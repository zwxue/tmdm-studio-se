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
 * A representation of the model object '<em><b>Ws Where Condition E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getLeftPath <em>Left Path</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getRightValueOrPath <em>Right Value Or Path</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getStringPredicate <em>String Predicate</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#isSpellCheck <em>Spell Check</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsWhereConditionE()
 * @model
 * @generated
 */
public interface WsWhereConditionE extends EObject {
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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsWhereConditionE_LeftPath()
     * @model
     * @generated
     */
    String getLeftPath();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getLeftPath <em>Left Path</em>}' attribute.
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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsWhereConditionE_RightValueOrPath()
     * @model
     * @generated
     */
    String getRightValueOrPath();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getRightValueOrPath <em>Right Value Or Path</em>}' attribute.
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
     * @see #setStringPredicate(WsStringPredicateE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsWhereConditionE_StringPredicate()
     * @model containment="true"
     * @generated
     */
    WsStringPredicateE getStringPredicate();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getStringPredicate <em>String Predicate</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>String Predicate</em>' containment reference.
     * @see #getStringPredicate()
     * @generated
     */
    void setStringPredicate(WsStringPredicateE value);

    /**
     * Returns the value of the '<em><b>Operator</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operator</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operator</em>' containment reference.
     * @see #setOperator(WsWhereOperatorE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsWhereConditionE_Operator()
     * @model containment="true"
     * @generated
     */
    WsWhereOperatorE getOperator();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getOperator <em>Operator</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operator</em>' containment reference.
     * @see #getOperator()
     * @generated
     */
    void setOperator(WsWhereOperatorE value);

    /**
     * Returns the value of the '<em><b>Spell Check</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Spell Check</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Spell Check</em>' attribute.
     * @see #setSpellCheck(boolean)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsWhereConditionE_SpellCheck()
     * @model
     * @generated
     */
    boolean isSpellCheck();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#isSpellCheck <em>Spell Check</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Spell Check</em>' attribute.
     * @see #isSpellCheck()
     * @generated
     */
    void setSpellCheck(boolean value);

} // WsWhereConditionE
