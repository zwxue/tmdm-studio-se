package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.ISubmittable;

public abstract class CommitHandler {

    protected ISubmittable submittedObj;

    public CommitHandler(ISubmittable submittedObj) {
        this.submittedObj = submittedObj;
    }

    public ISubmittable getCommitedObj() {
        return submittedObj;
    }

    protected abstract void validateCommit() throws CommitValidationException;

    protected abstract boolean doSubmit() throws CommitException;

    /**
     * update the changes
     * 
     * @return true means there are some changes committed, otherwise return false
     * 
     * @throws CommitException
     * @throws CommitValidationException
     */
    public boolean submit() throws CommitException, CommitValidationException {

       validateCommit();

       return doSubmit();
    }
}
