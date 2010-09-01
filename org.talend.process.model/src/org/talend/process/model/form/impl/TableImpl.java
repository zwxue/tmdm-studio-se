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

import org.talend.process.model.form.FormPackage;
import org.talend.process.model.form.GroovyScript;
import org.talend.process.model.form.LabelPosition;
import org.talend.process.model.form.Table;
import org.talend.process.model.form.WidgetDependency;
import org.talend.process.model.form.WidgetLayoutInfo;

import org.talend.process.model.process.Connector;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.TextAnnotationAttachment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getTextAnnotationAttachment <em>Text Annotation Attachment</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getScript <em>Script</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getTooltip <em>Tooltip</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getWidgetLayoutInfo <em>Widget Layout Info</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getDisplayLabel <em>Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getShowDisplayLabel <em>Show Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#isAllowHTMLForDisplayLabel <em>Allow HTML For Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getHtmlAttributes <em>Html Attributes</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getRealHtmlAttributes <em>Real Html Attributes</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getDependOn <em>Depend On</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#isDisplayDependentWidgetOnlyOnEventTriggered <em>Display Dependent Widget Only On Event Triggered</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getScriptAfterEvent <em>Script After Event</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getParentOf <em>Parent Of</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getLabelPosition <em>Label Position</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getInputConnectors <em>Input Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getOutputConnectors <em>Output Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getAfterEventConnectors <em>After Event Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#isLeftColumnIsHeader <em>Left Column Is Header</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#isRightColumnIsHeader <em>Right Column Is Header</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#isFirstRowIsHeader <em>First Row Is Header</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#isLastRowIsHeader <em>Last Row Is Header</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#isInitializedUsingCells <em>Initialized Using Cells</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.TableImpl#getCells <em>Cells</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends EObjectImpl implements Table {
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
     * The default value of the '{@link #isLeftColumnIsHeader() <em>Left Column Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLeftColumnIsHeader()
     * @generated
     * @ordered
     */
    protected static final boolean LEFT_COLUMN_IS_HEADER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isLeftColumnIsHeader() <em>Left Column Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLeftColumnIsHeader()
     * @generated
     * @ordered
     */
    protected boolean leftColumnIsHeader = LEFT_COLUMN_IS_HEADER_EDEFAULT;

    /**
     * The default value of the '{@link #isRightColumnIsHeader() <em>Right Column Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRightColumnIsHeader()
     * @generated
     * @ordered
     */
    protected static final boolean RIGHT_COLUMN_IS_HEADER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isRightColumnIsHeader() <em>Right Column Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRightColumnIsHeader()
     * @generated
     * @ordered
     */
    protected boolean rightColumnIsHeader = RIGHT_COLUMN_IS_HEADER_EDEFAULT;

    /**
     * The default value of the '{@link #isFirstRowIsHeader() <em>First Row Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFirstRowIsHeader()
     * @generated
     * @ordered
     */
    protected static final boolean FIRST_ROW_IS_HEADER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isFirstRowIsHeader() <em>First Row Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFirstRowIsHeader()
     * @generated
     * @ordered
     */
    protected boolean firstRowIsHeader = FIRST_ROW_IS_HEADER_EDEFAULT;

    /**
     * The default value of the '{@link #isLastRowIsHeader() <em>Last Row Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLastRowIsHeader()
     * @generated
     * @ordered
     */
    protected static final boolean LAST_ROW_IS_HEADER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isLastRowIsHeader() <em>Last Row Is Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLastRowIsHeader()
     * @generated
     * @ordered
     */
    protected boolean lastRowIsHeader = LAST_ROW_IS_HEADER_EDEFAULT;

    /**
     * The default value of the '{@link #isInitializedUsingCells() <em>Initialized Using Cells</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInitializedUsingCells()
     * @generated
     * @ordered
     */
    protected static final boolean INITIALIZED_USING_CELLS_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isInitializedUsingCells() <em>Initialized Using Cells</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInitializedUsingCells()
     * @generated
     * @ordered
     */
    protected boolean initializedUsingCells = INITIALIZED_USING_CELLS_EDEFAULT;

    /**
     * The default value of the '{@link #getCells() <em>Cells</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCells()
     * @generated
     * @ordered
     */
    protected static final Object CELLS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCells() <em>Cells</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCells()
     * @generated
     * @ordered
     */
    protected Object cells = CELLS_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TableImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FormPackage.Literals.TABLE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__DOCUMENTATION, oldDocumentation, documentation));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TextAnnotationAttachment> getTextAnnotationAttachment() {
        if (textAnnotationAttachment == null) {
            textAnnotationAttachment = new EObjectContainmentWithInverseEList<TextAnnotationAttachment>(TextAnnotationAttachment.class, this, FormPackage.TABLE__TEXT_ANNOTATION_ATTACHMENT, ProcessPackage.TEXT_ANNOTATION_ATTACHMENT__TARGET);
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__SCRIPT, oldScript, newScript);
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
                msgs = ((InternalEObject)script).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormPackage.TABLE__SCRIPT, null, msgs);
            if (newScript != null)
                msgs = ((InternalEObject)newScript).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormPackage.TABLE__SCRIPT, null, msgs);
            msgs = basicSetScript(newScript, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__SCRIPT, newScript, newScript));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__TOOLTIP, oldTooltip, tooltip));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__WIDGET_LAYOUT_INFO, oldWidgetLayoutInfo, newWidgetLayoutInfo);
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
                msgs = ((InternalEObject)widgetLayoutInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormPackage.TABLE__WIDGET_LAYOUT_INFO, null, msgs);
            if (newWidgetLayoutInfo != null)
                msgs = ((InternalEObject)newWidgetLayoutInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormPackage.TABLE__WIDGET_LAYOUT_INFO, null, msgs);
            msgs = basicSetWidgetLayoutInfo(newWidgetLayoutInfo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__WIDGET_LAYOUT_INFO, newWidgetLayoutInfo, newWidgetLayoutInfo));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__DISPLAY_LABEL, oldDisplayLabel, displayLabel));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__SHOW_DISPLAY_LABEL, oldShowDisplayLabel, showDisplayLabel));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__ALLOW_HTML_FOR_DISPLAY_LABEL, oldAllowHTMLForDisplayLabel, allowHTMLForDisplayLabel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getHtmlAttributes() {
        if (htmlAttributes == null) {
            htmlAttributes = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, FormPackage.TABLE__HTML_ATTRIBUTES);
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__REAL_HTML_ATTRIBUTES, oldRealHtmlAttributes, realHtmlAttributes));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WidgetDependency> getDependOn() {
        if (dependOn == null) {
            dependOn = new EObjectContainmentEList<WidgetDependency>(WidgetDependency.class, this, FormPackage.TABLE__DEPEND_ON);
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED, oldDisplayDependentWidgetOnlyOnEventTriggered, displayDependentWidgetOnlyOnEventTriggered));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__SCRIPT_AFTER_EVENT, oldScriptAfterEvent, newScriptAfterEvent);
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
                msgs = ((InternalEObject)scriptAfterEvent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormPackage.TABLE__SCRIPT_AFTER_EVENT, null, msgs);
            if (newScriptAfterEvent != null)
                msgs = ((InternalEObject)newScriptAfterEvent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormPackage.TABLE__SCRIPT_AFTER_EVENT, null, msgs);
            msgs = basicSetScriptAfterEvent(newScriptAfterEvent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__SCRIPT_AFTER_EVENT, newScriptAfterEvent, newScriptAfterEvent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WidgetDependency> getParentOf() {
        if (parentOf == null) {
            parentOf = new EObjectContainmentEList<WidgetDependency>(WidgetDependency.class, this, FormPackage.TABLE__PARENT_OF);
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__MANDATORY, oldMandatory, mandatory));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__READ_ONLY, oldReadOnly, readOnly));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__LABEL_POSITION, oldLabelPosition, labelPosition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getInputConnectors() {
        if (inputConnectors == null) {
            inputConnectors = new EObjectContainmentEList<Connector>(Connector.class, this, FormPackage.TABLE__INPUT_CONNECTORS);
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
            outputConnectors = new EObjectContainmentEList<Connector>(Connector.class, this, FormPackage.TABLE__OUTPUT_CONNECTORS);
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
            afterEventConnectors = new EObjectContainmentEList<Connector>(Connector.class, this, FormPackage.TABLE__AFTER_EVENT_CONNECTORS);
        }
        return afterEventConnectors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isLeftColumnIsHeader() {
        return leftColumnIsHeader;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLeftColumnIsHeader(boolean newLeftColumnIsHeader) {
        boolean oldLeftColumnIsHeader = leftColumnIsHeader;
        leftColumnIsHeader = newLeftColumnIsHeader;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__LEFT_COLUMN_IS_HEADER, oldLeftColumnIsHeader, leftColumnIsHeader));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isRightColumnIsHeader() {
        return rightColumnIsHeader;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRightColumnIsHeader(boolean newRightColumnIsHeader) {
        boolean oldRightColumnIsHeader = rightColumnIsHeader;
        rightColumnIsHeader = newRightColumnIsHeader;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__RIGHT_COLUMN_IS_HEADER, oldRightColumnIsHeader, rightColumnIsHeader));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isFirstRowIsHeader() {
        return firstRowIsHeader;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFirstRowIsHeader(boolean newFirstRowIsHeader) {
        boolean oldFirstRowIsHeader = firstRowIsHeader;
        firstRowIsHeader = newFirstRowIsHeader;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__FIRST_ROW_IS_HEADER, oldFirstRowIsHeader, firstRowIsHeader));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isLastRowIsHeader() {
        return lastRowIsHeader;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLastRowIsHeader(boolean newLastRowIsHeader) {
        boolean oldLastRowIsHeader = lastRowIsHeader;
        lastRowIsHeader = newLastRowIsHeader;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__LAST_ROW_IS_HEADER, oldLastRowIsHeader, lastRowIsHeader));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isInitializedUsingCells() {
        return initializedUsingCells;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInitializedUsingCells(boolean newInitializedUsingCells) {
        boolean oldInitializedUsingCells = initializedUsingCells;
        initializedUsingCells = newInitializedUsingCells;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__INITIALIZED_USING_CELLS, oldInitializedUsingCells, initializedUsingCells));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object getCells() {
        return cells;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCells(Object newCells) {
        Object oldCells = cells;
        cells = newCells;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.TABLE__CELLS, oldCells, cells));
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
            case FormPackage.TABLE__TEXT_ANNOTATION_ATTACHMENT:
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
            case FormPackage.TABLE__TEXT_ANNOTATION_ATTACHMENT:
                return ((InternalEList<?>)getTextAnnotationAttachment()).basicRemove(otherEnd, msgs);
            case FormPackage.TABLE__SCRIPT:
                return basicSetScript(null, msgs);
            case FormPackage.TABLE__WIDGET_LAYOUT_INFO:
                return basicSetWidgetLayoutInfo(null, msgs);
            case FormPackage.TABLE__HTML_ATTRIBUTES:
                return ((InternalEList<?>)getHtmlAttributes()).basicRemove(otherEnd, msgs);
            case FormPackage.TABLE__DEPEND_ON:
                return ((InternalEList<?>)getDependOn()).basicRemove(otherEnd, msgs);
            case FormPackage.TABLE__SCRIPT_AFTER_EVENT:
                return basicSetScriptAfterEvent(null, msgs);
            case FormPackage.TABLE__PARENT_OF:
                return ((InternalEList<?>)getParentOf()).basicRemove(otherEnd, msgs);
            case FormPackage.TABLE__INPUT_CONNECTORS:
                return ((InternalEList<?>)getInputConnectors()).basicRemove(otherEnd, msgs);
            case FormPackage.TABLE__OUTPUT_CONNECTORS:
                return ((InternalEList<?>)getOutputConnectors()).basicRemove(otherEnd, msgs);
            case FormPackage.TABLE__AFTER_EVENT_CONNECTORS:
                return ((InternalEList<?>)getAfterEventConnectors()).basicRemove(otherEnd, msgs);
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
            case FormPackage.TABLE__DOCUMENTATION:
                return getDocumentation();
            case FormPackage.TABLE__NAME:
                return getName();
            case FormPackage.TABLE__LABEL:
                return getLabel();
            case FormPackage.TABLE__TEXT_ANNOTATION_ATTACHMENT:
                return getTextAnnotationAttachment();
            case FormPackage.TABLE__SCRIPT:
                return getScript();
            case FormPackage.TABLE__TOOLTIP:
                return getTooltip();
            case FormPackage.TABLE__WIDGET_LAYOUT_INFO:
                return getWidgetLayoutInfo();
            case FormPackage.TABLE__DISPLAY_LABEL:
                return getDisplayLabel();
            case FormPackage.TABLE__SHOW_DISPLAY_LABEL:
                return getShowDisplayLabel();
            case FormPackage.TABLE__ALLOW_HTML_FOR_DISPLAY_LABEL:
                return isAllowHTMLForDisplayLabel();
            case FormPackage.TABLE__HTML_ATTRIBUTES:
                if (coreType) return getHtmlAttributes();
                else return getHtmlAttributes().map();
            case FormPackage.TABLE__REAL_HTML_ATTRIBUTES:
                return getRealHtmlAttributes();
            case FormPackage.TABLE__DEPEND_ON:
                return getDependOn();
            case FormPackage.TABLE__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                return isDisplayDependentWidgetOnlyOnEventTriggered();
            case FormPackage.TABLE__SCRIPT_AFTER_EVENT:
                return getScriptAfterEvent();
            case FormPackage.TABLE__PARENT_OF:
                return getParentOf();
            case FormPackage.TABLE__MANDATORY:
                return isMandatory();
            case FormPackage.TABLE__READ_ONLY:
                return isReadOnly();
            case FormPackage.TABLE__LABEL_POSITION:
                return getLabelPosition();
            case FormPackage.TABLE__INPUT_CONNECTORS:
                return getInputConnectors();
            case FormPackage.TABLE__OUTPUT_CONNECTORS:
                return getOutputConnectors();
            case FormPackage.TABLE__AFTER_EVENT_CONNECTORS:
                return getAfterEventConnectors();
            case FormPackage.TABLE__LEFT_COLUMN_IS_HEADER:
                return isLeftColumnIsHeader();
            case FormPackage.TABLE__RIGHT_COLUMN_IS_HEADER:
                return isRightColumnIsHeader();
            case FormPackage.TABLE__FIRST_ROW_IS_HEADER:
                return isFirstRowIsHeader();
            case FormPackage.TABLE__LAST_ROW_IS_HEADER:
                return isLastRowIsHeader();
            case FormPackage.TABLE__INITIALIZED_USING_CELLS:
                return isInitializedUsingCells();
            case FormPackage.TABLE__CELLS:
                return getCells();
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
            case FormPackage.TABLE__DOCUMENTATION:
                setDocumentation((String)newValue);
                return;
            case FormPackage.TABLE__NAME:
                setName((String)newValue);
                return;
            case FormPackage.TABLE__LABEL:
                setLabel((String)newValue);
                return;
            case FormPackage.TABLE__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                getTextAnnotationAttachment().addAll((Collection<? extends TextAnnotationAttachment>)newValue);
                return;
            case FormPackage.TABLE__SCRIPT:
                setScript((GroovyScript)newValue);
                return;
            case FormPackage.TABLE__TOOLTIP:
                setTooltip((String)newValue);
                return;
            case FormPackage.TABLE__WIDGET_LAYOUT_INFO:
                setWidgetLayoutInfo((WidgetLayoutInfo)newValue);
                return;
            case FormPackage.TABLE__DISPLAY_LABEL:
                setDisplayLabel((String)newValue);
                return;
            case FormPackage.TABLE__SHOW_DISPLAY_LABEL:
                setShowDisplayLabel((Boolean)newValue);
                return;
            case FormPackage.TABLE__ALLOW_HTML_FOR_DISPLAY_LABEL:
                setAllowHTMLForDisplayLabel((Boolean)newValue);
                return;
            case FormPackage.TABLE__HTML_ATTRIBUTES:
                ((EStructuralFeature.Setting)getHtmlAttributes()).set(newValue);
                return;
            case FormPackage.TABLE__REAL_HTML_ATTRIBUTES:
                setRealHtmlAttributes((String)newValue);
                return;
            case FormPackage.TABLE__DEPEND_ON:
                getDependOn().clear();
                getDependOn().addAll((Collection<? extends WidgetDependency>)newValue);
                return;
            case FormPackage.TABLE__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                setDisplayDependentWidgetOnlyOnEventTriggered((Boolean)newValue);
                return;
            case FormPackage.TABLE__SCRIPT_AFTER_EVENT:
                setScriptAfterEvent((GroovyScript)newValue);
                return;
            case FormPackage.TABLE__PARENT_OF:
                getParentOf().clear();
                getParentOf().addAll((Collection<? extends WidgetDependency>)newValue);
                return;
            case FormPackage.TABLE__MANDATORY:
                setMandatory((Boolean)newValue);
                return;
            case FormPackage.TABLE__READ_ONLY:
                setReadOnly((Boolean)newValue);
                return;
            case FormPackage.TABLE__LABEL_POSITION:
                setLabelPosition((LabelPosition)newValue);
                return;
            case FormPackage.TABLE__INPUT_CONNECTORS:
                getInputConnectors().clear();
                getInputConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case FormPackage.TABLE__OUTPUT_CONNECTORS:
                getOutputConnectors().clear();
                getOutputConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case FormPackage.TABLE__AFTER_EVENT_CONNECTORS:
                getAfterEventConnectors().clear();
                getAfterEventConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case FormPackage.TABLE__LEFT_COLUMN_IS_HEADER:
                setLeftColumnIsHeader((Boolean)newValue);
                return;
            case FormPackage.TABLE__RIGHT_COLUMN_IS_HEADER:
                setRightColumnIsHeader((Boolean)newValue);
                return;
            case FormPackage.TABLE__FIRST_ROW_IS_HEADER:
                setFirstRowIsHeader((Boolean)newValue);
                return;
            case FormPackage.TABLE__LAST_ROW_IS_HEADER:
                setLastRowIsHeader((Boolean)newValue);
                return;
            case FormPackage.TABLE__INITIALIZED_USING_CELLS:
                setInitializedUsingCells((Boolean)newValue);
                return;
            case FormPackage.TABLE__CELLS:
                setCells(newValue);
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
            case FormPackage.TABLE__DOCUMENTATION:
                setDocumentation(DOCUMENTATION_EDEFAULT);
                return;
            case FormPackage.TABLE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case FormPackage.TABLE__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case FormPackage.TABLE__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                return;
            case FormPackage.TABLE__SCRIPT:
                setScript((GroovyScript)null);
                return;
            case FormPackage.TABLE__TOOLTIP:
                setTooltip(TOOLTIP_EDEFAULT);
                return;
            case FormPackage.TABLE__WIDGET_LAYOUT_INFO:
                setWidgetLayoutInfo((WidgetLayoutInfo)null);
                return;
            case FormPackage.TABLE__DISPLAY_LABEL:
                setDisplayLabel(DISPLAY_LABEL_EDEFAULT);
                return;
            case FormPackage.TABLE__SHOW_DISPLAY_LABEL:
                setShowDisplayLabel(SHOW_DISPLAY_LABEL_EDEFAULT);
                return;
            case FormPackage.TABLE__ALLOW_HTML_FOR_DISPLAY_LABEL:
                setAllowHTMLForDisplayLabel(ALLOW_HTML_FOR_DISPLAY_LABEL_EDEFAULT);
                return;
            case FormPackage.TABLE__HTML_ATTRIBUTES:
                getHtmlAttributes().clear();
                return;
            case FormPackage.TABLE__REAL_HTML_ATTRIBUTES:
                setRealHtmlAttributes(REAL_HTML_ATTRIBUTES_EDEFAULT);
                return;
            case FormPackage.TABLE__DEPEND_ON:
                getDependOn().clear();
                return;
            case FormPackage.TABLE__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                setDisplayDependentWidgetOnlyOnEventTriggered(DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED_EDEFAULT);
                return;
            case FormPackage.TABLE__SCRIPT_AFTER_EVENT:
                setScriptAfterEvent((GroovyScript)null);
                return;
            case FormPackage.TABLE__PARENT_OF:
                getParentOf().clear();
                return;
            case FormPackage.TABLE__MANDATORY:
                setMandatory(MANDATORY_EDEFAULT);
                return;
            case FormPackage.TABLE__READ_ONLY:
                setReadOnly(READ_ONLY_EDEFAULT);
                return;
            case FormPackage.TABLE__LABEL_POSITION:
                setLabelPosition(LABEL_POSITION_EDEFAULT);
                return;
            case FormPackage.TABLE__INPUT_CONNECTORS:
                getInputConnectors().clear();
                return;
            case FormPackage.TABLE__OUTPUT_CONNECTORS:
                getOutputConnectors().clear();
                return;
            case FormPackage.TABLE__AFTER_EVENT_CONNECTORS:
                getAfterEventConnectors().clear();
                return;
            case FormPackage.TABLE__LEFT_COLUMN_IS_HEADER:
                setLeftColumnIsHeader(LEFT_COLUMN_IS_HEADER_EDEFAULT);
                return;
            case FormPackage.TABLE__RIGHT_COLUMN_IS_HEADER:
                setRightColumnIsHeader(RIGHT_COLUMN_IS_HEADER_EDEFAULT);
                return;
            case FormPackage.TABLE__FIRST_ROW_IS_HEADER:
                setFirstRowIsHeader(FIRST_ROW_IS_HEADER_EDEFAULT);
                return;
            case FormPackage.TABLE__LAST_ROW_IS_HEADER:
                setLastRowIsHeader(LAST_ROW_IS_HEADER_EDEFAULT);
                return;
            case FormPackage.TABLE__INITIALIZED_USING_CELLS:
                setInitializedUsingCells(INITIALIZED_USING_CELLS_EDEFAULT);
                return;
            case FormPackage.TABLE__CELLS:
                setCells(CELLS_EDEFAULT);
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
            case FormPackage.TABLE__DOCUMENTATION:
                return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
            case FormPackage.TABLE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case FormPackage.TABLE__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case FormPackage.TABLE__TEXT_ANNOTATION_ATTACHMENT:
                return textAnnotationAttachment != null && !textAnnotationAttachment.isEmpty();
            case FormPackage.TABLE__SCRIPT:
                return script != null;
            case FormPackage.TABLE__TOOLTIP:
                return TOOLTIP_EDEFAULT == null ? tooltip != null : !TOOLTIP_EDEFAULT.equals(tooltip);
            case FormPackage.TABLE__WIDGET_LAYOUT_INFO:
                return widgetLayoutInfo != null;
            case FormPackage.TABLE__DISPLAY_LABEL:
                return DISPLAY_LABEL_EDEFAULT == null ? displayLabel != null : !DISPLAY_LABEL_EDEFAULT.equals(displayLabel);
            case FormPackage.TABLE__SHOW_DISPLAY_LABEL:
                return SHOW_DISPLAY_LABEL_EDEFAULT == null ? showDisplayLabel != null : !SHOW_DISPLAY_LABEL_EDEFAULT.equals(showDisplayLabel);
            case FormPackage.TABLE__ALLOW_HTML_FOR_DISPLAY_LABEL:
                return allowHTMLForDisplayLabel != ALLOW_HTML_FOR_DISPLAY_LABEL_EDEFAULT;
            case FormPackage.TABLE__HTML_ATTRIBUTES:
                return htmlAttributes != null && !htmlAttributes.isEmpty();
            case FormPackage.TABLE__REAL_HTML_ATTRIBUTES:
                return REAL_HTML_ATTRIBUTES_EDEFAULT == null ? realHtmlAttributes != null : !REAL_HTML_ATTRIBUTES_EDEFAULT.equals(realHtmlAttributes);
            case FormPackage.TABLE__DEPEND_ON:
                return dependOn != null && !dependOn.isEmpty();
            case FormPackage.TABLE__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                return displayDependentWidgetOnlyOnEventTriggered != DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED_EDEFAULT;
            case FormPackage.TABLE__SCRIPT_AFTER_EVENT:
                return scriptAfterEvent != null;
            case FormPackage.TABLE__PARENT_OF:
                return parentOf != null && !parentOf.isEmpty();
            case FormPackage.TABLE__MANDATORY:
                return mandatory != MANDATORY_EDEFAULT;
            case FormPackage.TABLE__READ_ONLY:
                return readOnly != READ_ONLY_EDEFAULT;
            case FormPackage.TABLE__LABEL_POSITION:
                return labelPosition != LABEL_POSITION_EDEFAULT;
            case FormPackage.TABLE__INPUT_CONNECTORS:
                return inputConnectors != null && !inputConnectors.isEmpty();
            case FormPackage.TABLE__OUTPUT_CONNECTORS:
                return outputConnectors != null && !outputConnectors.isEmpty();
            case FormPackage.TABLE__AFTER_EVENT_CONNECTORS:
                return afterEventConnectors != null && !afterEventConnectors.isEmpty();
            case FormPackage.TABLE__LEFT_COLUMN_IS_HEADER:
                return leftColumnIsHeader != LEFT_COLUMN_IS_HEADER_EDEFAULT;
            case FormPackage.TABLE__RIGHT_COLUMN_IS_HEADER:
                return rightColumnIsHeader != RIGHT_COLUMN_IS_HEADER_EDEFAULT;
            case FormPackage.TABLE__FIRST_ROW_IS_HEADER:
                return firstRowIsHeader != FIRST_ROW_IS_HEADER_EDEFAULT;
            case FormPackage.TABLE__LAST_ROW_IS_HEADER:
                return lastRowIsHeader != LAST_ROW_IS_HEADER_EDEFAULT;
            case FormPackage.TABLE__INITIALIZED_USING_CELLS:
                return initializedUsingCells != INITIALIZED_USING_CELLS_EDEFAULT;
            case FormPackage.TABLE__CELLS:
                return CELLS_EDEFAULT == null ? cells != null : !CELLS_EDEFAULT.equals(cells);
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
        result.append(", leftColumnIsHeader: "); //$NON-NLS-1$
        result.append(leftColumnIsHeader);
        result.append(", rightColumnIsHeader: "); //$NON-NLS-1$
        result.append(rightColumnIsHeader);
        result.append(", firstRowIsHeader: "); //$NON-NLS-1$
        result.append(firstRowIsHeader);
        result.append(", LastRowIsHeader: "); //$NON-NLS-1$
        result.append(lastRowIsHeader);
        result.append(", initializedUsingCells: "); //$NON-NLS-1$
        result.append(initializedUsingCells);
        result.append(", cells: "); //$NON-NLS-1$
        result.append(cells);
        result.append(')');
        return result.toString();
    }

} //TableImpl
