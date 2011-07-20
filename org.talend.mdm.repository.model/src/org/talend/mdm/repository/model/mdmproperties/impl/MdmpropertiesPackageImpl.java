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
import org.talend.mdm.repository.model.mdmproperties.WSDataClusterItem;
import org.talend.mdm.repository.model.mdmproperties.WSDataModelItem;
import org.talend.mdm.repository.model.mdmproperties.WSJobModelItem;
import org.talend.mdm.repository.model.mdmproperties.WSMenuItem;
import org.talend.mdm.repository.model.mdmproperties.WSRoleItem;
import org.talend.mdm.repository.model.mdmproperties.WSRoutingRuleItem;
import org.talend.mdm.repository.model.mdmproperties.WSStoredProcedureItem;
import org.talend.mdm.repository.model.mdmproperties.WSSynchronizationPlanItem;
import org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item;
import org.talend.mdm.repository.model.mdmproperties.WSUniverseItem;
import org.talend.mdm.repository.model.mdmproperties.WSViewItem;
import org.talend.mdm.repository.model.mdmproperties.WSWorkflowDeployItem;
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
    private EClass wsDataModelItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsDataClusterItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsStoredProcedureItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsUniverseItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsSynchronizationPlanItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsViewItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsWorkflowDeployItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsTransformerV2ItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsRoutingRuleItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsJobModelItemEClass = null;

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
    public EClass getWSDataModelItem() {
        return wsDataModelItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSDataModelItem_WsDataModel() {
        return (EReference)wsDataModelItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSDataClusterItem() {
        return wsDataClusterItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSDataClusterItem_WsDataCluster() {
        return (EReference)wsDataClusterItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSStoredProcedureItem() {
        return wsStoredProcedureItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSStoredProcedureItem_WsStoredProcedure() {
        return (EReference)wsStoredProcedureItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSUniverseItem() {
        return wsUniverseItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSUniverseItem_WsUniverse() {
        return (EReference)wsUniverseItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSSynchronizationPlanItem() {
        return wsSynchronizationPlanItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSSynchronizationPlanItem_WsSynchronizationPlan() {
        return (EReference)wsSynchronizationPlanItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSViewItem() {
        return wsViewItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSViewItem_WsView() {
        return (EReference)wsViewItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSWorkflowDeployItem() {
        return wsWorkflowDeployItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSWorkflowDeployItem_WsWorkflowDeploy() {
        return (EReference)wsWorkflowDeployItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSTransformerV2Item() {
        return wsTransformerV2ItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSTransformerV2Item_WsTransformerV2() {
        return (EReference)wsTransformerV2ItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSRoutingRuleItem() {
        return wsRoutingRuleItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSRoutingRuleItem_WsRoutingRule() {
        return (EReference)wsRoutingRuleItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSJobModelItem() {
        return wsJobModelItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSJobModelItem_WsJobModelItem() {
        return (EReference)wsJobModelItemEClass.getEStructuralFeatures().get(0);
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

        wsDataModelItemEClass = createEClass(WS_DATA_MODEL_ITEM);
        createEReference(wsDataModelItemEClass, WS_DATA_MODEL_ITEM__WS_DATA_MODEL);

        wsDataClusterItemEClass = createEClass(WS_DATA_CLUSTER_ITEM);
        createEReference(wsDataClusterItemEClass, WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER);

        wsStoredProcedureItemEClass = createEClass(WS_STORED_PROCEDURE_ITEM);
        createEReference(wsStoredProcedureItemEClass, WS_STORED_PROCEDURE_ITEM__WS_STORED_PROCEDURE);

        wsUniverseItemEClass = createEClass(WS_UNIVERSE_ITEM);
        createEReference(wsUniverseItemEClass, WS_UNIVERSE_ITEM__WS_UNIVERSE);

        wsSynchronizationPlanItemEClass = createEClass(WS_SYNCHRONIZATION_PLAN_ITEM);
        createEReference(wsSynchronizationPlanItemEClass, WS_SYNCHRONIZATION_PLAN_ITEM__WS_SYNCHRONIZATION_PLAN);

        wsViewItemEClass = createEClass(WS_VIEW_ITEM);
        createEReference(wsViewItemEClass, WS_VIEW_ITEM__WS_VIEW);

        wsWorkflowDeployItemEClass = createEClass(WS_WORKFLOW_DEPLOY_ITEM);
        createEReference(wsWorkflowDeployItemEClass, WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY);

        wsTransformerV2ItemEClass = createEClass(WS_TRANSFORMER_V2_ITEM);
        createEReference(wsTransformerV2ItemEClass, WS_TRANSFORMER_V2_ITEM__WS_TRANSFORMER_V2);

        wsRoutingRuleItemEClass = createEClass(WS_ROUTING_RULE_ITEM);
        createEReference(wsRoutingRuleItemEClass, WS_ROUTING_RULE_ITEM__WS_ROUTING_RULE);

        wsJobModelItemEClass = createEClass(WS_JOB_MODEL_ITEM);
        createEReference(wsJobModelItemEClass, WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM);

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
        wsDataModelItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsDataClusterItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsStoredProcedureItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsUniverseItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsSynchronizationPlanItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsViewItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsWorkflowDeployItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsTransformerV2ItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsRoutingRuleItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsJobModelItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());

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

        initEClass(wsDataModelItemEClass, WSDataModelItem.class, "WSDataModelItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSDataModelItem_WsDataModel(), theMdmserverobjectPackage.getWSDataModelE(), null, "wsDataModel", null, 0, 1, WSDataModelItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsDataClusterItemEClass, WSDataClusterItem.class, "WSDataClusterItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSDataClusterItem_WsDataCluster(), theMdmserverobjectPackage.getWSDataClusterE(), null, "wsDataCluster", null, 0, 1, WSDataClusterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsStoredProcedureItemEClass, WSStoredProcedureItem.class, "WSStoredProcedureItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSStoredProcedureItem_WsStoredProcedure(), theMdmserverobjectPackage.getWSStoredProcedureE(), null, "wsStoredProcedure", null, 0, 1, WSStoredProcedureItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsUniverseItemEClass, WSUniverseItem.class, "WSUniverseItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSUniverseItem_WsUniverse(), theMdmserverobjectPackage.getWSUniverseE(), null, "wsUniverse", null, 0, 1, WSUniverseItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsSynchronizationPlanItemEClass, WSSynchronizationPlanItem.class, "WSSynchronizationPlanItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSSynchronizationPlanItem_WsSynchronizationPlan(), theMdmserverobjectPackage.getWSSynchronizationPlanE(), null, "wsSynchronizationPlan", null, 0, 1, WSSynchronizationPlanItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsViewItemEClass, WSViewItem.class, "WSViewItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSViewItem_WsView(), theMdmserverobjectPackage.getWSViewE(), null, "wsView", null, 0, 1, WSViewItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsWorkflowDeployItemEClass, WSWorkflowDeployItem.class, "WSWorkflowDeployItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSWorkflowDeployItem_WsWorkflowDeploy(), theMdmserverobjectPackage.getWSWorkflowDeployE(), null, "wsWorkflowDeploy", null, 0, 1, WSWorkflowDeployItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsTransformerV2ItemEClass, WSTransformerV2Item.class, "WSTransformerV2Item", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSTransformerV2Item_WsTransformerV2(), theMdmserverobjectPackage.getWSTransformerV2E(), null, "wsTransformerV2", null, 0, 1, WSTransformerV2Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoutingRuleItemEClass, WSRoutingRuleItem.class, "WSRoutingRuleItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSRoutingRuleItem_WsRoutingRule(), theMdmserverobjectPackage.getWSRoutingRuleE(), null, "wsRoutingRule", null, 0, 1, WSRoutingRuleItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsJobModelItemEClass, WSJobModelItem.class, "WSJobModelItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSJobModelItem_WsJobModelItem(), theMdmserverobjectPackage.getWSJobModelE(), null, "wsJobModelItem", null, 0, 1, WSJobModelItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize data types
        initEDataType(eRepositoryObjectTypeEDataType, ERepositoryObjectType.class, "ERepositoryObjectType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //MdmpropertiesPackageImpl
