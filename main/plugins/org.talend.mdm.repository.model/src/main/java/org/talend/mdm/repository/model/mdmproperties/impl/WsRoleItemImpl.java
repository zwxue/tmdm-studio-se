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
import org.talend.mdm.repository.model.mdmproperties.WsRoleItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsRoleE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Role Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsRoleItemImpl#getWsRole <em>Ws Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsRoleItemImpl extends MDMServerObjectItemImpl implements WsRoleItem {

    /**
     * The cached value of the '{@link #getWsRole() <em>Ws Role</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getWsRole()
     * @generated
     * @ordered
     */
    protected WsRoleE wsRole;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsRoleItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_ROLE_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public WsRoleE getWsRole() {
        if (wsRole != null && wsRole.eIsProxy()) {
            InternalEObject oldWsRole = (InternalEObject) wsRole;
            wsRole = (WsRoleE) eResolveProxy(oldWsRole);
            if (wsRole.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsRole);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WsRoleE) {
                        wsRole = (WsRoleE) object;
                        break;
                    }
                }
            }
            if (wsRole != oldWsRole) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE,
                            oldWsRole, wsRole));
                }
            }
        }
        return wsRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsRoleE basicGetWsRole() {
        return wsRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWsRole(WsRoleE newWsRole) {
        WsRoleE oldWsRole = wsRole;
        wsRole = newWsRole;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE, oldWsRole, wsRole));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE:
            if (resolve) {
                return getWsRole();
            }
            return basicGetWsRole();
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
        case MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE:
            setWsRole((WsRoleE) newValue);
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
        case MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE:
            setWsRole((WsRoleE) null);
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
        case MdmpropertiesPackage.WS_ROLE_ITEM__WS_ROLE:
            return wsRole != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsRole();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsRole((WsRoleE) serverObj);
    }

} // WsRoleItemImpl
