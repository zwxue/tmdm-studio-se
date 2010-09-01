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
import org.eclipse.emf.common.util.EMap;

import org.talend.process.model.process.ConnectableElement;
import org.talend.process.model.process.ResourceContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Form</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.form.Form#getWidgets <em>Widgets</em>}</li>
 *   <li>{@link org.talend.process.model.form.Form#getScripts <em>Scripts</em>}</li>
 *   <li>{@link org.talend.process.model.form.Form#getNColumn <em>NColumn</em>}</li>
 *   <li>{@link org.talend.process.model.form.Form#getStringAttributes <em>String Attributes</em>}</li>
 *   <li>{@link org.talend.process.model.form.Form#getNLine <em>NLine</em>}</li>
 *   <li>{@link org.talend.process.model.form.Form#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.talend.process.model.form.Form#getLines <em>Lines</em>}</li>
 *   <li>{@link org.talend.process.model.form.Form#getPageLabel <em>Page Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.Form#getShowPageLabel <em>Show Page Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.Form#isAllowHTMLInPageLabel <em>Allow HTML In Page Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.form.FormPackage#getForm()
 * @model
 * @generated
 */
public interface Form extends ConnectableElement, Validable, ResourceContainer {
    /**
     * Returns the value of the '<em><b>Widgets</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.form.Widget}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Widgets</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Widgets</em>' containment reference list.
     * @see org.talend.process.model.form.FormPackage#getForm_Widgets()
     * @model containment="true"
     * @generated
     */
    EList<Widget> getWidgets();

    /**
     * Returns the value of the '<em><b>Scripts</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.form.GroovyScript}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Scripts</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Scripts</em>' containment reference list.
     * @see org.talend.process.model.form.FormPackage#getForm_Scripts()
     * @model containment="true"
     * @generated
     */
    EList<GroovyScript> getScripts();

    /**
     * Returns the value of the '<em><b>NColumn</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Number of column of the Gridlayout
     * <!-- end-model-doc -->
     * @return the value of the '<em>NColumn</em>' attribute.
     * @see #setNColumn(int)
     * @see org.talend.process.model.form.FormPackage#getForm_NColumn()
     * @model default="1"
     * @generated
     */
    int getNColumn();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Form#getNColumn <em>NColumn</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>NColumn</em>' attribute.
     * @see #getNColumn()
     * @generated
     */
    void setNColumn(int value);

    /**
     * Returns the value of the '<em><b>String Attributes</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>String Attributes</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>String Attributes</em>' map.
     * @see org.talend.process.model.form.FormPackage#getForm_StringAttributes()
     * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
     * @generated
     */
    EMap<String, String> getStringAttributes();

    /**
     * Returns the value of the '<em><b>NLine</b></em>' attribute.
     * The default value is <code>"4"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>NLine</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>NLine</em>' attribute.
     * @see #setNLine(int)
     * @see org.talend.process.model.form.FormPackage#getForm_NLine()
     * @model default="4"
     * @generated
     */
    int getNLine();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Form#getNLine <em>NLine</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>NLine</em>' attribute.
     * @see #getNLine()
     * @generated
     */
    void setNLine(int value);

    /**
     * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.form.Column}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Columns</em>' containment reference list.
     * @see org.talend.process.model.form.FormPackage#getForm_Columns()
     * @model containment="true"
     * @generated
     */
    EList<Column> getColumns();

    /**
     * Returns the value of the '<em><b>Lines</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.form.Line}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lines</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Lines</em>' containment reference list.
     * @see org.talend.process.model.form.FormPackage#getForm_Lines()
     * @model containment="true"
     * @generated
     */
    EList<Line> getLines();

    /**
     * Returns the value of the '<em><b>Page Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Page Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Page Label</em>' attribute.
     * @see #setPageLabel(String)
     * @see org.talend.process.model.form.FormPackage#getForm_PageLabel()
     * @model
     * @generated
     */
    String getPageLabel();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Form#getPageLabel <em>Page Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Page Label</em>' attribute.
     * @see #getPageLabel()
     * @generated
     */
    void setPageLabel(String value);

    /**
     * Returns the value of the '<em><b>Show Page Label</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Show Page Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Show Page Label</em>' attribute.
     * @see #setShowPageLabel(Boolean)
     * @see org.talend.process.model.form.FormPackage#getForm_ShowPageLabel()
     * @model default="true"
     * @generated
     */
    Boolean getShowPageLabel();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Form#getShowPageLabel <em>Show Page Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Show Page Label</em>' attribute.
     * @see #getShowPageLabel()
     * @generated
     */
    void setShowPageLabel(Boolean value);

    /**
     * Returns the value of the '<em><b>Allow HTML In Page Label</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Allow HTML In Page Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Allow HTML In Page Label</em>' attribute.
     * @see #setAllowHTMLInPageLabel(boolean)
     * @see org.talend.process.model.form.FormPackage#getForm_AllowHTMLInPageLabel()
     * @model default="false"
     * @generated
     */
    boolean isAllowHTMLInPageLabel();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Form#isAllowHTMLInPageLabel <em>Allow HTML In Page Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Allow HTML In Page Label</em>' attribute.
     * @see #isAllowHTMLInPageLabel()
     * @generated
     */
    void setAllowHTMLInPageLabel(boolean value);

} // Form
