// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.simpletype.SimpleTypeWrapper;

public class SimpleTypeNameCommitHandler extends CommitHandler<SimpleTypeWrapper> {

    public SimpleTypeNameCommitHandler(SimpleTypeWrapper submittable) {
        super(submittable);
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

        if ("".equals(getCommitedObj().getNewTypeName().trim()))
            throw new CommitValidationException("The new type name can not be empty");

        if (getCommitedObj().getNewTypeName().replaceAll("\\s", "").length() != getCommitedObj().getNewTypeName().length())//$NON-NLS-1$//$NON-NLS-2$
            throw new CommitValidationException("The new type name can not contain the empty characters");
    }

    @Override
    protected boolean doSubmit() throws CommitException {
        return getCommitedObj().changeTypeName();
    }

}
