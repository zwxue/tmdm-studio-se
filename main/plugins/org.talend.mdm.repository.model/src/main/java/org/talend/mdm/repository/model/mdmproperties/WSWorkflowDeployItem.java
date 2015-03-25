/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSWorkflowDeployE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Workflow Deploy Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSWorkflowDeployItem#getWsWorkflowDeploy <em>Ws Workflow Deploy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSWorkflowDeployItem()
 * @model
 * @generated
 */
public interface WSWorkflowDeployItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Workflow Deploy</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Workflow Deploy</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Workflow Deploy</em>' reference.
     * @see #setWsWorkflowDeploy(WSWorkflowDeployE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSWorkflowDeployItem_WsWorkflowDeploy()
     * @model
     * @generated
     */
    WSWorkflowDeployE getWsWorkflowDeploy();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSWorkflowDeployItem#getWsWorkflowDeploy <em>Ws Workflow Deploy</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Workflow Deploy</em>' reference.
     * @see #getWsWorkflowDeploy()
     * @generated
     */
    void setWsWorkflowDeploy(WSWorkflowDeployE value);

} // WSWorkflowDeployItem
