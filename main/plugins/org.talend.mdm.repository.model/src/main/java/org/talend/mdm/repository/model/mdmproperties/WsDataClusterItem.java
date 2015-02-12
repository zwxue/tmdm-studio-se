/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsDataClusterE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Data Cluster Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsDataClusterItem#getWsDataCluster <em>Ws Data Cluster</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsDataClusterItem()
 * @model
 * @generated
 */
public interface WsDataClusterItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Data Cluster</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Data Cluster</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Data Cluster</em>' reference.
     * @see #setWsDataCluster(WsDataClusterE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsDataClusterItem_WsDataCluster()
     * @model
     * @generated
     */
    WsDataClusterE getWsDataCluster();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsDataClusterItem#getWsDataCluster <em>Ws Data Cluster</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Data Cluster</em>' reference.
     * @see #getWsDataCluster()
     * @generated
     */
    void setWsDataCluster(WsDataClusterE value);

} // WsDataClusterItem
