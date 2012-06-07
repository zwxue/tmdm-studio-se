// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2012 Talend �C www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.mdm.repository.ui.navigator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.actions.DeployAllAction;
import org.talend.mdm.repository.ui.actions.ExportObjectAction;
import org.talend.mdm.repository.ui.actions.ImportObjectAction;
import org.talend.mdm.repository.ui.actions.ImportServerObjectAction;
import org.talend.mdm.repository.ui.actions.RefreshViewAction;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.views.ServerView;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class MDMRepositoryView extends CommonNavigator implements ITabbedPropertySheetPageContributor {

    private static final String VIEW_CONTEXT_ID = "org.talend.mdm.repository.context"; //$NON-NLS-1$

    private static final Log log = LogFactory.getLog(ServerView.class);

    public static final String VIEW_ID = "org.talend.mdm.repository.ui.navigator.MDMRepositoryView"; //$NON-NLS-1$

    @Override
    public void createPartControl(Composite aParent) {
        super.createPartControl(aParent);
        initInput();
        registerEditorListener();
        contributeToActionBars();
        activateContext();

        // new added
        regisitPerspectiveBarSelectListener();
    }

    /**
     * Activate a context that this view uses. It will be tied to this view activation events and will be removed when
     * the view is disposed.
     */
    private void activateContext() {
        IContextService contextService = (IContextService) getSite().getService(IContextService.class);
        contextService.activateContext(VIEW_CONTEXT_ID);
    }

    @Override
    public void dispose() {
        super.dispose();
        unRegisterEditorListener();
    }

    private void contributeToActionBars() {
        IActionBars bars = getViewSite().getActionBars();
        fillLocalToolBar(bars.getToolBarManager());
    }

    private void fillLocalToolBar(IToolBarManager manager) {
        RefreshViewAction refreshViewAction = new RefreshViewAction();
        refreshViewAction.initCommonViewer(((CommonNavigator) this).getCommonViewer());
        manager.add(new Separator());
        manager.add(refreshViewAction);
        manager.add(new Separator());
        DeployAllAction deployAll = new DeployAllAction(true);
        deployAll.initCommonViewer(((CommonNavigator) this).getCommonViewer());
        manager.add(deployAll);
        manager.add(new Separator());
        ImportObjectAction importObject = new ImportObjectAction();
        importObject.initCommonViewer(((CommonNavigator) this).getCommonViewer());
        manager.add(importObject);
        // manager.add(new Separator());
        ExportObjectAction exportObject = new ExportObjectAction();
        exportObject.initCommonViewer(((CommonNavigator) this).getCommonViewer());
        manager.add(exportObject);
        // manager.add(new Separator());
        ImportServerObjectAction importServerObject = new ImportServerObjectAction();
        importServerObject.initCommonViewer(((CommonNavigator) this).getCommonViewer());
        manager.add(importServerObject);
        manager.add(new Separator());

    }

    /**
     * DOC hbhong Comment method "initInput".
     */
    private void initInput() {
        copyDataModelFiles();

        IRepositoryViewObject[] categoryViewObjects = RepositoryResourceUtil.getCategoryViewObjectsWithRecycle();

        getCommonViewer().setInput(categoryViewObjects);
        // getCommonViewer().addFilter(filter);
        getCommonViewer().expandToLevel(2);
    }

    /**
     * Just copy the default DataModel Data to current workspace
     */
    private void copyDataModelFiles() {
        final String resourceFolder = "resources\\system\\datamodel";
        ERepositoryObjectType type = IServerObjectRepositoryType.TYPE_DATAMODEL;
        
        IFolder folder2 = createTargetSystemFolder(type);
        File resourceFile = getResourceFolder(resourceFolder);
        copyToFolder(folder2, resourceFile);
    }

    private File getResourceFolder(final String resourceFolder) {
        File file = null;
        try {
            File bundleFile = FileLocator.getBundleFile(RepositoryPlugin.getDefault().getBundle());
            file = new File(bundleFile, resourceFolder);
        } catch (IOException e) {
            log.error("resolve bundle file error.", e);
        }

        return file;
    }

    private void copyToFolder(IFolder targetFolder, File resourceFile) {
        if(resourceFile != null) {
            File file = resourceFile;
            File[] files = file.listFiles();
            System.out.println("all files need to copy :" + files);
            try {
                
                List<IResource> asList = Arrays.asList(targetFolder.members());
                for (int i = 0; i < files.length; i++) {
                    if(files[i].getName().equals(".svn"))
                        continue;
                    
                    IFile ifile = targetFolder.getFile(files[i].getName());
                    if (!asList.contains(ifile)) {
                        System.out.println("create file " + files[i].getName());
                        ifile.create(new FileInputStream(files[i]), IFile.FORCE, new NullProgressMonitor());
                    }
                }
            } catch (FileNotFoundException e) {
                log.error("file not found.", e);
            } catch (CoreException e) {
                log.error("create model file failed.", e);
            }
        }
    }

    private IFolder createTargetSystemFolder(ERepositoryObjectType type) {
        IFolder typeFolder = RepositoryResourceUtil.getFolder(type);
        
        IFolder systemFolder = typeFolder.getFolder("System");
        if (!systemFolder.exists()) {
            try {
                systemFolder.create(0, true, new NullProgressMonitor());
            } catch (CoreException e) {
                log.error("create System folder error", e);
            }
        }
        return systemFolder;
    }

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    public static MDMRepositoryView show() {
        IViewPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(VIEW_ID);
        if (part == null) {
            try {
                part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(VIEW_ID);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return (MDMRepositoryView) part;
    }

    private IPartListener2 partListener = new IPartListener2() {

        public void partVisible(IWorkbenchPartReference partRef) {

        }

        public void partOpened(IWorkbenchPartReference partRef) {

        }

        public void partInputChanged(IWorkbenchPartReference partRef) {

        }

        public void partHidden(IWorkbenchPartReference partRef) {

        }

        public void partDeactivated(IWorkbenchPartReference partRef) {

        }

        public void partClosed(IWorkbenchPartReference partRef) {

        }

        public void partBroughtToTop(IWorkbenchPartReference partRef) {

        }

        public void partActivated(IWorkbenchPartReference partRef) {
            if (partRef.getId().equals("org.bonitasoft.studio.model.process.diagram.part.ProcessDiagramEditorID")) {//$NON-NLS-1$
                IPerspectiveDescriptor perspective = WorkbenchPlugin.getDefault().getPerspectiveRegistry()
                        .findPerspectiveWithId("org.bonitasoft.studio.application.perspective"); //$NON-NLS-1$
                if (perspective != null) {
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().setPerspective(perspective);
                }
            }
            // if editor is talend job editor, switch to org.talend.rcp.perspective
            if (partRef.getId().equals("org.talend.designer.core.ui.MultiPageTalendEditor")) {//$NON-NLS-1$

                String perspectiveId = "org.talend.rcp.perspective";

                if (activePerspective != null && deactivePerspective != null) {
                    if (!activePerspective.equals(deactivePerspective)) {
                        perspectiveId = activePerspective.getId();
                    }
                }

                IPerspectiveDescriptor perspective = WorkbenchPlugin.getDefault().getPerspectiveRegistry()
                        .findPerspectiveWithId(perspectiveId); //$NON-NLS-1$
                if (perspective != null) {
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().setPerspective(perspective);
                }
            }

            activePerspective = null;
            deactivePerspective = null;
        }
    };

    private IPerspectiveDescriptor activePerspective;// record current activated perspective for temp use

    private IPerspectiveDescriptor deactivePerspective;// record current deactivated perspective for temp use

    /**
     * Register one perspective selection listener
     */
    private void regisitPerspectiveBarSelectListener() {
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().addPerspectiveListener(new PerspectiveAdapter() {

            @Override
            public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
                activePerspective = perspective;
            }

            @Override
            public void perspectiveDeactivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
                deactivePerspective = perspective;
            }

        });
    }

    IPartListener editorListener = new IPartListener() {

        public void partActivated(IWorkbenchPart part) {
            if (part instanceof IEditorPart) {
                IEditorInput input = ((IEditorPart) part).getEditorInput();
                if (input != null && input instanceof IRepositoryViewEditorInput) {
                    Item item = ((IRepositoryViewEditorInput) input).getInputItem();
                    if (item != null) {
                        Property property = item.getProperty();
                        final IRepositoryViewObject viewObject = ContainerCacheService.get(property);
                        if (viewObject != null) {
                            Display.getDefault().asyncExec(new Runnable() {

                                public void run() {
                                    if (!getCommonViewer().getTree().isDisposed()) {
                                        getCommonViewer().refresh(viewObject);
                                    }
                                }
                            });

                        }
                    }
                }
            }
        }

        public void partBroughtToTop(IWorkbenchPart part) {
        }

        public void partClosed(IWorkbenchPart part) {
            if (part instanceof IEditorPart) {
                IEditorInput input = ((IEditorPart) part).getEditorInput();
                if (input != null && input instanceof IRepositoryViewEditorInput) {
                    Item item = ((IRepositoryViewEditorInput) input).getInputItem();
                    if (item != null) {
                        try {
                            factory.unlock(item);
                            Property property = item.getProperty();
                            final IRepositoryViewObject viewObject = ContainerCacheService.get(property);
                            if (viewObject != null) {
                                Display.getDefault().asyncExec(new Runnable() {

                                    public void run() {
                                        if (!getCommonViewer().getTree().isDisposed()) {
                                            getCommonViewer().refresh(viewObject);
                                        }
                                    }
                                });

                            }
                        } catch (PersistenceException e) {
                            log.error(e.getMessage(), e);
                        } catch (LoginException e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                }
            }
        }

        public void partDeactivated(IWorkbenchPart part) {
        }

        public void partOpened(IWorkbenchPart part) {
        }

    };

    private void registerEditorListener() {

        this.getSite().getPage().addPartListener(editorListener);
        this.getSite().getPage().addPartListener(partListener);
    }

    private void unRegisterEditorListener() {
        this.getSite().getPage().removePartListener(editorListener);
        this.getSite().getPage().removePartListener(partListener);
    }

    @Override
    public void init(IViewSite aSite, IMemento aMemento) throws PartInitException {
        super.init(aSite, aMemento);
        CommandManager.getInstance().restoreState(aMemento);
    }

    @Override
    public void saveState(IMemento aMemento) {
        super.saveState(aMemento);
        CommandManager.getInstance().saveState(aMemento);
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (adapter == IPropertySheetPage.class) {
            return new TabbedPropertySheetPage(this);
        }
        return super.getAdapter(adapter);
    }

    public String getContributorId() {
        return "org.talend.mdm.repository.repositoryviewobjct.version.propertycontributer"; //$NON-NLS-1$
    }
}
