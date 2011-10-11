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
 * A representation of the model object '<em><b>WS Transformer V2E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerV2E#getProcessSteps <em>Process Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerV2E()
 * @model
 * @generated
 */
public interface WSTransformerV2E extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Process Steps</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Process Steps</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Process Steps</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerV2E_ProcessSteps()
     * @model containment="true"
     * @generated
     */
    EList<WSTransformerProcessStepE> getProcessSteps();

} // WSTransformerV2E
