// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.validate.datamodel;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDParticleContent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDParser;
import org.talend.mdm.repository.core.validate.datamodel.model.IElementContainer;
import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.model.IMRoot;
import org.talend.mdm.repository.core.validate.datamodel.model.IMType;
import org.talend.mdm.repository.core.validate.datamodel.model.impl.MElement;
import org.talend.mdm.repository.core.validate.datamodel.model.impl.MRoot;
import org.talend.mdm.repository.core.validate.datamodel.model.impl.MType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * created by HHB on 2013-1-6 Detailled comment
 * 
 */
public class ModelBuilder {

    public IMRoot buildModel(XSDSchema schema, String fileName) {
        IMRoot root = new MRoot();
        analyseTypeDefinitions(schema, root);
        analyseEntities(schema, root);
        String dataModelName = getDataModelName(fileName);
        root.setName(dataModelName);
        return root;
    }

    private String getDataModelName(String fileName) {
        Pattern pattern = Pattern.compile("(\\w*?)_(\\d*?)\\.(\\d*?)\\.xsd"); //$NON-NLS-1$
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return fileName;
    }

    /**
     * DOC HHB Comment method "analyseTypes".
     * 
     * @param schema
     * @param root
     */
    private void analyseTypeDefinitions(XSDSchema schema, IMRoot root) {
        for (XSDTypeDefinition typeDefine : schema.getTypeDefinitions()) {
            analyseType(typeDefine, root, true);
        }
    }

    private void analyseEntities(XSDSchema schema, IMRoot root) {
        for (XSDElementDeclaration decl : schema.getElementDeclarations()) {
            analyseEntity(decl, root);
        }
    }

    private IMElement analyseEntity(XSDElementDeclaration decl, IMRoot root) {
        IMElement entity = analyseElement(decl, root);
        buildChildElementFromType(entity);
        return entity;
    }

    private void buildChildElementFromType(IMElement element) {
        IMType type = element.getType();
        if (type.isComplexType() || type.isAnonymousType()) {
            for (IMElement child : type.getElements()) {
                IMElement cloneElement = child.cloneElement();
                element.addElement(cloneElement);
                cloneElement.setParent(element);
                buildChildElementFromType(cloneElement);
            }
        }

    }

    private IMType findType(XSDTypeDefinition typeDefine, IMRoot root) {
        for (IMType type : root.getTypes()) {
            if (typeDefine == type.getXsdComponent()) {
                return type;
            }
        }
        return null;
    }

    private IMType analyseType(XSDTypeDefinition typeDefine, IMRoot root, boolean declared) {
        IMType foundType = findType(typeDefine, root);
        if (foundType != null) {
            if (declared && !foundType.isDeclared()) {
                foundType.setDeclared(true);
            }
            return foundType;
        }
        String typeName = typeDefine.getName();
        boolean isComplex = typeDefine instanceof XSDComplexTypeDefinition;
        IMType type = new MType(typeName, typeDefine, isComplex, declared);
        // important
        root.addType(type);
        if (isComplex) {
            XSDComplexTypeDefinition complexType = (XSDComplexTypeDefinition) typeDefine;

            if (complexType.getContent() instanceof XSDParticle) {
                XSDParticle particle = (XSDParticle) complexType.getContent();

                if (particle.getTerm() instanceof XSDModelGroup) {
                    XSDModelGroup group = (XSDModelGroup) particle.getTerm();
                    EList<XSDParticle> particles = group.getContents();
                    for (XSDParticle p : particles) {
                        XSDParticleContent particleContent = p.getContent();
                        if (particleContent instanceof XSDElementDeclaration) {
                            Element element = particleContent.getElement();
                            XSDParser.getStartLine(element);
                            XSDParser.getStartColumn(element);
                            int maxOccurs = p.getMaxOccurs();
                            int minOccurs = p.getMinOccurs();
                            // System.out.println(typeDefine.getName() + "\t" + type + " \tmin:" + minOccurs + "\tmax:"
                            // + maxOccurs);

                            analyseElement((XSDElementDeclaration) particleContent, type, minOccurs, maxOccurs);
                        }
                    }
                }
            }
        }

        return type;
    }

    private IMElement analyseElement(XSDElementDeclaration decl, IElementContainer container) {
        return analyseElement(decl, container, null, null);
    }

    private IMElement analyseElement(XSDElementDeclaration decl, IElementContainer container, Integer min, Integer max) {
        IMElement element = new MElement(decl.getName(), decl);
        if (min != null && max != null) {
            element.setMinOccurs(min);
            element.setMaxOccurs(max);
        }
        // analyse annotation
        analyseAnnotation(element);
        //
        XSDTypeDefinition anonymousTypeDefinition = decl.getAnonymousTypeDefinition();
        IMType elementType = null;
        IMRoot root = container.getRoot();
        if (anonymousTypeDefinition != null) {

            IMType anonymousType = analyseType(anonymousTypeDefinition, root, false);
            elementType = anonymousType;
        } else {
            XSDTypeDefinition typeDefinition = decl.getTypeDefinition();
            IMType foundType = root.findTypeByXSD(typeDefinition);
            if (foundType != null) {
                elementType = foundType;
            } else {
                elementType = analyseType(typeDefinition, root, false);
            }
        }

        container.addElement(element);
        element.setType(elementType);
        return element;
    }

    private void analyseAnnotation(IMElement element) {
        XSDElementDeclaration decl = (XSDElementDeclaration) element.getXsdComponent();
        XSDAnnotation annotation = decl.getAnnotation();
        if (annotation != null) {
            List<Element> annotationElements = annotation.getApplicationInformation();
            for (Element aElement : annotationElements) {
                if (aElement.getLocalName().equals("appinfo")) { //$NON-NLS-1$
                    Node node = aElement.getAttributes().getNamedItem("source"); //$NON-NLS-1$
                    if (node != null) {
                        Node firstChild = aElement.getFirstChild();
                        String attribute = node.getNodeValue();
                        if (attribute != null) {
                            String value = firstChild.getNodeValue();
                            element.getAnnotation().addAnnotation(attribute, value, aElement);
                        }
                    }
                }
            }

        }
    }
}
