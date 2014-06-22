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
package com.amalto.workbench.editors;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.talend.mdm.commmon.util.core.ICoreConstants;
import org.w3c.dom.Node;

import com.amalto.workbench.dialogs.PluginDetailsDialog;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XmlUtil;
import com.amalto.workbench.webservices.WSCheckServiceConfigRequest;
import com.amalto.workbench.webservices.WSCheckServiceConfigResponse;
import com.amalto.workbench.webservices.WSGetServicesList;
import com.amalto.workbench.webservices.WSPutVersioningSystemConfiguration;
import com.amalto.workbench.webservices.WSServiceGetDocument;
import com.amalto.workbench.webservices.WSServicePutConfiguration;
import com.amalto.workbench.webservices.WSServicesList;
import com.amalto.workbench.webservices.WSServicesListItem;
import com.amalto.workbench.webservices.WSString;
import com.amalto.workbench.webservices.WSVersioningSystemConfiguration;
import com.amalto.workbench.webservices.XtentisPort;
import com.sun.xml.bind.StringInputStream;

public class ServiceConfigrationMainPage extends AMainPageV2 {

    private static Log log = LogFactory.getLog(ServiceConfigrationMainPage.class);

    protected Combo serviceNameCombo;

    protected Text serviceConfigurationsText;

    private Button defultParameterBtn;

    private Button checkButton;

    protected XtentisPort port;

    protected WSServiceGetDocument document;

    protected WSServicePutConfiguration ws = new WSServicePutConfiguration();

    protected Text errorLabel;

    protected static final String CHECKMSG_NOSELECTION = ""; //$NON-NLS-1$

    protected static final String CHECKMSG_SUCCESSFULCONN = Messages.ServiceConfigrationMainPage_1;

    protected static final String CHECKMSG_ERRORCONN = Messages.ServiceConfigrationMainPage_2;

    public ServiceConfigrationMainPage(FormEditor editor) {
        super(editor, ServiceConfigrationMainPage.class.getName(), ((XObjectEditorInput) editor.getEditorInput()).getName());
    }

    protected void setForConfigureContent(String serviceName) {

        try {
            if (serviceName != null && !"".equals(serviceName)) {//$NON-NLS-1$
                document = port.getServiceDocument(new WSString(serviceName.trim()));
                String documentConfigure = ServiceConfigrationMainPage.formartXml(document.getConfigure());
                serviceConfigurationsText.setText(documentConfigure);
                errorLabel.setText("");//$NON-NLS-1$
            }
        } catch (RemoteException e1) {
            log.error(e1.getMessage(), e1);
        }

    }

