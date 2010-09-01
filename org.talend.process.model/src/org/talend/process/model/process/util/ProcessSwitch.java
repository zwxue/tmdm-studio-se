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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.talend.process.model.process.*;

import org.talend.process.model.simulation.SimulationAbstractProcess;
import org.talend.process.model.simulation.SimulationActivity;
import org.talend.process.model.simulation.SimulationDataContainer;
import org.talend.process.model.simulation.SimulationTransition;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.talend.process.model.process.ProcessPackage
 * @generated
 */
public class ProcessSwitch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ProcessPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessSwitch() {
        if (modelPackage == null) {
            modelPackage = ProcessPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case ProcessPackage.ELEMENT: {
                Element element = (Element)theEObject;
                T result = caseElement(element);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.ABSTRACT_PROCESS: {
                AbstractProcess abstractProcess = (AbstractProcess)theEObject;
                T result = caseAbstractProcess(abstractProcess);
                if (result == null) result = caseContainer(abstractProcess);
                if (result == null) result = caseResourceContainer(abstractProcess);
                if (result == null) result = casePageFlow(abstractProcess);
                if (result == null) result = caseSimulationAbstractProcess(abstractProcess);
                if (result == null) result = caseRecapFlow(abstractProcess);
                if (result == null) result = caseConnectableElement(abstractProcess);
                if (result == null) result = caseSimulationDataContainer(abstractProcess);
                if (result == null) result = caseElement(abstractProcess);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.MAIN_PROCESS: {
                MainProcess mainProcess = (MainProcess)theEObject;
                T result = caseMainProcess(mainProcess);
                if (result == null) result = caseAbstractProcess(mainProcess);
                if (result == null) result = caseContainer(mainProcess);
                if (result == null) result = caseResourceContainer(mainProcess);
                if (result == null) result = casePageFlow(mainProcess);
                if (result == null) result = caseSimulationAbstractProcess(mainProcess);
                if (result == null) result = caseRecapFlow(mainProcess);
                if (result == null) result = caseConnectableElement(mainProcess);
                if (result == null) result = caseSimulationDataContainer(mainProcess);
                if (result == null) result = caseElement(mainProcess);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.TASK: {
                Task task = (Task)theEObject;
                T result = caseTask(task);
                if (result == null) result = caseActivity(task);
                if (result == null) result = casePageFlow(task);
                if (result == null) result = caseResourceContainer(task);
                if (result == null) result = caseAssignable(task);
                if (result == null) result = caseFlowElement(task);
                if (result == null) result = caseConnectableElement(task);
                if (result == null) result = caseSimulationActivity(task);
                if (result == null) result = caseSourceElement(task);
                if (result == null) result = caseTargetElement(task);
                if (result == null) result = caseElement(task);
                if (result == null) result = caseSimulationDataContainer(task);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.GATEWAY: {
                Gateway gateway = (Gateway)theEObject;
                T result = caseGateway(gateway);
                if (result == null) result = caseFlowElement(gateway);
                if (result == null) result = caseSimulationActivity(gateway);
                if (result == null) result = caseSourceElement(gateway);
                if (result == null) result = caseTargetElement(gateway);
                if (result == null) result = caseElement(gateway);
                if (result == null) result = caseSimulationDataContainer(gateway);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.XOR_GATEWAY: {
                XORGateway xorGateway = (XORGateway)theEObject;
                T result = caseXORGateway(xorGateway);
                if (result == null) result = caseGateway(xorGateway);
                if (result == null) result = caseFlowElement(xorGateway);
                if (result == null) result = caseSimulationActivity(xorGateway);
                if (result == null) result = caseSourceElement(xorGateway);
                if (result == null) result = caseTargetElement(xorGateway);
                if (result == null) result = caseElement(xorGateway);
                if (result == null) result = caseSimulationDataContainer(xorGateway);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.AND_GATEWAY: {
                ANDGateway andGateway = (ANDGateway)theEObject;
                T result = caseANDGateway(andGateway);
                if (result == null) result = caseGateway(andGateway);
                if (result == null) result = caseFlowElement(andGateway);
                if (result == null) result = caseSimulationActivity(andGateway);
                if (result == null) result = caseSourceElement(andGateway);
                if (result == null) result = caseTargetElement(andGateway);
                if (result == null) result = caseElement(andGateway);
                if (result == null) result = caseSimulationDataContainer(andGateway);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.CONNECTION: {
                Connection connection = (Connection)theEObject;
                T result = caseConnection(connection);
                if (result == null) result = caseElement(connection);
                if (result == null) result = caseSimulationTransition(connection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.MESSAGE_FLOW: {
                MessageFlow messageFlow = (MessageFlow)theEObject;
                T result = caseMessageFlow(messageFlow);
                if (result == null) result = caseElement(messageFlow);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.ASSOCIATION: {
                Association association = (Association)theEObject;
                T result = caseAssociation(association);
                if (result == null) result = caseConnection(association);
                if (result == null) result = caseElement(association);
                if (result == null) result = caseSimulationTransition(association);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.SEQUENCE_FLOW: {
                SequenceFlow sequenceFlow = (SequenceFlow)theEObject;
                T result = caseSequenceFlow(sequenceFlow);
                if (result == null) result = caseConnection(sequenceFlow);
                if (result == null) result = caseElement(sequenceFlow);
                if (result == null) result = caseSimulationTransition(sequenceFlow);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.LANE: {
                Lane lane = (Lane)theEObject;
                T result = caseLane(lane);
                if (result == null) result = caseContainer(lane);
                if (result == null) result = caseAssignable(lane);
                if (result == null) result = caseElement(lane);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.POOL: {
                Pool pool = (Pool)theEObject;
                T result = casePool(pool);
                if (result == null) result = caseAbstractProcess(pool);
                if (result == null) result = caseContainer(pool);
                if (result == null) result = caseResourceContainer(pool);
                if (result == null) result = casePageFlow(pool);
                if (result == null) result = caseSimulationAbstractProcess(pool);
                if (result == null) result = caseRecapFlow(pool);
                if (result == null) result = caseConnectableElement(pool);
                if (result == null) result = caseSimulationDataContainer(pool);
                if (result == null) result = caseElement(pool);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.ACTIVITY: {
                Activity activity = (Activity)theEObject;
                T result = caseActivity(activity);
                if (result == null) result = caseFlowElement(activity);
                if (result == null) result = caseConnectableElement(activity);
                if (result == null) result = caseSimulationActivity(activity);
                if (result == null) result = caseSourceElement(activity);
                if (result == null) result = caseTargetElement(activity);
                if (result == null) result = caseElement(activity);
                if (result == null) result = caseSimulationDataContainer(activity);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.SEND_TASK: {
                SendTask sendTask = (SendTask)theEObject;
                T result = caseSendTask(sendTask);
                if (result == null) result = caseActivity(sendTask);
                if (result == null) result = caseThrowMessageEvent(sendTask);
                if (result == null) result = caseConnectableElement(sendTask);
                if (result == null) result = caseMessageEvent(sendTask);
                if (result == null) result = caseSimulationActivity(sendTask);
                if (result == null) result = caseSourceElement(sendTask);
                if (result == null) result = caseTargetElement(sendTask);
                if (result == null) result = caseEvent(sendTask);
                if (result == null) result = caseFlowElement(sendTask);
                if (result == null) result = caseElement(sendTask);
                if (result == null) result = caseSimulationDataContainer(sendTask);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.RECEIVE_TASK: {
                ReceiveTask receiveTask = (ReceiveTask)theEObject;
                T result = caseReceiveTask(receiveTask);
                if (result == null) result = caseActivity(receiveTask);
                if (result == null) result = caseCatchMessageEvent(receiveTask);
                if (result == null) result = caseConnectableElement(receiveTask);
                if (result == null) result = caseMessageEvent(receiveTask);
                if (result == null) result = caseSimulationActivity(receiveTask);
                if (result == null) result = caseSourceElement(receiveTask);
                if (result == null) result = caseTargetElement(receiveTask);
                if (result == null) result = caseEvent(receiveTask);
                if (result == null) result = caseFlowElement(receiveTask);
                if (result == null) result = caseElement(receiveTask);
                if (result == null) result = caseSimulationDataContainer(receiveTask);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.SCRIPT_TASK: {
                ScriptTask scriptTask = (ScriptTask)theEObject;
                T result = caseScriptTask(scriptTask);
                if (result == null) result = caseActivity(scriptTask);
                if (result == null) result = caseFlowElement(scriptTask);
                if (result == null) result = caseConnectableElement(scriptTask);
                if (result == null) result = caseSimulationActivity(scriptTask);
                if (result == null) result = caseSourceElement(scriptTask);
                if (result == null) result = caseTargetElement(scriptTask);
                if (result == null) result = caseElement(scriptTask);
                if (result == null) result = caseSimulationDataContainer(scriptTask);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.SERVICE_TASK: {
                ServiceTask serviceTask = (ServiceTask)theEObject;
                T result = caseServiceTask(serviceTask);
                if (result == null) result = caseActivity(serviceTask);
                if (result == null) result = caseFlowElement(serviceTask);
                if (result == null) result = caseConnectableElement(serviceTask);
                if (result == null) result = caseSimulationActivity(serviceTask);
                if (result == null) result = caseSourceElement(serviceTask);
                if (result == null) result = caseTargetElement(serviceTask);
                if (result == null) result = caseElement(serviceTask);
                if (result == null) result = caseSimulationDataContainer(serviceTask);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.SUB_PROCESS: {
                SubProcess subProcess = (SubProcess)theEObject;
                T result = caseSubProcess(subProcess);
                if (result == null) result = caseActivity(subProcess);
                if (result == null) result = caseFlowElement(subProcess);
                if (result == null) result = caseConnectableElement(subProcess);
                if (result == null) result = caseSimulationActivity(subProcess);
                if (result == null) result = caseSourceElement(subProcess);
                if (result == null) result = caseTargetElement(subProcess);
                if (result == null) result = caseElement(subProcess);
                if (result == null) result = caseSimulationDataContainer(subProcess);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.FLOW_ELEMENT: {
                FlowElement flowElement = (FlowElement)theEObject;
                T result = caseFlowElement(flowElement);
                if (result == null) result = caseSimulationActivity(flowElement);
                if (result == null) result = caseSourceElement(flowElement);
                if (result == null) result = caseTargetElement(flowElement);
                if (result == null) result = caseElement(flowElement);
                if (result == null) result = caseSimulationDataContainer(flowElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.CONTAINER: {
                Container container = (Container)theEObject;
                T result = caseContainer(container);
                if (result == null) result = caseElement(container);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.CONNECTABLE_ELEMENT: {
                ConnectableElement connectableElement = (ConnectableElement)theEObject;
                T result = caseConnectableElement(connectableElement);
                if (result == null) result = caseElement(connectableElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.CONNECTOR: {
                Connector connector = (Connector)theEObject;
                T result = caseConnector(connector);
                if (result == null) result = caseElement(connector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.PARAMETER: {
                Parameter parameter = (Parameter)theEObject;
                T result = caseParameter(parameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.OUTPUT_PARAMETER_MAPPING: {
                OutputParameterMapping outputParameterMapping = (OutputParameterMapping)theEObject;
                T result = caseOutputParameterMapping(outputParameterMapping);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.GROUP: {
                Group group = (Group)theEObject;
                T result = caseGroup(group);
                if (result == null) result = caseConnector(group);
                if (result == null) result = caseElement(group);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.DATA: {
                Data data = (Data)theEObject;
                T result = caseData(data);
                if (result == null) result = caseElement(data);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.ATTACHMENT_DATA: {
                AttachmentData attachmentData = (AttachmentData)theEObject;
                T result = caseAttachmentData(attachmentData);
                if (result == null) result = caseData(attachmentData);
                if (result == null) result = caseElement(attachmentData);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.JAVA_OBJECT_DATA: {
                JavaObjectData javaObjectData = (JavaObjectData)theEObject;
                T result = caseJavaObjectData(javaObjectData);
                if (result == null) result = caseData(javaObjectData);
                if (result == null) result = caseElement(javaObjectData);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.XML_DATA: {
                XMLData xmlData = (XMLData)theEObject;
                T result = caseXMLData(xmlData);
                if (result == null) result = caseData(xmlData);
                if (result == null) result = caseElement(xmlData);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.DATA_TYPE: {
                DataType dataType = (DataType)theEObject;
                T result = caseDataType(dataType);
                if (result == null) result = caseElement(dataType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.INTEGER_TYPE: {
                IntegerType integerType = (IntegerType)theEObject;
                T result = caseIntegerType(integerType);
                if (result == null) result = caseDataType(integerType);
                if (result == null) result = caseElement(integerType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.STRING_TYPE: {
                StringType stringType = (StringType)theEObject;
                T result = caseStringType(stringType);
                if (result == null) result = caseDataType(stringType);
                if (result == null) result = caseElement(stringType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.DATE_TYPE: {
                DateType dateType = (DateType)theEObject;
                T result = caseDateType(dateType);
                if (result == null) result = caseStringType(dateType);
                if (result == null) result = caseDataType(dateType);
                if (result == null) result = caseElement(dateType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.FLOAT_TYPE: {
                FloatType floatType = (FloatType)theEObject;
                T result = caseFloatType(floatType);
                if (result == null) result = caseDataType(floatType);
                if (result == null) result = caseElement(floatType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.BOOLEAN_TYPE: {
                BooleanType booleanType = (BooleanType)theEObject;
                T result = caseBooleanType(booleanType);
                if (result == null) result = caseDataType(booleanType);
                if (result == null) result = caseElement(booleanType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.ENUM_TYPE: {
                EnumType enumType = (EnumType)theEObject;
                T result = caseEnumType(enumType);
                if (result == null) result = caseDataType(enumType);
                if (result == null) result = caseElement(enumType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.JAVA_TYPE: {
                JavaType javaType = (JavaType)theEObject;
                T result = caseJavaType(javaType);
                if (result == null) result = caseDataType(javaType);
                if (result == null) result = caseElement(javaType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.XML_TYPE: {
                XMLType xmlType = (XMLType)theEObject;
                T result = caseXMLType(xmlType);
                if (result == null) result = caseDataType(xmlType);
                if (result == null) result = caseElement(xmlType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.OUTPUT_MAPPING: {
                OutputMapping outputMapping = (OutputMapping)theEObject;
                T result = caseOutputMapping(outputMapping);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.ATTACHMENT_TYPE: {
                AttachmentType attachmentType = (AttachmentType)theEObject;
                T result = caseAttachmentType(attachmentType);
                if (result == null) result = caseDataType(attachmentType);
                if (result == null) result = caseElement(attachmentType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.START_EVENT: {
                StartEvent startEvent = (StartEvent)theEObject;
                T result = caseStartEvent(startEvent);
                if (result == null) result = caseEvent(startEvent);
                if (result == null) result = caseFlowElement(startEvent);
                if (result == null) result = caseSimulationActivity(startEvent);
                if (result == null) result = caseSourceElement(startEvent);
                if (result == null) result = caseTargetElement(startEvent);
                if (result == null) result = caseElement(startEvent);
                if (result == null) result = caseSimulationDataContainer(startEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.END_EVENT: {
                EndEvent endEvent = (EndEvent)theEObject;
                T result = caseEndEvent(endEvent);
                if (result == null) result = caseEvent(endEvent);
                if (result == null) result = caseFlowElement(endEvent);
                if (result == null) result = caseSimulationActivity(endEvent);
                if (result == null) result = caseSourceElement(endEvent);
                if (result == null) result = caseTargetElement(endEvent);
                if (result == null) result = caseElement(endEvent);
                if (result == null) result = caseSimulationDataContainer(endEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.EVENT: {
                Event event = (Event)theEObject;
                T result = caseEvent(event);
                if (result == null) result = caseFlowElement(event);
                if (result == null) result = caseSimulationActivity(event);
                if (result == null) result = caseSourceElement(event);
                if (result == null) result = caseTargetElement(event);
                if (result == null) result = caseElement(event);
                if (result == null) result = caseSimulationDataContainer(event);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.PAGE_FLOW: {
                PageFlow pageFlow = (PageFlow)theEObject;
                T result = casePageFlow(pageFlow);
                if (result == null) result = caseConnectableElement(pageFlow);
                if (result == null) result = caseElement(pageFlow);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.RESOURCE_CONTAINER: {
                ResourceContainer resourceContainer = (ResourceContainer)theEObject;
                T result = caseResourceContainer(resourceContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.ASSOCIATED_FILE: {
                AssociatedFile associatedFile = (AssociatedFile)theEObject;
                T result = caseAssociatedFile(associatedFile);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.RESOURCE_FILE: {
                ResourceFile resourceFile = (ResourceFile)theEObject;
                T result = caseResourceFile(resourceFile);
                if (result == null) result = caseAssociatedFile(resourceFile);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.RESOURCE_FOLDER: {
                ResourceFolder resourceFolder = (ResourceFolder)theEObject;
                T result = caseResourceFolder(resourceFolder);
                if (result == null) result = caseAssociatedFile(resourceFolder);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.DEADLINE: {
                Deadline deadline = (Deadline)theEObject;
                T result = caseDeadline(deadline);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.MULTI_INSTANTIATION: {
                MultiInstantiation multiInstantiation = (MultiInstantiation)theEObject;
                T result = caseMultiInstantiation(multiInstantiation);
                if (result == null) result = caseConnector(multiInstantiation);
                if (result == null) result = caseElement(multiInstantiation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.INPUT_MAPPING: {
                InputMapping inputMapping = (InputMapping)theEObject;
                T result = caseInputMapping(inputMapping);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.MESSAGE_EVENT: {
                MessageEvent messageEvent = (MessageEvent)theEObject;
                T result = caseMessageEvent(messageEvent);
                if (result == null) result = caseEvent(messageEvent);
                if (result == null) result = caseFlowElement(messageEvent);
                if (result == null) result = caseSimulationActivity(messageEvent);
                if (result == null) result = caseSourceElement(messageEvent);
                if (result == null) result = caseTargetElement(messageEvent);
                if (result == null) result = caseElement(messageEvent);
                if (result == null) result = caseSimulationDataContainer(messageEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.START_MESSAGE_EVENT: {
                StartMessageEvent startMessageEvent = (StartMessageEvent)theEObject;
                T result = caseStartMessageEvent(startMessageEvent);
                if (result == null) result = caseCatchMessageEvent(startMessageEvent);
                if (result == null) result = caseMessageEvent(startMessageEvent);
                if (result == null) result = caseConnectableElement(startMessageEvent);
                if (result == null) result = caseEvent(startMessageEvent);
                if (result == null) result = caseFlowElement(startMessageEvent);
                if (result == null) result = caseSimulationActivity(startMessageEvent);
                if (result == null) result = caseSourceElement(startMessageEvent);
                if (result == null) result = caseTargetElement(startMessageEvent);
                if (result == null) result = caseElement(startMessageEvent);
                if (result == null) result = caseSimulationDataContainer(startMessageEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.END_MESSAGE_EVENT: {
                EndMessageEvent endMessageEvent = (EndMessageEvent)theEObject;
                T result = caseEndMessageEvent(endMessageEvent);
                if (result == null) result = caseThrowMessageEvent(endMessageEvent);
                if (result == null) result = caseMessageEvent(endMessageEvent);
                if (result == null) result = caseEvent(endMessageEvent);
                if (result == null) result = caseFlowElement(endMessageEvent);
                if (result == null) result = caseSimulationActivity(endMessageEvent);
                if (result == null) result = caseSourceElement(endMessageEvent);
                if (result == null) result = caseTargetElement(endMessageEvent);
                if (result == null) result = caseElement(endMessageEvent);
                if (result == null) result = caseSimulationDataContainer(endMessageEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.CATCH_MESSAGE_EVENT: {
                CatchMessageEvent catchMessageEvent = (CatchMessageEvent)theEObject;
                T result = caseCatchMessageEvent(catchMessageEvent);
                if (result == null) result = caseMessageEvent(catchMessageEvent);
                if (result == null) result = caseConnectableElement(catchMessageEvent);
                if (result == null) result = caseEvent(catchMessageEvent);
                if (result == null) result = caseFlowElement(catchMessageEvent);
                if (result == null) result = caseSimulationActivity(catchMessageEvent);
                if (result == null) result = caseSourceElement(catchMessageEvent);
                if (result == null) result = caseTargetElement(catchMessageEvent);
                if (result == null) result = caseElement(catchMessageEvent);
                if (result == null) result = caseSimulationDataContainer(catchMessageEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.THROW_MESSAGE_EVENT: {
                ThrowMessageEvent throwMessageEvent = (ThrowMessageEvent)theEObject;
                T result = caseThrowMessageEvent(throwMessageEvent);
                if (result == null) result = caseMessageEvent(throwMessageEvent);
                if (result == null) result = caseEvent(throwMessageEvent);
                if (result == null) result = caseFlowElement(throwMessageEvent);
                if (result == null) result = caseSimulationActivity(throwMessageEvent);
                if (result == null) result = caseSourceElement(throwMessageEvent);
                if (result == null) result = caseTargetElement(throwMessageEvent);
                if (result == null) result = caseElement(throwMessageEvent);
                if (result == null) result = caseSimulationDataContainer(throwMessageEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.INTERMEDIATE_CATCH_MESSAGE_EVENT: {
                IntermediateCatchMessageEvent intermediateCatchMessageEvent = (IntermediateCatchMessageEvent)theEObject;
                T result = caseIntermediateCatchMessageEvent(intermediateCatchMessageEvent);
                if (result == null) result = caseCatchMessageEvent(intermediateCatchMessageEvent);
                if (result == null) result = caseMessageEvent(intermediateCatchMessageEvent);
                if (result == null) result = caseConnectableElement(intermediateCatchMessageEvent);
                if (result == null) result = caseEvent(intermediateCatchMessageEvent);
                if (result == null) result = caseFlowElement(intermediateCatchMessageEvent);
                if (result == null) result = caseSimulationActivity(intermediateCatchMessageEvent);
                if (result == null) result = caseSourceElement(intermediateCatchMessageEvent);
                if (result == null) result = caseTargetElement(intermediateCatchMessageEvent);
                if (result == null) result = caseElement(intermediateCatchMessageEvent);
                if (result == null) result = caseSimulationDataContainer(intermediateCatchMessageEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.INTERMEDIATE_THROW_MESSAGE_EVENT: {
                IntermediateThrowMessageEvent intermediateThrowMessageEvent = (IntermediateThrowMessageEvent)theEObject;
                T result = caseIntermediateThrowMessageEvent(intermediateThrowMessageEvent);
                if (result == null) result = caseThrowMessageEvent(intermediateThrowMessageEvent);
                if (result == null) result = caseMessageEvent(intermediateThrowMessageEvent);
                if (result == null) result = caseEvent(intermediateThrowMessageEvent);
                if (result == null) result = caseFlowElement(intermediateThrowMessageEvent);
                if (result == null) result = caseSimulationActivity(intermediateThrowMessageEvent);
                if (result == null) result = caseSourceElement(intermediateThrowMessageEvent);
                if (result == null) result = caseTargetElement(intermediateThrowMessageEvent);
                if (result == null) result = caseElement(intermediateThrowMessageEvent);
                if (result == null) result = caseSimulationDataContainer(intermediateThrowMessageEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.TEXT_ANNOTATION: {
                TextAnnotation textAnnotation = (TextAnnotation)theEObject;
                T result = caseTextAnnotation(textAnnotation);
                if (result == null) result = caseElement(textAnnotation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.TEXT_ANNOTATION_ATTACHMENT: {
                TextAnnotationAttachment textAnnotationAttachment = (TextAnnotationAttachment)theEObject;
                T result = caseTextAnnotationAttachment(textAnnotationAttachment);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.EVENT_OBJECT: {
                EventObject eventObject = (EventObject)theEObject;
                T result = caseEventObject(eventObject);
                if (result == null) result = caseConnectableElement(eventObject);
                if (result == null) result = caseElement(eventObject);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.TIMER_EVENT: {
                TimerEvent timerEvent = (TimerEvent)theEObject;
                T result = caseTimerEvent(timerEvent);
                if (result == null) result = caseEvent(timerEvent);
                if (result == null) result = caseConnectableElement(timerEvent);
                if (result == null) result = caseFlowElement(timerEvent);
                if (result == null) result = caseSimulationActivity(timerEvent);
                if (result == null) result = caseSourceElement(timerEvent);
                if (result == null) result = caseTargetElement(timerEvent);
                if (result == null) result = caseElement(timerEvent);
                if (result == null) result = caseSimulationDataContainer(timerEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.START_TIMER_EVENT: {
                StartTimerEvent startTimerEvent = (StartTimerEvent)theEObject;
                T result = caseStartTimerEvent(startTimerEvent);
                if (result == null) result = caseTimerEvent(startTimerEvent);
                if (result == null) result = caseEvent(startTimerEvent);
                if (result == null) result = caseConnectableElement(startTimerEvent);
                if (result == null) result = caseFlowElement(startTimerEvent);
                if (result == null) result = caseSimulationActivity(startTimerEvent);
                if (result == null) result = caseSourceElement(startTimerEvent);
                if (result == null) result = caseTargetElement(startTimerEvent);
                if (result == null) result = caseElement(startTimerEvent);
                if (result == null) result = caseSimulationDataContainer(startTimerEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.INTERMEDIATE_CATCH_TIMER_EVENT: {
                IntermediateCatchTimerEvent intermediateCatchTimerEvent = (IntermediateCatchTimerEvent)theEObject;
                T result = caseIntermediateCatchTimerEvent(intermediateCatchTimerEvent);
                if (result == null) result = caseTimerEvent(intermediateCatchTimerEvent);
                if (result == null) result = caseEvent(intermediateCatchTimerEvent);
                if (result == null) result = caseConnectableElement(intermediateCatchTimerEvent);
                if (result == null) result = caseFlowElement(intermediateCatchTimerEvent);
                if (result == null) result = caseSimulationActivity(intermediateCatchTimerEvent);
                if (result == null) result = caseSourceElement(intermediateCatchTimerEvent);
                if (result == null) result = caseTargetElement(intermediateCatchTimerEvent);
                if (result == null) result = caseElement(intermediateCatchTimerEvent);
                if (result == null) result = caseSimulationDataContainer(intermediateCatchTimerEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.CATCH_LINK_EVENT: {
                CatchLinkEvent catchLinkEvent = (CatchLinkEvent)theEObject;
                T result = caseCatchLinkEvent(catchLinkEvent);
                if (result == null) result = caseLinkEvent(catchLinkEvent);
                if (result == null) result = caseEvent(catchLinkEvent);
                if (result == null) result = caseFlowElement(catchLinkEvent);
                if (result == null) result = caseSimulationActivity(catchLinkEvent);
                if (result == null) result = caseSourceElement(catchLinkEvent);
                if (result == null) result = caseTargetElement(catchLinkEvent);
                if (result == null) result = caseElement(catchLinkEvent);
                if (result == null) result = caseSimulationDataContainer(catchLinkEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.THROW_LINK_EVENT: {
                ThrowLinkEvent throwLinkEvent = (ThrowLinkEvent)theEObject;
                T result = caseThrowLinkEvent(throwLinkEvent);
                if (result == null) result = caseLinkEvent(throwLinkEvent);
                if (result == null) result = caseEvent(throwLinkEvent);
                if (result == null) result = caseFlowElement(throwLinkEvent);
                if (result == null) result = caseSimulationActivity(throwLinkEvent);
                if (result == null) result = caseSourceElement(throwLinkEvent);
                if (result == null) result = caseTargetElement(throwLinkEvent);
                if (result == null) result = caseElement(throwLinkEvent);
                if (result == null) result = caseSimulationDataContainer(throwLinkEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.LINK_EVENT: {
                LinkEvent linkEvent = (LinkEvent)theEObject;
                T result = caseLinkEvent(linkEvent);
                if (result == null) result = caseEvent(linkEvent);
                if (result == null) result = caseFlowElement(linkEvent);
                if (result == null) result = caseSimulationActivity(linkEvent);
                if (result == null) result = caseSourceElement(linkEvent);
                if (result == null) result = caseTargetElement(linkEvent);
                if (result == null) result = caseElement(linkEvent);
                if (result == null) result = caseSimulationDataContainer(linkEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.SIGNAL_EVENT: {
                SignalEvent signalEvent = (SignalEvent)theEObject;
                T result = caseSignalEvent(signalEvent);
                if (result == null) result = caseEvent(signalEvent);
                if (result == null) result = caseFlowElement(signalEvent);
                if (result == null) result = caseSimulationActivity(signalEvent);
                if (result == null) result = caseSourceElement(signalEvent);
                if (result == null) result = caseTargetElement(signalEvent);
                if (result == null) result = caseElement(signalEvent);
                if (result == null) result = caseSimulationDataContainer(signalEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.THROW_SIGNAL_EVENT: {
                ThrowSignalEvent throwSignalEvent = (ThrowSignalEvent)theEObject;
                T result = caseThrowSignalEvent(throwSignalEvent);
                if (result == null) result = caseSignalEvent(throwSignalEvent);
                if (result == null) result = caseEvent(throwSignalEvent);
                if (result == null) result = caseFlowElement(throwSignalEvent);
                if (result == null) result = caseSimulationActivity(throwSignalEvent);
                if (result == null) result = caseSourceElement(throwSignalEvent);
                if (result == null) result = caseTargetElement(throwSignalEvent);
                if (result == null) result = caseElement(throwSignalEvent);
                if (result == null) result = caseSimulationDataContainer(throwSignalEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.CATCH_SIGNAL_EVENT: {
                CatchSignalEvent catchSignalEvent = (CatchSignalEvent)theEObject;
                T result = caseCatchSignalEvent(catchSignalEvent);
                if (result == null) result = caseSignalEvent(catchSignalEvent);
                if (result == null) result = caseConnectableElement(catchSignalEvent);
                if (result == null) result = caseEvent(catchSignalEvent);
                if (result == null) result = caseFlowElement(catchSignalEvent);
                if (result == null) result = caseSimulationActivity(catchSignalEvent);
                if (result == null) result = caseSourceElement(catchSignalEvent);
                if (result == null) result = caseTargetElement(catchSignalEvent);
                if (result == null) result = caseElement(catchSignalEvent);
                if (result == null) result = caseSimulationDataContainer(catchSignalEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.END_SIGNAL_EVENT: {
                EndSignalEvent endSignalEvent = (EndSignalEvent)theEObject;
                T result = caseEndSignalEvent(endSignalEvent);
                if (result == null) result = caseThrowSignalEvent(endSignalEvent);
                if (result == null) result = caseSignalEvent(endSignalEvent);
                if (result == null) result = caseEvent(endSignalEvent);
                if (result == null) result = caseFlowElement(endSignalEvent);
                if (result == null) result = caseSimulationActivity(endSignalEvent);
                if (result == null) result = caseSourceElement(endSignalEvent);
                if (result == null) result = caseTargetElement(endSignalEvent);
                if (result == null) result = caseElement(endSignalEvent);
                if (result == null) result = caseSimulationDataContainer(endSignalEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.INTERMEDIATE_THROW_SIGNAL_EVENT: {
                IntermediateThrowSignalEvent intermediateThrowSignalEvent = (IntermediateThrowSignalEvent)theEObject;
                T result = caseIntermediateThrowSignalEvent(intermediateThrowSignalEvent);
                if (result == null) result = caseThrowSignalEvent(intermediateThrowSignalEvent);
                if (result == null) result = caseSignalEvent(intermediateThrowSignalEvent);
                if (result == null) result = caseEvent(intermediateThrowSignalEvent);
                if (result == null) result = caseFlowElement(intermediateThrowSignalEvent);
                if (result == null) result = caseSimulationActivity(intermediateThrowSignalEvent);
                if (result == null) result = caseSourceElement(intermediateThrowSignalEvent);
                if (result == null) result = caseTargetElement(intermediateThrowSignalEvent);
                if (result == null) result = caseElement(intermediateThrowSignalEvent);
                if (result == null) result = caseSimulationDataContainer(intermediateThrowSignalEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.INTERMEDIATE_CATCH_SIGNAL_EVENT: {
                IntermediateCatchSignalEvent intermediateCatchSignalEvent = (IntermediateCatchSignalEvent)theEObject;
                T result = caseIntermediateCatchSignalEvent(intermediateCatchSignalEvent);
                if (result == null) result = caseCatchSignalEvent(intermediateCatchSignalEvent);
                if (result == null) result = caseSignalEvent(intermediateCatchSignalEvent);
                if (result == null) result = caseConnectableElement(intermediateCatchSignalEvent);
                if (result == null) result = caseEvent(intermediateCatchSignalEvent);
                if (result == null) result = caseFlowElement(intermediateCatchSignalEvent);
                if (result == null) result = caseSimulationActivity(intermediateCatchSignalEvent);
                if (result == null) result = caseSourceElement(intermediateCatchSignalEvent);
                if (result == null) result = caseTargetElement(intermediateCatchSignalEvent);
                if (result == null) result = caseElement(intermediateCatchSignalEvent);
                if (result == null) result = caseSimulationDataContainer(intermediateCatchSignalEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.START_SIGNAL_EVENT: {
                StartSignalEvent startSignalEvent = (StartSignalEvent)theEObject;
                T result = caseStartSignalEvent(startSignalEvent);
                if (result == null) result = caseCatchSignalEvent(startSignalEvent);
                if (result == null) result = caseSignalEvent(startSignalEvent);
                if (result == null) result = caseConnectableElement(startSignalEvent);
                if (result == null) result = caseEvent(startSignalEvent);
                if (result == null) result = caseFlowElement(startSignalEvent);
                if (result == null) result = caseSimulationActivity(startSignalEvent);
                if (result == null) result = caseSourceElement(startSignalEvent);
                if (result == null) result = caseTargetElement(startSignalEvent);
                if (result == null) result = caseElement(startSignalEvent);
                if (result == null) result = caseSimulationDataContainer(startSignalEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.ASSIGNABLE: {
                Assignable assignable = (Assignable)theEObject;
                T result = caseAssignable(assignable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.RECAP_FLOW: {
                RecapFlow recapFlow = (RecapFlow)theEObject;
                T result = caseRecapFlow(recapFlow);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.BOUNDARY_EVENT: {
                BoundaryEvent boundaryEvent = (BoundaryEvent)theEObject;
                T result = caseBoundaryEvent(boundaryEvent);
                if (result == null) result = caseSourceElement(boundaryEvent);
                if (result == null) result = caseElement(boundaryEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.INTERMEDIATE_ERROR_CATCH_EVENT: {
                IntermediateErrorCatchEvent intermediateErrorCatchEvent = (IntermediateErrorCatchEvent)theEObject;
                T result = caseIntermediateErrorCatchEvent(intermediateErrorCatchEvent);
                if (result == null) result = caseBoundaryEvent(intermediateErrorCatchEvent);
                if (result == null) result = caseSourceElement(intermediateErrorCatchEvent);
                if (result == null) result = caseElement(intermediateErrorCatchEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.SOURCE_ELEMENT: {
                SourceElement sourceElement = (SourceElement)theEObject;
                T result = caseSourceElement(sourceElement);
                if (result == null) result = caseElement(sourceElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ProcessPackage.TARGET_ELEMENT: {
                TargetElement targetElement = (TargetElement)theEObject;
                T result = caseTargetElement(targetElement);
                if (result == null) result = caseElement(targetElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseElement(Element object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Process</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Process</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractProcess(AbstractProcess object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Main Process</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Main Process</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMainProcess(MainProcess object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTask(Task object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Gateway</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Gateway</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGateway(Gateway object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>XOR Gateway</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>XOR Gateway</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseXORGateway(XORGateway object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>AND Gateway</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>AND Gateway</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseANDGateway(ANDGateway object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnection(Connection object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Message Flow</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Message Flow</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMessageFlow(MessageFlow object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Association</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Association</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssociation(Association object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Sequence Flow</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sequence Flow</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSequenceFlow(SequenceFlow object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Lane</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Lane</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLane(Lane object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Pool</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Pool</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePool(Pool object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseActivity(Activity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Send Task</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Send Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSendTask(SendTask object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Receive Task</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Receive Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReceiveTask(ReceiveTask object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Script Task</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Script Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScriptTask(ScriptTask object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Service Task</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Service Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseServiceTask(ServiceTask object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Sub Process</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sub Process</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSubProcess(SubProcess object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Flow Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Flow Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFlowElement(FlowElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseContainer(Container object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Connectable Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connectable Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnectableElement(ConnectableElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnector(Connector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameter(Parameter object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Output Parameter Mapping</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Output Parameter Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOutputParameterMapping(OutputParameterMapping object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Group</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGroup(Group object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseData(Data object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attachment Data</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attachment Data</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttachmentData(AttachmentData object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Java Object Data</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Java Object Data</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJavaObjectData(JavaObjectData object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>XML Data</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>XML Data</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseXMLData(XMLData object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataType(DataType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntegerType(IntegerType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStringType(StringType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Date Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Date Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDateType(DateType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Float Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Float Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFloatType(FloatType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBooleanType(BooleanType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Enum Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enum Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEnumType(EnumType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Java Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Java Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJavaType(JavaType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>XML Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>XML Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseXMLType(XMLType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Output Mapping</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Output Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOutputMapping(OutputMapping object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attachment Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attachment Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttachmentType(AttachmentType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Start Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Start Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStartEvent(StartEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>End Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>End Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEndEvent(EndEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEvent(Event object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Page Flow</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Page Flow</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePageFlow(PageFlow object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceContainer(ResourceContainer object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Associated File</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Associated File</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssociatedFile(AssociatedFile object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource File</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource File</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceFile(ResourceFile object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource Folder</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource Folder</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceFolder(ResourceFolder object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Deadline</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Deadline</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDeadline(Deadline object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Multi Instantiation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Multi Instantiation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMultiInstantiation(MultiInstantiation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Input Mapping</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Input Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInputMapping(InputMapping object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Message Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Message Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMessageEvent(MessageEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Start Message Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Start Message Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStartMessageEvent(StartMessageEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>End Message Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>End Message Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEndMessageEvent(EndMessageEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Catch Message Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Catch Message Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCatchMessageEvent(CatchMessageEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Throw Message Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Throw Message Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseThrowMessageEvent(ThrowMessageEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Intermediate Catch Message Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Intermediate Catch Message Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateCatchMessageEvent(IntermediateCatchMessageEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Intermediate Throw Message Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Intermediate Throw Message Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateThrowMessageEvent(IntermediateThrowMessageEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Text Annotation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Text Annotation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTextAnnotation(TextAnnotation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Text Annotation Attachment</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Text Annotation Attachment</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTextAnnotationAttachment(TextAnnotationAttachment object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Object</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventObject(EventObject object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Timer Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Timer Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTimerEvent(TimerEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Start Timer Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Start Timer Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStartTimerEvent(StartTimerEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Intermediate Catch Timer Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Intermediate Catch Timer Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateCatchTimerEvent(IntermediateCatchTimerEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Catch Link Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Catch Link Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCatchLinkEvent(CatchLinkEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Throw Link Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Throw Link Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseThrowLinkEvent(ThrowLinkEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Link Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Link Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLinkEvent(LinkEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Signal Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Signal Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSignalEvent(SignalEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Throw Signal Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Throw Signal Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseThrowSignalEvent(ThrowSignalEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Catch Signal Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Catch Signal Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCatchSignalEvent(CatchSignalEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>End Signal Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>End Signal Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEndSignalEvent(EndSignalEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Intermediate Throw Signal Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Intermediate Throw Signal Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateThrowSignalEvent(IntermediateThrowSignalEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Intermediate Catch Signal Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Intermediate Catch Signal Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateCatchSignalEvent(IntermediateCatchSignalEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Start Signal Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Start Signal Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStartSignalEvent(StartSignalEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Assignable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Assignable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssignable(Assignable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Recap Flow</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Recap Flow</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRecapFlow(RecapFlow object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Boundary Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Boundary Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBoundaryEvent(BoundaryEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Intermediate Error Catch Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Intermediate Error Catch Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateErrorCatchEvent(IntermediateErrorCatchEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Source Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Source Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSourceElement(SourceElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Target Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Target Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTargetElement(TargetElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimulationDataContainer(SimulationDataContainer object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Process</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Process</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimulationAbstractProcess(SimulationAbstractProcess object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimulationActivity(SimulationActivity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimulationTransition(SimulationTransition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
        return null;
    }

} //ProcessSwitch
