/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.talend.core.model.repository.ERepositoryObjectType;

import org.talend.mdm.repository.model.mdmproperties.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MdmpropertiesFactoryImpl extends EFactoryImpl implements MdmpropertiesFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MdmpropertiesFactory init() {
        try {
            MdmpropertiesFactory theMdmpropertiesFactory = (MdmpropertiesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.talend.org/mdmproperties"); 
            if (theMdmpropertiesFactory != null) {
                return theMdmpropertiesFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new MdmpropertiesFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmpropertiesFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case MdmpropertiesPackage.MDM_ITEM: return createMDMItem();
            case MdmpropertiesPackage.MDM_SERVER_DEF_ITEM: return createMDMServerDefItem();
            case MdmpropertiesPackage.MDM_SERVER_OBJECT_ITEM: return createMDMServerObjectItem();
            case MdmpropertiesPackage.WS_MENU_ITEM: return createWsMenuItem();
            case MdmpropertiesPackage.WS_ROLE_ITEM: return createWsRoleItem();
            case MdmpropertiesPackage.CONTAINER_ITEM: return createContainerItem();
            case MdmpropertiesPackage.WS_DATA_MODEL_ITEM: return createWsDataModelItem();
            case MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM: return createWsDataClusterItem();
            case MdmpropertiesPackage.WS_STORED_PROCEDURE_ITEM: return createWsStoredProcedureItem();
            case MdmpropertiesPackage.WS_UNIVERSE_ITEM: return createWsUniverseItem();
            case MdmpropertiesPackage.WS_SYNCHRONIZATION_PLAN_ITEM: return createWsSynchronizationPlanItem();
            case MdmpropertiesPackage.WS_VIEW_ITEM: return createWsViewItem();
            case MdmpropertiesPackage.WS_WORKFLOW_DEPLOY_ITEM: return createWsWorkflowDeployItem();
            case MdmpropertiesPackage.WS_TRANSFORMER_V2_ITEM: return createWsTransformerV2Item();
            case MdmpropertiesPackage.WS_ROUTING_RULE_ITEM: return createWsRoutingRuleItem();
            case MdmpropertiesPackage.WS_JOB_MODEL_ITEM: return createWsJobModelItem();
            case MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM: return createWsEventManagerItem();
            case MdmpropertiesPackage.WS_SERVICE_CONFIGURATION_ITEM: return createWsServiceConfigurationItem();
            case MdmpropertiesPackage.WS_WORKFLOW_ITEM: return createWsWorkflowItem();
            case MdmpropertiesPackage.WS_RESOURCE_ITEM: return createWsResourceItem();
            case MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM: return createWsCustomFormItem();
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM: return createWorkspaceRootItem();
            case MdmpropertiesPackage.WS_MATCH_RULE_ITEM: return createWsMatchRuleItem();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case MdmpropertiesPackage.EREPOSITORY_OBJECT_TYPE:
                return createERepositoryObjectTypeFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case MdmpropertiesPackage.EREPOSITORY_OBJECT_TYPE:
                return convertERepositoryObjectTypeToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MDMItem createMDMItem() {
        MDMItemImpl mdmItem = new MDMItemImpl();
        return mdmItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MDMServerDefItem createMDMServerDefItem() {
        MDMServerDefItemImpl mdmServerDefItem = new MDMServerDefItemImpl();
        return mdmServerDefItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MDMServerObjectItem createMDMServerObjectItem() {
        MDMServerObjectItemImpl mdmServerObjectItem = new MDMServerObjectItemImpl();
        return mdmServerObjectItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsMenuItem createWsMenuItem() {
        WsMenuItemImpl wsMenuItem = new WsMenuItemImpl();
        return wsMenuItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsRoleItem createWsRoleItem() {
        WsRoleItemImpl wsRoleItem = new WsRoleItemImpl();
        return wsRoleItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContainerItem createContainerItem() {
        ContainerItemImpl containerItem = new ContainerItemImpl();
        return containerItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsDataModelItem createWsDataModelItem() {
        WsDataModelItemImpl wsDataModelItem = new WsDataModelItemImpl();
        return wsDataModelItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsDataClusterItem createWsDataClusterItem() {
        WsDataClusterItemImpl wsDataClusterItem = new WsDataClusterItemImpl();
        return wsDataClusterItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsStoredProcedureItem createWsStoredProcedureItem() {
        WsStoredProcedureItemImpl wsStoredProcedureItem = new WsStoredProcedureItemImpl();
        return wsStoredProcedureItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsUniverseItem createWsUniverseItem() {
        WsUniverseItemImpl wsUniverseItem = new WsUniverseItemImpl();
        return wsUniverseItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsSynchronizationPlanItem createWsSynchronizationPlanItem() {
        WsSynchronizationPlanItemImpl wsSynchronizationPlanItem = new WsSynchronizationPlanItemImpl();
        return wsSynchronizationPlanItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsViewItem createWsViewItem() {
        WsViewItemImpl wsViewItem = new WsViewItemImpl();
        return wsViewItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsWorkflowDeployItem createWsWorkflowDeployItem() {
        WsWorkflowDeployItemImpl wsWorkflowDeployItem = new WsWorkflowDeployItemImpl();
        return wsWorkflowDeployItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsTransformerV2Item createWsTransformerV2Item() {
        WsTransformerV2ItemImpl wsTransformerV2Item = new WsTransformerV2ItemImpl();
        return wsTransformerV2Item;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsRoutingRuleItem createWsRoutingRuleItem() {
        WsRoutingRuleItemImpl wsRoutingRuleItem = new WsRoutingRuleItemImpl();
        return wsRoutingRuleItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsJobModelItem createWsJobModelItem() {
        WsJobModelItemImpl wsJobModelItem = new WsJobModelItemImpl();
        return wsJobModelItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsEventManagerItem createWsEventManagerItem() {
        WsEventManagerItemImpl wsEventManagerItem = new WsEventManagerItemImpl();
        return wsEventManagerItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsServiceConfigurationItem createWsServiceConfigurationItem() {
        WsServiceConfigurationItemImpl wsServiceConfigurationItem = new WsServiceConfigurationItemImpl();
        return wsServiceConfigurationItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsWorkflowItem createWsWorkflowItem() {
        WsWorkflowItemImpl wsWorkflowItem = new WsWorkflowItemImpl();
        return wsWorkflowItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsResourceItem createWsResourceItem() {
        WsResourceItemImpl wsResourceItem = new WsResourceItemImpl();
        return wsResourceItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsCustomFormItem createWsCustomFormItem() {
        WsCustomFormItemImpl wsCustomFormItem = new WsCustomFormItemImpl();
        return wsCustomFormItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WorkspaceRootItem createWorkspaceRootItem() {
        WorkspaceRootItemImpl workspaceRootItem = new WorkspaceRootItemImpl();
        return workspaceRootItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsMatchRuleItem createWsMatchRuleItem() {
        WsMatchRuleItemImpl wsMatchRuleItem = new WsMatchRuleItemImpl();
        return wsMatchRuleItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ERepositoryObjectType createERepositoryObjectTypeFromString(EDataType eDataType, String initialValue) {
        return (ERepositoryObjectType)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertERepositoryObjectTypeToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmpropertiesPackage getMdmpropertiesPackage() {
        return (MdmpropertiesPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static MdmpropertiesPackage getPackage() {
        return MdmpropertiesPackage.eINSTANCE;
    }

} //MdmpropertiesFactoryImpl
