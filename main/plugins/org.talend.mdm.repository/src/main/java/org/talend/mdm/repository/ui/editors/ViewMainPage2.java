// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
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
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.ui.widgets.TisTableViewerR;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.editors.ViewMainPage;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSConceptKey;
import com.amalto.workbench.webservices.WSGetBusinessConceptKey;
import com.amalto.workbench.webservices.WSView;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;
import com.amalto.workbench.widgets.TisTableViewer;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ViewMainPage2 extends ViewMainPage {


    /**
     * DOC hbhong ViewMainPage2 constructor comment.
     * 
     * @param editor
     */
    public ViewMainPage2(FormEditor editor) {
        super(editor);
    }

    @Override
    protected void initProcessCombo() throws RemoteException, XtentisException {
        List<String> processNames = RepositoryQueryService.findAllProcessNames();
        cboProcessList.setItems(processNames.toArray(new String[0]));
    }

    @Override
    protected TisTableViewer getNewTisTableViewer(Composite parent, FormToolkit toolkit, List<ComplexTableViewerColumn> columns) {
        return new TisTableViewerR(columns, toolkit, parent);
    }

    @Override
    protected WSView getWsViewObject() {
        return (WSView) getXObject().getWsObject();
    }

    @Override
    protected List<String> getAvailableDataModel() {
        return RepositoryQueryService.getDataModel(null, concept);
    }

    @Override
    protected WSConceptKey getBusinessConceptKey(WSGetBusinessConceptKey businessConcepKey) throws RemoteException,
            XtentisException {
        return RepositoryResourceUtil.getBusinessConceptKey(businessConcepKey);
    }

}
