/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSMatchRuleE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Match Rule Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSMatchRuleItem#getMdmMatchRule <em>Mdm Match Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSMatchRuleItem()
 * @model
 * @generated
 */
public interface WSMatchRuleItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Mdm Match Rule</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mdm Match Rule</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mdm Match Rule</em>' reference.
     * @see #setMdmMatchRule(WSMatchRuleE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSMatchRuleItem_MdmMatchRule()
     * @model
     * @generated
     */
    WSMatchRuleE getMdmMatchRule();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSMatchRuleItem#getMdmMatchRule <em>Mdm Match Rule</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mdm Match Rule</em>' reference.
     * @see #getMdmMatchRule()
     * @generated
     */
    void setMdmMatchRule(WSMatchRuleE value);

} // WSMatchRuleItem
