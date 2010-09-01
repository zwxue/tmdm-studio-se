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

import org.talend.process.model.process.CatchSignalEvent;
import org.talend.process.model.process.ConnectableElement;
import org.talend.process.model.process.Connector;
import org.talend.process.model.process.Data;
import org.talend.process.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catch Signal Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.CatchSignalEventImpl#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.CatchSignalEventImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.CatchSignalEventImpl#getKpis <em>Kpis</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.CatchSignalEventImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.CatchSignalEventImpl#getMatcher <em>Matcher</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CatchSignalEventImpl extends SignalEventImpl implements CatchSignalEvent {
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
     * The default value of the '{@link #getSignal() <em>Signal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSignal()
     * @generated
     * @ordered
     */
    protected static final String SIGNAL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSignal() <em>Signal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSignal()
     * @generated
     * @ordered
     */
    protected String signal = SIGNAL_EDEFAULT;

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
    protected CatchSignalEventImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.CATCH_SIGNAL_EVENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getConnectors() {
        if (connectors == null) {
            connectors = new EObjectContainmentEList<Connector>(Connector.class, this, ProcessPackage.CATCH_SIGNAL_EVENT__CONNECTORS);
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
            data = new EObjectContainmentEList<Data>(Data.class, this, ProcessPackage.CATCH_SIGNAL_EVENT__DATA);
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
            kpis = new EObjectContainmentEList<AbstractKPIBinding>(AbstractKPIBinding.class, this, ProcessPackage.CATCH_SIGNAL_EVENT__KPIS);
        }
        return kpis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSignal() {
        return signal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSignal(String newSignal) {
        String oldSignal = signal;
        signal = newSignal;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.CATCH_SIGNAL_EVENT__SIGNAL, oldSignal, signal));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.CATCH_SIGNAL_EVENT__MATCHER, oldMatcher, matcher));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.CATCH_SIGNAL_EVENT__CONNECTORS:
                return ((InternalEList<?>)getConnectors()).basicRemove(otherEnd, msgs);
            case ProcessPackage.CATCH_SIGNAL_EVENT__DATA:
                return ((InternalEList<?>)getData()).basicRemove(otherEnd, msgs);
            case ProcessPackage.CATCH_SIGNAL_EVENT__KPIS:
                return ((InternalEList<?>)getKpis()).basicRemove(otherEnd, msgs);
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
            case ProcessPackage.CATCH_SIGNAL_EVENT__CONNECTORS:
                return getConnectors();
            case ProcessPackage.CATCH_SIGNAL_EVENT__DATA:
                return getData();
            case ProcessPackage.CATCH_SIGNAL_EVENT__KPIS:
                return getKpis();
            case ProcessPackage.CATCH_SIGNAL_EVENT__SIGNAL:
                return getSignal();
            case ProcessPackage.CATCH_SIGNAL_EVENT__MATCHER:
                return getMatcher();
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
            case ProcessPackage.CATCH_SIGNAL_EVENT__CONNECTORS:
                getConnectors().clear();
                getConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case ProcessPackage.CATCH_SIGNAL_EVENT__DATA:
                getData().clear();
                getData().addAll((Collection<? extends Data>)newValue);
                return;
            case ProcessPackage.CATCH_SIGNAL_EVENT__KPIS:
                getKpis().clear();
                getKpis().addAll((Collection<? extends AbstractKPIBinding>)newValue);
                return;
            case ProcessPackage.CATCH_SIGNAL_EVENT__SIGNAL:
                setSignal((String)newValue);
                return;
            case ProcessPackage.CATCH_SIGNAL_EVENT__MATCHER:
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
            case ProcessPackage.CATCH_SIGNAL_EVENT__CONNECTORS:
                getConnectors().clear();
                return;
            case ProcessPackage.CATCH_SIGNAL_EVENT__DATA:
                getData().clear();
                return;
            case ProcessPackage.CATCH_SIGNAL_EVENT__KPIS:
                getKpis().clear();
                return;
            case ProcessPackage.CATCH_SIGNAL_EVENT__SIGNAL:
                setSignal(SIGNAL_EDEFAULT);
                return;
            case ProcessPackage.CATCH_SIGNAL_EVENT__MATCHER:
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
            case ProcessPackage.CATCH_SIGNAL_EVENT__CONNECTORS:
                return connectors != null && !connectors.isEmpty();
            case ProcessPackage.CATCH_SIGNAL_EVENT__DATA:
                return data != null && !data.isEmpty();
            case ProcessPackage.CATCH_SIGNAL_EVENT__KPIS:
                return kpis != null && !kpis.isEmpty();
            case ProcessPackage.CATCH_SIGNAL_EVENT__SIGNAL:
                return SIGNAL_EDEFAULT == null ? signal != null : !SIGNAL_EDEFAULT.equals(signal);
            case ProcessPackage.CATCH_SIGNAL_EVENT__MATCHER:
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
        if (baseClass == ConnectableElement.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.CATCH_SIGNAL_EVENT__CONNECTORS: return ProcessPackage.CONNECTABLE_ELEMENT__CONNECTORS;
                case ProcessPackage.CATCH_SIGNAL_EVENT__DATA: return ProcessPackage.CONNECTABLE_ELEMENT__DATA;
                case ProcessPackage.CATCH_SIGNAL_EVENT__KPIS: return ProcessPackage.CONNECTABLE_ELEMENT__KPIS;
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
                case ProcessPackage.CONNECTABLE_ELEMENT__CONNECTORS: return ProcessPackage.CATCH_SIGNAL_EVENT__CONNECTORS;
                case ProcessPackage.CONNECTABLE_ELEMENT__DATA: return ProcessPackage.CATCH_SIGNAL_EVENT__DATA;
                case ProcessPackage.CONNECTABLE_ELEMENT__KPIS: return ProcessPackage.CATCH_SIGNAL_EVENT__KPIS;
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
        result.append(" (signal: "); //$NON-NLS-1$
        result.append(signal);
        result.append(", matcher: "); //$NON-NLS-1$
        result.append(matcher);
        result.append(')');
        return result.toString();
    }

} //CatchSignalEventImpl
