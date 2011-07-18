package org.talend.mdm.repository.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.talend.mdm.repository.ui.dialogs.RepositoryViewFilterDialog;

public class ConfigRepositoryFilterAction implements IViewActionDelegate {

    private IViewPart view;

    @Override
    public void run(IAction action) {
        RepositoryViewFilterDialog dialog = new RepositoryViewFilterDialog(view.getSite().getShell());
        dialog.open();
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
    }

    @Override
    public void init(IViewPart view) {
        this.view = view;
    }

}
