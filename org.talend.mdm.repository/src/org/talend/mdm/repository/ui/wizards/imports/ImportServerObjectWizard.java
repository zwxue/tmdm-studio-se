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

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.progress.UIJob;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.Bean2EObjUtil;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XtentisServerObjectsRetriever;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSGetUniversePKs;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.LabelCombo;
import com.amalto.workbench.widgets.RepositoryCheckTreeViewer;
import com.amalto.workbench.widgets.WidgetFactory;

/**
 * DOC achen  class global comment. Detailled comment
 */
public class ImportServerObjectWizard extends Wizard {

    static Logger log = Logger.getLogger(ImportServerObjectWizard.class);

    private RepositoryCheckTreeViewer treeViewer;

    private TreeObject serverRoot;

    MDMServerDef def;

    private LabelCombo comboVersion;

    private Text txtServer;

    WidgetFactory toolkit = WidgetFactory.getWidgetFactory();

    ServerView view = ServerView.show();

    CommonViewer commonViewer;

    boolean isOverrideAll = false;

    private Button btnOverwrite;
    public ImportServerObjectWizard(CommonViewer commonViewer) {
        setNeedsProgressMonitor(true);
        this.commonViewer = commonViewer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    @Override
    public boolean performFinish() {
        try {
            doImport();
        } catch (InvocationTargetException e) {
            log.error(e);
            return false;
        } catch (InterruptedException e) {
            log.error(e);
            return false;
        }
        return true;
    }
    
    private int isOveride(String name, String obTypeName) {

        final MessageDialog dialog = new MessageDialog(view.getSite().getShell(), Messages.Confirm_Overwrite, null,
                Messages.bind(Messages.Confirm_Overwrite_Info, obTypeName, name), MessageDialog.QUESTION,
                new String[] { IDialogConstants.YES_LABEL, IDialogConstants.YES_TO_ALL_LABEL, IDialogConstants.NO_LABEL,
                        IDialogConstants.CANCEL_LABEL }, 0);
        dialog.open();
        int result = dialog.getReturnCode();
        if (result == 0) {
            return IDialogConstants.YES_ID;
        }
        if (result == 1) {
            return IDialogConstants.YES_TO_ALL_ID;
        }
        if (result == 2) {
            return IDialogConstants.NO_ID;
        }
        return IDialogConstants.CANCEL_ID;

    }


    public void doImport(Object[] objs, IProgressMonitor monitor) {
        monitor.beginTask(Messages.Import_Objects, IProgressMonitor.UNKNOWN);

        List<Integer> types = new ArrayList<Integer>();
        types.add(TreeObject.DATA_CLUSTER);
        types.add(TreeObject.DATA_MODEL);
        types.add(TreeObject.TRANSFORMER);
        types.add(TreeObject.ROUTING_RULE);
        types.add(TreeObject.MENU);
        types.add(TreeObject.ROLE);
        types.add(TreeObject.SYNCHRONIZATIONPLAN);
        types.add(TreeObject.STORED_PROCEDURE);
        types.add(TreeObject.UNIVERSE);
        types.add(TreeObject.VIEW);
        for (Object obj : objs) {
            TreeObject treeObj = (TreeObject) obj;
            if (!types.contains(treeObj.getType()) || treeObj.getWsObject() == null
                    || ("JCAAdapers".equals(treeObj.getName()) && treeObj.getType() == TreeObject.DATA_CLUSTER)) //$NON-NLS-1$
                continue;
            monitor.subTask(treeObj.getDisplayName());
            MDMServerObject eobj = (MDMServerObject) Bean2EObjUtil.getInstance()
                    .convertFromBean2EObj(treeObj.getWsObject(), null);
            ERepositoryObjectType type = RepositoryQueryService.getRepositoryObjectType(treeObj.getType());
            MDMServerObjectItem item = RepositoryQueryService.findServerObjectItemByName(type, treeObj.getName());
            if (item != null) {
                if (!isOverrideAll) {
                    int result = isOveride(treeObj.getName(), TreeObject.getTypeName(treeObj.getType()));
                    if (result == IDialogConstants.CANCEL_ID) {
                        return;
                    }
                    if (result == IDialogConstants.YES_TO_ALL_ID) {
                        isOverrideAll = true;
                    }
                    if (result == IDialogConstants.NO_ID) {
                        break;
                    }
                }
                item.setMDMServerObject(eobj);
                // save
                IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
                try {
                    factory.save(item);
                } catch (PersistenceException e) {
                    log.error(e);
                }
            } else {
                IRepositoryNodeConfiguration config = RepositoryNodeConfigurationManager.getConfiguration(type);
                item = (MDMServerObjectItem) config.getResourceProvider().createNewItem(type);
                item.setMDMServerObject(eobj);
                ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
                itemState.setPath(treeObj.getPath());
                item.setState(itemState);
                RepositoryResourceUtil.createItem(item, treeObj.getName());
            }
        }
        monitor.done();
    }

    class ImportProcess implements IRunnableWithProgress {

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
         */
        public void run(IProgressMonitor arg0) throws InvocationTargetException, InterruptedException {
            UIJob job = new UIJob(Messages.Import_Objects) {

                @Override
                public IStatus runInUIThread(IProgressMonitor arg0) {
                    isOverrideAll = btnOverwrite.getSelection();
                    doImport(treeViewer.getCheckNodes(), arg0);
                    commonViewer.refresh();
                    return Status.OK_STATUS;
                }
            };
            job.schedule();
        }
    }

    class RetriveProcess implements IRunnableWithProgress {

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
         */
        public void run(IProgressMonitor arg0) throws InvocationTargetException, InterruptedException {
            final XtentisServerObjectsRetriever retriever = new XtentisServerObjectsRetriever(def.getName(), def.getUrl(),
                    def.getUser(), def.getPasswd(), def.getUniverse(), view);
            final IProgressMonitor monitor = arg0;
            // TODO Auto-generated method stub
            retriever.setRetriveWSObject(true);
            retriever.run(monitor);
            serverRoot = retriever.getServerRoot();

            Display.getDefault().asyncExec(new Runnable() {

                public void run() {
                    try {
                        treeViewer.setRoot((TreeParent) serverRoot);
                        treeViewer.getViewer().setInput(serverRoot);
                        treeViewer.getViewer().refresh();
                    } catch (Exception e) {
                        log.error(e);
                    }
                }
            });
        }
    }
    @Override
    public void addPages() {
        addPage(new SelectItemsPage());
    }

    private void doImport() throws InvocationTargetException, InterruptedException {
        getContainer().run(true, false, new ImportProcess());
    }
    private void retriveServerRoot() {
        if (def != null) {
            try {
                getContainer().run(true, false, new RetriveProcess());
            } catch (InvocationTargetException e) {
                log.error(e);
            } catch (InterruptedException e) {
                log.error(e);
            }
        }
    }

    class PageListener implements Listener {

        SelectItemsPage page;

        PageListener(SelectItemsPage page) {
            this.page = page;
        }

        public void handleEvent(Event event) {
            page.checkCompleted();
        }
    };
    class SelectItemsPage extends WizardPage {

        protected SelectItemsPage() {
            super("SelectServerPage"); //$NON-NLS-1$
            setTitle(Messages.ImportServerObject);

            // Page isn't complete until an e-mail address has been added
            setPageComplete(false);

        }

        public void checkCompleted() {
            if (txtServer.getText().length() > 0) {
                setPageComplete(true);
            } else {
                setPageComplete(false);
            }
        }

        public void createControl(Composite parent) {
            Composite composite = new Composite(parent, SWT.BORDER);
            composite.setLayout(new GridLayout(4, false));
            composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
            setControl(composite);

            Group serverGroup = new Group(composite, SWT.NORMAL);
            serverGroup.setText(Messages.Select_Server);
            serverGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
            serverGroup.setLayout(new GridLayout(2, false));
            // serverGroup.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_WHITE));

            txtServer = new Text(serverGroup, SWT.BORDER);
            txtServer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
            Button btnSel = new Button(serverGroup, SWT.PUSH);
            btnSel.setText("..."); //$NON-NLS-1$
            btnSel.setToolTipText(Messages.Select_Server);
            txtServer.setEnabled(false);

            btnSel.addSelectionListener(new SelectionAdapter() {

                /*
                 * (non-Javadoc)
                 * 
                 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
                 */
                @Override
                public void widgetSelected(SelectionEvent e) {
                    SelectServerDefDialog dlg = new SelectServerDefDialog(getShell());
                    if (dlg.open() == IDialogConstants.OK_ID) {
                        def = dlg.getSelectedServerDef();
                        txtServer.setText(def.getUrl());
                        checkCompleted();
                        String url = def.getUrl();
                        String user = def.getUser();
                        String password = def.getPasswd();
                        try {
                            // get Version
                            XtentisPort port;
                            port = Util.getPort(new URL(url), null, user, password);
                            WSUniversePK[] universePKs = port.getUniversePKs(new WSGetUniversePKs("*")).getWsUniversePK();//$NON-NLS-1$
                            CCombo universeCombo = comboVersion.getCombo();
                            universeCombo.removeAll();
                            universeCombo.add(""); //$NON-NLS-1$
                            if (universePKs != null && universePKs.length > 0) {
                                for (int i = 0; i < universePKs.length; i++) {
                                    String universe = universePKs[i].getPk();
                                    universeCombo.add(universe);
                                }
                            }
                            retriveServerRoot();
                        } catch (Exception e1) {
                            comboVersion.getCombo().removeAll();
                        }

                    }
                }
            });
            comboVersion = new LabelCombo(toolkit, serverGroup, Messages.Version, SWT.BORDER, 2);
            comboVersion.getCombo().setEditable(false);

            comboVersion.getCombo().addModifyListener(new ModifyListener() {

                public void modifyText(ModifyEvent e) {
                    // TODO Auto-generated method stub
                    def.setUniverse(comboVersion.getCombo().getText());
                    retriveServerRoot();

                }
            });
            toolkit.setBackGround((Composite) comboVersion.getComposite(), serverGroup.getBackground());
            // create viewer
            treeViewer = new RepositoryCheckTreeViewer((TreeParent) serverRoot);
            Composite itemcom = treeViewer.createItemList(composite);
            treeViewer.getViewer().setInput(null);
            itemcom.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 5));
            treeViewer.setItemText(Messages.Select_Items_To_Imports);
            treeViewer.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {

                public void selectionChanged(SelectionChangedEvent arg0) {
                    checkCompleted();
                }
            });
            btnOverwrite = new Button(composite, SWT.CHECK);
            btnOverwrite.setText(Messages.Overwrite_Exists_Items);
            // btnOverwrite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
            btnOverwrite.setSelection(true);
            GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(920, 600).applyTo(composite);
        }
    }
}