    protected void setForServiceNameCombo() {
        try {
            port = Util.getPort(getXObject());
            WSServicesList list = port.getServicesList(new WSGetServicesList(""));//$NON-NLS-1$
            WSServicesListItem[] items = list.getItem();
            if (items != null) {
                String[] sortedList = new String[items.length];
                for (int i = 0; i < items.length; i++) {
                    sortedList[i] = items[i].getJndiName();
                }
                Arrays.sort(sortedList);
                for (int i = 0; i < sortedList.length; i++) {
                    WSServiceGetDocument doc = port.getServiceDocument(new WSString(sortedList[i].trim()));
                    if (doc.getConfigureSchema() == null || doc.getConfigureSchema().length() == 0)
                        continue;
                    serviceNameCombo.add(sortedList[i]);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

    protected String getDoc() {
        try {
            WSServiceGetDocument doc = getServiceDocument(serviceNameCombo.getText());
            return doc.getDefaultConfig();
        } catch (RemoteException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    protected String getDesc() {
        try {
            WSServiceGetDocument doc = getServiceDocument(serviceNameCombo.getText());
            return doc.getDescription();
        } catch (RemoteException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    protected WSServiceGetDocument getServiceDocument(String jndiName) throws RemoteException {

        // return port.getServiceDocument(new WSString(serviceNameCombo.getText().trim()));
        return port.getServiceDocument(new WSString(jndiName.trim()));
    }

    @Override
    protected void createCharacteristicsContent(FormToolkit toolkit, Composite charSection) {

        // Routing Expressions
        Composite serviceGroup = this.getNewSectionComposite(Messages.ServiceConfigrationMainPage_3);
        serviceGroup.setLayout(new GridLayout(2, false));
        // Service Name
        Label serviceNameLabel = toolkit.createLabel(serviceGroup, Messages.ServiceConfigrationMainPage_4, SWT.NULL);
        serviceNameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));

        Composite subPanel = toolkit.createComposite(serviceGroup);
        subPanel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
        subPanel.setLayout(new GridLayout(2, false));
        serviceNameCombo = new Combo(subPanel, SWT.DROP_DOWN | SWT.SINGLE | SWT.READ_ONLY);
        serviceNameCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
        ((GridData) serviceNameCombo.getLayoutData()).widthHint = 300;
        serviceNameCombo.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                String serviceName = serviceNameCombo.getText();
                setRefreshing(true);
                setForConfigureContent(serviceName);
                setRefreshing(false);
                // markDirty();
            }
        });

        setForServiceNameCombo();
        // default parameters button
        defultParameterBtn = toolkit.createButton(subPanel, "", SWT.PUSH);//$NON-NLS-1$
        defultParameterBtn.setImage(ImageCache.getCreatedImage(EImage.HELP_CONTENTS.getPath()));
        defultParameterBtn.setToolTipText(Messages.ServiceConfigrationMainPage_5);
        defultParameterBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
        defultParameterBtn.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
            };

            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                if (serviceNameCombo.getText().trim().length() == 0)
                    return;
                String doc = "";//$NON-NLS-1$
                String desc = "";//$NON-NLS-1$

                try {

                    desc = getDesc();
                    doc = getDoc();

                } catch (Exception e1) {
                    doc = "N/A";//$NON-NLS-1$
                } finally {
                    showUpDialog(desc, doc);
                }
            };

            private void showUpDialog(String desc, String doc) {

                final PluginDetailsDialog dialog = new PluginDetailsDialog(getSite().getShell(), desc, doc, null,
                        Messages.ServiceConfigrationMainPage_6);
                dialog.addListener(new Listener() {

                    public void handleEvent(Event event) {
                        dialog.close();
                    }
                });
                dialog.create();
                dialog.getShell().setText(serviceNameCombo.getText() + Messages.ServiceConfigrationMainPage_7);
                dialog.setBlockOnOpen(true);
                dialog.open();
            }

        });

