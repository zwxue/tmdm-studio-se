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
package org.talend.mdm.webapp.synchronization2.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.talend.mdm.webapp.synchronization2.client.Synchronization2Service;
import org.talend.mdm.webapp.synchronization2.server.model.SynchronizationItem;
import org.talend.mdm.webapp.synchronization2.server.model.TreeNode;
import org.talend.mdm.webapp.synchronization2.shared.SynBaseModel;

import com.amalto.core.enterpriseutil.EnterpriseUtil;
import com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJO;
import com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJOPK;
import com.amalto.core.objects.synchronization.ejb.local.SynchronizationItemCtrlLocal;
import com.amalto.webapp.core.util.XConverter;
import com.amalto.webapp.util.webservices.WSGetSynchronizationItem;
import com.amalto.webapp.util.webservices.WSGetSynchronizationItemPKs;
import com.amalto.webapp.util.webservices.WSSynchronizationItem;
import com.amalto.webapp.util.webservices.WSSynchronizationItemPK;
import com.amalto.webapp.util.webservices.WSSynchronizationItemPKArray;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class Synchronization2ServiceImpl extends RemoteServiceServlet implements Synchronization2Service {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(Synchronization2ServiceImpl.class);

    public PagingLoadResult<SynBaseModel> getSyncItems(String regex, PagingLoadConfig load) throws Exception {

        List<SynchronizationItem> list = new ArrayList<SynchronizationItem>();

        WSSynchronizationItemPKArray pks = getSynchronizationItemPKs(new WSGetSynchronizationItemPKs(regex));
        WSSynchronizationItemPK[] items = pks.getWsSynchronizationItemPK();

        for (WSSynchronizationItemPK pk : items) {
            WSSynchronizationItem item = getSynchronizationItem(new WSGetSynchronizationItem(pk));
            if (item.getResolvedProjection() == null) {
                continue;
            }
            SynchronizationItem syncItem = new SynchronizationItem();
            syncItem = syncItem.WS2POJO(item);
            if (!syncItem.getItemPK().matches(regex)) {
                continue;
            }
            TreeNode node = new TreeNode();
            node = node.deserialize(item.getResolvedProjection());
            syncItem.setNode(node);
            list.add(syncItem);
        }

        List<SynBaseModel> resultList = new ArrayList<SynBaseModel>();
        for (SynchronizationItem item : list) {
            SynBaseModel model = new SynBaseModel();
            model.set("pk", item.getItemPOJOPK().toString()); //$NON-NLS-1$
            model.set("lri", item.getLocalRevisionID()); //$NON-NLS-1$
            model.set("lrsn", item.getLastRunPlan()); //$NON-NLS-1$
            model.set("status", item.getStatus()); //$NON-NLS-1$
            resultList.add(model);
        }

        return new BasePagingLoadResult<SynBaseModel>(resultList, load.getOffset(), list.size());
    }

    public WSSynchronizationItem getSynchronizationItem(WSGetSynchronizationItem wsGetSynchronizationItem) throws RemoteException {
        try {
            SynchronizationItemCtrlLocal ctrl = EnterpriseUtil.getSynchronizationItemCtrlLocal();
            SynchronizationItemPOJO pojo = ctrl.getSynchronizationItem(new SynchronizationItemPOJOPK(wsGetSynchronizationItem
                    .getWsSynchronizationItemPK().getIds()));
            return XConverter.POJO2WS(pojo);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new RemoteException(e.getLocalizedMessage(), e);
        }
    }

    public WSSynchronizationItemPKArray getSynchronizationItemPKs(WSGetSynchronizationItemPKs regex) throws RemoteException {
        try {
            SynchronizationItemCtrlLocal ctrl = EnterpriseUtil.getSynchronizationItemCtrlLocal();
            Collection<?> c = ctrl.getSynchronizationItemPKs(regex.getRegex());
            if (c == null)
                return null;
            WSSynchronizationItemPK[] pks = new WSSynchronizationItemPK[c.size()];
            int i = 0;
            for (Iterator<?> iter = c.iterator(); iter.hasNext();) {
                pks[i++] = new WSSynchronizationItemPK(((SynchronizationItemPOJOPK) iter.next()).getIds());
            }
            return new WSSynchronizationItemPKArray(pks);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new RemoteException(e.getLocalizedMessage(), e);
        }
    }
}
