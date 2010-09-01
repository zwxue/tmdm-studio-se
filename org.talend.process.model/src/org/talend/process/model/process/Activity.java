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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.Activity#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.talend.process.model.process.Activity#getDeadlines <em>Deadlines</em>}</li>
 *   <li>{@link org.talend.process.model.process.Activity#getMultiInstantiation <em>Multi Instantiation</em>}</li>
 *   <li>{@link org.talend.process.model.process.Activity#getIsLoop <em>Is Loop</em>}</li>
 *   <li>{@link org.talend.process.model.process.Activity#getTestBefore <em>Test Before</em>}</li>
 *   <li>{@link org.talend.process.model.process.Activity#getLoopCondition <em>Loop Condition</em>}</li>
 *   <li>{@link org.talend.process.model.process.Activity#getLoopMaximum <em>Loop Maximum</em>}</li>
 *   <li>{@link org.talend.process.model.process.Activity#getBoundaryIntermediateEvents <em>Boundary Intermediate Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getActivity()
 * @model
 * @generated
 */
public interface Activity extends FlowElement, ConnectableElement {
    /**
     * Returns the value of the '<em><b>Duration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Duration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Duration</em>' attribute.
     * @see #setDuration(String)
     * @see org.talend.process.model.process.ProcessPackage#getActivity_Duration()
     * @model
     * @generated
     */
    String getDuration();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Activity#getDuration <em>Duration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Duration</em>' attribute.
     * @see #getDuration()
     * @generated
     */
    void setDuration(String value);

    /**
     * Returns the value of the '<em><b>Deadlines</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Deadline}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Deadlines</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deadlines</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getActivity_Deadlines()
     * @model containment="true"
     * @generated
     */
    EList<Deadline> getDeadlines();

    /**
     * Returns the value of the '<em><b>Multi Instantiation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Multi Instantiation</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Multi Instantiation</em>' containment reference.
     * @see #setMultiInstantiation(MultiInstantiation)
     * @see org.talend.process.model.process.ProcessPackage#getActivity_MultiInstantiation()
     * @model containment="true"
     * @generated
     */
    MultiInstantiation getMultiInstantiation();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Activity#getMultiInstantiation <em>Multi Instantiation</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Multi Instantiation</em>' containment reference.
     * @see #getMultiInstantiation()
     * @generated
     */
    void setMultiInstantiation(MultiInstantiation value);

    /**
     * Returns the value of the '<em><b>Is Loop</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Loop</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Loop</em>' attribute.
     * @see #setIsLoop(Boolean)
     * @see org.talend.process.model.process.ProcessPackage#getActivity_IsLoop()
     * @model default="false"
     * @generated
     */
    Boolean getIsLoop();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Activity#getIsLoop <em>Is Loop</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Loop</em>' attribute.
     * @see #getIsLoop()
     * @generated
     */
    void setIsLoop(Boolean value);

    /**
     * Returns the value of the '<em><b>Test Before</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Test Before</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Test Before</em>' attribute.
     * @see #setTestBefore(Boolean)
     * @see org.talend.process.model.process.ProcessPackage#getActivity_TestBefore()
     * @model default="false"
     * @generated
     */
    Boolean getTestBefore();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Activity#getTestBefore <em>Test Before</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Test Before</em>' attribute.
     * @see #getTestBefore()
     * @generated
     */
    void setTestBefore(Boolean value);

    /**
     * Returns the value of the '<em><b>Loop Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Loop Condition</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Loop Condition</em>' attribute.
     * @see #setLoopCondition(String)
     * @see org.talend.process.model.process.ProcessPackage#getActivity_LoopCondition()
     * @model
     * @generated
     */
    String getLoopCondition();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Activity#getLoopCondition <em>Loop Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Loop Condition</em>' attribute.
     * @see #getLoopCondition()
     * @generated
     */
    void setLoopCondition(String value);

    /**
     * Returns the value of the '<em><b>Loop Maximum</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Loop Maximum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Loop Maximum</em>' attribute.
     * @see #setLoopMaximum(String)
     * @see org.talend.process.model.process.ProcessPackage#getActivity_LoopMaximum()
     * @model default=""
     * @generated
     */
    String getLoopMaximum();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Activity#getLoopMaximum <em>Loop Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Loop Maximum</em>' attribute.
     * @see #getLoopMaximum()
     * @generated
     */
    void setLoopMaximum(String value);

    /**
     * Returns the value of the '<em><b>Boundary Intermediate Events</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.IntermediateErrorCatchEvent}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Boundary Intermediate Events</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Boundary Intermediate Events</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getActivity_BoundaryIntermediateEvents()
     * @model containment="true"
     * @generated
     */
    EList<IntermediateErrorCatchEvent> getBoundaryIntermediateEvents();

} // Activity
