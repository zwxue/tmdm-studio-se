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
 * A representation of the model object '<em><b>Database KPI Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.kpi.DatabaseKPIBinding#getDatabaseConfiguration <em>Database Configuration</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.DatabaseKPIBinding#getTableName <em>Table Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.kpi.KpiPackage#getDatabaseKPIBinding()
 * @model
 * @generated
 */
public interface DatabaseKPIBinding extends AbstractKPIBinding {
    /**
     * Returns the value of the '<em><b>Database Configuration</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Database Configuration</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Database Configuration</em>' containment reference.
     * @see #setDatabaseConfiguration(DatabaseConfiguration)
     * @see org.talend.process.model.kpi.KpiPackage#getDatabaseKPIBinding_DatabaseConfiguration()
     * @model containment="true"
     * @generated
     */
    DatabaseConfiguration getDatabaseConfiguration();

    /**
     * Sets the value of the '{@link org.talend.process.model.kpi.DatabaseKPIBinding#getDatabaseConfiguration <em>Database Configuration</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database Configuration</em>' containment reference.
     * @see #getDatabaseConfiguration()
     * @generated
     */
    void setDatabaseConfiguration(DatabaseConfiguration value);

    /**
     * Returns the value of the '<em><b>Table Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Table Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Table Name</em>' attribute.
     * @see #setTableName(String)
     * @see org.talend.process.model.kpi.KpiPackage#getDatabaseKPIBinding_TableName()
     * @model
     * @generated
     */
    String getTableName();

    /**
     * Sets the value of the '{@link org.talend.process.model.kpi.DatabaseKPIBinding#getTableName <em>Table Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Table Name</em>' attribute.
     * @see #getTableName()
     * @generated
     */
    void setTableName(String value);

} // DatabaseKPIBinding
