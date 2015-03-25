/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSEventManagerE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Event Manager Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSEventManagerItem#getWsEventManager <em>Ws Event Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSEventManagerItem()
 * @model
 * @generated
 */
public interface WSEventManagerItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Event Manager</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Event Manager</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Event Manager</em>' reference.
     * @see #setWsEventManager(WSEventManagerE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSEventManagerItem_WsEventManager()
     * @model
     * @generated
     */
    WSEventManagerE getWsEventManager();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSEventManagerItem#getWsEventManager <em>Ws Event Manager</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Event Manager</em>' reference.
     * @see #getWsEventManager()
     * @generated
     */
    void setWsEventManager(WSEventManagerE value);

} // WSEventManagerItem
