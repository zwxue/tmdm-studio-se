// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship.ForeignKeyAnnoInfo;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class ElementForeighKeyCommitHandler extends ListContentsCommitHandler<ForeignKeyAnnoInfo> {

    public ElementForeighKeyCommitHandler(ForeignKeyAnnoInfo foreignKeyInfo) {
        super(foreignKeyInfo);
    }

    @Override
    protected String getMsgHeader() {
        return "element foreign key";
    }

    @Override
    protected String[] getOriginalAnnoInfos() {
        return new String[] { getXSDAnnotationStruct().getForeignKey() };
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

    }

    @Override
    protected boolean doSubmit() throws CommitException {

        XSDAnnotationsStructure xsdAnnoStruct = getXSDAnnotationStruct();

        if (Util.getForeignKeys() != null && getCommitedObj().getValue() != null) {
            if (xsdAnnoStruct.getForeignKey() != null)
                Util.getForeignKeys().remove(Util.getConceptFromPath(xsdAnnoStruct.getForeignKey()));
            Util.getForeignKeys().add(Util.getConceptFromPath(getCommitedObj().getValue()));
        }

        return xsdAnnoStruct.setForeignKey(getCommitedObj().getValue());
    }
}
