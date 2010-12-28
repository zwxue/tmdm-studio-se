package com.amalto.workbench.detailtabs.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDParticle;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;

public class ElementMainSection extends CommitBarListenerSection<XSDParticle> {

    private XSDParticle curXSDParticle;

    @Override
    protected XSDParticle getEditedObj() {
        return curXSDParticle;
    }

    @Override
    protected void initUIContents(XSDParticle editedObj) {
        curXSDParticle = editedObj;

        // TODO
    }

    @Override
    protected ISubmittable getSubmittedObj() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String getSectionTitle() {
        return "Main";
    }

    @Override
    protected void createControlsInSection(Composite compSectionClient) {

        // TODO

    }

}
