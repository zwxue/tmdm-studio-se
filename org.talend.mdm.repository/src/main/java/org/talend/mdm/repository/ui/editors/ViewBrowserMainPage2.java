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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.ui.forms.editor.FormEditor;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;

import com.amalto.workbench.editors.ViewBrowserMainPage;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ViewBrowserMainPage2 extends ViewBrowserMainPage {

    private static Logger log = Logger.getLogger(ViewBrowserMainPage2.class);

    /**
     * DOC hbhong ViewBrowserMainPage2 constructor comment.
     *
     * @param editor
     */
    public ViewBrowserMainPage2(FormEditor editor) {
        super(editor);
    }

    @Override
    protected List<WSDataClusterPK> getDataClusterPKs() throws MalformedURLException, XtentisException {
        MDMServerDef d = getServerDef();
        return Util.getAllDataClusterPKs(new URL(d.getUrl()), d.getUniverse(), d.getUser(), d.getPasswd());
    }

    private MDMServerDef getServerDef() {
        ViewBrowserInput input = (ViewBrowserInput) getEditorInput();
        return input.getServerDef();
    }

    @Override
    protected WSViewPK getViewPK() {

        return new WSViewPK((String) getXObject().getWsKey());
    }

    @Override
    protected XtentisPort getPort() {
        try {
            MDMServerDef serverDef = getServerDef();
            return RepositoryWebServiceAdapter.getXtentisPort(serverDef);
        } catch (XtentisException e) {
            log.error(e.getMessage(), e);

        }
        return null;
    }

}
