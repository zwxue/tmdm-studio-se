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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.eclipse.core.runtime.Platform;

public class MDMServerHelper {

    public static final String ROOT = "MDMServer"; //$NON-NLS-1$

    public static final String PROPERTIES = "properties"; //$NON-NLS-1$

    public static final String NAME = "name"; //$NON-NLS-1$

    public static final String URL = "url"; //$NON-NLS-1$

    public static final String USER = "user"; //$NON-NLS-1$

    public static final String PASSWORD = "password"; //$NON-NLS-1$

    public static final String UNIVERSE = "universe"; //$NON-NLS-1$

    public static final String workbenchConfigFile = Platform.getInstanceLocation().getURL().getPath()
            + "/mdm_workbench_config.xml"; //$NON-NLS-1$

    private static java.util.List<MDMServerDef> serversListFromSerExp = new ArrayList<MDMServerDef>();

    private static final Log log = LogFactory.getLog(MDMServerHelper.class);

    public static List<MDMServerDef> getServers() {
        List<MDMServerDef> defs = new ArrayList<MDMServerDef>();
        Element rootElement = getRootElement();
        if (rootElement == null)
            return defs;

        List<?> properties = rootElement.elements(PROPERTIES);
        for (Iterator<?> iterator = properties.iterator(); iterator.hasNext();) {
            Element serverElement = (Element) iterator.next();
            MDMServerDef def = getServer(serverElement);
            defs.add(def);
        }
        return defs;
    }

    public static java.util.List<MDMServerDef> getServersListFromSerExp() {
        return serversListFromSerExp;
    }

    public static MDMServerDef getServer(String name) {
        Element rootElement = getRootElement();
        if (rootElement == null)
            return null;
        Element serverElement = getServerElement(rootElement, name);
        if (serverElement != null)
            return getServer(serverElement);
        return null;
    }

    private static MDMServerDef getServer(Element serverElement) {
        String name = serverElement.element(NAME).getText();
        String url = serverElement.element(URL).getText();
        String user = serverElement.element(USER).getText();
        String password = serverElement.element(PASSWORD).getText();
        String universe = serverElement.element(UNIVERSE) != null ? serverElement.element(UNIVERSE).getText() : ""; //$NON-NLS-1$
        password = PasswordUtil.decryptPassword(password);
        MDMServerDef def = MDMServerDef.parse(url, user, password, universe, name);
        return def;
    }

    public static boolean deleteServer(String name) {
        boolean deleted = false;
        Element rootElement = getRootElement();
        Element serverElement = getServerElement(rootElement, name);
        if (serverElement != null) {
            rootElement.remove(serverElement);
            deleted = saveRootElement(rootElement);
        }
        return deleted;
    }

    public static boolean saveServer(MDMServerDef serverDef) {
        Element rootElement = getRootElement();
        Element serverElement = getServerElement(rootElement, serverDef.getName());

        if (serverElement == null) {
            addServerElement(rootElement, serverDef);
        } else {
            addServerProperties(serverElement, serverDef);
        }
        return saveRootElement(rootElement);
    }

    public static boolean updateServer(MDMServerDef oldServerDef, MDMServerDef newServerDef) {
        Element rootElement = getRootElement();
        String oldName = oldServerDef.getName();
        Element serverElement = null;
        String newName = newServerDef.getName();
        if (oldName.equals(newName)) {
            serverElement = getServerElement(rootElement, oldName);
        } else {
            serverElement = getServerElement(rootElement, oldName);
            if (serverElement != null) {
                rootElement.remove(serverElement);
            }
            serverElement = getServerElement(rootElement, newName);
        }
        if (serverElement == null) {
            addServerElement(rootElement, newServerDef);
        } else {
            addServerProperties(serverElement, newServerDef);
        }

        return saveRootElement(rootElement);
    }

    private static void addServerElement(Element root, MDMServerDef serverDef) {
        Element prop = root.addElement(MDMServerHelper.PROPERTIES);
        addServerProperties(prop, serverDef);
        Element name = prop.element(MDMServerHelper.NAME);
        if (name == null)
            name = prop.addElement(MDMServerHelper.NAME);
        name.setText(serverDef.getName());
    }

    private static void addServerProperties(Element prop, MDMServerDef serverDef) {
        Element url = prop.element(MDMServerHelper.URL);
        if (url == null)
            url = prop.addElement(MDMServerHelper.URL);
        url.setText(serverDef.getUrl());

        Element user = prop.element(MDMServerHelper.USER);
        if (user == null)
            user = prop.addElement(MDMServerHelper.USER);
        user.setText(serverDef.getUser());

        Element password = prop.element(MDMServerHelper.PASSWORD);
        if (password == null)
            password = prop.addElement(MDMServerHelper.PASSWORD);
        password.setText(PasswordUtil.encryptPassword(serverDef.getPasswd()));

        if (serverDef.getUniverse() != null) {
            Element universe = prop.element(MDMServerHelper.UNIVERSE);
            if (universe == null)
                universe = prop.addElement(MDMServerHelper.UNIVERSE);
            universe.setText(serverDef.getUniverse());
        }
    }

    private static Element getRootElement() {
        Document logininfoDocument;
        Element rootElement;
        if (new File(workbenchConfigFile).exists()) {
            try {
                SAXReader reader = new SAXReader();
                logininfoDocument = reader.read(new File(workbenchConfigFile));
            } catch (DocumentException e) {
                log.error(e.getMessage(), e);
                return null;
            }
            rootElement = logininfoDocument.getRootElement();
        } else {
            logininfoDocument = DocumentHelper.createDocument();
            rootElement = logininfoDocument.addElement(ROOT);
        }
        return rootElement;
    }

    private static Element getServerElement(Element rootElement, String matchingName) {
        List<?> properties = rootElement.elements(MDMServerHelper.PROPERTIES);
        for (Iterator<?> iterator = properties.iterator(); iterator.hasNext();) {
            Element serverElement = (Element) iterator.next();
            Element nameElement = serverElement.element(MDMServerHelper.NAME);
            if (nameElement != null) {
                String name = nameElement.getText();
                if (matchingName.equals(name))
                    return serverElement;
            }
        }
        return null;
    }

    private static boolean saveRootElement(Element rootElement) {
        try {
            XMLWriter writer = new XMLWriter(new FileWriter(MDMServerHelper.workbenchConfigFile));
            writer.write(rootElement.getDocument());
            writer.close();
            return true;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
