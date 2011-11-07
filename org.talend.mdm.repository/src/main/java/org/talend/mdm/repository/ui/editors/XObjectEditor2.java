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

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.core.service.DeployService.DeployStatus;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.ui.contributor.SvnHistorySelectionProvider;
import org.talend.mdm.repository.ui.dialogs.message.MutliStatusDialog;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.ui.preferences.PreferenceConstants;
import org.talend.mdm.repository.utils.Bean2EObjUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.editors.AFormPage;
import com.amalto.workbench.editors.DataClusterMainPage;
import com.amalto.workbench.editors.JobMainPage;
import com.amalto.workbench.editors.MenuMainPage;
import com.amalto.workbench.editors.XObjectEditor;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.views.MDMPerspective;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class XObjectEditor2 extends XObjectEditor implements ITabbedPropertySheetPageContributor, ISvnHistory {

    static Logger log = Logger.getLogger(XObjectEditor2.class);

    public static final String EDITOR_ID = "org.talend.mdm.repository.ui.editors.XObjectEditor2"; //$NON-NLS-1$

    @Override
    public void doSave(IProgressMonitor monitor) {

        this.saveInProgress = true;
        try {
            // For the XMLEditor(the schema editor for the data model),it should be saved and then just refresh the data
            // model page and do nothing else if there are some changes.
            if (xmlEditor != null && this.getCurrentPage() == 1) {
                xmlEditor.doSave(monitor);
                ((AFormPage) (formPages.get(0))).refreshPage();
                return;
            }
            int numPages = formPages.size();
            monitor.beginTask(Messages.bind(Messages.XObjectEditor2_saving, this.getEditorInput().getName()), numPages + 1);
            for (int i = 0; i < numPages; i++) {
                if ((formPages.get(i)) instanceof AFormPage) {
                    if (!((AFormPage) (formPages.get(i))).beforeDoSave())
                        return;
                }
                (formPages.get(i)).doSave(monitor);
                monitor.worked(1);
                if (monitor.isCanceled()) {
                    this.saveInProgress = false;
                    return;
                }
            }
            // if(xmlEditor!=null)xmlEditor.doSave(monitor);
            // perform the actual save

            boolean saved = saveResourceToRepository();
            if (xmlEditor != null && saved) {
                xmlEditor.refresh();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            monitor.done();
        }
    }

    private boolean saveResourceToRepository() {
        XObjectEditorInput2 editorInput = (XObjectEditorInput2) this.getEditorInput();
        TreeObject xobject = (TreeObject) editorInput.getModel();
        MDMServerObjectItem serverObjectItem = (MDMServerObjectItem) editorInput.getInputItem();
        MDMServerObject serverObject = serverObjectItem.getMDMServerObject();
        EObject eObj = Bean2EObjUtil.getInstance().convertFromBean2EObj(xobject.getWsObject(), serverObject);
        if (eObj != null) {
            serverObject.setChanged(true);
            IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
            try {
                factory.save(serverObjectItem);
                // TODO should call the following,but the page in editor has many call to remote webService ,it will
                // search ServerRoot which cause a NPE
                // xobject.fireEvent(IXObjectModelListener.SAVE, xobject.getParent(), xobject);
                editorDirtyStateChanged();

                refreshDirtyCue();
                if (PlatformUI.getPreferenceStore().getBoolean(PreferenceConstants.P_AUTO_DEPLOY)) {
                    autoDeploy(serverObject);
                }
                return true;
            } catch (PersistenceException e) {
                log.error(e.getMessage(), e);
            }
        }
        return false;
    }

    private void autoDeploy(MDMServerObject serverObject) {
        if (serverObject.getLastServerDef() != null) {
            IEditorInput input = getEditorInput();
            XObjectEditorInput2 theInput = null;
            if (input instanceof XObjectEditorInput2) {
                theInput = (XObjectEditorInput2) input;
            }
            IRepositoryViewObject viewObj = theInput.getViewObject();
            List<IRepositoryViewObject> viewObjs = new ArrayList<IRepositoryViewObject>();
            viewObjs.add(viewObj);

            IStatus status = DeployService.getInstance().deploy(serverObject.getLastServerDef(), viewObjs);
            updateChangedStatus(status);
            if (status.isMultiStatus()) {
                showDeployStatus(status);
            }
        } else {
            MessageDialog.openWarning(getSite().getShell(), Messages.Warning_text, Messages.TheObject_text + " " //$NON-NLS-1$
                    + serverObject.getName() + " " + Messages.NeverDeploy_text);//$NON-NLS-1$
        }
    }

    protected void updateChangedStatus(IStatus status) {
        if (status.isMultiStatus()) {
            for (IStatus childStatus : status.getChildren()) {
                DeployService.DeployStatus deployStatus = (DeployStatus) childStatus;
                if (deployStatus.isOK()) {
                    if (deployStatus.getItem() instanceof MDMServerObjectItem) {
                        MDMServerObjectItem item = (MDMServerObjectItem) deployStatus.getItem();
                        MDMServerObject mdmServerObject = item.getMDMServerObject();
                        mdmServerObject.setChanged(false);
                    }
                }
            }
        }
    }

    protected void showDeployStatus(IStatus status) {
        MutliStatusDialog dialog = new MutliStatusDialog(getSite().getShell(), status.getChildren().length
                + Messages.AbstractDeployAction_deployMessage, status);
        dialog.open();
    }

    private void refreshDirtyCue() {
        IEditorInput input = getEditorInput();
        XObjectEditorInput2 theInput = null;
        if (input instanceof XObjectEditorInput2) {
            theInput = (XObjectEditorInput2) input;
        }
        IRepositoryViewObject viewObj = theInput.getViewObject();
        CommonViewer viewer = MDMRepositoryView.show().getCommonViewer();
        viewer.refresh(viewObj);

    }

    protected void addPageForXObject(TreeObject xobject) {
        try {
            switch (xobject.getType()) {
            case TreeObject.DATA_MODEL:
                // addPage(new DataModelMainPage(this));
                //
                // // addPage(new DataModelEditorPage(this));
                // WSDataModel wsObject = (WSDataModel) (xobject.getWsObject());
                // Document doc = new Document(Util.formatXsdSource(wsObject.getXsdSchema()));
                // xmlEditor = new XMLEditor(this, xobject);
                // addPage(xmlEditor, new XMLEditorInput(doc));
                // this.setPageText(1, "Schema");

                break;

            case TreeObject.INBOUND_PLUGIN:
                break;
            case TreeObject.OUTBOUND_PLUGIN:
                break;
            case TreeObject.VIEW:
                addPage(new ViewMainPage2(this));
                break;
            case TreeObject.DATA_CLUSTER:
                addPage(new DataClusterMainPage(this));
                break;
            case TreeObject.STORED_PROCEDURE:
                addPage(new StoredProcedureMainPage2(this));
                break;

            case TreeObject.MENU:
                addPage(new MenuMainPage(this));
                break;
            case TreeObject.SERVICE_CONFIGURATION:
                addPage(new MDMServiceConfigrationMainPage(this));
                break;
            /*
             * case TreeObject.RESOURCES: case TreeObject.DATA_MODEL_RESOURCE: case
             * TreeObject.DATA_MODEL_TYPES_RESOURCE: case TreeObject.CUSTOM_TYPES_RESOURCE: case
             * TreeObject.PICTURES_RESOURCE: addPage(new ResourceMainPage(this)); break;
             */
            case TreeObject.CUSTOM_TYPE:
                // addPage(new CustomTypeMainPage(this));
                break;
            case TreeObject.ROUTING_RULE:
                addPage(new RoutingRuleMainPage2(this));
                break;
            case TreeObject.TRANSFORMER:
                addPage(new TransformerMainPage2(this));
                break;
            case TreeObject.JOB:
                addPage(new JobMainPage(this));
                break;

            default:
                // MessageDialog.openError(this.getSite().getShell(), "Error",
                // "Unknown "+IConstants.TALEND+" Object Type: "+xobject.getType());
                return;
            }// switch

        } catch (PartInitException e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(this.getSite().getShell(), Messages.Common_Error,
                    Messages.bind(Messages.XObjectEditor2_unableOpenEditor, e.getLocalizedMessage()));
        }
    }

    @Override
    public boolean isLocalInput() {
        return true;
    }

    @Override
    public boolean isReadOnly() {
        IRepositoryViewEditorInput editorInput = (IRepositoryViewEditorInput) this.getEditorInput();
        return editorInput.isReadOnly();
    }

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

    /*
     * (non-Javadoc)
     * 
     * @see com.amalto.workbench.editors.XObjectEditor#addPages()
     */
    @Override
    protected void addPages() {
        // TODO Auto-generated method stub
        super.addPages();
        try {
            refreshPropertyView();
        } catch (PartInitException e) {

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
