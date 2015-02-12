/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.talend.mdm.repository.model.mdmserverobject.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MdmserverobjectFactoryImpl extends EFactoryImpl implements MdmserverobjectFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MdmserverobjectFactory init() {
        try {
            MdmserverobjectFactory theMdmserverobjectFactory = (MdmserverobjectFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.talend.org/mdmserverobject"); 
            if (theMdmserverobjectFactory != null) {
                return theMdmserverobjectFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new MdmserverobjectFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmserverobjectFactoryImpl() {
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
            case MdmserverobjectPackage.MDM_SERVER_OBJECT: return createMDMServerObject();
            case MdmserverobjectPackage.WS_MENU_E: return createWsMenuE();
            case MdmserverobjectPackage.WS_MENU_ENTRY_E: return createWsMenuEntryE();
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E: return createWsMenuMenuEntriesDescriptionsE();
            case MdmserverobjectPackage.WS_ROLE_E: return createWsRoleE();
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E: return createWsRoleSpecificationE();
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E: return createWsRoleSpecificationInstanceE();
            case MdmserverobjectPackage.WS_VIEW_E: return createWsViewE();
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E: return createWsWhereConditionE();
            case MdmserverobjectPackage.WS_WHERE_OPERATOR_E: return createWsWhereOperatorE();
            case MdmserverobjectPackage.WS_STRING_PREDICATE_E: return createWsStringPredicateE();
            case MdmserverobjectPackage.WS_DATA_MODEL_E: return createWsDataModelE();
            case MdmserverobjectPackage.WS_DATA_CLUSTER_E: return createWsDataClusterE();
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E: return createWsStoredProcedureE();
            case MdmserverobjectPackage.WS_UNIVERSE_E: return createWsUniverseE();
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E: return createWsUniverseXtentisObjectsRevisionIDsE();
            case MdmserverobjectPackage.WS_UNIVERSE_ITEMS_REVISION_IDS_E: return createWsUniverseItemsRevisionIDsE();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_E: return createWsSynchronizationPlanE();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E: return createWsSynchronizationPlanItemsSynchronizationsE();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E: return createWsSynchronizationPlanXtentisObjectsSynchronizationsE();
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E: return createWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE();
            case MdmserverobjectPackage.WS_BOOLEAN_E: return createWsBooleanE();
            case MdmserverobjectPackage.WS_WORKFLOW_DEPLOY_E: return createWsWorkflowDeployE();
            case MdmserverobjectPackage.WS_TRANSFORMER_V2E: return createWsTransformerV2E();
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E: return createWsTransformerProcessStepE();
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E: return createWsTransformerVariablesMappingE();
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E: return createWsTypedContentE();
            case MdmserverobjectPackage.WS_BYTE_ARRAY_E: return createWsByteArrayE();
            case MdmserverobjectPackage.WS_ROUTING_RULE_E: return createWsRoutingRuleE();
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E: return createWsRoutingRuleExpressionE();
            case MdmserverobjectPackage.WS_ROUTING_RULE_OPERATOR_E: return createWsRoutingRuleOperatorE();
            case MdmserverobjectPackage.WS_JOB_MODEL_E: return createWsJobModelE();
            case MdmserverobjectPackage.WS_EVENT_MANAGER_E: return createWsEventManagerE();
            case MdmserverobjectPackage.WS_SERVICE_CONFIGURATION_E: return createWsServiceConfigurationE();
            case MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E: return createWsServicePutConfigurationE();
            case MdmserverobjectPackage.WS_WORKFLOW_E: return createWsWorkflowE();
            case MdmserverobjectPackage.WS_RESOURCE_E: return createWsResourceE();
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E: return createWsCustomFormE();
            case MdmserverobjectPackage.WS_MATCH_RULE_E: return createWsMatchRuleE();
            case MdmserverobjectPackage.WS_MATCH_RULE_PKE: return createWsMatchRulePKE();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MDMServerObject createMDMServerObject() {
        MDMServerObjectImpl mdmServerObject = new MDMServerObjectImpl();
        return mdmServerObject;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsMenuE createWsMenuE() {
        WsMenuEImpl wsMenuE = new WsMenuEImpl();
        return wsMenuE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsMenuEntryE createWsMenuEntryE() {
        WsMenuEntryEImpl wsMenuEntryE = new WsMenuEntryEImpl();
        return wsMenuEntryE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsMenuMenuEntriesDescriptionsE createWsMenuMenuEntriesDescriptionsE() {
        WsMenuMenuEntriesDescriptionsEImpl wsMenuMenuEntriesDescriptionsE = new WsMenuMenuEntriesDescriptionsEImpl();
        return wsMenuMenuEntriesDescriptionsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsRoleE createWsRoleE() {
        WsRoleEImpl wsRoleE = new WsRoleEImpl();
        return wsRoleE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsRoleSpecificationE createWsRoleSpecificationE() {
        WsRoleSpecificationEImpl wsRoleSpecificationE = new WsRoleSpecificationEImpl();
        return wsRoleSpecificationE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsRoleSpecificationInstanceE createWsRoleSpecificationInstanceE() {
        WsRoleSpecificationInstanceEImpl wsRoleSpecificationInstanceE = new WsRoleSpecificationInstanceEImpl();
        return wsRoleSpecificationInstanceE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsViewE createWsViewE() {
        WsViewEImpl wsViewE = new WsViewEImpl();
        return wsViewE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsWhereConditionE createWsWhereConditionE() {
        WsWhereConditionEImpl wsWhereConditionE = new WsWhereConditionEImpl();
        return wsWhereConditionE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsWhereOperatorE createWsWhereOperatorE() {
        WsWhereOperatorEImpl wsWhereOperatorE = new WsWhereOperatorEImpl();
        return wsWhereOperatorE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsStringPredicateE createWsStringPredicateE() {
        WsStringPredicateEImpl wsStringPredicateE = new WsStringPredicateEImpl();
        return wsStringPredicateE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsDataModelE createWsDataModelE() {
        WsDataModelEImpl wsDataModelE = new WsDataModelEImpl();
        return wsDataModelE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsDataClusterE createWsDataClusterE() {
        WsDataClusterEImpl wsDataClusterE = new WsDataClusterEImpl();
        return wsDataClusterE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsStoredProcedureE createWsStoredProcedureE() {
        WsStoredProcedureEImpl wsStoredProcedureE = new WsStoredProcedureEImpl();
        return wsStoredProcedureE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsUniverseE createWsUniverseE() {
        WsUniverseEImpl wsUniverseE = new WsUniverseEImpl();
        return wsUniverseE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsUniverseXtentisObjectsRevisionIDsE createWsUniverseXtentisObjectsRevisionIDsE() {
        WsUniverseXtentisObjectsRevisionIDsEImpl wsUniverseXtentisObjectsRevisionIDsE = new WsUniverseXtentisObjectsRevisionIDsEImpl();
        return wsUniverseXtentisObjectsRevisionIDsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsUniverseItemsRevisionIDsE createWsUniverseItemsRevisionIDsE() {
        WsUniverseItemsRevisionIDsEImpl wsUniverseItemsRevisionIDsE = new WsUniverseItemsRevisionIDsEImpl();
        return wsUniverseItemsRevisionIDsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsSynchronizationPlanE createWsSynchronizationPlanE() {
        WsSynchronizationPlanEImpl wsSynchronizationPlanE = new WsSynchronizationPlanEImpl();
        return wsSynchronizationPlanE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsSynchronizationPlanItemsSynchronizationsE createWsSynchronizationPlanItemsSynchronizationsE() {
        WsSynchronizationPlanItemsSynchronizationsEImpl wsSynchronizationPlanItemsSynchronizationsE = new WsSynchronizationPlanItemsSynchronizationsEImpl();
        return wsSynchronizationPlanItemsSynchronizationsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsSynchronizationPlanXtentisObjectsSynchronizationsE createWsSynchronizationPlanXtentisObjectsSynchronizationsE() {
        WsSynchronizationPlanXtentisObjectsSynchronizationsEImpl wsSynchronizationPlanXtentisObjectsSynchronizationsE = new WsSynchronizationPlanXtentisObjectsSynchronizationsEImpl();
        return wsSynchronizationPlanXtentisObjectsSynchronizationsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE createWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE() {
        WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE = new WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl();
        return wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsBooleanE createWsBooleanE() {
        WsBooleanEImpl wsBooleanE = new WsBooleanEImpl();
        return wsBooleanE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsWorkflowDeployE createWsWorkflowDeployE() {
        WsWorkflowDeployEImpl wsWorkflowDeployE = new WsWorkflowDeployEImpl();
        return wsWorkflowDeployE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsTransformerV2E createWsTransformerV2E() {
        WsTransformerV2EImpl wsTransformerV2E = new WsTransformerV2EImpl();
        return wsTransformerV2E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsTransformerProcessStepE createWsTransformerProcessStepE() {
        WsTransformerProcessStepEImpl wsTransformerProcessStepE = new WsTransformerProcessStepEImpl();
        return wsTransformerProcessStepE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsTransformerVariablesMappingE createWsTransformerVariablesMappingE() {
        WsTransformerVariablesMappingEImpl wsTransformerVariablesMappingE = new WsTransformerVariablesMappingEImpl();
        return wsTransformerVariablesMappingE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsTypedContentE createWsTypedContentE() {
        WsTypedContentEImpl wsTypedContentE = new WsTypedContentEImpl();
        return wsTypedContentE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsByteArrayE createWsByteArrayE() {
        WsByteArrayEImpl wsByteArrayE = new WsByteArrayEImpl();
        return wsByteArrayE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsRoutingRuleE createWsRoutingRuleE() {
        WsRoutingRuleEImpl wsRoutingRuleE = new WsRoutingRuleEImpl();
        return wsRoutingRuleE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsRoutingRuleExpressionE createWsRoutingRuleExpressionE() {
        WsRoutingRuleExpressionEImpl wsRoutingRuleExpressionE = new WsRoutingRuleExpressionEImpl();
        return wsRoutingRuleExpressionE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsRoutingRuleOperatorE createWsRoutingRuleOperatorE() {
        WsRoutingRuleOperatorEImpl wsRoutingRuleOperatorE = new WsRoutingRuleOperatorEImpl();
        return wsRoutingRuleOperatorE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsJobModelE createWsJobModelE() {
        WsJobModelEImpl wsJobModelE = new WsJobModelEImpl();
        return wsJobModelE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsEventManagerE createWsEventManagerE() {
        WsEventManagerEImpl wsEventManagerE = new WsEventManagerEImpl();
        return wsEventManagerE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsServiceConfigurationE createWsServiceConfigurationE() {
        WsServiceConfigurationEImpl wsServiceConfigurationE = new WsServiceConfigurationEImpl();
        return wsServiceConfigurationE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsServicePutConfigurationE createWsServicePutConfigurationE() {
        WsServicePutConfigurationEImpl wsServicePutConfigurationE = new WsServicePutConfigurationEImpl();
        return wsServicePutConfigurationE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsWorkflowE createWsWorkflowE() {
        WsWorkflowEImpl wsWorkflowE = new WsWorkflowEImpl();
        return wsWorkflowE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsResourceE createWsResourceE() {
        WsResourceEImpl wsResourceE = new WsResourceEImpl();
        return wsResourceE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsCustomFormE createWsCustomFormE() {
        WsCustomFormEImpl wsCustomFormE = new WsCustomFormEImpl();
        return wsCustomFormE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsMatchRuleE createWsMatchRuleE() {
        WsMatchRuleEImpl wsMatchRuleE = new WsMatchRuleEImpl();
        return wsMatchRuleE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WsMatchRulePKE createWsMatchRulePKE() {
        WsMatchRulePKEImpl wsMatchRulePKE = new WsMatchRulePKEImpl();
        return wsMatchRulePKE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmserverobjectPackage getMdmserverobjectPackage() {
        return (MdmserverobjectPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static MdmserverobjectPackage getPackage() {
        return MdmserverobjectPackage.eINSTANCE;
    }

} //MdmserverobjectFactoryImpl
