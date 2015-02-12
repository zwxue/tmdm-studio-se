/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WsUniverseXtentisObjectsRevisionIDsE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ws Universe Xtentis Objects Revision IDs E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseXtentisObjectsRevisionIDsEImpl#getXtentisObjectName <em>Xtentis Object Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseXtentisObjectsRevisionIDsEImpl#getRevisionID <em>Revision ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsUniverseXtentisObjectsRevisionIDsEImpl extends EObjectImpl implements WsUniverseXtentisObjectsRevisionIDsE {
    /**
     * The default value of the '{@link #getXtentisObjectName() <em>Xtentis Object Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXtentisObjectName()
     * @generated
     * @ordered
     */
    protected static final String XTENTIS_OBJECT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getXtentisObjectName() <em>Xtentis Object Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXtentisObjectName()
     * @generated
     * @ordered
     */
    protected String xtentisObjectName = XTENTIS_OBJECT_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getRevisionID() <em>Revision ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRevisionID()
     * @generated
     * @ordered
     */
    protected static final String REVISION_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRevisionID() <em>Revision ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRevisionID()
     * @generated
     * @ordered
     */
    protected String revisionID = REVISION_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WsUniverseXtentisObjectsRevisionIDsEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getXtentisObjectName() {
        return xtentisObjectName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setXtentisObjectName(String newXtentisObjectName) {
        String oldXtentisObjectName = xtentisObjectName;
        xtentisObjectName = newXtentisObjectName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__XTENTIS_OBJECT_NAME, oldXtentisObjectName, xtentisObjectName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRevisionID() {
        return revisionID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRevisionID(String newRevisionID) {
        String oldRevisionID = revisionID;
        revisionID = newRevisionID;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__REVISION_ID, oldRevisionID, revisionID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__XTENTIS_OBJECT_NAME:
                return getXtentisObjectName();
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__REVISION_ID:
                return getRevisionID();
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
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__XTENTIS_OBJECT_NAME:
                setXtentisObjectName((String)newValue);
                return;
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__REVISION_ID:
                setRevisionID((String)newValue);
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
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__XTENTIS_OBJECT_NAME:
                setXtentisObjectName(XTENTIS_OBJECT_NAME_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__REVISION_ID:
                setRevisionID(REVISION_ID_EDEFAULT);
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
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__XTENTIS_OBJECT_NAME:
                return XTENTIS_OBJECT_NAME_EDEFAULT == null ? xtentisObjectName != null : !XTENTIS_OBJECT_NAME_EDEFAULT.equals(xtentisObjectName);
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__REVISION_ID:
                return REVISION_ID_EDEFAULT == null ? revisionID != null : !REVISION_ID_EDEFAULT.equals(revisionID);
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
        result.append(" (xtentisObjectName: ");
        result.append(xtentisObjectName);
        result.append(", revisionID: ");
        result.append(revisionID);
        result.append(')');
        return result.toString();
    }

} //WsUniverseXtentisObjectsRevisionIDsEImpl
