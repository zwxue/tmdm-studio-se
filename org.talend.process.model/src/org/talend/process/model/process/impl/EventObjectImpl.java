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

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.talend.process.model.process.EventObject;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.ThrowMessageEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.EventObjectImpl#getThrowEvent <em>Throw Event</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.EventObjectImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.EventObjectImpl#getTtl <em>Ttl</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.EventObjectImpl#getTargetProcessName <em>Target Process Name</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.EventObjectImpl#getTargetElementName <em>Target Element Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventObjectImpl extends ConnectableElementImpl implements EventObject {
    /**
     * The default value of the '{@link #getThrowEvent() <em>Throw Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getThrowEvent()
     * @generated
     * @ordered
     */
    protected static final String THROW_EVENT_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getThrowEvent() <em>Throw Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getThrowEvent()
     * @generated
     * @ordered
     */
    protected String throwEvent = THROW_EVENT_EDEFAULT;

    /**
     * The default value of the '{@link #getTtl() <em>Ttl</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTtl()
     * @generated
     * @ordered
     */
    protected static final String TTL_EDEFAULT = "31104000000"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getTtl() <em>Ttl</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTtl()
     * @generated
     * @ordered
     */
    protected String ttl = TTL_EDEFAULT;

    /**
     * The default value of the '{@link #getTargetProcessName() <em>Target Process Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetProcessName()
     * @generated
     * @ordered
     */
    protected static final String TARGET_PROCESS_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTargetProcessName() <em>Target Process Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetProcessName()
     * @generated
     * @ordered
     */
    protected String targetProcessName = TARGET_PROCESS_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getTargetElementName() <em>Target Element Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetElementName()
     * @generated
     * @ordered
     */
    protected static final String TARGET_ELEMENT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTargetElementName() <em>Target Element Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetElementName()
     * @generated
     * @ordered
     */
    protected String targetElementName = TARGET_ELEMENT_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EventObjectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.EVENT_OBJECT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getThrowEvent() {
        return throwEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setThrowEvent(String newThrowEvent) {
        String oldThrowEvent = throwEvent;
        throwEvent = newThrowEvent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.EVENT_OBJECT__THROW_EVENT, oldThrowEvent, throwEvent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ThrowMessageEvent getSource() {
        if (eContainerFeatureID() != ProcessPackage.EVENT_OBJECT__SOURCE) return null;
        return (ThrowMessageEvent)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSource(ThrowMessageEvent newSource, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSource, ProcessPackage.EVENT_OBJECT__SOURCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSource(ThrowMessageEvent newSource) {
        if (newSource != eInternalContainer() || (eContainerFeatureID() != ProcessPackage.EVENT_OBJECT__SOURCE && newSource != null)) {
            if (EcoreUtil.isAncestor(this, newSource))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSource != null)
                msgs = ((InternalEObject)newSource).eInverseAdd(this, ProcessPackage.THROW_MESSAGE_EVENT__EVENTS, ThrowMessageEvent.class, msgs);
            msgs = basicSetSource(newSource, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.EVENT_OBJECT__SOURCE, newSource, newSource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTtl() {
        return ttl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTtl(String newTtl) {
        String oldTtl = ttl;
        ttl = newTtl;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.EVENT_OBJECT__TTL, oldTtl, ttl));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTargetProcessName() {
        return targetProcessName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetProcessName(String newTargetProcessName) {
        String oldTargetProcessName = targetProcessName;
        targetProcessName = newTargetProcessName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.EVENT_OBJECT__TARGET_PROCESS_NAME, oldTargetProcessName, targetProcessName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTargetElementName() {
        return targetElementName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetElementName(String newTargetElementName) {
        String oldTargetElementName = targetElementName;
        targetElementName = newTargetElementName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.EVENT_OBJECT__TARGET_ELEMENT_NAME, oldTargetElementName, targetElementName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.EVENT_OBJECT__SOURCE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSource((ThrowMessageEvent)otherEnd, msgs);
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
            case ProcessPackage.EVENT_OBJECT__SOURCE:
                return basicSetSource(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case ProcessPackage.EVENT_OBJECT__SOURCE:
                return eInternalContainer().eInverseRemove(this, ProcessPackage.THROW_MESSAGE_EVENT__EVENTS, ThrowMessageEvent.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ProcessPackage.EVENT_OBJECT__THROW_EVENT:
                return getThrowEvent();
            case ProcessPackage.EVENT_OBJECT__SOURCE:
                return getSource();
            case ProcessPackage.EVENT_OBJECT__TTL:
                return getTtl();
            case ProcessPackage.EVENT_OBJECT__TARGET_PROCESS_NAME:
                return getTargetProcessName();
            case ProcessPackage.EVENT_OBJECT__TARGET_ELEMENT_NAME:
                return getTargetElementName();
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
            case ProcessPackage.EVENT_OBJECT__THROW_EVENT:
                setThrowEvent((String)newValue);
                return;
            case ProcessPackage.EVENT_OBJECT__SOURCE:
                setSource((ThrowMessageEvent)newValue);
                return;
            case ProcessPackage.EVENT_OBJECT__TTL:
                setTtl((String)newValue);
                return;
            case ProcessPackage.EVENT_OBJECT__TARGET_PROCESS_NAME:
                setTargetProcessName((String)newValue);
                return;
            case ProcessPackage.EVENT_OBJECT__TARGET_ELEMENT_NAME:
                setTargetElementName((String)newValue);
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
            case ProcessPackage.EVENT_OBJECT__THROW_EVENT:
                setThrowEvent(THROW_EVENT_EDEFAULT);
                return;
            case ProcessPackage.EVENT_OBJECT__SOURCE:
                setSource((ThrowMessageEvent)null);
                return;
            case ProcessPackage.EVENT_OBJECT__TTL:
                setTtl(TTL_EDEFAULT);
                return;
            case ProcessPackage.EVENT_OBJECT__TARGET_PROCESS_NAME:
                setTargetProcessName(TARGET_PROCESS_NAME_EDEFAULT);
                return;
            case ProcessPackage.EVENT_OBJECT__TARGET_ELEMENT_NAME:
                setTargetElementName(TARGET_ELEMENT_NAME_EDEFAULT);
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
            case ProcessPackage.EVENT_OBJECT__THROW_EVENT:
                return THROW_EVENT_EDEFAULT == null ? throwEvent != null : !THROW_EVENT_EDEFAULT.equals(throwEvent);
            case ProcessPackage.EVENT_OBJECT__SOURCE:
                return getSource() != null;
            case ProcessPackage.EVENT_OBJECT__TTL:
                return TTL_EDEFAULT == null ? ttl != null : !TTL_EDEFAULT.equals(ttl);
            case ProcessPackage.EVENT_OBJECT__TARGET_PROCESS_NAME:
                return TARGET_PROCESS_NAME_EDEFAULT == null ? targetProcessName != null : !TARGET_PROCESS_NAME_EDEFAULT.equals(targetProcessName);
            case ProcessPackage.EVENT_OBJECT__TARGET_ELEMENT_NAME:
                return TARGET_ELEMENT_NAME_EDEFAULT == null ? targetElementName != null : !TARGET_ELEMENT_NAME_EDEFAULT.equals(targetElementName);
        }
        return super.eIsSet(featureID);
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
        result.append(" (throwEvent: "); //$NON-NLS-1$
        result.append(throwEvent);
        result.append(", ttl: "); //$NON-NLS-1$
        result.append(ttl);
        result.append(", targetProcessName: "); //$NON-NLS-1$
        result.append(targetProcessName);
        result.append(", targetElementName: "); //$NON-NLS-1$
        result.append(targetElementName);
        result.append(')');
        return result.toString();
    }

} //EventObjectImpl
