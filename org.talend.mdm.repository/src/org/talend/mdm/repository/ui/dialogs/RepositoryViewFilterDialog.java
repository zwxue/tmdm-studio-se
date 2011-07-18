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
package org.talend.mdm.repository.ui.dialogs;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryViewFilter;
import org.talend.mdm.repository.core.impl.AbstractLabelProvider;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.ui.navigator.filter.ServerObjectViewFilter;
import org.talend.mdm.repository.utils.PreferenceUtil;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryViewFilterDialog extends Dialog {

    private class ServerObjectLabelProvider extends LabelProvider implements ITableLabelProvider {

        public Image getColumnImage(Object element, int columnIndex) {
            return ((AbstractLabelProvider) ((IRepositoryNodeConfiguration) element).getLabelProvider()).getCategoryImage();
        }

        public String getColumnText(Object element, int columnIndex) {
            return getLabel(element);
        }
    }

    private String getLabel(Object element) {
        if (element instanceof IRepositoryNodeConfiguration) {
            return ((IRepositoryNodeConfiguration) element).getLabelProvider().getCategoryLabel();
        }
        return ""; //$NON-NLS-1$
    }

    private Table table;

    private CheckboxTableViewer serverObjViewer;

    private List<IRepositoryNodeConfiguration> allConfigs;

    private Set<IRepositoryNodeConfiguration> enabledConfigs;

    private Button enableServerObjFilterBun;

    private Button enableAllBun;

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
        new Label(container, SWT.NONE);
        new Label(container, SWT.NONE);

        enableServerObjFilterBun = new Button(container, SWT.CHECK);
        enableServerObjFilterBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                enableServeObjFilterComposite(enableServerObjFilterBun.getSelection());
            }
        });
        enableServerObjFilterBun.setText("Enable Server Object Filter");

        serverObjViewer = CheckboxTableViewer.newCheckList(container, SWT.BORDER | SWT.FULL_SELECTION);
        table = serverObjViewer.getTable();
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        //
        serverObjViewer.addCheckStateListener(new ICheckStateListener() {

            @Override
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

            @Override
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
        enableAllBun.setText("Enable All Server Objects");
        serverObjViewer.setLabelProvider(new ServerObjectLabelProvider());
        serverObjViewer.setContentProvider(new ArrayContentProvider());
        //
        getShell().setText("Repository View Filter");
        //
        initServerObjectFilter();
        return container;
    }

    /**
     * DOC hbhong Comment method "initServerObjectTable".
     */
    private void initServerObjectFilter() {
        boolean enableFilter = PreferenceUtil.getBoolean(ServerObjectViewFilter.PROP_ENABLE);
        enableServerObjFilterBun.setSelection(enableFilter);
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
        enableServeObjFilterComposite(enableFilter);
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
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    /**
     * Return the initial size of the dialog.
     */
    @Override
    protected Point getInitialSize() {
        return new Point(451, 362);
    }

    @Override
    protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
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
