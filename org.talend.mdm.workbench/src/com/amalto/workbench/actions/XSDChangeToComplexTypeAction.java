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
package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDDerivationMethod;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;
import org.eclipse.xsd.impl.XSDModelGroupImpl;
import org.eclipse.xsd.impl.XSDParticleImpl;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.dialogs.ComplexTypeInputDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.Util;

public class XSDChangeToComplexTypeAction extends UndoAction implements SelectionListener {

    private Log log = LogFactory.getLog(XSDChangeToComplexTypeAction.class);

    protected boolean isConcept = false;

    protected XSDElementDeclaration decl = null;

    protected ComplexTypeInputDialog dialog = null;

    XSDElementDeclaration declNew = null;

    String typeName = null;

    String superTypeName;

    boolean isAbstract;

    boolean isChoice = false;

    boolean isAll = false;

    boolean showDlg = true;

    private boolean isXSDModelGroup = false;

    public XSDChangeToComplexTypeAction(DataModelMainPage page, boolean isXSDModelGroup) {
        super(page);
        this.isXSDModelGroup = isXSDModelGroup;
        setImageDescriptor(ImageCache.getImage(EImage.COMPLEX_ALL.getPath()));
        if (isXSDModelGroup)
            setText("Change Sub-Element Group");
        else
            setText("Change to a Complex Type");
        setToolTipText("Make an Element a Complex Element or change the type of current Complex Element");
        setDescription(getToolTipText());
    }

    public XSDChangeToComplexTypeAction(DataModelMainPage page, XSDElementDeclaration dec, String name, boolean choice,
            boolean all, boolean isAbstract, String superTypeName) {

        this(page, false);
        this.superTypeName = superTypeName;
        this.isAbstract = isAbstract;
        declNew = dec;
        showDlg = false;
        typeName = name;
        isChoice = choice;
        isAll = all;
    }

