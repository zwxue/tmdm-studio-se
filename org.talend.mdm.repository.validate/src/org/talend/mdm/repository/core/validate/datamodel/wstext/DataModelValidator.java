// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================

package org.talend.mdm.repository.core.validate.datamodel.wstext;

import java.io.InputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.wst.validation.internal.provisional.core.IMessage;
import org.eclipse.wst.xml.core.internal.validation.core.AbstractNestedValidator;
import org.eclipse.wst.xml.core.internal.validation.core.NestedValidatorContext;
import org.eclipse.wst.xml.core.internal.validation.core.ValidationMessage;
import org.eclipse.wst.xml.core.internal.validation.core.ValidationReport;
import org.talend.mdm.repository.core.validate.datamodel.IDataModelChecker;
import org.talend.mdm.repository.core.validate.datamodel.model.IDataModelMarkerConst;
import org.talend.mdm.repository.core.validate.datamodel.validator.IModelBuilder;
import org.talend.mdm.repository.core.validate.datamodel.validator.ModelValidationMessage;
import org.talend.mdm.repository.core.validate.datamodel.validator.impl.ModelBuilder;
import org.talend.mdm.repository.core.validate.datamodel.validator.impl.StudioDataModelChecker;

public class DataModelValidator extends AbstractNestedValidator implements IDataModelMarkerConst {

    /**
     * 
     */
    private static final String EDITOR_ID = "org.talend.mdm.repository.ui.editors.XSDEditor2"; //$NON-NLS-1$

    public DataModelValidator() {
        IModelBuilder builder = new ModelBuilder();
        modelChecker = new StudioDataModelChecker(builder);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.wst.xml.core.internal.validation.core.AbstractNestedValidator#validate(java.lang.String,
     * java.io.InputStream, org.eclipse.wst.xml.core.internal.validation.core.NestedValidatorContext)
     */
    @Override
    public ValidationReport validate(String uri, InputStream inputstream, NestedValidatorContext context) {
        //
        DataModelValidationReport report = new DataModelValidationReport(uri);
        List<ModelValidationMessage> messages = modelChecker.toCheck(uri);
        report.addMessages(messages);
        return report;
    }

    private IDataModelChecker modelChecker;

    // //////////// overwrite///////////////////
    private boolean fileIsAccessible(IFile file) {
        if (file != null && file.exists() && file.getProject().isAccessible()) {
            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.wst.xml.core.internal.validation.core.AbstractNestedValidator#addInfoToMessage(org.eclipse.wst.xml
     * .core.internal.validation.core.ValidationMessage, org.eclipse.wst.validation.internal.provisional.core.IMessage)
     */
    @Override
    protected void addInfoToMessage(ValidationMessage validationmessage, IMessage message) {
        if (validationmessage instanceof ModelValidationMessageAdapter) {
            ModelValidationMessageAdapter msg = (ModelValidationMessageAdapter) validationmessage;
            message.setAttribute(DATA_MODEL, msg.getDataModelName());
            message.setAttribute(ENTITY, msg.getEntityName());
            message.setAttribute(PATH, msg.getPath());
            message.setAttribute(ELEMENT_TYPE, msg.getElementType());
            message.setAttribute(MSG_GROUP, msg.getMsgGroup());
            // message.setAttribute(IDE.EDITOR_ID_ATTR, EDITOR_ID);
        }
    }

}
