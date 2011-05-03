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
package com.amalto.workbench.dialogs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.providers.ListContentProvider;
import com.amalto.workbench.utils.MDMServerDef;
import com.amalto.workbench.utils.MDMServerHelper;
import com.amalto.workbench.utils.PasswordUtil;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSUniversePK;

public class LoginDialog extends Dialog {

    private static final Log log = LogFactory.getLog(LoginDialog.class);

    private ComboViewer descCombo = null;

    private Text userText = null;

    private Text passwordText = null;

    private Text urlText;

    private Button savePasswordButton;

    private Button connectOnStartupButton;

    private SelectionListener caller = null;

    private String title = "";//$NON-NLS-1$

    private Combo universeCombo;

    private Group authenticationGroup;

    private Document logininfoDocument;

    private List<WSUniversePK> universes;

    private boolean isOK;

    /**
     * @param parentShell
     */
    public LoginDialog(SelectionListener caller, Shell parentShell, String title, List<WSUniversePK> universes) {
        super(parentShell);
        this.caller = caller;
        this.title = title;
        this.universes = universes;
        setDefaultImage(ImageCache.getCreatedImage(EImage.TALEND_PICTO.getPath()));
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        // Should not really be here but well,....
        parent.getShell().setText(this.title);

        Composite composite = (Composite) super.createDialogArea(parent);

        GridLayout layout = (GridLayout) composite.getLayout();
        layout.numColumns = 2;
        // layout.verticalSpacing = 10;

        Label endpointsLabel = new Label(composite, SWT.NONE);
        endpointsLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        endpointsLabel.setText("Description(*)");
        endpointsLabel.setForeground(endpointsLabel.getDisplay().getSystemColor(SWT.COLOR_RED));
        endpointsLabel.setToolTipText("Description is unique and mandatory!");
        descCombo = new ComboViewer(composite, SWT.NONE);
        descCombo.setContentProvider(new ListContentProvider());
        descCombo.setLabelProvider(new MDMServerLabelProvider());
        descCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        ((GridData) descCombo.getCombo().getLayoutData()).widthHint = 400;
        // for (Iterator<String> iter = endpoints.iterator(); iter.hasNext();) {
        // String host = iter.next();
        // endpointsCombo.add(host);
        // }
        // endpointsCombo.select(0);
        MDMServerDef[] serverDefs = getInitMDMServers();
        descCombo.setInput(serverDefs);

        Label descriptionLabel = new Label(composite, SWT.NONE);
        descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        descriptionLabel.setText("Server");
        urlText = new Text(composite, SWT.BORDER);
        urlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        authenticationGroup = new Group(composite, SWT.NONE);
        authenticationGroup.setVisible(true);
        authenticationGroup.setText("Authentication");
        authenticationGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
        authenticationGroup.setLayout(new GridLayout(2, false));

        Label usernameLabel = new Label(authenticationGroup, SWT.NONE);
        usernameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        usernameLabel.setText("Username");

        userText = new Text(authenticationGroup, SWT.BORDER);
        userText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        userText.setDoubleClickEnabled(false);

        Label passwordLabel = new Label(authenticationGroup, SWT.NONE);
        passwordLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        passwordLabel.setText("Password");

        passwordText = new Text(authenticationGroup, SWT.PASSWORD | SWT.BORDER);
        passwordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        // check Enterprise
        if (Util.IsEnterPrise()) {
            // universe
            Label universeLabel = new Label(composite, SWT.NONE);
            universeLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
            universeLabel.setText("Version");
            universeCombo = new Combo(composite, SWT.NONE);
            universeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
            ((GridData) universeCombo.getLayoutData()).widthHint = 300;
            if (universes != null) {
                java.util.List<String> hostList = new ArrayList<String>();
                for (int i = 0; i < universes.size(); i++) {
                    String host = universes.get(i).getPk();
                    if (!hostList.contains(host)) {
                        universeCombo.add(host);
                        hostList.add(host);
                    }
                }
            }
            // universeCombo.select(0);
        }

        savePasswordButton = new Button(composite, SWT.CHECK);
        savePasswordButton.setText("Save password");
        savePasswordButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
        savePasswordButton.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(SelectionEvent e) {
            }

            public void widgetSelected(SelectionEvent e) {
                boolean savePassword = savePasswordButton.getSelection();
                connectOnStartupButton.setEnabled(savePassword);
            }
        });

        connectOnStartupButton = new Button(composite, SWT.CHECK);
        connectOnStartupButton.setEnabled(false);
        connectOnStartupButton.setText("Automatically connect on startup");
        connectOnStartupButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        descCombo.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent arg0) {
                onSelectMDMServer();

            }
        });
        descCombo.setSelection(new StructuredSelection(serverDefs[0]));

        return composite;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        super.createButtonsForButtonBar(parent);
        getButton(IDialogConstants.OK_ID).addSelectionListener(this.caller);
    }

    public boolean isOK() {
        return isOK;
    }

    @Override
    protected void okPressed() {
        String desc = descCombo.getCombo().getText().trim();
        if (desc.length() == 0) {
            MessageDialog.openWarning(null, "Warning", "Description is mandatory!");
            descCombo.getCombo().setFocus();
            isOK = false;
            return;
        }
        if (urlText.getText().trim().length() == 0) {
            MessageDialog.openWarning(null, "Warning", "Server is mandatory!");
            urlText.setFocus();
            isOK = false;
            return;
        }
        if (userText.getText().trim().length() == 0) {
            MessageDialog.openWarning(null, "Warning", "Username is mandatory!");
            userText.setFocus();
            isOK = false;
            return;
        }
        if (passwordText.getText().trim().length() == 0) {
            MessageDialog.openWarning(null, "Warning", "Password is mandatory!");
            passwordText.setFocus();
            isOK = false;
            return;
        }

        Element root;
        Element server;
        if (new File(MDMServerHelper.workbenchConfigFile).exists()) {
            try {
                SAXReader reader = new SAXReader();
                logininfoDocument = reader.read(new File(MDMServerHelper.workbenchConfigFile));
            } catch (DocumentException e) {
                log.error(e.getMessage(), e);
                isOK = false;
                return;
            }
            root = logininfoDocument.getRootElement();
            server = getServer(root, desc);
        } else {
            logininfoDocument = DocumentHelper.createDocument();
            root = logininfoDocument.addElement(MDMServerHelper.ROOT);
            server = null;
        }

        boolean savePassword = savePasswordButton.getSelection();
        boolean connectOnStartup = savePassword && connectOnStartupButton.getSelection();

        if (server == null) {
            addServer(root, savePassword, connectOnStartup);
        } else {
            setServerProperties(server, savePassword, connectOnStartup);
        }

        XMLWriter writer;
        try {
            writer = new XMLWriter(new FileWriter(MDMServerHelper.workbenchConfigFile));
            writer.write(logininfoDocument);
            writer.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            isOK = false;
            return;
        }

        isOK = true;
        setReturnCode(OK);
        // no close let Action Handler handle it
    }

    private Element getServer(Element root, String matchingDesc) {
        List<?> properties = root.elements(MDMServerHelper.PROPERTIES);
        for (Iterator<?> iterator = properties.iterator(); iterator.hasNext();) {
            Element ele = (Element) iterator.next();
            String desc = ele.element(MDMServerHelper.DESC) != null ? ele.element(MDMServerHelper.DESC).getText() : ""; //$NON-NLS-1$
            if (matchingDesc.equals(desc))
                return ele;
        }
        return null;
    }

    private void addServer(Element root, boolean savePassword, boolean connectOnStartup) {
        Element prop = root.addElement(MDMServerHelper.PROPERTIES);
        setServerProperties(prop, savePassword, connectOnStartup);
        Element desc = prop.element(MDMServerHelper.DESC);
        if (desc == null)
            desc = prop.addElement(MDMServerHelper.DESC);
        desc.setText(descCombo.getCombo().getText().trim());
    }

    private void setServerProperties(Element prop, boolean savePassword, boolean connectOnStartup) {
        Element url = prop.element(MDMServerHelper.URL);
        if (url == null)
            url = prop.addElement(MDMServerHelper.URL);
        url.setText(urlText.getText().trim());

        Element user = prop.element(MDMServerHelper.USER);
        if (user == null)
            user = prop.addElement(MDMServerHelper.USER);
        user.setText(userText.getText());

        Element password = prop.element(MDMServerHelper.PASSWORD);
        if (password == null)
            password = prop.addElement(MDMServerHelper.PASSWORD);
        if (savePassword)
            password.setText(PasswordUtil.encryptPassword(passwordText.getText()));
        else
            password.setText(""); //$NON-NLS-1$

        Element universe = prop.element(MDMServerHelper.UNIVERSE);
        if (universe == null)
            universe = prop.addElement(MDMServerHelper.UNIVERSE);
        universe.setText(getUniverse());

        Element saved = prop.element(MDMServerHelper.SAVED);
        if (saved == null)
            saved = prop.addElement(MDMServerHelper.SAVED);
        saved.setText(String.valueOf(savePassword));

        Element connected = prop.element(MDMServerHelper.CONNECTED);
        if (connected == null)
            connected = prop.addElement(MDMServerHelper.CONNECTED);
        connected.setText(String.valueOf(connectOnStartup));
    }

    public void saveUserTypes() {

    }

    public String getDescription() {
        return descCombo.getCombo().getText().trim();
    }

    public String getPasswordText() {
        return passwordText.getText().trim();
    }

    public String getUsernameText() {
        return userText.getText().trim();
    }

    public String getServer() {
        return urlText.getText().trim();
    }

    public String getUniverse() {
        if (Util.IsEnterPrise())
            return universeCombo.getText().trim();
        return "";//$NON-NLS-1$
    }

    private MDMServerDef[] getInitMDMServers() {

        List<MDMServerDef> servers = MDMServerHelper.getServers();
        MDMServerDef defaultMDMServerDef = new MDMServerDef();

        // add the default url to the first position
        servers.add(0, defaultMDMServerDef);

        return servers.toArray(new MDMServerDef[0]);
    }

    private MDMServerDef getSelectedMDMServerDef() {

        IStructuredSelection selection = (IStructuredSelection) descCombo.getSelection();
        if (selection.isEmpty())
            return null;

        return (MDMServerDef) selection.getFirstElement();
    }

    private void onSelectMDMServer() {

        MDMServerDef selectedServer = getSelectedMDMServerDef();

        descCombo.getCombo().setText(selectedServer == null ? "" : selectedServer.getDesc());//$NON-NLS-1$
        userText.setText(selectedServer == null ? "" : selectedServer.getUser());//$NON-NLS-1$
        passwordText.setText(selectedServer == null ? "" : selectedServer.getPasswd());//$NON-NLS-1$
        urlText.setText(selectedServer == null ? "" : selectedServer.getUrl());//$NON-NLS-1$
        userText.setFocus();
        savePasswordButton.setSelection(selectedServer == null ? false : selectedServer.isSaved());
        connectOnStartupButton.setSelection(selectedServer == null ? false : selectedServer.isConnected());
        connectOnStartupButton.setEnabled(selectedServer == null ? false : selectedServer.isSaved());
    }
}

class MDMServerLabelProvider implements ILabelProvider {

    public void addListener(ILabelProviderListener element) {
    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String arg1) {
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
    }

    public Image getImage(Object element) {
        return null;
    }

    public String getText(Object element) {

        if (!(element instanceof MDMServerDef))
            return "";//$NON-NLS-1$

        return ((MDMServerDef) element).getDesc();
    }
}
