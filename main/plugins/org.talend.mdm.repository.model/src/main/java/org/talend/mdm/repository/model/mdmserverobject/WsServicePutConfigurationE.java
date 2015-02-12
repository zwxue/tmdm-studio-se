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
 * A representation of the model object '<em><b>Ws Service Put Configuration E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsServicePutConfigurationE()
 * @model
 * @generated
 */
public interface WsServicePutConfigurationE extends EObject {
    /**
     * Returns the value of the '<em><b>Jndi Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Jndi Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Jndi Name</em>' attribute.
     * @see #setJndiName(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsServicePutConfigurationE_JndiName()
     * @model
     * @generated
     */
    String getJndiName();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE#getJndiName <em>Jndi Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Jndi Name</em>' attribute.
     * @see #getJndiName()
     * @generated
     */
    void setJndiName(String value);

    /**
     * Returns the value of the '<em><b>Configuration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configuration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Configuration</em>' attribute.
     * @see #setConfiguration(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsServicePutConfigurationE_Configuration()
     * @model
     * @generated
     */
    String getConfiguration();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE#getConfiguration <em>Configuration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configuration</em>' attribute.
     * @see #getConfiguration()
     * @generated
     */
    void setConfiguration(String value);

} // WsServicePutConfigurationE
