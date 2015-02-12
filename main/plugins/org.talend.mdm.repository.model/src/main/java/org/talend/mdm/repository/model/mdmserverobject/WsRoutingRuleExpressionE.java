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
 * A representation of the model object '<em><b>Ws Routing Rule Expression E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getXpath <em>Xpath</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getValue <em>Value</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getWsOperator <em>Ws Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoutingRuleExpressionE()
 * @model
 * @generated
 */
public interface WsRoutingRuleExpressionE extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoutingRuleExpressionE_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Xpath</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Xpath</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Xpath</em>' attribute.
     * @see #setXpath(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoutingRuleExpressionE_Xpath()
     * @model
     * @generated
     */
    String getXpath();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getXpath <em>Xpath</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Xpath</em>' attribute.
     * @see #getXpath()
     * @generated
     */
    void setXpath(String value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoutingRuleExpressionE_Value()
     * @model
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Ws Operator</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Operator</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Operator</em>' containment reference.
     * @see #setWsOperator(WsRoutingRuleOperatorE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoutingRuleExpressionE_WsOperator()
     * @model containment="true"
     * @generated
     */
    WsRoutingRuleOperatorE getWsOperator();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getWsOperator <em>Ws Operator</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Operator</em>' containment reference.
     * @see #getWsOperator()
     * @generated
     */
    void setWsOperator(WsRoutingRuleOperatorE value);

} // WsRoutingRuleExpressionE
