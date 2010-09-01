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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.process.model.kpi.AbstractKPIBinding;

import org.talend.process.model.process.Activity;
import org.talend.process.model.process.ConnectableElement;
import org.talend.process.model.process.Connector;
import org.talend.process.model.process.Data;
import org.talend.process.model.process.Deadline;
import org.talend.process.model.process.IntermediateErrorCatchEvent;
import org.talend.process.model.process.MultiInstantiation;
import org.talend.process.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.ActivityImpl#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ActivityImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ActivityImpl#getKpis <em>Kpis</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ActivityImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ActivityImpl#getDeadlines <em>Deadlines</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ActivityImpl#getMultiInstantiation <em>Multi Instantiation</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ActivityImpl#getIsLoop <em>Is Loop</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ActivityImpl#getTestBefore <em>Test Before</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ActivityImpl#getLoopCondition <em>Loop Condition</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ActivityImpl#getLoopMaximum <em>Loop Maximum</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ActivityImpl#getBoundaryIntermediateEvents <em>Boundary Intermediate Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends FlowElementImpl implements Activity {
    /**
     * The cached value of the '{@link #getConnectors() <em>Connectors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnectors()
     * @generated
     * @ordered
     */
    protected EList<Connector> connectors;

    /**
     * The cached value of the '{@link #getData() <em>Data</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getData()
     * @generated
     * @ordered
     */
    protected EList<Data> data;

    /**
     * The cached value of the '{@link #getKpis() <em>Kpis</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKpis()
     * @generated
     * @ordered
     */
    protected EList<AbstractKPIBinding> kpis;

    /**
     * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDuration()
     * @generated
     * @ordered
     */
    protected static final String DURATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDuration()
     * @generated
     * @ordered
     */
    protected String duration = DURATION_EDEFAULT;

    /**
     * The cached value of the '{@link #getDeadlines() <em>Deadlines</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeadlines()
     * @generated
     * @ordered
     */
    protected EList<Deadline> deadlines;

    /**
     * The cached value of the '{@link #getMultiInstantiation() <em>Multi Instantiation</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMultiInstantiation()
     * @generated
     * @ordered
     */
    protected MultiInstantiation multiInstantiation;

    /**
     * The default value of the '{@link #getIsLoop() <em>Is Loop</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIsLoop()
     * @generated
     * @ordered
     */
    protected static final Boolean IS_LOOP_EDEFAULT = Boolean.FALSE;

    /**
     * The cached value of the '{@link #getIsLoop() <em>Is Loop</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIsLoop()
     * @generated
     * @ordered
     */
    protected Boolean isLoop = IS_LOOP_EDEFAULT;

    /**
     * The default value of the '{@link #getTestBefore() <em>Test Before</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTestBefore()
     * @generated
     * @ordered
     */
    protected static final Boolean TEST_BEFORE_EDEFAULT = Boolean.FALSE;

    /**
     * The cached value of the '{@link #getTestBefore() <em>Test Before</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTestBefore()
     * @generated
     * @ordered
     */
    protected Boolean testBefore = TEST_BEFORE_EDEFAULT;

    /**
     * The default value of the '{@link #getLoopCondition() <em>Loop Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLoopCondition()
     * @generated
     * @ordered
     */
    protected static final String LOOP_CONDITION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLoopCondition() <em>Loop Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLoopCondition()
     * @generated
     * @ordered
     */
    protected String loopCondition = LOOP_CONDITION_EDEFAULT;

    /**
     * The default value of the '{@link #getLoopMaximum() <em>Loop Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLoopMaximum()
     * @generated
     * @ordered
     */
    protected static final String LOOP_MAXIMUM_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getLoopMaximum() <em>Loop Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLoopMaximum()
     * @generated
     * @ordered
     */
    protected String loopMaximum = LOOP_MAXIMUM_EDEFAULT;

    /**
     * The cached value of the '{@link #getBoundaryIntermediateEvents() <em>Boundary Intermediate Events</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBoundaryIntermediateEvents()
     * @generated
     * @ordered
     */
    protected EList<IntermediateErrorCatchEvent> boundaryIntermediateEvents;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ActivityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.ACTIVITY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getConnectors() {
        if (connectors == null) {
            connectors = new EObjectContainmentEList<Connector>(Connector.class, this, ProcessPackage.ACTIVITY__CONNECTORS);
        }
        return connectors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Data> getData() {
        if (data == null) {
            data = new EObjectContainmentEList<Data>(Data.class, this, ProcessPackage.ACTIVITY__DATA);
        }
        return data;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<AbstractKPIBinding> getKpis() {
        if (kpis == null) {
            kpis = new EObjectContainmentEList<AbstractKPIBinding>(AbstractKPIBinding.class, this, ProcessPackage.ACTIVITY__KPIS);
        }
        return kpis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDuration() {
        return duration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDuration(String newDuration) {
        String oldDuration = duration;
        duration = newDuration;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ACTIVITY__DURATION, oldDuration, duration));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Deadline> getDeadlines() {
        if (deadlines == null) {
            deadlines = new EObjectContainmentEList<Deadline>(Deadline.class, this, ProcessPackage.ACTIVITY__DEADLINES);
        }
        return deadlines;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MultiInstantiation getMultiInstantiation() {
        return multiInstantiation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMultiInstantiation(MultiInstantiation newMultiInstantiation, NotificationChain msgs) {
        MultiInstantiation oldMultiInstantiation = multiInstantiation;
        multiInstantiation = newMultiInstantiation;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ACTIVITY__MULTI_INSTANTIATION, oldMultiInstantiation, newMultiInstantiation);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMultiInstantiation(MultiInstantiation newMultiInstantiation) {
        if (newMultiInstantiation != multiInstantiation) {
            NotificationChain msgs = null;
            if (multiInstantiation != null)
                msgs = ((InternalEObject)multiInstantiation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ACTIVITY__MULTI_INSTANTIATION, null, msgs);
            if (newMultiInstantiation != null)
                msgs = ((InternalEObject)newMultiInstantiation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ACTIVITY__MULTI_INSTANTIATION, null, msgs);
            msgs = basicSetMultiInstantiation(newMultiInstantiation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ACTIVITY__MULTI_INSTANTIATION, newMultiInstantiation, newMultiInstantiation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getIsLoop() {
        return isLoop;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsLoop(Boolean newIsLoop) {
        Boolean oldIsLoop = isLoop;
        isLoop = newIsLoop;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ACTIVITY__IS_LOOP, oldIsLoop, isLoop));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getTestBefore() {
        return testBefore;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTestBefore(Boolean newTestBefore) {
        Boolean oldTestBefore = testBefore;
        testBefore = newTestBefore;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ACTIVITY__TEST_BEFORE, oldTestBefore, testBefore));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLoopCondition() {
        return loopCondition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLoopCondition(String newLoopCondition) {
        String oldLoopCondition = loopCondition;
        loopCondition = newLoopCondition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ACTIVITY__LOOP_CONDITION, oldLoopCondition, loopCondition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLoopMaximum() {
        return loopMaximum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLoopMaximum(String newLoopMaximum) {
        String oldLoopMaximum = loopMaximum;
        loopMaximum = newLoopMaximum;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ACTIVITY__LOOP_MAXIMUM, oldLoopMaximum, loopMaximum));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateErrorCatchEvent> getBoundaryIntermediateEvents() {
        if (boundaryIntermediateEvents == null) {
            boundaryIntermediateEvents = new EObjectContainmentEList<IntermediateErrorCatchEvent>(IntermediateErrorCatchEvent.class, this, ProcessPackage.ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS);
        }
        return boundaryIntermediateEvents;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.ACTIVITY__CONNECTORS:
                return ((InternalEList<?>)getConnectors()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ACTIVITY__DATA:
                return ((InternalEList<?>)getData()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ACTIVITY__KPIS:
                return ((InternalEList<?>)getKpis()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ACTIVITY__DEADLINES:
                return ((InternalEList<?>)getDeadlines()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ACTIVITY__MULTI_INSTANTIATION:
                return basicSetMultiInstantiation(null, msgs);
            case ProcessPackage.ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS:
                return ((InternalEList<?>)getBoundaryIntermediateEvents()).basicRemove(otherEnd, msgs);
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
            case ProcessPackage.ACTIVITY__CONNECTORS:
                return getConnectors();
            case ProcessPackage.ACTIVITY__DATA:
                return getData();
            case ProcessPackage.ACTIVITY__KPIS:
                return getKpis();
            case ProcessPackage.ACTIVITY__DURATION:
                return getDuration();
            case ProcessPackage.ACTIVITY__DEADLINES:
                return getDeadlines();
            case ProcessPackage.ACTIVITY__MULTI_INSTANTIATION:
                return getMultiInstantiation();
            case ProcessPackage.ACTIVITY__IS_LOOP:
                return getIsLoop();
            case ProcessPackage.ACTIVITY__TEST_BEFORE:
                return getTestBefore();
            case ProcessPackage.ACTIVITY__LOOP_CONDITION:
                return getLoopCondition();
            case ProcessPackage.ACTIVITY__LOOP_MAXIMUM:
                return getLoopMaximum();
            case ProcessPackage.ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS:
                return getBoundaryIntermediateEvents();
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
            case ProcessPackage.ACTIVITY__CONNECTORS:
                getConnectors().clear();
                getConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case ProcessPackage.ACTIVITY__DATA:
                getData().clear();
                getData().addAll((Collection<? extends Data>)newValue);
                return;
            case ProcessPackage.ACTIVITY__KPIS:
                getKpis().clear();
                getKpis().addAll((Collection<? extends AbstractKPIBinding>)newValue);
                return;
            case ProcessPackage.ACTIVITY__DURATION:
                setDuration((String)newValue);
                return;
            case ProcessPackage.ACTIVITY__DEADLINES:
                getDeadlines().clear();
                getDeadlines().addAll((Collection<? extends Deadline>)newValue);
                return;
            case ProcessPackage.ACTIVITY__MULTI_INSTANTIATION:
                setMultiInstantiation((MultiInstantiation)newValue);
                return;
            case ProcessPackage.ACTIVITY__IS_LOOP:
                setIsLoop((Boolean)newValue);
                return;
            case ProcessPackage.ACTIVITY__TEST_BEFORE:
                setTestBefore((Boolean)newValue);
                return;
            case ProcessPackage.ACTIVITY__LOOP_CONDITION:
                setLoopCondition((String)newValue);
                return;
            case ProcessPackage.ACTIVITY__LOOP_MAXIMUM:
                setLoopMaximum((String)newValue);
                return;
            case ProcessPackage.ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS:
                getBoundaryIntermediateEvents().clear();
                getBoundaryIntermediateEvents().addAll((Collection<? extends IntermediateErrorCatchEvent>)newValue);
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
            case ProcessPackage.ACTIVITY__CONNECTORS:
                getConnectors().clear();
                return;
            case ProcessPackage.ACTIVITY__DATA:
                getData().clear();
                return;
            case ProcessPackage.ACTIVITY__KPIS:
                getKpis().clear();
                return;
            case ProcessPackage.ACTIVITY__DURATION:
                setDuration(DURATION_EDEFAULT);
                return;
            case ProcessPackage.ACTIVITY__DEADLINES:
                getDeadlines().clear();
                return;
            case ProcessPackage.ACTIVITY__MULTI_INSTANTIATION:
                setMultiInstantiation((MultiInstantiation)null);
                return;
            case ProcessPackage.ACTIVITY__IS_LOOP:
                setIsLoop(IS_LOOP_EDEFAULT);
                return;
            case ProcessPackage.ACTIVITY__TEST_BEFORE:
                setTestBefore(TEST_BEFORE_EDEFAULT);
                return;
            case ProcessPackage.ACTIVITY__LOOP_CONDITION:
                setLoopCondition(LOOP_CONDITION_EDEFAULT);
                return;
            case ProcessPackage.ACTIVITY__LOOP_MAXIMUM:
                setLoopMaximum(LOOP_MAXIMUM_EDEFAULT);
                return;
            case ProcessPackage.ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS:
                getBoundaryIntermediateEvents().clear();
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
            case ProcessPackage.ACTIVITY__CONNECTORS:
                return connectors != null && !connectors.isEmpty();
            case ProcessPackage.ACTIVITY__DATA:
                return data != null && !data.isEmpty();
            case ProcessPackage.ACTIVITY__KPIS:
                return kpis != null && !kpis.isEmpty();
            case ProcessPackage.ACTIVITY__DURATION:
                return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
            case ProcessPackage.ACTIVITY__DEADLINES:
                return deadlines != null && !deadlines.isEmpty();
            case ProcessPackage.ACTIVITY__MULTI_INSTANTIATION:
                return multiInstantiation != null;
            case ProcessPackage.ACTIVITY__IS_LOOP:
                return IS_LOOP_EDEFAULT == null ? isLoop != null : !IS_LOOP_EDEFAULT.equals(isLoop);
            case ProcessPackage.ACTIVITY__TEST_BEFORE:
                return TEST_BEFORE_EDEFAULT == null ? testBefore != null : !TEST_BEFORE_EDEFAULT.equals(testBefore);
            case ProcessPackage.ACTIVITY__LOOP_CONDITION:
                return LOOP_CONDITION_EDEFAULT == null ? loopCondition != null : !LOOP_CONDITION_EDEFAULT.equals(loopCondition);
            case ProcessPackage.ACTIVITY__LOOP_MAXIMUM:
                return LOOP_MAXIMUM_EDEFAULT == null ? loopMaximum != null : !LOOP_MAXIMUM_EDEFAULT.equals(loopMaximum);
            case ProcessPackage.ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS:
                return boundaryIntermediateEvents != null && !boundaryIntermediateEvents.isEmpty();
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
        if (baseClass == ConnectableElement.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.ACTIVITY__CONNECTORS: return ProcessPackage.CONNECTABLE_ELEMENT__CONNECTORS;
                case ProcessPackage.ACTIVITY__DATA: return ProcessPackage.CONNECTABLE_ELEMENT__DATA;
                case ProcessPackage.ACTIVITY__KPIS: return ProcessPackage.CONNECTABLE_ELEMENT__KPIS;
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
        if (baseClass == ConnectableElement.class) {
            switch (baseFeatureID) {
                case ProcessPackage.CONNECTABLE_ELEMENT__CONNECTORS: return ProcessPackage.ACTIVITY__CONNECTORS;
                case ProcessPackage.CONNECTABLE_ELEMENT__DATA: return ProcessPackage.ACTIVITY__DATA;
                case ProcessPackage.CONNECTABLE_ELEMENT__KPIS: return ProcessPackage.ACTIVITY__KPIS;
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
        result.append(" (duration: "); //$NON-NLS-1$
        result.append(duration);
        result.append(", isLoop: "); //$NON-NLS-1$
        result.append(isLoop);
        result.append(", testBefore: "); //$NON-NLS-1$
        result.append(testBefore);
        result.append(", loopCondition: "); //$NON-NLS-1$
        result.append(loopCondition);
        result.append(", loopMaximum: "); //$NON-NLS-1$
        result.append(loopMaximum);
        result.append(')');
        return result.toString();
    }

} //ActivityImpl
