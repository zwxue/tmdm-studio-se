/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Synchronization Plan Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.WsSynchronizationPlanItem#getWsSynchronizationPlan <em>Ws Synchronization Plan</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsSynchronizationPlanItem()
 * @model
 * @generated
 */
public interface WsSynchronizationPlanItem extends MDMServerObjectItem {
    /**
     * Returns the value of the '<em><b>Ws Synchronization Plan</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Synchronization Plan</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Synchronization Plan</em>' reference.
     * @see #setWsSynchronizationPlan(WsSynchronizationPlanE)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getWsSynchronizationPlanItem_WsSynchronizationPlan()
     * @model
     * @generated
     */
    WsSynchronizationPlanE getWsSynchronizationPlan();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.WsSynchronizationPlanItem#getWsSynchronizationPlan <em>Ws Synchronization Plan</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Synchronization Plan</em>' reference.
     * @see #getWsSynchronizationPlan()
     * @generated
     */
    void setWsSynchronizationPlan(WsSynchronizationPlanE value);

} // WsSynchronizationPlanItem
