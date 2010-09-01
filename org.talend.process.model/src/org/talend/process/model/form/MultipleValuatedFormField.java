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

import org.eclipse.emf.common.util.EList;

import org.talend.process.model.process.Connector;
import org.talend.process.model.process.Data;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiple Valuated Form Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.form.MultipleValuatedFormField#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.talend.process.model.form.MultipleValuatedFormField#getDefaultValueAfterEvent <em>Default Value After Event</em>}</li>
 *   <li>{@link org.talend.process.model.form.MultipleValuatedFormField#getEnum <em>Enum</em>}</li>
 *   <li>{@link org.talend.process.model.form.MultipleValuatedFormField#getEnumAfterEvent <em>Enum After Event</em>}</li>
 *   <li>{@link org.talend.process.model.form.MultipleValuatedFormField#getLiterals <em>Literals</em>}</li>
 *   <li>{@link org.talend.process.model.form.MultipleValuatedFormField#getLiteralsAfterEvent <em>Literals After Event</em>}</li>
 *   <li>{@link org.talend.process.model.form.MultipleValuatedFormField#getDefaultConnectors <em>Default Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.MultipleValuatedFormField#getDefaultAfterEventConnectors <em>Default After Event Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.form.FormPackage#getMultipleValuatedFormField()
 * @model abstract="true"
 * @generated
 */
public interface MultipleValuatedFormField extends FormField {
    /**
     * Returns the value of the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Value</em>' attribute.
     * @see #setDefaultValue(String)
     * @see org.talend.process.model.form.FormPackage#getMultipleValuatedFormField_DefaultValue()
     * @model
     * @generated
     */
    String getDefaultValue();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.MultipleValuatedFormField#getDefaultValue <em>Default Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Value</em>' attribute.
     * @see #getDefaultValue()
     * @generated
     */
    void setDefaultValue(String value);

    /**
     * Returns the value of the '<em><b>Default Value After Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Value After Event</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Value After Event</em>' attribute.
     * @see #setDefaultValueAfterEvent(String)
     * @see org.talend.process.model.form.FormPackage#getMultipleValuatedFormField_DefaultValueAfterEvent()
     * @model
     * @generated
     */
    String getDefaultValueAfterEvent();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.MultipleValuatedFormField#getDefaultValueAfterEvent <em>Default Value After Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Value After Event</em>' attribute.
     * @see #getDefaultValueAfterEvent()
     * @generated
     */
    void setDefaultValueAfterEvent(String value);

    /**
     * Returns the value of the '<em><b>Enum</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enum</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enum</em>' reference.
     * @see #setEnum(Data)
     * @see org.talend.process.model.form.FormPackage#getMultipleValuatedFormField_Enum()
     * @model
     * @generated
     */
    Data getEnum();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.MultipleValuatedFormField#getEnum <em>Enum</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enum</em>' reference.
     * @see #getEnum()
     * @generated
     */
    void setEnum(Data value);

    /**
     * Returns the value of the '<em><b>Enum After Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * enum used for dependencies between widget.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Enum After Event</em>' reference.
     * @see #setEnumAfterEvent(Data)
     * @see org.talend.process.model.form.FormPackage#getMultipleValuatedFormField_EnumAfterEvent()
     * @model
     * @generated
     */
    Data getEnumAfterEvent();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.MultipleValuatedFormField#getEnumAfterEvent <em>Enum After Event</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enum After Event</em>' reference.
     * @see #getEnumAfterEvent()
     * @generated
     */
    void setEnumAfterEvent(Data value);

    /**
     * Returns the value of the '<em><b>Literals</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Literals</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Literals</em>' attribute list.
     * @see org.talend.process.model.form.FormPackage#getMultipleValuatedFormField_Literals()
     * @model
     * @generated
     */
    EList<String> getLiterals();

    /**
     * Returns the value of the '<em><b>Literals After Event</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * literals used on dependencies management.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Literals After Event</em>' attribute list.
     * @see org.talend.process.model.form.FormPackage#getMultipleValuatedFormField_LiteralsAfterEvent()
     * @model
     * @generated
     */
    EList<String> getLiteralsAfterEvent();

    /**
     * Returns the value of the '<em><b>Default Connectors</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Connector}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Connectors</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Connectors</em>' containment reference list.
     * @see org.talend.process.model.form.FormPackage#getMultipleValuatedFormField_DefaultConnectors()
     * @model containment="true"
     * @generated
     */
    EList<Connector> getDefaultConnectors();

    /**
     * Returns the value of the '<em><b>Default After Event Connectors</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Connector}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default After Event Connectors</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default After Event Connectors</em>' containment reference list.
     * @see org.talend.process.model.form.FormPackage#getMultipleValuatedFormField_DefaultAfterEventConnectors()
     * @model containment="true"
     * @generated
     */
    EList<Connector> getDefaultAfterEventConnectors();

} // MultipleValuatedFormField
