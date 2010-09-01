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

import org.talend.process.model.form.Widget;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.OutputParameterMapping#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.talend.process.model.process.OutputParameterMapping#getTargetData <em>Target Data</em>}</li>
 *   <li>{@link org.talend.process.model.process.OutputParameterMapping#getAdditionalPath <em>Additional Path</em>}</li>
 *   <li>{@link org.talend.process.model.process.OutputParameterMapping#getTargetWidget <em>Target Widget</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getOutputParameterMapping()
 * @model
 * @generated
 */
public interface OutputParameterMapping extends EObject {
    /**
     * Returns the value of the '<em><b>Value Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value Expression</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value Expression</em>' attribute.
     * @see #setValueExpression(String)
     * @see org.talend.process.model.process.ProcessPackage#getOutputParameterMapping_ValueExpression()
     * @model
     * @generated
     */
    String getValueExpression();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.OutputParameterMapping#getValueExpression <em>Value Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Expression</em>' attribute.
     * @see #getValueExpression()
     * @generated
     */
    void setValueExpression(String value);

    /**
     * Returns the value of the '<em><b>Target Data</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Data</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Data</em>' reference.
     * @see #setTargetData(Data)
     * @see org.talend.process.model.process.ProcessPackage#getOutputParameterMapping_TargetData()
     * @model
     * @generated
     */
    Data getTargetData();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.OutputParameterMapping#getTargetData <em>Target Data</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Data</em>' reference.
     * @see #getTargetData()
     * @generated
     */
    void setTargetData(Data value);

    /**
     * Returns the value of the '<em><b>Additional Path</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * This field is used to provide additional description of the target data.
     * For example, if the selected data is "myData", which is of XML, then this field will contain
     * ":/myNode/@myAttr" or ":/myNode/text()"
     * <!-- end-model-doc -->
     * @return the value of the '<em>Additional Path</em>' attribute.
     * @see #setAdditionalPath(String)
     * @see org.talend.process.model.process.ProcessPackage#getOutputParameterMapping_AdditionalPath()
     * @model default=""
     * @generated
     */
    String getAdditionalPath();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.OutputParameterMapping#getAdditionalPath <em>Additional Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Additional Path</em>' attribute.
     * @see #getAdditionalPath()
     * @generated
     */
    void setAdditionalPath(String value);

    /**
     * Returns the value of the '<em><b>Target Widget</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Widget</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Widget</em>' reference.
     * @see #setTargetWidget(Widget)
     * @see org.talend.process.model.process.ProcessPackage#getOutputParameterMapping_TargetWidget()
     * @model
     * @generated
     */
    Widget getTargetWidget();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.OutputParameterMapping#getTargetWidget <em>Target Widget</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Widget</em>' reference.
     * @see #getTargetWidget()
     * @generated
     */
    void setTargetWidget(Widget value);

} // OutputParameterMapping
