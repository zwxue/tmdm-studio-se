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
package org.talend.process.model.kpi.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.process.model.kpi.KPIParameterMapping;
import org.talend.process.model.kpi.KpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>KPI Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.kpi.impl.KPIParameterMappingImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.KPIParameterMappingImpl#getKpiFieldName <em>Kpi Field Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KPIParameterMappingImpl extends EObjectImpl implements KPIParameterMapping {
    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #getKpiFieldName() <em>Kpi Field Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKpiFieldName()
     * @generated
     * @ordered
     */
    protected static final String KPI_FIELD_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getKpiFieldName() <em>Kpi Field Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKpiFieldName()
     * @generated
     * @ordered
     */
    protected String kpiFieldName = KPI_FIELD_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected KPIParameterMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return KpiPackage.Literals.KPI_PARAMETER_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.KPI_PARAMETER_MAPPING__VALUE, oldValue, value));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getKpiFieldName() {
        return kpiFieldName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKpiFieldName(String newKpiFieldName) {
        String oldKpiFieldName = kpiFieldName;
        kpiFieldName = newKpiFieldName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.KPI_PARAMETER_MAPPING__KPI_FIELD_NAME, oldKpiFieldName, kpiFieldName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case KpiPackage.KPI_PARAMETER_MAPPING__VALUE:
                return getValue();
            case KpiPackage.KPI_PARAMETER_MAPPING__KPI_FIELD_NAME:
                return getKpiFieldName();
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
            case KpiPackage.KPI_PARAMETER_MAPPING__VALUE:
                setValue((String)newValue);
                return;
            case KpiPackage.KPI_PARAMETER_MAPPING__KPI_FIELD_NAME:
                setKpiFieldName((String)newValue);
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
            case KpiPackage.KPI_PARAMETER_MAPPING__VALUE:
                setValue(VALUE_EDEFAULT);
                return;
            case KpiPackage.KPI_PARAMETER_MAPPING__KPI_FIELD_NAME:
                setKpiFieldName(KPI_FIELD_NAME_EDEFAULT);
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
            case KpiPackage.KPI_PARAMETER_MAPPING__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
            case KpiPackage.KPI_PARAMETER_MAPPING__KPI_FIELD_NAME:
                return KPI_FIELD_NAME_EDEFAULT == null ? kpiFieldName != null : !KPI_FIELD_NAME_EDEFAULT.equals(kpiFieldName);
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
        result.append(" (value: "); //$NON-NLS-1$
        result.append(value);
        result.append(", kpiFieldName: "); //$NON-NLS-1$
        result.append(kpiFieldName);
        result.append(')');
        return result.toString();
    }

} //KPIParameterMappingImpl
