package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.sections.model.EntityWrapper;
import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.LanguageInfoCollection;

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
            return getEntityCommitHandler((EntityWrapper) submittedObj);

        if (submittedObj instanceof LanguageInfoCollection)
            return getLanguageInfoCommitHandler((LanguageInfoCollection) submittedObj);

        return new DefaultCommitHandler(submittedObj);
    }

    private CommitHandler getEntityCommitHandler(EntityWrapper submittedObj) {
        return new EntityCommitHandler(submittedObj);
    }

    private CommitHandler getLanguageInfoCommitHandler(LanguageInfoCollection langInfoCollection) {

        if (langInfoCollection.isLabelInfo())
            return new LabelCommitHandler(langInfoCollection);

        if (langInfoCollection.isDescriptionInfo())
            return new DescriptionCommitHandler(langInfoCollection);

        return new DefaultCommitHandler(langInfoCollection);
    }
}
