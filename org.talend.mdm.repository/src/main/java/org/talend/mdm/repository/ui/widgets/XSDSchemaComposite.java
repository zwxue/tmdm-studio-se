// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.widgets;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.xsd.XSDComplexTypeContent;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTypeDefinition;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.model.mdmserverobject.WSDataModelE;
import org.talend.mdm.repository.models.CustomFormElement;
import org.talend.mdm.repository.utils.CustomFormUtil;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XSDAnnotationsStructure;
import com.amalto.workbench.webservices.WSConceptKey;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSGetBusinessConceptKey;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class XSDSchemaComposite extends Composite {

    private static Logger log = Logger.getLogger(XSDSchemaComposite.class);

    private static final Image IMG = ImageCache.getCreatedImage(EImage.SCHEMAELEMENT.getPath());

    private static class ViewerLabelProvider extends LabelProvider {

        public Image getImage(Object element) {
            return IMG;
        }

        public String getText(Object element) {
            if (element instanceof CustomFormElement) {
                CustomFormElement cfe = (CustomFormElement) element;
                String name = cfe.getName();
                return name + (cfe.getType() == null ? "" : " : " + cfe.getType()); //$NON-NLS-1$ //$NON-NLS-2$
            }
            return ""; //$NON-NLS-1$
        }
    }

    private static class TreeContentProvider implements ITreeContentProvider {

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

        public void dispose() {
        }

        public Object[] getElements(Object inputElement) {
            return getChildren(inputElement);
        }

        public Object[] getChildren(Object parentElement) {
            if (parentElement instanceof Collection) {
                return ((Collection) parentElement).toArray();
            }
            if (parentElement instanceof CustomFormElement) {
                List<CustomFormElement> children = ((CustomFormElement) parentElement).getChildren();
                if (children != null) {
                    return children.toArray();
                }
            }
            return new Object[0];
        }

        public Object getParent(Object element) {
            return null;
        }

        public boolean hasChildren(Object element) {
            return getChildren(element).length > 0;
        }
    }

    private String dataModelName;

    private String entityName;

    private Tree tree;

    private CustomFormElement ancestor;

    private TreeViewer viewer;

    private WSConceptKey conceptKey;

    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     */
    public XSDSchemaComposite(Composite parent) {
        super(parent, SWT.NONE);

        setLayout(new GridLayout(1, false));

        viewer = new TreeViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
        tree = viewer.getTree();
        tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        viewer.setLabelProvider(new ViewerLabelProvider());
        viewer.setContentProvider(new TreeContentProvider());

    }

    public void updateModel(String dataModel, String entityName) {
        this.dataModelName = dataModel;
        this.entityName = entityName;
        WSGetBusinessConceptKey key = new WSGetBusinessConceptKey(new WSDataModelPK(dataModelName), entityName);
        CustomFormUtil cUtil = new CustomFormUtil();
        try {
            conceptKey = cUtil.getBusinessConceptKey(key);

        } catch (Exception e) {
        }

        updateModel();
        viewer.setInput(getAllElements());
        viewer.expandAll();

    }

    private void updateModel() {
        WSDataModelE dataModel = RepositoryQueryService.findDataModelByName(dataModelName);
        if (dataModel != null) {
            String schema = dataModel.getXsdSchema();
            try {
                XSDSchema xsd = Util.createXsdSchema(schema, null);
                if (xsd != null) {
                    for (XSDElementDeclaration elemDecl : xsd.getElementDeclarations()) {
                        if (elemDecl.getName().equals(entityName)) {
                            ancestor = new CustomFormElement(entityName, null);
                            XSDTypeDefinition typeDefinition = elemDecl.getTypeDefinition();
                            boolean isSequence = Util.isSequenceComplexType((XSDComplexTypeDefinition) typeDefinition);
                            ancestor.setCanMove(!isSequence);

                            analyseTypeDefinition(typeDefinition, ancestor);

                        }
                    }
                }
                // System.out.println(schema);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }


    private void analyseTypeDefinition(XSDTypeDefinition typeDefinition, CustomFormElement pElement) {
        if (typeDefinition instanceof XSDComplexTypeDefinition) {
            analyseComplexType((XSDComplexTypeDefinition) typeDefinition, pElement);
        }
    }

    private void analyseComplexType(XSDComplexTypeDefinition cType, CustomFormElement pElement) {
        XSDComplexTypeContent content = cType.getContent();
        if (content instanceof XSDSimpleTypeDefinition) {

        } else if (content instanceof XSDParticle) {
            analyseParticle((XSDParticle) content, pElement);
        }

    }

    private void analyseParticle(XSDParticle particle, CustomFormElement pElement) {
        XSDTerm term = particle.getTerm();
        if (term instanceof XSDElementDeclaration) {

            XSDElementDeclaration decl = (XSDElementDeclaration) term;
            String name = decl.getName();
            XSDTypeDefinition typeDefinition = decl.getTypeDefinition();
            String type = typeDefinition.getName();
            if (type == null) {
                type = typeDefinition.getBaseType().getName();
            }
            CustomFormElement child = new CustomFormElement(name, type);
            child.setMinOccurs(particle.getMinOccurs());
            child.setMaxOccurs(particle.getMaxOccurs());
            // ignore foreign key
            XSDAnnotationsStructure struct = new XSDAnnotationsStructure(particle);
            if (struct.getForeignKey() == null) {
                pElement.addChild(child);
            }
            if (Arrays.asList(conceptKey.getFields()).contains(name)) {
                child.setKey(true);
            }
            // System.out.println(child);
            if (typeDefinition instanceof XSDComplexTypeDefinition) {
                type = null;
                child.setType(type);
                if (ancestor != pElement) {
                boolean isSequence = Util.isSequenceComplexType((XSDComplexTypeDefinition) typeDefinition);
                pElement.setCanMove(!isSequence);
                }
                analyseComplexType((XSDComplexTypeDefinition) typeDefinition, child);
            }

        }
        if (term instanceof XSDModelGroup) {
            XSDModelGroup group = (XSDModelGroup) term;
            if (ancestor != pElement) {
                boolean isSequence = XSDCompositor.SEQUENCE_LITERAL.equals(group.getCompositor());
                pElement.setCanMove(!isSequence);
            }
            for (XSDParticle child : ((XSDModelGroup) term).getContents()) {
                analyseParticle(child, pElement);
            }
        }
    }


    public List<CustomFormElement> getAllElements() {
        if (ancestor != null) {
            return ancestor.getChildren();
        }
        return null;
    }

    public CustomFormElement getAncestor() {
        return ancestor;
    }

    @Override
    protected void checkSubclass() {

    }

}
