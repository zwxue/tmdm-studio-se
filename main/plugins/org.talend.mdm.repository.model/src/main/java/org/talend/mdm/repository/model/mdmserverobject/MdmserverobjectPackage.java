/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory
 * @model kind="package"
 * @generated
 */
public interface MdmserverobjectPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "mdmserverobject";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.talend.org/mdmserverobject";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "mdmserverobject";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MdmserverobjectPackage eINSTANCE = org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl.init();

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.MDMServerObjectImpl <em>MDM Server Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MDMServerObjectImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getMDMServerObject()
     * @generated
     */
    int MDM_SERVER_OBJECT = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT__NAME = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT__DESCRIPTION = 1;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT__SYSTEM = 2;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT__LAST_SERVER_DEF = 3;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT__TYPE = 4;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT__TIMESTAMP = 5;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT__DIGEST_VALUE = 6;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE = 7;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT__LAST_SERVER_NAME = 8;

    /**
     * The number of structural features of the '<em>MDM Server Object</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT_FEATURE_COUNT = 9;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEImpl <em>Ws Menu E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsMenuE()
     * @generated
     */
    int WS_MENU_E = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Menu Entries</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__MENU_ENTRIES = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Menu E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEntryEImpl <em>Ws Menu Entry E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEntryEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsMenuEntryE()
     * @generated
     */
    int WS_MENU_ENTRY_E = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ENTRY_E__ID = 0;

    /**
     * The feature id for the '<em><b>Application</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ENTRY_E__APPLICATION = 1;

    /**
     * The feature id for the '<em><b>Context</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ENTRY_E__CONTEXT = 2;

    /**
     * The feature id for the '<em><b>Icon</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ENTRY_E__ICON = 3;

    /**
     * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ENTRY_E__DESCRIPTIONS = 4;

    /**
     * The feature id for the '<em><b>Sub Menus</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ENTRY_E__SUB_MENUS = 5;

    /**
     * The number of structural features of the '<em>Ws Menu Entry E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ENTRY_E_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuMenuEntriesDescriptionsEImpl <em>Ws Menu Menu Entries Descriptions E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuMenuEntriesDescriptionsEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsMenuMenuEntriesDescriptionsE()
     * @generated
     */
    int WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E = 3;

    /**
     * The feature id for the '<em><b>Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LANGUAGE = 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LABEL = 1;

    /**
     * The number of structural features of the '<em>Ws Menu Menu Entries Descriptions E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleEImpl <em>Ws Role E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoleE()
     * @generated
     */
    int WS_ROLE_E = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Specification</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__SPECIFICATION = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Role E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleSpecificationEImpl <em>Ws Role Specification E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleSpecificationEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoleSpecificationE()
     * @generated
     */
    int WS_ROLE_SPECIFICATION_E = 5;

    /**
     * The feature id for the '<em><b>Admin</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_SPECIFICATION_E__ADMIN = 0;

    /**
     * The feature id for the '<em><b>Object Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_SPECIFICATION_E__OBJECT_TYPE = 1;

    /**
     * The feature id for the '<em><b>Instance</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_SPECIFICATION_E__INSTANCE = 2;

    /**
     * The number of structural features of the '<em>Ws Role Specification E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_SPECIFICATION_E_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleSpecificationInstanceEImpl <em>Ws Role Specification Instance E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleSpecificationInstanceEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoleSpecificationInstanceE()
     * @generated
     */
    int WS_ROLE_SPECIFICATION_INSTANCE_E = 6;

    /**
     * The feature id for the '<em><b>Instance Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_SPECIFICATION_INSTANCE_E__INSTANCE_NAME = 0;

    /**
     * The feature id for the '<em><b>Writable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_SPECIFICATION_INSTANCE_E__WRITABLE = 1;

    /**
     * The feature id for the '<em><b>Parameter</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_SPECIFICATION_INSTANCE_E__PARAMETER = 2;

    /**
     * The number of structural features of the '<em>Ws Role Specification Instance E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_SPECIFICATION_INSTANCE_E_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsViewEImpl <em>Ws View E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsViewEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsViewE()
     * @generated
     */
    int WS_VIEW_E = 7;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Searchable Business Elements</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__SEARCHABLE_BUSINESS_ELEMENTS = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Viewable Business Elements</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__VIEWABLE_BUSINESS_ELEMENTS = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Transformer Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__TRANSFORMER_ACTIVE = MDM_SERVER_OBJECT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Where Conditions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__WHERE_CONDITIONS = MDM_SERVER_OBJECT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Is Transformer Active</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__IS_TRANSFORMER_ACTIVE = MDM_SERVER_OBJECT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Transformer PK</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__TRANSFORMER_PK = MDM_SERVER_OBJECT_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Ws View E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereConditionEImpl <em>Ws Where Condition E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereConditionEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsWhereConditionE()
     * @generated
     */
    int WS_WHERE_CONDITION_E = 8;

    /**
     * The feature id for the '<em><b>Left Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WHERE_CONDITION_E__LEFT_PATH = 0;

    /**
     * The feature id for the '<em><b>Right Value Or Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WHERE_CONDITION_E__RIGHT_VALUE_OR_PATH = 1;

    /**
     * The feature id for the '<em><b>String Predicate</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WHERE_CONDITION_E__STRING_PREDICATE = 2;

    /**
     * The feature id for the '<em><b>Operator</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WHERE_CONDITION_E__OPERATOR = 3;

    /**
     * The feature id for the '<em><b>Spell Check</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WHERE_CONDITION_E__SPELL_CHECK = 4;

    /**
     * The number of structural features of the '<em>Ws Where Condition E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WHERE_CONDITION_E_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereOperatorEImpl <em>Ws Where Operator E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereOperatorEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsWhereOperatorE()
     * @generated
     */
    int WS_WHERE_OPERATOR_E = 9;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WHERE_OPERATOR_E__VALUE = 0;

    /**
     * The number of structural features of the '<em>Ws Where Operator E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WHERE_OPERATOR_E_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsStringPredicateEImpl <em>Ws String Predicate E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsStringPredicateEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsStringPredicateE()
     * @generated
     */
    int WS_STRING_PREDICATE_E = 10;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STRING_PREDICATE_E__VALUE = 0;

    /**
     * The number of structural features of the '<em>Ws String Predicate E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STRING_PREDICATE_E_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsDataModelEImpl <em>Ws Data Model E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsDataModelEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsDataModelE()
     * @generated
     */
    int WS_DATA_MODEL_E = 11;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Xsd Schema</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_E__XSD_SCHEMA = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Data Model E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_MODEL_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsDataClusterEImpl <em>Ws Data Cluster E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsDataClusterEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsDataClusterE()
     * @generated
     */
    int WS_DATA_CLUSTER_E = 12;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Vocabulary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_E__VOCABULARY = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Data Cluster E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_DATA_CLUSTER_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsStoredProcedureEImpl <em>Ws Stored Procedure E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsStoredProcedureEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsStoredProcedureE()
     * @generated
     */
    int WS_STORED_PROCEDURE_E = 13;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Procedure</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E__PROCEDURE = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Refresh Cache</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E__REFRESH_CACHE = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Ws Stored Procedure E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STORED_PROCEDURE_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseEImpl <em>Ws Universe E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsUniverseE()
     * @generated
     */
    int WS_UNIVERSE_E = 14;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Default Items Revision ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__DEFAULT_ITEMS_REVISION_ID = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Xtentis Objects Revision IDs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__XTENTIS_OBJECTS_REVISION_IDS = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Items Revision IDs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E__ITEMS_REVISION_IDS = MDM_SERVER_OBJECT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Ws Universe E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseXtentisObjectsRevisionIDsEImpl <em>Ws Universe Xtentis Objects Revision IDs E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseXtentisObjectsRevisionIDsEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsUniverseXtentisObjectsRevisionIDsE()
     * @generated
     */
    int WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E = 15;

    /**
     * The feature id for the '<em><b>Xtentis Object Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__XTENTIS_OBJECT_NAME = 0;

    /**
     * The feature id for the '<em><b>Revision ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__REVISION_ID = 1;

    /**
     * The number of structural features of the '<em>Ws Universe Xtentis Objects Revision IDs E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseItemsRevisionIDsEImpl <em>Ws Universe Items Revision IDs E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseItemsRevisionIDsEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsUniverseItemsRevisionIDsE()
     * @generated
     */
    int WS_UNIVERSE_ITEMS_REVISION_IDS_E = 16;

    /**
     * The feature id for the '<em><b>Concept Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEMS_REVISION_IDS_E__CONCEPT_PATTERN = 0;

    /**
     * The feature id for the '<em><b>Revision ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEMS_REVISION_IDS_E__REVISION_ID = 1;

    /**
     * The number of structural features of the '<em>Ws Universe Items Revision IDs E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_UNIVERSE_ITEMS_REVISION_IDS_E_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanEImpl <em>Ws Synchronization Plan E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsSynchronizationPlanE()
     * @generated
     */
    int WS_SYNCHRONIZATION_PLAN_E = 17;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Remote System Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_NAME = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Remote System URL</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_URL = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Remote System Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_USERNAME = MDM_SERVER_OBJECT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Remote System Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_PASSWORD = MDM_SERVER_OBJECT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Tis URL</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__TIS_URL = MDM_SERVER_OBJECT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Tis Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__TIS_USERNAME = MDM_SERVER_OBJECT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Tis Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__TIS_PASSWORD = MDM_SERVER_OBJECT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Tis Parameters</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__TIS_PARAMETERS = MDM_SERVER_OBJECT_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Xtentis Objects Synchronizations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__XTENTIS_OBJECTS_SYNCHRONIZATIONS = MDM_SERVER_OBJECT_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Items Synchronizations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E__ITEMS_SYNCHRONIZATIONS = MDM_SERVER_OBJECT_FEATURE_COUNT + 9;

    /**
     * The number of structural features of the '<em>Ws Synchronization Plan E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 10;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanItemsSynchronizationsEImpl <em>Ws Synchronization Plan Items Synchronizations E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanItemsSynchronizationsEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsSynchronizationPlanItemsSynchronizationsE()
     * @generated
     */
    int WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E = 18;

    /**
     * The feature id for the '<em><b>Concept Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__CONCEPT_NAME = 0;

    /**
     * The feature id for the '<em><b>Ids Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__IDS_PATTERN = 1;

    /**
     * The feature id for the '<em><b>Local Cluster</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_CLUSTER = 2;

    /**
     * The feature id for the '<em><b>Local Revision ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID = 3;

    /**
     * The feature id for the '<em><b>Remote Cluster</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_CLUSTER = 4;

    /**
     * The feature id for the '<em><b>Remote Revision ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID = 5;

    /**
     * The feature id for the '<em><b>Algorithm</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__ALGORITHM = 6;

    /**
     * The number of structural features of the '<em>Ws Synchronization Plan Items Synchronizations E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E_FEATURE_COUNT = 7;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanXtentisObjectsSynchronizationsEImpl <em>Ws Synchronization Plan Xtentis Objects Synchronizations E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanXtentisObjectsSynchronizationsEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsSynchronizationPlanXtentisObjectsSynchronizationsE()
     * @generated
     */
    int WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E = 19;

    /**
     * The feature id for the '<em><b>Xtentis Object Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__XTENTIS_OBJECT_NAME = 0;

    /**
     * The feature id for the '<em><b>Synchronizations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__SYNCHRONIZATIONS = 1;

    /**
     * The number of structural features of the '<em>Ws Synchronization Plan Xtentis Objects Synchronizations E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl <em>Ws Synchronization Plan Xtentis Objects Synchronizations Synchronizations E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE()
     * @generated
     */
    int WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E = 20;

    /**
     * The feature id for the '<em><b>Instance Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__INSTANCE_PATTERN = 0;

    /**
     * The feature id for the '<em><b>Local Revision ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID = 1;

    /**
     * The feature id for the '<em><b>Remote Revision ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID = 2;

    /**
     * The feature id for the '<em><b>Algorithm</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__ALGORITHM = 3;

    /**
     * The number of structural features of the '<em>Ws Synchronization Plan Xtentis Objects Synchronizations Synchronizations E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsBooleanEImpl <em>Ws Boolean E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsBooleanEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsBooleanE()
     * @generated
     */
    int WS_BOOLEAN_E = 21;

    /**
     * The feature id for the '<em><b>true</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_BOOLEAN_E__TRUE = 0;

    /**
     * The number of structural features of the '<em>Ws Boolean E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_BOOLEAN_E_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWorkflowDeployEImpl <em>Ws Workflow Deploy E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsWorkflowDeployEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsWorkflowDeployE()
     * @generated
     */
    int WS_WORKFLOW_DEPLOY_E = 22;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Filename</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_E__FILENAME = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Workflow Deploy E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_DEPLOY_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerV2EImpl <em>Ws Transformer V2E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerV2EImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsTransformerV2E()
     * @generated
     */
    int WS_TRANSFORMER_V2E = 23;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Process Steps</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2E__PROCESS_STEPS = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Transformer V2E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_V2E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerProcessStepEImpl <em>Ws Transformer Process Step E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerProcessStepEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsTransformerProcessStepE()
     * @generated
     */
    int WS_TRANSFORMER_PROCESS_STEP_E = 24;

    /**
     * The feature id for the '<em><b>Plugin JNDI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_PROCESS_STEP_E__PLUGIN_JNDI = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_PROCESS_STEP_E__DESCRIPTION = 1;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_PROCESS_STEP_E__PARAMETERS = 2;

    /**
     * The feature id for the '<em><b>Disabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_PROCESS_STEP_E__DISABLED = 3;

    /**
     * The feature id for the '<em><b>Input Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_PROCESS_STEP_E__INPUT_MAPPINGS = 4;

    /**
     * The feature id for the '<em><b>Output Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_PROCESS_STEP_E__OUTPUT_MAPPINGS = 5;

    /**
     * The number of structural features of the '<em>Ws Transformer Process Step E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_PROCESS_STEP_E_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerVariablesMappingEImpl <em>Ws Transformer Variables Mapping E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerVariablesMappingEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsTransformerVariablesMappingE()
     * @generated
     */
    int WS_TRANSFORMER_VARIABLES_MAPPING_E = 25;

    /**
     * The feature id for the '<em><b>Pipeline Variable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_VARIABLES_MAPPING_E__PIPELINE_VARIABLE = 0;

    /**
     * The feature id for the '<em><b>Plugin Variable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_VARIABLES_MAPPING_E__PLUGIN_VARIABLE = 1;

    /**
     * The feature id for the '<em><b>Hard Coding</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING = 2;

    /**
     * The number of structural features of the '<em>Ws Transformer Variables Mapping E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TRANSFORMER_VARIABLES_MAPPING_E_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsTypedContentEImpl <em>Ws Typed Content E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsTypedContentEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsTypedContentE()
     * @generated
     */
    int WS_TYPED_CONTENT_E = 26;

    /**
     * The feature id for the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TYPED_CONTENT_E__URL = 0;

    /**
     * The feature id for the '<em><b>Content Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TYPED_CONTENT_E__CONTENT_TYPE = 1;

    /**
     * The feature id for the '<em><b>Ws Bytes</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TYPED_CONTENT_E__WS_BYTES = 2;

    /**
     * The number of structural features of the '<em>Ws Typed Content E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_TYPED_CONTENT_E_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsByteArrayEImpl <em>Ws Byte Array E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsByteArrayEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsByteArrayE()
     * @generated
     */
    int WS_BYTE_ARRAY_E = 27;

    /**
     * The feature id for the '<em><b>Bytes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_BYTE_ARRAY_E__BYTES = 0;

    /**
     * The number of structural features of the '<em>Ws Byte Array E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_BYTE_ARRAY_E_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleEImpl <em>Ws Routing Rule E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoutingRuleE()
     * @generated
     */
    int WS_ROUTING_RULE_E = 28;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__SYNCHRONOUS = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Concept</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__CONCEPT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Service JNDI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__SERVICE_JNDI = MDM_SERVER_OBJECT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__PARAMETERS = MDM_SERVER_OBJECT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__CONDITION = MDM_SERVER_OBJECT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Deactive</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__DEACTIVE = MDM_SERVER_OBJECT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Execute Order</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__EXECUTE_ORDER = MDM_SERVER_OBJECT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Ws Routing Rule Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E__WS_ROUTING_RULE_EXPRESSIONS = MDM_SERVER_OBJECT_FEATURE_COUNT + 7;

    /**
     * The number of structural features of the '<em>Ws Routing Rule E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 8;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleExpressionEImpl <em>Ws Routing Rule Expression E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleExpressionEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoutingRuleExpressionE()
     * @generated
     */
    int WS_ROUTING_RULE_EXPRESSION_E = 29;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_EXPRESSION_E__NAME = 0;

    /**
     * The feature id for the '<em><b>Xpath</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_EXPRESSION_E__XPATH = 1;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_EXPRESSION_E__VALUE = 2;

    /**
     * The feature id for the '<em><b>Ws Operator</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR = 3;

    /**
     * The number of structural features of the '<em>Ws Routing Rule Expression E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_EXPRESSION_E_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleOperatorEImpl <em>Ws Routing Rule Operator E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleOperatorEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoutingRuleOperatorE()
     * @generated
     */
    int WS_ROUTING_RULE_OPERATOR_E = 30;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_OPERATOR_E__VALUE = 0;

    /**
     * The number of structural features of the '<em>Ws Routing Rule Operator E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROUTING_RULE_OPERATOR_E_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsJobModelEImpl <em>Ws Job Model E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsJobModelEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsJobModelE()
     * @generated
     */
    int WS_JOB_MODEL_E = 31;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The number of structural features of the '<em>Ws Job Model E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_JOB_MODEL_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsEventManagerEImpl <em>Ws Event Manager E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsEventManagerEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsEventManagerE()
     * @generated
     */
    int WS_EVENT_MANAGER_E = 32;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The number of structural features of the '<em>Ws Event Manager E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_EVENT_MANAGER_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsServiceConfigurationEImpl <em>Ws Service Configuration E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsServiceConfigurationEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsServiceConfigurationE()
     * @generated
     */
    int WS_SERVICE_CONFIGURATION_E = 33;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Service Put Configurations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_E__SERVICE_PUT_CONFIGURATIONS = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Service Configuration E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_CONFIGURATION_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsServicePutConfigurationEImpl <em>Ws Service Put Configuration E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsServicePutConfigurationEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsServicePutConfigurationE()
     * @generated
     */
    int WS_SERVICE_PUT_CONFIGURATION_E = 34;

    /**
     * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_PUT_CONFIGURATION_E__JNDI_NAME = 0;

    /**
     * The feature id for the '<em><b>Configuration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_PUT_CONFIGURATION_E__CONFIGURATION = 1;

    /**
     * The number of structural features of the '<em>Ws Service Put Configuration E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_SERVICE_PUT_CONFIGURATION_E_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWorkflowEImpl <em>Ws Workflow E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsWorkflowEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsWorkflowE()
     * @generated
     */
    int WS_WORKFLOW_E = 35;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>File Content</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_E__FILE_CONTENT = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ws Workflow E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WORKFLOW_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsResourceEImpl <em>Ws Resource E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsResourceEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsResourceE()
     * @generated
     */
    int WS_RESOURCE_E = 36;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__FILE_EXTENSION = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>File Content</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__FILE_CONTENT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Image Catalog</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E__IMAGE_CATALOG = MDM_SERVER_OBJECT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Ws Resource E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_RESOURCE_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsCustomFormEImpl <em>Ws Custom Form E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsCustomFormEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsCustomFormE()
     * @generated
     */
    int WS_CUSTOM_FORM_E = 37;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Filename</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__FILENAME = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Datamodel</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__DATAMODEL = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Entity</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__ENTITY = MDM_SERVER_OBJECT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Xml</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__XML = MDM_SERVER_OBJECT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Role</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E__ROLE = MDM_SERVER_OBJECT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Ws Custom Form E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_CUSTOM_FORM_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMatchRuleEImpl <em>Ws Match Rule E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsMatchRuleEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsMatchRuleE()
     * @generated
     */
    int WS_MATCH_RULE_E = 38;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E__NAME = MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E__DESCRIPTION = MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E__SYSTEM = MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Last Server Def</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E__LAST_SERVER_DEF = MDM_SERVER_OBJECT__LAST_SERVER_DEF;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E__TYPE = MDM_SERVER_OBJECT__TYPE;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E__TIMESTAMP = MDM_SERVER_OBJECT__TIMESTAMP;

    /**
     * The feature id for the '<em><b>Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E__DIGEST_VALUE = MDM_SERVER_OBJECT__DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Current Digest Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E__CURRENT_DIGEST_VALUE = MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE;

    /**
     * The feature id for the '<em><b>Last Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E__LAST_SERVER_NAME = MDM_SERVER_OBJECT__LAST_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Configuration Xml Content</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E__CONFIGURATION_XML_CONTENT = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>PK</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E__PK = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Ws Match Rule E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMatchRulePKEImpl <em>Ws Match Rule PKE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsMatchRulePKEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsMatchRulePKE()
     * @generated
     */
    int WS_MATCH_RULE_PKE = 39;

    /**
     * The feature id for the '<em><b>Pk</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_PKE__PK = 0;

    /**
     * The number of structural features of the '<em>Ws Match Rule PKE</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MATCH_RULE_PKE_FEATURE_COUNT = 1;


    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject <em>MDM Server Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>MDM Server Object</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.MDMServerObject
     * @generated
     */
    EClass getMDMServerObject();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getName()
     * @see #getMDMServerObject()
     * @generated
     */
    EAttribute getMDMServerObject_Name();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getDescription()
     * @see #getMDMServerObject()
     * @generated
     */
    EAttribute getMDMServerObject_Description();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#isSystem <em>System</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>System</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#isSystem()
     * @see #getMDMServerObject()
     * @generated
     */
    EAttribute getMDMServerObject_System();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getLastServerDef <em>Last Server Def</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Last Server Def</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getLastServerDef()
     * @see #getMDMServerObject()
     * @generated
     */
    EReference getMDMServerObject_LastServerDef();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getType()
     * @see #getMDMServerObject()
     * @generated
     */
    EAttribute getMDMServerObject_Type();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getTimestamp <em>Timestamp</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timestamp</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getTimestamp()
     * @see #getMDMServerObject()
     * @generated
     */
    EAttribute getMDMServerObject_Timestamp();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getDigestValue <em>Digest Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Digest Value</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getDigestValue()
     * @see #getMDMServerObject()
     * @generated
     */
    EAttribute getMDMServerObject_DigestValue();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getCurrentDigestValue <em>Current Digest Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Current Digest Value</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getCurrentDigestValue()
     * @see #getMDMServerObject()
     * @generated
     */
    EAttribute getMDMServerObject_CurrentDigestValue();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getLastServerName <em>Last Server Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Server Name</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.MDMServerObject#getLastServerName()
     * @see #getMDMServerObject()
     * @generated
     */
    EAttribute getMDMServerObject_LastServerName();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuE <em>Ws Menu E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Menu E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuE
     * @generated
     */
    EClass getWsMenuE();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuE#getMenuEntries <em>Menu Entries</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Menu Entries</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuE#getMenuEntries()
     * @see #getWsMenuE()
     * @generated
     */
    EReference getWsMenuE_MenuEntries();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE <em>Ws Menu Entry E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Menu Entry E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE
     * @generated
     */
    EClass getWsMenuEntryE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getId()
     * @see #getWsMenuEntryE()
     * @generated
     */
    EAttribute getWsMenuEntryE_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getApplication <em>Application</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Application</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getApplication()
     * @see #getWsMenuEntryE()
     * @generated
     */
    EAttribute getWsMenuEntryE_Application();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getContext()
     * @see #getWsMenuEntryE()
     * @generated
     */
    EAttribute getWsMenuEntryE_Context();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getIcon <em>Icon</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Icon</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getIcon()
     * @see #getWsMenuEntryE()
     * @generated
     */
    EAttribute getWsMenuEntryE_Icon();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getDescriptions <em>Descriptions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Descriptions</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getDescriptions()
     * @see #getWsMenuEntryE()
     * @generated
     */
    EReference getWsMenuEntryE_Descriptions();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getSubMenus <em>Sub Menus</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sub Menus</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE#getSubMenus()
     * @see #getWsMenuEntryE()
     * @generated
     */
    EReference getWsMenuEntryE_SubMenus();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuMenuEntriesDescriptionsE <em>Ws Menu Menu Entries Descriptions E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Menu Menu Entries Descriptions E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuMenuEntriesDescriptionsE
     * @generated
     */
    EClass getWsMenuMenuEntriesDescriptionsE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuMenuEntriesDescriptionsE#getLanguage <em>Language</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Language</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuMenuEntriesDescriptionsE#getLanguage()
     * @see #getWsMenuMenuEntriesDescriptionsE()
     * @generated
     */
    EAttribute getWsMenuMenuEntriesDescriptionsE_Language();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsMenuMenuEntriesDescriptionsE#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMenuMenuEntriesDescriptionsE#getLabel()
     * @see #getWsMenuMenuEntriesDescriptionsE()
     * @generated
     */
    EAttribute getWsMenuMenuEntriesDescriptionsE_Label();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleE <em>Ws Role E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Role E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleE
     * @generated
     */
    EClass getWsRoleE();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleE#getSpecification <em>Specification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Specification</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleE#getSpecification()
     * @see #getWsRoleE()
     * @generated
     */
    EReference getWsRoleE_Specification();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE <em>Ws Role Specification E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Role Specification E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE
     * @generated
     */
    EClass getWsRoleSpecificationE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE#isAdmin <em>Admin</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Admin</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE#isAdmin()
     * @see #getWsRoleSpecificationE()
     * @generated
     */
    EAttribute getWsRoleSpecificationE_Admin();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE#getObjectType <em>Object Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Object Type</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE#getObjectType()
     * @see #getWsRoleSpecificationE()
     * @generated
     */
    EAttribute getWsRoleSpecificationE_ObjectType();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE#getInstance <em>Instance</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Instance</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE#getInstance()
     * @see #getWsRoleSpecificationE()
     * @generated
     */
    EReference getWsRoleSpecificationE_Instance();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE <em>Ws Role Specification Instance E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Role Specification Instance E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE
     * @generated
     */
    EClass getWsRoleSpecificationInstanceE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE#getInstanceName <em>Instance Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Instance Name</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE#getInstanceName()
     * @see #getWsRoleSpecificationInstanceE()
     * @generated
     */
    EAttribute getWsRoleSpecificationInstanceE_InstanceName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE#isWritable <em>Writable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Writable</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE#isWritable()
     * @see #getWsRoleSpecificationInstanceE()
     * @generated
     */
    EAttribute getWsRoleSpecificationInstanceE_Writable();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Parameter</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE#getParameter()
     * @see #getWsRoleSpecificationInstanceE()
     * @generated
     */
    EAttribute getWsRoleSpecificationInstanceE_Parameter();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE <em>Ws View E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws View E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsViewE
     * @generated
     */
    EClass getWsViewE();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getSearchableBusinessElements <em>Searchable Business Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Searchable Business Elements</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsViewE#getSearchableBusinessElements()
     * @see #getWsViewE()
     * @generated
     */
    EAttribute getWsViewE_SearchableBusinessElements();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getViewableBusinessElements <em>Viewable Business Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Viewable Business Elements</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsViewE#getViewableBusinessElements()
     * @see #getWsViewE()
     * @generated
     */
    EAttribute getWsViewE_ViewableBusinessElements();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#isTransformerActive <em>Transformer Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Transformer Active</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsViewE#isTransformerActive()
     * @see #getWsViewE()
     * @generated
     */
    EAttribute getWsViewE_TransformerActive();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getWhereConditions <em>Where Conditions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Where Conditions</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsViewE#getWhereConditions()
     * @see #getWsViewE()
     * @generated
     */
    EReference getWsViewE_WhereConditions();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getIsTransformerActive <em>Is Transformer Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Is Transformer Active</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsViewE#getIsTransformerActive()
     * @see #getWsViewE()
     * @generated
     */
    EReference getWsViewE_IsTransformerActive();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getTransformerPK <em>Transformer PK</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Transformer PK</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsViewE#getTransformerPK()
     * @see #getWsViewE()
     * @generated
     */
    EAttribute getWsViewE_TransformerPK();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE <em>Ws Where Condition E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Where Condition E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE
     * @generated
     */
    EClass getWsWhereConditionE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getLeftPath <em>Left Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Left Path</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getLeftPath()
     * @see #getWsWhereConditionE()
     * @generated
     */
    EAttribute getWsWhereConditionE_LeftPath();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getRightValueOrPath <em>Right Value Or Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Right Value Or Path</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getRightValueOrPath()
     * @see #getWsWhereConditionE()
     * @generated
     */
    EAttribute getWsWhereConditionE_RightValueOrPath();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getStringPredicate <em>String Predicate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>String Predicate</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getStringPredicate()
     * @see #getWsWhereConditionE()
     * @generated
     */
    EReference getWsWhereConditionE_StringPredicate();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getOperator <em>Operator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Operator</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#getOperator()
     * @see #getWsWhereConditionE()
     * @generated
     */
    EReference getWsWhereConditionE_Operator();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#isSpellCheck <em>Spell Check</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Spell Check</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE#isSpellCheck()
     * @see #getWsWhereConditionE()
     * @generated
     */
    EAttribute getWsWhereConditionE_SpellCheck();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereOperatorE <em>Ws Where Operator E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Where Operator E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWhereOperatorE
     * @generated
     */
    EClass getWsWhereOperatorE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsWhereOperatorE#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWhereOperatorE#getValue()
     * @see #getWsWhereOperatorE()
     * @generated
     */
    EAttribute getWsWhereOperatorE_Value();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsStringPredicateE <em>Ws String Predicate E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws String Predicate E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsStringPredicateE
     * @generated
     */
    EClass getWsStringPredicateE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsStringPredicateE#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsStringPredicateE#getValue()
     * @see #getWsStringPredicateE()
     * @generated
     */
    EAttribute getWsStringPredicateE_Value();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsDataModelE <em>Ws Data Model E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Data Model E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsDataModelE
     * @generated
     */
    EClass getWsDataModelE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsDataModelE#getXsdSchema <em>Xsd Schema</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xsd Schema</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsDataModelE#getXsdSchema()
     * @see #getWsDataModelE()
     * @generated
     */
    EAttribute getWsDataModelE_XsdSchema();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsDataClusterE <em>Ws Data Cluster E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Data Cluster E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsDataClusterE
     * @generated
     */
    EClass getWsDataClusterE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsDataClusterE#getVocabulary <em>Vocabulary</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Vocabulary</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsDataClusterE#getVocabulary()
     * @see #getWsDataClusterE()
     * @generated
     */
    EAttribute getWsDataClusterE_Vocabulary();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsStoredProcedureE <em>Ws Stored Procedure E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Stored Procedure E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsStoredProcedureE
     * @generated
     */
    EClass getWsStoredProcedureE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsStoredProcedureE#getProcedure <em>Procedure</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Procedure</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsStoredProcedureE#getProcedure()
     * @see #getWsStoredProcedureE()
     * @generated
     */
    EAttribute getWsStoredProcedureE_Procedure();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsStoredProcedureE#isRefreshCache <em>Refresh Cache</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Refresh Cache</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsStoredProcedureE#isRefreshCache()
     * @see #getWsStoredProcedureE()
     * @generated
     */
    EAttribute getWsStoredProcedureE_RefreshCache();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseE <em>Ws Universe E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Universe E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseE
     * @generated
     */
    EClass getWsUniverseE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseE#getDefaultItemsRevisionID <em>Default Items Revision ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Items Revision ID</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseE#getDefaultItemsRevisionID()
     * @see #getWsUniverseE()
     * @generated
     */
    EAttribute getWsUniverseE_DefaultItemsRevisionID();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseE#getXtentisObjectsRevisionIDs <em>Xtentis Objects Revision IDs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Xtentis Objects Revision IDs</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseE#getXtentisObjectsRevisionIDs()
     * @see #getWsUniverseE()
     * @generated
     */
    EReference getWsUniverseE_XtentisObjectsRevisionIDs();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseE#getItemsRevisionIDs <em>Items Revision IDs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Items Revision IDs</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseE#getItemsRevisionIDs()
     * @see #getWsUniverseE()
     * @generated
     */
    EReference getWsUniverseE_ItemsRevisionIDs();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseXtentisObjectsRevisionIDsE <em>Ws Universe Xtentis Objects Revision IDs E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Universe Xtentis Objects Revision IDs E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseXtentisObjectsRevisionIDsE
     * @generated
     */
    EClass getWsUniverseXtentisObjectsRevisionIDsE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseXtentisObjectsRevisionIDsE#getXtentisObjectName <em>Xtentis Object Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xtentis Object Name</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseXtentisObjectsRevisionIDsE#getXtentisObjectName()
     * @see #getWsUniverseXtentisObjectsRevisionIDsE()
     * @generated
     */
    EAttribute getWsUniverseXtentisObjectsRevisionIDsE_XtentisObjectName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseXtentisObjectsRevisionIDsE#getRevisionID <em>Revision ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Revision ID</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseXtentisObjectsRevisionIDsE#getRevisionID()
     * @see #getWsUniverseXtentisObjectsRevisionIDsE()
     * @generated
     */
    EAttribute getWsUniverseXtentisObjectsRevisionIDsE_RevisionID();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseItemsRevisionIDsE <em>Ws Universe Items Revision IDs E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Universe Items Revision IDs E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseItemsRevisionIDsE
     * @generated
     */
    EClass getWsUniverseItemsRevisionIDsE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseItemsRevisionIDsE#getConceptPattern <em>Concept Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Concept Pattern</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseItemsRevisionIDsE#getConceptPattern()
     * @see #getWsUniverseItemsRevisionIDsE()
     * @generated
     */
    EAttribute getWsUniverseItemsRevisionIDsE_ConceptPattern();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsUniverseItemsRevisionIDsE#getRevisionID <em>Revision ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Revision ID</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsUniverseItemsRevisionIDsE#getRevisionID()
     * @see #getWsUniverseItemsRevisionIDsE()
     * @generated
     */
    EAttribute getWsUniverseItemsRevisionIDsE_RevisionID();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE <em>Ws Synchronization Plan E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Synchronization Plan E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE
     * @generated
     */
    EClass getWsSynchronizationPlanE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getRemoteSystemName <em>Remote System Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Remote System Name</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getRemoteSystemName()
     * @see #getWsSynchronizationPlanE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanE_RemoteSystemName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getRemoteSystemURL <em>Remote System URL</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Remote System URL</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getRemoteSystemURL()
     * @see #getWsSynchronizationPlanE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanE_RemoteSystemURL();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getRemoteSystemUsername <em>Remote System Username</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Remote System Username</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getRemoteSystemUsername()
     * @see #getWsSynchronizationPlanE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanE_RemoteSystemUsername();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getRemoteSystemPassword <em>Remote System Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Remote System Password</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getRemoteSystemPassword()
     * @see #getWsSynchronizationPlanE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanE_RemoteSystemPassword();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getTisURL <em>Tis URL</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tis URL</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getTisURL()
     * @see #getWsSynchronizationPlanE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanE_TisURL();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getTisUsername <em>Tis Username</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tis Username</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getTisUsername()
     * @see #getWsSynchronizationPlanE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanE_TisUsername();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getTisPassword <em>Tis Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tis Password</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getTisPassword()
     * @see #getWsSynchronizationPlanE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanE_TisPassword();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getTisParameters <em>Tis Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tis Parameters</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getTisParameters()
     * @see #getWsSynchronizationPlanE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanE_TisParameters();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getXtentisObjectsSynchronizations <em>Xtentis Objects Synchronizations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Xtentis Objects Synchronizations</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getXtentisObjectsSynchronizations()
     * @see #getWsSynchronizationPlanE()
     * @generated
     */
    EReference getWsSynchronizationPlanE_XtentisObjectsSynchronizations();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getItemsSynchronizations <em>Items Synchronizations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Items Synchronizations</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE#getItemsSynchronizations()
     * @see #getWsSynchronizationPlanE()
     * @generated
     */
    EReference getWsSynchronizationPlanE_ItemsSynchronizations();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE <em>Ws Synchronization Plan Items Synchronizations E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Synchronization Plan Items Synchronizations E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE
     * @generated
     */
    EClass getWsSynchronizationPlanItemsSynchronizationsE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getConceptName <em>Concept Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Concept Name</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getConceptName()
     * @see #getWsSynchronizationPlanItemsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanItemsSynchronizationsE_ConceptName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getIdsPattern <em>Ids Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ids Pattern</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getIdsPattern()
     * @see #getWsSynchronizationPlanItemsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanItemsSynchronizationsE_IdsPattern();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getLocalCluster <em>Local Cluster</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Local Cluster</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getLocalCluster()
     * @see #getWsSynchronizationPlanItemsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanItemsSynchronizationsE_LocalCluster();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getLocalRevisionID <em>Local Revision ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Local Revision ID</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getLocalRevisionID()
     * @see #getWsSynchronizationPlanItemsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanItemsSynchronizationsE_LocalRevisionID();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getRemoteCluster <em>Remote Cluster</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Remote Cluster</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getRemoteCluster()
     * @see #getWsSynchronizationPlanItemsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanItemsSynchronizationsE_RemoteCluster();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getRemoteRevisionID <em>Remote Revision ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Remote Revision ID</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getRemoteRevisionID()
     * @see #getWsSynchronizationPlanItemsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanItemsSynchronizationsE_RemoteRevisionID();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getAlgorithm <em>Algorithm</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Algorithm</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE#getAlgorithm()
     * @see #getWsSynchronizationPlanItemsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanItemsSynchronizationsE_Algorithm();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsE <em>Ws Synchronization Plan Xtentis Objects Synchronizations E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Synchronization Plan Xtentis Objects Synchronizations E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsE
     * @generated
     */
    EClass getWsSynchronizationPlanXtentisObjectsSynchronizationsE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsE#getXtentisObjectName <em>Xtentis Object Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xtentis Object Name</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsE#getXtentisObjectName()
     * @see #getWsSynchronizationPlanXtentisObjectsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanXtentisObjectsSynchronizationsE_XtentisObjectName();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsE#getSynchronizations <em>Synchronizations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Synchronizations</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsE#getSynchronizations()
     * @see #getWsSynchronizationPlanXtentisObjectsSynchronizationsE()
     * @generated
     */
    EReference getWsSynchronizationPlanXtentisObjectsSynchronizationsE_Synchronizations();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE <em>Ws Synchronization Plan Xtentis Objects Synchronizations Synchronizations E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Synchronization Plan Xtentis Objects Synchronizations Synchronizations E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE
     * @generated
     */
    EClass getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE#getInstancePattern <em>Instance Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Instance Pattern</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE#getInstancePattern()
     * @see #getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_InstancePattern();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE#getLocalRevisionID <em>Local Revision ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Local Revision ID</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE#getLocalRevisionID()
     * @see #getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_LocalRevisionID();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE#getRemoteRevisionID <em>Remote Revision ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Remote Revision ID</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE#getRemoteRevisionID()
     * @see #getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_RemoteRevisionID();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE#getAlgorithm <em>Algorithm</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Algorithm</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE#getAlgorithm()
     * @see #getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE()
     * @generated
     */
    EAttribute getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_Algorithm();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsBooleanE <em>Ws Boolean E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Boolean E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsBooleanE
     * @generated
     */
    EClass getWsBooleanE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsBooleanE#is_true <em>true</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>true</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsBooleanE#is_true()
     * @see #getWsBooleanE()
     * @generated
     */
    EAttribute getWsBooleanE__true();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsWorkflowDeployE <em>Ws Workflow Deploy E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Workflow Deploy E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWorkflowDeployE
     * @generated
     */
    EClass getWsWorkflowDeployE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsWorkflowDeployE#getFilename <em>Filename</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Filename</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWorkflowDeployE#getFilename()
     * @see #getWsWorkflowDeployE()
     * @generated
     */
    EAttribute getWsWorkflowDeployE_Filename();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerV2E <em>Ws Transformer V2E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Transformer V2E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerV2E
     * @generated
     */
    EClass getWsTransformerV2E();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerV2E#getProcessSteps <em>Process Steps</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Process Steps</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerV2E#getProcessSteps()
     * @see #getWsTransformerV2E()
     * @generated
     */
    EReference getWsTransformerV2E_ProcessSteps();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE <em>Ws Transformer Process Step E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Transformer Process Step E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE
     * @generated
     */
    EClass getWsTransformerProcessStepE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#getPluginJNDI <em>Plugin JNDI</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Plugin JNDI</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#getPluginJNDI()
     * @see #getWsTransformerProcessStepE()
     * @generated
     */
    EAttribute getWsTransformerProcessStepE_PluginJNDI();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#getDescription()
     * @see #getWsTransformerProcessStepE()
     * @generated
     */
    EAttribute getWsTransformerProcessStepE_Description();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Parameters</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#getParameters()
     * @see #getWsTransformerProcessStepE()
     * @generated
     */
    EAttribute getWsTransformerProcessStepE_Parameters();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#isDisabled <em>Disabled</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Disabled</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#isDisabled()
     * @see #getWsTransformerProcessStepE()
     * @generated
     */
    EAttribute getWsTransformerProcessStepE_Disabled();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#getInputMappings <em>Input Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Input Mappings</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#getInputMappings()
     * @see #getWsTransformerProcessStepE()
     * @generated
     */
    EReference getWsTransformerProcessStepE_InputMappings();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#getOutputMappings <em>Output Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Output Mappings</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE#getOutputMappings()
     * @see #getWsTransformerProcessStepE()
     * @generated
     */
    EReference getWsTransformerProcessStepE_OutputMappings();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE <em>Ws Transformer Variables Mapping E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Transformer Variables Mapping E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE
     * @generated
     */
    EClass getWsTransformerVariablesMappingE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getPipelineVariable <em>Pipeline Variable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pipeline Variable</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getPipelineVariable()
     * @see #getWsTransformerVariablesMappingE()
     * @generated
     */
    EAttribute getWsTransformerVariablesMappingE_PipelineVariable();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getPluginVariable <em>Plugin Variable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Plugin Variable</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getPluginVariable()
     * @see #getWsTransformerVariablesMappingE()
     * @generated
     */
    EAttribute getWsTransformerVariablesMappingE_PluginVariable();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getHardCoding <em>Hard Coding</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Hard Coding</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getHardCoding()
     * @see #getWsTransformerVariablesMappingE()
     * @generated
     */
    EReference getWsTransformerVariablesMappingE_HardCoding();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE <em>Ws Typed Content E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Typed Content E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE
     * @generated
     */
    EClass getWsTypedContentE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getUrl <em>Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Url</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getUrl()
     * @see #getWsTypedContentE()
     * @generated
     */
    EAttribute getWsTypedContentE_Url();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getContentType <em>Content Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Content Type</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getContentType()
     * @see #getWsTypedContentE()
     * @generated
     */
    EAttribute getWsTypedContentE_ContentType();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getWsBytes <em>Ws Bytes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Ws Bytes</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE#getWsBytes()
     * @see #getWsTypedContentE()
     * @generated
     */
    EReference getWsTypedContentE_WsBytes();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsByteArrayE <em>Ws Byte Array E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Byte Array E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsByteArrayE
     * @generated
     */
    EClass getWsByteArrayE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsByteArrayE#getBytes <em>Bytes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Bytes</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsByteArrayE#getBytes()
     * @see #getWsByteArrayE()
     * @generated
     */
    EAttribute getWsByteArrayE_Bytes();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE <em>Ws Routing Rule E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Routing Rule E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE
     * @generated
     */
    EClass getWsRoutingRuleE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#isSynchronous <em>Synchronous</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Synchronous</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#isSynchronous()
     * @see #getWsRoutingRuleE()
     * @generated
     */
    EAttribute getWsRoutingRuleE_Synchronous();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getConcept <em>Concept</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Concept</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getConcept()
     * @see #getWsRoutingRuleE()
     * @generated
     */
    EAttribute getWsRoutingRuleE_Concept();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getServiceJNDI <em>Service JNDI</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Service JNDI</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getServiceJNDI()
     * @see #getWsRoutingRuleE()
     * @generated
     */
    EAttribute getWsRoutingRuleE_ServiceJNDI();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Parameters</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getParameters()
     * @see #getWsRoutingRuleE()
     * @generated
     */
    EAttribute getWsRoutingRuleE_Parameters();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Condition</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getCondition()
     * @see #getWsRoutingRuleE()
     * @generated
     */
    EAttribute getWsRoutingRuleE_Condition();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#isDeactive <em>Deactive</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Deactive</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#isDeactive()
     * @see #getWsRoutingRuleE()
     * @generated
     */
    EAttribute getWsRoutingRuleE_Deactive();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getExecuteOrder <em>Execute Order</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Execute Order</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getExecuteOrder()
     * @see #getWsRoutingRuleE()
     * @generated
     */
    EAttribute getWsRoutingRuleE_ExecuteOrder();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getWsRoutingRuleExpressions <em>Ws Routing Rule Expressions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Ws Routing Rule Expressions</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE#getWsRoutingRuleExpressions()
     * @see #getWsRoutingRuleE()
     * @generated
     */
    EReference getWsRoutingRuleE_WsRoutingRuleExpressions();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE <em>Ws Routing Rule Expression E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Routing Rule Expression E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE
     * @generated
     */
    EClass getWsRoutingRuleExpressionE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getName()
     * @see #getWsRoutingRuleExpressionE()
     * @generated
     */
    EAttribute getWsRoutingRuleExpressionE_Name();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getXpath <em>Xpath</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xpath</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getXpath()
     * @see #getWsRoutingRuleExpressionE()
     * @generated
     */
    EAttribute getWsRoutingRuleExpressionE_Xpath();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getValue()
     * @see #getWsRoutingRuleExpressionE()
     * @generated
     */
    EAttribute getWsRoutingRuleExpressionE_Value();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getWsOperator <em>Ws Operator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Ws Operator</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE#getWsOperator()
     * @see #getWsRoutingRuleExpressionE()
     * @generated
     */
    EReference getWsRoutingRuleExpressionE_WsOperator();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleOperatorE <em>Ws Routing Rule Operator E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Routing Rule Operator E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleOperatorE
     * @generated
     */
    EClass getWsRoutingRuleOperatorE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleOperatorE#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleOperatorE#getValue()
     * @see #getWsRoutingRuleOperatorE()
     * @generated
     */
    EAttribute getWsRoutingRuleOperatorE_Value();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsJobModelE <em>Ws Job Model E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Job Model E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsJobModelE
     * @generated
     */
    EClass getWsJobModelE();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsEventManagerE <em>Ws Event Manager E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Event Manager E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsEventManagerE
     * @generated
     */
    EClass getWsEventManagerE();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsServiceConfigurationE <em>Ws Service Configuration E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Service Configuration E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsServiceConfigurationE
     * @generated
     */
    EClass getWsServiceConfigurationE();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WsServiceConfigurationE#getServicePutConfigurations <em>Service Put Configurations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Service Put Configurations</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsServiceConfigurationE#getServicePutConfigurations()
     * @see #getWsServiceConfigurationE()
     * @generated
     */
    EReference getWsServiceConfigurationE_ServicePutConfigurations();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE <em>Ws Service Put Configuration E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Service Put Configuration E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE
     * @generated
     */
    EClass getWsServicePutConfigurationE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE#getJndiName <em>Jndi Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Jndi Name</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE#getJndiName()
     * @see #getWsServicePutConfigurationE()
     * @generated
     */
    EAttribute getWsServicePutConfigurationE_JndiName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE#getConfiguration <em>Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Configuration</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE#getConfiguration()
     * @see #getWsServicePutConfigurationE()
     * @generated
     */
    EAttribute getWsServicePutConfigurationE_Configuration();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsWorkflowE <em>Ws Workflow E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Workflow E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWorkflowE
     * @generated
     */
    EClass getWsWorkflowE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsWorkflowE#getFileContent <em>File Content</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Content</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsWorkflowE#getFileContent()
     * @see #getWsWorkflowE()
     * @generated
     */
    EAttribute getWsWorkflowE_FileContent();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsResourceE <em>Ws Resource E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Resource E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsResourceE
     * @generated
     */
    EClass getWsResourceE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsResourceE#getFileExtension <em>File Extension</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Extension</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsResourceE#getFileExtension()
     * @see #getWsResourceE()
     * @generated
     */
    EAttribute getWsResourceE_FileExtension();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsResourceE#getFileContent <em>File Content</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Content</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsResourceE#getFileContent()
     * @see #getWsResourceE()
     * @generated
     */
    EAttribute getWsResourceE_FileContent();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsResourceE#getImageCatalog <em>Image Catalog</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Image Catalog</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsResourceE#getImageCatalog()
     * @see #getWsResourceE()
     * @generated
     */
    EAttribute getWsResourceE_ImageCatalog();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE <em>Ws Custom Form E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Custom Form E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE
     * @generated
     */
    EClass getWsCustomFormE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE#getFilename <em>Filename</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Filename</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE#getFilename()
     * @see #getWsCustomFormE()
     * @generated
     */
    EAttribute getWsCustomFormE_Filename();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE#getDatamodel <em>Datamodel</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Datamodel</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE#getDatamodel()
     * @see #getWsCustomFormE()
     * @generated
     */
    EAttribute getWsCustomFormE_Datamodel();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE#getEntity <em>Entity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Entity</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE#getEntity()
     * @see #getWsCustomFormE()
     * @generated
     */
    EAttribute getWsCustomFormE_Entity();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE#getXml <em>Xml</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xml</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE#getXml()
     * @see #getWsCustomFormE()
     * @generated
     */
    EAttribute getWsCustomFormE_Xml();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE#getRole <em>Role</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Role</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE#getRole()
     * @see #getWsCustomFormE()
     * @generated
     */
    EAttribute getWsCustomFormE_Role();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE <em>Ws Match Rule E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Match Rule E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE
     * @generated
     */
    EClass getWsMatchRuleE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE#getConfigurationXmlContent <em>Configuration Xml Content</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Configuration Xml Content</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE#getConfigurationXmlContent()
     * @see #getWsMatchRuleE()
     * @generated
     */
    EAttribute getWsMatchRuleE_ConfigurationXmlContent();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE#getPK <em>PK</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>PK</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE#getPK()
     * @see #getWsMatchRuleE()
     * @generated
     */
    EReference getWsMatchRuleE_PK();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WsMatchRulePKE <em>Ws Match Rule PKE</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ws Match Rule PKE</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMatchRulePKE
     * @generated
     */
    EClass getWsMatchRulePKE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WsMatchRulePKE#getPk <em>Pk</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pk</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WsMatchRulePKE#getPk()
     * @see #getWsMatchRulePKE()
     * @generated
     */
    EAttribute getWsMatchRulePKE_Pk();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    MdmserverobjectFactory getMdmserverobjectFactory();

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
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.MDMServerObjectImpl <em>MDM Server Object</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MDMServerObjectImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getMDMServerObject()
         * @generated
         */
        EClass MDM_SERVER_OBJECT = eINSTANCE.getMDMServerObject();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MDM_SERVER_OBJECT__NAME = eINSTANCE.getMDMServerObject_Name();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MDM_SERVER_OBJECT__DESCRIPTION = eINSTANCE.getMDMServerObject_Description();

        /**
         * The meta object literal for the '<em><b>System</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MDM_SERVER_OBJECT__SYSTEM = eINSTANCE.getMDMServerObject_System();

        /**
         * The meta object literal for the '<em><b>Last Server Def</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MDM_SERVER_OBJECT__LAST_SERVER_DEF = eINSTANCE.getMDMServerObject_LastServerDef();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MDM_SERVER_OBJECT__TYPE = eINSTANCE.getMDMServerObject_Type();

        /**
         * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MDM_SERVER_OBJECT__TIMESTAMP = eINSTANCE.getMDMServerObject_Timestamp();

        /**
         * The meta object literal for the '<em><b>Digest Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MDM_SERVER_OBJECT__DIGEST_VALUE = eINSTANCE.getMDMServerObject_DigestValue();

        /**
         * The meta object literal for the '<em><b>Current Digest Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE = eINSTANCE.getMDMServerObject_CurrentDigestValue();

        /**
         * The meta object literal for the '<em><b>Last Server Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MDM_SERVER_OBJECT__LAST_SERVER_NAME = eINSTANCE.getMDMServerObject_LastServerName();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEImpl <em>Ws Menu E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsMenuE()
         * @generated
         */
        EClass WS_MENU_E = eINSTANCE.getWsMenuE();

        /**
         * The meta object literal for the '<em><b>Menu Entries</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_MENU_E__MENU_ENTRIES = eINSTANCE.getWsMenuE_MenuEntries();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEntryEImpl <em>Ws Menu Entry E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEntryEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsMenuEntryE()
         * @generated
         */
        EClass WS_MENU_ENTRY_E = eINSTANCE.getWsMenuEntryE();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_ENTRY_E__ID = eINSTANCE.getWsMenuEntryE_Id();

        /**
         * The meta object literal for the '<em><b>Application</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_ENTRY_E__APPLICATION = eINSTANCE.getWsMenuEntryE_Application();

        /**
         * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_ENTRY_E__CONTEXT = eINSTANCE.getWsMenuEntryE_Context();

        /**
         * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_ENTRY_E__ICON = eINSTANCE.getWsMenuEntryE_Icon();

        /**
         * The meta object literal for the '<em><b>Descriptions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_MENU_ENTRY_E__DESCRIPTIONS = eINSTANCE.getWsMenuEntryE_Descriptions();

        /**
         * The meta object literal for the '<em><b>Sub Menus</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_MENU_ENTRY_E__SUB_MENUS = eINSTANCE.getWsMenuEntryE_SubMenus();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuMenuEntriesDescriptionsEImpl <em>Ws Menu Menu Entries Descriptions E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuMenuEntriesDescriptionsEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsMenuMenuEntriesDescriptionsE()
         * @generated
         */
        EClass WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E = eINSTANCE.getWsMenuMenuEntriesDescriptionsE();

        /**
         * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LANGUAGE = eINSTANCE.getWsMenuMenuEntriesDescriptionsE_Language();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LABEL = eINSTANCE.getWsMenuMenuEntriesDescriptionsE_Label();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleEImpl <em>Ws Role E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoleE()
         * @generated
         */
        EClass WS_ROLE_E = eINSTANCE.getWsRoleE();

        /**
         * The meta object literal for the '<em><b>Specification</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_ROLE_E__SPECIFICATION = eINSTANCE.getWsRoleE_Specification();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleSpecificationEImpl <em>Ws Role Specification E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleSpecificationEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoleSpecificationE()
         * @generated
         */
        EClass WS_ROLE_SPECIFICATION_E = eINSTANCE.getWsRoleSpecificationE();

        /**
         * The meta object literal for the '<em><b>Admin</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROLE_SPECIFICATION_E__ADMIN = eINSTANCE.getWsRoleSpecificationE_Admin();

        /**
         * The meta object literal for the '<em><b>Object Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROLE_SPECIFICATION_E__OBJECT_TYPE = eINSTANCE.getWsRoleSpecificationE_ObjectType();

        /**
         * The meta object literal for the '<em><b>Instance</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_ROLE_SPECIFICATION_E__INSTANCE = eINSTANCE.getWsRoleSpecificationE_Instance();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleSpecificationInstanceEImpl <em>Ws Role Specification Instance E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoleSpecificationInstanceEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoleSpecificationInstanceE()
         * @generated
         */
        EClass WS_ROLE_SPECIFICATION_INSTANCE_E = eINSTANCE.getWsRoleSpecificationInstanceE();

        /**
         * The meta object literal for the '<em><b>Instance Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROLE_SPECIFICATION_INSTANCE_E__INSTANCE_NAME = eINSTANCE.getWsRoleSpecificationInstanceE_InstanceName();

        /**
         * The meta object literal for the '<em><b>Writable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROLE_SPECIFICATION_INSTANCE_E__WRITABLE = eINSTANCE.getWsRoleSpecificationInstanceE_Writable();

        /**
         * The meta object literal for the '<em><b>Parameter</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROLE_SPECIFICATION_INSTANCE_E__PARAMETER = eINSTANCE.getWsRoleSpecificationInstanceE_Parameter();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsViewEImpl <em>Ws View E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsViewEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsViewE()
         * @generated
         */
        EClass WS_VIEW_E = eINSTANCE.getWsViewE();

        /**
         * The meta object literal for the '<em><b>Searchable Business Elements</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_VIEW_E__SEARCHABLE_BUSINESS_ELEMENTS = eINSTANCE.getWsViewE_SearchableBusinessElements();

        /**
         * The meta object literal for the '<em><b>Viewable Business Elements</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_VIEW_E__VIEWABLE_BUSINESS_ELEMENTS = eINSTANCE.getWsViewE_ViewableBusinessElements();

        /**
         * The meta object literal for the '<em><b>Transformer Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_VIEW_E__TRANSFORMER_ACTIVE = eINSTANCE.getWsViewE_TransformerActive();

        /**
         * The meta object literal for the '<em><b>Where Conditions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_VIEW_E__WHERE_CONDITIONS = eINSTANCE.getWsViewE_WhereConditions();

        /**
         * The meta object literal for the '<em><b>Is Transformer Active</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_VIEW_E__IS_TRANSFORMER_ACTIVE = eINSTANCE.getWsViewE_IsTransformerActive();

        /**
         * The meta object literal for the '<em><b>Transformer PK</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_VIEW_E__TRANSFORMER_PK = eINSTANCE.getWsViewE_TransformerPK();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereConditionEImpl <em>Ws Where Condition E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereConditionEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsWhereConditionE()
         * @generated
         */
        EClass WS_WHERE_CONDITION_E = eINSTANCE.getWsWhereConditionE();

        /**
         * The meta object literal for the '<em><b>Left Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_WHERE_CONDITION_E__LEFT_PATH = eINSTANCE.getWsWhereConditionE_LeftPath();

        /**
         * The meta object literal for the '<em><b>Right Value Or Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_WHERE_CONDITION_E__RIGHT_VALUE_OR_PATH = eINSTANCE.getWsWhereConditionE_RightValueOrPath();

        /**
         * The meta object literal for the '<em><b>String Predicate</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_WHERE_CONDITION_E__STRING_PREDICATE = eINSTANCE.getWsWhereConditionE_StringPredicate();

        /**
         * The meta object literal for the '<em><b>Operator</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_WHERE_CONDITION_E__OPERATOR = eINSTANCE.getWsWhereConditionE_Operator();

        /**
         * The meta object literal for the '<em><b>Spell Check</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_WHERE_CONDITION_E__SPELL_CHECK = eINSTANCE.getWsWhereConditionE_SpellCheck();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereOperatorEImpl <em>Ws Where Operator E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsWhereOperatorEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsWhereOperatorE()
         * @generated
         */
        EClass WS_WHERE_OPERATOR_E = eINSTANCE.getWsWhereOperatorE();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_WHERE_OPERATOR_E__VALUE = eINSTANCE.getWsWhereOperatorE_Value();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsStringPredicateEImpl <em>Ws String Predicate E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsStringPredicateEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsStringPredicateE()
         * @generated
         */
        EClass WS_STRING_PREDICATE_E = eINSTANCE.getWsStringPredicateE();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_STRING_PREDICATE_E__VALUE = eINSTANCE.getWsStringPredicateE_Value();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsDataModelEImpl <em>Ws Data Model E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsDataModelEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsDataModelE()
         * @generated
         */
        EClass WS_DATA_MODEL_E = eINSTANCE.getWsDataModelE();

        /**
         * The meta object literal for the '<em><b>Xsd Schema</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_DATA_MODEL_E__XSD_SCHEMA = eINSTANCE.getWsDataModelE_XsdSchema();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsDataClusterEImpl <em>Ws Data Cluster E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsDataClusterEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsDataClusterE()
         * @generated
         */
        EClass WS_DATA_CLUSTER_E = eINSTANCE.getWsDataClusterE();

        /**
         * The meta object literal for the '<em><b>Vocabulary</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_DATA_CLUSTER_E__VOCABULARY = eINSTANCE.getWsDataClusterE_Vocabulary();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsStoredProcedureEImpl <em>Ws Stored Procedure E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsStoredProcedureEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsStoredProcedureE()
         * @generated
         */
        EClass WS_STORED_PROCEDURE_E = eINSTANCE.getWsStoredProcedureE();

        /**
         * The meta object literal for the '<em><b>Procedure</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_STORED_PROCEDURE_E__PROCEDURE = eINSTANCE.getWsStoredProcedureE_Procedure();

        /**
         * The meta object literal for the '<em><b>Refresh Cache</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_STORED_PROCEDURE_E__REFRESH_CACHE = eINSTANCE.getWsStoredProcedureE_RefreshCache();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseEImpl <em>Ws Universe E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsUniverseE()
         * @generated
         */
        EClass WS_UNIVERSE_E = eINSTANCE.getWsUniverseE();

        /**
         * The meta object literal for the '<em><b>Default Items Revision ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_UNIVERSE_E__DEFAULT_ITEMS_REVISION_ID = eINSTANCE.getWsUniverseE_DefaultItemsRevisionID();

        /**
         * The meta object literal for the '<em><b>Xtentis Objects Revision IDs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_UNIVERSE_E__XTENTIS_OBJECTS_REVISION_IDS = eINSTANCE.getWsUniverseE_XtentisObjectsRevisionIDs();

        /**
         * The meta object literal for the '<em><b>Items Revision IDs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_UNIVERSE_E__ITEMS_REVISION_IDS = eINSTANCE.getWsUniverseE_ItemsRevisionIDs();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseXtentisObjectsRevisionIDsEImpl <em>Ws Universe Xtentis Objects Revision IDs E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseXtentisObjectsRevisionIDsEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsUniverseXtentisObjectsRevisionIDsE()
         * @generated
         */
        EClass WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E = eINSTANCE.getWsUniverseXtentisObjectsRevisionIDsE();

        /**
         * The meta object literal for the '<em><b>Xtentis Object Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__XTENTIS_OBJECT_NAME = eINSTANCE.getWsUniverseXtentisObjectsRevisionIDsE_XtentisObjectName();

        /**
         * The meta object literal for the '<em><b>Revision ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__REVISION_ID = eINSTANCE.getWsUniverseXtentisObjectsRevisionIDsE_RevisionID();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseItemsRevisionIDsEImpl <em>Ws Universe Items Revision IDs E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsUniverseItemsRevisionIDsEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsUniverseItemsRevisionIDsE()
         * @generated
         */
        EClass WS_UNIVERSE_ITEMS_REVISION_IDS_E = eINSTANCE.getWsUniverseItemsRevisionIDsE();

        /**
         * The meta object literal for the '<em><b>Concept Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_UNIVERSE_ITEMS_REVISION_IDS_E__CONCEPT_PATTERN = eINSTANCE.getWsUniverseItemsRevisionIDsE_ConceptPattern();

        /**
         * The meta object literal for the '<em><b>Revision ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_UNIVERSE_ITEMS_REVISION_IDS_E__REVISION_ID = eINSTANCE.getWsUniverseItemsRevisionIDsE_RevisionID();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanEImpl <em>Ws Synchronization Plan E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsSynchronizationPlanE()
         * @generated
         */
        EClass WS_SYNCHRONIZATION_PLAN_E = eINSTANCE.getWsSynchronizationPlanE();

        /**
         * The meta object literal for the '<em><b>Remote System Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_NAME = eINSTANCE.getWsSynchronizationPlanE_RemoteSystemName();

        /**
         * The meta object literal for the '<em><b>Remote System URL</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_URL = eINSTANCE.getWsSynchronizationPlanE_RemoteSystemURL();

        /**
         * The meta object literal for the '<em><b>Remote System Username</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_USERNAME = eINSTANCE.getWsSynchronizationPlanE_RemoteSystemUsername();

        /**
         * The meta object literal for the '<em><b>Remote System Password</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_PASSWORD = eINSTANCE.getWsSynchronizationPlanE_RemoteSystemPassword();

        /**
         * The meta object literal for the '<em><b>Tis URL</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_E__TIS_URL = eINSTANCE.getWsSynchronizationPlanE_TisURL();

        /**
         * The meta object literal for the '<em><b>Tis Username</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_E__TIS_USERNAME = eINSTANCE.getWsSynchronizationPlanE_TisUsername();

        /**
         * The meta object literal for the '<em><b>Tis Password</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_E__TIS_PASSWORD = eINSTANCE.getWsSynchronizationPlanE_TisPassword();

        /**
         * The meta object literal for the '<em><b>Tis Parameters</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_E__TIS_PARAMETERS = eINSTANCE.getWsSynchronizationPlanE_TisParameters();

        /**
         * The meta object literal for the '<em><b>Xtentis Objects Synchronizations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_SYNCHRONIZATION_PLAN_E__XTENTIS_OBJECTS_SYNCHRONIZATIONS = eINSTANCE.getWsSynchronizationPlanE_XtentisObjectsSynchronizations();

        /**
         * The meta object literal for the '<em><b>Items Synchronizations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_SYNCHRONIZATION_PLAN_E__ITEMS_SYNCHRONIZATIONS = eINSTANCE.getWsSynchronizationPlanE_ItemsSynchronizations();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanItemsSynchronizationsEImpl <em>Ws Synchronization Plan Items Synchronizations E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanItemsSynchronizationsEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsSynchronizationPlanItemsSynchronizationsE()
         * @generated
         */
        EClass WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E = eINSTANCE.getWsSynchronizationPlanItemsSynchronizationsE();

        /**
         * The meta object literal for the '<em><b>Concept Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__CONCEPT_NAME = eINSTANCE.getWsSynchronizationPlanItemsSynchronizationsE_ConceptName();

        /**
         * The meta object literal for the '<em><b>Ids Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__IDS_PATTERN = eINSTANCE.getWsSynchronizationPlanItemsSynchronizationsE_IdsPattern();

        /**
         * The meta object literal for the '<em><b>Local Cluster</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_CLUSTER = eINSTANCE.getWsSynchronizationPlanItemsSynchronizationsE_LocalCluster();

        /**
         * The meta object literal for the '<em><b>Local Revision ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID = eINSTANCE.getWsSynchronizationPlanItemsSynchronizationsE_LocalRevisionID();

        /**
         * The meta object literal for the '<em><b>Remote Cluster</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_CLUSTER = eINSTANCE.getWsSynchronizationPlanItemsSynchronizationsE_RemoteCluster();

        /**
         * The meta object literal for the '<em><b>Remote Revision ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID = eINSTANCE.getWsSynchronizationPlanItemsSynchronizationsE_RemoteRevisionID();

        /**
         * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__ALGORITHM = eINSTANCE.getWsSynchronizationPlanItemsSynchronizationsE_Algorithm();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanXtentisObjectsSynchronizationsEImpl <em>Ws Synchronization Plan Xtentis Objects Synchronizations E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanXtentisObjectsSynchronizationsEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsSynchronizationPlanXtentisObjectsSynchronizationsE()
         * @generated
         */
        EClass WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E = eINSTANCE.getWsSynchronizationPlanXtentisObjectsSynchronizationsE();

        /**
         * The meta object literal for the '<em><b>Xtentis Object Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__XTENTIS_OBJECT_NAME = eINSTANCE.getWsSynchronizationPlanXtentisObjectsSynchronizationsE_XtentisObjectName();

        /**
         * The meta object literal for the '<em><b>Synchronizations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__SYNCHRONIZATIONS = eINSTANCE.getWsSynchronizationPlanXtentisObjectsSynchronizationsE_Synchronizations();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl <em>Ws Synchronization Plan Xtentis Objects Synchronizations Synchronizations E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE()
         * @generated
         */
        EClass WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E = eINSTANCE.getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE();

        /**
         * The meta object literal for the '<em><b>Instance Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__INSTANCE_PATTERN = eINSTANCE.getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_InstancePattern();

        /**
         * The meta object literal for the '<em><b>Local Revision ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID = eINSTANCE.getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_LocalRevisionID();

        /**
         * The meta object literal for the '<em><b>Remote Revision ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID = eINSTANCE.getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_RemoteRevisionID();

        /**
         * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__ALGORITHM = eINSTANCE.getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_Algorithm();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsBooleanEImpl <em>Ws Boolean E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsBooleanEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsBooleanE()
         * @generated
         */
        EClass WS_BOOLEAN_E = eINSTANCE.getWsBooleanE();

        /**
         * The meta object literal for the '<em><b>true</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_BOOLEAN_E__TRUE = eINSTANCE.getWsBooleanE__true();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWorkflowDeployEImpl <em>Ws Workflow Deploy E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsWorkflowDeployEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsWorkflowDeployE()
         * @generated
         */
        EClass WS_WORKFLOW_DEPLOY_E = eINSTANCE.getWsWorkflowDeployE();

        /**
         * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_WORKFLOW_DEPLOY_E__FILENAME = eINSTANCE.getWsWorkflowDeployE_Filename();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerV2EImpl <em>Ws Transformer V2E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerV2EImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsTransformerV2E()
         * @generated
         */
        EClass WS_TRANSFORMER_V2E = eINSTANCE.getWsTransformerV2E();

        /**
         * The meta object literal for the '<em><b>Process Steps</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_TRANSFORMER_V2E__PROCESS_STEPS = eINSTANCE.getWsTransformerV2E_ProcessSteps();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerProcessStepEImpl <em>Ws Transformer Process Step E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerProcessStepEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsTransformerProcessStepE()
         * @generated
         */
        EClass WS_TRANSFORMER_PROCESS_STEP_E = eINSTANCE.getWsTransformerProcessStepE();

        /**
         * The meta object literal for the '<em><b>Plugin JNDI</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_TRANSFORMER_PROCESS_STEP_E__PLUGIN_JNDI = eINSTANCE.getWsTransformerProcessStepE_PluginJNDI();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_TRANSFORMER_PROCESS_STEP_E__DESCRIPTION = eINSTANCE.getWsTransformerProcessStepE_Description();

        /**
         * The meta object literal for the '<em><b>Parameters</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_TRANSFORMER_PROCESS_STEP_E__PARAMETERS = eINSTANCE.getWsTransformerProcessStepE_Parameters();

        /**
         * The meta object literal for the '<em><b>Disabled</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_TRANSFORMER_PROCESS_STEP_E__DISABLED = eINSTANCE.getWsTransformerProcessStepE_Disabled();

        /**
         * The meta object literal for the '<em><b>Input Mappings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_TRANSFORMER_PROCESS_STEP_E__INPUT_MAPPINGS = eINSTANCE.getWsTransformerProcessStepE_InputMappings();

        /**
         * The meta object literal for the '<em><b>Output Mappings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_TRANSFORMER_PROCESS_STEP_E__OUTPUT_MAPPINGS = eINSTANCE.getWsTransformerProcessStepE_OutputMappings();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerVariablesMappingEImpl <em>Ws Transformer Variables Mapping E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsTransformerVariablesMappingEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsTransformerVariablesMappingE()
         * @generated
         */
        EClass WS_TRANSFORMER_VARIABLES_MAPPING_E = eINSTANCE.getWsTransformerVariablesMappingE();

        /**
         * The meta object literal for the '<em><b>Pipeline Variable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_TRANSFORMER_VARIABLES_MAPPING_E__PIPELINE_VARIABLE = eINSTANCE.getWsTransformerVariablesMappingE_PipelineVariable();

        /**
         * The meta object literal for the '<em><b>Plugin Variable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_TRANSFORMER_VARIABLES_MAPPING_E__PLUGIN_VARIABLE = eINSTANCE.getWsTransformerVariablesMappingE_PluginVariable();

        /**
         * The meta object literal for the '<em><b>Hard Coding</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING = eINSTANCE.getWsTransformerVariablesMappingE_HardCoding();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsTypedContentEImpl <em>Ws Typed Content E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsTypedContentEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsTypedContentE()
         * @generated
         */
        EClass WS_TYPED_CONTENT_E = eINSTANCE.getWsTypedContentE();

        /**
         * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_TYPED_CONTENT_E__URL = eINSTANCE.getWsTypedContentE_Url();

        /**
         * The meta object literal for the '<em><b>Content Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_TYPED_CONTENT_E__CONTENT_TYPE = eINSTANCE.getWsTypedContentE_ContentType();

        /**
         * The meta object literal for the '<em><b>Ws Bytes</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_TYPED_CONTENT_E__WS_BYTES = eINSTANCE.getWsTypedContentE_WsBytes();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsByteArrayEImpl <em>Ws Byte Array E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsByteArrayEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsByteArrayE()
         * @generated
         */
        EClass WS_BYTE_ARRAY_E = eINSTANCE.getWsByteArrayE();

        /**
         * The meta object literal for the '<em><b>Bytes</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_BYTE_ARRAY_E__BYTES = eINSTANCE.getWsByteArrayE_Bytes();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleEImpl <em>Ws Routing Rule E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoutingRuleE()
         * @generated
         */
        EClass WS_ROUTING_RULE_E = eINSTANCE.getWsRoutingRuleE();

        /**
         * The meta object literal for the '<em><b>Synchronous</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROUTING_RULE_E__SYNCHRONOUS = eINSTANCE.getWsRoutingRuleE_Synchronous();

        /**
         * The meta object literal for the '<em><b>Concept</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROUTING_RULE_E__CONCEPT = eINSTANCE.getWsRoutingRuleE_Concept();

        /**
         * The meta object literal for the '<em><b>Service JNDI</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROUTING_RULE_E__SERVICE_JNDI = eINSTANCE.getWsRoutingRuleE_ServiceJNDI();

        /**
         * The meta object literal for the '<em><b>Parameters</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROUTING_RULE_E__PARAMETERS = eINSTANCE.getWsRoutingRuleE_Parameters();

        /**
         * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROUTING_RULE_E__CONDITION = eINSTANCE.getWsRoutingRuleE_Condition();

        /**
         * The meta object literal for the '<em><b>Deactive</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROUTING_RULE_E__DEACTIVE = eINSTANCE.getWsRoutingRuleE_Deactive();

        /**
         * The meta object literal for the '<em><b>Execute Order</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROUTING_RULE_E__EXECUTE_ORDER = eINSTANCE.getWsRoutingRuleE_ExecuteOrder();

        /**
         * The meta object literal for the '<em><b>Ws Routing Rule Expressions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_ROUTING_RULE_E__WS_ROUTING_RULE_EXPRESSIONS = eINSTANCE.getWsRoutingRuleE_WsRoutingRuleExpressions();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleExpressionEImpl <em>Ws Routing Rule Expression E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleExpressionEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoutingRuleExpressionE()
         * @generated
         */
        EClass WS_ROUTING_RULE_EXPRESSION_E = eINSTANCE.getWsRoutingRuleExpressionE();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROUTING_RULE_EXPRESSION_E__NAME = eINSTANCE.getWsRoutingRuleExpressionE_Name();

        /**
         * The meta object literal for the '<em><b>Xpath</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROUTING_RULE_EXPRESSION_E__XPATH = eINSTANCE.getWsRoutingRuleExpressionE_Xpath();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROUTING_RULE_EXPRESSION_E__VALUE = eINSTANCE.getWsRoutingRuleExpressionE_Value();

        /**
         * The meta object literal for the '<em><b>Ws Operator</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR = eINSTANCE.getWsRoutingRuleExpressionE_WsOperator();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleOperatorEImpl <em>Ws Routing Rule Operator E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsRoutingRuleOperatorEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsRoutingRuleOperatorE()
         * @generated
         */
        EClass WS_ROUTING_RULE_OPERATOR_E = eINSTANCE.getWsRoutingRuleOperatorE();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROUTING_RULE_OPERATOR_E__VALUE = eINSTANCE.getWsRoutingRuleOperatorE_Value();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsJobModelEImpl <em>Ws Job Model E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsJobModelEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsJobModelE()
         * @generated
         */
        EClass WS_JOB_MODEL_E = eINSTANCE.getWsJobModelE();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsEventManagerEImpl <em>Ws Event Manager E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsEventManagerEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsEventManagerE()
         * @generated
         */
        EClass WS_EVENT_MANAGER_E = eINSTANCE.getWsEventManagerE();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsServiceConfigurationEImpl <em>Ws Service Configuration E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsServiceConfigurationEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsServiceConfigurationE()
         * @generated
         */
        EClass WS_SERVICE_CONFIGURATION_E = eINSTANCE.getWsServiceConfigurationE();

        /**
         * The meta object literal for the '<em><b>Service Put Configurations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_SERVICE_CONFIGURATION_E__SERVICE_PUT_CONFIGURATIONS = eINSTANCE.getWsServiceConfigurationE_ServicePutConfigurations();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsServicePutConfigurationEImpl <em>Ws Service Put Configuration E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsServicePutConfigurationEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsServicePutConfigurationE()
         * @generated
         */
        EClass WS_SERVICE_PUT_CONFIGURATION_E = eINSTANCE.getWsServicePutConfigurationE();

        /**
         * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SERVICE_PUT_CONFIGURATION_E__JNDI_NAME = eINSTANCE.getWsServicePutConfigurationE_JndiName();

        /**
         * The meta object literal for the '<em><b>Configuration</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_SERVICE_PUT_CONFIGURATION_E__CONFIGURATION = eINSTANCE.getWsServicePutConfigurationE_Configuration();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsWorkflowEImpl <em>Ws Workflow E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsWorkflowEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsWorkflowE()
         * @generated
         */
        EClass WS_WORKFLOW_E = eINSTANCE.getWsWorkflowE();

        /**
         * The meta object literal for the '<em><b>File Content</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_WORKFLOW_E__FILE_CONTENT = eINSTANCE.getWsWorkflowE_FileContent();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsResourceEImpl <em>Ws Resource E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsResourceEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsResourceE()
         * @generated
         */
        EClass WS_RESOURCE_E = eINSTANCE.getWsResourceE();

        /**
         * The meta object literal for the '<em><b>File Extension</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_RESOURCE_E__FILE_EXTENSION = eINSTANCE.getWsResourceE_FileExtension();

        /**
         * The meta object literal for the '<em><b>File Content</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_RESOURCE_E__FILE_CONTENT = eINSTANCE.getWsResourceE_FileContent();

        /**
         * The meta object literal for the '<em><b>Image Catalog</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_RESOURCE_E__IMAGE_CATALOG = eINSTANCE.getWsResourceE_ImageCatalog();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsCustomFormEImpl <em>Ws Custom Form E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsCustomFormEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsCustomFormE()
         * @generated
         */
        EClass WS_CUSTOM_FORM_E = eINSTANCE.getWsCustomFormE();

        /**
         * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_CUSTOM_FORM_E__FILENAME = eINSTANCE.getWsCustomFormE_Filename();

        /**
         * The meta object literal for the '<em><b>Datamodel</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_CUSTOM_FORM_E__DATAMODEL = eINSTANCE.getWsCustomFormE_Datamodel();

        /**
         * The meta object literal for the '<em><b>Entity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_CUSTOM_FORM_E__ENTITY = eINSTANCE.getWsCustomFormE_Entity();

        /**
         * The meta object literal for the '<em><b>Xml</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_CUSTOM_FORM_E__XML = eINSTANCE.getWsCustomFormE_Xml();

        /**
         * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_CUSTOM_FORM_E__ROLE = eINSTANCE.getWsCustomFormE_Role();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMatchRuleEImpl <em>Ws Match Rule E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsMatchRuleEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsMatchRuleE()
         * @generated
         */
        EClass WS_MATCH_RULE_E = eINSTANCE.getWsMatchRuleE();

        /**
         * The meta object literal for the '<em><b>Configuration Xml Content</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MATCH_RULE_E__CONFIGURATION_XML_CONTENT = eINSTANCE.getWsMatchRuleE_ConfigurationXmlContent();

        /**
         * The meta object literal for the '<em><b>PK</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_MATCH_RULE_E__PK = eINSTANCE.getWsMatchRuleE_PK();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMatchRulePKEImpl <em>Ws Match Rule PKE</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WsMatchRulePKEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWsMatchRulePKE()
         * @generated
         */
        EClass WS_MATCH_RULE_PKE = eINSTANCE.getWsMatchRulePKE();

        /**
         * The meta object literal for the '<em><b>Pk</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MATCH_RULE_PKE__PK = eINSTANCE.getWsMatchRulePKE_Pk();

    }

} //MdmserverobjectPackage
