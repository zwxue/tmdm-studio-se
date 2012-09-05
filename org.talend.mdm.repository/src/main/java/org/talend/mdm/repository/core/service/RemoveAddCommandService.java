package org.talend.mdm.repository.core.service;

import java.util.List;
import java.util.Map;

import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.service.bridge.IRemoveAddCommandService;


public class RemoveAddCommandService implements IRemoveAddCommandService {

    public boolean removeAddCommandOf(ERepositoryObjectType type, Object item) {
        List<IRepositoryViewObject> viewObjs = RepositoryResourceUtil.findAllViewObjects(type);
        for(IRepositoryViewObject viewObj:viewObjs) {
            Item innerItem = viewObj.getProperty().getItem();
            if(innerItem.equals(item)) {
                Map<String, List<ICommand>> allCommandsByPhase = CommandManager.getInstance().getAllCommandsByPhase(ICommand.CMD_ADD);
                for(List<ICommand> cList:allCommandsByPhase.values()) {
                    for(ICommand cmd : cList) {
                        String objName = cmd.getObjName();
                        String label = innerItem.getProperty().getLabel();
                        
                        if(objName.equals(label)) {
                            CommandManager.getInstance().removeCommandStack(cmd, ICommand.CMD_ADD);                        }
                    }
                }
                
                break;
            }
        }
        return false;
    }

    public boolean removeAddCommandOf(ERepositoryObjectType type, String itemName) {
        IRepositoryViewObject viewObj = RepositoryResourceUtil.findViewObjectByName(type, itemName);
        if(viewObj != null) {
            Item item = viewObj.getProperty().getItem();
            return removeAddCommandOf(type, item);
        }
        
        return false;
    }

}
