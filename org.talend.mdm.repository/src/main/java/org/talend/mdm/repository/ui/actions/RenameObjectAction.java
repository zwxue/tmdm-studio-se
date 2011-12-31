// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RenameObjectAction extends AbstractRepositoryAction {

    static Logger log = Logger.getLogger(RenameObjectAction.class);

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    /**
     * DOC hbhong RemoveFromRepositoryAction constructor comment.
     * 
     * @param text
     */
    public RenameObjectAction() {
        super(Messages.RenameObjectAction_rename);
        setImageDescriptor(ImageCache.getImage(EImage.RENAME.getPath()));
    }

    @Override
    public String getGroupName() {
        return GROUP_EDIT;
    }

    protected void doRun() {
        Object obj = getSelectedObject().get(0);
        if (obj instanceof IRepositoryViewObject) {
            IRepositoryViewObject viewObj = (IRepositoryViewObject) obj;

            MDMServerObjectItem item = (MDMServerObjectItem) viewObj.getProperty().getItem();
            MDMServerObject serverObject = item.getMDMServerObject();
            IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(item);
            if (configuration != null) {
                ERepositoryObjectType type = configuration.getResourceProvider().getRepositoryObjectType(item);
                IRepositoryViewObject parentViewObj = ContainerCacheService.get(type, item.getState().getPath());

                try {
                    if (serverObject != null) {
                        String oldName = serverObject.getName();
                        String newName = showRenameDlg(type, (ContainerItem) parentViewObj.getProperty().getItem(), oldName);
                        if (newName != null && factory.isEditableAndLockIfPossible(item)) {
                            serverObject.setName(newName);
                            viewObj.getProperty().setLabel(newName);
                            factory.save(viewObj.getProperty().getItem(), false);
                            if (serverObject.getLastServerDef() != null) {
                                CommandManager.getInstance().pushCommand(ICommand.CMD_RENAME, viewObj.getId(),
                                        new String[] { oldName, newName });
                            }
                        }
                    }
                    commonViewer.refresh(obj);
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

    private String showRenameDlg(final ERepositoryObjectType type, final ContainerItem parentItem, final String originalName) {

        InputDialog dlg = new InputDialog(getShell(), Messages.RenameObjectAction_rename, Messages.Common_rename, originalName,
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
}
