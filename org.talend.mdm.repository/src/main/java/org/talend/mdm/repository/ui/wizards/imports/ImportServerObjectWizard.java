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
package org.talend.mdm.repository.ui.wizards.imports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.progress.UIJob;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.impl.transformerV2.ITransformerV2NodeConsDef;
import org.talend.mdm.repository.core.impl.view.IViewNodeConstDef;
import org.talend.mdm.repository.core.service.ISyncWorkflowService;
import org.talend.mdm.repository.core.service.ImportService;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSResourceE;
import org.talend.mdm.repository.model.mdmserverobject.WSWorkflowE;
import org.talend.mdm.repository.ui.dialogs.lock.LockedObjectDialog;
import org.talend.mdm.repository.ui.wizards.imports.viewer.TreeObjectCheckTreeViewer;
import org.talend.mdm.repository.utils.Bean2EObjUtil;
import org.talend.mdm.repository.utils.IOUtil;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.repository.utils.RepositoryTransformUtil;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XtentisServerObjectsRetriever;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSCustomForm;
import com.amalto.workbench.webservices.WSCustomFormPK;
import com.amalto.workbench.webservices.WSGetCustomForm;
import com.amalto.workbench.webservices.WSGetCustomFormPKs;
import com.amalto.workbench.webservices.WSGetUniversePKs;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.WSWorkflowProcessDefinitionUUID;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.LabelCombo;
import com.amalto.workbench.widgets.WidgetFactory;

/**
 * DOC achen class global comment. Detailled comment
 */
public class ImportServerObjectWizard extends Wizard {

    static Logger log = Logger.getLogger(ImportServerObjectWizard.class);

    private TreeObjectCheckTreeViewer treeViewer;

    private TreeObject serverRoot;

    private MDMServerDef serverDef;

    private LabelCombo comboVersion;

    private Text txtServer;

    WidgetFactory toolkit = WidgetFactory.getWidgetFactory();

    CommonViewer commonViewer;

    boolean isOverrideAll = true;

    private Button btnOverwrite;

    private Object[] selectedObjects;

