/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsDataModelE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Data Model Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsDataModelItem#getWsDataModel <em>Ws Data Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsDataModelItem()
 * @model
 * @generated
 */
public interface WsDataModelItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Data Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Data Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Data Model</em>' reference.
     * @see #setWsDataModel(WsDataModelE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsDataModelItem_WsDataModel()
     * @model
     * @generated
     */
    WsDataModelE getWsDataModel();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsDataModelItem#getWsDataModel <em>Ws Data Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Data Model</em>' reference.
     * @see #getWsDataModel()
     * @generated
     */
    void setWsDataModel(WsDataModelE value);

} // WsDataModelItem
