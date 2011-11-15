// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
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
public class XObjectBrowser2 extends XObjectBrowser implements ITabbedPropertySheetPageContributor, ISvnHistory {

    static Logger log = Logger.getLogger(XObjectBrowser2.class);

    public static final String EDITOR_ID = "org.talend.mdm.repository.ui.editors.XObjectBrowser2"; //$NON-NLS-1$

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor#getContributorId()
     */
    public String getContributorId() {
        if (hasSvnHistory())
            return CONTRUIBUTIONID_SVNHISTORY;
        return null;
    }

    public Object getAdapter(Class adapter) {
        if (adapter == IPropertySheetPage.class && hasSvnHistory())
            return new TabbedPropertySheetPage(this);
        return super.getAdapter(adapter);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.forms.editor.FormEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
     */
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        // TODO Auto-generated method stub
        super.init(site, input);
        if (hasSvnHistory()) {
            IRepositoryViewEditorInput editorInput = (IRepositoryViewEditorInput) input;
            SvnHistorySelectionProvider provider = new SvnHistorySelectionProvider(editorInput);
            site.setSelectionProvider(provider);
        }
    }

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

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.ui.editors.ISvnHistory#hasSvnHistory()
     */
    public boolean hasSvnHistory() {
        try {
            if (ProxyRepositoryFactory.getInstance().isLocalConnectionProvider()) {
                return false;
            }
        } catch (PersistenceException e) {
            log.error(e);
            return false;
        }
        return true;
    }

}
