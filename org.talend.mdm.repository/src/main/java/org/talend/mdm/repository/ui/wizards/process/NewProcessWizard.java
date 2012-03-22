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
package org.talend.mdm.repository.ui.wizards.process;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerV2E;
import org.talend.mdm.repository.utils.JobTemplateUtil;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class NewProcessWizard extends Wizard {

    // BEFORE
    public static final int BEFORE_TYPE = 1;

    public static final int BEFORE_SAVING = 2;

    public static final int BEFORE_DELETING = 3;

    // RUNNABLE
    public static final int RUNNABLE_TYPE = 4;

    public static final int RUNNABLE_RUNNABLE = 5;

    public static final int RUNNABLE_STANDALONE = 6;

    // OTHER
    public static final int OTHER_TYPE = 7;

    private SelectProcessTypePage selectProcessTypePage;

    private InputProcessNamePage inputProcessNamePage;

    private final IWorkbenchPartSite site;

    private ConfigRedirectURLPage configRedirectURLPage;

    private ConfigReturnMessagePage configReturnMessagePage;

    private WSTransformerV2E transformer;

    List<IMDMJobTemplate> jobTemplates;
    public WSTransformerV2E getNewProcess() {
        return this.transformer;
    }

    public NewProcessWizard(IWorkbenchPartSite site) {
        this.site = site;
        setWindowTitle(Messages.NewProcessWizard_title);
    }

    @Override
    public void addPages() {
        selectProcessTypePage = new SelectProcessTypePage();
        inputProcessNamePage = new InputProcessNamePage(site);
        configRedirectURLPage = new ConfigRedirectURLPage();
        configReturnMessagePage = new ConfigReturnMessagePage();
        // add
        addPage(selectProcessTypePage);
        addPage(inputProcessNamePage);
        addPage(configRedirectURLPage);
        addPage(configReturnMessagePage);
        
        //add job template generate page
        jobTemplates=JobTemplateUtil.getJobTemplateGenPages();
        for(IMDMJobTemplate jobPage:jobTemplates){
        	if(jobPage instanceof WizardPage){
        		addPage((WizardPage)jobPage);
        	}
        }
    }

    @Override
    public boolean performFinish() {
        String processName = inputProcessNamePage.getProcessName();
        int processType = inputProcessNamePage.getProcessType();
        transformer = MdmserverobjectFactory.eINSTANCE.createWSTransformerV2E();
        transformer.setName(processName);
        String desc=processName + " template process";
        transformer.setDescription(desc); 
        List<WSTransformerProcessStepE> steps = new ArrayList<WSTransformerProcessStepE>();
        createProcessStep(steps, processType);
        transformer.getProcessSteps().addAll(steps);
        
        //generate job template
        generateJobTemplate();
        return true;
    }

    @Override
    public boolean canFinish() {
        IWizardPage currentPage = getContainer().getCurrentPage();
        if (currentPage.isPageComplete() && currentPage.getNextPage() == null) {
            return true;
        }
        return false;
    }

    /**
     * DOC hbhong Comment method "createProcessStep".
     * 
     * @param steps
     * @param processType
     */
    private void createProcessStep(List<WSTransformerProcessStepE> steps, int processType) {
    	String processName=inputProcessNamePage.getProcessName();
        switch (processType) {
        case BEFORE_DELETING:
        case BEFORE_SAVING:
            String[] messageParams = configReturnMessagePage.getMessageParams();
            WSTransformerProcessStepE messageStep = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_RETURN_MESSAGE,
                    messageParams, processName);
            steps.add(messageStep);
            break;
        case RUNNABLE_RUNNABLE:
        case RUNNABLE_STANDALONE:
            WSTransformerProcessStepE updateStep = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_UPDATE_REPORT,
                    null, processName);
            WSTransformerProcessStepE escapeStep = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_ESCAPE, null, processName);
            steps.add(updateStep);
            steps.add(escapeStep);
            boolean enableRedirect = configRedirectURLPage.isEnableRedirect();
            if (enableRedirect) {
                String url = configRedirectURLPage.getUrl();
                //job name can't contains #,$ etc
                processName=processName.replaceAll("#|\\$", ""); //$NON-NLS-1$ //$NON-NLS-2$
                WSTransformerProcessStepE redirectStep = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_REDIRECT,
                        url, processName);
                steps.add(redirectStep);
            }
            break;
        case OTHER_TYPE:
            WSTransformerProcessStepE updateStep2 = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_UPDATE_REPORT,
                    null, processName);
            WSTransformerProcessStepE escapeStep2 = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_ESCAPE, null, processName);
            steps.add(updateStep2);
            steps.add(escapeStep2);
            break;
        default:
            break;
        }
    }

    public String getInputName() {
        return selectProcessTypePage.getInputName();
    }
    
    public void generateJobTemplate(){
    	
		String[] messages=configReturnMessagePage.getMessageParams();		
		int type= inputProcessNamePage.getProcessType();
		String infoType=null;
		String pMessage=null;
		if(type==BEFORE_DELETING|| type==BEFORE_SAVING){
			infoType=messages[0];
			pMessage=messages[1];
		}
		if(type==RUNNABLE_RUNNABLE|| type==RUNNABLE_STANDALONE){
			if(configRedirectURLPage.isEnableRedirect()){
				pMessage="<results><item><attr>" +configRedirectURLPage.getUrl()+ //$NON-NLS-1$
						 "</attr></item></results>";             //$NON-NLS-1$
			}else{
				pMessage=""; //$NON-NLS-1$
			}
		}		
        for(IMDMJobTemplate job:jobTemplates){
        	job.generateJobTemplate(type,inputProcessNamePage.getProcessName(), infoType, pMessage);
        }
    }
}
