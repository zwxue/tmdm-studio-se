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
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.BlockingKeyImpl#getKeyName <em>Key Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockingKeyImpl extends EObjectImpl implements BlockingKey {
    /**
     * The default value of the '{@link #getKeyName() <em>Key Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKeyName()
     * @generated
     * @ordered
     */
    protected static final String KEY_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getKeyName() <em>Key Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKeyName()
     * @generated
     * @ordered
     */
    protected String keyName = KEY_NAME_EDEFAULT;

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
    public String getKeyName() {
        return keyName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKeyName(String newKeyName) {
        String oldKeyName = keyName;
        keyName = newKeyName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MatchRulePackage.BLOCKING_KEY__KEY_NAME, oldKeyName, keyName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MatchRulePackage.BLOCKING_KEY__KEY_NAME:
                return getKeyName();
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
            case MatchRulePackage.BLOCKING_KEY__KEY_NAME:
                setKeyName((String)newValue);
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
            case MatchRulePackage.BLOCKING_KEY__KEY_NAME:
                setKeyName(KEY_NAME_EDEFAULT);
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
            case MatchRulePackage.BLOCKING_KEY__KEY_NAME:
                return KEY_NAME_EDEFAULT == null ? keyName != null : !KEY_NAME_EDEFAULT.equals(keyName);
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
        result.append(" (keyName: ");
        result.append(keyName);
        result.append(')');
        return result.toString();
    }

} //BlockingKeyImpl
