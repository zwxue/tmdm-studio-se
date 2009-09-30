package com.amalto.workbench.dialogs;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSGetCurrentUniverse;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSVersioningHistoryEntry;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.UniverseVersionTreeViewer;

public class VersioningUniverseDialog extends Dialog {
	private IStructuredSelection sel;
	private UniverseVersionTreeViewer treeViewer;
	private XtentisPort port;
	
	public VersioningUniverseDialog(Shell parentShell,XtentisPort port,IStructuredSelection selection) {
		
		super(parentShell);
		this.sel=selection;
		this.port=port;
		
	}
	
	protected Control createDialogArea(Composite parent) {
		
		try {
			//Should not really be here but well,....
			parent.getShell().setText("Universe Versioning");
			Composite composite = (Composite) super.createDialogArea(parent);
			GridLayout layout = (GridLayout)composite.getLayout();
			layout.numColumns=1;
			treeViewer =new UniverseVersionTreeViewer(sel,getDefautTag(),false);
			treeViewer.setTagSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {}
				public void widgetSelected(SelectionEvent e) {
					if ("".equals(treeViewer.getTagText())) {
						MessageDialog.openError(VersioningUniverseDialog.this.getShell(), "Error", "Please enter a tag value");
						return;
					}

					if ("".equals(treeViewer.getComment())) {
						MessageDialog.openError(VersioningUniverseDialog.this.getShell(), "Error", "Please enter a comment");
						return;
					}
					
					TreeObject[]  checkNodes=treeViewer.getCheckNodes();
					System.out.println("Tag universe");
				}				
			});
			treeViewer.setRestoreSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {}
				public void widgetSelected(SelectionEvent e) {
					System.out.println("Restore universe");
				}				
			});
			treeViewer.setTagsViewerDoubleClickListener(new IDoubleClickListener() {
	        	public void doubleClick(DoubleClickEvent event) {
	        		System.out.println("Viewer double click");
	            }
            });
			treeViewer.setHisEntries(initData());
			treeViewer.createContents(composite);
			
		    return composite;
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					this.getShell(),
					"Error", 
					"An error occured trying to create the Versioning Dialog: "+e.getLocalizedMessage()
			);
			return null;
		}
	}

	private ArrayList<WSVersioningHistoryEntry> initData() {
		System.out.println("Init history universes in svn ");
		ArrayList<WSVersioningHistoryEntry> history = new ArrayList<WSVersioningHistoryEntry>();
		WSVersioningHistoryEntry wsVersioningHistoryEntry=new WSVersioningHistoryEntry();
		wsVersioningHistoryEntry.setTag("Test Tag");
		wsVersioningHistoryEntry.setRevision(null);
		wsVersioningHistoryEntry.setDate("2009-09-30");
		wsVersioningHistoryEntry.setAuthor("hshu");
		wsVersioningHistoryEntry.setComments("test");
		history.add(wsVersioningHistoryEntry);
		return history;
	}
	
	private String getDefautTag() {
		String tagName="";
		try {
			WSUniverse CUniverse=port.getCurrentUniverse(new WSGetCurrentUniverse());
			tagName = "UNIVERSE_"+CUniverse.getName();//UNIVERSE is keyword
			tagName = tagName.replace("[", "").replace("]", "");
			
			//timestamp
			Date dateNow=new Date();
			SimpleDateFormat  dateFormat=new SimpleDateFormat ("yyyyMMdd");
		    String dateNowStr=dateFormat.format(dateNow);
			tagName+="_"+dateNowStr;
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        return tagName;
	}
	
	
}
