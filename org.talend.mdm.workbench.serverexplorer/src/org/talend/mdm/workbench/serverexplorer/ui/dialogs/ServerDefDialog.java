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
package org.talend.mdm.workbench.serverexplorer.ui.dialogs;

import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataFactory;
import org.talend.mdm.workbench.serverexplorer.core.ServerDefService;
import org.talend.mdm.workbench.serverexplorer.i18n.Messages;

import com.amalto.workbench.utils.MDMServerHelper;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSGetUniversePKs;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class ServerDefDialog extends TitleAreaDialog {

    private static final Log log = LogFactory.getLog(ServerDefDialog.class);

    private Text nameText;

    private Text urlText;

    private Text userNameText;

    private Text passwordText;

    private Combo universeCombo;

    boolean isEnterprise;

    boolean isUpdateServerDef;

    public boolean isUpdateServerDef() {
        return this.isUpdateServerDef;
    }

    private MDMServerDef serverDef;

    private String newName = ""; //$NON-NLS-1$

    private static final int CHECK_CONNECTION_ID = 1024;

    public MDMServerDef getServerDef() {
        return this.serverDef;
    }

    /**
     * Create the dialog.
     * 
     * @param parentShell
     */
    public ServerDefDialog(Shell parentShell, MDMServerDef serverDef) {
        super(parentShell);
        
        //
        this.serverDef = serverDef;
        isUpdateServerDef = serverDef != null;
        if ( isUpdateServerDef){
            newName=serverDef.getName();
        }else{
            this.serverDef = MdmmetadataFactory.eINSTANCE.createMDMServerDef();
        }
        isEnterprise = Util.IsEnterPrise();
    }

    /**
     * Create contents of the dialog.
     * 
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        if (isUpdateServerDef){
            setTitle(Messages.ServerDefDialog_UpdateServer);
        }else{
            setTitle(Messages.ServerDefDialog_AddServer);
            this.serverDef = MdmmetadataFactory.eINSTANCE.createMDMServerDef();
        }
        //
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayout(new GridLayout(2, false));
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        new Label(container, SWT.NONE).setText(Messages.ServerDefDialog_Name);

        nameText = new Text(container, SWT.BORDER);

        nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        nameText.setFocus();

        new Label(container, SWT.NONE).setText(Messages.ServerDefDialog_Server);

        urlText = new Text(container, SWT.BORDER);

        urlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Group grpAuthentication = new Group(container, SWT.NONE);
        grpAuthentication.setText(Messages.ServerDefDialog_Authentication);
        grpAuthentication.setLayout(new GridLayout(2, false));
        GridData gd_grpAuthentication = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        gd_grpAuthentication.widthHint = 439;
        grpAuthentication.setLayoutData(gd_grpAuthentication);

        new Label(grpAuthentication, SWT.NONE).setText(Messages.ServerDefDialog_UserName);

        userNameText = new Text(grpAuthentication, SWT.BORDER);

        userNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        new Label(grpAuthentication, SWT.NONE).setText(Messages.ServerDefDialog_Password);

        passwordText = new Text(grpAuthentication, SWT.BORDER|SWT.PASSWORD);

        passwordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        // check Enterprise

        if (isEnterprise) {
            new Label(container, SWT.NONE).setText(Messages.ServerDefDialog_Version);

            universeCombo = new Combo(container, SWT.NONE);
            universeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        }
        // init value
        initValue();
        // init listener
        initListener();
        return area;
    }

    private void initListener() {
        nameText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                newName = nameText.getText().trim();
            }
        });
        urlText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                serverDef.setUrl(urlText.getText().trim());
            }
        });
        userNameText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                serverDef.setUser(userNameText.getText().trim());
            }
        });
        passwordText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                serverDef.setPasswd(passwordText.getText().trim());
            }
        });
        if (isEnterprise) {
            universeCombo.addModifyListener(new ModifyListener() {

                public void modifyText(ModifyEvent e) {
                    serverDef.setUniverse(universeCombo.getText().trim());
                }
            });

            FocusListener listener = new FocusAdapter() {

                @Override
                public void focusLost(FocusEvent e) {
                    updateUniverseValues();
                }
            };
            urlText.addFocusListener(listener);
            userNameText.addFocusListener(listener);
            passwordText.addFocusListener(listener);
        }
    }

    private void updateUniverseValues() {

        if (serverDef.getUser().equals("") || serverDef.getPasswd().equals("")) //$NON-NLS-1$ //$NON-NLS-2$
            return;

        if (Util.IsEnterPrise()) {

            try {
                XtentisPort port = Util.getPort(new URL(serverDef.getUrl()), null, serverDef.getUser(), serverDef.getPasswd());
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

    private boolean validateInput() {

        if (newName.length() == 0) {
            setErrorMessage(Messages.ServerDefDialog_NameCanNotBeEmpty);
            nameText.setFocus();
            return false;
        }

        if (ServerDefService.isExistServerDefName(newName)) {
            if ((!isUpdateServerDef) || (isUpdateServerDef() && (!serverDef.getName().equalsIgnoreCase(newName)))) {
                setErrorMessage(Messages.ServerDefDialog_SameName);
                nameText.setFocus();
                return false;
            }
        }
        if (urlText.getText().trim().length() == 0) {
            setErrorMessage(Messages.ServerDefDialog_ServerCanNotBeEmpty);
            urlText.setFocus();
            return false;
        }
        if (!serverDef.validate(serverDef.getUrl())) {
            setErrorMessage(Messages.ServerDefDialog_ServerInvalid);
            urlText.setFocus();
            return false;
        }
        if (serverDef.getUser().length() == 0) {
            setErrorMessage(Messages.ServerDefDialog_UsernameCanNotBeEmpty);
            userNameText.setFocus();
            return false;
        }
        if (serverDef.getPasswd().length() == 0) {
            setErrorMessage(Messages.ServerDefDialog_PasswordCanNotBeEmpty);
            passwordText.setFocus();
            return false;
        }
        setErrorMessage(null);
        return true;
    }

    @Override
    protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
            if (!validateInput())
                return;
            serverDef.parse(serverDef.getUrl());
            serverDef.setName(newName);

            createMDMServerViewDef(serverDef);
        }
        if (buttonId == CHECK_CONNECTION_ID) {
            if (!validateInput())
                return;
            boolean check = ServerDefService.checkMDMConnection(serverDef);
            String msg = check ? Messages.ServerExplorer_ConnectSuccessful : Messages.ServerExplorer_ConnectFailed;
            if (check) {
                setMessage(msg);
            } else {
                setErrorMessage(msg);
            }
        }
        super.buttonPressed(buttonId);
    }

    private void createMDMServerViewDef(MDMServerDef serverDef) {
        com.amalto.workbench.utils.MDMServerDef serDef = com.amalto.workbench.utils.MDMServerDef.parse(serverDef.getUrl(),
                serverDef.getUser(), serverDef.getPasswd(), serverDef.getUniverse(), serverDef.getName());

        boolean saved = MDMServerHelper.saveServer(serDef);


        if (!saved) {
            MessageDialog.openError(null, "Error", "Unable to store server definition");
        }
         
        IWorkbenchPage page =PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        
        ServerView viewPart = (ServerView) page.findView(ServerView.VIEW_ID);

        if (viewPart != null) {
            (viewPart).getViewer().refresh();
            ((ServerView) viewPart).initView();
        }

    }

    private void initValue() {
        nameText.setText(serverDef.getName());
        urlText.setText(serverDef.getUrl());
        userNameText.setText(serverDef.getUser());
        passwordText.setText(serverDef.getPasswd());
        if (Util.IsEnterPrise()) {
            universeCombo.setText(serverDef.getUniverse());
        }
    }

    /**
     * Create contents of the button bar.
     * 
     * @param parent
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, CHECK_CONNECTION_ID, Messages.ServerDefDialog_CheckConnection, false);
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

//    /**
//     * Return the initial size of the dialog.
//     */
//    @Override
//    protected Point getInitialSize() {
//        return new Point(483, 300);
//    }
}
