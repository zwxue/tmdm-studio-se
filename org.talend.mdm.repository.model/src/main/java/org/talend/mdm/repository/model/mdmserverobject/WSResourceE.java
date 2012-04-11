/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Resource E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSResourceE#getFileExtension <em>File Extension</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSResourceE#getFileContent <em>File Content</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSResourceE#getImageCatalog <em>Image Catalog</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSResourceE()
 * @model
 * @generated
 */
public interface WSResourceE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Extension</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>File Extension</em>' attribute.
     * @see #setFileExtension(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSResourceE_FileExtension()
     * @model
     * @generated
     */
    String getFileExtension();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSResourceE#getFileExtension <em>File Extension</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>File Extension</em>' attribute.
     * @see #getFileExtension()
     * @generated
     */
    void setFileExtension(String value);

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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSResourceE_FileContent()
     * @model transient="true"
     * @generated
     */
    byte[] getFileContent();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSResourceE#getFileContent <em>File Content</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>File Content</em>' attribute.
     * @see #getFileContent()
     * @generated
     */
    void setFileContent(byte[] value);

    /**
     * Returns the value of the '<em><b>Image Catalog</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Image Catalog</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Image Catalog</em>' attribute.
     * @see #setImageCatalog(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSResourceE_ImageCatalog()
     * @model
     * @generated
     */
    String getImageCatalog();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSResourceE#getImageCatalog <em>Image Catalog</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Image Catalog</em>' attribute.
     * @see #getImageCatalog()
     * @generated
     */
    void setImageCatalog(String value);

} // WSResourceE
