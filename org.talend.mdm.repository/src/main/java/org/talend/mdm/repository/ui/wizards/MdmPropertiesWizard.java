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
package org.talend.mdm.repository.ui.wizards;

import org.eclipse.core.runtime.IPath;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.exception.MessageBoxExceptionHandler;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.ui.wizards.PropertiesWizard;


/**
 * DOC achen  class global comment. Detailled comment
 */
public class MdmPropertiesWizard extends PropertiesWizard {

    /**
     * DOC achen MdmPropertiesWizard constructor comment.
     * 
     * @param repositoryViewObject
     * @param path
     * @param useLastVersion
     */
    public MdmPropertiesWizard(IRepositoryViewObject repositoryViewObject, IPath path, boolean useLastVersion) {
        super(repositoryViewObject, path, useLastVersion);

        // reset the originaleObjectLabel
        MDMServerObjectItem item = (MDMServerObjectItem) object.getProperty().getItem();
        String oldName = item.getMDMServerObject().getName();
        // reset property's label
        object.getProperty().setLabel(oldName);
    }

    @Override
    public boolean performFinish() {
        if (alreadyEditedByUser) {
            return false;
        }
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        MDMServerObjectItem item = (MDMServerObjectItem) object.getProperty().getItem();
        String newName = object.getLabel();
        MDMServerObject serverObject = item.getMDMServerObject();
        try {
            if (serverObject != null) {
                String oldName = serverObject.getName();
                if (newName != null) {
                    serverObject.setName(newName);
                    newName = RepositoryResourceUtil.escapeSpecialCharacters(newName);
                    object.getProperty().setLabel(newName);
                    factory.save(object.getProperty().getItem(), false);
                    if (!oldName.equals(newName)) {
                    CommandManager.getInstance().pushCommand(ICommand.CMD_RENAME, object.getId(),
                            new String[] { oldName, newName });
                    }
                }
            }
        } catch (PersistenceException e) {
            MessageBoxExceptionHandler.process(e);
            return false;
        }
        return true;
    }
}
