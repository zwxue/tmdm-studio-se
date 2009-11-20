package com.amalto.workbench.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

import com.amalto.workbench.editors.AMainPageV2;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;
import com.amalto.workbench.widgets.TisTableViewer;
import com.amalto.workbench.widgets.WidgetFactory;

public class ValidationRuleDialog extends Dialog {
	String title;
	private TisTableViewer viewer;
	AMainPageV2 page;
	List<String> rules;
	private ComplexTableViewerColumn[] columns;
	String conceptName;
	public ValidationRuleDialog(Shell parentShell,String title,List<String> rules,AMainPageV2 page,String conceptName) {		
		super(parentShell);
		this.rules=rules;
		this.page=page;
		this.title=title;
		this.conceptName=conceptName;
	}
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.getShell().setText(this.title);		
		Composite composite = (Composite) super.createDialogArea(parent);
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
	    viewer.create();
	    viewer.getViewer().setInput(parseRules());
	    viewer.setHeight(110);
	    viewer.setWidth(400);
		return composite;
	}
	@Override
	protected boolean isResizable() {
		return true;
	}
	private List<Line> parseRules(){
		List<Line> lines=new ArrayList<Line>();
		for(String rule:rules){

			String context="";
			String type="";
			String express="";
			String msg="";
			Matcher m=Pattern.compile("<rule context=\"(.*?)\">",Pattern.CANON_EQ).matcher(rule);
			
			if(m.find()){
				context=m.group(1).trim();
			}
			m=Pattern.compile("<(\\w+?) test=\"(.*?)\">").matcher(rule);
			if(m.find()){
				type=m.group(1).trim();
				express=m.group(2).trim();
			}
			m=Pattern.compile("<"+type+".*?>(.*?)</"+type+">").matcher(rule);
			if(m.find()){
				msg=m.group(1).trim();
			}
			Line l=new Line(columns, new String[]{type,context,express,msg});
			lines.add(l);
		}
		return lines;
	}
	@Override
	protected void okPressed() {
		getValidationRules();
		super.okPressed();
	}
	private List<String> getValidationRules(){
		TableItem[] items=viewer.getViewer().getTable().getItems();
		rules=new ArrayList<String>();
		if(items.length > 0){
			for(TableItem item:items){
				Line line=(Line)item.getData();
				StringBuffer sb =new StringBuffer();
				sb=sb.append("<pattern >\n");
				sb=sb.append("<rule context=\"");
				
				String type=line.keyValues.get(0).value;			
				String context=line.keyValues.get(1).value;
				String express=line.keyValues.get(2).value;
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
				sb=sb.append(msg);
				sb=sb.append("</"+type.toLowerCase()+">");
				sb=sb.append("</rule>\n");
				sb=sb.append("</pattern>\n");
				rules.add(sb.toString());
			}
		}
		return rules;
	}
	public List<String> getRules(){
		return rules;
	}
}
