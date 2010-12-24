package com.amalto.workbench.detailtabs.sections.handlers;

import java.util.Arrays;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship.ForeignKeyInfosAnnoInfo;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class ElementForeignKeyInfosCommitHandler extends ListContentsCommitHandler<ForeignKeyInfosAnnoInfo> {

    public ElementForeignKeyInfosCommitHandler(ForeignKeyInfosAnnoInfo submittedFKInfosAnnoInfo) {
        super(submittedFKInfosAnnoInfo);
    }

    @Override
    protected String getMsgHeader() {
        return "element foreign key infos";
    }

    @Override
    protected String[] getOriginalAnnoInfos() {
        return getXSDAnnotationStruct().getForeignKeyInfos().values().toArray(new String[0]);
    }

    @Override
    protected void validateCommit() throws CommitValidationException {
    }

    @Override
    protected boolean doSubmit() throws CommitException {

        XSDAnnotationsStructure xsdAnnoStruct = getXSDAnnotationStruct();

        try {
            xsdAnnoStruct.setForeignKeyInfos(Arrays.asList(getCommitedObj().getInfos()));
            xsdAnnoStruct.setRetrieveFKinfos(getCommitedObj().isResolveAutoInWeb());
        } catch (Exception e) {
            throw new CommitException(e.getMessage(), e);
        }

        return true;
    }
}
