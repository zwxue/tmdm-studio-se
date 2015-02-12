/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsEventManagerE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Event Manager Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsEventManagerItem#getWsEventManager <em>Ws Event Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsEventManagerItem()
 * @model
 * @generated
 */
public interface WsEventManagerItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Event Manager</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Event Manager</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Event Manager</em>' reference.
     * @see #setWsEventManager(WsEventManagerE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsEventManagerItem_WsEventManager()
     * @model
     * @generated
     */
    WsEventManagerE getWsEventManager();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsEventManagerItem#getWsEventManager <em>Ws Event Manager</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Event Manager</em>' reference.
     * @see #getWsEventManager()
     * @generated
     */
    void setWsEventManager(WsEventManagerE value);

} // WsEventManagerItem
