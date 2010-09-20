package com.amalto.workbench.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

import com.amalto.workbench.editors.AMainPageV2;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;
import com.amalto.workbench.widgets.ICellEditor;
import com.amalto.workbench.widgets.TisTableViewer;
import com.amalto.workbench.widgets.WidgetFactory;

public class FKFilterDialog extends Dialog {
	String title;
	private TisTableViewer viewer;
	AMainPageV2 page;
	String filter;
	private ComplexTableViewerColumn[] columns;
	String conceptName;

	public FKFilterDialog(Shell parentShell,String title,String filter,AMainPageV2 page,String conceptName) {		
		super(parentShell);
		this.filter=filter;
		this.page=page;
		this.title=title;
		this.conceptName=conceptName;
	}
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.getShell().setText(this.title);		
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new GridLayout(2,false));
		
		columns= new ComplexTableViewerColumn[]{
	    		new ComplexTableViewerColumn("XPath", false, "newXPath", "newXPath", "",ComplexTableViewerColumn.XPATH_STYLE,new String[] {},0),
	    		new ComplexTableViewerColumn("Operator", false, "", "", "",ComplexTableViewerColumn.COMBO_STYLE,IConstants.VIEW_CONDITION_OPERATORS,0),
	    		new ComplexTableViewerColumn("Value", false, "", "", "",ComplexTableViewerColumn.XPATH_STYLE,new String[] {},0),
	    		new ComplexTableViewerColumn("Predicate", true, "", "", "",ComplexTableViewerColumn.COMBO_STYLE,IConstants.PREDICATES,0),
	    };
	    columns[0].setColumnWidth(200);
	    columns[1].setColumnWidth(140);
	    columns[2].setColumnWidth(200);	   
	    columns[3].setColumnWidth(140);
	    viewer=new TisTableViewer(Arrays.asList(columns),new WidgetFactory(),composite);
	    viewer.setXpath(true);
	    viewer.setMainPage(page);	    
	    //viewer.setConceptName(conceptName);
	    //viewer.setContext(true);
	    viewer.create();
	    viewer.getViewer().setInput(parseRules());
	    viewer.setHeight(140);
	    viewer.setWidth(680);
	    viewer.getMainComposite().setLayoutData( new GridData(SWT.FILL,SWT.FILL,true,true,2,3));
	    parent.getShell().addDisposeListener(new DisposeListener() {
			
			public void widgetDisposed(DisposeEvent e) {
				XpathSelectDialog.setContext(null);				
			}
		});
		return composite;
	}
	@Override
	protected boolean isResizable() {
		return true;
	}
	private List<Line> parseRules() {
		List<Line> lines=buildLine(filter);
		return lines;
	}
	@Override
	protected void okPressed() {
		XpathSelectDialog.setContext(null);
		deactiveAllCellEditors();
		resetFilter();
		super.okPressed();
	}
	private void deactiveAllCellEditors(){
		CellEditor[] editors=viewer.getViewer().getCellEditors();
		for(CellEditor editor: editors){
			if( editor instanceof ICellEditor){
				((ICellEditor)editor).deactive();
			}
		}
	}
	@Override
	protected void cancelPressed() {		
		super.cancelPressed();
		XpathSelectDialog.setContext(null);
	}
	private String resetFilter(){
		TableItem[] items=viewer.getViewer().getTable().getItems();
		StringBuffer sb =new StringBuffer();		
		if(items.length > 0) {
			for(TableItem item:items){
				Line line=(Line)item.getData();				
				
				String xpath=line.keyValues.get(0).value;			
				String operator=line.keyValues.get(1).value;
				String value=line.keyValues.get(2).value;
				value=normalizeValue(value);
				String predicate=line.keyValues.get(3).value;
				sb.append(xpath+"$$" + operator+ "$$" + value+"$$"+predicate +"#");
			}
			//rules.add(sb.toString());
		}
				
		return filter=sb.toString();
	}
	

	private String normalizeValue(String value) {
		if(value!=null&&value.trim().length()>0) {
			value=value.replaceAll("\"", "&quot;");
			value=value.replaceAll("'", "&quot;");
		}
		return value;
	}
	
	public String getFilter() {
		return filter;
	}
	
	public  List<Line> buildLine(String criteria){
		List<Line> lines=new ArrayList<Line>();
		if(criteria!=null) {
			String[] criterias = criteria.split("#");
			for (String cria: criterias)
			{
				String[] values = cria.split("\\$\\$");
				List<String> list=new ArrayList<String>();
				list.addAll(Arrays.asList(values));
				int num=4-list.size();
				for(int i=0; i<num; i++) {
					list.add("");
				}
				//filter value
				if(list.get(2)!=null&&list.get(2).length()>0) {
					String value=list.get(2);
					value=value.replaceAll("&quot;","\"");
					list.set(2, value);
				}
				Line line =new Line(columns,list.toArray(new String[list.size()]));
				lines.add(line);
			}
		}
		return lines;
	}

}
