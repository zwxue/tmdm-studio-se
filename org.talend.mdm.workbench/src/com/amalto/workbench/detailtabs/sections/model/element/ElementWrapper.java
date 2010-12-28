package com.amalto.workbench.detailtabs.sections.model.element;

import org.eclipse.xsd.XSDParticle;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;
import com.amalto.workbench.detailtabs.sections.model.ISubmittable;

public class ElementWrapper implements ISubmittable {

    private XSDParticle sourceElement;

    private String newName = "";

    private String newReference = "";

    private int newMinOcur = 1;

    private int newMaxOcur = 1;

    public ElementWrapper(XSDParticle sourceElement, String newName, String newReference, int newMinOcur, int newMaxOcur) {

        this.sourceElement = sourceElement;
        this.newName = newName;
        this.newMinOcur = newMinOcur;
        this.newMaxOcur = newMaxOcur;
    }

    public XSDParticle getSourceElement() {
        return sourceElement;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewReference() {
        return newReference;
    }

    public void setNewReference(String newReference) {
        this.newReference = newReference;
    }

    public int getNewMinOcur() {
        return newMinOcur;
    }

    public void setNewMinOcur(int newMinOcur) {
        this.newMinOcur = newMinOcur;
    }

    public int getNewMaxOcur() {
        return newMaxOcur;
    }

    public void setNewMaxOcur(int newMaxOcur) {
        this.newMaxOcur = newMaxOcur;
    }

    public CommitHandler<ElementWrapper> createCommitHandler() {
        // TODO Auto-generated method stub
        return null;
    }

}
