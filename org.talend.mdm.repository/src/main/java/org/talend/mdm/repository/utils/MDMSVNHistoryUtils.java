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
package org.talend.mdm.repository.utils;

import java.io.ByteArrayInputStream;
import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.exception.ExceptionHandler;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IRepositoryNodeActionProvider;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.ui.editors.ISvnHistory;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.repository.remoteprovider.ProjectUrl;
import org.talend.repository.remoteprovider.ProjectUrlHelper;
import org.talend.repository.svnprovider.utils.SVNHistoryUtils;
import org.tigris.subversion.javahl.ClientException;
import org.tigris.subversion.javahl.DirEntry;
import org.tigris.subversion.javahl.LogMessage;


/**
 * DOC achen  class global comment. Detailled comment
 */
public class MDMSVNHistoryUtils extends SVNHistoryUtils {

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.repository.svnprovider.utils.SVNHistoryUtils#getSVNCurrentFilePath(java.lang.String,
     * java.lang.String, long)
     */
    @Override
    protected String getSVNCurrentFilePath(String folderPath, String filePath, long num) throws PersistenceException,
            ClientException {
        String returnValue = null;
        DirEntry[] dirEntry = svnHandler.list(folderPath, num);
        if (dirEntry != null) {
            for (int i = 0; i < dirEntry.length; i++) {
                if (returnValue != null)
                    return returnValue;

                if (dirEntry[i].getPath().indexOf('.') != -1) {// is file
                    if (dirEntry[i].getPath().equals(filePath)) {
                        returnValue = folderPath + "/" + dirEntry[i].getPath(); //$NON-NLS-1$
                        return returnValue;
                    }
                } else {
                    returnValue = this.getSVNCurrentFilePath(folderPath + "/" + dirEntry[i].getPath(), filePath, num); //$NON-NLS-1$
                }
            }
        }

        return returnValue;
    }

    protected String getCurrentFilePath(String folderPath, String filePath) throws PersistenceException {
        File file = new File(folderPath);
        String[] flist = file.list();
        String returnValue = null;
        if (flist != null) {
            for (int i = 0; i < flist.length; i++) {
                if (returnValue != null)
                    return returnValue;
                File f = new File(flist[i]);
                if (f.getName().indexOf('.') != -1) {// is File
                    if (f.getName().equals(filePath)) {
                        returnValue = folderPath + "/" + f.getPath(); //$NON-NLS-1$
                        return returnValue;
                    }
                } else {
                    returnValue = this.getCurrentFilePath(folderPath + "/" + f.getPath(), filePath); //$NON-NLS-1$
                }
            }
        }
        return returnValue;
    }

    public void refreshEditor(IRepositoryViewObject obj) {
        // close the editor
        IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(obj);
        if (configuration != null) {
            IRepositoryNodeActionProvider actionProvider = configuration.getActionProvider();
            if (actionProvider != null) {
                IRepositoryViewEditorInput editorInput = actionProvider.getOpenEditorInput(obj);
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                IEditorPart part = page.findEditor(editorInput);
                if (part != null)
                    page.closeEditor(part, true);
                // refresh the obj
                RepositoryResourceUtil.initialize();
                IRepositoryViewObject parent = ContainerCacheService.getParent(obj);
                if (parent != null) {
                    MDMRepositoryView.show().getCommonViewer().refresh(parent);
                }
                // open the editor
                try {
                    editorInput = actionProvider.getOpenEditorInput(obj);
                    obj.getProperty().getItem();
                    IEditorPart editor = page.openEditor(editorInput, editorInput.getEditorId(), true);
                    String name = editorInput.getName() + " (Revision:" + logRevisionNum + ")";
                    if (editor instanceof ISvnHistory) {
                        ((ISvnHistory) editor).setName(name);
                    }
                } catch (PartInitException e) {

                }
            }
        }

    }

    // Replace the item and property files in local workcopy of update special revision files form SVN.
    @SuppressWarnings("nls")
    public void rewriteJobPropertyFile(Object object, Object obj, IRepositoryViewObject repositoryObject, boolean isLocked) {
        String objectname = (repositoryObject).getProperty().getLabel() + "_" + (repositoryObject).getProperty().getVersion(); //$NON-NLS-1$
        String checkoutItemFile = objectname + ".item"; //$NON-NLS-1$
        // resource object
        String checkoutPngFile = objectname + ".png";
        // customform object
        String checkoutFormFile = objectname + ".form";
        // workflow object
        String checkoutProcFile = objectname + ".proc";
        LogMessage logMessage = (LogMessage) object;
        if (isLocked == false)
            logRevisionNum = logMessage.getRevision().getNumber() + 1;
        else
            logRevisionNum = logMessage.getRevision().getNumber();
        ProjectUrl projectUrl;
        try {
            projectUrl = ProjectUrlHelper.fromUrl(projectURL);

            String folderName = ERepositoryObjectType.getFolderName(ERepositoryObjectType
                    .getItemType(((IRepositoryViewObject) repositoryObject).getProperty().getItem()));
            String currentPropertyFilePath = this.getCurrentFilePath(eclipseProject.getLocation() + "/" + folderName,
                    checkoutPropertyFile);
            String currentItemFilePath = this.getCurrentFilePath(eclipseProject.getLocation() + "/" + folderName,
                    checkoutItemFile);
            // resource object
            String currentPngFilePath = this.getCurrentFilePath(eclipseProject.getLocation() + "/" + folderName, checkoutPngFile);
            if (currentPngFilePath != null)
                currentPngFilePath = currentPngFilePath.substring(currentPngFilePath.indexOf(folderName));
            // customform object
            String currentFormFilePath = this.getCurrentFilePath(eclipseProject.getLocation() + "/" + folderName,
                    checkoutFormFile);
            if (currentFormFilePath != null)
                currentFormFilePath = currentFormFilePath.substring(currentFormFilePath.indexOf(folderName));
            // workflow object
            String currentProcFilePath = this.getCurrentFilePath(eclipseProject.getLocation() + "/" + folderName,
                    checkoutProcFile);
            if (currentProcFilePath != null)
                currentProcFilePath = currentProcFilePath.substring(currentProcFilePath.indexOf(folderName));

            currentPropertyFilePath = currentPropertyFilePath.substring(currentPropertyFilePath.indexOf(folderName));
            currentItemFilePath = currentPropertyFilePath.replace(".properties", ".item");
            long revisionNumtoCheck = logMessage.getRevision().getNumber();
            String svnCurrentFilePath = getSVNCurrentFilePath(projectUrl.getLocation() + "/" + folderName, checkoutItemFile,
                    revisionNumtoCheck);
            if (svnCurrentFilePath == null && revisionNumtoCheck == ((LogMessage) obj).getRevisionNumber()) {
                do {
                    revisionNumtoCheck -= 1;
                    svnCurrentFilePath = getSVNCurrentFilePath(projectUrl.getLocation() + "/" + folderName, checkoutItemFile,
                            revisionNumtoCheck);
                } while (svnCurrentFilePath == null);
            }
            if (svnCurrentFilePath == null)
                revisionNumtoCheck++;
            byte[] itemFileContent = null;
            byte[] propertyFileContent = null;
            itemFileContent = svnHandler.fileContents(projectUrl.getLocation() + "/" + currentItemFilePath, revisionNumtoCheck);
            propertyFileContent = svnHandler.fileContents(projectUrl.getLocation() + "/" + currentPropertyFilePath,
                    revisionNumtoCheck);
            IFile itemFile = eclipseProject.getFile(currentItemFilePath);
            IFile propertyFile = eclipseProject.getFile(currentPropertyFilePath);
            // IFile file = objectFolder.getFile(filename);

            if (!itemFile.exists())
                itemFile.create(new ByteArrayInputStream(itemFileContent), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$
            else
                itemFile.setContents(new ByteArrayInputStream(itemFileContent), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$

            if (!propertyFile.exists())
                propertyFile.create(new ByteArrayInputStream(propertyFileContent), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$
            else
                propertyFile.setContents(new ByteArrayInputStream(propertyFileContent), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$

            itemFile.refreshLocal(0, new NullProgressMonitor());
            propertyFile.refreshLocal(0, new NullProgressMonitor());

            byte[] pngFileContent = null;
            byte[] formFileContent = null;
            byte[] procFileContent = null;
            if (currentPngFilePath != null) {
                pngFileContent = svnHandler.fileContents(projectUrl.getLocation() + "/" + currentPngFilePath, revisionNumtoCheck);
                IFile pngFile = eclipseProject.getFile(currentPngFilePath);
                if (!pngFile.exists())
                    pngFile.create(new ByteArrayInputStream(pngFileContent), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$
                else
                    pngFile.setContents(new ByteArrayInputStream(pngFileContent), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$                
            }
            if (currentFormFilePath != null) {
                formFileContent = svnHandler.fileContents(projectUrl.getLocation() + "/" + currentFormFilePath,
                        revisionNumtoCheck);
                IFile formFile = eclipseProject.getFile(currentFormFilePath);
                if (!formFile.exists())
                    formFile.create(new ByteArrayInputStream(formFileContent), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$
                else
                    formFile.setContents(new ByteArrayInputStream(formFileContent), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$
            }
            if (currentProcFilePath != null) {
                procFileContent = svnHandler.fileContents(projectUrl.getLocation() + "/" + currentProcFilePath,
                        revisionNumtoCheck);
                IFile procFile = eclipseProject.getFile(currentProcFilePath);
                if (!procFile.exists())
                    procFile.create(new ByteArrayInputStream(procFileContent), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$
                else
                    procFile.setContents(new ByteArrayInputStream(procFileContent), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$            
            }

        } catch (PersistenceException e) {
            ExceptionHandler.process(e);
        } catch (ClientException e) {
            ExceptionHandler.process(e);
        } catch (Exception e) {
            ExceptionHandler.process(e);
        }
    }

}
