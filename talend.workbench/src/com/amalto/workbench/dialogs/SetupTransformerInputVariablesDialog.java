package com.amalto.workbench.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.editors.TransformerMainPage;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSByteArray;
import com.amalto.workbench.webservices.WSExecuteTransformerV2AsJob;
import com.amalto.workbench.webservices.WSTransformerContext;
import com.amalto.workbench.webservices.WSTransformerContextPipeline;
import com.amalto.workbench.webservices.WSTransformerContextPipelinePipelineItem;
import com.amalto.workbench.webservices.WSTransformerProcessStep;
import com.amalto.workbench.webservices.WSTransformerV2;
import com.amalto.workbench.webservices.WSTransformerV2PK;
import com.amalto.workbench.webservices.WSTransformerVariablesMapping;
import com.amalto.workbench.webservices.WSTypedContent;
import com.amalto.workbench.widgets.ComplexTableViewer;

public class SetupTransformerInputVariablesDialog extends Dialog {
	WSTransformerV2 transformer;
	FormToolkit toolkit;
	TreeObject object;
	private ComplexTableViewer objectViewer;

	TransformerMainPage page;
	public SetupTransformerInputVariablesDialog(Shell parentShell,FormToolkit toolkit,TreeObject obj,TransformerMainPage page) {
		super(parentShell);	
		this.toolkit=toolkit;
		object=obj;
		this.page=page;
		transformer = (WSTransformerV2)obj.getWsObject();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
        Group comp = new Group(parent,SWT.NONE);
        comp.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
        );
        ((GridLayout)parent.getLayout()).marginTop=5;
        ((GridLayout)parent.getLayout()).marginLeft=5;
        ((GridLayout)parent.getLayout()).marginRight=5;
        ((GridLayout)parent.getLayout()).marginBottom=5;
        parent.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        comp.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
  
        comp.setLayout(  new GridLayout(1 ,false ));
        comp.setText("Setup " + transformer.getName() + " input variables");
		String[] columns={"Input variables","Value","Content/type"};
        objectViewer=new ComplexTableViewer(Arrays.asList(columns),toolkit,comp);
        Set<String> strings=new HashSet<String>();
        for(WSTransformerProcessStep step:transformer.getProcessSteps()){
        	for(WSTransformerVariablesMapping mapping:step.getInputMappings()){       		
        		strings.add(mapping.getPipelineVariable()==null?TransformerMainPage.DEFAULT_VAR:mapping.getPipelineVariable());
        	}
        }
        
        objectViewer.setFirstCombo(true);
        objectViewer.setFirstcomboStrings(strings.toArray(new String[strings.size()]));

        objectViewer.setLastCombo(true);
        objectViewer.setLastcomboStrings(new String[]{"text/plain","text/xml"});
        objectViewer.create();
        
        Table table=objectViewer.getViewer().getTable();
              	
        table.getColumns()[1].setWidth(500);
        
        GridData gd=(GridData)objectViewer.getTxtLists().get(0).getLayoutData();
        gd.minimumHeight=200;
        gd.minimumWidth=300;
       
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        
        //((GridData)table.getLayoutData()).minimumHeight = 100;
        //((GridData)table.getLayoutData()).minimumWidth = 600;
        if(page.getCacheList()!=null){
        	objectViewer.getViewer().setInput(page.getCacheList());
        }else{
	        List<Line> list=new ArrayList<Line>();
	        objectViewer.getViewer().setInput(list);
        }
        return comp;
		
	}

	
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		parent.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
	}
	
	private void processOk(){
		objectViewer.add();
		java.util.List<Line> list=(java.util.List<Line>)objectViewer.getViewer().getInput();
		if(list.size()==0)return;

		page.setCacheList(list);
		page.execute();

	}
	


	@Override
	protected void okPressed() {
		setReturnCode(OK);
		processOk();
		super.okPressed();
	}
	
	 @Override
	protected void cancelPressed() {
		setReturnCode(CANCEL);
		super.cancelPressed();
	}
}
