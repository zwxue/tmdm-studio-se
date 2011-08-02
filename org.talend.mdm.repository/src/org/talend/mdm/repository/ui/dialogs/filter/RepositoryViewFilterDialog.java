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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryViewFilter;
import org.talend.mdm.repository.core.impl.AbstractLabelProvider;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.ui.navigator.filter.NamePatternViewFilter;
import org.talend.mdm.repository.ui.navigator.filter.ServerObjectViewFilter;
import org.talend.mdm.repository.utils.PreferenceUtil;
import org.talend.mdm.repository.i18n.Messages;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryViewFilterDialog extends Dialog {

    private class ServerObjectLabelProvider extends LabelProvider implements ITableLabelProvider {

        public Image getColumnImage(Object element, int columnIndex) {
            return ((AbstractLabelProvider) ((IRepositoryNodeConfiguration) element).getLabelProvider()).getCategoryImage(null);
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
        container.setLayout(new GridLayout(1, false));

        enableNameFilterBun = new Button(container, SWT.CHECK);
        enableNameFilterBun.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                namePatternTxt.setEnabled(enableNameFilterBun.getSelection());
            }
        });
        enableNameFilterBun.setText(Messages.RepositoryViewFilterDialog_enableNameFilter);

        namePatternTxt = new Text(container, SWT.BORDER);
        namePatternTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        enableServerObjFilterBun = new Button(container, SWT.CHECK);
        enableServerObjFilterBun.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                enableServeObjFilterComposite(enableServerObjFilterBun.getSelection());
            }
        });
        enableServerObjFilterBun.setText(Messages.RepositoryViewFilterDialog_enableServerObjFilter);

        serverObjViewer = CheckboxTableViewer.newCheckList(container, SWT.BORDER | SWT.FULL_SELECTION);
        table = serverObjViewer.getTable();
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        //
        serverObjViewer.addCheckStateListener(new ICheckStateListener() {

            public void checkStateChanged(CheckStateChangedEvent event) {
                IRepositoryNodeConfiguration config = (IRepositoryNodeConfiguration) event.getElement();
                if (event.getChecked()) {
                    enabledConfigs.add(config);
                } else {
                    enabledConfigs.remove(config);
                }
                enableAllBun.setSelection(enabledConfigs.size() == allConfigs.size());
            }
        });

        enableAllBun = new Button(container, SWT.CHECK);
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
        serverObjViewer.setLabelProvider(new ServerObjectLabelProvider());
        serverObjViewer.setContentProvider(new ArrayContentProvider());
        //
        getShell().setText(Messages.RepositoryViewFilterDialog_title);
        //
        initServerObjectFilter();
        return container;
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
        enableServeObjFilterComposite(enableServerObjFilter);
        enableAllBun.setSelection(enabledConfigs.size() == allConfigs.size());

    }

    private void enableServeObjFilterComposite(boolean enable) {
        table.setEnabled(enable);
        enableAllBun.setEnabled(enable);
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
