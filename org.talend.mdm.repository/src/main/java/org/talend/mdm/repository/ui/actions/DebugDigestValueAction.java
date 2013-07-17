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
package org.talend.mdm.repository.ui.actions;

import java.util.List;

import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.utils.EMFClassUtil;

/**
 * created by HHB on 2013-7-15 
 * Just used for test DigestValueAction , only actved in debug mode
 * 
 */
public class DebugDigestValueAction extends AbstractRepositoryAction {

    EMFClassUtil util;

    public DebugDigestValueAction() {
        super("Debug digestValue"); //$NON-NLS-1$
        util = EMFClassUtil.getInstance();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.AbstractRepositoryAction#getGroupName()
     */
    @Override
    public String getGroupName() {
        return GROUP_COMMON;
    }

    @Override
    protected void doRun() {
        List<Object> selectedObject = getSelectedObject();
        if (!selectedObject.isEmpty()) {
            IRepositoryViewObject viewObj = (IRepositoryViewObject) selectedObject.get(0);
            Item item = viewObj.getProperty().getItem();
            String digestValue = util.caculateDigestValue(item);
            System.out.println("DigestValue:(" + item.getProperty().getLabel() + ") = " + digestValue); //$NON-NLS-1$ //$NON-NLS-2$
        }

    }

}
