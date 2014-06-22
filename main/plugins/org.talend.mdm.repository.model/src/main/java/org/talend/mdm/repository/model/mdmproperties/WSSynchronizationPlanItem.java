/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Synchronization Plan Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WSSynchronizationPlanItem#getWsSynchronizationPlan <em>Ws Synchronization Plan</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSSynchronizationPlanItem()
 * @model
 * @generated
 */
public interface WSSynchronizationPlanItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Synchronization Plan</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Synchronization Plan</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Synchronization Plan</em>' reference.
     * @see #setWsSynchronizationPlan(WSSynchronizationPlanE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWSSynchronizationPlanItem_WsSynchronizationPlan()
     * @model
     * @generated
     */
    WSSynchronizationPlanE getWsSynchronizationPlan();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WSSynchronizationPlanItem#getWsSynchronizationPlan <em>Ws Synchronization Plan</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Synchronization Plan</em>' reference.
     * @see #getWsSynchronizationPlan()
     * @generated
     */
    void setWsSynchronizationPlan(WSSynchronizationPlanE value);

} // WSSynchronizationPlanItem
