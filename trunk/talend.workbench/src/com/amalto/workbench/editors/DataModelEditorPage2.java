package com.amalto.workbench.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;

public class DataModelEditorPage2 implements IFormPage {

	FormEditor editor;
	boolean active;
	int index;
	
	/*
	public DataModelEditorPage2(FormEditor editor) {
		this.editor = editor;
	}
	*/
	
	
	public boolean canLeaveThePage() {
		return false;
	}

	public FormEditor getEditor() {
		return this.editor;
	}

	public String getId() {
		return this.getClass().getName();
	}

	public int getIndex() {
		return this.index;
	}

	public IManagedForm getManagedForm() {
		// TODO Auto-generated method stub
		return null;
	}

	public Control getPartControl() {
		// TODO Auto-generated method stub
		return null;
	}

	public void initialize(FormEditor editor) {
		System.out.println("initialize() ");
		this.editor = editor;
	}

	public boolean isActive() {
		return this.active;
	}

	public boolean isEditor() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean selectReveal(Object object) {
		return false;
	}

	public void setActive(boolean active) {
		this.active = active;

	}

	public void setIndex(int index) {
		this.index = index;

	}

	public IEditorInput getEditorInput() {
		// TODO Auto-generated method stub
		return null;
	}

	public IEditorSite getEditorSite() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// TODO Auto-generated method stub

	}

	public void addPropertyListener(IPropertyListener listener) {
		// TODO Auto-generated method stub

	}

	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public IWorkbenchPartSite getSite() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Image getTitleImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitleToolTip() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removePropertyListener(IPropertyListener listener) {
		// TODO Auto-generated method stub

	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSaveOnCloseNeeded() {
		// TODO Auto-generated method stub
		return false;
	}

}
