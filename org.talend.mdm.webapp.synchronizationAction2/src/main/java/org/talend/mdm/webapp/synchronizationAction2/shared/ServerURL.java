package org.talend.mdm.webapp.synchronizationAction2.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ServerURL implements IsSerializable {

    private String id;

    private String name;

    public ServerURL() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
