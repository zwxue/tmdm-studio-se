// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2011 Talend ¨C www.talend.com
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.ui.actions.DeployAllAction;
import org.talend.mdm.repository.ui.actions.ImportObjectAction;
import org.talend.mdm.repository.ui.actions.RefreshViewAction;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.views.ServerView;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class MDMRepositoryView extends CommonNavigator {

    private static final Log log = LogFactory.getLog(ServerView.class);

    public static final String VIEW_ID = "org.talend.mdm.repository.ui.navigator.MDMRepositoryView"; //$NON-NLS-1$

    @Override
    public void createPartControl(Composite aParent) {
        super.createPartControl(aParent);
        initInput();
        registerEditorListener();
        contributeToActionBars();
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
        manager.add(new Separator());

    }

    /**
     * DOC hbhong Comment method "initInput".
     */
    private void initInput() {
        IRepositoryViewObject[] categoryViewObjects = RepositoryResourceUtil.getCategoryViewObjects();

        getCommonViewer().setInput(categoryViewObjects);
        // getCommonViewer().addFilter(filter);
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

    IPartListener editorListener = new IPartListener() {

        public void partActivated(IWorkbenchPart part) {
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
                            IRepositoryViewObject viewObject = ContainerCacheService.get(property);
                            if (viewObject != null) {
                                getCommonViewer().refresh(viewObject);
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
    }

    private void unRegisterEditorListener() {
        this.getSite().getPage().removePartListener(editorListener);
    }
}
