/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSUniverseE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Universe Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSUniverseItem#getWsUniverse <em>Ws Universe</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSUniverseItem()
 * @model
 * @generated
 */
public interface WSUniverseItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Universe</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Universe</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Universe</em>' reference.
     * @see #setWsUniverse(WSUniverseE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSUniverseItem_WsUniverse()
     * @model
     * @generated
     */
    WSUniverseE getWsUniverse();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSUniverseItem#getWsUniverse <em>Ws Universe</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Universe</em>' reference.
     * @see #getWsUniverse()
     * @generated
     */
    void setWsUniverse(WSUniverseE value);

} // WSUniverseItem
