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
package org.talend.mdm.workbench.serverexplorer.ui.views;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem;
import org.talend.mdm.workbench.serverexplorer.core.ServerDefService;
import org.talend.mdm.workbench.serverexplorer.plugin.MDMServerExplorerPlugin;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.ServerDefDialog;
import org.talend.mdm.workbench.serverexplorer.ui.providers.ServerSorter;
import org.talend.mdm.workbench.serverexplorer.ui.providers.TreeContentProvider;
import org.talend.mdm.workbench.serverexplorer.ui.providers.ViewerLabelProvider;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class ServerExplorer extends ViewPart {

    static final ImageDescriptor IMG_CHECK_CONNECT = MDMServerExplorerPlugin.imageDescriptorFromPlugin(
            MDMServerExplorerPlugin.PLUGIN_ID, "icons/client_network.png"); //$NON-NLS-1$








    public static final String ID = "org.talend.mdm.workbench.serverexplorer.ui.views.ServerExplorer"; //$NON-NLS-1$

    private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

    private TreeViewer treeViewer;

    private Tree tree;

    public ServerExplorer() {
    }

    /**
     * Create contents of the view part.
     * 
     * @param parent
     */
    @Override
    public void createPartControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new FillLayout(SWT.HORIZONTAL));

        treeViewer = new TreeViewer(container, SWT.BORDER);
        treeViewer.setSorter(new ServerSorter());
        tree = treeViewer.getTree();
        tree.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                editServerDef();
            }
        });
        toolkit.paintBordersFor(tree);
        treeViewer.setContentProvider(new TreeContentProvider());
        treeViewer.setLabelProvider(new ViewerLabelProvider());

        createActions();
        initializeToolBar();
        initializeMenu();
        // for debug
        // treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
        //
        // @Override
        // public void selectionChanged(SelectionChangedEvent event) {
        // IRepositoryViewObject viewObject = getCurSelectedViewObject();
        // Property property = viewObject.getProperty();
        // Item item = property.getItem();
        // System.out.println(property.eResource());
        //
        // }
        // });
        refreshServerDefs();

    }

    public void dispose() {
        toolkit.dispose();
        super.dispose();
    }

    /**
     * Create the actions.
     */
    private void createActions() {
        // Create the actions
    }

    /**
     * Initialize the toolbar.
     */
    private void initializeToolBar() {
        IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
    }

    /**
     * Initialize the menu.
     */
    private void initializeMenu() {

        // Adds root context menu
        MenuManager menuManager = new MenuManager();
        menuManager.add(new AddServerDefAction());
        menuManager.add(new DeleteServerDefAction());
        menuManager.add(new EditServerDefAction());
        menuManager.add(new CheckConnectionAction());

        // Context
        Menu contextMenu = menuManager.createContextMenu(tree);

        // Publish it
        tree.setMenu(contextMenu);
        getSite().registerContextMenu(menuManager, treeViewer);

    }

    @Override
    public void setFocus() {
        // Set the focus
    }

    public void refreshServerDefs() {
        List<IRepositoryViewObject> viewObjects = ServerDefService.getAllServerDefViewObjects();
        if (viewObjects != null) {
            treeViewer.setInput(viewObjects);
        }
    }

    private MDMServerDefItem getMDMItem(IRepositoryViewObject viewObject) {
        if (viewObject != null) {
            return (MDMServerDefItem) (viewObject.getProperty().getItem());
        }
        return null;
    }

    private IRepositoryViewObject getCurSelectedViewObject() {
        ISelection selection = treeViewer.getSelection();
        if (!selection.isEmpty()) {
            Object firstElement = ((TreeSelection) selection).getFirstElement();
            return (IRepositoryViewObject) firstElement;
        }
        return null;
    }

    class AddServerDefAction extends Action {

        public AddServerDefAction() {
            setImageDescriptor(ImageCache.getImage(EImage.ADD_OBJ.getPath()));
            setText("Add Server Location");
        }

        public void run() {
            ServerDefDialog dialog = new ServerDefDialog(getViewSite().getShell(), null);
            if (dialog.open() == IDialogConstants.OK_ID) {
                boolean result = ServerDefService.createServerDef(dialog.getServerDef());
                if (result) {
                    refreshServerDefs();
                }
            }
        }
    }

    class CheckConnectionAction extends Action {

        public CheckConnectionAction() {

            setImageDescriptor(IMG_CHECK_CONNECT);
            setText("Check Connection");
        }

        public void run() {
            IRepositoryViewObject viewObject = getCurSelectedViewObject();
            if (viewObject != null) {
                MDMServerDefItem mdmItem = getMDMItem(viewObject);
                if (mdmItem != null) {
                    MDMServerDef serverDef = mdmItem.getServerDef();
                    String msg = ServerDefService.checkMDMConnection(serverDef) ? "MDM Server Connected Sucessful!"
                            : "Connction Failed,Please check connection settings.";
                    MessageDialog.openInformation(getSite().getShell(), "Check Connection", msg);
                }
            }
        }
    }

    class EditServerDefAction extends Action {

        public EditServerDefAction() {
            setImageDescriptor(ImageCache.getImage(EImage.EDIT_OBJ.getPath()));
            setText("Edit Server Location");
        }

        public void run() {
            editServerDef();
        }

    }

    private void editServerDef() {
        IRepositoryViewObject viewObject = getCurSelectedViewObject();
        if (viewObject != null) {
            MDMServerDefItem mdmItem = getMDMItem(viewObject);
            if (mdmItem != null) {
                MDMServerDef serverDef = mdmItem.getServerDef();
                ServerDefDialog dialog = new ServerDefDialog(getViewSite().getShell(), serverDef);
                if (dialog.open() == IDialogConstants.OK_ID) {
                    boolean result = ServerDefService.saveServeDef(mdmItem);
                    if (result) {
                        refreshServerDefs();
                    }
                }
            }
        }
    }

    class DeleteServerDefAction extends Action {

        public DeleteServerDefAction() {
            setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
            setText("Remove Server Location");
        }

        public void run() {
            IRepositoryViewObject viewObject = getCurSelectedViewObject();
            if (viewObject != null) {
                MDMServerDefItem serverDefItem = getMDMItem(viewObject);
                if (MessageDialog.openQuestion(getViewSite().getShell(), "Delete Server",
                        "Are you sure you want to delete the server location '" + serverDefItem.getServerDef().getName() + "'?")) {
                    boolean result = ServerDefService.deleteServerDef(viewObject);
                    if (result) {
                        refreshServerDefs();
                    }
                }
            }
        }

    }
}
