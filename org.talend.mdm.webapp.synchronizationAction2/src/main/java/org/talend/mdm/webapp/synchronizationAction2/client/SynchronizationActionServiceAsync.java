// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.webapp.synchronizationAction2.client;

import java.util.List;

import org.talend.mdm.webapp.synchronizationAction2.client.model.ItemBaseModel;
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

    void getSavedURLs(AsyncCallback<List<ItemBaseModel>> callback);

    void saveURLs(String url, AsyncCallback<Void> callback);    
}
