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
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getDigestValue <em>Digest Value</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getCurrentDigestValue <em>Current Digest Value</em>}</li>
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
     * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timestamp</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timestamp</em>' attribute.
     * @see #setTimestamp(long)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getMDMServerObject_Timestamp()
     * @model
     * @generated
     */
    long getTimestamp();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getTimestamp <em>Timestamp</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timestamp</em>' attribute.
     * @see #getTimestamp()
     * @generated
     */
    void setTimestamp(long value);

    /**
     * Returns the value of the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Digest Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Digest Value</em>' attribute.
     * @see #setDigestValue(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getMDMServerObject_DigestValue()
     * @model
     * @generated
     */
    String getDigestValue();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getDigestValue <em>Digest Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Digest Value</em>' attribute.
     * @see #getDigestValue()
     * @generated
     */
    void setDigestValue(String value);

    /**
     * Returns the value of the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Current Digest Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Current Digest Value</em>' attribute.
     * @see #setCurrentDigestValue(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getMDMServerObject_CurrentDigestValue()
     * @model transient="true"
     * @generated
     */
    String getCurrentDigestValue();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getCurrentDigestValue <em>Current Digest Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Current Digest Value</em>' attribute.
     * @see #getCurrentDigestValue()
     * @generated
     */
    void setCurrentDigestValue(String value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    String getUniqueName();

} // MDMServerObject
