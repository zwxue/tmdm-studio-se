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
import org.talend.mdm.repository.model.mdmproperties.WSEventManagerItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSEventManagerE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Event Manager Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSEventManagerItemImpl#getWsEventManager <em>Ws Event Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSEventManagerItemImpl extends MDMServerObjectItemImpl implements WSEventManagerItem {
    /**
     * The cached value of the '{@link #getWsEventManager() <em>Ws Event Manager</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWsEventManager()
     * @generated
     * @ordered
     */
    protected WSEventManagerE wsEventManager;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSEventManagerItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_EVENT_MANAGER_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSEventManagerE getWsEventManager() {
        if (wsEventManager != null && wsEventManager.eIsProxy()) {
            InternalEObject oldWsEventManager = (InternalEObject)wsEventManager;
            wsEventManager = (WSEventManagerE)eResolveProxy(oldWsEventManager);
            if (wsEventManager != oldWsEventManager) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER, oldWsEventManager, wsEventManager));
            }
        }
        return wsEventManager;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSEventManagerE basicGetWsEventManager() {
        return wsEventManager;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWsEventManager(WSEventManagerE newWsEventManager) {
        WSEventManagerE oldWsEventManager = wsEventManager;
        wsEventManager = newWsEventManager;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER, oldWsEventManager, wsEventManager));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER:
                if (resolve) return getWsEventManager();
                return basicGetWsEventManager();
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
            case MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER:
                setWsEventManager((WSEventManagerE)newValue);
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
            case MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER:
                setWsEventManager((WSEventManagerE)null);
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
            case MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER:
                return wsEventManager != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject getMDMServerObject() {
        return getWsEventManager();
    }

} //WSEventManagerItemImpl
