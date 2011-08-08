package org.talend.mdm.webapp.synchronizationAction2.client;

import java.util.List;

import org.talend.mdm.webapp.synchronizationAction2.shared.ItemBaseModel;
import org.talend.mdm.webapp.synchronizationAction2.shared.ListRange;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncInfo;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncStatus;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface SynchronizationActionServiceAsync {

    void getSyncNames(SyncInfo info, AsyncCallback<List<ItemBaseModel>> callback);

    void startFull(SyncInfo info, AsyncCallback<Void> callback);

    void startDifferent(SyncInfo info, AsyncCallback<Void> callback);

    void stop(SyncInfo info, AsyncCallback<Void> callback);

    void reset(SyncInfo info, AsyncCallback<Void> callback);

    void getStatus(SyncInfo info, AsyncCallback<SyncStatus> callback);

    void getSavedURLs(AsyncCallback<ListRange> callback);

    void saveURLs(String url, AsyncCallback<Void> callback);

    void getInfo(SyncInfo info, AsyncCallback<List<ItemBaseModel>> callback);   
    
}
