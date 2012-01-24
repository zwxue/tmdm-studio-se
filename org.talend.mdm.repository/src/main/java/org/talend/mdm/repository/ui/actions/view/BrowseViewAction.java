// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions.view;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.WSViewItem;
import org.talend.mdm.repository.model.mdmserverobject.WSViewE;
import org.talend.mdm.repository.ui.editors.XObjectBrowser2;
import org.talend.mdm.repository.ui.editors.XObjectBrowserInput2;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class BrowseViewAction extends AbstractRepositoryAction {

    private IWorkbenchPage page = null;

    private static Logger log = Logger.getLogger(BrowseViewAction.class);

    /**
     * DOC hbhong BrowseViewAction constructor comment.
     * 
     * @param text
     */
    public BrowseViewAction() {
        super(Messages.BrowseViewAction_label);
        setImageDescriptor(ImageCache.getImage(EImage.BROWSE.getPath()));
    }

    protected void doRun() {
        Object obj = getSelectedObject().get(0);
        if (obj instanceof IRepositoryViewObject) {
            IRepositoryViewObject viewObject = (IRepositoryViewObject) obj;
            WSViewItem item = (WSViewItem) viewObject.getProperty().getItem();
            WSViewE wsView = item.getWsView();
            MDMServerDef lastServerDef = wsView.getLastServerDef();
            SelectServerDefDialog dlg = new SelectServerDefDialog(getShell());
            dlg.create();
            dlg.setSelectServer(lastServerDef);
            if (dlg.open() == IDialogConstants.OK_ID) {
                XObjectBrowserInput2 input = new XObjectBrowserInput2(viewObject);
                input.setServerDef(dlg.getSelectedServerDef());
                if (page == null)
                    this.page = commonViewer.getCommonNavigator().getSite().getWorkbenchWindow().getActivePage();
                try {
                    this.page.openEditor(input, XObjectBrowser2.EDITOR_ID);
                } catch (PartInitException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    public String getGroupName() {
        return GROUP_EDIT;
    }

}
