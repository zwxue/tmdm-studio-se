/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Role Specification E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationEImpl#isAdmin <em>Admin</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationEImpl#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationEImpl#getInstance <em>Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSRoleSpecificationEImpl extends EObjectImpl implements WSRoleSpecificationE {
    /**
     * The default value of the '{@link #isAdmin() <em>Admin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAdmin()
     * @generated
     * @ordered
     */
    protected static final boolean ADMIN_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAdmin() <em>Admin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAdmin()
     * @generated
     * @ordered
     */
    protected boolean admin = ADMIN_EDEFAULT;

    /**
     * The default value of the '{@link #getObjectType() <em>Object Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getObjectType()
     * @generated
     * @ordered
     */
    protected static final String OBJECT_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getObjectType() <em>Object Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getObjectType()
     * @generated
     * @ordered
     */
    protected String objectType = OBJECT_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getInstance() <em>Instance</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstance()
     * @generated
     * @ordered
     */
    protected EList<WSRoleSpecificationInstanceE> instance;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSRoleSpecificationEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_ROLE_SPECIFICATION_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAdmin(boolean newAdmin) {
        boolean oldAdmin = admin;
        admin = newAdmin;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__ADMIN, oldAdmin, admin));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setObjectType(String newObjectType) {
        String oldObjectType = objectType;
        objectType = newObjectType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__OBJECT_TYPE, oldObjectType, objectType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WSRoleSpecificationInstanceE> getInstance() {
        if (instance == null) {
            instance = new EObjectResolvingEList<WSRoleSpecificationInstanceE>(WSRoleSpecificationInstanceE.class, this, MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__INSTANCE);
        }
        return instance;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__ADMIN:
                return isAdmin();
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__OBJECT_TYPE:
                return getObjectType();
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__INSTANCE:
                return getInstance();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__ADMIN:
                setAdmin((Boolean)newValue);
                return;
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__OBJECT_TYPE:
                setObjectType((String)newValue);
                return;
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__INSTANCE:
                getInstance().clear();
                getInstance().addAll((Collection<? extends WSRoleSpecificationInstanceE>)newValue);
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
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__ADMIN:
                setAdmin(ADMIN_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__OBJECT_TYPE:
                setObjectType(OBJECT_TYPE_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__INSTANCE:
                getInstance().clear();
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
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__ADMIN:
                return admin != ADMIN_EDEFAULT;
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__OBJECT_TYPE:
                return OBJECT_TYPE_EDEFAULT == null ? objectType != null : !OBJECT_TYPE_EDEFAULT.equals(objectType);
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E__INSTANCE:
                return instance != null && !instance.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (admin: ");
        result.append(admin);
        result.append(", objectType: ");
        result.append(objectType);
        result.append(')');
        return result.toString();
    }

} //WSRoleSpecificationEImpl
