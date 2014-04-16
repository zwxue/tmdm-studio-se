package org.talend.mdm.repository.handler;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EMap;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.items.importexport.handlers.imports.ImportRepTypeHandler;
import org.talend.repository.items.importexport.handlers.model.ImportItem;
import org.talend.repository.items.importexport.manager.ResourcesManager;

public class MdmImportHandler extends ImportRepTypeHandler {

    private ProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();

    private static Logger log = Logger.getLogger(MdmImportHandler.class);

    @Override
    public void afterImportingItems(IProgressMonitor monitor, ResourcesManager resManager, ImportItem selectedImportItem) {
        super.afterImportingItems(monitor, resManager, selectedImportItem);

        try {
            IRepositoryViewObject object = factory.getSpecificVersion(selectedImportItem.getItemId(),
                    selectedImportItem.getItemVersion(), true);
            if (null != object) {
                update(object, selectedImportItem);
            }
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
    }

    protected void update(IRepositoryViewObject object, ImportItem selectedImportItem) throws PersistenceException {
        Property property = object.getProperty();
        Item item = property.getItem();
        boolean needSave = false;
        if (item instanceof MDMServerObjectItem) {
            MDMServerObject serverObj = ((MDMServerObjectItem) item).getMDMServerObject();
            if (serverObj.getLastServerDef() != null) {
                serverObj.setLastServerDef(null);
                needSave = true;
            }

        } else {
            EMap<?, ?> additionalProperties = property.getAdditionalProperties();
            if (additionalProperties != null) {
                additionalProperties.remove(RepositoryResourceUtil.PROP_LAST_SERVER_DEF);
                needSave = true;
            }
        }
        if (needSave) {
            factory.save(item, true);
        }
        if (selectedImportItem.isValid()) {
            String[] split = selectedImportItem.getLabel().split(" "); //$NON-NLS-1$
            String name = split.length > 0 ? split[0] : null;
            if (name != null) {
                CommandManager.getInstance().pushCommand(ICommand.CMD_ADD, selectedImportItem.getItemId(), name);
            }
        }
    }
}
