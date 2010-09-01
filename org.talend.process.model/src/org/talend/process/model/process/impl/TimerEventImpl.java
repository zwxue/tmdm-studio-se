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

import org.talend.process.model.process.ConnectableElement;
import org.talend.process.model.process.Connector;
import org.talend.process.model.process.Data;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.TimerEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timer Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.TimerEventImpl#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TimerEventImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TimerEventImpl#getKpis <em>Kpis</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TimerEventImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimerEventImpl extends EventImpl implements TimerEvent {
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
     * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected static final String CONDITION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected String condition = CONDITION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TimerEventImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.TIMER_EVENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getConnectors() {
        if (connectors == null) {
            connectors = new EObjectContainmentEList<Connector>(Connector.class, this, ProcessPackage.TIMER_EVENT__CONNECTORS);
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
            data = new EObjectContainmentEList<Data>(Data.class, this, ProcessPackage.TIMER_EVENT__DATA);
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
            kpis = new EObjectContainmentEList<AbstractKPIBinding>(AbstractKPIBinding.class, this, ProcessPackage.TIMER_EVENT__KPIS);
        }
        return kpis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCondition() {
        return condition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCondition(String newCondition) {
        String oldCondition = condition;
        condition = newCondition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TIMER_EVENT__CONDITION, oldCondition, condition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.TIMER_EVENT__CONNECTORS:
                return ((InternalEList<?>)getConnectors()).basicRemove(otherEnd, msgs);
            case ProcessPackage.TIMER_EVENT__DATA:
                return ((InternalEList<?>)getData()).basicRemove(otherEnd, msgs);
            case ProcessPackage.TIMER_EVENT__KPIS:
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
            case ProcessPackage.TIMER_EVENT__CONNECTORS:
                return getConnectors();
            case ProcessPackage.TIMER_EVENT__DATA:
                return getData();
            case ProcessPackage.TIMER_EVENT__KPIS:
                return getKpis();
            case ProcessPackage.TIMER_EVENT__CONDITION:
                return getCondition();
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
            case ProcessPackage.TIMER_EVENT__CONNECTORS:
                getConnectors().clear();
                getConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case ProcessPackage.TIMER_EVENT__DATA:
                getData().clear();
                getData().addAll((Collection<? extends Data>)newValue);
                return;
            case ProcessPackage.TIMER_EVENT__KPIS:
                getKpis().clear();
                getKpis().addAll((Collection<? extends AbstractKPIBinding>)newValue);
                return;
            case ProcessPackage.TIMER_EVENT__CONDITION:
                setCondition((String)newValue);
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
            case ProcessPackage.TIMER_EVENT__CONNECTORS:
                getConnectors().clear();
                return;
            case ProcessPackage.TIMER_EVENT__DATA:
                getData().clear();
                return;
            case ProcessPackage.TIMER_EVENT__KPIS:
                getKpis().clear();
                return;
            case ProcessPackage.TIMER_EVENT__CONDITION:
                setCondition(CONDITION_EDEFAULT);
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
            case ProcessPackage.TIMER_EVENT__CONNECTORS:
                return connectors != null && !connectors.isEmpty();
            case ProcessPackage.TIMER_EVENT__DATA:
                return data != null && !data.isEmpty();
            case ProcessPackage.TIMER_EVENT__KPIS:
                return kpis != null && !kpis.isEmpty();
            case ProcessPackage.TIMER_EVENT__CONDITION:
                return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
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
                case ProcessPackage.TIMER_EVENT__CONNECTORS: return ProcessPackage.CONNECTABLE_ELEMENT__CONNECTORS;
                case ProcessPackage.TIMER_EVENT__DATA: return ProcessPackage.CONNECTABLE_ELEMENT__DATA;
                case ProcessPackage.TIMER_EVENT__KPIS: return ProcessPackage.CONNECTABLE_ELEMENT__KPIS;
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
                case ProcessPackage.CONNECTABLE_ELEMENT__CONNECTORS: return ProcessPackage.TIMER_EVENT__CONNECTORS;
                case ProcessPackage.CONNECTABLE_ELEMENT__DATA: return ProcessPackage.TIMER_EVENT__DATA;
                case ProcessPackage.CONNECTABLE_ELEMENT__KPIS: return ProcessPackage.TIMER_EVENT__KPIS;
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
        result.append(" (condition: "); //$NON-NLS-1$
        result.append(condition);
        result.append(')');
        return result.toString();
    }

} //TimerEventImpl
