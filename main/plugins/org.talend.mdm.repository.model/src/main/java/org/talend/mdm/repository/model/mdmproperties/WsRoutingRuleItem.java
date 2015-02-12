/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Routing Rule Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsRoutingRuleItem#getWsRoutingRule <em>Ws Routing Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsRoutingRuleItem()
 * @model
 * @generated
 */
public interface WsRoutingRuleItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Routing Rule</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Routing Rule</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Routing Rule</em>' reference.
     * @see #setWsRoutingRule(WsRoutingRuleE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsRoutingRuleItem_WsRoutingRule()
     * @model
     * @generated
     */
    WsRoutingRuleE getWsRoutingRule();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsRoutingRuleItem#getWsRoutingRule <em>Ws Routing Rule</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Routing Rule</em>' reference.
     * @see #getWsRoutingRule()
     * @generated
     */
    void setWsRoutingRule(WsRoutingRuleE value);

} // WsRoutingRuleItem
