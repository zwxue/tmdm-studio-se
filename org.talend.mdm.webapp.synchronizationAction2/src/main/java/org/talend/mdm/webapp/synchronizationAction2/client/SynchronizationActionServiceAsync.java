package org.talend.mdm.webapp.synchronizationAction2.client;

import java.util.List;

import org.talend.mdm.webapp.synchronizationAction2.shared.ItemBaseModel;
import org.talend.mdm.webapp.synchronizationAction2.shared.ListRange;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncInfo;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncStatus;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface SynchronizationActionServiceAsync {   
    
    void getSyncNames(SyncInfo syncInfo,AsyncCallback<List<ItemBaseModel>> callback)throws Exception;
    
    void startFull(SyncInfo info,AsyncCallback<Void> callback)throws Exception;
    
    void startDifferent(SyncInfo info,AsyncCallback<Void> callback)throws Exception;
    
    void stop(SyncInfo info,AsyncCallback<Void> callback)throws Exception;
    
    void reset(SyncInfo info,AsyncCallback<Void> callback)throws Exception;

    void getStatus(SyncInfo info,AsyncCallback<SyncStatus> callback)throws Exception;
    
    void getSavedURLs(AsyncCallback<ListRange> callback)throws Exception;
    
    void saveURLs(String url,AsyncCallback<Void> callback)throws Exception;
    
    void getInfo(SyncInfo info,AsyncCallback<List<ItemBaseModel>> callback)throws IllegalArgumentException;

}
