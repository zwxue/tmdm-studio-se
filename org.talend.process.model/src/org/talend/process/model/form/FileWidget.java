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

import org.talend.process.model.process.Data;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Widget</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.form.FileWidget#getFileData <em>File Data</em>}</li>
 *   <li>{@link org.talend.process.model.form.FileWidget#isDownloadOnly <em>Download Only</em>}</li>
 *   <li>{@link org.talend.process.model.form.FileWidget#isUsePreview <em>Use Preview</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.form.FormPackage#getFileWidget()
 * @model
 * @generated
 */
public interface FileWidget extends SingleValuatedFormField, Duplicable {
    /**
     * Returns the value of the '<em><b>File Data</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Data</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>File Data</em>' reference.
     * @see #setFileData(Data)
     * @see org.talend.process.model.form.FormPackage#getFileWidget_FileData()
     * @model
     * @generated
     */
    Data getFileData();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.FileWidget#getFileData <em>File Data</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>File Data</em>' reference.
     * @see #getFileData()
     * @generated
     */
    void setFileData(Data value);

    /**
     * Returns the value of the '<em><b>Download Only</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Download Only</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Download Only</em>' attribute.
     * @see #setDownloadOnly(boolean)
     * @see org.talend.process.model.form.FormPackage#getFileWidget_DownloadOnly()
     * @model default="false"
     * @generated
     */
    boolean isDownloadOnly();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.FileWidget#isDownloadOnly <em>Download Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Download Only</em>' attribute.
     * @see #isDownloadOnly()
     * @generated
     */
    void setDownloadOnly(boolean value);

    /**
     * Returns the value of the '<em><b>Use Preview</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Use Preview</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Use Preview</em>' attribute.
     * @see #setUsePreview(boolean)
     * @see org.talend.process.model.form.FormPackage#getFileWidget_UsePreview()
     * @model default="false"
     * @generated
     */
    boolean isUsePreview();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.FileWidget#isUsePreview <em>Use Preview</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Use Preview</em>' attribute.
     * @see #isUsePreview()
     * @generated
     */
    void setUsePreview(boolean value);

} // FileWidget
