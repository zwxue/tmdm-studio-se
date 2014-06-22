// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
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
import com.amalto.workbench.webservices.WSPutRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRuleExpression;
import com.amalto.workbench.webservices.WSRoutingRuleOperator;
import com.amalto.workbench.webservices.WSRoutingRulePK;

public class GenerateJobDefaultTriggerAction extends Action {

	private ServerView server = ServerView.show();

	private TreeObject xobject;

	public GenerateJobDefaultTriggerAction() {
		super();
		setImageDescriptor(ImageCache.getImage(EImage.JOB.getPath()));
		setText(Messages.GenerateJobXX_Text2);
		setToolTipText(Messages.GenerateJobXX_Text2);
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
			String server = "http://" + xobject.getEndpointHost() + ":" //$NON-NLS-1$ //$NON-NLS-2$
					+ xobject.getEndpointPort();
			url = server + "/" + jobversion + "/services/" + jobname; //$NON-NLS-1$ //$NON-NLS-2$
			break;
		}

		try {
			
			String parameter = ""; //$NON-NLS-1$
			switch(executionParameter) {
			case CONTEXT_VARIABLE:
				parameter = "<configuration>\n" + "<url>" + url + "</url><contextParam>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
				+ "<name>xmlInput</name>\n" + "<value>{exchange_data}</value>\n" + "</contextParam>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
				+ "</configuration>\n";//$NON-NLS-1$
				break;
			case INTEGRATED:
				parameter = "<configuration>\n" + "<url>" + url + "</url>"  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "</configuration>\n";//$NON-NLS-1$
				break;
			}

			// Generate the job call
			// create default CREATE operation express
			WSRoutingRuleExpression express1 = new WSRoutingRuleExpression(
					"C1", "Update/OperationType",//$NON-NLS-1$ //$NON-NLS-2$ 
					WSRoutingRuleOperator.CONTAINS, "CREATE");//$NON-NLS-1$ 
			WSRoutingRuleExpression express2 = new WSRoutingRuleExpression(
					"C2", "Update/OperationType",//$NON-NLS-1$ //$NON-NLS-2$
					WSRoutingRuleOperator.CONTAINS, "UPDATE");//$NON-NLS-1$ 
			WSRoutingRuleExpression express3 = new WSRoutingRuleExpression(
					"C3", "Update/OperationType",//$NON-NLS-1$ //$NON-NLS-2$
					WSRoutingRuleOperator.CONTAINS, "DELETE");//$NON-NLS-1$ 
			WSRoutingRule routingRule = new WSRoutingRule(
					(String) "CallJob_" + filename, "Trigger that calls the Talend Job: "//$NON-NLS-1$ //$NON-NLS-2$
							+ filename,
					false,
					"Update", "amalto/local/service/callJob", parameter, new WSRoutingRuleExpression[] {//$NON-NLS-1$ //$NON-NLS-2$
					express1, express2, express3 }, "C1 Or C2 Or C3", false);//$NON-NLS-1$

			Util.getPort(xobject).putRoutingRule(
					new WSPutRoutingRule(routingRule));
			// add the object to the tree
			TreeObject obj = new TreeObject(routingRule.getName(),
					xobject.getServerRoot(), TreeObject.ROUTING_RULE,
					new WSRoutingRulePK((String) routingRule.getName()),
					routingRule // no storage to save space
			);
			TreeParent folder = xobject.findServerFolder(TreeObject.ROUTING_RULE);
			folder.addChild(obj);

		} catch (Exception e) {

		} finally {

		}

	}

}
