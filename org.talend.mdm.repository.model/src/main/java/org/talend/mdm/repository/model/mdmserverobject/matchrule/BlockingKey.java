/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Blocking Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKey#getElmentName <em>Elment Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getBlockingKey()
 * @model
 * @generated
 */
public interface BlockingKey extends EObject {
    /**
     * Returns the value of the '<em><b>Elment Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Elment Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Elment Name</em>' attribute.
     * @see #setElmentName(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getBlockingKey_ElmentName()
     * @model
     * @generated
     */
    String getElmentName();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKey#getElmentName <em>Elment Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Elment Name</em>' attribute.
     * @see #getElmentName()
     * @generated
     */
    void setElmentName(String value);

} // BlockingKey
