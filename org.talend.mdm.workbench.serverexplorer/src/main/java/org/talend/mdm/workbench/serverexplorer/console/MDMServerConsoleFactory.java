package org.talend.mdm.workbench.serverexplorer.console;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.workbench.serverexplorer.core.ServerDefService;
import org.talend.mdm.workbench.serverexplorer.plugin.MDMServerExplorerPlugin;

/**
 *
 * created by Karelun Huang on Mar 20, 2013 Detailled comment
 *
 */
public class MDMServerConsoleFactory implements IConsoleFactory {

    public static class DownloadAction extends Action {

        public DownloadAction() {
            super("Download");
            ImageDescriptor IMG_EVENTMANAGER = MDMServerExplorerPlugin.imageDescriptorFromPlugin(
                    MDMServerExplorerPlugin.PLUGIN_ID, "icons/sub_engine.png"); //$NON-NLS-1$
            setImageDescriptor(IMG_EVENTMANAGER);
        }

        @Override
        public void run() {
            if (mdmServerConsole == null) {
                return;
            }
            // C:\Users\talend-mdm
            String path = System.getProperty("user.home");
            mdmServerConsole.download(path);
        }
    }

    public static class ResumeAction extends Action {

        public ResumeAction() {
            super("Pause", IAction.AS_CHECK_BOX);
            ImageDescriptor IMG_CHECK_CONNECT = MDMServerExplorerPlugin.imageDescriptorFromPlugin(
                    MDMServerExplorerPlugin.PLUGIN_ID, "icons/client_network.png"); //$NON-NLS-1$
            setImageDescriptor(IMG_CHECK_CONNECT);
        }

        @Override
        public void run() {
            if (mdmServerConsole != null) {
                mdmServerConsole.pauseOrResume(isChecked());
            }
            updateActionText();
        }

        private void updateActionText() {
            String text = isChecked() ? "Resume" : "Pause";
            setText(text);
        }
    }

    private static MDMServerMessageConsole mdmServerConsole = null;

    private static ResumeAction resumeAction = null;

    private static DownloadAction downloadAction = null;

    public void openConsole() {
        List<MDMServerDef> allServerDefs = ServerDefService.getAllServerDefs();
        if (allServerDefs == null) {
            return;
        }
        // TODO: choose one server.
        MDMServerDef serverDef = allServerDefs.get(0).getDecryptedServerDef();
        showMDMServerConsole(serverDef);
    }

    public static void showMDMServerConsole(MDMServerDef serverDef) {
        if (mdmServerConsole == null) {
            mdmServerConsole = new MDMServerMessageConsole(serverDef);
        } else {
            mdmServerConsole.setServerDef(serverDef);
        }
        IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
        if (!containedMDMServerMessageConsole(consoleManager)) {
            consoleManager.addConsoles(new IConsole[] { mdmServerConsole });
        }
        consoleManager.showConsoleView(mdmServerConsole);
        getResumeAction().setChecked(false);
        mdmServerConsole.display();
    }

    private static boolean containedMDMServerMessageConsole(IConsoleManager consoleManager) {
        IConsole[] consoles = consoleManager.getConsoles();
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

    public static ResumeAction getResumeAction() {
        if (resumeAction == null) {
            resumeAction = new ResumeAction();
        }
        return resumeAction;
    }

    public static DownloadAction getDownloadAction() {
        if (downloadAction == null) {
            downloadAction = new DownloadAction();
        }
        return downloadAction;
    }
}
