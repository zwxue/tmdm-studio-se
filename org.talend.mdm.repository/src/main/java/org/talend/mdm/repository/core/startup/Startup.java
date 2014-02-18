package org.talend.mdm.repository.core.startup;

import org.eclipse.ui.IStartup;
import org.talend.mdm.repository.core.service.IRelationService;
import org.talend.mdm.repository.utils.ServiceUtil;

public class Startup implements IStartup {

    public void earlyStartup() {
        buildRelationMap();

    }

    private void buildRelationMap() {
        IRelationService service = ServiceUtil.getService(IRelationService.class);
        if (service != null) {
            service.buildRelationMap();
        }
    }

}
