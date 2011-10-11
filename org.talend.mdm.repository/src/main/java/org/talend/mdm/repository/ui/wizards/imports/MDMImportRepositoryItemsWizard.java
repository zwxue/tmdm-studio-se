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
package org.talend.mdm.repository.ui.wizards.imports;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.wizards.datatransfer.ArchiveFileManipulations;
import org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages;
import org.eclipse.ui.internal.wizards.datatransfer.TarException;
import org.eclipse.ui.internal.wizards.datatransfer.TarFile;
import org.eclipse.ui.internal.wizards.datatransfer.TarLeveledStructureProvider;
import org.eclipse.ui.internal.wizards.datatransfer.ZipLeveledStructureProvider;
import org.eclipse.ui.progress.UIJob;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.ui.wizards.exports.viewers.CheckboxMDMRepositoryTreeViewer;
import org.talend.mdm.repository.ui.wizards.exports.viewers.RepositoryViewCheckTreeViewer;
import org.talend.repository.imports.ImportItemUtil;
import org.talend.repository.imports.ItemRecord;
import org.talend.repository.imports.ResourcesManager;
import org.talend.repository.imports.ResourcesManagerFactory;
import org.talend.repository.imports.TreeBuilder;
import org.talend.repository.imports.TreeBuilder.IContainerNode;

import com.amalto.workbench.export.ImportItemsWizard;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.widgets.FilteredCheckboxTree;

/**
 * DOC hywang class global comment. Detailled comment
 */
public class MDMImportRepositoryItemsWizard extends ImportItemsWizard {

    private ImportItemUtil repositoryUtil = new ImportItemUtil();

    private List<ItemRecord> selectedItems = new ArrayList<ItemRecord>();

    private ResourcesManager manager;

    boolean hideView = true;

    public MDMImportRepositoryItemsWizard(IStructuredSelection sel) {
        super(sel);
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

        IViewPart viewPart = page.findView(ServerView.VIEW_ID);
        if (viewPart != null) {
            hideView = false;
        }
    }

    @Override
    public void doImport(Object[] selectedObjs, IProgressMonitor monitor) {
        repositoryUtil.importItemRecords(manager, selectedItems, monitor, isOverride, null, "");
    }

