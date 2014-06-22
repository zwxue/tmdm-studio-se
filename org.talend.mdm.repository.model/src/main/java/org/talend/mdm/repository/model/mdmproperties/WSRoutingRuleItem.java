/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Routing Rule Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSRoutingRuleItem#getWsRoutingRule <em>Ws Routing Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSRoutingRuleItem()
 * @model
 * @generated
 */
public interface WSRoutingRuleItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Routing Rule</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Routing Rule</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Routing Rule</em>' reference.
     * @see #setWsRoutingRule(WSRoutingRuleE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSRoutingRuleItem_WsRoutingRule()
     * @model
     * @generated
     */
    WSRoutingRuleE getWsRoutingRule();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSRoutingRuleItem#getWsRoutingRule <em>Ws Routing Rule</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Routing Rule</em>' reference.
     * @see #getWsRoutingRule()
     * @generated
     */
    void setWsRoutingRule(WSRoutingRuleE value);

} // WSRoutingRuleItem
