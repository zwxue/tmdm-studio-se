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
package org.talend.mdm.repository.core.validate;

import java.util.List;

import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.service.IModelValidationService;

/**
 * created by HHB on 2013-1-24 Detailled comment
 * 
 */
public class MDMValidationService implements IModelValidationService {

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.service.IValidationService#validate(java.util.List, int)
     */
    @Override
    public int validate(List<IRepositoryViewObject> viewObjs, int condition) {
        if (viewObjs != null && viewObjs.size() > 0) {
            switch (condition) {
            case VALIDATE_IMMEDIATE:
                MDMValidationRunner.validate(viewObjs, null);
                break;

            default:
                break;
            }
        }
        return BUTTON_OK;
    }

}
