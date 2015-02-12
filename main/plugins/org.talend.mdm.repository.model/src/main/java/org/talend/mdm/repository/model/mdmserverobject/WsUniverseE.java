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
 * A representation of the model object '<em><b>Ws Universe E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseE#getDefaultItemsRevisionID <em>Default Items Revision ID</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseE#getXtentisObjectsRevisionIDs <em>Xtentis Objects Revision IDs</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseE#getItemsRevisionIDs <em>Items Revision IDs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsUniverseE()
 * @model
 * @generated
 */
public interface WsUniverseE extends MDMServerObject {
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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsUniverseE_DefaultItemsRevisionID()
     * @model
     * @generated
     */
    String getDefaultItemsRevisionID();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseE#getDefaultItemsRevisionID <em>Default Items Revision ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Items Revision ID</em>' attribute.
     * @see #getDefaultItemsRevisionID()
     * @generated
     */
    void setDefaultItemsRevisionID(String value);

    /**
     * Returns the value of the '<em><b>Xtentis Objects Revision IDs</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseXtentisObjectsRevisionIDsE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Xtentis Objects Revision IDs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Xtentis Objects Revision IDs</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsUniverseE_XtentisObjectsRevisionIDs()
     * @model containment="true"
     * @generated
     */
    EList<WsUniverseXtentisObjectsRevisionIDsE> getXtentisObjectsRevisionIDs();

    /**
     * Returns the value of the '<em><b>Items Revision IDs</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseItemsRevisionIDsE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items Revision IDs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Items Revision IDs</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsUniverseE_ItemsRevisionIDs()
     * @model containment="true"
     * @generated
     */
    EList<WsUniverseItemsRevisionIDsE> getItemsRevisionIDs();

} // WsUniverseE
