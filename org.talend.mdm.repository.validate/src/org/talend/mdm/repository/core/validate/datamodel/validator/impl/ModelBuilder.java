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
package org.talend.mdm.repository.core.validate.datamodel.validator.impl;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDDiagnostic;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDParticleContent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDParser;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.model.IMRoot;
import org.talend.mdm.repository.core.validate.datamodel.model.IMType;
import org.talend.mdm.repository.core.validate.datamodel.model.impl.IElementContainerWritable;
import org.talend.mdm.repository.core.validate.datamodel.model.impl.IMAnnotationWritable;
import org.talend.mdm.repository.core.validate.datamodel.model.impl.IMElementWritable;
import org.talend.mdm.repository.core.validate.datamodel.model.impl.IMRootWritable;
import org.talend.mdm.repository.core.validate.datamodel.model.impl.IMTypeWritable;
import org.talend.mdm.repository.core.validate.datamodel.model.impl.MElement;
import org.talend.mdm.repository.core.validate.datamodel.model.impl.MRoot;
import org.talend.mdm.repository.core.validate.datamodel.model.impl.MType;
import org.talend.mdm.repository.core.validate.datamodel.validator.IModelBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.helpers.LocatorImpl;

/**
 * created by HHB on 2013-1-6 Detailled comment
 * 
 */
public class ModelBuilder implements IModelBuilder {

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.validator.IModelBuilder#buildModel(java.lang.String,
     * java.lang.String)
     */
    @Override
    public IMRoot buildModel(String modelName, String doc) {
        XSDSchema schema = parseSchema(doc);
        if (schema != null) {
            IMRootWritable root = new MRoot();
            analyseTypeDefinitions(schema, root);
            analyseEntities(schema, root);
            root.setName(modelName);
            root.setXSDError(hasXSDError(schema));
            return root;
        }
        return null;
    }

    boolean hasXSDError(XSDSchema schema) {
        EList<XSDDiagnostic> diagnostics = schema.getAllDiagnostics();
        schema.validate();

        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.validator.IModelBuilder#buildModel(java.lang.String,
     * java.io.File)
     */
    @Override
    public IMRoot buildModel(String modelName, File file) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.validator.IModelBuilder#buildModel(java.lang.String,
     * java.io.InputStream)
     */
    @Override
    public IMRoot buildModel(String modelName, InputStream inputStream) {
        return null;
    }

    private XSDSchema parseSchema(String doc) {
        XSDParser parse = new XSDParser(getOptions());
        parse.setDocumentLocator(new LocatorImpl());
        parse.parseString(doc);
        return parse.getSchema();
    }

    private static Map optionMap;

    private static Map getOptions() {
        if (optionMap == null) {
            optionMap = new HashMap();
            // map.put(XMLResource.OPTION_ENCODING, UTF_8);
            optionMap.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
            optionMap.put(XSDResourceImpl.XSD_TRACK_LOCATION, Boolean.TRUE);
        }
        return optionMap;
    }

    /**
     * DOC HHB Comment method "analyseTypes".
     * 
     * @param schema
     * @param root
     */
    private void analyseTypeDefinitions(XSDSchema schema, IMRootWritable root) {
        for (XSDTypeDefinition typeDefine : schema.getTypeDefinitions()) {
            analyseType(typeDefine, root, true);
        }
    }

    private void analyseEntities(XSDSchema schema, IMRootWritable root) {
        for (XSDElementDeclaration decl : schema.getElementDeclarations()) {
            analyseEntity(decl, root);
        }
    }

    private IMElementWritable analyseEntity(XSDElementDeclaration decl, IMRootWritable root) {
        IMElementWritable entity = analyseElement(decl, root);
        buildChildElementFromType(entity);
        return entity;
    }

    private void buildChildElementFromType(IMElementWritable element) {
        IMType type = element.getType();
        if (type.isComplexType() || type.isAnonymousType()) {
            for (IMElement child : type.getElements()) {
                IMElementWritable cloneElement = ((IMElementWritable) child).cloneElement();
                element.addElement(cloneElement);
                cloneElement.setParent(element);
                buildChildElementFromType(cloneElement);
            }
        }

    }

    private IMTypeWritable findType(XSDTypeDefinition typeDefine, IMRootWritable root) {
        Element element = typeDefine.getElement();
        for (IMType type : root.getTypes()) {
            if (element == type.getW3CElement()) {
                return (IMTypeWritable) type;
            }
        }
        return null;
    }

    private IMTypeWritable analyseType(XSDTypeDefinition typeDefine, IMRootWritable root, boolean declared) {
        IMTypeWritable foundType = findType(typeDefine, root);
        if (foundType != null) {
            if (declared && !foundType.isDeclared()) {
                foundType.setDeclared(true);
            }
            return foundType;
        }
        String typeName = typeDefine.getName();
        boolean isComplex = typeDefine instanceof XSDComplexTypeDefinition;
        IMTypeWritable type = new MType(typeName, typeDefine.getElement(), isComplex, declared);

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

                            analyseElement((XSDElementDeclaration) particleContent, type, minOccurs, maxOccurs);
                        }
                    }
                }
            }
        }

        return type;
    }

    private IMElementWritable analyseElement(XSDElementDeclaration decl, IElementContainerWritable container) {
        return analyseElement(decl, container, null, null);
    }

    private IMElementWritable analyseElement(XSDElementDeclaration decl, IElementContainerWritable container, Integer min,
            Integer max) {
        IMElementWritable element = new MElement(decl.getName(), decl.getElement());
        if (min != null && max != null) {
            element.setMinOccurs(min);
            element.setMaxOccurs(max);
        }
        // analyse annotation
        analyseAnnotation(element, decl);
        //
        XSDTypeDefinition anonymousTypeDefinition = decl.getAnonymousTypeDefinition();
        IMTypeWritable elementType = null;
        IMRootWritable root = (IMRootWritable) container.getRoot();
        if (anonymousTypeDefinition != null) {

            IMTypeWritable anonymousType = analyseType(anonymousTypeDefinition, root, false);
            elementType = anonymousType;
        } else {
            XSDTypeDefinition typeDefinition = decl.getTypeDefinition();
            IMTypeWritable foundType = (IMTypeWritable) root.findTypeByW3CElement(typeDefinition.getElement());
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

    private void analyseAnnotation(IMElement element, XSDElementDeclaration decl) {
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
                            ((IMAnnotationWritable) element.getAnnotation()).addAnnotation(attribute, value, aElement);
                        }
                    }
                }
            }

        }
    }
}