    public ImportServerObjectWizard(CommonViewer commonViewer) {

        setNeedsProgressMonitor(true);
        this.commonViewer = commonViewer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    @Override
    public boolean performFinish() {
        if (!showLockedObjDialog(selectedObjects)) {
            return false;
        }
        try {
            if (selectedObjects != null) {
                doImport();
            }
        } catch (InvocationTargetException e) {
            log.error(e);
            return false;
        } catch (InterruptedException e) {
            log.error(e);
            return false;
        }

        return true;
    }

    private void updateSelectedObjects() {
        selectedObjects = treeViewer.getCheckNodes();
    }

    private int isOveride(String name, String obTypeName) {

        final MessageDialog dialog = new MessageDialog(getShell(), Messages.Confirm_Overwrite, null, Messages.bind(
                Messages.Confirm_Overwrite_Info, obTypeName, name), MessageDialog.QUESTION, new String[] {
                IDialogConstants.YES_LABEL, IDialogConstants.YES_TO_ALL_LABEL, IDialogConstants.NO_LABEL,
                IDialogConstants.CANCEL_LABEL }, 0);
        dialog.open();
        int result = dialog.getReturnCode();
        if (result == 0) {
            return IDialogConstants.YES_ID;
        }
        if (result == 1) {
            return IDialogConstants.YES_TO_ALL_ID;
        }
        if (result == 2) {
            return IDialogConstants.NO_ID;
        }
        return IDialogConstants.CANCEL_ID;

    }

    Pattern picFileNamePattern = Pattern.compile("(.*?)-(.*)\\.(.*?)"); //$NON-NLS-1$

    Pattern picFileVersionPattern = Pattern.compile("(.*)_(\\d+\\.\\d+)"); //$NON-NLS-1$

    /**
     * DOC hbhong Comment method "getFileInfo".
     * 
     * @param input
     * @return // dirName result[0] // fileQName result[1] // fileExtension result[2] // fileName result[3] // version
     * result[4]
     */
    private String[] getPicResourceFileInfo(String input) {
        Matcher m = picFileNamePattern.matcher(input);
        if (m.matches()) {
            String[] result = new String[5];
            // dirName
            result[0] = m.group(1);
            // fileQName
            result[1] = m.group(2);
            // fileExtension
            result[2] = m.group(3);
            // fileName
            result[3] = result[1];
            // version
            result[4] = VersionUtils.DEFAULT_VERSION;
            Matcher versionM = picFileVersionPattern.matcher(result[1]);
            if (versionM.matches()) {
                // fileName
                result[3] = versionM.group(1);
                // version
                result[4] = versionM.group(2);
            }
            return result;
        }
        return null;

    }

    private MDMServerObject handleSpecialTreeObject(TreeObject treeObj) throws IOException {
        int type = treeObj.getType();
        if (type == TreeObject.PICTURES_RESOURCE) {
            return handlePictureResourceObject(treeObj);
        }
        if (type == TreeObject.WORKFLOW_PROCESS) {
            return handleWorkflowObject(treeObj);

        }
        return null;
    }

    private WSWorkflowE handleWorkflowObject(TreeObject treeObj) throws IOException, ClientProtocolException,
            UnsupportedEncodingException {
        WSWorkflowProcessDefinitionUUID wsKey = (WSWorkflowProcessDefinitionUUID) treeObj.getWsKey();
        String workflowURL = treeObj.getEndpointIpAddress() + TreeObject.BARFILE_URI + treeObj.getDisplayName();
        // correct the URL to Bonita 5.8 version
        Pattern PATTERN_53 = Pattern.compile("(.+?)_(\\d+\\.\\d+)");
        Matcher matcher = PATTERN_53.matcher(workflowURL);
        if (matcher.matches()) {
            workflowURL = matcher.group(1) + "--" + matcher.group(2);
        }
        DefaultHttpClient httpclient = new DefaultHttpClient();
        httpclient.getCredentialsProvider().setCredentials(
                new AuthScope(treeObj.getEndpointHost(), Integer.valueOf(treeObj.getEndpointPort())),
                new UsernamePasswordCredentials(treeObj.getUsername(), treeObj.getPassword()));
        HttpGet httpget = new HttpGet(workflowURL);
        // System.out.println("executing request" + httpget.getRequestLine());
        HttpResponse response = httpclient.execute(httpget);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();

            String encodedID = URLEncoder.encode(treeObj.getDisplayName(), "UTF-8");//$NON-NLS-1$
            File tempFolder = IOUtil.getWorkspaceTempFolder();
            String filename = tempFolder.getAbsolutePath() + File.separator + encodedID + ".bar";//$NON-NLS-1$
            InputStream is = entity.getContent();
            OutputStream os = null;
            File barFile = new File(filename);
            try {

                os = new FileOutputStream(barFile);
                int copy = IOUtils.copy(is, os);

            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return null;
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (Exception e) {
                    }
                }
                if (os != null) {
                    try {
                        os.close();
                    } catch (Exception e) {
                    }
                }

            }
            if (barFile.exists()) {
                try {
                    byte[] procBytes = extractBar(barFile);
                    if (procBytes != null) {
                        WSWorkflowE workflow = MdmserverobjectFactory.eINSTANCE.createWSWorkflowE();
                        workflow.setName(wsKey.getProcessName());
                        workflow.setFileContent(procBytes);
                        return workflow;
                    }
                } finally {
                    IOUtil.cleanFolder(tempFolder);
                }
            }

        }
        return null;
    }

    private byte[] extractBar(File barFile) {
        ZipFile zipFile = null;
        InputStream entryInputStream = null;
        byte[] processBytes = null;
        try {
            zipFile = new ZipFile(barFile);

            for (Enumeration entries = zipFile.entries(); entries.hasMoreElements();) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                if (!entry.isDirectory()) {
                    if (entry.getName().endsWith(".proc")) { //$NON-NLS-1$
                        entryInputStream = zipFile.getInputStream(entry);
                        processBytes = IOUtils.toByteArray(entryInputStream);
                    }
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (entryInputStream != null) {
                try {
                    entryInputStream.close();
                } catch (IOException e) {
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                }
            }

        }
        return processBytes;
    }

    /**
     * DOC hbhong Comment method "handlePictureResourceObject".
     * 
     * @param treeObj
     * @throws IOException
     */
    private WSResourceE handlePictureResourceObject(TreeObject treeObj) throws IOException {
        String[] fileInfo = getPicResourceFileInfo(treeObj.getName());

        if (fileInfo != null) {
            String dirName = fileInfo[0];
            String fileQName = fileInfo[1];
            String fileExtension = fileInfo[2];

            String fileName = fileInfo[3];

            WSResourceE resource = MdmserverobjectFactory.eINSTANCE.createWSResourceE();
            resource.setName(fileName);
            resource.setFileExtension(fileExtension);
            StringBuffer strBuf = new StringBuffer();
            strBuf.append("http://").append(serverDef.getHost()).append(":").append(serverDef.getPort()) //$NON-NLS-1$ //$NON-NLS-2$
                    .append("/imageserver/upload/").append(dirName).append("/").append(fileQName).append(".").append(fileExtension); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            String url = strBuf.toString();
            byte[] bytes = Util.downloadFile(url, serverDef.getUser(), serverDef.getPasswd());
            resource.setFileContent(bytes);
            // add imageCatalog
            resource.setImageCatalog(dirName);

            treeObj.setName(fileName);
            return resource;
        }
        return null;
    }

    private boolean showLockedObjDialog(Object[] objs) {
        if (objs == null) {
            return true;
        }
        List<IRepositoryViewObject> viewObjs = new LinkedList<IRepositoryViewObject>();
        for (Object obj : objs) {
            TreeObject treeObj = (TreeObject) obj;
            String treeObjName = treeObj.getName();
            ERepositoryObjectType type = RepositoryQueryService.getRepositoryObjectType(treeObj.getType());
            if (type != null && treeObjName != null) {
                String uniqueName = getUniqueName(treeObj, treeObjName);
                IRepositoryViewObject viewObject = RepositoryResourceUtil.findViewObjectByName(type, uniqueName);
                if (viewObject != null) {
                    viewObjs.add(viewObject);
                }
            }
        }
        LockedObjectDialog lockDialog = new LockedObjectDialog(getShell(), Messages.ImportServerObjectWizard_lockedObjectMessage,
                viewObjs);
        if (lockDialog.needShowDialog() && lockDialog.open() == IDialogConstants.CANCEL_ID) {
            return false;
        }
        return true;
    }

    public void doImport(Object[] objs, IProgressMonitor monitor) {
        monitor.beginTask(Messages.Import_Objects, IProgressMonitor.UNKNOWN);
        ImportService.setImporting(true);
        // if (!showLockedObjDialog(objs)) {
        // ImportService.setImporting(false);
        // return;
        // }
        List<Integer> types = new ArrayList<Integer>();
        types.add(TreeObject.CUSTOM_FORM);
        types.add(TreeObject.DATA_CLUSTER);
        types.add(TreeObject.DATA_MODEL);
        types.add(TreeObject.TRANSFORMER);
        types.add(TreeObject.ROUTING_RULE);
        types.add(TreeObject.MENU);
        types.add(TreeObject.ROLE);
        types.add(TreeObject.SYNCHRONIZATIONPLAN);
        types.add(TreeObject.STORED_PROCEDURE);
        types.add(TreeObject.UNIVERSE);
        types.add(TreeObject.VIEW);
        types.add(TreeObject.WORKFLOW_PROCESS);
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        for (Object obj : objs) {
            try {
                TreeObject treeObj = (TreeObject) obj;
                monitor.subTask(treeObj.getDisplayName());
                String treeObjName = treeObj.getName();
                MDMServerObject eobj = handleSpecialTreeObject(treeObj);

                if (eobj == null) {
                    if (!types.contains(treeObj.getType()) || treeObj.getWsObject() == null
                            || ("JCAAdapers".equals(treeObj.getName()) && treeObj.getType() == TreeObject.DATA_CLUSTER)) {
                        continue;
                    }
                    eobj = (MDMServerObject) Bean2EObjUtil.getInstance().convertFromBean2EObj(treeObj.getWsObject(), null);
                }
                eobj.setLastServerDef(serverDef.getEncryptedServerDef());

                ERepositoryObjectType type = RepositoryQueryService.getRepositoryObjectType(treeObj.getType());
                String uniqueName = getUniqueName(treeObj, treeObjName);
                MDMServerObjectItem item = RepositoryQueryService.findServerObjectItemByNameWithDeleted(type, uniqueName, true);

                if (item != null) {
                    if (!RepositoryResourceUtil.isLockedItem(item)) {
                        if (!isOverrideAll) {
                            int result = isOveride(treeObj.getName(), TreeObject.getTypeName(treeObj.getType()));
                            if (result == IDialogConstants.CANCEL_ID) {
                                ImportService.setImporting(false);
                                return;
                            }
                            if (result == IDialogConstants.YES_TO_ALL_ID) {
                                isOverrideAll = true;
                            }
                            if (result == IDialogConstants.NO_ID) {
                                break;
                            }
                        }
                        if (factory.isEditableAndLockIfPossible(item)) {
                            item.setMDMServerObject(eobj);
                            item.getState().setDeleted(false);
                            // save
                            RepositoryResourceUtil.saveItem(item);
                            try {
                                factory.unlock(item);
                            } catch (PersistenceException e) {
                                log.error(e.getMessage(), e);
                            } catch (LoginException e) {
                                log.error(e.getMessage(), e);
                            }
                        }

                        CommandManager.getInstance().removeCommandStack(item.getProperty().getId());
                    }
                } else {
                    IRepositoryNodeConfiguration config = RepositoryNodeConfigurationManager.getConfiguration(type);
                    item = (MDMServerObjectItem) config.getResourceProvider().createNewItem(type);
                    item.setMDMServerObject(eobj);
                    ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();

                    itemState.setPath(caculatePath(treeObj));
                    handlePath(itemState, type);
                    item.setState(itemState);
                    String version = getVersion(treeObj);

                    RepositoryResourceUtil.createItem(item, uniqueName, version, false);

                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        ImportService.setImporting(false);
        monitor.done();
    }

    /**
     * DOC jsxie Comment method "caculatePath". if it is process or trigger ,cut the path prefix.
     * 
     * @param treeObj
     * @return the tree object path.
     */
    private String caculatePath(TreeObject treeObj) {
        if (treeObj.getType() == TreeObject.TRANSFORMER) {
            return getProcessTypeObjectPath(treeObj);

        }

        if (treeObj.getType() == TreeObject.ROUTING_RULE) {
            if (treeObj.getPath().equals("Trigger")) {
                return "";//$NON-NLS-1$
            } else {
                return treeObj.getPath().substring(8);
            }

        }

        if (treeObj.getType() == TreeObject.VIEW) {
            return getViewTypeObjectPath(treeObj);
        }

        return treeObj.getPath();

    }

    private String getProcessTypeObjectPath(TreeObject treeObj) {

        String path = treeObj.getPath();
        String processName = treeObj.getName();
        int processType = RepositoryTransformUtil.getInstance().getProcessType(processName);
        switch (processType) {
        case ITransformerV2NodeConsDef.TYPE_BEFORESAVE:
            if (path.equals(ITransformerV2NodeConsDef.PATH_PROCESS)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_BEFORESAVE;
            } else if (!path.equals(ITransformerV2NodeConsDef.PATH_PROCESS)
                    && !path.startsWith(IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_SMARTVIEW)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_BEFORESAVE + path.substring(8);
            }
            break;
        case ITransformerV2NodeConsDef.TYPE_BEFOREDEL:
            if (path.equals(ITransformerV2NodeConsDef.PATH_PROCESS)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_BEFOREDEL;
            } else if (!path.equals(ITransformerV2NodeConsDef.PATH_PROCESS)
                    && !path.startsWith(IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_BEFOREDEL)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_BEFOREDEL + path.substring(8);
            }
            break;
        case ITransformerV2NodeConsDef.TYPE_ENTITYACTION:
            if (path.equals(ITransformerV2NodeConsDef.PATH_PROCESS)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_ENTITYACTION;
            } else if (!path.startsWith(IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_ENTITYACTION)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_ENTITYACTION + path.substring(8);
            }
            break;
        case ITransformerV2NodeConsDef.TYPE_WELCOMEACTION:
            if (path.equals(ITransformerV2NodeConsDef.PATH_PROCESS)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_WELCOMEACTION;
            } else if (!path.startsWith(IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_WELCOMEACTION)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_WELCOMEACTION + path.substring(8);
            }
            break;
        case ITransformerV2NodeConsDef.TYPE_SMARTVIEW:
            if (path.equals(ITransformerV2NodeConsDef.PATH_PROCESS)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_SMARTVIEW;
            } else if (!path.startsWith(IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_SMARTVIEW)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_SMARTVIEW + path.substring(8);
            }
            break;
        case ITransformerV2NodeConsDef.TYPE_OTHER:

        default:
            if (path.equals(ITransformerV2NodeConsDef.PATH_PROCESS)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_OTHER;
            } else if (!path.startsWith(IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_OTHER)) {
                return IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_OTHER + path.substring(8);
            }
            break;
        }

        return path.substring(8);
    }

    private String getViewTypeObjectPath(TreeObject treeObj) {
        if (RepositoryTransformUtil.getInstance().getViewType(treeObj.getName()) == IViewNodeConstDef.TYPE_WEBFILTER) {
            if (!treeObj.getPath().startsWith(IPath.SEPARATOR + IViewNodeConstDef.PATH_WEBFILTER)) {
                String path = treeObj.getPath();
                if (path.length() > 8) {
                    path = IPath.SEPARATOR + path.substring(8);
                } else if (!path.isEmpty()) {
                    path = IPath.SEPARATOR + path;
                }
                return IPath.SEPARATOR + IViewNodeConstDef.PATH_WEBFILTER + path;
            }
        } else {
            if (!treeObj.getPath().startsWith(IPath.SEPARATOR + IViewNodeConstDef.PATH_SEARCHFILTER)) {
                String path = treeObj.getPath();
                if (path.length() > 8) {
                    path = path.substring(8);
                } else if (!path.isEmpty()) {
                    path = IPath.SEPARATOR + path;
                }
                return IPath.SEPARATOR + IViewNodeConstDef.PATH_SEARCHFILTER + path;
            }
        }

        return treeObj.getPath();
    }

    /**
     * DOC hbhong Comment method "getVersion".
     * 
     * @param treeObj
     * @return
     */
    private String getVersion(TreeObject treeObj) {
        int type = treeObj.getType();
        if (type == TreeObject.PICTURES_RESOURCE) {
            String[] fileInfo = getPicResourceFileInfo(treeObj.getName());
            if (fileInfo != null) {
                return fileInfo[4];
            }
        }
        if (type == TreeObject.WORKFLOW_PROCESS) {
            WSWorkflowProcessDefinitionUUID wsKey = (WSWorkflowProcessDefinitionUUID) treeObj.getWsKey();
            return wsKey.getProcessVersion();
        }
        return VersionUtils.DEFAULT_VERSION;
    }

    /**
     * DOC hbhong Comment method "getUniqueName".
     * 
     * @param treeObj
     * @return
     */
    private String getUniqueName(TreeObject treeObj, String name) {
        int type = treeObj.getType();
        if (type == TreeObject.PICTURES_RESOURCE) {
            if (name == null) {
                name = treeObj.getName();
            }
            String[] fileInfo = getPicResourceFileInfo(name);
            if (fileInfo != null) {
                //return fileInfo[3] + "." + fileInfo[2]; //$NON-NLS-1$
                return fileInfo[3];
            }
        }
        if (type == TreeObject.WORKFLOW_PROCESS) {
            WSWorkflowProcessDefinitionUUID wsKey = (WSWorkflowProcessDefinitionUUID) treeObj.getWsKey();
            return wsKey.getProcessName();
        }
        return treeObj.getName();
    }

    /**
     * DOC hbhong Comment method "handlePath".
     * 
     * @param itemState
     * @param type
     */
    private void handlePath(ItemState itemState, ERepositoryObjectType type) {
        if (type == IServerObjectRepositoryType.TYPE_RESOURCE) {
            itemState.setPath(""); //$NON-NLS-1$
        }

    }

    class ImportProcess implements IRunnableWithProgress {

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
         */
        public void run(IProgressMonitor arg0) throws InvocationTargetException, InterruptedException {
            UIJob job = new UIJob(Messages.Import_Objects) {

                @Override
                public IStatus runInUIThread(IProgressMonitor monitor) {
                    // isOverrideAll = btnOverwrite.getSelection();
                    doImport(selectedObjects, monitor);
                    commonViewer.refresh();
                    if (Util.IsEnterPrise()) {
                        // sync workflow object to bonita
                        ISyncWorkflowService syncService = (ISyncWorkflowService) GlobalServiceRegister.getDefault().getService(
                                ISyncWorkflowService.class);
                        if (syncService != null) {
                            syncService.startSyncWorkflowTask();
                        }
                    }
                    return Status.OK_STATUS;
                }
            };
            job.schedule();
        }
    }

    class RetriveProcess implements IRunnableWithProgress {

        private void retrieverCustomForms(TreeParent parent, IProgressMonitor monitor) {
            try {
                XtentisPort port = Util.getPort(new URL(serverDef.getUrl()), serverDef.getUniverse(), serverDef.getUser(),
                        serverDef.getPasswd());
                // Data Models
                TreeParent models = new TreeParent(Messages.ImportServerObjectWizard_customForm, parent, TreeObject.CUSTOM_FORM,
                        null, null);
                WSCustomFormPK[] xdmPKs = null;

                xdmPKs = port.getCustomFormPKs(new WSGetCustomFormPKs("")).getWsCustomFormPK(); //$NON-NLS-1$

                if (xdmPKs != null) {
                    monitor.subTask(Messages.ImportServerObjectWizard_loadCustomForm);
                    for (WSCustomFormPK xdmPK : xdmPKs) {

                        try {
                            WSCustomForm wsobj = null;
                            wsobj = port.getCustomForm(new WSGetCustomForm(xdmPK));
                            TreeObject obj = new TreeObject(wsobj.getName(), parent, TreeObject.CUSTOM_FORM, xdmPK, wsobj);
                            models.addChild(obj);
                        } catch (RemoteException e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                }
                parent.addChild(models);

            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
         */
        public void run(IProgressMonitor m) throws InvocationTargetException, InterruptedException {

            final XtentisServerObjectsRetriever retriever = new XtentisServerObjectsRetriever(serverDef.getName(),
                    serverDef.getUrl(), serverDef.getUser(), serverDef.getPasswd(), serverDef.getUniverse(), null);

            retriever.setRetriveWSObject(true);
            retriever.run(m);
            serverRoot = retriever.getServerRoot();
            //
            if (Util.IsEnterPrise()) {
                retrieverCustomForms((TreeParent) serverRoot, m);
            }
            //
            Display.getDefault().syncExec(new Runnable() {

                public void run() {
                    try {

                        treeViewer.setRoot((TreeParent) serverRoot);
                        treeViewer.getViewer().setInput(serverRoot);
                        treeViewer.setServerRoot((TreeParent) serverRoot);
                        treeViewer.getViewer().refresh();

                    } catch (Exception e) {
                        log.error(e);
                    }
                }
            });
        }
    }

    @Override
    public void addPages() {
        addPage(new SelectItemsPage());
    }

    private void doImport() throws InvocationTargetException, InterruptedException {
        getContainer().run(true, false, new ImportProcess());
    }

    private void retriveServerRoot() {
        if (serverDef != null) {
            try {
                getContainer().run(true, false, new RetriveProcess());
            } catch (InvocationTargetException e) {
                MessageDialog.openWarning(getShell(), Messages.Common_Warning,
                        Messages.bind(Messages.Server_cannot_connected, serverDef.getName()));
                log.error(e);
            } catch (InterruptedException e) {
                MessageDialog.openWarning(getShell(), Messages.Common_Warning,
                        Messages.bind(Messages.Server_cannot_connected, serverDef.getName()));
                log.error(e);
            }
        }
    }

    class SelectItemsPage extends WizardPage {

        protected SelectItemsPage() {
            super("SelectServerPage"); //$NON-NLS-1$
            setTitle(Messages.ImportServerObject);

            // Page isn't complete until an e-mail address has been added
            // setPageComplete(false);

        }

        public void checkCompleted() {
            // && (selectedObjects != null && selectedObjects.length > 0)
            if (txtServer.getText().length() > 0 && (selectedObjects != null && selectedObjects.length > 0)) {
                setPageComplete(true);
            } else {
                setPageComplete(false);
            }
        }

        public void createControl(Composite parent) {
            Composite composite = new Composite(parent, SWT.BORDER);
            composite.setLayout(new GridLayout(4, false));
            composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
            setControl(composite);

            Group serverGroup = new Group(composite, SWT.NORMAL);
            serverGroup.setText(Messages.Select_Server);
            serverGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
            serverGroup.setLayout(new GridLayout(2, false));
            // serverGroup.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_WHITE));

            txtServer = new Text(serverGroup, SWT.BORDER);
            txtServer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
            Button btnSel = new Button(serverGroup, SWT.PUSH);
            btnSel.setText("..."); //$NON-NLS-1$
            btnSel.setToolTipText(Messages.Select_Server);
            txtServer.setEnabled(false);

            btnSel.addSelectionListener(new SelectionAdapter() {

                /*
                 * (non-Javadoc)
                 * 
                 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
                 */
                @Override
                public void widgetSelected(SelectionEvent e) {
                    SelectServerDefDialog dlg = new SelectServerDefDialog(getShell());
                    if (dlg.open() == IDialogConstants.OK_ID) {
                        serverDef = dlg.getSelectedServerDef();
                        if (serverDef == null) {
                            return;
                        }
                        txtServer.setText(serverDef.getUrl());

                        String url = serverDef.getUrl();
                        String user = serverDef.getUser();
                        String password = serverDef.getPasswd();
                        if (Util.IsEnterPrise()) {
                            try {
                                // get Version
                                XtentisPort port;
                                port = Util.getPort(new URL(url), null, user, password);
                                WSUniversePK[] universePKs = port.getUniversePKs(new WSGetUniversePKs("*")).getWsUniversePK();//$NON-NLS-1$

                                CCombo universeCombo = comboVersion.getCombo();
                                universeCombo.removeAll();
                                universeCombo.add(""); //$NON-NLS-1$
                                if (universePKs != null && universePKs.length > 0) {
                                    for (WSUniversePK universePK : universePKs) {
                                        String universe = universePK.getPk();
                                        universeCombo.add(universe);
                                    }
                                }

                            } catch (Exception e1) {
                                log.error(e1.getMessage(), e1);
                                comboVersion.getCombo().removeAll();
                            }
                        }
                        retriveServerRoot();
                    }

                    treeViewer.refresh();
                    updateSelectedObjects();
                    checkCompleted();
                }
            });
            if (Util.IsEnterPrise()) {
                comboVersion = new LabelCombo(toolkit, serverGroup, Messages.Version, SWT.BORDER, 2);
                comboVersion.getCombo().setEditable(false);

                comboVersion.getCombo().addSelectionListener(new SelectionAdapter() {

                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        serverDef.setUniverse(comboVersion.getCombo().getText());
                        retriveServerRoot();
                    }
                });

                toolkit.setBackGround((Composite) comboVersion.getComposite(), serverGroup.getBackground());
            }
            // create viewer
            treeViewer = new TreeObjectCheckTreeViewer((TreeParent) serverRoot);
            treeViewer.addButtonSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    updateSelectedObjects();
                    checkCompleted();
                }
            });
            Composite itemcom = treeViewer.createItemList(composite);
            treeViewer.getViewer().setInput(null);
            itemcom.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 5));
            treeViewer.setItemText(Messages.Select_Items_To_Imports);

            CheckboxTreeViewer checkboxViewer = (CheckboxTreeViewer) treeViewer.getViewer();
            checkboxViewer.addCheckStateListener(new ICheckStateListener() {

                public void checkStateChanged(CheckStateChangedEvent checkstatechangedevent) {
                    updateSelectedObjects();
                    checkCompleted();
                }
            });

            treeViewer.getViewer().addFilter(new ViewerFilter() {

                @Override
                public boolean select(Viewer viewer, Object parentElement, Object element) {
                    if (element instanceof TreeObject) {
                        int type = ((TreeObject) element).getType();
                        if (type == 26 || type == 24 || type == 25) {
                            return false;
                        }
                    }
                    return true;
                }
            });
            btnOverwrite = new Button(composite, SWT.CHECK);
            btnOverwrite.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    isOverrideAll = btnOverwrite.getSelection();

                    treeViewer.setOverWrite(isOverrideAll);
                    treeViewer.getViewer().refresh();
                }

            });
            btnOverwrite.setText(Messages.Overwrite_Exists_Items);
            // btnOverwrite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
            btnOverwrite.setSelection(true);
            GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(920, 600).applyTo(composite);
        }
    }
}
