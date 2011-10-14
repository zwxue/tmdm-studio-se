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
import org.talend.mdm.repository.model.mdmproperties.WSJobModelItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSJobModelE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Job Model Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSJobModelItemImpl#getWsJobModelItem <em>Ws Job Model Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSJobModelItemImpl extends MDMServerObjectItemImpl implements WSJobModelItem {
    /**
     * The cached value of the '{@link #getWsJobModelItem() <em>Ws Job Model Item</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWsJobModelItem()
     * @generated
     * @ordered
     */
    protected WSJobModelE wsJobModelItem;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSJobModelItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_JOB_MODEL_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSJobModelE getWsJobModelItem() {
        if (wsJobModelItem != null && wsJobModelItem.eIsProxy()) {
            InternalEObject oldWsJobModelItem = (InternalEObject)wsJobModelItem;
            wsJobModelItem = (WSJobModelE)eResolveProxy(oldWsJobModelItem);
            if (wsJobModelItem != oldWsJobModelItem) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM, oldWsJobModelItem, wsJobModelItem));
            }
        }
        return wsJobModelItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSJobModelE basicGetWsJobModelItem() {
        return wsJobModelItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWsJobModelItem(WSJobModelE newWsJobModelItem) {
        WSJobModelE oldWsJobModelItem = wsJobModelItem;
        wsJobModelItem = newWsJobModelItem;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM, oldWsJobModelItem, wsJobModelItem));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM:
                if (resolve) return getWsJobModelItem();
                return basicGetWsJobModelItem();
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
            case MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM:
                setWsJobModelItem((WSJobModelE)newValue);
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
            case MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM:
                setWsJobModelItem((WSJobModelE)null);
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
            case MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM:
                return wsJobModelItem != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject getMDMServerObject() {
        return getWsJobModelItem();
    }

} //WSJobModelItemImpl
