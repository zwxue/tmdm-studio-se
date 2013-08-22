/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKey;
import org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Blocking Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.BlockingKeyImpl#getElmentName <em>Elment Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockingKeyImpl extends EObjectImpl implements BlockingKey {
    /**
     * The default value of the '{@link #getElmentName() <em>Elment Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getElmentName()
     * @generated
     * @ordered
     */
    protected static final String ELMENT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getElmentName() <em>Elment Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getElmentName()
     * @generated
     * @ordered
     */
    protected String elmentName = ELMENT_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BlockingKeyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MatchRulePackage.Literals.BLOCKING_KEY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getElmentName() {
        return elmentName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setElmentName(String newElmentName) {
        String oldElmentName = elmentName;
        elmentName = newElmentName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MatchRulePackage.BLOCKING_KEY__ELMENT_NAME, oldElmentName, elmentName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MatchRulePackage.BLOCKING_KEY__ELMENT_NAME:
                return getElmentName();
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
            case MatchRulePackage.BLOCKING_KEY__ELMENT_NAME:
                setElmentName((String)newValue);
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
            case MatchRulePackage.BLOCKING_KEY__ELMENT_NAME:
                setElmentName(ELMENT_NAME_EDEFAULT);
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
            case MatchRulePackage.BLOCKING_KEY__ELMENT_NAME:
                return ELMENT_NAME_EDEFAULT == null ? elmentName != null : !ELMENT_NAME_EDEFAULT.equals(elmentName);
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
        result.append(" (elmentName: ");
        result.append(elmentName);
        result.append(')');
        return result.toString();
    }

} //BlockingKeyImpl
