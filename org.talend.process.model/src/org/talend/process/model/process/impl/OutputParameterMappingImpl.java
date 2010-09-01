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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.process.model.form.Widget;

import org.talend.process.model.process.Data;
import org.talend.process.model.process.OutputParameterMapping;
import org.talend.process.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.OutputParameterMappingImpl#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.OutputParameterMappingImpl#getTargetData <em>Target Data</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.OutputParameterMappingImpl#getAdditionalPath <em>Additional Path</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.OutputParameterMappingImpl#getTargetWidget <em>Target Widget</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputParameterMappingImpl extends EObjectImpl implements OutputParameterMapping {
    /**
     * The default value of the '{@link #getValueExpression() <em>Value Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueExpression()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValueExpression() <em>Value Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueExpression()
     * @generated
     * @ordered
     */
    protected String valueExpression = VALUE_EXPRESSION_EDEFAULT;

    /**
     * The cached value of the '{@link #getTargetData() <em>Target Data</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetData()
     * @generated
     * @ordered
     */
    protected Data targetData;

    /**
     * The default value of the '{@link #getAdditionalPath() <em>Additional Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAdditionalPath()
     * @generated
     * @ordered
     */
    protected static final String ADDITIONAL_PATH_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getAdditionalPath() <em>Additional Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAdditionalPath()
     * @generated
     * @ordered
     */
    protected String additionalPath = ADDITIONAL_PATH_EDEFAULT;

    /**
     * The cached value of the '{@link #getTargetWidget() <em>Target Widget</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetWidget()
     * @generated
     * @ordered
     */
    protected Widget targetWidget;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OutputParameterMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.OUTPUT_PARAMETER_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getValueExpression() {
        return valueExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValueExpression(String newValueExpression) {
        String oldValueExpression = valueExpression;
        valueExpression = newValueExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.OUTPUT_PARAMETER_MAPPING__VALUE_EXPRESSION, oldValueExpression, valueExpression));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data getTargetData() {
        if (targetData != null && targetData.eIsProxy()) {
            InternalEObject oldTargetData = (InternalEObject)targetData;
            targetData = (Data)eResolveProxy(oldTargetData);
            if (targetData != oldTargetData) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_DATA, oldTargetData, targetData));
            }
        }
        return targetData;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data basicGetTargetData() {
        return targetData;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetData(Data newTargetData) {
        Data oldTargetData = targetData;
        targetData = newTargetData;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_DATA, oldTargetData, targetData));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAdditionalPath() {
        return additionalPath;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAdditionalPath(String newAdditionalPath) {
        String oldAdditionalPath = additionalPath;
        additionalPath = newAdditionalPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.OUTPUT_PARAMETER_MAPPING__ADDITIONAL_PATH, oldAdditionalPath, additionalPath));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Widget getTargetWidget() {
        if (targetWidget != null && targetWidget.eIsProxy()) {
            InternalEObject oldTargetWidget = (InternalEObject)targetWidget;
            targetWidget = (Widget)eResolveProxy(oldTargetWidget);
            if (targetWidget != oldTargetWidget) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_WIDGET, oldTargetWidget, targetWidget));
            }
        }
        return targetWidget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Widget basicGetTargetWidget() {
        return targetWidget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetWidget(Widget newTargetWidget) {
        Widget oldTargetWidget = targetWidget;
        targetWidget = newTargetWidget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_WIDGET, oldTargetWidget, targetWidget));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__VALUE_EXPRESSION:
                return getValueExpression();
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_DATA:
                if (resolve) return getTargetData();
                return basicGetTargetData();
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__ADDITIONAL_PATH:
                return getAdditionalPath();
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_WIDGET:
                if (resolve) return getTargetWidget();
                return basicGetTargetWidget();
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
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__VALUE_EXPRESSION:
                setValueExpression((String)newValue);
                return;
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_DATA:
                setTargetData((Data)newValue);
                return;
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__ADDITIONAL_PATH:
                setAdditionalPath((String)newValue);
                return;
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_WIDGET:
                setTargetWidget((Widget)newValue);
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
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__VALUE_EXPRESSION:
                setValueExpression(VALUE_EXPRESSION_EDEFAULT);
                return;
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_DATA:
                setTargetData((Data)null);
                return;
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__ADDITIONAL_PATH:
                setAdditionalPath(ADDITIONAL_PATH_EDEFAULT);
                return;
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_WIDGET:
                setTargetWidget((Widget)null);
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
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__VALUE_EXPRESSION:
                return VALUE_EXPRESSION_EDEFAULT == null ? valueExpression != null : !VALUE_EXPRESSION_EDEFAULT.equals(valueExpression);
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_DATA:
                return targetData != null;
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__ADDITIONAL_PATH:
                return ADDITIONAL_PATH_EDEFAULT == null ? additionalPath != null : !ADDITIONAL_PATH_EDEFAULT.equals(additionalPath);
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING__TARGET_WIDGET:
                return targetWidget != null;
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
        result.append(" (valueExpression: "); //$NON-NLS-1$
        result.append(valueExpression);
        result.append(", additionalPath: "); //$NON-NLS-1$
        result.append(additionalPath);
        result.append(')');
        return result.toString();
    }

} //OutputParameterMappingImpl
