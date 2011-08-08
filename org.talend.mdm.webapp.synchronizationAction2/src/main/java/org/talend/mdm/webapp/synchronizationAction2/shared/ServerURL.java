package org.talend.mdm.webapp.synchronizationAction2.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ServerURL implements IsSerializable {
	String id;
	String name;
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
