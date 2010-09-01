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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.talend.process.model.process.CatchMessageEvent;
import org.talend.process.model.process.Event;
import org.talend.process.model.process.MessageEvent;
import org.talend.process.model.process.MessageFlow;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.ReceiveTask;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Receive Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.ReceiveTaskImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ReceiveTaskImpl#getIncomingMessag <em>Incoming Messag</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ReceiveTaskImpl#getMatcher <em>Matcher</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReceiveTaskImpl extends ActivityImpl implements ReceiveTask {
    /**
     * The default value of the '{@link #getEvent() <em>Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEvent()
     * @generated
     * @ordered
     */
    protected static final String EVENT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEvent() <em>Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEvent()
     * @generated
     * @ordered
     */
    protected String event = EVENT_EDEFAULT;

    /**
     * The cached value of the '{@link #getIncomingMessag() <em>Incoming Messag</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIncomingMessag()
     * @generated
     * @ordered
     */
    protected MessageFlow incomingMessag;

    /**
     * The default value of the '{@link #getMatcher() <em>Matcher</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMatcher()
     * @generated
     * @ordered
     */
    protected static final String MATCHER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMatcher()
     * @generated
     * @ordered
     */
    protected String matcher = MATCHER_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ReceiveTaskImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.RECEIVE_TASK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEvent() {
        return event;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEvent(String newEvent) {
        String oldEvent = event;
        event = newEvent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.RECEIVE_TASK__EVENT, oldEvent, event));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MessageFlow getIncomingMessag() {
        if (incomingMessag != null && incomingMessag.eIsProxy()) {
            InternalEObject oldIncomingMessag = (InternalEObject)incomingMessag;
            incomingMessag = (MessageFlow)eResolveProxy(oldIncomingMessag);
            if (incomingMessag != oldIncomingMessag) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.RECEIVE_TASK__INCOMING_MESSAG, oldIncomingMessag, incomingMessag));
            }
        }
        return incomingMessag;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MessageFlow basicGetIncomingMessag() {
        return incomingMessag;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetIncomingMessag(MessageFlow newIncomingMessag, NotificationChain msgs) {
        MessageFlow oldIncomingMessag = incomingMessag;
        incomingMessag = newIncomingMessag;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.RECEIVE_TASK__INCOMING_MESSAG, oldIncomingMessag, newIncomingMessag);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIncomingMessag(MessageFlow newIncomingMessag) {
        if (newIncomingMessag != incomingMessag) {
            NotificationChain msgs = null;
            if (incomingMessag != null)
                msgs = ((InternalEObject)incomingMessag).eInverseRemove(this, ProcessPackage.MESSAGE_FLOW__TARGET, MessageFlow.class, msgs);
            if (newIncomingMessag != null)
                msgs = ((InternalEObject)newIncomingMessag).eInverseAdd(this, ProcessPackage.MESSAGE_FLOW__TARGET, MessageFlow.class, msgs);
            msgs = basicSetIncomingMessag(newIncomingMessag, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.RECEIVE_TASK__INCOMING_MESSAG, newIncomingMessag, newIncomingMessag));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMatcher() {
        return matcher;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMatcher(String newMatcher) {
        String oldMatcher = matcher;
        matcher = newMatcher;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.RECEIVE_TASK__MATCHER, oldMatcher, matcher));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.RECEIVE_TASK__INCOMING_MESSAG:
                if (incomingMessag != null)
                    msgs = ((InternalEObject)incomingMessag).eInverseRemove(this, ProcessPackage.MESSAGE_FLOW__TARGET, MessageFlow.class, msgs);
                return basicSetIncomingMessag((MessageFlow)otherEnd, msgs);
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
            case ProcessPackage.RECEIVE_TASK__INCOMING_MESSAG:
                return basicSetIncomingMessag(null, msgs);
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
            case ProcessPackage.RECEIVE_TASK__EVENT:
                return getEvent();
            case ProcessPackage.RECEIVE_TASK__INCOMING_MESSAG:
                if (resolve) return getIncomingMessag();
                return basicGetIncomingMessag();
            case ProcessPackage.RECEIVE_TASK__MATCHER:
                return getMatcher();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ProcessPackage.RECEIVE_TASK__EVENT:
                setEvent((String)newValue);
                return;
            case ProcessPackage.RECEIVE_TASK__INCOMING_MESSAG:
                setIncomingMessag((MessageFlow)newValue);
                return;
            case ProcessPackage.RECEIVE_TASK__MATCHER:
                setMatcher((String)newValue);
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
            case ProcessPackage.RECEIVE_TASK__EVENT:
                setEvent(EVENT_EDEFAULT);
                return;
            case ProcessPackage.RECEIVE_TASK__INCOMING_MESSAG:
                setIncomingMessag((MessageFlow)null);
                return;
            case ProcessPackage.RECEIVE_TASK__MATCHER:
                setMatcher(MATCHER_EDEFAULT);
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
            case ProcessPackage.RECEIVE_TASK__EVENT:
                return EVENT_EDEFAULT == null ? event != null : !EVENT_EDEFAULT.equals(event);
            case ProcessPackage.RECEIVE_TASK__INCOMING_MESSAG:
                return incomingMessag != null;
            case ProcessPackage.RECEIVE_TASK__MATCHER:
                return MATCHER_EDEFAULT == null ? matcher != null : !MATCHER_EDEFAULT.equals(matcher);
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
        if (baseClass == Event.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == MessageEvent.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == CatchMessageEvent.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.RECEIVE_TASK__EVENT: return ProcessPackage.CATCH_MESSAGE_EVENT__EVENT;
                case ProcessPackage.RECEIVE_TASK__INCOMING_MESSAG: return ProcessPackage.CATCH_MESSAGE_EVENT__INCOMING_MESSAG;
                case ProcessPackage.RECEIVE_TASK__MATCHER: return ProcessPackage.CATCH_MESSAGE_EVENT__MATCHER;
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
        if (baseClass == Event.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == MessageEvent.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == CatchMessageEvent.class) {
            switch (baseFeatureID) {
                case ProcessPackage.CATCH_MESSAGE_EVENT__EVENT: return ProcessPackage.RECEIVE_TASK__EVENT;
                case ProcessPackage.CATCH_MESSAGE_EVENT__INCOMING_MESSAG: return ProcessPackage.RECEIVE_TASK__INCOMING_MESSAG;
                case ProcessPackage.CATCH_MESSAGE_EVENT__MATCHER: return ProcessPackage.RECEIVE_TASK__MATCHER;
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
        result.append(" (event: "); //$NON-NLS-1$
        result.append(event);
        result.append(", matcher: "); //$NON-NLS-1$
        result.append(matcher);
        result.append(')');
        return result.toString();
    }

} //ReceiveTaskImpl
