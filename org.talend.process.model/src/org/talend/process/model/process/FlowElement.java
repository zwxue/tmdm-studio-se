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
package org.talend.process.model.process;

import org.talend.process.model.simulation.SimulationActivity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.FlowElement#getSynchronous <em>Synchronous</em>}</li>
 *   <li>{@link org.talend.process.model.process.FlowElement#getDynamicLabel <em>Dynamic Label</em>}</li>
 *   <li>{@link org.talend.process.model.process.FlowElement#getDynamicDescription <em>Dynamic Description</em>}</li>
 *   <li>{@link org.talend.process.model.process.FlowElement#getStepSummary <em>Step Summary</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getFlowElement()
 * @model
 * @generated
 */
public interface FlowElement extends Element, SimulationActivity, SourceElement, TargetElement {
    /**
     * Returns the value of the '<em><b>Synchronous</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Synchronous</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Synchronous</em>' attribute.
     * @see #setSynchronous(Boolean)
     * @see org.talend.process.model.process.ProcessPackage#getFlowElement_Synchronous()
     * @model default="true" required="true"
     * @generated
     */
    Boolean getSynchronous();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.FlowElement#getSynchronous <em>Synchronous</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Synchronous</em>' attribute.
     * @see #getSynchronous()
     * @generated
     */
    void setSynchronous(Boolean value);

    /**
     * Returns the value of the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dynamic Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dynamic Label</em>' attribute.
     * @see #setDynamicLabel(String)
     * @see org.talend.process.model.process.ProcessPackage#getFlowElement_DynamicLabel()
     * @model
     * @generated
     */
    String getDynamicLabel();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.FlowElement#getDynamicLabel <em>Dynamic Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dynamic Label</em>' attribute.
     * @see #getDynamicLabel()
     * @generated
     */
    void setDynamicLabel(String value);

    /**
     * Returns the value of the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dynamic Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dynamic Description</em>' attribute.
     * @see #setDynamicDescription(String)
     * @see org.talend.process.model.process.ProcessPackage#getFlowElement_DynamicDescription()
     * @model
     * @generated
     */
    String getDynamicDescription();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.FlowElement#getDynamicDescription <em>Dynamic Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dynamic Description</em>' attribute.
     * @see #getDynamicDescription()
     * @generated
     */
    void setDynamicDescription(String value);

    /**
     * Returns the value of the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Step Summary</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Step Summary</em>' attribute.
     * @see #setStepSummary(String)
     * @see org.talend.process.model.process.ProcessPackage#getFlowElement_StepSummary()
     * @model
     * @generated
     */
    String getStepSummary();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.FlowElement#getStepSummary <em>Step Summary</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Step Summary</em>' attribute.
     * @see #getStepSummary()
     * @generated
     */
    void setStepSummary(String value);

} // FlowElement
