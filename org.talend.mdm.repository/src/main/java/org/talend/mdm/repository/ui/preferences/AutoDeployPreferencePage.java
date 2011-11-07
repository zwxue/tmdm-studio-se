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
package org.talend.mdm.repository.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.talend.mdm.repository.i18n.Messages;

public class AutoDeployPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    private Button bAutoDeploy;

    public void init(IWorkbench workbench) {
        setPreferenceStore(PlatformUI.getPreferenceStore());
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridData gridData = new GridData(GridData.FILL_BOTH);
        composite.setLayoutData(gridData);
        composite.setLayout(new GridLayout(2, false));
        bAutoDeploy = new Button(composite, SWT.CHECK);
        bAutoDeploy.setText(Messages.AutoDeploy_saving_text);
        bAutoDeploy.setSelection(getPreferenceStore().getBoolean(PreferenceConstants.P_AUTO_DEPLOY));
        gridData = new GridData();
        gridData.horizontalSpan = 2;
        bAutoDeploy.setLayoutData(gridData);
        return composite;
    }

    public boolean performOk() {
        IPreferenceStore store = getPreferenceStore();
        store.setValue(PreferenceConstants.P_AUTO_DEPLOY, bAutoDeploy.getSelection());
        return true;
    }

    protected void performDefaults() {
        IPreferenceStore store = getPreferenceStore();
        bAutoDeploy.setSelection(store.getDefaultBoolean(PreferenceConstants.P_AUTO_DEPLOY));
    }

}
