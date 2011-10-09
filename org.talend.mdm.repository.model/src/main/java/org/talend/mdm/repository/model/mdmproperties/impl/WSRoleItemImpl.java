/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;
import org.talend.mdm.repository.model.mdmproperties.WSRoleItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>WS Role Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSRoleItemImpl#getWsRole <em>Ws Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSRoleItemImpl extends MDMServerObjectItemImpl implements WSRoleItem {

    /**
     * The cached value of the '{@link #getWsRole() <em>Ws Role</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getWsRole()
     * @generated
     * @ordered
     */
    protected WSRoleE wsRole;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected WSRoleItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_ROLE_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public WSRoleE getWsRole() {
        if (wsRole != null && wsRole.eIsProxy()) {
            InternalEObject oldWsRole = (InternalEObject)wsRole;
            wsRole = (WSRoleE)eResolveProxy(oldWsRole);
            if (wsRole != oldWsRole) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE, oldWsRole, wsRole));
            }
        }
        return wsRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public WSRoleE basicGetWsRole() {
        return wsRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setWsRole(WSRoleE newWsRole) {
        WSRoleE oldWsRole = wsRole;
        wsRole = newWsRole;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE, oldWsRole, wsRole));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE:
                if (resolve) return getWsRole();
                return basicGetWsRole();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE:
                setWsRole((WSRoleE)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE:
                setWsRole((WSRoleE)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE:
                return wsRole != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject getMDMServerObject() {
        return getWsRole();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsRole((WSRoleE) serverObj);
    }
} // WSRoleItemImpl
