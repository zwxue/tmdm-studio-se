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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.talend.process.model.process.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessFactoryImpl extends EFactoryImpl implements ProcessFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ProcessFactory init() {
        try {
            ProcessFactory theProcessFactory = (ProcessFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.bonitasoft.org/ns/studio/process"); //$NON-NLS-1$ 
            if (theProcessFactory != null) {
                return theProcessFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ProcessFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessFactoryImpl() {
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
            case ProcessPackage.MAIN_PROCESS: return createMainProcess();
            case ProcessPackage.TASK: return createTask();
            case ProcessPackage.GATEWAY: return createGateway();
            case ProcessPackage.XOR_GATEWAY: return createXORGateway();
            case ProcessPackage.AND_GATEWAY: return createANDGateway();
            case ProcessPackage.CONNECTION: return createConnection();
            case ProcessPackage.MESSAGE_FLOW: return createMessageFlow();
            case ProcessPackage.ASSOCIATION: return createAssociation();
            case ProcessPackage.SEQUENCE_FLOW: return createSequenceFlow();
            case ProcessPackage.LANE: return createLane();
            case ProcessPackage.POOL: return createPool();
            case ProcessPackage.ACTIVITY: return createActivity();
            case ProcessPackage.SEND_TASK: return createSendTask();
            case ProcessPackage.RECEIVE_TASK: return createReceiveTask();
            case ProcessPackage.SCRIPT_TASK: return createScriptTask();
            case ProcessPackage.SERVICE_TASK: return createServiceTask();
            case ProcessPackage.SUB_PROCESS: return createSubProcess();
            case ProcessPackage.FLOW_ELEMENT: return createFlowElement();
            case ProcessPackage.CONTAINER: return createContainer();
            case ProcessPackage.CONNECTABLE_ELEMENT: return createConnectableElement();
            case ProcessPackage.CONNECTOR: return createConnector();
            case ProcessPackage.PARAMETER: return createParameter();
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING: return createOutputParameterMapping();
            case ProcessPackage.GROUP: return createGroup();
            case ProcessPackage.DATA: return createData();
            case ProcessPackage.ATTACHMENT_DATA: return createAttachmentData();
            case ProcessPackage.JAVA_OBJECT_DATA: return createJavaObjectData();
            case ProcessPackage.XML_DATA: return createXMLData();
            case ProcessPackage.INTEGER_TYPE: return createIntegerType();
            case ProcessPackage.STRING_TYPE: return createStringType();
            case ProcessPackage.DATE_TYPE: return createDateType();
            case ProcessPackage.FLOAT_TYPE: return createFloatType();
            case ProcessPackage.BOOLEAN_TYPE: return createBooleanType();
            case ProcessPackage.ENUM_TYPE: return createEnumType();
            case ProcessPackage.JAVA_TYPE: return createJavaType();
            case ProcessPackage.XML_TYPE: return createXMLType();
            case ProcessPackage.OUTPUT_MAPPING: return createOutputMapping();
            case ProcessPackage.ATTACHMENT_TYPE: return createAttachmentType();
            case ProcessPackage.START_EVENT: return createStartEvent();
            case ProcessPackage.END_EVENT: return createEndEvent();
            case ProcessPackage.EVENT: return createEvent();
            case ProcessPackage.PAGE_FLOW: return createPageFlow();
            case ProcessPackage.RESOURCE_CONTAINER: return createResourceContainer();
            case ProcessPackage.ASSOCIATED_FILE: return createAssociatedFile();
            case ProcessPackage.RESOURCE_FILE: return createResourceFile();
            case ProcessPackage.RESOURCE_FOLDER: return createResourceFolder();
            case ProcessPackage.DEADLINE: return createDeadline();
            case ProcessPackage.MULTI_INSTANTIATION: return createMultiInstantiation();
            case ProcessPackage.INPUT_MAPPING: return createInputMapping();
            case ProcessPackage.MESSAGE_EVENT: return createMessageEvent();
            case ProcessPackage.START_MESSAGE_EVENT: return createStartMessageEvent();
            case ProcessPackage.END_MESSAGE_EVENT: return createEndMessageEvent();
            case ProcessPackage.CATCH_MESSAGE_EVENT: return createCatchMessageEvent();
            case ProcessPackage.THROW_MESSAGE_EVENT: return createThrowMessageEvent();
            case ProcessPackage.INTERMEDIATE_CATCH_MESSAGE_EVENT: return createIntermediateCatchMessageEvent();
            case ProcessPackage.INTERMEDIATE_THROW_MESSAGE_EVENT: return createIntermediateThrowMessageEvent();
            case ProcessPackage.TEXT_ANNOTATION: return createTextAnnotation();
            case ProcessPackage.TEXT_ANNOTATION_ATTACHMENT: return createTextAnnotationAttachment();
            case ProcessPackage.EVENT_OBJECT: return createEventObject();
            case ProcessPackage.TIMER_EVENT: return createTimerEvent();
            case ProcessPackage.START_TIMER_EVENT: return createStartTimerEvent();
            case ProcessPackage.INTERMEDIATE_CATCH_TIMER_EVENT: return createIntermediateCatchTimerEvent();
            case ProcessPackage.CATCH_LINK_EVENT: return createCatchLinkEvent();
            case ProcessPackage.THROW_LINK_EVENT: return createThrowLinkEvent();
            case ProcessPackage.LINK_EVENT: return createLinkEvent();
            case ProcessPackage.SIGNAL_EVENT: return createSignalEvent();
            case ProcessPackage.THROW_SIGNAL_EVENT: return createThrowSignalEvent();
            case ProcessPackage.CATCH_SIGNAL_EVENT: return createCatchSignalEvent();
            case ProcessPackage.END_SIGNAL_EVENT: return createEndSignalEvent();
            case ProcessPackage.INTERMEDIATE_THROW_SIGNAL_EVENT: return createIntermediateThrowSignalEvent();
            case ProcessPackage.INTERMEDIATE_CATCH_SIGNAL_EVENT: return createIntermediateCatchSignalEvent();
            case ProcessPackage.START_SIGNAL_EVENT: return createStartSignalEvent();
            case ProcessPackage.BOUNDARY_EVENT: return createBoundaryEvent();
            case ProcessPackage.INTERMEDIATE_ERROR_CATCH_EVENT: return createIntermediateErrorCatchEvent();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
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
            case ProcessPackage.GATEWAY_TYPE:
                return createGatewayTypeFromString(eDataType, initialValue);
            case ProcessPackage.ACTOR_TYPE:
                return createActorTypeFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
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
            case ProcessPackage.GATEWAY_TYPE:
                return convertGatewayTypeToString(eDataType, instanceValue);
            case ProcessPackage.ACTOR_TYPE:
                return convertActorTypeToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MainProcess createMainProcess() {
        MainProcessImpl mainProcess = new MainProcessImpl();
        return mainProcess;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Task createTask() {
        TaskImpl task = new TaskImpl();
        return task;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Gateway createGateway() {
        GatewayImpl gateway = new GatewayImpl();
        return gateway;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XORGateway createXORGateway() {
        XORGatewayImpl xorGateway = new XORGatewayImpl();
        return xorGateway;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ANDGateway createANDGateway() {
        ANDGatewayImpl andGateway = new ANDGatewayImpl();
        return andGateway;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Connection createConnection() {
        ConnectionImpl connection = new ConnectionImpl();
        return connection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MessageFlow createMessageFlow() {
        MessageFlowImpl messageFlow = new MessageFlowImpl();
        return messageFlow;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Association createAssociation() {
        AssociationImpl association = new AssociationImpl();
        return association;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SequenceFlow createSequenceFlow() {
        SequenceFlowImpl sequenceFlow = new SequenceFlowImpl();
        return sequenceFlow;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Lane createLane() {
        LaneImpl lane = new LaneImpl();
        return lane;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pool createPool() {
        PoolImpl pool = new PoolImpl();
        return pool;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Activity createActivity() {
        ActivityImpl activity = new ActivityImpl();
        return activity;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SendTask createSendTask() {
        SendTaskImpl sendTask = new SendTaskImpl();
        return sendTask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReceiveTask createReceiveTask() {
        ReceiveTaskImpl receiveTask = new ReceiveTaskImpl();
        return receiveTask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScriptTask createScriptTask() {
        ScriptTaskImpl scriptTask = new ScriptTaskImpl();
        return scriptTask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceTask createServiceTask() {
        ServiceTaskImpl serviceTask = new ServiceTaskImpl();
        return serviceTask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SubProcess createSubProcess() {
        SubProcessImpl subProcess = new SubProcessImpl();
        return subProcess;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FlowElement createFlowElement() {
        FlowElementImpl flowElement = new FlowElementImpl();
        return flowElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.talend.process.model.process.Container createContainer() {
        ContainerImpl container = new ContainerImpl();
        return container;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConnectableElement createConnectableElement() {
        ConnectableElementImpl connectableElement = new ConnectableElementImpl();
        return connectableElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Connector createConnector() {
        ConnectorImpl connector = new ConnectorImpl();
        return connector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parameter createParameter() {
        ParameterImpl parameter = new ParameterImpl();
        return parameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OutputParameterMapping createOutputParameterMapping() {
        OutputParameterMappingImpl outputParameterMapping = new OutputParameterMappingImpl();
        return outputParameterMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Group createGroup() {
        GroupImpl group = new GroupImpl();
        return group;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data createData() {
        DataImpl data = new DataImpl();
        return data;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttachmentData createAttachmentData() {
        AttachmentDataImpl attachmentData = new AttachmentDataImpl();
        return attachmentData;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JavaObjectData createJavaObjectData() {
        JavaObjectDataImpl javaObjectData = new JavaObjectDataImpl();
        return javaObjectData;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XMLData createXMLData() {
        XMLDataImpl xmlData = new XMLDataImpl();
        return xmlData;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntegerType createIntegerType() {
        IntegerTypeImpl integerType = new IntegerTypeImpl();
        return integerType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StringType createStringType() {
        StringTypeImpl stringType = new StringTypeImpl();
        return stringType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DateType createDateType() {
        DateTypeImpl dateType = new DateTypeImpl();
        return dateType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FloatType createFloatType() {
        FloatTypeImpl floatType = new FloatTypeImpl();
        return floatType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BooleanType createBooleanType() {
        BooleanTypeImpl booleanType = new BooleanTypeImpl();
        return booleanType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EnumType createEnumType() {
        EnumTypeImpl enumType = new EnumTypeImpl();
        return enumType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JavaType createJavaType() {
        JavaTypeImpl javaType = new JavaTypeImpl();
        return javaType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XMLType createXMLType() {
        XMLTypeImpl xmlType = new XMLTypeImpl();
        return xmlType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OutputMapping createOutputMapping() {
        OutputMappingImpl outputMapping = new OutputMappingImpl();
        return outputMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttachmentType createAttachmentType() {
        AttachmentTypeImpl attachmentType = new AttachmentTypeImpl();
        return attachmentType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StartEvent createStartEvent() {
        StartEventImpl startEvent = new StartEventImpl();
        return startEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EndEvent createEndEvent() {
        EndEventImpl endEvent = new EndEventImpl();
        return endEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Event createEvent() {
        EventImpl event = new EventImpl();
        return event;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PageFlow createPageFlow() {
        PageFlowImpl pageFlow = new PageFlowImpl();
        return pageFlow;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceContainer createResourceContainer() {
        ResourceContainerImpl resourceContainer = new ResourceContainerImpl();
        return resourceContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssociatedFile createAssociatedFile() {
        AssociatedFileImpl associatedFile = new AssociatedFileImpl();
        return associatedFile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceFile createResourceFile() {
        ResourceFileImpl resourceFile = new ResourceFileImpl();
        return resourceFile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceFolder createResourceFolder() {
        ResourceFolderImpl resourceFolder = new ResourceFolderImpl();
        return resourceFolder;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Deadline createDeadline() {
        DeadlineImpl deadline = new DeadlineImpl();
        return deadline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MultiInstantiation createMultiInstantiation() {
        MultiInstantiationImpl multiInstantiation = new MultiInstantiationImpl();
        return multiInstantiation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputMapping createInputMapping() {
        InputMappingImpl inputMapping = new InputMappingImpl();
        return inputMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MessageEvent createMessageEvent() {
        MessageEventImpl messageEvent = new MessageEventImpl();
        return messageEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StartMessageEvent createStartMessageEvent() {
        StartMessageEventImpl startMessageEvent = new StartMessageEventImpl();
        return startMessageEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EndMessageEvent createEndMessageEvent() {
        EndMessageEventImpl endMessageEvent = new EndMessageEventImpl();
        return endMessageEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CatchMessageEvent createCatchMessageEvent() {
        CatchMessageEventImpl catchMessageEvent = new CatchMessageEventImpl();
        return catchMessageEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ThrowMessageEvent createThrowMessageEvent() {
        ThrowMessageEventImpl throwMessageEvent = new ThrowMessageEventImpl();
        return throwMessageEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateCatchMessageEvent createIntermediateCatchMessageEvent() {
        IntermediateCatchMessageEventImpl intermediateCatchMessageEvent = new IntermediateCatchMessageEventImpl();
        return intermediateCatchMessageEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateThrowMessageEvent createIntermediateThrowMessageEvent() {
        IntermediateThrowMessageEventImpl intermediateThrowMessageEvent = new IntermediateThrowMessageEventImpl();
        return intermediateThrowMessageEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextAnnotation createTextAnnotation() {
        TextAnnotationImpl textAnnotation = new TextAnnotationImpl();
        return textAnnotation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextAnnotationAttachment createTextAnnotationAttachment() {
        TextAnnotationAttachmentImpl textAnnotationAttachment = new TextAnnotationAttachmentImpl();
        return textAnnotationAttachment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventObject createEventObject() {
        EventObjectImpl eventObject = new EventObjectImpl();
        return eventObject;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TimerEvent createTimerEvent() {
        TimerEventImpl timerEvent = new TimerEventImpl();
        return timerEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StartTimerEvent createStartTimerEvent() {
        StartTimerEventImpl startTimerEvent = new StartTimerEventImpl();
        return startTimerEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateCatchTimerEvent createIntermediateCatchTimerEvent() {
        IntermediateCatchTimerEventImpl intermediateCatchTimerEvent = new IntermediateCatchTimerEventImpl();
        return intermediateCatchTimerEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CatchLinkEvent createCatchLinkEvent() {
        CatchLinkEventImpl catchLinkEvent = new CatchLinkEventImpl();
        return catchLinkEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ThrowLinkEvent createThrowLinkEvent() {
        ThrowLinkEventImpl throwLinkEvent = new ThrowLinkEventImpl();
        return throwLinkEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LinkEvent createLinkEvent() {
        LinkEventImpl linkEvent = new LinkEventImpl();
        return linkEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignalEvent createSignalEvent() {
        SignalEventImpl signalEvent = new SignalEventImpl();
        return signalEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ThrowSignalEvent createThrowSignalEvent() {
        ThrowSignalEventImpl throwSignalEvent = new ThrowSignalEventImpl();
        return throwSignalEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CatchSignalEvent createCatchSignalEvent() {
        CatchSignalEventImpl catchSignalEvent = new CatchSignalEventImpl();
        return catchSignalEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EndSignalEvent createEndSignalEvent() {
        EndSignalEventImpl endSignalEvent = new EndSignalEventImpl();
        return endSignalEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateThrowSignalEvent createIntermediateThrowSignalEvent() {
        IntermediateThrowSignalEventImpl intermediateThrowSignalEvent = new IntermediateThrowSignalEventImpl();
        return intermediateThrowSignalEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateCatchSignalEvent createIntermediateCatchSignalEvent() {
        IntermediateCatchSignalEventImpl intermediateCatchSignalEvent = new IntermediateCatchSignalEventImpl();
        return intermediateCatchSignalEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StartSignalEvent createStartSignalEvent() {
        StartSignalEventImpl startSignalEvent = new StartSignalEventImpl();
        return startSignalEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BoundaryEvent createBoundaryEvent() {
        BoundaryEventImpl boundaryEvent = new BoundaryEventImpl();
        return boundaryEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateErrorCatchEvent createIntermediateErrorCatchEvent() {
        IntermediateErrorCatchEventImpl intermediateErrorCatchEvent = new IntermediateErrorCatchEventImpl();
        return intermediateErrorCatchEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GatewayType createGatewayTypeFromString(EDataType eDataType, String initialValue) {
        GatewayType result = GatewayType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertGatewayTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ActorType createActorTypeFromString(EDataType eDataType, String initialValue) {
        ActorType result = ActorType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertActorTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessPackage getProcessPackage() {
        return (ProcessPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ProcessPackage getPackage() {
        return ProcessPackage.eINSTANCE;
    }

} //ProcessFactoryImpl
