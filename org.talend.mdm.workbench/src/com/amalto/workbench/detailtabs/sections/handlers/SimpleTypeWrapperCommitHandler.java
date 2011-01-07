package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.sections.model.simpletype.SimpleTypeWrapper;

public class SimpleTypeWrapperCommitHandler extends CompositeCommitHandler<SimpleTypeWrapper> {

    public SimpleTypeWrapperCommitHandler(SimpleTypeWrapper submittable) {
        super(submittable);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected CommitHandler<SimpleTypeWrapper>[] createChildHandlers() {

        return new CommitHandler[] { new SimpleTypeNameCommitHandler(getCommitedObj()),
                new SimpleTypeBaseTypeCommitHandler(getCommitedObj()), new SimpleTypeFacetCommitHandler(getCommitedObj()) };
    }

}
