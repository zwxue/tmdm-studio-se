// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.editors;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.forms.editor.FormEditor;

import com.amalto.workbench.availablemodel.AvailableModelUtil;
import com.amalto.workbench.availablemodel.IAvailableModel;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.providers.XObjectBrowserInput;

/**
 * created by liusongbo on 2014-5-6
 */
public class DataClusterStagingBrowserMainPage extends DataClusterBrowserMainPage {

    public DataClusterStagingBrowserMainPage(FormEditor editor) {
        super(editor);
        setPartName(Messages.bind(Messages.DataClusterStagingBrowserMainPage_stagingDataContainer,
                ((XObjectBrowserInput) editor.getEditorInput()).getName()));
        setMaster(false);
    }

    @Override
    protected void hookKeyboard() {
        //
    }

    @Override
    protected void hookContextMenu() {
        MenuManager menuMgr = new MenuManager();
        menuMgr.setRemoveAllWhenShown(true);
        menuMgr.addMenuListener(new IMenuListener() {

            public void menuAboutToShow(IMenuManager manager) {
                manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
                manager.appendToGroup(IWorkbenchActionConstants.MB_ADDITIONS, new NewItemAction(getShell(), resultsViewer));

                IStructuredSelection selection = ((IStructuredSelection) resultsViewer.getSelection());
                if (selection.size() == 1) {
                    manager.appendToGroup(IWorkbenchActionConstants.MB_ADDITIONS, new EditItemAction(getShell(), resultsViewer));
                }

                // compare item with each other
                if (selection.size() == 2) {
                    manager.appendToGroup(IWorkbenchActionConstants.MB_ADDITIONS, new CompareItemWithEachOtherAction(getShell(),
                            resultsViewer));
                }

                // available models
                if (selection.size() == 1) {
                    java.util.List<IAvailableModel> availablemodels = AvailableModelUtil.getAvailableModels();
                    for (IAvailableModel model : availablemodels) {
                        model.menuAboutToShow(manager, DataClusterStagingBrowserMainPage.this);
                    }
                }
            }
        });
        Menu menu = menuMgr.createContextMenu(resultsViewer.getControl());
        resultsViewer.getControl().setMenu(menu);
        getSite().registerContextMenu(menuMgr, resultsViewer);
    }

    @Override
    protected void hookToolBarItem() {
        // empty
    }

    @Override
    protected String getPkAddition() {
        return IDataClusterConstants.PK_ADDITION;
    }
}
