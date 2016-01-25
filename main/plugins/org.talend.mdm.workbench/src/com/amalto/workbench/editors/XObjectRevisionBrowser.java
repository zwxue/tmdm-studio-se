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
package com.amalto.workbench.editors;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSPutUniverse;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.XtentisPort;

public class XObjectRevisionBrowser extends FormEditor {

    private static Log log = LogFactory.getLog(XObjectRevisionBrowser.class);

    public static String ID = "com.amalto.workbench.editors.XObjectRevisionBrowser";//$NON-NLS-1$

    private ArrayList<IFormPage> formPages = new ArrayList<IFormPage>();

    private TreeObject initialXObject = null; // backup

    protected boolean saveInProgress = false;

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
     */
    protected void addPages() {
        try {

            updateTitle();

            TreeObject xobject = (TreeObject) ((XObjectBrowserInput) this.getEditorInput()).getModel();

            if (xobject.isXObject())
                return;

            if (Util.hasUniverse(xobject))
                addPage(new BrowseRevisionMainPage(this));
            else
                MessageDialog.openError(this.getSite().getShell(), Messages._Error, Messages.bind(Messages.XObjectRevisionBrowser_ErrorMsg, IConstants.TALEND, xobject.getType()));

            // switch
        } catch (PartInitException e) {
            MessageDialog.openError(this.getSite().getShell(), Messages._Error, Messages.bind(Messages.XObjectRevisionBrowser_ErrorMsg1, e.getLocalizedMessage()));
        }
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
        // System.out.println("doSave");
        try {
            this.saveInProgress = true;
            int numPages = formPages.size();
            monitor.beginTask(Messages.bind(Messages.XObjectRevisionBrowser_Saving, this.getEditorInput().getName()), numPages + 1);
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
                TreeObject xobject = (TreeObject) ((XObjectBrowserInput) this.getEditorInput()).getModel();
                if (!xobject.isXObject())
                    return;

                // Access to server and get port

                XtentisPort port = Util.getPort(new URL(xobject.getEndpointAddress()), xobject.getUniverse(),
                        xobject.getUsername(), xobject.getPassword());
                List<WSUniverse> universes = ((BrowseRevisionMainPage) formPages.get(i)).getUniverses();
                for (WSUniverse wsUniverse : universes)
                    port.putUniverse(new WSPutUniverse(wsUniverse));
            }
        } catch (RemoteException e) {
            log.error(e.getMessage(), e);

        } catch (MalformedURLException e) {
            log.error(e.getMessage(), e);
        } catch (XtentisException e) {
            log.error(e.getMessage(), e);
        }

        monitor.done();
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
        setPartName(input.getName().replaceAll("\\[.*\\]", ""));//$NON-NLS-1$//$NON-NLS-2$
        setContentDescription("");//$NON-NLS-1$
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
        else if (object.getType() == TreeObject.SYNCHRONIZATIONPLAN)
            return ImageCache.getCreatedImage(EImage.SYNCHRONIZATIONPLAN.getPath());

        return ImageCache.getCreatedImage(EImage.ERROR.getPath());
    }

}
