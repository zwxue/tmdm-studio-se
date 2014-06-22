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
 * A representation of the model object '<em><b>EWS Menu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.EWSMenu#getMenuEntries <em>Menu Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getEWSMenu()
 * @model
 * @generated
 */
public interface EWSMenu extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Menu Entries</b></em>' reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Menu Entries</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Menu Entries</em>' reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getEWSMenu_MenuEntries()
     * @model
     * @generated
     */
    EList<EWSMenuEntry> getMenuEntries();

} // EWSMenu
