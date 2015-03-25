/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSCustomFormE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Custom Form Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSCustomFormItem#getCustomForm <em>Custom Form</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSCustomFormItem()
 * @model
 * @generated
 */
public interface WSCustomFormItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Custom Form</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Custom Form</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Custom Form</em>' reference.
     * @see #setCustomForm(WSCustomFormE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSCustomFormItem_CustomForm()
     * @model
     * @generated
     */
    WSCustomFormE getCustomForm();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSCustomFormItem#getCustomForm <em>Custom Form</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Custom Form</em>' reference.
     * @see #getCustomForm()
     * @generated
     */
    void setCustomForm(WSCustomFormE value);

} // WSCustomFormItem
