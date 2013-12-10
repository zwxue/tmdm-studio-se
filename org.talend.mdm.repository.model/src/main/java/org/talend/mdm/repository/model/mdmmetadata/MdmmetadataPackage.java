/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmmetadata;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.talend.core.model.metadata.builder.connection.ConnectionPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataFactory
 * @model kind="package"
 * @generated
 */
public interface MdmmetadataPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "mdmmetadata";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://www.talend.org/metadata/mdmserverdef";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "mdmmetadata";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	MdmmetadataPackage eINSTANCE = org.talend.mdm.repository.model.mdmmetadata.impl.MdmmetadataPackageImpl.init();

	/**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl <em>MDM Server Def</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl
     * @see org.talend.mdm.repository.model.mdmmetadata.impl.MdmmetadataPackageImpl#getMDMServerDef()
     * @generated
     */
	int MDM_SERVER_DEF = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__NAME = ConnectionPackage.ABSTRACT_METADATA_OBJECT__NAME;

	/**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__VISIBILITY = ConnectionPackage.ABSTRACT_METADATA_OBJECT__VISIBILITY;

	/**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__CLIENT_DEPENDENCY = ConnectionPackage.ABSTRACT_METADATA_OBJECT__CLIENT_DEPENDENCY;

	/**
     * The feature id for the '<em><b>Supplier Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__SUPPLIER_DEPENDENCY = ConnectionPackage.ABSTRACT_METADATA_OBJECT__SUPPLIER_DEPENDENCY;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__CONSTRAINT = ConnectionPackage.ABSTRACT_METADATA_OBJECT__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Namespace</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__NAMESPACE = ConnectionPackage.ABSTRACT_METADATA_OBJECT__NAMESPACE;

	/**
     * The feature id for the '<em><b>Importer</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__IMPORTER = ConnectionPackage.ABSTRACT_METADATA_OBJECT__IMPORTER;

	/**
     * The feature id for the '<em><b>Stereotype</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__STEREOTYPE = ConnectionPackage.ABSTRACT_METADATA_OBJECT__STEREOTYPE;

	/**
     * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__TAGGED_VALUE = ConnectionPackage.ABSTRACT_METADATA_OBJECT__TAGGED_VALUE;

	/**
     * The feature id for the '<em><b>Document</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__DOCUMENT = ConnectionPackage.ABSTRACT_METADATA_OBJECT__DOCUMENT;

	/**
     * The feature id for the '<em><b>Description</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__DESCRIPTION = ConnectionPackage.ABSTRACT_METADATA_OBJECT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Responsible Party</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__RESPONSIBLE_PARTY = ConnectionPackage.ABSTRACT_METADATA_OBJECT__RESPONSIBLE_PARTY;

	/**
     * The feature id for the '<em><b>Element Node</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__ELEMENT_NODE = ConnectionPackage.ABSTRACT_METADATA_OBJECT__ELEMENT_NODE;

	/**
     * The feature id for the '<em><b>Set</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__SET = ConnectionPackage.ABSTRACT_METADATA_OBJECT__SET;

	/**
     * The feature id for the '<em><b>Rendered Object</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__RENDERED_OBJECT = ConnectionPackage.ABSTRACT_METADATA_OBJECT__RENDERED_OBJECT;

	/**
     * The feature id for the '<em><b>Vocabulary Element</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__VOCABULARY_ELEMENT = ConnectionPackage.ABSTRACT_METADATA_OBJECT__VOCABULARY_ELEMENT;

	/**
     * The feature id for the '<em><b>Measurement</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__MEASUREMENT = ConnectionPackage.ABSTRACT_METADATA_OBJECT__MEASUREMENT;

	/**
     * The feature id for the '<em><b>Change Request</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__CHANGE_REQUEST = ConnectionPackage.ABSTRACT_METADATA_OBJECT__CHANGE_REQUEST;

	/**
     * The feature id for the '<em><b>Dasdl Property</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__DASDL_PROPERTY = ConnectionPackage.ABSTRACT_METADATA_OBJECT__DASDL_PROPERTY;

	/**
     * The feature id for the '<em><b>Properties</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__PROPERTIES = ConnectionPackage.ABSTRACT_METADATA_OBJECT__PROPERTIES;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__ID = ConnectionPackage.ABSTRACT_METADATA_OBJECT__ID;

	/**
     * The feature id for the '<em><b>Comment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__COMMENT = ConnectionPackage.ABSTRACT_METADATA_OBJECT__COMMENT;

	/**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__LABEL = ConnectionPackage.ABSTRACT_METADATA_OBJECT__LABEL;

	/**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__READ_ONLY = ConnectionPackage.ABSTRACT_METADATA_OBJECT__READ_ONLY;

	/**
     * The feature id for the '<em><b>Synchronised</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__SYNCHRONISED = ConnectionPackage.ABSTRACT_METADATA_OBJECT__SYNCHRONISED;

	/**
     * The feature id for the '<em><b>Divergency</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__DIVERGENCY = ConnectionPackage.ABSTRACT_METADATA_OBJECT__DIVERGENCY;

	/**
     * The feature id for the '<em><b>Host</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__HOST = ConnectionPackage.ABSTRACT_METADATA_OBJECT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Passwd</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__PASSWD = ConnectionPackage.ABSTRACT_METADATA_OBJECT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Temp Passwd</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_DEF__TEMP_PASSWD = ConnectionPackage.ABSTRACT_METADATA_OBJECT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__PATH = ConnectionPackage.ABSTRACT_METADATA_OBJECT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__PORT = ConnectionPackage.ABSTRACT_METADATA_OBJECT_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Universe</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__UNIVERSE = ConnectionPackage.ABSTRACT_METADATA_OBJECT_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__URL = ConnectionPackage.ABSTRACT_METADATA_OBJECT_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>User</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF__USER = ConnectionPackage.ABSTRACT_METADATA_OBJECT_FEATURE_COUNT + 7;

	/**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_DEF__ENABLED = ConnectionPackage.ABSTRACT_METADATA_OBJECT_FEATURE_COUNT + 8;

    /**
     * The number of structural features of the '<em>MDM Server Def</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF_FEATURE_COUNT = ConnectionPackage.ABSTRACT_METADATA_OBJECT_FEATURE_COUNT + 9;


	/**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef <em>MDM Server Def</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>MDM Server Def</em>'.
     * @see org.talend.mdm.repository.model.mdmmetadata.MDMServerDef
     * @generated
     */
	EClass getMDMServerDef();

	/**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getHost <em>Host</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Host</em>'.
     * @see org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getHost()
     * @see #getMDMServerDef()
     * @generated
     */
	EAttribute getMDMServerDef_Host();

	/**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPasswd <em>Passwd</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Passwd</em>'.
     * @see org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPasswd()
     * @see #getMDMServerDef()
     * @generated
     */
	EAttribute getMDMServerDef_Passwd();

	/**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getTempPasswd <em>Temp Passwd</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Temp Passwd</em>'.
     * @see org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getTempPasswd()
     * @see #getMDMServerDef()
     * @generated
     */
    EAttribute getMDMServerDef_TempPasswd();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPath <em>Path</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Path</em>'.
     * @see org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPath()
     * @see #getMDMServerDef()
     * @generated
     */
	EAttribute getMDMServerDef_Path();

	/**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPort <em>Port</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port</em>'.
     * @see org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getPort()
     * @see #getMDMServerDef()
     * @generated
     */
	EAttribute getMDMServerDef_Port();

	/**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUniverse <em>Universe</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Universe</em>'.
     * @see org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUniverse()
     * @see #getMDMServerDef()
     * @generated
     */
	EAttribute getMDMServerDef_Universe();

	/**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUrl <em>Url</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Url</em>'.
     * @see org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUrl()
     * @see #getMDMServerDef()
     * @generated
     */
	EAttribute getMDMServerDef_Url();

	/**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUser <em>User</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>User</em>'.
     * @see org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getUser()
     * @see #getMDMServerDef()
     * @generated
     */
	EAttribute getMDMServerDef_User();

	/**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#isEnabled <em>Enabled</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enabled</em>'.
     * @see org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#isEnabled()
     * @see #getMDMServerDef()
     * @generated
     */
    EAttribute getMDMServerDef_Enabled();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	MdmmetadataFactory getMdmmetadataFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl <em>MDM Server Def</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl
         * @see org.talend.mdm.repository.model.mdmmetadata.impl.MdmmetadataPackageImpl#getMDMServerDef()
         * @generated
         */
		EClass MDM_SERVER_DEF = eINSTANCE.getMDMServerDef();

		/**
         * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MDM_SERVER_DEF__HOST = eINSTANCE.getMDMServerDef_Host();

		/**
         * The meta object literal for the '<em><b>Passwd</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MDM_SERVER_DEF__PASSWD = eINSTANCE.getMDMServerDef_Passwd();

		/**
         * The meta object literal for the '<em><b>Temp Passwd</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MDM_SERVER_DEF__TEMP_PASSWD = eINSTANCE.getMDMServerDef_TempPasswd();

        /**
         * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MDM_SERVER_DEF__PATH = eINSTANCE.getMDMServerDef_Path();

		/**
         * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MDM_SERVER_DEF__PORT = eINSTANCE.getMDMServerDef_Port();

		/**
         * The meta object literal for the '<em><b>Universe</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MDM_SERVER_DEF__UNIVERSE = eINSTANCE.getMDMServerDef_Universe();

		/**
         * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MDM_SERVER_DEF__URL = eINSTANCE.getMDMServerDef_Url();

		/**
         * The meta object literal for the '<em><b>User</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MDM_SERVER_DEF__USER = eINSTANCE.getMDMServerDef_User();

        /**
         * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MDM_SERVER_DEF__ENABLED = eINSTANCE.getMDMServerDef_Enabled();

	}

} //MdmmetadataPackage
