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
package org.talend.process.model.kpi.impl;

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
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.process.model.kpi.AbstractKPIBinding;
import org.talend.process.model.kpi.KPIParameterMapping;
import org.talend.process.model.kpi.KpiPackage;

import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.TextAnnotationAttachment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract KPI Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.kpi.impl.AbstractKPIBindingImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.AbstractKPIBindingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.AbstractKPIBindingImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.AbstractKPIBindingImpl#getTextAnnotationAttachment <em>Text Annotation Attachment</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.AbstractKPIBindingImpl#getKpiDefinitionName <em>Kpi Definition Name</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.AbstractKPIBindingImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.AbstractKPIBindingImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.AbstractKPIBindingImpl#isIgnoreError <em>Ignore Error</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.AbstractKPIBindingImpl#getRequest <em>Request</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.AbstractKPIBindingImpl#isUseGraphicalEditor <em>Use Graphical Editor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractKPIBindingImpl extends EObjectImpl implements AbstractKPIBinding {
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
     * The default value of the '{@link #getKpiDefinitionName() <em>Kpi Definition Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKpiDefinitionName()
     * @generated
     * @ordered
     */
    protected static final String KPI_DEFINITION_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getKpiDefinitionName() <em>Kpi Definition Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKpiDefinitionName()
     * @generated
     * @ordered
     */
    protected String kpiDefinitionName = KPI_DEFINITION_NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected EList<KPIParameterMapping> parameters;

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
     * The default value of the '{@link #isIgnoreError() <em>Ignore Error</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIgnoreError()
     * @generated
     * @ordered
     */
    protected static final boolean IGNORE_ERROR_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIgnoreError() <em>Ignore Error</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIgnoreError()
     * @generated
     * @ordered
     */
    protected boolean ignoreError = IGNORE_ERROR_EDEFAULT;

    /**
     * The default value of the '{@link #getRequest() <em>Request</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRequest()
     * @generated
     * @ordered
     */
    protected static final String REQUEST_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRequest() <em>Request</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRequest()
     * @generated
     * @ordered
     */
    protected String request = REQUEST_EDEFAULT;

    /**
     * The default value of the '{@link #isUseGraphicalEditor() <em>Use Graphical Editor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUseGraphicalEditor()
     * @generated
     * @ordered
     */
    protected static final boolean USE_GRAPHICAL_EDITOR_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isUseGraphicalEditor() <em>Use Graphical Editor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUseGraphicalEditor()
     * @generated
     * @ordered
     */
    protected boolean useGraphicalEditor = USE_GRAPHICAL_EDITOR_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractKPIBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return KpiPackage.Literals.ABSTRACT_KPI_BINDING;
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
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.ABSTRACT_KPI_BINDING__DOCUMENTATION, oldDocumentation, documentation));
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
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.ABSTRACT_KPI_BINDING__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.ABSTRACT_KPI_BINDING__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TextAnnotationAttachment> getTextAnnotationAttachment() {
        if (textAnnotationAttachment == null) {
            textAnnotationAttachment = new EObjectContainmentWithInverseEList<TextAnnotationAttachment>(TextAnnotationAttachment.class, this, KpiPackage.ABSTRACT_KPI_BINDING__TEXT_ANNOTATION_ATTACHMENT, ProcessPackage.TEXT_ANNOTATION_ATTACHMENT__TARGET);
        }
        return textAnnotationAttachment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getKpiDefinitionName() {
        return kpiDefinitionName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKpiDefinitionName(String newKpiDefinitionName) {
        String oldKpiDefinitionName = kpiDefinitionName;
        kpiDefinitionName = newKpiDefinitionName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.ABSTRACT_KPI_BINDING__KPI_DEFINITION_NAME, oldKpiDefinitionName, kpiDefinitionName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<KPIParameterMapping> getParameters() {
        if (parameters == null) {
            parameters = new EObjectContainmentEList<KPIParameterMapping>(KPIParameterMapping.class, this, KpiPackage.ABSTRACT_KPI_BINDING__PARAMETERS);
        }
        return parameters;
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
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.ABSTRACT_KPI_BINDING__EVENT, oldEvent, event));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIgnoreError() {
        return ignoreError;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIgnoreError(boolean newIgnoreError) {
        boolean oldIgnoreError = ignoreError;
        ignoreError = newIgnoreError;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.ABSTRACT_KPI_BINDING__IGNORE_ERROR, oldIgnoreError, ignoreError));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRequest() {
        return request;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRequest(String newRequest) {
        String oldRequest = request;
        request = newRequest;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.ABSTRACT_KPI_BINDING__REQUEST, oldRequest, request));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isUseGraphicalEditor() {
        return useGraphicalEditor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUseGraphicalEditor(boolean newUseGraphicalEditor) {
        boolean oldUseGraphicalEditor = useGraphicalEditor;
        useGraphicalEditor = newUseGraphicalEditor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.ABSTRACT_KPI_BINDING__USE_GRAPHICAL_EDITOR, oldUseGraphicalEditor, useGraphicalEditor));
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
            case KpiPackage.ABSTRACT_KPI_BINDING__TEXT_ANNOTATION_ATTACHMENT:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTextAnnotationAttachment()).basicAdd(otherEnd, msgs);
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
            case KpiPackage.ABSTRACT_KPI_BINDING__TEXT_ANNOTATION_ATTACHMENT:
                return ((InternalEList<?>)getTextAnnotationAttachment()).basicRemove(otherEnd, msgs);
            case KpiPackage.ABSTRACT_KPI_BINDING__PARAMETERS:
                return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
            case KpiPackage.ABSTRACT_KPI_BINDING__DOCUMENTATION:
                return getDocumentation();
            case KpiPackage.ABSTRACT_KPI_BINDING__NAME:
                return getName();
            case KpiPackage.ABSTRACT_KPI_BINDING__LABEL:
                return getLabel();
            case KpiPackage.ABSTRACT_KPI_BINDING__TEXT_ANNOTATION_ATTACHMENT:
                return getTextAnnotationAttachment();
            case KpiPackage.ABSTRACT_KPI_BINDING__KPI_DEFINITION_NAME:
                return getKpiDefinitionName();
            case KpiPackage.ABSTRACT_KPI_BINDING__PARAMETERS:
                return getParameters();
            case KpiPackage.ABSTRACT_KPI_BINDING__EVENT:
                return getEvent();
            case KpiPackage.ABSTRACT_KPI_BINDING__IGNORE_ERROR:
                return isIgnoreError();
            case KpiPackage.ABSTRACT_KPI_BINDING__REQUEST:
                return getRequest();
            case KpiPackage.ABSTRACT_KPI_BINDING__USE_GRAPHICAL_EDITOR:
                return isUseGraphicalEditor();
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
            case KpiPackage.ABSTRACT_KPI_BINDING__DOCUMENTATION:
                setDocumentation((String)newValue);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__NAME:
                setName((String)newValue);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__LABEL:
                setLabel((String)newValue);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                getTextAnnotationAttachment().addAll((Collection<? extends TextAnnotationAttachment>)newValue);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__KPI_DEFINITION_NAME:
                setKpiDefinitionName((String)newValue);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__PARAMETERS:
                getParameters().clear();
                getParameters().addAll((Collection<? extends KPIParameterMapping>)newValue);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__EVENT:
                setEvent((String)newValue);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__IGNORE_ERROR:
                setIgnoreError((Boolean)newValue);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__REQUEST:
                setRequest((String)newValue);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__USE_GRAPHICAL_EDITOR:
                setUseGraphicalEditor((Boolean)newValue);
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
            case KpiPackage.ABSTRACT_KPI_BINDING__DOCUMENTATION:
                setDocumentation(DOCUMENTATION_EDEFAULT);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__NAME:
                setName(NAME_EDEFAULT);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__KPI_DEFINITION_NAME:
                setKpiDefinitionName(KPI_DEFINITION_NAME_EDEFAULT);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__PARAMETERS:
                getParameters().clear();
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__EVENT:
                setEvent(EVENT_EDEFAULT);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__IGNORE_ERROR:
                setIgnoreError(IGNORE_ERROR_EDEFAULT);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__REQUEST:
                setRequest(REQUEST_EDEFAULT);
                return;
            case KpiPackage.ABSTRACT_KPI_BINDING__USE_GRAPHICAL_EDITOR:
                setUseGraphicalEditor(USE_GRAPHICAL_EDITOR_EDEFAULT);
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
            case KpiPackage.ABSTRACT_KPI_BINDING__DOCUMENTATION:
                return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
            case KpiPackage.ABSTRACT_KPI_BINDING__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case KpiPackage.ABSTRACT_KPI_BINDING__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case KpiPackage.ABSTRACT_KPI_BINDING__TEXT_ANNOTATION_ATTACHMENT:
                return textAnnotationAttachment != null && !textAnnotationAttachment.isEmpty();
            case KpiPackage.ABSTRACT_KPI_BINDING__KPI_DEFINITION_NAME:
                return KPI_DEFINITION_NAME_EDEFAULT == null ? kpiDefinitionName != null : !KPI_DEFINITION_NAME_EDEFAULT.equals(kpiDefinitionName);
            case KpiPackage.ABSTRACT_KPI_BINDING__PARAMETERS:
                return parameters != null && !parameters.isEmpty();
            case KpiPackage.ABSTRACT_KPI_BINDING__EVENT:
                return EVENT_EDEFAULT == null ? event != null : !EVENT_EDEFAULT.equals(event);
            case KpiPackage.ABSTRACT_KPI_BINDING__IGNORE_ERROR:
                return ignoreError != IGNORE_ERROR_EDEFAULT;
            case KpiPackage.ABSTRACT_KPI_BINDING__REQUEST:
                return REQUEST_EDEFAULT == null ? request != null : !REQUEST_EDEFAULT.equals(request);
            case KpiPackage.ABSTRACT_KPI_BINDING__USE_GRAPHICAL_EDITOR:
                return useGraphicalEditor != USE_GRAPHICAL_EDITOR_EDEFAULT;
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
        result.append(" (documentation: "); //$NON-NLS-1$
        result.append(documentation);
        result.append(", name: "); //$NON-NLS-1$
        result.append(name);
        result.append(", label: "); //$NON-NLS-1$
        result.append(label);
        result.append(", kpiDefinitionName: "); //$NON-NLS-1$
        result.append(kpiDefinitionName);
        result.append(", event: "); //$NON-NLS-1$
        result.append(event);
        result.append(", ignoreError: "); //$NON-NLS-1$
        result.append(ignoreError);
        result.append(", request: "); //$NON-NLS-1$
        result.append(request);
        result.append(", useGraphicalEditor: "); //$NON-NLS-1$
        result.append(useGraphicalEditor);
        result.append(')');
        return result.toString();
    }

} //AbstractKPIBindingImpl
