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
package org.talend.mdm.repository.core.validate.datamodel.validator.visitor;

import java.util.Set;

import org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext;
import org.talend.mdm.repository.core.validate.datamodel.DataModelValidationMessage;
import org.talend.mdm.repository.core.validate.datamodel.model.IElementContainer;
import org.talend.mdm.repository.core.validate.datamodel.model.IMComponent;
import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;

/**
 * created by HHB on 2013-1-11 Detailled comment
 * 
 */
public interface IComponentValidateVisitor {

    public static final int SEV_ERROR = 2;

    public static final int SEV_WARNING = 4;

    // to mark the error is caused by UNKNOW
    public static final int MSG_GROUP_UNKNOW = 0;

    // to mark the error is caused by Entity
    public static final int MSG_GROUP_ENTITY = 1;

    // to mark the error is caused by Element
    public static final int MSG_GROUP_ELEMENT = 2;

    // to mark the error is caused by Type
    public static final int MSG_GROUP_TYPE = 4;

    public boolean needValidate(DataModelValidateContext context, IMComponent mComponent);

    public boolean visit(DataModelValidateContext context, IMComponent mComponent, Set<DataModelValidationMessage> messages);

    public String[] getMessageKeys();

    public int getMsgGroup(IElementContainer container, IMElement element, String msgKey);
}
