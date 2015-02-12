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
import org.eclipse.emf.ecore.EOperation;
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
import org.talend.mdm.repository.model.mdmproperties.WorkspaceRootItem;
import org.talend.mdm.repository.model.mdmproperties.WsCustomFormItem;
import org.talend.mdm.repository.model.mdmproperties.WsDataClusterItem;
import org.talend.mdm.repository.model.mdmproperties.WsDataModelItem;
import org.talend.mdm.repository.model.mdmproperties.WsEventManagerItem;
import org.talend.mdm.repository.model.mdmproperties.WsJobModelItem;
import org.talend.mdm.repository.model.mdmproperties.WsMatchRuleItem;
import org.talend.mdm.repository.model.mdmproperties.WsMenuItem;
import org.talend.mdm.repository.model.mdmproperties.WsResourceItem;
import org.talend.mdm.repository.model.mdmproperties.WsRoleItem;
import org.talend.mdm.repository.model.mdmproperties.WsRoutingRuleItem;
import org.talend.mdm.repository.model.mdmproperties.WsServiceConfigurationItem;
import org.talend.mdm.repository.model.mdmproperties.WsStoredProcedureItem;
import org.talend.mdm.repository.model.mdmproperties.WsSynchronizationPlanItem;
import org.talend.mdm.repository.model.mdmproperties.WsTransformerV2Item;
import org.talend.mdm.repository.model.mdmproperties.WsUniverseItem;
import org.talend.mdm.repository.model.mdmproperties.WsViewItem;
import org.talend.mdm.repository.model.mdmproperties.WsWorkflowDeployItem;
import org.talend.mdm.repository.model.mdmproperties.WsWorkflowItem;

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
    private EClass wsEventManagerItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsServiceConfigurationItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsWorkflowItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsResourceItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsCustomFormItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass workspaceRootItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsMatchRuleItemEClass = null;

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
    public EClass getWsMenuItem() {
        return wsMenuItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsMenuItem_WsMenu() {
        return (EReference)wsMenuItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsRoleItem() {
        return wsRoleItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsRoleItem_WsRole() {
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
    public EAttribute getContainerItem_Data() {
        return (EAttribute)containerItemEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsDataModelItem() {
        return wsDataModelItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsDataModelItem_WsDataModel() {
        return (EReference)wsDataModelItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsDataClusterItem() {
        return wsDataClusterItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsDataClusterItem_WsDataCluster() {
        return (EReference)wsDataClusterItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsStoredProcedureItem() {
        return wsStoredProcedureItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsStoredProcedureItem_WsStoredProcedure() {
        return (EReference)wsStoredProcedureItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsUniverseItem() {
        return wsUniverseItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsUniverseItem_WsUniverse() {
        return (EReference)wsUniverseItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsSynchronizationPlanItem() {
        return wsSynchronizationPlanItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsSynchronizationPlanItem_WsSynchronizationPlan() {
        return (EReference)wsSynchronizationPlanItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsViewItem() {
        return wsViewItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsViewItem_WsView() {
        return (EReference)wsViewItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsWorkflowDeployItem() {
        return wsWorkflowDeployItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsWorkflowDeployItem_WsWorkflowDeploy() {
        return (EReference)wsWorkflowDeployItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsTransformerV2Item() {
        return wsTransformerV2ItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsTransformerV2Item_WsTransformerV2() {
        return (EReference)wsTransformerV2ItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsRoutingRuleItem() {
        return wsRoutingRuleItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsRoutingRuleItem_WsRoutingRule() {
        return (EReference)wsRoutingRuleItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsJobModelItem() {
        return wsJobModelItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsJobModelItem_WsJobModelItem() {
        return (EReference)wsJobModelItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsEventManagerItem() {
        return wsEventManagerItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsEventManagerItem_WsEventManager() {
        return (EReference)wsEventManagerItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsServiceConfigurationItem() {
        return wsServiceConfigurationItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsServiceConfigurationItem_WsServiceConfiguration() {
        return (EReference)wsServiceConfigurationItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsWorkflowItem() {
        return wsWorkflowItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsWorkflowItem_WsWorkflow() {
        return (EReference)wsWorkflowItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsResourceItem() {
        return wsResourceItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsResourceItem_Resource() {
        return (EReference)wsResourceItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsCustomFormItem() {
        return wsCustomFormItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsCustomFormItem_CustomForm() {
        return (EReference)wsCustomFormItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWorkspaceRootItem() {
        return workspaceRootItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWorkspaceRootItem_Label() {
        return (EAttribute)workspaceRootItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsMatchRuleItem() {
        return wsMatchRuleItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsMatchRuleItem_MdmMatchRule() {
        return (EReference)wsMatchRuleItemEClass.getEStructuralFeatures().get(0);
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
        createEAttribute(containerItemEClass, CONTAINER_ITEM__DATA);

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

        wsEventManagerItemEClass = createEClass(WS_EVENT_MANAGER_ITEM);
        createEReference(wsEventManagerItemEClass, WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER);

        wsServiceConfigurationItemEClass = createEClass(WS_SERVICE_CONFIGURATION_ITEM);
        createEReference(wsServiceConfigurationItemEClass, WS_SERVICE_CONFIGURATION_ITEM__WS_SERVICE_CONFIGURATION);

        wsWorkflowItemEClass = createEClass(WS_WORKFLOW_ITEM);
        createEReference(wsWorkflowItemEClass, WS_WORKFLOW_ITEM__WS_WORKFLOW);

        wsResourceItemEClass = createEClass(WS_RESOURCE_ITEM);
        createEReference(wsResourceItemEClass, WS_RESOURCE_ITEM__RESOURCE);

        wsCustomFormItemEClass = createEClass(WS_CUSTOM_FORM_ITEM);
        createEReference(wsCustomFormItemEClass, WS_CUSTOM_FORM_ITEM__CUSTOM_FORM);

        workspaceRootItemEClass = createEClass(WORKSPACE_ROOT_ITEM);
        createEAttribute(workspaceRootItemEClass, WORKSPACE_ROOT_ITEM__LABEL);

        wsMatchRuleItemEClass = createEClass(WS_MATCH_RULE_ITEM);
        createEReference(wsMatchRuleItemEClass, WS_MATCH_RULE_ITEM__MDM_MATCH_RULE);

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
        wsEventManagerItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsServiceConfigurationItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsWorkflowItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsResourceItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        wsCustomFormItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());
        workspaceRootItemEClass.getESuperTypes().add(this.getMDMItem());
        workspaceRootItemEClass.getESuperTypes().add(thePropertiesPackage.getFolderItem());
        wsMatchRuleItemEClass.getESuperTypes().add(this.getMDMServerObjectItem());

        // Initialize classes and features; add operations and parameters
        initEClass(mdmItemEClass, MDMItem.class, "MDMItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(mdmServerDefItemEClass, MDMServerDefItem.class, "MDMServerDefItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMDMServerDefItem_ServerDef(), theMdmmetadataPackage.getMDMServerDef(), null, "serverDef", null, 0, 1, MDMServerDefItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(mdmServerObjectItemEClass, MDMServerObjectItem.class, "MDMServerObjectItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        addEOperation(mdmServerObjectItemEClass, theMdmserverobjectPackage.getMDMServerObject(), "getMDMServerObject", 0, 1, IS_UNIQUE, IS_ORDERED);

        EOperation op = addEOperation(mdmServerObjectItemEClass, null, "setMDMServerObject", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMdmserverobjectPackage.getMDMServerObject(), "serverObj", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(wsMenuItemEClass, WsMenuItem.class, "WsMenuItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsMenuItem_WsMenu(), theMdmserverobjectPackage.getWsMenuE(), null, "wsMenu", null, 0, 1, WsMenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoleItemEClass, WsRoleItem.class, "WsRoleItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsRoleItem_WsRole(), theMdmserverobjectPackage.getWsRoleE(), null, "wsRole", null, 0, 1, WsRoleItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(containerItemEClass, ContainerItem.class, "ContainerItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getContainerItem_Label(), theEcorePackage.getEString(), "label", null, 0, 1, ContainerItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getContainerItem_RepObjType(), this.getERepositoryObjectType(), "repObjType", null, 0, 1, ContainerItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getContainerItem_Data(), theEcorePackage.getEJavaObject(), "data", null, 0, 1, ContainerItem.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsDataModelItemEClass, WsDataModelItem.class, "WsDataModelItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsDataModelItem_WsDataModel(), theMdmserverobjectPackage.getWsDataModelE(), null, "wsDataModel", null, 0, 1, WsDataModelItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsDataClusterItemEClass, WsDataClusterItem.class, "WsDataClusterItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsDataClusterItem_WsDataCluster(), theMdmserverobjectPackage.getWsDataClusterE(), null, "wsDataCluster", null, 0, 1, WsDataClusterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsStoredProcedureItemEClass, WsStoredProcedureItem.class, "WsStoredProcedureItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsStoredProcedureItem_WsStoredProcedure(), theMdmserverobjectPackage.getWsStoredProcedureE(), null, "wsStoredProcedure", null, 0, 1, WsStoredProcedureItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsUniverseItemEClass, WsUniverseItem.class, "WsUniverseItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsUniverseItem_WsUniverse(), theMdmserverobjectPackage.getWsUniverseE(), null, "wsUniverse", null, 0, 1, WsUniverseItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsSynchronizationPlanItemEClass, WsSynchronizationPlanItem.class, "WsSynchronizationPlanItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsSynchronizationPlanItem_WsSynchronizationPlan(), theMdmserverobjectPackage.getWsSynchronizationPlanE(), null, "wsSynchronizationPlan", null, 0, 1, WsSynchronizationPlanItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsViewItemEClass, WsViewItem.class, "WsViewItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsViewItem_WsView(), theMdmserverobjectPackage.getWsViewE(), null, "wsView", null, 0, 1, WsViewItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsWorkflowDeployItemEClass, WsWorkflowDeployItem.class, "WsWorkflowDeployItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsWorkflowDeployItem_WsWorkflowDeploy(), theMdmserverobjectPackage.getWsWorkflowDeployE(), null, "wsWorkflowDeploy", null, 0, 1, WsWorkflowDeployItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsTransformerV2ItemEClass, WsTransformerV2Item.class, "WsTransformerV2Item", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsTransformerV2Item_WsTransformerV2(), theMdmserverobjectPackage.getWsTransformerV2E(), null, "wsTransformerV2", null, 0, 1, WsTransformerV2Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoutingRuleItemEClass, WsRoutingRuleItem.class, "WsRoutingRuleItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsRoutingRuleItem_WsRoutingRule(), theMdmserverobjectPackage.getWsRoutingRuleE(), null, "wsRoutingRule", null, 0, 1, WsRoutingRuleItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsJobModelItemEClass, WsJobModelItem.class, "WsJobModelItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsJobModelItem_WsJobModelItem(), theMdmserverobjectPackage.getWsJobModelE(), null, "wsJobModelItem", null, 0, 1, WsJobModelItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsEventManagerItemEClass, WsEventManagerItem.class, "WsEventManagerItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsEventManagerItem_WsEventManager(), theMdmserverobjectPackage.getWsEventManagerE(), null, "wsEventManager", null, 0, 1, WsEventManagerItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsServiceConfigurationItemEClass, WsServiceConfigurationItem.class, "WsServiceConfigurationItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsServiceConfigurationItem_WsServiceConfiguration(), theMdmserverobjectPackage.getWsServiceConfigurationE(), null, "wsServiceConfiguration", null, 0, 1, WsServiceConfigurationItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsWorkflowItemEClass, WsWorkflowItem.class, "WsWorkflowItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsWorkflowItem_WsWorkflow(), theMdmserverobjectPackage.getWsWorkflowE(), null, "wsWorkflow", null, 0, 1, WsWorkflowItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsResourceItemEClass, WsResourceItem.class, "WsResourceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsResourceItem_Resource(), theMdmserverobjectPackage.getWsResourceE(), null, "resource", null, 0, 1, WsResourceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsCustomFormItemEClass, WsCustomFormItem.class, "WsCustomFormItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsCustomFormItem_CustomForm(), theMdmserverobjectPackage.getWsCustomFormE(), null, "customForm", null, 0, 1, WsCustomFormItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(workspaceRootItemEClass, WorkspaceRootItem.class, "WorkspaceRootItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWorkspaceRootItem_Label(), ecorePackage.getEString(), "label", null, 0, 1, WorkspaceRootItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsMatchRuleItemEClass, WsMatchRuleItem.class, "WsMatchRuleItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsMatchRuleItem_MdmMatchRule(), theMdmserverobjectPackage.getWsMatchRuleE(), null, "mdmMatchRule", null, 0, 1, WsMatchRuleItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize data types
        initEDataType(eRepositoryObjectTypeEDataType, ERepositoryObjectType.class, "ERepositoryObjectType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //MdmpropertiesPackageImpl
