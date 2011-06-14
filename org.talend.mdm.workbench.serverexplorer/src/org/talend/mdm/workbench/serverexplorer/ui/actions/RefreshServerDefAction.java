package org.talend.mdm.workbench.serverexplorer.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.talend.mdm.workbench.serverexplorer.ui.views.ServerExplorer;

public class RefreshServerDefAction implements IViewActionDelegate {

    ServerExplorer serverExplorer;

    @Override
    public void run(IAction action) {
        if (serverExplorer != null) {
            serverExplorer.refreshServerDefs();
        }
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
    }

    @Override
    public void init(IViewPart view) {

        if (view instanceof ServerExplorer) {
            serverExplorer = (ServerExplorer) view;
        }
    }

}
