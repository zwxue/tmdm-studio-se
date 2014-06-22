/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule.impl;

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

import org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKey;
import org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKeyDefinition;
import org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Blocking Key Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.BlockingKeyDefinitionImpl#getBlockingKeys <em>Blocking Keys</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.BlockingKeyDefinitionImpl#isUseBuiltInColumn <em>Use Built In Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockingKeyDefinitionImpl extends EObjectImpl implements BlockingKeyDefinition {
    /**
     * The cached value of the '{@link #getBlockingKeys() <em>Blocking Keys</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlockingKeys()
     * @generated
     * @ordered
     */
    protected EList<BlockingKey> blockingKeys;

    /**
     * The default value of the '{@link #isUseBuiltInColumn() <em>Use Built In Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUseBuiltInColumn()
     * @generated
     * @ordered
     */
    protected static final boolean USE_BUILT_IN_COLUMN_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isUseBuiltInColumn() <em>Use Built In Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUseBuiltInColumn()
     * @generated
     * @ordered
     */
    protected boolean useBuiltInColumn = USE_BUILT_IN_COLUMN_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BlockingKeyDefinitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MatchRulePackage.Literals.BLOCKING_KEY_DEFINITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<BlockingKey> getBlockingKeys() {
        if (blockingKeys == null) {
            blockingKeys = new EObjectContainmentEList<BlockingKey>(BlockingKey.class, this, MatchRulePackage.BLOCKING_KEY_DEFINITION__BLOCKING_KEYS);
        }
        return blockingKeys;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isUseBuiltInColumn() {
        return useBuiltInColumn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUseBuiltInColumn(boolean newUseBuiltInColumn) {
        boolean oldUseBuiltInColumn = useBuiltInColumn;
        useBuiltInColumn = newUseBuiltInColumn;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MatchRulePackage.BLOCKING_KEY_DEFINITION__USE_BUILT_IN_COLUMN, oldUseBuiltInColumn, useBuiltInColumn));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MatchRulePackage.BLOCKING_KEY_DEFINITION__BLOCKING_KEYS:
                return ((InternalEList<?>)getBlockingKeys()).basicRemove(otherEnd, msgs);
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
            case MatchRulePackage.BLOCKING_KEY_DEFINITION__BLOCKING_KEYS:
                return getBlockingKeys();
            case MatchRulePackage.BLOCKING_KEY_DEFINITION__USE_BUILT_IN_COLUMN:
                return isUseBuiltInColumn();
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
            case MatchRulePackage.BLOCKING_KEY_DEFINITION__BLOCKING_KEYS:
                getBlockingKeys().clear();
                getBlockingKeys().addAll((Collection<? extends BlockingKey>)newValue);
                return;
            case MatchRulePackage.BLOCKING_KEY_DEFINITION__USE_BUILT_IN_COLUMN:
                setUseBuiltInColumn((Boolean)newValue);
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
            case MatchRulePackage.BLOCKING_KEY_DEFINITION__BLOCKING_KEYS:
                getBlockingKeys().clear();
                return;
            case MatchRulePackage.BLOCKING_KEY_DEFINITION__USE_BUILT_IN_COLUMN:
                setUseBuiltInColumn(USE_BUILT_IN_COLUMN_EDEFAULT);
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
            case MatchRulePackage.BLOCKING_KEY_DEFINITION__BLOCKING_KEYS:
                return blockingKeys != null && !blockingKeys.isEmpty();
            case MatchRulePackage.BLOCKING_KEY_DEFINITION__USE_BUILT_IN_COLUMN:
                return useBuiltInColumn != USE_BUILT_IN_COLUMN_EDEFAULT;
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
        result.append(" (useBuiltInColumn: ");
        result.append(useBuiltInColumn);
        result.append(')');
        return result.toString();
    }

} //BlockingKeyDefinitionImpl
