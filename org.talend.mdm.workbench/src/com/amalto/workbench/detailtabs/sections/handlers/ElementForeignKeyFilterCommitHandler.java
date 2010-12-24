package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship.ForeignKeyFilterAnnoInfo;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class ElementForeignKeyFilterCommitHandler extends ListContentsCommitHandler<ForeignKeyFilterAnnoInfo> {

    public ElementForeignKeyFilterCommitHandler(ForeignKeyFilterAnnoInfo submittedFKFilter) {
        super(submittedFKFilter);
    }

    @Override
    protected String getMsgHeader() {
        return "element foreign key filter";
    }

    @Override
    protected String[] getOriginalAnnoInfos() {
        return new String[] { getXSDAnnotationStruct().getFKFilter() };
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

    }

    @Override
    protected boolean doSubmit() throws CommitException {

        XSDAnnotationsStructure xsdAnnoStruct = getXSDAnnotationStruct();

        try {
            xsdAnnoStruct.setFKFilter(getCommitedObj().getValue());
        } catch (Exception e) {
            throw new CommitException(e.getMessage(), e);
        }

        return true;
    }
}
