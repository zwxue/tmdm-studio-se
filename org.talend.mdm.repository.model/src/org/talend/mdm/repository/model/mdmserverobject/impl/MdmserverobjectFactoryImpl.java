/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmserverobject.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MdmserverobjectFactoryImpl extends EFactoryImpl implements MdmserverobjectFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MdmserverobjectFactory init() {
        try {
            MdmserverobjectFactory theMdmserverobjectFactory = (MdmserverobjectFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.talend.org/mdmserverobject"); 
            if (theMdmserverobjectFactory != null) {
                return theMdmserverobjectFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new MdmserverobjectFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmserverobjectFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case MdmserverobjectPackage.MDM_SERVER_OBJECT: return createMDMServerObject();
            case MdmserverobjectPackage.WS_MENU_E: return createWSMenuE();
            case MdmserverobjectPackage.WS_MENU_ENTRY_E: return createWSMenuEntryE();
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E: return createWSMenuMenuEntriesDescriptionsE();
            case MdmserverobjectPackage.WS_ROLE_E: return createWSRoleE();
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E: return createWSRoleSpecificationE();
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E: return createWSRoleSpecificationInstanceE();
            case MdmserverobjectPackage.WS_VIEW_E: return createWSViewE();
            case MdmserverobjectPackage.WS_WHERE_CONDITION_E: return createWSWhereConditionE();
            case MdmserverobjectPackage.WS_WHERE_OPERATOR_E: return createWSWhereOperatorE();
            case MdmserverobjectPackage.WS_STRING_PREDICATE_E: return createWSStringPredicateE();
            case MdmserverobjectPackage.WS_DATA_MODEL_E: return createWSDataModelE();
            case MdmserverobjectPackage.WS_DATA_CLUSTER_E: return createWSDataClusterE();
            case MdmserverobjectPackage.WS_STORED_PROCEDURE_E: return createWSStoredProcedureE();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case MdmserverobjectPackage.STRING_ARRAY:
                return createStringArrayFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case MdmserverobjectPackage.STRING_ARRAY:
                return convertStringArrayToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MDMServerObject createMDMServerObject() {
        MDMServerObjectImpl mdmServerObject = new MDMServerObjectImpl();
        return mdmServerObject;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSMenuE createWSMenuE() {
        WSMenuEImpl wsMenuE = new WSMenuEImpl();
        return wsMenuE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSMenuEntryE createWSMenuEntryE() {
        WSMenuEntryEImpl wsMenuEntryE = new WSMenuEntryEImpl();
        return wsMenuEntryE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSMenuMenuEntriesDescriptionsE createWSMenuMenuEntriesDescriptionsE() {
        WSMenuMenuEntriesDescriptionsEImpl wsMenuMenuEntriesDescriptionsE = new WSMenuMenuEntriesDescriptionsEImpl();
        return wsMenuMenuEntriesDescriptionsE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoleE createWSRoleE() {
        WSRoleEImpl wsRoleE = new WSRoleEImpl();
        return wsRoleE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoleSpecificationE createWSRoleSpecificationE() {
        WSRoleSpecificationEImpl wsRoleSpecificationE = new WSRoleSpecificationEImpl();
        return wsRoleSpecificationE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoleSpecificationInstanceE createWSRoleSpecificationInstanceE() {
        WSRoleSpecificationInstanceEImpl wsRoleSpecificationInstanceE = new WSRoleSpecificationInstanceEImpl();
        return wsRoleSpecificationInstanceE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSViewE createWSViewE() {
        WSViewEImpl wsViewE = new WSViewEImpl();
        return wsViewE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSWhereConditionE createWSWhereConditionE() {
        WSWhereConditionEImpl wsWhereConditionE = new WSWhereConditionEImpl();
        return wsWhereConditionE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSWhereOperatorE createWSWhereOperatorE() {
        WSWhereOperatorEImpl wsWhereOperatorE = new WSWhereOperatorEImpl();
        return wsWhereOperatorE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSStringPredicateE createWSStringPredicateE() {
        WSStringPredicateEImpl wsStringPredicateE = new WSStringPredicateEImpl();
        return wsStringPredicateE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSDataModelE createWSDataModelE() {
        WSDataModelEImpl wsDataModelE = new WSDataModelEImpl();
        return wsDataModelE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSDataClusterE createWSDataClusterE() {
        WSDataClusterEImpl wsDataClusterE = new WSDataClusterEImpl();
        return wsDataClusterE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSStoredProcedureE createWSStoredProcedureE() {
        WSStoredProcedureEImpl wsStoredProcedureE = new WSStoredProcedureEImpl();
        return wsStoredProcedureE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String[] createStringArrayFromString(EDataType eDataType, String initialValue) {
        return (String[])super.createFromString(initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertStringArrayToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmserverobjectPackage getMdmserverobjectPackage() {
        return (MdmserverobjectPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static MdmserverobjectPackage getPackage() {
        return MdmserverobjectPackage.eINSTANCE;
    }

} //MdmserverobjectFactoryImpl
