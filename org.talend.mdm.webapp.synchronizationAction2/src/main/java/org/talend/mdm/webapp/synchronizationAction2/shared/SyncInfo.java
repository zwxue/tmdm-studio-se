package org.talend.mdm.webapp.synchronizationAction2.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SyncInfo implements IsSerializable {

    private String serverURL;

    private String username;

    private String password;

    private String syncName;

    public SyncInfo() {

    }

    public String getServerURL() {
        return serverURL;
    }

    public void setServerURL(String serverURL) {
        this.serverURL = serverURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSyncName() {
        return syncName;
    }

    public void setSyncName(String syncName) {
        this.syncName = syncName;
    }

}
