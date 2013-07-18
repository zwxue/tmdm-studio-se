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
package org.talend.mdm.repository.core.impl.jobmodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.model.mdmproperties.WSWorkflowItem;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.repository.utils.RepositoryWorkflowUtil;
import org.talend.repository.documentation.ERepositoryActionName;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * created by liusongbo on 2013-7-17 Detailled comment
 * 
 */
public class WorkflowChangeListener implements PropertyChangeListener {

    private static final Log log = LogFactory.getLog(WorkflowChangeListener.class);

    public void propertyChange(final PropertyChangeEvent evt) {
        if (!(evt.getNewValue() instanceof WSWorkflowItem)) {
            return;
        }

        if (isCreateEvent(evt)) {
            Display.getCurrent().asyncExec(new Runnable() {

                public void run() {
                    final WSWorkflowItem item = (WSWorkflowItem) evt.getNewValue();
                    IRepositoryViewObject workflowViewObject = RepositoryResourceUtil.findViewObjectByName(
                            IServerObjectRepositoryType.TYPE_WORKFLOW, item.getProperty().getLabel());

                    if (workflowViewObject != null) {
                        IEditorReference editorRef = RepositoryResourceUtil.isOpenedInEditor(workflowViewObject);
                        if (editorRef != null && RepositoryWorkflowUtil.isWorkflowEditorFromBPM(editorRef.getEditor(false))) {
                            try {
                                IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
                                factory.lock(workflowViewObject);
                            } catch (Exception e) {
                                log.error(e.getMessage(), e);
                            }
                        }
                    }
                }
            });
        }
    }

    private boolean isCreateEvent(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        if (propertyName.equals(ERepositoryActionName.CREATE.getName())
                || propertyName.equals(ERepositoryActionName.IMPORT.getName())) {
            return true;
        }

        return false;
    }

}