        // Service Parameters
        Label serviceConfigurationsLabel = toolkit.createLabel(serviceGroup, Messages.ServiceConfigrationMainPage_8, SWT.NULL);
        serviceConfigurationsLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 2, 1));
        serviceConfigurationsText = toolkit.createText(serviceGroup, "", SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);//$NON-NLS-1$

        serviceConfigurationsText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
        ((GridData) serviceConfigurationsText.getLayoutData()).widthHint = 200;
        ((GridData) serviceConfigurationsText.getLayoutData()).heightHint = 120;

        serviceConfigurationsText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                if (isRefreshing())
                    return;
                markDirtyWithoutCommit();
            }
        });
        checkButton = toolkit.createButton(serviceGroup, Messages.ServiceConfigrationMainPage_9, SWT.NONE);
        checkButton.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {

                String msg = getContentsCheckResult();

                errorLabel.setForeground(CHECKMSG_SUCCESSFULCONN.equals(msg) ? errorLabel.getDisplay().getSystemColor(
                        SWT.COLOR_BLUE) : errorLabel.getDisplay().getSystemColor(SWT.COLOR_RED));
                errorLabel.setText(msg);
            }
        });
        errorLabel = new Text(serviceGroup, SWT.WRAP);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gd.heightHint = 400;
        errorLabel.setLayoutData(gd);

    }

    public static String formartXml(String doc) {
        // format output
        if (doc != null && doc.length() > 0) {
            try {
                doc = XmlUtil.formatPretty(doc, "UTF-8");//$NON-NLS-1$
            } catch (DocumentException e) {
                log.error(e.getMessage(), e);
            }
        }
        return doc;
    }

    protected void doSaveChanges() {

        try {
            if (!"".equalsIgnoreCase(ws.getJndiName()) && !"".equalsIgnoreCase(ws.getConfiguration())) {//$NON-NLS-1$//$NON-NLS-2$
                port.putServiceConfiguration(ws);
                // there maybe several svn settings, so we need to put it on VersionSystem
                if (serviceNameCombo.getText().equalsIgnoreCase("svn")) {//$NON-NLS-1$
                    port.putVersioningSystemConfiguration(getDefaultSvn(serviceConfigurationsText.getText()));
                }
            }
        } catch (Exception e1) {
            log.error(e1.getMessage(), e1);
        }

    }

    protected void saveChanges() {
        ws.setJndiName(serviceNameCombo.getText().contains("/") ? serviceNameCombo.getText() : "amalto/local/service/"//$NON-NLS-1$//$NON-NLS-2$
                + serviceNameCombo.getText());
        ws.setConfiguration(serviceConfigurationsText.getText());

        doSaveChanges();
    }

    private WSPutVersioningSystemConfiguration getDefaultSvn(String svnConfig) throws Exception {
        Node e = Util.parse(svnConfig).getDocumentElement();
        String jndi = serviceNameCombo.getText().contains("/") ? serviceNameCombo.getText() : "amalto/local/service/"//$NON-NLS-1$//$NON-NLS-2$
                + serviceNameCombo.getText();
        String url = Util.getFirstTextNode(e, "./url");//$NON-NLS-1$
        String username = Util.getFirstTextNode(e, "./username");//$NON-NLS-1$
        String password = Util.getFirstTextNode(e, "./password");//$NON-NLS-1$
        String autocommit = Util.getFirstTextNode(e, "./autocommit");//$NON-NLS-1$
        WSPutVersioningSystemConfiguration conf = new WSPutVersioningSystemConfiguration(new WSVersioningSystemConfiguration(
                ICoreConstants.DEFAULT_SVN, ICoreConstants.DEFAULT_SVN, url, username, password, autocommit, jndi));
        return conf;
    }

    @Override
    protected void commit() {
    }

    @Override
    protected void createActions() {

    }

    @Override
    protected void refreshData() {

    }

    @Override
    public void doSave(IProgressMonitor monitor) {

        String msg = checkValidXML();

        if (msg != null) {
            MessageDialog.openError(getSite().getShell(), Messages._Error, msg);
            return;
        }

        saveChanges();
        super.doSave(monitor);
    }

    protected String getContentsCheckResult() {

        if (serviceNameCombo.getText().trim().length() == 0)
            return CHECKMSG_NOSELECTION;

        WSCheckServiceConfigResponse result;
        try {
            result = port.checkServiceConfiguration(new WSCheckServiceConfigRequest(serviceNameCombo.getText().trim(),
                    serviceConfigurationsText.getText()));

            if (result.getCheckResult()) {
                return CHECKMSG_SUCCESSFULCONN;
            } else {
                return CHECKMSG_ERRORCONN;
            }
        } catch (RemoteException e) {
            log.error(e.getMessage(), e);
            return e.getLocalizedMessage();
        }
    }

    private String checkValidXML() {

        if (serviceConfigurationsText == null)
            return null;

        StringInputStream inStream = null;

        try {
            inStream = new StringInputStream(serviceConfigurationsText.getText());
            XmlUtil.parse(inStream);
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            if (inStream != null)
                try {
                    inStream.close();
                } catch (IOException e) {

                }
        }

        return null;

    }
}
