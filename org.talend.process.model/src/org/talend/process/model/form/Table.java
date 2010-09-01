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
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.form.Table#isLeftColumnIsHeader <em>Left Column Is Header</em>}</li>
 *   <li>{@link org.talend.process.model.form.Table#isRightColumnIsHeader <em>Right Column Is Header</em>}</li>
 *   <li>{@link org.talend.process.model.form.Table#isFirstRowIsHeader <em>First Row Is Header</em>}</li>
 *   <li>{@link org.talend.process.model.form.Table#isLastRowIsHeader <em>Last Row Is Header</em>}</li>
 *   <li>{@link org.talend.process.model.form.Table#isInitializedUsingCells <em>Initialized Using Cells</em>}</li>
 *   <li>{@link org.talend.process.model.form.Table#getCells <em>Cells</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.form.FormPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends Widget {
    /**
     * Returns the value of the '<em><b>Left Column Is Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Left Column Is Header</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Left Column Is Header</em>' attribute.
     * @see #setLeftColumnIsHeader(boolean)
     * @see org.talend.process.model.form.FormPackage#getTable_LeftColumnIsHeader()
     * @model
     * @generated
     */
    boolean isLeftColumnIsHeader();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Table#isLeftColumnIsHeader <em>Left Column Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Left Column Is Header</em>' attribute.
     * @see #isLeftColumnIsHeader()
     * @generated
     */
    void setLeftColumnIsHeader(boolean value);

    /**
     * Returns the value of the '<em><b>Right Column Is Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Right Column Is Header</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Right Column Is Header</em>' attribute.
     * @see #setRightColumnIsHeader(boolean)
     * @see org.talend.process.model.form.FormPackage#getTable_RightColumnIsHeader()
     * @model
     * @generated
     */
    boolean isRightColumnIsHeader();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Table#isRightColumnIsHeader <em>Right Column Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Right Column Is Header</em>' attribute.
     * @see #isRightColumnIsHeader()
     * @generated
     */
    void setRightColumnIsHeader(boolean value);

    /**
     * Returns the value of the '<em><b>First Row Is Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>First Row Is Header</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>First Row Is Header</em>' attribute.
     * @see #setFirstRowIsHeader(boolean)
     * @see org.talend.process.model.form.FormPackage#getTable_FirstRowIsHeader()
     * @model
     * @generated
     */
    boolean isFirstRowIsHeader();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Table#isFirstRowIsHeader <em>First Row Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>First Row Is Header</em>' attribute.
     * @see #isFirstRowIsHeader()
     * @generated
     */
    void setFirstRowIsHeader(boolean value);

    /**
     * Returns the value of the '<em><b>Last Row Is Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Row Is Header</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Last Row Is Header</em>' attribute.
     * @see #setLastRowIsHeader(boolean)
     * @see org.talend.process.model.form.FormPackage#getTable_LastRowIsHeader()
     * @model
     * @generated
     */
    boolean isLastRowIsHeader();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Table#isLastRowIsHeader <em>Last Row Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Last Row Is Header</em>' attribute.
     * @see #isLastRowIsHeader()
     * @generated
     */
    void setLastRowIsHeader(boolean value);

    /**
     * Returns the value of the '<em><b>Initialized Using Cells</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initialized Using Cells</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initialized Using Cells</em>' attribute.
     * @see #setInitializedUsingCells(boolean)
     * @see org.talend.process.model.form.FormPackage#getTable_InitializedUsingCells()
     * @model
     * @generated
     */
    boolean isInitializedUsingCells();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Table#isInitializedUsingCells <em>Initialized Using Cells</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initialized Using Cells</em>' attribute.
     * @see #isInitializedUsingCells()
     * @generated
     */
    void setInitializedUsingCells(boolean value);

    /**
     * Returns the value of the '<em><b>Cells</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cells</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cells</em>' attribute.
     * @see #setCells(Object)
     * @see org.talend.process.model.form.FormPackage#getTable_Cells()
     * @model
     * @generated
     */
    Object getCells();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Table#getCells <em>Cells</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cells</em>' attribute.
     * @see #getCells()
     * @generated
     */
    void setCells(Object value);

} // Table
