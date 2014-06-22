// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.amalto.workbench.dialogs.JobProcesssOptionsDialog;
import com.amalto.workbench.dialogs.JobProcesssOptionsDialog.Execution;
import com.amalto.workbench.dialogs.JobProcesssOptionsDialog.Parameter;
import com.amalto.workbench.i18n.Messages;
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

public class GenerateJobDefaultTransformerAction extends Action {

	private static Log log = LogFactory
			.getLog(GenerateJobDefaultTransformerAction.class);

	private ServerView server = ServerView.show();

	private TreeObject xobject;

	public GenerateJobDefaultTransformerAction() {
		super();
		setImageDescriptor(ImageCache.getImage(EImage.JOB.getPath()));
		setText(Messages.GenerateJobXX_Text1);
		setToolTipText(Messages.GenerateJobXX_Text1);
	}

	public void run() {
		if (this.server != null) { // called from ServerView
			ISelection selection = server.getViewer().getSelection();
			xobject = (TreeObject) ((IStructuredSelection) selection)
					.getFirstElement();
		}

		if (xobject.getType() != TreeObject.JOB) {
			return;
		}

		String filename = xobject.getDisplayName();
		Execution defaultExecutionType = filename.endsWith("zip") ? Execution.EMBEDDED : Execution.WEB_SERVICE; //$NON-NLS-1$
		
		JobProcesssOptionsDialog dialog = new JobProcesssOptionsDialog(server
				.getSite().getShell(), defaultExecutionType);
		dialog.setBlockOnOpen(true);
		int ret = dialog.open();
		if (ret == Dialog.CANCEL) {
			return;
		}

		WSTransformerV2 transformer = new WSTransformerV2();
		String jobname = null;
		String jobversion = null;
		if (filename.lastIndexOf("_") > 0 && filename.lastIndexOf(".") > 0) {//$NON-NLS-1$ //$NON-NLS-2$ 
			jobname = filename.substring(0, filename.lastIndexOf("_"));//$NON-NLS-1$ 
			jobversion = filename.substring(0, filename.lastIndexOf("."));//$NON-NLS-1$ 
		}
		if (jobname == null || jobname.length() == 0) {
			return;
		}

		Execution execution = dialog.getExecution();
		Parameter executionParameter = dialog.getParameter();
		
		String url = ""; //$NON-NLS-1$
		switch (execution) {
		case EMBEDDED:
			String version = jobversion.substring(jobname.length() + 1);
			url = "ltj://" + jobname + "/" + version; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		case WEB_SERVICE:
			String server = "http://" + xobject.getEndpointHost()+ ":" + xobject.getEndpointPort(); //$NON-NLS-1$ //$NON-NLS-2$
			url = server + "/" + jobversion + "/services/" + jobname; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		}
		
		// Generate the job call
		transformer.setName("CallJob_" + filename);//$NON-NLS-1$
		transformer
				.setDescription("Process that calls the Talend Job: " + filename);//$NON-NLS-1$ 

		WSTransformerProcessStep[] steps = new WSTransformerProcessStep[0];
		WSTransformerVariablesMapping[] input; 
		WSTransformerVariablesMapping[] output;
		try {
			switch (executionParameter) {
			case CONTEXT_VARIABLE:
				steps = new WSTransformerProcessStep[3];
				
				String itemstr = "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"  xmlns:mdm=\"java:com.amalto.core.plugin.base.xslt.MdmExtension\" version=\"1.0\"> <xsl:output method=\"xml\" indent=\"yes\" omit-xml-declaration=\"yes\" /> <xsl:template match=\"/\" priority=\"1\">\n" //$NON-NLS-1$
						+ "<exchange> <report>\n <xsl:copy-of select=\"Update\"/> </report>  <item><xsl:copy-of select='mdm:getItemProjection(Update/RevisionID,Update/DataCluster,Update/Concept,Update/Key)'/></item></exchange> "//$NON-NLS-1$ 
						+ "</xsl:template> </xsl:stylesheet>\n";//$NON-NLS-1$
				input = new WSTransformerVariablesMapping[1];
				input[0] = new WSTransformerVariablesMapping(
						"_DEFAULT_", "xml", null);//$NON-NLS-1$ //$NON-NLS-2$ 
				output = new WSTransformerVariablesMapping[1];
				output[0] = new WSTransformerVariablesMapping(
						"item_xml", "text", null);//$NON-NLS-1$ //$NON-NLS-2$ 

				steps[0] = new WSTransformerProcessStep(
						"amalto/local/transformer/plugin/xslt",//$NON-NLS-1$ 
						"Retrieve the complete item from the update report", itemstr, input, output, false);//$NON-NLS-1$ 
				// Generate the XSLT step to retrieve the item from an update
				// report
				// step 2
				input = new WSTransformerVariablesMapping[1];
				input[0] = new WSTransformerVariablesMapping(
						"item_xml", "law_text", null);//$NON-NLS-1$ //$NON-NLS-2$ 
				output = new WSTransformerVariablesMapping[1];
				output[0] = new WSTransformerVariablesMapping(
						"decode_xml", "codec_text", null);//$NON-NLS-1$ //$NON-NLS-2$ 
				String parameter = "<parameters>\n" + "<method>DECODE</method>\n" + "<algorithm>XMLESCAPE</algorithm>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
						+ "</parameters>\n";//$NON-NLS-1$ 
				steps[1] = new WSTransformerProcessStep(
						"amalto/local/transformer/plugin/codec", "Escape the item XML",//$NON-NLS-1$ //$NON-NLS-2$ 
						parameter, input, output, false);
				// Generate the codec step to escape the item xml
				// step 3
				input = new WSTransformerVariablesMapping[1];
				input[0] = new WSTransformerVariablesMapping(
						"decode_xml", "text", null);//$NON-NLS-1$ //$NON-NLS-2$ 
				output = new WSTransformerVariablesMapping[1];
				output[0] = new WSTransformerVariablesMapping(
						"output", "result", null);//$NON-NLS-1$ //$NON-NLS-2$ 
				parameter = "<configuration>\n" + "<url>" + url +"</url>\n" + "<contextParam>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
						+ "<name>xmlInput</name>\n" + "<value>{decode_xml}</value>\n" + "</contextParam>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
						+ "</configuration>\n";//$NON-NLS-1$ 
				steps[2] = new WSTransformerProcessStep(
						"amalto/local/transformer/plugin/callJob", "Invoke the job", parameter,//$NON-NLS-1$ //$NON-NLS-2$ 
						input, output, false);

				break;
			case INTEGRATED:
				steps = new WSTransformerProcessStep[1];
				
				input = new WSTransformerVariablesMapping[1];
                input[0] = new WSTransformerVariablesMapping("_DEFAULT_", "text", null);//$NON-NLS-1$ //$NON-NLS-2$ 
				output = new WSTransformerVariablesMapping[1];
				output[0] = new WSTransformerVariablesMapping("item_xml", "result", null);//$NON-NLS-1$ //$NON-NLS-2$ 
				parameter = "<configuration>\n" + "<url>" + url +"</url>\n"  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
						+ "</configuration>\n"; //$NON-NLS-1$ 
				steps[0] = new WSTransformerProcessStep(
						"amalto/local/transformer/plugin/callJob",//$NON-NLS-1$ 
						"Invoke the job", parameter, input, output, false); //$NON-NLS-1$  //$NON-NLS-2$
				break;
			default:
				log.warn(Messages.bind(Messages.GenerateJobXX_UnsupportedType, executionParameter));
				steps =  new WSTransformerProcessStep[0];
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			// server.forceAllSiteToRefresh();
		}
		
		// Set steps for process
		transformer.setProcessSteps(steps);

		try {
			Util.getPort(xobject).putTransformerV2(
					new WSPutTransformerV2(transformer));
			// add the object to the tree
			TreeObject obj = new TreeObject(transformer.getName(),
					xobject.getServerRoot(), TreeObject.TRANSFORMER,
					new WSTransformerV2PK(transformer.getName()), null // no
																		// storage
																		// to
																		// save
																		// space
			);
			TreeParent folder = xobject
					.findServerFolder(TreeObject.TRANSFORMER);
			folder.addChild(obj);
		} catch (Exception e) {
			e.printStackTrace(); // TODO
		}

	}

}
