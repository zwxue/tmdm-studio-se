/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsServiceConfigurationE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Service Configuration Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsServiceConfigurationItem#getWsServiceConfiguration <em>Ws Service Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsServiceConfigurationItem()
 * @model
 * @generated
 */
public interface WsServiceConfigurationItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Service Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Service Configuration</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Service Configuration</em>' reference.
     * @see #setWsServiceConfiguration(WsServiceConfigurationE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsServiceConfigurationItem_WsServiceConfiguration()
     * @model
     * @generated
     */
    WsServiceConfigurationE getWsServiceConfiguration();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsServiceConfigurationItem#getWsServiceConfiguration <em>Ws Service Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Service Configuration</em>' reference.
     * @see #getWsServiceConfiguration()
     * @generated
     */
    void setWsServiceConfiguration(WsServiceConfigurationE value);

} // WsServiceConfigurationItem
