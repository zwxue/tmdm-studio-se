/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSResourceE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Resource Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSResourceItem#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSResourceItem()
 * @model
 * @generated
 */
public interface WSResourceItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Resource</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Resource</em>' reference.
     * @see #setResource(WSResourceE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSResourceItem_Resource()
     * @model
     * @generated
     */
    WSResourceE getResource();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSResourceItem#getResource <em>Resource</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Resource</em>' reference.
     * @see #getResource()
     * @generated
     */
    void setResource(WSResourceE value);

} // WSResourceItem
