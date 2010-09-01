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
 * A representation of the model object '<em><b>Sub Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.SubProcess#getSubprocessName <em>Subprocess Name</em>}</li>
 *   <li>{@link org.talend.process.model.process.SubProcess#getSubprocessVersion <em>Subprocess Version</em>}</li>
 *   <li>{@link org.talend.process.model.process.SubProcess#getInputMappings <em>Input Mappings</em>}</li>
 *   <li>{@link org.talend.process.model.process.SubProcess#getOutputMappings <em>Output Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getSubProcess()
 * @model
 * @generated
 */
public interface SubProcess extends Activity {
    /**
     * Returns the value of the '<em><b>Subprocess Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Subprocess Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Subprocess Name</em>' attribute.
     * @see #setSubprocessName(String)
     * @see org.talend.process.model.process.ProcessPackage#getSubProcess_SubprocessName()
     * @model
     * @generated
     */
    String getSubprocessName();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.SubProcess#getSubprocessName <em>Subprocess Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Subprocess Name</em>' attribute.
     * @see #getSubprocessName()
     * @generated
     */
    void setSubprocessName(String value);

    /**
     * Returns the value of the '<em><b>Subprocess Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Subprocess Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Subprocess Version</em>' attribute.
     * @see #setSubprocessVersion(String)
     * @see org.talend.process.model.process.ProcessPackage#getSubProcess_SubprocessVersion()
     * @model
     * @generated
     */
    String getSubprocessVersion();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.SubProcess#getSubprocessVersion <em>Subprocess Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Subprocess Version</em>' attribute.
     * @see #getSubprocessVersion()
     * @generated
     */
    void setSubprocessVersion(String value);

    /**
     * Returns the value of the '<em><b>Input Mappings</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.InputMapping}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Mappings</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getSubProcess_InputMappings()
     * @model containment="true"
     * @generated
     */
    EList<InputMapping> getInputMappings();

    /**
     * Returns the value of the '<em><b>Output Mappings</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.OutputMapping}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Mappings</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getSubProcess_OutputMappings()
     * @model containment="true"
     * @generated
     */
    EList<OutputMapping> getOutputMappings();

} // SubProcess
