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

import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage;
import org.talend.mdm.repository.model.mdmserverobject.CustomForm;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmserverobject.EWSMenu;
import org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSBooleanE;
import org.talend.mdm.repository.model.mdmserverobject.WSByteArrayE;
import org.talend.mdm.repository.model.mdmserverobject.WSDataClusterE;
import org.talend.mdm.repository.model.mdmserverobject.WSDataModelE;
import org.talend.mdm.repository.model.mdmserverobject.WSEventManagerE;
import org.talend.mdm.repository.model.mdmserverobject.WSJobModelE;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuE;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE;
import org.talend.mdm.repository.model.mdmserverobject.WSResourceE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleExpressionE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleExpression;
import org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleOperatorE;
import org.talend.mdm.repository.model.mdmserverobject.WSServiceConfigurationE;
import org.talend.mdm.repository.model.mdmserverobject.WSServicePutConfigurationE;
import org.talend.mdm.repository.model.mdmserverobject.WSStoredProcedureE;
import org.talend.mdm.repository.model.mdmserverobject.WSStringPredicateE;
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanE;
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanItemsSynchronizationsE;
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsE;
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerV2E;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE;
import org.talend.mdm.repository.model.mdmserverobject.WSTypedContentE;
import org.talend.mdm.repository.model.mdmserverobject.WSUniverseE;
import org.talend.mdm.repository.model.mdmserverobject.WSUniverseItemsRevisionIDsE;
import org.talend.mdm.repository.model.mdmserverobject.WSUniverseXtentisObjectsRevisionIDsE;
import org.talend.mdm.repository.model.mdmserverobject.WSViewE;
import org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE;
import org.talend.mdm.repository.model.mdmserverobject.WSWhereOperatorE;
import org.talend.mdm.repository.model.mdmserverobject.WSWorkflowDeployE;
import org.talend.mdm.repository.model.mdmserverobject.WSWorkflowE;

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
    private EClass wsMenuEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsMenuEntryEEClass = null;

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
    private EClass wsViewEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsWhereConditionEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsWhereOperatorEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsStringPredicateEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsDataModelEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsDataClusterEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsStoredProcedureEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsUniverseEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsUniverseXtentisObjectsRevisionIDsEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsUniverseItemsRevisionIDsEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsSynchronizationPlanEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsSynchronizationPlanItemsSynchronizationsEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsBooleanEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsWorkflowDeployEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsTransformerV2EEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsTransformerProcessStepEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsTransformerVariablesMappingEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsTypedContentEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsByteArrayEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsRoutingRuleEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsRoutingRuleExpressionEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsRoutingRuleOperatorEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsJobModelEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsEventManagerEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsServiceConfigurationEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsServicePutConfigurationEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsWorkflowEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsResourceEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass customFormEClass = null;

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

        // Initialize simple dependencies
        MdmmetadataPackage.eINSTANCE.eClass();

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
    public EAttribute getMDMServerObject_System() {
        return (EAttribute)mdmServerObjectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMDMServerObject_LastServerDef() {
        return (EReference)mdmServerObjectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMDMServerObject_Type() {
        return (EAttribute)mdmServerObjectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMDMServerObject_Changed() {
        return (EAttribute)mdmServerObjectEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSMenuE() {
        return wsMenuEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSMenuE_MenuEntries() {
        return (EReference)wsMenuEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSMenuEntryE() {
        return wsMenuEntryEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSMenuEntryE_Id() {
        return (EAttribute)wsMenuEntryEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSMenuEntryE_Application() {
        return (EAttribute)wsMenuEntryEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSMenuEntryE_Context() {
        return (EAttribute)wsMenuEntryEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSMenuEntryE_Icon() {
        return (EAttribute)wsMenuEntryEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSMenuEntryE_Descriptions() {
        return (EReference)wsMenuEntryEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSMenuEntryE_SubMenus() {
        return (EReference)wsMenuEntryEEClass.getEStructuralFeatures().get(5);
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
    public EClass getWSViewE() {
        return wsViewEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSViewE_SearchableBusinessElements() {
        return (EAttribute)wsViewEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSViewE_ViewableBusinessElements() {
        return (EAttribute)wsViewEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSViewE_TransformerActive() {
        return (EAttribute)wsViewEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSViewE_WhereConditions() {
        return (EReference)wsViewEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSViewE_IsTransformerActive() {
        return (EReference)wsViewEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSViewE_TransformerPK() {
        return (EAttribute)wsViewEEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSWhereConditionE() {
        return wsWhereConditionEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSWhereConditionE_LeftPath() {
        return (EAttribute)wsWhereConditionEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSWhereConditionE_RightValueOrPath() {
        return (EAttribute)wsWhereConditionEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSWhereConditionE_StringPredicate() {
        return (EReference)wsWhereConditionEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSWhereConditionE_Operator() {
        return (EReference)wsWhereConditionEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSWhereConditionE_SpellCheck() {
        return (EAttribute)wsWhereConditionEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSWhereOperatorE() {
        return wsWhereOperatorEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSWhereOperatorE_Value() {
        return (EAttribute)wsWhereOperatorEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSStringPredicateE() {
        return wsStringPredicateEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSStringPredicateE_Value() {
        return (EAttribute)wsStringPredicateEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSDataModelE() {
        return wsDataModelEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSDataModelE_XsdSchema() {
        return (EAttribute)wsDataModelEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSDataClusterE() {
        return wsDataClusterEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSDataClusterE_Vocabulary() {
        return (EAttribute)wsDataClusterEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSStoredProcedureE() {
        return wsStoredProcedureEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSStoredProcedureE_Procedure() {
        return (EAttribute)wsStoredProcedureEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSStoredProcedureE_RefreshCache() {
        return (EAttribute)wsStoredProcedureEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSUniverseE() {
        return wsUniverseEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSUniverseE_DefaultItemsRevisionID() {
        return (EAttribute)wsUniverseEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSUniverseE_XtentisObjectsRevisionIDs() {
        return (EReference)wsUniverseEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSUniverseE_ItemsRevisionIDs() {
        return (EReference)wsUniverseEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSUniverseXtentisObjectsRevisionIDsE() {
        return wsUniverseXtentisObjectsRevisionIDsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSUniverseXtentisObjectsRevisionIDsE_XtentisObjectName() {
        return (EAttribute)wsUniverseXtentisObjectsRevisionIDsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSUniverseXtentisObjectsRevisionIDsE_RevisionID() {
        return (EAttribute)wsUniverseXtentisObjectsRevisionIDsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSUniverseItemsRevisionIDsE() {
        return wsUniverseItemsRevisionIDsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSUniverseItemsRevisionIDsE_ConceptPattern() {
        return (EAttribute)wsUniverseItemsRevisionIDsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSUniverseItemsRevisionIDsE_RevisionID() {
        return (EAttribute)wsUniverseItemsRevisionIDsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSSynchronizationPlanE() {
        return wsSynchronizationPlanEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanE_RemoteSystemName() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanE_RemoteSystemURL() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanE_RemoteSystemUsername() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanE_RemoteSystemPassword() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanE_TisURL() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanE_TisUsername() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanE_TisPassword() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanE_TisParameters() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSSynchronizationPlanE_XtentisObjectsSynchronizations() {
        return (EReference)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSSynchronizationPlanE_ItemsSynchronizations() {
        return (EReference)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSSynchronizationPlanItemsSynchronizationsE() {
        return wsSynchronizationPlanItemsSynchronizationsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanItemsSynchronizationsE_ConceptName() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanItemsSynchronizationsE_IdsPattern() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanItemsSynchronizationsE_LocalCluster() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanItemsSynchronizationsE_LocalRevisionID() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanItemsSynchronizationsE_RemoteCluster() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanItemsSynchronizationsE_RemoteRevisionID() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanItemsSynchronizationsE_Algorithm() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSSynchronizationPlanXtentisObjectsSynchronizationsE() {
        return wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanXtentisObjectsSynchronizationsE_XtentisObjectName() {
        return (EAttribute)wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSSynchronizationPlanXtentisObjectsSynchronizationsE_Synchronizations() {
        return (EReference)wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE() {
        return wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_InstancePattern() {
        return (EAttribute)wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_LocalRevisionID() {
        return (EAttribute)wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_RemoteRevisionID() {
        return (EAttribute)wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_Algorithm() {
        return (EAttribute)wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSBooleanE() {
        return wsBooleanEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSBooleanE__true() {
        return (EAttribute)wsBooleanEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSWorkflowDeployE() {
        return wsWorkflowDeployEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSWorkflowDeployE_Filename() {
        return (EAttribute)wsWorkflowDeployEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSTransformerV2E() {
        return wsTransformerV2EEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSTransformerV2E_ProcessSteps() {
        return (EReference)wsTransformerV2EEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSTransformerProcessStepE() {
        return wsTransformerProcessStepEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSTransformerProcessStepE_PluginJNDI() {
        return (EAttribute)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSTransformerProcessStepE_Description() {
        return (EAttribute)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSTransformerProcessStepE_Parameters() {
        return (EAttribute)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSTransformerProcessStepE_Disabled() {
        return (EAttribute)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSTransformerProcessStepE_InputMappings() {
        return (EReference)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSTransformerProcessStepE_OutputMappings() {
        return (EReference)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSTransformerVariablesMappingE() {
        return wsTransformerVariablesMappingEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSTransformerVariablesMappingE_PipelineVariable() {
        return (EAttribute)wsTransformerVariablesMappingEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSTransformerVariablesMappingE_PluginVariable() {
        return (EAttribute)wsTransformerVariablesMappingEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSTransformerVariablesMappingE_HardCoding() {
        return (EReference)wsTransformerVariablesMappingEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSTypedContentE() {
        return wsTypedContentEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSTypedContentE_Url() {
        return (EAttribute)wsTypedContentEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSTypedContentE_ContentType() {
        return (EAttribute)wsTypedContentEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSTypedContentE_WsBytes() {
        return (EReference)wsTypedContentEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSByteArrayE() {
        return wsByteArrayEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSByteArrayE_Bytes() {
        return (EAttribute)wsByteArrayEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSRoutingRuleE() {
        return wsRoutingRuleEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoutingRuleE_Synchronous() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoutingRuleE_Concept() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoutingRuleE_ServiceJNDI() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoutingRuleE_Parameters() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoutingRuleE_Condition() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoutingRuleE_Deactive() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSRoutingRuleE_WsRoutingRuleExpressions() {
        return (EReference)wsRoutingRuleEEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSRoutingRuleExpressionE() {
        return wsRoutingRuleExpressionEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoutingRuleExpressionE_Name() {
        return (EAttribute)wsRoutingRuleExpressionEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoutingRuleExpressionE_Xpath() {
        return (EAttribute)wsRoutingRuleExpressionEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoutingRuleExpressionE_Value() {
        return (EAttribute)wsRoutingRuleExpressionEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSRoutingRuleExpressionE_WsOperator() {
        return (EReference)wsRoutingRuleExpressionEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSRoutingRuleOperatorE() {
        return wsRoutingRuleOperatorEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSRoutingRuleOperatorE_Value() {
        return (EAttribute)wsRoutingRuleOperatorEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSJobModelE() {
        return wsJobModelEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSEventManagerE() {
        return wsEventManagerEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSServiceConfigurationE() {
        return wsServiceConfigurationEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWSServiceConfigurationE_ServicePutConfigurations() {
        return (EReference)wsServiceConfigurationEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSServicePutConfigurationE() {
        return wsServicePutConfigurationEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSServicePutConfigurationE_JndiName() {
        return (EAttribute)wsServicePutConfigurationEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSServicePutConfigurationE_Configuration() {
        return (EAttribute)wsServicePutConfigurationEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSWorkflowE() {
        return wsWorkflowEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWSResourceE() {
        return wsResourceEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSResourceE_FileExtension() {
        return (EAttribute)wsResourceEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWSResourceE_FileContent() {
        return (EAttribute)wsResourceEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCustomForm() {
        return customFormEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCustomForm_Filename() {
        return (EAttribute)customFormEClass.getEStructuralFeatures().get(0);
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
        createEAttribute(mdmServerObjectEClass, MDM_SERVER_OBJECT__SYSTEM);
        createEReference(mdmServerObjectEClass, MDM_SERVER_OBJECT__LAST_SERVER_DEF);
        createEAttribute(mdmServerObjectEClass, MDM_SERVER_OBJECT__TYPE);
        createEAttribute(mdmServerObjectEClass, MDM_SERVER_OBJECT__CHANGED);

        wsMenuEEClass = createEClass(WS_MENU_E);
        createEReference(wsMenuEEClass, WS_MENU_E__MENU_ENTRIES);

        wsMenuEntryEEClass = createEClass(WS_MENU_ENTRY_E);
        createEAttribute(wsMenuEntryEEClass, WS_MENU_ENTRY_E__ID);
        createEAttribute(wsMenuEntryEEClass, WS_MENU_ENTRY_E__APPLICATION);
        createEAttribute(wsMenuEntryEEClass, WS_MENU_ENTRY_E__CONTEXT);
        createEAttribute(wsMenuEntryEEClass, WS_MENU_ENTRY_E__ICON);
        createEReference(wsMenuEntryEEClass, WS_MENU_ENTRY_E__DESCRIPTIONS);
        createEReference(wsMenuEntryEEClass, WS_MENU_ENTRY_E__SUB_MENUS);

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

        wsViewEEClass = createEClass(WS_VIEW_E);
        createEAttribute(wsViewEEClass, WS_VIEW_E__SEARCHABLE_BUSINESS_ELEMENTS);
        createEAttribute(wsViewEEClass, WS_VIEW_E__VIEWABLE_BUSINESS_ELEMENTS);
        createEAttribute(wsViewEEClass, WS_VIEW_E__TRANSFORMER_ACTIVE);
        createEReference(wsViewEEClass, WS_VIEW_E__WHERE_CONDITIONS);
        createEReference(wsViewEEClass, WS_VIEW_E__IS_TRANSFORMER_ACTIVE);
        createEAttribute(wsViewEEClass, WS_VIEW_E__TRANSFORMER_PK);

        wsWhereConditionEEClass = createEClass(WS_WHERE_CONDITION_E);
        createEAttribute(wsWhereConditionEEClass, WS_WHERE_CONDITION_E__LEFT_PATH);
        createEAttribute(wsWhereConditionEEClass, WS_WHERE_CONDITION_E__RIGHT_VALUE_OR_PATH);
        createEReference(wsWhereConditionEEClass, WS_WHERE_CONDITION_E__STRING_PREDICATE);
        createEReference(wsWhereConditionEEClass, WS_WHERE_CONDITION_E__OPERATOR);
        createEAttribute(wsWhereConditionEEClass, WS_WHERE_CONDITION_E__SPELL_CHECK);

        wsWhereOperatorEEClass = createEClass(WS_WHERE_OPERATOR_E);
        createEAttribute(wsWhereOperatorEEClass, WS_WHERE_OPERATOR_E__VALUE);

        wsStringPredicateEEClass = createEClass(WS_STRING_PREDICATE_E);
        createEAttribute(wsStringPredicateEEClass, WS_STRING_PREDICATE_E__VALUE);

        wsDataModelEEClass = createEClass(WS_DATA_MODEL_E);
        createEAttribute(wsDataModelEEClass, WS_DATA_MODEL_E__XSD_SCHEMA);

        wsDataClusterEEClass = createEClass(WS_DATA_CLUSTER_E);
        createEAttribute(wsDataClusterEEClass, WS_DATA_CLUSTER_E__VOCABULARY);

        wsStoredProcedureEEClass = createEClass(WS_STORED_PROCEDURE_E);
        createEAttribute(wsStoredProcedureEEClass, WS_STORED_PROCEDURE_E__PROCEDURE);
        createEAttribute(wsStoredProcedureEEClass, WS_STORED_PROCEDURE_E__REFRESH_CACHE);

        wsUniverseEEClass = createEClass(WS_UNIVERSE_E);
        createEAttribute(wsUniverseEEClass, WS_UNIVERSE_E__DEFAULT_ITEMS_REVISION_ID);
        createEReference(wsUniverseEEClass, WS_UNIVERSE_E__XTENTIS_OBJECTS_REVISION_IDS);
        createEReference(wsUniverseEEClass, WS_UNIVERSE_E__ITEMS_REVISION_IDS);

        wsUniverseXtentisObjectsRevisionIDsEEClass = createEClass(WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E);
        createEAttribute(wsUniverseXtentisObjectsRevisionIDsEEClass, WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__XTENTIS_OBJECT_NAME);
        createEAttribute(wsUniverseXtentisObjectsRevisionIDsEEClass, WS_UNIVERSE_XTENTIS_OBJECTS_REVISION_IDS_E__REVISION_ID);

        wsUniverseItemsRevisionIDsEEClass = createEClass(WS_UNIVERSE_ITEMS_REVISION_IDS_E);
        createEAttribute(wsUniverseItemsRevisionIDsEEClass, WS_UNIVERSE_ITEMS_REVISION_IDS_E__CONCEPT_PATTERN);
        createEAttribute(wsUniverseItemsRevisionIDsEEClass, WS_UNIVERSE_ITEMS_REVISION_IDS_E__REVISION_ID);

        wsSynchronizationPlanEEClass = createEClass(WS_SYNCHRONIZATION_PLAN_E);
        createEAttribute(wsSynchronizationPlanEEClass, WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_NAME);
        createEAttribute(wsSynchronizationPlanEEClass, WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_URL);
        createEAttribute(wsSynchronizationPlanEEClass, WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_USERNAME);
        createEAttribute(wsSynchronizationPlanEEClass, WS_SYNCHRONIZATION_PLAN_E__REMOTE_SYSTEM_PASSWORD);
        createEAttribute(wsSynchronizationPlanEEClass, WS_SYNCHRONIZATION_PLAN_E__TIS_URL);
        createEAttribute(wsSynchronizationPlanEEClass, WS_SYNCHRONIZATION_PLAN_E__TIS_USERNAME);
        createEAttribute(wsSynchronizationPlanEEClass, WS_SYNCHRONIZATION_PLAN_E__TIS_PASSWORD);
        createEAttribute(wsSynchronizationPlanEEClass, WS_SYNCHRONIZATION_PLAN_E__TIS_PARAMETERS);
        createEReference(wsSynchronizationPlanEEClass, WS_SYNCHRONIZATION_PLAN_E__XTENTIS_OBJECTS_SYNCHRONIZATIONS);
        createEReference(wsSynchronizationPlanEEClass, WS_SYNCHRONIZATION_PLAN_E__ITEMS_SYNCHRONIZATIONS);

        wsSynchronizationPlanItemsSynchronizationsEEClass = createEClass(WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E);
        createEAttribute(wsSynchronizationPlanItemsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__CONCEPT_NAME);
        createEAttribute(wsSynchronizationPlanItemsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__IDS_PATTERN);
        createEAttribute(wsSynchronizationPlanItemsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_CLUSTER);
        createEAttribute(wsSynchronizationPlanItemsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID);
        createEAttribute(wsSynchronizationPlanItemsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_CLUSTER);
        createEAttribute(wsSynchronizationPlanItemsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID);
        createEAttribute(wsSynchronizationPlanItemsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_ITEMS_SYNCHRONIZATIONS_E__ALGORITHM);

        wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass = createEClass(WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E);
        createEAttribute(wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__XTENTIS_OBJECT_NAME);
        createEReference(wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_E__SYNCHRONIZATIONS);

        wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass = createEClass(WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E);
        createEAttribute(wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__INSTANCE_PATTERN);
        createEAttribute(wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__LOCAL_REVISION_ID);
        createEAttribute(wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__REMOTE_REVISION_ID);
        createEAttribute(wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass, WS_SYNCHRONIZATION_PLAN_XTENTIS_OBJECTS_SYNCHRONIZATIONS_SYNCHRONIZATIONS_E__ALGORITHM);

        wsBooleanEEClass = createEClass(WS_BOOLEAN_E);
        createEAttribute(wsBooleanEEClass, WS_BOOLEAN_E__TRUE);

        wsWorkflowDeployEEClass = createEClass(WS_WORKFLOW_DEPLOY_E);
        createEAttribute(wsWorkflowDeployEEClass, WS_WORKFLOW_DEPLOY_E__FILENAME);

        wsTransformerV2EEClass = createEClass(WS_TRANSFORMER_V2E);
        createEReference(wsTransformerV2EEClass, WS_TRANSFORMER_V2E__PROCESS_STEPS);

        wsTransformerProcessStepEEClass = createEClass(WS_TRANSFORMER_PROCESS_STEP_E);
        createEAttribute(wsTransformerProcessStepEEClass, WS_TRANSFORMER_PROCESS_STEP_E__PLUGIN_JNDI);
        createEAttribute(wsTransformerProcessStepEEClass, WS_TRANSFORMER_PROCESS_STEP_E__DESCRIPTION);
        createEAttribute(wsTransformerProcessStepEEClass, WS_TRANSFORMER_PROCESS_STEP_E__PARAMETERS);
        createEAttribute(wsTransformerProcessStepEEClass, WS_TRANSFORMER_PROCESS_STEP_E__DISABLED);
        createEReference(wsTransformerProcessStepEEClass, WS_TRANSFORMER_PROCESS_STEP_E__INPUT_MAPPINGS);
        createEReference(wsTransformerProcessStepEEClass, WS_TRANSFORMER_PROCESS_STEP_E__OUTPUT_MAPPINGS);

        wsTransformerVariablesMappingEEClass = createEClass(WS_TRANSFORMER_VARIABLES_MAPPING_E);
        createEAttribute(wsTransformerVariablesMappingEEClass, WS_TRANSFORMER_VARIABLES_MAPPING_E__PIPELINE_VARIABLE);
        createEAttribute(wsTransformerVariablesMappingEEClass, WS_TRANSFORMER_VARIABLES_MAPPING_E__PLUGIN_VARIABLE);
        createEReference(wsTransformerVariablesMappingEEClass, WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING);

        wsTypedContentEEClass = createEClass(WS_TYPED_CONTENT_E);
        createEAttribute(wsTypedContentEEClass, WS_TYPED_CONTENT_E__URL);
        createEAttribute(wsTypedContentEEClass, WS_TYPED_CONTENT_E__CONTENT_TYPE);
        createEReference(wsTypedContentEEClass, WS_TYPED_CONTENT_E__WS_BYTES);

        wsByteArrayEEClass = createEClass(WS_BYTE_ARRAY_E);
        createEAttribute(wsByteArrayEEClass, WS_BYTE_ARRAY_E__BYTES);

        wsRoutingRuleEEClass = createEClass(WS_ROUTING_RULE_E);
        createEAttribute(wsRoutingRuleEEClass, WS_ROUTING_RULE_E__SYNCHRONOUS);
        createEAttribute(wsRoutingRuleEEClass, WS_ROUTING_RULE_E__CONCEPT);
        createEAttribute(wsRoutingRuleEEClass, WS_ROUTING_RULE_E__SERVICE_JNDI);
        createEAttribute(wsRoutingRuleEEClass, WS_ROUTING_RULE_E__PARAMETERS);
        createEAttribute(wsRoutingRuleEEClass, WS_ROUTING_RULE_E__CONDITION);
        createEAttribute(wsRoutingRuleEEClass, WS_ROUTING_RULE_E__DEACTIVE);
        createEReference(wsRoutingRuleEEClass, WS_ROUTING_RULE_E__WS_ROUTING_RULE_EXPRESSIONS);

        wsRoutingRuleExpressionEEClass = createEClass(WS_ROUTING_RULE_EXPRESSION_E);
        createEAttribute(wsRoutingRuleExpressionEEClass, WS_ROUTING_RULE_EXPRESSION_E__NAME);
        createEAttribute(wsRoutingRuleExpressionEEClass, WS_ROUTING_RULE_EXPRESSION_E__XPATH);
        createEAttribute(wsRoutingRuleExpressionEEClass, WS_ROUTING_RULE_EXPRESSION_E__VALUE);
        createEReference(wsRoutingRuleExpressionEEClass, WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR);

        wsRoutingRuleOperatorEEClass = createEClass(WS_ROUTING_RULE_OPERATOR_E);
        createEAttribute(wsRoutingRuleOperatorEEClass, WS_ROUTING_RULE_OPERATOR_E__VALUE);

        wsJobModelEEClass = createEClass(WS_JOB_MODEL_E);

        wsEventManagerEEClass = createEClass(WS_EVENT_MANAGER_E);

        wsServiceConfigurationEEClass = createEClass(WS_SERVICE_CONFIGURATION_E);
        createEReference(wsServiceConfigurationEEClass, WS_SERVICE_CONFIGURATION_E__SERVICE_PUT_CONFIGURATIONS);

        wsServicePutConfigurationEEClass = createEClass(WS_SERVICE_PUT_CONFIGURATION_E);
        createEAttribute(wsServicePutConfigurationEEClass, WS_SERVICE_PUT_CONFIGURATION_E__JNDI_NAME);
        createEAttribute(wsServicePutConfigurationEEClass, WS_SERVICE_PUT_CONFIGURATION_E__CONFIGURATION);

        wsWorkflowEEClass = createEClass(WS_WORKFLOW_E);

        wsResourceEEClass = createEClass(WS_RESOURCE_E);
        createEAttribute(wsResourceEEClass, WS_RESOURCE_E__FILE_EXTENSION);
        createEAttribute(wsResourceEEClass, WS_RESOURCE_E__FILE_CONTENT);

        customFormEClass = createEClass(CUSTOM_FORM);
        createEAttribute(customFormEClass, CUSTOM_FORM__FILENAME);
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

        // Obtain other dependent packages
        MdmmetadataPackage theMdmmetadataPackage = (MdmmetadataPackage)EPackage.Registry.INSTANCE.getEPackage(MdmmetadataPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        wsMenuEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsRoleEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsViewEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsDataModelEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsDataClusterEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsStoredProcedureEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsUniverseEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsSynchronizationPlanEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsWorkflowDeployEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsTransformerV2EEClass.getESuperTypes().add(this.getMDMServerObject());
        wsRoutingRuleEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsJobModelEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsEventManagerEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsServiceConfigurationEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsWorkflowEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsResourceEEClass.getESuperTypes().add(this.getMDMServerObject());
        customFormEClass.getESuperTypes().add(this.getMDMServerObject());

        // Initialize classes and features; add operations and parameters
        initEClass(mdmServerObjectEClass, MDMServerObject.class, "MDMServerObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMDMServerObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_Description(), ecorePackage.getEString(), "description", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_System(), ecorePackage.getEBoolean(), "system", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMDMServerObject_LastServerDef(), theMdmmetadataPackage.getMDMServerDef(), null, "lastServerDef", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_Type(), ecorePackage.getEInt(), "type", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_Changed(), ecorePackage.getEBoolean(), "changed", null, 0, 1, MDMServerObject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(mdmServerObjectEClass, ecorePackage.getEString(), "getUniqueName", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(wsMenuEEClass, WSMenuE.class, "WSMenuE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSMenuE_MenuEntries(), this.getWSMenuEntryE(), null, "menuEntries", null, 0, -1, WSMenuE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsMenuEntryEEClass, WSMenuEntryE.class, "WSMenuEntryE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSMenuEntryE_Id(), ecorePackage.getEString(), "id", null, 0, 1, WSMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSMenuEntryE_Application(), ecorePackage.getEString(), "application", null, 0, 1, WSMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSMenuEntryE_Context(), ecorePackage.getEString(), "context", null, 0, 1, WSMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSMenuEntryE_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, WSMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSMenuEntryE_Descriptions(), this.getWSMenuMenuEntriesDescriptionsE(), null, "descriptions", null, 0, -1, WSMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSMenuEntryE_SubMenus(), this.getWSMenuEntryE(), null, "subMenus", null, 0, -1, WSMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsMenuMenuEntriesDescriptionsEEClass, WSMenuMenuEntriesDescriptionsE.class, "WSMenuMenuEntriesDescriptionsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSMenuMenuEntriesDescriptionsE_Language(), ecorePackage.getEString(), "language", null, 0, 1, WSMenuMenuEntriesDescriptionsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSMenuMenuEntriesDescriptionsE_Label(), ecorePackage.getEString(), "label", null, 0, 1, WSMenuMenuEntriesDescriptionsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoleEEClass, WSRoleE.class, "WSRoleE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSRoleE_Specification(), this.getWSRoleSpecificationE(), null, "specification", null, 0, -1, WSRoleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoleSpecificationEEClass, WSRoleSpecificationE.class, "WSRoleSpecificationE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSRoleSpecificationE_Admin(), ecorePackage.getEBoolean(), "admin", null, 0, 1, WSRoleSpecificationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoleSpecificationE_ObjectType(), ecorePackage.getEString(), "objectType", null, 0, 1, WSRoleSpecificationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSRoleSpecificationE_Instance(), this.getWSRoleSpecificationInstanceE(), null, "instance", null, 0, -1, WSRoleSpecificationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoleSpecificationInstanceEEClass, WSRoleSpecificationInstanceE.class, "WSRoleSpecificationInstanceE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSRoleSpecificationInstanceE_InstanceName(), ecorePackage.getEString(), "instanceName", null, 0, 1, WSRoleSpecificationInstanceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoleSpecificationInstanceE_Writable(), ecorePackage.getEBoolean(), "writable", null, 0, 1, WSRoleSpecificationInstanceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoleSpecificationInstanceE_Parameter(), ecorePackage.getEString(), "parameter", null, 0, -1, WSRoleSpecificationInstanceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsViewEEClass, WSViewE.class, "WSViewE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSViewE_SearchableBusinessElements(), ecorePackage.getEString(), "searchableBusinessElements", null, 0, -1, WSViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSViewE_ViewableBusinessElements(), ecorePackage.getEString(), "viewableBusinessElements", null, 0, -1, WSViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSViewE_TransformerActive(), ecorePackage.getEBoolean(), "transformerActive", null, 0, 1, WSViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSViewE_WhereConditions(), this.getWSWhereConditionE(), null, "whereConditions", null, 0, -1, WSViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSViewE_IsTransformerActive(), this.getWSBooleanE(), null, "isTransformerActive", null, 0, 1, WSViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSViewE_TransformerPK(), ecorePackage.getEString(), "transformerPK", null, 0, 1, WSViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsWhereConditionEEClass, WSWhereConditionE.class, "WSWhereConditionE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSWhereConditionE_LeftPath(), ecorePackage.getEString(), "leftPath", null, 0, 1, WSWhereConditionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSWhereConditionE_RightValueOrPath(), ecorePackage.getEString(), "rightValueOrPath", null, 0, 1, WSWhereConditionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSWhereConditionE_StringPredicate(), this.getWSStringPredicateE(), null, "stringPredicate", null, 0, 1, WSWhereConditionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSWhereConditionE_Operator(), this.getWSWhereOperatorE(), null, "operator", null, 0, 1, WSWhereConditionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSWhereConditionE_SpellCheck(), ecorePackage.getEBoolean(), "spellCheck", null, 0, 1, WSWhereConditionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsWhereOperatorEEClass, WSWhereOperatorE.class, "WSWhereOperatorE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSWhereOperatorE_Value(), ecorePackage.getEString(), "value", null, 0, 1, WSWhereOperatorE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsStringPredicateEEClass, WSStringPredicateE.class, "WSStringPredicateE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSStringPredicateE_Value(), ecorePackage.getEString(), "value", null, 0, 1, WSStringPredicateE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsDataModelEEClass, WSDataModelE.class, "WSDataModelE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSDataModelE_XsdSchema(), ecorePackage.getEString(), "xsdSchema", null, 0, 1, WSDataModelE.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsDataClusterEEClass, WSDataClusterE.class, "WSDataClusterE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSDataClusterE_Vocabulary(), ecorePackage.getEString(), "vocabulary", null, 0, 1, WSDataClusterE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsStoredProcedureEEClass, WSStoredProcedureE.class, "WSStoredProcedureE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSStoredProcedureE_Procedure(), ecorePackage.getEString(), "procedure", null, 0, 1, WSStoredProcedureE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSStoredProcedureE_RefreshCache(), ecorePackage.getEBoolean(), "refreshCache", null, 0, 1, WSStoredProcedureE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsUniverseEEClass, WSUniverseE.class, "WSUniverseE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSUniverseE_DefaultItemsRevisionID(), ecorePackage.getEString(), "defaultItemsRevisionID", null, 0, 1, WSUniverseE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSUniverseE_XtentisObjectsRevisionIDs(), this.getWSUniverseXtentisObjectsRevisionIDsE(), null, "xtentisObjectsRevisionIDs", null, 0, -1, WSUniverseE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSUniverseE_ItemsRevisionIDs(), this.getWSUniverseItemsRevisionIDsE(), null, "itemsRevisionIDs", null, 0, -1, WSUniverseE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsUniverseXtentisObjectsRevisionIDsEEClass, WSUniverseXtentisObjectsRevisionIDsE.class, "WSUniverseXtentisObjectsRevisionIDsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSUniverseXtentisObjectsRevisionIDsE_XtentisObjectName(), ecorePackage.getEString(), "xtentisObjectName", null, 0, 1, WSUniverseXtentisObjectsRevisionIDsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSUniverseXtentisObjectsRevisionIDsE_RevisionID(), ecorePackage.getEString(), "revisionID", null, 0, 1, WSUniverseXtentisObjectsRevisionIDsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsUniverseItemsRevisionIDsEEClass, WSUniverseItemsRevisionIDsE.class, "WSUniverseItemsRevisionIDsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSUniverseItemsRevisionIDsE_ConceptPattern(), ecorePackage.getEString(), "conceptPattern", null, 0, 1, WSUniverseItemsRevisionIDsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSUniverseItemsRevisionIDsE_RevisionID(), ecorePackage.getEString(), "revisionID", null, 0, 1, WSUniverseItemsRevisionIDsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsSynchronizationPlanEEClass, WSSynchronizationPlanE.class, "WSSynchronizationPlanE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSSynchronizationPlanE_RemoteSystemName(), ecorePackage.getEString(), "remoteSystemName", null, 0, 1, WSSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanE_RemoteSystemURL(), ecorePackage.getEString(), "remoteSystemURL", null, 0, 1, WSSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanE_RemoteSystemUsername(), ecorePackage.getEString(), "remoteSystemUsername", null, 0, 1, WSSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanE_RemoteSystemPassword(), ecorePackage.getEString(), "remoteSystemPassword", null, 0, 1, WSSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanE_TisURL(), ecorePackage.getEString(), "tisURL", null, 0, 1, WSSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanE_TisUsername(), ecorePackage.getEString(), "tisUsername", null, 0, 1, WSSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanE_TisPassword(), ecorePackage.getEString(), "tisPassword", null, 0, 1, WSSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanE_TisParameters(), ecorePackage.getEString(), "tisParameters", null, 0, 1, WSSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSSynchronizationPlanE_XtentisObjectsSynchronizations(), this.getWSSynchronizationPlanXtentisObjectsSynchronizationsE(), null, "xtentisObjectsSynchronizations", null, 0, -1, WSSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSSynchronizationPlanE_ItemsSynchronizations(), this.getWSSynchronizationPlanItemsSynchronizationsE(), null, "itemsSynchronizations", null, 0, -1, WSSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsSynchronizationPlanItemsSynchronizationsEEClass, WSSynchronizationPlanItemsSynchronizationsE.class, "WSSynchronizationPlanItemsSynchronizationsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSSynchronizationPlanItemsSynchronizationsE_ConceptName(), ecorePackage.getEString(), "conceptName", null, 0, 1, WSSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanItemsSynchronizationsE_IdsPattern(), ecorePackage.getEString(), "idsPattern", null, 0, 1, WSSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanItemsSynchronizationsE_LocalCluster(), ecorePackage.getEString(), "localCluster", null, 0, 1, WSSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanItemsSynchronizationsE_LocalRevisionID(), ecorePackage.getEString(), "localRevisionID", null, 0, 1, WSSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanItemsSynchronizationsE_RemoteCluster(), ecorePackage.getEString(), "remoteCluster", null, 0, 1, WSSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanItemsSynchronizationsE_RemoteRevisionID(), ecorePackage.getEString(), "remoteRevisionID", null, 0, 1, WSSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanItemsSynchronizationsE_Algorithm(), ecorePackage.getEString(), "algorithm", null, 0, 1, WSSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass, WSSynchronizationPlanXtentisObjectsSynchronizationsE.class, "WSSynchronizationPlanXtentisObjectsSynchronizationsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSSynchronizationPlanXtentisObjectsSynchronizationsE_XtentisObjectName(), ecorePackage.getEString(), "xtentisObjectName", null, 0, 1, WSSynchronizationPlanXtentisObjectsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSSynchronizationPlanXtentisObjectsSynchronizationsE_Synchronizations(), this.getWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE(), null, "synchronizations", null, 0, -1, WSSynchronizationPlanXtentisObjectsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass, WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE.class, "WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_InstancePattern(), ecorePackage.getEString(), "instancePattern", null, 0, 1, WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_LocalRevisionID(), ecorePackage.getEString(), "localRevisionID", null, 0, 1, WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_RemoteRevisionID(), ecorePackage.getEString(), "remoteRevisionID", null, 0, 1, WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_Algorithm(), ecorePackage.getEString(), "algorithm", null, 0, 1, WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsBooleanEEClass, WSBooleanE.class, "WSBooleanE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSBooleanE__true(), ecorePackage.getEBoolean(), "_true", null, 0, 1, WSBooleanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsWorkflowDeployEEClass, WSWorkflowDeployE.class, "WSWorkflowDeployE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSWorkflowDeployE_Filename(), ecorePackage.getEString(), "filename", null, 0, 1, WSWorkflowDeployE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsTransformerV2EEClass, WSTransformerV2E.class, "WSTransformerV2E", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSTransformerV2E_ProcessSteps(), this.getWSTransformerProcessStepE(), null, "processSteps", null, 0, -1, WSTransformerV2E.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsTransformerProcessStepEEClass, WSTransformerProcessStepE.class, "WSTransformerProcessStepE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSTransformerProcessStepE_PluginJNDI(), ecorePackage.getEString(), "pluginJNDI", null, 0, 1, WSTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSTransformerProcessStepE_Description(), ecorePackage.getEString(), "description", null, 0, 1, WSTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSTransformerProcessStepE_Parameters(), ecorePackage.getEString(), "parameters", null, 0, 1, WSTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSTransformerProcessStepE_Disabled(), ecorePackage.getEBoolean(), "disabled", null, 0, 1, WSTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSTransformerProcessStepE_InputMappings(), this.getWSTransformerVariablesMappingE(), null, "inputMappings", null, 0, -1, WSTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSTransformerProcessStepE_OutputMappings(), this.getWSTransformerVariablesMappingE(), null, "outputMappings", null, 0, -1, WSTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsTransformerVariablesMappingEEClass, WSTransformerVariablesMappingE.class, "WSTransformerVariablesMappingE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSTransformerVariablesMappingE_PipelineVariable(), ecorePackage.getEString(), "pipelineVariable", null, 0, 1, WSTransformerVariablesMappingE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSTransformerVariablesMappingE_PluginVariable(), ecorePackage.getEString(), "pluginVariable", null, 0, 1, WSTransformerVariablesMappingE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSTransformerVariablesMappingE_HardCoding(), this.getWSTypedContentE(), null, "hardCoding", null, 0, 1, WSTransformerVariablesMappingE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsTypedContentEEClass, WSTypedContentE.class, "WSTypedContentE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSTypedContentE_Url(), ecorePackage.getEString(), "url", null, 0, 1, WSTypedContentE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSTypedContentE_ContentType(), ecorePackage.getEString(), "contentType", null, 0, 1, WSTypedContentE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSTypedContentE_WsBytes(), this.getWSByteArrayE(), null, "wsBytes", null, 0, 1, WSTypedContentE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsByteArrayEEClass, WSByteArrayE.class, "WSByteArrayE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSByteArrayE_Bytes(), ecorePackage.getEByteArray(), "bytes", null, 0, 1, WSByteArrayE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoutingRuleEEClass, WSRoutingRuleE.class, "WSRoutingRuleE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSRoutingRuleE_Synchronous(), ecorePackage.getEBoolean(), "synchronous", null, 0, 1, WSRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoutingRuleE_Concept(), ecorePackage.getEString(), "concept", null, 0, 1, WSRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoutingRuleE_ServiceJNDI(), ecorePackage.getEString(), "serviceJNDI", null, 0, 1, WSRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoutingRuleE_Parameters(), ecorePackage.getEString(), "parameters", null, 0, 1, WSRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoutingRuleE_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, WSRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoutingRuleE_Deactive(), ecorePackage.getEBoolean(), "deactive", null, 0, 1, WSRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSRoutingRuleE_WsRoutingRuleExpressions(), this.getWSRoutingRuleExpressionE(), null, "wsRoutingRuleExpressions", null, 0, -1, WSRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoutingRuleExpressionEEClass, WSRoutingRuleExpressionE.class, "WSRoutingRuleExpressionE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSRoutingRuleExpressionE_Name(), ecorePackage.getEString(), "name", null, 0, 1, WSRoutingRuleExpressionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoutingRuleExpressionE_Xpath(), ecorePackage.getEString(), "xpath", null, 0, 1, WSRoutingRuleExpressionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSRoutingRuleExpressionE_Value(), ecorePackage.getEString(), "value", null, 0, 1, WSRoutingRuleExpressionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWSRoutingRuleExpressionE_WsOperator(), this.getWSRoutingRuleOperatorE(), null, "wsOperator", null, 0, 1, WSRoutingRuleExpressionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoutingRuleOperatorEEClass, WSRoutingRuleOperatorE.class, "WSRoutingRuleOperatorE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSRoutingRuleOperatorE_Value(), ecorePackage.getEString(), "value", null, 0, 1, WSRoutingRuleOperatorE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsJobModelEEClass, WSJobModelE.class, "WSJobModelE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(wsEventManagerEEClass, WSEventManagerE.class, "WSEventManagerE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(wsServiceConfigurationEEClass, WSServiceConfigurationE.class, "WSServiceConfigurationE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWSServiceConfigurationE_ServicePutConfigurations(), this.getWSServicePutConfigurationE(), null, "servicePutConfigurations", null, 0, -1, WSServiceConfigurationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsServicePutConfigurationEEClass, WSServicePutConfigurationE.class, "WSServicePutConfigurationE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSServicePutConfigurationE_JndiName(), ecorePackage.getEString(), "jndiName", null, 0, 1, WSServicePutConfigurationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSServicePutConfigurationE_Configuration(), ecorePackage.getEString(), "configuration", null, 0, 1, WSServicePutConfigurationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsWorkflowEEClass, WSWorkflowE.class, "WSWorkflowE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(wsResourceEEClass, WSResourceE.class, "WSResourceE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWSResourceE_FileExtension(), ecorePackage.getEString(), "fileExtension", null, 0, 1, WSResourceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWSResourceE_FileContent(), ecorePackage.getEByteArray(), "fileContent", null, 0, 1, WSResourceE.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(customFormEClass, CustomForm.class, "CustomForm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCustomForm_Filename(), ecorePackage.getEString(), "filename", null, 0, 1, CustomForm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //MdmserverobjectPackageImpl
