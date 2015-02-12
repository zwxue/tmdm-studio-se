/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsUniverseE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Universe Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsUniverseItem#getWsUniverse <em>Ws Universe</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsUniverseItem()
 * @model
 * @generated
 */
public interface WsUniverseItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Universe</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Universe</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Universe</em>' reference.
     * @see #setWsUniverse(WsUniverseE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsUniverseItem_WsUniverse()
     * @model
     * @generated
     */
    WsUniverseE getWsUniverse();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsUniverseItem#getWsUniverse <em>Ws Universe</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Universe</em>' reference.
     * @see #getWsUniverse()
     * @generated
     */
    void setWsUniverse(WsUniverseE value);

} // WsUniverseItem
