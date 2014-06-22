// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDPatternFacet;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;
import org.eclipse.xsd.util.XSDConstants;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;
import org.talend.mdm.commmon.util.core.EUUIDCustomType;

import com.amalto.workbench.dialogs.SimpleTypeInputDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

public class XSDChangeToSimpleTypeAction extends UndoAction implements SelectionListener {

    private static Log log = LogFactory.getLog(XSDChangeToSimpleTypeAction.class);

    private SimpleTypeInputDialog dialog = null;

    private String typeName = null;

    private boolean builtIn = false;

    private boolean isConcept = false;

    private XSDSimpleTypeDefinition simpleType;

    private XSDElementDeclaration declNew = null;

    boolean showDlg = true;

    public XSDChangeToSimpleTypeAction(DataModelMainPage page) {
        super(page);
        setImageDescriptor(ImageCache.getImage(EImage.SIMPLETYPE.getPath()));
        setText(Messages.XSDChangeToXX_Text);
        setToolTipText(Messages.XSDChangeToXX_ActionTip);
        setDescription(getToolTipText());
    }

    public XSDChangeToSimpleTypeAction(DataModelMainPage page, XSDElementDeclaration dec, String name, boolean built) {
        this(page);
        showDlg = false;
        typeName = name;
        builtIn = built;

        declNew = dec;
    }

