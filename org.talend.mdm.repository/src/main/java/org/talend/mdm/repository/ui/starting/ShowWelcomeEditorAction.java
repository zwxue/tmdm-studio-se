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
package org.talend.mdm.repository.ui.starting;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class ShowWelcomeEditorAction implements IWorkbenchWindowActionDelegate {

    public void run(IAction action) {
        ShowWelcomeEditor.showWelcomeEditor();
    }

    public void selectionChanged(IAction arg0, ISelection arg1) {
        System.out.println();
    }

    public void dispose() {
    }

    public void init(IWorkbenchWindow arg0) {
    }
}