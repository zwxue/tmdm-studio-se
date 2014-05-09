// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.editors;

import org.apache.log4j.Logger;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.commmon.util.webapp.XSystemObjects;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.utils.EclipseResourceManager;

import com.amalto.workbench.editors.DataClusterBrowserMainPage;
import com.amalto.workbench.editors.DataClusterStagingBrowserMainPage;
import com.amalto.workbench.editors.ItemsTrashBrowserMainPage;
import com.amalto.workbench.editors.XObjectBrowser;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.views.MDMPerspective;

/**
 * DOC achen  class global comment. Detailled comment
 */
public class XObjectBrowser2 extends XObjectBrowser implements ISvnHistory {

    static Logger log = Logger.getLogger(XObjectBrowser2.class);

    public static final String EDITOR_ID = "org.talend.mdm.repository.ui.editors.XObjectBrowser2"; //$NON-NLS-1$

    private final String masterImgPath = "icons/dataclustermaster.png"; //$NON-NLS-1$

    private final String stagingImgPath = "icons/dataclusterstaging.png"; //$NON-NLS-1$


    private void refreshPropertyView() throws PartInitException {

        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

        IViewPart propView = page.findView(MDMPerspective.VIEWID_PROPERTYVIEW);

        if (propView != null) {
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(propView);
        }

        page.showView(MDMPerspective.VIEWID_PROPERTYVIEW);
    }
    /*
     * (non-Javadoc)
     * 
     * @see com.amalto.workbench.editors.XObjectEditor#addPages()
     */
    @Override
    protected void addPages() {
        super.addPages();
        try {
            refreshPropertyView();
        } catch (PartInitException e) {

        }
    }

    @Override
    protected void addPageForXObject(TreeObject xobject) throws PartInitException {
        switch (xobject.getType()) {
        case TreeObject.VIEW:
            addPage(new ViewBrowserMainPage2(this));
            break;
        case TreeObject.DATA_CLUSTER:
            if (xobject.getDisplayName() != null && xobject.getDisplayName().equals(XSystemObjects.DC_MDMITEMSTRASH.getName())) {
                addPage(new ItemsTrashBrowserMainPage(this));
                break;
            }
            addPage(new DataClusterBrowserMainPage(this));// page index 0
            setPageImage(0, EclipseResourceManager.getImage(RepositoryPlugin.PLUGIN_ID, masterImgPath));
            if (!isSystemCluster()) {
                addPage(new DataClusterStagingBrowserMainPage(this));// page index 1
                setPageImage(1, EclipseResourceManager.getImage(RepositoryPlugin.PLUGIN_ID, stagingImgPath));
            }
            break;
        case TreeObject.SUBSCRIPTION_ENGINE:
            try {
                addPage(new RoutingEngineV2BrowserMainPage2(this));
            } catch (PartInitException e) {
                log.error(e.getMessage(), e);
            }
            break;

        }// switch
    }

    private boolean isSystemCluster() {
        XObjectBrowserInput2 editorInput = (XObjectBrowserInput2) getEditorInput();
        IRepositoryViewObject viewObject = editorInput.getViewObject();
        ERepositoryObjectType objectType = viewObject.getRepositoryObjectType();
        if (objectType == IServerObjectRepositoryType.TYPE_DATACLUSTER) {
            String path = viewObject.getPath();
            if (path.toLowerCase().startsWith("system") || path.toLowerCase().startsWith("/system")) { //$NON-NLS-1$ //$NON-NLS-2$
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isLocalInput() {
        return true;
    }
}
