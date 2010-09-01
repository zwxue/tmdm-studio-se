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

import org.talend.process.model.form.Form;
import org.talend.process.model.form.ViewForm;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.PageFlow#getForm <em>Form</em>}</li>
 *   <li>{@link org.talend.process.model.process.PageFlow#getByPassFormsGeneration <em>By Pass Forms Generation</em>}</li>
 *   <li>{@link org.talend.process.model.process.PageFlow#getConfirmationTemplate <em>Confirmation Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.PageFlow#getConfirmationMessage <em>Confirmation Message</em>}</li>
 *   <li>{@link org.talend.process.model.process.PageFlow#getRegExpToHideDefaultField <em>Reg Exp To Hide Default Field</em>}</li>
 *   <li>{@link org.talend.process.model.process.PageFlow#isUseRegExpToHideDefaultField <em>Use Reg Exp To Hide Default Field</em>}</li>
 *   <li>{@link org.talend.process.model.process.PageFlow#getViewForm <em>View Form</em>}</li>
 *   <li>{@link org.talend.process.model.process.PageFlow#isUseViewForm <em>Use View Form</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getPageFlow()
 * @model
 * @generated
 */
public interface PageFlow extends ConnectableElement {
    /**
     * Returns the value of the '<em><b>Form</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.form.Form}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Form</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Form</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getPageFlow_Form()
     * @model containment="true"
     * @generated
     */
    EList<Form> getForm();

    /**
     * Returns the value of the '<em><b>By Pass Forms Generation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>By Pass Forms Generation</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>By Pass Forms Generation</em>' attribute.
     * @see #setByPassFormsGeneration(Boolean)
     * @see org.talend.process.model.process.ProcessPackage#getPageFlow_ByPassFormsGeneration()
     * @model
     * @generated
     */
    Boolean getByPassFormsGeneration();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.PageFlow#getByPassFormsGeneration <em>By Pass Forms Generation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>By Pass Forms Generation</em>' attribute.
     * @see #getByPassFormsGeneration()
     * @generated
     */
    void setByPassFormsGeneration(Boolean value);

    /**
     * Returns the value of the '<em><b>Confirmation Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Confirmation Template</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Confirmation Template</em>' containment reference.
     * @see #setConfirmationTemplate(AssociatedFile)
     * @see org.talend.process.model.process.ProcessPackage#getPageFlow_ConfirmationTemplate()
     * @model containment="true"
     * @generated
     */
    AssociatedFile getConfirmationTemplate();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.PageFlow#getConfirmationTemplate <em>Confirmation Template</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Confirmation Template</em>' containment reference.
     * @see #getConfirmationTemplate()
     * @generated
     */
    void setConfirmationTemplate(AssociatedFile value);

    /**
     * Returns the value of the '<em><b>Confirmation Message</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Confirmation Message</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Confirmation Message</em>' attribute.
     * @see #setConfirmationMessage(String)
     * @see org.talend.process.model.process.ProcessPackage#getPageFlow_ConfirmationMessage()
     * @model
     * @generated
     */
    String getConfirmationMessage();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.PageFlow#getConfirmationMessage <em>Confirmation Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Confirmation Message</em>' attribute.
     * @see #getConfirmationMessage()
     * @generated
     */
    void setConfirmationMessage(String value);

    /**
     * Returns the value of the '<em><b>Reg Exp To Hide Default Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reg Exp To Hide Default Field</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reg Exp To Hide Default Field</em>' attribute.
     * @see #setRegExpToHideDefaultField(String)
     * @see org.talend.process.model.process.ProcessPackage#getPageFlow_RegExpToHideDefaultField()
     * @model
     * @generated
     */
    String getRegExpToHideDefaultField();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.PageFlow#getRegExpToHideDefaultField <em>Reg Exp To Hide Default Field</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reg Exp To Hide Default Field</em>' attribute.
     * @see #getRegExpToHideDefaultField()
     * @generated
     */
    void setRegExpToHideDefaultField(String value);

    /**
     * Returns the value of the '<em><b>Use Reg Exp To Hide Default Field</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Use Reg Exp To Hide Default Field</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Use Reg Exp To Hide Default Field</em>' attribute.
     * @see #setUseRegExpToHideDefaultField(boolean)
     * @see org.talend.process.model.process.ProcessPackage#getPageFlow_UseRegExpToHideDefaultField()
     * @model default="false"
     * @generated
     */
    boolean isUseRegExpToHideDefaultField();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.PageFlow#isUseRegExpToHideDefaultField <em>Use Reg Exp To Hide Default Field</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Use Reg Exp To Hide Default Field</em>' attribute.
     * @see #isUseRegExpToHideDefaultField()
     * @generated
     */
    void setUseRegExpToHideDefaultField(boolean value);

    /**
     * Returns the value of the '<em><b>View Form</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.form.ViewForm}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>View Form</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>View Form</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getPageFlow_ViewForm()
     * @model containment="true"
     * @generated
     */
    EList<ViewForm> getViewForm();

    /**
     * Returns the value of the '<em><b>Use View Form</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Use View Form</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Use View Form</em>' attribute.
     * @see #setUseViewForm(boolean)
     * @see org.talend.process.model.process.ProcessPackage#getPageFlow_UseViewForm()
     * @model default="false"
     * @generated
     */
    boolean isUseViewForm();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.PageFlow#isUseViewForm <em>Use View Form</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Use View Form</em>' attribute.
     * @see #isUseViewForm()
     * @generated
     */
    void setUseViewForm(boolean value);

} // PageFlow
