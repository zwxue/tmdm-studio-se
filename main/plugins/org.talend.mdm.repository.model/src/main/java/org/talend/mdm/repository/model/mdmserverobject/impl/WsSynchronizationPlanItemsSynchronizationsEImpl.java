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
import org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ws Synchronization Plan Items Synchronizations E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanItemsSynchronizationsEImpl#getConceptName <em>Concept Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanItemsSynchronizationsEImpl#getIdsPattern <em>Ids Pattern</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanItemsSynchronizationsEImpl#getLocalCluster <em>Local Cluster</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanItemsSynchronizationsEImpl#getLocalRevisionID <em>Local Revision ID</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanItemsSynchronizationsEImpl#getRemoteCluster <em>Remote Cluster</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanItemsSynchronizationsEImpl#getRemoteRevisionID <em>Remote Revision ID</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanItemsSynchronizationsEImpl#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsSynchronizationPlanItemsSynchronizationsEImpl extends EObjectImpl implements WsSynchronizationPlanItemsSynchronizationsE {
    /**
     * The default value of the '{@link #getConceptName() <em>Concept Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConceptName()
     * @generated
     * @ordered
     */
    protected static final String CONCEPT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConceptName() <em>Concept Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConceptName()
     * @generated
     * @ordered
     */
    protected String conceptName = CONCEPT_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getIdsPattern() <em>Ids Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIdsPattern()
     * @generated
     * @ordered
     */
    protected static final String IDS_PATTERN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIdsPattern() <em>Ids Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIdsPattern()
     * @generated
     * @ordered
     */
    protected String idsPattern = IDS_PATTERN_EDEFAULT;

    /**
     * The default value of the '{@link #getLocalCluster() <em>Local Cluster</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalCluster()
     * @generated
     * @ordered
     */
    protected static final String LOCAL_CLUSTER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLocalCluster() <em>Local Cluster</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalCluster()
     * @generated
     * @ordered
     */
    protected String localCluster = LOCAL_CLUSTER_EDEFAULT;

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
     * The default value of the '{@link #getRemoteCluster() <em>Remote Cluster</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRemoteCluster()
     * @generated
     * @ordered
     */
    protected static final String REMOTE_CLUSTER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRemoteCluster() <em>Remote Cluster</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRemoteCluster()
     * @generated
     * @ordered
     */
    protected String remoteCluster = REMOTE_CLUSTER_EDEFAULT;

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
    protected WsSynchronizationPlanItemsSynchronizationsEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getConceptName() {
        return conceptName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConceptName(String newConceptName) {
        String oldConceptName = conceptName;
        conceptName = newConceptName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__CONCEPT_NAME, oldConceptName, conceptName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getIdsPattern() {
        return idsPattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIdsPattern(String newIdsPattern) {
        String oldIdsPattern = idsPattern;
        idsPattern = newIdsPattern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__IDS_PATTERN, oldIdsPattern, idsPattern));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLocalCluster() {
        return localCluster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocalCluster(String newLocalCluster) {
        String oldLocalCluster = localCluster;
        localCluster = newLocalCluster;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_CLUSTER, oldLocalCluster, localCluster));
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
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID, oldLocalRevisionID, localRevisionID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRemoteCluster() {
        return remoteCluster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRemoteCluster(String newRemoteCluster) {
        String oldRemoteCluster = remoteCluster;
        remoteCluster = newRemoteCluster;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_CLUSTER, oldRemoteCluster, remoteCluster));
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
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID, oldRemoteRevisionID, remoteRevisionID));
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
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__ALGORITHM, oldAlgorithm, algorithm));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__CONCEPT_NAME:
                return getConceptName();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__IDS_PATTERN:
                return getIdsPattern();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_CLUSTER:
                return getLocalCluster();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID:
                return getLocalRevisionID();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_CLUSTER:
                return getRemoteCluster();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID:
                return getRemoteRevisionID();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__ALGORITHM:
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
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__CONCEPT_NAME:
                setConceptName((String)newValue);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__IDS_PATTERN:
                setIdsPattern((String)newValue);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_CLUSTER:
                setLocalCluster((String)newValue);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID:
                setLocalRevisionID((String)newValue);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_CLUSTER:
                setRemoteCluster((String)newValue);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID:
                setRemoteRevisionID((String)newValue);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__ALGORITHM:
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
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__CONCEPT_NAME:
                setConceptName(CONCEPT_NAME_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__IDS_PATTERN:
                setIdsPattern(IDS_PATTERN_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_CLUSTER:
                setLocalCluster(LOCAL_CLUSTER_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID:
                setLocalRevisionID(LOCAL_REVISION_ID_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_CLUSTER:
                setRemoteCluster(REMOTE_CLUSTER_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID:
                setRemoteRevisionID(REMOTE_REVISION_ID_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__ALGORITHM:
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
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__CONCEPT_NAME:
                return CONCEPT_NAME_EDEFAULT == null ? conceptName != null : !CONCEPT_NAME_EDEFAULT.equals(conceptName);
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__IDS_PATTERN:
                return IDS_PATTERN_EDEFAULT == null ? idsPattern != null : !IDS_PATTERN_EDEFAULT.equals(idsPattern);
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_CLUSTER:
                return LOCAL_CLUSTER_EDEFAULT == null ? localCluster != null : !LOCAL_CLUSTER_EDEFAULT.equals(localCluster);
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID:
                return LOCAL_REVISION_ID_EDEFAULT == null ? localRevisionID != null : !LOCAL_REVISION_ID_EDEFAULT.equals(localRevisionID);
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_CLUSTER:
                return REMOTE_CLUSTER_EDEFAULT == null ? remoteCluster != null : !REMOTE_CLUSTER_EDEFAULT.equals(remoteCluster);
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID:
                return REMOTE_REVISION_ID_EDEFAULT == null ? remoteRevisionID != null : !REMOTE_REVISION_ID_EDEFAULT.equals(remoteRevisionID);
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__ALGORITHM:
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
        result.append(" (conceptName: ");
        result.append(conceptName);
        result.append(", idsPattern: ");
        result.append(idsPattern);
        result.append(", localCluster: ");
        result.append(localCluster);
        result.append(", localRevisionID: ");
        result.append(localRevisionID);
        result.append(", remoteCluster: ");
        result.append(remoteCluster);
        result.append(", remoteRevisionID: ");
        result.append(remoteRevisionID);
        result.append(", algorithm: ");
        result.append(algorithm);
        result.append(')');
        return result.toString();
    }

} //WsSynchronizationPlanItemsSynchronizationsEImpl
