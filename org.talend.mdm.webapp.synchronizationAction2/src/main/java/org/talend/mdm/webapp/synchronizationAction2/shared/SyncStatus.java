package org.talend.mdm.webapp.synchronizationAction2.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SyncStatus implements IsSerializable {

    private String value;

    private String message;

    public SyncStatus() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
