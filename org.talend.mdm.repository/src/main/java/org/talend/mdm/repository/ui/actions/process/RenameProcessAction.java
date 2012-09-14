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
package org.talend.mdm.repository.ui.actions.process;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.impl.transformerV2.ITransformerV2NodeConsDef;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.repository.utils.ValidateUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

public class RenameProcessAction extends AbstractRepositoryAction {

    private static Logger log = Logger.getLogger(RenameProcessAction.class);

    private ERepositoryObjectType etype;

    protected IInputValidator validator;

    public RenameProcessAction() {
        super(Messages.RenameObjectAction_rename);
        setImageDescriptor(ImageCache.getImage(EImage.RENAME.getPath()));
    }

    @Override
    public String getGroupName() {
        return GROUP_EDIT;
    }

    @Override
    protected void doRun() {

        Object selectObj = getSelectedObject().get(0);
        if (selectObj instanceof IRepositoryViewObject) {
            IRepositoryViewObject viewObj = (IRepositoryViewObject) selectObj;
            MDMServerObjectItem item = (MDMServerObjectItem) viewObj.getProperty().getItem();

            int type = getType(item);
            etype = viewObj.getRepositoryObjectType();

            MDMServerObject serverObject = item.getMDMServerObject();

            if (serverObject != null) {
                String oldName = serverObject.getName();
                RenameProcessDialog dialog = getRenameDialog(getSite(), oldName, type, getInputValidator());
                int returnCode = dialog.open();

                if (returnCode == Window.OK) {
                    IProxyRepositoryFactory factory = getFactory();
                    String newName = dialog.getValue();

                    try {
                        if (factory.isEditableAndLockIfPossible(item)) {
                            serverObject.setName(newName);
                            viewObj.getProperty().setLabel(newName);
                            factory.save(item, false);
                            if (serverObject.getLastServerDef() != null) {
                                CommandManager.getInstance().pushCommand(ICommand.CMD_RENAME, viewObj.getId(),
                                        new String[] { oldName, newName });
                            }
                        }

                        commonViewer.refresh(viewObj);
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
        }

    }

    private IWorkbenchPartSite getSite() {
        IWorkbenchPartSite site = commonViewer.getCommonNavigator().getSite();
        return site;
    }

    private IProxyRepositoryFactory getFactory() {
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        return factory;
    }

    private RenameProcessDialog getRenameDialog(IWorkbenchPartSite site, String processName, int type,
            IInputValidator inputValidator) {
        RenameProcessDialog renameDialog = new RenameProcessDialog(site.getShell(), site, type, processName, inputValidator);
        return renameDialog;
    }

    private int getType(Item item) {
        int type = 0;

        String path = item.getState().getPath();
        if (path.startsWith("/")) //$NON-NLS-1$
            path = path.substring(1);
        if (path.startsWith(ITransformerV2NodeConsDef.PATH_BEFORESAVE)) {
            type = 1;
        } else if (path.startsWith(ITransformerV2NodeConsDef.PATH_BEFOREDEL)) {
            type = 2;
        } else if (path.startsWith(ITransformerV2NodeConsDef.PATH_ENTITYACTION)) {
            type = 3;
        } else if (path.startsWith(ITransformerV2NodeConsDef.PATH_WELCOMEACTION)) {
            type = 4;
        } else if (path.startsWith(ITransformerV2NodeConsDef.PATH_SMARTVIEW)) {
            type = 5;
        } else if (path.startsWith(ITransformerV2NodeConsDef.PATH_OTHER)) {
            type = 6;
        }

        return type;
    }

    private IInputValidator getInputValidator() {
        if (validator == null) {
            validator = new IInputValidator() {

                public String isValid(String newText) {
                    if (newText == null || newText.trim().length() == 0)
                        return Messages.Common_nameCanNotBeEmpty;

                    if (!ValidateUtil.matchViewProcessRegex(newText)) {
                        return Messages.Common_nameInvalid;
                    }
                    //
                    if (RepositoryResourceUtil.isExistByName(etype, newText.trim())) {
                        return Messages.Common_nameIsUsed;
                    }
                    return null;
                };
            };
        }

        return validator;
    }

    public boolean matchViewProcessRegex(String newText) {
        String regex = "\\w*(#|\\.|\\w*)+(#|\\w+)";//$NON-NLS-1$
        String tailRegex = ".*(#|\\w+)";//$NON-NLS-1$

        return matches(regex, tailRegex, newText);
    }

    private boolean matches(String regex, String tailRegex, String newText) {
        Pattern p1 = Pattern.compile(regex);

        return p1.matcher(newText).matches();
    }

    @Override
    public boolean isVisible(IRepositoryViewObject viewObj) {
        if (getSelectedObject().size() == 1) {
            String path = viewObj.getPath();
            if (path != null && path.equalsIgnoreCase("system")) {//$NON-NLS-1$
                return false;
            }
            return true;
        }
        return false;
    }

}
