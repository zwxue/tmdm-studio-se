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
package org.talend.process.model.simulation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.simulation.SimulationData#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.talend.process.model.simulation.SimulationData#isExpressionBased <em>Expression Based</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.simulation.SimulationPackage#getSimulationData()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SimulationData extends SimulationElement {
    /**
     * Returns the value of the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expression</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expression</em>' attribute.
     * @see #setExpression(String)
     * @see org.talend.process.model.simulation.SimulationPackage#getSimulationData_Expression()
     * @model
     * @generated
     */
    String getExpression();

    /**
     * Sets the value of the '{@link org.talend.process.model.simulation.SimulationData#getExpression <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression</em>' attribute.
     * @see #getExpression()
     * @generated
     */
    void setExpression(String value);

    /**
     * Returns the value of the '<em><b>Expression Based</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expression Based</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expression Based</em>' attribute.
     * @see #setExpressionBased(boolean)
     * @see org.talend.process.model.simulation.SimulationPackage#getSimulationData_ExpressionBased()
     * @model default="true" required="true"
     * @generated
     */
    boolean isExpressionBased();

    /**
     * Sets the value of the '{@link org.talend.process.model.simulation.SimulationData#isExpressionBased <em>Expression Based</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression Based</em>' attribute.
     * @see #isExpressionBased()
     * @generated
     */
    void setExpressionBased(boolean value);

} // SimulationData
