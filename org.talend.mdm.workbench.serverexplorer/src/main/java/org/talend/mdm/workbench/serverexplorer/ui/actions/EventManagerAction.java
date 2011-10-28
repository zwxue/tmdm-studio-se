package org.talend.mdm.workbench.serverexplorer.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.talend.mdm.workbench.serverexplorer.ui.views.ServerExplorer;

public class EventManagerAction implements IViewActionDelegate {

    ServerExplorer serverExplorer;

    public void run(IAction action) {
        if (serverExplorer != null) {
            serverExplorer.getEventManageAction().run();
        }
    }

    public void selectionChanged(IAction action, ISelection selection) {
    }

    public void init(IViewPart view) {

        if (view instanceof ServerExplorer) {
            serverExplorer = (ServerExplorer) view;
        }
    }

}
