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
package org.talend.mdm.webapp.synchronizationAction2.shared;

import org.talend.mdm.webapp.synchronizationAction2.client.model.ItemBaseModel;

import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.user.client.rpc.IsSerializable;

public class ItemModelStore extends ListStore<ItemBaseModel> implements IsSerializable {

    public ItemModelStore() {

    }
}
