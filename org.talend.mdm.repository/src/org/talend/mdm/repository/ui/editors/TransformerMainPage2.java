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

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.ui.forms.editor.FormEditor;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.ui.widgets.xmleditor.infoholder.RepositoryExternalInfoHolder;

import com.amalto.workbench.editors.TransformerMainPage;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSTransformerPluginV2SList;
import com.amalto.workbench.webservices.WSTransformerPluginV2SListItem;
import com.amalto.workbench.webservices.WSTransformerV2;
import com.amalto.workbench.widgets.xmleditor.infoholder.ExternalInfoHolder;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class TransformerMainPage2 extends TransformerMainPage {

    /**
     * DOC hbhong TransformerMainPage2 constructor comment.
     * 
     * @param editor
     */
    public TransformerMainPage2(FormEditor editor) {
        super(editor);
    }

    @Override
    protected void initExternalInfoHolder() {

        ExternalInfoHolder<?> allJobInfosHolder = RepositoryExternalInfoHolder.getAllJobInfosHolder(null);
        ExternalInfoHolder<?> mdmServerInfoHolder = RepositoryExternalInfoHolder.getAllMDMServerInfoHolder2(null);
        ExternalInfoHolder<?> allVarCandidatesHolder = RepositoryExternalInfoHolder
                .getProcessAllCallJobVarsCandidatesHolder((WSTransformerV2) getXObject().getWsObject());
        ExternalInfoHolder<?> workflowInfoHolder = RepositoryExternalInfoHolder.getAllWorkflowInfoHolder(null);
        ExternalInfoHolder<?> allDataModelHolderProxy = RepositoryExternalInfoHolder.getAllDataModelInfoHolderProxy(getXObject());

        initExternalInfoHolderForEachType("callJob", new ExternalInfoHolder<?>[] { allJobInfosHolder, mdmServerInfoHolder,
                allVarCandidatesHolder });
        initExternalInfoHolderForEachType("workflowtrigger", new ExternalInfoHolder<?>[] { workflowInfoHolder,
                allDataModelHolderProxy });

    }

    protected void initTransformer() throws XtentisException {
        TreeObject xObject = getXObject();
        transformer = (WSTransformerV2) xObject.getWsObject();
    }

    @Override
    protected void initPlugin() throws RemoteException {
        WSTransformerPluginV2SList list = RepositoryQueryService.getTransformerPluginV2SList("EN");//$NON-NLS-1$

        WSTransformerPluginV2SListItem[] items = list.getItem();

        if (items != null) {
            for (int i = 0; i < items.length; i++) {
                pluginDescriptions.put(items[i].getJndiName(), items[i].getDescription());
            }
            // get the sorted list and feed the combo
            Set<String> jndis = pluginDescriptions.keySet();
            for (Iterator<String> iterator = jndis.iterator(); iterator.hasNext();) {
                String jndi = iterator.next();
                pluginsCombo.add(jndi);
                // add input variables and output variables
                inputVariablesMap.put(jndi, RepositoryQueryService.getInputVariables(jndi));
                outputVariablesMap.put(jndi, RepositoryQueryService.getOutputVariables(jndi));
            }
        }
    }

}
