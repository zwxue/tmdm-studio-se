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
 * A representation of the model object '<em><b>Number Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.simulation.SimulationNumberRange#getMin <em>Min</em>}</li>
 *   <li>{@link org.talend.process.model.simulation.SimulationNumberRange#getMax <em>Max</em>}</li>
 *   <li>{@link org.talend.process.model.simulation.SimulationNumberRange#getProbability <em>Probability</em>}</li>
 *   <li>{@link org.talend.process.model.simulation.SimulationNumberRange#getRepartitionType <em>Repartition Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.simulation.SimulationPackage#getSimulationNumberRange()
 * @model
 * @generated
 */
public interface SimulationNumberRange extends EObject {
    /**
     * Returns the value of the '<em><b>Min</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Min</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Min</em>' attribute.
     * @see #setMin(long)
     * @see org.talend.process.model.simulation.SimulationPackage#getSimulationNumberRange_Min()
     * @model default="0" required="true"
     * @generated
     */
    long getMin();

    /**
     * Sets the value of the '{@link org.talend.process.model.simulation.SimulationNumberRange#getMin <em>Min</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Min</em>' attribute.
     * @see #getMin()
     * @generated
     */
    void setMin(long value);

    /**
     * Returns the value of the '<em><b>Max</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Max</em>' attribute.
     * @see #setMax(long)
     * @see org.talend.process.model.simulation.SimulationPackage#getSimulationNumberRange_Max()
     * @model default="0" required="true"
     * @generated
     */
    long getMax();

    /**
     * Sets the value of the '{@link org.talend.process.model.simulation.SimulationNumberRange#getMax <em>Max</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max</em>' attribute.
     * @see #getMax()
     * @generated
     */
    void setMax(long value);

    /**
     * Returns the value of the '<em><b>Probability</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Probability</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Probability</em>' attribute.
     * @see #setProbability(double)
     * @see org.talend.process.model.simulation.SimulationPackage#getSimulationNumberRange_Probability()
     * @model
     * @generated
     */
    double getProbability();

    /**
     * Sets the value of the '{@link org.talend.process.model.simulation.SimulationNumberRange#getProbability <em>Probability</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Probability</em>' attribute.
     * @see #getProbability()
     * @generated
     */
    void setProbability(double value);

    /**
     * Returns the value of the '<em><b>Repartition Type</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * The literals are from the enumeration {@link org.talend.process.model.simulation.RepartitionType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Repartition Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Repartition Type</em>' attribute.
     * @see org.talend.process.model.simulation.RepartitionType
     * @see #setRepartitionType(RepartitionType)
     * @see org.talend.process.model.simulation.SimulationPackage#getSimulationNumberRange_RepartitionType()
     * @model default="0" required="true"
     * @generated
     */
    RepartitionType getRepartitionType();

    /**
     * Sets the value of the '{@link org.talend.process.model.simulation.SimulationNumberRange#getRepartitionType <em>Repartition Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Repartition Type</em>' attribute.
     * @see org.talend.process.model.simulation.RepartitionType
     * @see #getRepartitionType()
     * @generated
     */
    void setRepartitionType(RepartitionType value);

} // SimulationNumberRange
