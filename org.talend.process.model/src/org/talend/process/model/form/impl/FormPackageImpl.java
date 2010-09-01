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
package org.talend.process.model.form.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.talend.process.model.form.CheckBoxMultipleFormField;
import org.talend.process.model.form.CheckBoxSingleFormField;
import org.talend.process.model.form.Column;
import org.talend.process.model.form.ComboFormField;
import org.talend.process.model.form.DateFormField;
import org.talend.process.model.form.Duplicable;
import org.talend.process.model.form.DurationFormField;
import org.talend.process.model.form.EventDependencyType;
import org.talend.process.model.form.FileWidget;
import org.talend.process.model.form.Form;
import org.talend.process.model.form.FormButton;
import org.talend.process.model.form.FormFactory;
import org.talend.process.model.form.FormField;
import org.talend.process.model.form.FormPackage;
import org.talend.process.model.form.GroovyScript;
import org.talend.process.model.form.Group;
import org.talend.process.model.form.HiddenWidget;
import org.talend.process.model.form.ImageWidget;
import org.talend.process.model.form.Info;
import org.talend.process.model.form.ItemContainer;
import org.talend.process.model.form.LabelPosition;
import org.talend.process.model.form.Line;
import org.talend.process.model.form.ListFormField;
import org.talend.process.model.form.MessageInfo;
import org.talend.process.model.form.MultipleValuatedFormField;
import org.talend.process.model.form.NextFormButton;
import org.talend.process.model.form.PasswordFormField;
import org.talend.process.model.form.PreviousFormButton;
import org.talend.process.model.form.RadioFormField;
import org.talend.process.model.form.RichTextAreaFormField;
import org.talend.process.model.form.SelectFormField;
import org.talend.process.model.form.SingleValuatedFormField;
import org.talend.process.model.form.SubmitFormButton;
import org.talend.process.model.form.Table;
import org.talend.process.model.form.TextAreaFormField;
import org.talend.process.model.form.TextFormField;
import org.talend.process.model.form.TextInfo;
import org.talend.process.model.form.Validable;
import org.talend.process.model.form.Validator;
import org.talend.process.model.form.ViewForm;
import org.talend.process.model.form.Widget;
import org.talend.process.model.form.WidgetDependency;
import org.talend.process.model.form.WidgetLayoutInfo;

import org.talend.process.model.kpi.KpiPackage;

