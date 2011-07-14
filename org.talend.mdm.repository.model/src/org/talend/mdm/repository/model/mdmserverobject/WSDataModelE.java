/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Data Model E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSDataModelE#getXsdSchema <em>Xsd Schema</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSDataModelE()
 * @model
 * @generated
 */
public interface WSDataModelE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Xsd Schema</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Xsd Schema</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Xsd Schema</em>' attribute.
     * @see #setXsdSchema(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSDataModelE_XsdSchema()
     * @model
     * @generated
     */
    String getXsdSchema();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSDataModelE#getXsdSchema <em>Xsd Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Xsd Schema</em>' attribute.
     * @see #getXsdSchema()
     * @generated
     */
    void setXsdSchema(String value);

} // WSDataModelE
