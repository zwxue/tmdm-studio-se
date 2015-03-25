/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSStoredProcedureE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Stored Procedure Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSStoredProcedureItem#getWsStoredProcedure <em>Ws Stored Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSStoredProcedureItem()
 * @model
 * @generated
 */
public interface WSStoredProcedureItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Stored Procedure</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Stored Procedure</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Stored Procedure</em>' reference.
     * @see #setWsStoredProcedure(WSStoredProcedureE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSStoredProcedureItem_WsStoredProcedure()
     * @model
     * @generated
     */
    WSStoredProcedureE getWsStoredProcedure();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSStoredProcedureItem#getWsStoredProcedure <em>Ws Stored Procedure</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Stored Procedure</em>' reference.
     * @see #getWsStoredProcedure()
     * @generated
     */
    void setWsStoredProcedure(WSStoredProcedureE value);

} // WSStoredProcedureItem
