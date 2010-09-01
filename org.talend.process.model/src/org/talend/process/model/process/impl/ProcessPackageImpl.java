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
package org.talend.process.model.process.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.talend.process.model.form.FormPackage;

import org.talend.process.model.form.impl.FormPackageImpl;

import org.talend.process.model.kpi.KpiPackage;

import org.talend.process.model.kpi.impl.KpiPackageImpl;

import org.talend.process.model.process.ANDGateway;
import org.talend.process.model.process.AbstractProcess;
import org.talend.process.model.process.Activity;
import org.talend.process.model.process.ActorType;
import org.talend.process.model.process.Assignable;
import org.talend.process.model.process.AssociatedFile;
import org.talend.process.model.process.Association;
import org.talend.process.model.process.AttachmentData;
import org.talend.process.model.process.AttachmentType;
import org.talend.process.model.process.BooleanType;
import org.talend.process.model.process.BoundaryEvent;
import org.talend.process.model.process.CatchLinkEvent;
import org.talend.process.model.process.CatchMessageEvent;
import org.talend.process.model.process.CatchSignalEvent;
import org.talend.process.model.process.ConnectableElement;
import org.talend.process.model.process.Connection;
import org.talend.process.model.process.Connector;
import org.talend.process.model.process.Data;
import org.talend.process.model.process.DataType;
import org.talend.process.model.process.DateType;
import org.talend.process.model.process.Deadline;
import org.talend.process.model.process.Element;
import org.talend.process.model.process.EndEvent;
import org.talend.process.model.process.EndMessageEvent;
import org.talend.process.model.process.EndSignalEvent;
import org.talend.process.model.process.EnumType;
import org.talend.process.model.process.Event;
import org.talend.process.model.process.EventObject;
import org.talend.process.model.process.FloatType;
import org.talend.process.model.process.FlowElement;
import org.talend.process.model.process.Gateway;
import org.talend.process.model.process.GatewayType;
import org.talend.process.model.process.Group;
import org.talend.process.model.process.InputMapping;
import org.talend.process.model.process.IntegerType;
import org.talend.process.model.process.IntermediateCatchMessageEvent;
import org.talend.process.model.process.IntermediateCatchSignalEvent;
import org.talend.process.model.process.IntermediateCatchTimerEvent;
import org.talend.process.model.process.IntermediateErrorCatchEvent;
import org.talend.process.model.process.IntermediateThrowMessageEvent;
import org.talend.process.model.process.IntermediateThrowSignalEvent;
import org.talend.process.model.process.JavaObjectData;
import org.talend.process.model.process.JavaType;
import org.talend.process.model.process.Lane;
import org.talend.process.model.process.LinkEvent;
import org.talend.process.model.process.MainProcess;
import org.talend.process.model.process.MessageEvent;
import org.talend.process.model.process.MessageFlow;
import org.talend.process.model.process.MultiInstantiation;
import org.talend.process.model.process.OutputMapping;
import org.talend.process.model.process.OutputParameterMapping;
import org.talend.process.model.process.PageFlow;
import org.talend.process.model.process.Parameter;
import org.talend.process.model.process.Pool;
import org.talend.process.model.process.ProcessFactory;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.RecapFlow;
import org.talend.process.model.process.ReceiveTask;
import org.talend.process.model.process.ResourceContainer;
import org.talend.process.model.process.ResourceFile;
import org.talend.process.model.process.ResourceFolder;
import org.talend.process.model.process.ScriptTask;
import org.talend.process.model.process.SendTask;
import org.talend.process.model.process.SequenceFlow;
import org.talend.process.model.process.ServiceTask;
import org.talend.process.model.process.SignalEvent;
import org.talend.process.model.process.SourceElement;
import org.talend.process.model.process.StartEvent;
import org.talend.process.model.process.StartMessageEvent;
import org.talend.process.model.process.StartSignalEvent;
import org.talend.process.model.process.StartTimerEvent;
import org.talend.process.model.process.StringType;
import org.talend.process.model.process.SubProcess;
import org.talend.process.model.process.TargetElement;
import org.talend.process.model.process.Task;
import org.talend.process.model.process.TextAnnotation;
import org.talend.process.model.process.TextAnnotationAttachment;
import org.talend.process.model.process.ThrowLinkEvent;
import org.talend.process.model.process.ThrowMessageEvent;
import org.talend.process.model.process.ThrowSignalEvent;
import org.talend.process.model.process.TimerEvent;
import org.talend.process.model.process.XMLData;
import org.talend.process.model.process.XMLType;
import org.talend.process.model.process.XORGateway;

import org.talend.process.model.simulation.SimulationPackage;

