/*
 * Created on 27 oct. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.amalto.workbench.editors;

import java.util.ArrayList;
import java.util.LinkedList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.Document;
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
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;

import com.amalto.workbench.actions.SaveXObjectAction;
import com.amalto.workbench.availablemodel.AvailableModelUtil;
import com.amalto.workbench.availablemodel.IAvailableModel;
import com.amalto.workbench.editors.xmleditor.XMLEditor;
import com.amalto.workbench.editors.xmleditor.XMLEditorInput;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.IXObjectModelListener;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSDataModel;

public class XObjectEditor extends FormEditor implements IXObjectModelListener{	
	
	public ArrayList<IFormPage> formPages = new ArrayList<IFormPage>();
	private TreeObject initialXObject = null;  //backup
	
	protected boolean saveInProgress = false;
	
	protected XMLEditor xmlEditor;
	private com.amalto.workbench.editors.XObjectEditor.TdEditorToolBar toolBar;
	/*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
     */
    protected void addPages() {
        try {
        	updateTitle();
        	
        	TreeObject xobject = (TreeObject)((XObjectEditorInput)this.getEditorInput()).getModel();
        	
        	//backup initial object
        	this.initialXObject = new TreeObject(
        			xobject.getDisplayName(),
        			xobject.getServerRoot(),
        			xobject.getType(),
        			xobject.getWsKey(),
        			xobject.getWsObject(),
        			xobject.getAdditionalInfo()
        	);
        	
        	if (!xobject.isXObject()) return;
        	
        	//register model listener
        	xobject.addListener(this);
			//available models
			java.util.List<IAvailableModel> availablemodels=AvailableModelUtil.getAvailableModels();
			for(IAvailableModel model: availablemodels){
				model.addPage(xobject,this);
			}
            switch(xobject.getType()) {
	           	case TreeObject.DATA_MODEL:
	           		addPage(new DataModelMainPage(this));

                    //addPage(new DataModelEditorPage(this));
	           		WSDataModel wsObject = (WSDataModel) (xobject.getWsObject()); 
	           		Document doc = new Document(Util.formatXsdSource(wsObject.getXsdSchema()));
	           		xmlEditor=new XMLEditor(this, xobject);
	           		addPage(xmlEditor, new XMLEditorInput(doc));	           		
	           		this.setPageText(1, "Schema");

	           		break;
	           		
	           	case TreeObject.INBOUND_PLUGIN:
	           		break;
	           	case TreeObject.OUTBOUND_PLUGIN:
	           		break;
	           	case TreeObject.VIEW:
	           		addPage(new  ViewMainPage(this));
	           		break;
	           	case TreeObject.DATA_CLUSTER:
                    addPage(new DataClusterMainPage(this));
	           		break;
	           	case TreeObject.STORED_PROCEDURE:
                    addPage(new StoredProcedureMainPage(this));
	           		break;	
	           			           
	           	case TreeObject.MENU:
                    addPage(new MenuMainPage(this));
	           		break;
	           	case TreeObject.SERVICE_CONFIGURATION:
	           		addPage(new  ServiceConfigrationMainPage(this));
	           		break;
/*	           	case TreeObject.RESOURCES:
				case TreeObject.DATA_MODEL_RESOURCE:	
				case TreeObject.DATA_MODEL_TYPES_RESOURCE:	
				case TreeObject.CUSTOM_TYPES_RESOURCE:	
				case TreeObject.PICTURES_RESOURCE:	
	           		addPage(new  ResourceMainPage(this));
	           		break;*/
				case TreeObject.CUSTOM_TYPE:
//			 		addPage(new  CustomTypeMainPage(this));
					break;
				case TreeObject.ROUTING_RULE:
			        try {
						addPage(new RoutingRuleMainPage(this));
					} catch (PartInitException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   		break;
				case TreeObject.TRANSFORMER:
					try {
						addPage(new TransformerMainPage(this));
					} catch (PartInitException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   		break;	
		       	case TreeObject.JOB:
		       		try {
						addPage(new JobMainPage(this));
					} catch (PartInitException e) {
						e.printStackTrace();
					}
		       		break;							
	           	default:
	           		//MessageDialog.openError(this.getSite().getShell(), "Error", "Unknown "+IConstants.TALEND+" Object Type: "+xobject.getType());
	           		return;
            }//switch
        } catch (PartInitException e) {
            MessageDialog.openError(this.getSite().getShell(), "Error", "Unable to open the editor :"+e.getLocalizedMessage());
        }
    }
    
    
    //Overloaded - Fixes issues with getEditor()
    public int addPage(IFormPage page) throws PartInitException {
//    	((DataModelMainPage)page).markDirty();
    	formPages.add(page);
//		((DataModelMainPage)page).markDirty();
		return super.addPage(page);
	}

	/*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor)
     */
    public void doSave(IProgressMonitor monitor) {

			this.saveInProgress = true;
			//For the XMLEditor(the schema editor for the data model),it should be saved and then just refresh the data model page and do nothing else if there are some changes.
		if (xmlEditor != null&&this.getCurrentPage()==1) {
			xmlEditor.doSave(monitor);
			((AFormPage) (formPages.get(0))).refreshPage();
			return;
		}
			int numPages = formPages.size();
			monitor.beginTask("Saving " + this.getEditorInput().getName(),
					numPages + 1);
			for (int i = 0; i < numPages; i++) {
				if((formPages.get(i)) instanceof AFormPage){
					if(!((AFormPage)(formPages.get(i))).beforeDoSave())return;
				}
				(formPages.get(i)).doSave(monitor);
				monitor.worked(1);
				if (monitor.isCanceled()) {
					this.saveInProgress = false;
					return;
				}
			}
			//if(xmlEditor!=null)xmlEditor.doSave(monitor);
			//perform the actual save
			SaveXObjectAction action = new SaveXObjectAction(this);
			action.run();
			if (xmlEditor != null && action.getState() == 0) {
				xmlEditor.refresh();
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
    	setPartName(input.getName());
    	setContentDescription("");
    }


	public void dispose() {
		//save space
		TreeObject xobject = (TreeObject)((XObjectEditorInput)this.getEditorInput()).getModel(); 
		if (xobject!=null) { 
				xobject.setWsObject(null);
				xobject.removeListener(this);
		}
		super.dispose();
	}

	/**
	 * Model Listener
	 */
	public void handleEvent(int type, TreeObject parent, TreeObject child) {
		TreeObject xobject = (TreeObject)((XObjectEditorInput)this.getEditorInput()).getModel();
		switch(type) {
			case IXObjectModelListener.DELETE:
				if (xobject.equals(child)) this.close(false);
				break;
			case IXObjectModelListener.SAVE:
				if (saveInProgress)
					this.editorDirtyStateChanged();
				else
					/*
					MessageDialog.openWarning(
						this.getSite().getShell(),
						"Warning underlying data changed", 
						"The current displayed data may not be in sync with the data persisted on the server."
					);
					*/
				break;
			case IXObjectModelListener.UPDATE:
				if (xobject.equals(child)) {
					AFormPage activePage = ((AFormPage)getActivePageInstance());
					if (activePage == null)
					{
						int editPos = pages.indexOf(xmlEditor);
						if (editPos >= 1)
						{
							activePage = (AFormPage)pages.get(editPos -1);
						}
						xmlEditor.refresh();
					}
//					activePage.refreshPage();
					
					/*
			    	for (int i = formPages.size()-1; i >=0 ; i--) {
			    		((AFormPage) formPages.get(i)).refreshPage();
					}
					*/
				}
			default:
		}
	}


	public TreeObject getInitialXObject() {
		return initialXObject;
	}

    
    protected void pageChange(int newPageIndex) {
    	AFormPage page = (AFormPage)formPages.get(0);
    	boolean isdirty=page.isDirty();
        super.pageChange(newPageIndex);
                
    	if (xmlEditor != null) {
			xmlEditor.refresh();
			if (xmlEditor.isDirty() || xmlEditor.isModified()) {
				page.refreshPage();
				xmlEditor.setModified(false);
			}
		}
    	linkDirty(page, isdirty);   
                          
    }

	private void linkDirty(Object page, boolean dirty) {
		if(dirty){
			if(page instanceof DataModelMainPage ){
	        	
	        	if(findPage(DataModelMainPage.class.getName())!=null){
	        		DataModelMainPage mainPage = (DataModelMainPage)findPage(DataModelMainPage.class.getName());
	        		mainPage.markDirtyWithoutCommit();
	        	}			        	
	        }
		}
	}

    @Override
    public Image getTitleImage() {
    	TreeObject object = (TreeObject)((XObjectEditorInput)this.getEditorInput()).getModel();
    	
		if (object.getType() == TreeObject._SERVER_)
			return ImageCache.getImage( "icons/talend-picto-small.gif").createImage();
		else if (object.getType() == TreeObject.DATA_CLUSTER)
			return ImageCache.getImage( EImage.DATA_CLUSTER.getPath()).createImage();
		else if (object.getType() == TreeObject.DATA_MODEL)
			return ImageCache.getImage( EImage.DATA_MODEL.getPath()).createImage();
		else if (object.getType() == TreeObject.MENU)
			return ImageCache.getImage( EImage.MENU.getPath()).createImage();
		else if (object.getType() == TreeObject.TRANSFORMER)
			return ImageCache.getImage( EImage.TRANSFORMER.getPath()).createImage();
		else if (object.getType() == TreeObject.ROLE)
			return ImageCache.getImage( EImage.ROLE.getPath()).createImage();
		else if (object.getType() == TreeObject.STORED_PROCEDURE)
			return ImageCache.getImage( EImage.STORED_PROCEDURE.getPath()).createImage();
		else if (object.getType() == TreeObject.ROUTING_RULE)
			return ImageCache.getImage( EImage.ROUTING_RULE.getPath()).createImage();
		else if (object.getType() == TreeObject.VIEW)
			return ImageCache.getImage( EImage.VIEW.getPath()).createImage();
		else if (object.getType() == TreeObject.DOCUMENT)
			return ImageCache.getImage( EImage.DOCUMENTS.getPath()).createImage();			
		else if (object.getType() == TreeObject.SUBSCRIPTION_ENGINE)
			return ImageCache.getImage( EImage.SUBSCRIPTION_ENGINE.getPath()).createImage();
		else if (object.getType() == TreeObject.SYNCHRONIZATIONPLAN)
			return ImageCache.getImage( EImage.SYNCHRONIZATIONPLAN.getPath()).createImage();
		else if (object.getType() == TreeObject.UNIVERSE)
			return ImageCache.getImage( EImage.UNIVERSE.getPath()).createImage();
		else if (object.getType() == TreeObject.SERVICE_CONFIGURATION)
			return ImageCache.getImage( EImage.SERVICE_CONFIGURATION.getPath()).createImage();
		else if (object.getType() == TreeObject.RESOURCES
				|| object.getType() == TreeObject.DATA_MODEL_RESOURCE
				|| object.getType() == TreeObject.DATA_MODEL_TYPES_RESOURCE
				|| object.getType() == TreeObject.CUSTOM_TYPES_RESOURCE
				|| object.getType() == TreeObject.PICTURES_RESOURCE)
			return ImageCache.getCreatedImage(EImage.RESOURCES.getPath());
		else if(object.getType()==TreeObject.JOB)
			return ImageCache.getImage(EImage.JOB.getPath()).createImage();
		
		return ImageCache.getImage( "icons/error.gif").createImage();
    }


	public XMLEditor getXmlEditor() {
		return xmlEditor;
	}
    
	public int getCurrentPage() {
		// TODO Auto-generated method stub
		return super.getCurrentPage();
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

	        createToolbar(barComp);

	        Composite mainParent = new Composite(parent, SWT.NONE);
	        GridData gdData1 = new GridData(GridData.FILL_BOTH);
	        gdData1.grabExcessVerticalSpace = true;
	        mainParent.setLayoutData(gdData1);
	        return super.createPageContainer(mainParent);
	    }
	    protected void createToolbar(final Composite parent) {

	        toolBar = new TdEditorToolBar(parent);

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

	    /**
	     * DOC bzhou Comment method "getToolBar".
	     * 
	     * @return
	     */
	    public TdEditorToolBar getToolBar() {
	        return toolBar;
	    }	
	    
	    public class TdEditorToolBar {

	        private CoolBar coolBar = null;

	        private CoolBarManager coolBarMgr;

	        private ToolBarManager defaultToolBarMgr;


	        private LinkedList<Action> actions = new LinkedList<Action>();

	        public TdEditorToolBar(Composite parent) {

	            // create coolbar

	            coolBar = new CoolBar(parent, SWT.FLAT);
	            coolBarMgr = new CoolBarManager(coolBar);

	            GridData gid = new GridData();
	            gid.horizontalAlignment = GridData.FILL;
	            coolBar.setLayoutData(gid);

	            // initialize default actions
	            defaultToolBarMgr = new ToolBarManager(SWT.FLAT);

	            actions.add(new RefreshSectionAction());

	            for (Action action : actions) {
	                defaultToolBarMgr.add(action);
	            }

	            // add all toolbars to parent coolbar
	            coolBarMgr.add(new ToolBarContributionItem(defaultToolBarMgr));
	            coolBarMgr.update(true);
	        }

	        public void addResizeListener(ControlListener listener) {
	            coolBar.addControlListener(listener);
	        }

	        public CoolBar getToolbarControl() {
	            return coolBar;
	        }


	        public void addActions(Action... actions) {
	            assert actions != null;

	            if (coolBarMgr != null) {
	                for (Action action : actions) {
	                    defaultToolBarMgr.add(action);
	                }

	                // coolBarMgr.add(new ToolBarContributionItem(defaultToolBarMgr));
	                defaultToolBarMgr.update(true);
	                coolBarMgr.update(true);
	            }
	        }


	        /**
	         * 
	         * DOC mzhao TdEditorToolBar class global comment. Detailled comment
	         */
	        private class RefreshSectionAction extends Action {

	            public RefreshSectionAction() {
	                super("Refresh"); //$NON-NLS-1$
	                setToolTipText("Refresh");
	                this.setImageDescriptor(ImageCache.getImage(EImage.REFRESH.getPath()));
	            }

	            @Override
	            public void run() {
	            	IFormPage page= formPages.get(getCurrentPage());
	            	if(page!=null && page instanceof AFormPage) {	            	
	            		((AFormPage)page).refreshPage();
	            	}
	            }
	        }
	    }
	    
	    public IFormPage getPage(int index) {
	    	return formPages.get(index);
	    }
}
