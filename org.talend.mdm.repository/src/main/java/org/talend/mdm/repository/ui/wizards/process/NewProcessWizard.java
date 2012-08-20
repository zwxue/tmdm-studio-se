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

import com.amalto.workbench.utils.Util;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class NewProcessWizard extends Wizard {

    //
    public static final int ANY_TYPE = 0;
    
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

    // SMARTVIEW
    public static final int SMARTVIEW_TYPE = 8;

    private SelectProcessTypePage selectProcessTypePage;

    private InputProcessNamePage inputProcessNamePage;

    private final IWorkbenchPartSite site;

    private ConfigRedirectURLPage configRedirectURLPage;

    private ConfigReturnMessagePage configReturnMessagePage;

    private WSTransformerV2E transformer;

    List<IMDMJobTemplate> jobTemplates;
    
    private int type;//use it to decide which type of process can be create,if 0,all type is permitted
    
    public WSTransformerV2E getNewProcess() {
        return this.transformer;
    }

    public NewProcessWizard(IWorkbenchPartSite site, int type) {
        this.site = site;
        this.type = type;
        setWindowTitle(Messages.NewProcessWizard_title);
    }

    @Override
    public void addPages() {
        selectProcessTypePage = new SelectProcessTypePage(type);
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
        String processdesc=inputProcessNamePage.getProcessDesc();
        transformer = MdmserverobjectFactory.eINSTANCE.createWSTransformerV2E();
        transformer.setName(processName);
        if(processdesc==null|| processdesc.length()==0){
            processdesc=Messages.bind(Messages.NewProcessWizard_TemplateProcess, processName);
        }
        transformer.setDescription(processdesc); 
       
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
    	boolean createJob=false;    	
    	if(jobTemplates !=null && jobTemplates.size()>0){
    	    IMDMJobTemplate jobtemplate= jobTemplates.get(0);
    	    createJob=jobtemplate.createJob();
    	}
        switch (processType) {
        case BEFORE_DELETING:
        case BEFORE_SAVING:
            String[] messageParams = configReturnMessagePage.getMessageParams();
            WSTransformerProcessStepE messageStep = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_RETURN_MESSAGE,
                    messageParams, processName, createJob);
            steps.add(messageStep);
            break;
        case RUNNABLE_RUNNABLE:
            WSTransformerProcessStepE updateStep = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_UPDATE_REPORT,
                    null, processName, createJob);
            WSTransformerProcessStepE escapeStep = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_ESCAPE, null, processName, createJob);
            steps.add(updateStep);
            steps.add(escapeStep);
                        
            String url = configRedirectURLPage.getUrl();
            //job name can't contains #,$ etc
            processName=processName.replaceAll("#|\\$", ""); //$NON-NLS-1$ //$NON-NLS-2$
            WSTransformerProcessStepE callJobStep = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_REDIRECT,
                    url, processName, createJob);
            steps.add(callJobStep);
            
            break;            
        case RUNNABLE_STANDALONE:                        
            //job name can't contains #,$ etc
            processName=processName.replaceAll("#|\\$", ""); //$NON-NLS-1$ //$NON-NLS-2$
            boolean isEnterprise=Util.IsEnterPrise();
            url = configRedirectURLPage.getUrl();
            if(isEnterprise && createJob){
                if(url!=null && url.length()>0){
                    callJobStep = ProcessStepFactory.createCallJobStep(processName, ProcessStepFactory.VAR_OUTPUT_URL, ProcessStepFactory.VAR_DEFAULT);
                }else{
                    callJobStep = ProcessStepFactory.createCallJobStep(processName, ProcessStepFactory.VAR_OUTPUT, ProcessStepFactory.VAR_DEFAULT);
                }
            }else{
                if(url!=null && url.length()>0){
                    callJobStep=ProcessStepFactory.createRedirectStep(url, ProcessStepFactory.VAR_OUTPUT_URL);
                }else{
                    callJobStep=ProcessStepFactory.createRedirectStep(url, ProcessStepFactory.VAR_OUTPUT);
                }
            }
            steps.add(callJobStep);
            
            break;
        case OTHER_TYPE:
            WSTransformerProcessStepE updateStep2 = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_UPDATE_REPORT,
                    null, processName, createJob);
            WSTransformerProcessStepE escapeStep2 = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_ESCAPE, null, processName, createJob);
            steps.add(updateStep2);
            steps.add(escapeStep2);
            
            //job name can't contains #,$ etc
            processName=processName.replaceAll("#|\\$", ""); //$NON-NLS-1$ //$NON-NLS-2$
            callJobStep = ProcessStepFactory.createProcessStep(ProcessStepFactory.STEP_REDIRECT,
                    null, processName, createJob);
            steps.add(callJobStep);
            
            break;
        case SMARTVIEW_TYPE:
            WSTransformerProcessStepE xsltStep = ProcessStepFactory.createSmartViewStep();
            steps.add(xsltStep);
            break;
        default:
            break;
        }
    }

    public String getInputName() {
        return selectProcessTypePage.getInputName();
    }
    
    public void generateJobTemplate(){
        int type = inputProcessNamePage.getProcessType();
        if (type == SMARTVIEW_TYPE)// don't create job if smartview
            return;
		String[] messages=configReturnMessagePage.getMessageParams();		
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
