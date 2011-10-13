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
package org.talend.mdm.repository.ui.widgets;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.talend.commons.ui.runtime.exception.ExceptionHandler;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.commons.ui.runtime.image.ImageProvider;
import org.talend.commons.ui.swt.actions.ITreeContextualAction;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.model.general.Project;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryObject;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.repository.RepositoryObject;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.mdm.repository.ui.actions.OpenObjectAction;
import org.talend.repository.model.ERepositoryStatus;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.IRepositoryNode.ENodeType;
import org.talend.repository.model.IRepositoryNode.EProperties;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.RepositoryNodeUtilities;
import org.talend.repository.svnprovider.utils.SVNHistoryUtils;
import org.talend.repository.ui.actions.ActionsHelper;
import org.tigris.subversion.javahl.LogMessage;
import org.tigris.subversion.javahl.Revision.Number;

/**
 * DOC achen  class global comment. Detailled comment
 */
public class SvnHistoryComposite extends Composite {

    protected static final int NB_LINES = 4;

    protected TabbedPropertySheetWidgetFactory widgetFactory;

    protected IRepositoryViewObject repositoryObject;

    protected static final SimpleDateFormat FORMATTER = new SimpleDateFormat();

    private TableViewer tableViewer;

    private ISelection selection;

    private IWizardPage wizardPage = null;

    boolean canWork = true;

    SVNHistoryUtils svnHistoryUtils = null;

    /**
     * nma VersionComposite class global comment. Detailled comment
     */
    private static class IRepositoryObjectComparator implements Comparator {

        public int compare(Object o1, Object o2) {
            return VersionUtils.compareTo(((IRepositoryObject) o1).getVersion(), ((IRepositoryObject) o2).getVersion());
        }
    }

    public IRepositoryViewObject getRepositoryObject() {
        return repositoryObject;
    }

    public void setRepositoryObject(IRepositoryViewObject repositoryObject) {
        this.repositoryObject = repositoryObject;
    }


