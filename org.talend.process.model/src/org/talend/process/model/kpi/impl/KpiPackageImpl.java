/**
 * Copyright (C) 2009 BonitaSoft S.A.
 * BonitaSoft, 31 rue Gustave Eiffel - 38000 Grenoble
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * $Id$
 */
package org.talend.process.model.kpi.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.talend.process.model.form.FormPackage;

import org.talend.process.model.form.impl.FormPackageImpl;

import org.talend.process.model.kpi.AbstractKPIBinding;
import org.talend.process.model.kpi.AbstractKPIDefinition;
import org.talend.process.model.kpi.DatabaseConfiguration;
import org.talend.process.model.kpi.DatabaseKPIBinding;
import org.talend.process.model.kpi.DatabaseKPIDefinition;
import org.talend.process.model.kpi.KPIField;
import org.talend.process.model.kpi.KPIParameterMapping;
import org.talend.process.model.kpi.KpiFactory;
import org.talend.process.model.kpi.KpiPackage;

import org.talend.process.model.process.ProcessPackage;

import org.talend.process.model.process.impl.ProcessPackageImpl;

import org.talend.process.model.simulation.SimulationPackage;

import org.talend.process.model.simulation.impl.SimulationPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KpiPackageImpl extends EPackageImpl implements KpiPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractKPIDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractKPIBindingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kpiParameterMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass databaseConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass databaseKPIBindingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass databaseKPIDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kpiFieldEClass = null;

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
     * @see org.talend.process.model.kpi.KpiPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private KpiPackageImpl() {
        super(eNS_URI, KpiFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link KpiPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static KpiPackage init() {
        if (isInited) return (KpiPackage)EPackage.Registry.INSTANCE.getEPackage(KpiPackage.eNS_URI);

        // Obtain or create and register package
        KpiPackageImpl theKpiPackage = (KpiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof KpiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new KpiPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        FormPackageImpl theFormPackage = (FormPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FormPackage.eNS_URI) instanceof FormPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FormPackage.eNS_URI) : FormPackage.eINSTANCE);
        ProcessPackageImpl theProcessPackage = (ProcessPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI) instanceof ProcessPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI) : ProcessPackage.eINSTANCE);
        SimulationPackageImpl theSimulationPackage = (SimulationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimulationPackage.eNS_URI) instanceof SimulationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimulationPackage.eNS_URI) : SimulationPackage.eINSTANCE);

        // Create package meta-data objects
        theKpiPackage.createPackageContents();
        theFormPackage.createPackageContents();
        theProcessPackage.createPackageContents();
        theSimulationPackage.createPackageContents();

        // Initialize created meta-data
        theKpiPackage.initializePackageContents();
        theFormPackage.initializePackageContents();
        theProcessPackage.initializePackageContents();
        theSimulationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theKpiPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(KpiPackage.eNS_URI, theKpiPackage);
        return theKpiPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractKPIDefinition() {
        return abstractKPIDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractKPIDefinition_Fields() {
        return (EReference)abstractKPIDefinitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractKPIBinding() {
        return abstractKPIBindingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractKPIBinding_KpiDefinitionName() {
        return (EAttribute)abstractKPIBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractKPIBinding_Parameters() {
        return (EReference)abstractKPIBindingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractKPIBinding_Event() {
        return (EAttribute)abstractKPIBindingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractKPIBinding_IgnoreError() {
        return (EAttribute)abstractKPIBindingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractKPIBinding_Request() {
        return (EAttribute)abstractKPIBindingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractKPIBinding_UseGraphicalEditor() {
        return (EAttribute)abstractKPIBindingEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKPIParameterMapping() {
        return kpiParameterMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKPIParameterMapping_Value() {
        return (EAttribute)kpiParameterMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKPIParameterMapping_KpiFieldName() {
        return (EAttribute)kpiParameterMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDatabaseConfiguration() {
        return databaseConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDatabaseConfiguration_Name() {
        return (EAttribute)databaseConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDatabaseConfiguration_Configuration() {
        return (EAttribute)databaseConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDatabaseKPIBinding() {
        return databaseKPIBindingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDatabaseKPIBinding_DatabaseConfiguration() {
        return (EReference)databaseKPIBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDatabaseKPIBinding_TableName() {
        return (EAttribute)databaseKPIBindingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDatabaseKPIDefinition() {
        return databaseKPIDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDatabaseKPIDefinition_DefaultConfiguration() {
        return (EReference)databaseKPIDefinitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDatabaseKPIDefinition_DefaultTableName() {
        return (EAttribute)databaseKPIDefinitionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKPIField() {
        return kpiFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKPIField_FieldName() {
        return (EAttribute)kpiFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKPIField_FieldType() {
        return (EAttribute)kpiFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKPIField_UseQuotes() {
        return (EAttribute)kpiFieldEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KpiFactory getKpiFactory() {
        return (KpiFactory)getEFactoryInstance();
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
        abstractKPIDefinitionEClass = createEClass(ABSTRACT_KPI_DEFINITION);
        createEReference(abstractKPIDefinitionEClass, ABSTRACT_KPI_DEFINITION__FIELDS);

        abstractKPIBindingEClass = createEClass(ABSTRACT_KPI_BINDING);
        createEAttribute(abstractKPIBindingEClass, ABSTRACT_KPI_BINDING__KPI_DEFINITION_NAME);
        createEReference(abstractKPIBindingEClass, ABSTRACT_KPI_BINDING__PARAMETERS);
        createEAttribute(abstractKPIBindingEClass, ABSTRACT_KPI_BINDING__EVENT);
        createEAttribute(abstractKPIBindingEClass, ABSTRACT_KPI_BINDING__IGNORE_ERROR);
        createEAttribute(abstractKPIBindingEClass, ABSTRACT_KPI_BINDING__REQUEST);
        createEAttribute(abstractKPIBindingEClass, ABSTRACT_KPI_BINDING__USE_GRAPHICAL_EDITOR);

        kpiParameterMappingEClass = createEClass(KPI_PARAMETER_MAPPING);
        createEAttribute(kpiParameterMappingEClass, KPI_PARAMETER_MAPPING__VALUE);
        createEAttribute(kpiParameterMappingEClass, KPI_PARAMETER_MAPPING__KPI_FIELD_NAME);

        databaseConfigurationEClass = createEClass(DATABASE_CONFIGURATION);
        createEAttribute(databaseConfigurationEClass, DATABASE_CONFIGURATION__NAME);
        createEAttribute(databaseConfigurationEClass, DATABASE_CONFIGURATION__CONFIGURATION);

        databaseKPIBindingEClass = createEClass(DATABASE_KPI_BINDING);
        createEReference(databaseKPIBindingEClass, DATABASE_KPI_BINDING__DATABASE_CONFIGURATION);
        createEAttribute(databaseKPIBindingEClass, DATABASE_KPI_BINDING__TABLE_NAME);

        databaseKPIDefinitionEClass = createEClass(DATABASE_KPI_DEFINITION);
        createEReference(databaseKPIDefinitionEClass, DATABASE_KPI_DEFINITION__DEFAULT_CONFIGURATION);
        createEAttribute(databaseKPIDefinitionEClass, DATABASE_KPI_DEFINITION__DEFAULT_TABLE_NAME);

        kpiFieldEClass = createEClass(KPI_FIELD);
        createEAttribute(kpiFieldEClass, KPI_FIELD__FIELD_NAME);
        createEAttribute(kpiFieldEClass, KPI_FIELD__FIELD_TYPE);
        createEAttribute(kpiFieldEClass, KPI_FIELD__USE_QUOTES);
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
        ProcessPackage theProcessPackage = (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        abstractKPIDefinitionEClass.getESuperTypes().add(theProcessPackage.getElement());
        abstractKPIBindingEClass.getESuperTypes().add(theProcessPackage.getElement());
        databaseKPIBindingEClass.getESuperTypes().add(this.getAbstractKPIBinding());
        databaseKPIDefinitionEClass.getESuperTypes().add(this.getAbstractKPIDefinition());

        // Initialize classes and features; add operations and parameters
        initEClass(abstractKPIDefinitionEClass, AbstractKPIDefinition.class, "AbstractKPIDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getAbstractKPIDefinition_Fields(), this.getKPIField(), null, "fields", null, 0, -1, AbstractKPIDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(abstractKPIBindingEClass, AbstractKPIBinding.class, "AbstractKPIBinding", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getAbstractKPIBinding_KpiDefinitionName(), ecorePackage.getEString(), "kpiDefinitionName", null, 0, 1, AbstractKPIBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAbstractKPIBinding_Parameters(), this.getKPIParameterMapping(), null, "parameters", null, 0, -1, AbstractKPIBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAbstractKPIBinding_Event(), ecorePackage.getEString(), "event", null, 0, 1, AbstractKPIBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAbstractKPIBinding_IgnoreError(), ecorePackage.getEBoolean(), "ignoreError", null, 0, 1, AbstractKPIBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAbstractKPIBinding_Request(), ecorePackage.getEString(), "request", null, 0, 1, AbstractKPIBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAbstractKPIBinding_UseGraphicalEditor(), ecorePackage.getEBoolean(), "useGraphicalEditor", "true", 0, 1, AbstractKPIBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(kpiParameterMappingEClass, KPIParameterMapping.class, "KPIParameterMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getKPIParameterMapping_Value(), ecorePackage.getEString(), "value", null, 0, 1, KPIParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getKPIParameterMapping_KpiFieldName(), ecorePackage.getEString(), "kpiFieldName", null, 0, 1, KPIParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(databaseConfigurationEClass, DatabaseConfiguration.class, "DatabaseConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getDatabaseConfiguration_Name(), ecorePackage.getEString(), "name", null, 0, 1, DatabaseConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDatabaseConfiguration_Configuration(), ecorePackage.getEString(), "configuration", null, 0, 1, DatabaseConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(databaseKPIBindingEClass, DatabaseKPIBinding.class, "DatabaseKPIBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getDatabaseKPIBinding_DatabaseConfiguration(), this.getDatabaseConfiguration(), null, "databaseConfiguration", null, 0, 1, DatabaseKPIBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDatabaseKPIBinding_TableName(), ecorePackage.getEString(), "tableName", null, 0, 1, DatabaseKPIBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(databaseKPIDefinitionEClass, DatabaseKPIDefinition.class, "DatabaseKPIDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getDatabaseKPIDefinition_DefaultConfiguration(), this.getDatabaseConfiguration(), null, "defaultConfiguration", null, 0, 1, DatabaseKPIDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDatabaseKPIDefinition_DefaultTableName(), ecorePackage.getEString(), "defaultTableName", null, 0, 1, DatabaseKPIDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(kpiFieldEClass, KPIField.class, "KPIField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getKPIField_FieldName(), ecorePackage.getEString(), "fieldName", null, 0, 1, KPIField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getKPIField_FieldType(), ecorePackage.getEString(), "fieldType", null, 0, 1, KPIField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getKPIField_UseQuotes(), ecorePackage.getEBoolean(), "useQuotes", null, 0, 1, KPIField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        // Create resource
        createResource(eNS_URI);
    }

} //KpiPackageImpl
