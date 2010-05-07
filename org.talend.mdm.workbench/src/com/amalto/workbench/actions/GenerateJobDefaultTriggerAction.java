package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSPutRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRuleExpression;
import com.amalto.workbench.webservices.WSRoutingRuleOperator;
import com.amalto.workbench.webservices.WSRoutingRulePK;

public class GenerateJobDefaultTriggerAction extends Action{

	private ServerView server = ServerView.show();
	private TreeObject xobject;

				
	public GenerateJobDefaultTriggerAction() {
		super();			
		setImageDescriptor(ImageCache.getImage(EImage.JOB.getPath()));
		setText("Generate Talend Job Caller Trigger");
		setToolTipText("Generate Talend Job Caller Trigger");
	}
	
	public void run() {
		if (this.server != null) { //called from ServerView
			ISelection selection = server.getViewer().getSelection();
			xobject = (TreeObject)((IStructuredSelection)selection).getFirstElement();
		}
        
        if (xobject.getType()!=TreeObject.JOB) return;

		try {
			String parameter= "";
			String server="http://"+xobject.getEndpointHost()+":"+xobject.getEndpointPort();
			
			String filename=xobject.getDisplayName();
			String jobname=null;
			String jobversion=null;
			if(filename.lastIndexOf("_")>0 && filename.lastIndexOf(".")>0) {
				jobname=filename.substring(0,filename.lastIndexOf("_"));
				jobversion=filename.substring(0,filename.lastIndexOf("."));
			}
			if(jobname==null || jobname.length()==0) return;
			//.zip
			if(filename.endsWith(".zip")) {
				String version=jobversion.substring(jobname.length()+1);
				parameter="<configuration>\n"+
				"<url>ltj://"+jobname+"/"+version+"</url>\n"+
				"<contextParam>\n"+
				"<name>xmlInput</name>\n"+
				"<value>{exchange_data}</value>\n"+
				"</contextParam>\n"+
				"</configuration>\n";			
			}else{			
				parameter="<configuration>\n"+
				"<url>"+server+"/"+jobversion+"/services/"+jobname+"</url>\n"+
				"<contextParam>\n"+
				"<name>xmlInput</name>\n"+
				"<value>{exchange_data}</value>\n"+
				"</contextParam>\n"+
				"</configuration>\n";
			}
			//Generate the job call
			//create default CREATE operation express
			WSRoutingRuleExpression express1=new WSRoutingRuleExpression("C1","Update/OperationType",WSRoutingRuleOperator.CONTAINS,"CREATE");
			WSRoutingRuleExpression express2=new WSRoutingRuleExpression("C2","Update/OperationType",WSRoutingRuleOperator.CONTAINS,"UPDATE");
			WSRoutingRuleExpression express3=new WSRoutingRuleExpression("C3","Update/OperationType",WSRoutingRuleOperator.CONTAINS,"DELETE");
	        WSRoutingRule routingRule = new WSRoutingRule(
	        		(String)"CallJob_"+filename,
	        		"Trigger that calls the Talend Job: "+filename,
	        		false,
	        		"Update",
	        		"callJob",
	        		parameter,
	        		new WSRoutingRuleExpression[] {express1,express2,express3},
	        		"C1 Or C2 Or C3",                    		
	        		false
	        );		
	
			
			Util.getPort(xobject).putRoutingRule(new WSPutRoutingRule(routingRule));
			//add the object to the tree
			TreeObject obj = new TreeObject(
					routingRule.getName(),
					xobject.getServerRoot(),
					TreeObject.ROUTING_RULE,
					new WSRoutingRulePK((String)routingRule.getName()),
					routingRule   //no storage to save space
			);
			TreeParent folder=xobject.findServerFolder(xobject.ROUTING_RULE);
			folder.addChild(obj);
    	   
       }catch(Exception e){
    	
       } finally{
      		
      	}
      
	}

}