    public IStatus doAction() {

        try {
            IStructuredSelection selection = (IStructuredSelection) page.getTreeViewer().getSelection();
            isConcept = false;
            TreePath tPath = null;
            if (((TreeSelection) selection).getPaths().length > 0)
                tPath = ((TreeSelection) selection).getPaths()[0];
            // fliu
            // add declNew to support convert action invoked from new concept/new element menu, in this case
            // declNew is the new created one not the selected one in tree vew
            if (declNew != null) {
                decl = declNew;
                checkConcept();
            } else if (selection.getFirstElement() instanceof XSDModelGroup) {
                for (int i = 0; i < tPath.getSegmentCount(); i++) {
                    if (tPath.getSegment(i) instanceof XSDElementDeclaration)
                        decl = (XSDElementDeclaration) tPath.getSegment(i);
                    else if (tPath.getSegment(i) instanceof XSDParticle)
                        decl = (XSDElementDeclaration) ((XSDParticle) tPath.getSegment(i)).getTerm();
                }
                checkConcept();
            } else if (selection.getFirstElement() instanceof XSDElementDeclaration) {
                decl = (XSDElementDeclaration) selection.getFirstElement();
                // check if concept or "just" element
                checkConcept();

            } else if (selection.getFirstElement() instanceof XSDParticle) {
                // if it's a particle,it should change the element of its
                // content
                decl = (XSDElementDeclaration) ((XSDParticle) selection.getFirstElement()).getContent();
            } else {
                // if(selection.getFirstElement() instanceof XSDParticle )
                if (selection.getFirstElement() != null) {
                    // a sub element
                    decl = (XSDElementDeclaration) ((XSDParticle) selection.getFirstElement()).getTerm();
                }
            }

            // /save current Type Definition
            // XSDTypeDefinition current = decl.getTypeDefinition();
            List<XSDComplexTypeDefinition> types = Util.getComplexTypes(decl.getSchema());
            if (showDlg) {
                if (tPath != null)
                    for (int i = 0; i < tPath.getSegmentCount(); i++) {
                        if (tPath.getSegment(i) instanceof XSDElementDeclaration) {
                            XSDTypeDefinition type = (((XSDElementDeclaration) tPath.getSegment(i)).getTypeDefinition());
                            if (!type.equals(decl.getTypeDefinition()))
                                types.remove(type);
                        }
                        if (tPath.getSegment(i) instanceof XSDParticle) {
                            XSDTypeDefinition type = ((XSDElementDeclaration) (((XSDParticle) tPath.getSegment(i)).getTerm()))
                                    .getTypeDefinition();
                            if (!type.equals(decl.getTypeDefinition()))
                                types.remove(type);
                        }
                    }
                dialog = new ComplexTypeInputDialog(this, page.getSite().getShell(), schema, decl.getTypeDefinition(), types,
                        isXSDModelGroup);

                dialog.setBlockOnOpen(true);
                int ret = dialog.open();
                if (ret == Dialog.CANCEL) {
                    return Status.CANCEL_STATUS;
                }
            }

            if (!showDlg && !validateType()) {
                return Status.CANCEL_STATUS;
            }

            XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
            boolean anonymous = (typeName == null) || ("".equals(typeName));//$NON-NLS-1$
            boolean alreadyExists = false;

            XSDComplexTypeDefinition complexType = null;
            // the sub element created if needed
            XSDParticle subParticle = null;
            XSDParticle groupParticle = null;
            XSDElementDeclaration subElement = null;

            // check if already exist
            // add by ymli; fix the bug:0012278;
            XSDElementDeclaration parent = null;
            Object pObject = Util.getParent(decl);
            if (pObject instanceof XSDElementDeclaration)
                parent = (XSDElementDeclaration) pObject;
            else if (pObject instanceof XSDComplexTypeDefinition)
                complexType = (XSDComplexTypeDefinition) pObject;

            if (!anonymous) {
                EList list = schema.getTypeDefinitions();
                String ns = "";//$NON-NLS-1$
                if (typeName.lastIndexOf(" : ") != -1) {//$NON-NLS-1$
                    ns = typeName.substring(typeName.lastIndexOf(" : ") + 3);//$NON-NLS-1$
                    typeName = typeName.substring(0, typeName.lastIndexOf(" : "));//$NON-NLS-1$
                }
                for (Iterator iter = list.iterator(); iter.hasNext();) {
                    XSDTypeDefinition td = (XSDTypeDefinition) iter.next();
                    if ((td.getName().equals(typeName) && (td instanceof XSDComplexTypeDefinition))) {
                        alreadyExists = true;
                        complexType = (XSDComplexTypeDefinition) td;
                        break;
                    }
                }

            } else {
                if (parent != null && decl.getTypeDefinition() instanceof XSDComplexTypeDefinition)
                    // complexType = (XSDComplexTypeDefinition) parent.getTypeDefinition();
                    complexType = (XSDComplexTypeDefinition) decl.getTypeDefinition();
                if (complexType != null && complexType.getName() == null) {
                    alreadyExists = true;
                }
                if (decl.getTypeDefinition() instanceof XSDSimpleTypeDefinition)
                    alreadyExists = false;
            }
            // partCnt.setMaxOccurs(1);

            if (complexType != null) {
                XSDParticleImpl partCnt = (XSDParticleImpl) complexType.getContentType();
                XSDModelGroupImpl mdlGrp = (XSDModelGroupImpl) partCnt.getTerm();
                if (isChoice)
                    mdlGrp.setCompositor(XSDCompositor.CHOICE_LITERAL);
                else if (isAll) {
                    mdlGrp.setCompositor(XSDCompositor.ALL_LITERAL);

                } else {
                    mdlGrp.setCompositor(XSDCompositor.SEQUENCE_LITERAL);
                }
                partCnt.unsetMaxOccurs();
                partCnt.unsetMinOccurs();
                XSDTypeDefinition superType = null;
                for (XSDTypeDefinition type : types) {
                    if (type.getName().equals(superTypeName)) {
                        superType = type;
                        break;
                    }
                }
                // modified by jsxie; fix the bug: 0019688 
 
                if (!anonymous) {
                    complexType.setName(typeName);
                }
                else{
                	 complexType.setName(decl.getTypeDefinition().getName());
                }
               
                
                if (superType != null) {
                    complexType.setDerivationMethod(XSDDerivationMethod.EXTENSION_LITERAL);
                    complexType.setBaseTypeDefinition(superType);
                }
                if (isAbstract)
                    complexType.setAbstract(isAbstract);
                else
                    complexType.unsetAbstract();

                if (parent != null)
                    parent.updateElement();
                if (complexType != null)
                    complexType.updateElement();
            }

            // Create if does not exist
            if (!alreadyExists) {

                // add an element declaration
                subElement = factory.createXSDElementDeclaration();
                subElement.setName("subelement");//$NON-NLS-1$
                subElement.setTypeDefinition(schema.resolveSimpleTypeDefinition(schema.getSchemaForSchemaNamespace(), "string"));//$NON-NLS-1$

                subParticle = factory.createXSDParticle();
                subParticle.unsetMaxOccurs();
                subParticle.unsetMinOccurs();
                subParticle.setContent(subElement);
                subParticle.updateElement();

                // create group
                XSDModelGroup group = factory.createXSDModelGroup();
                if (isChoice)
                    group.setCompositor(XSDCompositor.CHOICE_LITERAL);
                else if (isAll)
                    group.setCompositor(XSDCompositor.ALL_LITERAL);
                else
                    group.setCompositor(XSDCompositor.SEQUENCE_LITERAL);
                group.getContents().add(0, subParticle);
                group.updateElement();

                // create the complex type
                complexType = factory.createXSDComplexTypeDefinition();
                // complexType.setDerivationMethod(XSDDerivationMethod.EXTENSION_LITERAL);
                if (!anonymous) {
//                if (true) {
                    XSDTypeDefinition superType = null;
                    for (XSDTypeDefinition type : types) {
                        if (type.getName().equals(superTypeName)) {
                            superType = type;
                            break;
                        }
                    }
                    complexType.setName(typeName);
                    if (superType != null) {
                        complexType.setDerivationMethod(XSDDerivationMethod.EXTENSION_LITERAL);
                        complexType.setBaseTypeDefinition(superType);
                    }
                    if (isAbstract)
                        complexType.setAbstract(isAbstract);
                    else
                        complexType.unsetAbstract();
                    schema.getContents().add(complexType);
                }
                complexType.updateElement();

                // add the group
                groupParticle = factory.createXSDParticle();
                groupParticle.unsetMaxOccurs();
                groupParticle.unsetMinOccurs();
                groupParticle.setContent(group);
                groupParticle.updateElement();

                complexType.setContent(groupParticle);
                complexType.updateElement();
            }// end if NOT already exusts

            // set complex type to concept
            if (anonymous)
                decl.setAnonymousTypeDefinition(complexType);
            else {
                decl.setTypeDefinition(complexType);
            }

            if (isConcept) {

                // remove exisiting unique key(s)
                ArrayList keys = new ArrayList();
                EList list = decl.getIdentityConstraintDefinitions();
                for (Iterator iter = list.iterator(); iter.hasNext();) {
                    XSDIdentityConstraintDefinition icd = (XSDIdentityConstraintDefinition) iter.next();
                    if (icd.getIdentityConstraintCategory().equals(XSDIdentityConstraintCategory.UNIQUE_LITERAL))
                        keys.add(icd);
                }
                decl.getIdentityConstraintDefinitions().removeAll(keys);

                // add new unique key with first element declaration name
                XSDElementDeclaration firstDecl = null;
                if (complexType.getContent() instanceof XSDParticle) {
                    if (((XSDParticle) complexType.getContent()).getTerm() instanceof XSDModelGroup) {
                        XSDModelGroup group = (XSDModelGroup) ((XSDParticle) complexType.getContent()).getTerm();
                        EList gpl = group.getContents();
                        for (Iterator iter = gpl.iterator(); iter.hasNext();) {
                            XSDParticle part = (XSDParticle) iter.next();
                            if (part.getTerm() instanceof XSDElementDeclaration) {
                                firstDecl = (XSDElementDeclaration) part.getTerm();
                                break;
                            }
                        }
                    }
                }
                if (firstDecl != null) {
                    XSDIdentityConstraintDefinition uniqueKey = factory.createXSDIdentityConstraintDefinition();
                    uniqueKey.setIdentityConstraintCategory(XSDIdentityConstraintCategory.UNIQUE_LITERAL);
                    uniqueKey.setName(decl.getName());
                    XSDXPathDefinition selector = factory.createXSDXPathDefinition();
                    selector.setVariety(XSDXPathVariety.SELECTOR_LITERAL);
                    selector.setValue(".");//$NON-NLS-1$
                    uniqueKey.setSelector(selector);
                    XSDXPathDefinition field = factory.createXSDXPathDefinition();
                    field.setVariety(XSDXPathVariety.FIELD_LITERAL);
                    field.setValue(firstDecl.getAliasName());
                    uniqueKey.getFields().add(field);
                    decl.getIdentityConstraintDefinitions().add(uniqueKey);
                }

            }// if isConcept

            decl.updateElement();
            schema.update();
            page.refresh();

            declNew = null;
            page.markDirty();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(page.getSite().getShell(), "Error",
                    "An error occured trying to change to Complex Type: " + e.getLocalizedMessage());
            return Status.CANCEL_STATUS;
        }

        return Status.OK_STATUS;
    }