    /**
     * nma VersionComposite constructor comment.
     * 
     * @param parent
     * @param style
     */
    public SvnHistoryComposite(Composite parent, int style) {
        super(parent, style);
        this.widgetFactory = new TabbedPropertySheetWidgetFactory();

        svnHistoryUtils = new SVNHistoryUtils();
        FormLayout layout = new FormLayout();
        setLayout(layout);

        tableViewer = new TableViewer(this, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
        final Table table = tableViewer.getTable();
        TableLayout tableLayout = new TableLayout();
        table.setLayout(tableLayout);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        final String[] columnProperties = new String[] { "Revision", "Date", "Author", "Comment" };

        final TableColumn column1 = new TableColumn(table, SWT.NONE);
        tableLayout.addColumnData(new ColumnPixelData(125, true));
        column1.setText(columnProperties[0]);

        final TableColumn column2 = new TableColumn(table, SWT.NONE);
        tableLayout.addColumnData(new ColumnPixelData(125, true));
        column2.setText(columnProperties[1]);

        final TableColumn column3 = new TableColumn(table, SWT.NONE);
        tableLayout.addColumnData(new ColumnPixelData(125, true));
        column3.setText(columnProperties[2]);

        final TableColumn column4 = new TableColumn(table, SWT.NONE);
        tableLayout.addColumnData(new ColumnPixelData(125, true));
        column4.setText(columnProperties[3]);

        tableViewer.setColumnProperties(columnProperties);

        Object layoutData = parent.getLayoutData();
        if (layoutData instanceof GridData) {
            GridData gridData = (GridData) layoutData;
            gridData.grabExcessVerticalSpace = true;
            gridData.verticalAlignment = SWT.FILL;
        }

        FormData formData = new FormData();
        formData.left = new FormAttachment(0);
        formData.top = new FormAttachment(0);
        formData.right = new FormAttachment(100);
        formData.bottom = new FormAttachment(100);
        table.setLayoutData(formData);

        tableViewer.setContentProvider(new IStructuredContentProvider() {

            public Object[] getElements(Object inputElement) {
                return svnHistoryUtils.getContentElements(repositoryObject.getProperty());
            }

            public void dispose() {
            }

            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            }
        });

        tableViewer.setLabelProvider(new ITableLabelProvider() {

            public Image getColumnImage(Object element, int columnIndex) {
                return null;
            }

            public String getColumnText(Object element, int columnIndex) {
                LogMessage logMessageNode = (LogMessage) element;
                switch (columnIndex) {
                case 0:
                    return logMessageNode.getRevision().toString();
                case 1:
                    if (logMessageNode.getDate() != null) {
                        return FORMATTER.format(logMessageNode.getDate());
                    } else {
                        return null;
                    }
                case 2:
                    if (logMessageNode.getAuthor() != null) {
                        return logMessageNode.getAuthor();
                    } else {
                        return null;
                    }
                case 3:
                    if (logMessageNode.getMessage() != null) {
                        if (logMessageNode.getMessage().indexOf("\n-\nUser") == -1) //$NON-NLS-1$
                            return ""; //$NON-NLS-1$
                        else
                            return logMessageNode.getMessage().substring(0, logMessageNode.getMessage().indexOf("\n-\nUser")); //$NON-NLS-1$
                    } else {
                        return null;
                    }
                default:
                    return null;
                }
            }

            public void addListener(ILabelProviderListener listener) {
            }

            public void dispose() {
            }

            public boolean isLabelProperty(Object element, String property) {
                return false;
            }

            public void removeListener(ILabelProviderListener listener) {
            }
        });

        // feature 18354
        tableViewer.setSorter(new ViewerSorter() {

            public int compare(Viewer viewer, Object object1, Object object2) {
                LogMessage l1 = null;
                LogMessage l2 = null;
                Number r1 = null;
                Number r2 = null;
                if (null != object1 && object1 instanceof LogMessage) {
                    l1 = (LogMessage) object1;
                    r1 = l1.getRevision();
                }
                if (null != object2 && object2 instanceof LogMessage) {
                    l2 = (LogMessage) object2;
                    r2 = l2.getRevision();
                }
                if (null != r1 && r1 instanceof Number && null != r2 && r2 instanceof Number) {
                    if (r1.getNumber() > r2.getNumber()) {
                        return -1;
                    } else if (r1.getNumber() < r2.getNumber()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
                return 0;
            }
        });

        IProxyRepositoryFactory rFactory = ProxyRepositoryFactory.getInstance();
        if (!rFactory.isUserReadOnlyOnCurrentProject()) {
            addPopUpMenu();
        }
        addSortListener(table, column1, column2, column3);

    }

    protected LogMessage adaptToLogMessage(Object element) {
        // Get the log entry for the provided object
        LogMessage entry = null;
        if (element instanceof LogMessage) {
            entry = (LogMessage) element;
        } else if (element instanceof IAdaptable) {
            entry = (LogMessage) ((IAdaptable) element).getAdapter(LogMessage.class);
        }
        return entry;
    }

    // check out process with special revison, and replace the latesest modified one.
    private class CheckoutAction extends Action {

        public CheckoutAction() {
            super();
            this.setText("Check out");
            this.setToolTipText("Check out");
            this.setImageDescriptor(ImageProvider.getImageDesc(ECoreImage.PROCESS_ICON));
        }

        @Override
        public void run() {

            this.setImageDescriptor(ImageProvider.getImageDesc(ECoreImage.PROCESS_ICON));
            ISelection selection = tableViewer.getSelection();
            if (selection != null && selection instanceof IStructuredSelection) {
                try {
                    canWork = MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Replace current revision",
                                    "Last revision of the object will be lost as soon as a modification in done in the job, are you sure ?");
                    if (canWork) {
                        Property property = repositoryObject.getProperty();
                        ERepositoryStatus status = ProxyRepositoryFactory.getInstance().getStatus(property.getItem());
                        if (status == ERepositoryStatus.LOCK_BY_OTHER) {
                            MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Item already locked by other",
                                    "Impossible to checkout actually, please unlock first");
                            return;
                        }
                        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
                        Object object = structuredSelection.getFirstElement();
                        Object obj = (tableViewer.getTable().getItems()[tableViewer.getTable().getItems().length - 1].getData());
                        svnHistoryUtils.rewriteJobPropertyFile(object, obj, repositoryObject, true);
                        IRepositoryObject currentObject = null;
                        if (property != null) {
                            currentObject = new RepositoryObject(property);
                            RepositoryNode parentRepositoryNode = RepositoryNodeUtilities
                                    .getParentRepositoryNodeFromSelection(repositoryObject);
                            ERepositoryObjectType itemType = ERepositoryObjectType.getItemType(currentObject.getProperty()
                                    .getItem());

                            RepositoryNode repositoryNode = new RepositoryNode(currentObject, parentRepositoryNode,
                                    ENodeType.REPOSITORY_ELEMENT);
                            repositoryNode.setProperties(EProperties.CONTENT_TYPE, itemType);
                            repositoryNode.setProperties(EProperties.LABEL, currentObject.getLabel());
                            repositoryObject.setRepositoryNode(repositoryNode);
                            // svnHistoryUtils.refreshEditor(repositoryNode);
                            refreshEditor(repositoryObject);
                        }
                    }
                } catch (RuntimeException e) {
                    ExceptionHandler.process(e);
                }

            }

        }
    }

