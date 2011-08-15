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
package importorexport;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.talend.commons.ui.runtime.exception.MessageBoxExceptionHandler;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.RepositoryViewObject;
import org.talend.repository.local.ExportItemUtil;

import com.amalto.workbench.export.ExportItemsWizard;

/**
 * DOC hywang class global comment. this wizard is used to export the selected items from MDMRepositoryView
 */
public class MDMExportRepositoryItemsWizard extends ExportItemsWizard {

    public MDMExportRepositoryItemsWizard(IStructuredSelection sel) {
        super(sel);

    }

    // do export is need to override ,use the system of TOS to export EMF files
    @Override
    protected void doexport(Object[] selectedNodes, IProgressMonitor monitor) {
        List selected = Arrays.asList(selectedNodes);
        List<RepositoryViewObject> objs = new ArrayList<RepositoryViewObject>();
        for (Object obj : selected) {
            if (obj instanceof RepositoryViewObject) {
                objs.add((RepositoryViewObject) obj);
            }
        }
        if (exportFolder != null) {

            Collection<Item> selectedItems = getItemsToExport(objs);
            try {
                ExportItemUtil exportItemUtil = new ExportItemUtil();
                // MOD sgandon 31/03/2010 bug 12229: moved getAllVersion into ExportItemUtil.exportitems() method.
                exportItemUtil.exportItems(new File(exportFolder), selectedItems, true, new NullProgressMonitor());

            } catch (Exception e) {
                MessageBoxExceptionHandler.process(e);
            } finally {

            }
        }
    }

    /**
     * DOC hywang Comment method "getItemsToExport".
     * 
     */
    private Collection<Item> getItemsToExport(Collection<RepositoryViewObject> objs) {
        List<Item> toReturn = null;
        if (objs != null && objs.size() > 0) {
            toReturn = new ArrayList<Item>();
            for (RepositoryViewObject obj : objs) {
                Item item = obj.getProperty().getItem();
                toReturn.add(item);
            }
        }
        return toReturn;
    }

    // create a check box viewer
    @Override
    protected void createViewer() {
        treeViewer = new RepositoryViewCheckTreeViewer(sel);
    }

}
