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
package org.talend.mdm.repository.ui.editors;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.forms.editor.FormEditor;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;

import com.amalto.workbench.editors.RoutingEngineV2BrowserMainPage;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSRoutingEngineV2Status;
import com.amalto.workbench.webservices.XtentisPort;

public class RoutingEngineV2BrowserMainPage2 extends RoutingEngineV2BrowserMainPage {

    private static Logger log = Logger.getLogger(RoutingEngineV2BrowserMainPage2.class);
    public RoutingEngineV2BrowserMainPage2(FormEditor editor) {
        super(editor);
    }

    private MDMServerDef getServerDef() {
        XObjectBrowserInput2 input = (XObjectBrowserInput2) getEditorInput();
        return input.getServerDef();
    }

    protected XtentisPort getPort() {
        try {
            MDMServerDef serverDef = getServerDef();
            return RepositoryWebServiceAdapter.getXtentisPort(serverDef);
        } catch (XtentisException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

	@Override
	protected void refreshData() {
		try {
			WSRoutingEngineV2Status status = getServerRoutingStatus();
			statusLabel.setText(status.getValue());
			idText.setFocus();

		} catch (Exception e) {
			MDMServerDef serverDef = ((XObjectBrowserInput2) getEditorInput())
					.getServerDef();
			updateButtons();
			log.error(e.getMessage(), e);
			MessageDialog
					.openError(
							this.getSite().getShell(),
							com.amalto.workbench.i18n.Messages.RoutingEngineV2BrowserMainPage_ErrorRefreshingPage,
							Messages.bind(Messages.Server_cannot_connected,
									serverDef.getName()));
		}
	}
}