    private void refreshEditor(IRepositoryViewObject obj) {
        OpenObjectAction action = new OpenObjectAction();
        List<Object> list = new ArrayList<Object>();
        list.add(obj);
        // TODO
        action.setSelectObject(list);
        action.run();
    }
    /**
     * nma Comment method "addPoppuMenu".
     */
    private void addPopUpMenu() {
        MenuManager menuMgr = new MenuManager("#PopUp"); //$NON-NLS-1$
        menuMgr.setRemoveAllWhenShown(true);
        menuMgr.addMenuListener(new IMenuListener() {

            public void menuAboutToShow(IMenuManager mgr) {
                if (svnHistoryUtils.isRefProject() == false)
                    mgr.add(new CheckoutAction());
            }

        });
        Menu menu = menuMgr.createContextMenu(tableViewer.getControl());
        tableViewer.getControl().setMenu(menu);
    }

    protected IProject getEclipseProject(Project project) {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IProject eclipseProject = workspace.getRoot().getProject(project.getTechnicalLabel());
        return eclipseProject;
    }

    /**
     * nma Comment method "addSortListener".
     * 
     * @param table
     * @param column1
     * @param column2
     * @param column3
     */
    private void addSortListener(final Table table, final TableColumn column1, final TableColumn column2,
            final TableColumn column3) {
        Listener sortListener = new Listener() {

            private int direction = 1;

            public void handleEvent(Event e) {
                final TableColumn column = (TableColumn) e.widget;

                if (column == table.getSortColumn()) {
                    direction = -direction;
                }
                if (direction == 1) {
                    table.setSortDirection(SWT.DOWN);
                } else {
                    table.setSortDirection(SWT.UP);
                }

                table.setSortColumn(column);
                tableViewer.setSorter(new ViewerSorter() {

                    int index = 0;

                    @Override
                    public void sort(Viewer viewer, Object[] elements) {
                        while (index < table.getColumns().length && table.getColumn(index) != column) {
                            index++;
                        }
                        super.sort(viewer, elements);
                    }

                    @Override
                    public int compare(Viewer viewer, Object e1, Object e2) {

                        ITableLabelProvider labelProvider = (ITableLabelProvider) tableViewer.getLabelProvider();
                        String columnText = labelProvider.getColumnText(e1, index) != null ? labelProvider.getColumnText(e1,
                                index) : ""; //$NON-NLS-1$
                        String columnText2 = labelProvider.getColumnText(e2, index) != null ? labelProvider.getColumnText(e2,
                                index) : ""; //$NON-NLS-1$
                        // feature 18354
                        if (!"".equals(columnText) && null != columnText && !"".equals(columnText2) && null != columnText2) { //$NON-NLS-1$ //$NON-NLS-2$
                            int text1 = Integer.parseInt(columnText);
                            int text2 = Integer.parseInt(columnText2);
                            if (text1 > text2) {
                                return -1 * direction;
                            } else if (text1 < text2) {
                                return 1 * direction;
                            } else {
                                return 0 * direction;
                            }
                        }
                        return 0;
                    }
                });
            }
        };

        tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            /*
             * (non-Javadoc)
             * 
             * @seeorg.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.
             * SelectionChangedEvent)
             */
            public void selectionChanged(SelectionChangedEvent event) {
                selection = event.getSelection();
                if (getParentWizard() != null) {
                    ((WizardPage) getParentWizard()).setPageComplete(true);
                }
            }
        });

        column1.addListener(SWT.Selection, sortListener);
        column2.addListener(SWT.Selection, sortListener);
        column3.addListener(SWT.Selection, sortListener);
        table.setSortColumn(column1);
        table.setSortDirection(SWT.DOWN);

        tableViewer.addDoubleClickListener(new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                if (getParentWizard() == null) {
                }
            }

        });
    }


    public void refresh() {
        Display.getDefault().syncExec(new Runnable() {

            /*
             * (non-Javadoc)
             * 
             * @see java.lang.Runnable#run()
             */
            public void run() {
                getParent().layout();
            }
        });
        if (tableViewer.getContentProvider() != null) {
            if (repositoryObject != null && repositoryObject.getProperty() != null
                    && svnHistoryUtils.isJobExistOnSVN(repositoryObject.getProperty())) {
                tableViewer.setInput(repositoryObject);
            } else {
                tableViewer.setInput(null);
            }
        }
    }

    public ITreeContextualAction getEditPropertiesAction(final Class<?> klazz) {

        ISelection selection = tableViewer.getSelection();
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;

            List<ITreeContextualAction> contextualsActions = ActionsHelper.getRepositoryContextualsActions();
            for (ITreeContextualAction action : contextualsActions) {
                if (action.getClass() == klazz) {
                    if (action.isReadAction() || action.isEditAction() || action.isPropertiesAction()) {
                        action.init(null, structuredSelection);
                        if (action.isVisible()) {
                            return action;
                        }
                    }
                }
            }
        }
        return null;
    }

    public ISelection getSelection() {
        return this.selection;
    }

    public IWizardPage getParentWizard() {
        return this.wizardPage;
    }

    public void setParentWizard(IWizardPage parentWizard) {
        this.wizardPage = parentWizard;
    }

}
