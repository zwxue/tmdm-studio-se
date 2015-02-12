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
 * A representation of the model object '<em><b>Ws Role Specification Instance E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE#getInstanceName <em>Instance Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE#isWritable <em>Writable</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoleSpecificationInstanceE()
 * @model
 * @generated
 */
public interface WsRoleSpecificationInstanceE extends EObject {
    /**
     * Returns the value of the '<em><b>Instance Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instance Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instance Name</em>' attribute.
     * @see #setInstanceName(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoleSpecificationInstanceE_InstanceName()
     * @model
     * @generated
     */
    String getInstanceName();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE#getInstanceName <em>Instance Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instance Name</em>' attribute.
     * @see #getInstanceName()
     * @generated
     */
    void setInstanceName(String value);

    /**
     * Returns the value of the '<em><b>Writable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Writable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Writable</em>' attribute.
     * @see #setWritable(boolean)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoleSpecificationInstanceE_Writable()
     * @model
     * @generated
     */
    boolean isWritable();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE#isWritable <em>Writable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Writable</em>' attribute.
     * @see #isWritable()
     * @generated
     */
    void setWritable(boolean value);

    /**
     * Returns the value of the '<em><b>Parameter</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter</em>' attribute list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoleSpecificationInstanceE_Parameter()
     * @model
     * @generated
     */
    EList<String> getParameter();

} // WsRoleSpecificationInstanceE
