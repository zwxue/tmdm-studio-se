/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.CustomForm;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Form Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.CustomFormItem#getCustomForm <em>Custom Form</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getCustomFormItem()
 * @model
 * @generated
 */
public interface CustomFormItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Custom Form</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Custom Form</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Custom Form</em>' reference.
     * @see #setCustomForm(CustomForm)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getCustomFormItem_CustomForm()
     * @model
     * @generated
     */
    CustomForm getCustomForm();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.CustomFormItem#getCustomForm <em>Custom Form</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Custom Form</em>' reference.
     * @see #getCustomForm()
     * @generated
     */
    void setCustomForm(CustomForm value);

} // CustomFormItem
