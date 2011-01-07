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

    }

    @Override
    protected boolean doSubmit() throws CommitException {

        if (getCommitedObj().getNewTypeName().trim().equals(getCommitedObj().getOldTypeName()))
            return false;

        getCommitedObj().getXSDSimpleType().setName(getCommitedObj().getNewTypeName().trim());
        getCommitedObj().getXSDSimpleType().updateElement();

        return true;
    }

}
