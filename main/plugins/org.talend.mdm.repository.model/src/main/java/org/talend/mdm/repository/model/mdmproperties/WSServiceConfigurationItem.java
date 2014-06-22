/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSServiceConfigurationE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Service Configuration Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSServiceConfigurationItem#getWsServiceConfiguration <em>Ws Service Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSServiceConfigurationItem()
 * @model
 * @generated
 */
public interface WSServiceConfigurationItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Service Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Service Configuration</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Service Configuration</em>' reference.
     * @see #setWsServiceConfiguration(WSServiceConfigurationE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSServiceConfigurationItem_WsServiceConfiguration()
     * @model
     * @generated
     */
    WSServiceConfigurationE getWsServiceConfiguration();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSServiceConfigurationItem#getWsServiceConfiguration <em>Ws Service Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Service Configuration</em>' reference.
     * @see #getWsServiceConfiguration()
     * @generated
     */
    void setWsServiceConfiguration(WSServiceConfigurationE value);

} // WSServiceConfigurationItem
