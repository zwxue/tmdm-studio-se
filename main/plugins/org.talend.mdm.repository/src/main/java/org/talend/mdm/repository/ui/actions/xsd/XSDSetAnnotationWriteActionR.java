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
package org.talend.mdm.repository.ui.actions.xsd;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.dialogs.xsd.AnnotationOrderedListsDialogR;

import com.amalto.workbench.actions.XSDSetAnnotationWriteAction;
import com.amalto.workbench.dialogs.AnnotationOrderedListsDialog;
import com.amalto.workbench.editors.DataModelMainPage;


/**
 * DOC hbhong  class global comment. Detailled comment
 */
public class XSDSetAnnotationWriteActionR extends XSDSetAnnotationWriteAction {

    /**
     * DOC hbhong XSDSetAnnotationWriteActionR constructor comment.
     * 
     * @param page
     */
    public XSDSetAnnotationWriteActionR(DataModelMainPage page) {
        super(page);
    }

    @Override
    protected AnnotationOrderedListsDialog getNewAnnotaionOrderedListsDialog(Collection<String> values) {
        return new AnnotationOrderedListsDialogR(new ArrayList(values), new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                dlg.close();
            }
        }, page.getSite().getShell(), Messages.XSDSetAnnotationWriteActionR_title, Messages.XSDSetAnnotationRoles, page,
                AnnotationOrderedListsDialog.AnnotationWrite_ActionType, null);
    }

}
