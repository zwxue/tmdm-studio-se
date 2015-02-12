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
 * A representation of the model object '<em><b>Ws Typed Content E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getUrl <em>Url</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getWsBytes <em>Ws Bytes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsTypedContentE()
 * @model
 * @generated
 */
public interface WsTypedContentE extends EObject {
    /**
     * Returns the value of the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Url</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Url</em>' attribute.
     * @see #setUrl(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsTypedContentE_Url()
     * @model
     * @generated
     */
    String getUrl();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getUrl <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Url</em>' attribute.
     * @see #getUrl()
     * @generated
     */
    void setUrl(String value);

    /**
     * Returns the value of the '<em><b>Content Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Content Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Content Type</em>' attribute.
     * @see #setContentType(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsTypedContentE_ContentType()
     * @model
     * @generated
     */
    String getContentType();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getContentType <em>Content Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Content Type</em>' attribute.
     * @see #getContentType()
     * @generated
     */
    void setContentType(String value);

    /**
     * Returns the value of the '<em><b>Ws Bytes</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ws Bytes</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ws Bytes</em>' containment reference.
     * @see #setWsBytes(WsByteArrayE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsTypedContentE_WsBytes()
     * @model containment="true"
     * @generated
     */
    WsByteArrayE getWsBytes();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getWsBytes <em>Ws Bytes</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Bytes</em>' containment reference.
     * @see #getWsBytes()
     * @generated
     */
    void setWsBytes(WsByteArrayE value);

} // WsTypedContentE
