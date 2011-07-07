/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Where Condition E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getLeftPath <em>Left Path</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getRightValueOrPath <em>Right Value Or Path</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getStringPredicate <em>String Predicate</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSWhereConditionE()
 * @model
 * @generated
 */
public interface WSWhereConditionE extends EObject {
    /**
     * Returns the value of the '<em><b>Left Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Left Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Left Path</em>' attribute.
     * @see #setLeftPath(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSWhereConditionE_LeftPath()
     * @model
     * @generated
     */
    String getLeftPath();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getLeftPath <em>Left Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Left Path</em>' attribute.
     * @see #getLeftPath()
     * @generated
     */
    void setLeftPath(String value);

    /**
     * Returns the value of the '<em><b>Right Value Or Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Right Value Or Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Right Value Or Path</em>' attribute.
     * @see #setRightValueOrPath(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSWhereConditionE_RightValueOrPath()
     * @model
     * @generated
     */
    String getRightValueOrPath();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getRightValueOrPath <em>Right Value Or Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Right Value Or Path</em>' attribute.
     * @see #getRightValueOrPath()
     * @generated
     */
    void setRightValueOrPath(String value);

    /**
     * Returns the value of the '<em><b>String Predicate</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>String Predicate</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>String Predicate</em>' containment reference.
     * @see #setStringPredicate(WSStringPredicateE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSWhereConditionE_StringPredicate()
     * @model containment="true"
     * @generated
     */
    WSStringPredicateE getStringPredicate();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getStringPredicate <em>String Predicate</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>String Predicate</em>' containment reference.
     * @see #getStringPredicate()
     * @generated
     */
    void setStringPredicate(WSStringPredicateE value);

    /**
     * Returns the value of the '<em><b>Operator</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operator</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operator</em>' containment reference.
     * @see #setOperator(WSWhereOperatorE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSWhereConditionE_Operator()
     * @model containment="true"
     * @generated
     */
    WSWhereOperatorE getOperator();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getOperator <em>Operator</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operator</em>' containment reference.
     * @see #getOperator()
     * @generated
     */
    void setOperator(WSWhereOperatorE value);

} // WSWhereConditionE
