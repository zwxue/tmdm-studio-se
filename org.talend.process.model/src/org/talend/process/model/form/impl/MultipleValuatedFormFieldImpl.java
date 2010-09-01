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
package org.talend.process.model.form.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.process.model.form.FormPackage;
import org.talend.process.model.form.MultipleValuatedFormField;

import org.talend.process.model.process.Connector;
import org.talend.process.model.process.Data;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiple Valuated Form Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl#getDefaultValueAfterEvent <em>Default Value After Event</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl#getEnum <em>Enum</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl#getEnumAfterEvent <em>Enum After Event</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl#getLiterals <em>Literals</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl#getLiteralsAfterEvent <em>Literals After Event</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl#getDefaultConnectors <em>Default Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl#getDefaultAfterEventConnectors <em>Default After Event Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MultipleValuatedFormFieldImpl extends FormFieldImpl implements MultipleValuatedFormField {
    /**
     * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValue()
     * @generated
     * @ordered
     */
    protected static final String DEFAULT_VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValue()
     * @generated
     * @ordered
     */
    protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultValueAfterEvent() <em>Default Value After Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValueAfterEvent()
     * @generated
     * @ordered
     */
    protected static final String DEFAULT_VALUE_AFTER_EVENT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefaultValueAfterEvent() <em>Default Value After Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValueAfterEvent()
     * @generated
     * @ordered
     */
    protected String defaultValueAfterEvent = DEFAULT_VALUE_AFTER_EVENT_EDEFAULT;

    /**
     * The cached value of the '{@link #getEnum() <em>Enum</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnum()
     * @generated
     * @ordered
     */
    protected Data enum_;

    /**
     * The cached value of the '{@link #getEnumAfterEvent() <em>Enum After Event</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnumAfterEvent()
     * @generated
     * @ordered
     */
    protected Data enumAfterEvent;

    /**
     * The cached value of the '{@link #getLiterals() <em>Literals</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLiterals()
     * @generated
     * @ordered
     */
    protected EList<String> literals;

    /**
     * The cached value of the '{@link #getLiteralsAfterEvent() <em>Literals After Event</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLiteralsAfterEvent()
     * @generated
     * @ordered
     */
    protected EList<String> literalsAfterEvent;

    /**
     * The cached value of the '{@link #getDefaultConnectors() <em>Default Connectors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultConnectors()
     * @generated
     * @ordered
     */
    protected EList<Connector> defaultConnectors;

    /**
     * The cached value of the '{@link #getDefaultAfterEventConnectors() <em>Default After Event Connectors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultAfterEventConnectors()
     * @generated
     * @ordered
     */
    protected EList<Connector> defaultAfterEventConnectors;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MultipleValuatedFormFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FormPackage.Literals.MULTIPLE_VALUATED_FORM_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultValue(String newDefaultValue) {
        String oldDefaultValue = defaultValue;
        defaultValue = newDefaultValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE, oldDefaultValue, defaultValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDefaultValueAfterEvent() {
        return defaultValueAfterEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultValueAfterEvent(String newDefaultValueAfterEvent) {
        String oldDefaultValueAfterEvent = defaultValueAfterEvent;
        defaultValueAfterEvent = newDefaultValueAfterEvent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT, oldDefaultValueAfterEvent, defaultValueAfterEvent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data getEnum() {
        if (enum_ != null && enum_.eIsProxy()) {
            InternalEObject oldEnum = (InternalEObject)enum_;
            enum_ = (Data)eResolveProxy(oldEnum);
            if (enum_ != oldEnum) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM, oldEnum, enum_));
            }
        }
        return enum_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data basicGetEnum() {
        return enum_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnum(Data newEnum) {
        Data oldEnum = enum_;
        enum_ = newEnum;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM, oldEnum, enum_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data getEnumAfterEvent() {
        if (enumAfterEvent != null && enumAfterEvent.eIsProxy()) {
            InternalEObject oldEnumAfterEvent = (InternalEObject)enumAfterEvent;
            enumAfterEvent = (Data)eResolveProxy(oldEnumAfterEvent);
            if (enumAfterEvent != oldEnumAfterEvent) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT, oldEnumAfterEvent, enumAfterEvent));
            }
        }
        return enumAfterEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data basicGetEnumAfterEvent() {
        return enumAfterEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnumAfterEvent(Data newEnumAfterEvent) {
        Data oldEnumAfterEvent = enumAfterEvent;
        enumAfterEvent = newEnumAfterEvent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT, oldEnumAfterEvent, enumAfterEvent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getLiterals() {
        if (literals == null) {
            literals = new EDataTypeUniqueEList<String>(String.class, this, FormPackage.MULTIPLE_VALUATED_FORM_FIELD__LITERALS);
        }
        return literals;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getLiteralsAfterEvent() {
        if (literalsAfterEvent == null) {
            literalsAfterEvent = new EDataTypeUniqueEList<String>(String.class, this, FormPackage.MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT);
        }
        return literalsAfterEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getDefaultConnectors() {
        if (defaultConnectors == null) {
            defaultConnectors = new EObjectContainmentEList<Connector>(Connector.class, this, FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS);
        }
        return defaultConnectors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getDefaultAfterEventConnectors() {
        if (defaultAfterEventConnectors == null) {
            defaultAfterEventConnectors = new EObjectContainmentEList<Connector>(Connector.class, this, FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS);
        }
        return defaultAfterEventConnectors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS:
                return ((InternalEList<?>)getDefaultConnectors()).basicRemove(otherEnd, msgs);
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS:
                return ((InternalEList<?>)getDefaultAfterEventConnectors()).basicRemove(otherEnd, msgs);
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
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE:
                return getDefaultValue();
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT:
                return getDefaultValueAfterEvent();
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM:
                if (resolve) return getEnum();
                return basicGetEnum();
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT:
                if (resolve) return getEnumAfterEvent();
                return basicGetEnumAfterEvent();
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__LITERALS:
                return getLiterals();
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT:
                return getLiteralsAfterEvent();
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS:
                return getDefaultConnectors();
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS:
                return getDefaultAfterEventConnectors();
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
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE:
                setDefaultValue((String)newValue);
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT:
                setDefaultValueAfterEvent((String)newValue);
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM:
                setEnum((Data)newValue);
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT:
                setEnumAfterEvent((Data)newValue);
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__LITERALS:
                getLiterals().clear();
                getLiterals().addAll((Collection<? extends String>)newValue);
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT:
                getLiteralsAfterEvent().clear();
                getLiteralsAfterEvent().addAll((Collection<? extends String>)newValue);
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS:
                getDefaultConnectors().clear();
                getDefaultConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS:
                getDefaultAfterEventConnectors().clear();
                getDefaultAfterEventConnectors().addAll((Collection<? extends Connector>)newValue);
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
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE:
                setDefaultValue(DEFAULT_VALUE_EDEFAULT);
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT:
                setDefaultValueAfterEvent(DEFAULT_VALUE_AFTER_EVENT_EDEFAULT);
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM:
                setEnum((Data)null);
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT:
                setEnumAfterEvent((Data)null);
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__LITERALS:
                getLiterals().clear();
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT:
                getLiteralsAfterEvent().clear();
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS:
                getDefaultConnectors().clear();
                return;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS:
                getDefaultAfterEventConnectors().clear();
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
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE:
                return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT:
                return DEFAULT_VALUE_AFTER_EVENT_EDEFAULT == null ? defaultValueAfterEvent != null : !DEFAULT_VALUE_AFTER_EVENT_EDEFAULT.equals(defaultValueAfterEvent);
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM:
                return enum_ != null;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT:
                return enumAfterEvent != null;
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__LITERALS:
                return literals != null && !literals.isEmpty();
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT:
                return literalsAfterEvent != null && !literalsAfterEvent.isEmpty();
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS:
                return defaultConnectors != null && !defaultConnectors.isEmpty();
            case FormPackage.MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS:
                return defaultAfterEventConnectors != null && !defaultAfterEventConnectors.isEmpty();
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
        result.append(" (defaultValue: "); //$NON-NLS-1$
        result.append(defaultValue);
        result.append(", defaultValueAfterEvent: "); //$NON-NLS-1$
        result.append(defaultValueAfterEvent);
        result.append(", literals: "); //$NON-NLS-1$
        result.append(literals);
        result.append(", literalsAfterEvent: "); //$NON-NLS-1$
        result.append(literalsAfterEvent);
        result.append(')');
        return result.toString();
    }

} //MultipleValuatedFormFieldImpl
