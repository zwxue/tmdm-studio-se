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
 * A representation of the model object '<em><b>WS Service Configuration E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSServiceConfigurationE#getServicePutConfigurations <em>Service Put Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSServiceConfigurationE()
 * @model
 * @generated
 */
public interface WSServiceConfigurationE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Service Put Configurations</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSServicePutConfigurationE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Put Configurations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Put Configurations</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSServiceConfigurationE_ServicePutConfigurations()
     * @model containment="true"
     * @generated
     */
    EList<WSServicePutConfigurationE> getServicePutConfigurations();

} // WSServiceConfigurationE
