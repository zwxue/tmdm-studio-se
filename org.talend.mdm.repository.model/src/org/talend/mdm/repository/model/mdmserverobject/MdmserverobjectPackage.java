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
     * The number of structural features of the '<em>MDM Server Object</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MDM_SERVER_OBJECT_FEATURE_COUNT = 3;

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
    int WS_MENU_E__NAME = MdmserverobjectPackage.MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__DESCRIPTION = MdmserverobjectPackage.MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__SYSTEM = MdmserverobjectPackage.MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Menu Entries</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E__MENU_ENTRIES = MdmserverobjectPackage.MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Menu E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_MENU_E_FEATURE_COUNT = MdmserverobjectPackage.MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

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
    int WS_ROLE_E__NAME = MdmserverobjectPackage.MDM_SERVER_OBJECT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__DESCRIPTION = MdmserverobjectPackage.MDM_SERVER_OBJECT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__SYSTEM = MdmserverobjectPackage.MDM_SERVER_OBJECT__SYSTEM;

    /**
     * The feature id for the '<em><b>Specification</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E__SPECIFICATION = MdmserverobjectPackage.MDM_SERVER_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>WS Role E</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WS_ROLE_E_FEATURE_COUNT = MdmserverobjectPackage.MDM_SERVER_OBJECT_FEATURE_COUNT + 1;

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
     * The meta object id for the '<em>String Array</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getStringArray()
     * @generated
     */
    int STRING_ARRAY = 7;


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
         * The meta object literal for the '<em>String Array</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectPackageImpl#getStringArray()
         * @generated
         */
        EDataType STRING_ARRAY = eINSTANCE.getStringArray();

    }

} //MdmserverobjectPackage
