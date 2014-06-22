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
 * A representation of the model object '<em><b>WS Role Specification E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE#isAdmin <em>Admin</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE#getInstance <em>Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoleSpecificationE()
 * @model
 * @generated
 */
public interface WSRoleSpecificationE extends EObject {
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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoleSpecificationE_Admin()
     * @model
     * @generated
     */
    boolean isAdmin();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE#isAdmin <em>Admin</em>}' attribute.
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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoleSpecificationE_ObjectType()
     * @model
     * @generated
     */
    String getObjectType();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE#getObjectType <em>Object Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Object Type</em>' attribute.
     * @see #getObjectType()
     * @generated
     */
    void setObjectType(String value);

    /**
     * Returns the value of the '<em><b>Instance</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instance</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instance</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoleSpecificationE_Instance()
     * @model containment="true"
     * @generated
     */
    EList<WSRoleSpecificationInstanceE> getInstance();

} // WSRoleSpecificationE
