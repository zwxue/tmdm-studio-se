package com.amalto.workbench.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.w3c.dom.Element;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSPutTransformerV2;
import com.amalto.workbench.webservices.WSServiceGetConfiguration;
import com.amalto.workbench.webservices.WSString;
import com.amalto.workbench.webservices.WSTransformerProcessStep;
import com.amalto.workbench.webservices.WSTransformerV2;
import com.amalto.workbench.webservices.WSTransformerVariablesMapping;

public class WorkflowDefaultTransformerGenerateWizard extends Wizard {
	private TreeObject xobject;
	private ServerView view;
	private StyledText variableext;
	private boolean isFinish = false;
	public WorkflowDefaultTransformerGenerateWizard(TreeObject xobject,ServerView view){
		super();
		this.xobject = xobject;
		this.view = view;		
	}

	@Override
	public void addPages() {
		addPage(new WorkflowTriggerPage());
	}
	@Override
	public boolean performFinish() {
		WSTransformerV2 transformer=new WSTransformerV2();
		try {
		WSTransformerProcessStep[] steps=new WSTransformerProcessStep[2];
		WSTransformerVariablesMapping[] input=new WSTransformerVariablesMapping[1];
		input[0]=new WSTransformerVariablesMapping("_DEFAULT_","xml",null);
		WSTransformerVariablesMapping[] output=new WSTransformerVariablesMapping[1];
		output[0]=new WSTransformerVariablesMapping("item_primary_key","text",null);
		
		steps[0]=new WSTransformerProcessStep("amalto/local/transformer/plugin/xslt","getItemPK","<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\"> <xsl:output method=\"xml\" indent=\"yes\" omit-xml-declaration=\"yes\" /> <xsl:template match=\"/\" priority=\"1\">\n"+
"<item-pOJOPK><concept-name><xsl:copy-of select='Update/Concept'/></concept-name><ids><xsl:copy-of select='Update/Key'/></ids><data-cluster-pOJOPK><ids><xsl:copy-of select='Update/DataCluster'/></ids></data-cluster-pOJOPK></item-pOJOPK>\n"+
"</xsl:template> </xsl:stylesheet>\n",input,output,false);
		
		//step 2
		input=new WSTransformerVariablesMapping[1];
		input[0]=new WSTransformerVariablesMapping("item_primary_key","item_primary_key",null);
		output=new WSTransformerVariablesMapping[1];
		output[0]=new WSTransformerVariablesMapping("output","execution_result",null);
		String parameter="<parameters>\n";
		
		//get workflowtrigger config
		WSString config=Util.getPort(xobject).getServiceConfiguration(new WSServiceGetConfiguration("amalto/local/transformer/plugin/workflowtrigger",""));
		String configuration=config.getValue()==null?"":config.getValue();
		if(configuration.length()>0){
			Element e=Util.parse(configuration).getDocumentElement();
			String initialContextFactory=Util.getFirstTextNode(e, "initialContextFactory");
			String providerURL=Util.getFirstTextNode(e, "providerURL");
			String apiType=Util.getFirstTextNode(e, "apiType");
			configuration="<initialContextFactory>"+initialContextFactory+"</initialContextFactory>\n";
			configuration=configuration+"<providerURL>"+providerURL+"</providerURL>\n";
			configuration=configuration+"<apiType>"+apiType+"</apiType>\n";
		}
		parameter=parameter+configuration+"\n";
		//get process id
		String process="<processId>"+ xobject.getDisplayName()+ "</processId>";
		process=process+"<processVersion>2.0</processVersion>\n";
		//get the whole parameters
		parameter=parameter+process+variableext.getText();		
		parameter=parameter+"</parameters>";
		steps[1]=new WSTransformerProcessStep("amalto/local/transformer/plugin/workflowtrigger","workflowtrigger",parameter,input,output,false);	
		
		transformer.setName("default_workflow_process_"+xobject.getDisplayName()+"_transformer");
		transformer.setDescription("default workflow process "+xobject.getDisplayName()+" transformer");
		transformer.setProcessSteps(steps);
		
		Util.getPort(xobject).putTransformerV2(new WSPutTransformerV2(transformer));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public boolean canFinish(){
		return isFinish;
	 }
	class WorkflowTriggerPage extends WizardPage{
		
		public WorkflowTriggerPage() {
			super("Workflowtrigger Step");
			setTitle("Workflowtrigger Step");
			setDescription("Generate the workflowtrigger step");
			setPageComplete(false);			
		}
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NULL);
			composite.setLayout(new GridLayout(3, false));
			Label tipLabel = new Label(composite,SWT.NONE);
			tipLabel.setText("Select variables from xpath:");
			GridData gd = new GridData(SWT.BEGINNING,SWT.CENTER,false,false,1,1);
			tipLabel.setLayoutData(gd);
			Button xpath=new Button(composite,SWT.PUSH);
			xpath.setText("...");
			xpath.setToolTipText("Select xpath");
			gd = new GridData(SWT.BEGINNING,SWT.CENTER,false,false,2,1);
			xpath.setLayoutData(gd);
			
			Label label = new Label(composite,SWT.NONE);
			label.setText("The genearted variables xml string:");
			gd = new GridData(SWT.BEGINNING,SWT.CENTER,false,false,1,1);
			label.setLayoutData(gd);
			variableext=new StyledText(composite,SWT.WRAP|SWT.BORDER);
			gd = new GridData(SWT.FILL,SWT.FILL,true,true,2,2);
			variableext.setLayoutData(gd);
			setControl(composite);
			
			xpath.addSelectionListener(new SelectionListener(){

				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void widgetSelected(SelectionEvent e) {
	        		
					XpathSelectDialog xpathDialog = new XpathSelectDialog(
		        				null,
		        				xobject.getParent(),"Select Multiple XPaths",
		        				view.getSite(),
								true,
								null								
						);
		       
	        		
	        		xpathDialog.setBlockOnOpen(true);
	        		xpathDialog.open();
	        		List<String> rets=new ArrayList<String>();
	        		if (xpathDialog.getReturnCode() == Window.OK && xpathDialog.getXpath().length()>0)  {
	        			String[] xpaths=xpathDialog.getXpath().split("&");
	        			for(String xpath:xpaths){
	        				StringBuffer sb=new StringBuffer();
	        				sb=sb.append("<variable><scope>process</scope>");
	        				String name="MDM_"+xpath.replaceAll("/", "_");
	        				sb=sb.append("<name>"+ name+"</name>");
	        				sb.append("<type>String</type><fromItem>true</fromItem>");
	        				sb.append("<xpath>"+xpath+"</xpath>");
	        				sb.append("</variable>\n");
	        				rets.add(sb.toString());
	        			}	        			
	        		}
	        		StringBuffer sb=new StringBuffer();
	        		for(String str:rets){
	        			sb=sb.append(str+"\n");
	        		}
	        		variableext.setText(sb.toString());
	        		if(variableext.getText().length()>0){
	        			isFinish=true;
	        			setPageComplete(true);
					}else{
						setPageComplete(false);
					}
	        			
				}
				
			});
			
			
		}
		
	}
}
