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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.InputMapping#getProcessSource <em>Process Source</em>}</li>
 *   <li>{@link org.talend.process.model.process.InputMapping#getSubprocessTarget <em>Subprocess Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getInputMapping()
 * @model
 * @generated
 */
public interface InputMapping extends EObject {
    /**
     * Returns the value of the '<em><b>Process Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Process Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Process Source</em>' reference.
     * @see #setProcessSource(Data)
     * @see org.talend.process.model.process.ProcessPackage#getInputMapping_ProcessSource()
     * @model
     * @generated
     */
    Data getProcessSource();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.InputMapping#getProcessSource <em>Process Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Process Source</em>' reference.
     * @see #getProcessSource()
     * @generated
     */
    void setProcessSource(Data value);

    /**
     * Returns the value of the '<em><b>Subprocess Target</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Subprocess Target</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Subprocess Target</em>' attribute.
     * @see #setSubprocessTarget(String)
     * @see org.talend.process.model.process.ProcessPackage#getInputMapping_SubprocessTarget()
     * @model
     * @generated
     */
    String getSubprocessTarget();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.InputMapping#getSubprocessTarget <em>Subprocess Target</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Subprocess Target</em>' attribute.
     * @see #getSubprocessTarget()
     * @generated
     */
    void setSubprocessTarget(String value);

} // InputMapping
