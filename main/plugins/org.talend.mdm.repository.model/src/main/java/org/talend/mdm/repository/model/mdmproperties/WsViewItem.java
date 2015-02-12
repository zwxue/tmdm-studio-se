/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsViewE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws View Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsViewItem#getWsView <em>Ws View</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsViewItem()
 * @model
 * @generated
 */
public interface WsViewItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws View</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws View</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws View</em>' reference.
     * @see #setWsView(WsViewE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsViewItem_WsView()
     * @model
     * @generated
     */
    WsViewE getWsView();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsViewItem#getWsView <em>Ws View</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws View</em>' reference.
     * @see #getWsView()
     * @generated
     */
    void setWsView(WsViewE value);

} // WsViewItem
