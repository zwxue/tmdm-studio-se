/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.talend.core.model.properties.FolderItem;
import org.talend.core.model.properties.Item;

import org.talend.mdm.repository.model.mdmproperties.*;

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
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage
 * @generated
 */
public class MdmpropertiesSwitch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static MdmpropertiesPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmpropertiesSwitch() {
        if (modelPackage == null) {
            modelPackage = MdmpropertiesPackage.eINSTANCE;
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
            case MdmpropertiesPackage.MDM_ITEM: {
                MDMItem mdmItem = (MDMItem)theEObject;
                T result = caseMDMItem(mdmItem);
                if (result == null) result = caseItem(mdmItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.MDM_SERVER_DEF_ITEM: {
                MDMServerDefItem mdmServerDefItem = (MDMServerDefItem)theEObject;
                T result = caseMDMServerDefItem(mdmServerDefItem);
                if (result == null) result = caseMDMItem(mdmServerDefItem);
                if (result == null) result = caseItem(mdmServerDefItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.MDM_SERVER_OBJECT_ITEM: {
                MDMServerObjectItem mdmServerObjectItem = (MDMServerObjectItem)theEObject;
                T result = caseMDMServerObjectItem(mdmServerObjectItem);
                if (result == null) result = caseMDMItem(mdmServerObjectItem);
                if (result == null) result = caseItem(mdmServerObjectItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_MENU_ITEM: {
                WsMenuItem wsMenuItem = (WsMenuItem)theEObject;
                T result = caseWsMenuItem(wsMenuItem);
                if (result == null) result = caseMDMServerObjectItem(wsMenuItem);
                if (result == null) result = caseMDMItem(wsMenuItem);
                if (result == null) result = caseItem(wsMenuItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_ROLE_ITEM: {
                WsRoleItem wsRoleItem = (WsRoleItem)theEObject;
                T result = caseWsRoleItem(wsRoleItem);
                if (result == null) result = caseMDMServerObjectItem(wsRoleItem);
                if (result == null) result = caseMDMItem(wsRoleItem);
                if (result == null) result = caseItem(wsRoleItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.CONTAINER_ITEM: {
                ContainerItem containerItem = (ContainerItem)theEObject;
                T result = caseContainerItem(containerItem);
                if (result == null) result = caseMDMItem(containerItem);
                if (result == null) result = caseFolderItem(containerItem);
                if (result == null) result = caseItem(containerItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_DATA_MODEL_ITEM: {
                WsDataModelItem wsDataModelItem = (WsDataModelItem)theEObject;
                T result = caseWsDataModelItem(wsDataModelItem);
                if (result == null) result = caseMDMServerObjectItem(wsDataModelItem);
                if (result == null) result = caseMDMItem(wsDataModelItem);
                if (result == null) result = caseItem(wsDataModelItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_DATA_CLUSTER_ITEM: {
                WsDataClusterItem wsDataClusterItem = (WsDataClusterItem)theEObject;
                T result = caseWsDataClusterItem(wsDataClusterItem);
                if (result == null) result = caseMDMServerObjectItem(wsDataClusterItem);
                if (result == null) result = caseMDMItem(wsDataClusterItem);
                if (result == null) result = caseItem(wsDataClusterItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_STORED_PROCEDURE_ITEM: {
                WsStoredProcedureItem wsStoredProcedureItem = (WsStoredProcedureItem)theEObject;
                T result = caseWsStoredProcedureItem(wsStoredProcedureItem);
                if (result == null) result = caseMDMServerObjectItem(wsStoredProcedureItem);
                if (result == null) result = caseMDMItem(wsStoredProcedureItem);
                if (result == null) result = caseItem(wsStoredProcedureItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_UNIVERSE_ITEM: {
                WsUniverseItem wsUniverseItem = (WsUniverseItem)theEObject;
                T result = caseWsUniverseItem(wsUniverseItem);
                if (result == null) result = caseMDMServerObjectItem(wsUniverseItem);
                if (result == null) result = caseMDMItem(wsUniverseItem);
                if (result == null) result = caseItem(wsUniverseItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_SYNCHRONIZATION_PLAN_ITEM: {
                WsSynchronizationPlanItem wsSynchronizationPlanItem = (WsSynchronizationPlanItem)theEObject;
                T result = caseWsSynchronizationPlanItem(wsSynchronizationPlanItem);
                if (result == null) result = caseMDMServerObjectItem(wsSynchronizationPlanItem);
                if (result == null) result = caseMDMItem(wsSynchronizationPlanItem);
                if (result == null) result = caseItem(wsSynchronizationPlanItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_VIEW_ITEM: {
                WsViewItem wsViewItem = (WsViewItem)theEObject;
                T result = caseWsViewItem(wsViewItem);
                if (result == null) result = caseMDMServerObjectItem(wsViewItem);
                if (result == null) result = caseMDMItem(wsViewItem);
                if (result == null) result = caseItem(wsViewItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_WORKFLOW_DEPLOY_ITEM: {
                WsWorkflowDeployItem wsWorkflowDeployItem = (WsWorkflowDeployItem)theEObject;
                T result = caseWsWorkflowDeployItem(wsWorkflowDeployItem);
                if (result == null) result = caseMDMServerObjectItem(wsWorkflowDeployItem);
                if (result == null) result = caseMDMItem(wsWorkflowDeployItem);
                if (result == null) result = caseItem(wsWorkflowDeployItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_TRANSFORMER_V2_ITEM: {
                WsTransformerV2Item wsTransformerV2Item = (WsTransformerV2Item)theEObject;
                T result = caseWsTransformerV2Item(wsTransformerV2Item);
                if (result == null) result = caseMDMServerObjectItem(wsTransformerV2Item);
                if (result == null) result = caseMDMItem(wsTransformerV2Item);
                if (result == null) result = caseItem(wsTransformerV2Item);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_ROUTING_RULE_ITEM: {
                WsRoutingRuleItem wsRoutingRuleItem = (WsRoutingRuleItem)theEObject;
                T result = caseWsRoutingRuleItem(wsRoutingRuleItem);
                if (result == null) result = caseMDMServerObjectItem(wsRoutingRuleItem);
                if (result == null) result = caseMDMItem(wsRoutingRuleItem);
                if (result == null) result = caseItem(wsRoutingRuleItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_JOB_MODEL_ITEM: {
                WsJobModelItem wsJobModelItem = (WsJobModelItem)theEObject;
                T result = caseWsJobModelItem(wsJobModelItem);
                if (result == null) result = caseMDMServerObjectItem(wsJobModelItem);
                if (result == null) result = caseMDMItem(wsJobModelItem);
                if (result == null) result = caseItem(wsJobModelItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM: {
                WsEventManagerItem wsEventManagerItem = (WsEventManagerItem)theEObject;
                T result = caseWsEventManagerItem(wsEventManagerItem);
                if (result == null) result = caseMDMServerObjectItem(wsEventManagerItem);
                if (result == null) result = caseMDMItem(wsEventManagerItem);
                if (result == null) result = caseItem(wsEventManagerItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_SERVICE_CONFIGURATION_ITEM: {
                WsServiceConfigurationItem wsServiceConfigurationItem = (WsServiceConfigurationItem)theEObject;
                T result = caseWsServiceConfigurationItem(wsServiceConfigurationItem);
                if (result == null) result = caseMDMServerObjectItem(wsServiceConfigurationItem);
                if (result == null) result = caseMDMItem(wsServiceConfigurationItem);
                if (result == null) result = caseItem(wsServiceConfigurationItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_WORKFLOW_ITEM: {
                WsWorkflowItem wsWorkflowItem = (WsWorkflowItem)theEObject;
                T result = caseWsWorkflowItem(wsWorkflowItem);
                if (result == null) result = caseMDMServerObjectItem(wsWorkflowItem);
                if (result == null) result = caseMDMItem(wsWorkflowItem);
                if (result == null) result = caseItem(wsWorkflowItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_RESOURCE_ITEM: {
                WsResourceItem wsResourceItem = (WsResourceItem)theEObject;
                T result = caseWsResourceItem(wsResourceItem);
                if (result == null) result = caseMDMServerObjectItem(wsResourceItem);
                if (result == null) result = caseMDMItem(wsResourceItem);
                if (result == null) result = caseItem(wsResourceItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM: {
                WsCustomFormItem wsCustomFormItem = (WsCustomFormItem)theEObject;
                T result = caseWsCustomFormItem(wsCustomFormItem);
                if (result == null) result = caseMDMServerObjectItem(wsCustomFormItem);
                if (result == null) result = caseMDMItem(wsCustomFormItem);
                if (result == null) result = caseItem(wsCustomFormItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM: {
                WorkspaceRootItem workspaceRootItem = (WorkspaceRootItem)theEObject;
                T result = caseWorkspaceRootItem(workspaceRootItem);
                if (result == null) result = caseMDMItem(workspaceRootItem);
                if (result == null) result = caseFolderItem(workspaceRootItem);
                if (result == null) result = caseItem(workspaceRootItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmpropertiesPackage.WS_MATCH_RULE_ITEM: {
                WsMatchRuleItem wsMatchRuleItem = (WsMatchRuleItem)theEObject;
                T result = caseWsMatchRuleItem(wsMatchRuleItem);
                if (result == null) result = caseMDMServerObjectItem(wsMatchRuleItem);
                if (result == null) result = caseMDMItem(wsMatchRuleItem);
                if (result == null) result = caseItem(wsMatchRuleItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>MDM Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MDM Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMDMItem(MDMItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>MDM Server Def Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MDM Server Def Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMDMServerDefItem(MDMServerDefItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>MDM Server Object Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MDM Server Object Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMDMServerObjectItem(MDMServerObjectItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Menu Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Menu Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsMenuItem(WsMenuItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Role Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Role Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsRoleItem(WsRoleItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Container Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Container Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseContainerItem(ContainerItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Data Model Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Data Model Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsDataModelItem(WsDataModelItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Data Cluster Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Data Cluster Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsDataClusterItem(WsDataClusterItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Stored Procedure Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Stored Procedure Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsStoredProcedureItem(WsStoredProcedureItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Universe Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Universe Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsUniverseItem(WsUniverseItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Synchronization Plan Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Synchronization Plan Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsSynchronizationPlanItem(WsSynchronizationPlanItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws View Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws View Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsViewItem(WsViewItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Workflow Deploy Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Workflow Deploy Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsWorkflowDeployItem(WsWorkflowDeployItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Transformer V2 Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Transformer V2 Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsTransformerV2Item(WsTransformerV2Item object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Routing Rule Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Routing Rule Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsRoutingRuleItem(WsRoutingRuleItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Job Model Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Job Model Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsJobModelItem(WsJobModelItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Event Manager Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Event Manager Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsEventManagerItem(WsEventManagerItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Service Configuration Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Service Configuration Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsServiceConfigurationItem(WsServiceConfigurationItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Workflow Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Workflow Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsWorkflowItem(WsWorkflowItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Resource Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Resource Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsResourceItem(WsResourceItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Custom Form Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Custom Form Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsCustomFormItem(WsCustomFormItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Workspace Root Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Workspace Root Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWorkspaceRootItem(WorkspaceRootItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ws Match Rule Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ws Match Rule Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWsMatchRuleItem(WsMatchRuleItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItem(Item object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Folder Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Folder Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFolderItem(FolderItem object) {
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

} //MdmpropertiesSwitch
