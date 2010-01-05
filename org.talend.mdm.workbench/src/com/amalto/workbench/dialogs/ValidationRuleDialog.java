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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.workbench.editors.AMainPageV2;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;
import com.amalto.workbench.widgets.ICellEditor;
import com.amalto.workbench.widgets.TisTableViewer;
import com.amalto.workbench.widgets.WidgetFactory;

public class ValidationRuleDialog extends Dialog {
	String title;
	private TisTableViewer viewer;
	AMainPageV2 page;
	String pattern;
	private ComplexTableViewerColumn[] columns;
	String conceptName;
	String name="";
	private Text text;
	public ValidationRuleDialog(Shell parentShell,String title,String pattern,AMainPageV2 page,String conceptName) {		
		super(parentShell);
		this.pattern=pattern;
		this.page=page;
		this.title=title;
		this.conceptName=conceptName;
	}
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.getShell().setText(this.title);		
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new GridLayout(2,false));
		Label label=new Label(composite,SWT.NONE);
		label.setText("Name:");
		label.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
        ); 
		text=new Text(composite,SWT.BORDER);		
		text.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
        ); 		
	    columns= new ComplexTableViewerColumn[]{
	    		new ComplexTableViewerColumn("Type", false, "", "", "",ComplexTableViewerColumn.COMBO_STYLE,IConstants.SCHEMATRON_TYPES,0),
	    		new ComplexTableViewerColumn("Context XPath", false, "newXPath", "newXPath", "",ComplexTableViewerColumn.XPATH_STYLE,new String[] {},0),
	    		new ComplexTableViewerColumn("Expression", false, "", "", "",ComplexTableViewerColumn.VALIDATIONRULE_STYLE,new String[] {},0),
	    		new ComplexTableViewerColumn("Message", false, "", "", "",ComplexTableViewerColumn.MULTIMESSAGE_STYLE,new String[] {},0),
	    };
	    columns[0].setColumnWidth(70);
	    columns[1].setColumnWidth(130);
	    columns[2].setColumnWidth(300);	   
	    columns[3].setColumnWidth(300);
	    viewer=new TisTableViewer(Arrays.asList(columns),new WidgetFactory(),composite);
	    viewer.setMainPage(page);
	    viewer.setConceptName(conceptName);
	    viewer.setContext(true);
	    viewer.create();
	    viewer.getViewer().setInput(parseRules());
	    viewer.setHeight(110);
	    viewer.setWidth(800);
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
		List<Line> lines=new ArrayList<Line>();
			pattern= pattern.replaceAll("\\r\\n|\\n", "");
			String context="";
			String type="";
			String express="";
			String msg="";
			Element e=null;
			try {
				e = Util.parse(pattern).getDocumentElement();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(e.getAttributes().getNamedItem("name")!=null)name=e.getAttributes().getNamedItem("name").getTextContent();
			text.setText("Product Type".equals(name)?"":name);
			NodeList rulelist=e.getElementsByTagName("rule");
			for(int i=0; i<rulelist.getLength(); i++){
				Node r=rulelist.item(i);
				context=r.getAttributes().getNamedItem("context").getTextContent();
				for( int j=0; j<r.getChildNodes().getLength(); j++){
					if( r.getChildNodes().item(j).getNodeType()== Node.ELEMENT_NODE){
						type=r.getChildNodes().item(j).getNodeName();
						express=r.getChildNodes().item(j).getAttributes().getNamedItem("test").getTextContent();		
						msg= r.getChildNodes().item(j).getTextContent();
						break;
					}
				}
					
				Line l=new Line(columns, new String[]{type,context,express,msg});
				lines.add(l);				
			}


	
		return lines;
	}
	@Override
	protected void okPressed() {
		name=text.getText();
		XpathSelectDialog.setContext(null);
		deactiveAllCellEditors();
		getValidationRules();
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
	private String getValidationRules(){
		TableItem[] items=viewer.getViewer().getTable().getItems();
		//List<String> rules=new ArrayList<String>();
		StringBuffer sb =new StringBuffer();
		sb=sb.append("<pattern "+ "name=\""+text.getText()+"\" >\n");
		
		if(items.length > 0) {
			for(TableItem item:items){
				Line line=(Line)item.getData();
				sb=sb.append("<rule context=\"");
				
				String type=line.keyValues.get(0).value;			
				String context=line.keyValues.get(1).value;
				String express=line.keyValues.get(2).value;
				express=express.replaceAll("<", "&lt;");
				express = express.replaceAll("\"", "&quot;");
				express = express.replaceAll("\'", "&apos;");
				String msg=line.keyValues.get(3).value;
				if(conceptName!=null){
					if(context.equals(conceptName)){
						context=context.replaceAll(conceptName, "/");
					}else{
						context=context.replaceAll(conceptName+"/", "");
					}
				}
				sb=sb.append(context).append("\">");
				sb=sb.append("<"+ type.toLowerCase() + " test=\"" + express+"\">");
				sb=sb.append("<![CDATA[" + msg + "]]>");
				sb=sb.append("</"+type.toLowerCase()+">");
				sb=sb.append("</rule>\n");
			}
			//rules.add(sb.toString());
		}
		
		sb=sb.append("</pattern>\n");
		
		return pattern=sb.toString();
	}
	public String getPattern() {
		return pattern;
	}
	
	public String getName(){
		return name;
	}
}
