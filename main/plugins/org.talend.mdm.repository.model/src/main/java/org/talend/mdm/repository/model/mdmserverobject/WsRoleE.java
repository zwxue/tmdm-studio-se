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
 * A representation of the model object '<em><b>Ws Role E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleE#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoleE()
 * @model
 * @generated
 */
public interface WsRoleE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Specification</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Specification</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Specification</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsRoleE_Specification()
     * @model containment="true"
     * @generated
     */
    EList<WsRoleSpecificationE> getSpecification();

} // WsRoleE
