package org.talend.mdm.workbench.serverexplorer.console;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.workbench.serverexplorer.core.ServerDefService;
import org.talend.mdm.workbench.serverexplorer.plugin.MDMServerExplorerPlugin;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

/**
 *
 * created by Karelun Huang on Mar 20, 2013 Detailled comment
 *
 */
public class MDMServerConsoleFactory implements IConsoleFactory {

    public void openConsole() {
        List<MDMServerDef> allServerDefs = ServerDefService.getAllServerDefs();
        if (allServerDefs == null || allServerDefs.isEmpty()) {
            MessageDialog.openInformation(null, "Dialog", "No MDM Server been connected by studio");
        } else if (allServerDefs.size() == 1) {
            MDMServerDef serverDef = allServerDefs.get(0).getDecryptedServerDef();
            showMDMServerConsole(serverDef);
        } else {
            SelectServerDefDialog d = new SelectServerDefDialog(new Shell());
            d.create();
            d.setSelectServer(allServerDefs.get(0));
            if (d.open() == IDialogConstants.OK_ID) {
                MDMServerDef serverDef = d.getSelectedServerDef();
                showMDMServerConsole(serverDef);
            }
        }
    }

    public void showMDMServerConsole(MDMServerDef serverDef) {
        String serverDefId = getMDMServerDefId(serverDef);
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            return;
        }
        IWorkbenchPage page = window.getActivePage();
        if (page == null) {
            return;
        }
        Map<String, MDMServerMessageConsole> serverToConsole = MDMServerExplorerPlugin.getDefault().getServerToConsole();
        MDMServerMessageConsole mdmServerConsole = serverToConsole.get(serverDefId);
        if (mdmServerConsole == null) {
            mdmServerConsole = new MDMServerMessageConsole(serverDef);
            serverToConsole.put(serverDefId, mdmServerConsole);
        }
        if (!containedMDMServerMessageConsole(mdmServerConsole)) {
            IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
            consoleManager.addConsoles(new IConsole[] { mdmServerConsole });
        }
        mdmServerConsole.activate();
    }

    private boolean activeConsoleView(MDMServerDef serverDef) {
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            return false;
        }
        IWorkbenchPage page = window.getActivePage();
        if (page == null) {
            return false;
        }
        String serverDefId = getMDMServerDefId(serverDef);
        Map<String, IConsoleView> serverToView = MDMServerExplorerPlugin.getDefault().getServerToView();
        IConsoleView consoleView = serverToView.get(serverDefId);
        if (consoleView == null) {
            try {
                String secondaryId = serverDef.getHost() + "#" + serverDef.getPort(); //$NON-NLS-1$
                consoleView = (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW, secondaryId,
                        IWorkbenchPage.VIEW_ACTIVATE);
                serverToView.put(serverDefId, consoleView);
            } catch (PartInitException e) {
                e.printStackTrace();
            }
        } else {
            page.activate(consoleView);
        }
        return true;
    }

    private IConsoleView createConsoleView(MDMServerDef serverDef) {
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            return null;
        }
        IWorkbenchPage page = window.getActivePage();
        if (page == null) {
            return null;
        }
        try {
            String secondaryId = serverDef.getHost() + "#" + serverDef.getPort(); //$NON-NLS-1$
            IConsoleView consoleView = (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW, secondaryId,
                    IWorkbenchPage.VIEW_ACTIVATE);
            return consoleView;
        } catch (PartInitException e) {
            e.printStackTrace();
        }
        return null;
    }

    // private IConsoleView findConsoleView(Map<MDMServerDef, IConsoleView> serverToView, MDMServerDef serverDef) {
    // for (Entry<MDMServerDef, IConsoleView> entry : serverToView.entrySet()) {
    // if (theSameServer(entry.getKey(), serverDef)) {
    // return entry.getValue();
    // }
    // }
    // return null;
    // }
    //
    // private MDMServerMessageConsole findMDMServerConsole(Map<MDMServerDef, MDMServerMessageConsole> serverToConsole,
    // MDMServerDef serverDef) {
    // for (Entry<MDMServerDef, MDMServerMessageConsole> entry : serverToConsole.entrySet()) {
    // if (theSameServer(entry.getKey(), serverDef)) {
    // return entry.getValue();
    // }
    // }
    // return null;
    // }
    //
    // private boolean theSameServer(MDMServerDef key, MDMServerDef serverDef) {
    // // TODO:
    // String host1 = key.getHost();
    // String host2 = serverDef.getHost();
    // String port1 = key.getPort();
    // String port2 = serverDef.getPort();
    // return host1.equals(host2) && port1.equals(port2);
    // }

    private boolean containedMDMServerMessageConsole(IConsole mdmServerConsole) {
        IConsole[] consoles = ConsolePlugin.getDefault().getConsoleManager().getConsoles();
        if (consoles == null || consoles.length == 0) {
            return false;
        }
        for (IConsole console : consoles) {
            if (console == mdmServerConsole) {
                return true;
            }
        }
        return false;
    }

    public static String getMDMServerDefId(MDMServerDef serverDef) {
        return serverDef.getHost() + ":" + serverDef.getPort(); //$NON-NLS-1$
    }
}
