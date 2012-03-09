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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;
import org.eclipse.ui.navigator.CommonNavigator;
import org.talend.commons.exception.BusinessException;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryDropAssistant extends CommonDropAdapterAssistant {

    private static Logger log = Logger.getLogger(RepositoryDropAssistant.class);

    public IStatus validateDrop(Object target, int operation, TransferData transferType) {
        if (operation == DND.DROP_COPY || operation == DND.DROP_MOVE) {
            if (!(target instanceof IRepositoryViewObject)) {
                return Status.CANCEL_STATUS;
            }
            IRepositoryViewObject dragViewObj = getSelectedDragViewObj();
            IRepositoryViewObject dropViewObj = (IRepositoryViewObject) target;
            return validate(operation, dragViewObj, dropViewObj) ? Status.OK_STATUS : Status.CANCEL_STATUS;
        }
        return Status.CANCEL_STATUS;
    }

    public boolean validate(int operation, IRepositoryViewObject dragViewObj, IRepositoryViewObject dropViewObj) {
        if (dragViewObj == null || dropViewObj == null) {
            return false;
        }
        //
        if (dragViewObj instanceof FolderRepositoryObject) {
            return false;
        }

        ERepositoryObjectType dragType = dragViewObj.getRepositoryObjectType();

        // can't support workflow and job object
        if (dragType == IServerObjectRepositoryType.TYPE_WORKFLOW || dragType == ERepositoryObjectType.PROCESS) {
            return false;
        }

        if (dropViewObj instanceof FolderRepositoryObject) {
            if (((ContainerItem) dropViewObj.getProperty().getItem()).getType().getValue() == FolderType.STABLE_SYSTEM_FOLDER) {
                return false;
            }
        } else {
            return false;
        }
        // can't move to self folder
        if (operation == DND.DROP_MOVE) {
            IRepositoryViewObject dragParent = getParentRepositoryViewObject(dragViewObj);
            if (dragParent.equals(dropViewObj))
                return false;
        }
        // can't move/copy to different node folder
        ERepositoryObjectType dropType = dropViewObj.getRepositoryObjectType();

        if (dragType!=null && !dragType.equals(dropType))
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
        IRepositoryViewObject dragParent = getParentRepositoryViewObject(dragViewObj);
        IRepositoryViewObject dropParent = getParentRepositoryViewObject(dropViewObj);
        int detail = dropTargetEvent.detail;
        if (detail == DND.DROP_COPY) {
            if (copyViewObj(dragViewObj, dropViewObj)) {
                refreshContainer(dropParent);
                return Status.OK_STATUS;
            }
        } else if (detail == DND.DROP_MOVE) {
            if (moveViewObj(dragViewObj, dropViewObj)) {
                refreshContainer(dropParent);
                refreshContainer(dragParent);
                return Status.OK_STATUS;
            }
        }

        return Status.CANCEL_STATUS;
    }

    /**
     * DOC hbhong Comment method "moveViewObj".
     * 
     * @param dragViewObj
     * @param dropViewObj
     * @return
     */
    private boolean moveViewObj(IRepositoryViewObject dragViewObj, IRepositoryViewObject dropViewObj) {
        if (dropViewObj != null && dragViewObj != null) {
            if (RepositoryResourceUtil.isLockedViewObject(dragViewObj)) {
                MessageDialog.openError(getShell(), Messages.AbstractRepositoryAction_lockedObjTitle,
                        Messages.RepositoryDropAssistant_stopMoveMsg);
                return false;
            }
            Property dropProp = dropViewObj.getProperty();
            String pathStr = dropProp.getItem().getState().getPath();
            IPath path = new Path(pathStr);
            IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
            try {
                factory.moveObject(dragViewObj, path);
                return true;
            } catch (PersistenceException e) {
                log.error(e.getMessage(), e);
            } catch (BusinessException e) {
                log.error(e.getMessage(), e);
            }

        }
        return false;
    }

    public boolean copyViewObj(IRepositoryViewObject dragViewObj, IRepositoryViewObject dropViewObj) {
        if (dropViewObj != null && dragViewObj != null) {

            Property dragProp = dragViewObj.getProperty();
            Property dropProp = dropViewObj.getProperty();
            Item item = dragProp.getItem();
            String name;
            if (item instanceof MDMServerObjectItem) {
                MDMServerObject serverObj = ((MDMServerObjectItem) item).getMDMServerObject();
                name = serverObj.getName();
            } else {
                name = dragProp.getLabel();
            }
            // show dialog
            IRepositoryViewObject dragParentViewObj = getParentRepositoryViewObject(dragViewObj);
            ContainerItem dragParentItem = (ContainerItem) dragParentViewObj.getProperty().getItem();
            String newName = showPasteDlg(dragParentItem.getRepObjType(), dragParentItem, "Copy_" + name); //$NON-NLS-1$
            if (newName != null) {
                String pathStr = dropProp.getItem().getState().getPath();
                IPath path = new Path(pathStr);
                IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
                Item copy = null;
                try {
                    copy = factory.copy(item, path, true);
                    if (factory.isEditableAndLockIfPossible(copy)) {
                        if (copy instanceof MDMServerObjectItem) {
                            ((MDMServerObjectItem) copy).getMDMServerObject().setName(newName);
                            ((MDMServerObjectItem) copy).getMDMServerObject().setLastServerDef(null);
                            CommandManager.getInstance().pushCommand(ICommand.CMD_ADD, copy.getProperty().getId(), newName);
                        }
                        copy.getProperty().setLabel(newName);
                        RepositoryResourceUtil.setLastServerDef(copy, null);
                        factory.save(copy);
                        return true;
                    }
                } catch (PersistenceException e) {
                    log.error(e.getMessage(), e);
                } catch (BusinessException e) {
                    log.error(e.getMessage(), e);
                } finally {

                    try {
                        factory.unlock(copy);
                    } catch (PersistenceException e) {
                        log.error(e.getMessage(), e);
                    } catch (LoginException e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
        }
        return false;
    }

    private String showPasteDlg(final ERepositoryObjectType type, final ContainerItem parentItem, String initLabel) {
        InputDialog dlg = new InputDialog(getShell(), Messages.RepositoryDropAssistant_pasteObject, Messages.Common_inputName,
                initLabel, new IInputValidator() {

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

    private void refreshContainer(final IRepositoryViewObject viewObj) {
        Display.getDefault().asyncExec(new Runnable() {

            public void run() {
                if (viewObj != null) {
                    try {
                        IViewPart viewPart = RepositoryPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
                                .getActivePage().findView(getContentService().getViewerId());
                        if (viewPart != null && viewPart instanceof CommonNavigator) {
                            ((CommonNavigator) viewPart).getCommonViewer().refresh(viewObj);
                        }
                        Item item = viewObj.getProperty().getItem();
                        if (item instanceof ContainerItem) {
                            ERepositoryObjectType repObjType = ((ContainerItem) item).getRepObjType();
                            if(repObjType == IServerObjectRepositoryType.TYPE_TRANSFORMERV2){
                                 ContainerCacheService.refreshRepositoryRoot(IServerObjectRepositoryType.TYPE_EVENTMANAGER,
                                 ((CommonNavigator) viewPart).getCommonViewer());
                            }
                        }
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }

        });

    }



    public IRepositoryViewObject getParentRepositoryViewObject(IRepositoryViewObject dropViewObj) {
        Item dropItem = dropViewObj.getProperty().getItem();
        if (dropItem instanceof ContainerItem) {
            return dropViewObj;
        }
        return ContainerCacheService.getParent(dropViewObj);

    }
}
