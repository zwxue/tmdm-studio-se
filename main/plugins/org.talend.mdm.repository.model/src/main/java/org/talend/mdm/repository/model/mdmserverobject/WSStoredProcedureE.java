/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Stored Procedure E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSStoredProcedureE#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSStoredProcedureE#isRefreshCache <em>Refresh Cache</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSStoredProcedureE()
 * @model
 * @generated
 */
public interface WSStoredProcedureE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Procedure</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Procedure</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Procedure</em>' attribute.
     * @see #setProcedure(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSStoredProcedureE_Procedure()
     * @model
     * @generated
     */
    String getProcedure();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSStoredProcedureE#getProcedure <em>Procedure</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Procedure</em>' attribute.
     * @see #getProcedure()
     * @generated
     */
    void setProcedure(String value);

    /**
     * Returns the value of the '<em><b>Refresh Cache</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Refresh Cache</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Refresh Cache</em>' attribute.
     * @see #setRefreshCache(boolean)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSStoredProcedureE_RefreshCache()
     * @model
     * @generated
     */
    boolean isRefreshCache();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSStoredProcedureE#isRefreshCache <em>Refresh Cache</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Refresh Cache</em>' attribute.
     * @see #isRefreshCache()
     * @generated
     */
    void setRefreshCache(boolean value);

} // WSStoredProcedureE
