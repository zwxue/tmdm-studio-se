/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Universe E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSUniverseE#getDefaultItemsRevisionID <em>Default Items Revision ID</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSUniverseE#getXtentisObjectsRevisionIDs <em>Xtentis Objects Revision IDs</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSUniverseE#getItemsRevisionIDs <em>Items Revision IDs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSUniverseE()
 * @model
 * @generated
 */
public interface WSUniverseE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Default Items Revision ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Items Revision ID</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Items Revision ID</em>' attribute.
     * @see #setDefaultItemsRevisionID(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSUniverseE_DefaultItemsRevisionID()
     * @model
     * @generated
     */
    String getDefaultItemsRevisionID();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSUniverseE#getDefaultItemsRevisionID <em>Default Items Revision ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Items Revision ID</em>' attribute.
     * @see #getDefaultItemsRevisionID()
     * @generated
     */
    void setDefaultItemsRevisionID(String value);

    /**
     * Returns the value of the '<em><b>Xtentis Objects Revision IDs</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSUniverseXtentisObjectsRevisionIDsE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Xtentis Objects Revision IDs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Xtentis Objects Revision IDs</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSUniverseE_XtentisObjectsRevisionIDs()
     * @model containment="true"
     * @generated
     */
    EList<WSUniverseXtentisObjectsRevisionIDsE> getXtentisObjectsRevisionIDs();

    /**
     * Returns the value of the '<em><b>Items Revision IDs</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSUniverseItemsRevisionIDsE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items Revision IDs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Items Revision IDs</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSUniverseE_ItemsRevisionIDs()
     * @model containment="true"
     * @generated
     */
    EList<WSUniverseItemsRevisionIDsE> getItemsRevisionIDs();

} // WSUniverseE
