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
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSStoredProcedureE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Stored Procedure E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSStoredProcedureEImpl#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSStoredProcedureEImpl#isRefreshCache <em>Refresh Cache</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSStoredProcedureEImpl extends MDMServerObjectImpl implements WSStoredProcedureE {
    /**
     * The default value of the '{@link #getProcedure() <em>Procedure</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProcedure()
     * @generated
     * @ordered
     */
    protected static final String PROCEDURE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProcedure() <em>Procedure</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProcedure()
     * @generated
     * @ordered
     */
    protected String procedure = PROCEDURE_EDEFAULT;

    /**
     * The default value of the '{@link #isRefreshCache() <em>Refresh Cache</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRefreshCache()
     * @generated
     * @ordered
     */
    protected static final boolean REFRESH_CACHE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isRefreshCache() <em>Refresh Cache</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRefreshCache()
     * @generated
     * @ordered
     */
    protected boolean refreshCache = REFRESH_CACHE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSStoredProcedureEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_STORED_PROCEDURE_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getProcedure() {
        return procedure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProcedure(String newProcedure) {
        String oldProcedure = procedure;
        procedure = newProcedure;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_STORED_PROCEDURE_E__PROCEDURE, oldProcedure, procedure));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isRefreshCache() {
        return refreshCache;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRefreshCache(boolean newRefreshCache) {
        boolean oldRefreshCache = refreshCache;
        refreshCache = newRefreshCache;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_STORED_PROCEDURE_E__REFRESH_CACHE, oldRefreshCache, refreshCache));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E__PROCEDURE:
                return getProcedure();
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E__REFRESH_CACHE:
                return isRefreshCache();
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
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E__PROCEDURE:
                setProcedure((String)newValue);
                return;
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E__REFRESH_CACHE:
                setRefreshCache((Boolean)newValue);
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
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E__PROCEDURE:
                setProcedure(PROCEDURE_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E__REFRESH_CACHE:
                setRefreshCache(REFRESH_CACHE_EDEFAULT);
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
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E__PROCEDURE:
                return PROCEDURE_EDEFAULT == null ? procedure != null : !PROCEDURE_EDEFAULT.equals(procedure);
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E__REFRESH_CACHE:
                return refreshCache != REFRESH_CACHE_EDEFAULT;
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
        result.append(" (procedure: ");
        result.append(procedure);
        result.append(", refreshCache: ");
        result.append(refreshCache);
        result.append(')');
        return result.toString();
    }

    @Override
    public int getType() {
        return 12;
    }

} //WSStoredProcedureEImpl
