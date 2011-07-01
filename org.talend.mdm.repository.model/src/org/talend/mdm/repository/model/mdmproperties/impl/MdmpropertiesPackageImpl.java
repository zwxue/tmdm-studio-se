/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.talend.core.model.properties.PropertiesPackage;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;
import org.talend.mdm.repository.model.mdmproperties.WSMenuItem;
import org.talend.mdm.repository.model.mdmproperties.WSRoleItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MdmpropertiesPackageImpl extends EPackageImpl implements MdmpropertiesPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass mdmItemEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass mdmServerDefItemEClass = null;

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mdmServerObjectItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsMenuItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsRoleItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass containerItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType eRepositoryObjectTypeEDataType = null;

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
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private MdmpropertiesPackageImpl() {
        super(eNS_URI, MdmpropertiesFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link MdmpropertiesPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static MdmpropertiesPackage init() {
        if (isInited) return (MdmpropertiesPackage)EPackage.Registry.INSTANCE.getEPackage(MdmpropertiesPackage.eNS_URI);

        // Obtain or create and register package
        MdmpropertiesPackageImpl theMdmpropertiesPackage = (MdmpropertiesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MdmpropertiesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MdmpropertiesPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        MdmmetadataPackage.eINSTANCE.eClass();
        MdmserverobjectPackage.eINSTANCE.eClass();
        PropertiesPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theMdmpropertiesPackage.createPackageContents();

        // Initialize created meta-data
        theMdmpropertiesPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theMdmpropertiesPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(MdmpropertiesPackage.eNS_URI, theMdmpropertiesPackage);
        return theMdmpropertiesPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMDMItem() {
        return mdmItemEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMDMServerDefItem() {
        return mdmServerDefItemEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMDMServerDefItem_ServerDef() {
        return (EReference)mdmServerDefItemEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMDMServerObjectItem() {
        return mdmServerObjectItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSMenuItem() {
        return wsMenuItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSMenuItem_WsMenu() {
        return (EReference)wsMenuItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSRoleItem() {
        return wsRoleItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSRoleItem_WsRole() {
        return (EReference)wsRoleItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getContainerItem() {
        return containerItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getContainerItem_Label() {
        return (EAttribute)containerItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getContainerItem_RepObjType() {
        return (EAttribute)containerItemEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getERepositoryObjectType() {
        return eRepositoryObjectTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MdmpropertiesFactory getMdmpropertiesFactory() {
        return (MdmpropertiesFactory)getEFactoryInstance();
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
        mdmItemEClass = createEClass(MDM_ITEM);

        mdmServerDefItemEClass = createEClass(MDM_SERVER_DEF_ITEM);
        createEReference(mdmServerDefItemEClass, MDM_SERVER_DEF_ITEM__SERVER_DEF);

        mdmServerObjectItemEClass = createEClass(MDM_SERVER_OBJECT_ITEM);

        wsMenuItemEClass = createEClass(WS_MENU_ITEM);
        createEReference(wsMenuItemEClass, WS_MENU_ITEM__WS_MENU);

        wsRoleItemEClass = createEClass(WS_ROLE_ITEM);
        createEReference(wsRoleItemEClass, WS_ROLE_ITEM__WS_ROLE);

        containerItemEClass = createEClass(CONTAINER_ITEM);
        createEAttribute(containerItemEClass, CONTAINER_ITEM__LABEL);
        createEAttribute(containerItemEClass, CONTAINER_ITEM__REP_OBJ_TYPE);

        // Create data types
        eRepositoryObjectTypeEDataType = createEDataType(EREPOSITORY_OBJECT_TYPE);
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
        PropertiesPackage thePropertiesPackage = (PropertiesPackage)EPackage.Registry.INSTANCE.getEPackage(PropertiesPackage.eNS_URI);
        MdmmetadataPackage theMdmmetadataPackage = (MdmmetadataPackage)EPackage.Registry.INSTANCE.getEPackage(MdmmetadataPackage.eNS_URI);
        MdmserverobjectPackage theMdmserverobjectPackage = (MdmserverobjectPackage)EPackage.Registry.INSTANCE.getEPackage(MdmserverobjectPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        mdmItemEClass.getESuperTypes().add(thePropertiesPackage.getItem());
        mdmServerDefItemEClass.getESuperTypes().add(this.getMDMItem());
        mdmServerObjectItemEClass.getESuperTypes().add(this.getMDMItem());
        wsMenuItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsRoleItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        containerItemEClass.getESuperTypes().add(this.getMDMItem());
        containerItemEClass.getESuperTypes().add(thePropertiesPackage.getFolderItem());

        // Initialize classes and features; add operations and parameters
        initEClass(mdmItemEClass, MDMItem.class, "MDMItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(mdmServerDefItemEClass, MDMServerDefItem.class, "MDMServerDefItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMDMServerDefItem_ServerDef(), theMdmmetadataPackage.getMDMServerDef(), null, "serverDef", null, 0, 1, MDMServerDefItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(mdmServerObjectItemEClass, MDMServerObjectItem.class, "MDMServerObjectItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        addEOperation(mdmServerObjectItemEClass, theMdmserverobjectPackage.getMDMServerObject(), "getMDMServerObject", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(wsMenuItemEClass, WSMenuItem.class, "WSMenuItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSMenuItem_WsMenu(), theMdmserverobjectPackage.getWSMenuE(), null, "wsMenu", null, 0, 1, WSMenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoleItemEClass, WSRoleItem.class, "WSRoleItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSRoleItem_WsRole(), theMdmserverobjectPackage.getWSRoleE(), null, "wsRole", null, 0, 1, WSRoleItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(containerItemEClass, ContainerItem.class, "ContainerItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getContainerItem_Label(), theEcorePackage.getEString(), "label", null, 0, 1, ContainerItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getContainerItem_RepObjType(), this.getERepositoryObjectType(), "repObjType", null, 0, 1, ContainerItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize data types
        initEDataType(eRepositoryObjectTypeEDataType, ERepositoryObjectType.class, "ERepositoryObjectType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //MdmpropertiesPackageImpl
