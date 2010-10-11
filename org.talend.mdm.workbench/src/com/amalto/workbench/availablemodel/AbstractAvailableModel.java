package com.amalto.workbench.availablemodel;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IMenuManager;

import com.amalto.workbench.editors.DataClusterBrowserMainPage;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.XObjectBrowser;
import com.amalto.workbench.editors.XObjectEditor;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.webservices.XtentisPort;

public class AbstractAvailableModel implements IAvailableModel {

	public void addTreeObjects(XtentisPort port, IProgressMonitor monitor,
			TreeParent serverRoot) {
		

	}

	public void fillContextMenu(TreeObject xobject, IMenuManager manager) {
		// TODO Auto-generated method stub

	}

	public void addPage(TreeObject xobject, XObjectBrowser editor) {
		// TODO Auto-generated method stub
		
	}

	public void addPage(TreeObject xobject, XObjectEditor editor) {
		// TODO Auto-generated method stub
		
	}


	public void menuAboutToShow(IMenuManager manager, DataClusterBrowserMainPage page) {
		// TODO Auto-generated method stub
		
	}
	public void fillContextMenu(Object obj, IMenuManager manager,DataModelMainPage page,String dataModelName) {
		// TODO Auto-generated method stub

	}

	public void doubleClickOnElement(int type,DataModelMainPage page,String dataModelName) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTreeObject(XtentisPort port,TreeObject xobject) {
		// TODO Auto-generated method stub
		
	}
	public void doImport(TreeObject obj,String importFolder) {

	}
}
