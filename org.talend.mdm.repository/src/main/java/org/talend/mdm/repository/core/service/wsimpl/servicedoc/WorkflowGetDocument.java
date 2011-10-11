// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.service.wsimpl.servicedoc;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class WorkflowGetDocument extends AbstractGetDocument {

    /**
     * DOC hbhong CopyOfCallJobGetDocument constructor comment.
     * 
     * @param twoLettersLanguageCode
     */
    public WorkflowGetDocument(String twoLettersLanguageCode) {
        super(twoLettersLanguageCode);
    }

    @Override
    public String getJNDIName() {
        return "workflow"; //$NON-NLS-1$
    }

    @Override
    public String getDescription() {
        if ("fr".matches(twoLettersLanguageCode.toLowerCase()))
            return "This service handle the basic functionality of workflow";
        return "This service handle the basic functionality of workflow";
    }

    @Override
    public String getDocument() {
        return "Instanciate a workflow and send it an MDM record. \n"
                + "\n"
                + "\n"
                + "Parameters\n"
                +
                // "    initialContextFactory [mandatory]: the Initial Context Factory "+"\n"+
                // "    providerURL [mandatory]: the provider URL "+"\n"+
                // "    apiType [mandatory]: the API type "+"\n"+
                // "    packageId [mandatory]: the packageId of the process "+"\n"+
                "   processId [mandatory]: the processId of the workflow "
                + "\n"
                + " processVersion [mandatory]: the processVersion of the workflow "
                + "\n"
                + " useBuiltInVariable [optional]: default value is true (see below)"
                + "\n"
                +
                // "    needGoThrough [optional]: default value is false "+"\n"+
                "   defaultDataModel [optional]: default value of the datamodel (if not "
                + "\n"
                + " set, workflowtrigger will use the last data-model the record was\n"
                + " last created or updated with)\n"
                +
                // "    username [mandatory]: the username used to login workflow "+"\n"+
                // "    password [mandatory]: the password used to login workflow "+"\n"+
                "   variable [optional]: define a variable so send in the workflow "
                + "\n"
                + "     scope: the scope of the variable, 'process' or 'activity' "
                + "\n"
                + "     activityId [optional]: if the scope is equals to 'activity' "
                + "\n"
                + "     name: the name of the variable defined in the workflow"
                + "\n"
                + "     type: the type of variable, like 'String','Boolean' etc. "
                + "\n"
                + "     fromItem: grab the value from the record, 'true' or 'false' "
                + "\n"
                + "     xpath [optional]: if the fromItem is equals to 'true' "
                + "\n"
                + "     value [optional]: if the fromItem is equals to 'false' "
                + "\n"
                + "\n"
                + "When useBuiltInVariable is set to 'true', workflowtrigger will also\n"
                + "pass the following set of variables in the workflow instance:\n"
                + " MDM_host: the host MDM server is running on\n"
                + " MDM_port: the port MDM server is listening to\n"
                + " MDM_universe: the version to connect to (the old name 'universe' was\n"
                + " retained for background compatibility with early versions of Talend MDM)\n"
                + " MDM_dataCluster: the data-container to connect to ('data-cluster' = old\n"
                + " name for data-container)\n"
                + " MDM_dataModel: the data-model to use\n"
                + "\n"
                + "Note: you can define those variables in your workflow with the\n"
                + "'MDM_' prefix (uppercase) or 'mdm_' prefix (lowercase), both are supported.\n"
                + "\n"
                + "\n"
                + "Example"
                + "\n"
                + " <parameters>"
                + "\n"
                +
                // "        <initialContextFactory>org.jnp.interfaces.NamingContextFactory</initialContextFactory>"
                // +"\n"+
                // "        <providerURL>jnp://localhost:1099</providerURL>" +"\n"+
                // "        <apiType>EJB2</apiType>" +"\n"+
                // "        <packageId>ApprovalWorkflow</packageId>" +"\n"+
                "       <processId>ApprovalWorkflow</processId>"
                + "\n"
                + "     <processVersion>1.0</processVersion>"
                + "\n"
                +
                // "        <username>admin</username>" +"\n"+
                // "        <password>talend</password>" +"\n"+
                "       <variable>" + "\n" + "          <scope>process</scope>" + "\n" + "          <name>SampleItemName</name>"
                + "\n" + "         <type>String</type>" + "\n" + "         <fromItem>true</fromItem>" + "\n"
                + "           <xpath>/Customer/Name</xpath>" + "\n" + "      </variable>" + "\n" + "     <variable>" + "\n"
                + "          <scope>activity</scope>" + "\n" + "         <activityId>Approval</activityId>" + "\n"
                + "           <name>isGranted</name>" + "\n" + "          <type>Boolean</type>" + "\n"
                + "          <fromItem>false</fromItem>" + "\n" + "          <value>true</value>" + "\n" + "     </variable>"
                + "\n" + " </parameters>" + "\n" + "\n" + "\n" + "Notes for Plugin Developers: " + "\n" + "        empty";

    }
}
