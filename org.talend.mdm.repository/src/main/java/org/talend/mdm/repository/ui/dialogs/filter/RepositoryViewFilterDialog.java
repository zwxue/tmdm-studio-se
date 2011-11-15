// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.dialogs.filter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryNodeLabelProvider;
import org.talend.mdm.repository.core.IRepositoryViewFilter;
import org.talend.mdm.repository.core.impl.AbstractLabelProvider;
import org.talend.mdm.repository.core.impl.eventmanager.EventManagerNodeConfiguration;
import org.talend.mdm.repository.core.impl.routingrule.RoutingRuleNodeConfiguration;
import org.talend.mdm.repository.core.impl.transformerV2.TransformerV2NodeConfiguration;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.ui.navigator.filter.LastServerViewFilter;
import org.talend.mdm.repository.ui.navigator.filter.NamePatternViewFilter;
import org.talend.mdm.repository.ui.navigator.filter.ServerObjectViewFilter;
import org.talend.mdm.repository.utils.PreferenceUtil;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryViewFilterDialog extends Dialog {

    private class ServerObjectLabelProvider extends LabelProvider implements ITableLabelProvider {

        public Image getColumnImage(Object element, int columnIndex) {
            IRepositoryNodeLabelProvider labelProvider = ((IRepositoryNodeConfiguration) element).getLabelProvider();
            if (labelProvider instanceof AbstractLabelProvider)
                return ((AbstractLabelProvider) ((IRepositoryNodeConfiguration) element).getLabelProvider())
                        .getCategoryImage(null);
            return null;
        }

        public String getColumnText(Object element, int columnIndex) {
            return getLabel(element);
        }
    }

    private String getLabel(Object element) {
        if (element instanceof IRepositoryNodeConfiguration) {
            return ((IRepositoryNodeConfiguration) element).getLabelProvider().getCategoryLabel(null);
        }
        return ""; //$NON-NLS-1$
    }

    private Table table;

    private CheckboxTableViewer serverObjViewer;

    private List<IRepositoryNodeConfiguration> allConfigs;

    private Set<IRepositoryNodeConfiguration> enabledConfigs;

    private Button enableServerObjFilterBun;

    private Button enableAllBun;

    private Button enableNameFilterBun;

    private Text namePatternTxt;

    private Group objectgroup;

    private Button enableLastServerFilterBun;

    private Label lastServerLabel;

    private Text serverNameTxt;

    private Button selServerBun;

    /**
     * Create the dialog.
     * 
     * @param parentShell
     */
    public RepositoryViewFilterDialog(Shell parentShell) {
        super(parentShell);
        this.setShellStyle(getShellStyle() | SWT.RESIZE);

    }

    /**
     * Create contents of the dialog.
     * 
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        GridLayout gl_container = new GridLayout(1, false);
        gl_container.marginRight = 5;
        container.setLayout(gl_container);

        Group nameGroup = new Group(container, SWT.NONE);
        nameGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        GridLayout gl_nameGroup = new GridLayout(1, false);
        nameGroup.setLayout(gl_nameGroup);
        nameGroup.setText(Messages.RepositoryViewFilterDialog_groupNamePattern);

        enableNameFilterBun = new Button(nameGroup, SWT.CHECK);
        enableNameFilterBun.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                namePatternTxt.setEnabled(enableNameFilterBun.getSelection());
            }
        });
        enableNameFilterBun.setText(Messages.RepositoryViewFilterDialog_enableNameFilter);

        namePatternTxt = new Text(nameGroup, SWT.BORDER);
        namePatternTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        namePatternTxt.setSize(440, 18);

        objectgroup = new Group(container, SWT.NONE);
        objectgroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        objectgroup.setText(Messages.RepositoryViewFilterDialog_groupServerObject);
        objectgroup.setLayout(new GridLayout(1, false));

        enableServerObjFilterBun = new Button(objectgroup, SWT.CHECK);
        enableServerObjFilterBun.setSize(183, 16);
        enableServerObjFilterBun.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                enableServerObjFilterComposite(enableServerObjFilterBun.getSelection());
            }
        });
        enableServerObjFilterBun.setText(Messages.RepositoryViewFilterDialog_enableServerObjFilter);

        serverObjViewer = CheckboxTableViewer.newCheckList(objectgroup, SWT.BORDER | SWT.FULL_SELECTION);
        table = serverObjViewer.getTable();
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        table.setSize(441, 121);

        enableAllBun = new Button(objectgroup, SWT.CHECK);
        enableAllBun.setSize(171, 16);
        enableAllBun.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                boolean selected = enableAllBun.getSelection();
                enableAllBun.setSelection(selected);
                serverObjViewer.setAllChecked(selected);
                if (selected) {
                    enabledConfigs.addAll(allConfigs);
                } else {
                    enabledConfigs.clear();
                }
            }
        });
        enableAllBun.setText(Messages.RepositoryViewFilterDialog_enableAllServerObject);

        //
        serverObjViewer.addCheckStateListener(new ICheckStateListener() {

            public void checkStateChanged(CheckStateChangedEvent event) {
                IRepositoryNodeConfiguration config = (IRepositoryNodeConfiguration) event.getElement();
                if (event.getChecked()) {
                    enabledConfigs.add(config);
                } else {
                    enabledConfigs.remove(config);
                }

                solveProcTriCase();

                enableAllBun.setSelection(enabledConfigs.size() == allConfigs.size());
            }

        });
        serverObjViewer.setLabelProvider(new ServerObjectLabelProvider());
        serverObjViewer.setContentProvider(new ArrayContentProvider());
        Group lastServerGroup = new Group(container, SWT.NONE);
        lastServerGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        lastServerGroup.setLayout(new GridLayout(3, false));
        lastServerGroup.setText(Messages.RepositoryViewFilterDialog_groupLastServer);

        enableLastServerFilterBun = new Button(lastServerGroup, SWT.CHECK);
        enableLastServerFilterBun.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
        enableLastServerFilterBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                enableLastServerFilterComposite(enableLastServerFilterBun.getSelection());
            }
        });
        enableLastServerFilterBun.setText(Messages.RepositoryViewFilterDialog_enableLastServerFilter);
        enableLastServerFilterBun.setSelection(false);
        new Label(lastServerGroup, SWT.NONE);

        lastServerLabel = new Label(lastServerGroup, SWT.NONE);
        lastServerLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lastServerLabel.setText(Messages.RepositoryViewFilterDialog_lblLastServer);

        serverNameTxt = new Text(lastServerGroup, SWT.BORDER | SWT.READ_ONLY);
        serverNameTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        selServerBun = new Button(lastServerGroup, SWT.NONE);
        selServerBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                SelectServerDefDialog dlg = new SelectServerDefDialog(getShell());
                if (dlg.open() == IDialogConstants.OK_ID) {
                    MDMServerDef def = dlg.getSelectedServerDef();
                    serverNameTxt.setText(def.getName());
                }
            }
        });
        selServerBun.setText(Messages.RepositoryViewFilterDialog_btnSelectServer);
        //
        getShell().setText(Messages.RepositoryViewFilterDialog_title);
        //
        initServerObjectFilter();
        return container;
    }

    private void solveProcTriCase() {
        IRepositoryNodeConfiguration eventMgr = null;
        boolean exist = false;

        for (IRepositoryNodeConfiguration conf : enabledConfigs) {
            if (conf instanceof EventManagerNodeConfiguration) {
                exist = true;
                break;
            }

            if (conf instanceof RoutingRuleNodeConfiguration || conf instanceof TransformerV2NodeConfiguration) {

                for (IRepositoryNodeConfiguration confi : allConfigs) {
                    if (confi instanceof EventManagerNodeConfiguration) {
                        eventMgr = confi;
                    }
                }
            }
        }

        if (eventMgr != null && !exist)
            enabledConfigs.add(eventMgr);

    }

    /**
     * DOC hbhong Comment method "initServerObjectTable".
     */
    private void initServerObjectFilter() {
        // name pattern filter
        boolean enableNamePatternFilter = PreferenceUtil.getBoolean(NamePatternViewFilter.PROP_ENABLE);
        enableNameFilterBun.setSelection(enableNamePatternFilter);
        String namePattern = PreferenceUtil.getString(NamePatternViewFilter.PROP_NAME_PATTERN);
        if (namePattern == null || namePattern.trim().length() == 0) {
            namePattern = "*"; //$NON-NLS-1$
        }
        namePatternTxt.setText(namePattern);
        namePatternTxt.setEnabled(enableNamePatternFilter);

        // sever object filter
        boolean enableServerObjFilter = PreferenceUtil.getBoolean(ServerObjectViewFilter.PROP_ENABLE);
        enableServerObjFilterBun.setSelection(enableServerObjFilter);
        //
        allConfigs = RepositoryNodeConfigurationManager.getConfigurations();
        serverObjViewer.setInput(allConfigs);
        Set<String> enabledObjectLabels = PreferenceUtil.getStringSet(ServerObjectViewFilter.PROP_ENABLE_LIST);
        enabledConfigs = new HashSet<IRepositoryNodeConfiguration>();
        for (IRepositoryNodeConfiguration conf : allConfigs) {
            String label = getLabel(conf);
            if (enabledObjectLabels.contains(label)) {
                serverObjViewer.setChecked(conf, true);
                enabledConfigs.add(conf);
            }
        }
        //
        enableServerObjFilterComposite(enableServerObjFilter);
        enableAllBun.setSelection(enabledConfigs.size() == allConfigs.size());
        // last server filter
        boolean enableLastServerFilter = PreferenceUtil.getBoolean(LastServerViewFilter.PROP_ENABLE);
        enableLastServerFilterBun.setSelection(enableLastServerFilter);
        String serverName = PreferenceUtil.getString(LastServerViewFilter.LAST_SERVER_NAME);
        serverNameTxt.setText(serverName == null ? "" : serverName); //$NON-NLS-1$
        enableLastServerFilterComposite(enableLastServerFilter);
    }

    private void enableServerObjFilterComposite(boolean enable) {
        table.setEnabled(enable);
        enableAllBun.setEnabled(enable);
    }

    private void enableLastServerFilterComposite(boolean enable) {
        lastServerLabel.setEnabled(enable);
        serverNameTxt.setEnabled(enable);
        selServerBun.setEnabled(enable);
    }

    /**
     * Create contents of the button bar.
     * 
     * @param parent
     */
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    /**
     * Return the initial size of the dialog.
     */
    protected Point getInitialSize() {
        return new Point(451, 362);
    }

    protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
            // name pattern pref
            PreferenceUtil.setBoolean(NamePatternViewFilter.PROP_ENABLE, enableNameFilterBun.getSelection());
            PreferenceUtil.setString(NamePatternViewFilter.PROP_NAME_PATTERN, namePatternTxt.getText().trim());
            // server object pref
            PreferenceUtil.setBoolean(ServerObjectViewFilter.PROP_ENABLE, enableServerObjFilterBun.getSelection());
            Set<String> names = getNewServerObjectPref();
            PreferenceUtil.setStringSet(ServerObjectViewFilter.PROP_ENABLE_LIST, names);
            // last server pref
            PreferenceUtil.setBoolean(LastServerViewFilter.PROP_ENABLE, enableLastServerFilterBun.getSelection());
            PreferenceUtil.setString(LastServerViewFilter.LAST_SERVER_NAME, serverNameTxt.getText().trim());
            //
            PreferenceUtil.save();
            PreferenceUtil.flipBooleanKey(IRepositoryViewFilter.PROP_REFRESH);

        }
        super.buttonPressed(buttonId);
    }

    private Set<String> getNewServerObjectPref() {
        Set<String> values = new HashSet<String>();
        for (IRepositoryNodeConfiguration conf : enabledConfigs) {
            String label = getLabel(conf);
            if (label.length() > 0) {
                values.add(label);
            }
        }
        return values;
    }

}
