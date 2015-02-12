/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.talend.mdm.repository.model.mdmserverobject.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage
 * @generated
 */
public class MdmserverobjectSwitch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static MdmserverobjectPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmserverobjectSwitch() {
        if (modelPackage == null) {
            modelPackage = MdmserverobjectPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case MdmserverobjectPackage.MDM_SERVER_OBJECT: {
                MDMServerObject mdmServerObject = (MDMServerObject)theEObject;
                T result = caseMDMServerObject(mdmServerObject);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_MENU_E: {
                WsMenuE wsMenuE = (WsMenuE)theEObject;
                T result = caseWsMenuE(wsMenuE);
                if (result == null) result = caseMDMServerObject(wsMenuE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_MENU_ENTRY_E: {
                WsMenuEntryE wsMenuEntryE = (WsMenuEntryE)theEObject;
                T result = caseWsMenuEntryE(wsMenuEntryE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E: {
                WsMenuMenuEntriesDescriptionsE wsMenuMenuEntriesDescriptionsE = (WsMenuMenuEntriesDescriptionsE)theEObject;
                T result = caseWsMenuMenuEntriesDescriptionsE(wsMenuMenuEntriesDescriptionsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROLE_E: {
                WsRoleE wsRoleE = (WsRoleE)theEObject;
                T result = caseWsRoleE(wsRoleE);
                if (result == null) result = caseMDMServerObject(wsRoleE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E: {
                WsRoleSpecificationE wsRoleSpecificationE = (WsRoleSpecificationE)theEObject;
                T result = caseWsRoleSpecificationE(wsRoleSpecificationE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E: {
                WsRoleSpecificationInstanceE wsRoleSpecificationInstanceE = (WsRoleSpecificationInstanceE)theEObject;
                T result = caseWsRoleSpecificationInstanceE(wsRoleSpecificationInstanceE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_VIEW_E: {
                WsViewE wsViewE = (WsViewE)theEObject;
                T result = caseWsViewE(wsViewE);
                if (result == null) result = caseMDMServerObject(wsViewE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E: {
                WsWhereConditionE wsWhereConditionE = (WsWhereConditionE)theEObject;
                T result = caseWsWhereConditionE(wsWhereConditionE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_WHERE_OPERATOR_E: {
                WsWhereOperatorE wsWhereOperatorE = (WsWhereOperatorE)theEObject;
                T result = caseWsWhereOperatorE(wsWhereOperatorE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_STRING_PREDICATE_E: {
                WsStringPredicateE wsStringPredicateE = (WsStringPredicateE)theEObject;
                T result = caseWsStringPredicateE(wsStringPredicateE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_DATA_MODEL_E: {
                WsDataModelE wsDataModelE = (WsDataModelE)theEObject;
                T result = caseWsDataModelE(wsDataModelE);
                if (result == null) result = caseMDMServerObject(wsDataModelE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_DATA_CLUSTER_E: {
                WsDataClusterE wsDataClusterE = (WsDataClusterE)theEObject;
                T result = caseWsDataClusterE(wsDataClusterE);
                if (result == null) result = caseMDMServerObject(wsDataClusterE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E: {
                WsStoredProcedureE wsStoredProcedureE = (WsStoredProcedureE)theEObject;
                T result = caseWsStoredProcedureE(wsStoredProcedureE);
                if (result == null) result = caseMDMServerObject(wsStoredProcedureE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_UNIVERSE_E: {
                WsUniverseE wsUniverseE = (WsUniverseE)theEObject;
                T result = caseWsUniverseE(wsUniverseE);
                if (result == null) result = caseMDMServerObject(wsUniverseE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E: {
                WsUniverseXtentisObjectsRevisionIDsE wsUniverseXtentisObjectsRevisionIDsE = (WsUniverseXtentisObjectsRevisionIDsE)theEObject;
                T result = caseWsUniverseXtentisObjectsRevisionIDsE(wsUniverseXtentisObjectsRevisionIDsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_UNIVERSE_ITEMS_REVISION_IDS_E: {
                WsUniverseItemsRevisionIDsE wsUniverseItemsRevisionIDsE = (WsUniverseItemsRevisionIDsE)theEObject;
                T result = caseWsUniverseItemsRevisionIDsE(wsUniverseItemsRevisionIDsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_E: {
                WsSynchronizationPlanE wsSynchronizationPlanE = (WsSynchronizationPlanE)theEObject;
                T result = caseWsSynchronizationPlanE(wsSynchronizationPlanE);
                if (result == null) result = caseMDMServerObject(wsSynchronizationPlanE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E: {
                WsSynchronizationPlanItemsSynchronizationsE wsSynchronizationPlanItemsSynchronizationsE = (WsSynchronizationPlanItemsSynchronizationsE)theEObject;
                T result = caseWsSynchronizationPlanItemsSynchronizationsE(wsSynchronizationPlanItemsSynchronizationsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E: {
                WsSynchronizationPlanXtentisObjectsSynchronizationsE wsSynchronizationPlanXtentisObjectsSynchronizationsE = (WsSynchronizationPlanXtentisObjectsSynchronizationsE)theEObject;
                T result = caseWsSynchronizationPlanXtentisObjectsSynchronizationsE(wsSynchronizationPlanXtentisObjectsSynchronizationsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E: {
                WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE = (WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE)theEObject;
                T result = caseWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE(wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_BOOLEAN_E: {
                WsBooleanE wsBooleanE = (WsBooleanE)theEObject;
                T result = caseWsBooleanE(wsBooleanE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_WORKFLOW_DEPLOY_E: {
                WsWorkflowDeployE wsWorkflowDeployE = (WsWorkflowDeployE)theEObject;
                T result = caseWsWorkflowDeployE(wsWorkflowDeployE);
                if (result == null) result = caseMDMServerObject(wsWorkflowDeployE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_TRANSFORMER_V2E: {
                WsTransformerV2E wsTransformerV2E = (WsTransformerV2E)theEObject;
                T result = caseWsTransformerV2E(wsTransformerV2E);
                if (result == null) result = caseMDMServerObject(wsTransformerV2E);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E: {
                WsTransformerProcessStepE wsTransformerProcessStepE = (WsTransformerProcessStepE)theEObject;
                T result = caseWsTransformerProcessStepE(wsTransformerProcessStepE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E: {
                WsTransformerVariablesMappingE wsTransformerVariablesMappingE = (WsTransformerVariablesMappingE)theEObject;
                T result = caseWsTransformerVariablesMappingE(wsTransformerVariablesMappingE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E: {
                WsTypedContentE wsTypedContentE = (WsTypedContentE)theEObject;
                T result = caseWsTypedContentE(wsTypedContentE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_BYTE_ARRAY_E: {
                WsByteArrayE wsByteArrayE = (WsByteArrayE)theEObject;
                T result = caseWsByteArrayE(wsByteArrayE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROUTING_RULE_E: {
                WsRoutingRuleE wsRoutingRuleE = (WsRoutingRuleE)theEObject;
                T result = caseWsRoutingRuleE(wsRoutingRuleE);
                if (result == null) result = caseMDMServerObject(wsRoutingRuleE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E: {
                WsRoutingRuleExpressionE wsRoutingRuleExpressionE = (WsRoutingRuleExpressionE)theEObject;
                T result = caseWsRoutingRuleExpressionE(wsRoutingRuleExpressionE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROUTING_RULE_OPERATOR_E: {
                WsRoutingRuleOperatorE wsRoutingRuleOperatorE = (WsRoutingRuleOperatorE)theEObject;
                T result = caseWsRoutingRuleOperatorE(wsRoutingRuleOperatorE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_JOB_MODEL_E: {
                WsJobModelE wsJobModelE = (WsJobModelE)theEObject;
                T result = caseWsJobModelE(wsJobModelE);
                if (result == null) result = caseMDMServerObject(wsJobModelE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_EVENT_MANAGER_E: {
                WsEventManagerE wsEventManagerE = (WsEventManagerE)theEObject;
                T result = caseWsEventManagerE(wsEventManagerE);
                if (result == null) result = caseMDMServerObject(wsEventManagerE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_SERVICE_CONFIGURATION_E: {
                WsServiceConfigurationE wsServiceConfigurationE = (WsServiceConfigurationE)theEObject;
                T result = caseWsServiceConfigurationE(wsServiceConfigurationE);
                if (result == null) result = caseMDMServerObject(wsServiceConfigurationE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E: {
                WsServicePutConfigurationE wsServicePutConfigurationE = (WsServicePutConfigurationE)theEObject;
                T result = caseWsServicePutConfigurationE(wsServicePutConfigurationE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_WORKFLOW_E: {
                WsWorkflowE wsWorkflowE = (WsWorkflowE)theEObject;
                T result = caseWsWorkflowE(wsWorkflowE);
                if (result == null) result = caseMDMServerObject(wsWorkflowE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_RESOURCE_E: {
                WsResourceE wsResourceE = (WsResourceE)theEObject;
                T result = caseWsResourceE(wsResourceE);
                if (result == null) result = caseMDMServerObject(wsResourceE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E: {
                WsCustomFormE wsCustomFormE = (WsCustomFormE)theEObject;
                T result = caseWsCustomFormE(wsCustomFormE);
                if (result == null) result = caseMDMServerObject(wsCustomFormE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_MATCH_RULE_E: {
                WsMatchRuleE wsMatchRuleE = (WsMatchRuleE)theEObject;
                T result = caseWsMatchRuleE(wsMatchRuleE);
                if (result == null) result = caseMDMServerObject(wsMatchRuleE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_MATCH_RULE_PKE: {
                WsMatchRulePKE wsMatchRulePKE = (WsMatchRulePKE)theEObject;
                T result = caseWsMatchRulePKE(wsMatchRulePKE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>MDM Server Object</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MDM Server Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMDMServerObject(MDMServerObject object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Menu E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Menu E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsMenuE(WsMenuE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Menu Entry E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Menu Entry E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsMenuEntryE(WsMenuEntryE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Menu Menu Entries Descriptions E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Menu Menu Entries Descriptions E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsMenuMenuEntriesDescriptionsE(WsMenuMenuEntriesDescriptionsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Role E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Role E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsRoleE(WsRoleE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Role Specification E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Role Specification E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsRoleSpecificationE(WsRoleSpecificationE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Role Specification Instance E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Role Specification Instance E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsRoleSpecificationInstanceE(WsRoleSpecificationInstanceE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws View E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws View E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsViewE(WsViewE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Where Condition E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Where Condition E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsWhereConditionE(WsWhereConditionE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Where Operator E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Where Operator E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsWhereOperatorE(WsWhereOperatorE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws String Predicate E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws String Predicate E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsStringPredicateE(WsStringPredicateE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Data Model E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Data Model E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsDataModelE(WsDataModelE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Data Cluster E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Data Cluster E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsDataClusterE(WsDataClusterE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Stored Procedure E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Stored Procedure E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsStoredProcedureE(WsStoredProcedureE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Universe E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Universe E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsUniverseE(WsUniverseE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Universe Xtentis Objects Revision IDs E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Universe Xtentis Objects Revision IDs E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsUniverseXtentisObjectsRevisionIDsE(WsUniverseXtentisObjectsRevisionIDsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Universe Items Revision IDs E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Universe Items Revision IDs E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsUniverseItemsRevisionIDsE(WsUniverseItemsRevisionIDsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Synchronization Plan E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Synchronization Plan E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsSynchronizationPlanE(WsSynchronizationPlanE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Synchronization Plan Items Synchronizations E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Synchronization Plan Items Synchronizations E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsSynchronizationPlanItemsSynchronizationsE(WsSynchronizationPlanItemsSynchronizationsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Synchronization Plan Xtentis Objects Synchronizations E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Synchronization Plan Xtentis Objects Synchronizations E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsSynchronizationPlanXtentisObjectsSynchronizationsE(WsSynchronizationPlanXtentisObjectsSynchronizationsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Synchronization Plan Xtentis Objects Synchronizations Synchronizations E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Synchronization Plan Xtentis Objects Synchronizations Synchronizations E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE(WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Boolean E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Boolean E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsBooleanE(WsBooleanE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Workflow Deploy E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Workflow Deploy E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsWorkflowDeployE(WsWorkflowDeployE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Transformer V2E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Transformer V2E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsTransformerV2E(WsTransformerV2E object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Transformer Process Step E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Transformer Process Step E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsTransformerProcessStepE(WsTransformerProcessStepE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Transformer Variables Mapping E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Transformer Variables Mapping E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsTransformerVariablesMappingE(WsTransformerVariablesMappingE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Typed Content E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Typed Content E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsTypedContentE(WsTypedContentE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Byte Array E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Byte Array E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsByteArrayE(WsByteArrayE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Routing Rule E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Routing Rule E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsRoutingRuleE(WsRoutingRuleE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Routing Rule Expression E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Routing Rule Expression E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsRoutingRuleExpressionE(WsRoutingRuleExpressionE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Routing Rule Operator E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Routing Rule Operator E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsRoutingRuleOperatorE(WsRoutingRuleOperatorE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Job Model E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Job Model E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsJobModelE(WsJobModelE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Event Manager E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Event Manager E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsEventManagerE(WsEventManagerE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Service Configuration E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Service Configuration E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsServiceConfigurationE(WsServiceConfigurationE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Service Put Configuration E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Service Put Configuration E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsServicePutConfigurationE(WsServicePutConfigurationE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Workflow E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Workflow E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsWorkflowE(WsWorkflowE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Resource E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Resource E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsResourceE(WsResourceE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Custom Form E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Custom Form E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsCustomFormE(WsCustomFormE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Match Rule E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Match Rule E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsMatchRuleE(WsMatchRuleE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Match Rule PKE</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Match Rule PKE</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsMatchRulePKE(WsMatchRulePKE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
        return null;
    }

} //MdmserverobjectSwitch
