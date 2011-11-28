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
package org.talend.mdm.repository.core.dnd;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;
import org.eclipse.ui.navigator.CommonNavigator;
import org.talend.commons.exception.BusinessException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryDropAssistant extends CommonDropAdapterAssistant {

    private static Logger log = Logger.getLogger(RepositoryDropAssistant.class);

    public IStatus validateDrop(Object target, int operation, TransferData transferType) {
        if (operation == DND.DROP_COPY) {
            if (!(target instanceof IRepositoryViewObject)) {
                return Status.CANCEL_STATUS;
            }
            IRepositoryViewObject dragViewObj = getSelectedDragViewObj();
            IRepositoryViewObject dropViewObj = (IRepositoryViewObject) target;
            return validate(dragViewObj, dropViewObj) ? Status.OK_STATUS : Status.CANCEL_STATUS;
        }
        return Status.CANCEL_STATUS;
    }

    public boolean validate(IRepositoryViewObject dragViewObj, IRepositoryViewObject dropViewObj) {
        if (dragViewObj == null || dropViewObj == null) {
            return false;
        }
        //
        Item item = dragViewObj.getProperty().getItem();
        if (item instanceof ContainerItem) {
            return false;
        }

        ERepositoryObjectType dragType = dragViewObj.getRepositoryObjectType();

        Item dropItem = dropViewObj.getProperty().getItem();
        if (dropItem instanceof ContainerItem
                && ((ContainerItem) dropItem).getType().getValue() == FolderType.STABLE_SYSTEM_FOLDER) {
            return false;
        }
        ERepositoryObjectType dropType = dropViewObj.getRepositoryObjectType();
        // System.out.println("Source:" + dragViewObj + "\t" + dragType);
        // System.out.println("Target:" + target + "\t" + dropType);
        if (!dragType.equals(dropType))
            return false;
        return true;
    }

    private IRepositoryViewObject getSelectedDragViewObj() {
        ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
        if (selection instanceof IStructuredSelection) {
            Object object = ((IStructuredSelection) selection).getFirstElement();
            if (object instanceof IRepositoryViewObject) {
                return (IRepositoryViewObject) object;
            }
        }
        return null;
    }

    public IStatus handleDrop(CommonDropAdapter dropAdapter, DropTargetEvent dropTargetEvent, Object aTarget) {
        IRepositoryViewObject dropViewObj = (IRepositoryViewObject) aTarget;
        IRepositoryViewObject dragViewObj = getSelectedDragViewObj();
        if (copyViewObj(dragViewObj, dropViewObj)) {
            refreshTarget(dropViewObj);
            return Status.OK_STATUS;
        }
        return Status.CANCEL_STATUS;
    }

    public boolean copyViewObj(IRepositoryViewObject dragViewObj, IRepositoryViewObject dropViewObj) {
        if (dropViewObj != null && dragViewObj != null) {

            Property dragProp = dropViewObj.getProperty();
            MDMServerObject serverObj = ((MDMServerObjectItem) dragProp.getItem()).getMDMServerObject();
            // show dialog
            IRepositoryViewObject dragParentViewObj = getParentRepositoryViewObject(dragViewObj);
            ContainerItem dragParentItem = (ContainerItem) dragParentViewObj.getProperty().getItem();
            String newName = showPasteDlg(dragParentItem.getRepObjType(), dragParentItem, "Copy_" + serverObj.getName()); //$NON-NLS-1$
            if (newName != null) {
                String pathStr = dragProp.getItem().getState().getPath();
                IPath path = new Path(pathStr);
                IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
                try {
                    Item copy = factory.copy(dragProp.getItem(), path, true);
                    if (copy instanceof MDMServerObjectItem) {
                        ((MDMServerObjectItem) copy).getMDMServerObject().setName(newName);
                    }
                    newName = RepositoryResourceUtil.escapeSpecialCharacters(newName);
                    copy.getProperty().setLabel(newName);

                    factory.save(copy);
                    return true;
                } catch (PersistenceException e) {
                    log.error(e.getMessage(), e);
                } catch (BusinessException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return false;
    }

    private String showPasteDlg(final ERepositoryObjectType type, final ContainerItem parentItem, String initLabel) {
        InputDialog dlg = new InputDialog(getShell(), Messages.RepositoryDropAssistant_pasteObject, Messages.Common_inputName,
                initLabel,
                new IInputValidator() {

                    public String isValid(String newText) {
                        if (newText == null || newText.trim().length() == 0)
                            return Messages.Common_nameCanNotBeEmpty;
                        if (type.equals(IServerObjectRepositoryType.TYPE_TRANSFORMERV2)
                                || type.equals(IServerObjectRepositoryType.TYPE_VIEW)) {
                            if (!Pattern.matches("\\w*(#|\\.|\\w*)+(#|\\w+)", newText)) {//$NON-NLS-1$
                                return Messages.Common_nameInvalid;
                            }
                        } else if (!Pattern.matches("\\w*(#|-|\\.|\\w*)+\\w+", newText)) {//$NON-NLS-1$
                            return Messages.Common_nameInvalid;
                        }
                        //
                        if (RepositoryResourceUtil.isExistByName(parentItem.getRepObjType(), newText.trim())) {
                            return Messages.Common_nameIsUsed;
                        }
                        return null;
                    };
                });
        dlg.setBlockOnOpen(true);
        if (dlg.open() == Window.CANCEL)
            return null;
        return dlg.getValue();

    }

    private void refreshTarget(IRepositoryViewObject dropViewObj) {
        IRepositoryViewObject parenViewObj = getParentRepositoryViewObject(dropViewObj);
        if (parenViewObj != null) {
            try {
                IViewPart viewPart = RepositoryPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .findView(getContentService().getViewerId());
                if (viewPart != null && viewPart instanceof CommonNavigator) {
                    ((CommonNavigator) viewPart).getCommonViewer().refresh(parenViewObj);
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    public IRepositoryViewObject getParentRepositoryViewObject(IRepositoryViewObject dropViewObj) {
        Item dropItem = dropViewObj.getProperty().getItem();
        if (dropItem instanceof ContainerItem) {
            return dropViewObj;
        }
        return ContainerCacheService.getParent(dropViewObj);

    }
}