import org.talend.process.model.simulation.impl.SimulationPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessPackageImpl extends EPackageImpl implements ProcessPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass elementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractProcessEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mainProcessEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass taskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass gatewayEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass xorGatewayEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass andGatewayEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass connectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass messageFlowEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass associationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass sequenceFlowEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass laneEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass poolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass activityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass sendTaskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass receiveTaskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptTaskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass serviceTaskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass subProcessEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass flowElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass containerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass connectableElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass connectorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass parameterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass outputParameterMappingEClass = null;

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
    private EClass dataEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attachmentDataEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass javaObjectDataEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass xmlDataEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass integerTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stringTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dateTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass floatTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass booleanTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass enumTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass javaTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass xmlTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass outputMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attachmentTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass startEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass endEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass pageFlowEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resourceContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass associatedFileEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resourceFileEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resourceFolderEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass deadlineEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass multiInstantiationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass inputMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass messageEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass startMessageEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass endMessageEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass catchMessageEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass throwMessageEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateCatchMessageEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateThrowMessageEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textAnnotationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textAnnotationAttachmentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventObjectEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass timerEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass startTimerEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateCatchTimerEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass catchLinkEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass throwLinkEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass linkEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass signalEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass throwSignalEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass catchSignalEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass endSignalEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateThrowSignalEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateCatchSignalEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass startSignalEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass assignableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass recapFlowEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass boundaryEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateErrorCatchEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass sourceElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass targetElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum gatewayTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum actorTypeEEnum = null;

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
     * @see org.talend.process.model.process.ProcessPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ProcessPackageImpl() {
        super(eNS_URI, ProcessFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link ProcessPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ProcessPackage init() {
        if (isInited) return (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);

        // Obtain or create and register package
        ProcessPackageImpl theProcessPackage = (ProcessPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ProcessPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ProcessPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        FormPackageImpl theFormPackage = (FormPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FormPackage.eNS_URI) instanceof FormPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FormPackage.eNS_URI) : FormPackage.eINSTANCE);
        KpiPackageImpl theKpiPackage = (KpiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(KpiPackage.eNS_URI) instanceof KpiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(KpiPackage.eNS_URI) : KpiPackage.eINSTANCE);
        SimulationPackageImpl theSimulationPackage = (SimulationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimulationPackage.eNS_URI) instanceof SimulationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimulationPackage.eNS_URI) : SimulationPackage.eINSTANCE);

        // Create package meta-data objects
        theProcessPackage.createPackageContents();
        theFormPackage.createPackageContents();
        theKpiPackage.createPackageContents();
        theSimulationPackage.createPackageContents();

        // Initialize created meta-data
        theProcessPackage.initializePackageContents();
        theFormPackage.initializePackageContents();
        theKpiPackage.initializePackageContents();
        theSimulationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theProcessPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ProcessPackage.eNS_URI, theProcessPackage);
        return theProcessPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getElement() {
        return elementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getElement_Documentation() {
        return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getElement_Name() {
        return (EAttribute)elementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getElement_Label() {
        return (EAttribute)elementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getElement_TextAnnotationAttachment() {
        return (EReference)elementEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractProcess() {
        return abstractProcessEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractProcess_Version() {
        return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractProcess_Author() {
        return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractProcess_CreationDate() {
        return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractProcess_ModificationDate() {
        return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractProcess_Groups() {
        return (EReference)abstractProcessEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractProcess_Datatypes() {
        return (EReference)abstractProcessEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractProcess_Connections() {
        return (EReference)abstractProcessEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractProcess_MandatorySymbol() {
        return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractProcess_MandatoryClasses() {
        return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractProcess_MandatoryLabel() {
        return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractProcess_ErrorTemplate() {
        return (EReference)abstractProcessEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractProcess_ProcessTemplate() {
        return (EReference)abstractProcessEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractProcess_PageTemplate() {
        return (EReference)abstractProcessEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractProcess_ConsultationTemplate() {
        return (EReference)abstractProcessEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractProcess_LogInPage() {
        return (EReference)abstractProcessEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractProcess_WelcomePage() {
        return (EReference)abstractProcessEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractProcess_WelcomePageInternal() {
        return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractProcess_Categories() {
        return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMainProcess() {
        return mainProcessEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMainProcess_BonitaVersion() {
        return (EAttribute)mainProcessEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMainProcess_BonitaModelVersion() {
        return (EAttribute)mainProcessEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMainProcess_IncludedEntries() {
        return (EAttribute)mainProcessEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMainProcess_MessageConnections() {
        return (EReference)mainProcessEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTask() {
        return taskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTask_OverrideGroupsOfTheLane() {
        return (EAttribute)taskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTask_Priority() {
        return (EAttribute)taskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGateway() {
        return gatewayEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGateway_GatewayType() {
        return (EAttribute)gatewayEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getXORGateway() {
        return xorGatewayEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getANDGateway() {
        return andGatewayEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConnection() {
        return connectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnection_Source() {
        return (EReference)connectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnection_Target() {
        return (EReference)connectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMessageFlow() {
        return messageFlowEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMessageFlow_Source() {
        return (EReference)messageFlowEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMessageFlow_Target() {
        return (EReference)messageFlowEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAssociation() {
        return associationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAssociation_IsDirected() {
        return (EAttribute)associationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSequenceFlow() {
        return sequenceFlowEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSequenceFlow_Quantity() {
        return (EAttribute)sequenceFlowEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSequenceFlow_IsDefault() {
        return (EAttribute)sequenceFlowEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSequenceFlow_Condition() {
        return (EAttribute)sequenceFlowEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLane() {
        return laneEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPool() {
        return poolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getActivity() {
        return activityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getActivity_Duration() {
        return (EAttribute)activityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getActivity_Deadlines() {
        return (EReference)activityEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getActivity_MultiInstantiation() {
        return (EReference)activityEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getActivity_IsLoop() {
        return (EAttribute)activityEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getActivity_TestBefore() {
        return (EAttribute)activityEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getActivity_LoopCondition() {
        return (EAttribute)activityEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getActivity_LoopMaximum() {
        return (EAttribute)activityEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getActivity_BoundaryIntermediateEvents() {
        return (EReference)activityEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSendTask() {
        return sendTaskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReceiveTask() {
        return receiveTaskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScriptTask() {
        return scriptTaskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getServiceTask() {
        return serviceTaskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSubProcess() {
        return subProcessEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSubProcess_SubprocessName() {
        return (EAttribute)subProcessEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSubProcess_SubprocessVersion() {
        return (EAttribute)subProcessEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSubProcess_InputMappings() {
        return (EReference)subProcessEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSubProcess_OutputMappings() {
        return (EReference)subProcessEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFlowElement() {
        return flowElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFlowElement_Synchronous() {
        return (EAttribute)flowElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFlowElement_DynamicLabel() {
        return (EAttribute)flowElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFlowElement_DynamicDescription() {
        return (EAttribute)flowElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFlowElement_StepSummary() {
        return (EAttribute)flowElementEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getContainer() {
        return containerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getContainer_Elements() {
        return (EReference)containerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConnectableElement() {
        return connectableElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnectableElement_Connectors() {
        return (EReference)connectableElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnectableElement_Data() {
        return (EReference)connectableElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnectableElement_Kpis() {
        return (EReference)connectableElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConnector() {
        return connectorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnector_ConnectorId() {
        return (EAttribute)connectorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnector_ConfigurationId() {
        return (EAttribute)connectorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnector_Parameters() {
        return (EReference)connectorEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnector_Event() {
        return (EAttribute)connectorEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnector_IgnoreErrors() {
        return (EAttribute)connectorEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnector_Outputs() {
        return (EReference)connectorEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getParameter() {
        return parameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParameter_Key() {
        return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParameter_Value() {
        return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOutputParameterMapping() {
        return outputParameterMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOutputParameterMapping_ValueExpression() {
        return (EAttribute)outputParameterMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOutputParameterMapping_TargetData() {
        return (EReference)outputParameterMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOutputParameterMapping_AdditionalPath() {
        return (EAttribute)outputParameterMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOutputParameterMapping_TargetWidget() {
        return (EReference)outputParameterMappingEClass.getEStructuralFeatures().get(3);
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
    public EClass getData() {
        return dataEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getData_DataType() {
        return (EReference)dataEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getData_DefaultValue() {
        return (EAttribute)dataEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getData_Generated() {
        return (EAttribute)dataEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAttachmentData() {
        return attachmentDataEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttachmentData_BarPath() {
        return (EAttribute)attachmentDataEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJavaObjectData() {
        return javaObjectDataEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getJavaObjectData_ClassName() {
        return (EAttribute)javaObjectDataEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getXMLData() {
        return xmlDataEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getXMLData_Namespace() {
        return (EAttribute)xmlDataEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getXMLData_Type() {
        return (EAttribute)xmlDataEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataType() {
        return dataTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntegerType() {
        return integerTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStringType() {
        return stringTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDateType() {
        return dateTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFloatType() {
        return floatTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBooleanType() {
        return booleanTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEnumType() {
        return enumTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEnumType_Literals() {
        return (EAttribute)enumTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJavaType() {
        return javaTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getXMLType() {
        return xmlTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOutputMapping() {
        return outputMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOutputMapping_SubprocessSource() {
        return (EAttribute)outputMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOutputMapping_ProcessTarget() {
        return (EReference)outputMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAttachmentType() {
        return attachmentTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStartEvent() {
        return startEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEndEvent() {
        return endEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEvent() {
        return eventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPageFlow() {
        return pageFlowEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPageFlow_Form() {
        return (EReference)pageFlowEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPageFlow_ByPassFormsGeneration() {
        return (EAttribute)pageFlowEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPageFlow_ConfirmationTemplate() {
        return (EReference)pageFlowEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPageFlow_ConfirmationMessage() {
        return (EAttribute)pageFlowEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPageFlow_RegExpToHideDefaultField() {
        return (EAttribute)pageFlowEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPageFlow_UseRegExpToHideDefaultField() {
        return (EAttribute)pageFlowEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPageFlow_ViewForm() {
        return (EReference)pageFlowEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPageFlow_UseViewForm() {
        return (EAttribute)pageFlowEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResourceContainer() {
        return resourceContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResourceContainer_ResourceFolders() {
        return (EReference)resourceContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResourceContainer_HtmlTemplate() {
        return (EReference)resourceContainerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResourceContainer_ResourceFiles() {
        return (EReference)resourceContainerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResourceContainer_ResourceJars() {
        return (EAttribute)resourceContainerEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResourceContainer_ResourceValidators() {
        return (EAttribute)resourceContainerEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAssociatedFile() {
        return associatedFileEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAssociatedFile_Path() {
        return (EAttribute)associatedFileEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAssociatedFile_WarPath() {
        return (EAttribute)associatedFileEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResourceFile() {
        return resourceFileEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResourceFolder() {
        return resourceFolderEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResourceFolder_ResourceFiles() {
        return (EReference)resourceFolderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDeadline() {
        return deadlineEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDeadline_Condition() {
        return (EAttribute)deadlineEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDeadline_Connector() {
        return (EReference)deadlineEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMultiInstantiation() {
        return multiInstantiationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMultiInstantiation_Enabled() {
        return (EAttribute)multiInstantiationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMultiInstantiation_ActivityData() {
        return (EReference)multiInstantiationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMultiInstantiation_Instantiator() {
        return (EReference)multiInstantiationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMultiInstantiation_JoinChecker() {
        return (EReference)multiInstantiationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInputMapping() {
        return inputMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInputMapping_ProcessSource() {
        return (EReference)inputMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInputMapping_SubprocessTarget() {
        return (EAttribute)inputMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMessageEvent() {
        return messageEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStartMessageEvent() {
        return startMessageEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEndMessageEvent() {
        return endMessageEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCatchMessageEvent() {
        return catchMessageEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCatchMessageEvent_Event() {
        return (EAttribute)catchMessageEventEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCatchMessageEvent_IncomingMessag() {
        return (EReference)catchMessageEventEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCatchMessageEvent_Matcher() {
        return (EAttribute)catchMessageEventEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getThrowMessageEvent() {
        return throwMessageEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getThrowMessageEvent_Events() {
        return (EReference)throwMessageEventEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getThrowMessageEvent_OutgoingMessages() {
        return (EReference)throwMessageEventEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateCatchMessageEvent() {
        return intermediateCatchMessageEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateThrowMessageEvent() {
        return intermediateThrowMessageEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextAnnotation() {
        return textAnnotationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextAnnotation_Text() {
        return (EAttribute)textAnnotationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextAnnotationAttachment() {
        return textAnnotationAttachmentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTextAnnotationAttachment_Source() {
        return (EReference)textAnnotationAttachmentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTextAnnotationAttachment_Target() {
        return (EReference)textAnnotationAttachmentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEventObject() {
        return eventObjectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEventObject_ThrowEvent() {
        return (EAttribute)eventObjectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEventObject_Source() {
        return (EReference)eventObjectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEventObject_Ttl() {
        return (EAttribute)eventObjectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEventObject_TargetProcessName() {
        return (EAttribute)eventObjectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEventObject_TargetElementName() {
        return (EAttribute)eventObjectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTimerEvent() {
        return timerEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTimerEvent_Condition() {
        return (EAttribute)timerEventEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStartTimerEvent() {
        return startTimerEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateCatchTimerEvent() {
        return intermediateCatchTimerEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCatchLinkEvent() {
        return catchLinkEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCatchLinkEvent_From() {
        return (EReference)catchLinkEventEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getThrowLinkEvent() {
        return throwLinkEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getThrowLinkEvent_To() {
        return (EReference)throwLinkEventEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLinkEvent() {
        return linkEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSignalEvent() {
        return signalEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getThrowSignalEvent() {
        return throwSignalEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getThrowSignalEvent_Events() {
        return (EReference)throwSignalEventEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCatchSignalEvent() {
        return catchSignalEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCatchSignalEvent_Signal() {
        return (EAttribute)catchSignalEventEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCatchSignalEvent_Matcher() {
        return (EAttribute)catchSignalEventEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEndSignalEvent() {
        return endSignalEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateThrowSignalEvent() {
        return intermediateThrowSignalEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateCatchSignalEvent() {
        return intermediateCatchSignalEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStartSignalEvent() {
        return startSignalEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAssignable() {
        return assignableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAssignable_User() {
        return (EAttribute)assignableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAssignable_Filters() {
        return (EReference)assignableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAssignable_Groups() {
        return (EReference)assignableEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAssignable_ActorType() {
        return (EAttribute)assignableEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRecapFlow() {
        return recapFlowEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRecapFlow_RecapForms() {
        return (EReference)recapFlowEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBoundaryEvent() {
        return boundaryEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateErrorCatchEvent() {
        return intermediateErrorCatchEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSourceElement() {
        return sourceElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSourceElement_Outgoing() {
        return (EReference)sourceElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTargetElement() {
        return targetElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTargetElement_Incoming() {
        return (EReference)targetElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getGatewayType() {
        return gatewayTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getActorType() {
        return actorTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessFactory getProcessFactory() {
        return (ProcessFactory)getEFactoryInstance();
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
        elementEClass = createEClass(ELEMENT);
        createEAttribute(elementEClass, ELEMENT__DOCUMENTATION);
        createEAttribute(elementEClass, ELEMENT__NAME);
        createEAttribute(elementEClass, ELEMENT__LABEL);
        createEReference(elementEClass, ELEMENT__TEXT_ANNOTATION_ATTACHMENT);

        abstractProcessEClass = createEClass(ABSTRACT_PROCESS);
        createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__VERSION);
        createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__AUTHOR);
        createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__CREATION_DATE);
        createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__MODIFICATION_DATE);
        createEReference(abstractProcessEClass, ABSTRACT_PROCESS__GROUPS);
        createEReference(abstractProcessEClass, ABSTRACT_PROCESS__DATATYPES);
        createEReference(abstractProcessEClass, ABSTRACT_PROCESS__CONNECTIONS);
        createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__MANDATORY_SYMBOL);
        createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__MANDATORY_CLASSES);
        createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__MANDATORY_LABEL);
        createEReference(abstractProcessEClass, ABSTRACT_PROCESS__ERROR_TEMPLATE);
        createEReference(abstractProcessEClass, ABSTRACT_PROCESS__PROCESS_TEMPLATE);
        createEReference(abstractProcessEClass, ABSTRACT_PROCESS__PAGE_TEMPLATE);
        createEReference(abstractProcessEClass, ABSTRACT_PROCESS__CONSULTATION_TEMPLATE);
        createEReference(abstractProcessEClass, ABSTRACT_PROCESS__LOG_IN_PAGE);
        createEReference(abstractProcessEClass, ABSTRACT_PROCESS__WELCOME_PAGE);
        createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__WELCOME_PAGE_INTERNAL);
        createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__CATEGORIES);

        mainProcessEClass = createEClass(MAIN_PROCESS);
        createEAttribute(mainProcessEClass, MAIN_PROCESS__BONITA_VERSION);
        createEAttribute(mainProcessEClass, MAIN_PROCESS__BONITA_MODEL_VERSION);
        createEAttribute(mainProcessEClass, MAIN_PROCESS__INCLUDED_ENTRIES);
        createEReference(mainProcessEClass, MAIN_PROCESS__MESSAGE_CONNECTIONS);

        taskEClass = createEClass(TASK);
        createEAttribute(taskEClass, TASK__OVERRIDE_GROUPS_OF_THE_LANE);
        createEAttribute(taskEClass, TASK__PRIORITY);

        gatewayEClass = createEClass(GATEWAY);
        createEAttribute(gatewayEClass, GATEWAY__GATEWAY_TYPE);

        xorGatewayEClass = createEClass(XOR_GATEWAY);

        andGatewayEClass = createEClass(AND_GATEWAY);

        connectionEClass = createEClass(CONNECTION);
        createEReference(connectionEClass, CONNECTION__SOURCE);
        createEReference(connectionEClass, CONNECTION__TARGET);

        messageFlowEClass = createEClass(MESSAGE_FLOW);
        createEReference(messageFlowEClass, MESSAGE_FLOW__SOURCE);
        createEReference(messageFlowEClass, MESSAGE_FLOW__TARGET);

        associationEClass = createEClass(ASSOCIATION);
        createEAttribute(associationEClass, ASSOCIATION__IS_DIRECTED);

        sequenceFlowEClass = createEClass(SEQUENCE_FLOW);
        createEAttribute(sequenceFlowEClass, SEQUENCE_FLOW__QUANTITY);
        createEAttribute(sequenceFlowEClass, SEQUENCE_FLOW__IS_DEFAULT);
        createEAttribute(sequenceFlowEClass, SEQUENCE_FLOW__CONDITION);

        laneEClass = createEClass(LANE);

        poolEClass = createEClass(POOL);

        activityEClass = createEClass(ACTIVITY);
        createEAttribute(activityEClass, ACTIVITY__DURATION);
        createEReference(activityEClass, ACTIVITY__DEADLINES);
        createEReference(activityEClass, ACTIVITY__MULTI_INSTANTIATION);
        createEAttribute(activityEClass, ACTIVITY__IS_LOOP);
        createEAttribute(activityEClass, ACTIVITY__TEST_BEFORE);
        createEAttribute(activityEClass, ACTIVITY__LOOP_CONDITION);
        createEAttribute(activityEClass, ACTIVITY__LOOP_MAXIMUM);
        createEReference(activityEClass, ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS);

        sendTaskEClass = createEClass(SEND_TASK);

        receiveTaskEClass = createEClass(RECEIVE_TASK);

        scriptTaskEClass = createEClass(SCRIPT_TASK);

        serviceTaskEClass = createEClass(SERVICE_TASK);

        subProcessEClass = createEClass(SUB_PROCESS);
        createEAttribute(subProcessEClass, SUB_PROCESS__SUBPROCESS_NAME);
        createEAttribute(subProcessEClass, SUB_PROCESS__SUBPROCESS_VERSION);
        createEReference(subProcessEClass, SUB_PROCESS__INPUT_MAPPINGS);
        createEReference(subProcessEClass, SUB_PROCESS__OUTPUT_MAPPINGS);

        flowElementEClass = createEClass(FLOW_ELEMENT);
        createEAttribute(flowElementEClass, FLOW_ELEMENT__SYNCHRONOUS);
        createEAttribute(flowElementEClass, FLOW_ELEMENT__DYNAMIC_LABEL);
        createEAttribute(flowElementEClass, FLOW_ELEMENT__DYNAMIC_DESCRIPTION);
        createEAttribute(flowElementEClass, FLOW_ELEMENT__STEP_SUMMARY);

        containerEClass = createEClass(CONTAINER);
        createEReference(containerEClass, CONTAINER__ELEMENTS);

        connectableElementEClass = createEClass(CONNECTABLE_ELEMENT);
        createEReference(connectableElementEClass, CONNECTABLE_ELEMENT__CONNECTORS);
        createEReference(connectableElementEClass, CONNECTABLE_ELEMENT__DATA);
        createEReference(connectableElementEClass, CONNECTABLE_ELEMENT__KPIS);

        connectorEClass = createEClass(CONNECTOR);
        createEAttribute(connectorEClass, CONNECTOR__CONNECTOR_ID);
        createEAttribute(connectorEClass, CONNECTOR__CONFIGURATION_ID);
        createEReference(connectorEClass, CONNECTOR__PARAMETERS);
        createEAttribute(connectorEClass, CONNECTOR__EVENT);
        createEAttribute(connectorEClass, CONNECTOR__IGNORE_ERRORS);
        createEReference(connectorEClass, CONNECTOR__OUTPUTS);

        parameterEClass = createEClass(PARAMETER);
        createEAttribute(parameterEClass, PARAMETER__KEY);
        createEAttribute(parameterEClass, PARAMETER__VALUE);

        outputParameterMappingEClass = createEClass(OUTPUT_PARAMETER_MAPPING);
        createEAttribute(outputParameterMappingEClass, OUTPUT_PARAMETER_MAPPING__VALUE_EXPRESSION);
        createEReference(outputParameterMappingEClass, OUTPUT_PARAMETER_MAPPING__TARGET_DATA);
        createEAttribute(outputParameterMappingEClass, OUTPUT_PARAMETER_MAPPING__ADDITIONAL_PATH);
        createEReference(outputParameterMappingEClass, OUTPUT_PARAMETER_MAPPING__TARGET_WIDGET);

        groupEClass = createEClass(GROUP);

        dataEClass = createEClass(DATA);
        createEReference(dataEClass, DATA__DATA_TYPE);
        createEAttribute(dataEClass, DATA__DEFAULT_VALUE);
        createEAttribute(dataEClass, DATA__GENERATED);

        attachmentDataEClass = createEClass(ATTACHMENT_DATA);
        createEAttribute(attachmentDataEClass, ATTACHMENT_DATA__BAR_PATH);

        javaObjectDataEClass = createEClass(JAVA_OBJECT_DATA);
        createEAttribute(javaObjectDataEClass, JAVA_OBJECT_DATA__CLASS_NAME);

        xmlDataEClass = createEClass(XML_DATA);
        createEAttribute(xmlDataEClass, XML_DATA__NAMESPACE);
        createEAttribute(xmlDataEClass, XML_DATA__TYPE);

        dataTypeEClass = createEClass(DATA_TYPE);

        integerTypeEClass = createEClass(INTEGER_TYPE);

        stringTypeEClass = createEClass(STRING_TYPE);

        dateTypeEClass = createEClass(DATE_TYPE);

        floatTypeEClass = createEClass(FLOAT_TYPE);

        booleanTypeEClass = createEClass(BOOLEAN_TYPE);

        enumTypeEClass = createEClass(ENUM_TYPE);
        createEAttribute(enumTypeEClass, ENUM_TYPE__LITERALS);

        javaTypeEClass = createEClass(JAVA_TYPE);

        xmlTypeEClass = createEClass(XML_TYPE);

        outputMappingEClass = createEClass(OUTPUT_MAPPING);
        createEAttribute(outputMappingEClass, OUTPUT_MAPPING__SUBPROCESS_SOURCE);
        createEReference(outputMappingEClass, OUTPUT_MAPPING__PROCESS_TARGET);

        attachmentTypeEClass = createEClass(ATTACHMENT_TYPE);

        startEventEClass = createEClass(START_EVENT);

        endEventEClass = createEClass(END_EVENT);

        eventEClass = createEClass(EVENT);

        pageFlowEClass = createEClass(PAGE_FLOW);
        createEReference(pageFlowEClass, PAGE_FLOW__FORM);
        createEAttribute(pageFlowEClass, PAGE_FLOW__BY_PASS_FORMS_GENERATION);
        createEReference(pageFlowEClass, PAGE_FLOW__CONFIRMATION_TEMPLATE);
        createEAttribute(pageFlowEClass, PAGE_FLOW__CONFIRMATION_MESSAGE);
        createEAttribute(pageFlowEClass, PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD);
        createEAttribute(pageFlowEClass, PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD);
        createEReference(pageFlowEClass, PAGE_FLOW__VIEW_FORM);
        createEAttribute(pageFlowEClass, PAGE_FLOW__USE_VIEW_FORM);

        resourceContainerEClass = createEClass(RESOURCE_CONTAINER);
        createEReference(resourceContainerEClass, RESOURCE_CONTAINER__RESOURCE_FOLDERS);
        createEReference(resourceContainerEClass, RESOURCE_CONTAINER__HTML_TEMPLATE);
        createEReference(resourceContainerEClass, RESOURCE_CONTAINER__RESOURCE_FILES);
        createEAttribute(resourceContainerEClass, RESOURCE_CONTAINER__RESOURCE_JARS);
        createEAttribute(resourceContainerEClass, RESOURCE_CONTAINER__RESOURCE_VALIDATORS);

        associatedFileEClass = createEClass(ASSOCIATED_FILE);
        createEAttribute(associatedFileEClass, ASSOCIATED_FILE__PATH);
        createEAttribute(associatedFileEClass, ASSOCIATED_FILE__WAR_PATH);

        resourceFileEClass = createEClass(RESOURCE_FILE);

        resourceFolderEClass = createEClass(RESOURCE_FOLDER);
        createEReference(resourceFolderEClass, RESOURCE_FOLDER__RESOURCE_FILES);

        deadlineEClass = createEClass(DEADLINE);
        createEAttribute(deadlineEClass, DEADLINE__CONDITION);
        createEReference(deadlineEClass, DEADLINE__CONNECTOR);

        multiInstantiationEClass = createEClass(MULTI_INSTANTIATION);
        createEAttribute(multiInstantiationEClass, MULTI_INSTANTIATION__ENABLED);
        createEReference(multiInstantiationEClass, MULTI_INSTANTIATION__ACTIVITY_DATA);
        createEReference(multiInstantiationEClass, MULTI_INSTANTIATION__INSTANTIATOR);
        createEReference(multiInstantiationEClass, MULTI_INSTANTIATION__JOIN_CHECKER);

        inputMappingEClass = createEClass(INPUT_MAPPING);
        createEReference(inputMappingEClass, INPUT_MAPPING__PROCESS_SOURCE);
        createEAttribute(inputMappingEClass, INPUT_MAPPING__SUBPROCESS_TARGET);

        messageEventEClass = createEClass(MESSAGE_EVENT);

        startMessageEventEClass = createEClass(START_MESSAGE_EVENT);

        endMessageEventEClass = createEClass(END_MESSAGE_EVENT);

        catchMessageEventEClass = createEClass(CATCH_MESSAGE_EVENT);
        createEAttribute(catchMessageEventEClass, CATCH_MESSAGE_EVENT__EVENT);
        createEReference(catchMessageEventEClass, CATCH_MESSAGE_EVENT__INCOMING_MESSAG);
        createEAttribute(catchMessageEventEClass, CATCH_MESSAGE_EVENT__MATCHER);

        throwMessageEventEClass = createEClass(THROW_MESSAGE_EVENT);
        createEReference(throwMessageEventEClass, THROW_MESSAGE_EVENT__EVENTS);
        createEReference(throwMessageEventEClass, THROW_MESSAGE_EVENT__OUTGOING_MESSAGES);

        intermediateCatchMessageEventEClass = createEClass(INTERMEDIATE_CATCH_MESSAGE_EVENT);

        intermediateThrowMessageEventEClass = createEClass(INTERMEDIATE_THROW_MESSAGE_EVENT);

        textAnnotationEClass = createEClass(TEXT_ANNOTATION);
        createEAttribute(textAnnotationEClass, TEXT_ANNOTATION__TEXT);

        textAnnotationAttachmentEClass = createEClass(TEXT_ANNOTATION_ATTACHMENT);
        createEReference(textAnnotationAttachmentEClass, TEXT_ANNOTATION_ATTACHMENT__SOURCE);
        createEReference(textAnnotationAttachmentEClass, TEXT_ANNOTATION_ATTACHMENT__TARGET);

        eventObjectEClass = createEClass(EVENT_OBJECT);
        createEAttribute(eventObjectEClass, EVENT_OBJECT__THROW_EVENT);
        createEReference(eventObjectEClass, EVENT_OBJECT__SOURCE);
        createEAttribute(eventObjectEClass, EVENT_OBJECT__TTL);
        createEAttribute(eventObjectEClass, EVENT_OBJECT__TARGET_PROCESS_NAME);
        createEAttribute(eventObjectEClass, EVENT_OBJECT__TARGET_ELEMENT_NAME);

        timerEventEClass = createEClass(TIMER_EVENT);
        createEAttribute(timerEventEClass, TIMER_EVENT__CONDITION);

        startTimerEventEClass = createEClass(START_TIMER_EVENT);

        intermediateCatchTimerEventEClass = createEClass(INTERMEDIATE_CATCH_TIMER_EVENT);

        catchLinkEventEClass = createEClass(CATCH_LINK_EVENT);
        createEReference(catchLinkEventEClass, CATCH_LINK_EVENT__FROM);

        throwLinkEventEClass = createEClass(THROW_LINK_EVENT);
        createEReference(throwLinkEventEClass, THROW_LINK_EVENT__TO);

        linkEventEClass = createEClass(LINK_EVENT);

        signalEventEClass = createEClass(SIGNAL_EVENT);

        throwSignalEventEClass = createEClass(THROW_SIGNAL_EVENT);
        createEReference(throwSignalEventEClass, THROW_SIGNAL_EVENT__EVENTS);

        catchSignalEventEClass = createEClass(CATCH_SIGNAL_EVENT);
        createEAttribute(catchSignalEventEClass, CATCH_SIGNAL_EVENT__SIGNAL);
        createEAttribute(catchSignalEventEClass, CATCH_SIGNAL_EVENT__MATCHER);

        endSignalEventEClass = createEClass(END_SIGNAL_EVENT);

        intermediateThrowSignalEventEClass = createEClass(INTERMEDIATE_THROW_SIGNAL_EVENT);

        intermediateCatchSignalEventEClass = createEClass(INTERMEDIATE_CATCH_SIGNAL_EVENT);

        startSignalEventEClass = createEClass(START_SIGNAL_EVENT);

        assignableEClass = createEClass(ASSIGNABLE);
        createEAttribute(assignableEClass, ASSIGNABLE__USER);
        createEReference(assignableEClass, ASSIGNABLE__FILTERS);
        createEReference(assignableEClass, ASSIGNABLE__GROUPS);
        createEAttribute(assignableEClass, ASSIGNABLE__ACTOR_TYPE);

        recapFlowEClass = createEClass(RECAP_FLOW);
        createEReference(recapFlowEClass, RECAP_FLOW__RECAP_FORMS);

        boundaryEventEClass = createEClass(BOUNDARY_EVENT);

        intermediateErrorCatchEventEClass = createEClass(INTERMEDIATE_ERROR_CATCH_EVENT);

        sourceElementEClass = createEClass(SOURCE_ELEMENT);
        createEReference(sourceElementEClass, SOURCE_ELEMENT__OUTGOING);

        targetElementEClass = createEClass(TARGET_ELEMENT);
        createEReference(targetElementEClass, TARGET_ELEMENT__INCOMING);

        // Create enums
        gatewayTypeEEnum = createEEnum(GATEWAY_TYPE);
        actorTypeEEnum = createEEnum(ACTOR_TYPE);
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
        SimulationPackage theSimulationPackage = (SimulationPackage)EPackage.Registry.INSTANCE.getEPackage(SimulationPackage.eNS_URI);
        KpiPackage theKpiPackage = (KpiPackage)EPackage.Registry.INSTANCE.getEPackage(KpiPackage.eNS_URI);
        FormPackage theFormPackage = (FormPackage)EPackage.Registry.INSTANCE.getEPackage(FormPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        abstractProcessEClass.getESuperTypes().add(this.getContainer());
        abstractProcessEClass.getESuperTypes().add(this.getResourceContainer());
        abstractProcessEClass.getESuperTypes().add(this.getPageFlow());
        abstractProcessEClass.getESuperTypes().add(theSimulationPackage.getSimulationAbstractProcess());
        abstractProcessEClass.getESuperTypes().add(this.getRecapFlow());
        mainProcessEClass.getESuperTypes().add(this.getAbstractProcess());
        taskEClass.getESuperTypes().add(this.getActivity());
        taskEClass.getESuperTypes().add(this.getPageFlow());
        taskEClass.getESuperTypes().add(this.getResourceContainer());
        taskEClass.getESuperTypes().add(this.getAssignable());
        gatewayEClass.getESuperTypes().add(this.getFlowElement());
        xorGatewayEClass.getESuperTypes().add(this.getGateway());
        andGatewayEClass.getESuperTypes().add(this.getGateway());
        connectionEClass.getESuperTypes().add(this.getElement());
        connectionEClass.getESuperTypes().add(theSimulationPackage.getSimulationTransition());
        messageFlowEClass.getESuperTypes().add(this.getElement());
        associationEClass.getESuperTypes().add(this.getConnection());
        sequenceFlowEClass.getESuperTypes().add(this.getConnection());
        laneEClass.getESuperTypes().add(this.getContainer());
        laneEClass.getESuperTypes().add(this.getAssignable());
        poolEClass.getESuperTypes().add(this.getAbstractProcess());
        activityEClass.getESuperTypes().add(this.getFlowElement());
        activityEClass.getESuperTypes().add(this.getConnectableElement());
        sendTaskEClass.getESuperTypes().add(this.getActivity());
        sendTaskEClass.getESuperTypes().add(this.getThrowMessageEvent());
        receiveTaskEClass.getESuperTypes().add(this.getActivity());
        receiveTaskEClass.getESuperTypes().add(this.getCatchMessageEvent());
        scriptTaskEClass.getESuperTypes().add(this.getActivity());
        serviceTaskEClass.getESuperTypes().add(this.getActivity());
        subProcessEClass.getESuperTypes().add(this.getActivity());
        flowElementEClass.getESuperTypes().add(this.getElement());
        flowElementEClass.getESuperTypes().add(theSimulationPackage.getSimulationActivity());
        flowElementEClass.getESuperTypes().add(this.getSourceElement());
        flowElementEClass.getESuperTypes().add(this.getTargetElement());
        containerEClass.getESuperTypes().add(this.getElement());
        connectableElementEClass.getESuperTypes().add(this.getElement());
        connectorEClass.getESuperTypes().add(this.getElement());
        groupEClass.getESuperTypes().add(this.getConnector());
        dataEClass.getESuperTypes().add(this.getElement());
        attachmentDataEClass.getESuperTypes().add(this.getData());
        javaObjectDataEClass.getESuperTypes().add(this.getData());
        xmlDataEClass.getESuperTypes().add(this.getData());
        dataTypeEClass.getESuperTypes().add(this.getElement());
        integerTypeEClass.getESuperTypes().add(this.getDataType());
        stringTypeEClass.getESuperTypes().add(this.getDataType());
        dateTypeEClass.getESuperTypes().add(this.getStringType());
        floatTypeEClass.getESuperTypes().add(this.getDataType());
        booleanTypeEClass.getESuperTypes().add(this.getDataType());
        enumTypeEClass.getESuperTypes().add(this.getDataType());
        javaTypeEClass.getESuperTypes().add(this.getDataType());
        xmlTypeEClass.getESuperTypes().add(this.getDataType());
        attachmentTypeEClass.getESuperTypes().add(this.getDataType());
        startEventEClass.getESuperTypes().add(this.getEvent());
        endEventEClass.getESuperTypes().add(this.getEvent());
        eventEClass.getESuperTypes().add(this.getFlowElement());
        pageFlowEClass.getESuperTypes().add(this.getConnectableElement());
        resourceFileEClass.getESuperTypes().add(this.getAssociatedFile());
        resourceFolderEClass.getESuperTypes().add(this.getAssociatedFile());
        multiInstantiationEClass.getESuperTypes().add(this.getConnector());
        messageEventEClass.getESuperTypes().add(this.getEvent());
        startMessageEventEClass.getESuperTypes().add(this.getCatchMessageEvent());
        endMessageEventEClass.getESuperTypes().add(this.getThrowMessageEvent());
        catchMessageEventEClass.getESuperTypes().add(this.getMessageEvent());
        catchMessageEventEClass.getESuperTypes().add(this.getConnectableElement());
        throwMessageEventEClass.getESuperTypes().add(this.getMessageEvent());
        intermediateCatchMessageEventEClass.getESuperTypes().add(this.getCatchMessageEvent());
        intermediateThrowMessageEventEClass.getESuperTypes().add(this.getThrowMessageEvent());
        textAnnotationEClass.getESuperTypes().add(this.getElement());
        eventObjectEClass.getESuperTypes().add(this.getConnectableElement());
        timerEventEClass.getESuperTypes().add(this.getEvent());
        timerEventEClass.getESuperTypes().add(this.getConnectableElement());
        startTimerEventEClass.getESuperTypes().add(this.getTimerEvent());
        intermediateCatchTimerEventEClass.getESuperTypes().add(this.getTimerEvent());
        catchLinkEventEClass.getESuperTypes().add(this.getLinkEvent());
        throwLinkEventEClass.getESuperTypes().add(this.getLinkEvent());
        linkEventEClass.getESuperTypes().add(this.getEvent());
        signalEventEClass.getESuperTypes().add(this.getEvent());
        throwSignalEventEClass.getESuperTypes().add(this.getSignalEvent());
        catchSignalEventEClass.getESuperTypes().add(this.getSignalEvent());
        catchSignalEventEClass.getESuperTypes().add(this.getConnectableElement());
        endSignalEventEClass.getESuperTypes().add(this.getThrowSignalEvent());
        intermediateThrowSignalEventEClass.getESuperTypes().add(this.getThrowSignalEvent());
        intermediateCatchSignalEventEClass.getESuperTypes().add(this.getCatchSignalEvent());
        startSignalEventEClass.getESuperTypes().add(this.getCatchSignalEvent());
        boundaryEventEClass.getESuperTypes().add(this.getElement());
        boundaryEventEClass.getESuperTypes().add(this.getSourceElement());
        intermediateErrorCatchEventEClass.getESuperTypes().add(this.getBoundaryEvent());
        sourceElementEClass.getESuperTypes().add(this.getElement());
        targetElementEClass.getESuperTypes().add(this.getElement());

        // Initialize classes and features; add operations and parameters
        initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getElement_Documentation(), ecorePackage.getEString(), "documentation", "", 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getElement_Name(), ecorePackage.getEString(), "name", "", 1, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getElement_Label(), ecorePackage.getEString(), "label", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getElement_TextAnnotationAttachment(), this.getTextAnnotationAttachment(), this.getTextAnnotationAttachment_Target(), "textAnnotationAttachment", null, 0, -1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(abstractProcessEClass, AbstractProcess.class, "AbstractProcess", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getAbstractProcess_Version(), ecorePackage.getEString(), "version", "1.0", 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getAbstractProcess_Author(), ecorePackage.getEString(), "author", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAbstractProcess_CreationDate(), ecorePackage.getEDate(), "creationDate", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAbstractProcess_ModificationDate(), ecorePackage.getEDate(), "modificationDate", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAbstractProcess_Groups(), this.getGroup(), null, "groups", null, 0, -1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAbstractProcess_Datatypes(), this.getDataType(), null, "datatypes", null, 0, -1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAbstractProcess_Connections(), this.getConnection(), null, "connections", null, 0, -1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAbstractProcess_MandatorySymbol(), ecorePackage.getEString(), "mandatorySymbol", "*", 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getAbstractProcess_MandatoryClasses(), ecorePackage.getEString(), "mandatoryClasses", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAbstractProcess_MandatoryLabel(), ecorePackage.getEString(), "mandatoryLabel", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAbstractProcess_ErrorTemplate(), this.getAssociatedFile(), null, "errorTemplate", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAbstractProcess_ProcessTemplate(), this.getAssociatedFile(), null, "processTemplate", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAbstractProcess_PageTemplate(), this.getAssociatedFile(), null, "pageTemplate", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAbstractProcess_ConsultationTemplate(), this.getAssociatedFile(), null, "consultationTemplate", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAbstractProcess_LogInPage(), this.getAssociatedFile(), null, "logInPage", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAbstractProcess_WelcomePage(), this.getAssociatedFile(), null, "welcomePage", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAbstractProcess_WelcomePageInternal(), ecorePackage.getEBooleanObject(), "welcomePageInternal", "true", 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getAbstractProcess_Categories(), ecorePackage.getEString(), "categories", null, 0, -1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(mainProcessEClass, MainProcess.class, "MainProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getMainProcess_BonitaVersion(), ecorePackage.getEString(), "bonitaVersion", "", 1, 1, MainProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getMainProcess_BonitaModelVersion(), ecorePackage.getEString(), "bonitaModelVersion", "5.0", 0, 1, MainProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getMainProcess_IncludedEntries(), ecorePackage.getEString(), "includedEntries", null, 0, -1, MainProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMainProcess_MessageConnections(), this.getMessageFlow(), null, "messageConnections", null, 0, -1, MainProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTask_OverrideGroupsOfTheLane(), ecorePackage.getEBoolean(), "overrideGroupsOfTheLane", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getTask_Priority(), ecorePackage.getEInt(), "priority", "0", 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(gatewayEClass, Gateway.class, "Gateway", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getGateway_GatewayType(), this.getGatewayType(), "gatewayType", null, 0, 1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(xorGatewayEClass, XORGateway.class, "XORGateway", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(andGatewayEClass, ANDGateway.class, "ANDGateway", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getConnection_Source(), this.getSourceElement(), this.getSourceElement_Outgoing(), "source", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getConnection_Target(), this.getTargetElement(), this.getTargetElement_Incoming(), "target", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(messageFlowEClass, MessageFlow.class, "MessageFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMessageFlow_Source(), this.getThrowMessageEvent(), this.getThrowMessageEvent_OutgoingMessages(), "source", null, 1, 1, MessageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMessageFlow_Target(), this.getCatchMessageEvent(), this.getCatchMessageEvent_IncomingMessag(), "target", null, 1, 1, MessageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getAssociation_IsDirected(), ecorePackage.getEBoolean(), "isDirected", "false", 0, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(sequenceFlowEClass, SequenceFlow.class, "SequenceFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getSequenceFlow_Quantity(), ecorePackage.getEIntegerObject(), "quantity", null, 0, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSequenceFlow_IsDefault(), ecorePackage.getEBoolean(), "isDefault", "false", 0, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getSequenceFlow_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(laneEClass, Lane.class, "Lane", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(poolEClass, Pool.class, "Pool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(activityEClass, Activity.class, "Activity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getActivity_Duration(), ecorePackage.getEString(), "duration", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getActivity_Deadlines(), this.getDeadline(), null, "deadlines", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getActivity_MultiInstantiation(), this.getMultiInstantiation(), null, "multiInstantiation", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getActivity_IsLoop(), ecorePackage.getEBooleanObject(), "isLoop", "false", 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getActivity_TestBefore(), ecorePackage.getEBooleanObject(), "testBefore", "false", 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getActivity_LoopCondition(), ecorePackage.getEString(), "loopCondition", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getActivity_LoopMaximum(), ecorePackage.getEString(), "loopMaximum", "", 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getActivity_BoundaryIntermediateEvents(), this.getIntermediateErrorCatchEvent(), null, "BoundaryIntermediateEvents", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(sendTaskEClass, SendTask.class, "SendTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(receiveTaskEClass, ReceiveTask.class, "ReceiveTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(scriptTaskEClass, ScriptTask.class, "ScriptTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(serviceTaskEClass, ServiceTask.class, "ServiceTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(subProcessEClass, SubProcess.class, "SubProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getSubProcess_SubprocessName(), ecorePackage.getEString(), "subprocessName", null, 0, 1, SubProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSubProcess_SubprocessVersion(), ecorePackage.getEString(), "subprocessVersion", null, 0, 1, SubProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSubProcess_InputMappings(), this.getInputMapping(), null, "inputMappings", null, 0, -1, SubProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSubProcess_OutputMappings(), this.getOutputMapping(), null, "outputMappings", null, 0, -1, SubProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(flowElementEClass, FlowElement.class, "FlowElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getFlowElement_Synchronous(), ecorePackage.getEBooleanObject(), "synchronous", "true", 1, 1, FlowElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getFlowElement_DynamicLabel(), ecorePackage.getEString(), "dynamicLabel", null, 0, 1, FlowElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getFlowElement_DynamicDescription(), ecorePackage.getEString(), "dynamicDescription", null, 0, 1, FlowElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getFlowElement_StepSummary(), ecorePackage.getEString(), "stepSummary", null, 0, 1, FlowElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(containerEClass, org.talend.process.model.process.Container.class, "Container", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getContainer_Elements(), this.getElement(), null, "elements", null, 0, -1, org.talend.process.model.process.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(connectableElementEClass, ConnectableElement.class, "ConnectableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getConnectableElement_Connectors(), this.getConnector(), null, "connectors", null, 0, -1, ConnectableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getConnectableElement_Data(), this.getData(), null, "data", null, 0, -1, ConnectableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getConnectableElement_Kpis(), theKpiPackage.getAbstractKPIBinding(), null, "kpis", null, 0, -1, ConnectableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(connectorEClass, Connector.class, "Connector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getConnector_ConnectorId(), ecorePackage.getEString(), "connectorId", null, 0, 1, Connector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getConnector_ConfigurationId(), ecorePackage.getEString(), "configurationId", null, 0, 1, Connector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getConnector_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Connector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getConnector_Event(), ecorePackage.getEString(), "event", null, 0, 1, Connector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getConnector_IgnoreErrors(), ecorePackage.getEBoolean(), "ignoreErrors", null, 0, 1, Connector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getConnector_Outputs(), this.getOutputParameterMapping(), null, "outputs", null, 0, -1, Connector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getParameter_Key(), ecorePackage.getEString(), "key", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getParameter_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(outputParameterMappingEClass, OutputParameterMapping.class, "OutputParameterMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getOutputParameterMapping_ValueExpression(), ecorePackage.getEString(), "valueExpression", null, 0, 1, OutputParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOutputParameterMapping_TargetData(), this.getData(), null, "targetData", null, 0, 1, OutputParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getOutputParameterMapping_AdditionalPath(), ecorePackage.getEString(), "additionalPath", "", 0, 1, OutputParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getOutputParameterMapping_TargetWidget(), theFormPackage.getWidget(), null, "targetWidget", null, 0, 1, OutputParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(dataEClass, Data.class, "Data", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getData_DataType(), this.getDataType(), null, "dataType", null, 1, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getData_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getData_Generated(), ecorePackage.getEBoolean(), "generated", "true", 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(attachmentDataEClass, AttachmentData.class, "AttachmentData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getAttachmentData_BarPath(), ecorePackage.getEString(), "barPath", null, 0, 1, AttachmentData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(javaObjectDataEClass, JavaObjectData.class, "JavaObjectData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getJavaObjectData_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, JavaObjectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(xmlDataEClass, XMLData.class, "XMLData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getXMLData_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, XMLData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getXMLData_Type(), ecorePackage.getEString(), "type", null, 0, 1, XMLData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(dataTypeEClass, DataType.class, "DataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(integerTypeEClass, IntegerType.class, "IntegerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(dateTypeEClass, DateType.class, "DateType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(floatTypeEClass, FloatType.class, "FloatType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(enumTypeEClass, EnumType.class, "EnumType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getEnumType_Literals(), ecorePackage.getEString(), "literals", null, 0, -1, EnumType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(javaTypeEClass, JavaType.class, "JavaType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(xmlTypeEClass, XMLType.class, "XMLType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(outputMappingEClass, OutputMapping.class, "OutputMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getOutputMapping_SubprocessSource(), ecorePackage.getEString(), "subprocessSource", null, 0, 1, OutputMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOutputMapping_ProcessTarget(), this.getData(), null, "processTarget", null, 0, 1, OutputMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(attachmentTypeEClass, AttachmentType.class, "AttachmentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(startEventEClass, StartEvent.class, "StartEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(endEventEClass, EndEvent.class, "EndEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(pageFlowEClass, PageFlow.class, "PageFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPageFlow_Form(), theFormPackage.getForm(), null, "form", null, 0, -1, PageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getPageFlow_ByPassFormsGeneration(), ecorePackage.getEBooleanObject(), "byPassFormsGeneration", null, 0, 1, PageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPageFlow_ConfirmationTemplate(), this.getAssociatedFile(), null, "confirmationTemplate", null, 0, 1, PageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getPageFlow_ConfirmationMessage(), ecorePackage.getEString(), "confirmationMessage", null, 0, 1, PageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getPageFlow_RegExpToHideDefaultField(), ecorePackage.getEString(), "regExpToHideDefaultField", null, 0, 1, PageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getPageFlow_UseRegExpToHideDefaultField(), ecorePackage.getEBoolean(), "useRegExpToHideDefaultField", "false", 0, 1, PageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getPageFlow_ViewForm(), theFormPackage.getViewForm(), null, "viewForm", null, 0, -1, PageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getPageFlow_UseViewForm(), ecorePackage.getEBoolean(), "useViewForm", "false", 0, 1, PageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(resourceContainerEClass, ResourceContainer.class, "ResourceContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getResourceContainer_ResourceFolders(), this.getResourceFolder(), null, "resourceFolders", null, 0, -1, ResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getResourceContainer_HtmlTemplate(), this.getAssociatedFile(), null, "htmlTemplate", null, 0, 1, ResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getResourceContainer_ResourceFiles(), this.getResourceFile(), null, "resourceFiles", null, 0, -1, ResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getResourceContainer_ResourceJars(), ecorePackage.getEString(), "resourceJars", null, 0, -1, ResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getResourceContainer_ResourceValidators(), ecorePackage.getEString(), "resourceValidators", null, 0, -1, ResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(associatedFileEClass, AssociatedFile.class, "AssociatedFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getAssociatedFile_Path(), ecorePackage.getEString(), "path", null, 0, 1, AssociatedFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAssociatedFile_WarPath(), ecorePackage.getEString(), "warPath", null, 0, 1, AssociatedFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(resourceFileEClass, ResourceFile.class, "ResourceFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(resourceFolderEClass, ResourceFolder.class, "ResourceFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getResourceFolder_ResourceFiles(), this.getResourceFile(), null, "resourceFiles", null, 0, -1, ResourceFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(deadlineEClass, Deadline.class, "Deadline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getDeadline_Condition(), ecorePackage.getEString(), "condition", null, 1, 1, Deadline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getDeadline_Connector(), this.getConnector(), null, "connector", null, 1, 1, Deadline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(multiInstantiationEClass, MultiInstantiation.class, "MultiInstantiation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getMultiInstantiation_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1, MultiInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMultiInstantiation_ActivityData(), this.getData(), null, "activityData", null, 0, 1, MultiInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMultiInstantiation_Instantiator(), this.getConnector(), null, "instantiator", null, 0, 1, MultiInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMultiInstantiation_JoinChecker(), this.getConnector(), null, "joinChecker", null, 0, 1, MultiInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(inputMappingEClass, InputMapping.class, "InputMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getInputMapping_ProcessSource(), this.getData(), null, "processSource", null, 0, 1, InputMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getInputMapping_SubprocessTarget(), ecorePackage.getEString(), "subprocessTarget", null, 0, 1, InputMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(messageEventEClass, MessageEvent.class, "MessageEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(startMessageEventEClass, StartMessageEvent.class, "StartMessageEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(endMessageEventEClass, EndMessageEvent.class, "EndMessageEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(catchMessageEventEClass, CatchMessageEvent.class, "CatchMessageEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getCatchMessageEvent_Event(), ecorePackage.getEString(), "event", null, 0, 1, CatchMessageEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getCatchMessageEvent_IncomingMessag(), this.getMessageFlow(), this.getMessageFlow_Target(), "incomingMessag", null, 0, 1, CatchMessageEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getCatchMessageEvent_Matcher(), ecorePackage.getEString(), "matcher", null, 0, 1, CatchMessageEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(throwMessageEventEClass, ThrowMessageEvent.class, "ThrowMessageEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getThrowMessageEvent_Events(), this.getEventObject(), this.getEventObject_Source(), "events", null, 0, -1, ThrowMessageEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getThrowMessageEvent_OutgoingMessages(), this.getMessageFlow(), this.getMessageFlow_Source(), "outgoingMessages", null, 0, -1, ThrowMessageEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(intermediateCatchMessageEventEClass, IntermediateCatchMessageEvent.class, "IntermediateCatchMessageEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(intermediateThrowMessageEventEClass, IntermediateThrowMessageEvent.class, "IntermediateThrowMessageEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(textAnnotationEClass, TextAnnotation.class, "TextAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTextAnnotation_Text(), ecorePackage.getEString(), "text", null, 1, 1, TextAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(textAnnotationAttachmentEClass, TextAnnotationAttachment.class, "TextAnnotationAttachment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTextAnnotationAttachment_Source(), this.getTextAnnotation(), null, "source", null, 0, 1, TextAnnotationAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getTextAnnotationAttachment_Target(), this.getElement(), this.getElement_TextAnnotationAttachment(), "target", null, 0, 1, TextAnnotationAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(eventObjectEClass, EventObject.class, "EventObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getEventObject_ThrowEvent(), ecorePackage.getEString(), "throwEvent", "", 1, 1, EventObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getEventObject_Source(), this.getThrowMessageEvent(), this.getThrowMessageEvent_Events(), "source", null, 0, 1, EventObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEventObject_Ttl(), ecorePackage.getEString(), "ttl", "31104000000", 0, 1, EventObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getEventObject_TargetProcessName(), ecorePackage.getEString(), "targetProcessName", null, 0, 1, EventObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEventObject_TargetElementName(), ecorePackage.getEString(), "targetElementName", null, 0, 1, EventObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(timerEventEClass, TimerEvent.class, "TimerEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTimerEvent_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, TimerEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(startTimerEventEClass, StartTimerEvent.class, "StartTimerEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(intermediateCatchTimerEventEClass, IntermediateCatchTimerEvent.class, "IntermediateCatchTimerEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(catchLinkEventEClass, CatchLinkEvent.class, "CatchLinkEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getCatchLinkEvent_From(), this.getThrowLinkEvent(), this.getThrowLinkEvent_To(), "from", null, 0, -1, CatchLinkEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(throwLinkEventEClass, ThrowLinkEvent.class, "ThrowLinkEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getThrowLinkEvent_To(), this.getCatchLinkEvent(), this.getCatchLinkEvent_From(), "to", null, 0, 1, ThrowLinkEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(linkEventEClass, LinkEvent.class, "LinkEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(signalEventEClass, SignalEvent.class, "SignalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(throwSignalEventEClass, ThrowSignalEvent.class, "ThrowSignalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getThrowSignalEvent_Events(), this.getEventObject(), null, "events", null, 0, -1, ThrowSignalEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(catchSignalEventEClass, CatchSignalEvent.class, "CatchSignalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getCatchSignalEvent_Signal(), ecorePackage.getEString(), "signal", null, 0, 1, CatchSignalEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getCatchSignalEvent_Matcher(), ecorePackage.getEString(), "matcher", null, 0, 1, CatchSignalEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(endSignalEventEClass, EndSignalEvent.class, "EndSignalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(intermediateThrowSignalEventEClass, IntermediateThrowSignalEvent.class, "IntermediateThrowSignalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(intermediateCatchSignalEventEClass, IntermediateCatchSignalEvent.class, "IntermediateCatchSignalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(startSignalEventEClass, StartSignalEvent.class, "StartSignalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(assignableEClass, Assignable.class, "Assignable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getAssignable_User(), ecorePackage.getEString(), "user", null, 0, 1, Assignable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAssignable_Filters(), this.getConnector(), null, "filters", null, 0, -1, Assignable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAssignable_Groups(), this.getGroup(), null, "groups", null, 0, -1, Assignable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAssignable_ActorType(), this.getActorType(), "actorType", null, 0, 1, Assignable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(recapFlowEClass, RecapFlow.class, "RecapFlow", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getRecapFlow_RecapForms(), theFormPackage.getViewForm(), null, "recapForms", null, 0, -1, RecapFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(boundaryEventEClass, BoundaryEvent.class, "BoundaryEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(intermediateErrorCatchEventEClass, IntermediateErrorCatchEvent.class, "IntermediateErrorCatchEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(sourceElementEClass, SourceElement.class, "SourceElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getSourceElement_Outgoing(), this.getConnection(), this.getConnection_Source(), "outgoing", null, 0, -1, SourceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(targetElementEClass, TargetElement.class, "TargetElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTargetElement_Incoming(), this.getConnection(), this.getConnection_Target(), "incoming", null, 0, -1, TargetElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum(gatewayTypeEEnum, GatewayType.class, "GatewayType"); //$NON-NLS-1$
        addEEnumLiteral(gatewayTypeEEnum, GatewayType.XOR);
        addEEnumLiteral(gatewayTypeEEnum, GatewayType.OR);
        addEEnumLiteral(gatewayTypeEEnum, GatewayType.COMPLEX);
        addEEnumLiteral(gatewayTypeEEnum, GatewayType.AND);

        initEEnum(actorTypeEEnum, ActorType.class, "ActorType"); //$NON-NLS-1$
        addEEnumLiteral(actorTypeEEnum, ActorType.GROUP);
        addEEnumLiteral(actorTypeEEnum, ActorType.USER);

        // Create resource
        createResource(eNS_URI);
    }

} //ProcessPackageImpl
