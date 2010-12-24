package com.amalto.workbench.detailtabs.sections.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.listinfo.ListContentsAnnotationInfo;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public abstract class ListContentsCommitHandler<T extends ListContentsAnnotationInfo> extends AnnotationInfoCommitHandler<T> {

    public ListContentsCommitHandler(T submittedSimpleAnnoInfo) {
        super(submittedSimpleAnnoInfo);
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

        for (String eachSubmittedSimpleAnnoInfoValue : getCommitedObj().getInfos()) {
            if (eachSubmittedSimpleAnnoInfoValue == null || "".equals(eachSubmittedSimpleAnnoInfoValue.trim())) {
                throw new CommitValidationException("The " + getMsgHeader() + " can not contains empty content");
            }
        }

    }

    protected XSDAnnotationsStructure getXSDAnnotationStruct() {
        return new XSDAnnotationsStructure(getCommitedObj().getSourceXSDComponent());
    }

    @Override
    protected String[] getNeedRemovedObjs() {

        List<String> results = new ArrayList<String>();
        List<String> curInfoList = Arrays.asList(getCommitedObj().getInfos());

        for (String eachOriginalInfo : getOriginalAnnoInfos()) {

            if (curInfoList.contains(eachOriginalInfo))
                continue;

            results.add(eachOriginalInfo);
        }

        return results.toArray(new String[0]);
    }

    @Override
    protected Object[] getNeedUpdatedObjs() {
        return new String[0];
    }

    @Override
    protected Object[] getNeedAddedObjs() {

        List<String> results = new ArrayList<String>();
        List<String> originalInfos = Arrays.asList(getOriginalAnnoInfos());

        for (String eachCurInfo : getCommitedObj().getInfos()) {

            if (originalInfos.contains(eachCurInfo))
                continue;

            results.add(eachCurInfo);
        }

        return results.toArray(new String[0]);
    }

    @Override
    protected void doRemoveEachObj(XSDAnnotationsStructure xsdAnnoStruct, Object eachNeedRemovedObj) {
    }

    @Override
    protected void doUpdateEachObj(XSDAnnotationsStructure xsdAnnoStruct, Object eachNeedUpdatedObj) {
    }

    @Override
    protected void doAddEachObj(XSDAnnotationsStructure xsdAnnoStruct, Object eachNeedAddedObj) {
    }

    protected abstract String getMsgHeader();

    protected abstract String[] getOriginalAnnoInfos();

}
