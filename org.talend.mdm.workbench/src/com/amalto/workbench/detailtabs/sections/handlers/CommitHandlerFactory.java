package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.sections.model.EntityWrapper;
import com.amalto.workbench.detailtabs.sections.model.ISubmittable;

public class CommitHandlerFactory {

    private static CommitHandlerFactory INSTANCE;

    private CommitHandlerFactory() {
    }

    public static synchronized CommitHandlerFactory getInstance() {

        if (INSTANCE == null)
            INSTANCE = new CommitHandlerFactory();

        return INSTANCE;
    }

    public CommitHandler creatCommitHandler(ISubmittable submittedObj) {

        if (submittedObj instanceof EntityWrapper)
            return new EntityCommitHandler((EntityWrapper) submittedObj);

        return new DefaultCommitHandler(submittedObj);
    }
}
