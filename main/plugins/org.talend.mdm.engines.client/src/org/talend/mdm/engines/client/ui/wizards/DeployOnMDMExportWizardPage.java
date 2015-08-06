// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.engines.client.ui.wizards;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages;
import org.eclipse.ui.internal.wizards.datatransfer.WizardFileSystemResourceExportPage1;
import org.talend.commons.ui.runtime.exception.ExceptionHandler;
import org.talend.commons.ui.runtime.exception.MessageBoxExceptionHandler;
import org.talend.commons.ui.swt.formtools.LabelledCombo;
import org.talend.core.CorePlugin;
import org.talend.core.language.ECodeLanguage;
import org.talend.core.language.LanguageManager;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ProcessItem;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.SpagoBiServer;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.prefs.ITalendCorePrefConstants;
import org.talend.designer.runprocess.IProcessor;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.mdm.engines.client.i18n.Messages;
import org.talend.mdm.engines.client.proxy.ProxyUtil;
import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataFactory;
import org.talend.repository.documentation.ArchiveFileExportOperationFullPath;
import org.talend.repository.documentation.ExportFileResource;
import org.talend.repository.model.IRepositoryNode.ENodeType;
import org.talend.repository.model.IRepositoryNode.EProperties;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.ui.utils.ZipToFile;
import org.talend.repository.ui.wizards.exportjob.JavaJobExportReArchieveCreator;
import org.talend.repository.ui.wizards.exportjob.scriptsmanager.JobJavaScriptsWSManager;
import org.talend.repository.ui.wizards.exportjob.scriptsmanager.JobScriptsManager;
import org.talend.repository.ui.wizards.exportjob.scriptsmanager.JobScriptsManager.ExportChoice;

import com.amalto.workbench.utils.MDMServerDef;

/**
 * Page of the Job Scripts Export Wizard. <br/>
 * 
 * $Id: DeployOnMDMExportWizardPage.java 1 2007-04-26 11:29:00 cantoine
 * 
 */
public abstract class DeployOnMDMExportWizardPage extends WizardFileSystemResourceExportPage1 {

    private static final Log log = LogFactory.getLog(DeployOnMDMExportWizardPage.class);

    // widgets
    protected Button contextButton;

    protected ExportFileResource[] process;

    protected LabelledCombo serverSpagoBi;

    protected Combo contextCombo;

    protected JobScriptsManager manager;

    protected String jobLabelName;

    protected String jobPurposeDescription;

    private String jobVersion;

    private LabelledCombo exportTypeCombo;

    private SpagoBiServer mdmServer = null;

    protected List<JobDeploymentInfo> jobInfoList = new ArrayList<JobDeploymentInfo>();

    /**
     * Create an instance of this class.
     * 
     * @param name java.lang.String
     */
    protected DeployOnMDMExportWizardPage(String name, IStructuredSelection selection, SpagoBiServer mdmserver) {
        super(name, null);
        this.mdmServer = mdmserver;
        manager = new JobJavaScriptsWSManager(getExportChoiceMap(0),
                "", JobScriptsManager.ALL_ENVIRONMENTS, IProcessor.NO_STATISTICS, //$NON-NLS-1$
                IProcessor.NO_TRACES, ".war");
        RepositoryNode[] nodes = (RepositoryNode[]) selection.toList().toArray(new RepositoryNode[selection.size()]);

        List<ExportFileResource> list = new ArrayList<ExportFileResource>();
        for (int i = 0; i < nodes.length; i++) {
            RepositoryNode node = nodes[i];
            if (node.getType() == ENodeType.SYSTEM_FOLDER || node.getType() == ENodeType.SIMPLE_FOLDER) {
                addTreeNode(node, node.getProperties(EProperties.LABEL).toString(), list);
            }
            if (node.getType() == ENodeType.REPOSITORY_ELEMENT) {
                IRepositoryViewObject repositoryObject = node.getObject();
                if (repositoryObject.getProperty().getItem() instanceof ProcessItem) {
                    ProcessItem processItem = (ProcessItem) repositoryObject.getProperty().getItem();
                    ExportFileResource resource = new ExportFileResource(processItem, processItem.getProperty().getLabel());
                    if (mdmserver == null)
                        resource.setNode(node);
                    jobLabelName = processItem.getProperty().getLabel();
                    jobVersion = processItem.getProperty().getVersion();
                    jobPurposeDescription = processItem.getProperty().getPurpose();
                    list.add(resource);

                    // add by jsxie to fix bug 20084
                    JobDeploymentInfo jobInfo = new JobDeploymentInfo();
                    jobInfo.setJobLabelName(processItem.getProperty().getLabel());
                    jobInfo.setJobPath(processItem.getState().getPath());
                    jobInfo.setJobVersion(processItem.getProperty().getVersion());
                    jobInfo.setJobPurposeDescription(jobPurposeDescription);

                    jobInfoList.add(jobInfo);
                }
            }
        }

        process = list.toArray(new ExportFileResource[list.size()]);
    }

