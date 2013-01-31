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
package org.talend.mdm.repository.core.validate.datamodel.validator.impl;

import org.talend.mdm.repository.core.validate.datamodel.validator.IModelBuilder;

/**
 * created by HHB on 2013-1-29 Detailled comment
 * 
 */
public class ServerDataModelChecker extends DataModelChecker {

    /**
     * DOC HHB StudioDataModelChecker constructor comment.
     * 
     * @param builder
     */
    public ServerDataModelChecker(IModelBuilder builder) {
        super(builder);
    }

    @Override
    public void initValidators() {
        addValidator(new ServerElementValidator());
    }

}
