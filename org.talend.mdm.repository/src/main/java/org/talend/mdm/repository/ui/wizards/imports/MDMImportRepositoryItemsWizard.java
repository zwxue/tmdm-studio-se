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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.wizards.datatransfer.ArchiveFileManipulations;
import org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages;
import org.eclipse.ui.internal.wizards.datatransfer.TarEntry;
import org.eclipse.ui.internal.wizards.datatransfer.TarException;
import org.eclipse.ui.internal.wizards.datatransfer.TarFile;
import org.eclipse.ui.internal.wizards.datatransfer.TarLeveledStructureProvider;
import org.eclipse.ui.internal.wizards.datatransfer.ZipLeveledStructureProvider;
import org.eclipse.ui.progress.UIJob;
import org.exolab.castor.xml.Unmarshaller;
import org.talend.core.model.properties.Item;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.ui.wizards.imports.viewer.ImportRepositoryObjectCheckTreeViewer;
import org.talend.repository.imports.ImportItemUtil;
import org.talend.repository.imports.ItemRecord;
import org.talend.repository.imports.ResourcesManager;
import org.talend.repository.imports.ResourcesManagerFactory;

import com.amalto.workbench.export.Exports;
import com.amalto.workbench.export.ImportItemsWizard;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;

/**
 * DOC hywang class global comment. Detailled comment
 */
public class MDMImportRepositoryItemsWizard extends ImportItemsWizard {

    private ImportItemUtil repositoryUtil = new ImportItemUtil();

    private List<ItemRecord> selectedItems = new ArrayList<ItemRecord>();

    private ResourcesManager manager;

    private static Logger log = Logger.getLogger(MDMImportRepositoryItemsWizard.class);
    ImportRepositoryObjectCheckTreeViewer checkTreeViewer;

    // data container that has items
    private List<TreeObject> dataClusters = new ArrayList<TreeObject>();

    private static final String exportDataContainerItems_xml = "exportDataContainerItems.xml";
    public MDMImportRepositoryItemsWizard(IStructuredSelection sel) {
        super(sel);
    }

    @Override
    public void doImport(Object[] selectedObjs, IProgressMonitor monitor) {
        List<ItemRecord> itemRecords = new LinkedList<ItemRecord>();
        for (Object obj : selectedObjs) {
            if (obj instanceof ItemRecord) {
                itemRecords.add((ItemRecord) obj);
            }
        }
        for (ItemRecord itemRec : itemRecords) {
            Item item = itemRec.getProperty().getItem();
            MDMServerObject serverObj = null;
            if (item instanceof MDMServerObjectItem) {
                serverObj = ((MDMServerObjectItem) item).getMDMServerObject();
                if (serverObj.getLastServerDef() != null) {
                    serverObj.setLastServerDef(null);
                }
            }
        }
        repositoryUtil.importItemRecords(manager, itemRecords, monitor, isOverride, null, ""); //$NON-NLS-1$

        monitor.beginTask("Importing Data Container Items ...", 20);
        HashMap<String, String> picturePathMap = new HashMap<String, String>();
        for (TreeObject item : dataClusters) {

            try {
                importClusterContents(item, Util.getPort(item), picturePathMap);
            } catch (Exception e) {
                log.error(e);
            }
        }
        monitor.done();
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
        checkTreeViewer = new ImportRepositoryObjectCheckTreeViewer(repositoryUtil);
    }

    /** need to override this method to list all the import items to the viewer **/
    @Override
    protected void parses(boolean importFromArchieve, String zipFilePath, IProgressMonitor monitor) {
        selectedItems.clear();
        String importPath = importFromArchieve ? zipFilePath : importFolder;
        final Collection<ItemRecord> items = new ArrayList<ItemRecord>();

        monitor.beginTask(DataTransferMessages.WizardProjectsImportPage_SearchingMessage, 100);
        File directory = new File(importPath);
        InputStream exportDataContainerItems = null;
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
            try {
                exportDataContainerItems = sourceTarFile.getInputStream(new TarEntry("/" + exportDataContainerItems_xml)); //$NON-NLS-1$
            } catch (Exception e) {
                log.error(e);
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
            try {
                ZipEntry entry = sourceFile.getEntry(exportDataContainerItems_xml);
                exportDataContainerItems = sourceFile.getInputStream(entry); //$NON-NLS-1$
            } catch (Exception e) {
                log.error(e);
            }
        } else if (!importFromArchieve && directory.isDirectory()) {
            manager = ResourcesManagerFactory.getInstance().createResourcesManager();

            if (!manager.collectPath2Object(directory)) {
                return;
            }
            try {
                exportDataContainerItems = new FileInputStream(directory.getAbsolutePath() + File.separator
                        + exportDataContainerItems_xml);
            } catch (FileNotFoundException e) {
                log.error(e);
            }
        } else {
            monitor.worked(60);
        }
        repositoryUtil.clearAllData();
        if (manager != null)
            items.addAll(repositoryUtil.populateItems(manager, isOverride, monitor));

        selectedItems.addAll(items);

        this.getShell().getDisplay().syncExec(new Runnable() {

            public void run() {
                checkTreeViewer.getViewer().setInput(repositoryUtil.getTreeViewInput());
            }
        });
        dataClusters.clear();
        dataClusterContent.clear();
        if (exportDataContainerItems != null) {
            // import dataContainer items
            InputStreamReader reader = null;
            try {
                reader = new InputStreamReader(exportDataContainerItems, "UTF-8");//$NON-NLS-1$
                final Exports exports = (Exports) Unmarshaller.unmarshal(Exports.class, reader);
                for (TreeObject obj : exports.getItems()) {
                    dataClusters.add(obj);
                    if (obj.getItems() != null && obj.getItems().length > 0) {
                        for (int i = 0; i < obj.getItems().length; i++) {
                            if (obj.getItems()[i].split("/")[1] != null) //$NON-NLS-1$
                                dataClusterContent.put(obj.getItems()[i].split("/")[1], obj.getItems()); //$NON-NLS-1$
                        }
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }
        }
        monitor.done();

    }

    @Override
    protected Object[] getCheckedObjects() {
        return checkTreeViewer.getCheckNodes();
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


    protected Composite initItemTreeViewer(Composite composite) {
        Composite returnComposite = checkTreeViewer.createItemList(composite);
        checkTreeViewer.getViewer().setInput(null);
        checkTreeViewer.setItemText("Select items to import:");
        return returnComposite;
    }

}
