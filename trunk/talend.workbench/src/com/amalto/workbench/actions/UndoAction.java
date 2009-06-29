package com.amalto.workbench.actions;

/**
 * All actions need to support Undo/Redo(DataModelMainPage) must subclass this one
 */
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xsd.XSDElementDeclaration;

import com.amalto.workbench.editors.DataModelMainPage;

public  class UndoAction extends Action {
	
	protected DataModelMainPage page;
	
	public UndoAction(DataModelMainPage page){
		this.page=page;
		
	}
	public class XsdUndoableOperation extends AbstractOperation{

		public XsdUndoableOperation(String label) {
			super(label);
			// TODO Auto-generated constructor stub
		}

		@Override
		public IStatus execute(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			// TODO Auto-generated method stub
			return UndoAction.this.execute();
		}

		@Override
		public IStatus redo(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			// TODO Auto-generated method stub
			return UndoAction.this.redo();
		}

		@Override
		public IStatus undo(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			// TODO Auto-generated method stub
			return UndoAction.this.undo();
		}		
	};
	public void run() {
		try {			
			operation.addContext(page.getUndoContext());
			getOperationHistory().execute(operation, null, null);			
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	public void run(Object toDel)
	{
	}
	
	protected XsdUndoableOperation operation=new XsdUndoableOperation("");
	
	/**
	 * need override by subclass
	 */
	protected void doAction(){
		
	}
	protected IStatus execute(){
		System.out.println(getText()+" execute....");
		doAction();
		return Status.OK_STATUS;
	}
	/**
	 * need override by subclass
	 * @return
	 */
	protected IStatus undo(){
		System.out.println(getText()+" undo....");
		
   		page.getTreeViewer().refresh(true);
   		page.markDirty();
		return Status.OK_STATUS;
	}
	
	protected IStatus redo(){
		System.out.println(getText()+" redo....");
		
   		page.getTreeViewer().refresh(true);
   		page.markDirty();
		return Status.OK_STATUS;
	}
	public XsdUndoableOperation getOperation() {
		return operation;
	}
	
	public IOperationHistory getOperationHistory(){
		return PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
	}
}
