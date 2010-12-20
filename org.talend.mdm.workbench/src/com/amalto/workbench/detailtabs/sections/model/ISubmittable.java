package com.amalto.workbench.detailtabs.sections.model;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;

public interface ISubmittable {

    public CommitHandler createCommitHandler();

}
