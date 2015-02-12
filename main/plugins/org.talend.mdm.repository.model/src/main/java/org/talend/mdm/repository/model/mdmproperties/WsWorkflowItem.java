/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsWorkflowE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Workflow Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsWorkflowItem#getWsWorkflow <em>Ws Workflow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsWorkflowItem()
 * @model
 * @generated
 */
public interface WsWorkflowItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Workflow</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Workflow</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Workflow</em>' reference.
     * @see #setWsWorkflow(WsWorkflowE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsWorkflowItem_WsWorkflow()
     * @model
     * @generated
     */
    WsWorkflowE getWsWorkflow();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsWorkflowItem#getWsWorkflow <em>Ws Workflow</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Workflow</em>' reference.
     * @see #getWsWorkflow()
     * @generated
     */
    void setWsWorkflow(WsWorkflowE value);

} // WsWorkflowItem
