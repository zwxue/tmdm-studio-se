/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Form</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.CustomForm#getFilename <em>Filename</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.CustomForm#getDataModelName <em>Data Model Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.CustomForm#getEntityName <em>Entity Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getCustomForm()
 * @model
 * @generated
 */
public interface CustomForm extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Filename</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Filename</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Filename</em>' attribute.
     * @see #setFilename(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getCustomForm_Filename()
     * @model
     * @generated
     */
    String getFilename();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.CustomForm#getFilename <em>Filename</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Filename</em>' attribute.
     * @see #getFilename()
     * @generated
     */
    void setFilename(String value);

    /**
     * Returns the value of the '<em><b>Data Model Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Model Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Model Name</em>' attribute.
     * @see #setDataModelName(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getCustomForm_DataModelName()
     * @model
     * @generated
     */
    String getDataModelName();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.CustomForm#getDataModelName <em>Data Model Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Model Name</em>' attribute.
     * @see #getDataModelName()
     * @generated
     */
    void setDataModelName(String value);

    /**
     * Returns the value of the '<em><b>Entity Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entity Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entity Name</em>' attribute.
     * @see #setEntityName(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getCustomForm_EntityName()
     * @model
     * @generated
     */
    String getEntityName();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.CustomForm#getEntityName <em>Entity Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Entity Name</em>' attribute.
     * @see #getEntityName()
     * @generated
     */
    void setEntityName(String value);

} // CustomForm
