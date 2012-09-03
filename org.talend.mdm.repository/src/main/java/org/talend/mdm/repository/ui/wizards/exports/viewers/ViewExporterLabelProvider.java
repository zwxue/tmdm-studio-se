package org.talend.mdm.repository.ui.wizards.exports.viewers;

import org.talend.core.model.properties.Item;
import org.talend.mdm.repository.core.impl.view.ViewLabelProvider;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;


public class ViewExporterLabelProvider extends ViewLabelProvider {

    @Override
    protected String getServerObjectItemText(Item item) {
        MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
        if (serverObject != null) {
            String name = serverObject.getName();
            
            return name;
        }
        
        return null;
    }
}
