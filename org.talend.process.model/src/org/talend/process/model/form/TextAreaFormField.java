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
package org.talend.process.model.form;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Area Form Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.form.TextAreaFormField#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link org.talend.process.model.form.TextAreaFormField#getMaxHeigth <em>Max Heigth</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.form.FormPackage#getTextAreaFormField()
 * @model
 * @generated
 */
public interface TextAreaFormField extends SingleValuatedFormField, Duplicable {
    /**
     * Returns the value of the '<em><b>Max Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max Length</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Max Length</em>' attribute.
     * @see #setMaxLength(int)
     * @see org.talend.process.model.form.FormPackage#getTextAreaFormField_MaxLength()
     * @model
     * @generated
     */
    int getMaxLength();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.TextAreaFormField#getMaxLength <em>Max Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max Length</em>' attribute.
     * @see #getMaxLength()
     * @generated
     */
    void setMaxLength(int value);

    /**
     * Returns the value of the '<em><b>Max Heigth</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max Heigth</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Max Heigth</em>' attribute.
     * @see #setMaxHeigth(int)
     * @see org.talend.process.model.form.FormPackage#getTextAreaFormField_MaxHeigth()
     * @model
     * @generated
     */
    int getMaxHeigth();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.TextAreaFormField#getMaxHeigth <em>Max Heigth</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max Heigth</em>' attribute.
     * @see #getMaxHeigth()
     * @generated
     */
    void setMaxHeigth(int value);

} // TextAreaFormField