    @Override
    public IStatus doAction() {
        try {
            XSDElementDeclaration decl = null;
            IStructuredSelection selection = (IStructuredSelection) page.getTreeViewer().getSelection();
            // fliu
            // add declNew to support convert action invoked from new concept/new element menu, in this case
            // declNew is the new created one not the selected one in tree vew
            if (declNew != null)
                decl = declNew;
            else if (selection.getFirstElement() instanceof XSDElementDeclaration) {
                isConcept = true;
                decl = (XSDElementDeclaration) selection.getFirstElement();

            } else {
                isConcept = false;
                if (selection.getFirstElement() != null) {
                    decl = (XSDElementDeclaration) ((XSDParticle) selection.getFirstElement()).getTerm();
                }
            }

            // build list of custom types and built in types
            List<String> customTypes = new ArrayList<String>();
            for (Iterator<XSDTypeDefinition> iter = schema.getTypeDefinitions().iterator(); iter.hasNext();) {
                XSDTypeDefinition type = iter.next();
                if (type instanceof XSDSimpleTypeDefinition) {
                    if (type.getTargetNamespace() != null
                            && !type.getTargetNamespace().equals(XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001)
                            || type.getTargetNamespace() == null)
                        customTypes.add(type.getName());
                }
            }
            List<String> builtInTypes = new ArrayList<String>();
            initBuiltInTypesWithSelectedTypes(builtInTypes);

            if (showDlg) {
                String name = decl.getTypeDefinition().getName();

                if(decl.getTypeDefinition() instanceof XSDComplexTypeDefinition) {
                    name = null;
                    boolean confirm = MessageDialog.openConfirm(page.getSite().getShell(), Messages.Warning, Messages.XSDChangeToCXX_ChangeToAnotherTypeWarning);
                    if(!confirm)
                        return Status.CANCEL_STATUS;
                }

                dialog = new SimpleTypeInputDialog(this, page.getSite().getShell(), schema, Messages.XSDChangeToXX_DialogTitle,
                        customTypes, builtInTypes, name);

                dialog.setBlockOnOpen(true);
                int ret = dialog.open();
                if (ret == Window.CANCEL) {
                    return Status.CANCEL_STATUS;
                }
            }

            // if concept
            // remove all unique keys and make new one
            if (isConcept) {
                // remove exisitng unique key(s)
                ArrayList keys = new ArrayList();
                EList list = decl.getIdentityConstraintDefinitions();
                for (Iterator iter = list.iterator(); iter.hasNext();) {
                    XSDIdentityConstraintDefinition icd = (XSDIdentityConstraintDefinition) iter.next();
                    if (icd.getIdentityConstraintCategory().equals(XSDIdentityConstraintCategory.UNIQUE_LITERAL))
                        keys.add(icd);
                }
                decl.getIdentityConstraintDefinitions().removeAll(keys);
                // add new unique Key
                XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
                XSDIdentityConstraintDefinition uniqueKey = factory.createXSDIdentityConstraintDefinition();
                uniqueKey.setIdentityConstraintCategory(XSDIdentityConstraintCategory.UNIQUE_LITERAL);
                uniqueKey.setName(decl.getName());
                XSDXPathDefinition selector = factory.createXSDXPathDefinition();
                selector.setVariety(XSDXPathVariety.SELECTOR_LITERAL);
                selector.setValue(".");//$NON-NLS-1$
                uniqueKey.setSelector(selector);
                XSDXPathDefinition field = factory.createXSDXPathDefinition();
                field.setVariety(XSDXPathVariety.FIELD_LITERAL);
                field.setValue(".");//$NON-NLS-1$
                uniqueKey.getFields().add(field);
                decl.getIdentityConstraintDefinitions().add(uniqueKey);
            }

            // Save current type definition
            XSDTypeDefinition current = decl.getTypeDefinition();

            // set new one
            if (builtIn) {
                decl.setTypeDefinition(schema.resolveSimpleTypeDefinition(schema.getSchemaForSchemaNamespace(), typeName));
            } else {
                // check if concept already exists
                if (typeName != null && typeName.length() > 0) {
                    XSDSimpleTypeDefinition std = null;
                    String ns = "";//$NON-NLS-1$
                    if (typeName.lastIndexOf(" : ") != -1) {//$NON-NLS-1$
                        ns = typeName.substring(typeName.lastIndexOf(" : ") + 3);//$NON-NLS-1$
                        typeName = typeName.substring(0, typeName.lastIndexOf(" : "));//$NON-NLS-1$
                    }
                    for (XSDTypeDefinition typeDef : schema.getTypeDefinitions()) {
                        if (typeDef instanceof XSDSimpleTypeDefinition) {
                            if (typeDef.getName().equals(typeName)) {
                                std = (XSDSimpleTypeDefinition) typeDef;
                                break;
                            }
                        }
                    }
                    if (std == null) {
                        std = schema.resolveSimpleTypeDefinition(typeName);
                        std.setBaseTypeDefinition(schema.resolveSimpleTypeDefinition(schema.getSchemaForSchemaNamespace(),
                                "string"));//$NON-NLS-1$

                        if(typeName.equals(EUUIDCustomType.MULTI_LINGUAL.getName())){
                            XSDPatternFacet f = XSDSchemaBuildingTools.getXSDFactory().createXSDPatternFacet();
                            f.setLexicalValue("(\\[\\w+\\:[^\\[\\]]*\\]){0,}");//$NON-NLS-1$
                            std.getFacetContents().add(f);
                        }

                        schema.getContents().add(std);
                    }

                    decl.setTypeDefinition(std);
                } else {
                    XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
                    simpleType = factory.createXSDSimpleTypeDefinition();
                    simpleType.setBaseTypeDefinition(schema.resolveSimpleTypeDefinition(schema.getSchemaForSchemaNamespace(),
                            "string"));//$NON-NLS-1$
                    decl.setAnonymousTypeDefinition(simpleType);
                }
            }
            decl.updateElement();

            // remove current if no more in use
            // if (current != null) {
            // if ( (current.getName()!=null) && //anonymous type
            // (!schema.getSchemaForSchemaNamespace().equals(current.getTargetNamespace()))
            // ){
            // List eut =Util.findElementsUsingType(schema, current.getTargetNamespace(), current.getName());
            // if (eut.size()==0)
            // schema.getContents().remove(current);
            // }
            // }

            declNew = null;
            page.refresh();
            page.markDirty();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(page.getSite().getShell(), Messages._Error,
                    Messages.bind(Messages.XSDChangeToXX_ErrorMsg1, e.getLocalizedMessage()));
            return Status.CANCEL_STATUS;
        }
        return Status.OK_STATUS;
    }

