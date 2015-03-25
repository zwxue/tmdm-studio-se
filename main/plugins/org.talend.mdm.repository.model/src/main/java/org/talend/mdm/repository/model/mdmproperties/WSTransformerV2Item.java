/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSTransformerV2E;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Transformer V2 Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item#getWsTransformerV2 <em>Ws Transformer V2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSTransformerV2Item()
 * @model
 * @generated
 */
public interface WSTransformerV2Item extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Transformer V2</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Transformer V2</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Transformer V2</em>' reference.
     * @see #setWsTransformerV2(WSTransformerV2E)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSTransformerV2Item_WsTransformerV2()
     * @model
     * @generated
     */
    WSTransformerV2E getWsTransformerV2();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item#getWsTransformerV2 <em>Ws Transformer V2</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Transformer V2</em>' reference.
     * @see #getWsTransformerV2()
     * @generated
     */
    void setWsTransformerV2(WSTransformerV2E value);

} // WSTransformerV2Item