    private void checkConcept() {
        EList l = decl.getIdentityConstraintDefinitions();
        for (Iterator iter = l.iterator(); iter.hasNext();) {
            XSDIdentityConstraintDefinition icd = (XSDIdentityConstraintDefinition) iter.next();
            if (icd.getIdentityConstraintCategory().equals(XSDIdentityConstraintCategory.UNIQUE_LITERAL)) {
                isConcept = true;
                break;
            }
        }

    }

    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

    /********************************
     * Listener to input dialog
     */
    public void widgetDefaultSelected(SelectionEvent e) {
    }

    public void widgetSelected(SelectionEvent e) {
        if (dialog.getReturnCode() == -1)
            return;
        superTypeName = dialog.getSuperName();
        isAbstract = dialog.isAbstract();
        typeName = dialog.getTypeName();
        isChoice = dialog.isChoice();
        isAll = dialog.isAll();

        if (!validateType()) {
            return;
        }
        dialog.close();
    }

    private boolean validateType() {
        if (!"".equals(typeName)) {//$NON-NLS-1$
            EList list = schema.getTypeDefinitions();
            for (Iterator iter = list.iterator(); iter.hasNext();) {
                XSDTypeDefinition td = (XSDTypeDefinition) iter.next();
                if (td.getName().equals(typeName)) {
                    if (td instanceof XSDSimpleTypeDefinition) {
                        MessageDialog.openError(page.getSite().getShell(), "Error", "This type \"" + typeName
                                + "\" already exists as a Simple Type");
                        return false;
                    }
                }
            }// for
        }

        return true;
    }
}
