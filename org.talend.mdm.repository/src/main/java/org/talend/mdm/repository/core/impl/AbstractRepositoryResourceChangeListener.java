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
package org.talend.mdm.repository.core.impl;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.progress.UIJob;
import org.talend.core.model.properties.Item;

/**
 * created by HHB on 2013-10-18 Detailled comment
 * 
 */
public abstract class AbstractRepositoryResourceChangeListener extends UIJob {

    static Logger log = Logger.getLogger(AbstractRepositoryResourceChangeListener.class);

    public AbstractRepositoryResourceChangeListener() {
        super("MDM Resource Change Listener"); //$NON-NLS-1$
    }

    protected abstract boolean isHandleProperty(String propertyName);

    protected abstract boolean isHandleItem(Item item);

    protected abstract void run(String propertyName, Item item, IProgressMonitor monitor) throws Exception;

    Item currentItem;

    private Item getCurrentItem() {
        return this.currentItem;
    }

    public void setCurrentItem(Item currentItem) {
        this.currentItem = currentItem;
    }

    String currentPropertyName;

    private String getCurrentPropertyName() {
        return this.currentPropertyName;
    }

    public void setCurrentPropertyName(String currentPropertyName) {
        this.currentPropertyName = currentPropertyName;
    }

    @Override
    public IStatus runInUIThread(IProgressMonitor monitor) {
        try {
            run(getCurrentPropertyName(), getCurrentItem(), monitor);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Status.CANCEL_STATUS;
        }
        return Status.OK_STATUS;
    }

}
