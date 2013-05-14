/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmmetadata.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.talend.core.model.metadata.builder.connection.ConnectionPackage;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataFactory;
import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MdmmetadataPackageImpl extends EPackageImpl implements MdmmetadataPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass mdmServerDefEClass = null;
	/**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private MdmmetadataPackageImpl() {
        super(eNS_URI, MdmmetadataFactory.eINSTANCE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link MdmmetadataPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static MdmmetadataPackage init() {
        if (isInited) return (MdmmetadataPackage)EPackage.Registry.INSTANCE.getEPackage(MdmmetadataPackage.eNS_URI);

        // Obtain or create and register package
        MdmmetadataPackageImpl theMdmmetadataPackage = (MdmmetadataPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MdmmetadataPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MdmmetadataPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ConnectionPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theMdmmetadataPackage.createPackageContents();

        // Initialize created meta-data
        theMdmmetadataPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theMdmmetadataPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(MdmmetadataPackage.eNS_URI, theMdmmetadataPackage);
        return theMdmmetadataPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMDMServerDef() {
        return mdmServerDefEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMDMServerDef_Host() {
        return (EAttribute)mdmServerDefEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMDMServerDef_Passwd() {
        return (EAttribute)mdmServerDefEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMDMServerDef_TempPasswd() {
        return (EAttribute)mdmServerDefEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMDMServerDef_Path() {
        return (EAttribute)mdmServerDefEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMDMServerDef_Port() {
        return (EAttribute)mdmServerDefEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMDMServerDef_Universe() {
        return (EAttribute)mdmServerDefEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMDMServerDef_Url() {
        return (EAttribute)mdmServerDefEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMDMServerDef_User() {
        return (EAttribute)mdmServerDefEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MdmmetadataFactory getMdmmetadataFactory() {
        return (MdmmetadataFactory)getEFactoryInstance();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

	/**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        mdmServerDefEClass = createEClass(MDM_SERVER_DEF);
        createEAttribute(mdmServerDefEClass, MDM_SERVER_DEF__HOST);
        createEAttribute(mdmServerDefEClass, MDM_SERVER_DEF__PASSWD);
        createEAttribute(mdmServerDefEClass, MDM_SERVER_DEF__TEMP_PASSWD);
        createEAttribute(mdmServerDefEClass, MDM_SERVER_DEF__PATH);
        createEAttribute(mdmServerDefEClass, MDM_SERVER_DEF__PORT);
        createEAttribute(mdmServerDefEClass, MDM_SERVER_DEF__UNIVERSE);
        createEAttribute(mdmServerDefEClass, MDM_SERVER_DEF__URL);
        createEAttribute(mdmServerDefEClass, MDM_SERVER_DEF__USER);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

	/**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        ConnectionPackage theConnectionPackage = (ConnectionPackage)EPackage.Registry.INSTANCE.getEPackage(ConnectionPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        mdmServerDefEClass.getESuperTypes().add(theConnectionPackage.getAbstractMetadataObject());

        // Initialize classes and features; add operations and parameters
        initEClass(mdmServerDefEClass, MDMServerDef.class, "MDMServerDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMDMServerDef_Host(), ecorePackage.getEString(), "host", "localhost", 0, 1, MDMServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerDef_Passwd(), ecorePackage.getEString(), "passwd", null, 0, 1, MDMServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerDef_TempPasswd(), ecorePackage.getEString(), "tempPasswd", null, 0, 1, MDMServerDef.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerDef_Path(), ecorePackage.getEString(), "path", null, 0, 1, MDMServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerDef_Port(), ecorePackage.getEString(), "port", null, 0, 1, MDMServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerDef_Universe(), ecorePackage.getEString(), "universe", null, 0, 1, MDMServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerDef_Url(), ecorePackage.getEString(), "url", null, 0, 1, MDMServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerDef_User(), ecorePackage.getEString(), "user", null, 0, 1, MDMServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        EOperation op = addEOperation(mdmServerDefEClass, ecorePackage.getEBoolean(), "validate", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "url", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = addEOperation(mdmServerDefEClass, this.getMDMServerDef(), "parse", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "url", 0, 1, IS_UNIQUE, IS_ORDERED);

        addEOperation(mdmServerDefEClass, ecorePackage.getEString(), "getProtocol", 0, 1, IS_UNIQUE, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //MdmmetadataPackageImpl
