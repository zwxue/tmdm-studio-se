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
package org.talend.mdm.repository.ui.starting.actions;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem;
import org.talend.mdm.workbench.serverexplorer.core.ServerDefService;

public class ConnectToWebUIAction implements IIntroAction {

    private static Logger log = Logger.getLogger(ConnectToWebUIAction.class);
    public void run(IIntroSite iintrosite, Properties properties) {
        String url = getUrl();
        try {
            open(url);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private void open(String url) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
            URI uri = URI.create(url);
            desktop.browse(uri);
        }
    }

    private String getUrl() {
        String path = "/general/secure/";//$NON-NLS-1$
        String defaultHostPort = "http://localhost:8180";//$NON-NLS-1$

        List<IRepositoryViewObject> viewObjects = ServerDefService.getAllServerDefViewObjects();
        if (viewObjects == null || viewObjects.size() == 0)
            return defaultHostPort + path;

        MDMServerDefItem serverDefItem = (MDMServerDefItem) (viewObjects.get(0).getProperty().getItem());
        String host = serverDefItem.getServerDef().getHost();
        String port = serverDefItem.getServerDef().getPort();

        return "http://" + host + ":" + port + path;//$NON-NLS-1$//$NON-NLS-2$
    }
}
