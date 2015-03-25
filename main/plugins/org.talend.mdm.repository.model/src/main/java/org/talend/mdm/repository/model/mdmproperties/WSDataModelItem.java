/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSDataModelE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Data Model Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSDataModelItem#getWsDataModel <em>Ws Data Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSDataModelItem()
 * @model
 * @generated
 */
public interface WSDataModelItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Data Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Data Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Data Model</em>' reference.
     * @see #setWsDataModel(WSDataModelE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSDataModelItem_WsDataModel()
     * @model
     * @generated
     */
    WSDataModelE getWsDataModel();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSDataModelItem#getWsDataModel <em>Ws Data Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Data Model</em>' reference.
     * @see #getWsDataModel()
     * @generated
     */
    void setWsDataModel(WSDataModelE value);

} // WSDataModelItem
