package com.amalto.workbench.service.bridge;

import org.talend.core.IService;
import org.talend.core.model.repository.ERepositoryObjectType;


public interface IRemoveAddCommandService extends IService{
    public boolean removeAddCommandOf(ERepositoryObjectType type, Object item);
    public boolean removeAddCommandOf(ERepositoryObjectType type, String itemName);
}
