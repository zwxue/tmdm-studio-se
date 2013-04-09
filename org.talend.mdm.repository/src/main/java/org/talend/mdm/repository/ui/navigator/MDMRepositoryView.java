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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.talend.mdm.repository.ui.dialogs.SwitchPerspectiveDialog;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.ui.preferences.PreferenceConstants;
import org.talend.mdm.repository.ui.starting.ShowWelcomeEditor;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.views.MDMPerspective;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 *
 */
public class MDMRepositoryView extends CommonNavigator implements ITabbedPropertySheetPageContributor {

    /**
     *
     */
    private static final String JOB_EDITOR_ID = "org.talend.designer.core.ui.MultiPageTalendEditor"; //$NON-NLS-1$

    /**
     *
     */
    //    private static final String BONITA_PERSPECTIVE_ID = "org.bonitasoft.studio.perspective.process"; //$NON-NLS-1$

    public static final String CONTRIBUTER_ID = "org.talend.mdm.repository.propertycontributer"; //$NON-NLS-1$

    private static final String VIEW_CONTEXT_ID = "org.talend.mdm.repository.context"; //$NON-NLS-1$

    private static final Log log = LogFactory.getLog(MDMRepositoryView.class);

    public static final String VIEW_ID = "org.talend.mdm.repository.ui.navigator.MDMRepositoryView"; //$NON-NLS-1$

    private static final String DI_PERSPECTIVE_ID = "org.talend.rcp.perspective";//$NON-NLS-1$

    private static final String MDM_PERSPECTIVE_ID = "org.talend.mdm.perspective"; //$NON-NLS-1$

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
        unRegisterEditorListener();
        unRegisitPerspectiveBarSelectListener();
        super.dispose();
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
        deployAll = new DeployAllAction(true);
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

    public DeployAllAction getDeployAllAction() {
        return deployAll;
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
        final String resourceFolder = "resources/system/datamodel";//$NON-NLS-1$
        ERepositoryObjectType type = IServerObjectRepositoryType.TYPE_DATAMODEL;

        File resourceFile = getResourceFolder(resourceFolder);
        copyToFolder(resourceFile, type);
    }

    private File getResourceFolder(final String resourceFolder) {
        File file = null;
        try {
            File bundleFile = FileLocator.getBundleFile(RepositoryPlugin.getDefault().getBundle());
            file = new File(bundleFile, resourceFolder);
        } catch (IOException e) {
            log.error("resolve bundle file error.", e);//$NON-NLS-1$
        }

        return file;
    }

