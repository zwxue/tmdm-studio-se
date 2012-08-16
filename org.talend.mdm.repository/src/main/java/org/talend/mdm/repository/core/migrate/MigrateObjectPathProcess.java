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
package org.talend.mdm.repository.core.migrate;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.talend.commons.exception.BusinessException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC HHB class global comment. Detailled comment
 */
public class MigrateObjectPathProcess {

    static Logger log = Logger.getLogger(MigrateObjectPathProcess.class);

    private final IMigrateObjectPathRule rule;

    public MigrateObjectPathProcess(IMigrateObjectPathRule rule) {
        this.rule = rule;
    }

    private boolean running = false;

    private void refresh() {
        Display.getDefault().asyncExec(new Runnable() {

            public void run() {
                MDMRepositoryView.show().getCommonViewer().refresh();
            }
        });
    }

    public void run() {
        try {
            if (isRunning()) {
                // System.out.println("#####");
                return;
            }
            // System.out.println(">>>>>>>>>>>> Begin");
            IProgressService progressService = null;
            while (progressService == null) {
                try {
                    Thread.sleep(1000);
                    progressService = PlatformUI.getWorkbench().getProgressService();
                } catch (Exception e) {
                }
            }
            progressService.run(true, false, process);

        } catch (InvocationTargetException e) {
            log.error(e.getMessage(), e);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        } finally {
            setRunning(false);
            // System.out.println("<<<<<<< End");
        }
    }

    private boolean isRunning() {
        return running;
    }

    private synchronized void setRunning(Boolean running) {
        this.running = running;
    }

    private void migrate(IProgressMonitor monitor) {
        setRunning(true);
        monitor.beginTask(Messages.MigrateObjectPathProcess_update, IProgressMonitor.UNKNOWN);
        List<String> existedMigrateFolders = new ArrayList<String>();
        List<IRepositoryViewObject> toMoveviewObjects = new ArrayList<IRepositoryViewObject>();
        iterateFolder(existedMigrateFolders, toMoveviewObjects, monitor);

        assertFolder(existedMigrateFolders, monitor);
        move(toMoveviewObjects, monitor);
        removeFolder(toMoveviewObjects, monitor);
        refresh();
        monitor.done();
    }

    private void removeFolder(List<IRepositoryViewObject> toMoveviewObjects, IProgressMonitor monitor) {
        monitor.subTask(Messages.MigrateObjectPathProcess_clean);
        for (ListIterator<IRepositoryViewObject> il = toMoveviewObjects.listIterator(toMoveviewObjects.size()); il.hasPrevious();) {
            IRepositoryViewObject viewObj = il.previous();
            if (viewObj instanceof FolderRepositoryObject) {

                // System.out.println("Removing.." + viewObj.getLabel());
                IFolder folder = RepositoryResourceUtil.getFolder(viewObj);
                try {
                    if (folder != null && folder.exists()) {
                        folder.delete(true, new NullProgressMonitor());
                    }
                } catch (CoreException e) {
                    log.error(e.getMessage(), e);
                }

            }
        }
    }

    private void move(List<IRepositoryViewObject> toMoveviewObjects, IProgressMonitor monitor) {
        final ProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();
        ERepositoryObjectType type = rule.getRepositoryObjectType();
        for (IRepositoryViewObject viewObj : toMoveviewObjects) {
            if (viewObj instanceof FolderRepositoryObject) {
                IPath[] moveTargetPaths = getMoveTargetPaths(viewObj);
                if (moveTargetPaths != null) {
                    for (IPath path : moveTargetPaths) {
                        // System.out.println("Create folder:" + viewObj.getLabel() + " => " + path);
                        IRepositoryViewObject parentViewObj = ContainerCacheService.get(type, path.removeLastSegments(1)
                                .toString());
                        Item folderItem = parentViewObj.getProperty().getItem();
                        RepositoryResourceUtil.createFolderViewObject(type, path.lastSegment(), folderItem, false);
                    }
                }

            } else {
                IPath moveTargetPath = getMoveTargetPath(viewObj);
                // System.out.println("move file:" + viewObj.getLabel() + " => " + moveTargetPath);
                try {
                    factory.moveObject(viewObj, moveTargetPath, null);
                } catch (PersistenceException e) {
                    log.error(e.getMessage(), e);
                } catch (BusinessException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }

    }

    private IPath getMoveTargetPath(IRepositoryViewObject viewObj) {
        String newPath = rule.routeObject(viewObj);
        return getPath(newPath, viewObj.getPath());
    }

    private IPath[] getMoveTargetPaths(IRepositoryViewObject viewObj) {
        String[] paths = rule.routeFolderObject(viewObj);
        if (paths == null)
            return null;
        IPath[] returnPaths = new IPath[paths.length];
        for (int i = 0; i < paths.length; i++) {
            returnPaths[i] = getPath(paths[i], viewObj.getPath());
        }
        return returnPaths;
    }

    private IPath getPath(String parentPath, String path) {
        if (parentPath != null) {
            if (path.trim().length() > 0) {
                parentPath += IPath.SEPARATOR + path;
            }
            return new Path(parentPath);
        }
        return null;
    }

    private void iterateFolder(List<String> existedMigrateFolders, List<IRepositoryViewObject> toMoveviewObjects,
            IProgressMonitor monitor) {
        monitor.subTask(Messages.MigrateObjectPathProcess_checkObj);

        List<IRepositoryViewObject> viewObjects = RepositoryResourceUtil.findViewObjects(rule.getRepositoryObjectType(),
                rule.getRootFolderItem(), true, true);
        for (IRepositoryViewObject viewObj : viewObjects) {
            if (viewObj instanceof FolderRepositoryObject) {
                if (!rule.isToMigrateFolder(viewObj)) {
                    handleViewObject(viewObj, toMoveviewObjects);
                } else {
                    existedMigrateFolders.add(viewObj.getLabel());
                }
            } else {
                handleViewObject(viewObj, toMoveviewObjects);
            }
        }

    }

    private void assertFolder(List<String> existedMigrateFolders, IProgressMonitor monitor) {
        monitor.subTask(Messages.MigrateObjectPathProcess_checkFolder);
        Item rootFolderItem = rule.getRootFolderItem();
        ERepositoryObjectType type = rule.getRepositoryObjectType();
        for (String folderName : rule.getAllNewFolderNames()) {
            if (!existedMigrateFolders.contains(folderName)) {
                RepositoryResourceUtil.createFolderViewObject(type, folderName, rootFolderItem, false);
            }
        }
    }

    private void handleViewObject(IRepositoryViewObject viewObj, List<IRepositoryViewObject> toMoveviewObjects) {
        toMoveviewObjects.add(viewObj);
        if (viewObj instanceof FolderRepositoryObject) {
            // System.out.println(viewObj.getLabel() + "[]\t" + rule.routeFolderObject(viewObj));
            Item item = viewObj.getProperty().getItem();
            List<IRepositoryViewObject> viewObjects = RepositoryResourceUtil.findViewObjects(rule.getRepositoryObjectType(),
                    item, true, true);
            if (viewObjects != null) {
                for (IRepositoryViewObject childViewObj : viewObjects) {
                    handleViewObject(childViewObj, toMoveviewObjects);
                }
            }
        }

    }

    IRunnableWithProgress process = new IRunnableWithProgress() {

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            migrate(monitor);
        }
    };

}
