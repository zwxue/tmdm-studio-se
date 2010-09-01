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
 * A representation of the model object '<em><b>Image Widget</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.form.ImageWidget#getImgPath <em>Img Path</em>}</li>
 *   <li>{@link org.talend.process.model.form.ImageWidget#isIsAnAttachment <em>Is An Attachment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.form.FormPackage#getImageWidget()
 * @model
 * @generated
 */
public interface ImageWidget extends Widget {
    /**
     * Returns the value of the '<em><b>Img Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Img Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Img Path</em>' attribute.
     * @see #setImgPath(String)
     * @see org.talend.process.model.form.FormPackage#getImageWidget_ImgPath()
     * @model
     * @generated
     */
    String getImgPath();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.ImageWidget#getImgPath <em>Img Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Img Path</em>' attribute.
     * @see #getImgPath()
     * @generated
     */
    void setImgPath(String value);

    /**
     * Returns the value of the '<em><b>Is An Attachment</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is An Attachment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is An Attachment</em>' attribute.
     * @see #setIsAnAttachment(boolean)
     * @see org.talend.process.model.form.FormPackage#getImageWidget_IsAnAttachment()
     * @model default="false"
     * @generated
     */
    boolean isIsAnAttachment();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.ImageWidget#isIsAnAttachment <em>Is An Attachment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is An Attachment</em>' attribute.
     * @see #isIsAnAttachment()
     * @generated
     */
    void setIsAnAttachment(boolean value);

} // ImageWidget
