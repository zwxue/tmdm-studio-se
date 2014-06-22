// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.providers.ISchemaContentProvider;
import com.amalto.workbench.utils.Util;

public class XSDDeleteTypeDefinition extends UndoAction {

    private static Log log = LogFactory.getLog(XSDDeleteTypeDefinition.class);

    private XSDComplexTypeDefinition xsdCmpexType;

    private XSDSimpleTypeDefinition xsdSimpType;

    public XSDDeleteTypeDefinition(DataModelMainPage page) {
        super(page);
        setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
        setText(Messages.XSDDeleteTypeDefinition_DelTypeDefine);
        setToolTipText(Messages.XSDDeleteTypeDefinition_RemoveTypeDefineFromSchema);
        setDescription(getToolTipText());
    }

    public XSDDeleteTypeDefinition(DataModelMainPage page, boolean isMulti) {
        super(page);
        setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
        if (isMulti)
            setText(Messages.XSDDeleteTypeDefinition_DelTypeDefines);
        else
            setText(Messages.XSDDeleteTypeDefinition_DelTypeDefine);
        setToolTipText(Messages.XSDDeleteTypeDefinition_RemoveTypeDefineFromSchema);
        setDescription(getToolTipText());
    }

    public void run(Object toDel) {
        if (!(toDel instanceof XSDComplexTypeDefinition || toDel instanceof XSDSimpleTypeDefinition)) {
            return;
        }
        if (toDel instanceof XSDComplexTypeDefinition)
            xsdCmpexType = (XSDComplexTypeDefinition) toDel;
        else
            xsdSimpType = (XSDSimpleTypeDefinition) toDel;
        run();
    }

    public IStatus doAction() {
        IStructuredSelection selection = (IStructuredSelection) page.getTreeViewer().getSelection();
        XSDSchema schema = ((ISchemaContentProvider) page.getTreeViewer().getContentProvider()).getXsdSchema();

        ArrayList<Object> objList = new ArrayList<Object>();
        Util.getAllObject(page.getSite(), objList, (IStructuredContentProvider) page.getSchemaContentProvider());
        Util.getAllObject(page.getSite(), objList, (IStructuredContentProvider) page.getTypeContentProvider());

        // edit by ymli; fix the bug:0012228. Made the multiple types can be deleted.
        for (Iterator<XSDTypeDefinition> iter = selection.iterator(); iter.hasNext();) {

            XSDTypeDefinition type = iter.next();
            // if (selection.getFirstElement() instanceof XSDSimpleTypeDefinition) {
            if (type instanceof XSDSimpleTypeDefinition) {
                // XSDSimpleTypeDefinition simpleType = (XSDSimpleTypeDefinition)selection.getFirstElement();
                XSDSimpleTypeDefinition simpleType = (XSDSimpleTypeDefinition) type;
                if (xsdSimpType != null)
                    simpleType = xsdSimpType;
                boolean find = Util.findElementsUsingType(objList, simpleType);
                if (find) {
                    boolean confirmed = MessageDialog.openConfirm(page.getSite().getShell(), Messages.XSDDeleteTypeDefinition_ConfirmDel,
                            Messages.bind(Messages.XSDDeleteTypeDefinition_ConfirmInfo, simpleType.getName()));
                    if (!confirmed) {
                        xsdSimpType = null;
                        return Status.CANCEL_STATUS;
                    }
                }// iif(!list.isEmpty())
                schema.getContents().remove(simpleType);
            }// if (selection.getFirstElement()
            else {

                // XSDComplexTypeDefinition complxType = (XSDComplexTypeDefinition)selection.getFirstElement();
                XSDComplexTypeDefinition complxType = (XSDComplexTypeDefinition) type;
                if (xsdCmpexType != null) {
                    complxType = xsdCmpexType;
                }

                boolean find = Util.findElementsUsingType(objList, complxType);
                if (find) {
                    boolean confirmed = MessageDialog.openConfirm(page.getSite().getShell(), Messages.XSDDeleteTypeDefinition_ConfirmDel,
                            Messages.bind(Messages.XSDDeleteTypeDefinition_ConfirmInfo1, complxType.getName()));
                    if (!confirmed) {
                        xsdCmpexType = null;
                        return Status.CANCEL_STATUS;
                    }
                }
                schema.getContents().remove(complxType);
            }

        }
        xsdCmpexType = null;
        page.refresh();
        page.markDirty();

        return Status.OK_STATUS;
    }

    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

    public void setXSDTODel(XSDComplexTypeDefinition elem) {
        xsdCmpexType = elem;
    }

    public void setXSDTODel(XSDSimpleTypeDefinition xsdSimpType) {
        this.xsdSimpType = xsdSimpType;
    }

    public boolean isTypeDefinition(Object[] selectedObjs) {
        boolean typeDefinition = true;
        boolean isAllComplexType = false;
        for (Object obj : selectedObjs) {
            if (!(obj instanceof XSDSimpleTypeDefinition) && !(obj instanceof XSDComplexTypeDefinition)) {
                typeDefinition = false;
                break;
            } else if (!(obj instanceof XSDComplexTypeDefinition))
                isAllComplexType = true;

        }
        if (selectedObjs.length == 1)
            isAllComplexType = true;
        return typeDefinition && isAllComplexType;
    }
}
