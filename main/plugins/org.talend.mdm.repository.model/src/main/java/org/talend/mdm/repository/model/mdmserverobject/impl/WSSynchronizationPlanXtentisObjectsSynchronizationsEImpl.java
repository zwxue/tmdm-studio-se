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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsE;
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Synchronization Plan Xtentis Objects Synchronizations E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSSynchronizationPlanXtentisObjectsSynchronizationsEImpl#getXtentisObjectName <em>Xtentis Object Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSSynchronizationPlanXtentisObjectsSynchronizationsEImpl#getSynchronizations <em>Synchronizations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSSynchronizationPlanXtentisObjectsSynchronizationsEImpl extends EObjectImpl implements WSSynchronizationPlanXtentisObjectsSynchronizationsE {
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
     * The cached value of the '{@link #getSynchronizations() <em>Synchronizations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSynchronizations()
     * @generated
     * @ordered
     */
    protected EList<WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE> synchronizations;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSSynchronizationPlanXtentisObjectsSynchronizationsEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E;
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
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__XTENTIS_OBJECT_NAME, oldXtentisObjectName, xtentisObjectName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE> getSynchronizations() {
        if (synchronizations == null) {
            synchronizations = new EObjectContainmentEList<WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE>(WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE.class, this, MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__SYNCHRONIZATIONS);
        }
        return synchronizations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__SYNCHRONIZATIONS:
                return ((InternalEList<?>)getSynchronizations()).basicRemove(otherEnd, msgs);
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
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__XTENTIS_OBJECT_NAME:
                return getXtentisObjectName();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__SYNCHRONIZATIONS:
                return getSynchronizations();
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
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__XTENTIS_OBJECT_NAME:
                setXtentisObjectName((String)newValue);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__SYNCHRONIZATIONS:
                getSynchronizations().clear();
                getSynchronizations().addAll((Collection<? extends WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE>)newValue);
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
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__XTENTIS_OBJECT_NAME:
                setXtentisObjectName(XTENTIS_OBJECT_NAME_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__SYNCHRONIZATIONS:
                getSynchronizations().clear();
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
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__XTENTIS_OBJECT_NAME:
                return XTENTIS_OBJECT_NAME_EDEFAULT == null ? xtentisObjectName != null : !XTENTIS_OBJECT_NAME_EDEFAULT.equals(xtentisObjectName);
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__SYNCHRONIZATIONS:
                return synchronizations != null && !synchronizations.isEmpty();
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
        result.append(')');
        return result.toString();
    }

} //WSSynchronizationPlanXtentisObjectsSynchronizationsEImpl
