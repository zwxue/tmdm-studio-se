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
import java.net.URL;
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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.MDMServerDef;
import com.amalto.workbench.utils.MDMServerHelper;
import com.amalto.workbench.utils.PasswordUtil;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSGetUniversePKs;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.XtentisPort;

public class LoginDialog extends Dialog {

    private static final Log log = LogFactory.getLog(LoginDialog.class);

    private Text nameText = null;

    private Text userText = null;

    private Text passwordText = null;

    private Text urlText;

    private SelectionListener caller = null;

    private String title = "";//$NON-NLS-1$

    private Combo universeCombo;

    private Group authenticationGroup;

    private Document logininfoDocument;

    private boolean isOK;

    /**
     * @param parentShell
     */
    public LoginDialog(SelectionListener caller, Shell parentShell, String title) {
        super(parentShell);
        this.caller = caller;
        this.title = title;
        setDefaultImage(ImageCache.getCreatedImage(EImage.TALEND_PICTO.getPath()));
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        // Should not really be here but well,....
        parent.getShell().setText(this.title);

        Composite composite = (Composite) super.createDialogArea(parent);

        GridLayout layout = (GridLayout) composite.getLayout();
        layout.numColumns = 2;

        Label nameLabel = new Label(composite, SWT.NONE);
        nameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        nameLabel.setText("Name");
        nameLabel.setForeground(nameLabel.getDisplay().getSystemColor(SWT.COLOR_RED));
        nameLabel.setToolTipText("Name is mandatory and must be unique!");
        nameText = new Text(composite, SWT.BORDER);
        nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        ((GridData) nameText.getLayoutData()).widthHint = 400;
        nameText.setFocus();

        Label urlLabel = new Label(composite, SWT.NONE);
        urlLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        urlLabel.setText("Server");
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
        }

        initDefaultValues();

        return composite;
    }

    private void initDefaultValues() {
        MDMServerDef defaultMDMServerDef = new MDMServerDef();
        nameText.setText(defaultMDMServerDef.getName());
        urlText.setText(defaultMDMServerDef.getUrl());
        userText.setText(defaultMDMServerDef.getUser());
        passwordText.setText(defaultMDMServerDef.getPasswd());
        universeCombo.setText(defaultMDMServerDef.getUniverse());

        if (Util.IsEnterPrise()) {
            FocusListener listener = new FocusListener() {

                public void focusGained(FocusEvent e) {
                }

                public void focusLost(FocusEvent e) {
                    updateUniverseValues();
                }
            };
            urlText.addFocusListener(listener);
            userText.addFocusListener(listener);
            passwordText.addFocusListener(listener);
        }
    }

    private void updateUniverseValues() {
        if (Util.IsEnterPrise()) {

            String name = getName();
            if (name.length() == 0)
                return;
            String url = getServer();
            if (url.length() == 0)
                return;
            String user = getUsernameText();
            if (user.length() == 0)
                return;
            String password = getPasswordText();
            if (password.length() == 0)
                return;

            try {
                XtentisPort port = Util.getPort(new URL(url), null, user, password);
                WSUniversePK[] universePKs = port.getUniversePKs(new WSGetUniversePKs("*")).getWsUniversePK();//$NON-NLS-1$
                universeCombo.removeAll();
                universeCombo.add(""); //$NON-NLS-1$
                if (universePKs != null && universePKs.length > 0) {
                    for (int i = 0; i < universePKs.length; i++) {
                        String universe = universePKs[i].getPk();
                        universeCombo.add(universe);
                    }
                }
            } catch (Exception e) {
                if (log.isDebugEnabled())
                    log.debug(e.getMessage(), e);
                universeCombo.removeAll();
            }
        }
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
        String name = getName();
        if (name.length() == 0) {
            MessageDialog.openError(null, "Error", "Name is mandatory!");
            nameText.setFocus();
            isOK = false;
            return;
        }
        if (MDMServerHelper.getServer(name) != null) {
            MessageDialog.openError(null, "Error", "Server with same name already exist!");
            isOK = false;
            return;
        }

        if (getServer().length() == 0) {
            MessageDialog.openError(null, "Error", "Server is mandatory!");
            urlText.setFocus();
            isOK = false;
            return;
        }
        if (getUsernameText().length() == 0) {
            MessageDialog.openError(null, "Error", "Username is mandatory!");
            userText.setFocus();
            isOK = false;
            return;
        }
        if (getPasswordText().length() == 0) {
            MessageDialog.openError(null, "Error", "Password is mandatory!");
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
            server = getServer(root, name);
        } else {
            logininfoDocument = DocumentHelper.createDocument();
            root = logininfoDocument.addElement(MDMServerHelper.ROOT);
            server = null;
        }

        if (server == null) {
            addServer(root);
        } else {
            setServerProperties(server);
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

    private Element getServer(Element root, String matchingName) {
        List<?> properties = root.elements(MDMServerHelper.PROPERTIES);
        for (Iterator<?> iterator = properties.iterator(); iterator.hasNext();) {
            Element ele = (Element) iterator.next();
            String name = ele.element(MDMServerHelper.NAME) != null ? ele.element(MDMServerHelper.NAME).getText() : ""; //$NON-NLS-1$
            if (matchingName.equals(name))
                return ele;
        }
        return null;
    }

    private void addServer(Element root) {
        Element prop = root.addElement(MDMServerHelper.PROPERTIES);
        setServerProperties(prop);
        Element name = prop.element(MDMServerHelper.NAME);
        if (name == null)
            name = prop.addElement(MDMServerHelper.NAME);
        name.setText(nameText.getText().trim());
    }

    private void setServerProperties(Element prop) {
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
        password.setText(PasswordUtil.encryptPassword(passwordText.getText()));

        Element universe = prop.element(MDMServerHelper.UNIVERSE);
        if (universe == null)
            universe = prop.addElement(MDMServerHelper.UNIVERSE);
        universe.setText(getUniverse());
    }

    public void saveUserTypes() {

    }

    public String getName() {
        return nameText.getText().trim();
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

        return ((MDMServerDef) element).getName();
    }
}
