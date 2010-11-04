package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.amalto.workbench.dialogs.InputComboDialog;
import com.amalto.workbench.dialogs.JobProcesssOptionsDialog;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSPutTransformerV2;
import com.amalto.workbench.webservices.WSTransformerProcessStep;
import com.amalto.workbench.webservices.WSTransformerV2;
import com.amalto.workbench.webservices.WSTransformerV2PK;
import com.amalto.workbench.webservices.WSTransformerVariablesMapping;

public class GenerateJobDefaultTransformerAction extends Action{

	private ServerView server = ServerView.show();
	private TreeObject xobject;

				
	public GenerateJobDefaultTransformerAction() {
		super();			
		setImageDescriptor(ImageCache.getImage(EImage.JOB.getPath()));
		setText("Generate Talend Job Caller Process");
		setToolTipText("Generate Talend Job Caller Process");
	}
	
	public void run() {
		JobProcesssOptionsDialog dialog = new JobProcesssOptionsDialog(
				server.getSite().getShell(),
   				"Which schema do you want?"   				
   		);
   		dialog.setBlockOnOpen(true);
   		int ret = dialog.open();
   		if (ret == Dialog.CANCEL) return;
   		String itemstr="";
   		if(dialog.isExchange()) {
   			itemstr="<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"  xmlns:mdm=\"java:com.amalto.core.plugin.base.xslt.MdmExtension\" version=\"1.0\"> <xsl:output method=\"xml\" indent=\"yes\" omit-xml-declaration=\"yes\" /> <xsl:template match=\"/\" priority=\"1\">\n"+
   			"<exchange> <report>\n <xsl:copy-of select=\"Update\"/> </report>  <item><xsl:copy-of select='mdm:getItemProjection(Update/RevisionID,Update/DataCluster,Update/Concept,Update/Key)'/></item></exchange> "+
   			"</xsl:template> </xsl:stylesheet>\n";
   		}else {
   			itemstr="<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"  xmlns:mdm=\"java:com.amalto.core.plugin.base.xslt.MdmExtension\" version=\"1.0\"> <xsl:output method=\"xml\" indent=\"yes\" omit-xml-declaration=\"yes\" /> <xsl:template match=\"/\" priority=\"1\">\n"+
   			"<item><xsl:copy-of select='mdm:getItemProjection(Update/RevisionID,Update/DataCluster,Update/Concept,Update/Key)'/></item>"+
   			"</xsl:template> </xsl:stylesheet>\n";
   		}
		if (this.server != null) { //called from ServerView
			ISelection selection = server.getViewer().getSelection();
			xobject = (TreeObject)((IStructuredSelection)selection).getFirstElement();
		}
        
        if (xobject.getType()!=TreeObject.JOB) return;
       try{ 
	
   		WSTransformerV2 transformer=new WSTransformerV2();
		try {
		WSTransformerProcessStep[] steps=new WSTransformerProcessStep[3];
		WSTransformerVariablesMapping[] input=new WSTransformerVariablesMapping[1];
		input[0]=new WSTransformerVariablesMapping("_DEFAULT_","xml",null);
		WSTransformerVariablesMapping[] output=new WSTransformerVariablesMapping[1];
		output[0]=new WSTransformerVariablesMapping("item_xml","text",null);
		
		steps[0]=new WSTransformerProcessStep("amalto/local/transformer/plugin/xslt","Retrieve the complete item from the update report",itemstr,input,output,false);
		//Generate the XSLT step to retrieve the item from an update report
		//step 2
		input=new WSTransformerVariablesMapping[1];
		input[0]=new WSTransformerVariablesMapping("item_xml","law_text",null);
		output=new WSTransformerVariablesMapping[1];
		output[0]=new WSTransformerVariablesMapping("decode_xml","codec_text",null);
		String parameter="<parameters>\n"+
				"<method>DECODE</method>\n"+
				"<algorithm>XMLESCAPE</algorithm>\n"+
				"</parameters>\n";
		steps[1]=new WSTransformerProcessStep("amalto/local/transformer/plugin/codec","Escape the item XML",parameter,input,output,false);
		//Generate the codec step to escape the item xml
		//step 3
		input=new WSTransformerVariablesMapping[1];
		input[0]=new WSTransformerVariablesMapping("decode_xml","text",null);
		output=new WSTransformerVariablesMapping[1];
		output[0]=new WSTransformerVariablesMapping("output","result",null);
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
			"<value>{decode_xml}</value>\n"+
			"</contextParam>\n"+
			"</configuration>\n";			
		}else{			
			parameter="<configuration>\n"+
			"<url>"+server+"/"+jobversion+"/services/"+jobname+"</url>\n"+
			"<contextParam>\n"+
			"<name>xmlInput</name>\n"+
			"<value>{decode_xml}</value>\n"+
			"</contextParam>\n"+
			"</configuration>\n";
		}
		steps[2]=new WSTransformerProcessStep("amalto/local/transformer/plugin/callJob","Invoke the job",parameter,input,output,false);
		//Generate the job call
		
		transformer.setName("CallJob_"+filename);
		transformer.setDescription("Process that calls the Talend Job: "+filename);
		transformer.setProcessSteps(steps);
		
		Util.getPort(xobject).putTransformerV2(new WSPutTransformerV2(transformer));
		//add the object to the tree
		TreeObject obj = new TreeObject(
				transformer.getName(),
				xobject.getServerRoot(),
				TreeObject.TRANSFORMER,
				new WSTransformerV2PK(transformer.getName()),
				null   //no storage to save space
		);
		TreeParent folder=xobject.findServerFolder(xobject.TRANSFORMER);
		folder.addChild(obj);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
       }catch(Exception e){
    	//add ymli. To refresh the view; fix the bug:0010322  
       } finally{
      		//server.forceAllSiteToRefresh();
      	}
      
	}

}
