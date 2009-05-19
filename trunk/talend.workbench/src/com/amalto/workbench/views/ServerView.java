package com.amalto.workbench.views;

import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.amalto.workbench.actions.AServerViewAction;
import com.amalto.workbench.actions.BrowseViewAction;
import com.amalto.workbench.actions.CopyXObjectAction;
import com.amalto.workbench.actions.DeleteXObjectAction;
import com.amalto.workbench.actions.EditXObjectAction;
import com.amalto.workbench.actions.NewXObjectAction;
import com.amalto.workbench.actions.PasteXObjectAction;
import com.amalto.workbench.actions.ServerInitAction;
import com.amalto.workbench.actions.ServerLoginAction;
import com.amalto.workbench.actions.ServerRefreshAction;
import com.amalto.workbench.actions.VersioningXObjectAction;
import com.amalto.workbench.models.IXObjectModelListener;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.ServerTreeContentProvider;
import com.amalto.workbench.providers.ServerTreeLabelProvider;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.WorkbenchClipboard;
import com.amalto.workbench.webservices.WSLogout;
import com.amalto.workbench.webservices.WSVersioningGetInfo;
import com.amalto.workbench.webservices.WSVersioningInfo;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * The view allowing administration of the "+IConstants.TALEND+" Server
 * 
 * @author Bruno Grieder
 * 
 */
public class ServerView extends ViewPart implements IXObjectModelListener {
	
	public static final String VIEW_ID="org.talend.openmdm.workbench.views.ServerView";
	
	protected TreeViewer viewer;
	protected DrillDownAdapter drillDownAdapter;
	protected Action loginAction;
	protected Action logoutAction;
	protected Action newXObjectAction;
	protected Action editXObjectAction;
	protected Action deleteXObjectAction;
	protected Action serverRefreshAction;
	protected Action serverInitAction;
	protected Action browseViewAction;
	protected Action copyAction;
	protected Action pasteAction;
	protected Action versionAction;
	private ServerTreeContentProvider contentProvider;

	/**********************************************************************************
	 * The VIEW
	 * 
	 **********************************************************************************/

	/**
	 * The constructor.
	 */
	public ServerView() {
	}

    public static ServerView show() {
        IViewPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(VIEW_ID);
        if (part == null) {
            try {
                part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(VIEW_ID);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (ServerView) part;
    }
    
    public TreeParent getRoot(){
    	return contentProvider.getInvisibleRoot();
    }
    
	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		 contentProvider=new ServerTreeContentProvider(this.getSite(),
				new TreeParent("INVISIBLE ROOT", null, TreeObject._ROOT_, null,
						null));
		setTreeContentProvider(contentProvider);
		viewer.setLabelProvider(new ServerTreeLabelProvider());
		viewer.setSorter(new ViewerSorter());
		viewer.setInput(getViewSite());
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		hookKeyPressAction();
		contributeToActionBars();
		hookKeyboard();
	}

	/**
	 * // fliu 
	 *  add keyboard listener into tree to assist ctrl+c, ctrl+v and del
	 */
	private void hookKeyboard()
	{
		viewer.getControl().addKeyListener(new KeyListener() {
        	public void keyPressed(KeyEvent e) {}
        	public void keyReleased(KeyEvent e) {
        		if (e.keyCode == 'c' && e.stateMask ==
        			SWT.CTRL) {
        			copyAction.run();
        		}
        		else if(e.keyCode == 'v' && e.stateMask ==
        			SWT.CTRL){
        			pasteAction.run();
        		}
        		else if (e.keyCode == SWT.DEL){
        			deleteXObjectAction.run();
        		}
        		}
        	});
	}
	
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ServerView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(loginAction);
		/*
		 * manager.add(new Separator()); manager.add(logoutAction);
		 */
	}

