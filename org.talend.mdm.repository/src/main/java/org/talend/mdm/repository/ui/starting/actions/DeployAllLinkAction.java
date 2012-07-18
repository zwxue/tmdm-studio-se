package org.talend.mdm.repository.ui.starting.actions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;
import org.talend.mdm.repository.ui.actions.DeployAllAction;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;


public class DeployAllLinkAction implements IIntroAction {
    private static Logger log = Logger.getLogger(DeployAllLinkAction.class);
    
    public void run(IIntroSite introSite, Properties prop) {
        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        MDMRepositoryView findView = (MDMRepositoryView) activePage.findView(MDMRepositoryView.VIEW_ID);
        try {
            if(findView == null)
                findView = (MDMRepositoryView) activePage.showView(MDMRepositoryView.VIEW_ID);
            findView.setFocus();
            
            DeployAllAction deployAllAction = findView.getDeployAllAction();
            deployAllAction.runWithType(null);
            
        } catch (PartInitException e) {
            log.error(e.getMessage(), e);
        }
    }

}
