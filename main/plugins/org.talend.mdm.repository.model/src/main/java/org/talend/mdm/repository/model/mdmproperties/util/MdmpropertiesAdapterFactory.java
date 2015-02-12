/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.talend.core.model.properties.FolderItem;
import org.talend.core.model.properties.Item;

import org.talend.mdm.repository.model.mdmproperties.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage
 * @generated
 */
public class MdmpropertiesAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static MdmpropertiesPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmpropertiesAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = MdmpropertiesPackage.eINSTANCE;
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
    protected MdmpropertiesSwitch<Adapter> modelSwitch =
        new MdmpropertiesSwitch<Adapter>() {
            @Override
            public Adapter caseMDMItem(MDMItem object) {
                return createMDMItemAdapter();
            }
            @Override
            public Adapter caseMDMServerDefItem(MDMServerDefItem object) {
                return createMDMServerDefItemAdapter();
            }
            @Override
            public Adapter caseMDMServerObjectItem(MDMServerObjectItem object) {
                return createMDMServerObjectItemAdapter();
            }
            @Override
            public Adapter caseWsMenuItem(WsMenuItem object) {
                return createWsMenuItemAdapter();
            }
            @Override
            public Adapter caseWsRoleItem(WsRoleItem object) {
                return createWsRoleItemAdapter();
            }
            @Override
            public Adapter caseContainerItem(ContainerItem object) {
                return createContainerItemAdapter();
            }
            @Override
            public Adapter caseWsDataModelItem(WsDataModelItem object) {
                return createWsDataModelItemAdapter();
            }
            @Override
            public Adapter caseWsDataClusterItem(WsDataClusterItem object) {
                return createWsDataClusterItemAdapter();
            }
            @Override
            public Adapter caseWsStoredProcedureItem(WsStoredProcedureItem object) {
                return createWsStoredProcedureItemAdapter();
            }
            @Override
            public Adapter caseWsUniverseItem(WsUniverseItem object) {
                return createWsUniverseItemAdapter();
            }
            @Override
            public Adapter caseWsSynchronizationPlanItem(WsSynchronizationPlanItem object) {
                return createWsSynchronizationPlanItemAdapter();
            }
            @Override
            public Adapter caseWsViewItem(WsViewItem object) {
                return createWsViewItemAdapter();
            }
            @Override
            public Adapter caseWsWorkflowDeployItem(WsWorkflowDeployItem object) {
                return createWsWorkflowDeployItemAdapter();
            }
            @Override
            public Adapter caseWsTransformerV2Item(WsTransformerV2Item object) {
                return createWsTransformerV2ItemAdapter();
            }
            @Override
            public Adapter caseWsRoutingRuleItem(WsRoutingRuleItem object) {
                return createWsRoutingRuleItemAdapter();
            }
            @Override
            public Adapter caseWsJobModelItem(WsJobModelItem object) {
                return createWsJobModelItemAdapter();
            }
            @Override
            public Adapter caseWsEventManagerItem(WsEventManagerItem object) {
                return createWsEventManagerItemAdapter();
            }
            @Override
            public Adapter caseWsServiceConfigurationItem(WsServiceConfigurationItem object) {
                return createWsServiceConfigurationItemAdapter();
            }
            @Override
            public Adapter caseWsWorkflowItem(WsWorkflowItem object) {
                return createWsWorkflowItemAdapter();
            }
            @Override
            public Adapter caseWsResourceItem(WsResourceItem object) {
                return createWsResourceItemAdapter();
            }
            @Override
            public Adapter caseWsCustomFormItem(WsCustomFormItem object) {
                return createWsCustomFormItemAdapter();
            }
            @Override
            public Adapter caseWorkspaceRootItem(WorkspaceRootItem object) {
                return createWorkspaceRootItemAdapter();
            }
            @Override
            public Adapter caseWsMatchRuleItem(WsMatchRuleItem object) {
                return createWsMatchRuleItemAdapter();
            }
            @Override
            public Adapter caseItem(Item object) {
                return createItemAdapter();
            }
            @Override
            public Adapter caseFolderItem(FolderItem object) {
                return createFolderItemAdapter();
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
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.MDMItem <em>MDM Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.MDMItem
     * @generated
     */
    public Adapter createMDMItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem <em>MDM Server Def Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem
     * @generated
     */
    public Adapter createMDMServerDefItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem <em>MDM Server Object Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem
     * @generated
     */
    public Adapter createMDMServerObjectItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsMenuItem <em>Ws Menu Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsMenuItem
     * @generated
     */
    public Adapter createWsMenuItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsRoleItem <em>Ws Role Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsRoleItem
     * @generated
     */
    public Adapter createWsRoleItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem <em>Container Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.ContainerItem
     * @generated
     */
    public Adapter createContainerItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsDataModelItem <em>Ws Data Model Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsDataModelItem
     * @generated
     */
    public Adapter createWsDataModelItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsDataClusterItem <em>Ws Data Cluster Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsDataClusterItem
     * @generated
     */
    public Adapter createWsDataClusterItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsStoredProcedureItem <em>Ws Stored Procedure Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsStoredProcedureItem
     * @generated
     */
    public Adapter createWsStoredProcedureItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsUniverseItem <em>Ws Universe Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsUniverseItem
     * @generated
     */
    public Adapter createWsUniverseItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsSynchronizationPlanItem <em>Ws Synchronization Plan Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsSynchronizationPlanItem
     * @generated
     */
    public Adapter createWsSynchronizationPlanItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsViewItem <em>Ws View Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsViewItem
     * @generated
     */
    public Adapter createWsViewItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsWorkflowDeployItem <em>Ws Workflow Deploy Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsWorkflowDeployItem
     * @generated
     */
    public Adapter createWsWorkflowDeployItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsTransformerV2Item <em>Ws Transformer V2 Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsTransformerV2Item
     * @generated
     */
    public Adapter createWsTransformerV2ItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsRoutingRuleItem <em>Ws Routing Rule Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsRoutingRuleItem
     * @generated
     */
    public Adapter createWsRoutingRuleItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsJobModelItem <em>Ws Job Model Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsJobModelItem
     * @generated
     */
    public Adapter createWsJobModelItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsEventManagerItem <em>Ws Event Manager Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsEventManagerItem
     * @generated
     */
    public Adapter createWsEventManagerItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsServiceConfigurationItem <em>Ws Service Configuration Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsServiceConfigurationItem
     * @generated
     */
    public Adapter createWsServiceConfigurationItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsWorkflowItem <em>Ws Workflow Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsWorkflowItem
     * @generated
     */
    public Adapter createWsWorkflowItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsResourceItem <em>Ws Resource Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsResourceItem
     * @generated
     */
    public Adapter createWsResourceItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsCustomFormItem <em>Ws Custom Form Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsCustomFormItem
     * @generated
     */
    public Adapter createWsCustomFormItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WorkspaceRootItem <em>Workspace Root Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WorkspaceRootItem
     * @generated
     */
    public Adapter createWorkspaceRootItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WsMatchRuleItem <em>Ws Match Rule Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WsMatchRuleItem
     * @generated
     */
    public Adapter createWsMatchRuleItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.Item
     * @generated
     */
    public Adapter createItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.FolderItem <em>Folder Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.FolderItem
     * @generated
     */
    public Adapter createFolderItemAdapter() {
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

} //MdmpropertiesAdapterFactory
