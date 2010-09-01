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
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.Connector#getConnectorId <em>Connector Id</em>}</li>
 *   <li>{@link org.talend.process.model.process.Connector#getConfigurationId <em>Configuration Id</em>}</li>
 *   <li>{@link org.talend.process.model.process.Connector#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.talend.process.model.process.Connector#getEvent <em>Event</em>}</li>
 *   <li>{@link org.talend.process.model.process.Connector#isIgnoreErrors <em>Ignore Errors</em>}</li>
 *   <li>{@link org.talend.process.model.process.Connector#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getConnector()
 * @model
 * @generated
 */
public interface Connector extends Element {
    /**
     * Returns the value of the '<em><b>Connector Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connector Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connector Id</em>' attribute.
     * @see #setConnectorId(String)
     * @see org.talend.process.model.process.ProcessPackage#getConnector_ConnectorId()
     * @model
     * @generated
     */
    String getConnectorId();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Connector#getConnectorId <em>Connector Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connector Id</em>' attribute.
     * @see #getConnectorId()
     * @generated
     */
    void setConnectorId(String value);

    /**
     * Returns the value of the '<em><b>Configuration Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configuration Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Configuration Id</em>' attribute.
     * @see #setConfigurationId(String)
     * @see org.talend.process.model.process.ProcessPackage#getConnector_ConfigurationId()
     * @model
     * @generated
     */
    String getConfigurationId();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Connector#getConfigurationId <em>Configuration Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configuration Id</em>' attribute.
     * @see #getConfigurationId()
     * @generated
     */
    void setConfigurationId(String value);

    /**
     * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Parameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameters</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getConnector_Parameters()
     * @model containment="true"
     * @generated
     */
    EList<Parameter> getParameters();

    /**
     * Returns the value of the '<em><b>Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Event</em>' attribute.
     * @see #setEvent(String)
     * @see org.talend.process.model.process.ProcessPackage#getConnector_Event()
     * @model
     * @generated
     */
    String getEvent();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Connector#getEvent <em>Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Event</em>' attribute.
     * @see #getEvent()
     * @generated
     */
    void setEvent(String value);

    /**
     * Returns the value of the '<em><b>Ignore Errors</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ignore Errors</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ignore Errors</em>' attribute.
     * @see #setIgnoreErrors(boolean)
     * @see org.talend.process.model.process.ProcessPackage#getConnector_IgnoreErrors()
     * @model
     * @generated
     */
    boolean isIgnoreErrors();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Connector#isIgnoreErrors <em>Ignore Errors</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ignore Errors</em>' attribute.
     * @see #isIgnoreErrors()
     * @generated
     */
    void setIgnoreErrors(boolean value);

    /**
     * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.OutputParameterMapping}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outputs</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getConnector_Outputs()
     * @model containment="true"
     * @generated
     */
    EList<OutputParameterMapping> getOutputs();

} // Connector