    private void copyToFolder(File resourceFolder, ERepositoryObjectType dataType) {
        if (resourceFolder != null && resourceFolder.exists()) {
            IFolder targetFolder = createTargetSystemFolder(dataType);

            File file = resourceFolder;
            File[] files = file.listFiles();
            if (files != null) {

                for (File file2 : files) {
                    if (file2.getName().equals(".svn")) {
                        continue;
                    }

                    IFile ifile = targetFolder.getFile(file2.getName());
                    String fileExtension = ifile.getFileExtension();

                    if ("item".equals(fileExtension) || "properties".equals(fileExtension) || "xsd".equals(fileExtension)) //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
                    {
                        FileInputStream fileInputStream = null;
                        File sunfile = ifile.getLocation().toFile();
                        if (!sunfile.exists()) {
                            try {
                                fileInputStream = new FileInputStream(file2);
                                ifile.create(fileInputStream, IFile.FORCE, new NullProgressMonitor());
                            } catch (FileNotFoundException e) {
                                log.error("file not found.", e);//$NON-NLS-1$
                            } catch (CoreException e) {
                                log.error("create model file failed.", e);//$NON-NLS-1$
                            } finally {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e) {
                                        log.error(e.getMessage(), e);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private IFolder createTargetSystemFolder(ERepositoryObjectType type) {
        IFolder typeFolder = RepositoryResourceUtil.getFolder(type);

        IFolder systemFolder = typeFolder.getFolder("System");//$NON-NLS-1$
        File folderFile = systemFolder.getLocation().toFile();
        if (!folderFile.exists()) {
            try {
                systemFolder.create(0, true, new NullProgressMonitor());
            } catch (CoreException e) {
                log.error("create System folder error", e);//$NON-NLS-1$
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
            SwitchPerspectiveDialog dialog = null;
            String curPerspectiveId = (currentPerspective == null) ? null : currentPerspective.getId();
            String curPartId = partRef.getId();
            // if (!BONITA_PERSPECTIVE_ID.equals(curPerspectiveId) && WorkflowEditorInput.EDITOR_ID.equals(curPartId)) {
            //                dialog = new SwitchPerspectiveDialog(getSite().getShell(), "BPM", BONITA_PERSPECTIVE_ID, //$NON-NLS-1$
            // PreferenceConstants.P_AUTO_SWITCH_TO_BONITA, PreferenceConstants.P_NOT_ASK_AUTO_SWITCH_TO_BONITA);
            //
            // }
            // if editor is talend job editor, switch to org.talend.rcp.perspective
            if (MDM_PERSPECTIVE_ID.equals(curPerspectiveId) && JOB_EDITOR_ID.equals(curPartId)) {
                dialog = new SwitchPerspectiveDialog(getSite().getShell(), "Integration", DI_PERSPECTIVE_ID, //$NON-NLS-1$
                        PreferenceConstants.P_AUTO_SWITCH_TO_DI, PreferenceConstants.P_NOT_ASK_AUTO_SWITCH_TO_DI);

            }
            if (dialog != null) {
                dialog.run();
            }
        }

    };

    private IPerspectiveDescriptor currentPerspective;

    PerspectiveAdapter perspectiveListener = new PerspectiveAdapter() {

        @Override
        public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
            currentPerspective = perspective;
            if (first) {
                first = false;
                if (MDMPerspective.PERPECTIVE_ID.equals(perspective.getId())) {
                    ShowWelcomeEditor.showWelcomeEditor();
                }
            }

            if (MDMPerspective.PERPECTIVE_ID.equals(perspective.getId())) {
                getCommonViewer().refresh();
            }
        }
    };

    /**
     * Register one perspective selection listener
     */
    private void regisitPerspectiveBarSelectListener() {

        PlatformUI.getWorkbench().getActiveWorkbenchWindow().addPerspectiveListener(perspectiveListener);
    }

    private void unRegisitPerspectiveBarSelectListener() {

        PlatformUI.getWorkbench().getActiveWorkbenchWindow().removePerspectiveListener(perspectiveListener);
    }

    private static boolean first = true;

    IPartListener editorListener = new IPartListener() {

        public void partActivated(IWorkbenchPart part) {
            if (part instanceof IEditorPart) {
                IEditorInput input = ((IEditorPart) part).getEditorInput();
                if (input != null && input instanceof IRepositoryViewEditorInput) {

                    IRepositoryViewEditorInput repositoryViewEditorInput = (IRepositoryViewEditorInput) input;
                    final String id = repositoryViewEditorInput.getViewObject().getId();
                    Display.getDefault().asyncExec(new Runnable() {

                        public void run() {

                            if (!getCommonViewer().getTree().isDisposed()) {
                                final IRepositoryViewObject viewObject = ContainerCacheService.get(id);
                                if (viewObject != null) {
                                    getCommonViewer().refresh(viewObject);
                                }
                            }
                        }
                    });

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
                            final String id = property.getId();

                            Display.getDefault().asyncExec(new Runnable() {

                                public void run() {
                                    if (!getCommonViewer().getTree().isDisposed()) {
                                        final IRepositoryViewObject viewObject = ContainerCacheService.get(id);
                                        if (viewObject != null) {
                                            getCommonViewer().refresh(viewObject);
                                        }
                                    }
                                }
                            });

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

    private DeployAllAction deployAll;

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
        return CONTRIBUTER_ID;
    }

    public void refreshRootNode(ERepositoryObjectType type) {
        IRepositoryViewObject[] categoryViewObjects = RepositoryResourceUtil.getCategoryViewObjects();
        for (IRepositoryViewObject viewObj : categoryViewObjects) {
            if (viewObj.getRepositoryObjectType().equals(type)) {
                getCommonViewer().refresh(viewObj);
                break;
            }
        }
    }
}
