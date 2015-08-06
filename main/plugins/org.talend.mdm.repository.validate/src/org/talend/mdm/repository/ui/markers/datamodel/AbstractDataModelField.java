// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.markers.datamodel;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.views.markers.MarkerField;
import org.talend.mdm.repository.core.validate.datamodel.model.IDataModelMarkerConst;
import org.talend.mdm.repository.core.validate.datamodel.validator.rule.IComponentValidationRule;

/**
 * created by HHB on 2013-1-16 Detailled comment
 * 
 */
public abstract class AbstractDataModelField extends MarkerField implements IDataModelMarkerConst {

    protected static final String BLANK = ""; //$NON-NLS-1$

    static Logger log = Logger.getLogger(AbstractDataModelField.class);

    protected int getMessageGroup(IMarker marker) {
        int group = marker.getAttribute(MSG_GROUP, IComponentValidationRule.MSG_GROUP_UNKNOW);
        return group;
    }

    protected boolean isBelongGroup(int group, int cur) {
        return (group & cur) == group;
    }
}
