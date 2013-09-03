// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.utils;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.ui.editors.WorkflowEditorInput;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryWorkflowUtil {

    private static final String WORKFLOWEDITOR_ID = "org.bonitasoft.studio.model.process.diagram.part.ProcessDiagramEditorID"; //$NON-NLS-1$

    private static Logger log = Logger.getLogger(RepositoryWorkflowUtil.class);

    private static final String PROCESS_EXTENSION = ".proc"; //$NON-NLS-1$

    private static final String BAR_EXTENSION = ".bar"; //$NON-NLS-1$

    public static String getProcFileName(String workflowname, String version) {
        if (version != null) {
            return workflowname + "_" + version + PROCESS_EXTENSION; //$NON-NLS-1$
        } else {
            return workflowname + PROCESS_EXTENSION;
        }
    }

    public static String getBarFileName(String workflowname, String version) {
        if (version != null) {
            return workflowname + "_" + version + BAR_EXTENSION; //$NON-NLS-1$
        } else {
            return workflowname + BAR_EXTENSION;
        }
    }

    public static boolean isWorkflowEditor(IEditorPart part) {
        if (part == null) {
            return false;
        }

        if (WORKFLOWEDITOR_ID.equals(part.getEditorSite().getId())) {
            return true;
        }

        return false;
    }

    public static boolean isWorkflowEditorFromBPM(IEditorPart part) {
        if (isWorkflowEditor(part)) {
            if (part.getEditorInput() instanceof IFileEditorInput) {
                return true;
            }
        }

        return false;
    }

    public static IRepositoryViewObject getWorkflowViewObject(IEditorPart part) {
        if (isWorkflowEditor(part)) {
            if (isWorkflowEditorFromBPM(part)) {
                IFileEditorInput fileInput = (IFileEditorInput) part.getEditorInput();
                IFile file = fileInput.getFile();
                IRepositoryViewObject workflowViewObject = RepositoryResourceUtil.findViewObjectByReferenceResource(
                        IServerObjectRepositoryType.TYPE_WORKFLOW, file);

                return workflowViewObject;
            } else {
                WorkflowEditorInput workflowInput = (WorkflowEditorInput) part.getEditorInput();
                IRepositoryViewObject workflowViewObject = workflowInput.getViewObject();
                return workflowViewObject;
            }
        }

        return null;
    }
}
