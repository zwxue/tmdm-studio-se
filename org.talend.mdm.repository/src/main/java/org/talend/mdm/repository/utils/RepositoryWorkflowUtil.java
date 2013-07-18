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
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;

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

    public static boolean isWorkflowEditorFromBPM(IEditorPart part) {
        if (part == null) {
            return false;
        }

        if (WORKFLOWEDITOR_ID.equals(part.getEditorSite().getId())) {
            if (part.getEditorInput() instanceof IFileEditorInput) {
                return true;
            }
        }

        return false;
    }

    public static IRepositoryViewObject getWorkflowViewObject(IEditorPart input) {
        String workflowName = getWorkflowProcessName(input);

        IRepositoryViewObject workflowViewObject = RepositoryResourceUtil.findViewObjectByName(
                IServerObjectRepositoryType.TYPE_WORKFLOW, workflowName);

        return workflowViewObject;
    }

    private static String getWorkflowProcessName(IEditorPart editorPart) {
        IEditorInput editorInput = editorPart.getEditorInput();
        String fileName = null;
        if (editorInput instanceof IFileEditorInput) {
            IFileEditorInput wfInput = (IFileEditorInput) editorInput;
            fileName = wfInput.getFile().getName();
        } else if (editorInput instanceof URIEditorInput) {
            URIEditorInput wfInput = (URIEditorInput) editorInput;
            String[] segments = wfInput.getURI().segments();
            fileName = segments[segments.length - 1];
        }

        if (fileName != null) {
            fileName = fileName.substring(0, fileName.lastIndexOf("_")); //$NON-NLS-1$
        }

        return fileName;
    }
}
