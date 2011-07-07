/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
     * The number of structural features of the '<em>MDM Server Object</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuEImpl <em>WS Menu E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSMenuE()
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
     * The feature id for the '<em><b>Menu Entries</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__MENU_ENTRIES = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Menu E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuEntryEImpl <em>WS Menu Entry E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuEntryEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSMenuEntryE()
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
     * The number of structural features of the '<em>WS Menu Entry E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_ENTRY_E_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuMenuEntriesDescriptionsEImpl <em>WS Menu Menu Entries Descriptions E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuMenuEntriesDescriptionsEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSMenuMenuEntriesDescriptionsE()
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
     * The number of structural features of the '<em>WS Menu Menu Entries Descriptions E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleEImpl <em>WS Role E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSRoleE()
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
     * The feature id for the '<em><b>Specification</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__SPECIFICATION = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Role E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationEImpl <em>WS Role Specification E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSRoleSpecificationE()
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
     * The number of structural features of the '<em>WS Role Specification E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_SPECIFICATION_E_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationInstanceEImpl <em>WS Role Specification Instance E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationInstanceEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSRoleSpecificationInstanceE()
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
     * The feature id for the '<em><b>Parameter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_SPECIFICATION_INSTANCE_E__PARAMETER = 2;

    /**
     * The number of structural features of the '<em>WS Role Specification Instance E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_SPECIFICATION_INSTANCE_E_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSViewEImpl <em>WS View E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSViewEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSViewE()
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
     * The feature id for the '<em><b>Searchable Business Elements</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E__SEARCHABLE_BUSINESS_ELEMENTS = MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Viewable Business Elements</b></em>' attribute.
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
     * The number of structural features of the '<em>WS View E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_VIEW_E_FEATURE_COUNT = MDM_SERVER_OBJECT_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSWhereConditionEImpl <em>WS Where Condition E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSWhereConditionEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSWhereConditionE()
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
     * The number of structural features of the '<em>WS Where Condition E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WHERE_CONDITION_E_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSWhereOperatorEImpl <em>WS Where Operator E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSWhereOperatorEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSWhereOperatorE()
     * @generated
     */
    int WS_WHERE_OPERATOR_E = 9;

    /**
     * The number of structural features of the '<em>WS Where Operator E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_WHERE_OPERATOR_E_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSStringPredicateEImpl <em>WS String Predicate E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSStringPredicateEImpl
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSStringPredicateE()
     * @generated
     */
    int WS_STRING_PREDICATE_E = 10;

    /**
     * The number of structural features of the '<em>WS String Predicate E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_STRING_PREDICATE_E_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '<em>String Array</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getStringArray()
     * @generated
     */
    int STRING_ARRAY = 11;


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
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuE <em>WS Menu E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Menu E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuE
     * @generated
     */
    EClass getWSMenuE();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuE#getMenuEntries <em>Menu Entries</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Menu Entries</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuE#getMenuEntries()
     * @see #getWSMenuE()
     * @generated
     */
    EReference getWSMenuE_MenuEntries();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE <em>WS Menu Entry E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Menu Entry E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE
     * @generated
     */
    EClass getWSMenuEntryE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getId()
     * @see #getWSMenuEntryE()
     * @generated
     */
    EAttribute getWSMenuEntryE_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getApplication <em>Application</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Application</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getApplication()
     * @see #getWSMenuEntryE()
     * @generated
     */
    EAttribute getWSMenuEntryE_Application();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getContext()
     * @see #getWSMenuEntryE()
     * @generated
     */
    EAttribute getWSMenuEntryE_Context();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getIcon <em>Icon</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Icon</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getIcon()
     * @see #getWSMenuEntryE()
     * @generated
     */
    EAttribute getWSMenuEntryE_Icon();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getDescriptions <em>Descriptions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Descriptions</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getDescriptions()
     * @see #getWSMenuEntryE()
     * @generated
     */
    EReference getWSMenuEntryE_Descriptions();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getSubMenus <em>Sub Menus</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sub Menus</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE#getSubMenus()
     * @see #getWSMenuEntryE()
     * @generated
     */
    EReference getWSMenuEntryE_SubMenus();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE <em>WS Menu Menu Entries Descriptions E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Menu Menu Entries Descriptions E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE
     * @generated
     */
    EClass getWSMenuMenuEntriesDescriptionsE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE#getLanguage <em>Language</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Language</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE#getLanguage()
     * @see #getWSMenuMenuEntriesDescriptionsE()
     * @generated
     */
    EAttribute getWSMenuMenuEntriesDescriptionsE_Language();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE#getLabel()
     * @see #getWSMenuMenuEntriesDescriptionsE()
     * @generated
     */
    EAttribute getWSMenuMenuEntriesDescriptionsE_Label();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleE <em>WS Role E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Role E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSRoleE
     * @generated
     */
    EClass getWSRoleE();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleE#getSpecification <em>Specification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Specification</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSRoleE#getSpecification()
     * @see #getWSRoleE()
     * @generated
     */
    EReference getWSRoleE_Specification();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE <em>WS Role Specification E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Role Specification E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE
     * @generated
     */
    EClass getWSRoleSpecificationE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE#isAdmin <em>Admin</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Admin</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE#isAdmin()
     * @see #getWSRoleSpecificationE()
     * @generated
     */
    EAttribute getWSRoleSpecificationE_Admin();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE#getObjectType <em>Object Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Object Type</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE#getObjectType()
     * @see #getWSRoleSpecificationE()
     * @generated
     */
    EAttribute getWSRoleSpecificationE_ObjectType();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE#getInstance <em>Instance</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Instance</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE#getInstance()
     * @see #getWSRoleSpecificationE()
     * @generated
     */
    EReference getWSRoleSpecificationE_Instance();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE <em>WS Role Specification Instance E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Role Specification Instance E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE
     * @generated
     */
    EClass getWSRoleSpecificationInstanceE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE#getInstanceName <em>Instance Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Instance Name</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE#getInstanceName()
     * @see #getWSRoleSpecificationInstanceE()
     * @generated
     */
    EAttribute getWSRoleSpecificationInstanceE_InstanceName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE#isWritable <em>Writable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Writable</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE#isWritable()
     * @see #getWSRoleSpecificationInstanceE()
     * @generated
     */
    EAttribute getWSRoleSpecificationInstanceE_Writable();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Parameter</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE#getParameter()
     * @see #getWSRoleSpecificationInstanceE()
     * @generated
     */
    EAttribute getWSRoleSpecificationInstanceE_Parameter();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE <em>WS View E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS View E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSViewE
     * @generated
     */
    EClass getWSViewE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#getSearchableBusinessElements <em>Searchable Business Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Searchable Business Elements</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSViewE#getSearchableBusinessElements()
     * @see #getWSViewE()
     * @generated
     */
    EAttribute getWSViewE_SearchableBusinessElements();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#getViewableBusinessElements <em>Viewable Business Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Viewable Business Elements</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSViewE#getViewableBusinessElements()
     * @see #getWSViewE()
     * @generated
     */
    EAttribute getWSViewE_ViewableBusinessElements();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#isTransformerActive <em>Transformer Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Transformer Active</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSViewE#isTransformerActive()
     * @see #getWSViewE()
     * @generated
     */
    EAttribute getWSViewE_TransformerActive();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#getWhereConditions <em>Where Conditions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Where Conditions</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSViewE#getWhereConditions()
     * @see #getWSViewE()
     * @generated
     */
    EReference getWSViewE_WhereConditions();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE <em>WS Where Condition E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Where Condition E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE
     * @generated
     */
    EClass getWSWhereConditionE();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getLeftPath <em>Left Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Left Path</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getLeftPath()
     * @see #getWSWhereConditionE()
     * @generated
     */
    EAttribute getWSWhereConditionE_LeftPath();

    /**
     * Returns the meta object for the attribute '{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getRightValueOrPath <em>Right Value Or Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Right Value Or Path</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getRightValueOrPath()
     * @see #getWSWhereConditionE()
     * @generated
     */
    EAttribute getWSWhereConditionE_RightValueOrPath();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getStringPredicate <em>String Predicate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>String Predicate</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getStringPredicate()
     * @see #getWSWhereConditionE()
     * @generated
     */
    EReference getWSWhereConditionE_StringPredicate();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getOperator <em>Operator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Operator</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE#getOperator()
     * @see #getWSWhereConditionE()
     * @generated
     */
    EReference getWSWhereConditionE_Operator();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WSWhereOperatorE <em>WS Where Operator E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS Where Operator E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSWhereOperatorE
     * @generated
     */
    EClass getWSWhereOperatorE();

    /**
     * Returns the meta object for class '{@link org.talend.mdm.repository.model.mdmserverobject.WSStringPredicateE <em>WS String Predicate E</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>WS String Predicate E</em>'.
     * @see org.talend.mdm.repository.model.mdmserverobject.WSStringPredicateE
     * @generated
     */
    EClass getWSStringPredicateE();

    /**
     * Returns the meta object for data type '<em>String Array</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>String Array</em>'.
     * @model instanceClass="java.lang.String[]"
     * @generated
     */
    EDataType getStringArray();

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
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuEImpl <em>WS Menu E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSMenuE()
         * @generated
         */
        EClass WS_MENU_E = eINSTANCE.getWSMenuE();

        /**
         * The meta object literal for the '<em><b>Menu Entries</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_MENU_E__MENU_ENTRIES = eINSTANCE.getWSMenuE_MenuEntries();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuEntryEImpl <em>WS Menu Entry E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuEntryEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSMenuEntryE()
         * @generated
         */
        EClass WS_MENU_ENTRY_E = eINSTANCE.getWSMenuEntryE();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_ENTRY_E__ID = eINSTANCE.getWSMenuEntryE_Id();

        /**
         * The meta object literal for the '<em><b>Application</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_ENTRY_E__APPLICATION = eINSTANCE.getWSMenuEntryE_Application();

        /**
         * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_ENTRY_E__CONTEXT = eINSTANCE.getWSMenuEntryE_Context();

        /**
         * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_ENTRY_E__ICON = eINSTANCE.getWSMenuEntryE_Icon();

        /**
         * The meta object literal for the '<em><b>Descriptions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_MENU_ENTRY_E__DESCRIPTIONS = eINSTANCE.getWSMenuEntryE_Descriptions();

        /**
         * The meta object literal for the '<em><b>Sub Menus</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_MENU_ENTRY_E__SUB_MENUS = eINSTANCE.getWSMenuEntryE_SubMenus();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuMenuEntriesDescriptionsEImpl <em>WS Menu Menu Entries Descriptions E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuMenuEntriesDescriptionsEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSMenuMenuEntriesDescriptionsE()
         * @generated
         */
        EClass WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E = eINSTANCE.getWSMenuMenuEntriesDescriptionsE();

        /**
         * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LANGUAGE = eINSTANCE.getWSMenuMenuEntriesDescriptionsE_Language();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LABEL = eINSTANCE.getWSMenuMenuEntriesDescriptionsE_Label();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleEImpl <em>WS Role E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSRoleE()
         * @generated
         */
        EClass WS_ROLE_E = eINSTANCE.getWSRoleE();

        /**
         * The meta object literal for the '<em><b>Specification</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_ROLE_E__SPECIFICATION = eINSTANCE.getWSRoleE_Specification();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationEImpl <em>WS Role Specification E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSRoleSpecificationE()
         * @generated
         */
        EClass WS_ROLE_SPECIFICATION_E = eINSTANCE.getWSRoleSpecificationE();

        /**
         * The meta object literal for the '<em><b>Admin</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROLE_SPECIFICATION_E__ADMIN = eINSTANCE.getWSRoleSpecificationE_Admin();

        /**
         * The meta object literal for the '<em><b>Object Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROLE_SPECIFICATION_E__OBJECT_TYPE = eINSTANCE.getWSRoleSpecificationE_ObjectType();

        /**
         * The meta object literal for the '<em><b>Instance</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_ROLE_SPECIFICATION_E__INSTANCE = eINSTANCE.getWSRoleSpecificationE_Instance();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationInstanceEImpl <em>WS Role Specification Instance E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationInstanceEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSRoleSpecificationInstanceE()
         * @generated
         */
        EClass WS_ROLE_SPECIFICATION_INSTANCE_E = eINSTANCE.getWSRoleSpecificationInstanceE();

        /**
         * The meta object literal for the '<em><b>Instance Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROLE_SPECIFICATION_INSTANCE_E__INSTANCE_NAME = eINSTANCE.getWSRoleSpecificationInstanceE_InstanceName();

        /**
         * The meta object literal for the '<em><b>Writable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROLE_SPECIFICATION_INSTANCE_E__WRITABLE = eINSTANCE.getWSRoleSpecificationInstanceE_Writable();

        /**
         * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_ROLE_SPECIFICATION_INSTANCE_E__PARAMETER = eINSTANCE.getWSRoleSpecificationInstanceE_Parameter();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSViewEImpl <em>WS View E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSViewEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSViewE()
         * @generated
         */
        EClass WS_VIEW_E = eINSTANCE.getWSViewE();

        /**
         * The meta object literal for the '<em><b>Searchable Business Elements</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_VIEW_E__SEARCHABLE_BUSINESS_ELEMENTS = eINSTANCE.getWSViewE_SearchableBusinessElements();

        /**
         * The meta object literal for the '<em><b>Viewable Business Elements</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_VIEW_E__VIEWABLE_BUSINESS_ELEMENTS = eINSTANCE.getWSViewE_ViewableBusinessElements();

        /**
         * The meta object literal for the '<em><b>Transformer Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_VIEW_E__TRANSFORMER_ACTIVE = eINSTANCE.getWSViewE_TransformerActive();

        /**
         * The meta object literal for the '<em><b>Where Conditions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_VIEW_E__WHERE_CONDITIONS = eINSTANCE.getWSViewE_WhereConditions();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSWhereConditionEImpl <em>WS Where Condition E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSWhereConditionEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSWhereConditionE()
         * @generated
         */
        EClass WS_WHERE_CONDITION_E = eINSTANCE.getWSWhereConditionE();

        /**
         * The meta object literal for the '<em><b>Left Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_WHERE_CONDITION_E__LEFT_PATH = eINSTANCE.getWSWhereConditionE_LeftPath();

        /**
         * The meta object literal for the '<em><b>Right Value Or Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WS_WHERE_CONDITION_E__RIGHT_VALUE_OR_PATH = eINSTANCE.getWSWhereConditionE_RightValueOrPath();

        /**
         * The meta object literal for the '<em><b>String Predicate</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_WHERE_CONDITION_E__STRING_PREDICATE = eINSTANCE.getWSWhereConditionE_StringPredicate();

        /**
         * The meta object literal for the '<em><b>Operator</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WS_WHERE_CONDITION_E__OPERATOR = eINSTANCE.getWSWhereConditionE_Operator();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSWhereOperatorEImpl <em>WS Where Operator E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSWhereOperatorEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSWhereOperatorE()
         * @generated
         */
        EClass WS_WHERE_OPERATOR_E = eINSTANCE.getWSWhereOperatorE();

        /**
         * The meta object literal for the '{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSStringPredicateEImpl <em>WS String Predicate E</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.WSStringPredicateEImpl
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getWSStringPredicateE()
         * @generated
         */
        EClass WS_STRING_PREDICATE_E = eINSTANCE.getWSStringPredicateE();

        /**
         * The meta object literal for the '<em>String Array</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getStringArray()
         * @generated
         */
        EDataType STRING_ARRAY = eINSTANCE.getStringArray();

    }

} //MdmserverobjectPackage
