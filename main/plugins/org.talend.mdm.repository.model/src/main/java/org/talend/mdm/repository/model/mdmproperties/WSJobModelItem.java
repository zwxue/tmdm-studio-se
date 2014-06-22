/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSJobModelE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Job Model Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSJobModelItem#getWsJobModelItem <em>Ws Job Model Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSJobModelItem()
 * @model
 * @generated
 */
public interface WSJobModelItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Job Model Item</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Job Model Item</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Job Model Item</em>' reference.
     * @see #setWsJobModelItem(WSJobModelE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSJobModelItem_WsJobModelItem()
     * @model
     * @generated
     */
    WSJobModelE getWsJobModelItem();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSJobModelItem#getWsJobModelItem <em>Ws Job Model Item</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Job Model Item</em>' reference.
     * @see #getWsJobModelItem()
     * @generated
     */
    void setWsJobModelItem(WSJobModelE value);

} // WSJobModelItem
