package org.talend.mdm.repository.ui.navigator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IRepositoryNodeActionProvider;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryViewGlobalActionHandler;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.ui.actions.OpenObjectAction;
import org.talend.mdm.repository.ui.actions.RefreshAction;

public class MDMRepositoryActionProvider extends CommonActionProvider implements IRepositoryViewGlobalActionHandler {

    private CommonViewer commonViewer;

    public MDMRepositoryActionProvider() {
        initActions();
    }

    private void initActions() {
        openObjectAction = new OpenObjectAction();
        refreshAction = new RefreshAction();
    }

    OpenObjectAction openObjectAction;

    AbstractRepositoryAction refreshAction;

    @Override
    public void init(ICommonActionExtensionSite aSite) {
        commonViewer = (CommonViewer) aSite.getStructuredViewer();
        for (IRepositoryNodeConfiguration conf : RepositoryNodeConfigurationManager.getConfigurations()) {
            IRepositoryNodeActionProvider actionProvider = conf.getActionProvider();
            if (actionProvider != null) {
                actionProvider.setRepositoryViewGlobalActionHandler(this);
                actionProvider.initCommonViewer(commonViewer);
            }
        }
        //
        openObjectAction.initCommonViewer(commonViewer);
        refreshAction.initCommonViewer(commonViewer);
    }

    @Override
    public void fillActionBars(IActionBars actionBars) {
        // open
        actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openObjectAction);
        actionBars.setGlobalActionHandler(REFRESH, refreshAction);
    }

    @Override
    public void fillContextMenu(IMenuManager menu) {
        IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
        List<AbstractRepositoryAction> finalActions = null;
        for (Iterator il = selection.iterator(); il.hasNext();) {
            Object obj = il.next();
            if (obj instanceof IRepositoryViewObject) {
                IRepositoryViewObject viewObj = (IRepositoryViewObject) obj;
                IRepositoryNodeConfiguration conf = RepositoryNodeConfigurationManager.getConfiguration(viewObj);
                if (conf != null && conf.getActionProvider() != null) {
                    List<AbstractRepositoryAction> actions = conf.getActionProvider().getActions(viewObj);
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
            if (action instanceof AbstractRepositoryAction) {
                AbstractRepositoryAction groupAction = (AbstractRepositoryAction) action;
                groupAction.selectionChanged(selection);
                if (groupAction.getGroupName() != null) {
                    menu.appendToGroup(groupAction.getGroupName(), action);
                } else {
                    menu.add(action);
                }
            }
        }

    }

    @Override
    public void updateActionBars() {
        IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
        openObjectAction.selectionChanged(selection);
        refreshAction.selectionChanged(selection);
    }

    private List<AbstractRepositoryAction> combineActions(List<AbstractRepositoryAction> actionsA,
            List<AbstractRepositoryAction> actionsB) {
        List<AbstractRepositoryAction> result = new LinkedList<AbstractRepositoryAction>();
        for (Iterator<AbstractRepositoryAction> il = actionsA.iterator(); il.hasNext();) {
            AbstractRepositoryAction action = il.next();
            if (actionsB.contains(action)) {
                result.add(action);
            }
        }
        return result;
    }

    public AbstractRepositoryAction getGlobalAction(String actionId) {
        if (actionId.equals(REFRESH)) {
            return refreshAction;
        }
        return null;
    }

}
