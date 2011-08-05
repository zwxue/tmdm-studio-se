package org.talend.mdm.webapp.synchronization2.client;

import org.talend.mdm.webapp.synchronization2.shared.SynBaseModel;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Synchronization2Service")
public interface Synchronization2Service extends RemoteService {

    PagingLoadResult<SynBaseModel> getSyncItems(String regex, PagingLoadConfig load) throws Exception;
}
