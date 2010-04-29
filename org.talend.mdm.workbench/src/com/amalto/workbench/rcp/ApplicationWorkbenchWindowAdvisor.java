package com.amalto.workbench.rcp;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.ide.EditorAreaDropAdapter;

import sun.management.ManagementFactory;

import com.amalto.workbench.MDMWorbenchPlugin;
import com.amalto.workbench.Messages;
import com.amalto.workbench.availablemodel.AvailableModelUtil;
import com.amalto.workbench.register.RegisterManagement;
import com.amalto.workbench.register.RegisterWizard;
import com.amalto.workbench.register.RegisterWizardDialog;
import com.amalto.workbench.service.GlobalServiceRegister;
import com.amalto.workbench.service.branding.IBrandingService;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
    public void preWindowOpen() {
    	
    	
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        
        configurer.setInitialSize(new Point(1200, 950));
        configurer.setShowCoolBar(true);
        configurer.setShowStatusLine(true);
        configurer.setShowProgressIndicator(true);
        configurer.setShowPerspectiveBar(true);
        configurer.configureEditorAreaDropListener(new EditorAreaDropAdapter(configurer.getWindow()));

        //configurer.setTitle("Talend MDM Studio (3.2.0M2)");
    }
    @Override
    public void postWindowOpen() {
        // Start Web Service Registration
        try {
            if (!RegisterManagement.isProductRegistered()) {
                RegisterWizard registerWizard = new RegisterWizard();
                Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
                WizardDialog dialog = new RegisterWizardDialog(shell, registerWizard);
                dialog.setTitle(Messages.getString("RegisterWizard.windowTitle")); //$NON-NLS-1$
                if (dialog.open() == WizardDialog.OK) {

                    String projectLanguage = "java";

                    // OS
                    String osName = System.getProperty("os.name"); //$NON-NLS-1$
                    String osVersion = System.getProperty("os.version"); //$NON-NLS-1$

                    // Java version
                    String javaVersion = System.getProperty("java.version"); //$NON-NLS-1$

                    // Java Memory
                    long totalMemory = Runtime.getRuntime().totalMemory();

                    // RAM
                    com.sun.management.OperatingSystemMXBean composantSystem = (com.sun.management.OperatingSystemMXBean) ManagementFactory
                            .getOperatingSystemMXBean();
                    Long memRAM = new Long(composantSystem.getTotalPhysicalMemorySize() / 1024);

                    // CPU
                    int nbProc = Runtime.getRuntime().availableProcessors();

                    RegisterManagement.register(registerWizard.getEmail(), registerWizard.getCountry(), registerWizard
                            .isProxyEnabled(), registerWizard.getProxyHost(), registerWizard.getProxyPort(),
                            MDMWorbenchPlugin.getDefault().getBundle().getHeaders().get(
                                    org.osgi.framework.Constants.BUNDLE_VERSION).toString(), projectLanguage, osName,
                            osVersion, javaVersion, totalMemory, memRAM, nbProc);
                } else {
                    RegisterManagement.decrementTry();
                }
            }
        } catch (Exception e) {
        	e.printStackTrace();
            // Do nothing : registration web service error is not a problem
        }
        IBrandingService service = (IBrandingService) GlobalServiceRegister.getDefault().getService(IBrandingService.class);
        getWindowConfigurer()
                .setTitle(getWindowConfigurer().getTitle() + service.getBrandingConfiguration().getAdditionalTitle());

    }
}
