// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.validate.impl;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.validation.internal.ValidationResultSummary;
import org.talend.mdm.repository.core.service.IModelValidationService;
import org.talend.mdm.repository.core.validate.IValidationPreference;
import org.talend.mdm.repository.ui.preferences.IValidationPerferenceConstant;

/**
 * created by HHB on 2013-1-31 Detailled comment
 * 
 */
public class ImmediateValidationPreference implements IValidationPreference, IValidationPerferenceConstant {

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.IValidationPreference#shouldShowResults()
     */
    @Override
    public boolean shouldShowResults(ValidationResultSummary result) {
        IPreferenceStore preferenceStore = PlatformUI.getPreferenceStore();
        preferenceStore.setDefault(SHOW_RESULT_DIALOG_AFTER_IMMEDIATE, true);
        return preferenceStore.getBoolean(SHOW_RESULT_DIALOG_AFTER_IMMEDIATE);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.IValidationPreference#getValidationCondition()
     */
    @Override
    public int getValidationCondition() {
        return IModelValidationService.VALIDATE_IMMEDIATE;
    }

}
