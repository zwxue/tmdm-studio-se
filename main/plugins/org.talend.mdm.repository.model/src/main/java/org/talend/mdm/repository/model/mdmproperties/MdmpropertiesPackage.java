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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_ITEM__FILE_EXTENSION = PropertiesPackage.ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_ITEM__NEED_VERSION = PropertiesPackage.ITEM__NEED_VERSION;

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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_DEF_ITEM__FILE_EXTENSION = MDM_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_DEF_ITEM__NEED_VERSION = MDM_ITEM__NEED_VERSION;

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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION = MDM_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT_ITEM__NEED_VERSION = MDM_ITEM__NEED_VERSION;

    /**
     * The number of structural features of the '<em>MDM Server Object Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT = MDM_ITEM_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsMenuItemImpl <em>Ws Menu Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsMenuItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsMenuItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Menu</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ITEM__WS_MENU = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Menu Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsRoleItemImpl <em>Ws Role Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsRoleItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsRoleItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Role</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_ITEM__WS_ROLE = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Role Item</em>' class.
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM__FILE_EXTENSION = MDM_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM__NEED_VERSION = MDM_ITEM__NEED_VERSION;

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
     * The feature id for the '<em><b>Data</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM__DATA = MDM_ITEM_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Container Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_ITEM_FEATURE_COUNT = MDM_ITEM_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsDataModelItemImpl <em>Ws Data Model Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsDataModelItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsDataModelItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Data Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_ITEM__WS_DATA_MODEL = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Data Model Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsDataClusterItemImpl <em>Ws Data Cluster Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsDataClusterItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsDataClusterItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Data Cluster</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Data Cluster Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsStoredProcedureItemImpl <em>Ws Stored Procedure Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsStoredProcedureItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsStoredProcedureItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Stored Procedure</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_ITEM__WS_STORED_PROCEDURE = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Stored Procedure Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsUniverseItemImpl <em>Ws Universe Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsUniverseItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsUniverseItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Universe</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEM__WS_UNIVERSE = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Universe Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsSynchronizationPlanItemImpl <em>Ws Synchronization Plan Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsSynchronizationPlanItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsSynchronizationPlanItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Synchronization Plan</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEM__WS_SYNCHRONIZATION_PLAN = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Synchronization Plan Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsViewItemImpl <em>Ws View Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsViewItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsViewItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws View</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_ITEM__WS_VIEW = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws View Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsWorkflowDeployItemImpl <em>Ws Workflow Deploy Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsWorkflowDeployItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsWorkflowDeployItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Workflow Deploy</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Workflow Deploy Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsTransformerV2ItemImpl <em>Ws Transformer V2 Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsTransformerV2ItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsTransformerV2Item()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Transformer V2</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2_ITEM__WS_TRANSFORMER_V2 = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Transformer V2 Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsRoutingRuleItemImpl <em>Ws Routing Rule Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsRoutingRuleItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsRoutingRuleItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Routing Rule</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_ITEM__WS_ROUTING_RULE = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Routing Rule Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsJobModelItemImpl <em>Ws Job Model Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsJobModelItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsJobModelItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Job Model Item</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Job Model Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsEventManagerItemImpl <em>Ws Event Manager Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsEventManagerItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsEventManagerItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Event Manager</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Event Manager Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsServiceConfigurationItemImpl <em>Ws Service Configuration Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsServiceConfigurationItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsServiceConfigurationItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Service Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_ITEM__WS_SERVICE_CONFIGURATION = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Service Configuration Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsWorkflowItemImpl <em>Ws Workflow Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsWorkflowItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsWorkflowItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Ws Workflow</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_ITEM__WS_WORKFLOW = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Workflow Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsResourceItemImpl <em>Ws Resource Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsResourceItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsResourceItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Resource</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_ITEM__RESOURCE = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Resource Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsCustomFormItemImpl <em>Ws Custom Form Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsCustomFormItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsCustomFormItem()
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
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Custom Form</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_ITEM__CUSTOM_FORM = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Custom Form Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WorkspaceRootItemImpl <em>Workspace Root Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WorkspaceRootItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWorkspaceRootItem()
     * @generated
     */
    int WORKSPACE_ROOT_ITEM = 21;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_ROOT_ITEM__PROPERTY = MDM_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_ROOT_ITEM__STATE = MDM_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_ROOT_ITEM__PARENT = MDM_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_ROOT_ITEM__REFERENCE_RESOURCES = MDM_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_ROOT_ITEM__FILE_EXTENSION = MDM_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_ROOT_ITEM__NEED_VERSION = MDM_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Children</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_ROOT_ITEM__CHILDREN = MDM_ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_ROOT_ITEM__TYPE = MDM_ITEM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_ROOT_ITEM__LABEL = MDM_ITEM_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Workspace Root Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORKSPACE_ROOT_ITEM_FEATURE_COUNT = MDM_ITEM_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsMatchRuleItemImpl <em>Ws Match Rule Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmproperties.impl.WsMatchRuleItemImpl
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsMatchRuleItem()
     * @generated
     */
    int WS_MATCH_RULE_ITEM = 22;

    /**
     * The feature id for the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_ITEM__PROPERTY = MDM_SERVER_OBJECT_ITEM__PROPERTY;

    /**
     * The feature id for the '<em><b>State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_ITEM__STATE = MDM_SERVER_OBJECT_ITEM__STATE;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_ITEM__PARENT = MDM_SERVER_OBJECT_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_ITEM__REFERENCE_RESOURCES = MDM_SERVER_OBJECT_ITEM__REFERENCE_RESOURCES;

    /**
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_ITEM__FILE_EXTENSION = MDM_SERVER_OBJECT_ITEM__FILE_EXTENSION;

    /**
     * The feature id for the '<em><b>Need Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_ITEM__NEED_VERSION = MDM_SERVER_OBJECT_ITEM__NEED_VERSION;

    /**
     * The feature id for the '<em><b>Mdm Match Rule</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_ITEM__MDM_MATCH_RULE = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Match Rule Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_ITEM_FEATURE_COUNT = MDM_SERVER_OBJECT_ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '<em>ERepository Object Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.core.model.repository.ERepositoryObjectType
     * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getERepositoryObjectType()
     * @generated
     */
    int EREPOSITORY_OBJECT_TYPE = 23;


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
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsMenuItem <em>Ws Menu Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Menu Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsMenuItem
     * @generated
     */
    EClass getWsMenuItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsMenuItem#getWsMenu <em>Ws Menu</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Menu</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsMenuItem#getWsMenu()
     * @see #getWsMenuItem()
     * @generated
     */
    EReference getWsMenuItem_WsMenu();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsRoleItem <em>Ws Role Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Role Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsRoleItem
     * @generated
     */
    EClass getWsRoleItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsRoleItem#getWsRole <em>Ws Role</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Role</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsRoleItem#getWsRole()
     * @see #getWsRoleItem()
     * @generated
     */
    EReference getWsRoleItem_WsRole();

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
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getData <em>Data</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Data</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.ContainerItem#getData()
     * @see #getContainerItem()
     * @generated
     */
    EAttribute getContainerItem_Data();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsDataModelItem <em>Ws Data Model Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Data Model Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsDataModelItem
     * @generated
     */
    EClass getWsDataModelItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsDataModelItem#getWsDataModel <em>Ws Data Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Data Model</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsDataModelItem#getWsDataModel()
     * @see #getWsDataModelItem()
     * @generated
     */
    EReference getWsDataModelItem_WsDataModel();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsDataClusterItem <em>Ws Data Cluster Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Data Cluster Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsDataClusterItem
     * @generated
     */
    EClass getWsDataClusterItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsDataClusterItem#getWsDataCluster <em>Ws Data Cluster</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Data Cluster</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsDataClusterItem#getWsDataCluster()
     * @see #getWsDataClusterItem()
     * @generated
     */
    EReference getWsDataClusterItem_WsDataCluster();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsStoredProcedureItem <em>Ws Stored Procedure Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Stored Procedure Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsStoredProcedureItem
     * @generated
     */
    EClass getWsStoredProcedureItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsStoredProcedureItem#getWsStoredProcedure <em>Ws Stored Procedure</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Stored Procedure</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsStoredProcedureItem#getWsStoredProcedure()
     * @see #getWsStoredProcedureItem()
     * @generated
     */
    EReference getWsStoredProcedureItem_WsStoredProcedure();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsUniverseItem <em>Ws Universe Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Universe Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsUniverseItem
     * @generated
     */
    EClass getWsUniverseItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsUniverseItem#getWsUniverse <em>Ws Universe</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Universe</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsUniverseItem#getWsUniverse()
     * @see #getWsUniverseItem()
     * @generated
     */
    EReference getWsUniverseItem_WsUniverse();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsSynchronizationPlanItem <em>Ws Synchronization Plan Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Synchronization Plan Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsSynchronizationPlanItem
     * @generated
     */
    EClass getWsSynchronizationPlanItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsSynchronizationPlanItem#getWsSynchronizationPlan <em>Ws Synchronization Plan</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Synchronization Plan</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsSynchronizationPlanItem#getWsSynchronizationPlan()
     * @see #getWsSynchronizationPlanItem()
     * @generated
     */
    EReference getWsSynchronizationPlanItem_WsSynchronizationPlan();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsViewItem <em>Ws View Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws View Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsViewItem
     * @generated
     */
    EClass getWsViewItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsViewItem#getWsView <em>Ws View</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws View</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsViewItem#getWsView()
     * @see #getWsViewItem()
     * @generated
     */
    EReference getWsViewItem_WsView();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsWorkflowDeployItem <em>Ws Workflow Deploy Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Workflow Deploy Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsWorkflowDeployItem
     * @generated
     */
    EClass getWsWorkflowDeployItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsWorkflowDeployItem#getWsWorkflowDeploy <em>Ws Workflow Deploy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Workflow Deploy</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsWorkflowDeployItem#getWsWorkflowDeploy()
     * @see #getWsWorkflowDeployItem()
     * @generated
     */
    EReference getWsWorkflowDeployItem_WsWorkflowDeploy();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsTransformerV2Item <em>Ws Transformer V2 Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Transformer V2 Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsTransformerV2Item
     * @generated
     */
    EClass getWsTransformerV2Item();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsTransformerV2Item#getWsTransformerV2 <em>Ws Transformer V2</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Transformer V2</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsTransformerV2Item#getWsTransformerV2()
     * @see #getWsTransformerV2Item()
     * @generated
     */
    EReference getWsTransformerV2Item_WsTransformerV2();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsRoutingRuleItem <em>Ws Routing Rule Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Routing Rule Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsRoutingRuleItem
     * @generated
     */
    EClass getWsRoutingRuleItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsRoutingRuleItem#getWsRoutingRule <em>Ws Routing Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Routing Rule</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsRoutingRuleItem#getWsRoutingRule()
     * @see #getWsRoutingRuleItem()
     * @generated
     */
    EReference getWsRoutingRuleItem_WsRoutingRule();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsJobModelItem <em>Ws Job Model Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Job Model Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsJobModelItem
     * @generated
     */
    EClass getWsJobModelItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsJobModelItem#getWsJobModelItem <em>Ws Job Model Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Job Model Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsJobModelItem#getWsJobModelItem()
     * @see #getWsJobModelItem()
     * @generated
     */
    EReference getWsJobModelItem_WsJobModelItem();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsEventManagerItem <em>Ws Event Manager Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Event Manager Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsEventManagerItem
     * @generated
     */
    EClass getWsEventManagerItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsEventManagerItem#getWsEventManager <em>Ws Event Manager</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Event Manager</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsEventManagerItem#getWsEventManager()
     * @see #getWsEventManagerItem()
     * @generated
     */
    EReference getWsEventManagerItem_WsEventManager();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsServiceConfigurationItem <em>Ws Service Configuration Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Service Configuration Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsServiceConfigurationItem
     * @generated
     */
    EClass getWsServiceConfigurationItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsServiceConfigurationItem#getWsServiceConfiguration <em>Ws Service Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Service Configuration</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsServiceConfigurationItem#getWsServiceConfiguration()
     * @see #getWsServiceConfigurationItem()
     * @generated
     */
    EReference getWsServiceConfigurationItem_WsServiceConfiguration();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsWorkflowItem <em>Ws Workflow Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Workflow Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsWorkflowItem
     * @generated
     */
    EClass getWsWorkflowItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsWorkflowItem#getWsWorkflow <em>Ws Workflow</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ws Workflow</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsWorkflowItem#getWsWorkflow()
     * @see #getWsWorkflowItem()
     * @generated
     */
    EReference getWsWorkflowItem_WsWorkflow();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsResourceItem <em>Ws Resource Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Resource Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsResourceItem
     * @generated
     */
    EClass getWsResourceItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsResourceItem#getResource <em>Resource</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Resource</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsResourceItem#getResource()
     * @see #getWsResourceItem()
     * @generated
     */
    EReference getWsResourceItem_Resource();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsCustomFormItem <em>Ws Custom Form Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Custom Form Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsCustomFormItem
     * @generated
     */
    EClass getWsCustomFormItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsCustomFormItem#getCustomForm <em>Custom Form</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Custom Form</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsCustomFormItem#getCustomForm()
     * @see #getWsCustomFormItem()
     * @generated
     */
    EReference getWsCustomFormItem_CustomForm();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WorkspaceRootItem <em>Workspace Root Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Workspace Root Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WorkspaceRootItem
     * @generated
     */
    EClass getWorkspaceRootItem();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmproperties.WorkspaceRootItem#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WorkspaceRootItem#getLabel()
     * @see #getWorkspaceRootItem()
     * @generated
     */
    EAttribute getWorkspaceRootItem_Label();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmproperties.WsMatchRuleItem <em>Ws Match Rule Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Match Rule Item</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsMatchRuleItem
     * @generated
     */
    EClass getWsMatchRuleItem();

    /**
     * Returns the meta object for the reference '{@link org.talend.mdm.repository.model.mdmproperties.WsMatchRuleItem#getMdmMatchRule <em>Mdm Match Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Mdm Match Rule</em>'.
     * @see org.talend.mdm.repository.model.mdmproperties.WsMatchRuleItem#getMdmMatchRule()
     * @see #getWsMatchRuleItem()
     * @generated
     */
    EReference getWsMatchRuleItem_MdmMatchRule();

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
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsMenuItemImpl <em>Ws Menu Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsMenuItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsMenuItem()
         * @generated
         */
        EClass WS_MENU_ITEM = eINSTANCE.getWsMenuItem();

        /**
         * The meta object literal for the '<em><b>Ws Menu</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_MENU_ITEM__WS_MENU = eINSTANCE.getWsMenuItem_WsMenu();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsRoleItemImpl <em>Ws Role Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsRoleItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsRoleItem()
         * @generated
         */
        EClass WS_ROLE_ITEM = eINSTANCE.getWsRoleItem();

        /**
         * The meta object literal for the '<em><b>Ws Role</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_ROLE_ITEM__WS_ROLE = eINSTANCE.getWsRoleItem_WsRole();

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
         * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONTAINER_ITEM__DATA = eINSTANCE.getContainerItem_Data();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsDataModelItemImpl <em>Ws Data Model Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsDataModelItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsDataModelItem()
         * @generated
         */
        EClass WS_DATA_MODEL_ITEM = eINSTANCE.getWsDataModelItem();

        /**
         * The meta object literal for the '<em><b>Ws Data Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_DATA_MODEL_ITEM__WS_DATA_MODEL = eINSTANCE.getWsDataModelItem_WsDataModel();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsDataClusterItemImpl <em>Ws Data Cluster Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsDataClusterItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsDataClusterItem()
         * @generated
         */
        EClass WS_DATA_CLUSTER_ITEM = eINSTANCE.getWsDataClusterItem();

        /**
         * The meta object literal for the '<em><b>Ws Data Cluster</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_DATA_CLUSTER_ITEM__WS_DATA_CLUSTER = eINSTANCE.getWsDataClusterItem_WsDataCluster();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsStoredProcedureItemImpl <em>Ws Stored Procedure Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsStoredProcedureItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsStoredProcedureItem()
         * @generated
         */
        EClass WS_STORED_PROCEDURE_ITEM = eINSTANCE.getWsStoredProcedureItem();

        /**
         * The meta object literal for the '<em><b>Ws Stored Procedure</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_STORED_PROCEDURE_ITEM__WS_STORED_PROCEDURE = eINSTANCE.getWsStoredProcedureItem_WsStoredProcedure();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsUniverseItemImpl <em>Ws Universe Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsUniverseItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsUniverseItem()
         * @generated
         */
        EClass WS_UNIVERSE_ITEM = eINSTANCE.getWsUniverseItem();

        /**
         * The meta object literal for the '<em><b>Ws Universe</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_UNIVERSE_ITEM__WS_UNIVERSE = eINSTANCE.getWsUniverseItem_WsUniverse();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsSynchronizationPlanItemImpl <em>Ws Synchronization Plan Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsSynchronizationPlanItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsSynchronizationPlanItem()
         * @generated
         */
        EClass WS_SYNCHRONIZATION_PLAN_ITEM = eINSTANCE.getWsSynchronizationPlanItem();

        /**
         * The meta object literal for the '<em><b>Ws Synchronization Plan</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_SYNCHRONIZATION_PLAN_ITEM__WS_SYNCHRONIZATION_PLAN = eINSTANCE.getWsSynchronizationPlanItem_WsSynchronizationPlan();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsViewItemImpl <em>Ws View Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsViewItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsViewItem()
         * @generated
         */
        EClass WS_VIEW_ITEM = eINSTANCE.getWsViewItem();

        /**
         * The meta object literal for the '<em><b>Ws View</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_VIEW_ITEM__WS_VIEW = eINSTANCE.getWsViewItem_WsView();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsWorkflowDeployItemImpl <em>Ws Workflow Deploy Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsWorkflowDeployItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsWorkflowDeployItem()
         * @generated
         */
        EClass WS_WORKFLOW_DEPLOY_ITEM = eINSTANCE.getWsWorkflowDeployItem();

        /**
         * The meta object literal for the '<em><b>Ws Workflow Deploy</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY = eINSTANCE.getWsWorkflowDeployItem_WsWorkflowDeploy();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsTransformerV2ItemImpl <em>Ws Transformer V2 Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsTransformerV2ItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsTransformerV2Item()
         * @generated
         */
        EClass WS_TRANSFORMER_V2_ITEM = eINSTANCE.getWsTransformerV2Item();

        /**
         * The meta object literal for the '<em><b>Ws Transformer V2</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_TRANSFORMER_V2_ITEM__WS_TRANSFORMER_V2 = eINSTANCE.getWsTransformerV2Item_WsTransformerV2();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsRoutingRuleItemImpl <em>Ws Routing Rule Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsRoutingRuleItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsRoutingRuleItem()
         * @generated
         */
        EClass WS_ROUTING_RULE_ITEM = eINSTANCE.getWsRoutingRuleItem();

        /**
         * The meta object literal for the '<em><b>Ws Routing Rule</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_ROUTING_RULE_ITEM__WS_ROUTING_RULE = eINSTANCE.getWsRoutingRuleItem_WsRoutingRule();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsJobModelItemImpl <em>Ws Job Model Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsJobModelItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsJobModelItem()
         * @generated
         */
        EClass WS_JOB_MODEL_ITEM = eINSTANCE.getWsJobModelItem();

        /**
         * The meta object literal for the '<em><b>Ws Job Model Item</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM = eINSTANCE.getWsJobModelItem_WsJobModelItem();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsEventManagerItemImpl <em>Ws Event Manager Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsEventManagerItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsEventManagerItem()
         * @generated
         */
        EClass WS_EVENT_MANAGER_ITEM = eINSTANCE.getWsEventManagerItem();

        /**
         * The meta object literal for the '<em><b>Ws Event Manager</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER = eINSTANCE.getWsEventManagerItem_WsEventManager();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsServiceConfigurationItemImpl <em>Ws Service Configuration Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsServiceConfigurationItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsServiceConfigurationItem()
         * @generated
         */
        EClass WS_SERVICE_CONFIGURATION_ITEM = eINSTANCE.getWsServiceConfigurationItem();

        /**
         * The meta object literal for the '<em><b>Ws Service Configuration</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_SERVICE_CONFIGURATION_ITEM__WS_SERVICE_CONFIGURATION = eINSTANCE.getWsServiceConfigurationItem_WsServiceConfiguration();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsWorkflowItemImpl <em>Ws Workflow Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsWorkflowItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsWorkflowItem()
         * @generated
         */
        EClass WS_WORKFLOW_ITEM = eINSTANCE.getWsWorkflowItem();

        /**
         * The meta object literal for the '<em><b>Ws Workflow</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_WORKFLOW_ITEM__WS_WORKFLOW = eINSTANCE.getWsWorkflowItem_WsWorkflow();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsResourceItemImpl <em>Ws Resource Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsResourceItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsResourceItem()
         * @generated
         */
        EClass WS_RESOURCE_ITEM = eINSTANCE.getWsResourceItem();

        /**
         * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_RESOURCE_ITEM__RESOURCE = eINSTANCE.getWsResourceItem_Resource();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsCustomFormItemImpl <em>Ws Custom Form Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsCustomFormItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsCustomFormItem()
         * @generated
         */
        EClass WS_CUSTOM_FORM_ITEM = eINSTANCE.getWsCustomFormItem();

        /**
         * The meta object literal for the '<em><b>Custom Form</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_CUSTOM_FORM_ITEM__CUSTOM_FORM = eINSTANCE.getWsCustomFormItem_CustomForm();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WorkspaceRootItemImpl <em>Workspace Root Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WorkspaceRootItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWorkspaceRootItem()
         * @generated
         */
        EClass WORKSPACE_ROOT_ITEM = eINSTANCE.getWorkspaceRootItem();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WORKSPACE_ROOT_ITEM__LABEL = eINSTANCE.getWorkspaceRootItem_Label();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmproperties.impl.WsMatchRuleItemImpl <em>Ws Match Rule Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmproperties.impl.WsMatchRuleItemImpl
         * @see org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesPackageImpl#getWsMatchRuleItem()
         * @generated
         */
        EClass WS_MATCH_RULE_ITEM = eINSTANCE.getWsMatchRuleItem();

        /**
         * The meta object literal for the '<em><b>Mdm Match Rule</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_MATCH_RULE_ITEM__MDM_MATCH_RULE = eINSTANCE.getWsMatchRuleItem_MdmMatchRule();

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
