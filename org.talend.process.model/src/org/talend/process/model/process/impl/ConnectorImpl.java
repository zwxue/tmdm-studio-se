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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.process.model.process.Connector;
import org.talend.process.model.process.OutputParameterMapping;
import org.talend.process.model.process.Parameter;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.TextAnnotationAttachment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.ConnectorImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ConnectorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ConnectorImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ConnectorImpl#getTextAnnotationAttachment <em>Text Annotation Attachment</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ConnectorImpl#getConnectorId <em>Connector Id</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ConnectorImpl#getConfigurationId <em>Configuration Id</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ConnectorImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ConnectorImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ConnectorImpl#isIgnoreErrors <em>Ignore Errors</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.ConnectorImpl#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorImpl extends EObjectImpl implements Connector {
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
     * The default value of the '{@link #getConnectorId() <em>Connector Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnectorId()
     * @generated
     * @ordered
     */
    protected static final String CONNECTOR_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConnectorId() <em>Connector Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnectorId()
     * @generated
     * @ordered
     */
    protected String connectorId = CONNECTOR_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getConfigurationId() <em>Configuration Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfigurationId()
     * @generated
     * @ordered
     */
    protected static final String CONFIGURATION_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConfigurationId() <em>Configuration Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfigurationId()
     * @generated
     * @ordered
     */
    protected String configurationId = CONFIGURATION_ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected EList<Parameter> parameters;

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
     * The default value of the '{@link #isIgnoreErrors() <em>Ignore Errors</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIgnoreErrors()
     * @generated
     * @ordered
     */
    protected static final boolean IGNORE_ERRORS_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIgnoreErrors() <em>Ignore Errors</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIgnoreErrors()
     * @generated
     * @ordered
     */
    protected boolean ignoreErrors = IGNORE_ERRORS_EDEFAULT;

    /**
     * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputs()
     * @generated
     * @ordered
     */
    protected EList<OutputParameterMapping> outputs;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.CONNECTOR;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.CONNECTOR__DOCUMENTATION, oldDocumentation, documentation));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.CONNECTOR__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.CONNECTOR__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TextAnnotationAttachment> getTextAnnotationAttachment() {
        if (textAnnotationAttachment == null) {
            textAnnotationAttachment = new EObjectContainmentWithInverseEList<TextAnnotationAttachment>(TextAnnotationAttachment.class, this, ProcessPackage.CONNECTOR__TEXT_ANNOTATION_ATTACHMENT, ProcessPackage.TEXT_ANNOTATION_ATTACHMENT__TARGET);
        }
        return textAnnotationAttachment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getConnectorId() {
        return connectorId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConnectorId(String newConnectorId) {
        String oldConnectorId = connectorId;
        connectorId = newConnectorId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.CONNECTOR__CONNECTOR_ID, oldConnectorId, connectorId));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getConfigurationId() {
        return configurationId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConfigurationId(String newConfigurationId) {
        String oldConfigurationId = configurationId;
        configurationId = newConfigurationId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.CONNECTOR__CONFIGURATION_ID, oldConfigurationId, configurationId));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Parameter> getParameters() {
        if (parameters == null) {
            parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, ProcessPackage.CONNECTOR__PARAMETERS);
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.CONNECTOR__EVENT, oldEvent, event));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIgnoreErrors() {
        return ignoreErrors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIgnoreErrors(boolean newIgnoreErrors) {
        boolean oldIgnoreErrors = ignoreErrors;
        ignoreErrors = newIgnoreErrors;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.CONNECTOR__IGNORE_ERRORS, oldIgnoreErrors, ignoreErrors));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<OutputParameterMapping> getOutputs() {
        if (outputs == null) {
            outputs = new EObjectContainmentEList<OutputParameterMapping>(OutputParameterMapping.class, this, ProcessPackage.CONNECTOR__OUTPUTS);
        }
        return outputs;
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
            case ProcessPackage.CONNECTOR__TEXT_ANNOTATION_ATTACHMENT:
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
            case ProcessPackage.CONNECTOR__TEXT_ANNOTATION_ATTACHMENT:
                return ((InternalEList<?>)getTextAnnotationAttachment()).basicRemove(otherEnd, msgs);
            case ProcessPackage.CONNECTOR__PARAMETERS:
                return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
            case ProcessPackage.CONNECTOR__OUTPUTS:
                return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
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
            case ProcessPackage.CONNECTOR__DOCUMENTATION:
                return getDocumentation();
            case ProcessPackage.CONNECTOR__NAME:
                return getName();
            case ProcessPackage.CONNECTOR__LABEL:
                return getLabel();
            case ProcessPackage.CONNECTOR__TEXT_ANNOTATION_ATTACHMENT:
                return getTextAnnotationAttachment();
            case ProcessPackage.CONNECTOR__CONNECTOR_ID:
                return getConnectorId();
            case ProcessPackage.CONNECTOR__CONFIGURATION_ID:
                return getConfigurationId();
            case ProcessPackage.CONNECTOR__PARAMETERS:
                return getParameters();
            case ProcessPackage.CONNECTOR__EVENT:
                return getEvent();
            case ProcessPackage.CONNECTOR__IGNORE_ERRORS:
                return isIgnoreErrors();
            case ProcessPackage.CONNECTOR__OUTPUTS:
                return getOutputs();
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
            case ProcessPackage.CONNECTOR__DOCUMENTATION:
                setDocumentation((String)newValue);
                return;
            case ProcessPackage.CONNECTOR__NAME:
                setName((String)newValue);
                return;
            case ProcessPackage.CONNECTOR__LABEL:
                setLabel((String)newValue);
                return;
            case ProcessPackage.CONNECTOR__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                getTextAnnotationAttachment().addAll((Collection<? extends TextAnnotationAttachment>)newValue);
                return;
            case ProcessPackage.CONNECTOR__CONNECTOR_ID:
                setConnectorId((String)newValue);
                return;
            case ProcessPackage.CONNECTOR__CONFIGURATION_ID:
                setConfigurationId((String)newValue);
                return;
            case ProcessPackage.CONNECTOR__PARAMETERS:
                getParameters().clear();
                getParameters().addAll((Collection<? extends Parameter>)newValue);
                return;
            case ProcessPackage.CONNECTOR__EVENT:
                setEvent((String)newValue);
                return;
            case ProcessPackage.CONNECTOR__IGNORE_ERRORS:
                setIgnoreErrors((Boolean)newValue);
                return;
            case ProcessPackage.CONNECTOR__OUTPUTS:
                getOutputs().clear();
                getOutputs().addAll((Collection<? extends OutputParameterMapping>)newValue);
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
            case ProcessPackage.CONNECTOR__DOCUMENTATION:
                setDocumentation(DOCUMENTATION_EDEFAULT);
                return;
            case ProcessPackage.CONNECTOR__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ProcessPackage.CONNECTOR__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case ProcessPackage.CONNECTOR__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                return;
            case ProcessPackage.CONNECTOR__CONNECTOR_ID:
                setConnectorId(CONNECTOR_ID_EDEFAULT);
                return;
            case ProcessPackage.CONNECTOR__CONFIGURATION_ID:
                setConfigurationId(CONFIGURATION_ID_EDEFAULT);
                return;
            case ProcessPackage.CONNECTOR__PARAMETERS:
                getParameters().clear();
                return;
            case ProcessPackage.CONNECTOR__EVENT:
                setEvent(EVENT_EDEFAULT);
                return;
            case ProcessPackage.CONNECTOR__IGNORE_ERRORS:
                setIgnoreErrors(IGNORE_ERRORS_EDEFAULT);
                return;
            case ProcessPackage.CONNECTOR__OUTPUTS:
                getOutputs().clear();
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
            case ProcessPackage.CONNECTOR__DOCUMENTATION:
                return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
            case ProcessPackage.CONNECTOR__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ProcessPackage.CONNECTOR__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case ProcessPackage.CONNECTOR__TEXT_ANNOTATION_ATTACHMENT:
                return textAnnotationAttachment != null && !textAnnotationAttachment.isEmpty();
            case ProcessPackage.CONNECTOR__CONNECTOR_ID:
                return CONNECTOR_ID_EDEFAULT == null ? connectorId != null : !CONNECTOR_ID_EDEFAULT.equals(connectorId);
            case ProcessPackage.CONNECTOR__CONFIGURATION_ID:
                return CONFIGURATION_ID_EDEFAULT == null ? configurationId != null : !CONFIGURATION_ID_EDEFAULT.equals(configurationId);
            case ProcessPackage.CONNECTOR__PARAMETERS:
                return parameters != null && !parameters.isEmpty();
            case ProcessPackage.CONNECTOR__EVENT:
                return EVENT_EDEFAULT == null ? event != null : !EVENT_EDEFAULT.equals(event);
            case ProcessPackage.CONNECTOR__IGNORE_ERRORS:
                return ignoreErrors != IGNORE_ERRORS_EDEFAULT;
            case ProcessPackage.CONNECTOR__OUTPUTS:
                return outputs != null && !outputs.isEmpty();
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
        result.append(", connectorId: "); //$NON-NLS-1$
        result.append(connectorId);
        result.append(", configurationId: "); //$NON-NLS-1$
        result.append(configurationId);
        result.append(", event: "); //$NON-NLS-1$
        result.append(event);
        result.append(", ignoreErrors: "); //$NON-NLS-1$
        result.append(ignoreErrors);
        result.append(')');
        return result.toString();
    }

} //ConnectorImpl