	protected void fillContextMenu(IMenuManager manager) {
		TreeObject xobject = (TreeObject) ((IStructuredSelection) viewer
				.getSelection()).getFirstElement();

		boolean hasVersioning = false;
		try {
			XtentisPort port = Util.getPort(xobject);
			if (port == null)
				return;
			WSVersioningInfo info = port
					.versioningGetInfo(new WSVersioningGetInfo(null));
			hasVersioning = info.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (xobject == null) {
			manager.add(loginAction);
		} else {
			switch (xobject.getType()) {
			case TreeObject._SERVER_:
				manager.add(loginAction);
				manager.add(logoutAction);
				manager.add(serverRefreshAction);
				if (!WorkbenchClipboard.getWorkbenchClipboard().isEmpty())
					manager.add(pasteAction);
				if ("admin".equalsIgnoreCase(xobject.getUsername()))
					manager.add(serverInitAction);
				break;
			case TreeObject._ACTION_:
				manager.add((Action) xobject.getWsObject());
				break;
			case TreeObject.SUBSCRIPTION_ENGINE:
				manager.add(browseViewAction);
				break;
			case TreeObject.VIEW:
			case TreeObject.DATA_CLUSTER:
				if (xobject.isXObject()) {
					manager.add(browseViewAction);
				}
			default:
				manager.add(newXObjectAction);
				if (xobject.isXObject()) {
					manager.add(editXObjectAction);
					manager.add(deleteXObjectAction);
					manager.add(copyAction);
				}
				if (hasVersioning)
					manager.add(versionAction);
				if (!WorkbenchClipboard.getWorkbenchClipboard().isEmpty())
					manager.add(pasteAction);
			}
		}
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(loginAction);
		// manager.add(logoutAction);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		loginAction = new ServerLoginAction(this);

		logoutAction = new Action() {
			public void run() {
				TreeParent serverRoot = (TreeParent) ((IStructuredSelection) ServerView.this.viewer
						.getSelection()).getFirstElement();

				final String universe = serverRoot.getUniverse();
				final String username = serverRoot.getUsername();
				final String password = serverRoot.getPassword();
				final String endpointAddress = serverRoot.getEndpointAddress();

				serverRoot.getParent().removeChild(serverRoot);
				ServerView.this.viewer.refresh();

				// attempt logout on the server side
				ServerView.this.viewer.getControl().getDisplay().syncExec(
						new Runnable() {
							public void run() {
								try {
									Util.getPort(new URL(endpointAddress),
											universe, username, password)
											.logout(new WSLogout());
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
			}
		};
		logoutAction.setText("Logout");
		logoutAction.setToolTipText("Logout From the " + IConstants.TALEND
				+ " Server");
		logoutAction.setImageDescriptor(AbstractUIPlugin
				.imageDescriptorFromPlugin("com.amalto.workbench",
						"icons/logout.gif"));

		editXObjectAction = new EditXObjectAction(this);
		newXObjectAction = new NewXObjectAction(this);
		deleteXObjectAction = new DeleteXObjectAction(this);
		serverRefreshAction = new ServerRefreshAction(this);
		serverInitAction = new ServerInitAction(this);
		browseViewAction = new BrowseViewAction(this);
		copyAction = new CopyXObjectAction(this);
		pasteAction = new PasteXObjectAction(this);
		versionAction = new VersioningXObjectAction(this);
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = ServerView.this.getViewer()
						.getSelection();
				TreeObject xo = (TreeObject) ((IStructuredSelection) selection)
						.getFirstElement();
				if (xo.getType() == TreeObject._ACTION_) {
					Class<?> actionClass = (Class<?>) xo.getWsKey();
					try {
						AServerViewAction action = (AServerViewAction) actionClass
								.newInstance();
						action.setServerView(ServerView.this);
						action.run();
					} catch (Exception ex) {
						MessageDialog.openError(viewer.getControl().getShell(),
								"Error", "Unable to run action");
					}
					return;
				}// if action
				if (xo.getType() == TreeObject.SUBSCRIPTION_ENGINE)
					browseViewAction.run();
				else
					editXObjectAction.run();
			}
		});
	}

	private void hookKeyPressAction() {
		viewer.getTree().addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {

				ISelection selection = ServerView.this.getViewer()
						.getSelection();
				TreeObject xo = (TreeObject) ((IStructuredSelection) selection)
						.getFirstElement();

				// delete
				if ((e.stateMask==0) && (e.keyCode == SWT.DEL)) {

					switch (xo.getType()) {

					case TreeObject.DATA_MODEL:
						if(xo.getParent().getType()==TreeObject.DATA_MODEL){
							deleteXObjectAction.run();
						}
						
						break;
					default:
//						MessageDialog.openError(getSite().getShell(),
//								"Error", "Unknown " + IConstants.TALEND
//										+ " Object Type: " + xo.getType());
						return;
					}// switch

				}

			}

			public void keyReleased(KeyEvent e) {

			}

		});

	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * Access to the Tree Model
	 * 
	 */
	public ServerTreeContentProvider getTreeContentProvider() {
		return (ServerTreeContentProvider) viewer.getContentProvider();
	}

	public void setTreeContentProvider(
			ServerTreeContentProvider treeContentProvider) {
		ServerTreeContentProvider oldProvider = (ServerTreeContentProvider) this.viewer
				.getContentProvider();
		if (oldProvider != null)
			oldProvider.removeListener(this);

		viewer.setContentProvider(treeContentProvider);
		treeContentProvider.addListener(this);
	}

	public void handleEvent(int type, TreeObject parent, TreeObject child) {
		// System.out.println("VIEWER HANDLE EVENT "+type+" Parent:  "+(parent==
		// null
		// ?" no parent":parent.getDisplayName())+"-->"+child.getDisplayName());

		switch (type) {
		case IXObjectModelListener.NEED_REFRESH:
			new ServerRefreshAction(this, (TreeParent) child).run();
			break;
		}

		this.viewer.refresh(false);
	}

	public TreeViewer getViewer() {
		return viewer;
	}

	public void setViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}

	public void dispose() {
		ServerTreeContentProvider oldProvider = (ServerTreeContentProvider) this.viewer
				.getContentProvider();
		if (oldProvider != null)
			oldProvider.removeListener(this);
		super.dispose();
	}

}