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
package org.talend.process.model.process;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.process.model.process.ProcessPackage
 * @generated
 */
public interface ProcessFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ProcessFactory eINSTANCE = org.talend.process.model.process.impl.ProcessFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Main Process</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Main Process</em>'.
     * @generated
     */
    MainProcess createMainProcess();

    /**
     * Returns a new object of class '<em>Task</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Task</em>'.
     * @generated
     */
    Task createTask();

    /**
     * Returns a new object of class '<em>Gateway</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Gateway</em>'.
     * @generated
     */
    Gateway createGateway();

    /**
     * Returns a new object of class '<em>XOR Gateway</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>XOR Gateway</em>'.
     * @generated
     */
    XORGateway createXORGateway();

    /**
     * Returns a new object of class '<em>AND Gateway</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>AND Gateway</em>'.
     * @generated
     */
    ANDGateway createANDGateway();

    /**
     * Returns a new object of class '<em>Connection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Connection</em>'.
     * @generated
     */
    Connection createConnection();

    /**
     * Returns a new object of class '<em>Message Flow</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Message Flow</em>'.
     * @generated
     */
    MessageFlow createMessageFlow();

    /**
     * Returns a new object of class '<em>Association</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Association</em>'.
     * @generated
     */
    Association createAssociation();

    /**
     * Returns a new object of class '<em>Sequence Flow</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Sequence Flow</em>'.
     * @generated
     */
    SequenceFlow createSequenceFlow();

    /**
     * Returns a new object of class '<em>Lane</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Lane</em>'.
     * @generated
     */
    Lane createLane();

    /**
     * Returns a new object of class '<em>Pool</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Pool</em>'.
     * @generated
     */
    Pool createPool();

    /**
     * Returns a new object of class '<em>Activity</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Activity</em>'.
     * @generated
     */
    Activity createActivity();

    /**
     * Returns a new object of class '<em>Send Task</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Send Task</em>'.
     * @generated
     */
    SendTask createSendTask();

    /**
     * Returns a new object of class '<em>Receive Task</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Receive Task</em>'.
     * @generated
     */
    ReceiveTask createReceiveTask();

    /**
     * Returns a new object of class '<em>Script Task</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Script Task</em>'.
     * @generated
     */
    ScriptTask createScriptTask();

    /**
     * Returns a new object of class '<em>Service Task</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Service Task</em>'.
     * @generated
     */
    ServiceTask createServiceTask();

    /**
     * Returns a new object of class '<em>Sub Process</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Sub Process</em>'.
     * @generated
     */
    SubProcess createSubProcess();

    /**
     * Returns a new object of class '<em>Flow Element</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Flow Element</em>'.
     * @generated
     */
    FlowElement createFlowElement();

    /**
     * Returns a new object of class '<em>Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Container</em>'.
     * @generated
     */
    Container createContainer();

    /**
     * Returns a new object of class '<em>Connectable Element</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Connectable Element</em>'.
     * @generated
     */
    ConnectableElement createConnectableElement();

    /**
     * Returns a new object of class '<em>Connector</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Connector</em>'.
     * @generated
     */
    Connector createConnector();

    /**
     * Returns a new object of class '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Parameter</em>'.
     * @generated
     */
    Parameter createParameter();

    /**
     * Returns a new object of class '<em>Output Parameter Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Output Parameter Mapping</em>'.
     * @generated
     */
    OutputParameterMapping createOutputParameterMapping();

    /**
     * Returns a new object of class '<em>Group</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Group</em>'.
     * @generated
     */
    Group createGroup();

    /**
     * Returns a new object of class '<em>Data</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data</em>'.
     * @generated
     */
    Data createData();

    /**
     * Returns a new object of class '<em>Attachment Data</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attachment Data</em>'.
     * @generated
     */
    AttachmentData createAttachmentData();

    /**
     * Returns a new object of class '<em>Java Object Data</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Java Object Data</em>'.
     * @generated
     */
    JavaObjectData createJavaObjectData();

    /**
     * Returns a new object of class '<em>XML Data</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>XML Data</em>'.
     * @generated
     */
    XMLData createXMLData();

    /**
     * Returns a new object of class '<em>Integer Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Integer Type</em>'.
     * @generated
     */
    IntegerType createIntegerType();

    /**
     * Returns a new object of class '<em>String Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>String Type</em>'.
     * @generated
     */
    StringType createStringType();

    /**
     * Returns a new object of class '<em>Date Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Date Type</em>'.
     * @generated
     */
    DateType createDateType();

    /**
     * Returns a new object of class '<em>Float Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Float Type</em>'.
     * @generated
     */
    FloatType createFloatType();

    /**
     * Returns a new object of class '<em>Boolean Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Boolean Type</em>'.
     * @generated
     */
    BooleanType createBooleanType();

    /**
     * Returns a new object of class '<em>Enum Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Enum Type</em>'.
     * @generated
     */
    EnumType createEnumType();

    /**
     * Returns a new object of class '<em>Java Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Java Type</em>'.
     * @generated
     */
    JavaType createJavaType();

    /**
     * Returns a new object of class '<em>XML Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>XML Type</em>'.
     * @generated
     */
    XMLType createXMLType();

    /**
     * Returns a new object of class '<em>Output Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Output Mapping</em>'.
     * @generated
     */
    OutputMapping createOutputMapping();

    /**
     * Returns a new object of class '<em>Attachment Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attachment Type</em>'.
     * @generated
     */
    AttachmentType createAttachmentType();

    /**
     * Returns a new object of class '<em>Start Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Start Event</em>'.
     * @generated
     */
    StartEvent createStartEvent();

    /**
     * Returns a new object of class '<em>End Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>End Event</em>'.
     * @generated
     */
    EndEvent createEndEvent();

    /**
     * Returns a new object of class '<em>Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event</em>'.
     * @generated
     */
    Event createEvent();

    /**
     * Returns a new object of class '<em>Page Flow</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Page Flow</em>'.
     * @generated
     */
    PageFlow createPageFlow();

    /**
     * Returns a new object of class '<em>Resource Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Resource Container</em>'.
     * @generated
     */
    ResourceContainer createResourceContainer();

    /**
     * Returns a new object of class '<em>Associated File</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Associated File</em>'.
     * @generated
     */
    AssociatedFile createAssociatedFile();

    /**
     * Returns a new object of class '<em>Resource File</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Resource File</em>'.
     * @generated
     */
    ResourceFile createResourceFile();

    /**
     * Returns a new object of class '<em>Resource Folder</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Resource Folder</em>'.
     * @generated
     */
    ResourceFolder createResourceFolder();

    /**
     * Returns a new object of class '<em>Deadline</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Deadline</em>'.
     * @generated
     */
    Deadline createDeadline();

    /**
     * Returns a new object of class '<em>Multi Instantiation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Multi Instantiation</em>'.
     * @generated
     */
    MultiInstantiation createMultiInstantiation();

    /**
     * Returns a new object of class '<em>Input Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Input Mapping</em>'.
     * @generated
     */
    InputMapping createInputMapping();

    /**
     * Returns a new object of class '<em>Message Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Message Event</em>'.
     * @generated
     */
    MessageEvent createMessageEvent();

    /**
     * Returns a new object of class '<em>Start Message Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Start Message Event</em>'.
     * @generated
     */
    StartMessageEvent createStartMessageEvent();

    /**
     * Returns a new object of class '<em>End Message Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>End Message Event</em>'.
     * @generated
     */
    EndMessageEvent createEndMessageEvent();

    /**
     * Returns a new object of class '<em>Catch Message Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Catch Message Event</em>'.
     * @generated
     */
    CatchMessageEvent createCatchMessageEvent();

    /**
     * Returns a new object of class '<em>Throw Message Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Throw Message Event</em>'.
     * @generated
     */
    ThrowMessageEvent createThrowMessageEvent();

    /**
     * Returns a new object of class '<em>Intermediate Catch Message Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Intermediate Catch Message Event</em>'.
     * @generated
     */
    IntermediateCatchMessageEvent createIntermediateCatchMessageEvent();

    /**
     * Returns a new object of class '<em>Intermediate Throw Message Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Intermediate Throw Message Event</em>'.
     * @generated
     */
    IntermediateThrowMessageEvent createIntermediateThrowMessageEvent();

    /**
     * Returns a new object of class '<em>Text Annotation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Text Annotation</em>'.
     * @generated
     */
    TextAnnotation createTextAnnotation();

    /**
     * Returns a new object of class '<em>Text Annotation Attachment</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Text Annotation Attachment</em>'.
     * @generated
     */
    TextAnnotationAttachment createTextAnnotationAttachment();

    /**
     * Returns a new object of class '<em>Event Object</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Object</em>'.
     * @generated
     */
    EventObject createEventObject();

    /**
     * Returns a new object of class '<em>Timer Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Timer Event</em>'.
     * @generated
     */
    TimerEvent createTimerEvent();

    /**
     * Returns a new object of class '<em>Start Timer Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Start Timer Event</em>'.
     * @generated
     */
    StartTimerEvent createStartTimerEvent();

    /**
     * Returns a new object of class '<em>Intermediate Catch Timer Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Intermediate Catch Timer Event</em>'.
     * @generated
     */
    IntermediateCatchTimerEvent createIntermediateCatchTimerEvent();

    /**
     * Returns a new object of class '<em>Catch Link Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Catch Link Event</em>'.
     * @generated
     */
    CatchLinkEvent createCatchLinkEvent();

    /**
     * Returns a new object of class '<em>Throw Link Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Throw Link Event</em>'.
     * @generated
     */
    ThrowLinkEvent createThrowLinkEvent();

    /**
     * Returns a new object of class '<em>Link Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Link Event</em>'.
     * @generated
     */
    LinkEvent createLinkEvent();

    /**
     * Returns a new object of class '<em>Signal Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Signal Event</em>'.
     * @generated
     */
    SignalEvent createSignalEvent();

    /**
     * Returns a new object of class '<em>Throw Signal Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Throw Signal Event</em>'.
     * @generated
     */
    ThrowSignalEvent createThrowSignalEvent();

    /**
     * Returns a new object of class '<em>Catch Signal Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Catch Signal Event</em>'.
     * @generated
     */
    CatchSignalEvent createCatchSignalEvent();

    /**
     * Returns a new object of class '<em>End Signal Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>End Signal Event</em>'.
     * @generated
     */
    EndSignalEvent createEndSignalEvent();

    /**
     * Returns a new object of class '<em>Intermediate Throw Signal Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Intermediate Throw Signal Event</em>'.
     * @generated
     */
    IntermediateThrowSignalEvent createIntermediateThrowSignalEvent();

    /**
     * Returns a new object of class '<em>Intermediate Catch Signal Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Intermediate Catch Signal Event</em>'.
     * @generated
     */
    IntermediateCatchSignalEvent createIntermediateCatchSignalEvent();

    /**
     * Returns a new object of class '<em>Start Signal Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Start Signal Event</em>'.
     * @generated
     */
    StartSignalEvent createStartSignalEvent();

    /**
     * Returns a new object of class '<em>Boundary Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Boundary Event</em>'.
     * @generated
     */
    BoundaryEvent createBoundaryEvent();

    /**
     * Returns a new object of class '<em>Intermediate Error Catch Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Intermediate Error Catch Event</em>'.
     * @generated
     */
    IntermediateErrorCatchEvent createIntermediateErrorCatchEvent();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ProcessPackage getProcessPackage();

} //ProcessFactory
