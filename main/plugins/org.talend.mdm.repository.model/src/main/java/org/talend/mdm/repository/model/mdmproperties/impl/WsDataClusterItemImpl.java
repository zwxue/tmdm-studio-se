/**
 * <copyright> </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;
import org.talend.mdm.repository.model.mdmproperties.WsDataClusterItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsDataClusterE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Data Cluster Item</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsDataClusterItemImpl#getWsDataCluster <em>Ws Data
 * Cluster</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsDataClusterItemImpl extends MDMServerObjectItemImpl implements WsDataClusterItem {

    /**
     * The cached value of the '{@link #getWsDataCluster() <em>Ws Data Cluster</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getWsDataCluster()
     * @generated
     * @ordered
     */
    protected WsDataClusterE wsDataCluster;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsDataClusterItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_DATA_CLUSTER_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public WsDataClusterE getWsDataCluster() {
        if (wsDataCluster != null && wsDataCluster.eIsProxy()) {
            InternalEObject oldWsDataCluster = (InternalEObject) wsDataCluster;
            wsDataCluster = (WsDataClusterE) eResolveProxy(oldWsDataCluster);
            if (wsDataCluster.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsDataCluster);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WsDataClusterE) {
                        wsDataCluster = (WsDataClusterE) object;
                        break;
                    }
                }
            }
            if (wsDataCluster != oldWsDataCluster) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER, oldWsDataCluster, wsDataCluster));
                }
            }
        }
        return wsDataCluster;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsDataClusterE basicGetWsDataCluster() {
        return wsDataCluster;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWsDataCluster(WsDataClusterE newWsDataCluster) {
        WsDataClusterE oldWsDataCluster = wsDataCluster;
        wsDataCluster = newWsDataCluster;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER,
                    oldWsDataCluster, wsDataCluster));
        }
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsDataCluster((WsDataClusterE) serverObj);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER:
            if (resolve) {
                return getWsDataCluster();
            }
            return basicGetWsDataCluster();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER:
            setWsDataCluster((WsDataClusterE) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER:
            setWsDataCluster((WsDataClusterE) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER:
            return wsDataCluster != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsDataCluster();
    }

} // WsDataClusterItemImpl
