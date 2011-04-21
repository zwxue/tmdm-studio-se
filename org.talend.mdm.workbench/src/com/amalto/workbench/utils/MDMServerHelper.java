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
package com.amalto.workbench.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.eclipse.core.runtime.Platform;

import com.amalto.workbench.dialogs.LoginDialog;

public class MDMServerHelper {

    private static String workbenchConfigFile = Platform.getInstanceLocation().getURL().getPath() + "/mdm_workbench_config.xml"; //$NON-NLS-1$

    private static Log log = LogFactory.getLog(LoginDialog.class);

    public static List<MDMServerDef> getServers() {       
        List<MDMServerDef> defs = new ArrayList<MDMServerDef>();        
        Element root;
        Document logininfoDocument = null;
        if (new File(workbenchConfigFile).exists()) {
            try {
                SAXReader reader = new SAXReader();
                logininfoDocument = reader.read(new File(workbenchConfigFile));
            } catch (DocumentException e) {
                log.error(e.getMessage(), e);
                return defs;
            }
            root = logininfoDocument.getRootElement();
        } else {
            logininfoDocument = DocumentHelper.createDocument();
            root = logininfoDocument.addElement("MDMServer"); //$NON-NLS-1$
        }
        
        List<Element> properties = root.elements("properties"); //$NON-NLS-1$
        for (Element ele : properties) {
            String password = ele.element("password").getText(); //$NON-NLS-1$
            password = PasswordUtil.decryptPassword(password);
            MDMServerDef def = MDMServerDef.parse(ele.element("url").getText(), ele.element("user").getText(), password, ele //$NON-NLS-1$ //$NON-NLS-2$
                    .element("desc").getText()); //$NON-NLS-1$
            defs.add(def);
        }
        return defs;
    }

}
