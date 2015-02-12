/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WsStringPredicateE;
import org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE;
import org.talend.mdm.repository.model.mdmserverobject.WsWhereOperatorE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ws Where Condition E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereConditionEImpl#getLeftPath <em>Left Path</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereConditionEImpl#getRightValueOrPath <em>Right Value Or Path</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereConditionEImpl#getStringPredicate <em>String Predicate</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereConditionEImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereConditionEImpl#isSpellCheck <em>Spell Check</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsWhereConditionEImpl extends EObjectImpl implements WsWhereConditionE {
    /**
     * The default value of the '{@link #getLeftPath() <em>Left Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLeftPath()
     * @generated
     * @ordered
     */
    protected static final String LEFT_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLeftPath() <em>Left Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLeftPath()
     * @generated
     * @ordered
     */
    protected String leftPath = LEFT_PATH_EDEFAULT;

    /**
     * The default value of the '{@link #getRightValueOrPath() <em>Right Value Or Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRightValueOrPath()
     * @generated
     * @ordered
     */
    protected static final String RIGHT_VALUE_OR_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRightValueOrPath() <em>Right Value Or Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRightValueOrPath()
     * @generated
     * @ordered
     */
    protected String rightValueOrPath = RIGHT_VALUE_OR_PATH_EDEFAULT;

    /**
     * The cached value of the '{@link #getStringPredicate() <em>String Predicate</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStringPredicate()
     * @generated
     * @ordered
     */
    protected WsStringPredicateE stringPredicate;

    /**
     * The cached value of the '{@link #getOperator() <em>Operator</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperator()
     * @generated
     * @ordered
     */
    protected WsWhereOperatorE operator;

    /**
     * The default value of the '{@link #isSpellCheck() <em>Spell Check</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSpellCheck()
     * @generated
     * @ordered
     */
    protected static final boolean SPELL_CHECK_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isSpellCheck() <em>Spell Check</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSpellCheck()
     * @generated
     * @ordered
     */
    protected boolean spellCheck = SPELL_CHECK_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WsWhereConditionEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_WHERE_CONDITION_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLeftPath() {
        return leftPath;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLeftPath(String newLeftPath) {
        String oldLeftPath = leftPath;
        leftPath = newLeftPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_WHERE_CONDITION_E__LEFT_PATH, oldLeftPath, leftPath));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRightValueOrPath() {
        return rightValueOrPath;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRightValueOrPath(String newRightValueOrPath) {
        String oldRightValueOrPath = rightValueOrPath;
        rightValueOrPath = newRightValueOrPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_WHERE_CONDITION_E__RIGHT_VALUE_OR_PATH, oldRightValueOrPath, rightValueOrPath));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsStringPredicateE getStringPredicate() {
        return stringPredicate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetStringPredicate(WsStringPredicateE newStringPredicate, NotificationChain msgs) {
        WsStringPredicateE oldStringPredicate = stringPredicate;
        stringPredicate = newStringPredicate;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_WHERE_CONDITION_E__STRING_PREDICATE, oldStringPredicate, newStringPredicate);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStringPredicate(WsStringPredicateE newStringPredicate) {
        if (newStringPredicate != stringPredicate) {
            NotificationChain msgs = null;
            if (stringPredicate != null)
                msgs = ((InternalEObject)stringPredicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_WHERE_CONDITION_E__STRING_PREDICATE, null, msgs);
            if (newStringPredicate != null)
                msgs = ((InternalEObject)newStringPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_WHERE_CONDITION_E__STRING_PREDICATE, null, msgs);
            msgs = basicSetStringPredicate(newStringPredicate, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_WHERE_CONDITION_E__STRING_PREDICATE, newStringPredicate, newStringPredicate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsWhereOperatorE getOperator() {
        return operator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperator(WsWhereOperatorE newOperator, NotificationChain msgs) {
        WsWhereOperatorE oldOperator = operator;
        operator = newOperator;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_WHERE_CONDITION_E__OPERATOR, oldOperator, newOperator);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperator(WsWhereOperatorE newOperator) {
        if (newOperator != operator) {
            NotificationChain msgs = null;
            if (operator != null)
                msgs = ((InternalEObject)operator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_WHERE_CONDITION_E__OPERATOR, null, msgs);
            if (newOperator != null)
                msgs = ((InternalEObject)newOperator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_WHERE_CONDITION_E__OPERATOR, null, msgs);
            msgs = basicSetOperator(newOperator, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_WHERE_CONDITION_E__OPERATOR, newOperator, newOperator));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSpellCheck() {
        return spellCheck;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSpellCheck(boolean newSpellCheck) {
        boolean oldSpellCheck = spellCheck;
        spellCheck = newSpellCheck;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_WHERE_CONDITION_E__SPELL_CHECK, oldSpellCheck, spellCheck));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__STRING_PREDICATE:
                return basicSetStringPredicate(null, msgs);
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__OPERATOR:
                return basicSetOperator(null, msgs);
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
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__LEFT_PATH:
                return getLeftPath();
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__RIGHT_VALUE_OR_PATH:
                return getRightValueOrPath();
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__STRING_PREDICATE:
                return getStringPredicate();
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__OPERATOR:
                return getOperator();
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__SPELL_CHECK:
                return isSpellCheck();
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
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__LEFT_PATH:
                setLeftPath((String)newValue);
                return;
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__RIGHT_VALUE_OR_PATH:
                setRightValueOrPath((String)newValue);
                return;
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__STRING_PREDICATE:
                setStringPredicate((WsStringPredicateE)newValue);
                return;
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__OPERATOR:
                setOperator((WsWhereOperatorE)newValue);
                return;
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__SPELL_CHECK:
                setSpellCheck((Boolean)newValue);
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
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__LEFT_PATH:
                setLeftPath(LEFT_PATH_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__RIGHT_VALUE_OR_PATH:
                setRightValueOrPath(RIGHT_VALUE_OR_PATH_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__STRING_PREDICATE:
                setStringPredicate((WsStringPredicateE)null);
                return;
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__OPERATOR:
                setOperator((WsWhereOperatorE)null);
                return;
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__SPELL_CHECK:
                setSpellCheck(SPELL_CHECK_EDEFAULT);
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
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__LEFT_PATH:
                return LEFT_PATH_EDEFAULT == null ? leftPath != null : !LEFT_PATH_EDEFAULT.equals(leftPath);
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__RIGHT_VALUE_OR_PATH:
                return RIGHT_VALUE_OR_PATH_EDEFAULT == null ? rightValueOrPath != null : !RIGHT_VALUE_OR_PATH_EDEFAULT.equals(rightValueOrPath);
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__STRING_PREDICATE:
                return stringPredicate != null;
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__OPERATOR:
                return operator != null;
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E__SPELL_CHECK:
                return spellCheck != SPELL_CHECK_EDEFAULT;
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
        result.append(" (leftPath: ");
        result.append(leftPath);
        result.append(", rightValueOrPath: ");
        result.append(rightValueOrPath);
        result.append(", spellCheck: ");
        result.append(spellCheck);
        result.append(')');
        return result.toString();
    }

} //WsWhereConditionEImpl
