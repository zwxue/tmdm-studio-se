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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MDMServerDef {

    private String desc = "";//$NON-NLS-1$

    private String host = "localhost";//$NON-NLS-1$

    private String port = "8080";//$NON-NLS-1$

    private String user = "";//$NON-NLS-1$

    private String passwd = "";//$NON-NLS-1$
    
    private String universe = ""; //$NON-NLS-1$

    private boolean saved = false;

    private boolean connected = false;

    private String path = "/talend/TalendPort";//$NON-NLS-1$

    public static final String PATTERN_URL = "^http://(.+):(\\d+)(/.*)";//$NON-NLS-1$

    public MDMServerDef(String desc, String host, String port, String path, String user, String passwd, String universe, boolean saved,
            boolean connected) {

        this.desc = desc;
        this.host = host;
        this.port = port;
        this.path = path;
        this.user = user;
        this.passwd = passwd;
        this.universe = universe;
        this.saved = saved;
        this.connected = connected;
    }

    public MDMServerDef() {

    }

    public boolean isSaved() {
        return saved;
    }

    public boolean isConnected() {
        return connected;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public String getUniverse() {
        return universe;
    }
    
    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getUrl() {
        StringBuilder sb = new StringBuilder("http://");//$NON-NLS-1$

        sb.append(host);
        sb.append(":");//$NON-NLS-1$
        sb.append(port);
        sb.append(path);

        return sb.toString();
    }

    public static MDMServerDef parse(String url, String user, String passwd, String universe, String desc, boolean saved, boolean connected) {

        Matcher m = Pattern.compile(PATTERN_URL).matcher(url);

        if (!m.find())
            return null;

        String host = m.group(1);
        String port = m.group(2);
        String path = m.group(3);

        return new MDMServerDef(desc, host, port, path, user, passwd, universe, saved, connected);
    }
}
