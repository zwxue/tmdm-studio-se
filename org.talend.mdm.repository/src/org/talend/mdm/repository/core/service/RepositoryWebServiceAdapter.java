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
package org.talend.mdm.repository.core.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.AbstractPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.BatchProjectPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.CSVParserPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.CodeProjectPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.CrossReferencingPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.DumpAndGoPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.FixedLengthParserPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.GroovyPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.GroupedLinesReaderPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.LineReaderPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.PartialUpdatePluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.ProjectPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.RegexpPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.ReplacePluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.RoutePluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.TISCallJobPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.WorkflowTriggerPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.XPathPluginDetail;
import org.talend.mdm.repository.core.service.wsimpl.transformplugin.XSLTPluginDetail;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSTransformerPluginV2Details;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryWebServiceAdapter {

    private static Logger log = Logger.getLogger(RepositoryWebServiceAdapter.class);

    private static Map<String, AbstractPluginDetail> transformerPluginMap;

    public static XtentisPort getXtentisPort(MDMServerDef serverDef) throws XtentisException {
        try {
            if (serverDef == null)
                return null;
            return Util.getPort(new URL(serverDef.getUrl()), serverDef.getUniverse(), serverDef.getUser(), serverDef.getPasswd());
        } catch (MalformedURLException e) {
            throw new XtentisException(Messages.bind(Messages.RepositoryWebServiceAdapter_InvalidEndpointAddress,
                    serverDef.getUrl()));
        }
    }

    public static XtentisPort getXtentisPort(Shell shell) {
        SelectServerDefDialog dialog = new SelectServerDefDialog(shell);
        try {
            if (dialog.open() == IDialogConstants.OK_ID) {
                MDMServerDef serverDef = dialog.getSelectedServerDef();
                return RepositoryWebServiceAdapter.getXtentisPort(serverDef);
            }
        } catch (XtentisException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static WSTransformerPluginV2Details findTransformerPluginV2Detail(String jndiName) {
        if (jndiName == null)
            return null;
        initTransformerPluginDetails();
        return transformerPluginMap.get(jndiName);
    }

    public static Collection<AbstractPluginDetail> findAllTransformerPluginV2Details() {
        initTransformerPluginDetails();
        return transformerPluginMap.values();
    }

    private static void initTransformerPluginDetails() {
        if (transformerPluginMap == null) {
            transformerPluginMap = new LinkedHashMap<String, AbstractPluginDetail>();
            String twoLettersLanguageCode = "en"; //$NON-NLS-1$
            addDetail(transformerPluginMap, new BatchProjectPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new CodeProjectPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new CrossReferencingPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new CSVParserPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new DumpAndGoPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new FixedLengthParserPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new GroovyPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new GroupedLinesReaderPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new LineReaderPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new PartialUpdatePluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new ProjectPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new RegexpPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new ReplacePluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new RoutePluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new TISCallJobPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new WorkflowTriggerPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new XPathPluginDetail(twoLettersLanguageCode));
            addDetail(transformerPluginMap, new XSLTPluginDetail(twoLettersLanguageCode));
        }
    }

    private static void addDetail(Map<String, AbstractPluginDetail> map, AbstractPluginDetail detail) {
        map.put(detail.getJNDIName(), detail);
    }
}
