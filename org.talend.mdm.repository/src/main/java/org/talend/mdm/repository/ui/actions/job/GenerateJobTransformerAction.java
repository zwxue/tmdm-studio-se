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
package org.talend.mdm.repository.ui.actions.job;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.Dialog;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.commons.ui.runtime.image.ImageProvider;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerV2E;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE;
import org.talend.mdm.repository.ui.dialogs.job.JobOptionsDialog;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC jsxie class global comment. Detailled comment
 */
public class GenerateJobTransformerAction extends AbstractRepositoryAction {

    /**
     * 
     */
    private static final String PREFIX = "CallJob_"; //$NON-NLS-1$

    protected Object selectObj;

    static Logger log = Logger.getLogger(GenerateJobTransformerAction.class);

    public GenerateJobTransformerAction() {
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
        return GROUP_EDIT;
    }

    @Override
    public void run() {

        selectObj = getSelectedObject().get(0);

        JobOptionsDialog dialog = new JobOptionsDialog(getShell(), Messages.JobProcesssOptionsDialogTitle_title);
        dialog.setBlockOnOpen(true);
        int ret = dialog.open();
        if (ret == Dialog.CANCEL)
            return;

        String jobName = ""; //$NON-NLS-1$
        String jobVersion = ""; //$NON-NLS-1$

        if (selectObj instanceof IRepositoryViewObject) {
            jobName = ((IRepositoryViewObject) selectObj).getProperty().getLabel();
            jobVersion = ((IRepositoryViewObject) selectObj).getProperty().getVersion();

        }

        WSTransformerV2E transformer = createTransformer(jobName, jobVersion, dialog);
        RepositoryResourceUtil.removeViewObjectPhysically(IServerObjectRepositoryType.TYPE_TRANSFORMERV2, PREFIX + jobName,
                jobVersion, null);
        AttachToProcessView(jobName, transformer);

    }

    /**
     * DOC jsxie Comment method "createTransformer".
     * 
     * @param jobVersion
     */
    private WSTransformerV2E createTransformer(String jobName, String jobVersion, JobOptionsDialog dialog) {

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

            String server = "http://localhost:8080"; //$NON-NLS-1$

            boolean isWar = dialog.isWar();
            if (!isWar) {
                parameter = "<configuration>\n" + "<url>ltj://" + jobName + "/" + jobVersion + "</url>\n" + "<contextParam>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                        + "<name>xmlInput</name>\n" + "<value>{decode_xml}</value>\n" + "</contextParam>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
                        + "</configuration>\n";//$NON-NLS-1$ 
            } else {
                parameter = "<configuration>\n" + "<url>" + server + "/" + jobName + "_" + jobVersion + "/services/" + jobName + "</url>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
                        + "<contextParam>\n" + "<name>xmlInput</name>\n" + "<value>{decode_xml}</value>\n"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
                        + "</contextParam>\n" + "</configuration>\n";//$NON-NLS-1$ //$NON-NLS-2$ 
            }

            steps3.setParameters(parameter);
            steps3.getInputMappings().addAll(inItems3);
            steps3.getOutputMappings().addAll(outItems3);
            steps3.setDisabled(false);
            // Generate the job call

            transformer.setName(PREFIX + jobName);
            transformer.setDescription("Process that calls the Talend Job: " + jobName);//$NON-NLS-1$ 

            list.add(steps1);
            list.add(steps2);
            list.add(steps3);
            transformer.getProcessSteps().addAll(list);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return transformer;
    }

    /**
     * DOC jsxie Comment method "AttachToProcessView".
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
        RepositoryResourceUtil.createItem(item, PREFIX + filename);
        getCommonViewer().refresh();
        // refreshRepositoryRoot(IServerObjectRepositoryType.TYPE_TRANSFORMERV2);

    }

}
