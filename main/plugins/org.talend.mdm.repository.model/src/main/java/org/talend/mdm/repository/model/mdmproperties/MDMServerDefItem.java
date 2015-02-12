/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MDM Server Def Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem#getServerDef <em>Server Def</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getMDMServerDefItem()
 * @model
 * @generated
 */
public interface MDMServerDefItem extends MDMItem {
    /**
     * Returns the value of the '<em><b>Server Def</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Server Def</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Server Def</em>' reference.
     * @see #setServerDef(MDMServerDef)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getMDMServerDefItem_ServerDef()
     * @model
     * @generated
     */
    MDMServerDef getServerDef();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem#getServerDef <em>Server Def</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Server Def</em>' reference.
     * @see #getServerDef()
     * @generated
     */
    void setServerDef(MDMServerDef value);

} // MDMServerDefItem
