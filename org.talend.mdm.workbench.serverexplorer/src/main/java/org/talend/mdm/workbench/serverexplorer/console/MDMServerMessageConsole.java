// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.workbench.serverexplorer.console;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.internal.console.IOConsolePage;
import org.eclipse.ui.part.IPageBookViewPage;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.workbench.serverexplorer.plugin.MDMServerExplorerPlugin;

/**
 * created by Karelun Huang on Mar 19, 2013 Detailled comment
 *
 */
public class MDMServerMessageConsole extends MessageConsole implements IPropertyChangeListener {

    private static final int HTTP_STATUS_OK = 200;

    private static final int HTTP_STATUS_NO_ACCESS = 401;

    private static final int HTTP_STATUS_NOT_FOUND = 404;

    public class DownloadAction extends Action {

        public DownloadAction() {
            super("Download");
            ImageDescriptor IMG_EVENTMANAGER = MDMServerExplorerPlugin.imageDescriptorFromPlugin(
                    MDMServerExplorerPlugin.PLUGIN_ID, "icons/sub_engine.png"); //$NON-NLS-1$
            setImageDescriptor(IMG_EVENTMANAGER);
        }

        @Override
        public void run() {
            // C:\Users\talend-mdm
            String path = System.getProperty("user.home");
            download(path);
        }
    }

    public class ResumeAction extends Action {

        public ResumeAction() {
            super("Pause", IAction.AS_CHECK_BOX);
            ImageDescriptor IMG_CHECK_CONNECT = MDMServerExplorerPlugin.imageDescriptorFromPlugin(
                    MDMServerExplorerPlugin.PLUGIN_ID, "icons/client_network.png"); //$NON-NLS-1$
            setImageDescriptor(IMG_CHECK_CONNECT);
        }

        @Override
        public void run() {
            pauseOrResume(isChecked());
            updateActionText();
        }

        @Override
        public void setChecked(boolean checked) {
            super.setChecked(checked);
            updateActionText();
        }

        private void updateActionText() {
            String text = isChecked() ? "Resume" : "Pause";
            setText(text);
        }
    }

    public class ReloadAction extends Action {

        public ReloadAction() {
            super("Reload");
            ImageDescriptor IMG_REFRESH = MDMServerExplorerPlugin.imageDescriptorFromPlugin(MDMServerExplorerPlugin.PLUGIN_ID,
                    "icons/refresh.gif"); //$NON-NLS-1$
            setImageDescriptor(IMG_REFRESH);
        }

        @Override
        public void run() {
            reload();
        }
    }

    private ResumeAction resumeAction = null;

    private DownloadAction downloadAction = null;

    private ReloadAction reloadAction = null;

    private MDMServerDef serverDef = null;

    private Timer timer = null;

    private int position = 0;

    public MDMServerMessageConsole(MDMServerDef serverDef) {
        this("MDM Server Console", null);
        this.serverDef = serverDef;
        initConsoleName();
        PlatformUI.getPreferenceStore().addPropertyChangeListener(this);
    }

    public MDMServerMessageConsole(String name, ImageDescriptor imageDescriptor) {
        super(name, imageDescriptor);
    }

    public void setServerDef(MDMServerDef serverDef) {
        this.serverDef = serverDef;
        initConsoleName();
    }

    private void initConsoleName() {
        String address = serverDef.getHost() + ":" + serverDef.getPort();
        String name = "MDM Server Console( " + serverDef.getName() + " = " + address + " )";
        setName(name);
        // setWaterMarks(8000, 8000 + 8000);

        reloadAction = new ReloadAction();
        resumeAction = new ResumeAction();
        downloadAction = new DownloadAction();
    }

    @Override
    public IPageBookViewPage createPage(IConsoleView view) {
        IOConsolePage consolePage = new IOConsolePage(this, view) {

            @Override
            protected void contextMenuAboutToShow(IMenuManager menuManager) {
                super.contextMenuAboutToShow(menuManager);
                menuManager.add(new Separator());
                menuManager.add(reloadAction);
                menuManager.add(resumeAction);
                menuManager.add(downloadAction);
            }

            @Override
            public void dispose() {
                disposeTimer();
                PlatformUI.getPreferenceStore().removePropertyChangeListener(MDMServerMessageConsole.this);
                String serverDefId = MDMServerConsoleFactory.getMDMServerDefId(serverDef);
                MDMServerExplorerPlugin.getDefault().getServerToConsole().remove(serverDefId);
                MDMServerExplorerPlugin.getDefault().getServerToView().remove(serverDefId);
                ConsolePlugin.getDefault().getConsoleManager().removeConsoles(new IConsole[] { MDMServerMessageConsole.this });
                super.dispose();
            }
        };
        consolePage.setReadOnly();
        return consolePage;
    }

    // public void refreshContent() {
    // IConsoleView consoleView = showConsoleView();
    // consoleView.display(this);
    // }

    @Override
    public void activate() {
        // showConsoleView();
        super.activate();
        display();
    }

