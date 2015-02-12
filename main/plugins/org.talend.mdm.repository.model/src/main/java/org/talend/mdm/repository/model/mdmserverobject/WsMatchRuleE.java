/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Match Rule E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE#getConfigurationXmlContent <em>Configuration Xml Content</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE#getPK <em>PK</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsMatchRuleE()
 * @model
 * @generated
 */
public interface WsMatchRuleE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Configuration Xml Content</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configuration Xml Content</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Configuration Xml Content</em>' attribute.
     * @see #setConfigurationXmlContent(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsMatchRuleE_ConfigurationXmlContent()
     * @model
     * @generated
     */
    String getConfigurationXmlContent();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE#getConfigurationXmlContent <em>Configuration Xml Content</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configuration Xml Content</em>' attribute.
     * @see #getConfigurationXmlContent()
     * @generated
     */
    void setConfigurationXmlContent(String value);

    /**
     * Returns the value of the '<em><b>PK</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>PK</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>PK</em>' containment reference.
     * @see #setPK(WsMatchRulePKE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsMatchRuleE_PK()
     * @model containment="true"
     * @generated
     */
    WsMatchRulePKE getPK();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE#getPK <em>PK</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>PK</em>' containment reference.
     * @see #getPK()
     * @generated
     */
    void setPK(WsMatchRulePKE value);

} // WsMatchRuleE
