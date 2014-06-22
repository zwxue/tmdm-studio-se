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
 * A representation of the model object '<em><b>EWS Menu Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry#getApplication <em>Application</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry#getContext <em>Context</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry#getSubMenus <em>Sub Menus</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getEWSMenuEntry()
 * @model
 * @generated
 */
public interface EWSMenuEntry extends EObject {
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getEWSMenuEntry_Id()
     * @model
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Application</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Application</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Application</em>' attribute.
     * @see #setApplication(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getEWSMenuEntry_Application()
     * @model
     * @generated
     */
    String getApplication();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry#getApplication <em>Application</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Application</em>' attribute.
     * @see #getApplication()
     * @generated
     */
    void setApplication(String value);

    /**
     * Returns the value of the '<em><b>Context</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context</em>' attribute.
     * @see #setContext(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getEWSMenuEntry_Context()
     * @model
     * @generated
     */
    String getContext();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry#getContext <em>Context</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context</em>' attribute.
     * @see #getContext()
     * @generated
     */
    void setContext(String value);

    /**
     * Returns the value of the '<em><b>Icon</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Icon</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Icon</em>' attribute.
     * @see #setIcon(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getEWSMenuEntry_Icon()
     * @model
     * @generated
     */
    String getIcon();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry#getIcon <em>Icon</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Icon</em>' attribute.
     * @see #getIcon()
     * @generated
     */
    void setIcon(String value);

    /**
     * Returns the value of the '<em><b>Descriptions</b></em>' reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Descriptions</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Descriptions</em>' reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getEWSMenuEntry_Descriptions()
     * @model
     * @generated
     */
    EList<WSMenuMenuEntriesDescriptionsE> getDescriptions();

    /**
     * Returns the value of the '<em><b>Sub Menus</b></em>' reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sub Menus</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sub Menus</em>' reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getEWSMenuEntry_SubMenus()
     * @model
     * @generated
     */
    EList<EWSMenuEntry> getSubMenus();

} // EWSMenuEntry
