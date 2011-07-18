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
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Synchronization Plan Xtentis Objects Synchronizations Synchronizations E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl#getInstancePattern <em>Instance Pattern</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl#getLocalRevisionID <em>Local Revision ID</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl#getRemoteRevisionID <em>Remote Revision ID</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl extends EObjectImpl implements WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE {
    /**
     * The default value of the '{@link #getInstancePattern() <em>Instance Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstancePattern()
     * @generated
     * @ordered
     */
    protected static final String INSTANCE_PATTERN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInstancePattern() <em>Instance Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstancePattern()
     * @generated
     * @ordered
     */
    protected String instancePattern = INSTANCE_PATTERN_EDEFAULT;

    /**
     * The default value of the '{@link #getLocalRevisionID() <em>Local Revision ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalRevisionID()
     * @generated
     * @ordered
     */
    protected static final String LOCAL_REVISION_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLocalRevisionID() <em>Local Revision ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalRevisionID()
     * @generated
     * @ordered
     */
    protected String localRevisionID = LOCAL_REVISION_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getRemoteRevisionID() <em>Remote Revision ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRemoteRevisionID()
     * @generated
     * @ordered
     */
    protected static final String REMOTE_REVISION_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRemoteRevisionID() <em>Remote Revision ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRemoteRevisionID()
     * @generated
     * @ordered
     */
    protected String remoteRevisionID = REMOTE_REVISION_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAlgorithm()
     * @generated
     * @ordered
     */
    protected static final String ALGORITHM_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAlgorithm()
     * @generated
     * @ordered
     */
    protected String algorithm = ALGORITHM_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInstancePattern() {
        return instancePattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInstancePattern(String newInstancePattern) {
        String oldInstancePattern = instancePattern;
        instancePattern = newInstancePattern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__INSTANCE_PATTERN, oldInstancePattern, instancePattern));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLocalRevisionID() {
        return localRevisionID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocalRevisionID(String newLocalRevisionID) {
        String oldLocalRevisionID = localRevisionID;
        localRevisionID = newLocalRevisionID;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID, oldLocalRevisionID, localRevisionID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRemoteRevisionID() {
        return remoteRevisionID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRemoteRevisionID(String newRemoteRevisionID) {
        String oldRemoteRevisionID = remoteRevisionID;
        remoteRevisionID = newRemoteRevisionID;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID, oldRemoteRevisionID, remoteRevisionID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAlgorithm(String newAlgorithm) {
        String oldAlgorithm = algorithm;
        algorithm = newAlgorithm;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__ALGORITHM, oldAlgorithm, algorithm));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__INSTANCE_PATTERN:
                return getInstancePattern();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID:
                return getLocalRevisionID();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID:
                return getRemoteRevisionID();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__ALGORITHM:
                return getAlgorithm();
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
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__INSTANCE_PATTERN:
                setInstancePattern((String)newValue);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID:
                setLocalRevisionID((String)newValue);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID:
                setRemoteRevisionID((String)newValue);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__ALGORITHM:
                setAlgorithm((String)newValue);
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
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__INSTANCE_PATTERN:
                setInstancePattern(INSTANCE_PATTERN_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID:
                setLocalRevisionID(LOCAL_REVISION_ID_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID:
                setRemoteRevisionID(REMOTE_REVISION_ID_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__ALGORITHM:
                setAlgorithm(ALGORITHM_EDEFAULT);
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
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__INSTANCE_PATTERN:
                return INSTANCE_PATTERN_EDEFAULT == null ? instancePattern != null : !INSTANCE_PATTERN_EDEFAULT.equals(instancePattern);
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID:
                return LOCAL_REVISION_ID_EDEFAULT == null ? localRevisionID != null : !LOCAL_REVISION_ID_EDEFAULT.equals(localRevisionID);
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID:
                return REMOTE_REVISION_ID_EDEFAULT == null ? remoteRevisionID != null : !REMOTE_REVISION_ID_EDEFAULT.equals(remoteRevisionID);
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__ALGORITHM:
                return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
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
        result.append(" (instancePattern: ");
        result.append(instancePattern);
        result.append(", localRevisionID: ");
        result.append(localRevisionID);
        result.append(", remoteRevisionID: ");
        result.append(remoteRevisionID);
        result.append(", algorithm: ");
        result.append(algorithm);
        result.append(')');
        return result.toString();
    }

} //WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl
