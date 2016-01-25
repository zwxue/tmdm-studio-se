// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.export;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.widgets.FileSelectWidget;
import com.amalto.workbench.widgets.LabelCombo;
import com.amalto.workbench.widgets.WidgetFactory;

/**
 * @deprecated
 * @author achen
 * 
 */
public class ExportItemsDialog extends Dialog {

    private static Log log = LogFactory.getLog(ExportItemsDialog.class);

    FormToolkit toolkit = WidgetFactory.getWidgetFactory();

    private LabelCombo comboDataCluster;

    TreeObject xObject;

    private Map<String, String> xpathMap = new HashMap<String, String>();

    private FileSelectWidget fw;

    private String server;

    String dataCluster;

    String filename;

    public ExportItemsDialog(Shell parentShell, TreeObject xObject) {
        super(parentShell);
        this.xObject = xObject;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        parent.getShell().setText(Messages.ExportItemsDialog_DialogTitle);
        Composite composite = (Composite) super.createDialogArea(parent);
        composite.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        GridLayout layout = (GridLayout) composite.getLayout();
        layout.numColumns = 1;

        Matcher matcher;
        final String dataCluster = "Data Container";//$NON-NLS-1$
        final String all = "ALL";//$NON-NLS-1$
        String xobjectName = "";//$NON-NLS-1$
        xobjectName = xObject.getDisplayName();
        if (xobjectName.equals(dataCluster))
            xobjectName = all;

        comboDataCluster = new LabelCombo(toolkit, composite, dataCluster, SWT.BORDER, 2);
        comboDataCluster.getCombo().setEditable(false);
        // List<String> dcs=Util.getCachedXObjectsNameSet(this.xObject, TreeObject.DATA_CLUSTER);
        List<String> dcs = Util.getChildren(this.xObject.getServerRoot(), TreeObject.DATA_CLUSTER);
        dcs.add(0, all);
        for (String cluster : dcs) {
            xpathMap.put(cluster, cluster);
        }
        for (TreeObject treeObj : xObject.getServerRoot().getChildren()) {
            if (treeObj.getDisplayName().startsWith(dataCluster))
                continue;
            String revision, xobject = "";//$NON-NLS-1$
            String xpath = "";//$NON-NLS-1$

            matcher = filter(treeObj.getDisplayName());
            if (matcher.matches()) {
                xobject = matcher.group(1).replace(" ", "");//$NON-NLS-1$//$NON-NLS-2$
                revision = matcher.group(3);
                if (xobject.equalsIgnoreCase("Process")) {//$NON-NLS-1$
                    xobject = "TransformerV2";//$NON-NLS-1$
                }
                if (revision.equals(IConstants.HEAD)) {
                    xpath = "amaltoOBJECTS" + xobject;//$NON-NLS-1$
                } else {
                    xpath = "R-" + revision + "/" + "amaltoOBJECTS" + xobject;//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
                }
            } else if (treeObj.getDisplayName().equals("Version")) {//$NON-NLS-1$
                xobject = treeObj.getDisplayName();
                xpath = "amaltoOBJECTS" + treeObj.getDisplayName();//$NON-NLS-1$
            }

            if (!xpath.equals("")) {//$NON-NLS-1$
                xpathMap.put(treeObj.getDisplayName(), xpath);
                dcs.add(treeObj.getDisplayName());
            }
        }
        comboDataCluster.getCombo().setItems(dcs.toArray(new String[dcs.size()]));
        int sel = Arrays.asList(comboDataCluster.getCombo().getItems()).indexOf(xobjectName);
        comboDataCluster.getCombo().select(sel);

        // file

        fw = new FileSelectWidget(composite, "Target      ", new String[] { "*.*", "*.zip" }, comboDataCluster.getCombo()//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
                .getText(), false, SWT.SAVE);
        comboDataCluster.getCombo().addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(SelectionEvent e) {

            }

            public void widgetSelected(SelectionEvent e) {
                if (comboDataCluster.getCombo().getText().length() > 0) {
                    fw.getText().setText(comboDataCluster.getCombo().getText());
                    fw.setFilename(comboDataCluster.getCombo().getText());
                }
            }
        });
        return composite;
    }

    private Matcher filter(String name) {
        Pattern bracket = Pattern.compile("(.*?)(\\s*)\\[(\\w+)\\]");//$NON-NLS-1$
        Matcher matcher = bracket.matcher(name);
        return matcher;
    }

    @Override
    protected void okPressed() {
        // /db/CONF -d c:/CONF.zip";
        if (comboDataCluster.getCombo().getText().trim().length() == 0) {
            MessageDialog.openError(null, Messages._Error, Messages.ExportItemsDialog_ErrorMsg);
            comboDataCluster.getCombo().setFocus();
            return;
        }
        if (fw.getText().getText().trim().length() == 0) {
            MessageDialog.openError(null, Messages._Error, Messages.ExportItemsDialog_ErrorMsg1);
            fw.getText().setFocus();
            return;
        }
        String url = xObject.getServerRoot().getEndpointAddress();
        server = null;
        try {
            server = new URL(url).getHost();
        } catch (MalformedURLException e1) {
            log.error(e1.getMessage(), e1);
        }
        dataCluster = comboDataCluster.getCombo().getText();
        dataCluster = xpathMap.get(dataCluster);
        filename = fw.getText().getText().trim();
        Job job = new Job(Messages.bind(Messages.ExportItemsDialog_JobName, dataCluster + " ...")) {//$NON-NLS-1$

            @Override
            public IStatus run(IProgressMonitor monitor) {
                try {
                    monitor.beginTask(Messages.bind(Messages.ExportItemsDialog_TaskName, dataCluster), IProgressMonitor.UNKNOWN);
                    // Util.exportDataCluster(xObject, dataCluster, filename,server, monitor);
                    monitor.done();
                    return Status.OK_STATUS;
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    return Status.CANCEL_STATUS;
                }
            }
        };
        job.setPriority(Job.INTERACTIVE);
        job.schedule();

        super.okPressed();
    }

}
