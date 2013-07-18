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

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;

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

        return getWorkflowViewObject(workflowName);
    }

    public static IRepositoryViewObject getWorkflowViewObject(String workflowName) {
        if (workflowName != null) {
            IRepositoryViewObject[] categoryViewObjects = RepositoryResourceUtil.getCategoryViewObjects();
            for (IRepositoryViewObject viewObj : categoryViewObjects) {
                if (viewObj.getRepositoryObjectType().equals(IServerObjectRepositoryType.TYPE_WORKFLOW)) {
                    List<IRepositoryViewObject> workflowObjs = viewObj.getChildren();

                    for (IRepositoryViewObject workflowObj : workflowObjs) {
                        if (workflowName.equals(getWorkflowObjectName(workflowObj))) {
                            return workflowObj;
                        }
                    }
                }
            }
        }

        return null;
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

    private static String getWorkflowObjectName(IRepositoryViewObject viewObj) {
        if (viewObj == null || !viewObj.getRepositoryObjectType().equals(IServerObjectRepositoryType.TYPE_WORKFLOW)) {
            return null;
        }

        String workflowName = null;

        Item item = viewObj.getProperty().getItem();
        if (item instanceof MDMServerObjectItem) {
            MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
            if (serverObject != null) {
                workflowName = serverObject.getName();
            }
        }

        if (workflowName == null) {
            workflowName = item.getProperty().getLabel();
        }

        if (workflowName != null) {
            workflowName = workflowName.replace("$", "#"); //$NON-NLS-1$ //$NON-NLS-2$
        }

        return workflowName;
    }
}
