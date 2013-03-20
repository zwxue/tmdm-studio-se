package org.talend.mdm.workbench.serverexplorer.console;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsolePageParticipant;
import org.eclipse.ui.part.IPageBookViewPage;


public class MDMServerConsolePageParticipant implements IConsolePageParticipant {

    public void init(IPageBookViewPage page, IConsole console) {
        IToolBarManager toolBar = page.getSite().getActionBars().getToolBarManager();
        toolBar.appendToGroup(IConsoleConstants.LAUNCH_GROUP, MDMServerConsoleFactory.getResumeAction());
        toolBar.appendToGroup(IConsoleConstants.LAUNCH_GROUP, MDMServerConsoleFactory.getDownloadAction());
    }

    public void dispose() {
        // TODO Auto-generated method stub

    }

    public void activated() {
        // TODO Auto-generated method stub

    }

    public void deactivated() {
        // TODO Auto-generated method stub

    }

    public Object getAdapter(Class adapter) {
        return null;
    }
}
