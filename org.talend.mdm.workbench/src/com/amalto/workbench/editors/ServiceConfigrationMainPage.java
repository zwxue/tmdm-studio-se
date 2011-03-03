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
package com.amalto.workbench.editors;

import java.rmi.RemoteException;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentException;
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

public class ServiceConfigrationMainPage extends AMainPageV2 {

    private static Log log = LogFactory.getLog(ServiceConfigrationMainPage.class);

    private Combo serviceNameCombo;

    protected Text serviceConfigurationsText;

    private Button defultParameterBtn;

    private Button checkButton;

    private XtentisPort port;

    protected WSServiceGetDocument document;

    private boolean refreshing = false;

    private WSServicePutConfiguration ws = new WSServicePutConfiguration();

    private Text errorLabel;

    public ServiceConfigrationMainPage(FormEditor editor) {
        super(editor, ServiceConfigrationMainPage.class.getName(), ((XObjectEditorInput) editor.getEditorInput()).getName());
    }

    @Override
    protected void createCharacteristicsContent(FormToolkit toolkit, Composite charSection) {

        // Routing Expressions
        Composite serviceGroup = this.getNewSectionComposite("Services List");
        serviceGroup.setLayout(new GridLayout(2, false));
        // Service Name
        Label serviceNameLabel = toolkit.createLabel(serviceGroup, "Service", SWT.NULL);
        serviceNameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));

        Composite subPanel = toolkit.createComposite(serviceGroup);
        subPanel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
        subPanel.setLayout(new GridLayout(2, false));
        serviceNameCombo = new Combo(subPanel, SWT.DROP_DOWN | SWT.SINGLE | SWT.READ_ONLY);
        serviceNameCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
        ((GridData) serviceNameCombo.getLayoutData()).widthHint = 300;
        serviceNameCombo.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                if (refreshing)
                    return;
                String serviceName = serviceNameCombo.getText();
                try {
                    if (serviceName != null && !"".equals(serviceName)) {//$NON-NLS-1$
                        document = port.getServiceDocument(new WSString(serviceName.trim()));
                        String documentConfigure = ServiceConfigrationMainPage.this.formartXml(document.getConfigure());
                        serviceConfigurationsText.setText(documentConfigure);
                        errorLabel.setText("");//$NON-NLS-1$
                    }
                } catch (RemoteException e1) {
                    log.error(e1.getMessage(), e1);
                }
                markDirty();
            }
        });
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
                    WSServiceGetDocument document = port.getServiceDocument(new WSString(sortedList[i].trim()));
                    if (document.getConfigureSchema() == null || document.getConfigureSchema().length() == 0)
                        continue;
                    serviceNameCombo.add(sortedList[i]);
                }
                // serviceNameCombo.add("");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        // default parameters button
        defultParameterBtn = toolkit.createButton(subPanel, "", SWT.PUSH);//$NON-NLS-1$
        defultParameterBtn.setImage(ImageCache.getCreatedImage(EImage.HELP_CONTENTS.getPath()));
        defultParameterBtn.setToolTipText("Help...");
        defultParameterBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
        defultParameterBtn.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
            };

            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                if (serviceNameCombo.getText().trim().length() == 0)
                    return;
                String doc = "";//$NON-NLS-1$
                String desc = "";//$NON-NLS-1$
                // WSRoutingRule wsObject = (WSRoutingRule) (getXObject().getWsObject());
                try {
                    // XtentisPort port=Util.getPort(getXObject());
                    WSServiceGetDocument document = port.getServiceDocument(new WSString(serviceNameCombo.getText().trim()));

                    desc = document.getDescription();
                    doc = document.getDefaultConfig();
                } catch (Exception e1) {
                    doc = "N/A";//$NON-NLS-1$
                } finally {
                    showUpDialog(desc, doc);
                }
            };

            private void showUpDialog(String desc, String doc) {
                // doc = ServiceConfigrationMainPage.this.formartXml(doc);

                final PluginDetailsDialog dialog = new PluginDetailsDialog(getSite().getShell(), desc, doc, null,
                        "Default Service Configuration");
                dialog.addListener(new Listener() {

                    public void handleEvent(Event event) {
                        dialog.close();
                    }
                });
                dialog.create();
                dialog.getShell().setText(serviceNameCombo.getText() + " Service Configuration Details");
                dialog.setBlockOnOpen(true);
                dialog.open();
            }

        });

        // Service Parameters
        Label serviceConfigurationsLabel = toolkit.createLabel(serviceGroup, "Service Configuration", SWT.NULL);
        serviceConfigurationsLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 2, 1));
        serviceConfigurationsText = toolkit.createText(serviceGroup, "", SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);//$NON-NLS-1$

        serviceConfigurationsText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
        ((GridData) serviceConfigurationsText.getLayoutData()).widthHint = 200;
        ((GridData) serviceConfigurationsText.getLayoutData()).heightHint = 120;

        serviceConfigurationsText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                if (refreshing)
                    return;
                // markDirty();
                markDirtyWithoutCommit();
            }
        });
        checkButton = toolkit.createButton(serviceGroup, "Check", SWT.NONE);
        checkButton.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                if (serviceNameCombo.getText().trim().length() == 0)
                    return;
                String msg = "";//$NON-NLS-1$
                boolean isok = false;
                try {
                    WSCheckServiceConfigResponse result = port.checkServiceConfiguration(new WSCheckServiceConfigRequest(
                            serviceNameCombo.getText().trim(), serviceConfigurationsText.getText()));
                    isok = result.getCheckResult();
                    if (isok) {
                        msg = "Connection sucessfully!";
                    } else {
                        msg = "Connection failed, please check your url, username and password";
                    }
                } catch (RemoteException e1) {
                    log.error(e1.getMessage(), e1);
                    msg = e1.getLocalizedMessage();
                }
                errorLabel.setForeground(isok ? errorLabel.getDisplay().getSystemColor(SWT.COLOR_BLUE) : errorLabel.getDisplay()
                        .getSystemColor(SWT.COLOR_RED));
                errorLabel.setText(msg);
            }
        });
        errorLabel = new Text(serviceGroup, SWT.WRAP);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        // gd.heightHint=200;
        errorLabel.setLayoutData(gd);
        // errorLabel.setImage(ImageCache.getImage( EImage.WARNING_CO.getPath()).createImage());
        // errorLabel.setVisible(false);
    }

    private String formartXml(String doc) {
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

    protected void saveChanges() {
        ws.setJndiName(serviceNameCombo.getText().contains("/") ? serviceNameCombo.getText() : "amalto/local/service/"//$NON-NLS-1$//$NON-NLS-2$
                + serviceNameCombo.getText());
        ws.setConfiguration(serviceConfigurationsText.getText());
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
        saveChanges();
    }

    @Override
    protected void createActions() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void refreshData() {
        // if (this.comitting) return;
        // this.refreshing = true;
        // this.refreshing = false;

    }

}
