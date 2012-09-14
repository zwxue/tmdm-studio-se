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
package org.talend.mdm.repository.ui.actions.view;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.impl.view.IViewNodeConstDef;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.ui.actions.RenameObjectAction;
import org.talend.mdm.repository.ui.dialogs.RenameViewDialog;
import org.talend.mdm.repository.ui.dialogs.RenameViewDialog2;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.repository.utils.ValidateUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;


public class RenameViewAction extends AbstractRepositoryAction {
    private static Logger log = Logger.getLogger(RenameObjectAction.class);
    private IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
    private IInputValidator inputValidator;
    private ERepositoryObjectType type;
    private IWorkbenchPartSite site;
    
    private String viewPrefix = IViewNodeConstDef.PREFIX_VIEW;
    
    public RenameViewAction() {
        super(Messages.RenameObjectAction_rename);
        setImageDescriptor(ImageCache.getImage(EImage.RENAME.getPath()));
    }

    @Override
    public String getGroupName() {
        return GROUP_EDIT;
    }

    protected boolean needValidateLockedObject() {
        return true;
    }

    @Override
    protected void doRun() {
        site = commonViewer.getCommonNavigator().getSite();
        
        Object selectObj = getSelectedObject().get(0);
        if (selectObj instanceof IRepositoryViewObject) {
            IRepositoryViewObject viewObj = (IRepositoryViewObject) selectObj;
            MDMServerObjectItem item = (MDMServerObjectItem) viewObj.getProperty().getItem();
            MDMServerObject serverObject = item.getMDMServerObject();

            try {
                if (serverObject != null) {
                    type = viewObj.getRepositoryObjectType();
                    String oldName = serverObject.getName();
                    RenameViewDialog dialog = getRenameDialog(oldName);

                    int returnCode = dialog.open();
                    if (returnCode == IDialogConstants.OK_ID) {
                        String newName = dialog.getValue();
                        
                        if(oldName.toLowerCase().startsWith(viewPrefix))
                            newName = IViewNodeConstDef.PREFIX_VIEW_UPPER + newName;
                        
                        if (newName != null && factory.isEditableAndLockIfPossible(item)) {
                            serverObject.setName(newName);
                            viewObj.getProperty().setLabel(newName);
                            factory.save(viewObj.getProperty().getItem(), false);
                            if (serverObject.getLastServerDef() != null) {
                                CommandManager.getInstance().pushCommand(ICommand.CMD_RENAME, viewObj.getId(),
                                        new String[] { oldName, newName });
                            }
                        }

                        commonViewer.refresh(viewObj);
                    }

                }
            } catch (PersistenceException e) {
                log.error(e.getMessage(), e);
            } finally {
                try {
                    factory.unlock(item);
                } catch (PersistenceException e) {
                    log.error(e.getMessage(), e);
                } catch (LoginException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    
    private RenameViewDialog getRenameDialog(String oldName) {
        RenameViewDialog dialog = null;
        if(oldName.toLowerCase().startsWith(viewPrefix)) {
            dialog = new RenameViewDialog(getShell(), Messages.RenameObjectAction_rename, Messages.Common_rename, oldName.substring(viewPrefix.length()), getInputValidator() , site);
        } else {
            dialog = new RenameViewDialog2(getShell(), Messages.RenameObjectAction_rename, Messages.Common_rename, oldName,getInputValidator(), site);
        }
        
        return dialog;
    }
    
    private IInputValidator getInputValidator() {
        if(inputValidator == null) {
            inputValidator =  new IInputValidator() {

                public String isValid(String newText) {
                    if (newText == null || newText.trim().length() == 0)
                        return Messages.Common_nameCanNotBeEmpty;
                    
                    if (!ValidateUtil.matchViewProcessRegex(newText)) {
                        return Messages.Common_nameInvalid;
                    }
                    //
                    if (RepositoryResourceUtil.isExistByName(type, newText.trim())) {
                        return Messages.Common_nameIsUsed;
                    }
                    return null;
                };
            };
        }
        
        return inputValidator;
    }
}
