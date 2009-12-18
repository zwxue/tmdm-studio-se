package com.amalto.workbench.availablemodel;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IMenuManager;

import com.amalto.workbench.editors.DataClusterBrowserMainPage;
import com.amalto.workbench.editors.XObjectBrowser;
import com.amalto.workbench.editors.XObjectEditor;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.webservices.XtentisPort;

public interface IAvailableModel {
	/**
	 * add treeobjects when refresh the serverroot treenode
	 * @param port
	 * @param monitor
	 * @param serverRoot
	 */
	void addTreeObjects(XtentisPort port,IProgressMonitor monitor,TreeParent serverRoot);
	
	/**
	 * Fill the context menu when right click the object
	 * @param xobject
	 * @param manager
	 */
	void fillContextMenu(TreeObject xobject,IMenuManager manager);
	
	/**
	 * XObjectBrowser to add page
	 * @param editor
	 */
	void addPage(TreeObject xobject,XObjectBrowser editor);
	
	/**
	 * XObjectEditor to add page
	 * @param editor
	 */
	void addPage(TreeObject xobject,XObjectEditor editor);
	
	/**
	 * Browse datacluster menuAboutToShow
	 * @param manager
	 */
	void menuAboutToShow(IMenuManager manager, DataClusterBrowserMainPage page);
}