    protected void createOverwriteBtn(Composite composite) {
        btnOverwrite = new Button(composite, SWT.CHECK);
        btnOverwrite.setText("Overwrite existing items"); //$NON-NLS-N$
        btnOverwrite.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                isOverride = btnOverwrite.getSelection();
                parse();
            }

        });
    }

    @Override
    protected void createViewer() {
        treeViewer = new RepositoryViewCheckTreeViewer(sel) {

            @Override
            protected void createTreeViewer(Composite itemComposite) {
                filteredCheckboxTree = new FilteredCheckboxTree(itemComposite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
                        | SWT.MULTI) {

                    @Override
                    protected CheckboxTreeViewer doCreateTreeViewer(Composite parent, int style) {
                        checkboxViewer = new CheckboxMDMRepositoryTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
                        checkboxViewer.setContentProvider(new ITreeContentProvider() {

                            public Object[] getChildren(Object parentElement) {
                                if (parentElement instanceof IContainerNode) {
                                    return ((IContainerNode) parentElement).getChildren().toArray();
                                }
                                return null;
                            }

                            public Object[] getElements(Object inputElement) {
                                // return getValidItems();
                                return repositoryUtil.getTreeViewInput().toArray();
                            }

                            public boolean hasChildren(Object element) {
                                if (element instanceof IContainerNode) {
                                    return ((IContainerNode) element).hasChildren();
                                }
                                return false;
                            }

                            public Object getParent(Object element) {
                                return null;
                            }

                            public void dispose() {

                            }

                            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
                            }

                        });

                        checkboxViewer.setLabelProvider(new LabelProvider() {

                            @Override
                            public String getText(Object element) {
                                if (element instanceof IContainerNode) {
                                    return ((IContainerNode) element).getLabel();
                                }
                                return ((ItemRecord) element).getLabel();
                            }

                            @Override
                            public Image getImage(Object element) {
                                if (element instanceof IContainerNode) {
                                    return ((IContainerNode) element).getImage();
                                } else if (element instanceof ItemRecord) {
                                    return ((ItemRecord) element).getImage();
                                }

                                return super.getImage(element);
                            }

                        });

                        checkboxViewer.setSorter(TreeBuilder.createSorter());
                        checkboxViewer.setInput(this);
                        return checkboxViewer;
                    }

                    @Override
                    protected void refreshCompleted() {
                        getViewer().expandToLevel(3);
                        restoreCheckedElements();
                    }

                    @Override
                    protected boolean isNodeCollectable(TreeItem item) {
                        // Object obj = item.getData();
                        // if (obj instanceof RepositoryNode) {
                        // RepositoryNode node = (RepositoryNode) obj;
                        // if (node.getObjectType() == ERepositoryObjectType.METADATA_CONNECTIONS) {
                        // return true;
                        // }
                        // }
                        return false;
                    }
                };
                if (checkboxViewer != null) {
                    checkboxViewer.addFilter(new ViewerFilter() {

                        @Override
                        public boolean select(Viewer viewer, Object parentElement, Object element) {
                            return true;
                        }
                    });
                }
            }

        };
    }

    /** need to override this method to list all the import items to the viewer **/
    @Override
    protected void parses(boolean importFromArchieve, String zipFilePath, IProgressMonitor monitor) {
        selectedItems.clear();
        String importPath = importFromArchieve ? zipFilePath : importFolder;
        final Collection<ItemRecord> items = new ArrayList<ItemRecord>();

        monitor.beginTask(DataTransferMessages.WizardProjectsImportPage_SearchingMessage, 100);
        File directory = new File(importPath);
        monitor.worked(10);
        if (importFromArchieve && ArchiveFileManipulations.isTarFile(importPath)) {
            TarFile sourceTarFile = getSpecifiedTarSourceFile(importPath);
            if (sourceTarFile == null) {
                return;
            }

            TarLeveledStructureProvider provider = new TarLeveledStructureProvider(sourceTarFile);
            manager = ResourcesManagerFactory.getInstance().createResourcesManager(provider);

            if (!manager.collectPath2Object(provider.getRoot())) {
                return;
            }
        } else if (importFromArchieve && ArchiveFileManipulations.isZipFile(importPath)) {
            ZipFile sourceFile = getSpecifiedZipSourceFile(importPath);
            if (sourceFile == null) {
                return;
            }
            ZipLeveledStructureProvider provider = new ZipLeveledStructureProvider(sourceFile);
            manager = ResourcesManagerFactory.getInstance().createResourcesManager(provider);

            if (!manager.collectPath2Object(provider.getRoot())) {
                return;
            }
        } else if (!importFromArchieve && directory.isDirectory()) {
            manager = ResourcesManagerFactory.getInstance().createResourcesManager();

            if (!manager.collectPath2Object(directory)) {
                return;
            }
        } else {
            monitor.worked(60);
        }
        repositoryUtil.clearAllData();
        items.addAll(repositoryUtil.populateItems(manager, isOverride, monitor));

        selectedItems.addAll(items);

        this.getShell().getDisplay().syncExec(new Runnable() {

            public void run() {
                treeViewer.getViewer().setInput(repositoryUtil.getTreeViewInput());
            }
        });

        monitor.done();

    }

    private ZipFile getSpecifiedZipSourceFile(String fileName) {
        if (fileName.length() == 0) {
            return null;
        }

        try {
            return new ZipFile(fileName);
        } catch (ZipException e) {
            displayErrorDialog(DataTransferMessages.ZipImport_badFormat);
        } catch (IOException e) {
            displayErrorDialog(DataTransferMessages.ZipImport_couldNotRead);
        }

        zip.getText().setFocus();
        return null;
    }

    private TarFile getSpecifiedTarSourceFile(String fileName) {
        if (fileName.length() == 0) {
            return null;
        }

        try {
            return new TarFile(fileName);
        } catch (TarException e) {
            displayErrorDialog(DataTransferMessages.TarImport_badFormat);
        } catch (IOException e) {
            displayErrorDialog(DataTransferMessages.ZipImport_couldNotRead);
        }

        zip.getText().setFocus();
        return null;
    }

    protected void displayErrorDialog(String message) {
        MessageDialog.openError(getContainer().getShell(), getErrorDialogTitle(), message);
    }

    protected String getErrorDialogTitle() {
        return IDEWorkbenchMessages.WizardExportPage_internalErrorTitle;
    }

    @Override
    protected void refreshViewJob() {
        new UIJob("Refreshing server") {

            @Override
            public IStatus runInUIThread(IProgressMonitor monitor) {
                MDMRepositoryView.show().getCommonViewer().refresh();
                return Status.OK_STATUS;
            }

        }.schedule();
    }

    public static void hideServerView() {
        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        if (activePage != null) {
            IViewReference ref = activePage.findViewReference(ServerView.VIEW_ID);
            if (ref != null) {
                activePage.hideView(ref);

            }
        }
    }

    @Override
    public boolean performCancel() {
        if (hideView) {
        hideServerView();
        }
        return super.performCancel();
    }

    @Override
    public boolean performFinish() {

        boolean result = super.performFinish();
        if (hideView) {
        hideServerView();
        }
        return result;
    }
}
