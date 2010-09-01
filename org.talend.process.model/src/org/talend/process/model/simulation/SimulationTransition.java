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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.simulation.SimulationTransition#getProbability <em>Probability</em>}</li>
 *   <li>{@link org.talend.process.model.simulation.SimulationTransition#isDataBased <em>Data Based</em>}</li>
 *   <li>{@link org.talend.process.model.simulation.SimulationTransition#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.talend.process.model.simulation.SimulationTransition#isUseExpression <em>Use Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.simulation.SimulationPackage#getSimulationTransition()
 * @model
 * @generated
 */
public interface SimulationTransition extends EObject {
    /**
     * Returns the value of the '<em><b>Probability</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Probability</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Probability</em>' attribute.
     * @see #setProbability(double)
     * @see org.talend.process.model.simulation.SimulationPackage#getSimulationTransition_Probability()
     * @model default="1" required="true"
     * @generated
     */
    double getProbability();

    /**
     * Sets the value of the '{@link org.talend.process.model.simulation.SimulationTransition#getProbability <em>Probability</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Probability</em>' attribute.
     * @see #getProbability()
     * @generated
     */
    void setProbability(double value);

    /**
     * Returns the value of the '<em><b>Data Based</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Based</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Based</em>' attribute.
     * @see #setDataBased(boolean)
     * @see org.talend.process.model.simulation.SimulationPackage#getSimulationTransition_DataBased()
     * @model
     * @generated
     */
    boolean isDataBased();

    /**
     * Sets the value of the '{@link org.talend.process.model.simulation.SimulationTransition#isDataBased <em>Data Based</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Based</em>' attribute.
     * @see #isDataBased()
     * @generated
     */
    void setDataBased(boolean value);

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
     * @see org.talend.process.model.simulation.SimulationPackage#getSimulationTransition_Expression()
     * @model
     * @generated
     */
    String getExpression();

    /**
     * Sets the value of the '{@link org.talend.process.model.simulation.SimulationTransition#getExpression <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression</em>' attribute.
     * @see #getExpression()
     * @generated
     */
    void setExpression(String value);

    /**
     * Returns the value of the '<em><b>Use Expression</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Use Expression</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Use Expression</em>' attribute.
     * @see #setUseExpression(boolean)
     * @see org.talend.process.model.simulation.SimulationPackage#getSimulationTransition_UseExpression()
     * @model default="false"
     * @generated
     */
    boolean isUseExpression();

    /**
     * Sets the value of the '{@link org.talend.process.model.simulation.SimulationTransition#isUseExpression <em>Use Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Use Expression</em>' attribute.
     * @see #isUseExpression()
     * @generated
     */
    void setUseExpression(boolean value);

} // SimulationTransition
