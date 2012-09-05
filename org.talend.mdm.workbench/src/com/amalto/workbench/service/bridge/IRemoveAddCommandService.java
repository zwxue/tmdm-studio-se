// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.service.bridge;

import org.talend.core.IService;
import org.talend.core.model.repository.ERepositoryObjectType;


public interface IRemoveAddCommandService extends IService{
    public boolean removeAddCommandOf(ERepositoryObjectType type, Object item);
    public boolean removeAddCommandOf(ERepositoryObjectType type, String itemName);
}