    private IConsoleView showConsoleView() {
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

    private void display() {
        position = 0;
        clearConsole();

        monitor();
    }

    private synchronized void monitor() {
        if (timer == null) {
            timer = new Timer(true);
        }
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                doMonitor();
            }
        }, 0, 1000/* getRefrehFrequency() */);
    }

    private void doMonitor() {
        DefaultHttpClient httpClient = createHttpClient();
        String monitorURL = buildMonitorURL(position);
        HttpGet httpGet = new HttpGet(monitorURL);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            // printHeader(response);
            int code = response.getStatusLine().getStatusCode();
            if (HTTP_STATUS_OK == code) {
                modifyChunkedPosition(response);
                if (isEndOfChunk(response)) {
                    return;
                }
                InputStream is = response.getEntity().getContent();
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                IOUtils.copy(is, os);
                String content = os.toString().trim();
                newMessageStream().println(content);
                // newMessageStream().println();
                is.close();
                os.close();
            } else if (HTTP_STATUS_NO_ACCESS == code) {
                newErrorMessageStream().println("This request requires HTTP authentication ().");
                disposeTimer();
            } else if (HTTP_STATUS_NOT_FOUND == code) {
                newErrorMessageStream().println("Can not connect the server.");
                disposeTimer();
            }
        } catch (IOException e) {
            newErrorMessageStream().println(e.getMessage());
            disposeTimer();
        }
    }

    private void printHeader(HttpResponse response) {
        Header[] allHeaders = response.getAllHeaders();
        for (Header header : allHeaders) {
            String name = header.getName();
            String value = header.getValue();
            System.out.println(name + " <> " + value);
        }
        System.out.println();
    }

    private void modifyChunkedPosition(HttpResponse response) {
        Header[] headers = response.getHeaders("X-Log-Position"); //$NON-NLS-1$
        Assert.isTrue(headers.length > 0);
        String value = headers[0].getValue();
        position = Integer.parseInt(value);
    }

    private boolean isEndOfChunk(HttpResponse response) {
        Header[] headers = response.getHeaders("Content-Length"); //$NON-NLS-1$
        if (headers == null || headers.length == 0) {
            return false;
        }
        String value = headers[0].getValue();
        return "0".equals(value); //$NON-NLS-1$
    }

    private DefaultHttpClient createHttpClient() {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        AuthScope authScope = new AuthScope(serverDef.getHost(), Integer.parseInt(serverDef.getPort()));
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(serverDef.getUser(), serverDef.getPasswd());
        httpclient.getCredentialsProvider().setCredentials(authScope, credentials);
        return httpclient;
    }

    private String buildMonitorURL(int pos) {
        StringBuilder sb = new StringBuilder();
        sb.append("http://"); //$NON-NLS-1$
        sb.append(serverDef.getHost());
        sb.append(":"); //$NON-NLS-1$
        sb.append(serverDef.getPort());
        sb.append("/datamanager/logviewer/log?position=" + pos); //$NON-NLS-1$
        sb.append("&maxLines=100"); //$NON-NLS-1$
        return sb.toString();
    }

    public void pauseOrResume(boolean paused) {
        if (paused) {
            disposeTimer();
        } else {
            monitor();
        }
    }

    public void reload() {
        disposeTimer();
        display();
    }

    public void download(String path) {
        try {
            DefaultHttpClient httpClient = createHttpClient();
            String monitorURL = buildDownloadURL();
            HttpGet httpGet = new HttpGet(monitorURL);
            HttpResponse response = httpClient.execute(httpGet);
            int code = response.getStatusLine().getStatusCode();
            if (HTTP_STATUS_OK == code) {
                String fileName = getFileName(response);
                InputStream is = response.getEntity().getContent();
                FileOutputStream os = new FileOutputStream(path + "\\" + fileName); //$NON-NLS-1$
                IOUtils.copy(is, os);
                is.close();
                os.close();
            } else if (HTTP_STATUS_NO_ACCESS == code) {
                newErrorMessageStream().println("This request requires HTTP authentication ().");
            } else if (HTTP_STATUS_NOT_FOUND == code) {
                newErrorMessageStream().println("Can not connect the server.");
            }
        } catch (IOException e) {
            newErrorMessageStream().println(e.getMessage());
        }
    }

    private String buildDownloadURL() {
        StringBuilder sb = new StringBuilder();
        sb.append("http://"); //$NON-NLS-1$
        sb.append(serverDef.getHost());
        sb.append(":"); //$NON-NLS-1$
        sb.append(serverDef.getPort());
        sb.append("/datamanager/logviewer/log"); //$NON-NLS-1$
        return sb.toString();
    }

    private String getFileName(HttpResponse response) {
        Header[] headers = response.getHeaders("Content-Disposition"); //$NON-NLS-1$
        Assert.isTrue(headers.length > 0);
        String value = headers[0].getValue();
        int begin = value.indexOf("\""); //$NON-NLS-1$
        int end = value.lastIndexOf("\""); //$NON-NLS-1$
        return value.substring(begin + 1, end);
    }

    private void disposeTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private MessageConsoleStream newErrorMessageStream() {
        final MessageConsoleStream msgStream = newMessageStream();
        ConsolePlugin.getStandardDisplay().asyncExec(new Runnable() {

            public void run() {
                msgStream.setColor(Display.getDefault().getSystemColor(SWT.COLOR_RED));
            }
        });
        return msgStream;
    }

    public void propertyChange(PropertyChangeEvent event) {
        if (event.getProperty().equals(MDMServerPreferenceInitializer.REFRESH_FREQ)) {
            disposeTimer();
            monitor();
        } else if (event.getProperty().equals(MDMServerPreferenceInitializer.DISPLAY_MAX_NUMBER)) {
            // TODO:
        }
    }

    private int getRefrehFrequency() {
        return PlatformUI.getPreferenceStore().getInt(MDMServerPreferenceInitializer.REFRESH_FREQ) * 1000;
    }

    private int getMaxDisplayedLines() {
        return PlatformUI.getPreferenceStore().getInt(MDMServerPreferenceInitializer.DISPLAY_MAX_NUMBER);
    }

    public ReloadAction getReloadAction() {
        return this.reloadAction;
    }

    public ResumeAction getResumeAction() {
        return this.resumeAction;
    }

    public DownloadAction getDownloadAction() {
        return this.downloadAction;
    }
}
