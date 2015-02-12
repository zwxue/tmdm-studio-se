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
 * A representation of the model object '<em><b>Ws Menu E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuE#getMenuEntries <em>Menu Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsMenuE()
 * @model
 * @generated
 */
public interface WsMenuE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Menu Entries</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Menu Entries</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Menu Entries</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsMenuE_MenuEntries()
     * @model containment="true"
     * @generated
     */
    EList<WsMenuEntryE> getMenuEntries();

} // WsMenuE
