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
package org.talend.process.model.process.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.talend.process.model.process.*;

import org.talend.process.model.simulation.SimulationAbstractProcess;
import org.talend.process.model.simulation.SimulationActivity;
import org.talend.process.model.simulation.SimulationDataContainer;
import org.talend.process.model.simulation.SimulationTransition;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.process.model.process.ProcessPackage
 * @generated
 */
public class ProcessAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ProcessPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ProcessPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProcessSwitch<Adapter> modelSwitch =
        new ProcessSwitch<Adapter>() {
            @Override
            public Adapter caseElement(Element object) {
                return createElementAdapter();
            }
            @Override
            public Adapter caseAbstractProcess(AbstractProcess object) {
                return createAbstractProcessAdapter();
            }
            @Override
            public Adapter caseMainProcess(MainProcess object) {
                return createMainProcessAdapter();
            }
            @Override
            public Adapter caseTask(Task object) {
                return createTaskAdapter();
            }
            @Override
            public Adapter caseGateway(Gateway object) {
                return createGatewayAdapter();
            }
            @Override
            public Adapter caseXORGateway(XORGateway object) {
                return createXORGatewayAdapter();
            }
            @Override
            public Adapter caseANDGateway(ANDGateway object) {
                return createANDGatewayAdapter();
            }
            @Override
            public Adapter caseConnection(Connection object) {
                return createConnectionAdapter();
            }
            @Override
            public Adapter caseMessageFlow(MessageFlow object) {
                return createMessageFlowAdapter();
            }
            @Override
            public Adapter caseAssociation(Association object) {
                return createAssociationAdapter();
            }
            @Override
            public Adapter caseSequenceFlow(SequenceFlow object) {
                return createSequenceFlowAdapter();
            }
            @Override
            public Adapter caseLane(Lane object) {
                return createLaneAdapter();
            }
            @Override
            public Adapter casePool(Pool object) {
                return createPoolAdapter();
            }
            @Override
            public Adapter caseActivity(Activity object) {
                return createActivityAdapter();
            }
            @Override
            public Adapter caseSendTask(SendTask object) {
                return createSendTaskAdapter();
            }
            @Override
            public Adapter caseReceiveTask(ReceiveTask object) {
                return createReceiveTaskAdapter();
            }
            @Override
            public Adapter caseScriptTask(ScriptTask object) {
                return createScriptTaskAdapter();
            }
            @Override
            public Adapter caseServiceTask(ServiceTask object) {
                return createServiceTaskAdapter();
            }
            @Override
            public Adapter caseSubProcess(SubProcess object) {
                return createSubProcessAdapter();
            }
            @Override
            public Adapter caseFlowElement(FlowElement object) {
                return createFlowElementAdapter();
            }
            @Override
            public Adapter caseContainer(Container object) {
                return createContainerAdapter();
            }
            @Override
            public Adapter caseConnectableElement(ConnectableElement object) {
                return createConnectableElementAdapter();
            }
            @Override
            public Adapter caseConnector(Connector object) {
                return createConnectorAdapter();
            }
            @Override
            public Adapter caseParameter(Parameter object) {
                return createParameterAdapter();
            }
            @Override
            public Adapter caseOutputParameterMapping(OutputParameterMapping object) {
                return createOutputParameterMappingAdapter();
            }
            @Override
            public Adapter caseGroup(Group object) {
                return createGroupAdapter();
            }
            @Override
            public Adapter caseData(Data object) {
                return createDataAdapter();
            }
            @Override
            public Adapter caseAttachmentData(AttachmentData object) {
                return createAttachmentDataAdapter();
            }
            @Override
            public Adapter caseJavaObjectData(JavaObjectData object) {
                return createJavaObjectDataAdapter();
            }
            @Override
            public Adapter caseXMLData(XMLData object) {
                return createXMLDataAdapter();
            }
            @Override
            public Adapter caseDataType(DataType object) {
                return createDataTypeAdapter();
            }
            @Override
            public Adapter caseIntegerType(IntegerType object) {
                return createIntegerTypeAdapter();
            }
            @Override
            public Adapter caseStringType(StringType object) {
                return createStringTypeAdapter();
            }
            @Override
            public Adapter caseDateType(DateType object) {
                return createDateTypeAdapter();
            }
            @Override
            public Adapter caseFloatType(FloatType object) {
                return createFloatTypeAdapter();
            }
            @Override
            public Adapter caseBooleanType(BooleanType object) {
                return createBooleanTypeAdapter();
            }
            @Override
            public Adapter caseEnumType(EnumType object) {
                return createEnumTypeAdapter();
            }
            @Override
            public Adapter caseJavaType(JavaType object) {
                return createJavaTypeAdapter();
            }
            @Override
            public Adapter caseXMLType(XMLType object) {
                return createXMLTypeAdapter();
            }
            @Override
            public Adapter caseOutputMapping(OutputMapping object) {
                return createOutputMappingAdapter();
            }
            @Override
            public Adapter caseAttachmentType(AttachmentType object) {
                return createAttachmentTypeAdapter();
            }
            @Override
            public Adapter caseStartEvent(StartEvent object) {
                return createStartEventAdapter();
            }
            @Override
            public Adapter caseEndEvent(EndEvent object) {
                return createEndEventAdapter();
            }
            @Override
            public Adapter caseEvent(Event object) {
                return createEventAdapter();
            }
            @Override
            public Adapter casePageFlow(PageFlow object) {
                return createPageFlowAdapter();
            }
            @Override
            public Adapter caseResourceContainer(ResourceContainer object) {
                return createResourceContainerAdapter();
            }
            @Override
            public Adapter caseAssociatedFile(AssociatedFile object) {
                return createAssociatedFileAdapter();
            }
            @Override
            public Adapter caseResourceFile(ResourceFile object) {
                return createResourceFileAdapter();
            }
            @Override
            public Adapter caseResourceFolder(ResourceFolder object) {
                return createResourceFolderAdapter();
            }
            @Override
            public Adapter caseDeadline(Deadline object) {
                return createDeadlineAdapter();
            }
            @Override
            public Adapter caseMultiInstantiation(MultiInstantiation object) {
                return createMultiInstantiationAdapter();
            }
            @Override
            public Adapter caseInputMapping(InputMapping object) {
                return createInputMappingAdapter();
            }
            @Override
            public Adapter caseMessageEvent(MessageEvent object) {
                return createMessageEventAdapter();
            }
            @Override
            public Adapter caseStartMessageEvent(StartMessageEvent object) {
                return createStartMessageEventAdapter();
            }
            @Override
            public Adapter caseEndMessageEvent(EndMessageEvent object) {
                return createEndMessageEventAdapter();
            }
            @Override
            public Adapter caseCatchMessageEvent(CatchMessageEvent object) {
                return createCatchMessageEventAdapter();
            }
            @Override
            public Adapter caseThrowMessageEvent(ThrowMessageEvent object) {
                return createThrowMessageEventAdapter();
            }
            @Override
            public Adapter caseIntermediateCatchMessageEvent(IntermediateCatchMessageEvent object) {
                return createIntermediateCatchMessageEventAdapter();
            }
            @Override
            public Adapter caseIntermediateThrowMessageEvent(IntermediateThrowMessageEvent object) {
                return createIntermediateThrowMessageEventAdapter();
            }
            @Override
            public Adapter caseTextAnnotation(TextAnnotation object) {
                return createTextAnnotationAdapter();
            }
            @Override
            public Adapter caseTextAnnotationAttachment(TextAnnotationAttachment object) {
                return createTextAnnotationAttachmentAdapter();
            }
            @Override
            public Adapter caseEventObject(EventObject object) {
                return createEventObjectAdapter();
            }
            @Override
            public Adapter caseTimerEvent(TimerEvent object) {
                return createTimerEventAdapter();
            }
            @Override
            public Adapter caseStartTimerEvent(StartTimerEvent object) {
                return createStartTimerEventAdapter();
            }
            @Override
            public Adapter caseIntermediateCatchTimerEvent(IntermediateCatchTimerEvent object) {
                return createIntermediateCatchTimerEventAdapter();
            }
            @Override
            public Adapter caseCatchLinkEvent(CatchLinkEvent object) {
                return createCatchLinkEventAdapter();
            }
            @Override
            public Adapter caseThrowLinkEvent(ThrowLinkEvent object) {
                return createThrowLinkEventAdapter();
            }
            @Override
            public Adapter caseLinkEvent(LinkEvent object) {
                return createLinkEventAdapter();
            }
            @Override
            public Adapter caseSignalEvent(SignalEvent object) {
                return createSignalEventAdapter();
            }
            @Override
            public Adapter caseThrowSignalEvent(ThrowSignalEvent object) {
                return createThrowSignalEventAdapter();
            }
            @Override
            public Adapter caseCatchSignalEvent(CatchSignalEvent object) {
                return createCatchSignalEventAdapter();
            }
            @Override
            public Adapter caseEndSignalEvent(EndSignalEvent object) {
                return createEndSignalEventAdapter();
            }
            @Override
            public Adapter caseIntermediateThrowSignalEvent(IntermediateThrowSignalEvent object) {
                return createIntermediateThrowSignalEventAdapter();
            }
            @Override
            public Adapter caseIntermediateCatchSignalEvent(IntermediateCatchSignalEvent object) {
                return createIntermediateCatchSignalEventAdapter();
            }
            @Override
            public Adapter caseStartSignalEvent(StartSignalEvent object) {
                return createStartSignalEventAdapter();
            }
            @Override
            public Adapter caseAssignable(Assignable object) {
                return createAssignableAdapter();
            }
            @Override
            public Adapter caseRecapFlow(RecapFlow object) {
                return createRecapFlowAdapter();
            }
            @Override
            public Adapter caseBoundaryEvent(BoundaryEvent object) {
                return createBoundaryEventAdapter();
            }
            @Override
            public Adapter caseIntermediateErrorCatchEvent(IntermediateErrorCatchEvent object) {
                return createIntermediateErrorCatchEventAdapter();
            }
            @Override
            public Adapter caseSourceElement(SourceElement object) {
                return createSourceElementAdapter();
            }
            @Override
            public Adapter caseTargetElement(TargetElement object) {
                return createTargetElementAdapter();
            }
            @Override
            public Adapter caseSimulationDataContainer(SimulationDataContainer object) {
                return createSimulationDataContainerAdapter();
            }
            @Override
            public Adapter caseSimulationAbstractProcess(SimulationAbstractProcess object) {
                return createSimulationAbstractProcessAdapter();
            }
            @Override
            public Adapter caseSimulationActivity(SimulationActivity object) {
                return createSimulationActivityAdapter();
            }
            @Override
            public Adapter caseSimulationTransition(SimulationTransition object) {
                return createSimulationTransitionAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Element <em>Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Element
     * @generated
     */
    public Adapter createElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.AbstractProcess <em>Abstract Process</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.AbstractProcess
     * @generated
     */
    public Adapter createAbstractProcessAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.MainProcess <em>Main Process</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.MainProcess
     * @generated
     */
    public Adapter createMainProcessAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Task <em>Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Task
     * @generated
     */
    public Adapter createTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Gateway <em>Gateway</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Gateway
     * @generated
     */
    public Adapter createGatewayAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.XORGateway <em>XOR Gateway</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.XORGateway
     * @generated
     */
    public Adapter createXORGatewayAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.ANDGateway <em>AND Gateway</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.ANDGateway
     * @generated
     */
    public Adapter createANDGatewayAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Connection
     * @generated
     */
    public Adapter createConnectionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.MessageFlow <em>Message Flow</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.MessageFlow
     * @generated
     */
    public Adapter createMessageFlowAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Association <em>Association</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Association
     * @generated
     */
    public Adapter createAssociationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.SequenceFlow <em>Sequence Flow</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.SequenceFlow
     * @generated
     */
    public Adapter createSequenceFlowAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Lane <em>Lane</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Lane
     * @generated
     */
    public Adapter createLaneAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Pool <em>Pool</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Pool
     * @generated
     */
    public Adapter createPoolAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Activity <em>Activity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Activity
     * @generated
     */
    public Adapter createActivityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.SendTask <em>Send Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.SendTask
     * @generated
     */
    public Adapter createSendTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.ReceiveTask <em>Receive Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.ReceiveTask
     * @generated
     */
    public Adapter createReceiveTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.ScriptTask <em>Script Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.ScriptTask
     * @generated
     */
    public Adapter createScriptTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.ServiceTask <em>Service Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.ServiceTask
     * @generated
     */
    public Adapter createServiceTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.SubProcess <em>Sub Process</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.SubProcess
     * @generated
     */
    public Adapter createSubProcessAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.FlowElement <em>Flow Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.FlowElement
     * @generated
     */
    public Adapter createFlowElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Container <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Container
     * @generated
     */
    public Adapter createContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.ConnectableElement <em>Connectable Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.ConnectableElement
     * @generated
     */
    public Adapter createConnectableElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Connector <em>Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Connector
     * @generated
     */
    public Adapter createConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Parameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Parameter
     * @generated
     */
    public Adapter createParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.OutputParameterMapping <em>Output Parameter Mapping</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.OutputParameterMapping
     * @generated
     */
    public Adapter createOutputParameterMappingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Group <em>Group</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Group
     * @generated
     */
    public Adapter createGroupAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Data <em>Data</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Data
     * @generated
     */
    public Adapter createDataAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.AttachmentData <em>Attachment Data</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.AttachmentData
     * @generated
     */
    public Adapter createAttachmentDataAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.JavaObjectData <em>Java Object Data</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.JavaObjectData
     * @generated
     */
    public Adapter createJavaObjectDataAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.XMLData <em>XML Data</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.XMLData
     * @generated
     */
    public Adapter createXMLDataAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.DataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.DataType
     * @generated
     */
    public Adapter createDataTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.IntegerType <em>Integer Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.IntegerType
     * @generated
     */
    public Adapter createIntegerTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.StringType <em>String Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.StringType
     * @generated
     */
    public Adapter createStringTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.DateType <em>Date Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.DateType
     * @generated
     */
    public Adapter createDateTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.FloatType <em>Float Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.FloatType
     * @generated
     */
    public Adapter createFloatTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.BooleanType <em>Boolean Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.BooleanType
     * @generated
     */
    public Adapter createBooleanTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.EnumType <em>Enum Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.EnumType
     * @generated
     */
    public Adapter createEnumTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.JavaType <em>Java Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.JavaType
     * @generated
     */
    public Adapter createJavaTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.XMLType <em>XML Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.XMLType
     * @generated
     */
    public Adapter createXMLTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.OutputMapping <em>Output Mapping</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.OutputMapping
     * @generated
     */
    public Adapter createOutputMappingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.AttachmentType <em>Attachment Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.AttachmentType
     * @generated
     */
    public Adapter createAttachmentTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.StartEvent <em>Start Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.StartEvent
     * @generated
     */
    public Adapter createStartEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.EndEvent <em>End Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.EndEvent
     * @generated
     */
    public Adapter createEndEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Event <em>Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Event
     * @generated
     */
    public Adapter createEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.PageFlow <em>Page Flow</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.PageFlow
     * @generated
     */
    public Adapter createPageFlowAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.ResourceContainer <em>Resource Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.ResourceContainer
     * @generated
     */
    public Adapter createResourceContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.AssociatedFile <em>Associated File</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.AssociatedFile
     * @generated
     */
    public Adapter createAssociatedFileAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.ResourceFile <em>Resource File</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.ResourceFile
     * @generated
     */
    public Adapter createResourceFileAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.ResourceFolder <em>Resource Folder</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.ResourceFolder
     * @generated
     */
    public Adapter createResourceFolderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Deadline <em>Deadline</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Deadline
     * @generated
     */
    public Adapter createDeadlineAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.MultiInstantiation <em>Multi Instantiation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.MultiInstantiation
     * @generated
     */
    public Adapter createMultiInstantiationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.InputMapping <em>Input Mapping</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.InputMapping
     * @generated
     */
    public Adapter createInputMappingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.MessageEvent <em>Message Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.MessageEvent
     * @generated
     */
    public Adapter createMessageEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.StartMessageEvent <em>Start Message Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.StartMessageEvent
     * @generated
     */
    public Adapter createStartMessageEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.EndMessageEvent <em>End Message Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.EndMessageEvent
     * @generated
     */
    public Adapter createEndMessageEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.CatchMessageEvent <em>Catch Message Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.CatchMessageEvent
     * @generated
     */
    public Adapter createCatchMessageEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.ThrowMessageEvent <em>Throw Message Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.ThrowMessageEvent
     * @generated
     */
    public Adapter createThrowMessageEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.IntermediateCatchMessageEvent <em>Intermediate Catch Message Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.IntermediateCatchMessageEvent
     * @generated
     */
    public Adapter createIntermediateCatchMessageEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.IntermediateThrowMessageEvent <em>Intermediate Throw Message Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.IntermediateThrowMessageEvent
     * @generated
     */
    public Adapter createIntermediateThrowMessageEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.TextAnnotation <em>Text Annotation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.TextAnnotation
     * @generated
     */
    public Adapter createTextAnnotationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.TextAnnotationAttachment <em>Text Annotation Attachment</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.TextAnnotationAttachment
     * @generated
     */
    public Adapter createTextAnnotationAttachmentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.EventObject <em>Event Object</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.EventObject
     * @generated
     */
    public Adapter createEventObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.TimerEvent <em>Timer Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.TimerEvent
     * @generated
     */
    public Adapter createTimerEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.StartTimerEvent <em>Start Timer Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.StartTimerEvent
     * @generated
     */
    public Adapter createStartTimerEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.IntermediateCatchTimerEvent <em>Intermediate Catch Timer Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.IntermediateCatchTimerEvent
     * @generated
     */
    public Adapter createIntermediateCatchTimerEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.CatchLinkEvent <em>Catch Link Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.CatchLinkEvent
     * @generated
     */
    public Adapter createCatchLinkEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.ThrowLinkEvent <em>Throw Link Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.ThrowLinkEvent
     * @generated
     */
    public Adapter createThrowLinkEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.LinkEvent <em>Link Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.LinkEvent
     * @generated
     */
    public Adapter createLinkEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.SignalEvent <em>Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.SignalEvent
     * @generated
     */
    public Adapter createSignalEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.ThrowSignalEvent <em>Throw Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.ThrowSignalEvent
     * @generated
     */
    public Adapter createThrowSignalEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.CatchSignalEvent <em>Catch Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.CatchSignalEvent
     * @generated
     */
    public Adapter createCatchSignalEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.EndSignalEvent <em>End Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.EndSignalEvent
     * @generated
     */
    public Adapter createEndSignalEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.IntermediateThrowSignalEvent <em>Intermediate Throw Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.IntermediateThrowSignalEvent
     * @generated
     */
    public Adapter createIntermediateThrowSignalEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.IntermediateCatchSignalEvent <em>Intermediate Catch Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.IntermediateCatchSignalEvent
     * @generated
     */
    public Adapter createIntermediateCatchSignalEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.StartSignalEvent <em>Start Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.StartSignalEvent
     * @generated
     */
    public Adapter createStartSignalEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.Assignable <em>Assignable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.Assignable
     * @generated
     */
    public Adapter createAssignableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.RecapFlow <em>Recap Flow</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.RecapFlow
     * @generated
     */
    public Adapter createRecapFlowAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.BoundaryEvent <em>Boundary Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.BoundaryEvent
     * @generated
     */
    public Adapter createBoundaryEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.IntermediateErrorCatchEvent <em>Intermediate Error Catch Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.IntermediateErrorCatchEvent
     * @generated
     */
    public Adapter createIntermediateErrorCatchEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.SourceElement <em>Source Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.SourceElement
     * @generated
     */
    public Adapter createSourceElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.process.TargetElement <em>Target Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.process.TargetElement
     * @generated
     */
    public Adapter createTargetElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.simulation.SimulationDataContainer <em>Data Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.simulation.SimulationDataContainer
     * @generated
     */
    public Adapter createSimulationDataContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.simulation.SimulationAbstractProcess <em>Abstract Process</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.simulation.SimulationAbstractProcess
     * @generated
     */
    public Adapter createSimulationAbstractProcessAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.simulation.SimulationActivity <em>Activity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.simulation.SimulationActivity
     * @generated
     */
    public Adapter createSimulationActivityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.process.model.simulation.SimulationTransition <em>Transition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.process.model.simulation.SimulationTransition
     * @generated
     */
    public Adapter createSimulationTransitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //ProcessAdapterFactory
