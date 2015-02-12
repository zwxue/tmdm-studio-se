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
 * A representation of the model object '<em><b>Ws Transformer V2E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerV2E#getProcessSteps <em>Process Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsTransformerV2E()
 * @model
 * @generated
 */
public interface WsTransformerV2E extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Process Steps</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Process Steps</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Process Steps</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsTransformerV2E_ProcessSteps()
     * @model containment="true"
     * @generated
     */
    EList<WsTransformerProcessStepE> getProcessSteps();

} // WsTransformerV2E
