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

import org.talend.process.model.form.Form;
import org.talend.process.model.form.ViewForm;

import org.talend.process.model.process.AssociatedFile;
import org.talend.process.model.process.PageFlow;
import org.talend.process.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.PageFlowImpl#getForm <em>Form</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.PageFlowImpl#getByPassFormsGeneration <em>By Pass Forms Generation</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.PageFlowImpl#getConfirmationTemplate <em>Confirmation Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.PageFlowImpl#getConfirmationMessage <em>Confirmation Message</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.PageFlowImpl#getRegExpToHideDefaultField <em>Reg Exp To Hide Default Field</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.PageFlowImpl#isUseRegExpToHideDefaultField <em>Use Reg Exp To Hide Default Field</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.PageFlowImpl#getViewForm <em>View Form</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.PageFlowImpl#isUseViewForm <em>Use View Form</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageFlowImpl extends ConnectableElementImpl implements PageFlow {
    /**
     * The cached value of the '{@link #getForm() <em>Form</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getForm()
     * @generated
     * @ordered
     */
    protected EList<Form> form;

    /**
     * The default value of the '{@link #getByPassFormsGeneration() <em>By Pass Forms Generation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getByPassFormsGeneration()
     * @generated
     * @ordered
     */
    protected static final Boolean BY_PASS_FORMS_GENERATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getByPassFormsGeneration() <em>By Pass Forms Generation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getByPassFormsGeneration()
     * @generated
     * @ordered
     */
    protected Boolean byPassFormsGeneration = BY_PASS_FORMS_GENERATION_EDEFAULT;

    /**
     * The cached value of the '{@link #getConfirmationTemplate() <em>Confirmation Template</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfirmationTemplate()
     * @generated
     * @ordered
     */
    protected AssociatedFile confirmationTemplate;

    /**
     * The default value of the '{@link #getConfirmationMessage() <em>Confirmation Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfirmationMessage()
     * @generated
     * @ordered
     */
    protected static final String CONFIRMATION_MESSAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConfirmationMessage() <em>Confirmation Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfirmationMessage()
     * @generated
     * @ordered
     */
    protected String confirmationMessage = CONFIRMATION_MESSAGE_EDEFAULT;

    /**
     * The default value of the '{@link #getRegExpToHideDefaultField() <em>Reg Exp To Hide Default Field</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRegExpToHideDefaultField()
     * @generated
     * @ordered
     */
    protected static final String REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRegExpToHideDefaultField() <em>Reg Exp To Hide Default Field</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRegExpToHideDefaultField()
     * @generated
     * @ordered
     */
    protected String regExpToHideDefaultField = REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT;

    /**
     * The default value of the '{@link #isUseRegExpToHideDefaultField() <em>Use Reg Exp To Hide Default Field</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUseRegExpToHideDefaultField()
     * @generated
     * @ordered
     */
    protected static final boolean USE_REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isUseRegExpToHideDefaultField() <em>Use Reg Exp To Hide Default Field</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUseRegExpToHideDefaultField()
     * @generated
     * @ordered
     */
    protected boolean useRegExpToHideDefaultField = USE_REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT;

    /**
     * The cached value of the '{@link #getViewForm() <em>View Form</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getViewForm()
     * @generated
     * @ordered
     */
    protected EList<ViewForm> viewForm;

    /**
     * The default value of the '{@link #isUseViewForm() <em>Use View Form</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUseViewForm()
     * @generated
     * @ordered
     */
    protected static final boolean USE_VIEW_FORM_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isUseViewForm() <em>Use View Form</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUseViewForm()
     * @generated
     * @ordered
     */
    protected boolean useViewForm = USE_VIEW_FORM_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PageFlowImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.PAGE_FLOW;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Form> getForm() {
        if (form == null) {
            form = new EObjectContainmentEList<Form>(Form.class, this, ProcessPackage.PAGE_FLOW__FORM);
        }
        return form;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getByPassFormsGeneration() {
        return byPassFormsGeneration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setByPassFormsGeneration(Boolean newByPassFormsGeneration) {
        Boolean oldByPassFormsGeneration = byPassFormsGeneration;
        byPassFormsGeneration = newByPassFormsGeneration;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PAGE_FLOW__BY_PASS_FORMS_GENERATION, oldByPassFormsGeneration, byPassFormsGeneration));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssociatedFile getConfirmationTemplate() {
        return confirmationTemplate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetConfirmationTemplate(AssociatedFile newConfirmationTemplate, NotificationChain msgs) {
        AssociatedFile oldConfirmationTemplate = confirmationTemplate;
        confirmationTemplate = newConfirmationTemplate;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE, oldConfirmationTemplate, newConfirmationTemplate);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConfirmationTemplate(AssociatedFile newConfirmationTemplate) {
        if (newConfirmationTemplate != confirmationTemplate) {
            NotificationChain msgs = null;
            if (confirmationTemplate != null)
                msgs = ((InternalEObject)confirmationTemplate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE, null, msgs);
            if (newConfirmationTemplate != null)
                msgs = ((InternalEObject)newConfirmationTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE, null, msgs);
            msgs = basicSetConfirmationTemplate(newConfirmationTemplate, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE, newConfirmationTemplate, newConfirmationTemplate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getConfirmationMessage() {
        return confirmationMessage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConfirmationMessage(String newConfirmationMessage) {
        String oldConfirmationMessage = confirmationMessage;
        confirmationMessage = newConfirmationMessage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PAGE_FLOW__CONFIRMATION_MESSAGE, oldConfirmationMessage, confirmationMessage));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRegExpToHideDefaultField() {
        return regExpToHideDefaultField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRegExpToHideDefaultField(String newRegExpToHideDefaultField) {
        String oldRegExpToHideDefaultField = regExpToHideDefaultField;
        regExpToHideDefaultField = newRegExpToHideDefaultField;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD, oldRegExpToHideDefaultField, regExpToHideDefaultField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isUseRegExpToHideDefaultField() {
        return useRegExpToHideDefaultField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUseRegExpToHideDefaultField(boolean newUseRegExpToHideDefaultField) {
        boolean oldUseRegExpToHideDefaultField = useRegExpToHideDefaultField;
        useRegExpToHideDefaultField = newUseRegExpToHideDefaultField;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD, oldUseRegExpToHideDefaultField, useRegExpToHideDefaultField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ViewForm> getViewForm() {
        if (viewForm == null) {
            viewForm = new EObjectContainmentEList<ViewForm>(ViewForm.class, this, ProcessPackage.PAGE_FLOW__VIEW_FORM);
        }
        return viewForm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isUseViewForm() {
        return useViewForm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUseViewForm(boolean newUseViewForm) {
        boolean oldUseViewForm = useViewForm;
        useViewForm = newUseViewForm;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PAGE_FLOW__USE_VIEW_FORM, oldUseViewForm, useViewForm));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.PAGE_FLOW__FORM:
                return ((InternalEList<?>)getForm()).basicRemove(otherEnd, msgs);
            case ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE:
                return basicSetConfirmationTemplate(null, msgs);
            case ProcessPackage.PAGE_FLOW__VIEW_FORM:
                return ((InternalEList<?>)getViewForm()).basicRemove(otherEnd, msgs);
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
            case ProcessPackage.PAGE_FLOW__FORM:
                return getForm();
            case ProcessPackage.PAGE_FLOW__BY_PASS_FORMS_GENERATION:
                return getByPassFormsGeneration();
            case ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE:
                return getConfirmationTemplate();
            case ProcessPackage.PAGE_FLOW__CONFIRMATION_MESSAGE:
                return getConfirmationMessage();
            case ProcessPackage.PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return getRegExpToHideDefaultField();
            case ProcessPackage.PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return isUseRegExpToHideDefaultField();
            case ProcessPackage.PAGE_FLOW__VIEW_FORM:
                return getViewForm();
            case ProcessPackage.PAGE_FLOW__USE_VIEW_FORM:
                return isUseViewForm();
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
            case ProcessPackage.PAGE_FLOW__FORM:
                getForm().clear();
                getForm().addAll((Collection<? extends Form>)newValue);
                return;
            case ProcessPackage.PAGE_FLOW__BY_PASS_FORMS_GENERATION:
                setByPassFormsGeneration((Boolean)newValue);
                return;
            case ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE:
                setConfirmationTemplate((AssociatedFile)newValue);
                return;
            case ProcessPackage.PAGE_FLOW__CONFIRMATION_MESSAGE:
                setConfirmationMessage((String)newValue);
                return;
            case ProcessPackage.PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setRegExpToHideDefaultField((String)newValue);
                return;
            case ProcessPackage.PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setUseRegExpToHideDefaultField((Boolean)newValue);
                return;
            case ProcessPackage.PAGE_FLOW__VIEW_FORM:
                getViewForm().clear();
                getViewForm().addAll((Collection<? extends ViewForm>)newValue);
                return;
            case ProcessPackage.PAGE_FLOW__USE_VIEW_FORM:
                setUseViewForm((Boolean)newValue);
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
            case ProcessPackage.PAGE_FLOW__FORM:
                getForm().clear();
                return;
            case ProcessPackage.PAGE_FLOW__BY_PASS_FORMS_GENERATION:
                setByPassFormsGeneration(BY_PASS_FORMS_GENERATION_EDEFAULT);
                return;
            case ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE:
                setConfirmationTemplate((AssociatedFile)null);
                return;
            case ProcessPackage.PAGE_FLOW__CONFIRMATION_MESSAGE:
                setConfirmationMessage(CONFIRMATION_MESSAGE_EDEFAULT);
                return;
            case ProcessPackage.PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setRegExpToHideDefaultField(REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT);
                return;
            case ProcessPackage.PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setUseRegExpToHideDefaultField(USE_REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT);
                return;
            case ProcessPackage.PAGE_FLOW__VIEW_FORM:
                getViewForm().clear();
                return;
            case ProcessPackage.PAGE_FLOW__USE_VIEW_FORM:
                setUseViewForm(USE_VIEW_FORM_EDEFAULT);
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
            case ProcessPackage.PAGE_FLOW__FORM:
                return form != null && !form.isEmpty();
            case ProcessPackage.PAGE_FLOW__BY_PASS_FORMS_GENERATION:
                return BY_PASS_FORMS_GENERATION_EDEFAULT == null ? byPassFormsGeneration != null : !BY_PASS_FORMS_GENERATION_EDEFAULT.equals(byPassFormsGeneration);
            case ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE:
                return confirmationTemplate != null;
            case ProcessPackage.PAGE_FLOW__CONFIRMATION_MESSAGE:
                return CONFIRMATION_MESSAGE_EDEFAULT == null ? confirmationMessage != null : !CONFIRMATION_MESSAGE_EDEFAULT.equals(confirmationMessage);
            case ProcessPackage.PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT == null ? regExpToHideDefaultField != null : !REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT.equals(regExpToHideDefaultField);
            case ProcessPackage.PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return useRegExpToHideDefaultField != USE_REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT;
            case ProcessPackage.PAGE_FLOW__VIEW_FORM:
                return viewForm != null && !viewForm.isEmpty();
            case ProcessPackage.PAGE_FLOW__USE_VIEW_FORM:
                return useViewForm != USE_VIEW_FORM_EDEFAULT;
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
        result.append(" (byPassFormsGeneration: "); //$NON-NLS-1$
        result.append(byPassFormsGeneration);
        result.append(", confirmationMessage: "); //$NON-NLS-1$
        result.append(confirmationMessage);
        result.append(", regExpToHideDefaultField: "); //$NON-NLS-1$
        result.append(regExpToHideDefaultField);
        result.append(", useRegExpToHideDefaultField: "); //$NON-NLS-1$
        result.append(useRegExpToHideDefaultField);
        result.append(", useViewForm: "); //$NON-NLS-1$
        result.append(useViewForm);
        result.append(')');
        return result.toString();
    }

} //PageFlowImpl
