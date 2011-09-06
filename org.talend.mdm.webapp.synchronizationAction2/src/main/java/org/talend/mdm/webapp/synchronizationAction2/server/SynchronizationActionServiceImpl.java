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
package org.talend.mdm.webapp.synchronizationAction2.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.talend.mdm.commmon.util.core.MDMConfiguration;
import org.talend.mdm.webapp.synchronizationAction2.client.SynchronizationActionService;
import org.talend.mdm.webapp.synchronizationAction2.client.common.SynchronizationActionException;
import org.talend.mdm.webapp.synchronizationAction2.client.model.ItemBaseModel;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncInfo;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncStatus;

import com.amalto.webapp.core.util.Util;
import com.amalto.webapp.util.webservices.WSGetSynchronizationPlanPKs;
import com.amalto.webapp.util.webservices.WSSynchronizationPlanAction;
import com.amalto.webapp.util.webservices.WSSynchronizationPlanActionCode;
import com.amalto.webapp.util.webservices.WSSynchronizationPlanPK;
import com.amalto.webapp.util.webservices.WSSynchronizationPlanPKArray;
import com.amalto.webapp.util.webservices.WSSynchronizationPlanStatus;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class SynchronizationActionServiceImpl extends RemoteServiceServlet implements SynchronizationActionService {

    public static final String SAVED_SERVER_URL = "save.server.url"; //$NON-NLS-1$

    public static final String SERVER_URL_DEFAULT = "http://localhost:8080/talend/TalendPort"; //$NON-NLS-1$

    private static final Logger logger = Logger.getLogger(SynchronizationActionServiceImpl.class);

    public List<ItemBaseModel> getSyncNames(SyncInfo info) throws SynchronizationActionException {

        try {
            WSSynchronizationPlanPKArray array = Util.getPort(info.getServerURL(), info.getUsername(), info.getPassword(),
                    Util._FORCE_WEB_SERVICE_).getSynchronizationPlanPKs(new WSGetSynchronizationPlanPKs(".*")); //$NON-NLS-1$
            WSSynchronizationPlanPK[] pks = array.getWsSynchronizationPlanPK();
            List<ItemBaseModel> syncNames = new ArrayList<ItemBaseModel>();
            if (pks != null && pks.length > 0) {
                if (logger.isDebugEnabled())
                    logger.debug("pks:" + pks.length); //$NON-NLS-1$           
                for (int i = 0; i < pks.length; i++) {
                    ItemBaseModel model = new ItemBaseModel();
                    model.set("id", pks[i].getPk()); //$NON-NLS-1$
                    model.set("name", pks[i].getPk()); //$NON-NLS-1$
                    syncNames.add(model);
                }
                if (logger.isDebugEnabled())
                    logger.debug("getSyncNames() syncNames:" + syncNames); //$NON-NLS-1$
            }
            return syncNames;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SynchronizationActionException(e.getLocalizedMessage(), e);
        }
    }

    public void startFull(SyncInfo info) throws Exception {
        try {
            Util.getPort(info.getServerURL(), info.getUsername(), info.getPassword(), Util._FORCE_WEB_SERVICE_)
                    .synchronizationPlanAction(
                            new WSSynchronizationPlanAction(new WSSynchronizationPlanPK(info.getSyncName()),
                                    WSSynchronizationPlanActionCode.START_FULL));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SynchronizationActionException(e.getLocalizedMessage(), e);
        }
    }

    public void startDifferent(SyncInfo info) throws Exception {
        try {

            Util.getPort(info.getServerURL(), info.getUsername(), info.getPassword(), Util._FORCE_WEB_SERVICE_)
                    .synchronizationPlanAction(
                            new WSSynchronizationPlanAction(new WSSynchronizationPlanPK(info.getSyncName()),
                                    WSSynchronizationPlanActionCode.START_DIFFERENTIAL));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SynchronizationActionException(e.getLocalizedMessage(), e);
        }
    }

    public void stop(SyncInfo info) throws Exception {
        try {

            Util.getPort(info.getServerURL(), info.getUsername(), info.getPassword(), Util._FORCE_WEB_SERVICE_)
                    .synchronizationPlanAction(
                            new WSSynchronizationPlanAction(new WSSynchronizationPlanPK(info.getSyncName()),
                                    WSSynchronizationPlanActionCode.STOP));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SynchronizationActionException(e.getLocalizedMessage(), e);
        }
    }

    public void reset(SyncInfo info) throws Exception {
        try {

            Util.getPort(info.getServerURL(), info.getUsername(), info.getPassword(), Util._FORCE_WEB_SERVICE_)
                    .synchronizationPlanAction(
                            new WSSynchronizationPlanAction(new WSSynchronizationPlanPK(info.getSyncName()),
                                    WSSynchronizationPlanActionCode.RESET));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SynchronizationActionException(e.getLocalizedMessage(), e);
        }
    }

    public SyncStatus getStatus(SyncInfo info) throws Exception {
        WSSynchronizationPlanStatus wsStatus = null;
        try {
            wsStatus = Util.getPort(info.getServerURL(), info.getUsername(), info.getPassword(), Util._FORCE_WEB_SERVICE_)
                    .synchronizationPlanAction(
                            new WSSynchronizationPlanAction(new WSSynchronizationPlanPK(info.getSyncName()),
                                    WSSynchronizationPlanActionCode.STATUS));
            SyncStatus status = new SyncStatus();
            status.setValue(wsStatus.getWsStatusCode().getValue());
            status.setMessage(wsStatus.getStatusMessage());
            return status;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SynchronizationActionException(e.getLocalizedMessage(), e);
        }
    }

    public List<ItemBaseModel> getSavedURLs() throws Exception {
        String[] urls = new String[] { SERVER_URL_DEFAULT };
        try {
            Properties configure = MDMConfiguration.getConfiguration();
            String url = configure.getProperty(SAVED_SERVER_URL);
            if (url != null) {
                urls = url.split(";"); //$NON-NLS-1$
            }
            Arrays.sort(urls);
            List<ItemBaseModel> items = new ArrayList<ItemBaseModel>();
            for (String id : urls) {
                ItemBaseModel item = new ItemBaseModel();
                item.set("id", id); //$NON-NLS-1$
                item.set("name", id); //$NON-NLS-1$
                items.add(item);
            }

            return items;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SynchronizationActionException(e.getLocalizedMessage(), e);
        }

    }

    public void saveURLs(String url) throws Exception {
        if (logger.isDebugEnabled())
            logger.debug("saveURLs()---- url ==" + url); //$NON-NLS-1$
        try {

            String[] urls = url.split(";"); //$NON-NLS-1$
            if (urls.length == 0)
                return;
            Properties configure = MDMConfiguration.getConfiguration();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < urls.length; i++) {
                if (i < urls.length - 1)
                    sb.append(urls[i]).append(";"); //$NON-NLS-1$
                else
                    sb.append(urls[i]);
            }
            configure.setProperty(SAVED_SERVER_URL, sb.toString());

            MDMConfiguration.save();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SynchronizationActionException(e.getLocalizedMessage(), e);
        }
    }
}
