/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSViewE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS View Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSViewItem#getWsView <em>Ws View</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSViewItem()
 * @model
 * @generated
 */
public interface WSViewItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws View</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws View</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws View</em>' reference.
     * @see #setWsView(WSViewE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSViewItem_WsView()
     * @model
     * @generated
     */
    WSViewE getWsView();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSViewItem#getWsView <em>Ws View</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws View</em>' reference.
     * @see #getWsView()
     * @generated
     */
    void setWsView(WSViewE value);

} // WSViewItem
