/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws Role Specification E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE#isAdmin <em>Admin</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE#getInstance <em>Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoleSpecificationE()
 * @model
 * @generated
 */
public interface WsRoleSpecificationE extends EObject {
    /**
     * Returns the value of the '<em><b>Admin</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Admin</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Admin</em>' attribute.
     * @see #setAdmin(boolean)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoleSpecificationE_Admin()
     * @model
     * @generated
     */
    boolean isAdmin();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE#isAdmin <em>Admin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Admin</em>' attribute.
     * @see #isAdmin()
     * @generated
     */
    void setAdmin(boolean value);

    /**
     * Returns the value of the '<em><b>Object Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Object Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Object Type</em>' attribute.
     * @see #setObjectType(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoleSpecificationE_ObjectType()
     * @model
     * @generated
     */
    String getObjectType();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE#getObjectType <em>Object Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Object Type</em>' attribute.
     * @see #getObjectType()
     * @generated
     */
    void setObjectType(String value);

    /**
     * Returns the value of the '<em><b>Instance</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instance</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instance</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoleSpecificationE_Instance()
     * @model containment="true"
     * @generated
     */
    EList<WsRoleSpecificationInstanceE> getInstance();

} // WsRoleSpecificationE
