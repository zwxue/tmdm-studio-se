package com.amalto.workbench.actions;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDParticle;
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.FKFilterDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDSetAnnotationFKFilterAction extends UndoAction {
	protected FKFilterDialog fkd = null;
	protected String dataModelName;
	
	public XSDSetAnnotationFKFilterAction(DataModelMainPage page,String dataModelName) {
		super(page);
		setImageDescriptor(ImageCache.getImage( EImage.FILTER_PS.getPath()));
		setText("Set the Foreign Key Filter");
		setToolTipText("Set the Foreign Key Filter");
		this.dataModelName = dataModelName;
	}
	
	public IStatus doAction() {
		try {
			
			if(page.isDirty()){
				boolean save = MessageDialog.openConfirm(page.getSite().getShell(), "Save Resource", "'"+page.getXObject().getDisplayName()+"' has been modified. Save changes?");
				
				if(save)
					page.doSave(new NullProgressMonitor());
					
				else
					return Status.CANCEL_STATUS;
			}
            IStructuredSelection selection = (TreeSelection)page.getTreeViewer().getSelection();
            XSDComponent xSDCom=null;
            String conceptName=null;
			if (selection.getFirstElement() instanceof Element) {
				TreePath tPath = ((TreeSelection) selection).getPaths()[0];
				for (int i = 0; i < tPath.getSegmentCount(); i++) {
					if (tPath.getSegment(i) instanceof XSDAnnotation)
						xSDCom = (XSDAnnotation) (tPath.getSegment(i));
				}
			}else
				xSDCom=(XSDComponent)selection.getFirstElement();
            if(xSDCom instanceof XSDElementDeclaration){
            	conceptName=xSDCom.getElement().getAttributes().getNamedItem("name").getNodeValue();
            }
			if(xSDCom instanceof XSDParticle) {
				//conceptName=getConceptName(xSDCom);
			}
            XSDAnnotationsStructure struc=null;
			if(xSDCom!=null)
            		    struc =new XSDAnnotationsStructure(xSDCom);
            if (struc==null||struc.getAnnotation() == null) {
            	throw new RuntimeException("Unable to edit an annotation for object of type "+xSDCom.getClass().getName());
            }
            
       		
            fkd=new FKFilterDialog(page.getSite().getShell(), "Set Foreign Key Filter", struc.getFKFilter(), page, conceptName);
            
            fkd.setBlockOnOpen(true);
       		int ret = fkd.open();
       		if (ret == Window.CANCEL){
                return Status.CANCEL_STATUS;
       		}
       		
       		String fkfilter=fkd.getFilter();
       		struc.setFKFilter(fkfilter);
       		
       		if (struc.hasChanged()) {
       			page.refresh();
       			page.getTreeViewer().expandToLevel(xSDCom, 2);
       			page.markDirty();
       		}
       		
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to set a FK Filter: "+e.getLocalizedMessage()
			);
            return Status.CANCEL_STATUS;
		}
        return Status.OK_STATUS;
	}
	private String getConceptName(XSDConcreteComponent element) {
		XSDConcreteComponent parent=element.getContainer();
		if(parent instanceof XSDElementDeclaration) {
			return ((XSDElementDeclaration)parent).getElement().getAttributes().getNamedItem("name").getNodeValue();
		}else {
			return getConceptName(parent);
		}
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
}
