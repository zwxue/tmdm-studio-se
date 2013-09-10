/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Match Rule E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSMatchRuleE#getConfigurationXmlContent <em>Configuration Xml Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSMatchRuleE()
 * @model
 * @generated
 */
public interface WSMatchRuleE extends MDMServerObject {
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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSMatchRuleE_ConfigurationXmlContent()
     * @model
     * @generated
     */
    String getConfigurationXmlContent();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSMatchRuleE#getConfigurationXmlContent <em>Configuration Xml Content</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configuration Xml Content</em>' attribute.
     * @see #getConfigurationXmlContent()
     * @generated
     */
    void setConfigurationXmlContent(String value);

} // WSMatchRuleE
