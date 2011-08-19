// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
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

import org.eclipse.emf.ecore.EObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.ui.wizards.workflow.GenerateWorkflowWizardR;
import org.talend.mdm.repository.utils.Bean2EObjUtil;
import org.talend.mdm.workbench.enterprice.dialog.GenerateWorkflowWizard;
import org.talend.repository.model.IProxyRepositoryFactory;

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
        EObject eObj = Bean2EObjUtil.getInstance().convertFromBean2EObj(wsObject, serverObject);
        if (eObj != null) {
            IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
            factory.save(serverObjectItem);
        }
    }

    @Override
    public Object getAdapter(Class cls) {
        if (cls == GenerateWorkflowWizard.class) {
            return new GenerateWorkflowWizardR(this);
        }
        return super.getAdapter(cls);
    }

}
