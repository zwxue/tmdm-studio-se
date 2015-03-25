/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSUniverseE;
import org.talend.mdm.repository.model.mdmserverobject.WSUniverseItemsRevisionIDsE;
import org.talend.mdm.repository.model.mdmserverobject.WSUniverseXtentisObjectsRevisionIDsE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Universe E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSUniverseEImpl#getDefaultItemsRevisionID <em>Default Items Revision ID</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSUniverseEImpl#getXtentisObjectsRevisionIDs <em>Xtentis Objects Revision IDs</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSUniverseEImpl#getItemsRevisionIDs <em>Items Revision IDs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSUniverseEImpl extends MDMServerObjectImpl implements WSUniverseE {
    /**
     * The default value of the '{@link #getDefaultItemsRevisionID() <em>Default Items Revision ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultItemsRevisionID()
     * @generated
     * @ordered
     */
    protected static final String DEFAULT_ITEMS_REVISION_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefaultItemsRevisionID() <em>Default Items Revision ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultItemsRevisionID()
     * @generated
     * @ordered
     */
    protected String defaultItemsRevisionID = DEFAULT_ITEMS_REVISION_ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getXtentisObjectsRevisionIDs() <em>Xtentis Objects Revision IDs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXtentisObjectsRevisionIDs()
     * @generated
     * @ordered
     */
    protected EList<WSUniverseXtentisObjectsRevisionIDsE> xtentisObjectsRevisionIDs;

    /**
     * The cached value of the '{@link #getItemsRevisionIDs() <em>Items Revision IDs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemsRevisionIDs()
     * @generated
     * @ordered
     */
    protected EList<WSUniverseItemsRevisionIDsE> itemsRevisionIDs;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSUniverseEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_UNIVERSE_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDefaultItemsRevisionID() {
        return defaultItemsRevisionID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultItemsRevisionID(String newDefaultItemsRevisionID) {
        String oldDefaultItemsRevisionID = defaultItemsRevisionID;
        defaultItemsRevisionID = newDefaultItemsRevisionID;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_UNIVERSE_E__DEFAULT_ITEMS_REVISION_ID, oldDefaultItemsRevisionID, defaultItemsRevisionID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WSUniverseXtentisObjectsRevisionIDsE> getXtentisObjectsRevisionIDs() {
        if (xtentisObjectsRevisionIDs == null) {
            xtentisObjectsRevisionIDs = new EObjectContainmentEList<WSUniverseXtentisObjectsRevisionIDsE>(WSUniverseXtentisObjectsRevisionIDsE.class, this, MdmserverobjectPackage.WS_UNIVERSE_E__XTENTIS_OBJECTS_REVISION_IDS);
        }
        return xtentisObjectsRevisionIDs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WSUniverseItemsRevisionIDsE> getItemsRevisionIDs() {
        if (itemsRevisionIDs == null) {
            itemsRevisionIDs = new EObjectContainmentEList<WSUniverseItemsRevisionIDsE>(WSUniverseItemsRevisionIDsE.class, this, MdmserverobjectPackage.WS_UNIVERSE_E__ITEMS_REVISION_IDS);
        }
        return itemsRevisionIDs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_UNIVERSE_E__XTENTIS_OBJECTS_REVISION_IDS:
                return ((InternalEList<?>)getXtentisObjectsRevisionIDs()).basicRemove(otherEnd, msgs);
            case MdmserverobjectPackage.WS_UNIVERSE_E__ITEMS_REVISION_IDS:
                return ((InternalEList<?>)getItemsRevisionIDs()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_UNIVERSE_E__DEFAULT_ITEMS_REVISION_ID:
                return getDefaultItemsRevisionID();
            case MdmserverobjectPackage.WS_UNIVERSE_E__XTENTIS_OBJECTS_REVISION_IDS:
                return getXtentisObjectsRevisionIDs();
            case MdmserverobjectPackage.WS_UNIVERSE_E__ITEMS_REVISION_IDS:
                return getItemsRevisionIDs();
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
            case MdmserverobjectPackage.WS_UNIVERSE_E__DEFAULT_ITEMS_REVISION_ID:
                setDefaultItemsRevisionID((String)newValue);
                return;
            case MdmserverobjectPackage.WS_UNIVERSE_E__XTENTIS_OBJECTS_REVISION_IDS:
                getXtentisObjectsRevisionIDs().clear();
                getXtentisObjectsRevisionIDs().addAll((Collection<? extends WSUniverseXtentisObjectsRevisionIDsE>)newValue);
                return;
            case MdmserverobjectPackage.WS_UNIVERSE_E__ITEMS_REVISION_IDS:
                getItemsRevisionIDs().clear();
                getItemsRevisionIDs().addAll((Collection<? extends WSUniverseItemsRevisionIDsE>)newValue);
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
            case MdmserverobjectPackage.WS_UNIVERSE_E__DEFAULT_ITEMS_REVISION_ID:
                setDefaultItemsRevisionID(DEFAULT_ITEMS_REVISION_ID_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_UNIVERSE_E__XTENTIS_OBJECTS_REVISION_IDS:
                getXtentisObjectsRevisionIDs().clear();
                return;
            case MdmserverobjectPackage.WS_UNIVERSE_E__ITEMS_REVISION_IDS:
                getItemsRevisionIDs().clear();
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
            case MdmserverobjectPackage.WS_UNIVERSE_E__DEFAULT_ITEMS_REVISION_ID:
                return DEFAULT_ITEMS_REVISION_ID_EDEFAULT == null ? defaultItemsRevisionID != null : !DEFAULT_ITEMS_REVISION_ID_EDEFAULT.equals(defaultItemsRevisionID);
            case MdmserverobjectPackage.WS_UNIVERSE_E__XTENTIS_OBJECTS_REVISION_IDS:
                return xtentisObjectsRevisionIDs != null && !xtentisObjectsRevisionIDs.isEmpty();
            case MdmserverobjectPackage.WS_UNIVERSE_E__ITEMS_REVISION_IDS:
                return itemsRevisionIDs != null && !itemsRevisionIDs.isEmpty();
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
        result.append(" (defaultItemsRevisionID: ");
        result.append(defaultItemsRevisionID);
        result.append(')');
        return result.toString();
    }

    @Override
    public int getType() {
        return 18;
    }
} // WsUniverseEImpl
