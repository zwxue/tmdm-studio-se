/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmmetadata;

import org.talend.core.model.metadata.builder.connection.AbstractMetadataObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MDM Server Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getHost <em>Host</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPasswd <em>Passwd</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getTempPasswd <em>Temp Passwd</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPath <em>Path</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPort <em>Port</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUniverse <em>Universe</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUrl <em>Url</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUser <em>User</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#isEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage#getMDMServerDef()
 * @model
 * @generated
 */
public interface MDMServerDef extends AbstractMetadataObject {
	/**
     * Returns the value of the '<em><b>Host</b></em>' attribute.
     * The default value is <code>"localhost"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Host</em>' attribute.
     * @see #setHost(String)
     * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage#getMDMServerDef_Host()
     * @model default="localhost"
     * @generated
     */
	String getHost();

	/**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getHost <em>Host</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Host</em>' attribute.
     * @see #getHost()
     * @generated
     */
	void setHost(String value);

	/**
     * Returns the value of the '<em><b>Passwd</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passwd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Passwd</em>' attribute.
     * @see #setPasswd(String)
     * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage#getMDMServerDef_Passwd()
     * @model
     * @generated
     */
	String getPasswd();

	/**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPasswd <em>Passwd</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Passwd</em>' attribute.
     * @see #getPasswd()
     * @generated
     */
	void setPasswd(String value);

	/**
     * Returns the value of the '<em><b>Temp Passwd</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Temp Passwd</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Temp Passwd</em>' attribute.
     * @see #setTempPasswd(String)
     * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage#getMDMServerDef_TempPasswd()
     * @model transient="true"
     * @generated
     */
    String getTempPasswd();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getTempPasswd <em>Temp Passwd</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Temp Passwd</em>' attribute.
     * @see #getTempPasswd()
     * @generated
     */
    void setTempPasswd(String value);

    /**
     * Returns the value of the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Path</em>' attribute.
     * @see #setPath(String)
     * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage#getMDMServerDef_Path()
     * @model
     * @generated
     */
	String getPath();

	/**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPath <em>Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Path</em>' attribute.
     * @see #getPath()
     * @generated
     */
	void setPath(String value);

	/**
     * Returns the value of the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Port</em>' attribute.
     * @see #setPort(String)
     * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage#getMDMServerDef_Port()
     * @model
     * @generated
     */
	String getPort();

	/**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPort <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port</em>' attribute.
     * @see #getPort()
     * @generated
     */
	void setPort(String value);

	/**
     * Returns the value of the '<em><b>Universe</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Universe</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Universe</em>' attribute.
     * @see #setUniverse(String)
     * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage#getMDMServerDef_Universe()
     * @model
     * @generated
     */
	String getUniverse();

	/**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUniverse <em>Universe</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Universe</em>' attribute.
     * @see #getUniverse()
     * @generated
     */
	void setUniverse(String value);

	/**
     * Returns the value of the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Url</em>' attribute.
     * @see #setUrl(String)
     * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage#getMDMServerDef_Url()
     * @model
     * @generated
     */
	String getUrl();

	/**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUrl <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Url</em>' attribute.
     * @see #getUrl()
     * @generated
     */
    void setUrl(String value);

    /**
     * Returns the value of the '<em><b>User</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>User</em>' attribute.
     * @see #setUser(String)
     * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage#getMDMServerDef_User()
     * @model
     * @generated
     */
	String getUser();

	/**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUser <em>User</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>User</em>' attribute.
     * @see #getUser()
     * @generated
     */
	void setUser(String value);

	/**
     * Returns the value of the '<em><b>Enabled</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enabled</em>' attribute.
     * @see #setEnabled(boolean)
     * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage#getMDMServerDef_Enabled()
     * @model default="true"
     * @generated
     */
    boolean isEnabled();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#isEnabled <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enabled</em>' attribute.
     * @see #isEnabled()
     * @generated
     */
    void setEnabled(boolean value);

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model
     * @generated
     */
	boolean validate(String url);

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    MDMServerDef parse(String url);
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    String getProtocol();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    boolean isEnableSSL();

    /**
     * 
     * get the decrypted ServerDef
     * @return
     */
    MDMServerDef getDecryptedServerDef();

    /**
     * return a new encrypted serverDef
     * 
     * @return
     */
    MDMServerDef getEncryptedServerDef();
} // MDMServerDef
