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
package org.talend.mdm.repository.core.validate.datamodel;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.talend.mdm.repository.core.validate.datamodel.validator.IDataModelValidator;
import org.talend.mdm.repository.core.validate.datamodel.validator.IModelBuilder;
import org.talend.mdm.repository.core.validate.datamodel.validator.ModelValidationMessage;

/**
 * created by HHB on 2013-1-29 Detailled comment
 * 
 */
public interface IDataModelChecker {

    /**
     * Getter for validators.
     * 
     * @return the validators
     */
    public abstract List<IDataModelValidator> getValidators();

    public abstract void addValidator(IDataModelValidator validator);

    public abstract void initValidators();

    /**
     * Sets the builder.
     * 
     * @param builder the builder to set
     */
    public abstract void setBuilder(IModelBuilder builder);

    public abstract boolean shouldCheck(DataModelValidateContext context);

    public abstract List<ModelValidationMessage> toCheck(String uri);

    public abstract List<ModelValidationMessage> toCheck(File file);

    public abstract List<ModelValidationMessage> toCheck(InputStream inputstream);

    public abstract List<ModelValidationMessage> toCheck(DataModelValidateContext context);

}