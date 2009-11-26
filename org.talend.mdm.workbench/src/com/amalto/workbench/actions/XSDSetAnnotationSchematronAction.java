package com.amalto.workbench.actions;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.ValidationRuleDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.providers.XSDTreeContentProvider;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDSetAnnotationSchematronAction extends UndoAction{

	protected ValidationRuleDialog dlg = null;
	protected String dataModelName;
	
	public XSDSetAnnotationSchematronAction(DataModelMainPage page,String dataModelName) {
		super(page);
		setImageDescriptor(ImageCache.getImage( "icons/annotation.gif"));
		setText("Set the Validation Rule");
		setToolTipText("Set the Validation Rule");
		this.dataModelName = dataModelName;
	}
	
	public IStatus doAction() {
		try {
			
            schema = ((XSDTreeContentProvider)page.getTreeViewer().getContentProvider()).getXsdSchema();
            IStructuredSelection selection = (TreeSelection)page.getTreeViewer().getSelection();
            XSDComponent xSDCom=null;
            if (selection.getFirstElement() instanceof Element) {
				TreePath tPath = ((TreeSelection) selection).getPaths()[0];
				for (int i = 0; i < tPath.getSegmentCount(); i++) {
					if (tPath.getSegment(i) instanceof XSDAnnotation)
						xSDCom = (XSDAnnotation) (tPath.getSegment(i));
				}
			} else
            xSDCom = (XSDComponent)selection.getFirstElement();
            		   XSDAnnotationsStructure struc =new XSDAnnotationsStructure(xSDCom);
//            IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
//            XSDAnnotationsStructure struc = new XSDAnnotationsStructure((XSDComponent)selection.getFirstElement());
            if (struc.getAnnotation() == null) {
            	throw new RuntimeException("Unable to edit an annotation for object of type "+xSDCom.getClass().getName());
            }
            
//            dlg = new AnnotationOrderedListsDialog(
//            		new ArrayList(struc.getSchematrons().values()),
//            		new SelectionListener() {
//            			public void widgetDefaultSelected(SelectionEvent e) {}
//            			public void widgetSelected(SelectionEvent e) {
//            				dlg.close();
//            			}
//            		},
//       				page.getSite().getShell(),
//       				"Set the Validation Rule",
//       				"Set the Validation Rule",
//       				page,
//       				AnnotationOrderedListsDialog.AnnotationSchematron_ActionType,
//       				dataModelName 
//       		);
            String conceptName=null;
            if(xSDCom instanceof XSDAnnotation){
            	conceptName=xSDCom.getContainer().getElement().getAttributes().getNamedItem("name").getNodeValue();
            }
            if(xSDCom instanceof XSDElementDeclaration){
            	conceptName=xSDCom.getElement().getAttributes().getNamedItem("name").getNodeValue();
            }
            if (!(selection.getFirstElement() instanceof Element)) {
            	return Status.CANCEL_STATUS;
            }
            Element e= (Element)selection.getFirstElement();
            if(!"X_Schematron".equals(e.getAttribute("source"))) return Status.CANCEL_STATUS;
            
            dlg=new ValidationRuleDialog(page.getSite().getShell(),"Set the Validation Rules",e.getFirstChild().getTextContent(),page,conceptName);            
       		dlg.setBlockOnOpen(true);
       		dlg.create();
       		//dlg.getShell().setSize(new Point(850,270));
       		int ret = dlg.open();
       		if (ret == Window.CANCEL) {
                return Status.CANCEL_STATUS;
       		}
       		e.getFirstChild().setTextContent(dlg.getPattern());
       		e.getFirstChild().setUserData("pattern_name", dlg.getName(), null);
      		//struc.setSchematron(0,dlg.getPattern());
       		       		
       		//if (struc.hasChanged()) {
       			page.refresh();
       			page.getTreeViewer().expandToLevel(xSDCom, 2);
       			page.markDirty();
       		//}
       		
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to set the Validation Rule: "+e.getLocalizedMessage()
			);
            return Status.CANCEL_STATUS;
		}
        return Status.OK_STATUS;
	}
}
