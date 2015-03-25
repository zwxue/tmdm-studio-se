/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Synchronization Plan Xtentis Objects Synchronizations E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsE#getXtentisObjectName <em>Xtentis Object Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsE#getSynchronizations <em>Synchronizations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSSynchronizationPlanXtentisObjectsSynchronizationsE()
 * @model
 * @generated
 */
public interface WSSynchronizationPlanXtentisObjectsSynchronizationsE extends EObject {
    /**
     * Returns the value of the '<em><b>Xtentis Object Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Xtentis Object Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Xtentis Object Name</em>' attribute.
     * @see #setXtentisObjectName(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSSynchronizationPlanXtentisObjectsSynchronizationsE_XtentisObjectName()
     * @model
     * @generated
     */
    String getXtentisObjectName();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsE#getXtentisObjectName <em>Xtentis Object Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Xtentis Object Name</em>' attribute.
     * @see #getXtentisObjectName()
     * @generated
     */
    void setXtentisObjectName(String value);

    /**
     * Returns the value of the '<em><b>Synchronizations</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Synchronizations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Synchronizations</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSSynchronizationPlanXtentisObjectsSynchronizationsE_Synchronizations()
     * @model containment="true"
     * @generated
     */
    EList<WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE> getSynchronizations();

} // WSSynchronizationPlanXtentisObjectsSynchronizationsE
