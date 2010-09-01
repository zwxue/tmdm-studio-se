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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Duplicable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Add option to choose if a widget can be dynamically duplicated
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.form.Duplicable#isDuplicate <em>Duplicate</em>}</li>
 *   <li>{@link org.talend.process.model.form.Duplicable#isLimitNumberOfDuplication <em>Limit Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.Duplicable#getMaxNumberOfDuplication <em>Max Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.Duplicable#isLimitMinNumberOfDuplication <em>Limit Min Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.Duplicable#getMinNumberOfDuplication <em>Min Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.Duplicable#getDisplayLabelForAdd <em>Display Label For Add</em>}</li>
 *   <li>{@link org.talend.process.model.form.Duplicable#getTooltipForAdd <em>Tooltip For Add</em>}</li>
 *   <li>{@link org.talend.process.model.form.Duplicable#getDisplayLabelForRemove <em>Display Label For Remove</em>}</li>
 *   <li>{@link org.talend.process.model.form.Duplicable#getTooltipForRemove <em>Tooltip For Remove</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.form.FormPackage#getDuplicable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Duplicable extends EObject {
    /**
     * Returns the value of the '<em><b>Duplicate</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Duplicate</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Duplicate</em>' attribute.
     * @see #setDuplicate(boolean)
     * @see org.talend.process.model.form.FormPackage#getDuplicable_Duplicate()
     * @model default="false" required="true"
     * @generated
     */
    boolean isDuplicate();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Duplicable#isDuplicate <em>Duplicate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Duplicate</em>' attribute.
     * @see #isDuplicate()
     * @generated
     */
    void setDuplicate(boolean value);

    /**
     * Returns the value of the '<em><b>Limit Number Of Duplication</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Limit Number Of Duplication</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Limit Number Of Duplication</em>' attribute.
     * @see #setLimitNumberOfDuplication(boolean)
     * @see org.talend.process.model.form.FormPackage#getDuplicable_LimitNumberOfDuplication()
     * @model default="false"
     * @generated
     */
    boolean isLimitNumberOfDuplication();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Duplicable#isLimitNumberOfDuplication <em>Limit Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Limit Number Of Duplication</em>' attribute.
     * @see #isLimitNumberOfDuplication()
     * @generated
     */
    void setLimitNumberOfDuplication(boolean value);

    /**
     * Returns the value of the '<em><b>Max Number Of Duplication</b></em>' attribute.
     * The default value is <code>"10"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max Number Of Duplication</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Max Number Of Duplication</em>' attribute.
     * @see #setMaxNumberOfDuplication(String)
     * @see org.talend.process.model.form.FormPackage#getDuplicable_MaxNumberOfDuplication()
     * @model default="10" required="true"
     * @generated
     */
    String getMaxNumberOfDuplication();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Duplicable#getMaxNumberOfDuplication <em>Max Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max Number Of Duplication</em>' attribute.
     * @see #getMaxNumberOfDuplication()
     * @generated
     */
    void setMaxNumberOfDuplication(String value);

    /**
     * Returns the value of the '<em><b>Limit Min Number Of Duplication</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Limit Min Number Of Duplication</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Limit Min Number Of Duplication</em>' attribute.
     * @see #setLimitMinNumberOfDuplication(boolean)
     * @see org.talend.process.model.form.FormPackage#getDuplicable_LimitMinNumberOfDuplication()
     * @model default="false"
     * @generated
     */
    boolean isLimitMinNumberOfDuplication();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Duplicable#isLimitMinNumberOfDuplication <em>Limit Min Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Limit Min Number Of Duplication</em>' attribute.
     * @see #isLimitMinNumberOfDuplication()
     * @generated
     */
    void setLimitMinNumberOfDuplication(boolean value);

    /**
     * Returns the value of the '<em><b>Min Number Of Duplication</b></em>' attribute.
     * The default value is <code>"2"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Min Number Of Duplication</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Min Number Of Duplication</em>' attribute.
     * @see #setMinNumberOfDuplication(String)
     * @see org.talend.process.model.form.FormPackage#getDuplicable_MinNumberOfDuplication()
     * @model default="2"
     * @generated
     */
    String getMinNumberOfDuplication();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Duplicable#getMinNumberOfDuplication <em>Min Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Min Number Of Duplication</em>' attribute.
     * @see #getMinNumberOfDuplication()
     * @generated
     */
    void setMinNumberOfDuplication(String value);

    /**
     * Returns the value of the '<em><b>Display Label For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Display Label For Add</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Display Label For Add</em>' attribute.
     * @see #setDisplayLabelForAdd(String)
     * @see org.talend.process.model.form.FormPackage#getDuplicable_DisplayLabelForAdd()
     * @model
     * @generated
     */
    String getDisplayLabelForAdd();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Duplicable#getDisplayLabelForAdd <em>Display Label For Add</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Display Label For Add</em>' attribute.
     * @see #getDisplayLabelForAdd()
     * @generated
     */
    void setDisplayLabelForAdd(String value);

    /**
     * Returns the value of the '<em><b>Tooltip For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tooltip For Add</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tooltip For Add</em>' attribute.
     * @see #setTooltipForAdd(String)
     * @see org.talend.process.model.form.FormPackage#getDuplicable_TooltipForAdd()
     * @model
     * @generated
     */
    String getTooltipForAdd();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Duplicable#getTooltipForAdd <em>Tooltip For Add</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tooltip For Add</em>' attribute.
     * @see #getTooltipForAdd()
     * @generated
     */
    void setTooltipForAdd(String value);

    /**
     * Returns the value of the '<em><b>Display Label For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Display Label For Remove</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Display Label For Remove</em>' attribute.
     * @see #setDisplayLabelForRemove(String)
     * @see org.talend.process.model.form.FormPackage#getDuplicable_DisplayLabelForRemove()
     * @model
     * @generated
     */
    String getDisplayLabelForRemove();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Duplicable#getDisplayLabelForRemove <em>Display Label For Remove</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Display Label For Remove</em>' attribute.
     * @see #getDisplayLabelForRemove()
     * @generated
     */
    void setDisplayLabelForRemove(String value);

    /**
     * Returns the value of the '<em><b>Tooltip For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tooltip For Remove</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tooltip For Remove</em>' attribute.
     * @see #setTooltipForRemove(String)
     * @see org.talend.process.model.form.FormPackage#getDuplicable_TooltipForRemove()
     * @model
     * @generated
     */
    String getTooltipForRemove();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Duplicable#getTooltipForRemove <em>Tooltip For Remove</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tooltip For Remove</em>' attribute.
     * @see #getTooltipForRemove()
     * @generated
     */
    void setTooltipForRemove(String value);

} // Duplicable
