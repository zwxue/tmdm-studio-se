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
                WSMenuE wsMenuE = (WSMenuE)theEObject;
                T result = caseWSMenuE(wsMenuE);
                if (result == null) result = caseMDMServerObject(wsMenuE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_MENU_ENTRY_E: {
                WSMenuEntryE wsMenuEntryE = (WSMenuEntryE)theEObject;
                T result = caseWSMenuEntryE(wsMenuEntryE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E: {
                WSMenuMenuEntriesDescriptionsE wsMenuMenuEntriesDescriptionsE = (WSMenuMenuEntriesDescriptionsE)theEObject;
                T result = caseWSMenuMenuEntriesDescriptionsE(wsMenuMenuEntriesDescriptionsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROLE_E: {
                WSRoleE wsRoleE = (WSRoleE)theEObject;
                T result = caseWSRoleE(wsRoleE);
                if (result == null) result = caseMDMServerObject(wsRoleE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E: {
                WSRoleSpecificationE wsRoleSpecificationE = (WSRoleSpecificationE)theEObject;
                T result = caseWSRoleSpecificationE(wsRoleSpecificationE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E: {
                WSRoleSpecificationInstanceE wsRoleSpecificationInstanceE = (WSRoleSpecificationInstanceE)theEObject;
                T result = caseWSRoleSpecificationInstanceE(wsRoleSpecificationInstanceE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_VIEW_E: {
                WSViewE wsViewE = (WSViewE)theEObject;
                T result = caseWSViewE(wsViewE);
                if (result == null) result = caseMDMServerObject(wsViewE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E: {
                WSWhereConditionE wsWhereConditionE = (WSWhereConditionE)theEObject;
                T result = caseWSWhereConditionE(wsWhereConditionE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_WHERE_OPERATOR_E: {
                WSWhereOperatorE wsWhereOperatorE = (WSWhereOperatorE)theEObject;
                T result = caseWSWhereOperatorE(wsWhereOperatorE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_STRING_PREDICATE_E: {
                WSStringPredicateE wsStringPredicateE = (WSStringPredicateE)theEObject;
                T result = caseWSStringPredicateE(wsStringPredicateE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_DATA_MODEL_E: {
                WSDataModelE wsDataModelE = (WSDataModelE)theEObject;
                T result = caseWSDataModelE(wsDataModelE);
                if (result == null) result = caseMDMServerObject(wsDataModelE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_DATA_CLUSTER_E: {
                WSDataClusterE wsDataClusterE = (WSDataClusterE)theEObject;
                T result = caseWSDataClusterE(wsDataClusterE);
                if (result == null) result = caseMDMServerObject(wsDataClusterE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E: {
                WSStoredProcedureE wsStoredProcedureE = (WSStoredProcedureE)theEObject;
                T result = caseWSStoredProcedureE(wsStoredProcedureE);
                if (result == null) result = caseMDMServerObject(wsStoredProcedureE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_UNIVERSE_E: {
                WSUniverseE wsUniverseE = (WSUniverseE)theEObject;
                T result = caseWSUniverseE(wsUniverseE);
                if (result == null) result = caseMDMServerObject(wsUniverseE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E: {
                WSUniverseXtentisObjectsRevisionIDsE wsUniverseXtentisObjectsRevisionIDsE = (WSUniverseXtentisObjectsRevisionIDsE)theEObject;
                T result = caseWSUniverseXtentisObjectsRevisionIDsE(wsUniverseXtentisObjectsRevisionIDsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_UNIVERSE_ITEMS_REVISION_IDS_E: {
                WSUniverseItemsRevisionIDsE wsUniverseItemsRevisionIDsE = (WSUniverseItemsRevisionIDsE)theEObject;
                T result = caseWSUniverseItemsRevisionIDsE(wsUniverseItemsRevisionIDsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_E: {
                WSSynchronizationPlanE wsSynchronizationPlanE = (WSSynchronizationPlanE)theEObject;
                T result = caseWSSynchronizationPlanE(wsSynchronizationPlanE);
                if (result == null) result = caseMDMServerObject(wsSynchronizationPlanE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E: {
                WSSynchronizationPlanItemsSynchronizationsE wsSynchronizationPlanItemsSynchronizationsE = (WSSynchronizationPlanItemsSynchronizationsE)theEObject;
                T result = caseWSSynchronizationPlanItemsSynchronizationsE(wsSynchronizationPlanItemsSynchronizationsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E: {
                WSSynchronizationPlanXtentisObjectsSynchronizationsE wsSynchronizationPlanXtentisObjectsSynchronizationsE = (WSSynchronizationPlanXtentisObjectsSynchronizationsE)theEObject;
                T result = caseWSSynchronizationPlanXtentisObjectsSynchronizationsE(wsSynchronizationPlanXtentisObjectsSynchronizationsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E: {
                WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE = (WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE)theEObject;
                T result = caseWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE(wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_BOOLEAN_E: {
                WSBooleanE wsBooleanE = (WSBooleanE)theEObject;
                T result = caseWSBooleanE(wsBooleanE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_WORKFLOW_DEPLOY_E: {
                WSWorkflowDeployE wsWorkflowDeployE = (WSWorkflowDeployE)theEObject;
                T result = caseWSWorkflowDeployE(wsWorkflowDeployE);
                if (result == null) result = caseMDMServerObject(wsWorkflowDeployE);
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
     * Returns the result of interpreting the object as an instance of '<em>WS Menu E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Menu E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSMenuE(WSMenuE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Menu Entry E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Menu Entry E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSMenuEntryE(WSMenuEntryE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Menu Menu Entries Descriptions E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Menu Menu Entries Descriptions E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSMenuMenuEntriesDescriptionsE(WSMenuMenuEntriesDescriptionsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Role E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Role E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSRoleE(WSRoleE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Role Specification E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Role Specification E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSRoleSpecificationE(WSRoleSpecificationE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Role Specification Instance E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Role Specification Instance E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSRoleSpecificationInstanceE(WSRoleSpecificationInstanceE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS View E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS View E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSViewE(WSViewE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Where Condition E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Where Condition E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSWhereConditionE(WSWhereConditionE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Where Operator E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Where Operator E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSWhereOperatorE(WSWhereOperatorE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS String Predicate E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS String Predicate E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSStringPredicateE(WSStringPredicateE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Data Model E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Data Model E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSDataModelE(WSDataModelE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Data Cluster E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Data Cluster E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSDataClusterE(WSDataClusterE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Stored Procedure E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Stored Procedure E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSStoredProcedureE(WSStoredProcedureE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Universe E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Universe E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSUniverseE(WSUniverseE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Universe Xtentis Objects Revision IDs E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Universe Xtentis Objects Revision IDs E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSUniverseXtentisObjectsRevisionIDsE(WSUniverseXtentisObjectsRevisionIDsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Universe Items Revision IDs E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Universe Items Revision IDs E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSUniverseItemsRevisionIDsE(WSUniverseItemsRevisionIDsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Synchronization Plan E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Synchronization Plan E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSSynchronizationPlanE(WSSynchronizationPlanE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Synchronization Plan Items Synchronizations E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Synchronization Plan Items Synchronizations E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSSynchronizationPlanItemsSynchronizationsE(WSSynchronizationPlanItemsSynchronizationsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Synchronization Plan Xtentis Objects Synchronizations E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Synchronization Plan Xtentis Objects Synchronizations E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSSynchronizationPlanXtentisObjectsSynchronizationsE(WSSynchronizationPlanXtentisObjectsSynchronizationsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Synchronization Plan Xtentis Objects Synchronizations Synchronizations E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Synchronization Plan Xtentis Objects Synchronizations Synchronizations E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE(WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Boolean E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Boolean E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSBooleanE(WSBooleanE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Workflow Deploy E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Workflow Deploy E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSWorkflowDeployE(WSWorkflowDeployE object) {
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
