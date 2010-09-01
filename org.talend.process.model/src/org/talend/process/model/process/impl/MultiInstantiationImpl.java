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

import org.talend.process.model.process.Connector;
import org.talend.process.model.process.Data;
import org.talend.process.model.process.MultiInstantiation;
import org.talend.process.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Instantiation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.MultiInstantiationImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.MultiInstantiationImpl#getActivityData <em>Activity Data</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.MultiInstantiationImpl#getInstantiator <em>Instantiator</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.MultiInstantiationImpl#getJoinChecker <em>Join Checker</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiInstantiationImpl extends ConnectorImpl implements MultiInstantiation {
    /**
     * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnabled()
     * @generated
     * @ordered
     */
    protected static final boolean ENABLED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnabled()
     * @generated
     * @ordered
     */
    protected boolean enabled = ENABLED_EDEFAULT;

    /**
     * The cached value of the '{@link #getActivityData() <em>Activity Data</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getActivityData()
     * @generated
     * @ordered
     */
    protected Data activityData;

    /**
     * The cached value of the '{@link #getInstantiator() <em>Instantiator</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstantiator()
     * @generated
     * @ordered
     */
    protected Connector instantiator;

    /**
     * The cached value of the '{@link #getJoinChecker() <em>Join Checker</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJoinChecker()
     * @generated
     * @ordered
     */
    protected Connector joinChecker;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MultiInstantiationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.MULTI_INSTANTIATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnabled(boolean newEnabled) {
        boolean oldEnabled = enabled;
        enabled = newEnabled;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.MULTI_INSTANTIATION__ENABLED, oldEnabled, enabled));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data getActivityData() {
        if (activityData != null && activityData.eIsProxy()) {
            InternalEObject oldActivityData = (InternalEObject)activityData;
            activityData = (Data)eResolveProxy(oldActivityData);
            if (activityData != oldActivityData) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.MULTI_INSTANTIATION__ACTIVITY_DATA, oldActivityData, activityData));
            }
        }
        return activityData;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data basicGetActivityData() {
        return activityData;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setActivityData(Data newActivityData) {
        Data oldActivityData = activityData;
        activityData = newActivityData;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.MULTI_INSTANTIATION__ACTIVITY_DATA, oldActivityData, activityData));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Connector getInstantiator() {
        return instantiator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInstantiator(Connector newInstantiator, NotificationChain msgs) {
        Connector oldInstantiator = instantiator;
        instantiator = newInstantiator;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.MULTI_INSTANTIATION__INSTANTIATOR, oldInstantiator, newInstantiator);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInstantiator(Connector newInstantiator) {
        if (newInstantiator != instantiator) {
            NotificationChain msgs = null;
            if (instantiator != null)
                msgs = ((InternalEObject)instantiator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.MULTI_INSTANTIATION__INSTANTIATOR, null, msgs);
            if (newInstantiator != null)
                msgs = ((InternalEObject)newInstantiator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.MULTI_INSTANTIATION__INSTANTIATOR, null, msgs);
            msgs = basicSetInstantiator(newInstantiator, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.MULTI_INSTANTIATION__INSTANTIATOR, newInstantiator, newInstantiator));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Connector getJoinChecker() {
        return joinChecker;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetJoinChecker(Connector newJoinChecker, NotificationChain msgs) {
        Connector oldJoinChecker = joinChecker;
        joinChecker = newJoinChecker;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.MULTI_INSTANTIATION__JOIN_CHECKER, oldJoinChecker, newJoinChecker);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setJoinChecker(Connector newJoinChecker) {
        if (newJoinChecker != joinChecker) {
            NotificationChain msgs = null;
            if (joinChecker != null)
                msgs = ((InternalEObject)joinChecker).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.MULTI_INSTANTIATION__JOIN_CHECKER, null, msgs);
            if (newJoinChecker != null)
                msgs = ((InternalEObject)newJoinChecker).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.MULTI_INSTANTIATION__JOIN_CHECKER, null, msgs);
            msgs = basicSetJoinChecker(newJoinChecker, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.MULTI_INSTANTIATION__JOIN_CHECKER, newJoinChecker, newJoinChecker));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.MULTI_INSTANTIATION__INSTANTIATOR:
                return basicSetInstantiator(null, msgs);
            case ProcessPackage.MULTI_INSTANTIATION__JOIN_CHECKER:
                return basicSetJoinChecker(null, msgs);
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
            case ProcessPackage.MULTI_INSTANTIATION__ENABLED:
                return isEnabled();
            case ProcessPackage.MULTI_INSTANTIATION__ACTIVITY_DATA:
                if (resolve) return getActivityData();
                return basicGetActivityData();
            case ProcessPackage.MULTI_INSTANTIATION__INSTANTIATOR:
                return getInstantiator();
            case ProcessPackage.MULTI_INSTANTIATION__JOIN_CHECKER:
                return getJoinChecker();
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
            case ProcessPackage.MULTI_INSTANTIATION__ENABLED:
                setEnabled((Boolean)newValue);
                return;
            case ProcessPackage.MULTI_INSTANTIATION__ACTIVITY_DATA:
                setActivityData((Data)newValue);
                return;
            case ProcessPackage.MULTI_INSTANTIATION__INSTANTIATOR:
                setInstantiator((Connector)newValue);
                return;
            case ProcessPackage.MULTI_INSTANTIATION__JOIN_CHECKER:
                setJoinChecker((Connector)newValue);
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
            case ProcessPackage.MULTI_INSTANTIATION__ENABLED:
                setEnabled(ENABLED_EDEFAULT);
                return;
            case ProcessPackage.MULTI_INSTANTIATION__ACTIVITY_DATA:
                setActivityData((Data)null);
                return;
            case ProcessPackage.MULTI_INSTANTIATION__INSTANTIATOR:
                setInstantiator((Connector)null);
                return;
            case ProcessPackage.MULTI_INSTANTIATION__JOIN_CHECKER:
                setJoinChecker((Connector)null);
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
            case ProcessPackage.MULTI_INSTANTIATION__ENABLED:
                return enabled != ENABLED_EDEFAULT;
            case ProcessPackage.MULTI_INSTANTIATION__ACTIVITY_DATA:
                return activityData != null;
            case ProcessPackage.MULTI_INSTANTIATION__INSTANTIATOR:
                return instantiator != null;
            case ProcessPackage.MULTI_INSTANTIATION__JOIN_CHECKER:
                return joinChecker != null;
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
        result.append(" (enabled: "); //$NON-NLS-1$
        result.append(enabled);
        result.append(')');
        return result.toString();
    }

} //MultiInstantiationImpl
