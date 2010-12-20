package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.AnnotaionInfo;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public abstract class AnnotationInfoCommitHandler extends CommitHandler {

    public AnnotationInfoCommitHandler(AnnotaionInfo submittedObj) {
        super(submittedObj);
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

    }

    @Override
    protected boolean doSubmit() throws CommitException {

        XSDAnnotationsStructure xsdAnnoStruct = getXSDAnnotationStruct();

        return doSubmit_Removal(xsdAnnoStruct) | doSubmit_Update(xsdAnnoStruct) | doSubmit_Add(xsdAnnoStruct);
    }

    @Override
    public AnnotaionInfo getCommitedObj() {
        return (AnnotaionInfo) super.getCommitedObj();
    }

    protected XSDAnnotationsStructure getXSDAnnotationStruct() {
        return new XSDAnnotationsStructure(getCommitedObj().getSourceXSDComponent());
    }

    protected boolean doSubmit_Removal(XSDAnnotationsStructure xsdAnnoStruct) {

        Object[] needRemovedObjs = getNeedRemovedObjs();

        for (Object eachNeedRemovedObj : needRemovedObjs) {
            doRemoveEachObj(xsdAnnoStruct, eachNeedRemovedObj);
        }

        return (needRemovedObjs.length > 0);
    }

    protected boolean doSubmit_Update(XSDAnnotationsStructure xsdAnnoStruct) {

        Object[] needUpdatedObjs = getNeedUpdatedObjs();

        for (Object eachNeedUpdateedObject : needUpdatedObjs) {
            doUpdateEachObj(xsdAnnoStruct, eachNeedUpdateedObject);
        }

        return needUpdatedObjs.length > 0;
    }

    protected boolean doSubmit_Add(XSDAnnotationsStructure xsdAnnoStruct) {

        Object[] needAddedObjects = getNeedAddedObjs();

        for (Object eachNeedAddedObject : needAddedObjects) {
            doAddEachObj(xsdAnnoStruct, eachNeedAddedObject);
        }

        return needAddedObjects.length > 0;
    }

    protected Object[] getNeedRemovedObjs() {
        return new Object[0];
    }

    protected Object[] getNeedUpdatedObjs() {
        return new Object[0];
    }

    protected Object[] getNeedAddedObjs() {
        return new Object[0];
    }

    protected void doRemoveEachObj(XSDAnnotationsStructure xsdAnnoStruct, Object eachNeedRemovedObj) {

    }

    protected void doUpdateEachObj(XSDAnnotationsStructure xsdAnnoStruct, Object eachNeedUpdatedObj) {

    }

    protected void doAddEachObj(XSDAnnotationsStructure xsdAnnoStruct, Object eachNeedAddedObj) {

    }
}
