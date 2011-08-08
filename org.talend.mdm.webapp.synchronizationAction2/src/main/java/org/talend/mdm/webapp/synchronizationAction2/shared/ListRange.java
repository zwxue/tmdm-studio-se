package org.talend.mdm.webapp.synchronizationAction2.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/*
 * generic bean for Ext.2.0 datastore
 * must be used with dwrproxy
 */

public class ListRange implements IsSerializable{

	private static final long serialVersionUID = 6239586023660639700L;

	private ServerURL[] data;

	private int totalSize;
	
	public ListRange(){
	    
	}

	public ServerURL[] getData() {
		return data;
	}

	public void setData(ServerURL[] data) {
		this.data = data;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
}