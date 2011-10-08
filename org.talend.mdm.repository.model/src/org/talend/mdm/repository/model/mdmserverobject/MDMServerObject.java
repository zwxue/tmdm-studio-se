/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.ecore.EObject;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MDM Server Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getDescription <em>Description</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#isSystem <em>System</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getLastServerDef <em>Last Server Def</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getType <em>Type</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#isChanged <em>Changed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getMDMServerObject()
 * @model
 * @generated
 */
public interface MDMServerObject extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getMDMServerObject_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getMDMServerObject_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>System</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>System</em>' attribute.
     * @see #setSystem(boolean)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getMDMServerObject_System()
     * @model
     * @generated
     */
    boolean isSystem();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#isSystem <em>System</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>System</em>' attribute.
     * @see #isSystem()
     * @generated
     */
    void setSystem(boolean value);

    /**
     * Returns the value of the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Server Def</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Last Server Def</em>' containment reference.
     * @see #setLastServerDef(MDMServerDef)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getMDMServerObject_LastServerDef()
     * @model containment="true"
     * @generated
     */
    MDMServerDef getLastServerDef();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getLastServerDef <em>Last Server Def</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Last Server Def</em>' containment reference.
     * @see #getLastServerDef()
     * @generated
     */
    void setLastServerDef(MDMServerDef value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(int)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getMDMServerObject_Type()
     * @model
     * @generated
     */
    int getType();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(int value);

    /**
     * Returns the value of the '<em><b>Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Changed</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Changed</em>' attribute.
     * @see #setChanged(boolean)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getMDMServerObject_Changed()
     * @model transient="true"
     * @generated
     */
    boolean isChanged();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#isChanged <em>Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Changed</em>' attribute.
     * @see #isChanged()
     * @generated
     */
    void setChanged(boolean value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    String getUniqueName();

    boolean isCreated();

    void setCreated(boolean value);

} // MDMServerObject
