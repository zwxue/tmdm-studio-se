package com.amalto.workbench.utils;

public class MDMServerDef {

    private String desc = "";

    private String host = "localhost";

    private String port = "8080";

    private String user = "";

    private String passwd = "";

    private String path = "/talend/TalendPort";

    public MDMServerDef(String desc, String host, String port, String path, String user, String passwd) {

        this.desc = desc;
        this.host = host;
        this.port = port;
        this.path = path;
        this.user = user;
        this.passwd = passwd;
    }

    public MDMServerDef(String desc, String host, String port, String user, String passwd) {
        this(desc, host, port, "/talend/TalendPort", user, passwd);
    }

    public MDMServerDef() {

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

    public String getUrl() {
        StringBuilder sb = new StringBuilder("http://");

        sb.append(host);
        sb.append(":");
        sb.append(port);
        sb.append(path);

        return sb.toString();
    }
}
