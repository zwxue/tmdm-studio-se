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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Instantiation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.MultiInstantiation#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.talend.process.model.process.MultiInstantiation#getActivityData <em>Activity Data</em>}</li>
 *   <li>{@link org.talend.process.model.process.MultiInstantiation#getInstantiator <em>Instantiator</em>}</li>
 *   <li>{@link org.talend.process.model.process.MultiInstantiation#getJoinChecker <em>Join Checker</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getMultiInstantiation()
 * @model
 * @generated
 */
public interface MultiInstantiation extends Connector {
    /**
     * Returns the value of the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enabled</em>' attribute.
     * @see #setEnabled(boolean)
     * @see org.talend.process.model.process.ProcessPackage#getMultiInstantiation_Enabled()
     * @model
     * @generated
     */
    boolean isEnabled();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.MultiInstantiation#isEnabled <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enabled</em>' attribute.
     * @see #isEnabled()
     * @generated
     */
    void setEnabled(boolean value);

    /**
     * Returns the value of the '<em><b>Activity Data</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Activity Data</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Activity Data</em>' reference.
     * @see #setActivityData(Data)
     * @see org.talend.process.model.process.ProcessPackage#getMultiInstantiation_ActivityData()
     * @model
     * @generated
     */
    Data getActivityData();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.MultiInstantiation#getActivityData <em>Activity Data</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Activity Data</em>' reference.
     * @see #getActivityData()
     * @generated
     */
    void setActivityData(Data value);

    /**
     * Returns the value of the '<em><b>Instantiator</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instantiator</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instantiator</em>' containment reference.
     * @see #setInstantiator(Connector)
     * @see org.talend.process.model.process.ProcessPackage#getMultiInstantiation_Instantiator()
     * @model containment="true"
     * @generated
     */
    Connector getInstantiator();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.MultiInstantiation#getInstantiator <em>Instantiator</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instantiator</em>' containment reference.
     * @see #getInstantiator()
     * @generated
     */
    void setInstantiator(Connector value);

    /**
     * Returns the value of the '<em><b>Join Checker</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Join Checker</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Join Checker</em>' containment reference.
     * @see #setJoinChecker(Connector)
     * @see org.talend.process.model.process.ProcessPackage#getMultiInstantiation_JoinChecker()
     * @model containment="true"
     * @generated
     */
    Connector getJoinChecker();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.MultiInstantiation#getJoinChecker <em>Join Checker</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Join Checker</em>' containment reference.
     * @see #getJoinChecker()
     * @generated
     */
    void setJoinChecker(Connector value);

} // MultiInstantiation
