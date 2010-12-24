package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;

class DefaultCommitHandler<T extends ISubmittable> extends CommitHandler<T> {

    public DefaultCommitHandler(T submittedObj) {
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