    private void addTreeNode(RepositoryNode node, String path, List<ExportFileResource> list) {
        if (node != null && node.getType() == ENodeType.REPOSITORY_ELEMENT) {
            IRepositoryViewObject repositoryObject = node.getObject();
            if (repositoryObject.getProperty().getItem() instanceof ProcessItem) {
                ProcessItem processItem = (ProcessItem) repositoryObject.getProperty().getItem();
                ExportFileResource resource = new ExportFileResource(processItem, path);
                resource.setNode(node);
                list.add(resource);
            }
        }
        Object[] nodes = node.getChildren().toArray();
        if (nodes.length <= 0) {
            return;
        }
        for (int i = 0; i < nodes.length; i++) {
            addTreeNode((RepositoryNode) nodes[i], path + "/" //$NON-NLS-1$
                    + ((RepositoryNode) nodes[i]).getProperties(EProperties.LABEL).toString(), list);
        }
    }

    /**
     * Create an instance of this class.
     * 
     * @param selection the selection
     */
    public DeployOnMDMExportWizardPage(IStructuredSelection selection) {
        this("publishOnSpagoExportPage1", selection, null); //$NON-NLS-1$
        setDescription(Messages.getString("DeployOnMDMExportWizardPage.publishJob")); //$NON-NLS-1$
        setTitle(DataTransferMessages.ArchiveExport_exportTitle);
    }

    /**
     * (non-Javadoc) Method declared on IDialogPage.
     */
    @Override
    public void createControl(Composite parent) {

        initializeDialogUnits(parent);

        Composite composite = new Composite(parent, SWT.NULL);
        composite.setLayout(new GridLayout());
        composite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
        composite.setFont(parent.getFont());

        // createDestinationGroup(composite);

        createOptionsGroup(composite);

        restoreResourceSpecificationWidgetValues(); // ie.- local
        restoreWidgetValues(); // ie.- subclass hook

        updateWidgetEnablements();
        setPageComplete(determinePageCompletion());
        setErrorMessage(null); // should not initially have error message

        setControl(composite);
        // giveFocusToDestination();
    }

    /*
     * @see org.eclipse.ui.internal.wizards.datatransfer.WizardFileSystemResourceExportPage1#validateSourceGroup()
     */
    @Override
    protected boolean validateSourceGroup() {
        return true;
    }

