package com.amalto.workbench.dialogs;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.models.KeyValue;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSGetRole;
import com.amalto.workbench.webservices.WSPutRole;
import com.amalto.workbench.webservices.WSRole;
import com.amalto.workbench.webservices.WSRolePK;
import com.amalto.workbench.webservices.WSRoleSpecification;
import com.amalto.workbench.webservices.WSRoleSpecificationInstance;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.ComplexTableViewer;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;
import com.amalto.workbench.widgets.WidgetFactory;

public class RoleAssignmentDialog extends Dialog {

    private String title;

    private Text instanceNameText = null;

    private TreeParent root = null;

    private ComplexTableViewer complexTableViewer = null;

    private StringBuffer outBuffer = new StringBuffer();

    private String typeName = null;

    private static ThreadLocal<List<RoleEntry>> roleEntries;

    private static ComplexTableViewerColumn[] roleConfigurationColumns = new ComplexTableViewerColumn[] {
            new ComplexTableViewerColumn("Role Name", false, "", "", "", ComplexTableViewerColumn.COMBO_STYLE, new String[] {}, 0),
            new ComplexTableViewerColumn("Access", false, "", "", "", ComplexTableViewerColumn.COMBO_STYLE, new String[] {}, 0) };

    public RoleAssignmentDialog(Shell parentShell, TreeParent root, String title, String type, StringBuffer outBuffer) {
        super(parentShell);
        this.root = root;
        this.title = title;

        if (roleEntries == null) {
            roleEntries = new ThreadLocal<List<RoleEntry>>();
            List<RoleEntry> list = new ArrayList<RoleEntry>();
            roleEntries.set(list);
        }
        typeName = type;
        this.outBuffer = outBuffer;
    }

    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);
        parent.getShell().setText(this.title);
        composite.setLayout(new GridLayout(1, false));

        Label instanceNameLabel = new Label(composite, SWT.NONE);
        instanceNameLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

        instanceNameLabel.setText("Enter a name for the New Instance");

        instanceNameText = new Text(composite, SWT.SINGLE | SWT.BORDER);
        instanceNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
        instanceNameText.setFocus();
        // The enable status of "Ok" button should be changes as the change of the content in this text.
        instanceNameText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                boolean enable = (instanceNameText.getText().length() > 0) && (!instanceNameText.getText().trim().equals(""));
                RoleAssignmentDialog.this.getButton(IDialogConstants.OK_ID).setEnabled(enable);
            }
        });
        // instanceNameText.addKeyListener(new KeyListener() {
        //
        // public void keyPressed(KeyEvent e) {
        // }
        //
        // public void keyReleased(KeyEvent e) {
        // boolean enable = (instanceNameText.getText().length() > 0) &&
        // (!instanceNameText.getText().trim().equals(""));
        // RoleAssignmentDialog.this.getButton(IDialogConstants.OK_ID).setEnabled(enable);
        // }
        // });

        Label infoLabel = new Label(composite, SWT.NONE);
        infoLabel.setText("Role Access definition");
        ComplexTableViewerColumn ruleColumn = roleConfigurationColumns[0];
        ruleColumn.setColumnWidth(250);
        // List<String> roles=Util.getCachedXObjectsNameSet(page.getXObject(), TreeObject.ROLE);
        List<String> roles = Util.getChildren(root.getServerRoot(), TreeObject.ROLE);
        ruleColumn.setComboValues(roles.toArray(new String[] {}));
        ComplexTableViewerColumn acsColumn = roleConfigurationColumns[1];
        acsColumn.setColumnWidth(250);
        acsColumn.setComboValues(new String[] { "Read Only", "Read & Write" });
        FormToolkit toolkit = WidgetFactory.getWidgetFactory();
        complexTableViewer = new ComplexTableViewer(Arrays.asList(roleConfigurationColumns), toolkit, composite);
        complexTableViewer.setKeyColumns(new ComplexTableViewerColumn[] { roleConfigurationColumns[0] });
        complexTableViewer.create();
        complexTableViewer.getViewer().setInput(new ArrayList<Line>());

        return composite;
    }

    protected Control createButtonBar(Composite parent) {
        Control bar = super.createButtonBar(parent);
        this.getButton(IDialogConstants.OK_ID).setEnabled(false);
        return bar;
    }

    @Override
    protected void okPressed() {
        // no close let Action Handler handle it
        outBuffer.append(instanceNameText.getText().trim());
        List<Line> inputs = (List<Line>) complexTableViewer.getViewer().getInput();
        List<RoleEntry> list = roleEntries.get();
        RoleEntry entry = new RoleEntry(inputs, instanceNameText.getText().trim(), typeName);
        list.add(entry);

        super.okPressed();
    }

    public static void doSave(XtentisPort port, String ObjectName, String type) throws RemoteException {
        if (roleEntries == null)
            return;
        List<RoleEntry> list = roleEntries.get();
        for (RoleEntry entry : list) {
            if (!entry.getInstanceName().equalsIgnoreCase(ObjectName) || entry.getType() != type)
                continue;
            for (Line line : entry.getInputList()) {
                List<KeyValue> keyValues = line.keyValues;
                String roleName = keyValues.get(0).value;
                WSGetRole getRole = new WSGetRole();
                getRole.setWsRolePK(new WSRolePK(roleName));
                WSRole role = port.getRole(getRole);
                for (WSRoleSpecification spec : role.getSpecification()) {
                    if (spec.getObjectType().equals(entry.getType())) {
                        WSRoleSpecificationInstance[] specInstance = spec.getInstance();
                        WSRoleSpecificationInstance newInstance = new WSRoleSpecificationInstance();
                        newInstance.setInstanceName(ObjectName);
                        newInstance.setWritable(keyValues.get(1).value.equals("Read Only") ? false : true);
                        WSRoleSpecificationInstance[] newSpecInstance = new WSRoleSpecificationInstance[specInstance.length + 1];
                        System.arraycopy(specInstance, 0, newSpecInstance, 0, specInstance.length);
                        newSpecInstance[specInstance.length] = newInstance;
                        spec.setInstance(newSpecInstance);
                        break;
                    }
                }
                WSPutRole wrap = new WSPutRole();
                wrap.setWsRole(role);
                port.putRole(wrap);
            }
        }

    }
}

class RoleEntry {

    private List<Line> inputList = new ArrayList<Line>();

    private String instanceName;

    private String typeName;

    protected RoleEntry(List<Line> input, String name, String type) {
        inputList = new ArrayList<Line>(input);
        instanceName = name;
        typeName = type;

    }

    public List<Line> getInputList() {
        return inputList;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public String getType() {
        return typeName;
    }
}
