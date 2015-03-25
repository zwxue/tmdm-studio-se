/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Blocking Key Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKeyDefinition#getBlockingKeys <em>Blocking Keys</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKeyDefinition#isUseBuiltInColumn <em>Use Built In Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getBlockingKeyDefinition()
 * @model
 * @generated
 */
public interface BlockingKeyDefinition extends EObject {
    /**
     * Returns the value of the '<em><b>Blocking Keys</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKey}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Blocking Keys</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Blocking Keys</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getBlockingKeyDefinition_BlockingKeys()
     * @model containment="true"
     * @generated
     */
    EList<BlockingKey> getBlockingKeys();

    /**
     * Returns the value of the '<em><b>Use Built In Column</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Use Built In Column</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Use Built In Column</em>' attribute.
     * @see #setUseBuiltInColumn(boolean)
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getBlockingKeyDefinition_UseBuiltInColumn()
     * @model
     * @generated
     */
    boolean isUseBuiltInColumn();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKeyDefinition#isUseBuiltInColumn <em>Use Built In Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Use Built In Column</em>' attribute.
     * @see #isUseBuiltInColumn()
     * @generated
     */
    void setUseBuiltInColumn(boolean value);

} // BlockingKeyDefinition
