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
package com.amalto.workbench.detailtabs.sections.handlers;

import org.eclipse.xsd.XSDCompositor;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.complextype.ComplexTypeWrapper;
import com.amalto.workbench.utils.Util;

public class ComplexTypeWrapperCommitHandler extends CompositeCommitHandler<ComplexTypeWrapper> {

    public ComplexTypeWrapperCommitHandler(ComplexTypeWrapper submittable) {
        super(submittable);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected CommitHandler<ComplexTypeWrapper>[] createChildHandlers() {
        return new CommitHandler[] { new ComplexTypeNameCommitHandler(getCommitedObj()),
                new ComplexTypeGroupTypeCommitHandler(getCommitedObj()), new ComplexTypeExtendsCommitHandler(getCommitedObj()), };
    }

}

class ComplexTypeNameCommitHandler extends CommitHandler<ComplexTypeWrapper> {

    public ComplexTypeNameCommitHandler(ComplexTypeWrapper submittedObj) {
        super(submittedObj);
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

        if (getCommitedObj().getNewTypeName() == null || "".equals(getCommitedObj().getNewTypeName().trim()))
            throw new CommitValidationException("The name of the complex type can not be empty");

        if (getCommitedObj().getNewTypeName().replaceAll("\\s", "").length() != getCommitedObj().getNewTypeName().length())//$NON-NLS-1$
            throw new CommitValidationException("The name of the complex type can not contain the empty characters");

    }

    @Override
    protected boolean doSubmit() throws CommitException {
        return getCommitedObj().changeTypeName();
    }

}

class ComplexTypeExtendsCommitHandler extends CommitHandler<ComplexTypeWrapper> {

    public ComplexTypeExtendsCommitHandler(ComplexTypeWrapper submittedObj) {
        super(submittedObj);
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

        if (getCommitedObj().getNewExtends() != null
                && getCommitedObj().getNewExtends().equals(getCommitedObj().getCurComplexType()))
            throw new CommitValidationException("The base type of a complex type can not be itself");

        if (Util.getParentTypes(getCommitedObj().getNewExtends()).contains(getCommitedObj().getCurComplexType()))
            throw new CommitValidationException("The base type " + getCommitedObj().getNewExtends().getName()
                    + " shouldn't be the child of " + getCommitedObj().getCurComplexType().getName());

        if (!getCommitedObj().isDefaultExtends()) {
            XSDCompositor newBaseGroupType = Util.getComplexTypeGroupType(getCommitedObj().getNewExtends());
            XSDCompositor newGroupType = getCommitedObj().getNewGroupType();

            if (newBaseGroupType != null && newBaseGroupType.equals(XSDCompositor.ALL_LITERAL))
                throw new CommitValidationException("The group type of the new base "
                        + getCommitedObj().getNewExtends().getName() + " shouldn't be 'All'");

            if (newGroupType != null && newGroupType.equals(XSDCompositor.ALL_LITERAL))
                throw new CommitValidationException("The new group type shouldn't be 'All'");

            if (newBaseGroupType != null && !newBaseGroupType.equals(newGroupType))
                throw new CommitValidationException("The group type of the new base "
                        + getCommitedObj().getNewExtends().getName() + " should be same to the new group type ");
        }
    }

    @Override
    protected boolean doSubmit() throws CommitException {
        return getCommitedObj().changeExtends();
    }

}

class ComplexTypeGroupTypeCommitHandler extends CommitHandler<ComplexTypeWrapper> {

    public ComplexTypeGroupTypeCommitHandler(ComplexTypeWrapper submittedObj) {
        super(submittedObj);
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

        if (getCommitedObj().getNewGroupType() == null)
            throw new CommitValidationException("The group type of the complex type can not be null");

    }

    @Override
    protected boolean doSubmit() throws CommitException {
        return getCommitedObj().changeGroupType();
    }

}
