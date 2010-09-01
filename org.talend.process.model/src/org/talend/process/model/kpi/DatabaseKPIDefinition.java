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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database KPI Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.kpi.DatabaseKPIDefinition#getDefaultConfiguration <em>Default Configuration</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.DatabaseKPIDefinition#getDefaultTableName <em>Default Table Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.kpi.KpiPackage#getDatabaseKPIDefinition()
 * @model
 * @generated
 */
public interface DatabaseKPIDefinition extends AbstractKPIDefinition {
    /**
     * Returns the value of the '<em><b>Default Configuration</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Configuration</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Configuration</em>' containment reference.
     * @see #setDefaultConfiguration(DatabaseConfiguration)
     * @see org.talend.process.model.kpi.KpiPackage#getDatabaseKPIDefinition_DefaultConfiguration()
     * @model containment="true"
     * @generated
     */
    DatabaseConfiguration getDefaultConfiguration();

    /**
     * Sets the value of the '{@link org.talend.process.model.kpi.DatabaseKPIDefinition#getDefaultConfiguration <em>Default Configuration</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Configuration</em>' containment reference.
     * @see #getDefaultConfiguration()
     * @generated
     */
    void setDefaultConfiguration(DatabaseConfiguration value);

    /**
     * Returns the value of the '<em><b>Default Table Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Table Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Table Name</em>' attribute.
     * @see #setDefaultTableName(String)
     * @see org.talend.process.model.kpi.KpiPackage#getDatabaseKPIDefinition_DefaultTableName()
     * @model
     * @generated
     */
    String getDefaultTableName();

    /**
     * Sets the value of the '{@link org.talend.process.model.kpi.DatabaseKPIDefinition#getDefaultTableName <em>Default Table Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Table Name</em>' attribute.
     * @see #getDefaultTableName()
     * @generated
     */
    void setDefaultTableName(String value);

} // DatabaseKPIDefinition
