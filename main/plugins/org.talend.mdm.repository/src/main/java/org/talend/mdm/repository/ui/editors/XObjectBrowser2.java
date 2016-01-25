// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.mdm.commmon.util.webapp.XSystemObjects;
import org.talend.mdm.repository.ui.contributor.SvnHistorySelectionProvider;

import com.amalto.workbench.editors.DataClusterBrowserMainPage;
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
            addPage(new DataClusterBrowserMainPage(this));
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

    public boolean isLocalInput() {
        return true;
    }
}
