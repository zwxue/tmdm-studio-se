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
package org.talend.mdm.repository.ui.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonViewer;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.core.service.DeployService.DeployStatus;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.ui.actions.xsd.XSDDeleteConceptActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationFKFilterActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationForeignKeyActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationForeignKeyInfoActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationNoActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationWrapNoActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationWrapWriteActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationWriteActionR;
import org.talend.mdm.repository.ui.dialogs.message.MutliStatusDialog;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.ui.preferences.PreferenceConstants;
import org.talend.mdm.repository.ui.wizards.view.AddBrowseItemsWizardR;
import org.talend.mdm.repository.utils.Bean2EObjUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.actions.XSDDeleteConceptAction;
import com.amalto.workbench.actions.XSDSetAnnotationFKFilterAction;
import com.amalto.workbench.actions.XSDSetAnnotationForeignKeyAction;
import com.amalto.workbench.actions.XSDSetAnnotationForeignKeyInfoAction;
import com.amalto.workbench.actions.XSDSetAnnotationNoAction;
import com.amalto.workbench.actions.XSDSetAnnotationWrapNoAction;
import com.amalto.workbench.actions.XSDSetAnnotationWrapWriteAction;
import com.amalto.workbench.actions.XSDSetAnnotationWriteAction;
import com.amalto.workbench.dialogs.AddBrowseItemsWizard;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSDataModel;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DataModelMainPage2 extends DataModelMainPage {

    /**
     * DOC hbhong DataModelMainPage2 constructor comment.
     * 
     * @param obj
     */
    public DataModelMainPage2(TreeObject obj) {
        super(obj);
    }

    @Override
    protected void doSave(WSDataModel wsObject) throws Exception {
        XObjectEditorInput2 editorInput = (XObjectEditorInput2) getEditorInput();

        MDMServerObjectItem serverObjectItem = (MDMServerObjectItem) editorInput.getInputItem();
        MDMServerObject serverObject = serverObjectItem.getMDMServerObject();
        EObject eContainer = serverObject.eContainer();
        EObject eObj = Bean2EObjUtil.getInstance().convertFromBean2EObj(wsObject, serverObject);
        if (eObj != null) {
            serverObject.setChanged(true);
            IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
            factory.save(serverObjectItem);
        }

        refreshDirtyCue();
        if (PlatformUI.getPreferenceStore().getBoolean(PreferenceConstants.P_AUTO_DEPLOY)) {
            autoDeploy(serverObject);
        }
    }

    private void autoDeploy(MDMServerObject serverObject) {
        IEditorInput input = getEditorInput();
        XObjectEditorInput2 theInput = null;
        if (input instanceof XObjectEditorInput2) {
            theInput = (XObjectEditorInput2) input;
        }
        IRepositoryViewObject viewObj = theInput.getViewObject();
        if (serverObject.getLastServerDef() != null) {
            List<IRepositoryViewObject> viewObjs = new ArrayList<IRepositoryViewObject>();
            viewObjs.add(viewObj);
            IStatus status = DeployService.getInstance().deploy(serverObject.getLastServerDef(), viewObjs);

            updateChangedStatus(status);
            if (status.isMultiStatus()) {
                showDeployStatus(status);
            }
        } else {
            MessageDialog.openWarning(getSite().getShell(), Messages.Warning_text, Messages.TheObject_text + " " //$NON-NLS-1$
                    + viewObj.getLabel() + " " + Messages.NeverDeploy_text);//$NON-NLS-1$
        }
    }

    protected void updateChangedStatus(IStatus status) {
        if (status.isMultiStatus()) {
            for (IStatus childStatus : status.getChildren()) {
                DeployService.DeployStatus deployStatus = (DeployStatus) childStatus;
                if (deployStatus.isOK()) {
                    if (deployStatus.getItem() instanceof MDMServerObjectItem) {
                        MDMServerObjectItem item = (MDMServerObjectItem) deployStatus.getItem();
                        MDMServerObject mdmServerObject = item.getMDMServerObject();
                        mdmServerObject.setChanged(false);
                    }
                }
            }
        }
    }

    protected void showDeployStatus(IStatus status) {
        MutliStatusDialog dialog = new MutliStatusDialog(getSite().getShell(), status.getChildren().length
                + Messages.AbstractDeployAction_deployMessage, status);
        dialog.open();
    }

    private void refreshDirtyCue() {
        IEditorInput input = getEditorInput();
        XObjectEditorInput2 theInput = null;
        if (input instanceof XObjectEditorInput2) {
            theInput = (XObjectEditorInput2) input;
        }
        IRepositoryViewObject viewObj = theInput.getViewObject();
        CommonViewer viewer = MDMRepositoryView.show().getCommonViewer();
        viewer.refresh(viewObj);
    }

    @Override
    public Object getAdapter(Class adapter) {

        if (adapter == AddBrowseItemsWizard.class) {
            return new AddBrowseItemsWizardR(this);
        }
        if (adapter == XSDSetAnnotationWriteAction.class) {
            return new XSDSetAnnotationWriteActionR(this);
        }

        if (adapter == XSDSetAnnotationNoAction.class) {
            return new XSDSetAnnotationNoActionR(this, dataModelName);
        }
        if (adapter == XSDSetAnnotationWrapWriteAction.class) {
            return new XSDSetAnnotationWrapWriteActionR(this);
        }
        if (adapter == XSDSetAnnotationWrapNoAction.class) {
            return new XSDSetAnnotationWrapNoActionR(this, dataModelName);
        }
        if (adapter == XSDSetAnnotationForeignKeyAction.class) {
            return new XSDSetAnnotationForeignKeyActionR(this, dataModelName);
        }
        if (adapter == XSDSetAnnotationForeignKeyInfoAction.class) {
            return new XSDSetAnnotationForeignKeyInfoActionR(this, dataModelName);
        }
        if (adapter == XSDSetAnnotationFKFilterAction.class) {
            return new XSDSetAnnotationFKFilterActionR(this, dataModelName);
        }
        if (adapter == XSDDeleteConceptAction.class) {
            return new XSDDeleteConceptActionR(this);
        }
        return super.getAdapter(adapter);
    }

}
