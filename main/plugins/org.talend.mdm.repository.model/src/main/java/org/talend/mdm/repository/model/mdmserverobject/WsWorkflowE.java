/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Workflow E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsWorkflowE#getFileContent <em>File Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsWorkflowE()
 * @model
 * @generated
 */
public interface WsWorkflowE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>File Content</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Content</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>File Content</em>' attribute.
     * @see #setFileContent(byte[])
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsWorkflowE_FileContent()
     * @model
     * @generated
     */
    byte[] getFileContent();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsWorkflowE#getFileContent <em>File Content</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>File Content</em>' attribute.
     * @see #getFileContent()
     * @generated
     */
    void setFileContent(byte[] value);

} // WsWorkflowE
