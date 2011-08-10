package org.talend.mdm.webapp.synchronizationAction2.client;

import java.util.List;

import org.talend.mdm.webapp.synchronizationAction2.client.model.ItemBaseModel;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncInfo;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncStatus;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("synchronizationActionService")
public interface SynchronizationActionService extends RemoteService{

    public List<ItemBaseModel> getSyncNames(SyncInfo info)throws Exception;
    
    public void startFull(SyncInfo info)throws Exception;
    
    public void startDifferent(SyncInfo info)throws Exception;
    
    public void stop(SyncInfo info)throws Exception;
    
    public void reset(SyncInfo info)throws Exception;

    public SyncStatus getStatus(SyncInfo info)throws Exception;
    
    public List<ItemBaseModel> getSavedURLs()throws Exception;
    
    public void saveURLs(String url)throws Exception;
    
    public List<ItemBaseModel> getInfo(SyncInfo info)throws IllegalArgumentException;
}