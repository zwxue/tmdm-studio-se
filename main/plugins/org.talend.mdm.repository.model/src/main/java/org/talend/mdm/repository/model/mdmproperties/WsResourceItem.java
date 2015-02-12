/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsResourceE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Resource Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsResourceItem#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsResourceItem()
 * @model
 * @generated
 */
public interface WsResourceItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Resource</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Resource</em>' reference.
     * @see #setResource(WsResourceE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsResourceItem_Resource()
     * @model
     * @generated
     */
    WsResourceE getResource();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsResourceItem#getResource <em>Resource</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Resource</em>' reference.
     * @see #getResource()
     * @generated
     */
    void setResource(WsResourceE value);

} // WsResourceItem