    private void initBuiltInTypesWithSelectedTypes(List<String> builtInTypes) {

    	builtInTypes.add("anyURI");              //$NON-NLS-1$
    	builtInTypes.add("base64Binary");              //$NON-NLS-1$
    	builtInTypes.add("boolean");              //$NON-NLS-1$
    	builtInTypes.add("byte");              //$NON-NLS-1$
    	builtInTypes.add("date");              //$NON-NLS-1$
    	builtInTypes.add("dateTime");              //$NON-NLS-1$
    	builtInTypes.add("decimal");              //$NON-NLS-1$
    	builtInTypes.add("double");              //$NON-NLS-1$
    	builtInTypes.add("duration");              //$NON-NLS-1$
    	builtInTypes.add("float");              //$NON-NLS-1$
    	builtInTypes.add("gDay");              //$NON-NLS-1$
    	builtInTypes.add("gMonth");              //$NON-NLS-1$
    	builtInTypes.add("gMonthDay");              //$NON-NLS-1$
    	builtInTypes.add("gYear");              //$NON-NLS-1$
    	builtInTypes.add("gYearMonth");              //$NON-NLS-1$
    	builtInTypes.add("hexBinary");              //$NON-NLS-1$
    	builtInTypes.add("int");              //$NON-NLS-1$
    	builtInTypes.add("integer");              //$NON-NLS-1$
    	builtInTypes.add("language");              //$NON-NLS-1$
    	builtInTypes.add("long");              //$NON-NLS-1$
    	builtInTypes.add("negativeInteger");              //$NON-NLS-1$
    	builtInTypes.add("nonNegativeInteger");              //$NON-NLS-1$
    	builtInTypes.add("nonPositiveInteger");              //$NON-NLS-1$
    	builtInTypes.add("normalizedString");              //$NON-NLS-1$
    	builtInTypes.add("positiveInteger");              //$NON-NLS-1$
    	builtInTypes.add("short");              //$NON-NLS-1$
    	builtInTypes.add("string");              //$NON-NLS-1$
    	builtInTypes.add("time");              //$NON-NLS-1$
    	builtInTypes.add("token");              //$NON-NLS-1$
    	builtInTypes.add("unsignedByte");              //$NON-NLS-1$
    	builtInTypes.add("unsignedInt");              //$NON-NLS-1$
    	builtInTypes.add("unsignedLong");              //$NON-NLS-1$
    	builtInTypes.add("unsignedShort");              //$NON-NLS-1$


    	builtInTypes.add("ENTITIES");              //$NON-NLS-1$
    	builtInTypes.add("ENTITY");              //$NON-NLS-1$
    	builtInTypes.add("ID");              //$NON-NLS-1$
    	builtInTypes.add("IDREF");              //$NON-NLS-1$
    	builtInTypes.add("IDREFS");              //$NON-NLS-1$
    	builtInTypes.add("NCName");              //$NON-NLS-1$
    	builtInTypes.add("NMTOKEN");              //$NON-NLS-1$
    	builtInTypes.add("NMTOKENS");              //$NON-NLS-1$
    	builtInTypes.add("NOTATION");              //$NON-NLS-1$
    	builtInTypes.add("Name");              //$NON-NLS-1$
    	builtInTypes.add("QName");              //$NON-NLS-1$


	}



	@Override
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
        typeName = dialog.getTypeName();
        builtIn = dialog.isBuiltIn();

        // if built in, check that the type actually exists
        if (builtIn && !validateType()) {
            return;
        }
        dialog.close();
    }

    private boolean validateType() {
        boolean found = false;
        for (Iterator iter = schema.getSchemaForSchema().getTypeDefinitions().iterator(); iter.hasNext();) {
            XSDTypeDefinition type = (XSDTypeDefinition) iter.next();
            if (type instanceof XSDSimpleTypeDefinition)
                if (type.getName().equals(typeName)) {
                    found = true;
                    break;
                }
        }
        if (!found) {
            MessageDialog.openError(page.getSite().getShell(), Messages._Error, Messages.bind(Messages.XSDChangeToXX_ErrorMsg2, typeName ));
            return false;
        }

        return true;
    }

}
