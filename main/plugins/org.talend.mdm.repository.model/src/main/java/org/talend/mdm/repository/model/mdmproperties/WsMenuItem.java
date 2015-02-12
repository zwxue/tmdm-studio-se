/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsMenuE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Menu Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsMenuItem#getWsMenu <em>Ws Menu</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsMenuItem()
 * @model
 * @generated
 */
public interface WsMenuItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Menu</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Menu</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Menu</em>' reference.
     * @see #setWsMenu(WsMenuE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsMenuItem_WsMenu()
     * @model
     * @generated
     */
    WsMenuE getWsMenu();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsMenuItem#getWsMenu <em>Ws Menu</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Menu</em>' reference.
     * @see #getWsMenu()
     * @generated
     */
    void setWsMenu(WsMenuE value);

} // WsMenuItem
