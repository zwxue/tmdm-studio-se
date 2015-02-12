/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Match Rule Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsMatchRuleItem#getMdmMatchRule <em>Mdm Match Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsMatchRuleItem()
 * @model
 * @generated
 */
public interface WsMatchRuleItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Mdm Match Rule</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mdm Match Rule</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mdm Match Rule</em>' reference.
     * @see #setMdmMatchRule(WsMatchRuleE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsMatchRuleItem_MdmMatchRule()
     * @model
     * @generated
     */
    WsMatchRuleE getMdmMatchRule();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsMatchRuleItem#getMdmMatchRule <em>Mdm Match Rule</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mdm Match Rule</em>' reference.
     * @see #getMdmMatchRule()
     * @generated
     */
    void setMdmMatchRule(WsMatchRuleE value);

} // WsMatchRuleItem
