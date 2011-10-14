// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions.svn;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.general.Project;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.dialogs.svn.SVNSwitchBranchDialog;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.svnprovider.SvnHandler;
import org.talend.repository.svnprovider.utils.SVNUtil;
import org.tigris.subversion.javahl.DirEntry;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class SVNSwitchBranchAction extends AbstractRepositoryAction {

    private static final ImageDescriptor ICON = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "/icons/branches.gif"); //$NON-NLS-1$

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    private static Logger log = Logger.getLogger(SVNSwitchBranchAction.class);

    /**
     * DOC hbhong SVNLockAction constructor comment.
     * 
     * @param text
     */
    public SVNSwitchBranchAction() {
        super("Switch Branch");
        setImageDescriptor(ICON);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.AbstractRepositoryAction#getGroupName()
     */
    @Override
    public String getGroupName() {

        return GROUP_SVN;
    }

    @Override
    public void run() {
        SvnHandler svnHandler;

        Project project;

        List<DirEntry> dirEntryList;
        SVNUtil svnUtil = new SVNUtil();
        svnHandler = svnUtil.getSvnHandler();
        dirEntryList = svnUtil.getDirEntryList();
        project = svnUtil.getProject();
        IWorkbenchWindow workBench = PlatformUI.getWorkbench().getActiveWorkbenchWindow();// .getActivePage().getEditorReferences();
        if (workBench != null) {
            IWorkbenchPage page = workBench.getActivePage();
            IEditorReference[] editors = page.getEditorReferences();
            if (editors.length > 0) {
                MessageBox box = new MessageBox(Display.getCurrent().getActiveShell(), SWT.ICON_WORKING | SWT.OK);
                box.setText("Warning");
                box.setMessage("All editors must be closed!");
                box.open();
                return;
            }
        }
        List<DirEntry> dirList = new ArrayList<DirEntry>();
        String currentBranch = svnUtil.getCurrentBranch();
        for (DirEntry entry : dirEntryList) {
            if (!entry.getPath().equals(currentBranch)) {
                dirList.add(entry);
            }
        }
        Shell activeShell = Display.getCurrent().getActiveShell();
        SVNSwitchBranchDialog dialog = new SVNSwitchBranchDialog(activeShell, dirList, project, svnHandler, true, false);
        dialog.open();
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
        IViewPart viewPart = page.findView("org.talend.core.tis.showchanges.ui.view.CompareResultView");
        if (viewPart != null) {
            page.hideView(viewPart);
        }
    }

    @Override
    public boolean isVisible(IRepositoryViewObject viewObj) {

        try {
            if (factory.isLocalConnectionProvider())
                return false;
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }

        return true;
    }

}
