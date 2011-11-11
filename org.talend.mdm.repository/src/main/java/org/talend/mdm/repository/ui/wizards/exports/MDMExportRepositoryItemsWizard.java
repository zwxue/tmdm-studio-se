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
package org.talend.mdm.repository.ui.wizards.exports;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.exolab.castor.xml.Marshaller;
import org.talend.commons.ui.runtime.exception.MessageBoxExceptionHandler;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.RepositoryViewObject;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.ui.wizards.exports.viewers.ExportRepositoryObjectCheckTreeViewer;
import org.talend.repository.local.ExportItemUtil;

import com.amalto.workbench.export.ExportItemsWizard;
import com.amalto.workbench.export.Exports;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.XtentisPort;
/**
 * DOC hywang class global comment. this wizard is used to export the selected items from MDMRepositoryView
 */
public class MDMExportRepositoryItemsWizard extends ExportItemsWizard {

    ExportRepositoryObjectCheckTreeViewer checkTreeViewer;

    private static Log log = LogFactory.getLog(MDMExportRepositoryItemsWizard.class);

    public MDMExportRepositoryItemsWizard(IStructuredSelection sel) {
        super(sel);
    }

    // create a check box viewer
    @Override
    protected void createViewer() {
        checkTreeViewer = new ExportRepositoryObjectCheckTreeViewer(sel);
    }

    // do export is need to override ,use the system of TOS to export EMF files
    @Override
    protected void doexport(Object[] selectedNodes, IProgressMonitor monitor) {
        List<RepositoryViewObject> objs = new LinkedList<RepositoryViewObject>();
        for (Object obj : selectedNodes) {
            if (obj instanceof RepositoryViewObject) {
                objs.add((RepositoryViewObject) obj);
            }
        }
        if (exportFolder != null) {

            Collection<Item> selectedItems = getItemsToExport(objs);
            try {
                ExportItemUtil exportItemUtil = new ExportItemUtil();
                // MOD sgandon 31/03/2010 bug 12229: moved getAllVersion into ExportItemUtil.exportitems() method.
                exportItemUtil.exportItems(new File(exportFolder), selectedItems, true, monitor);
                
                Exports eps = new Exports();
                List<TreeObject> exports = new ArrayList<TreeObject>();
                selectedItems = getItemsToExport(objs);

                //export datacluster
                boolean exportDc = false;
                for (Item item : selectedItems) {
                    MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
                    if(serverObject.getType()== TreeObject.DATA_CLUSTER){
                        WSDataClusterPK pk=new WSDataClusterPK(serverObject.getName());
                        if (serverObject.getLastServerDef() != null) {
                            XtentisPort port = RepositoryWebServiceAdapter.getXtentisPort(serverObject.getLastServerDef());
                            TreeObject xobject = exportCluster(exports, pk, port);
                            xobject.setUrl(serverObject.getLastServerDef().getUrl());
                            xobject.setUsername(serverObject.getLastServerDef().getUser());
                            xobject.setPassword(serverObject.getLastServerDef().getPasswd());
                            exportDc = true;
                        }
                    }
                }
                eps.setItems(exports.toArray(new TreeObject[exports.size()]));

                StringWriter sw = new StringWriter();
                try {
                    if (exportDc) {
                        Marshaller.marshal(eps, sw);
                        writeString(sw.toString(), "exportDataContainerItems.xml");//$NON-NLS-1$
                    }
                } catch (Exception e) {
                    log.error(e);
                }

            } catch (Exception e) {
                MessageBoxExceptionHandler.process(e);
            } finally {

            }
        }
    }

    @Override
    protected Object[] getCheckedObjects() {
        return checkTreeViewer.getCheckNodes();
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

    protected Composite initItemTreeViewer(Composite composite) {
        Composite returnComposite = checkTreeViewer.createItemList(composite);
        checkTreeViewer.setItemText(Messages.MDMExportRepositoryItemsWizard_exportItem);
        return returnComposite;
    }

}