    /**
     * Create the export options specification widgets.
     * 
     */
    @Override
    protected void createOptionsGroupButtons(Group optionsGroup) {
        Font font = optionsGroup.getFont();
        optionsGroup.setLayout(new GridLayout(1, true));

        Composite left = new Composite(optionsGroup, SWT.NONE);
        left.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false));
        left.setLayout(new GridLayout(2, true));

        createOptions(left, font);

    }

    /**
     * Create the buttons for the group that determine if the entire or selected directory structure should be created.
     * 
     * @param optionsGroup
     * @param font
     */
    protected void createOptions(Composite optionsGroup, Font font) {
        // create directory structure radios
        List<MDMServerDef> listServerSapgo = com.amalto.workbench.utils.MDMServerHelper.getServers();
        List<String> listEngine = new ArrayList<String>();

        if (mdmServer == null) {

            for (MDMServerDef serv : listServerSapgo) {
                listEngine.add(serv.getName());
            }
            serverSpagoBi = new LabelledCombo(
                    optionsGroup,
                    Messages.getString("DeployOnMDMExportWizardPage.SpagoBI.Server"), Messages.getString("DeployOnMDMExportWizardPage.SpecifyServer.PublishJob"), listEngine); //$NON-NLS-1$ //$NON-NLS-2$
            serverSpagoBi.select(0);
        }

        List<String> types = new ArrayList<String>();
        types.add("Distributed (War)");
        types.add("Hosted (Zip)");
        exportTypeCombo = new LabelledCombo(optionsGroup, "Export type:", "Export type", types); //$NON-NLS-1$ //$NON-NLS-2$
        exportTypeCombo.select(1);

        contextButton = new Button(optionsGroup, SWT.CHECK | SWT.LEFT);
        contextButton.setText(Messages.getString("JobScriptsExportWizardPage.contextPerlScripts")); //$NON-NLS-1$
        contextButton.setSelection(true);
        contextButton.setFont(font);

        contextCombo = new Combo(optionsGroup, SWT.PUSH);

    }

    /**
     * Returns a boolean indicating whether the directory portion of the passed pathname is valid and available for use.
     */
    protected boolean ensureTargetDirectoryIsValid(String fullPathname) {
        int separatorIndex = fullPathname.lastIndexOf(File.separator);

        if (separatorIndex == -1) {
            return true;
        }

        return ensureTargetIsValid(new File(fullPathname.substring(0, separatorIndex)));
    }

    /**
     * Returns a boolean indicating whether the passed File handle is is valid and available for use.
     */
    protected boolean ensureTargetFileIsValid(File targetFile) {
        if (targetFile.exists() && targetFile.isDirectory()) {
            displayErrorDialog(DataTransferMessages.ZipExport_mustBeFile);
            giveFocusToDestination();
            return false;
        }

        if (targetFile.exists()) {
            if (!targetFile.canWrite()) {
                displayErrorDialog(DataTransferMessages.ZipExport_alreadyExistsError);
                giveFocusToDestination();
                return false;
            }
        }

        return true;
    }

    /**
     * Ensures that the target output file and its containing directory are both valid and able to be used. Answer a
     * boolean indicating validity.
     */
    protected boolean ensureTargetIsValid() {
        String targetPath = getDestinationValue();

        if (!ensureTargetDirectoryIsValid(targetPath)) {
            return false;
        }

        if (!ensureTargetFileIsValid(new File(targetPath))) {
            return false;
        }

        return true;
    }

    /**
     * Export the passed resource and recursively export all of its child resources (iff it's a container). Answer a
     * boolean indicating success.
     */
    protected boolean executeExportOperation(ArchiveFileExportOperationFullPath op) {
        op.setCreateLeadupStructure(true);
        op.setUseCompression(true);

        try {
            getContainer().run(true, true, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            displayErrorDialog(e.getTargetException());
            return false;
        }

        IStatus status = op.getStatus();
        if (!status.isOK()) {
            ErrorDialog.openError(getContainer().getShell(), "", null, // no //$NON-NLS-1$
                    // special
                    // message
                    status);
            return false;
        }

        return true;
    }

    /**
     * The Finish button was pressed. Try to do the required work now and answer a boolean indicating success. If false
     * is returned then the wizard will not close.
     * 
     * @returns boolean
     */
    @Override
    public boolean finish() {
        Map<ExportChoice, Object> exportChoiceMap = getExportChoiceMap();
        boolean canExport = false;
        for (ExportChoice choice : ExportChoice.values()) {

            if (exportChoiceMap.get(choice) != null && exportChoiceMap.get(choice) instanceof Boolean
                    && (Boolean) exportChoiceMap.get(choice)) {
                canExport = true;
                break;
            }
        }
        if (!canExport) {
            MessageDialog.openInformation(getContainer().getShell(),
                    Messages.getString("DeployOnMDMExportWizardPage.publishResourceError"), //$NON-NLS-1$
                    Messages.getString("DeployOnMDMExportWizardPage.chooseResource")); //$NON-NLS-1$
            return false;
        }

        if (!ensureTargetIsValid()) {
            return false;
        }

        String topFolder = getRootFolderName();
        // reset the manager
        if (exportTypeCombo.getSelectionIndex() == 0) {// war
            manager = new JobJavaScriptsWSManager(exportChoiceMap, contextCombo.getText(), JobScriptsManager.ALL_ENVIRONMENTS,
                    IProcessor.NO_STATISTICS, IProcessor.NO_TRACES, ".war"); //$NON-NLS-1$
        }
        if (exportTypeCombo.getSelectionIndex() == 1) {// zip
            manager = new JobJavaScriptsManager(exportChoiceMap, contextCombo.getText(), JobScriptsManager.ALL_ENVIRONMENTS,
                    IProcessor.NO_STATISTICS, IProcessor.NO_TRACES);
        }

        List<ExportFileResource> resourcesToExport = null;
        try {
            resourcesToExport = getExportResources();
        } catch (ProcessorException e) {
            MessageBoxExceptionHandler.process(e);
            return false;
        }
        setTopFolder(resourcesToExport, topFolder);

        // Save dirty editors if possible but do not stop if not all are saved
        saveDirtyEditors();
        // about to invoke the operation so save our state
        saveWidgetValues();
        ArchiveFileExportOperationFullPath exporterOperation = getExporterOperation(resourcesToExport);
        boolean ok = executeExportOperation(exporterOperation);
        // TODO What if not ok ????

        // path can like name/name
        manager.deleteTempFiles();

        ProcessorUtilities.resetExportConfig();

        for (int i = 0; i < process.length; i++) {
            ProcessItem processItem = (ProcessItem) process[i].getItem();
            try {
                ProcessorUtilities.generateCode(processItem, processItem.getProcess().getDefaultContext(), false, false);
            } catch (ProcessorException e) {
                MessageBoxExceptionHandler.process(e);
                return false;
            }

        }
        // achen modify to fix bug 0006108
        // rearchieve the jobscript zip file
        ECodeLanguage curLanguage = LanguageManager.getCurrentLanguage();
        if (curLanguage == ECodeLanguage.JAVA) {
            reBuildJobZipFile();
        }
        // added by xie to fix bug 20084
        setDesValueForJob();
        processForEachJob();

        // retrieve user, password, host, port from selected server
        MDMServerDef server = null;
        if (mdmServer == null) {
            String selectedSpagoBiEngineName = serverSpagoBi.getItem(serverSpagoBi.getSelectionIndex());

            List<MDMServerDef> listServerSapgo = com.amalto.workbench.utils.MDMServerHelper.getServers();
            for (MDMServerDef serv : listServerSapgo) {
                if (selectedSpagoBiEngineName.equals(serv.getName())) {
                    server = serv;
                    break;
                }
            }
        } else {
            server = new MDMServerDef(mdmServer.getShortDescription(), mdmServer.getHost(), mdmServer.getPort(),
                    MDMServerDef.DEFAULT_PATH, mdmServer.getLogin(), mdmServer.getPassword(), ""); //$NON-NLS-1$
        }

        String user = server.getUser();
        String password = server.getPasswd();
        String host = server.getHost();
        String port = server.getPort();

        // modified by xie to fix bug 20084 ,do the multi jobs deployment in one time.
        for (JobDeploymentInfo jobInfo : jobInfoList) {

            String filename = jobInfo.getDescValue();
            String mdmServerUploadURL = "http://" + host + ":" + port + "/datamanager/uploadFile?deployjob="//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    + new File(filename).getName() + "&jobpath=" + jobInfo.getJobPath() + "&contextStr=" + contextCombo.getText();; //$NON-NLS-1$//$NON-NLS-2$
            try {
                ProxyUtil.uploadFileToAppServer(mdmServerUploadURL, filename, user, password);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                MessageDialog.openError(getContainer().getShell(),
                        Messages.getString("DeployOnMDMExportWizardPage.publishResourceError"), //$NON-NLS-1$
                        e.getLocalizedMessage());
                return false;
            }

        }
        
        mdmServer = toSpagoBiServer(server);

        MessageDialog.openInformation(getContainer().getShell(), Messages.getString("DeployOnMDMExportWizardPage.publishJob"), //$NON-NLS-1$
                Messages.getString("DeployOnMDMExportWizardPage.publishJobSuccess")); //$NON-NLS-1$
        return ok;
    }
    

    /**
     * 
     * DOC aiming Comment method "reBuildJobZipFile".
     */
    private void reBuildJobZipFile() {
        JavaJobExportReArchieveCreator creator = null;
        String zipFile = getDestinationValue();

        String tmpFolder = JavaJobExportReArchieveCreator.getTmpFolder();
        try {
            // unzip to tmpFolder
            ZipToFile.unZipFile(zipFile, tmpFolder);
            // remove jaxrpc.jar from lib , see 0021706
            String javxRpc = tmpFolder + File.separator + "WEB-INF" + File.separator + "lib" + File.separator + "jaxrpc.jar";//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
            File rpcfile = new File(javxRpc);
            if (rpcfile.exists()) {
                rpcfile.delete();
            }
            // build new jar
            for (int i = 0; i < process.length; i++) {
                if (process[i] != null) {
                    String jobFolderName = process[i].getDirectoryName();
                    int pos = jobFolderName.indexOf("/"); //$NON-NLS-1$
                    if (pos != -1) {
                        jobFolderName = jobFolderName.substring(pos + 1);
                    }
                    if (creator == null) {
                        creator = new JavaJobExportReArchieveCreator(zipFile, jobFolderName);
                    } else {
                        creator.setJobFolerName(jobFolderName);
                    }
                    creator.buildNewJar();
                }
            }
            // rezip the tmpFolder to zipFile
            ZipToFile.zipFile(tmpFolder, zipFile);
        } catch (Exception e) {
            ExceptionHandler.process(e);
        } finally {
            JavaJobExportReArchieveCreator.deleteTempFiles();
        }
    }

    /**
     * process each job,unzip to a temp folder , copy the necessary folder for each job , and zip to the MDM temp folder
     * for uploading.
     */
    protected void processForEachJob() {

        String zipFile = getDestinationValue();

        String tmpFolder = JavaJobExportReArchieveCreator.getTmpFolder() + File.separator + "forJob"; //$NON-NLS-1$

        try {
            // unzip to tmpFolder
            ZipToFile.unZipFile(zipFile, tmpFolder);

            File desFile = new File(tmpFolder + File.separator + jobLabelName + "_" + jobVersion);//$NON-NLS-1$

            if (desFile.isDirectory()) {

                for (JobDeploymentInfo jobInfo : jobInfoList) {
                    File sourFile = new File(tmpFolder + File.separator + jobLabelName
                            + "_" + jobVersion + File.separator + jobInfo.getJobLabelName()); //$NON-NLS-1$ 
                    File sourLibFile = new File(tmpFolder + File.separator + jobLabelName
                            + "_" + jobVersion + File.separator + "lib"); //$NON-NLS-1$ //$NON-NLS-2$

                    String jobDescPath = tmpFolder + File.separator + jobInfo.getJobLabelName()
                            + "_" + jobInfo.getJobVersion() + "job"; //$NON-NLS-1$ //$NON-NLS-2$

                    File jobDescDir = new File(jobDescPath);
                    if (!jobDescDir.exists())
                        jobDescDir.mkdir();
                    File jobDescDir_in = new File(jobDescPath + File.separator + jobInfo.getJobLabelName()
                            + "_" + jobInfo.getJobVersion()); //$NON-NLS-1$
                    if (!jobDescDir_in.exists())
                        jobDescDir_in.mkdir();
                    File jobDescDir_main = new File(jobDescPath + File.separator + jobInfo.getJobLabelName()
                            + "_" + jobInfo.getJobVersion() + File.separator + jobInfo.getJobLabelName()); //$NON-NLS-1$
                    if (!jobDescDir_main.exists())
                        jobDescDir_main.mkdir();

                    File jobDescDirLib = new File(jobDescPath + File.separator + jobInfo.getJobLabelName()
                            + "_" + jobInfo.getJobVersion() + File.separator + "lib"); //$NON-NLS-1$ //$NON-NLS-2$
                    if (!jobDescDirLib.exists())
                        jobDescDirLib.mkdir();

                    copy(sourFile.listFiles(), jobDescDir_main);
                    copy(sourLibFile.listFiles(), jobDescDirLib);

                    ZipToFile.zipFile(jobDescPath, jobInfo.getDescValue());
                }
            }
        } catch (Exception e) {
            ExceptionHandler.process(e);
        } finally {
            JavaJobExportReArchieveCreator.deleteTempFiles();
        }

    }

    /**
     * copy all the files of this folder to another
     */

    private void copy(File[] s, File d) {
        if (!d.exists())
            d.mkdir();
        for (int i = 0; i < s.length; i++) {
            if (s[i].isFile()) {
                try {
                    FileInputStream fis = new FileInputStream(s[i]);
                    FileOutputStream out = new FileOutputStream(new File(d.getPath() + File.separator + s[i].getName()));
                    int count = fis.available();
                    byte[] data = new byte[count];
                    if ((fis.read(data)) != -1) {
                        out.write(data);
                    }
                    out.close();
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (s[i].isDirectory()) {
                File des = new File(d.getPath() + File.separator + s[i].getName());
                des.mkdir();
                copy(s[i].listFiles(), des);
            }
        }
    }

    /**
     * Get the export operation.
     * 
     * @param resourcesToExport
     * @return
     */
    protected ArchiveFileExportOperationFullPath getExporterOperation(List<ExportFileResource> resourcesToExport) {
        ArchiveFileExportOperationFullPath exporterOperation = new ArchiveFileExportOperationFullPath(resourcesToExport,
                getDestinationValue());
        return exporterOperation;
    }

    protected ArchiveFileExportOperationFullPath getExporterOperationForOneJob(List<ExportFileResource> resourcesToExport,
            String descValue) {
        ArchiveFileExportOperationFullPath exporterOperation = new ArchiveFileExportOperationFullPath(resourcesToExport,
                descValue);
        return exporterOperation;
    }

    /**
     * Returns the root folder name.
     * 
     * @return
     */
    private String getRootFolderName() {
        IPath path = new Path(this.getDestinationValue());
        String subjectString = path.lastSegment();
        Pattern regex = Pattern.compile("(.*)(?=(\\.(tar|zip))\\b)", Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE //$NON-NLS-1$
                | Pattern.UNICODE_CASE);
        Matcher regexMatcher = regex.matcher(subjectString);
        if (regexMatcher.find()) {
            subjectString = regexMatcher.group(0);
        }

        return subjectString.trim();
    }

    private void setTopFolder(List<ExportFileResource> resourcesToExport, String topFolder) {
        // is war do nothing
        if (exportTypeCombo.getSelectionIndex() == 0)
            return;
        else if (resourcesToExport != null) {
            for (ExportFileResource fileResource : resourcesToExport) {
                String directory = fileResource.getDirectoryName();
                fileResource.setDirectoryName(topFolder + "/" + directory); //$NON-NLS-1$
            }
        }
    }

    /**
     * Answer the string to display in self as the destination type.
     * 
     * @return java.lang.String
     */
    @Override
    protected String getDestinationLabel() {
        return DataTransferMessages.ArchiveExport_destinationLabel;
    }

    /**
     * Returns resources to be exported. This returns file - for just the files use getSelectedResources.
     * 
     * @return a collection of resources currently selected for export (element type: <code>IResource</code>)
     * @throws ProcessorException
     */
    protected List<ExportFileResource> getExportResources() throws ProcessorException {
        Map<ExportChoice, Object> exportChoiceMap = getExportChoiceMap();
        return manager.getExportResources(process);
    }

    /**
     * set the destinationValue for each job
     */

    protected void setDesValueForJob() {

        for (ExportFileResource each : process) {

            for (JobDeploymentInfo jobInfo : jobInfoList) {
                Item item = each.getItem();
                if (item instanceof ProcessItem) {
                    String name = ((ProcessItem) each.getItem()).getProperty().getLabel();
                    if (jobInfo.getJobLabelName().equals(name)) {
                        setDestinationValueForJob(jobInfo);
                    }

                }

            }

        }
    }
    private Map<ExportChoice, Object> getExportChoiceMap() {
        return getExportChoiceMap(exportTypeCombo.getSelectionIndex());
    }

    private Map<ExportChoice, Object> getExportChoiceMap(int index) {
        Map<ExportChoice, Object> exportChoiceMap = new EnumMap<ExportChoice, Object>(ExportChoice.class);
        if (index == 0) {// war
            exportChoiceMap.put(ExportChoice.needMetaInfo, true);
            exportChoiceMap.put(ExportChoice.needWEBXML, true);
            exportChoiceMap.put(ExportChoice.needCONFIGFILE, true);
            exportChoiceMap.put(ExportChoice.needAXISLIB, true);
            exportChoiceMap.put(ExportChoice.needWSDD, true);
            exportChoiceMap.put(ExportChoice.needWSDL, true);

            exportChoiceMap.put(ExportChoice.needLauncher, true);
            exportChoiceMap.put(ExportChoice.needSystemRoutine, true);
            exportChoiceMap.put(ExportChoice.needUserRoutine, true);
            exportChoiceMap.put(ExportChoice.needTalendLibraries, true);
            exportChoiceMap.put(ExportChoice.needJobItem, true);
            exportChoiceMap.put(ExportChoice.needJobScript, true);
            exportChoiceMap.put(ExportChoice.needSourceCode, true);
            exportChoiceMap.put(ExportChoice.needContext, true);
        } else {// zip
            exportChoiceMap.put(ExportChoice.needLauncher, true);
            exportChoiceMap.put(ExportChoice.needSystemRoutine, true);
            exportChoiceMap.put(ExportChoice.needUserRoutine, true);
            exportChoiceMap.put(ExportChoice.needTalendLibraries, true);
            exportChoiceMap.put(ExportChoice.needJobItem, true);
            // exportChoiceMap.put(ExportChoice.needSourceCode, true);
            exportChoiceMap.put(ExportChoice.needDependencies, true);
            exportChoiceMap.put(ExportChoice.needJobScript, true);
            exportChoiceMap.put(ExportChoice.needContext, true);
            exportChoiceMap.put(ExportChoice.applyToChildren, true);
            exportChoiceMap.put(ExportChoice.needDependencies, true);
        }
        exportChoiceMap.put(ExportChoice.needContext, (contextButton != null) ? contextButton.getSelection() : true);

        return exportChoiceMap;
    }

    /**
     * Answer the contents of self's destination specification widget. If this value does not have a suffix then add it
     * first.
     */
    @Override
    protected String getDestinationValue() {
        String idealSuffix = getOutputSuffix();

        String filename = jobLabelName + "_" + jobVersion + idealSuffix; //$NON-NLS-1$
        IPath tempPath;
        tempPath = Path.fromOSString(CorePlugin.getDefault().getPreferenceStore()
                .getString(ITalendCorePrefConstants.FILE_PATH_TEMP));
        tempPath = tempPath.append(filename);
        return tempPath.toOSString();
    }

    /**
     * set the destinationValue for each job
     */
    protected void setDestinationValueForJob(JobDeploymentInfo jobInfo) {
        String idealSuffix = getOutputSuffix();
        String filename = jobInfo.getJobLabelName() + "_" + jobInfo.getJobVersion() + idealSuffix; //$NON-NLS-1$
        IPath tempPath;
        tempPath = Path.fromOSString(CorePlugin.getDefault().getPreferenceStore()
                .getString(ITalendCorePrefConstants.FILE_PATH_TEMP));
        tempPath = tempPath.append(filename);
        jobInfo.setDescValue(tempPath.toOSString());
    }

    /**
     * Answer the suffix that files exported from this wizard should have. If this suffix is a file extension (which is
     * typically the case) then it must include the leading period character.
     * 
     */
    protected String getOutputSuffix() {
        if (exportTypeCombo.getSelectionIndex() == 0)
            return ".war"; //$NON-NLS-1$
        else
            return ".zip"; //$NON-NLS-1$
    }

    /**
     * Open an appropriate destination browser so that the user can specify a source to import from.
     */
    @Override
    protected void handleDestinationBrowseButtonPressed() {
        FileDialog dialog = new FileDialog(getContainer().getShell(), SWT.SAVE);
        dialog.setFilterExtensions(new String[] { "*.zip", "*.*" }); //$NON-NLS-1$ //$NON-NLS-2$
        dialog.setText(""); //$NON-NLS-1$
        String currentSourceString = getDestinationValue();
        int lastSeparatorIndex = currentSourceString.lastIndexOf(File.separator);
        if (lastSeparatorIndex != -1) {
            dialog.setFilterPath(currentSourceString.substring(0, lastSeparatorIndex));
        }
        String selectedFileName = dialog.open();

        if (selectedFileName != null) {
            setErrorMessage(null);
            setDestinationValue(selectedFileName);
        }
    }

    /**
     * Hook method for saving widget values for restoration by the next instance of this class.
     */
    @Override
    protected void internalSaveWidgetValues() {
    }

    /**
     * Hook method for restoring widget values to the values that they held last time this wizard was used to
     * completion.
     */
    @Override
    protected void restoreWidgetValues() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.wizards.datatransfer.WizardFileSystemResourceExportPage1#destinationEmptyMessage()
     */
    @Override
    protected String destinationEmptyMessage() {
        return ""; //$NON-NLS-1$
    }

    @Override
    protected void createOptionsGroup(Composite parent) {
        // options group
        Group optionsGroup = new Group(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        optionsGroup.setLayout(layout);
        optionsGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
        optionsGroup.setText(Messages.getString("DeployOnMDMExportWizardPage.Settings")); //$NON-NLS-1$
        optionsGroup.setFont(parent.getFont());
        createOptionsGroupButtons(optionsGroup);

    }

    private SpagoBiServer toSpagoBiServer(MDMServerDef serverDef) {
        SpagoBiServer spagoBiServer = PropertiesFactory.eINSTANCE.createSpagoBiServer();
        spagoBiServer.setShortDescription(serverDef.getName());
        spagoBiServer.setHost(serverDef.getHost());
        spagoBiServer.setPort(serverDef.getPort());
        spagoBiServer.setLogin(serverDef.getUser());
        spagoBiServer.setPassword(serverDef.getPasswd());
        
        return spagoBiServer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.internal.wizards.datatransfer.WizardFileSystemResourceExportPage1#validateDestinationGroup()
     */
    @Override
    protected boolean validateDestinationGroup() {
        return true;
    }

    public SpagoBiServer getMdmServer() {
        return this.mdmServer;
    }

    public void setMdmServer(SpagoBiServer mdmServer) {
        this.mdmServer = mdmServer;
    }

}
