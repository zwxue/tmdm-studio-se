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
package org.talend.mdm.repository.ui.dialogs.svn;

import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.talend.core.model.general.Project;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.repository.svnprovider.SvnHandler;
import org.tigris.subversion.javahl.DirEntry;

/**
 * DOC hbhong  class global comment. Detailled comment
 */
public class SVNSwitchBranchDialog extends org.talend.repository.svnprovider.ui.dialog.SVNSwitchDialog {

    /**
     * DOC hbhong SVNSwitchDialog constructor comment.
     * 
     * @param parentShell
     * @param view
     * @param dirEntryList
     * @param project
     * @param svnHandler
     * @param isSwitch
     * @param isForcopy
     */
    public SVNSwitchBranchDialog(Shell parentShell, List<DirEntry> dirEntryList, Project project, SvnHandler svnHandler,
            boolean isSwitch, boolean isForcopy) {
        super(parentShell, null, dirEntryList, project, svnHandler, isSwitch, isForcopy);

    }

    @Override
    protected void refreshView() {
        MDMRepositoryView.show().getCommonViewer().refresh();
    }

    @Override
    protected void beforeSwitchBranch() {
        ContainerCacheService.clearCache();
    }

}
