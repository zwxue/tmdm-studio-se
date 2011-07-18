/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;
import org.talend.mdm.repository.model.mdmproperties.WSDataClusterItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSDataClusterE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Data Cluster Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSDataClusterItemImpl#getWsDataCluster <em>Ws Data Cluster</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSDataClusterItemImpl extends MDMServerObjectItemImpl implements WSDataClusterItem {
    /**
     * The cached value of the '{@link #getWsDataCluster() <em>Ws Data Cluster</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWsDataCluster()
     * @generated
     * @ordered
     */
    protected WSDataClusterE wsDataCluster;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSDataClusterItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_DATA_CLUSTER_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSDataClusterE getWsDataCluster() {
        if (wsDataCluster != null && wsDataCluster.eIsProxy()) {
            InternalEObject oldWsDataCluster = (InternalEObject)wsDataCluster;
            wsDataCluster = (WSDataClusterE)eResolveProxy(oldWsDataCluster);
            if (wsDataCluster != oldWsDataCluster) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER, oldWsDataCluster, wsDataCluster));
            }
        }
        return wsDataCluster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSDataClusterE basicGetWsDataCluster() {
        return wsDataCluster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWsDataCluster(WSDataClusterE newWsDataCluster) {
        WSDataClusterE oldWsDataCluster = wsDataCluster;
        wsDataCluster = newWsDataCluster;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER, oldWsDataCluster, wsDataCluster));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER:
                if (resolve) return getWsDataCluster();
                return basicGetWsDataCluster();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER:
                setWsDataCluster((WSDataClusterE)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER:
                setWsDataCluster((WSDataClusterE)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
    public MDMServerObject getMDMServerObject() {
        return getWsDataCluster();
    }

} //WSDataClusterItemImpl
