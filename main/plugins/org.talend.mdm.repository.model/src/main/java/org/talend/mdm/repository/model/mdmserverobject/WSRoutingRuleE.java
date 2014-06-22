/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Routing Rule E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#isSynchronous <em>Synchronous</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#getConcept <em>Concept</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#getServiceJNDI <em>Service JNDI</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#isDeactive <em>Deactive</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#getExecuteOrder <em>Execute Order</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#getWsRoutingRuleExpressions <em>Ws Routing Rule Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoutingRuleE()
 * @model
 * @generated
 */
public interface WSRoutingRuleE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Synchronous</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Synchronous</em>' attribute.
     * @see #setSynchronous(boolean)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoutingRuleE_Synchronous()
     * @model
     * @generated
     */
    boolean isSynchronous();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#isSynchronous <em>Synchronous</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Synchronous</em>' attribute.
     * @see #isSynchronous()
     * @generated
     */
    void setSynchronous(boolean value);

    /**
     * Returns the value of the '<em><b>Concept</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Concept</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Concept</em>' attribute.
     * @see #setConcept(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoutingRuleE_Concept()
     * @model
     * @generated
     */
    String getConcept();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#getConcept <em>Concept</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Concept</em>' attribute.
     * @see #getConcept()
     * @generated
     */
    void setConcept(String value);

    /**
     * Returns the value of the '<em><b>Service JNDI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service JNDI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service JNDI</em>' attribute.
     * @see #setServiceJNDI(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoutingRuleE_ServiceJNDI()
     * @model
     * @generated
     */
    String getServiceJNDI();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#getServiceJNDI <em>Service JNDI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service JNDI</em>' attribute.
     * @see #getServiceJNDI()
     * @generated
     */
    void setServiceJNDI(String value);

    /**
     * Returns the value of the '<em><b>Parameters</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameters</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameters</em>' attribute.
     * @see #setParameters(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoutingRuleE_Parameters()
     * @model
     * @generated
     */
    String getParameters();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#getParameters <em>Parameters</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameters</em>' attribute.
     * @see #getParameters()
     * @generated
     */
    void setParameters(String value);

    /**
     * Returns the value of the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Condition</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' attribute.
     * @see #setCondition(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoutingRuleE_Condition()
     * @model
     * @generated
     */
    String getCondition();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#getCondition <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition</em>' attribute.
     * @see #getCondition()
     * @generated
     */
    void setCondition(String value);

    /**
     * Returns the value of the '<em><b>Deactive</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Deactive</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deactive</em>' attribute.
     * @see #setDeactive(boolean)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoutingRuleE_Deactive()
     * @model
     * @generated
     */
    boolean isDeactive();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#isDeactive <em>Deactive</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Deactive</em>' attribute.
     * @see #isDeactive()
     * @generated
     */
    void setDeactive(boolean value);

    /**
     * Returns the value of the '<em><b>Execute Order</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Execute Order</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Execute Order</em>' attribute.
     * @see #setExecuteOrder(int)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoutingRuleE_ExecuteOrder()
     * @model
     * @generated
     */
    int getExecuteOrder();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE#getExecuteOrder <em>Execute Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Execute Order</em>' attribute.
     * @see #getExecuteOrder()
     * @generated
     */
    void setExecuteOrder(int value);

    /**
     * Returns the value of the '<em><b>Ws Routing Rule Expressions</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleExpressionE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Routing Rule Expressions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Routing Rule Expressions</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoutingRuleE_WsRoutingRuleExpressions()
     * @model containment="true"
     * @generated
     */
    EList<WSRoutingRuleExpressionE> getWsRoutingRuleExpressions();

} // WSRoutingRuleE
