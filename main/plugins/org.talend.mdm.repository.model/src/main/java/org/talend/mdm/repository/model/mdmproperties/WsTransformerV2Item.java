/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsTransformerV2E;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Transformer V2 Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsTransformerV2Item#getWsTransformerV2 <em>Ws Transformer V2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsTransformerV2Item()
 * @model
 * @generated
 */
public interface WsTransformerV2Item extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Transformer V2</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Transformer V2</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Transformer V2</em>' reference.
     * @see #setWsTransformerV2(WsTransformerV2E)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsTransformerV2Item_WsTransformerV2()
     * @model
     * @generated
     */
    WsTransformerV2E getWsTransformerV2();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsTransformerV2Item#getWsTransformerV2 <em>Ws Transformer V2</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Transformer V2</em>' reference.
     * @see #getWsTransformerV2()
     * @generated
     */
    void setWsTransformerV2(WsTransformerV2E value);

} // WsTransformerV2Item
