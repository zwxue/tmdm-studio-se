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
 * A representation of the model object '<em><b>WS Typed Content E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTypedContentE#getUrl <em>Url</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTypedContentE#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTypedContentE#getWsBytes <em>Ws Bytes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTypedContentE()
 * @model
 * @generated
 */
public interface WSTypedContentE extends EObject {
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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTypedContentE_Url()
     * @model
     * @generated
     */
    String getUrl();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSTypedContentE#getUrl <em>Url</em>}' attribute.
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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTypedContentE_ContentType()
     * @model
     * @generated
     */
    String getContentType();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSTypedContentE#getContentType <em>Content Type</em>}' attribute.
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
     * @see #setWsBytes(WSByteArrayE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTypedContentE_WsBytes()
     * @model containment="true"
     * @generated
     */
    WSByteArrayE getWsBytes();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSTypedContentE#getWsBytes <em>Ws Bytes</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ws Bytes</em>' containment reference.
     * @see #getWsBytes()
     * @generated
     */
    void setWsBytes(WSByteArrayE value);

} // WSTypedContentE
