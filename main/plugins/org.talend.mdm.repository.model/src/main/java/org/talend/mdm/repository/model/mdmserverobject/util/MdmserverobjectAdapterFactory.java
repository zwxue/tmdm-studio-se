/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.talend.mdm.repository.model.mdmserverobject.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage
 * @generated
 */
public class MdmserverobjectAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static MdmserverobjectPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmserverobjectAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = MdmserverobjectPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MdmserverobjectSwitch<Adapter> modelSwitch =
        new MdmserverobjectSwitch<Adapter>() {
            @Override
            public Adapter caseMDMServerObject(MDMServerObject object) {
                return createMDMServerObjectAdapter();
            }
            @Override
            public Adapter caseWsMenuE(WsMenuE object) {
                return createWsMenuEAdapter();
            }
            @Override
            public Adapter caseWsMenuEntryE(WsMenuEntryE object) {
                return createWsMenuEntryEAdapter();
            }
            @Override
            public Adapter caseWsMenuMenuEntriesDescriptionsE(WsMenuMenuEntriesDescriptionsE object) {
                return createWsMenuMenuEntriesDescriptionsEAdapter();
            }
            @Override
            public Adapter caseWsRoleE(WsRoleE object) {
                return createWsRoleEAdapter();
            }
            @Override
            public Adapter caseWsRoleSpecificationE(WsRoleSpecificationE object) {
                return createWsRoleSpecificationEAdapter();
            }
            @Override
            public Adapter caseWsRoleSpecificationInstanceE(WsRoleSpecificationInstanceE object) {
                return createWsRoleSpecificationInstanceEAdapter();
            }
            @Override
            public Adapter caseWsViewE(WsViewE object) {
                return createWsViewEAdapter();
            }
            @Override
            public Adapter caseWsWhereConditionE(WsWhereConditionE object) {
                return createWsWhereConditionEAdapter();
            }
            @Override
            public Adapter caseWsWhereOperatorE(WsWhereOperatorE object) {
                return createWsWhereOperatorEAdapter();
            }
            @Override
            public Adapter caseWsStringPredicateE(WsStringPredicateE object) {
                return createWsStringPredicateEAdapter();
            }
            @Override
            public Adapter caseWsDataModelE(WsDataModelE object) {
                return createWsDataModelEAdapter();
            }
            @Override
            public Adapter caseWsDataClusterE(WsDataClusterE object) {
                return createWsDataClusterEAdapter();
            }
            @Override
            public Adapter caseWsStoredProcedureE(WsStoredProcedureE object) {
                return createWsStoredProcedureEAdapter();
            }
            @Override
            public Adapter caseWsUniverseE(WsUniverseE object) {
                return createWsUniverseEAdapter();
            }
            @Override
            public Adapter caseWsUniverseXtentisObjectsRevisionIDsE(WsUniverseXtentisObjectsRevisionIDsE object) {
                return createWsUniverseXtentisObjectsRevisionIDsEAdapter();
            }
            @Override
            public Adapter caseWsUniverseItemsRevisionIDsE(WsUniverseItemsRevisionIDsE object) {
                return createWsUniverseItemsRevisionIDsEAdapter();
            }
            @Override
            public Adapter caseWsSynchronizationPlanE(WsSynchronizationPlanE object) {
                return createWsSynchronizationPlanEAdapter();
            }
            @Override
            public Adapter caseWsSynchronizationPlanItemsSynchronizationsE(WsSynchronizationPlanItemsSynchronizationsE object) {
                return createWsSynchronizationPlanItemsSynchronizationsEAdapter();
            }
            @Override
            public Adapter caseWsSynchronizationPlanXtentisObjectsSynchronizationsE(WsSynchronizationPlanXtentisObjectsSynchronizationsE object) {
                return createWsSynchronizationPlanXtentisObjectsSynchronizationsEAdapter();
            }
            @Override
            public Adapter caseWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE(WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE object) {
                return createWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEAdapter();
            }
            @Override
            public Adapter caseWsBooleanE(WsBooleanE object) {
                return createWsBooleanEAdapter();
            }
            @Override
            public Adapter caseWsWorkflowDeployE(WsWorkflowDeployE object) {
                return createWsWorkflowDeployEAdapter();
            }
            @Override
            public Adapter caseWsTransformerV2E(WsTransformerV2E object) {
                return createWsTransformerV2EAdapter();
            }
            @Override
            public Adapter caseWsTransformerProcessStepE(WsTransformerProcessStepE object) {
                return createWsTransformerProcessStepEAdapter();
            }
            @Override
            public Adapter caseWsTransformerVariablesMappingE(WsTransformerVariablesMappingE object) {
                return createWsTransformerVariablesMappingEAdapter();
            }
            @Override
            public Adapter caseWsTypedContentE(WsTypedContentE object) {
                return createWsTypedContentEAdapter();
            }
            @Override
            public Adapter caseWsByteArrayE(WsByteArrayE object) {
                return createWsByteArrayEAdapter();
            }
            @Override
            public Adapter caseWsRoutingRuleE(WsRoutingRuleE object) {
                return createWsRoutingRuleEAdapter();
            }
            @Override
            public Adapter caseWsRoutingRuleExpressionE(WsRoutingRuleExpressionE object) {
                return createWsRoutingRuleExpressionEAdapter();
            }
            @Override
            public Adapter caseWsRoutingRuleOperatorE(WsRoutingRuleOperatorE object) {
                return createWsRoutingRuleOperatorEAdapter();
            }
            @Override
            public Adapter caseWsJobModelE(WsJobModelE object) {
                return createWsJobModelEAdapter();
            }
            @Override
            public Adapter caseWsEventManagerE(WsEventManagerE object) {
                return createWsEventManagerEAdapter();
            }
            @Override
            public Adapter caseWsServiceConfigurationE(WsServiceConfigurationE object) {
                return createWsServiceConfigurationEAdapter();
            }
            @Override
            public Adapter caseWsServicePutConfigurationE(WsServicePutConfigurationE object) {
                return createWsServicePutConfigurationEAdapter();
            }
            @Override
            public Adapter caseWsWorkflowE(WsWorkflowE object) {
                return createWsWorkflowEAdapter();
            }
            @Override
            public Adapter caseWsResourceE(WsResourceE object) {
                return createWsResourceEAdapter();
            }
            @Override
            public Adapter caseWsCustomFormE(WsCustomFormE object) {
                return createWsCustomFormEAdapter();
            }
            @Override
            public Adapter caseWsMatchRuleE(WsMatchRuleE object) {
                return createWsMatchRuleEAdapter();
            }
            @Override
            public Adapter caseWsMatchRulePKE(WsMatchRulePKE object) {
                return createWsMatchRulePKEAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject <em>MDM Server Object</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.MDMServerObject
     * @generated
     */
    public Adapter createMDMServerObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuE <em>Ws Menu E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuE
     * @generated
     */
    public Adapter createWsMenuEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE <em>Ws Menu Entry E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE
     * @generated
     */
    public Adapter createWsMenuEntryEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuMenuEntriesDescriptionsE <em>Ws Menu Menu Entries Descriptions E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuMenuEntriesDescriptionsE
     * @generated
     */
    public Adapter createWsMenuMenuEntriesDescriptionsEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleE <em>Ws Role E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleE
     * @generated
     */
    public Adapter createWsRoleEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE <em>Ws Role Specification E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE
     * @generated
     */
    public Adapter createWsRoleSpecificationEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE <em>Ws Role Specification Instance E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE
     * @generated
     */
    public Adapter createWsRoleSpecificationInstanceEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE <em>Ws View E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsViewE
     * @generated
     */
    public Adapter createWsViewEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE <em>Ws Where Condition E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE
     * @generated
     */
    public Adapter createWsWhereConditionEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereOperatorE <em>Ws Where Operator E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWhereOperatorE
     * @generated
     */
    public Adapter createWsWhereOperatorEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsStringPredicateE <em>Ws String Predicate E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsStringPredicateE
     * @generated
     */
    public Adapter createWsStringPredicateEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsDataModelE <em>Ws Data Model E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsDataModelE
     * @generated
     */
    public Adapter createWsDataModelEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsDataClusterE <em>Ws Data Cluster E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsDataClusterE
     * @generated
     */
    public Adapter createWsDataClusterEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsStoredProcedureE <em>Ws Stored Procedure E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsStoredProcedureE
     * @generated
     */
    public Adapter createWsStoredProcedureEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseE <em>Ws Universe E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseE
     * @generated
     */
    public Adapter createWsUniverseEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseXtentisObjectsRevisionIDsE <em>Ws Universe Xtentis Objects Revision IDs E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseXtentisObjectsRevisionIDsE
     * @generated
     */
    public Adapter createWsUniverseXtentisObjectsRevisionIDsEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseItemsRevisionIDsE <em>Ws Universe Items Revision IDs E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseItemsRevisionIDsE
     * @generated
     */
    public Adapter createWsUniverseItemsRevisionIDsEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE <em>Ws Synchronization Plan E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE
     * @generated
     */
    public Adapter createWsSynchronizationPlanEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE <em>Ws Synchronization Plan Items Synchronizations E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE
     * @generated
     */
    public Adapter createWsSynchronizationPlanItemsSynchronizationsEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsE <em>Ws Synchronization Plan Xtentis Objects Synchronizations E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsE
     * @generated
     */
    public Adapter createWsSynchronizationPlanXtentisObjectsSynchronizationsEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE <em>Ws Synchronization Plan Xtentis Objects Synchronizations Synchronizations E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE
     * @generated
     */
    public Adapter createWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsBooleanE <em>Ws Boolean E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsBooleanE
     * @generated
     */
    public Adapter createWsBooleanEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsWorkflowDeployE <em>Ws Workflow Deploy E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWorkflowDeployE
     * @generated
     */
    public Adapter createWsWorkflowDeployEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerV2E <em>Ws Transformer V2E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerV2E
     * @generated
     */
    public Adapter createWsTransformerV2EAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE <em>Ws Transformer Process Step E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE
     * @generated
     */
    public Adapter createWsTransformerProcessStepEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE <em>Ws Transformer Variables Mapping E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE
     * @generated
     */
    public Adapter createWsTransformerVariablesMappingEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE <em>Ws Typed Content E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE
     * @generated
     */
    public Adapter createWsTypedContentEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsByteArrayE <em>Ws Byte Array E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsByteArrayE
     * @generated
     */
    public Adapter createWsByteArrayEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE <em>Ws Routing Rule E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE
     * @generated
     */
    public Adapter createWsRoutingRuleEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE <em>Ws Routing Rule Expression E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE
     * @generated
     */
    public Adapter createWsRoutingRuleExpressionEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleOperatorE <em>Ws Routing Rule Operator E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleOperatorE
     * @generated
     */
    public Adapter createWsRoutingRuleOperatorEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsJobModelE <em>Ws Job Model E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsJobModelE
     * @generated
     */
    public Adapter createWsJobModelEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsEventManagerE <em>Ws Event Manager E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsEventManagerE
     * @generated
     */
    public Adapter createWsEventManagerEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsServiceConfigurationE <em>Ws Service Configuration E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsServiceConfigurationE
     * @generated
     */
    public Adapter createWsServiceConfigurationEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE <em>Ws Service Put Configuration E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE
     * @generated
     */
    public Adapter createWsServicePutConfigurationEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsWorkflowE <em>Ws Workflow E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWorkflowE
     * @generated
     */
    public Adapter createWsWorkflowEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsResourceE <em>Ws Resource E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsResourceE
     * @generated
     */
    public Adapter createWsResourceEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE <em>Ws Custom Form E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE
     * @generated
     */
    public Adapter createWsCustomFormEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE <em>Ws Match Rule E</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE
     * @generated
     */
    public Adapter createWsMatchRuleEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.WsMatchRulePKE <em>Ws Match Rule PKE</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMatchRulePKE
     * @generated
     */
    public Adapter createWsMatchRulePKEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //MdmserverobjectAdapterFactory
