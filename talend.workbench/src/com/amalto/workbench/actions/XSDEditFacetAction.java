package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDEnumerationFacet;
import org.eclipse.xsd.XSDLengthFacet;
import org.eclipse.xsd.XSDMaxLengthFacet;
import org.eclipse.xsd.XSDMinLengthFacet;
import org.eclipse.xsd.XSDPatternFacet;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.AmaltoWorbenchPlugin;
import com.amalto.workbench.dialogs.FacetsListInputDialog;
import com.amalto.workbench.editors.DataModelMainPage;

public class XSDEditFacetAction extends Action{

	protected DataModelMainPage page = null;
	protected String facetName = null;
	//protected XSDSchema schema = null;
	protected XSDSimpleTypeDefinition std = null;
	
	protected Dialog dialog;
	protected ArrayList newValues;
	
	
	public XSDEditFacetAction(DataModelMainPage page, String facetName) {
		super();
		this.page = page;
		this.facetName = facetName;
		setImageDescriptor(AmaltoWorbenchPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/facet.gif"));
		setText("Edit "+facetName);
		setToolTipText("Edit the Facet "+facetName);
	}
	
	public void run() {
		try {
			
			ISelection selection = page.getTreeViewer().getSelection();
			std = (XSDSimpleTypeDefinition)((IStructuredSelection)selection).getFirstElement();
			
			super.run();
            if (facetName.equals("pattern")) {
            	editPattern();
            } else if (facetName.equals("enumeration")) {
            	editEnumeration();
            } else if (facetName.equals("length")) {
            	editLength();
            } else if (facetName.equals("minLength")) {
            	editMinLength();
            } else if (facetName.equals("maxLength")) {
            	editMaxLength();            	
            } else {
    			MessageDialog.openError(
    					page.getSite().getShell(),
    					"Error", 
    					"No editor available for the Facet: "+facetName
    			);
    			return;
            }
			
       		std.updateElement();
       		
    		page.getTreeViewer().refresh(true);
    		page.markDirty();
    		
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to edit a Facet: "+e.getLocalizedMessage()
			);
		}
		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	
	private void editPattern() {
		List currentValues = std.getPatternFacets();
		ArrayList stringValues = new ArrayList();
		for (Iterator iter = currentValues.iterator(); iter.hasNext(); ) {
			XSDPatternFacet facet = (XSDPatternFacet) iter.next();
			stringValues.add(facet.getLexicalValue());
		}
		dialog = new FacetsListInputDialog(
				new SelectionListener() {
					public void widgetDefaultSelected(SelectionEvent e) {
					}
					public void widgetSelected(SelectionEvent e) {
						newValues = ((FacetsListInputDialog)dialog).getItems();
						dialog.close();
					}
				},
   				page.getSite().getShell(),
   				"Edit Pattern Values",
   				stringValues
   		);
        
   		dialog.setBlockOnOpen(true);
   		int ret = dialog.open();
   		if (ret == Dialog.CANCEL) return;

   		std.getFacetContents().removeAll(currentValues);
   		for (Iterator iter = newValues.iterator(); iter.hasNext(); ) {
			String element = (String) iter.next();
			XSDPatternFacet f = XSDSchemaBuildingTools.getXSDFactory().createXSDPatternFacet();
			f.setLexicalValue(element);
			std.getFacetContents().add(f);
		}

	}//editPattern

	
	private void editEnumeration() {
		List currentValues = std.getEnumerationFacets();
		ArrayList stringValues = new ArrayList();
		for (Iterator iter = currentValues.iterator(); iter.hasNext(); ) {
			XSDEnumerationFacet facet = (XSDEnumerationFacet) iter.next();
			stringValues.add(facet.getLexicalValue());
		}
		dialog = new FacetsListInputDialog(
				new SelectionListener() {
					public void widgetDefaultSelected(SelectionEvent e) {
					}
					public void widgetSelected(SelectionEvent e) {
						newValues = ((FacetsListInputDialog)dialog).getItems();
						dialog.close();
					}
				},
   				page.getSite().getShell(),
   				"Edit Enumerations Values",
   				stringValues
   		);
        
   		dialog.setBlockOnOpen(true);
   		int ret = dialog.open();
   		if (ret == Dialog.CANCEL) return;

   		std.getFacetContents().removeAll(currentValues);
   		for (Iterator iter = newValues.iterator(); iter.hasNext(); ) {
			String element = (String) iter.next();
			XSDEnumerationFacet f = XSDSchemaBuildingTools.getXSDFactory().createXSDEnumerationFacet();
			f.setLexicalValue(element);
			std.getFacetContents().add(f);
		}

	}//EditEnumeration

	private void editLength() {
		XSDLengthFacet currentValue = std.getLengthFacet();
		String stringValue= "0";
		if (currentValue != null)	stringValue = currentValue.getLexicalValue();
		dialog = new InputDialog(
				page.getSite().getShell(),
   				"Length Facet",
   				"Enter a new value for the facet; 0 to remove it",
   				stringValue==null ? "" : stringValue,
   				new IInputValidator() {
					public String isValid(String newText) {
						int val;
						try {
							val = Integer.parseInt(newText);
						} catch (Exception e) {
							return "The value must be a non negative integer";
						}
						if (val < 0) return "The value must be a non negative integer";
						return null;
					}
				}
   		);
        
   		dialog.setBlockOnOpen(true);
   		int ret = dialog.open();
   		if (ret == Dialog.CANCEL) return;

   		if (currentValue!=null) std.getFacetContents().remove(currentValue);
   		int intValue = Integer.parseInt(((InputDialog)dialog).getValue());
   		if (intValue>0) {
   			XSDLengthFacet f = (XSDSchemaBuildingTools.getXSDFactory()).createXSDLengthFacet();
   			f.setLexicalValue(""+intValue);
   			std.getFacetContents().add(f);
   		}

	}//EditLength
	
	private void editMinLength() {
		XSDMinLengthFacet currentValue = std.getMinLengthFacet();
		String stringValue= "0";
		if (currentValue != null)	stringValue = currentValue.getLexicalValue();
		dialog = new InputDialog(
				page.getSite().getShell(),
   				"MinLength Facet",
   				"Enter a new value for the facet; 0 to remove it",
   				stringValue==null ? "" : stringValue,
   				new IInputValidator() {
					public String isValid(String newText) {
						int val;
						try {
							val = Integer.parseInt(newText);
						} catch (Exception e) {
							return "The value must be a non negative integer";
						}
						if (val < 0) return "The value must be a non negative integer";
						return null;
					}
				}
   		);
        
   		dialog.setBlockOnOpen(true);
   		int ret = dialog.open();
   		if (ret == Dialog.CANCEL) return;

   		if (currentValue!=null) std.getFacetContents().remove(currentValue);
   		int intValue = Integer.parseInt(((InputDialog)dialog).getValue());
   		if (intValue>0) {
   			XSDMinLengthFacet f = (XSDSchemaBuildingTools.getXSDFactory()).createXSDMinLengthFacet();
   			f.setLexicalValue(""+intValue);
   			std.getFacetContents().add(f);
   		}

	}//EditMinLength

	
	private void editMaxLength() {
		XSDMaxLengthFacet currentValue = std.getMaxLengthFacet();
		String stringValue= "0";
		if (currentValue != null)	stringValue = currentValue.getLexicalValue();
		dialog = new InputDialog(
				page.getSite().getShell(),
   				"MaxLength Facet",
   				"Enter a new value for the facet; 0 to remove it",
   				stringValue==null ? "" : stringValue,
   				new IInputValidator() {
					public String isValid(String newText) {
						int val;
						try {
							val = Integer.parseInt(newText);
						} catch (Exception e) {
							return "The value must be a non negative integer";
						}
						if (val < 0) return "The value must be a non negative integer";
						return null;
					}
				}
   		);
        
   		dialog.setBlockOnOpen(true);
   		int ret = dialog.open();
   		if (ret == Dialog.CANCEL) return;

   		if (currentValue!=null) std.getFacetContents().remove(currentValue);
   		int intValue = Integer.parseInt(((InputDialog)dialog).getValue());
   		if (intValue>0) {
   			XSDMaxLengthFacet f = (XSDSchemaBuildingTools.getXSDFactory()).createXSDMaxLengthFacet();
   			f.setLexicalValue(""+intValue);
   			std.getFacetContents().add(f);
   		}

	}//EditMaxLength
}