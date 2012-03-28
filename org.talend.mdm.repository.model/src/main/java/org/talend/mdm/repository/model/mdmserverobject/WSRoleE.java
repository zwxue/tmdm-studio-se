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
 * A representation of the model object '<em><b>WS Role E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleE#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoleE()
 * @model
 * @generated
 */
public interface WSRoleE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Specification</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Specification</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Specification</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSRoleE_Specification()
     * @model containment="true"
     * @generated
     */
    EList<WSRoleSpecificationE> getSpecification();

} // WSRoleE
