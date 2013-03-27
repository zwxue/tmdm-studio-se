package org.talend.mdm.workbench.serverexplorer.console;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
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
import org.talend.mdm.workbench.serverexplorer.i18n.Messages;
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
            MessageDialog.openInformation(null, Messages.ShowMDMServerConsole_InfoDialog_Title, Messages.ShowMDMServerConsole_InfoDialog_Message);
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
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            return;
        }
        IWorkbenchPage page = window.getActivePage();
        if (page == null) {
            return;
        }
        Map<String, MDMServerMessageConsole> serverToConsole = MDMServerExplorerPlugin.getDefault().getServerToConsole();
        MDMServerMessageConsole mdmServerConsole = serverToConsole.get(serverDef.getName());
        if (mdmServerConsole == null) {
            mdmServerConsole = new MDMServerMessageConsole(serverDef);
            serverToConsole.put(serverDef.getName(), mdmServerConsole);
        }
        // IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
        // IConsole[] consoles = serverToConsole.values().toArray(new IConsole[0]);
        // consoleManager.addConsoles(consoles);

        if (!containedMDMServerMessageConsole(mdmServerConsole)) {
            IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
            consoleManager.addConsoles(new IConsole[] { mdmServerConsole });
        }
        Map<String, IConsoleView> serverToView = MDMServerExplorerPlugin.getDefault().getServerToView();
        IConsoleView consoleView = serverToView.get(serverDef.getName());
        if (consoleView == null) {
            consoleView = showConsoleView(serverDef);
            Assert.isNotNull(consoleView);
            serverToView.put(serverDef.getName(), consoleView);
        }
        mdmServerConsole.activate();
    }

    private IConsoleView showConsoleView(MDMServerDef serverDef) {
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            return null;
        }
        IWorkbenchPage page = window.getActivePage();
        if (page == null) {
            return null;
        }
        try {
            return (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW, serverDef.getName(),
                    IWorkbenchPage.VIEW_ACTIVATE);
        } catch (PartInitException e) {
            e.printStackTrace();
        }
        return null;
    }

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
}
