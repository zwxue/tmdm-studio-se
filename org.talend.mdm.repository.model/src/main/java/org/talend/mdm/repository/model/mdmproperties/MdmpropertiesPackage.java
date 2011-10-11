/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.talend.core.model.properties.PropertiesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory
 * @model kind="package"
 * @generated
 */
public interface MdmpropertiesPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "mdmproperties";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://www.talend.org/mdmproperties";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "mdmproperties";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	MdmpropertiesPackage eINSTANCE = org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl.init();

	/**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.MDMItemImpl <em>MDM Item</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MDMItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getMDMItem()
     * @generated
     */
	int MDM_ITEM = 0;

	/**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_ITEM__PROPERTY = PropertiesPackage.ITEM__PROPERTY;

	/**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_ITEM__STATE = PropertiesPackage.ITEM__STATE;

	/**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_ITEM__PARENT = PropertiesPackage.ITEM__PARENT;

	/**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_ITEM__REFERENCE_RESOURCES = PropertiesPackage.ITEM__REFERENCE_RESOURCES;

    /**
     * The number of structural features of the '<em>MDM Item</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_ITEM_FEATURE_COUNT = PropertiesPackage.ITEM_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.MDMServerDefItemImpl <em>MDM Server Def Item</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MDMServerDefItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getMDMServerDefItem()
     * @generated
     */
	int MDM_SERVER_DEF_ITEM = 1;

	/**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF_ITEM__PROPERTY = MDM_ITEM__PROPERTY;

	/**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF_ITEM__STATE = MDM_ITEM__STATE;

	/**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF_ITEM__PARENT = MDM_ITEM__PARENT;

	/**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_DEF_ITEM__REFERENCE_RESOURCES = MDM_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Server Def</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF_ITEM__SERVER_DEF = MDM_ITEM_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>MDM Server Def Item</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MDM_SERVER_DEF_ITEM_FEATURE_COUNT = MDM_ITEM_FEATURE_COUNT + 1;


	/**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.MDMServerObjectItemImpl <em>MDM Server Object Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MDMServerObjectItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getMDMServerObjectItem()
     * @generated
     */
    int MDM_SERVER_OBJECT_ITEM = 2;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT_ITEM__PROPERTY = MDM_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT_ITEM__STATE = MDM_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT_ITEM__PARENT = MDM_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES = MDM_ITEM__REFERENCE_RESOURCES;

    /**
     * The number of structural features of the '<em>MDM Server Object Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT = MDM_ITEM_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSMenuItemImpl <em>WS Menu Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSMenuItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSMenuItem()
     * @generated
     */
    int WS_MENU_ITEM = 3;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Menu</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ITEM__WS_MENU = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Menu Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSRoleItemImpl <em>WS Role Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSRoleItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSRoleItem()
     * @generated
     */
    int WS_ROLE_ITEM = 4;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Role</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_ITEM__WS_ROLE = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Role Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;


    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.ContainerItemImpl <em>Container Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.ContainerItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getContainerItem()
     * @generated
     */
    int CONTAINER_ITEM = 5;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM__PROPERTY = MDM_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM__STATE = MDM_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM__PARENT = MDM_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM__REFERENCE_RESOURCES = MDM_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Children</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM__CHILDREN = MDM_ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM__TYPE = MDM_ITEM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM__LABEL = MDM_ITEM_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Rep Obj Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM__REP_OBJ_TYPE = MDM_ITEM_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Container Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM_FEATURE_COUNT = MDM_ITEM_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSDataModelItemImpl <em>WS Data Model Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSDataModelItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSDataModelItem()
     * @generated
     */
    int WS_DATA_MODEL_ITEM = 6;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Data Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_ITEM__WS_DATA_MODEL = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Data Model Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSDataClusterItemImpl <em>WS Data Cluster Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSDataClusterItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSDataClusterItem()
     * @generated
     */
    int WS_DATA_CLUSTER_ITEM = 7;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Data Cluster</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Data Cluster Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSStoredProcedureItemImpl <em>WS Stored Procedure Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSStoredProcedureItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSStoredProcedureItem()
     * @generated
     */
    int WS_STORED_PROCEDURE_ITEM = 8;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Stored Procedure</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_ITEM__WS_STORED_PROCEDURE = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Stored Procedure Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSUniverseItemImpl <em>WS Universe Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSUniverseItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSUniverseItem()
     * @generated
     */
    int WS_UNIVERSE_ITEM = 9;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Universe</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEM__WS_UNIVERSE = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Universe Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSSynchronizationPlanItemImpl <em>WS Synchronization Plan Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSSynchronizationPlanItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSSynchronizationPlanItem()
     * @generated
     */
    int WS_SYNCHRONIZATION_PLAN_ITEM = 10;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Synchronization Plan</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEM__WS_SYNCHRONIZATION_PLAN = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Synchronization Plan Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSViewItemImpl <em>WS View Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSViewItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSViewItem()
     * @generated
     */
    int WS_VIEW_ITEM = 11;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws View</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_ITEM__WS_VIEW = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS View Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSWorkflowDeployItemImpl <em>WS Workflow Deploy Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSWorkflowDeployItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSWorkflowDeployItem()
     * @generated
     */
    int WS_WORKFLOW_DEPLOY_ITEM = 12;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Workflow Deploy</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Workflow Deploy Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSTransformerV2ItemImpl <em>WS Transformer V2 Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSTransformerV2ItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSTransformerV2Item()
     * @generated
     */
    int WS_TRANSFORMER_V2_ITEM = 13;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Transformer V2</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2_ITEM__WS_TRANSFORMER_V2 = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Transformer V2 Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSRoutingRuleItemImpl <em>WS Routing Rule Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSRoutingRuleItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSRoutingRuleItem()
     * @generated
     */
    int WS_ROUTING_RULE_ITEM = 14;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Routing Rule</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_ITEM__WS_ROUTING_RULE = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Routing Rule Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSJobModelItemImpl <em>WS Job Model Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSJobModelItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSJobModelItem()
     * @generated
     */
    int WS_JOB_MODEL_ITEM = 15;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Job Model Item</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Job Model Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSEventManagerItemImpl <em>WS Event Manager Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSEventManagerItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSEventManagerItem()
     * @generated
     */
    int WS_EVENT_MANAGER_ITEM = 16;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Event Manager</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Event Manager Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSServiceConfigurationItemImpl <em>WS Service Configuration Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSServiceConfigurationItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSServiceConfigurationItem()
     * @generated
     */
    int WS_SERVICE_CONFIGURATION_ITEM = 17;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Service Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_ITEM__WS_SERVICE_CONFIGURATION = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Service Configuration Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSWorkflowItemImpl <em>WS Workflow Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSWorkflowItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSWorkflowItem()
     * @generated
     */
    int WS_WORKFLOW_ITEM = 18;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Ws Workflow</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_ITEM__WS_WORKFLOW = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Workflow Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSResourceItemImpl <em>WS Resource Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSResourceItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSResourceItem()
     * @generated
     */
    int WS_RESOURCE_ITEM = 19;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Resource</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_ITEM__RESOURCE = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Resource Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSCustomFormItemImpl <em>WS Custom Form Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WSCustomFormItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSCustomFormItem()
     * @generated
     */
    int WS_CUSTOM_FORM_ITEM = 20;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>Custom Form</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_ITEM__CUSTOM_FORM = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Custom Form Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '<em>ERepository Object Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.core.model.repository.ERepositoryObjectType
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getERepositoryObjectType()
     * @generated
     */
    int EREPOSITORY_OBJECT_TYPE = 21;


    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.MDMItem <em>MDM Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>MDM Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.MDMItem
     * @generated
     */
	EClass getMDMItem();

	/**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem <em>MDM Server Def Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>MDM Server Def Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem
     * @generated
     */
	EClass getMDMServerDefItem();

	/**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem#getServerDef <em>Server Def</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Server Def</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem#getServerDef()
     * @see #getMDMServerDefItem()
     * @generated
     */
	EReference getMDMServerDefItem_ServerDef();

	/**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem <em>MDM Server Object Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>MDM Server Object Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem
     * @generated
     */
    EClass getMDMServerObjectItem();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSMenuItem <em>WS Menu Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Menu Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSMenuItem
     * @generated
     */
    EClass getWSMenuItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSMenuItem#getWsMenu <em>Ws Menu</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Menu</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSMenuItem#getWsMenu()
     * @see #getWSMenuItem()
     * @generated
     */
    EReference getWSMenuItem_WsMenu();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSRoleItem <em>WS Role Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Role Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSRoleItem
     * @generated
     */
    EClass getWSRoleItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSRoleItem#getWsRole <em>Ws Role</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Role</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSRoleItem#getWsRole()
     * @see #getWSRoleItem()
     * @generated
     */
    EReference getWSRoleItem_WsRole();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem <em>Container Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Container Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.ContainerItem
     * @generated
     */
    EClass getContainerItem();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.ContainerItem#getLabel()
     * @see #getContainerItem()
     * @generated
     */
    EAttribute getContainerItem_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getRepObjType <em>Rep Obj Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rep Obj Type</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.ContainerItem#getRepObjType()
     * @see #getContainerItem()
     * @generated
     */
    EAttribute getContainerItem_RepObjType();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSDataModelItem <em>WS Data Model Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Data Model Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSDataModelItem
     * @generated
     */
    EClass getWSDataModelItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSDataModelItem#getWsDataModel <em>Ws Data Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Data Model</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSDataModelItem#getWsDataModel()
     * @see #getWSDataModelItem()
     * @generated
     */
    EReference getWSDataModelItem_WsDataModel();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSDataClusterItem <em>WS Data Cluster Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Data Cluster Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSDataClusterItem
     * @generated
     */
    EClass getWSDataClusterItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSDataClusterItem#getWsDataCluster <em>Ws Data Cluster</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Data Cluster</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSDataClusterItem#getWsDataCluster()
     * @see #getWSDataClusterItem()
     * @generated
     */
    EReference getWSDataClusterItem_WsDataCluster();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSStoredProcedureItem <em>WS Stored Procedure Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Stored Procedure Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSStoredProcedureItem
     * @generated
     */
    EClass getWSStoredProcedureItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSStoredProcedureItem#getWsStoredProcedure <em>Ws Stored Procedure</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Stored Procedure</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSStoredProcedureItem#getWsStoredProcedure()
     * @see #getWSStoredProcedureItem()
     * @generated
     */
    EReference getWSStoredProcedureItem_WsStoredProcedure();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSUniverseItem <em>WS Universe Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Universe Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSUniverseItem
     * @generated
     */
    EClass getWSUniverseItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSUniverseItem#getWsUniverse <em>Ws Universe</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Universe</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSUniverseItem#getWsUniverse()
     * @see #getWSUniverseItem()
     * @generated
     */
    EReference getWSUniverseItem_WsUniverse();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSSynchronizationPlanItem <em>WS Synchronization Plan Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Synchronization Plan Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSSynchronizationPlanItem
     * @generated
     */
    EClass getWSSynchronizationPlanItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSSynchronizationPlanItem#getWsSynchronizationPlan <em>Ws Synchronization Plan</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Synchronization Plan</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSSynchronizationPlanItem#getWsSynchronizationPlan()
     * @see #getWSSynchronizationPlanItem()
     * @generated
     */
    EReference getWSSynchronizationPlanItem_WsSynchronizationPlan();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSViewItem <em>WS View Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS View Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSViewItem
     * @generated
     */
    EClass getWSViewItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSViewItem#getWsView <em>Ws View</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws View</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSViewItem#getWsView()
     * @see #getWSViewItem()
     * @generated
     */
    EReference getWSViewItem_WsView();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSWorkflowDeployItem <em>WS Workflow Deploy Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Workflow Deploy Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSWorkflowDeployItem
     * @generated
     */
    EClass getWSWorkflowDeployItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSWorkflowDeployItem#getWsWorkflowDeploy <em>Ws Workflow Deploy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Workflow Deploy</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSWorkflowDeployItem#getWsWorkflowDeploy()
     * @see #getWSWorkflowDeployItem()
     * @generated
     */
    EReference getWSWorkflowDeployItem_WsWorkflowDeploy();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item <em>WS Transformer V2 Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Transformer V2 Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item
     * @generated
     */
    EClass getWSTransformerV2Item();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item#getWsTransformerV2 <em>Ws Transformer V2</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Transformer V2</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item#getWsTransformerV2()
     * @see #getWSTransformerV2Item()
     * @generated
     */
    EReference getWSTransformerV2Item_WsTransformerV2();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSRoutingRuleItem <em>WS Routing Rule Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Routing Rule Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSRoutingRuleItem
     * @generated
     */
    EClass getWSRoutingRuleItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSRoutingRuleItem#getWsRoutingRule <em>Ws Routing Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Routing Rule</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSRoutingRuleItem#getWsRoutingRule()
     * @see #getWSRoutingRuleItem()
     * @generated
     */
    EReference getWSRoutingRuleItem_WsRoutingRule();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSJobModelItem <em>WS Job Model Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Job Model Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSJobModelItem
     * @generated
     */
    EClass getWSJobModelItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSJobModelItem#getWsJobModelItem <em>Ws Job Model Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Job Model Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSJobModelItem#getWsJobModelItem()
     * @see #getWSJobModelItem()
     * @generated
     */
    EReference getWSJobModelItem_WsJobModelItem();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSEventManagerItem <em>WS Event Manager Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Event Manager Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSEventManagerItem
     * @generated
     */
    EClass getWSEventManagerItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSEventManagerItem#getWsEventManager <em>Ws Event Manager</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Event Manager</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSEventManagerItem#getWsEventManager()
     * @see #getWSEventManagerItem()
     * @generated
     */
    EReference getWSEventManagerItem_WsEventManager();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSServiceConfigurationItem <em>WS Service Configuration Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Service Configuration Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSServiceConfigurationItem
     * @generated
     */
    EClass getWSServiceConfigurationItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSServiceConfigurationItem#getWsServiceConfiguration <em>Ws Service Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Service Configuration</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSServiceConfigurationItem#getWsServiceConfiguration()
     * @see #getWSServiceConfigurationItem()
     * @generated
     */
    EReference getWSServiceConfigurationItem_WsServiceConfiguration();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSWorkflowItem <em>WS Workflow Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Workflow Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSWorkflowItem
     * @generated
     */
    EClass getWSWorkflowItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSWorkflowItem#getWsWorkflow <em>Ws Workflow</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Workflow</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSWorkflowItem#getWsWorkflow()
     * @see #getWSWorkflowItem()
     * @generated
     */
    EReference getWSWorkflowItem_WsWorkflow();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSResourceItem <em>WS Resource Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Resource Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSResourceItem
     * @generated
     */
    EClass getWSResourceItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSResourceItem#getResource <em>Resource</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Resource</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSResourceItem#getResource()
     * @see #getWSResourceItem()
     * @generated
     */
    EReference getWSResourceItem_Resource();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WSCustomFormItem <em>WS Custom Form Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Custom Form Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSCustomFormItem
     * @generated
     */
    EClass getWSCustomFormItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WSCustomFormItem#getCustomForm <em>Custom Form</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Custom Form</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WSCustomFormItem#getCustomForm()
     * @see #getWSCustomFormItem()
     * @generated
     */
    EReference getWSCustomFormItem_CustomForm();

    /**
     * Returns the meta object for data type '{@link org.talend.core.model.repository.ERepositoryObjectType <em>ERepository Object Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>ERepository Object Type</em>'.
     * @see org.talend.core.model.repository.ERepositoryObjectType
     * @model instanceClass="org.talend.core.model.repository.ERepositoryObjectType"
     * @generated
     */
    EDataType getERepositoryObjectType();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	MdmpropertiesFactory getMdmpropertiesFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.MDMItemImpl <em>MDM Item</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MDMItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getMDMItem()
         * @generated
         */
		EClass MDM_ITEM = eINSTANCE.getMDMItem();

		/**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.MDMServerDefItemImpl <em>MDM Server Def Item</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MDMServerDefItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getMDMServerDefItem()
         * @generated
         */
		EClass MDM_SERVER_DEF_ITEM = eINSTANCE.getMDMServerDefItem();

		/**
         * The meta object literal for the '<em><b>Server Def</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MDM_SERVER_DEF_ITEM__SERVER_DEF = eINSTANCE.getMDMServerDefItem_ServerDef();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.MDMServerObjectItemImpl <em>MDM Server Object Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MDMServerObjectItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getMDMServerObjectItem()
         * @generated
         */
        EClass MDM_SERVER_OBJECT_ITEM = eINSTANCE.getMDMServerObjectItem();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSMenuItemImpl <em>WS Menu Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSMenuItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSMenuItem()
         * @generated
         */
        EClass WS_MENU_ITEM = eINSTANCE.getWSMenuItem();

        /**
         * The meta object literal for the '<em><b>Ws Menu</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_MENU_ITEM__WS_MENU = eINSTANCE.getWSMenuItem_WsMenu();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSRoleItemImpl <em>WS Role Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSRoleItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSRoleItem()
         * @generated
         */
        EClass WS_ROLE_ITEM = eINSTANCE.getWSRoleItem();

        /**
         * The meta object literal for the '<em><b>Ws Role</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_ROLE_ITEM__WS_ROLE = eINSTANCE.getWSRoleItem_WsRole();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.ContainerItemImpl <em>Container Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.ContainerItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getContainerItem()
         * @generated
         */
        EClass CONTAINER_ITEM = eINSTANCE.getContainerItem();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONTAINER_ITEM__LABEL = eINSTANCE.getContainerItem_Label();

        /**
         * The meta object literal for the '<em><b>Rep Obj Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONTAINER_ITEM__REP_OBJ_TYPE = eINSTANCE.getContainerItem_RepObjType();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSDataModelItemImpl <em>WS Data Model Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSDataModelItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSDataModelItem()
         * @generated
         */
        EClass WS_DATA_MODEL_ITEM = eINSTANCE.getWSDataModelItem();

        /**
         * The meta object literal for the '<em><b>Ws Data Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_DATA_MODEL_ITEM__WS_DATA_MODEL = eINSTANCE.getWSDataModelItem_WsDataModel();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSDataClusterItemImpl <em>WS Data Cluster Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSDataClusterItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSDataClusterItem()
         * @generated
         */
        EClass WS_DATA_CLUSTER_ITEM = eINSTANCE.getWSDataClusterItem();

        /**
         * The meta object literal for the '<em><b>Ws Data Cluster</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER = eINSTANCE.getWSDataClusterItem_WsDataCluster();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSStoredProcedureItemImpl <em>WS Stored Procedure Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSStoredProcedureItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSStoredProcedureItem()
         * @generated
         */
        EClass WS_STORED_PROCEDURE_ITEM = eINSTANCE.getWSStoredProcedureItem();

        /**
         * The meta object literal for the '<em><b>Ws Stored Procedure</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_STORED_PROCEDURE_ITEM__WS_STORED_PROCEDURE = eINSTANCE.getWSStoredProcedureItem_WsStoredProcedure();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSUniverseItemImpl <em>WS Universe Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSUniverseItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSUniverseItem()
         * @generated
         */
        EClass WS_UNIVERSE_ITEM = eINSTANCE.getWSUniverseItem();

        /**
         * The meta object literal for the '<em><b>Ws Universe</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_UNIVERSE_ITEM__WS_UNIVERSE = eINSTANCE.getWSUniverseItem_WsUniverse();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSSynchronizationPlanItemImpl <em>WS Synchronization Plan Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSSynchronizationPlanItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSSynchronizationPlanItem()
         * @generated
         */
        EClass WS_SYNCHRONIZATION_PLAN_ITEM = eINSTANCE.getWSSynchronizationPlanItem();

        /**
         * The meta object literal for the '<em><b>Ws Synchronization Plan</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_SYNCHRONIZATION_PLAN_ITEM__WS_SYNCHRONIZATION_PLAN = eINSTANCE.getWSSynchronizationPlanItem_WsSynchronizationPlan();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSViewItemImpl <em>WS View Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSViewItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSViewItem()
         * @generated
         */
        EClass WS_VIEW_ITEM = eINSTANCE.getWSViewItem();

        /**
         * The meta object literal for the '<em><b>Ws View</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_VIEW_ITEM__WS_VIEW = eINSTANCE.getWSViewItem_WsView();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSWorkflowDeployItemImpl <em>WS Workflow Deploy Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSWorkflowDeployItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSWorkflowDeployItem()
         * @generated
         */
        EClass WS_WORKFLOW_DEPLOY_ITEM = eINSTANCE.getWSWorkflowDeployItem();

        /**
         * The meta object literal for the '<em><b>Ws Workflow Deploy</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY = eINSTANCE.getWSWorkflowDeployItem_WsWorkflowDeploy();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSTransformerV2ItemImpl <em>WS Transformer V2 Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSTransformerV2ItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSTransformerV2Item()
         * @generated
         */
        EClass WS_TRANSFORMER_V2_ITEM = eINSTANCE.getWSTransformerV2Item();

        /**
         * The meta object literal for the '<em><b>Ws Transformer V2</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_TRANSFORMER_V2_ITEM__WS_TRANSFORMER_V2 = eINSTANCE.getWSTransformerV2Item_WsTransformerV2();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSRoutingRuleItemImpl <em>WS Routing Rule Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSRoutingRuleItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSRoutingRuleItem()
         * @generated
         */
        EClass WS_ROUTING_RULE_ITEM = eINSTANCE.getWSRoutingRuleItem();

        /**
         * The meta object literal for the '<em><b>Ws Routing Rule</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_ROUTING_RULE_ITEM__WS_ROUTING_RULE = eINSTANCE.getWSRoutingRuleItem_WsRoutingRule();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSJobModelItemImpl <em>WS Job Model Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSJobModelItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSJobModelItem()
         * @generated
         */
        EClass WS_JOB_MODEL_ITEM = eINSTANCE.getWSJobModelItem();

        /**
         * The meta object literal for the '<em><b>Ws Job Model Item</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM = eINSTANCE.getWSJobModelItem_WsJobModelItem();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSEventManagerItemImpl <em>WS Event Manager Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSEventManagerItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSEventManagerItem()
         * @generated
         */
        EClass WS_EVENT_MANAGER_ITEM = eINSTANCE.getWSEventManagerItem();

        /**
         * The meta object literal for the '<em><b>Ws Event Manager</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER = eINSTANCE.getWSEventManagerItem_WsEventManager();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSServiceConfigurationItemImpl <em>WS Service Configuration Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSServiceConfigurationItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSServiceConfigurationItem()
         * @generated
         */
        EClass WS_SERVICE_CONFIGURATION_ITEM = eINSTANCE.getWSServiceConfigurationItem();

        /**
         * The meta object literal for the '<em><b>Ws Service Configuration</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_SERVICE_CONFIGURATION_ITEM__WS_SERVICE_CONFIGURATION = eINSTANCE.getWSServiceConfigurationItem_WsServiceConfiguration();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSWorkflowItemImpl <em>WS Workflow Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSWorkflowItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSWorkflowItem()
         * @generated
         */
        EClass WS_WORKFLOW_ITEM = eINSTANCE.getWSWorkflowItem();

        /**
         * The meta object literal for the '<em><b>Ws Workflow</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_WORKFLOW_ITEM__WS_WORKFLOW = eINSTANCE.getWSWorkflowItem_WsWorkflow();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSResourceItemImpl <em>WS Resource Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSResourceItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSResourceItem()
         * @generated
         */
        EClass WS_RESOURCE_ITEM = eINSTANCE.getWSResourceItem();

        /**
         * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_RESOURCE_ITEM__RESOURCE = eINSTANCE.getWSResourceItem_Resource();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WSCustomFormItemImpl <em>WS Custom Form Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WSCustomFormItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWSCustomFormItem()
         * @generated
         */
        EClass WS_CUSTOM_FORM_ITEM = eINSTANCE.getWSCustomFormItem();

        /**
         * The meta object literal for the '<em><b>Custom Form</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_CUSTOM_FORM_ITEM__CUSTOM_FORM = eINSTANCE.getWSCustomFormItem_CustomForm();

        /**
         * The meta object literal for the '<em>ERepository Object Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.core.model.repository.ERepositoryObjectType
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getERepositoryObjectType()
         * @generated
         */
        EDataType EREPOSITORY_OBJECT_TYPE = eINSTANCE.getERepositoryObjectType();

	}

} //MdmpropertiesPackage
