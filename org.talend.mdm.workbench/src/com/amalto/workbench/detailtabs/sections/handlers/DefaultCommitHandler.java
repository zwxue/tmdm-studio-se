package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;

class DefaultCommitHandler extends CommitHandler {

    public DefaultCommitHandler(ISubmittable submittedObj) {
        super(submittedObj);
    }

    @Override
    protected boolean doSubmit() {
    	return false;
    }

    @Override
    protected void validateCommit() {
    }

}
