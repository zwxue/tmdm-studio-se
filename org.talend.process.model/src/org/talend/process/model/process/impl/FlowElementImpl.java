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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.process.model.process.Connection;
import org.talend.process.model.process.FlowElement;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.SourceElement;
import org.talend.process.model.process.TargetElement;
import org.talend.process.model.process.TextAnnotationAttachment;

import org.talend.process.model.simulation.DataChange;
import org.talend.process.model.simulation.ResourceUsage;
import org.talend.process.model.simulation.SimulationActivity;
import org.talend.process.model.simulation.SimulationData;
import org.talend.process.model.simulation.SimulationDataContainer;
import org.talend.process.model.simulation.SimulationPackage;
import org.talend.process.model.simulation.SimulationTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getTextAnnotationAttachment <em>Text Annotation Attachment</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getSimulationData <em>Simulation Data</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getResourcesUsages <em>Resources Usages</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getExecutionTime <em>Execution Time</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getEstimatedTime <em>Estimated Time</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getMaximumTime <em>Maximum Time</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#isContigous <em>Contigous</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#isExclusiveOutgoingTransition <em>Exclusive Outgoing Transition</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getDataChange <em>Data Change</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getLoopTransition <em>Loop Transition</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getSynchronous <em>Synchronous</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getDynamicLabel <em>Dynamic Label</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getDynamicDescription <em>Dynamic Description</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.FlowElementImpl#getStepSummary <em>Step Summary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlowElementImpl extends EObjectImpl implements FlowElement {
    /**
     * The default value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDocumentation()
     * @generated
     * @ordered
     */
    protected static final String DOCUMENTATION_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDocumentation()
     * @generated
     * @ordered
     */
    protected String documentation = DOCUMENTATION_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * The cached value of the '{@link #getTextAnnotationAttachment() <em>Text Annotation Attachment</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextAnnotationAttachment()
     * @generated
     * @ordered
     */
    protected EList<TextAnnotationAttachment> textAnnotationAttachment;

    /**
     * The cached value of the '{@link #getSimulationData() <em>Simulation Data</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSimulationData()
     * @generated
     * @ordered
     */
    protected EList<SimulationData> simulationData;

    /**
     * The cached value of the '{@link #getResourcesUsages() <em>Resources Usages</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResourcesUsages()
     * @generated
     * @ordered
     */
    protected EList<ResourceUsage> resourcesUsages;

    /**
     * The default value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExecutionTime()
     * @generated
     * @ordered
     */
    protected static final long EXECUTION_TIME_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExecutionTime()
     * @generated
     * @ordered
     */
    protected long executionTime = EXECUTION_TIME_EDEFAULT;

    /**
     * The default value of the '{@link #getEstimatedTime() <em>Estimated Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEstimatedTime()
     * @generated
     * @ordered
     */
    protected static final double ESTIMATED_TIME_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getEstimatedTime() <em>Estimated Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEstimatedTime()
     * @generated
     * @ordered
     */
    protected double estimatedTime = ESTIMATED_TIME_EDEFAULT;

    /**
     * The default value of the '{@link #getMaximumTime() <em>Maximum Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaximumTime()
     * @generated
     * @ordered
     */
    protected static final double MAXIMUM_TIME_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getMaximumTime() <em>Maximum Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaximumTime()
     * @generated
     * @ordered
     */
    protected double maximumTime = MAXIMUM_TIME_EDEFAULT;

    /**
     * The default value of the '{@link #isContigous() <em>Contigous</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isContigous()
     * @generated
     * @ordered
     */
    protected static final boolean CONTIGOUS_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isContigous() <em>Contigous</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isContigous()
     * @generated
     * @ordered
     */
    protected boolean contigous = CONTIGOUS_EDEFAULT;

    /**
     * The default value of the '{@link #isExclusiveOutgoingTransition() <em>Exclusive Outgoing Transition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isExclusiveOutgoingTransition()
     * @generated
     * @ordered
     */
    protected static final boolean EXCLUSIVE_OUTGOING_TRANSITION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isExclusiveOutgoingTransition() <em>Exclusive Outgoing Transition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isExclusiveOutgoingTransition()
     * @generated
     * @ordered
     */
    protected boolean exclusiveOutgoingTransition = EXCLUSIVE_OUTGOING_TRANSITION_EDEFAULT;

    /**
     * The cached value of the '{@link #getDataChange() <em>Data Change</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataChange()
     * @generated
     * @ordered
     */
    protected EList<DataChange> dataChange;

    /**
     * The cached value of the '{@link #getLoopTransition() <em>Loop Transition</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLoopTransition()
     * @generated
     * @ordered
     */
    protected SimulationTransition loopTransition;

    /**
     * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutgoing()
     * @generated
     * @ordered
     */
    protected EList<Connection> outgoing;

    /**
     * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIncoming()
     * @generated
     * @ordered
     */
    protected EList<Connection> incoming;

    /**
     * The default value of the '{@link #getSynchronous() <em>Synchronous</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSynchronous()
     * @generated
     * @ordered
     */
    protected static final Boolean SYNCHRONOUS_EDEFAULT = Boolean.TRUE;

    /**
     * The cached value of the '{@link #getSynchronous() <em>Synchronous</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSynchronous()
     * @generated
     * @ordered
     */
    protected Boolean synchronous = SYNCHRONOUS_EDEFAULT;

    /**
     * The default value of the '{@link #getDynamicLabel() <em>Dynamic Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDynamicLabel()
     * @generated
     * @ordered
     */
    protected static final String DYNAMIC_LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDynamicLabel() <em>Dynamic Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDynamicLabel()
     * @generated
     * @ordered
     */
    protected String dynamicLabel = DYNAMIC_LABEL_EDEFAULT;

    /**
     * The default value of the '{@link #getDynamicDescription() <em>Dynamic Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDynamicDescription()
     * @generated
     * @ordered
     */
    protected static final String DYNAMIC_DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDynamicDescription() <em>Dynamic Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDynamicDescription()
     * @generated
     * @ordered
     */
    protected String dynamicDescription = DYNAMIC_DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getStepSummary() <em>Step Summary</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStepSummary()
     * @generated
     * @ordered
     */
    protected static final String STEP_SUMMARY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStepSummary() <em>Step Summary</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStepSummary()
     * @generated
     * @ordered
     */
    protected String stepSummary = STEP_SUMMARY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FlowElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.FLOW_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDocumentation() {
        return documentation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDocumentation(String newDocumentation) {
        String oldDocumentation = documentation;
        documentation = newDocumentation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__DOCUMENTATION, oldDocumentation, documentation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLabel() {
        return label;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabel(String newLabel) {
        String oldLabel = label;
        label = newLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TextAnnotationAttachment> getTextAnnotationAttachment() {
        if (textAnnotationAttachment == null) {
            textAnnotationAttachment = new EObjectContainmentWithInverseEList<TextAnnotationAttachment>(TextAnnotationAttachment.class, this, ProcessPackage.FLOW_ELEMENT__TEXT_ANNOTATION_ATTACHMENT, ProcessPackage.TEXT_ANNOTATION_ATTACHMENT__TARGET);
        }
        return textAnnotationAttachment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<SimulationData> getSimulationData() {
        if (simulationData == null) {
            simulationData = new EObjectContainmentEList<SimulationData>(SimulationData.class, this, ProcessPackage.FLOW_ELEMENT__SIMULATION_DATA);
        }
        return simulationData;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ResourceUsage> getResourcesUsages() {
        if (resourcesUsages == null) {
            resourcesUsages = new EObjectContainmentEList<ResourceUsage>(ResourceUsage.class, this, ProcessPackage.FLOW_ELEMENT__RESOURCES_USAGES);
        }
        return resourcesUsages;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getExecutionTime() {
        return executionTime;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExecutionTime(long newExecutionTime) {
        long oldExecutionTime = executionTime;
        executionTime = newExecutionTime;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__EXECUTION_TIME, oldExecutionTime, executionTime));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getEstimatedTime() {
        return estimatedTime;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEstimatedTime(double newEstimatedTime) {
        double oldEstimatedTime = estimatedTime;
        estimatedTime = newEstimatedTime;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__ESTIMATED_TIME, oldEstimatedTime, estimatedTime));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getMaximumTime() {
        return maximumTime;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMaximumTime(double newMaximumTime) {
        double oldMaximumTime = maximumTime;
        maximumTime = newMaximumTime;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__MAXIMUM_TIME, oldMaximumTime, maximumTime));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isContigous() {
        return contigous;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContigous(boolean newContigous) {
        boolean oldContigous = contigous;
        contigous = newContigous;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__CONTIGOUS, oldContigous, contigous));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isExclusiveOutgoingTransition() {
        return exclusiveOutgoingTransition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExclusiveOutgoingTransition(boolean newExclusiveOutgoingTransition) {
        boolean oldExclusiveOutgoingTransition = exclusiveOutgoingTransition;
        exclusiveOutgoingTransition = newExclusiveOutgoingTransition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__EXCLUSIVE_OUTGOING_TRANSITION, oldExclusiveOutgoingTransition, exclusiveOutgoingTransition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DataChange> getDataChange() {
        if (dataChange == null) {
            dataChange = new EObjectContainmentEList<DataChange>(DataChange.class, this, ProcessPackage.FLOW_ELEMENT__DATA_CHANGE);
        }
        return dataChange;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimulationTransition getLoopTransition() {
        return loopTransition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLoopTransition(SimulationTransition newLoopTransition, NotificationChain msgs) {
        SimulationTransition oldLoopTransition = loopTransition;
        loopTransition = newLoopTransition;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__LOOP_TRANSITION, oldLoopTransition, newLoopTransition);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLoopTransition(SimulationTransition newLoopTransition) {
        if (newLoopTransition != loopTransition) {
            NotificationChain msgs = null;
            if (loopTransition != null)
                msgs = ((InternalEObject)loopTransition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.FLOW_ELEMENT__LOOP_TRANSITION, null, msgs);
            if (newLoopTransition != null)
                msgs = ((InternalEObject)newLoopTransition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.FLOW_ELEMENT__LOOP_TRANSITION, null, msgs);
            msgs = basicSetLoopTransition(newLoopTransition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__LOOP_TRANSITION, newLoopTransition, newLoopTransition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connection> getOutgoing() {
        if (outgoing == null) {
            outgoing = new EObjectWithInverseResolvingEList<Connection>(Connection.class, this, ProcessPackage.FLOW_ELEMENT__OUTGOING, ProcessPackage.CONNECTION__SOURCE);
        }
        return outgoing;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connection> getIncoming() {
        if (incoming == null) {
            incoming = new EObjectWithInverseResolvingEList<Connection>(Connection.class, this, ProcessPackage.FLOW_ELEMENT__INCOMING, ProcessPackage.CONNECTION__TARGET);
        }
        return incoming;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getSynchronous() {
        return synchronous;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSynchronous(Boolean newSynchronous) {
        Boolean oldSynchronous = synchronous;
        synchronous = newSynchronous;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__SYNCHRONOUS, oldSynchronous, synchronous));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDynamicLabel() {
        return dynamicLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDynamicLabel(String newDynamicLabel) {
        String oldDynamicLabel = dynamicLabel;
        dynamicLabel = newDynamicLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__DYNAMIC_LABEL, oldDynamicLabel, dynamicLabel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDynamicDescription() {
        return dynamicDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDynamicDescription(String newDynamicDescription) {
        String oldDynamicDescription = dynamicDescription;
        dynamicDescription = newDynamicDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__DYNAMIC_DESCRIPTION, oldDynamicDescription, dynamicDescription));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getStepSummary() {
        return stepSummary;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStepSummary(String newStepSummary) {
        String oldStepSummary = stepSummary;
        stepSummary = newStepSummary;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLOW_ELEMENT__STEP_SUMMARY, oldStepSummary, stepSummary));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.FLOW_ELEMENT__TEXT_ANNOTATION_ATTACHMENT:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTextAnnotationAttachment()).basicAdd(otherEnd, msgs);
            case ProcessPackage.FLOW_ELEMENT__OUTGOING:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
            case ProcessPackage.FLOW_ELEMENT__INCOMING:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.FLOW_ELEMENT__TEXT_ANNOTATION_ATTACHMENT:
                return ((InternalEList<?>)getTextAnnotationAttachment()).basicRemove(otherEnd, msgs);
            case ProcessPackage.FLOW_ELEMENT__SIMULATION_DATA:
                return ((InternalEList<?>)getSimulationData()).basicRemove(otherEnd, msgs);
            case ProcessPackage.FLOW_ELEMENT__RESOURCES_USAGES:
                return ((InternalEList<?>)getResourcesUsages()).basicRemove(otherEnd, msgs);
            case ProcessPackage.FLOW_ELEMENT__DATA_CHANGE:
                return ((InternalEList<?>)getDataChange()).basicRemove(otherEnd, msgs);
            case ProcessPackage.FLOW_ELEMENT__LOOP_TRANSITION:
                return basicSetLoopTransition(null, msgs);
            case ProcessPackage.FLOW_ELEMENT__OUTGOING:
                return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
            case ProcessPackage.FLOW_ELEMENT__INCOMING:
                return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ProcessPackage.FLOW_ELEMENT__DOCUMENTATION:
                return getDocumentation();
            case ProcessPackage.FLOW_ELEMENT__NAME:
                return getName();
            case ProcessPackage.FLOW_ELEMENT__LABEL:
                return getLabel();
            case ProcessPackage.FLOW_ELEMENT__TEXT_ANNOTATION_ATTACHMENT:
                return getTextAnnotationAttachment();
            case ProcessPackage.FLOW_ELEMENT__SIMULATION_DATA:
                return getSimulationData();
            case ProcessPackage.FLOW_ELEMENT__RESOURCES_USAGES:
                return getResourcesUsages();
            case ProcessPackage.FLOW_ELEMENT__EXECUTION_TIME:
                return getExecutionTime();
            case ProcessPackage.FLOW_ELEMENT__ESTIMATED_TIME:
                return getEstimatedTime();
            case ProcessPackage.FLOW_ELEMENT__MAXIMUM_TIME:
                return getMaximumTime();
            case ProcessPackage.FLOW_ELEMENT__CONTIGOUS:
                return isContigous();
            case ProcessPackage.FLOW_ELEMENT__EXCLUSIVE_OUTGOING_TRANSITION:
                return isExclusiveOutgoingTransition();
            case ProcessPackage.FLOW_ELEMENT__DATA_CHANGE:
                return getDataChange();
            case ProcessPackage.FLOW_ELEMENT__LOOP_TRANSITION:
                return getLoopTransition();
            case ProcessPackage.FLOW_ELEMENT__OUTGOING:
                return getOutgoing();
            case ProcessPackage.FLOW_ELEMENT__INCOMING:
                return getIncoming();
            case ProcessPackage.FLOW_ELEMENT__SYNCHRONOUS:
                return getSynchronous();
            case ProcessPackage.FLOW_ELEMENT__DYNAMIC_LABEL:
                return getDynamicLabel();
            case ProcessPackage.FLOW_ELEMENT__DYNAMIC_DESCRIPTION:
                return getDynamicDescription();
            case ProcessPackage.FLOW_ELEMENT__STEP_SUMMARY:
                return getStepSummary();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ProcessPackage.FLOW_ELEMENT__DOCUMENTATION:
                setDocumentation((String)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__NAME:
                setName((String)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__LABEL:
                setLabel((String)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                getTextAnnotationAttachment().addAll((Collection<? extends TextAnnotationAttachment>)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__SIMULATION_DATA:
                getSimulationData().clear();
                getSimulationData().addAll((Collection<? extends SimulationData>)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__RESOURCES_USAGES:
                getResourcesUsages().clear();
                getResourcesUsages().addAll((Collection<? extends ResourceUsage>)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__EXECUTION_TIME:
                setExecutionTime((Long)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__ESTIMATED_TIME:
                setEstimatedTime((Double)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__MAXIMUM_TIME:
                setMaximumTime((Double)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__CONTIGOUS:
                setContigous((Boolean)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__EXCLUSIVE_OUTGOING_TRANSITION:
                setExclusiveOutgoingTransition((Boolean)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__DATA_CHANGE:
                getDataChange().clear();
                getDataChange().addAll((Collection<? extends DataChange>)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__LOOP_TRANSITION:
                setLoopTransition((SimulationTransition)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__OUTGOING:
                getOutgoing().clear();
                getOutgoing().addAll((Collection<? extends Connection>)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__INCOMING:
                getIncoming().clear();
                getIncoming().addAll((Collection<? extends Connection>)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__SYNCHRONOUS:
                setSynchronous((Boolean)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__DYNAMIC_LABEL:
                setDynamicLabel((String)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__DYNAMIC_DESCRIPTION:
                setDynamicDescription((String)newValue);
                return;
            case ProcessPackage.FLOW_ELEMENT__STEP_SUMMARY:
                setStepSummary((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ProcessPackage.FLOW_ELEMENT__DOCUMENTATION:
                setDocumentation(DOCUMENTATION_EDEFAULT);
                return;
            case ProcessPackage.FLOW_ELEMENT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ProcessPackage.FLOW_ELEMENT__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case ProcessPackage.FLOW_ELEMENT__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                return;
            case ProcessPackage.FLOW_ELEMENT__SIMULATION_DATA:
                getSimulationData().clear();
                return;
            case ProcessPackage.FLOW_ELEMENT__RESOURCES_USAGES:
                getResourcesUsages().clear();
                return;
            case ProcessPackage.FLOW_ELEMENT__EXECUTION_TIME:
                setExecutionTime(EXECUTION_TIME_EDEFAULT);
                return;
            case ProcessPackage.FLOW_ELEMENT__ESTIMATED_TIME:
                setEstimatedTime(ESTIMATED_TIME_EDEFAULT);
                return;
            case ProcessPackage.FLOW_ELEMENT__MAXIMUM_TIME:
                setMaximumTime(MAXIMUM_TIME_EDEFAULT);
                return;
            case ProcessPackage.FLOW_ELEMENT__CONTIGOUS:
                setContigous(CONTIGOUS_EDEFAULT);
                return;
            case ProcessPackage.FLOW_ELEMENT__EXCLUSIVE_OUTGOING_TRANSITION:
                setExclusiveOutgoingTransition(EXCLUSIVE_OUTGOING_TRANSITION_EDEFAULT);
                return;
            case ProcessPackage.FLOW_ELEMENT__DATA_CHANGE:
                getDataChange().clear();
                return;
            case ProcessPackage.FLOW_ELEMENT__LOOP_TRANSITION:
                setLoopTransition((SimulationTransition)null);
                return;
            case ProcessPackage.FLOW_ELEMENT__OUTGOING:
                getOutgoing().clear();
                return;
            case ProcessPackage.FLOW_ELEMENT__INCOMING:
                getIncoming().clear();
                return;
            case ProcessPackage.FLOW_ELEMENT__SYNCHRONOUS:
                setSynchronous(SYNCHRONOUS_EDEFAULT);
                return;
            case ProcessPackage.FLOW_ELEMENT__DYNAMIC_LABEL:
                setDynamicLabel(DYNAMIC_LABEL_EDEFAULT);
                return;
            case ProcessPackage.FLOW_ELEMENT__DYNAMIC_DESCRIPTION:
                setDynamicDescription(DYNAMIC_DESCRIPTION_EDEFAULT);
                return;
            case ProcessPackage.FLOW_ELEMENT__STEP_SUMMARY:
                setStepSummary(STEP_SUMMARY_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ProcessPackage.FLOW_ELEMENT__DOCUMENTATION:
                return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
            case ProcessPackage.FLOW_ELEMENT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ProcessPackage.FLOW_ELEMENT__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case ProcessPackage.FLOW_ELEMENT__TEXT_ANNOTATION_ATTACHMENT:
                return textAnnotationAttachment != null && !textAnnotationAttachment.isEmpty();
            case ProcessPackage.FLOW_ELEMENT__SIMULATION_DATA:
                return simulationData != null && !simulationData.isEmpty();
            case ProcessPackage.FLOW_ELEMENT__RESOURCES_USAGES:
                return resourcesUsages != null && !resourcesUsages.isEmpty();
            case ProcessPackage.FLOW_ELEMENT__EXECUTION_TIME:
                return executionTime != EXECUTION_TIME_EDEFAULT;
            case ProcessPackage.FLOW_ELEMENT__ESTIMATED_TIME:
                return estimatedTime != ESTIMATED_TIME_EDEFAULT;
            case ProcessPackage.FLOW_ELEMENT__MAXIMUM_TIME:
                return maximumTime != MAXIMUM_TIME_EDEFAULT;
            case ProcessPackage.FLOW_ELEMENT__CONTIGOUS:
                return contigous != CONTIGOUS_EDEFAULT;
            case ProcessPackage.FLOW_ELEMENT__EXCLUSIVE_OUTGOING_TRANSITION:
                return exclusiveOutgoingTransition != EXCLUSIVE_OUTGOING_TRANSITION_EDEFAULT;
            case ProcessPackage.FLOW_ELEMENT__DATA_CHANGE:
                return dataChange != null && !dataChange.isEmpty();
            case ProcessPackage.FLOW_ELEMENT__LOOP_TRANSITION:
                return loopTransition != null;
            case ProcessPackage.FLOW_ELEMENT__OUTGOING:
                return outgoing != null && !outgoing.isEmpty();
            case ProcessPackage.FLOW_ELEMENT__INCOMING:
                return incoming != null && !incoming.isEmpty();
            case ProcessPackage.FLOW_ELEMENT__SYNCHRONOUS:
                return SYNCHRONOUS_EDEFAULT == null ? synchronous != null : !SYNCHRONOUS_EDEFAULT.equals(synchronous);
            case ProcessPackage.FLOW_ELEMENT__DYNAMIC_LABEL:
                return DYNAMIC_LABEL_EDEFAULT == null ? dynamicLabel != null : !DYNAMIC_LABEL_EDEFAULT.equals(dynamicLabel);
            case ProcessPackage.FLOW_ELEMENT__DYNAMIC_DESCRIPTION:
                return DYNAMIC_DESCRIPTION_EDEFAULT == null ? dynamicDescription != null : !DYNAMIC_DESCRIPTION_EDEFAULT.equals(dynamicDescription);
            case ProcessPackage.FLOW_ELEMENT__STEP_SUMMARY:
                return STEP_SUMMARY_EDEFAULT == null ? stepSummary != null : !STEP_SUMMARY_EDEFAULT.equals(stepSummary);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == SimulationDataContainer.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.FLOW_ELEMENT__SIMULATION_DATA: return SimulationPackage.SIMULATION_DATA_CONTAINER__SIMULATION_DATA;
                default: return -1;
            }
        }
        if (baseClass == SimulationActivity.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.FLOW_ELEMENT__RESOURCES_USAGES: return SimulationPackage.SIMULATION_ACTIVITY__RESOURCES_USAGES;
                case ProcessPackage.FLOW_ELEMENT__EXECUTION_TIME: return SimulationPackage.SIMULATION_ACTIVITY__EXECUTION_TIME;
                case ProcessPackage.FLOW_ELEMENT__ESTIMATED_TIME: return SimulationPackage.SIMULATION_ACTIVITY__ESTIMATED_TIME;
                case ProcessPackage.FLOW_ELEMENT__MAXIMUM_TIME: return SimulationPackage.SIMULATION_ACTIVITY__MAXIMUM_TIME;
                case ProcessPackage.FLOW_ELEMENT__CONTIGOUS: return SimulationPackage.SIMULATION_ACTIVITY__CONTIGOUS;
                case ProcessPackage.FLOW_ELEMENT__EXCLUSIVE_OUTGOING_TRANSITION: return SimulationPackage.SIMULATION_ACTIVITY__EXCLUSIVE_OUTGOING_TRANSITION;
                case ProcessPackage.FLOW_ELEMENT__DATA_CHANGE: return SimulationPackage.SIMULATION_ACTIVITY__DATA_CHANGE;
                case ProcessPackage.FLOW_ELEMENT__LOOP_TRANSITION: return SimulationPackage.SIMULATION_ACTIVITY__LOOP_TRANSITION;
                default: return -1;
            }
        }
        if (baseClass == SourceElement.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.FLOW_ELEMENT__OUTGOING: return ProcessPackage.SOURCE_ELEMENT__OUTGOING;
                default: return -1;
            }
        }
        if (baseClass == TargetElement.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.FLOW_ELEMENT__INCOMING: return ProcessPackage.TARGET_ELEMENT__INCOMING;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == SimulationDataContainer.class) {
            switch (baseFeatureID) {
                case SimulationPackage.SIMULATION_DATA_CONTAINER__SIMULATION_DATA: return ProcessPackage.FLOW_ELEMENT__SIMULATION_DATA;
                default: return -1;
            }
        }
        if (baseClass == SimulationActivity.class) {
            switch (baseFeatureID) {
                case SimulationPackage.SIMULATION_ACTIVITY__RESOURCES_USAGES: return ProcessPackage.FLOW_ELEMENT__RESOURCES_USAGES;
                case SimulationPackage.SIMULATION_ACTIVITY__EXECUTION_TIME: return ProcessPackage.FLOW_ELEMENT__EXECUTION_TIME;
                case SimulationPackage.SIMULATION_ACTIVITY__ESTIMATED_TIME: return ProcessPackage.FLOW_ELEMENT__ESTIMATED_TIME;
                case SimulationPackage.SIMULATION_ACTIVITY__MAXIMUM_TIME: return ProcessPackage.FLOW_ELEMENT__MAXIMUM_TIME;
                case SimulationPackage.SIMULATION_ACTIVITY__CONTIGOUS: return ProcessPackage.FLOW_ELEMENT__CONTIGOUS;
                case SimulationPackage.SIMULATION_ACTIVITY__EXCLUSIVE_OUTGOING_TRANSITION: return ProcessPackage.FLOW_ELEMENT__EXCLUSIVE_OUTGOING_TRANSITION;
                case SimulationPackage.SIMULATION_ACTIVITY__DATA_CHANGE: return ProcessPackage.FLOW_ELEMENT__DATA_CHANGE;
                case SimulationPackage.SIMULATION_ACTIVITY__LOOP_TRANSITION: return ProcessPackage.FLOW_ELEMENT__LOOP_TRANSITION;
                default: return -1;
            }
        }
        if (baseClass == SourceElement.class) {
            switch (baseFeatureID) {
                case ProcessPackage.SOURCE_ELEMENT__OUTGOING: return ProcessPackage.FLOW_ELEMENT__OUTGOING;
                default: return -1;
            }
        }
        if (baseClass == TargetElement.class) {
            switch (baseFeatureID) {
                case ProcessPackage.TARGET_ELEMENT__INCOMING: return ProcessPackage.FLOW_ELEMENT__INCOMING;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (documentation: "); //$NON-NLS-1$
        result.append(documentation);
        result.append(", name: "); //$NON-NLS-1$
        result.append(name);
        result.append(", label: "); //$NON-NLS-1$
        result.append(label);
        result.append(", executionTime: "); //$NON-NLS-1$
        result.append(executionTime);
        result.append(", estimatedTime: "); //$NON-NLS-1$
        result.append(estimatedTime);
        result.append(", maximumTime: "); //$NON-NLS-1$
        result.append(maximumTime);
        result.append(", contigous: "); //$NON-NLS-1$
        result.append(contigous);
        result.append(", exclusiveOutgoingTransition: "); //$NON-NLS-1$
        result.append(exclusiveOutgoingTransition);
        result.append(", synchronous: "); //$NON-NLS-1$
        result.append(synchronous);
        result.append(", dynamicLabel: "); //$NON-NLS-1$
        result.append(dynamicLabel);
        result.append(", dynamicDescription: "); //$NON-NLS-1$
        result.append(dynamicDescription);
        result.append(", stepSummary: "); //$NON-NLS-1$
        result.append(stepSummary);
        result.append(')');
        return result.toString();
    }

} //FlowElementImpl
