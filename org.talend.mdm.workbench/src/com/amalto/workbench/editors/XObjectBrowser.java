/*
 * Created on 27 oct. 2005
 * 
 * To change the template for this generated file go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and
 * Comments
 */
package com.amalto.workbench.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.talend.mdm.commmon.util.webapp.XSystemObjects;

import com.amalto.workbench.availablemodel.AvailableModelUtil;
import com.amalto.workbench.availablemodel.IAvailableModel;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.IXObjectModelListener;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectBrowserInput;

public class XObjectBrowser extends FormEditor implements IXObjectModelListener {

    public static String ID = "com.amalto.workbench.editors.XObjectBrowser";

    private ArrayList<IFormPage> formPages = new ArrayList<IFormPage>();

    private TreeObject initialXObject = null; // backup

    private TdEditorToolBar toolBar;

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
     */
    protected void addPages() {
        try {

            updateTitle();

            TreeObject xobject = (TreeObject) ((XObjectBrowserInput) this.getEditorInput()).getModel();

            if (!xobject.isXObject())
                return;

            // register model listener in order to close the browser when object is removed
            xobject.addListener(this);
            // available models
            java.util.List<IAvailableModel> availablemodels = AvailableModelUtil.getAvailableModels();
            for (IAvailableModel model : availablemodels) {
                model.addPage(xobject, this);
            }

            switch (xobject.getType()) {
            case TreeObject.VIEW:
                addPage(new ViewBrowserMainPage(this));
                break;
            case TreeObject.DATA_CLUSTER:
                if (xobject.getDisplayName() != null
                        && xobject.getDisplayName().equals(XSystemObjects.DC_MDMITEMSTRASH.getName())) {
                    addPage(new ItemsTrashBrowserMainPage(this));
                    break;
                }
                addPage(new DataClusterBrowserMainPage(this));
                break;
            case TreeObject.SUBSCRIPTION_ENGINE:
                try {
                    addPage(new RoutingEngineV2BrowserMainPage(this));
                } catch (PartInitException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;

            }// switch
        } catch (PartInitException e) {
            MessageDialog.openError(this.getSite().getShell(), "Error", "Unable to open the editor :" + e.getLocalizedMessage());
        }
    }

    protected void createToolbar(final Composite parent, List<Action> actions) {

        toolBar = new TdEditorToolBar(parent, actions);

        FormData data = new FormData();
        data.top = new FormAttachment(0, 0);
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        toolBar.getToolbarControl().setLayoutData(data);

        toolBar.addResizeListener(new ControlListener() {

            public void controlMoved(ControlEvent e) {
            }

            public void controlResized(ControlEvent e) {
                parent.getParent().layout(true);
                parent.layout(true);
            }
        });
    }

    protected Composite createPageContainer(Composite parent) {
        GridLayout gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.numColumns = 1;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        parent.setLayout(gridLayout);

        Composite barComp = new Composite(parent, SWT.NONE);
        GridData gdData = new GridData(GridData.FILL_HORIZONTAL);
        barComp.setLayoutData(gdData);
        barComp.setLayout(new FormLayout());
        List<Action> actions = new ArrayList<Action>();
        actions.add(new RefreshSectionAction());
        createToolbar(barComp, actions);

        Composite mainParent = new Composite(parent, SWT.NONE);
        GridData gdData1 = new GridData(GridData.FILL_BOTH);
        gdData1.grabExcessVerticalSpace = true;
        mainParent.setLayoutData(gdData1);
        return super.createPageContainer(mainParent);
    }

    // Overloaded - Fixes issues with getEditor()
    public int addPage(IFormPage page) throws PartInitException {
        formPages.add(page);
        return super.addPage(page);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor)
     */
    public void doSave(IProgressMonitor monitor) {
        // NO saving on browsers
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.ISaveablePart#isSaveAsAllowed()
     */
    public boolean isSaveAsAllowed() {
        return false;
    }

    public void doSaveAs() {
    }

    private void updateTitle() {
        IEditorInput input = this.getEditorInput();
        setPartName(input.getName());
        setContentDescription("");
    }

    public void dispose() {
        // save space
        TreeObject xobject = (TreeObject) ((XObjectBrowserInput) this.getEditorInput()).getModel();
        if (xobject != null) {
            xobject.setWsObject(null);
            // xobject.removeListener(this);
        }
        formPages.clear();
        super.dispose();
    }

    /**
     * Model Listener
     */
    /*
     * public void handleEvent(int type, TreeObject parent, TreeObject child) {
     * System.out.println("XObjectBrowser Handle Event "+child.getDisplayName()+" - "+type); TreeObject xobject =
     * (TreeObject)((XObjectBrowserInput)this.getEditorInput()).getModel(); switch(type) { case
     * IXObjectModelListener.DELETE: if (xobject.equals(child)) this.close(false); break; case
     * IXObjectModelListener.SAVE: case IXObjectModelListener.UPDATE: if (xobject.equals(child)) {
     * //((AFormPage)getActivePageInstance()).refreshPage(); for (int i = formPages.size()-1; i >=0 ; i--) {
     * ((AFormPage) formPages.get(i)).refreshPage(); } } default: } }
     */

    public TreeObject getInitialXObject() {
        return initialXObject;
    }

    protected void pageChange(int newPageIndex) {
        super.pageChange(newPageIndex);
        AFormPage page = (AFormPage) formPages.get(newPageIndex);
        page.refreshPage();
    }

    @Override
    public Image getTitleImage() {
        TreeObject object = (TreeObject) ((XObjectBrowserInput) this.getEditorInput()).getModel();

        if (object.getType() == TreeObject._SERVER_)
            return ImageCache.getCreatedImage(EImage.TALEND_PICTO_SMALL.getPath());
        else if (object.getType() == TreeObject.DATA_CLUSTER)
            return ImageCache.getCreatedImage(EImage.DATA_CLUSTER.getPath());
        else if (object.getType() == TreeObject.DATA_MODEL)
            return ImageCache.getCreatedImage(EImage.DATA_MODEL.getPath());
        else if (object.getType() == TreeObject.MENU)
            return ImageCache.getCreatedImage(EImage.MENU.getPath());
        else if (object.getType() == TreeObject.TRANSFORMER)
            return ImageCache.getCreatedImage(EImage.TRANSFORMER.getPath());
        else if (object.getType() == TreeObject.ROLE)
            return ImageCache.getCreatedImage(EImage.ROLE.getPath());
        else if (object.getType() == TreeObject.STORED_PROCEDURE)
            return ImageCache.getCreatedImage(EImage.STORED_PROCEDURE.getPath());
        else if (object.getType() == TreeObject.ROUTING_RULE)
            return ImageCache.getCreatedImage(EImage.ROUTING_RULE.getPath());
        else if (object.getType() == TreeObject.VIEW)
            return ImageCache.getCreatedImage(EImage.VIEW.getPath());
        else if (object.getType() == TreeObject.DOCUMENT)
            return ImageCache.getCreatedImage(EImage.DOCUMENTS.getPath());
        else if (object.getType() == TreeObject.SUBSCRIPTION_ENGINE)
            return ImageCache.getCreatedImage(EImage.SUBSCRIPTION_ENGINE.getPath());
        else if (object.getType() == TreeObject.WORKFLOW_PROCESS)
            return ImageCache.getCreatedImage(EImage.WORKFLOW_PROCESS.getPath());
        else if (object.getType() == TreeObject.JOB)
            return ImageCache.getCreatedImage(EImage.JOB.getPath());
        return ImageCache.getCreatedImage(EImage.ERROR.getPath());
    }

    /**
     * Model Listener
     */
    public void handleEvent(int type, TreeObject parent, TreeObject child) {
        TreeObject xobject = (TreeObject) ((XObjectBrowserInput) this.getEditorInput()).getModel();
        switch (type) {
        case IXObjectModelListener.DELETE:
            if (xobject.equals(child))
                this.close(false);
            break;
        /*
         * case IXObjectModelListener.SAVE: if (saveInProgress) this.editorDirtyStateChanged(); break; case
         * IXObjectModelListener.UPDATE: if (xobject.equals(child)) {
         * ((AFormPage)getActivePageInstance()).refreshPage(); }
         */
        default:
        }
    }

    private class RefreshSectionAction extends Action {

        public RefreshSectionAction() {
            super("Refresh"); //$NON-NLS-1$
            setToolTipText("Refresh");
            this.setImageDescriptor(ImageCache.getImage(EImage.REFRESH.getPath()));
        }

        @Override
        public void run() {
            IFormPage page = formPages.get(getCurrentPage());
            if (page != null && page instanceof AFormPage) {
                ((AFormPage) page).refreshPage();
            }
        }
    }

    public IFormPage getPage(int index) {
        return formPages.get(index);
    }
}
