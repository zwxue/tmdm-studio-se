/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.talend.mdm.repository.model.mdmserverobject.EWSMenu;
import org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MdmserverobjectPackageImpl extends EPackageImpl implements MdmserverobjectPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mdmServerObjectEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass ewsMenuEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass ewsMenuEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsMenuMenuEntriesDescriptionsEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsRoleEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsRoleSpecificationEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsRoleSpecificationInstanceEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType stringArrayEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private MdmserverobjectPackageImpl() {
        super(eNS_URI, MdmserverobjectFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link MdmserverobjectPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static MdmserverobjectPackage init() {
        if (isInited) return (MdmserverobjectPackage)EPackage.Registry.INSTANCE.getEPackage(MdmserverobjectPackage.eNS_URI);

        // Obtain or create and register package
        MdmserverobjectPackageImpl theMdmserverobjectPackage = (MdmserverobjectPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MdmserverobjectPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MdmserverobjectPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theMdmserverobjectPackage.createPackageContents();

        // Initialize created meta-data
        theMdmserverobjectPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theMdmserverobjectPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(MdmserverobjectPackage.eNS_URI, theMdmserverobjectPackage);
        return theMdmserverobjectPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMDMServerObject() {
        return mdmServerObjectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMDMServerObject_Name() {
        return (EAttribute)mdmServerObjectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMDMServerObject_Description() {
        return (EAttribute)mdmServerObjectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEWSMenu() {
        return ewsMenuEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEWSMenu_MenuEntries() {
        return (EReference)ewsMenuEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEWSMenuEntry() {
        return ewsMenuEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEWSMenuEntry_Id() {
        return (EAttribute)ewsMenuEntryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEWSMenuEntry_Application() {
        return (EAttribute)ewsMenuEntryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEWSMenuEntry_Context() {
        return (EAttribute)ewsMenuEntryEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEWSMenuEntry_Icon() {
        return (EAttribute)ewsMenuEntryEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEWSMenuEntry_Descriptions() {
        return (EReference)ewsMenuEntryEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEWSMenuEntry_SubMenus() {
        return (EReference)ewsMenuEntryEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSMenuMenuEntriesDescriptionsE() {
        return wsMenuMenuEntriesDescriptionsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSMenuMenuEntriesDescriptionsE_Language() {
        return (EAttribute)wsMenuMenuEntriesDescriptionsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSMenuMenuEntriesDescriptionsE_Label() {
        return (EAttribute)wsMenuMenuEntriesDescriptionsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSRoleE() {
        return wsRoleEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSRoleE_Specification() {
        return (EReference)wsRoleEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSRoleSpecificationE() {
        return wsRoleSpecificationEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoleSpecificationE_Admin() {
        return (EAttribute)wsRoleSpecificationEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoleSpecificationE_ObjectType() {
        return (EAttribute)wsRoleSpecificationEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSRoleSpecificationE_Instance() {
        return (EReference)wsRoleSpecificationEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSRoleSpecificationInstanceE() {
        return wsRoleSpecificationInstanceEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoleSpecificationInstanceE_InstanceName() {
        return (EAttribute)wsRoleSpecificationInstanceEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoleSpecificationInstanceE_Writable() {
        return (EAttribute)wsRoleSpecificationInstanceEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoleSpecificationInstanceE_Parameter() {
        return (EAttribute)wsRoleSpecificationInstanceEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getStringArray() {
        return stringArrayEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmserverobjectFactory getMdmserverobjectFactory() {
        return (MdmserverobjectFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        mdmServerObjectEClass = createEClass(MDM_SERVER_OBJECT);
        createEAttribute(mdmServerObjectEClass, MDM_SERVER_OBJECT__NAME);
        createEAttribute(mdmServerObjectEClass, MDM_SERVER_OBJECT__DESCRIPTION);

        ewsMenuEClass = createEClass(EWS_MENU);
        createEReference(ewsMenuEClass, EWS_MENU__MENU_ENTRIES);

        ewsMenuEntryEClass = createEClass(EWS_MENU_ENTRY);
        createEAttribute(ewsMenuEntryEClass, EWS_MENU_ENTRY__ID);
        createEAttribute(ewsMenuEntryEClass, EWS_MENU_ENTRY__APPLICATION);
        createEAttribute(ewsMenuEntryEClass, EWS_MENU_ENTRY__CONTEXT);
        createEAttribute(ewsMenuEntryEClass, EWS_MENU_ENTRY__ICON);
        createEReference(ewsMenuEntryEClass, EWS_MENU_ENTRY__DESCRIPTIONS);
        createEReference(ewsMenuEntryEClass, EWS_MENU_ENTRY__SUB_MENUS);

        wsMenuMenuEntriesDescriptionsEEClass = createEClass(WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E);
        createEAttribute(wsMenuMenuEntriesDescriptionsEEClass, WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LANGUAGE);
        createEAttribute(wsMenuMenuEntriesDescriptionsEEClass, WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LABEL);

        wsRoleEEClass = createEClass(WS_ROLE_E);
        createEReference(wsRoleEEClass, WS_ROLE_E__SPECIFICATION);

        wsRoleSpecificationEEClass = createEClass(WS_ROLE_SPECIFICATION_E);
        createEAttribute(wsRoleSpecificationEEClass, WS_ROLE_SPECIFICATION_E__ADMIN);
        createEAttribute(wsRoleSpecificationEEClass, WS_ROLE_SPECIFICATION_E__OBJECT_TYPE);
        createEReference(wsRoleSpecificationEEClass, WS_ROLE_SPECIFICATION_E__INSTANCE);

        wsRoleSpecificationInstanceEEClass = createEClass(WS_ROLE_SPECIFICATION_INSTANCE_E);
        createEAttribute(wsRoleSpecificationInstanceEEClass, WS_ROLE_SPECIFICATION_INSTANCE_E__INSTANCE_NAME);
        createEAttribute(wsRoleSpecificationInstanceEEClass, WS_ROLE_SPECIFICATION_INSTANCE_E__WRITABLE);
        createEAttribute(wsRoleSpecificationInstanceEEClass, WS_ROLE_SPECIFICATION_INSTANCE_E__PARAMETER);

        // Create data types
        stringArrayEDataType = createEDataType(STRING_ARRAY);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        ewsMenuEClass.getESuperTypes().add(this.getMDMServerObject());
        wsRoleEEClass.getESuperTypes().add(this.getMDMServerObject());

        // Initialize classes and features; add operations and parameters
        initEClass(mdmServerObjectEClass, MDMServerObject.class, "MDMServerObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMDMServerObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_Description(), ecorePackage.getEString(), "description", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(ewsMenuEClass, EWSMenu.class, "EWSMenu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEWSMenu_MenuEntries(), this.getEWSMenuEntry(), null, "menuEntries", null, 0, -1, EWSMenu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(ewsMenuEntryEClass, EWSMenuEntry.class, "EWSMenuEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEWSMenuEntry_Id(), ecorePackage.getEString(), "id", null, 0, 1, EWSMenuEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEWSMenuEntry_Application(), ecorePackage.getEString(), "application", null, 0, 1, EWSMenuEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEWSMenuEntry_Context(), ecorePackage.getEString(), "context", null, 0, 1, EWSMenuEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEWSMenuEntry_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, EWSMenuEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEWSMenuEntry_Descriptions(), this.getWSMenuMenuEntriesDescriptionsE(), null, "descriptions", null, 0, -1, EWSMenuEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEWSMenuEntry_SubMenus(), this.getEWSMenuEntry(), null, "subMenus", null, 0, -1, EWSMenuEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsMenuMenuEntriesDescriptionsEEClass, WSMenuMenuEntriesDescriptionsE.class, "WSMenuMenuEntriesDescriptionsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSMenuMenuEntriesDescriptionsE_Language(), ecorePackage.getEString(), "language", null, 0, 1, WSMenuMenuEntriesDescriptionsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSMenuMenuEntriesDescriptionsE_Label(), ecorePackage.getEString(), "label", null, 0, 1, WSMenuMenuEntriesDescriptionsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoleEEClass, WSRoleE.class, "WSRoleE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSRoleE_Specification(), this.getWSRoleSpecificationE(), null, "specification", null, 0, -1, WSRoleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoleSpecificationEEClass, WSRoleSpecificationE.class, "WSRoleSpecificationE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSRoleSpecificationE_Admin(), ecorePackage.getEBoolean(), "admin", null, 0, 1, WSRoleSpecificationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoleSpecificationE_ObjectType(), ecorePackage.getEString(), "objectType", null, 0, 1, WSRoleSpecificationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSRoleSpecificationE_Instance(), this.getWSRoleSpecificationInstanceE(), null, "instance", null, 0, -1, WSRoleSpecificationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoleSpecificationInstanceEEClass, WSRoleSpecificationInstanceE.class, "WSRoleSpecificationInstanceE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSRoleSpecificationInstanceE_InstanceName(), ecorePackage.getEString(), "instanceName", null, 0, 1, WSRoleSpecificationInstanceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoleSpecificationInstanceE_Writable(), ecorePackage.getEBoolean(), "writable", null, 0, 1, WSRoleSpecificationInstanceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoleSpecificationInstanceE_Parameter(), this.getStringArray(), "parameter", null, 0, 1, WSRoleSpecificationInstanceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize data types
        initEDataType(stringArrayEDataType, String[].class, "StringArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //MdmserverobjectPackageImpl
