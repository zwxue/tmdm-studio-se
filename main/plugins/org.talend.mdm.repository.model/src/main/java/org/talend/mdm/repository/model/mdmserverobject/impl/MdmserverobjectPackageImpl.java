/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.talend.dataquality.analysis.AnalysisPackage;

import org.talend.dataquality.domain.DomainPackage;

import org.talend.dataquality.expressions.ExpressionsPackage;

import org.talend.dataquality.indicators.IndicatorsPackage;

import org.talend.dataquality.properties.PropertiesPackage;

import org.talend.dataquality.reports.ReportsPackage;

import org.talend.dataquality.rules.RulesPackage;

import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage;

import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WsBooleanE;
import org.talend.mdm.repository.model.mdmserverobject.WsByteArrayE;
import org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE;
import org.talend.mdm.repository.model.mdmserverobject.WsDataClusterE;
import org.talend.mdm.repository.model.mdmserverobject.WsDataModelE;
import org.talend.mdm.repository.model.mdmserverobject.WsEventManagerE;
import org.talend.mdm.repository.model.mdmserverobject.WsJobModelE;
import org.talend.mdm.repository.model.mdmserverobject.WsMatchRuleE;
import org.talend.mdm.repository.model.mdmserverobject.WsMatchRulePKE;
import org.talend.mdm.repository.model.mdmserverobject.WsMenuE;
import org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE;
import org.talend.mdm.repository.model.mdmserverobject.WsMenuMenuEntriesDescriptionsE;
import org.talend.mdm.repository.model.mdmserverobject.WsResourceE;
import org.talend.mdm.repository.model.mdmserverobject.WsRoleE;
import org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationE;
import org.talend.mdm.repository.model.mdmserverobject.WsRoleSpecificationInstanceE;
import org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleE;
import org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleExpressionE;
import org.talend.mdm.repository.model.mdmserverobject.WsRoutingRuleOperatorE;
import org.talend.mdm.repository.model.mdmserverobject.WsServiceConfigurationE;
import org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE;
import org.talend.mdm.repository.model.mdmserverobject.WsStoredProcedureE;
import org.talend.mdm.repository.model.mdmserverobject.WsStringPredicateE;
import org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE;
import org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanItemsSynchronizationsE;
import org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsE;
import org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE;
import org.talend.mdm.repository.model.mdmserverobject.WsTransformerProcessStepE;
import org.talend.mdm.repository.model.mdmserverobject.WsTransformerV2E;
import org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE;
import org.talend.mdm.repository.model.mdmserverobject.WsTypedContentE;
import org.talend.mdm.repository.model.mdmserverobject.WsUniverseE;
import org.talend.mdm.repository.model.mdmserverobject.WsUniverseItemsRevisionIDsE;
import org.talend.mdm.repository.model.mdmserverobject.WsUniverseXtentisObjectsRevisionIDsE;
import org.talend.mdm.repository.model.mdmserverobject.WsViewE;
import org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE;
import org.talend.mdm.repository.model.mdmserverobject.WsWhereOperatorE;
import org.talend.mdm.repository.model.mdmserverobject.WsWorkflowDeployE;
import org.talend.mdm.repository.model.mdmserverobject.WsWorkflowE;

import org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage;

import org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.MatchRulePackageImpl;

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
    private EClass wsCustomFormEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsMatchRuleEEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass wsMatchRulePKEEClass = null;

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
        AnalysisPackage.eINSTANCE.eClass();
        ReportsPackage.eINSTANCE.eClass();
        IndicatorsPackage.eINSTANCE.eClass();
        ExpressionsPackage.eINSTANCE.eClass();
        DomainPackage.eINSTANCE.eClass();
        RulesPackage.eINSTANCE.eClass();
        PropertiesPackage.eINSTANCE.eClass();
        MdmmetadataPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        MatchRulePackageImpl theMatchRulePackage = (MatchRulePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MatchRulePackage.eNS_URI) instanceof MatchRulePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MatchRulePackage.eNS_URI) : MatchRulePackage.eINSTANCE);

        // Create package meta-data objects
        theMdmserverobjectPackage.createPackageContents();
        theMatchRulePackage.createPackageContents();

        // Initialize created meta-data
        theMdmserverobjectPackage.initializePackageContents();
        theMatchRulePackage.initializePackageContents();

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
    public EAttribute getMDMServerObject_Timestamp() {
        return (EAttribute)mdmServerObjectEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMDMServerObject_DigestValue() {
        return (EAttribute)mdmServerObjectEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMDMServerObject_CurrentDigestValue() {
        return (EAttribute)mdmServerObjectEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMDMServerObject_LastServerName() {
        return (EAttribute)mdmServerObjectEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsMenuE() {
        return wsMenuEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsMenuE_MenuEntries() {
        return (EReference)wsMenuEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsMenuEntryE() {
        return wsMenuEntryEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsMenuEntryE_Id() {
        return (EAttribute)wsMenuEntryEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsMenuEntryE_Application() {
        return (EAttribute)wsMenuEntryEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsMenuEntryE_Context() {
        return (EAttribute)wsMenuEntryEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsMenuEntryE_Icon() {
        return (EAttribute)wsMenuEntryEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsMenuEntryE_Descriptions() {
        return (EReference)wsMenuEntryEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsMenuEntryE_SubMenus() {
        return (EReference)wsMenuEntryEEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsMenuMenuEntriesDescriptionsE() {
        return wsMenuMenuEntriesDescriptionsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsMenuMenuEntriesDescriptionsE_Language() {
        return (EAttribute)wsMenuMenuEntriesDescriptionsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsMenuMenuEntriesDescriptionsE_Label() {
        return (EAttribute)wsMenuMenuEntriesDescriptionsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsRoleE() {
        return wsRoleEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsRoleE_Specification() {
        return (EReference)wsRoleEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsRoleSpecificationE() {
        return wsRoleSpecificationEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoleSpecificationE_Admin() {
        return (EAttribute)wsRoleSpecificationEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoleSpecificationE_ObjectType() {
        return (EAttribute)wsRoleSpecificationEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsRoleSpecificationE_Instance() {
        return (EReference)wsRoleSpecificationEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsRoleSpecificationInstanceE() {
        return wsRoleSpecificationInstanceEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoleSpecificationInstanceE_InstanceName() {
        return (EAttribute)wsRoleSpecificationInstanceEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoleSpecificationInstanceE_Writable() {
        return (EAttribute)wsRoleSpecificationInstanceEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoleSpecificationInstanceE_Parameter() {
        return (EAttribute)wsRoleSpecificationInstanceEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsViewE() {
        return wsViewEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsViewE_SearchableBusinessElements() {
        return (EAttribute)wsViewEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsViewE_ViewableBusinessElements() {
        return (EAttribute)wsViewEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsViewE_TransformerActive() {
        return (EAttribute)wsViewEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsViewE_WhereConditions() {
        return (EReference)wsViewEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsViewE_IsTransformerActive() {
        return (EReference)wsViewEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsViewE_TransformerPK() {
        return (EAttribute)wsViewEEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsWhereConditionE() {
        return wsWhereConditionEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsWhereConditionE_LeftPath() {
        return (EAttribute)wsWhereConditionEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsWhereConditionE_RightValueOrPath() {
        return (EAttribute)wsWhereConditionEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsWhereConditionE_StringPredicate() {
        return (EReference)wsWhereConditionEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsWhereConditionE_Operator() {
        return (EReference)wsWhereConditionEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsWhereConditionE_SpellCheck() {
        return (EAttribute)wsWhereConditionEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsWhereOperatorE() {
        return wsWhereOperatorEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsWhereOperatorE_Value() {
        return (EAttribute)wsWhereOperatorEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsStringPredicateE() {
        return wsStringPredicateEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsStringPredicateE_Value() {
        return (EAttribute)wsStringPredicateEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsDataModelE() {
        return wsDataModelEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsDataModelE_XsdSchema() {
        return (EAttribute)wsDataModelEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsDataClusterE() {
        return wsDataClusterEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsDataClusterE_Vocabulary() {
        return (EAttribute)wsDataClusterEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsStoredProcedureE() {
        return wsStoredProcedureEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsStoredProcedureE_Procedure() {
        return (EAttribute)wsStoredProcedureEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsStoredProcedureE_RefreshCache() {
        return (EAttribute)wsStoredProcedureEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsUniverseE() {
        return wsUniverseEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsUniverseE_DefaultItemsRevisionID() {
        return (EAttribute)wsUniverseEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsUniverseE_XtentisObjectsRevisionIDs() {
        return (EReference)wsUniverseEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsUniverseE_ItemsRevisionIDs() {
        return (EReference)wsUniverseEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsUniverseXtentisObjectsRevisionIDsE() {
        return wsUniverseXtentisObjectsRevisionIDsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsUniverseXtentisObjectsRevisionIDsE_XtentisObjectName() {
        return (EAttribute)wsUniverseXtentisObjectsRevisionIDsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsUniverseXtentisObjectsRevisionIDsE_RevisionID() {
        return (EAttribute)wsUniverseXtentisObjectsRevisionIDsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsUniverseItemsRevisionIDsE() {
        return wsUniverseItemsRevisionIDsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsUniverseItemsRevisionIDsE_ConceptPattern() {
        return (EAttribute)wsUniverseItemsRevisionIDsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsUniverseItemsRevisionIDsE_RevisionID() {
        return (EAttribute)wsUniverseItemsRevisionIDsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsSynchronizationPlanE() {
        return wsSynchronizationPlanEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanE_RemoteSystemName() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanE_RemoteSystemURL() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanE_RemoteSystemUsername() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanE_RemoteSystemPassword() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanE_TisURL() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanE_TisUsername() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanE_TisPassword() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanE_TisParameters() {
        return (EAttribute)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsSynchronizationPlanE_XtentisObjectsSynchronizations() {
        return (EReference)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsSynchronizationPlanE_ItemsSynchronizations() {
        return (EReference)wsSynchronizationPlanEEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsSynchronizationPlanItemsSynchronizationsE() {
        return wsSynchronizationPlanItemsSynchronizationsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanItemsSynchronizationsE_ConceptName() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanItemsSynchronizationsE_IdsPattern() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanItemsSynchronizationsE_LocalCluster() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanItemsSynchronizationsE_LocalRevisionID() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanItemsSynchronizationsE_RemoteCluster() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanItemsSynchronizationsE_RemoteRevisionID() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanItemsSynchronizationsE_Algorithm() {
        return (EAttribute)wsSynchronizationPlanItemsSynchronizationsEEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsSynchronizationPlanXtentisObjectsSynchronizationsE() {
        return wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanXtentisObjectsSynchronizationsE_XtentisObjectName() {
        return (EAttribute)wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsSynchronizationPlanXtentisObjectsSynchronizationsE_Synchronizations() {
        return (EReference)wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE() {
        return wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_InstancePattern() {
        return (EAttribute)wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_LocalRevisionID() {
        return (EAttribute)wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_RemoteRevisionID() {
        return (EAttribute)wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_Algorithm() {
        return (EAttribute)wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsBooleanE() {
        return wsBooleanEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsBooleanE__true() {
        return (EAttribute)wsBooleanEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsWorkflowDeployE() {
        return wsWorkflowDeployEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsWorkflowDeployE_Filename() {
        return (EAttribute)wsWorkflowDeployEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsTransformerV2E() {
        return wsTransformerV2EEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsTransformerV2E_ProcessSteps() {
        return (EReference)wsTransformerV2EEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsTransformerProcessStepE() {
        return wsTransformerProcessStepEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsTransformerProcessStepE_PluginJNDI() {
        return (EAttribute)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsTransformerProcessStepE_Description() {
        return (EAttribute)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsTransformerProcessStepE_Parameters() {
        return (EAttribute)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsTransformerProcessStepE_Disabled() {
        return (EAttribute)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsTransformerProcessStepE_InputMappings() {
        return (EReference)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsTransformerProcessStepE_OutputMappings() {
        return (EReference)wsTransformerProcessStepEEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsTransformerVariablesMappingE() {
        return wsTransformerVariablesMappingEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsTransformerVariablesMappingE_PipelineVariable() {
        return (EAttribute)wsTransformerVariablesMappingEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsTransformerVariablesMappingE_PluginVariable() {
        return (EAttribute)wsTransformerVariablesMappingEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsTransformerVariablesMappingE_HardCoding() {
        return (EReference)wsTransformerVariablesMappingEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsTypedContentE() {
        return wsTypedContentEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsTypedContentE_Url() {
        return (EAttribute)wsTypedContentEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsTypedContentE_ContentType() {
        return (EAttribute)wsTypedContentEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsTypedContentE_WsBytes() {
        return (EReference)wsTypedContentEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsByteArrayE() {
        return wsByteArrayEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsByteArrayE_Bytes() {
        return (EAttribute)wsByteArrayEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsRoutingRuleE() {
        return wsRoutingRuleEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoutingRuleE_Synchronous() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoutingRuleE_Concept() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoutingRuleE_ServiceJNDI() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoutingRuleE_Parameters() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoutingRuleE_Condition() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoutingRuleE_Deactive() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoutingRuleE_ExecuteOrder() {
        return (EAttribute)wsRoutingRuleEEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsRoutingRuleE_WsRoutingRuleExpressions() {
        return (EReference)wsRoutingRuleEEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsRoutingRuleExpressionE() {
        return wsRoutingRuleExpressionEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoutingRuleExpressionE_Name() {
        return (EAttribute)wsRoutingRuleExpressionEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoutingRuleExpressionE_Xpath() {
        return (EAttribute)wsRoutingRuleExpressionEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoutingRuleExpressionE_Value() {
        return (EAttribute)wsRoutingRuleExpressionEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsRoutingRuleExpressionE_WsOperator() {
        return (EReference)wsRoutingRuleExpressionEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsRoutingRuleOperatorE() {
        return wsRoutingRuleOperatorEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsRoutingRuleOperatorE_Value() {
        return (EAttribute)wsRoutingRuleOperatorEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsJobModelE() {
        return wsJobModelEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsEventManagerE() {
        return wsEventManagerEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsServiceConfigurationE() {
        return wsServiceConfigurationEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsServiceConfigurationE_ServicePutConfigurations() {
        return (EReference)wsServiceConfigurationEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsServicePutConfigurationE() {
        return wsServicePutConfigurationEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsServicePutConfigurationE_JndiName() {
        return (EAttribute)wsServicePutConfigurationEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsServicePutConfigurationE_Configuration() {
        return (EAttribute)wsServicePutConfigurationEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsWorkflowE() {
        return wsWorkflowEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsWorkflowE_FileContent() {
        return (EAttribute)wsWorkflowEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsResourceE() {
        return wsResourceEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsResourceE_FileExtension() {
        return (EAttribute)wsResourceEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsResourceE_FileContent() {
        return (EAttribute)wsResourceEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsResourceE_ImageCatalog() {
        return (EAttribute)wsResourceEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsCustomFormE() {
        return wsCustomFormEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsCustomFormE_Filename() {
        return (EAttribute)wsCustomFormEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsCustomFormE_Datamodel() {
        return (EAttribute)wsCustomFormEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsCustomFormE_Entity() {
        return (EAttribute)wsCustomFormEEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsCustomFormE_Xml() {
        return (EAttribute)wsCustomFormEEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsCustomFormE_Role() {
        return (EAttribute)wsCustomFormEEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsMatchRuleE() {
        return wsMatchRuleEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsMatchRuleE_ConfigurationXmlContent() {
        return (EAttribute)wsMatchRuleEEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWsMatchRuleE_PK() {
        return (EReference)wsMatchRuleEEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWsMatchRulePKE() {
        return wsMatchRulePKEEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWsMatchRulePKE_Pk() {
        return (EAttribute)wsMatchRulePKEEClass.getEStructuralFeatures().get(0);
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
        createEAttribute(mdmServerObjectEClass, MDM_SERVER_OBJECT__TIMESTAMP);
        createEAttribute(mdmServerObjectEClass, MDM_SERVER_OBJECT__DIGEST_VALUE);
        createEAttribute(mdmServerObjectEClass, MDM_SERVER_OBJECT__CURRENT_DIGEST_VALUE);
        createEAttribute(mdmServerObjectEClass, MDM_SERVER_OBJECT__LAST_SERVER_NAME);

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
        createEAttribute(wsRoutingRuleEEClass, WS_ROUTING_RULE_E__EXECUTE_ORDER);
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
        createEAttribute(wsWorkflowEEClass, WS_WORKFLOW_E__FILE_CONTENT);

        wsResourceEEClass = createEClass(WS_RESOURCE_E);
        createEAttribute(wsResourceEEClass, WS_RESOURCE_E__FILE_EXTENSION);
        createEAttribute(wsResourceEEClass, WS_RESOURCE_E__FILE_CONTENT);
        createEAttribute(wsResourceEEClass, WS_RESOURCE_E__IMAGE_CATALOG);

        wsCustomFormEEClass = createEClass(WS_CUSTOM_FORM_E);
        createEAttribute(wsCustomFormEEClass, WS_CUSTOM_FORM_E__FILENAME);
        createEAttribute(wsCustomFormEEClass, WS_CUSTOM_FORM_E__DATAMODEL);
        createEAttribute(wsCustomFormEEClass, WS_CUSTOM_FORM_E__ENTITY);
        createEAttribute(wsCustomFormEEClass, WS_CUSTOM_FORM_E__XML);
        createEAttribute(wsCustomFormEEClass, WS_CUSTOM_FORM_E__ROLE);

        wsMatchRuleEEClass = createEClass(WS_MATCH_RULE_E);
        createEAttribute(wsMatchRuleEEClass, WS_MATCH_RULE_E__CONFIGURATION_XML_CONTENT);
        createEReference(wsMatchRuleEEClass, WS_MATCH_RULE_E__PK);

        wsMatchRulePKEEClass = createEClass(WS_MATCH_RULE_PKE);
        createEAttribute(wsMatchRulePKEEClass, WS_MATCH_RULE_PKE__PK);
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
        MatchRulePackage theMatchRulePackage = (MatchRulePackage)EPackage.Registry.INSTANCE.getEPackage(MatchRulePackage.eNS_URI);
        MdmmetadataPackage theMdmmetadataPackage = (MdmmetadataPackage)EPackage.Registry.INSTANCE.getEPackage(MdmmetadataPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Add subpackages
        getESubpackages().add(theMatchRulePackage);

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
        wsCustomFormEEClass.getESuperTypes().add(this.getMDMServerObject());
        wsMatchRuleEEClass.getESuperTypes().add(this.getMDMServerObject());

        // Initialize classes and features; add operations and parameters
        initEClass(mdmServerObjectEClass, MDMServerObject.class, "MDMServerObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMDMServerObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_Description(), ecorePackage.getEString(), "description", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_System(), ecorePackage.getEBoolean(), "system", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMDMServerObject_LastServerDef(), theMdmmetadataPackage.getMDMServerDef(), null, "lastServerDef", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_Type(), ecorePackage.getEInt(), "type", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_Timestamp(), ecorePackage.getELong(), "timestamp", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_DigestValue(), ecorePackage.getEString(), "digestValue", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_CurrentDigestValue(), theEcorePackage.getEString(), "currentDigestValue", null, 0, 1, MDMServerObject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMDMServerObject_LastServerName(), theEcorePackage.getEString(), "lastServerName", null, 0, 1, MDMServerObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(mdmServerObjectEClass, ecorePackage.getEString(), "getUniqueName", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(wsMenuEEClass, WsMenuE.class, "WsMenuE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsMenuE_MenuEntries(), this.getWsMenuEntryE(), null, "menuEntries", null, 0, -1, WsMenuE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsMenuEntryEEClass, WsMenuEntryE.class, "WsMenuEntryE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsMenuEntryE_Id(), ecorePackage.getEString(), "id", null, 0, 1, WsMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsMenuEntryE_Application(), ecorePackage.getEString(), "application", null, 0, 1, WsMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsMenuEntryE_Context(), ecorePackage.getEString(), "context", null, 0, 1, WsMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsMenuEntryE_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, WsMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsMenuEntryE_Descriptions(), this.getWsMenuMenuEntriesDescriptionsE(), null, "descriptions", null, 0, -1, WsMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsMenuEntryE_SubMenus(), this.getWsMenuEntryE(), null, "subMenus", null, 0, -1, WsMenuEntryE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsMenuMenuEntriesDescriptionsEEClass, WsMenuMenuEntriesDescriptionsE.class, "WsMenuMenuEntriesDescriptionsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsMenuMenuEntriesDescriptionsE_Language(), ecorePackage.getEString(), "language", null, 0, 1, WsMenuMenuEntriesDescriptionsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsMenuMenuEntriesDescriptionsE_Label(), ecorePackage.getEString(), "label", null, 0, 1, WsMenuMenuEntriesDescriptionsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoleEEClass, WsRoleE.class, "WsRoleE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsRoleE_Specification(), this.getWsRoleSpecificationE(), null, "specification", null, 0, -1, WsRoleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoleSpecificationEEClass, WsRoleSpecificationE.class, "WsRoleSpecificationE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsRoleSpecificationE_Admin(), ecorePackage.getEBoolean(), "admin", null, 0, 1, WsRoleSpecificationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsRoleSpecificationE_ObjectType(), ecorePackage.getEString(), "objectType", null, 0, 1, WsRoleSpecificationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsRoleSpecificationE_Instance(), this.getWsRoleSpecificationInstanceE(), null, "instance", null, 0, -1, WsRoleSpecificationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoleSpecificationInstanceEEClass, WsRoleSpecificationInstanceE.class, "WsRoleSpecificationInstanceE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsRoleSpecificationInstanceE_InstanceName(), ecorePackage.getEString(), "instanceName", null, 0, 1, WsRoleSpecificationInstanceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsRoleSpecificationInstanceE_Writable(), ecorePackage.getEBoolean(), "writable", null, 0, 1, WsRoleSpecificationInstanceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsRoleSpecificationInstanceE_Parameter(), ecorePackage.getEString(), "parameter", null, 0, -1, WsRoleSpecificationInstanceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsViewEEClass, WsViewE.class, "WsViewE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsViewE_SearchableBusinessElements(), ecorePackage.getEString(), "searchableBusinessElements", null, 0, -1, WsViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsViewE_ViewableBusinessElements(), ecorePackage.getEString(), "viewableBusinessElements", null, 0, -1, WsViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsViewE_TransformerActive(), ecorePackage.getEBoolean(), "transformerActive", null, 0, 1, WsViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsViewE_WhereConditions(), this.getWsWhereConditionE(), null, "whereConditions", null, 0, -1, WsViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsViewE_IsTransformerActive(), this.getWsBooleanE(), null, "isTransformerActive", null, 0, 1, WsViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsViewE_TransformerPK(), ecorePackage.getEString(), "transformerPK", null, 0, 1, WsViewE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsWhereConditionEEClass, WsWhereConditionE.class, "WsWhereConditionE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsWhereConditionE_LeftPath(), ecorePackage.getEString(), "leftPath", null, 0, 1, WsWhereConditionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsWhereConditionE_RightValueOrPath(), ecorePackage.getEString(), "rightValueOrPath", null, 0, 1, WsWhereConditionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsWhereConditionE_StringPredicate(), this.getWsStringPredicateE(), null, "stringPredicate", null, 0, 1, WsWhereConditionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsWhereConditionE_Operator(), this.getWsWhereOperatorE(), null, "operator", null, 0, 1, WsWhereConditionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsWhereConditionE_SpellCheck(), ecorePackage.getEBoolean(), "spellCheck", null, 0, 1, WsWhereConditionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsWhereOperatorEEClass, WsWhereOperatorE.class, "WsWhereOperatorE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsWhereOperatorE_Value(), ecorePackage.getEString(), "value", null, 0, 1, WsWhereOperatorE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsStringPredicateEEClass, WsStringPredicateE.class, "WsStringPredicateE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsStringPredicateE_Value(), ecorePackage.getEString(), "value", null, 0, 1, WsStringPredicateE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsDataModelEEClass, WsDataModelE.class, "WsDataModelE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsDataModelE_XsdSchema(), ecorePackage.getEString(), "xsdSchema", null, 0, 1, WsDataModelE.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsDataClusterEEClass, WsDataClusterE.class, "WsDataClusterE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsDataClusterE_Vocabulary(), ecorePackage.getEString(), "vocabulary", null, 0, 1, WsDataClusterE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsStoredProcedureEEClass, WsStoredProcedureE.class, "WsStoredProcedureE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsStoredProcedureE_Procedure(), ecorePackage.getEString(), "procedure", null, 0, 1, WsStoredProcedureE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsStoredProcedureE_RefreshCache(), ecorePackage.getEBoolean(), "refreshCache", null, 0, 1, WsStoredProcedureE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsUniverseEEClass, WsUniverseE.class, "WsUniverseE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsUniverseE_DefaultItemsRevisionID(), ecorePackage.getEString(), "defaultItemsRevisionID", null, 0, 1, WsUniverseE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsUniverseE_XtentisObjectsRevisionIDs(), this.getWsUniverseXtentisObjectsRevisionIDsE(), null, "xtentisObjectsRevisionIDs", null, 0, -1, WsUniverseE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsUniverseE_ItemsRevisionIDs(), this.getWsUniverseItemsRevisionIDsE(), null, "itemsRevisionIDs", null, 0, -1, WsUniverseE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsUniverseXtentisObjectsRevisionIDsEEClass, WsUniverseXtentisObjectsRevisionIDsE.class, "WsUniverseXtentisObjectsRevisionIDsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsUniverseXtentisObjectsRevisionIDsE_XtentisObjectName(), ecorePackage.getEString(), "xtentisObjectName", null, 0, 1, WsUniverseXtentisObjectsRevisionIDsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsUniverseXtentisObjectsRevisionIDsE_RevisionID(), ecorePackage.getEString(), "revisionID", null, 0, 1, WsUniverseXtentisObjectsRevisionIDsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsUniverseItemsRevisionIDsEEClass, WsUniverseItemsRevisionIDsE.class, "WsUniverseItemsRevisionIDsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsUniverseItemsRevisionIDsE_ConceptPattern(), ecorePackage.getEString(), "conceptPattern", null, 0, 1, WsUniverseItemsRevisionIDsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsUniverseItemsRevisionIDsE_RevisionID(), ecorePackage.getEString(), "revisionID", null, 0, 1, WsUniverseItemsRevisionIDsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsSynchronizationPlanEEClass, WsSynchronizationPlanE.class, "WsSynchronizationPlanE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsSynchronizationPlanE_RemoteSystemName(), ecorePackage.getEString(), "remoteSystemName", null, 0, 1, WsSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanE_RemoteSystemURL(), ecorePackage.getEString(), "remoteSystemURL", null, 0, 1, WsSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanE_RemoteSystemUsername(), ecorePackage.getEString(), "remoteSystemUsername", null, 0, 1, WsSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanE_RemoteSystemPassword(), ecorePackage.getEString(), "remoteSystemPassword", null, 0, 1, WsSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanE_TisURL(), ecorePackage.getEString(), "tisURL", null, 0, 1, WsSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanE_TisUsername(), ecorePackage.getEString(), "tisUsername", null, 0, 1, WsSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanE_TisPassword(), ecorePackage.getEString(), "tisPassword", null, 0, 1, WsSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanE_TisParameters(), ecorePackage.getEString(), "tisParameters", null, 0, 1, WsSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsSynchronizationPlanE_XtentisObjectsSynchronizations(), this.getWsSynchronizationPlanXtentisObjectsSynchronizationsE(), null, "xtentisObjectsSynchronizations", null, 0, -1, WsSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsSynchronizationPlanE_ItemsSynchronizations(), this.getWsSynchronizationPlanItemsSynchronizationsE(), null, "itemsSynchronizations", null, 0, -1, WsSynchronizationPlanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsSynchronizationPlanItemsSynchronizationsEEClass, WsSynchronizationPlanItemsSynchronizationsE.class, "WsSynchronizationPlanItemsSynchronizationsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsSynchronizationPlanItemsSynchronizationsE_ConceptName(), ecorePackage.getEString(), "conceptName", null, 0, 1, WsSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanItemsSynchronizationsE_IdsPattern(), ecorePackage.getEString(), "idsPattern", null, 0, 1, WsSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanItemsSynchronizationsE_LocalCluster(), ecorePackage.getEString(), "localCluster", null, 0, 1, WsSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanItemsSynchronizationsE_LocalRevisionID(), ecorePackage.getEString(), "localRevisionID", null, 0, 1, WsSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanItemsSynchronizationsE_RemoteCluster(), ecorePackage.getEString(), "remoteCluster", null, 0, 1, WsSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanItemsSynchronizationsE_RemoteRevisionID(), ecorePackage.getEString(), "remoteRevisionID", null, 0, 1, WsSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanItemsSynchronizationsE_Algorithm(), ecorePackage.getEString(), "algorithm", null, 0, 1, WsSynchronizationPlanItemsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsSynchronizationPlanXtentisObjectsSynchronizationsEEClass, WsSynchronizationPlanXtentisObjectsSynchronizationsE.class, "WsSynchronizationPlanXtentisObjectsSynchronizationsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsSynchronizationPlanXtentisObjectsSynchronizationsE_XtentisObjectName(), ecorePackage.getEString(), "xtentisObjectName", null, 0, 1, WsSynchronizationPlanXtentisObjectsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsSynchronizationPlanXtentisObjectsSynchronizationsE_Synchronizations(), this.getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE(), null, "synchronizations", null, 0, -1, WsSynchronizationPlanXtentisObjectsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsEEClass, WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE.class, "WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_InstancePattern(), ecorePackage.getEString(), "instancePattern", null, 0, 1, WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_LocalRevisionID(), ecorePackage.getEString(), "localRevisionID", null, 0, 1, WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_RemoteRevisionID(), ecorePackage.getEString(), "remoteRevisionID", null, 0, 1, WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE_Algorithm(), ecorePackage.getEString(), "algorithm", null, 0, 1, WsSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsBooleanEEClass, WsBooleanE.class, "WsBooleanE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsBooleanE__true(), ecorePackage.getEBoolean(), "_true", null, 0, 1, WsBooleanE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsWorkflowDeployEEClass, WsWorkflowDeployE.class, "WsWorkflowDeployE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsWorkflowDeployE_Filename(), ecorePackage.getEString(), "filename", null, 0, 1, WsWorkflowDeployE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsTransformerV2EEClass, WsTransformerV2E.class, "WsTransformerV2E", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsTransformerV2E_ProcessSteps(), this.getWsTransformerProcessStepE(), null, "processSteps", null, 0, -1, WsTransformerV2E.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsTransformerProcessStepEEClass, WsTransformerProcessStepE.class, "WsTransformerProcessStepE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsTransformerProcessStepE_PluginJNDI(), ecorePackage.getEString(), "pluginJNDI", null, 0, 1, WsTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsTransformerProcessStepE_Description(), ecorePackage.getEString(), "description", null, 0, 1, WsTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsTransformerProcessStepE_Parameters(), ecorePackage.getEString(), "parameters", null, 0, 1, WsTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsTransformerProcessStepE_Disabled(), ecorePackage.getEBoolean(), "disabled", null, 0, 1, WsTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsTransformerProcessStepE_InputMappings(), this.getWsTransformerVariablesMappingE(), null, "inputMappings", null, 0, -1, WsTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsTransformerProcessStepE_OutputMappings(), this.getWsTransformerVariablesMappingE(), null, "outputMappings", null, 0, -1, WsTransformerProcessStepE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsTransformerVariablesMappingEEClass, WsTransformerVariablesMappingE.class, "WsTransformerVariablesMappingE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsTransformerVariablesMappingE_PipelineVariable(), ecorePackage.getEString(), "pipelineVariable", null, 0, 1, WsTransformerVariablesMappingE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsTransformerVariablesMappingE_PluginVariable(), ecorePackage.getEString(), "pluginVariable", null, 0, 1, WsTransformerVariablesMappingE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsTransformerVariablesMappingE_HardCoding(), this.getWsTypedContentE(), null, "hardCoding", null, 0, 1, WsTransformerVariablesMappingE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsTypedContentEEClass, WsTypedContentE.class, "WsTypedContentE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsTypedContentE_Url(), ecorePackage.getEString(), "url", null, 0, 1, WsTypedContentE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsTypedContentE_ContentType(), ecorePackage.getEString(), "contentType", null, 0, 1, WsTypedContentE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsTypedContentE_WsBytes(), this.getWsByteArrayE(), null, "wsBytes", null, 0, 1, WsTypedContentE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsByteArrayEEClass, WsByteArrayE.class, "WsByteArrayE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsByteArrayE_Bytes(), ecorePackage.getEByteArray(), "bytes", null, 0, 1, WsByteArrayE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoutingRuleEEClass, WsRoutingRuleE.class, "WsRoutingRuleE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsRoutingRuleE_Synchronous(), ecorePackage.getEBoolean(), "synchronous", null, 0, 1, WsRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsRoutingRuleE_Concept(), ecorePackage.getEString(), "concept", null, 0, 1, WsRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsRoutingRuleE_ServiceJNDI(), ecorePackage.getEString(), "serviceJNDI", null, 0, 1, WsRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsRoutingRuleE_Parameters(), ecorePackage.getEString(), "parameters", null, 0, 1, WsRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsRoutingRuleE_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, WsRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsRoutingRuleE_Deactive(), ecorePackage.getEBoolean(), "deactive", null, 0, 1, WsRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsRoutingRuleE_ExecuteOrder(), theEcorePackage.getEInt(), "executeOrder", null, 0, 1, WsRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsRoutingRuleE_WsRoutingRuleExpressions(), this.getWsRoutingRuleExpressionE(), null, "wsRoutingRuleExpressions", null, 0, -1, WsRoutingRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoutingRuleExpressionEEClass, WsRoutingRuleExpressionE.class, "WsRoutingRuleExpressionE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsRoutingRuleExpressionE_Name(), ecorePackage.getEString(), "name", null, 0, 1, WsRoutingRuleExpressionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsRoutingRuleExpressionE_Xpath(), ecorePackage.getEString(), "xpath", null, 0, 1, WsRoutingRuleExpressionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsRoutingRuleExpressionE_Value(), ecorePackage.getEString(), "value", null, 0, 1, WsRoutingRuleExpressionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsRoutingRuleExpressionE_WsOperator(), this.getWsRoutingRuleOperatorE(), null, "wsOperator", null, 0, 1, WsRoutingRuleExpressionE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsRoutingRuleOperatorEEClass, WsRoutingRuleOperatorE.class, "WsRoutingRuleOperatorE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsRoutingRuleOperatorE_Value(), ecorePackage.getEString(), "value", null, 0, 1, WsRoutingRuleOperatorE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsJobModelEEClass, WsJobModelE.class, "WsJobModelE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(wsEventManagerEEClass, WsEventManagerE.class, "WsEventManagerE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(wsServiceConfigurationEEClass, WsServiceConfigurationE.class, "WsServiceConfigurationE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWsServiceConfigurationE_ServicePutConfigurations(), this.getWsServicePutConfigurationE(), null, "servicePutConfigurations", null, 0, -1, WsServiceConfigurationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsServicePutConfigurationEEClass, WsServicePutConfigurationE.class, "WsServicePutConfigurationE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsServicePutConfigurationE_JndiName(), ecorePackage.getEString(), "jndiName", null, 0, 1, WsServicePutConfigurationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsServicePutConfigurationE_Configuration(), ecorePackage.getEString(), "configuration", null, 0, 1, WsServicePutConfigurationE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsWorkflowEEClass, WsWorkflowE.class, "WsWorkflowE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsWorkflowE_FileContent(), ecorePackage.getEByteArray(), "fileContent", null, 0, 1, WsWorkflowE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsResourceEEClass, WsResourceE.class, "WsResourceE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsResourceE_FileExtension(), ecorePackage.getEString(), "fileExtension", null, 0, 1, WsResourceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsResourceE_FileContent(), ecorePackage.getEByteArray(), "fileContent", null, 0, 1, WsResourceE.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsResourceE_ImageCatalog(), ecorePackage.getEString(), "imageCatalog", "Default_Catalog", 0, 1, WsResourceE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsCustomFormEEClass, WsCustomFormE.class, "WsCustomFormE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsCustomFormE_Filename(), ecorePackage.getEString(), "filename", null, 0, 1, WsCustomFormE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsCustomFormE_Datamodel(), ecorePackage.getEString(), "datamodel", null, 0, 1, WsCustomFormE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsCustomFormE_Entity(), ecorePackage.getEString(), "entity", null, 0, 1, WsCustomFormE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsCustomFormE_Xml(), ecorePackage.getEString(), "xml", null, 0, 1, WsCustomFormE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWsCustomFormE_Role(), ecorePackage.getEString(), "role", null, 0, 1, WsCustomFormE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsMatchRuleEEClass, WsMatchRuleE.class, "WsMatchRuleE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsMatchRuleE_ConfigurationXmlContent(), theEcorePackage.getEString(), "configurationXmlContent", null, 0, 1, WsMatchRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWsMatchRuleE_PK(), this.getWsMatchRulePKE(), null, "PK", null, 0, 1, WsMatchRuleE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wsMatchRulePKEEClass, WsMatchRulePKE.class, "WsMatchRulePKE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWsMatchRulePKE_Pk(), theEcorePackage.getEString(), "pk", null, 0, 1, WsMatchRulePKE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //MdmserverobjectPackageImpl
