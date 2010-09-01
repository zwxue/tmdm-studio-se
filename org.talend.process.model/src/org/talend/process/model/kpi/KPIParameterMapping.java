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
package org.talend.process.model.kpi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KPI Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.kpi.KPIParameterMapping#getValue <em>Value</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.KPIParameterMapping#getKpiFieldName <em>Kpi Field Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.kpi.KpiPackage#getKPIParameterMapping()
 * @model
 * @generated
 */
public interface KPIParameterMapping extends EObject {
    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see org.talend.process.model.kpi.KpiPackage#getKPIParameterMapping_Value()
     * @model
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.talend.process.model.kpi.KPIParameterMapping#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Kpi Field Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Kpi Field Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Kpi Field Name</em>' attribute.
     * @see #setKpiFieldName(String)
     * @see org.talend.process.model.kpi.KpiPackage#getKPIParameterMapping_KpiFieldName()
     * @model
     * @generated
     */
    String getKpiFieldName();

    /**
     * Sets the value of the '{@link org.talend.process.model.kpi.KPIParameterMapping#getKpiFieldName <em>Kpi Field Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Kpi Field Name</em>' attribute.
     * @see #getKpiFieldName()
     * @generated
     */
    void setKpiFieldName(String value);

} // KPIParameterMapping
