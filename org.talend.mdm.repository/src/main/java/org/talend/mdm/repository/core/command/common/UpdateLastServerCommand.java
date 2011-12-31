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
package org.talend.mdm.repository.core.command.common;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.command.AbstractCommand;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class UpdateLastServerCommand extends AbstractCommand {

    private static Logger log = Logger.getLogger(UpdateLastServerCommand.class);

    private static IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    private MDMServerObjectItem item;

    public void setItem(MDMServerObjectItem item) {
        this.item = item;
    }

    public void setServerDef(MDMServerDef serverDef) {
        this.serverDef = serverDef;
    }

    private MDMServerDef serverDef;

    public UpdateLastServerCommand() {

    }

    public UpdateLastServerCommand(MDMServerObjectItem item, MDMServerDef serverDef) {
        this.item = item;
        this.serverDef = serverDef;

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.command.AbstractCommand#getCommandType()
     */
    @Override
    public int getCommandType() {
        return ICommand.CMD_UPDATE_SERVER;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.command.AbstractCommand#execute(java.lang.Object,
     * org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public IStatus execute(Object params, IProgressMonitor monitor) {
        if (item == null) {
            if (viewObject == null) {
                CommandManager.getInstance().fillViewObjectToCommand(this);
            }
            item = (MDMServerObjectItem) viewObject.getProperty().getItem();
        }
        if (item != null) {
            saveLastServer(item, serverDef);
        }
        return Status.OK_STATUS;
    }

    private void saveLastServer(MDMServerObjectItem item, MDMServerDef serverDef) {

        if (factory.isEditableAndLockIfPossible(item)) {
            MDMServerObject mdmServerObject = item.getMDMServerObject();
            mdmServerObject.setLastServerDef(serverDef);
            try {
                factory.save(item);
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
