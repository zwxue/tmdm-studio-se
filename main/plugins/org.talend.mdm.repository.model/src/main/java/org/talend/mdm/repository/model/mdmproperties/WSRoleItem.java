/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSRoleE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Role Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSRoleItem#getWsRole <em>Ws Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSRoleItem()
 * @model
 * @generated
 */
public interface WSRoleItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Role</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Role</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Role</em>' reference.
     * @see #setWsRole(WSRoleE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSRoleItem_WsRole()
     * @model
     * @generated
     */
    WSRoleE getWsRole();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSRoleItem#getWsRole <em>Ws Role</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Role</em>' reference.
     * @see #getWsRole()
     * @generated
     */
    void setWsRole(WSRoleE value);

} // WSRoleItem
