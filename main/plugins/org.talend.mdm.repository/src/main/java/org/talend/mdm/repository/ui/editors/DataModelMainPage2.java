// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
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

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.navigator.CommonViewer;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.ui.actions.xsd.XSDDefaultValueRuleActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDDeleteConceptActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDNewBrowseItemViewActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationFKFilterActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationForeignKeyActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationForeignKeyInfoActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationNoActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationWrapNoActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationWrapWriteActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationWriteActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDVisibleRuleActionR;
import org.talend.mdm.repository.ui.dialogs.SelectImportedModulesDialog2;
import org.talend.mdm.repository.ui.dialogs.datamodel.DataModelFilterDialogR;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.ui.wizards.view.AddBrowseItemsWizardR;
import org.talend.mdm.repository.utils.Bean2EObjUtil;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.actions.XSDDefaultValueRuleAction;
import com.amalto.workbench.actions.XSDDeleteConceptAction;
import com.amalto.workbench.actions.XSDSetAnnotationFKFilterAction;
import com.amalto.workbench.actions.XSDSetAnnotationForeignKeyAction;
import com.amalto.workbench.actions.XSDSetAnnotationForeignKeyInfoAction;
import com.amalto.workbench.actions.XSDSetAnnotationNoAction;
import com.amalto.workbench.actions.XSDSetAnnotationWrapNoAction;
import com.amalto.workbench.actions.XSDSetAnnotationWrapWriteAction;
import com.amalto.workbench.actions.XSDSetAnnotationWriteAction;
import com.amalto.workbench.actions.XSDVisibleRuleAction;
import com.amalto.workbench.dialogs.AddBrowseItemsWizard;
import com.amalto.workbench.dialogs.DataModelFilterDialog;
import com.amalto.workbench.dialogs.SelectImportedModulesDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSDataModel;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DataModelMainPage2 extends DataModelMainPage {

    private static Logger log = Logger.getLogger(DataModelMainPage2.class);

    private final IFile xsdFile;

    private boolean isGenView = false;

    /**
     * DOC hbhong DataModelMainPage2 constructor comment.
     *
     * @param obj
     */
    public DataModelMainPage2(TreeObject obj, IFile xsdFile) {
        super(obj);
        this.xsdFile = xsdFile;
    }

    @Override
    protected void doSave(WSDataModel wsObject) throws Exception {
        XObjectEditorInput2 editorInput = (XObjectEditorInput2) getEditorInput();

        if (isGenView && xsdFile != null) {
            String xsd = getXSDSchemaString();
            xsdFile.setCharset("utf-8", null);//$NON-NLS-1$
            xsdFile.setContents(new ByteArrayInputStream(xsd.getBytes("utf-8")), IFile.FORCE, null);//$NON-NLS-1$
        }

        MDMServerObjectItem serverObjectItem = (MDMServerObjectItem) editorInput.getInputItem();
        MDMServerObject serverObject = serverObjectItem.getMDMServerObject();
        EObject eObj = Bean2EObjUtil.getInstance().convertFromBean2EObj(wsObject, serverObject);
        if (eObj != null) {
            IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
            try {
            factory.save(serverObjectItem);
            } catch (PersistenceException e) {
                log.error(e.getMessage(), e);
            }
        }

        refreshDirtyCue();

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
        if (adapter == DataModelFilterDialog.class) {
            return new DataModelFilterDialogR(getSite().getShell(), xobject, dataModelFilter,
                    getSchemaElementNameFilterDesByTreeViewer(targetTreeViewer));
        }
        if (adapter == XSDDefaultValueRuleAction.class) {
            return new XSDDefaultValueRuleActionR(this, dataModelName);
        }
        if (adapter == XSDVisibleRuleAction.class) {
            return new XSDVisibleRuleActionR(this, dataModelName);
        }
        return super.getAdapter(adapter);
    }

    @Override
    protected void createNewBrowseItemViewAction() {
        this.newBrowseItemAction = new XSDNewBrowseItemViewActionR(this);
    }

    public void setGenView(boolean isGenView) {
        this.isGenView = isGenView;
    }

    @Override
    protected SelectImportedModulesDialog createSelectImportedModulesDialog() {
        return new SelectImportedModulesDialog2(getSite().getShell(), xsdSchema, xobject, Messages.ImportXSDSchema);
    }

    @Override
    protected void doImportSchema(List<String> addList, List<String> delList) {
        List<String> resolvedList = resolveAddList(addList);
        super.doImportSchema(resolvedList, delList);
    }

    private List<String> resolveAddList(List<String> addList) {
        List<String> result = new ArrayList<String>();
        for (String fileName : addList) {
            String fileProtocolPrefix = "file:///"; //$NON-NLS-1$
            if (fileName.startsWith(fileProtocolPrefix)) {
                fileName = fileName.replaceFirst(fileProtocolPrefix, ""); //$NON-NLS-1$
                result.add(fileName);
                continue;
            }

            String suffix = "/types"; //$NON-NLS-1$
            if (!fileName.endsWith(suffix)) {
                result.add(fileName);
                continue;
            }

            String name = fileName.substring(0, fileName.indexOf(suffix));
            IRepositoryViewObject viewObj = getViewObjForDataModel(name);
            String prjLabel = viewObj.getProjectLabel();

            String parentPath = buildParentPath(viewObj);
            String sep = "" + IPath.SEPARATOR; //$NON-NLS-1$

            fileName = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + sep + prjLabel.toUpperCase() + sep
                    + "MDM" + sep + "datamodel" + parentPath + viewObj.getLabel() + "_" + viewObj.getVersion() + ".xsd"; //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$

            result.add(fileName);
        }

        return result;
    }

    private String buildParentPath(IRepositoryViewObject viewObj) {
        String path = "" + IPath.SEPARATOR; //$NON-NLS-1$

        ItemState state = viewObj.getProperty().getItem().getState();
        String itemPath = state.getPath();
        if (!itemPath.isEmpty())
            path = itemPath + path;

        return path;
    }
    private IRepositoryViewObject getViewObjForDataModel(String name) {
        List<IRepositoryViewObject> vObjs = RepositoryResourceUtil.findAllViewObjects(IServerObjectRepositoryType.TYPE_DATAMODEL);
        IRepositoryViewObject theViewObj = null;
        for (IRepositoryViewObject obj : vObjs) {
            if (obj.getLabel().equals(name)) {
                theViewObj = obj;
            }
        }
        return theViewObj;
    }

}
