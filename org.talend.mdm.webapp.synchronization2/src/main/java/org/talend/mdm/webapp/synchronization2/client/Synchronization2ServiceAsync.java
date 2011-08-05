package org.talend.mdm.webapp.synchronization2.client;

import org.talend.mdm.webapp.synchronization2.shared.SynBaseModel;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface Synchronization2ServiceAsync {

    void getSyncItems(String regex, PagingLoadConfig load, AsyncCallback<PagingLoadResult<SynBaseModel>> callback);


}
