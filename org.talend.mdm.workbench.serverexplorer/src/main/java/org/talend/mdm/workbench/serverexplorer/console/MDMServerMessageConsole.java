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
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.internal.console.IOConsolePage;
import org.eclipse.ui.part.IPageBookViewPage;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;

/**
 * created by Karelun Huang on Mar 19, 2013 Detailled comment
 *
 */
public class MDMServerMessageConsole extends MessageConsole {

    private static final int HTTP_STATUS_OK = 200;

    private static final int HTTP_STATUS_NO_ACCESS = 401;

    private static final int HTTP_STATUS_NOT_FOUND = 404;

    private MDMServerDef serverDef = null;

    private Timer timer = null;

    private int position = 0;

    public MDMServerMessageConsole() {
        this("MDM Server Console", null);
    }

    public MDMServerMessageConsole(MDMServerDef serverDef) {
        this("MDM Server Console", null);
        this.serverDef = serverDef;
        initServerConsole();
    }

    public MDMServerMessageConsole(String name, ImageDescriptor imageDescriptor) {
        super(name, imageDescriptor);
    }

    public void setServerDef(MDMServerDef serverDef) {
        this.serverDef = serverDef;
        initServerConsole();
    }

    private void initServerConsole() {
        String address = serverDef.getHost() + ":" + serverDef.getPort();
        String name = "MDM Server Console(" + serverDef.getName() + "=" + address + ")";
        setName(name);
    }

    @Override
    public IPageBookViewPage createPage(IConsoleView view) {
        IOConsolePage consolePage = new IOConsolePage(this, view) {

            @Override
            protected void contextMenuAboutToShow(IMenuManager menuManager) {
                super.contextMenuAboutToShow(menuManager);
                menuManager.add(new Separator());
                menuManager.add(MDMServerConsoleFactory.getResumeAction());
                menuManager.add(MDMServerConsoleFactory.getDownloadAction());
            }

            @Override
            public void dispose() {
                disposeTimer();
                super.dispose();
            }
        };
        consolePage.setReadOnly();
        return consolePage;
    }

    public void display() {
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
        }, 0, 1000);
    }

    private void doMonitor() {
        DefaultHttpClient httpClient = createHttpClient();
        String monitorURL = buildMonitorURL() + position;
        HttpGet httpGet = new HttpGet(monitorURL);
        try {
            HttpResponse response = httpClient.execute(httpGet);
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

    private String buildMonitorURL() {
        StringBuilder sb = new StringBuilder();
        sb.append("http://"); //$NON-NLS-1$
        sb.append(serverDef.getHost());
        sb.append(":"); //$NON-NLS-1$
        sb.append(serverDef.getPort());
        sb.append("/datamanager/logviewer/log?position="); //$NON-NLS-1$
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
            String monitorURL = buildMonitorURL() + -1;
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
        Display.getDefault().syncExec(new Runnable() {

            public void run() {
                msgStream.setColor(Display.getDefault().getSystemColor(SWT.COLOR_RED));
            }
        });
        return msgStream;
    }
}
