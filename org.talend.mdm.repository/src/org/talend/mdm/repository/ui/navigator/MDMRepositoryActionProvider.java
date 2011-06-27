package org.talend.mdm.repository.ui.navigator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IGroupAction;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;

public class MDMRepositoryActionProvider extends CommonActionProvider {

    public MDMRepositoryActionProvider() {

    }

    @Override
    public void fillContextMenu(IMenuManager menu) {
        IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
        List<BaseSelectionListenerAction> finalActions = null;
        for (Iterator il = selection.iterator(); il.hasNext();) {
            Object obj = il.next();
            if (obj instanceof IRepositoryViewObject) {
                IRepositoryViewObject viewObj = (IRepositoryViewObject) obj;
                IRepositoryNodeConfiguration conf = RepositoryNodeConfigurationManager.getConfiguration(viewObj);
                if (conf != null) {
                    List<BaseSelectionListenerAction> actions = conf.getActionProvider().getActions(viewObj);
                    if (actions != null) {
                        if (finalActions == null) {
                            finalActions = actions;
                        }
                        finalActions = combineActions(finalActions, actions);
                        if (finalActions.size() == 0) {
                            return;
                        }
                    }
                }
            }
        }
        // hook action to menu
        for (IAction action : finalActions) {
            if (action instanceof IGroupAction) {
                IGroupAction groupAction = (IGroupAction) action;
                if (groupAction.getGroupName() != null) {
                    menu.appendToGroup(groupAction.getGroupName(), action);
                } else {
                    menu.add(action);
                }
            }
        }
    }

    private List<BaseSelectionListenerAction> combineActions(List<BaseSelectionListenerAction> actionsA,
            List<BaseSelectionListenerAction> actionsB) {
        List<BaseSelectionListenerAction> result = new LinkedList<BaseSelectionListenerAction>();
        for (Iterator<BaseSelectionListenerAction> il = actionsA.iterator(); il.hasNext();) {
            BaseSelectionListenerAction action = il.next();
            if (actionsB.contains(action)) {
                result.add(action);
            }
        }
        return result;
    }

}
