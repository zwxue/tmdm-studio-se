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
 * A representation of the model object '<em><b>Sequence Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.SequenceFlow#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link org.talend.process.model.process.SequenceFlow#isIsDefault <em>Is Default</em>}</li>
 *   <li>{@link org.talend.process.model.process.SequenceFlow#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getSequenceFlow()
 * @model
 * @generated
 */
public interface SequenceFlow extends Connection {
    /**
     * Returns the value of the '<em><b>Quantity</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Quantity</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Quantity</em>' attribute.
     * @see #setQuantity(Integer)
     * @see org.talend.process.model.process.ProcessPackage#getSequenceFlow_Quantity()
     * @model
     * @generated
     */
    Integer getQuantity();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.SequenceFlow#getQuantity <em>Quantity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Quantity</em>' attribute.
     * @see #getQuantity()
     * @generated
     */
    void setQuantity(Integer value);

    /**
     * Returns the value of the '<em><b>Is Default</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Default</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Default</em>' attribute.
     * @see #setIsDefault(boolean)
     * @see org.talend.process.model.process.ProcessPackage#getSequenceFlow_IsDefault()
     * @model default="false"
     * @generated
     */
    boolean isIsDefault();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.SequenceFlow#isIsDefault <em>Is Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Default</em>' attribute.
     * @see #isIsDefault()
     * @generated
     */
    void setIsDefault(boolean value);

    /**
     * Returns the value of the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Condition</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' attribute.
     * @see #setCondition(String)
     * @see org.talend.process.model.process.ProcessPackage#getSequenceFlow_Condition()
     * @model
     * @generated
     */
    String getCondition();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.SequenceFlow#getCondition <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition</em>' attribute.
     * @see #getCondition()
     * @generated
     */
    void setCondition(String value);

} // SequenceFlow
