package com.amalto.workbench.detailtabs.sections.handlers;

import java.util.Arrays;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra.LookupFieldsAnnoInfo;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class LookupFieldsCommitHandler extends ListContentsCommitHandler<LookupFieldsAnnoInfo> {

    private static final String ANNOTAG = "X_Lookup_Field";

    public LookupFieldsCommitHandler(LookupFieldsAnnoInfo submittedInfo) {
        super(submittedInfo);
    }

    @Override
    protected String getMsgHeader() {
        return "lookup fields";
    }

    @Override
    protected String[] getOriginalAnnoInfos() {
        return getXSDAnnotationStruct().getLookupFields().values().toArray(new String[0]);
    }

    @Override
    protected boolean doSubmit() throws CommitException {

        XSDAnnotationsStructure xsdAnnoStruct = getXSDAnnotationStruct();
        try {
            return xsdAnnoStruct.setAccessRole(Arrays.asList(getCommitedObj().getInfos()), false, null, ANNOTAG);
        } catch (Exception e) {
            throw new CommitException(e.getMessage(), e);
        }
    }

}
