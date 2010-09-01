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
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.process.model.form.FormField;
import org.talend.process.model.form.FormPackage;
import org.talend.process.model.form.GroovyScript;
import org.talend.process.model.form.LabelPosition;
import org.talend.process.model.form.Validable;
import org.talend.process.model.form.Validator;
import org.talend.process.model.form.WidgetDependency;
import org.talend.process.model.form.WidgetLayoutInfo;

import org.talend.process.model.process.Connector;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.TextAnnotationAttachment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getTextAnnotationAttachment <em>Text Annotation Attachment</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getScript <em>Script</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getTooltip <em>Tooltip</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getWidgetLayoutInfo <em>Widget Layout Info</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getDisplayLabel <em>Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getShowDisplayLabel <em>Show Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#isAllowHTMLForDisplayLabel <em>Allow HTML For Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getHtmlAttributes <em>Html Attributes</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getRealHtmlAttributes <em>Real Html Attributes</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getDependOn <em>Depend On</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#isDisplayDependentWidgetOnlyOnEventTriggered <em>Display Dependent Widget Only On Event Triggered</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getScriptAfterEvent <em>Script After Event</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getParentOf <em>Parent Of</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getLabelPosition <em>Label Position</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getInputConnectors <em>Input Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getOutputConnectors <em>Output Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getAfterEventConnectors <em>After Event Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getValidators <em>Validators</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getUseDefaultValidator <em>Use Default Validator</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#isBelow <em>Below</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.FormFieldImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FormFieldImpl extends EObjectImpl implements FormField {
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
     * The cached value of the '{@link #getScript() <em>Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScript()
     * @generated
     * @ordered
     */
    protected GroovyScript script;

    /**
     * The default value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTooltip()
     * @generated
     * @ordered
     */
    protected static final String TOOLTIP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTooltip()
     * @generated
     * @ordered
     */
    protected String tooltip = TOOLTIP_EDEFAULT;

    /**
     * The cached value of the '{@link #getWidgetLayoutInfo() <em>Widget Layout Info</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidgetLayoutInfo()
     * @generated
     * @ordered
     */
    protected WidgetLayoutInfo widgetLayoutInfo;

    /**
     * The default value of the '{@link #getDisplayLabel() <em>Display Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayLabel()
     * @generated
     * @ordered
     */
    protected static final String DISPLAY_LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDisplayLabel() <em>Display Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayLabel()
     * @generated
     * @ordered
     */
    protected String displayLabel = DISPLAY_LABEL_EDEFAULT;

    /**
     * The default value of the '{@link #getShowDisplayLabel() <em>Show Display Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShowDisplayLabel()
     * @generated
     * @ordered
     */
    protected static final Boolean SHOW_DISPLAY_LABEL_EDEFAULT = Boolean.TRUE;

    /**
     * The cached value of the '{@link #getShowDisplayLabel() <em>Show Display Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShowDisplayLabel()
     * @generated
     * @ordered
     */
    protected Boolean showDisplayLabel = SHOW_DISPLAY_LABEL_EDEFAULT;

    /**
     * The default value of the '{@link #isAllowHTMLForDisplayLabel() <em>Allow HTML For Display Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAllowHTMLForDisplayLabel()
     * @generated
     * @ordered
     */
    protected static final boolean ALLOW_HTML_FOR_DISPLAY_LABEL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAllowHTMLForDisplayLabel() <em>Allow HTML For Display Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAllowHTMLForDisplayLabel()
     * @generated
     * @ordered
     */
    protected boolean allowHTMLForDisplayLabel = ALLOW_HTML_FOR_DISPLAY_LABEL_EDEFAULT;

    /**
     * The cached value of the '{@link #getHtmlAttributes() <em>Html Attributes</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHtmlAttributes()
     * @generated
     * @ordered
     */
    protected EMap<String, String> htmlAttributes;

    /**
     * The default value of the '{@link #getRealHtmlAttributes() <em>Real Html Attributes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRealHtmlAttributes()
     * @generated
     * @ordered
     */
    protected static final String REAL_HTML_ATTRIBUTES_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRealHtmlAttributes() <em>Real Html Attributes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRealHtmlAttributes()
     * @generated
     * @ordered
     */
    protected String realHtmlAttributes = REAL_HTML_ATTRIBUTES_EDEFAULT;

    /**
     * The cached value of the '{@link #getDependOn() <em>Depend On</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDependOn()
     * @generated
     * @ordered
     */
    protected EList<WidgetDependency> dependOn;

    /**
     * The default value of the '{@link #isDisplayDependentWidgetOnlyOnEventTriggered() <em>Display Dependent Widget Only On Event Triggered</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDisplayDependentWidgetOnlyOnEventTriggered()
     * @generated
     * @ordered
     */
    protected static final boolean DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDisplayDependentWidgetOnlyOnEventTriggered() <em>Display Dependent Widget Only On Event Triggered</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDisplayDependentWidgetOnlyOnEventTriggered()
     * @generated
     * @ordered
     */
    protected boolean displayDependentWidgetOnlyOnEventTriggered = DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED_EDEFAULT;

    /**
     * The cached value of the '{@link #getScriptAfterEvent() <em>Script After Event</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScriptAfterEvent()
     * @generated
     * @ordered
     */
    protected GroovyScript scriptAfterEvent;

    /**
     * The cached value of the '{@link #getParentOf() <em>Parent Of</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParentOf()
     * @generated
     * @ordered
     */
    protected EList<WidgetDependency> parentOf;

    /**
     * The default value of the '{@link #isMandatory() <em>Mandatory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isMandatory()
     * @generated
     * @ordered
     */
    protected static final boolean MANDATORY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isMandatory() <em>Mandatory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isMandatory()
     * @generated
     * @ordered
     */
    protected boolean mandatory = MANDATORY_EDEFAULT;

    /**
     * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReadOnly()
     * @generated
     * @ordered
     */
    protected static final boolean READ_ONLY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReadOnly()
     * @generated
     * @ordered
     */
    protected boolean readOnly = READ_ONLY_EDEFAULT;

    /**
     * The default value of the '{@link #getLabelPosition() <em>Label Position</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabelPosition()
     * @generated
     * @ordered
     */
    protected static final LabelPosition LABEL_POSITION_EDEFAULT = LabelPosition.LEFT;

    /**
     * The cached value of the '{@link #getLabelPosition() <em>Label Position</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabelPosition()
     * @generated
     * @ordered
     */
    protected LabelPosition labelPosition = LABEL_POSITION_EDEFAULT;

    /**
     * The cached value of the '{@link #getInputConnectors() <em>Input Connectors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputConnectors()
     * @generated
     * @ordered
     */
    protected EList<Connector> inputConnectors;

    /**
     * The cached value of the '{@link #getOutputConnectors() <em>Output Connectors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputConnectors()
     * @generated
     * @ordered
     */
    protected EList<Connector> outputConnectors;

    /**
     * The cached value of the '{@link #getAfterEventConnectors() <em>After Event Connectors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAfterEventConnectors()
     * @generated
     * @ordered
     */
    protected EList<Connector> afterEventConnectors;

    /**
     * The cached value of the '{@link #getValidators() <em>Validators</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValidators()
     * @generated
     * @ordered
     */
    protected EList<Validator> validators;

    /**
     * The default value of the '{@link #getUseDefaultValidator() <em>Use Default Validator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUseDefaultValidator()
     * @generated
     * @ordered
     */
    protected static final Boolean USE_DEFAULT_VALIDATOR_EDEFAULT = Boolean.TRUE;

    /**
     * The cached value of the '{@link #getUseDefaultValidator() <em>Use Default Validator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUseDefaultValidator()
     * @generated
     * @ordered
     */
    protected Boolean useDefaultValidator = USE_DEFAULT_VALIDATOR_EDEFAULT;

    /**
     * The default value of the '{@link #isBelow() <em>Below</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isBelow()
     * @generated
     * @ordered
     */
    protected static final boolean BELOW_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isBelow() <em>Below</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isBelow()
     * @generated
     * @ordered
     */
    protected boolean below = BELOW_EDEFAULT;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FormFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FormPackage.Literals.FORM_FIELD;
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__DOCUMENTATION, oldDocumentation, documentation));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TextAnnotationAttachment> getTextAnnotationAttachment() {
        if (textAnnotationAttachment == null) {
            textAnnotationAttachment = new EObjectContainmentWithInverseEList<TextAnnotationAttachment>(TextAnnotationAttachment.class, this, FormPackage.FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT, ProcessPackage.TEXT_ANNOTATION_ATTACHMENT__TARGET);
        }
        return textAnnotationAttachment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroovyScript getScript() {
        return script;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetScript(GroovyScript newScript, NotificationChain msgs) {
        GroovyScript oldScript = script;
        script = newScript;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__SCRIPT, oldScript, newScript);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScript(GroovyScript newScript) {
        if (newScript != script) {
            NotificationChain msgs = null;
            if (script != null)
                msgs = ((InternalEObject)script).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormPackage.FORM_FIELD__SCRIPT, null, msgs);
            if (newScript != null)
                msgs = ((InternalEObject)newScript).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormPackage.FORM_FIELD__SCRIPT, null, msgs);
            msgs = basicSetScript(newScript, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__SCRIPT, newScript, newScript));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTooltip(String newTooltip) {
        String oldTooltip = tooltip;
        tooltip = newTooltip;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__TOOLTIP, oldTooltip, tooltip));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WidgetLayoutInfo getWidgetLayoutInfo() {
        return widgetLayoutInfo;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetWidgetLayoutInfo(WidgetLayoutInfo newWidgetLayoutInfo, NotificationChain msgs) {
        WidgetLayoutInfo oldWidgetLayoutInfo = widgetLayoutInfo;
        widgetLayoutInfo = newWidgetLayoutInfo;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__WIDGET_LAYOUT_INFO, oldWidgetLayoutInfo, newWidgetLayoutInfo);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWidgetLayoutInfo(WidgetLayoutInfo newWidgetLayoutInfo) {
        if (newWidgetLayoutInfo != widgetLayoutInfo) {
            NotificationChain msgs = null;
            if (widgetLayoutInfo != null)
                msgs = ((InternalEObject)widgetLayoutInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormPackage.FORM_FIELD__WIDGET_LAYOUT_INFO, null, msgs);
            if (newWidgetLayoutInfo != null)
                msgs = ((InternalEObject)newWidgetLayoutInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormPackage.FORM_FIELD__WIDGET_LAYOUT_INFO, null, msgs);
            msgs = basicSetWidgetLayoutInfo(newWidgetLayoutInfo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__WIDGET_LAYOUT_INFO, newWidgetLayoutInfo, newWidgetLayoutInfo));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDisplayLabel() {
        return displayLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDisplayLabel(String newDisplayLabel) {
        String oldDisplayLabel = displayLabel;
        displayLabel = newDisplayLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__DISPLAY_LABEL, oldDisplayLabel, displayLabel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getShowDisplayLabel() {
        return showDisplayLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShowDisplayLabel(Boolean newShowDisplayLabel) {
        Boolean oldShowDisplayLabel = showDisplayLabel;
        showDisplayLabel = newShowDisplayLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__SHOW_DISPLAY_LABEL, oldShowDisplayLabel, showDisplayLabel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAllowHTMLForDisplayLabel() {
        return allowHTMLForDisplayLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAllowHTMLForDisplayLabel(boolean newAllowHTMLForDisplayLabel) {
        boolean oldAllowHTMLForDisplayLabel = allowHTMLForDisplayLabel;
        allowHTMLForDisplayLabel = newAllowHTMLForDisplayLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL, oldAllowHTMLForDisplayLabel, allowHTMLForDisplayLabel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getHtmlAttributes() {
        if (htmlAttributes == null) {
            htmlAttributes = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, FormPackage.FORM_FIELD__HTML_ATTRIBUTES);
        }
        return htmlAttributes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRealHtmlAttributes() {
        return realHtmlAttributes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRealHtmlAttributes(String newRealHtmlAttributes) {
        String oldRealHtmlAttributes = realHtmlAttributes;
        realHtmlAttributes = newRealHtmlAttributes;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__REAL_HTML_ATTRIBUTES, oldRealHtmlAttributes, realHtmlAttributes));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WidgetDependency> getDependOn() {
        if (dependOn == null) {
            dependOn = new EObjectContainmentEList<WidgetDependency>(WidgetDependency.class, this, FormPackage.FORM_FIELD__DEPEND_ON);
        }
        return dependOn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDisplayDependentWidgetOnlyOnEventTriggered() {
        return displayDependentWidgetOnlyOnEventTriggered;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDisplayDependentWidgetOnlyOnEventTriggered(boolean newDisplayDependentWidgetOnlyOnEventTriggered) {
        boolean oldDisplayDependentWidgetOnlyOnEventTriggered = displayDependentWidgetOnlyOnEventTriggered;
        displayDependentWidgetOnlyOnEventTriggered = newDisplayDependentWidgetOnlyOnEventTriggered;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED, oldDisplayDependentWidgetOnlyOnEventTriggered, displayDependentWidgetOnlyOnEventTriggered));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroovyScript getScriptAfterEvent() {
        return scriptAfterEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetScriptAfterEvent(GroovyScript newScriptAfterEvent, NotificationChain msgs) {
        GroovyScript oldScriptAfterEvent = scriptAfterEvent;
        scriptAfterEvent = newScriptAfterEvent;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__SCRIPT_AFTER_EVENT, oldScriptAfterEvent, newScriptAfterEvent);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScriptAfterEvent(GroovyScript newScriptAfterEvent) {
        if (newScriptAfterEvent != scriptAfterEvent) {
            NotificationChain msgs = null;
            if (scriptAfterEvent != null)
                msgs = ((InternalEObject)scriptAfterEvent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormPackage.FORM_FIELD__SCRIPT_AFTER_EVENT, null, msgs);
            if (newScriptAfterEvent != null)
                msgs = ((InternalEObject)newScriptAfterEvent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormPackage.FORM_FIELD__SCRIPT_AFTER_EVENT, null, msgs);
            msgs = basicSetScriptAfterEvent(newScriptAfterEvent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__SCRIPT_AFTER_EVENT, newScriptAfterEvent, newScriptAfterEvent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WidgetDependency> getParentOf() {
        if (parentOf == null) {
            parentOf = new EObjectContainmentEList<WidgetDependency>(WidgetDependency.class, this, FormPackage.FORM_FIELD__PARENT_OF);
        }
        return parentOf;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isMandatory() {
        return mandatory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMandatory(boolean newMandatory) {
        boolean oldMandatory = mandatory;
        mandatory = newMandatory;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__MANDATORY, oldMandatory, mandatory));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReadOnly(boolean newReadOnly) {
        boolean oldReadOnly = readOnly;
        readOnly = newReadOnly;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__READ_ONLY, oldReadOnly, readOnly));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LabelPosition getLabelPosition() {
        return labelPosition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabelPosition(LabelPosition newLabelPosition) {
        LabelPosition oldLabelPosition = labelPosition;
        labelPosition = newLabelPosition == null ? LABEL_POSITION_EDEFAULT : newLabelPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__LABEL_POSITION, oldLabelPosition, labelPosition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getInputConnectors() {
        if (inputConnectors == null) {
            inputConnectors = new EObjectContainmentEList<Connector>(Connector.class, this, FormPackage.FORM_FIELD__INPUT_CONNECTORS);
        }
        return inputConnectors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getOutputConnectors() {
        if (outputConnectors == null) {
            outputConnectors = new EObjectContainmentEList<Connector>(Connector.class, this, FormPackage.FORM_FIELD__OUTPUT_CONNECTORS);
        }
        return outputConnectors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getAfterEventConnectors() {
        if (afterEventConnectors == null) {
            afterEventConnectors = new EObjectContainmentEList<Connector>(Connector.class, this, FormPackage.FORM_FIELD__AFTER_EVENT_CONNECTORS);
        }
        return afterEventConnectors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Validator> getValidators() {
        if (validators == null) {
            validators = new EObjectContainmentEList<Validator>(Validator.class, this, FormPackage.FORM_FIELD__VALIDATORS);
        }
        return validators;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getUseDefaultValidator() {
        return useDefaultValidator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUseDefaultValidator(Boolean newUseDefaultValidator) {
        Boolean oldUseDefaultValidator = useDefaultValidator;
        useDefaultValidator = newUseDefaultValidator;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__USE_DEFAULT_VALIDATOR, oldUseDefaultValidator, useDefaultValidator));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isBelow() {
        return below;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBelow(boolean newBelow) {
        boolean oldBelow = below;
        below = newBelow;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__BELOW, oldBelow, below));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.FORM_FIELD__DESCRIPTION, oldDescription, description));
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
            case FormPackage.FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT:
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
            case FormPackage.FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT:
                return ((InternalEList<?>)getTextAnnotationAttachment()).basicRemove(otherEnd, msgs);
            case FormPackage.FORM_FIELD__SCRIPT:
                return basicSetScript(null, msgs);
            case FormPackage.FORM_FIELD__WIDGET_LAYOUT_INFO:
                return basicSetWidgetLayoutInfo(null, msgs);
            case FormPackage.FORM_FIELD__HTML_ATTRIBUTES:
                return ((InternalEList<?>)getHtmlAttributes()).basicRemove(otherEnd, msgs);
            case FormPackage.FORM_FIELD__DEPEND_ON:
                return ((InternalEList<?>)getDependOn()).basicRemove(otherEnd, msgs);
            case FormPackage.FORM_FIELD__SCRIPT_AFTER_EVENT:
                return basicSetScriptAfterEvent(null, msgs);
            case FormPackage.FORM_FIELD__PARENT_OF:
                return ((InternalEList<?>)getParentOf()).basicRemove(otherEnd, msgs);
            case FormPackage.FORM_FIELD__INPUT_CONNECTORS:
                return ((InternalEList<?>)getInputConnectors()).basicRemove(otherEnd, msgs);
            case FormPackage.FORM_FIELD__OUTPUT_CONNECTORS:
                return ((InternalEList<?>)getOutputConnectors()).basicRemove(otherEnd, msgs);
            case FormPackage.FORM_FIELD__AFTER_EVENT_CONNECTORS:
                return ((InternalEList<?>)getAfterEventConnectors()).basicRemove(otherEnd, msgs);
            case FormPackage.FORM_FIELD__VALIDATORS:
                return ((InternalEList<?>)getValidators()).basicRemove(otherEnd, msgs);
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
            case FormPackage.FORM_FIELD__DOCUMENTATION:
                return getDocumentation();
            case FormPackage.FORM_FIELD__NAME:
                return getName();
            case FormPackage.FORM_FIELD__LABEL:
                return getLabel();
            case FormPackage.FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT:
                return getTextAnnotationAttachment();
            case FormPackage.FORM_FIELD__SCRIPT:
                return getScript();
            case FormPackage.FORM_FIELD__TOOLTIP:
                return getTooltip();
            case FormPackage.FORM_FIELD__WIDGET_LAYOUT_INFO:
                return getWidgetLayoutInfo();
            case FormPackage.FORM_FIELD__DISPLAY_LABEL:
                return getDisplayLabel();
            case FormPackage.FORM_FIELD__SHOW_DISPLAY_LABEL:
                return getShowDisplayLabel();
            case FormPackage.FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL:
                return isAllowHTMLForDisplayLabel();
            case FormPackage.FORM_FIELD__HTML_ATTRIBUTES:
                if (coreType) return getHtmlAttributes();
                else return getHtmlAttributes().map();
            case FormPackage.FORM_FIELD__REAL_HTML_ATTRIBUTES:
                return getRealHtmlAttributes();
            case FormPackage.FORM_FIELD__DEPEND_ON:
                return getDependOn();
            case FormPackage.FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                return isDisplayDependentWidgetOnlyOnEventTriggered();
            case FormPackage.FORM_FIELD__SCRIPT_AFTER_EVENT:
                return getScriptAfterEvent();
            case FormPackage.FORM_FIELD__PARENT_OF:
                return getParentOf();
            case FormPackage.FORM_FIELD__MANDATORY:
                return isMandatory();
            case FormPackage.FORM_FIELD__READ_ONLY:
                return isReadOnly();
            case FormPackage.FORM_FIELD__LABEL_POSITION:
                return getLabelPosition();
            case FormPackage.FORM_FIELD__INPUT_CONNECTORS:
                return getInputConnectors();
            case FormPackage.FORM_FIELD__OUTPUT_CONNECTORS:
                return getOutputConnectors();
            case FormPackage.FORM_FIELD__AFTER_EVENT_CONNECTORS:
                return getAfterEventConnectors();
            case FormPackage.FORM_FIELD__VALIDATORS:
                return getValidators();
            case FormPackage.FORM_FIELD__USE_DEFAULT_VALIDATOR:
                return getUseDefaultValidator();
            case FormPackage.FORM_FIELD__BELOW:
                return isBelow();
            case FormPackage.FORM_FIELD__DESCRIPTION:
                return getDescription();
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
            case FormPackage.FORM_FIELD__DOCUMENTATION:
                setDocumentation((String)newValue);
                return;
            case FormPackage.FORM_FIELD__NAME:
                setName((String)newValue);
                return;
            case FormPackage.FORM_FIELD__LABEL:
                setLabel((String)newValue);
                return;
            case FormPackage.FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                getTextAnnotationAttachment().addAll((Collection<? extends TextAnnotationAttachment>)newValue);
                return;
            case FormPackage.FORM_FIELD__SCRIPT:
                setScript((GroovyScript)newValue);
                return;
            case FormPackage.FORM_FIELD__TOOLTIP:
                setTooltip((String)newValue);
                return;
            case FormPackage.FORM_FIELD__WIDGET_LAYOUT_INFO:
                setWidgetLayoutInfo((WidgetLayoutInfo)newValue);
                return;
            case FormPackage.FORM_FIELD__DISPLAY_LABEL:
                setDisplayLabel((String)newValue);
                return;
            case FormPackage.FORM_FIELD__SHOW_DISPLAY_LABEL:
                setShowDisplayLabel((Boolean)newValue);
                return;
            case FormPackage.FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL:
                setAllowHTMLForDisplayLabel((Boolean)newValue);
                return;
            case FormPackage.FORM_FIELD__HTML_ATTRIBUTES:
                ((EStructuralFeature.Setting)getHtmlAttributes()).set(newValue);
                return;
            case FormPackage.FORM_FIELD__REAL_HTML_ATTRIBUTES:
                setRealHtmlAttributes((String)newValue);
                return;
            case FormPackage.FORM_FIELD__DEPEND_ON:
                getDependOn().clear();
                getDependOn().addAll((Collection<? extends WidgetDependency>)newValue);
                return;
            case FormPackage.FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                setDisplayDependentWidgetOnlyOnEventTriggered((Boolean)newValue);
                return;
            case FormPackage.FORM_FIELD__SCRIPT_AFTER_EVENT:
                setScriptAfterEvent((GroovyScript)newValue);
                return;
            case FormPackage.FORM_FIELD__PARENT_OF:
                getParentOf().clear();
                getParentOf().addAll((Collection<? extends WidgetDependency>)newValue);
                return;
            case FormPackage.FORM_FIELD__MANDATORY:
                setMandatory((Boolean)newValue);
                return;
            case FormPackage.FORM_FIELD__READ_ONLY:
                setReadOnly((Boolean)newValue);
                return;
            case FormPackage.FORM_FIELD__LABEL_POSITION:
                setLabelPosition((LabelPosition)newValue);
                return;
            case FormPackage.FORM_FIELD__INPUT_CONNECTORS:
                getInputConnectors().clear();
                getInputConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case FormPackage.FORM_FIELD__OUTPUT_CONNECTORS:
                getOutputConnectors().clear();
                getOutputConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case FormPackage.FORM_FIELD__AFTER_EVENT_CONNECTORS:
                getAfterEventConnectors().clear();
                getAfterEventConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case FormPackage.FORM_FIELD__VALIDATORS:
                getValidators().clear();
                getValidators().addAll((Collection<? extends Validator>)newValue);
                return;
            case FormPackage.FORM_FIELD__USE_DEFAULT_VALIDATOR:
                setUseDefaultValidator((Boolean)newValue);
                return;
            case FormPackage.FORM_FIELD__BELOW:
                setBelow((Boolean)newValue);
                return;
            case FormPackage.FORM_FIELD__DESCRIPTION:
                setDescription((String)newValue);
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
            case FormPackage.FORM_FIELD__DOCUMENTATION:
                setDocumentation(DOCUMENTATION_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__NAME:
                setName(NAME_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                return;
            case FormPackage.FORM_FIELD__SCRIPT:
                setScript((GroovyScript)null);
                return;
            case FormPackage.FORM_FIELD__TOOLTIP:
                setTooltip(TOOLTIP_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__WIDGET_LAYOUT_INFO:
                setWidgetLayoutInfo((WidgetLayoutInfo)null);
                return;
            case FormPackage.FORM_FIELD__DISPLAY_LABEL:
                setDisplayLabel(DISPLAY_LABEL_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__SHOW_DISPLAY_LABEL:
                setShowDisplayLabel(SHOW_DISPLAY_LABEL_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL:
                setAllowHTMLForDisplayLabel(ALLOW_HTML_FOR_DISPLAY_LABEL_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__HTML_ATTRIBUTES:
                getHtmlAttributes().clear();
                return;
            case FormPackage.FORM_FIELD__REAL_HTML_ATTRIBUTES:
                setRealHtmlAttributes(REAL_HTML_ATTRIBUTES_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__DEPEND_ON:
                getDependOn().clear();
                return;
            case FormPackage.FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                setDisplayDependentWidgetOnlyOnEventTriggered(DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__SCRIPT_AFTER_EVENT:
                setScriptAfterEvent((GroovyScript)null);
                return;
            case FormPackage.FORM_FIELD__PARENT_OF:
                getParentOf().clear();
                return;
            case FormPackage.FORM_FIELD__MANDATORY:
                setMandatory(MANDATORY_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__READ_ONLY:
                setReadOnly(READ_ONLY_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__LABEL_POSITION:
                setLabelPosition(LABEL_POSITION_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__INPUT_CONNECTORS:
                getInputConnectors().clear();
                return;
            case FormPackage.FORM_FIELD__OUTPUT_CONNECTORS:
                getOutputConnectors().clear();
                return;
            case FormPackage.FORM_FIELD__AFTER_EVENT_CONNECTORS:
                getAfterEventConnectors().clear();
                return;
            case FormPackage.FORM_FIELD__VALIDATORS:
                getValidators().clear();
                return;
            case FormPackage.FORM_FIELD__USE_DEFAULT_VALIDATOR:
                setUseDefaultValidator(USE_DEFAULT_VALIDATOR_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__BELOW:
                setBelow(BELOW_EDEFAULT);
                return;
            case FormPackage.FORM_FIELD__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
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
            case FormPackage.FORM_FIELD__DOCUMENTATION:
                return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
            case FormPackage.FORM_FIELD__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case FormPackage.FORM_FIELD__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case FormPackage.FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT:
                return textAnnotationAttachment != null && !textAnnotationAttachment.isEmpty();
            case FormPackage.FORM_FIELD__SCRIPT:
                return script != null;
            case FormPackage.FORM_FIELD__TOOLTIP:
                return TOOLTIP_EDEFAULT == null ? tooltip != null : !TOOLTIP_EDEFAULT.equals(tooltip);
            case FormPackage.FORM_FIELD__WIDGET_LAYOUT_INFO:
                return widgetLayoutInfo != null;
            case FormPackage.FORM_FIELD__DISPLAY_LABEL:
                return DISPLAY_LABEL_EDEFAULT == null ? displayLabel != null : !DISPLAY_LABEL_EDEFAULT.equals(displayLabel);
            case FormPackage.FORM_FIELD__SHOW_DISPLAY_LABEL:
                return SHOW_DISPLAY_LABEL_EDEFAULT == null ? showDisplayLabel != null : !SHOW_DISPLAY_LABEL_EDEFAULT.equals(showDisplayLabel);
            case FormPackage.FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL:
                return allowHTMLForDisplayLabel != ALLOW_HTML_FOR_DISPLAY_LABEL_EDEFAULT;
            case FormPackage.FORM_FIELD__HTML_ATTRIBUTES:
                return htmlAttributes != null && !htmlAttributes.isEmpty();
            case FormPackage.FORM_FIELD__REAL_HTML_ATTRIBUTES:
                return REAL_HTML_ATTRIBUTES_EDEFAULT == null ? realHtmlAttributes != null : !REAL_HTML_ATTRIBUTES_EDEFAULT.equals(realHtmlAttributes);
            case FormPackage.FORM_FIELD__DEPEND_ON:
                return dependOn != null && !dependOn.isEmpty();
            case FormPackage.FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                return displayDependentWidgetOnlyOnEventTriggered != DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED_EDEFAULT;
            case FormPackage.FORM_FIELD__SCRIPT_AFTER_EVENT:
                return scriptAfterEvent != null;
            case FormPackage.FORM_FIELD__PARENT_OF:
                return parentOf != null && !parentOf.isEmpty();
            case FormPackage.FORM_FIELD__MANDATORY:
                return mandatory != MANDATORY_EDEFAULT;
            case FormPackage.FORM_FIELD__READ_ONLY:
                return readOnly != READ_ONLY_EDEFAULT;
            case FormPackage.FORM_FIELD__LABEL_POSITION:
                return labelPosition != LABEL_POSITION_EDEFAULT;
            case FormPackage.FORM_FIELD__INPUT_CONNECTORS:
                return inputConnectors != null && !inputConnectors.isEmpty();
            case FormPackage.FORM_FIELD__OUTPUT_CONNECTORS:
                return outputConnectors != null && !outputConnectors.isEmpty();
            case FormPackage.FORM_FIELD__AFTER_EVENT_CONNECTORS:
                return afterEventConnectors != null && !afterEventConnectors.isEmpty();
            case FormPackage.FORM_FIELD__VALIDATORS:
                return validators != null && !validators.isEmpty();
            case FormPackage.FORM_FIELD__USE_DEFAULT_VALIDATOR:
                return USE_DEFAULT_VALIDATOR_EDEFAULT == null ? useDefaultValidator != null : !USE_DEFAULT_VALIDATOR_EDEFAULT.equals(useDefaultValidator);
            case FormPackage.FORM_FIELD__BELOW:
                return below != BELOW_EDEFAULT;
            case FormPackage.FORM_FIELD__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
        if (baseClass == Validable.class) {
            switch (derivedFeatureID) {
                case FormPackage.FORM_FIELD__VALIDATORS: return FormPackage.VALIDABLE__VALIDATORS;
                case FormPackage.FORM_FIELD__USE_DEFAULT_VALIDATOR: return FormPackage.VALIDABLE__USE_DEFAULT_VALIDATOR;
                case FormPackage.FORM_FIELD__BELOW: return FormPackage.VALIDABLE__BELOW;
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
        if (baseClass == Validable.class) {
            switch (baseFeatureID) {
                case FormPackage.VALIDABLE__VALIDATORS: return FormPackage.FORM_FIELD__VALIDATORS;
                case FormPackage.VALIDABLE__USE_DEFAULT_VALIDATOR: return FormPackage.FORM_FIELD__USE_DEFAULT_VALIDATOR;
                case FormPackage.VALIDABLE__BELOW: return FormPackage.FORM_FIELD__BELOW;
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
        result.append(" (documentation: "); //$NON-NLS-1$
        result.append(documentation);
        result.append(", name: "); //$NON-NLS-1$
        result.append(name);
        result.append(", label: "); //$NON-NLS-1$
        result.append(label);
        result.append(", tooltip: "); //$NON-NLS-1$
        result.append(tooltip);
        result.append(", displayLabel: "); //$NON-NLS-1$
        result.append(displayLabel);
        result.append(", showDisplayLabel: "); //$NON-NLS-1$
        result.append(showDisplayLabel);
        result.append(", allowHTMLForDisplayLabel: "); //$NON-NLS-1$
        result.append(allowHTMLForDisplayLabel);
        result.append(", realHtmlAttributes: "); //$NON-NLS-1$
        result.append(realHtmlAttributes);
        result.append(", displayDependentWidgetOnlyOnEventTriggered: "); //$NON-NLS-1$
        result.append(displayDependentWidgetOnlyOnEventTriggered);
        result.append(", mandatory: "); //$NON-NLS-1$
        result.append(mandatory);
        result.append(", readOnly: "); //$NON-NLS-1$
        result.append(readOnly);
        result.append(", labelPosition: "); //$NON-NLS-1$
        result.append(labelPosition);
        result.append(", useDefaultValidator: "); //$NON-NLS-1$
        result.append(useDefaultValidator);
        result.append(", below: "); //$NON-NLS-1$
        result.append(below);
        result.append(", description: "); //$NON-NLS-1$
        result.append(description);
        result.append(')');
        return result.toString();
    }

} //FormFieldImpl
