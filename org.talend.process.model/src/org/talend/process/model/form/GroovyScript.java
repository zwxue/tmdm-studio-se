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

import org.talend.process.model.process.Data;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Groovy Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.form.GroovyScript#getExprScript <em>Expr Script</em>}</li>
 *   <li>{@link org.talend.process.model.form.GroovyScript#getInputScript <em>Input Script</em>}</li>
 *   <li>{@link org.talend.process.model.form.GroovyScript#getSetVar <em>Set Var</em>}</li>
 *   <li>{@link org.talend.process.model.form.GroovyScript#isAllowHTMLInValues <em>Allow HTML In Values</em>}</li>
 *   <li>{@link org.talend.process.model.form.GroovyScript#getSetVarScript <em>Set Var Script</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.form.FormPackage#getGroovyScript()
 * @model
 * @generated
 */
public interface GroovyScript extends EObject {
    /**
     * Returns the value of the '<em><b>Expr Script</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expr Script</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expr Script</em>' attribute.
     * @see #setExprScript(String)
     * @see org.talend.process.model.form.FormPackage#getGroovyScript_ExprScript()
     * @model default=""
     * @generated
     */
    String getExprScript();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.GroovyScript#getExprScript <em>Expr Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expr Script</em>' attribute.
     * @see #getExprScript()
     * @generated
     */
    void setExprScript(String value);

    /**
     * Returns the value of the '<em><b>Input Script</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Script</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Script</em>' attribute.
     * @see #setInputScript(String)
     * @see org.talend.process.model.form.FormPackage#getGroovyScript_InputScript()
     * @model
     * @generated
     */
    String getInputScript();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.GroovyScript#getInputScript <em>Input Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Script</em>' attribute.
     * @see #getInputScript()
     * @generated
     */
    void setInputScript(String value);

    /**
     * Returns the value of the '<em><b>Set Var</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Set Var</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Set Var</em>' reference.
     * @see #setSetVar(Data)
     * @see org.talend.process.model.form.FormPackage#getGroovyScript_SetVar()
     * @model
     * @generated
     */
    Data getSetVar();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.GroovyScript#getSetVar <em>Set Var</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Set Var</em>' reference.
     * @see #getSetVar()
     * @generated
     */
    void setSetVar(Data value);

    /**
     * Returns the value of the '<em><b>Allow HTML In Values</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Allow HTML In Values</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Allow HTML In Values</em>' attribute.
     * @see #setAllowHTMLInValues(boolean)
     * @see org.talend.process.model.form.FormPackage#getGroovyScript_AllowHTMLInValues()
     * @model default="false"
     * @generated
     */
    boolean isAllowHTMLInValues();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.GroovyScript#isAllowHTMLInValues <em>Allow HTML In Values</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Allow HTML In Values</em>' attribute.
     * @see #isAllowHTMLInValues()
     * @generated
     */
    void setAllowHTMLInValues(boolean value);

    /**
     * Returns the value of the '<em><b>Set Var Script</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Set Var Script</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Set Var Script</em>' attribute.
     * @see #setSetVarScript(String)
     * @see org.talend.process.model.form.FormPackage#getGroovyScript_SetVarScript()
     * @model default=""
     * @generated
     */
    String getSetVarScript();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.GroovyScript#getSetVarScript <em>Set Var Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Set Var Script</em>' attribute.
     * @see #getSetVarScript()
     * @generated
     */
    void setSetVarScript(String value);

} // GroovyScript
