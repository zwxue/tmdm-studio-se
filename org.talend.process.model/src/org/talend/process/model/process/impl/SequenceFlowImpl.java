/**
 * Copyright (C) 2009 BonitaSoft S.A.
 * BonitaSoft, 31 rue Gustave Eiffel - 38000 Grenoble
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * $Id$
 */
package org.talend.process.model.process.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.SequenceFlow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.SequenceFlowImpl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.SequenceFlowImpl#isIsDefault <em>Is Default</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.SequenceFlowImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceFlowImpl extends ConnectionImpl implements SequenceFlow {
    /**
     * The default value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQuantity()
     * @generated
     * @ordered
     */
    protected static final Integer QUANTITY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQuantity()
     * @generated
     * @ordered
     */
    protected Integer quantity = QUANTITY_EDEFAULT;

    /**
     * The default value of the '{@link #isIsDefault() <em>Is Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsDefault()
     * @generated
     * @ordered
     */
    protected static final boolean IS_DEFAULT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsDefault() <em>Is Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsDefault()
     * @generated
     * @ordered
     */
    protected boolean isDefault = IS_DEFAULT_EDEFAULT;

    /**
     * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected static final String CONDITION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected String condition = CONDITION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SequenceFlowImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.SEQUENCE_FLOW;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setQuantity(Integer newQuantity) {
        Integer oldQuantity = quantity;
        quantity = newQuantity;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.SEQUENCE_FLOW__QUANTITY, oldQuantity, quantity));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsDefault() {
        return isDefault;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsDefault(boolean newIsDefault) {
        boolean oldIsDefault = isDefault;
        isDefault = newIsDefault;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.SEQUENCE_FLOW__IS_DEFAULT, oldIsDefault, isDefault));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCondition() {
        return condition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCondition(String newCondition) {
        String oldCondition = condition;
        condition = newCondition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.SEQUENCE_FLOW__CONDITION, oldCondition, condition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ProcessPackage.SEQUENCE_FLOW__QUANTITY:
                return getQuantity();
            case ProcessPackage.SEQUENCE_FLOW__IS_DEFAULT:
                return isIsDefault();
            case ProcessPackage.SEQUENCE_FLOW__CONDITION:
                return getCondition();
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
            case ProcessPackage.SEQUENCE_FLOW__QUANTITY:
                setQuantity((Integer)newValue);
                return;
            case ProcessPackage.SEQUENCE_FLOW__IS_DEFAULT:
                setIsDefault((Boolean)newValue);
                return;
            case ProcessPackage.SEQUENCE_FLOW__CONDITION:
                setCondition((String)newValue);
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
            case ProcessPackage.SEQUENCE_FLOW__QUANTITY:
                setQuantity(QUANTITY_EDEFAULT);
                return;
            case ProcessPackage.SEQUENCE_FLOW__IS_DEFAULT:
                setIsDefault(IS_DEFAULT_EDEFAULT);
                return;
            case ProcessPackage.SEQUENCE_FLOW__CONDITION:
                setCondition(CONDITION_EDEFAULT);
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
            case ProcessPackage.SEQUENCE_FLOW__QUANTITY:
                return QUANTITY_EDEFAULT == null ? quantity != null : !QUANTITY_EDEFAULT.equals(quantity);
            case ProcessPackage.SEQUENCE_FLOW__IS_DEFAULT:
                return isDefault != IS_DEFAULT_EDEFAULT;
            case ProcessPackage.SEQUENCE_FLOW__CONDITION:
                return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
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
        result.append(" (quantity: "); //$NON-NLS-1$
        result.append(quantity);
        result.append(", isDefault: "); //$NON-NLS-1$
        result.append(isDefault);
        result.append(", condition: "); //$NON-NLS-1$
        result.append(condition);
        result.append(')');
        return result.toString();
    }

} //SequenceFlowImpl
