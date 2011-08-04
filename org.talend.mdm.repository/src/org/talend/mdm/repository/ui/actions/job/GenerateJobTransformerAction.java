// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions.job;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.commons.ui.runtime.image.ImageProvider;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerV2E;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.dialogs.JobProcesssOptionsDialog;

/**
 * DOC hbhong  class global comment. Detailled comment
 */
public class GenerateJobTransformerAction extends AbstractRepositoryAction {

    protected ContainerItem parentItem;

    protected Object selectObj;

    public GenerateJobTransformerAction() {
        // super(text);
        // TODO Auto-generated constructor stub

        super("Generate Talend Job Caller Process"); //$NON-NLS-1$
        setImageDescriptor(ImageProvider.getImageDesc(ECoreImage.PROCESS_ICON));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.AbstractRepositoryAction#getGroupName()
     */
    @Override
    public String getGroupName() {
        // TODO Auto-generated method stub
        return GROUP_EDIT;
    }

    @Override
    public void run() {
        parentItem = null;
        selectObj = getSelectedObject().get(0);
        if (selectObj instanceof IRepositoryViewObject) {
            Item pItem = ((IRepositoryViewObject) selectObj).getProperty().getItem();
            if (pItem instanceof ContainerItem) {
                parentItem = (ContainerItem) pItem;
            }
        }
        
        
        JobProcesssOptionsDialog dialog = new JobProcesssOptionsDialog(getShell(), "Which schema do you want?");
        dialog.setBlockOnOpen(true);
        int ret = dialog.open();
        if (ret == Dialog.CANCEL)
            return;
        String itemstr = "";//$NON-NLS-1$
        if (dialog.isExchange()) {
            itemstr = "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"  xmlns:mdm=\"java:com.amalto.core.plugin.base.xslt.MdmExtension\" version=\"1.0\"> <xsl:output method=\"xml\" indent=\"yes\" omit-xml-declaration=\"yes\" /> <xsl:template match=\"/\" priority=\"1\">\n" //$NON-NLS-1$
                    + "<exchange> <report>\n <xsl:copy-of select=\"Update\"/> </report>  <item><xsl:copy-of select='mdm:getItemProjection(Update/RevisionID,Update/DataCluster,Update/Concept,Update/Key)'/></item></exchange> "//$NON-NLS-1$ 
                    + "</xsl:template> </xsl:stylesheet>\n";//$NON-NLS-1$ 
        } else {
            itemstr = "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"  xmlns:mdm=\"java:com.amalto.core.plugin.base.xslt.MdmExtension\" version=\"1.0\"> <xsl:output method=\"xml\" indent=\"yes\" omit-xml-declaration=\"yes\" /> <xsl:template match=\"/\" priority=\"1\">\n"//$NON-NLS-1$ 
                    + "<item><xsl:copy-of select='mdm:getItemProjection(Update/RevisionID,Update/DataCluster,Update/Concept,Update/Key)'/></item>"//$NON-NLS-1$ 
                    + "</xsl:template> </xsl:stylesheet>\n";//$NON-NLS-1$ 
        }

        final String TRANSFORMER_PLUGIN = "amalto/local/transformer/plugin/xslt";//$NON-NLS-1$
        WSTransformerV2E transformer = MdmserverobjectFactory.eINSTANCE.createWSTransformerV2E();

        try {
            ArrayList<WSTransformerProcessStepE> list = new ArrayList<WSTransformerProcessStepE>();
            WSTransformerProcessStepE steps1 = MdmserverobjectFactory.eINSTANCE.createWSTransformerProcessStepE();
            List<WSTransformerVariablesMappingE> inItems = new ArrayList<WSTransformerVariablesMappingE>();
            WSTransformerVariablesMappingE inputLine = MdmserverobjectFactory.eINSTANCE.createWSTransformerVariablesMappingE();
            inputLine.setPipelineVariable("_DEFAULT_");//$NON-NLS-1$
            inputLine.setPluginVariable("xml");//$NON-NLS-1$
            inItems.add(inputLine);

            List<WSTransformerVariablesMappingE> outItems = new ArrayList<WSTransformerVariablesMappingE>();
            WSTransformerVariablesMappingE outputLine = MdmserverobjectFactory.eINSTANCE.createWSTransformerVariablesMappingE();
            outputLine.setPipelineVariable("item_xml");//$NON-NLS-1$
            outputLine.setPluginVariable("text");//$NON-NLS-1$
            outItems.add(outputLine);
            steps1.setPluginJNDI(TRANSFORMER_PLUGIN);
            steps1.setDescription("Stylesheet"); //$NON-NLS-1$
            steps1.setParameters(itemstr);
            steps1.getInputMappings().addAll(inItems);
            steps1.getOutputMappings().addAll(outItems);
            steps1.setDisabled(false);

            // Generate the XSLT step to retrieve the item from an update report
            // step 2
            WSTransformerProcessStepE steps2 = MdmserverobjectFactory.eINSTANCE.createWSTransformerProcessStepE();
            List<WSTransformerVariablesMappingE> inItems2 = new ArrayList<WSTransformerVariablesMappingE>();
            WSTransformerVariablesMappingE inputLine2 = MdmserverobjectFactory.eINSTANCE.createWSTransformerVariablesMappingE();
            inputLine2.setPipelineVariable("item_xml");//$NON-NLS-1$
            inputLine2.setPluginVariable("law_text");//$NON-NLS-1$
            inItems2.add(inputLine2);


            List<WSTransformerVariablesMappingE> outItems2 = new ArrayList<WSTransformerVariablesMappingE>();
            WSTransformerVariablesMappingE outputLine2 = MdmserverobjectFactory.eINSTANCE.createWSTransformerVariablesMappingE();
            outputLine2.setPipelineVariable("decode_xml");//$NON-NLS-1$
            outputLine2.setPluginVariable("codec_text");//$NON-NLS-1$
            outItems2.add(outputLine2);
            steps2.setPluginJNDI("amalto/local/transformer/plugin/codec");//$NON-NLS-1$ 
            steps2.setDescription("Escape the item XML"); //$NON-NLS-1$
            String parameter = "<parameters>\n" + "<method>DECODE</method>\n" + "<algorithm>XMLESCAPE</algorithm>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
                    + "</parameters>\n";//$NON-NLS-1$ 

            steps2.setParameters(parameter);
            steps2.getInputMappings().addAll(inItems2);
            steps2.getOutputMappings().addAll(outItems2);
            steps2.setDisabled(false);

            
          
     
            // step 3
            WSTransformerProcessStepE steps3 = MdmserverobjectFactory.eINSTANCE.createWSTransformerProcessStepE();
            List<WSTransformerVariablesMappingE> inItems3 = new ArrayList<WSTransformerVariablesMappingE>();
            WSTransformerVariablesMappingE inputLine3 = MdmserverobjectFactory.eINSTANCE.createWSTransformerVariablesMappingE();
            inputLine3.setPipelineVariable("decode_xml");//$NON-NLS-1$
            inputLine3.setPluginVariable("text");//$NON-NLS-1$
            inItems3.add(inputLine3);

            List<WSTransformerVariablesMappingE> outItems3 = new ArrayList<WSTransformerVariablesMappingE>();
            WSTransformerVariablesMappingE outputLine3 = MdmserverobjectFactory.eINSTANCE.createWSTransformerVariablesMappingE();
            outputLine3.setPipelineVariable("output");//$NON-NLS-1$
            outputLine3.setPluginVariable("result");//$NON-NLS-1$
            outItems3.add(outputLine3);
            steps3.setPluginJNDI("amalto/local/transformer/plugin/callJob");//$NON-NLS-1$ 
            steps3.setDescription("Invoke the job"); //$NON-NLS-1$

            //            String server = "http://" + xobject.getEndpointHost() + ":" + xobject.getEndpointPort();//$NON-NLS-1$ //$NON-NLS-2$ 

            // String filename = xobject.getDisplayName();
            String server = "http://localhost:8080"; //$NON-NLS-1$

            String filename = ""; //$NON-NLS-1$
            if (selectObj instanceof IRepositoryViewObject) {
                filename = ((IRepositoryViewObject) selectObj).getLabel();

            }

            String jobname = null;
            String jobversion = null;
            if (filename.lastIndexOf("_") > 0 && filename.lastIndexOf(".") > 0) {//$NON-NLS-1$ //$NON-NLS-2$ 
                jobname = filename.substring(0, filename.lastIndexOf("_"));//$NON-NLS-1$ 
                jobversion = filename.substring(0, filename.lastIndexOf("."));//$NON-NLS-1$ 
            }
            // if (jobname == null || jobname.length() == 0)
            // return;
            // .zip
            if (filename.endsWith(".zip")) {//$NON-NLS-1$
                String version = jobversion.substring(jobname.length() + 1);
                parameter = "<configuration>\n" + "<url>ltj://" + jobname + "/" + version + "</url>\n" + "<contextParam>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                        + "<name>xmlInput</name>\n" + "<value>{decode_xml}</value>\n" + "</contextParam>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
                        + "</configuration>\n";//$NON-NLS-1$ 
            } else {
                parameter = "<configuration>\n" + "<url>" + server + "/" + jobversion + "/services/" + jobname + "</url>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                        + "<contextParam>\n" + "<name>xmlInput</name>\n" + "<value>{decode_xml}</value>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
                        + "</contextParam>\n" + "</configuration>\n";//$NON-NLS-1$ //$NON-NLS-2$ 
            }

            steps3.setParameters(parameter);
            steps3.getInputMappings().addAll(inItems3);
            steps3.getOutputMappings().addAll(outItems3);
            steps3.setDisabled(false);
            // Generate the job call

            transformer.setName("CallJob_" + filename);//$NON-NLS-1$
            transformer.setDescription("Process that calls the Talend Job: " + filename);//$NON-NLS-1$ 
            // transformer.setProcessSteps(steps);

            list.add(steps1);
            list.add(steps2);
            list.add(steps3);
            transformer.getProcessSteps().addAll(list);


            AttachToProcessView(filename, transformer);

        } catch (Exception e) {
            // log.error(e.getMessage(), e);
            e.printStackTrace();
        }


    }

    /**
     * DOC hbhong Comment method "AttachToTreeView".
     * 
     * @param filename
     * @param transformer
     */
    private void AttachToProcessView(String filename, WSTransformerV2E transformer) {

        WSTransformerV2Item item = MdmpropertiesFactory.eINSTANCE.createWSTransformerV2Item();
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);
        item.setWsTransformerV2(transformer);
        item.getState().setPath(""); //$NON-NLS-1$
        RepositoryResourceUtil.createItem(item, "CallJob_" + filename); //$NON-NLS-1$
        refreshRepositoryRoot(IServerObjectRepositoryType.TYPE_TRANSFORMERV2);

    }

}
