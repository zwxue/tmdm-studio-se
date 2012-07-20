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
package org.talend.mdm.repository.ui.starting.actions;

import java.util.Properties;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroSite;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.workbench.serverexplorer.ui.views.ServerExplorer;


public abstract class AbstractShowViewAction {
    public abstract void run(IIntroSite arg0, Properties arg1);
    
    protected ServerExplorer showServerExplorer() throws PartInitException {
        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        ServerExplorer serverExplorer = (ServerExplorer) activePage.findView(ServerExplorer.ID);

        if (serverExplorer == null) {
            serverExplorer = (ServerExplorer) activePage.showView(ServerExplorer.ID);
        }
        
        activePage.activate(serverExplorer);
        
        serverExplorer.setFocus();
        return serverExplorer;
    }
    
    protected MDMRepositoryView showRepositoryView() throws PartInitException {
        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        MDMRepositoryView findView = (MDMRepositoryView) activePage.findView(MDMRepositoryView.VIEW_ID);
        if(findView == null)
            findView = (MDMRepositoryView) activePage.showView(MDMRepositoryView.VIEW_ID);
        
        activePage.activate(findView);
        
        findView.setFocus();
        
        return findView;
    }
}
