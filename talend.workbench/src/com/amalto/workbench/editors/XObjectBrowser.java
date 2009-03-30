/*
 * Created on 27 oct. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.amalto.workbench.editors;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.amalto.workbench.models.IXObjectModelListener;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.Version;
import com.amalto.workbench.utils.XtentisException;


public class XObjectBrowser extends FormEditor implements IXObjectModelListener{	
	
	private ArrayList<IFormPage> formPages = new ArrayList<IFormPage>();
	private TreeObject initialXObject = null;  //backup
	
	/*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
     */
    protected void addPages() {
        try {
        	
        	updateTitle();
        	
        	TreeObject xobject = (TreeObject)((XObjectBrowserInput)this.getEditorInput()).getModel();
        	
        	if (!xobject.isXObject()) return;
        	
        	//register model listener in order to close the browser when object is removed
        	xobject.addListener(this);
        	
            switch(xobject.getType()) {
	           	case TreeObject.VIEW:
	           		addPage(new  ViewBrowserMainPage(this));
	           		break;
	           	case TreeObject.DATA_CLUSTER:
	           		addPage(new  DataClusterBrowserMainPage(this));
	           		break;	    
	           	case TreeObject.SUBSCRIPTION_ENGINE:
	           		boolean version_greater_2_19_0 = false;
					try {	
						Version ver = Util.getVersion(xobject);
						version_greater_2_19_0 = (ver.getMajor()>2) || ((ver.getMajor()==2)&&(ver.getMinor()>=19));
					} catch (XtentisException e) {}
	           		if (version_greater_2_19_0)
	           			addPage(new  RoutingEngineV2BrowserMainPage(this));
	           		else
	           			addPage(new  SubscriptionEngineBrowserMainPage(this));
	           		break;	    	           		
	           	default:
	           		MessageDialog.openError(this.getSite().getShell(), "Error", "Unsupported Xtentis Object Type: "+xobject.getType());
	           		return;
            }//switch
        } catch (PartInitException e) {
            MessageDialog.openError(this.getSite().getShell(), "Error", "Unable to open the editor :"+e.getLocalizedMessage());
        }
    }
    
    
    //Overloaded - Fixes issues with getEditor()
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
    	//NO saving on browsers
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
		//save space
		TreeObject xobject = (TreeObject)((XObjectBrowserInput)this.getEditorInput()).getModel(); 
		if (xobject!=null) { 
				xobject.setWsObject(null);
				//xobject.removeListener(this);
		}
		super.dispose();
	}

	/**
	 * Model Listener
	 */
	/*
	public void handleEvent(int type, TreeObject parent, TreeObject child) {
		System.out.println("XObjectBrowser Handle Event "+child.getDisplayName()+" - "+type);
		TreeObject xobject = (TreeObject)((XObjectBrowserInput)this.getEditorInput()).getModel();
		switch(type) {
			case IXObjectModelListener.DELETE:
				if (xobject.equals(child)) this.close(false);
				break;
			case IXObjectModelListener.SAVE:
			case IXObjectModelListener.UPDATE:
				if (xobject.equals(child)) {
					//((AFormPage)getActivePageInstance()).refreshPage();
			    	for (int i = formPages.size()-1; i >=0 ; i--) {
			    		((AFormPage) formPages.get(i)).refreshPage();
					}
				}
			default:
		}
	}
	*/


	public TreeObject getInitialXObject() {
		return initialXObject;
	}

    
    protected void pageChange(int newPageIndex) {
        super.pageChange(newPageIndex);
        AFormPage page = (AFormPage)formPages.get(newPageIndex);
        page.refreshPage();
    }

    @Override
    public Image getTitleImage() {
    	TreeObject object = (TreeObject)((XObjectBrowserInput)this.getEditorInput()).getModel();
    	
		if (object.getType() == TreeObject._SERVER_)
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/xtentis_server.gif").createImage();
		else if (object.getType() == TreeObject.DATA_CLUSTER)
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/data_cluster.gif").createImage();
		else if (object.getType() == TreeObject.DATA_MODEL)
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/data_model.gif").createImage();
		else if (object.getType() == TreeObject.MENU)
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/menu.gif").createImage();
		else if (object.getType() == TreeObject.TRANSFORMER)
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/transformer.gif").createImage();
		else if (object.getType() == TreeObject.ROLE)
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/role.gif").createImage();
		else if (object.getType() == TreeObject.STORED_PROCEDURE)
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/stored_procedure.gif").createImage();
		else if (object.getType() == TreeObject.ROUTING_RULE)
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/routing_rule.gif").createImage();
		else if (object.getType() == TreeObject.VIEW)
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/view.gif").createImage();
		else if (object.getType() == TreeObject.DOCUMENT)
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/documents.gif").createImage();			
		else if (object.getType() == TreeObject.SUBSCRIPTION_ENGINE)
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/routing_rule.gif").createImage();
		
		return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/error.gif").createImage();
    }
    
    
    
    
    
    /**
	 * Model Listener
	 */
	public void handleEvent(int type, TreeObject parent, TreeObject child) {
		TreeObject xobject = (TreeObject)((XObjectBrowserInput)this.getEditorInput()).getModel();
		switch(type) {
			case IXObjectModelListener.DELETE:
				if (xobject.equals(child)) this.close(false);
				break;
			/*
			case IXObjectModelListener.SAVE:
				if (saveInProgress)
					this.editorDirtyStateChanged();
				break;
			case IXObjectModelListener.UPDATE:
				if (xobject.equals(child)) {
					((AFormPage)getActivePageInstance()).refreshPage();
				}
			*/
			default:
		}
	}
    
}
