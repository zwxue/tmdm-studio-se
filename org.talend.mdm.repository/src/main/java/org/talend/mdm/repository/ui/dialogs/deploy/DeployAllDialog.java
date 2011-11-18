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
package org.talend.mdm.repository.ui.dialogs.deploy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryObject;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.ui.actions.RemoveFromRepositoryAction;
import org.talend.mdm.repository.ui.widgets.RepositoryViewObjectCheckedWidget;
import org.talend.mdm.repository.utils.Bean2EObjUtil;
import org.talend.mdm.workbench.serverexplorer.core.ServerDefService;

import com.amalto.workbench.models.TreeObject;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployAllDialog extends Dialog {

    private final Set<IRepositoryViewObject> changedViewObjs;

    private final Object input;

    private Combo combo;

    private MDMServerDef theServerDef;

    private String comboServerName;


    /**
     * Create the dialog.
     * 
     * @param parentShell
     */
    public DeployAllDialog(Shell parentShell, Object input, Set<IRepositoryViewObject> changedViewObjs) {
        super(parentShell);
        this.input = input;
        this.changedViewObjs = changedViewObjs;
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }

    public DeployAllDialog(Shell parentShell, Object input, Set<IRepositoryViewObject> changedViewObjs, String name) {
        super(parentShell);
        this.input = input;
        this.changedViewObjs = changedViewObjs;
        this.comboServerName = name;
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }
    /**
     * Create contents of the dialog.
     * 
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container1 = (Composite) super.createDialogArea(parent);
        GridLayout gridLayout = (GridLayout) container1.getLayout();
        container1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        gridLayout.numColumns = 1;
        
        Label lblNewLabel_selserver = new Label(container1, SWT.NONE);
        lblNewLabel_selserver.setText(Messages.DeployAllDialog_label_selectserver);

        combo = new Combo(container1, SWT.DROP_DOWN | SWT.READ_ONLY);
        GridData data = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 2);
        data.widthHint = 400;
        combo.setLayoutData(data);

        final List<MDMServerDef> serverDefs = new ArrayList<MDMServerDef>();
        List<IRepositoryViewObject> viewObjects = ServerDefService.getAllServerDefViewObjects();
        List<String> itemsLabel = new ArrayList<String>();
        for (IRepositoryViewObject object : viewObjects) {
            if (object instanceof IRepositoryObject) {
                MDMServerDefItem mdmItem = getMDMItem((IRepositoryViewObject) object);
                if (mdmItem != null) {
                    MDMServerDef serverDef = mdmItem.getServerDef();
                    String label = serverDef.getName() + " (" + serverDef.getHost() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
                    itemsLabel.add(label);
                    serverDefs.add(serverDef);
                }
            }
        }
        int size = itemsLabel.size();
        combo.setItems((String[]) itemsLabel.toArray(new String[size]));
        combo.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                theServerDef = serverDefs.get(combo.getSelectionIndex());
            }
        });

        if (comboServerName != null && comboServerName.trim().length() > 0) {
            for (int index = 0; index < serverDefs.size(); index++) {
                if (serverDefs.get(index).getName().equals(comboServerName)) {
                    combo.select(index);
                    theServerDef = serverDefs.get(index);
                }
            }
        } else {
            if (serverDefs.size() > 0) {
                combo.select(0);
                theServerDef = serverDefs.get(0);
            }
        }
        Composite container = new Composite(container1, SWT.BORDER);
        container.setLayout(new GridLayout(2, false));
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        Label lblNewLabel = new Label(container, SWT.NONE);
        lblNewLabel.setText(Messages.DeployAllDialog_label);
        new Label(container, SWT.NONE);
        restoreDeleteObjectsTreeView((IRepositoryViewObject[]) input);
        treeViewer = new RepositoryViewObjectCheckedWidget(container, input, changedViewObjs);
        treeViewer.addCheckStateListener(new ICheckStateListener() {
            public void checkStateChanged(CheckStateChangedEvent event) {
                // enableOkBun();
            }
        });
        treeViewer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
        Button selAllButton = new Button(container, SWT.NONE);
        selAllButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                treeViewer.selectAll(true);
            }
        });
        selAllButton.setText(Messages.DeployAllDialog_selectAll);
        Button deselAllBun = new Button(container, SWT.NONE);
        deselAllBun.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
        deselAllBun.setText(Messages.DeployAllDialog_deselectAll);
        deselAllBun.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                treeViewer.selectAll(false);
            }
        });
        return container;
    }
    
    private void restoreDeleteObjectsTreeView(IRepositoryViewObject[] theInput) {

        for (IRepositoryViewObject viewObj : RemoveFromRepositoryAction.getViewObjectsRemovedList()) {
            Item item = viewObj.getProperty().getItem();
            MDMServerObject serverObj = ((MDMServerObjectItem) item).getMDMServerObject();
            TreeObject treeObj = Bean2EObjUtil.getInstance().wrapEObjWithTreeObject(serverObj);
            viewObj.getRepositoryObjectType();

            switch (treeObj.getType()) {
            case TreeObject.DATA_MODEL:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_DATAMODEL).getChildren().add(viewObj);
                break;
            case TreeObject.DATA_CLUSTER:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_DATACLUSTER).getChildren().add(viewObj);
                break;
            case TreeObject.MENU:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_MENU).getChildren().add(viewObj);
                break;
            case TreeObject.ROUTING_RULE:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_EVENTMANAGER).getChildren().get(1).getChildren()
                        .add(viewObj);
                break;
            case TreeObject.ROLE:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_ROLE).getChildren().add(viewObj);
                break;
            case TreeObject.SERVICE_CONFIGURATION:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_SERVICECONFIGURATION).getChildren().add(viewObj);
                break;
            case TreeObject.STORED_PROCEDURE:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_STOREPROCEDURE).getChildren().add(viewObj);
                break;
            case TreeObject.TRANSFORMER:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_EVENTMANAGER).getChildren().get(0).getChildren()
                        .add(viewObj);
                break;
            case TreeObject.UNIVERSE:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_UNIVERSE).getChildren().add(viewObj);
                break;
            case TreeObject.VIEW:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_VIEW).getChildren().add(viewObj);
                break;
            case TreeObject.SYNCHRONIZATIONPLAN:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_SYNCHRONIZATIONPLAN).getChildren().add(viewObj);
                break;
            default:
                ;
            }
        }
    }

    public IRepositoryViewObject getViewObjectByType(IRepositoryViewObject[] theInput, ERepositoryObjectType type) {
        for (IRepositoryViewObject viewObj : theInput) {
            if (viewObj.getRepositoryObjectType().equals(type)) {
                return viewObj;
            }
        }
        return null;
    }

    /**
     * Create contents of the button bar.
     * 
     * @param parent
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        okBun = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    /**
     * Return the initial size of the dialog.
     */
    @Override
    protected Point getInitialSize() {
        // return new Point(450, 300);
        return new Point(450, 500);
    }

    List<IRepositoryViewObject> selectededViewObjs;

    private RepositoryViewObjectCheckedWidget treeViewer;

    private Button okBun;

    public List<IRepositoryViewObject> getSelectededViewObjs() {
        return this.selectededViewObjs;
    }

    @Override
    protected void okPressed() {
        selectededViewObjs = treeViewer.getSelectededViewObjs();
        if (!doCheck()) {
            return;
        }
        super.okPressed();
    }


    private boolean doCheck() {

        if (combo.getSelectionIndex() == -1) {
            MessageDialog.openWarning(getShell(), "Warning", "Please choose a server for deploy");
            return false;
        }

        return true;

    }

    private void enableOkBun() {
        okBun.setEnabled(treeViewer.getSelectededViewObjs().size() > 0);
    }

    private MDMServerDefItem getMDMItem(IRepositoryViewObject viewObject) {
        if (viewObject != null) {
            return (MDMServerDefItem) (viewObject.getProperty().getItem());
        }
        return null;
    }

    public MDMServerDef getTheServerDef() {
        return this.theServerDef;
    }

}
