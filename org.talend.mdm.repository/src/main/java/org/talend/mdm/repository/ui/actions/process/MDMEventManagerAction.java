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
package org.talend.mdm.repository.ui.actions.process;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.editors.XObjectBrowser2;
import org.talend.mdm.repository.ui.editors.XObjectBrowserInput2;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.mdm.workbench.serverexplorer.ui.actions.IEventMgrService;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

public class MDMEventManagerAction extends AbstractRepositoryAction  implements IEventMgrService{

    private static Log log = LogFactory.getLog(MDMEventManagerAction.class);

    private IWorkbenchPage page = null;

    private static final ImageDescriptor EM_IMG = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "/icons/sub_engine.png"); //$NON-NLS-1$

    public MDMEventManagerAction() {
        super(Messages.EventManager_text);
        setImageDescriptor(EM_IMG);
    }

    protected void doRun() {
        SelectServerDefDialog dlg = new SelectServerDefDialog(getShell());
        dlg.create();
        if (dlg.open() == IDialogConstants.OK_ID) {
            XObjectBrowserInput2 input = new XObjectBrowserInput2();
            input.setServerDef(dlg.getSelectedServerDef());
            if (page == null)
                this.page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            try {
                this.page.openEditor(input, XObjectBrowser2.EDITOR_ID);
            } catch (PartInitException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    public String getGroupName() {
        return GROUP_COMMON;
    }
    
    @Override
    protected Shell getShell() {
    	Shell shell = super.getShell();
    	if(shell == null)
    		shell = new Shell(Display.getCurrent());
    	
		return shell;
    }

}
