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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.process.model.form.FormPackage;
import org.talend.process.model.form.Validator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.form.impl.ValidatorImpl#getValidatorClass <em>Validator Class</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.ValidatorImpl#getHtmlClass <em>Html Class</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.ValidatorImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.ValidatorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.ValidatorImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.ValidatorImpl#isBelowField <em>Below Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValidatorImpl extends EObjectImpl implements Validator {
    /**
     * The default value of the '{@link #getValidatorClass() <em>Validator Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValidatorClass()
     * @generated
     * @ordered
     */
    protected static final String VALIDATOR_CLASS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValidatorClass() <em>Validator Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValidatorClass()
     * @generated
     * @ordered
     */
    protected String validatorClass = VALIDATOR_CLASS_EDEFAULT;

    /**
     * The default value of the '{@link #getHtmlClass() <em>Html Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHtmlClass()
     * @generated
     * @ordered
     */
    protected static final String HTML_CLASS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHtmlClass() <em>Html Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHtmlClass()
     * @generated
     * @ordered
     */
    protected String htmlClass = HTML_CLASS_EDEFAULT;

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
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

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
     * The default value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameter()
     * @generated
     * @ordered
     */
    protected static final String PARAMETER_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameter()
     * @generated
     * @ordered
     */
    protected String parameter = PARAMETER_EDEFAULT;

    /**
     * The default value of the '{@link #isBelowField() <em>Below Field</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isBelowField()
     * @generated
     * @ordered
     */
    protected static final boolean BELOW_FIELD_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isBelowField() <em>Below Field</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isBelowField()
     * @generated
     * @ordered
     */
    protected boolean belowField = BELOW_FIELD_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValidatorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FormPackage.Literals.VALIDATOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getValidatorClass() {
        return validatorClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValidatorClass(String newValidatorClass) {
        String oldValidatorClass = validatorClass;
        validatorClass = newValidatorClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.VALIDATOR__VALIDATOR_CLASS, oldValidatorClass, validatorClass));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHtmlClass() {
        return htmlClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHtmlClass(String newHtmlClass) {
        String oldHtmlClass = htmlClass;
        htmlClass = newHtmlClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.VALIDATOR__HTML_CLASS, oldHtmlClass, htmlClass));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.VALIDATOR__LABEL, oldLabel, label));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.VALIDATOR__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameter(String newParameter) {
        String oldParameter = parameter;
        parameter = newParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.VALIDATOR__PARAMETER, oldParameter, parameter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isBelowField() {
        return belowField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBelowField(boolean newBelowField) {
        boolean oldBelowField = belowField;
        belowField = newBelowField;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.VALIDATOR__BELOW_FIELD, oldBelowField, belowField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FormPackage.VALIDATOR__VALIDATOR_CLASS:
                return getValidatorClass();
            case FormPackage.VALIDATOR__HTML_CLASS:
                return getHtmlClass();
            case FormPackage.VALIDATOR__LABEL:
                return getLabel();
            case FormPackage.VALIDATOR__NAME:
                return getName();
            case FormPackage.VALIDATOR__PARAMETER:
                return getParameter();
            case FormPackage.VALIDATOR__BELOW_FIELD:
                return isBelowField();
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
            case FormPackage.VALIDATOR__VALIDATOR_CLASS:
                setValidatorClass((String)newValue);
                return;
            case FormPackage.VALIDATOR__HTML_CLASS:
                setHtmlClass((String)newValue);
                return;
            case FormPackage.VALIDATOR__LABEL:
                setLabel((String)newValue);
                return;
            case FormPackage.VALIDATOR__NAME:
                setName((String)newValue);
                return;
            case FormPackage.VALIDATOR__PARAMETER:
                setParameter((String)newValue);
                return;
            case FormPackage.VALIDATOR__BELOW_FIELD:
                setBelowField((Boolean)newValue);
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
            case FormPackage.VALIDATOR__VALIDATOR_CLASS:
                setValidatorClass(VALIDATOR_CLASS_EDEFAULT);
                return;
            case FormPackage.VALIDATOR__HTML_CLASS:
                setHtmlClass(HTML_CLASS_EDEFAULT);
                return;
            case FormPackage.VALIDATOR__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case FormPackage.VALIDATOR__NAME:
                setName(NAME_EDEFAULT);
                return;
            case FormPackage.VALIDATOR__PARAMETER:
                setParameter(PARAMETER_EDEFAULT);
                return;
            case FormPackage.VALIDATOR__BELOW_FIELD:
                setBelowField(BELOW_FIELD_EDEFAULT);
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
            case FormPackage.VALIDATOR__VALIDATOR_CLASS:
                return VALIDATOR_CLASS_EDEFAULT == null ? validatorClass != null : !VALIDATOR_CLASS_EDEFAULT.equals(validatorClass);
            case FormPackage.VALIDATOR__HTML_CLASS:
                return HTML_CLASS_EDEFAULT == null ? htmlClass != null : !HTML_CLASS_EDEFAULT.equals(htmlClass);
            case FormPackage.VALIDATOR__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case FormPackage.VALIDATOR__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case FormPackage.VALIDATOR__PARAMETER:
                return PARAMETER_EDEFAULT == null ? parameter != null : !PARAMETER_EDEFAULT.equals(parameter);
            case FormPackage.VALIDATOR__BELOW_FIELD:
                return belowField != BELOW_FIELD_EDEFAULT;
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
        result.append(" (validatorClass: "); //$NON-NLS-1$
        result.append(validatorClass);
        result.append(", htmlClass: "); //$NON-NLS-1$
        result.append(htmlClass);
        result.append(", label: "); //$NON-NLS-1$
        result.append(label);
        result.append(", name: "); //$NON-NLS-1$
        result.append(name);
        result.append(", parameter: "); //$NON-NLS-1$
        result.append(parameter);
        result.append(", belowField: "); //$NON-NLS-1$
        result.append(belowField);
        result.append(')');
        return result.toString();
    }

} //ValidatorImpl