import org.talend.process.model.kpi.impl.KpiPackageImpl;

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
public class FormPackageImpl extends EPackageImpl implements FormPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass formEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass widgetEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass widgetDependencyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass groupEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass formFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass multipleValuatedFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass singleValuatedFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass checkBoxMultipleFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass comboFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dateFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass listFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass passwordFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass radioFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass selectFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textAreaFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass richTextAreaFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass formButtonEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass submitFormButtonEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass previousFormButtonEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass nextFormButtonEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass groovyScriptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass infoEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textInfoEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass messageInfoEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass checkBoxSingleFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass validatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass validableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass widgetLayoutInfoEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fileWidgetEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass columnEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass lineEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass imageWidgetEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass hiddenWidgetEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass durationFormFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass duplicableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass viewFormEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum eventDependencyTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum labelPositionEEnum = null;

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
     * @see org.talend.process.model.form.FormPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private FormPackageImpl() {
        super(eNS_URI, FormFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link FormPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static FormPackage init() {
        if (isInited) return (FormPackage)EPackage.Registry.INSTANCE.getEPackage(FormPackage.eNS_URI);

        // Obtain or create and register package
        FormPackageImpl theFormPackage = (FormPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FormPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FormPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        KpiPackageImpl theKpiPackage = (KpiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(KpiPackage.eNS_URI) instanceof KpiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(KpiPackage.eNS_URI) : KpiPackage.eINSTANCE);
        ProcessPackageImpl theProcessPackage = (ProcessPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI) instanceof ProcessPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI) : ProcessPackage.eINSTANCE);
        SimulationPackageImpl theSimulationPackage = (SimulationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimulationPackage.eNS_URI) instanceof SimulationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimulationPackage.eNS_URI) : SimulationPackage.eINSTANCE);

        // Create package meta-data objects
        theFormPackage.createPackageContents();
        theKpiPackage.createPackageContents();
        theProcessPackage.createPackageContents();
        theSimulationPackage.createPackageContents();

        // Initialize created meta-data
        theFormPackage.initializePackageContents();
        theKpiPackage.initializePackageContents();
        theProcessPackage.initializePackageContents();
        theSimulationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theFormPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(FormPackage.eNS_URI, theFormPackage);
        return theFormPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getForm() {
        return formEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getForm_Widgets() {
        return (EReference)formEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getForm_Scripts() {
        return (EReference)formEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getForm_NColumn() {
        return (EAttribute)formEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getForm_StringAttributes() {
        return (EReference)formEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getForm_NLine() {
        return (EAttribute)formEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getForm_Columns() {
        return (EReference)formEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getForm_Lines() {
        return (EReference)formEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getForm_PageLabel() {
        return (EAttribute)formEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getForm_ShowPageLabel() {
        return (EAttribute)formEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getForm_AllowHTMLInPageLabel() {
        return (EAttribute)formEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWidget() {
        return widgetEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWidget_Script() {
        return (EReference)widgetEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidget_Tooltip() {
        return (EAttribute)widgetEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWidget_WidgetLayoutInfo() {
        return (EReference)widgetEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidget_DisplayLabel() {
        return (EAttribute)widgetEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidget_ShowDisplayLabel() {
        return (EAttribute)widgetEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidget_AllowHTMLForDisplayLabel() {
        return (EAttribute)widgetEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWidget_HtmlAttributes() {
        return (EReference)widgetEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidget_RealHtmlAttributes() {
        return (EAttribute)widgetEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWidget_DependOn() {
        return (EReference)widgetEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidget_DisplayDependentWidgetOnlyOnEventTriggered() {
        return (EAttribute)widgetEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWidget_ScriptAfterEvent() {
        return (EReference)widgetEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWidget_ParentOf() {
        return (EReference)widgetEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidget_Mandatory() {
        return (EAttribute)widgetEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidget_ReadOnly() {
        return (EAttribute)widgetEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidget_LabelPosition() {
        return (EAttribute)widgetEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWidget_InputConnectors() {
        return (EReference)widgetEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWidget_OutputConnectors() {
        return (EReference)widgetEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWidget_AfterEventConnectors() {
        return (EReference)widgetEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWidgetDependency() {
        return widgetDependencyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWidgetDependency_Widget() {
        return (EReference)widgetDependencyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidgetDependency_EventTypes() {
        return (EAttribute)widgetDependencyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGroup() {
        return groupEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroup_Widgets() {
        return (EReference)groupEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroup_ShowBorder() {
        return (EAttribute)groupEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroup_Columns() {
        return (EReference)groupEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroup_Lines() {
        return (EReference)groupEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFormField() {
        return formFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFormField_Description() {
        return (EAttribute)formFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMultipleValuatedFormField() {
        return multipleValuatedFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMultipleValuatedFormField_DefaultValue() {
        return (EAttribute)multipleValuatedFormFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMultipleValuatedFormField_DefaultValueAfterEvent() {
        return (EAttribute)multipleValuatedFormFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMultipleValuatedFormField_Enum() {
        return (EReference)multipleValuatedFormFieldEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMultipleValuatedFormField_EnumAfterEvent() {
        return (EReference)multipleValuatedFormFieldEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMultipleValuatedFormField_Literals() {
        return (EAttribute)multipleValuatedFormFieldEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMultipleValuatedFormField_LiteralsAfterEvent() {
        return (EAttribute)multipleValuatedFormFieldEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMultipleValuatedFormField_DefaultConnectors() {
        return (EReference)multipleValuatedFormFieldEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMultipleValuatedFormField_DefaultAfterEventConnectors() {
        return (EReference)multipleValuatedFormFieldEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSingleValuatedFormField() {
        return singleValuatedFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCheckBoxMultipleFormField() {
        return checkBoxMultipleFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComboFormField() {
        return comboFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDateFormField() {
        return dateFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDateFormField_InitialFormat() {
        return (EAttribute)dateFormFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDateFormField_DisplayFormat() {
        return (EAttribute)dateFormFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getListFormField() {
        return listFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getListFormField_MaxHeigth() {
        return (EAttribute)listFormFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPasswordFormField() {
        return passwordFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPasswordFormField_MaxLength() {
        return (EAttribute)passwordFormFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRadioFormField() {
        return radioFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSelectFormField() {
        return selectFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextFormField() {
        return textFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextFormField_MaxLength() {
        return (EAttribute)textFormFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextAreaFormField() {
        return textAreaFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextAreaFormField_MaxLength() {
        return (EAttribute)textAreaFormFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextAreaFormField_MaxHeigth() {
        return (EAttribute)textAreaFormFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRichTextAreaFormField() {
        return richTextAreaFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFormButton() {
        return formButtonEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFormButton_LabelBehavior() {
        return (EAttribute)formButtonEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSubmitFormButton() {
        return submitFormButtonEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSubmitFormButton_Scripts() {
        return (EReference)submitFormButtonEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPreviousFormButton() {
        return previousFormButtonEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNextFormButton() {
        return nextFormButtonEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGroovyScript() {
        return groovyScriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroovyScript_ExprScript() {
        return (EAttribute)groovyScriptEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroovyScript_InputScript() {
        return (EAttribute)groovyScriptEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroovyScript_SetVar() {
        return (EReference)groovyScriptEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroovyScript_AllowHTMLInValues() {
        return (EAttribute)groovyScriptEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroovyScript_SetVarScript() {
        return (EAttribute)groovyScriptEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInfo() {
        return infoEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextInfo() {
        return textInfoEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMessageInfo() {
        return messageInfoEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCheckBoxSingleFormField() {
        return checkBoxSingleFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getValidator() {
        return validatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValidator_ValidatorClass() {
        return (EAttribute)validatorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValidator_HtmlClass() {
        return (EAttribute)validatorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValidator_Label() {
        return (EAttribute)validatorEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValidator_Name() {
        return (EAttribute)validatorEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValidator_Parameter() {
        return (EAttribute)validatorEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValidator_BelowField() {
        return (EAttribute)validatorEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getValidable() {
        return validableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getValidable_Validators() {
        return (EReference)validableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValidable_UseDefaultValidator() {
        return (EAttribute)validableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValidable_Below() {
        return (EAttribute)validableEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWidgetLayoutInfo() {
        return widgetLayoutInfoEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidgetLayoutInfo_Line() {
        return (EAttribute)widgetLayoutInfoEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidgetLayoutInfo_Column() {
        return (EAttribute)widgetLayoutInfoEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidgetLayoutInfo_VerticalSpan() {
        return (EAttribute)widgetLayoutInfoEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWidgetLayoutInfo_HorizontalSpan() {
        return (EAttribute)widgetLayoutInfoEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFileWidget() {
        return fileWidgetEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFileWidget_FileData() {
        return (EReference)fileWidgetEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileWidget_DownloadOnly() {
        return (EAttribute)fileWidgetEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileWidget_UsePreview() {
        return (EAttribute)fileWidgetEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getColumn() {
        return columnEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getColumn_Width() {
        return (EAttribute)columnEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getColumn_Number() {
        return (EAttribute)columnEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLine() {
        return lineEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLine_Height() {
        return (EAttribute)lineEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLine_Number() {
        return (EAttribute)lineEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getImageWidget() {
        return imageWidgetEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getImageWidget_ImgPath() {
        return (EAttribute)imageWidgetEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getImageWidget_IsAnAttachment() {
        return (EAttribute)imageWidgetEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHiddenWidget() {
        return hiddenWidgetEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDurationFormField() {
        return durationFormFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDurationFormField_Day() {
        return (EAttribute)durationFormFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDurationFormField_Hour() {
        return (EAttribute)durationFormFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDurationFormField_Min() {
        return (EAttribute)durationFormFieldEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDurationFormField_Sec() {
        return (EAttribute)durationFormFieldEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItemContainer() {
        return itemContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItemContainer_ItemClass() {
        return (EAttribute)itemContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDuplicable() {
        return duplicableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDuplicable_Duplicate() {
        return (EAttribute)duplicableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDuplicable_LimitNumberOfDuplication() {
        return (EAttribute)duplicableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDuplicable_MaxNumberOfDuplication() {
        return (EAttribute)duplicableEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDuplicable_LimitMinNumberOfDuplication() {
        return (EAttribute)duplicableEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDuplicable_MinNumberOfDuplication() {
        return (EAttribute)duplicableEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDuplicable_DisplayLabelForAdd() {
        return (EAttribute)duplicableEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDuplicable_TooltipForAdd() {
        return (EAttribute)duplicableEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDuplicable_DisplayLabelForRemove() {
        return (EAttribute)duplicableEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDuplicable_TooltipForRemove() {
        return (EAttribute)duplicableEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTable() {
        return tableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTable_LeftColumnIsHeader() {
        return (EAttribute)tableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTable_RightColumnIsHeader() {
        return (EAttribute)tableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTable_FirstRowIsHeader() {
        return (EAttribute)tableEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTable_LastRowIsHeader() {
        return (EAttribute)tableEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTable_InitializedUsingCells() {
        return (EAttribute)tableEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTable_Cells() {
        return (EAttribute)tableEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getViewForm() {
        return viewFormEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getEventDependencyType() {
        return eventDependencyTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getLabelPosition() {
        return labelPositionEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FormFactory getFormFactory() {
        return (FormFactory)getEFactoryInstance();
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
        formEClass = createEClass(FORM);
        createEReference(formEClass, FORM__WIDGETS);
        createEReference(formEClass, FORM__SCRIPTS);
        createEAttribute(formEClass, FORM__NCOLUMN);
        createEReference(formEClass, FORM__STRING_ATTRIBUTES);
        createEAttribute(formEClass, FORM__NLINE);
        createEReference(formEClass, FORM__COLUMNS);
        createEReference(formEClass, FORM__LINES);
        createEAttribute(formEClass, FORM__PAGE_LABEL);
        createEAttribute(formEClass, FORM__SHOW_PAGE_LABEL);
        createEAttribute(formEClass, FORM__ALLOW_HTML_IN_PAGE_LABEL);

        widgetEClass = createEClass(WIDGET);
        createEReference(widgetEClass, WIDGET__SCRIPT);
        createEAttribute(widgetEClass, WIDGET__TOOLTIP);
        createEReference(widgetEClass, WIDGET__WIDGET_LAYOUT_INFO);
        createEAttribute(widgetEClass, WIDGET__DISPLAY_LABEL);
        createEAttribute(widgetEClass, WIDGET__SHOW_DISPLAY_LABEL);
        createEAttribute(widgetEClass, WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL);
        createEReference(widgetEClass, WIDGET__HTML_ATTRIBUTES);
        createEAttribute(widgetEClass, WIDGET__REAL_HTML_ATTRIBUTES);
        createEReference(widgetEClass, WIDGET__DEPEND_ON);
        createEAttribute(widgetEClass, WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED);
        createEReference(widgetEClass, WIDGET__SCRIPT_AFTER_EVENT);
        createEReference(widgetEClass, WIDGET__PARENT_OF);
        createEAttribute(widgetEClass, WIDGET__MANDATORY);
        createEAttribute(widgetEClass, WIDGET__READ_ONLY);
        createEAttribute(widgetEClass, WIDGET__LABEL_POSITION);
        createEReference(widgetEClass, WIDGET__INPUT_CONNECTORS);
        createEReference(widgetEClass, WIDGET__OUTPUT_CONNECTORS);
        createEReference(widgetEClass, WIDGET__AFTER_EVENT_CONNECTORS);

        widgetDependencyEClass = createEClass(WIDGET_DEPENDENCY);
        createEReference(widgetDependencyEClass, WIDGET_DEPENDENCY__WIDGET);
        createEAttribute(widgetDependencyEClass, WIDGET_DEPENDENCY__EVENT_TYPES);

        groupEClass = createEClass(GROUP);
        createEReference(groupEClass, GROUP__WIDGETS);
        createEAttribute(groupEClass, GROUP__SHOW_BORDER);
        createEReference(groupEClass, GROUP__COLUMNS);
        createEReference(groupEClass, GROUP__LINES);

        formFieldEClass = createEClass(FORM_FIELD);
        createEAttribute(formFieldEClass, FORM_FIELD__DESCRIPTION);

        multipleValuatedFormFieldEClass = createEClass(MULTIPLE_VALUATED_FORM_FIELD);
        createEAttribute(multipleValuatedFormFieldEClass, MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE);
        createEAttribute(multipleValuatedFormFieldEClass, MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT);
        createEReference(multipleValuatedFormFieldEClass, MULTIPLE_VALUATED_FORM_FIELD__ENUM);
        createEReference(multipleValuatedFormFieldEClass, MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT);
        createEAttribute(multipleValuatedFormFieldEClass, MULTIPLE_VALUATED_FORM_FIELD__LITERALS);
        createEAttribute(multipleValuatedFormFieldEClass, MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT);
        createEReference(multipleValuatedFormFieldEClass, MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS);
        createEReference(multipleValuatedFormFieldEClass, MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS);

        singleValuatedFormFieldEClass = createEClass(SINGLE_VALUATED_FORM_FIELD);

        checkBoxMultipleFormFieldEClass = createEClass(CHECK_BOX_MULTIPLE_FORM_FIELD);

        comboFormFieldEClass = createEClass(COMBO_FORM_FIELD);

        dateFormFieldEClass = createEClass(DATE_FORM_FIELD);
        createEAttribute(dateFormFieldEClass, DATE_FORM_FIELD__INITIAL_FORMAT);
        createEAttribute(dateFormFieldEClass, DATE_FORM_FIELD__DISPLAY_FORMAT);

        listFormFieldEClass = createEClass(LIST_FORM_FIELD);
        createEAttribute(listFormFieldEClass, LIST_FORM_FIELD__MAX_HEIGTH);

        passwordFormFieldEClass = createEClass(PASSWORD_FORM_FIELD);
        createEAttribute(passwordFormFieldEClass, PASSWORD_FORM_FIELD__MAX_LENGTH);

        radioFormFieldEClass = createEClass(RADIO_FORM_FIELD);

        selectFormFieldEClass = createEClass(SELECT_FORM_FIELD);

        textFormFieldEClass = createEClass(TEXT_FORM_FIELD);
        createEAttribute(textFormFieldEClass, TEXT_FORM_FIELD__MAX_LENGTH);

        textAreaFormFieldEClass = createEClass(TEXT_AREA_FORM_FIELD);
        createEAttribute(textAreaFormFieldEClass, TEXT_AREA_FORM_FIELD__MAX_LENGTH);
        createEAttribute(textAreaFormFieldEClass, TEXT_AREA_FORM_FIELD__MAX_HEIGTH);

        richTextAreaFormFieldEClass = createEClass(RICH_TEXT_AREA_FORM_FIELD);

        formButtonEClass = createEClass(FORM_BUTTON);
        createEAttribute(formButtonEClass, FORM_BUTTON__LABEL_BEHAVIOR);

        submitFormButtonEClass = createEClass(SUBMIT_FORM_BUTTON);
        createEReference(submitFormButtonEClass, SUBMIT_FORM_BUTTON__SCRIPTS);

        previousFormButtonEClass = createEClass(PREVIOUS_FORM_BUTTON);

        nextFormButtonEClass = createEClass(NEXT_FORM_BUTTON);

        groovyScriptEClass = createEClass(GROOVY_SCRIPT);
        createEAttribute(groovyScriptEClass, GROOVY_SCRIPT__EXPR_SCRIPT);
        createEAttribute(groovyScriptEClass, GROOVY_SCRIPT__INPUT_SCRIPT);
        createEReference(groovyScriptEClass, GROOVY_SCRIPT__SET_VAR);
        createEAttribute(groovyScriptEClass, GROOVY_SCRIPT__ALLOW_HTML_IN_VALUES);
        createEAttribute(groovyScriptEClass, GROOVY_SCRIPT__SET_VAR_SCRIPT);

        infoEClass = createEClass(INFO);

        textInfoEClass = createEClass(TEXT_INFO);

        messageInfoEClass = createEClass(MESSAGE_INFO);

        checkBoxSingleFormFieldEClass = createEClass(CHECK_BOX_SINGLE_FORM_FIELD);

        validatorEClass = createEClass(VALIDATOR);
        createEAttribute(validatorEClass, VALIDATOR__VALIDATOR_CLASS);
        createEAttribute(validatorEClass, VALIDATOR__HTML_CLASS);
        createEAttribute(validatorEClass, VALIDATOR__LABEL);
        createEAttribute(validatorEClass, VALIDATOR__NAME);
        createEAttribute(validatorEClass, VALIDATOR__PARAMETER);
        createEAttribute(validatorEClass, VALIDATOR__BELOW_FIELD);

        validableEClass = createEClass(VALIDABLE);
        createEReference(validableEClass, VALIDABLE__VALIDATORS);
        createEAttribute(validableEClass, VALIDABLE__USE_DEFAULT_VALIDATOR);
        createEAttribute(validableEClass, VALIDABLE__BELOW);

        widgetLayoutInfoEClass = createEClass(WIDGET_LAYOUT_INFO);
        createEAttribute(widgetLayoutInfoEClass, WIDGET_LAYOUT_INFO__LINE);
        createEAttribute(widgetLayoutInfoEClass, WIDGET_LAYOUT_INFO__COLUMN);
        createEAttribute(widgetLayoutInfoEClass, WIDGET_LAYOUT_INFO__VERTICAL_SPAN);
        createEAttribute(widgetLayoutInfoEClass, WIDGET_LAYOUT_INFO__HORIZONTAL_SPAN);

        fileWidgetEClass = createEClass(FILE_WIDGET);
        createEReference(fileWidgetEClass, FILE_WIDGET__FILE_DATA);
        createEAttribute(fileWidgetEClass, FILE_WIDGET__DOWNLOAD_ONLY);
        createEAttribute(fileWidgetEClass, FILE_WIDGET__USE_PREVIEW);

        columnEClass = createEClass(COLUMN);
        createEAttribute(columnEClass, COLUMN__WIDTH);
        createEAttribute(columnEClass, COLUMN__NUMBER);

        lineEClass = createEClass(LINE);
        createEAttribute(lineEClass, LINE__HEIGHT);
        createEAttribute(lineEClass, LINE__NUMBER);

        imageWidgetEClass = createEClass(IMAGE_WIDGET);
        createEAttribute(imageWidgetEClass, IMAGE_WIDGET__IMG_PATH);
        createEAttribute(imageWidgetEClass, IMAGE_WIDGET__IS_AN_ATTACHMENT);

        hiddenWidgetEClass = createEClass(HIDDEN_WIDGET);

        durationFormFieldEClass = createEClass(DURATION_FORM_FIELD);
        createEAttribute(durationFormFieldEClass, DURATION_FORM_FIELD__DAY);
        createEAttribute(durationFormFieldEClass, DURATION_FORM_FIELD__HOUR);
        createEAttribute(durationFormFieldEClass, DURATION_FORM_FIELD__MIN);
        createEAttribute(durationFormFieldEClass, DURATION_FORM_FIELD__SEC);

        itemContainerEClass = createEClass(ITEM_CONTAINER);
        createEAttribute(itemContainerEClass, ITEM_CONTAINER__ITEM_CLASS);

        duplicableEClass = createEClass(DUPLICABLE);
        createEAttribute(duplicableEClass, DUPLICABLE__DUPLICATE);
        createEAttribute(duplicableEClass, DUPLICABLE__LIMIT_NUMBER_OF_DUPLICATION);
        createEAttribute(duplicableEClass, DUPLICABLE__MAX_NUMBER_OF_DUPLICATION);
        createEAttribute(duplicableEClass, DUPLICABLE__LIMIT_MIN_NUMBER_OF_DUPLICATION);
        createEAttribute(duplicableEClass, DUPLICABLE__MIN_NUMBER_OF_DUPLICATION);
        createEAttribute(duplicableEClass, DUPLICABLE__DISPLAY_LABEL_FOR_ADD);
        createEAttribute(duplicableEClass, DUPLICABLE__TOOLTIP_FOR_ADD);
        createEAttribute(duplicableEClass, DUPLICABLE__DISPLAY_LABEL_FOR_REMOVE);
        createEAttribute(duplicableEClass, DUPLICABLE__TOOLTIP_FOR_REMOVE);

        tableEClass = createEClass(TABLE);
        createEAttribute(tableEClass, TABLE__LEFT_COLUMN_IS_HEADER);
        createEAttribute(tableEClass, TABLE__RIGHT_COLUMN_IS_HEADER);
        createEAttribute(tableEClass, TABLE__FIRST_ROW_IS_HEADER);
        createEAttribute(tableEClass, TABLE__LAST_ROW_IS_HEADER);
        createEAttribute(tableEClass, TABLE__INITIALIZED_USING_CELLS);
        createEAttribute(tableEClass, TABLE__CELLS);

        viewFormEClass = createEClass(VIEW_FORM);

        // Create enums
        eventDependencyTypeEEnum = createEEnum(EVENT_DEPENDENCY_TYPE);
        labelPositionEEnum = createEEnum(LABEL_POSITION);
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
        formEClass.getESuperTypes().add(theProcessPackage.getConnectableElement());
        formEClass.getESuperTypes().add(this.getValidable());
        formEClass.getESuperTypes().add(theProcessPackage.getResourceContainer());
        widgetEClass.getESuperTypes().add(theProcessPackage.getElement());
        groupEClass.getESuperTypes().add(this.getWidget());
        groupEClass.getESuperTypes().add(this.getDuplicable());
        formFieldEClass.getESuperTypes().add(this.getWidget());
        formFieldEClass.getESuperTypes().add(this.getValidable());
        multipleValuatedFormFieldEClass.getESuperTypes().add(this.getFormField());
        singleValuatedFormFieldEClass.getESuperTypes().add(this.getFormField());
        checkBoxMultipleFormFieldEClass.getESuperTypes().add(this.getMultipleValuatedFormField());
        checkBoxMultipleFormFieldEClass.getESuperTypes().add(this.getItemContainer());
        comboFormFieldEClass.getESuperTypes().add(this.getMultipleValuatedFormField());
        dateFormFieldEClass.getESuperTypes().add(this.getSingleValuatedFormField());
        dateFormFieldEClass.getESuperTypes().add(this.getDuplicable());
        listFormFieldEClass.getESuperTypes().add(this.getMultipleValuatedFormField());
        passwordFormFieldEClass.getESuperTypes().add(this.getSingleValuatedFormField());
        passwordFormFieldEClass.getESuperTypes().add(this.getDuplicable());
        radioFormFieldEClass.getESuperTypes().add(this.getMultipleValuatedFormField());
        radioFormFieldEClass.getESuperTypes().add(this.getItemContainer());
        selectFormFieldEClass.getESuperTypes().add(this.getMultipleValuatedFormField());
        selectFormFieldEClass.getESuperTypes().add(this.getDuplicable());
        textFormFieldEClass.getESuperTypes().add(this.getSingleValuatedFormField());
        textFormFieldEClass.getESuperTypes().add(this.getDuplicable());
        textAreaFormFieldEClass.getESuperTypes().add(this.getSingleValuatedFormField());
        textAreaFormFieldEClass.getESuperTypes().add(this.getDuplicable());
        richTextAreaFormFieldEClass.getESuperTypes().add(this.getSingleValuatedFormField());
        richTextAreaFormFieldEClass.getESuperTypes().add(this.getDuplicable());
        formButtonEClass.getESuperTypes().add(this.getWidget());
        submitFormButtonEClass.getESuperTypes().add(this.getFormButton());
        submitFormButtonEClass.getESuperTypes().add(theProcessPackage.getConnectableElement());
        previousFormButtonEClass.getESuperTypes().add(this.getFormButton());
        nextFormButtonEClass.getESuperTypes().add(this.getFormButton());
        infoEClass.getESuperTypes().add(this.getWidget());
        textInfoEClass.getESuperTypes().add(this.getInfo());
        messageInfoEClass.getESuperTypes().add(this.getInfo());
        checkBoxSingleFormFieldEClass.getESuperTypes().add(this.getSingleValuatedFormField());
        fileWidgetEClass.getESuperTypes().add(this.getSingleValuatedFormField());
        fileWidgetEClass.getESuperTypes().add(this.getDuplicable());
        imageWidgetEClass.getESuperTypes().add(this.getWidget());
        hiddenWidgetEClass.getESuperTypes().add(this.getSingleValuatedFormField());
        durationFormFieldEClass.getESuperTypes().add(this.getSingleValuatedFormField());
        durationFormFieldEClass.getESuperTypes().add(this.getItemContainer());
        tableEClass.getESuperTypes().add(this.getWidget());
        viewFormEClass.getESuperTypes().add(this.getForm());

        // Initialize classes and features; add operations and parameters
        initEClass(formEClass, Form.class, "Form", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getForm_Widgets(), this.getWidget(), null, "widgets", null, 0, -1, Form.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getForm_Scripts(), this.getGroovyScript(), null, "scripts", null, 0, -1, Form.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getForm_NColumn(), ecorePackage.getEInt(), "nColumn", "1", 0, 1, Form.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getForm_StringAttributes(), ecorePackage.getEStringToStringMapEntry(), null, "stringAttributes", null, 0, -1, Form.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getForm_NLine(), ecorePackage.getEInt(), "nLine", "4", 0, 1, Form.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getForm_Columns(), this.getColumn(), null, "columns", null, 0, -1, Form.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getForm_Lines(), this.getLine(), null, "lines", null, 0, -1, Form.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getForm_PageLabel(), ecorePackage.getEString(), "pageLabel", null, 0, 1, Form.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getForm_ShowPageLabel(), ecorePackage.getEBooleanObject(), "showPageLabel", "true", 0, 1, Form.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getForm_AllowHTMLInPageLabel(), ecorePackage.getEBoolean(), "allowHTMLInPageLabel", "false", 0, 1, Form.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(widgetEClass, Widget.class, "Widget", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getWidget_Script(), this.getGroovyScript(), null, "script", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getWidget_Tooltip(), ecorePackage.getEString(), "tooltip", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getWidget_WidgetLayoutInfo(), this.getWidgetLayoutInfo(), null, "widgetLayoutInfo", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getWidget_DisplayLabel(), ecorePackage.getEString(), "displayLabel", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getWidget_ShowDisplayLabel(), ecorePackage.getEBooleanObject(), "showDisplayLabel", "true", 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getWidget_AllowHTMLForDisplayLabel(), ecorePackage.getEBoolean(), "allowHTMLForDisplayLabel", "false", 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getWidget_HtmlAttributes(), ecorePackage.getEStringToStringMapEntry(), null, "htmlAttributes", null, 0, -1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getWidget_RealHtmlAttributes(), ecorePackage.getEString(), "realHtmlAttributes", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getWidget_DependOn(), this.getWidgetDependency(), null, "dependOn", null, 0, -1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getWidget_DisplayDependentWidgetOnlyOnEventTriggered(), ecorePackage.getEBoolean(), "displayDependentWidgetOnlyOnEventTriggered", "false", 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getWidget_ScriptAfterEvent(), this.getGroovyScript(), null, "scriptAfterEvent", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getWidget_ParentOf(), this.getWidgetDependency(), null, "parentOf", null, 0, -1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getWidget_Mandatory(), ecorePackage.getEBoolean(), "mandatory", "false", 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getWidget_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", "false", 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getWidget_LabelPosition(), this.getLabelPosition(), "labelPosition", "0", 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getWidget_InputConnectors(), theProcessPackage.getConnector(), null, "inputConnectors", null, 0, -1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getWidget_OutputConnectors(), theProcessPackage.getConnector(), null, "outputConnectors", null, 0, -1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getWidget_AfterEventConnectors(), theProcessPackage.getConnector(), null, "afterEventConnectors", null, 0, -1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(widgetDependencyEClass, WidgetDependency.class, "WidgetDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getWidgetDependency_Widget(), this.getWidget(), null, "widget", null, 1, 1, WidgetDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getWidgetDependency_EventTypes(), this.getEventDependencyType(), "eventTypes", "onChange", 1, -1, WidgetDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getGroup_Widgets(), this.getWidget(), null, "widgets", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getGroup_ShowBorder(), ecorePackage.getEBoolean(), "showBorder", "false", 1, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getGroup_Columns(), this.getColumn(), null, "columns", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getGroup_Lines(), this.getLine(), null, "lines", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(formFieldEClass, FormField.class, "FormField", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getFormField_Description(), ecorePackage.getEString(), "description", null, 0, 1, FormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(multipleValuatedFormFieldEClass, MultipleValuatedFormField.class, "MultipleValuatedFormField", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getMultipleValuatedFormField_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, MultipleValuatedFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getMultipleValuatedFormField_DefaultValueAfterEvent(), ecorePackage.getEString(), "defaultValueAfterEvent", null, 0, 1, MultipleValuatedFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMultipleValuatedFormField_Enum(), theProcessPackage.getData(), null, "enum", null, 0, 1, MultipleValuatedFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMultipleValuatedFormField_EnumAfterEvent(), theProcessPackage.getData(), null, "enumAfterEvent", null, 0, 1, MultipleValuatedFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getMultipleValuatedFormField_Literals(), ecorePackage.getEString(), "literals", null, 0, -1, MultipleValuatedFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getMultipleValuatedFormField_LiteralsAfterEvent(), ecorePackage.getEString(), "literalsAfterEvent", null, 0, -1, MultipleValuatedFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMultipleValuatedFormField_DefaultConnectors(), theProcessPackage.getConnector(), null, "defaultConnectors", null, 0, -1, MultipleValuatedFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMultipleValuatedFormField_DefaultAfterEventConnectors(), theProcessPackage.getConnector(), null, "defaultAfterEventConnectors", null, 0, -1, MultipleValuatedFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(singleValuatedFormFieldEClass, SingleValuatedFormField.class, "SingleValuatedFormField", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(checkBoxMultipleFormFieldEClass, CheckBoxMultipleFormField.class, "CheckBoxMultipleFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(comboFormFieldEClass, ComboFormField.class, "ComboFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(dateFormFieldEClass, DateFormField.class, "DateFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getDateFormField_InitialFormat(), ecorePackage.getEString(), "initialFormat", null, 0, 1, DateFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDateFormField_DisplayFormat(), ecorePackage.getEString(), "displayFormat", null, 0, 1, DateFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(listFormFieldEClass, ListFormField.class, "ListFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getListFormField_MaxHeigth(), ecorePackage.getEInt(), "maxHeigth", null, 0, 1, ListFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(passwordFormFieldEClass, PasswordFormField.class, "PasswordFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPasswordFormField_MaxLength(), ecorePackage.getEInt(), "maxLength", null, 0, 1, PasswordFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(radioFormFieldEClass, RadioFormField.class, "RadioFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(selectFormFieldEClass, SelectFormField.class, "SelectFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(textFormFieldEClass, TextFormField.class, "TextFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTextFormField_MaxLength(), ecorePackage.getEInt(), "maxLength", null, 0, 1, TextFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(textAreaFormFieldEClass, TextAreaFormField.class, "TextAreaFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTextAreaFormField_MaxLength(), ecorePackage.getEInt(), "maxLength", null, 0, 1, TextAreaFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getTextAreaFormField_MaxHeigth(), ecorePackage.getEInt(), "maxHeigth", null, 0, 1, TextAreaFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(richTextAreaFormFieldEClass, RichTextAreaFormField.class, "RichTextAreaFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(formButtonEClass, FormButton.class, "FormButton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getFormButton_LabelBehavior(), ecorePackage.getEBooleanObject(), "labelBehavior", "false", 0, 1, FormButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(submitFormButtonEClass, SubmitFormButton.class, "SubmitFormButton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getSubmitFormButton_Scripts(), this.getGroovyScript(), null, "scripts", null, 0, -1, SubmitFormButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(previousFormButtonEClass, PreviousFormButton.class, "PreviousFormButton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(nextFormButtonEClass, NextFormButton.class, "NextFormButton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(groovyScriptEClass, GroovyScript.class, "GroovyScript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getGroovyScript_ExprScript(), ecorePackage.getEString(), "exprScript", "", 0, 1, GroovyScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getGroovyScript_InputScript(), ecorePackage.getEString(), "inputScript", null, 0, 1, GroovyScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getGroovyScript_SetVar(), theProcessPackage.getData(), null, "setVar", null, 0, 1, GroovyScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getGroovyScript_AllowHTMLInValues(), ecorePackage.getEBoolean(), "allowHTMLInValues", "false", 0, 1, GroovyScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getGroovyScript_SetVarScript(), ecorePackage.getEString(), "setVarScript", "", 0, 1, GroovyScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(infoEClass, Info.class, "Info", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(textInfoEClass, TextInfo.class, "TextInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(messageInfoEClass, MessageInfo.class, "MessageInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(checkBoxSingleFormFieldEClass, CheckBoxSingleFormField.class, "CheckBoxSingleFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(validatorEClass, Validator.class, "Validator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getValidator_ValidatorClass(), ecorePackage.getEString(), "validatorClass", null, 0, 1, Validator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getValidator_HtmlClass(), ecorePackage.getEString(), "htmlClass", null, 0, 1, Validator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getValidator_Label(), ecorePackage.getEString(), "label", null, 0, 1, Validator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getValidator_Name(), ecorePackage.getEString(), "name", null, 0, 1, Validator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getValidator_Parameter(), ecorePackage.getEString(), "parameter", "", 0, 1, Validator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getValidator_BelowField(), ecorePackage.getEBoolean(), "belowField", "true", 0, 1, Validator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(validableEClass, Validable.class, "Validable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getValidable_Validators(), this.getValidator(), null, "validators", null, 0, -1, Validable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getValidable_UseDefaultValidator(), ecorePackage.getEBooleanObject(), "useDefaultValidator", "true", 0, 1, Validable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getValidable_Below(), ecorePackage.getEBoolean(), "below", "true", 1, 1, Validable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(widgetLayoutInfoEClass, WidgetLayoutInfo.class, "WidgetLayoutInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getWidgetLayoutInfo_Line(), ecorePackage.getEInt(), "line", null, 0, 1, WidgetLayoutInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getWidgetLayoutInfo_Column(), ecorePackage.getEInt(), "column", null, 0, 1, WidgetLayoutInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getWidgetLayoutInfo_VerticalSpan(), ecorePackage.getEInt(), "verticalSpan", "1", 0, 1, WidgetLayoutInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getWidgetLayoutInfo_HorizontalSpan(), ecorePackage.getEInt(), "horizontalSpan", "1", 0, 1, WidgetLayoutInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(fileWidgetEClass, FileWidget.class, "FileWidget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getFileWidget_FileData(), theProcessPackage.getData(), null, "fileData", null, 0, 1, FileWidget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getFileWidget_DownloadOnly(), ecorePackage.getEBoolean(), "downloadOnly", "false", 0, 1, FileWidget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getFileWidget_UsePreview(), ecorePackage.getEBoolean(), "usePreview", "false", 0, 1, FileWidget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(columnEClass, Column.class, "Column", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getColumn_Width(), ecorePackage.getEString(), "width", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getColumn_Number(), ecorePackage.getEInt(), "number", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(lineEClass, Line.class, "Line", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getLine_Height(), ecorePackage.getEString(), "height", null, 0, 1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getLine_Number(), ecorePackage.getEInt(), "number", null, 0, 1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(imageWidgetEClass, ImageWidget.class, "ImageWidget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getImageWidget_ImgPath(), ecorePackage.getEString(), "imgPath", null, 0, 1, ImageWidget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getImageWidget_IsAnAttachment(), ecorePackage.getEBoolean(), "isAnAttachment", "false", 0, 1, ImageWidget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(hiddenWidgetEClass, HiddenWidget.class, "HiddenWidget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(durationFormFieldEClass, DurationFormField.class, "DurationFormField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getDurationFormField_Day(), ecorePackage.getEBooleanObject(), "day", "true", 1, 1, DurationFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getDurationFormField_Hour(), ecorePackage.getEBooleanObject(), "hour", "true", 1, 1, DurationFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getDurationFormField_Min(), ecorePackage.getEBooleanObject(), "min", "true", 1, 1, DurationFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getDurationFormField_Sec(), ecorePackage.getEBooleanObject(), "sec", "true", 1, 1, DurationFormField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(itemContainerEClass, ItemContainer.class, "ItemContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getItemContainer_ItemClass(), ecorePackage.getEString(), "itemClass", null, 0, 1, ItemContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(duplicableEClass, Duplicable.class, "Duplicable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getDuplicable_Duplicate(), ecorePackage.getEBoolean(), "duplicate", "false", 1, 1, Duplicable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getDuplicable_LimitNumberOfDuplication(), ecorePackage.getEBoolean(), "limitNumberOfDuplication", "false", 0, 1, Duplicable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getDuplicable_MaxNumberOfDuplication(), ecorePackage.getEString(), "maxNumberOfDuplication", "10", 1, 1, Duplicable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getDuplicable_LimitMinNumberOfDuplication(), ecorePackage.getEBoolean(), "limitMinNumberOfDuplication", "false", 0, 1, Duplicable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getDuplicable_MinNumberOfDuplication(), ecorePackage.getEString(), "minNumberOfDuplication", "2", 0, 1, Duplicable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getDuplicable_DisplayLabelForAdd(), ecorePackage.getEString(), "displayLabelForAdd", null, 0, 1, Duplicable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDuplicable_TooltipForAdd(), ecorePackage.getEString(), "tooltipForAdd", null, 0, 1, Duplicable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDuplicable_DisplayLabelForRemove(), ecorePackage.getEString(), "displayLabelForRemove", null, 0, 1, Duplicable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDuplicable_TooltipForRemove(), ecorePackage.getEString(), "tooltipForRemove", null, 0, 1, Duplicable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(tableEClass, Table.class, "Table", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTable_LeftColumnIsHeader(), ecorePackage.getEBoolean(), "leftColumnIsHeader", null, 0, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getTable_RightColumnIsHeader(), ecorePackage.getEBoolean(), "rightColumnIsHeader", null, 0, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getTable_FirstRowIsHeader(), ecorePackage.getEBoolean(), "firstRowIsHeader", null, 0, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getTable_LastRowIsHeader(), ecorePackage.getEBoolean(), "LastRowIsHeader", null, 0, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getTable_InitializedUsingCells(), ecorePackage.getEBoolean(), "initializedUsingCells", null, 0, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getTable_Cells(), ecorePackage.getEJavaObject(), "cells", null, 0, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(viewFormEClass, ViewForm.class, "ViewForm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum(eventDependencyTypeEEnum, EventDependencyType.class, "EventDependencyType"); //$NON-NLS-1$
        addEEnumLiteral(eventDependencyTypeEEnum, EventDependencyType.ON_VALUE_CHANGE);
        addEEnumLiteral(eventDependencyTypeEEnum, EventDependencyType.ON_CHANGE);
        addEEnumLiteral(eventDependencyTypeEEnum, EventDependencyType.ON_BLUR);
        addEEnumLiteral(eventDependencyTypeEEnum, EventDependencyType.ON_CLICK);

        initEEnum(labelPositionEEnum, LabelPosition.class, "LabelPosition"); //$NON-NLS-1$
        addEEnumLiteral(labelPositionEEnum, LabelPosition.LEFT);
        addEEnumLiteral(labelPositionEEnum, LabelPosition.RIGHT);
        addEEnumLiteral(labelPositionEEnum, LabelPosition.UP);
        addEEnumLiteral(labelPositionEEnum, LabelPosition.DOWN);

        // Create resource
        createResource(eNS_URI);
    }

} //FormPackageImpl
