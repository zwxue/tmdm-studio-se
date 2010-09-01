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

import org.talend.process.model.form.Column;
import org.talend.process.model.form.Duplicable;
import org.talend.process.model.form.FormPackage;
import org.talend.process.model.form.GroovyScript;
import org.talend.process.model.form.Group;
import org.talend.process.model.form.LabelPosition;
import org.talend.process.model.form.Line;
import org.talend.process.model.form.Widget;
import org.talend.process.model.form.WidgetDependency;
import org.talend.process.model.form.WidgetLayoutInfo;

import org.talend.process.model.process.Connector;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.TextAnnotationAttachment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getTextAnnotationAttachment <em>Text Annotation Attachment</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getScript <em>Script</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getTooltip <em>Tooltip</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getWidgetLayoutInfo <em>Widget Layout Info</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getDisplayLabel <em>Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getShowDisplayLabel <em>Show Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#isAllowHTMLForDisplayLabel <em>Allow HTML For Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getHtmlAttributes <em>Html Attributes</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getRealHtmlAttributes <em>Real Html Attributes</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getDependOn <em>Depend On</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#isDisplayDependentWidgetOnlyOnEventTriggered <em>Display Dependent Widget Only On Event Triggered</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getScriptAfterEvent <em>Script After Event</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getParentOf <em>Parent Of</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getLabelPosition <em>Label Position</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getInputConnectors <em>Input Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getOutputConnectors <em>Output Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getAfterEventConnectors <em>After Event Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#isDuplicate <em>Duplicate</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#isLimitNumberOfDuplication <em>Limit Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getMaxNumberOfDuplication <em>Max Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#isLimitMinNumberOfDuplication <em>Limit Min Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getMinNumberOfDuplication <em>Min Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getDisplayLabelForAdd <em>Display Label For Add</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getTooltipForAdd <em>Tooltip For Add</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getDisplayLabelForRemove <em>Display Label For Remove</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getTooltipForRemove <em>Tooltip For Remove</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getWidgets <em>Widgets</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#isShowBorder <em>Show Border</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroupImpl#getLines <em>Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupImpl extends EObjectImpl implements Group {
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
     * The default value of the '{@link #isDuplicate() <em>Duplicate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDuplicate()
     * @generated
     * @ordered
     */
    protected static final boolean DUPLICATE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDuplicate() <em>Duplicate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDuplicate()
     * @generated
     * @ordered
     */
    protected boolean duplicate = DUPLICATE_EDEFAULT;

    /**
     * The default value of the '{@link #isLimitNumberOfDuplication() <em>Limit Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLimitNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected static final boolean LIMIT_NUMBER_OF_DUPLICATION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isLimitNumberOfDuplication() <em>Limit Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLimitNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected boolean limitNumberOfDuplication = LIMIT_NUMBER_OF_DUPLICATION_EDEFAULT;

    /**
     * The default value of the '{@link #getMaxNumberOfDuplication() <em>Max Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected static final String MAX_NUMBER_OF_DUPLICATION_EDEFAULT = "10"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getMaxNumberOfDuplication() <em>Max Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected String maxNumberOfDuplication = MAX_NUMBER_OF_DUPLICATION_EDEFAULT;

    /**
     * The default value of the '{@link #isLimitMinNumberOfDuplication() <em>Limit Min Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLimitMinNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected static final boolean LIMIT_MIN_NUMBER_OF_DUPLICATION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isLimitMinNumberOfDuplication() <em>Limit Min Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLimitMinNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected boolean limitMinNumberOfDuplication = LIMIT_MIN_NUMBER_OF_DUPLICATION_EDEFAULT;

    /**
     * The default value of the '{@link #getMinNumberOfDuplication() <em>Min Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMinNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected static final String MIN_NUMBER_OF_DUPLICATION_EDEFAULT = "2"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getMinNumberOfDuplication() <em>Min Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMinNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected String minNumberOfDuplication = MIN_NUMBER_OF_DUPLICATION_EDEFAULT;

    /**
     * The default value of the '{@link #getDisplayLabelForAdd() <em>Display Label For Add</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayLabelForAdd()
     * @generated
     * @ordered
     */
    protected static final String DISPLAY_LABEL_FOR_ADD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDisplayLabelForAdd() <em>Display Label For Add</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayLabelForAdd()
     * @generated
     * @ordered
     */
    protected String displayLabelForAdd = DISPLAY_LABEL_FOR_ADD_EDEFAULT;

    /**
     * The default value of the '{@link #getTooltipForAdd() <em>Tooltip For Add</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTooltipForAdd()
     * @generated
     * @ordered
     */
    protected static final String TOOLTIP_FOR_ADD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTooltipForAdd() <em>Tooltip For Add</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTooltipForAdd()
     * @generated
     * @ordered
     */
    protected String tooltipForAdd = TOOLTIP_FOR_ADD_EDEFAULT;

    /**
     * The default value of the '{@link #getDisplayLabelForRemove() <em>Display Label For Remove</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayLabelForRemove()
     * @generated
     * @ordered
     */
    protected static final String DISPLAY_LABEL_FOR_REMOVE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDisplayLabelForRemove() <em>Display Label For Remove</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayLabelForRemove()
     * @generated
     * @ordered
     */
    protected String displayLabelForRemove = DISPLAY_LABEL_FOR_REMOVE_EDEFAULT;

    /**
     * The default value of the '{@link #getTooltipForRemove() <em>Tooltip For Remove</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTooltipForRemove()
     * @generated
     * @ordered
     */
    protected static final String TOOLTIP_FOR_REMOVE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTooltipForRemove() <em>Tooltip For Remove</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTooltipForRemove()
     * @generated
     * @ordered
     */
    protected String tooltipForRemove = TOOLTIP_FOR_REMOVE_EDEFAULT;

    /**
     * The cached value of the '{@link #getWidgets() <em>Widgets</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidgets()
     * @generated
     * @ordered
     */
    protected EList<Widget> widgets;

    /**
     * The default value of the '{@link #isShowBorder() <em>Show Border</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isShowBorder()
     * @generated
     * @ordered
     */
    protected static final boolean SHOW_BORDER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isShowBorder() <em>Show Border</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isShowBorder()
     * @generated
     * @ordered
     */
    protected boolean showBorder = SHOW_BORDER_EDEFAULT;

    /**
     * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumns()
     * @generated
     * @ordered
     */
    protected EList<Column> columns;

    /**
     * The cached value of the '{@link #getLines() <em>Lines</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLines()
     * @generated
     * @ordered
     */
    protected EList<Line> lines;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GroupImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FormPackage.Literals.GROUP;
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__DOCUMENTATION, oldDocumentation, documentation));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TextAnnotationAttachment> getTextAnnotationAttachment() {
        if (textAnnotationAttachment == null) {
            textAnnotationAttachment = new EObjectContainmentWithInverseEList<TextAnnotationAttachment>(TextAnnotationAttachment.class, this, FormPackage.GROUP__TEXT_ANNOTATION_ATTACHMENT, ProcessPackage.TEXT_ANNOTATION_ATTACHMENT__TARGET);
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__SCRIPT, oldScript, newScript);
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
                msgs = ((InternalEObject)script).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormPackage.GROUP__SCRIPT, null, msgs);
            if (newScript != null)
                msgs = ((InternalEObject)newScript).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormPackage.GROUP__SCRIPT, null, msgs);
            msgs = basicSetScript(newScript, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__SCRIPT, newScript, newScript));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__TOOLTIP, oldTooltip, tooltip));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__WIDGET_LAYOUT_INFO, oldWidgetLayoutInfo, newWidgetLayoutInfo);
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
                msgs = ((InternalEObject)widgetLayoutInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormPackage.GROUP__WIDGET_LAYOUT_INFO, null, msgs);
            if (newWidgetLayoutInfo != null)
                msgs = ((InternalEObject)newWidgetLayoutInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormPackage.GROUP__WIDGET_LAYOUT_INFO, null, msgs);
            msgs = basicSetWidgetLayoutInfo(newWidgetLayoutInfo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__WIDGET_LAYOUT_INFO, newWidgetLayoutInfo, newWidgetLayoutInfo));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__DISPLAY_LABEL, oldDisplayLabel, displayLabel));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__SHOW_DISPLAY_LABEL, oldShowDisplayLabel, showDisplayLabel));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__ALLOW_HTML_FOR_DISPLAY_LABEL, oldAllowHTMLForDisplayLabel, allowHTMLForDisplayLabel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getHtmlAttributes() {
        if (htmlAttributes == null) {
            htmlAttributes = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, FormPackage.GROUP__HTML_ATTRIBUTES);
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__REAL_HTML_ATTRIBUTES, oldRealHtmlAttributes, realHtmlAttributes));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WidgetDependency> getDependOn() {
        if (dependOn == null) {
            dependOn = new EObjectContainmentEList<WidgetDependency>(WidgetDependency.class, this, FormPackage.GROUP__DEPEND_ON);
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED, oldDisplayDependentWidgetOnlyOnEventTriggered, displayDependentWidgetOnlyOnEventTriggered));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__SCRIPT_AFTER_EVENT, oldScriptAfterEvent, newScriptAfterEvent);
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
                msgs = ((InternalEObject)scriptAfterEvent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormPackage.GROUP__SCRIPT_AFTER_EVENT, null, msgs);
            if (newScriptAfterEvent != null)
                msgs = ((InternalEObject)newScriptAfterEvent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormPackage.GROUP__SCRIPT_AFTER_EVENT, null, msgs);
            msgs = basicSetScriptAfterEvent(newScriptAfterEvent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__SCRIPT_AFTER_EVENT, newScriptAfterEvent, newScriptAfterEvent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WidgetDependency> getParentOf() {
        if (parentOf == null) {
            parentOf = new EObjectContainmentEList<WidgetDependency>(WidgetDependency.class, this, FormPackage.GROUP__PARENT_OF);
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__MANDATORY, oldMandatory, mandatory));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__READ_ONLY, oldReadOnly, readOnly));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__LABEL_POSITION, oldLabelPosition, labelPosition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getInputConnectors() {
        if (inputConnectors == null) {
            inputConnectors = new EObjectContainmentEList<Connector>(Connector.class, this, FormPackage.GROUP__INPUT_CONNECTORS);
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
            outputConnectors = new EObjectContainmentEList<Connector>(Connector.class, this, FormPackage.GROUP__OUTPUT_CONNECTORS);
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
            afterEventConnectors = new EObjectContainmentEList<Connector>(Connector.class, this, FormPackage.GROUP__AFTER_EVENT_CONNECTORS);
        }
        return afterEventConnectors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDuplicate() {
        return duplicate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDuplicate(boolean newDuplicate) {
        boolean oldDuplicate = duplicate;
        duplicate = newDuplicate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__DUPLICATE, oldDuplicate, duplicate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isLimitNumberOfDuplication() {
        return limitNumberOfDuplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLimitNumberOfDuplication(boolean newLimitNumberOfDuplication) {
        boolean oldLimitNumberOfDuplication = limitNumberOfDuplication;
        limitNumberOfDuplication = newLimitNumberOfDuplication;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__LIMIT_NUMBER_OF_DUPLICATION, oldLimitNumberOfDuplication, limitNumberOfDuplication));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMaxNumberOfDuplication() {
        return maxNumberOfDuplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMaxNumberOfDuplication(String newMaxNumberOfDuplication) {
        String oldMaxNumberOfDuplication = maxNumberOfDuplication;
        maxNumberOfDuplication = newMaxNumberOfDuplication;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__MAX_NUMBER_OF_DUPLICATION, oldMaxNumberOfDuplication, maxNumberOfDuplication));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isLimitMinNumberOfDuplication() {
        return limitMinNumberOfDuplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLimitMinNumberOfDuplication(boolean newLimitMinNumberOfDuplication) {
        boolean oldLimitMinNumberOfDuplication = limitMinNumberOfDuplication;
        limitMinNumberOfDuplication = newLimitMinNumberOfDuplication;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__LIMIT_MIN_NUMBER_OF_DUPLICATION, oldLimitMinNumberOfDuplication, limitMinNumberOfDuplication));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMinNumberOfDuplication() {
        return minNumberOfDuplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMinNumberOfDuplication(String newMinNumberOfDuplication) {
        String oldMinNumberOfDuplication = minNumberOfDuplication;
        minNumberOfDuplication = newMinNumberOfDuplication;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__MIN_NUMBER_OF_DUPLICATION, oldMinNumberOfDuplication, minNumberOfDuplication));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDisplayLabelForAdd() {
        return displayLabelForAdd;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDisplayLabelForAdd(String newDisplayLabelForAdd) {
        String oldDisplayLabelForAdd = displayLabelForAdd;
        displayLabelForAdd = newDisplayLabelForAdd;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__DISPLAY_LABEL_FOR_ADD, oldDisplayLabelForAdd, displayLabelForAdd));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTooltipForAdd() {
        return tooltipForAdd;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTooltipForAdd(String newTooltipForAdd) {
        String oldTooltipForAdd = tooltipForAdd;
        tooltipForAdd = newTooltipForAdd;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__TOOLTIP_FOR_ADD, oldTooltipForAdd, tooltipForAdd));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDisplayLabelForRemove() {
        return displayLabelForRemove;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDisplayLabelForRemove(String newDisplayLabelForRemove) {
        String oldDisplayLabelForRemove = displayLabelForRemove;
        displayLabelForRemove = newDisplayLabelForRemove;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__DISPLAY_LABEL_FOR_REMOVE, oldDisplayLabelForRemove, displayLabelForRemove));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTooltipForRemove() {
        return tooltipForRemove;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTooltipForRemove(String newTooltipForRemove) {
        String oldTooltipForRemove = tooltipForRemove;
        tooltipForRemove = newTooltipForRemove;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__TOOLTIP_FOR_REMOVE, oldTooltipForRemove, tooltipForRemove));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Widget> getWidgets() {
        if (widgets == null) {
            widgets = new EObjectContainmentEList<Widget>(Widget.class, this, FormPackage.GROUP__WIDGETS);
        }
        return widgets;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isShowBorder() {
        return showBorder;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShowBorder(boolean newShowBorder) {
        boolean oldShowBorder = showBorder;
        showBorder = newShowBorder;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROUP__SHOW_BORDER, oldShowBorder, showBorder));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Column> getColumns() {
        if (columns == null) {
            columns = new EObjectContainmentEList<Column>(Column.class, this, FormPackage.GROUP__COLUMNS);
        }
        return columns;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Line> getLines() {
        if (lines == null) {
            lines = new EObjectContainmentEList<Line>(Line.class, this, FormPackage.GROUP__LINES);
        }
        return lines;
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
            case FormPackage.GROUP__TEXT_ANNOTATION_ATTACHMENT:
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
            case FormPackage.GROUP__TEXT_ANNOTATION_ATTACHMENT:
                return ((InternalEList<?>)getTextAnnotationAttachment()).basicRemove(otherEnd, msgs);
            case FormPackage.GROUP__SCRIPT:
                return basicSetScript(null, msgs);
            case FormPackage.GROUP__WIDGET_LAYOUT_INFO:
                return basicSetWidgetLayoutInfo(null, msgs);
            case FormPackage.GROUP__HTML_ATTRIBUTES:
                return ((InternalEList<?>)getHtmlAttributes()).basicRemove(otherEnd, msgs);
            case FormPackage.GROUP__DEPEND_ON:
                return ((InternalEList<?>)getDependOn()).basicRemove(otherEnd, msgs);
            case FormPackage.GROUP__SCRIPT_AFTER_EVENT:
                return basicSetScriptAfterEvent(null, msgs);
            case FormPackage.GROUP__PARENT_OF:
                return ((InternalEList<?>)getParentOf()).basicRemove(otherEnd, msgs);
            case FormPackage.GROUP__INPUT_CONNECTORS:
                return ((InternalEList<?>)getInputConnectors()).basicRemove(otherEnd, msgs);
            case FormPackage.GROUP__OUTPUT_CONNECTORS:
                return ((InternalEList<?>)getOutputConnectors()).basicRemove(otherEnd, msgs);
            case FormPackage.GROUP__AFTER_EVENT_CONNECTORS:
                return ((InternalEList<?>)getAfterEventConnectors()).basicRemove(otherEnd, msgs);
            case FormPackage.GROUP__WIDGETS:
                return ((InternalEList<?>)getWidgets()).basicRemove(otherEnd, msgs);
            case FormPackage.GROUP__COLUMNS:
                return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
            case FormPackage.GROUP__LINES:
                return ((InternalEList<?>)getLines()).basicRemove(otherEnd, msgs);
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
            case FormPackage.GROUP__DOCUMENTATION:
                return getDocumentation();
            case FormPackage.GROUP__NAME:
                return getName();
            case FormPackage.GROUP__LABEL:
                return getLabel();
            case FormPackage.GROUP__TEXT_ANNOTATION_ATTACHMENT:
                return getTextAnnotationAttachment();
            case FormPackage.GROUP__SCRIPT:
                return getScript();
            case FormPackage.GROUP__TOOLTIP:
                return getTooltip();
            case FormPackage.GROUP__WIDGET_LAYOUT_INFO:
                return getWidgetLayoutInfo();
            case FormPackage.GROUP__DISPLAY_LABEL:
                return getDisplayLabel();
            case FormPackage.GROUP__SHOW_DISPLAY_LABEL:
                return getShowDisplayLabel();
            case FormPackage.GROUP__ALLOW_HTML_FOR_DISPLAY_LABEL:
                return isAllowHTMLForDisplayLabel();
            case FormPackage.GROUP__HTML_ATTRIBUTES:
                if (coreType) return getHtmlAttributes();
                else return getHtmlAttributes().map();
            case FormPackage.GROUP__REAL_HTML_ATTRIBUTES:
                return getRealHtmlAttributes();
            case FormPackage.GROUP__DEPEND_ON:
                return getDependOn();
            case FormPackage.GROUP__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                return isDisplayDependentWidgetOnlyOnEventTriggered();
            case FormPackage.GROUP__SCRIPT_AFTER_EVENT:
                return getScriptAfterEvent();
            case FormPackage.GROUP__PARENT_OF:
                return getParentOf();
            case FormPackage.GROUP__MANDATORY:
                return isMandatory();
            case FormPackage.GROUP__READ_ONLY:
                return isReadOnly();
            case FormPackage.GROUP__LABEL_POSITION:
                return getLabelPosition();
            case FormPackage.GROUP__INPUT_CONNECTORS:
                return getInputConnectors();
            case FormPackage.GROUP__OUTPUT_CONNECTORS:
                return getOutputConnectors();
            case FormPackage.GROUP__AFTER_EVENT_CONNECTORS:
                return getAfterEventConnectors();
            case FormPackage.GROUP__DUPLICATE:
                return isDuplicate();
            case FormPackage.GROUP__LIMIT_NUMBER_OF_DUPLICATION:
                return isLimitNumberOfDuplication();
            case FormPackage.GROUP__MAX_NUMBER_OF_DUPLICATION:
                return getMaxNumberOfDuplication();
            case FormPackage.GROUP__LIMIT_MIN_NUMBER_OF_DUPLICATION:
                return isLimitMinNumberOfDuplication();
            case FormPackage.GROUP__MIN_NUMBER_OF_DUPLICATION:
                return getMinNumberOfDuplication();
            case FormPackage.GROUP__DISPLAY_LABEL_FOR_ADD:
                return getDisplayLabelForAdd();
            case FormPackage.GROUP__TOOLTIP_FOR_ADD:
                return getTooltipForAdd();
            case FormPackage.GROUP__DISPLAY_LABEL_FOR_REMOVE:
                return getDisplayLabelForRemove();
            case FormPackage.GROUP__TOOLTIP_FOR_REMOVE:
                return getTooltipForRemove();
            case FormPackage.GROUP__WIDGETS:
                return getWidgets();
            case FormPackage.GROUP__SHOW_BORDER:
                return isShowBorder();
            case FormPackage.GROUP__COLUMNS:
                return getColumns();
            case FormPackage.GROUP__LINES:
                return getLines();
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
            case FormPackage.GROUP__DOCUMENTATION:
                setDocumentation((String)newValue);
                return;
            case FormPackage.GROUP__NAME:
                setName((String)newValue);
                return;
            case FormPackage.GROUP__LABEL:
                setLabel((String)newValue);
                return;
            case FormPackage.GROUP__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                getTextAnnotationAttachment().addAll((Collection<? extends TextAnnotationAttachment>)newValue);
                return;
            case FormPackage.GROUP__SCRIPT:
                setScript((GroovyScript)newValue);
                return;
            case FormPackage.GROUP__TOOLTIP:
                setTooltip((String)newValue);
                return;
            case FormPackage.GROUP__WIDGET_LAYOUT_INFO:
                setWidgetLayoutInfo((WidgetLayoutInfo)newValue);
                return;
            case FormPackage.GROUP__DISPLAY_LABEL:
                setDisplayLabel((String)newValue);
                return;
            case FormPackage.GROUP__SHOW_DISPLAY_LABEL:
                setShowDisplayLabel((Boolean)newValue);
                return;
            case FormPackage.GROUP__ALLOW_HTML_FOR_DISPLAY_LABEL:
                setAllowHTMLForDisplayLabel((Boolean)newValue);
                return;
            case FormPackage.GROUP__HTML_ATTRIBUTES:
                ((EStructuralFeature.Setting)getHtmlAttributes()).set(newValue);
                return;
            case FormPackage.GROUP__REAL_HTML_ATTRIBUTES:
                setRealHtmlAttributes((String)newValue);
                return;
            case FormPackage.GROUP__DEPEND_ON:
                getDependOn().clear();
                getDependOn().addAll((Collection<? extends WidgetDependency>)newValue);
                return;
            case FormPackage.GROUP__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                setDisplayDependentWidgetOnlyOnEventTriggered((Boolean)newValue);
                return;
            case FormPackage.GROUP__SCRIPT_AFTER_EVENT:
                setScriptAfterEvent((GroovyScript)newValue);
                return;
            case FormPackage.GROUP__PARENT_OF:
                getParentOf().clear();
                getParentOf().addAll((Collection<? extends WidgetDependency>)newValue);
                return;
            case FormPackage.GROUP__MANDATORY:
                setMandatory((Boolean)newValue);
                return;
            case FormPackage.GROUP__READ_ONLY:
                setReadOnly((Boolean)newValue);
                return;
            case FormPackage.GROUP__LABEL_POSITION:
                setLabelPosition((LabelPosition)newValue);
                return;
            case FormPackage.GROUP__INPUT_CONNECTORS:
                getInputConnectors().clear();
                getInputConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case FormPackage.GROUP__OUTPUT_CONNECTORS:
                getOutputConnectors().clear();
                getOutputConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case FormPackage.GROUP__AFTER_EVENT_CONNECTORS:
                getAfterEventConnectors().clear();
                getAfterEventConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case FormPackage.GROUP__DUPLICATE:
                setDuplicate((Boolean)newValue);
                return;
            case FormPackage.GROUP__LIMIT_NUMBER_OF_DUPLICATION:
                setLimitNumberOfDuplication((Boolean)newValue);
                return;
            case FormPackage.GROUP__MAX_NUMBER_OF_DUPLICATION:
                setMaxNumberOfDuplication((String)newValue);
                return;
            case FormPackage.GROUP__LIMIT_MIN_NUMBER_OF_DUPLICATION:
                setLimitMinNumberOfDuplication((Boolean)newValue);
                return;
            case FormPackage.GROUP__MIN_NUMBER_OF_DUPLICATION:
                setMinNumberOfDuplication((String)newValue);
                return;
            case FormPackage.GROUP__DISPLAY_LABEL_FOR_ADD:
                setDisplayLabelForAdd((String)newValue);
                return;
            case FormPackage.GROUP__TOOLTIP_FOR_ADD:
                setTooltipForAdd((String)newValue);
                return;
            case FormPackage.GROUP__DISPLAY_LABEL_FOR_REMOVE:
                setDisplayLabelForRemove((String)newValue);
                return;
            case FormPackage.GROUP__TOOLTIP_FOR_REMOVE:
                setTooltipForRemove((String)newValue);
                return;
            case FormPackage.GROUP__WIDGETS:
                getWidgets().clear();
                getWidgets().addAll((Collection<? extends Widget>)newValue);
                return;
            case FormPackage.GROUP__SHOW_BORDER:
                setShowBorder((Boolean)newValue);
                return;
            case FormPackage.GROUP__COLUMNS:
                getColumns().clear();
                getColumns().addAll((Collection<? extends Column>)newValue);
                return;
            case FormPackage.GROUP__LINES:
                getLines().clear();
                getLines().addAll((Collection<? extends Line>)newValue);
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
            case FormPackage.GROUP__DOCUMENTATION:
                setDocumentation(DOCUMENTATION_EDEFAULT);
                return;
            case FormPackage.GROUP__NAME:
                setName(NAME_EDEFAULT);
                return;
            case FormPackage.GROUP__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case FormPackage.GROUP__TEXT_ANNOTATION_ATTACHMENT:
                getTextAnnotationAttachment().clear();
                return;
            case FormPackage.GROUP__SCRIPT:
                setScript((GroovyScript)null);
                return;
            case FormPackage.GROUP__TOOLTIP:
                setTooltip(TOOLTIP_EDEFAULT);
                return;
            case FormPackage.GROUP__WIDGET_LAYOUT_INFO:
                setWidgetLayoutInfo((WidgetLayoutInfo)null);
                return;
            case FormPackage.GROUP__DISPLAY_LABEL:
                setDisplayLabel(DISPLAY_LABEL_EDEFAULT);
                return;
            case FormPackage.GROUP__SHOW_DISPLAY_LABEL:
                setShowDisplayLabel(SHOW_DISPLAY_LABEL_EDEFAULT);
                return;
            case FormPackage.GROUP__ALLOW_HTML_FOR_DISPLAY_LABEL:
                setAllowHTMLForDisplayLabel(ALLOW_HTML_FOR_DISPLAY_LABEL_EDEFAULT);
                return;
            case FormPackage.GROUP__HTML_ATTRIBUTES:
                getHtmlAttributes().clear();
                return;
            case FormPackage.GROUP__REAL_HTML_ATTRIBUTES:
                setRealHtmlAttributes(REAL_HTML_ATTRIBUTES_EDEFAULT);
                return;
            case FormPackage.GROUP__DEPEND_ON:
                getDependOn().clear();
                return;
            case FormPackage.GROUP__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                setDisplayDependentWidgetOnlyOnEventTriggered(DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED_EDEFAULT);
                return;
            case FormPackage.GROUP__SCRIPT_AFTER_EVENT:
                setScriptAfterEvent((GroovyScript)null);
                return;
            case FormPackage.GROUP__PARENT_OF:
                getParentOf().clear();
                return;
            case FormPackage.GROUP__MANDATORY:
                setMandatory(MANDATORY_EDEFAULT);
                return;
            case FormPackage.GROUP__READ_ONLY:
                setReadOnly(READ_ONLY_EDEFAULT);
                return;
            case FormPackage.GROUP__LABEL_POSITION:
                setLabelPosition(LABEL_POSITION_EDEFAULT);
                return;
            case FormPackage.GROUP__INPUT_CONNECTORS:
                getInputConnectors().clear();
                return;
            case FormPackage.GROUP__OUTPUT_CONNECTORS:
                getOutputConnectors().clear();
                return;
            case FormPackage.GROUP__AFTER_EVENT_CONNECTORS:
                getAfterEventConnectors().clear();
                return;
            case FormPackage.GROUP__DUPLICATE:
                setDuplicate(DUPLICATE_EDEFAULT);
                return;
            case FormPackage.GROUP__LIMIT_NUMBER_OF_DUPLICATION:
                setLimitNumberOfDuplication(LIMIT_NUMBER_OF_DUPLICATION_EDEFAULT);
                return;
            case FormPackage.GROUP__MAX_NUMBER_OF_DUPLICATION:
                setMaxNumberOfDuplication(MAX_NUMBER_OF_DUPLICATION_EDEFAULT);
                return;
            case FormPackage.GROUP__LIMIT_MIN_NUMBER_OF_DUPLICATION:
                setLimitMinNumberOfDuplication(LIMIT_MIN_NUMBER_OF_DUPLICATION_EDEFAULT);
                return;
            case FormPackage.GROUP__MIN_NUMBER_OF_DUPLICATION:
                setMinNumberOfDuplication(MIN_NUMBER_OF_DUPLICATION_EDEFAULT);
                return;
            case FormPackage.GROUP__DISPLAY_LABEL_FOR_ADD:
                setDisplayLabelForAdd(DISPLAY_LABEL_FOR_ADD_EDEFAULT);
                return;
            case FormPackage.GROUP__TOOLTIP_FOR_ADD:
                setTooltipForAdd(TOOLTIP_FOR_ADD_EDEFAULT);
                return;
            case FormPackage.GROUP__DISPLAY_LABEL_FOR_REMOVE:
                setDisplayLabelForRemove(DISPLAY_LABEL_FOR_REMOVE_EDEFAULT);
                return;
            case FormPackage.GROUP__TOOLTIP_FOR_REMOVE:
                setTooltipForRemove(TOOLTIP_FOR_REMOVE_EDEFAULT);
                return;
            case FormPackage.GROUP__WIDGETS:
                getWidgets().clear();
                return;
            case FormPackage.GROUP__SHOW_BORDER:
                setShowBorder(SHOW_BORDER_EDEFAULT);
                return;
            case FormPackage.GROUP__COLUMNS:
                getColumns().clear();
                return;
            case FormPackage.GROUP__LINES:
                getLines().clear();
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
            case FormPackage.GROUP__DOCUMENTATION:
                return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
            case FormPackage.GROUP__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case FormPackage.GROUP__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case FormPackage.GROUP__TEXT_ANNOTATION_ATTACHMENT:
                return textAnnotationAttachment != null && !textAnnotationAttachment.isEmpty();
            case FormPackage.GROUP__SCRIPT:
                return script != null;
            case FormPackage.GROUP__TOOLTIP:
                return TOOLTIP_EDEFAULT == null ? tooltip != null : !TOOLTIP_EDEFAULT.equals(tooltip);
            case FormPackage.GROUP__WIDGET_LAYOUT_INFO:
                return widgetLayoutInfo != null;
            case FormPackage.GROUP__DISPLAY_LABEL:
                return DISPLAY_LABEL_EDEFAULT == null ? displayLabel != null : !DISPLAY_LABEL_EDEFAULT.equals(displayLabel);
            case FormPackage.GROUP__SHOW_DISPLAY_LABEL:
                return SHOW_DISPLAY_LABEL_EDEFAULT == null ? showDisplayLabel != null : !SHOW_DISPLAY_LABEL_EDEFAULT.equals(showDisplayLabel);
            case FormPackage.GROUP__ALLOW_HTML_FOR_DISPLAY_LABEL:
                return allowHTMLForDisplayLabel != ALLOW_HTML_FOR_DISPLAY_LABEL_EDEFAULT;
            case FormPackage.GROUP__HTML_ATTRIBUTES:
                return htmlAttributes != null && !htmlAttributes.isEmpty();
            case FormPackage.GROUP__REAL_HTML_ATTRIBUTES:
                return REAL_HTML_ATTRIBUTES_EDEFAULT == null ? realHtmlAttributes != null : !REAL_HTML_ATTRIBUTES_EDEFAULT.equals(realHtmlAttributes);
            case FormPackage.GROUP__DEPEND_ON:
                return dependOn != null && !dependOn.isEmpty();
            case FormPackage.GROUP__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED:
                return displayDependentWidgetOnlyOnEventTriggered != DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED_EDEFAULT;
            case FormPackage.GROUP__SCRIPT_AFTER_EVENT:
                return scriptAfterEvent != null;
            case FormPackage.GROUP__PARENT_OF:
                return parentOf != null && !parentOf.isEmpty();
            case FormPackage.GROUP__MANDATORY:
                return mandatory != MANDATORY_EDEFAULT;
            case FormPackage.GROUP__READ_ONLY:
                return readOnly != READ_ONLY_EDEFAULT;
            case FormPackage.GROUP__LABEL_POSITION:
                return labelPosition != LABEL_POSITION_EDEFAULT;
            case FormPackage.GROUP__INPUT_CONNECTORS:
                return inputConnectors != null && !inputConnectors.isEmpty();
            case FormPackage.GROUP__OUTPUT_CONNECTORS:
                return outputConnectors != null && !outputConnectors.isEmpty();
            case FormPackage.GROUP__AFTER_EVENT_CONNECTORS:
                return afterEventConnectors != null && !afterEventConnectors.isEmpty();
            case FormPackage.GROUP__DUPLICATE:
                return duplicate != DUPLICATE_EDEFAULT;
            case FormPackage.GROUP__LIMIT_NUMBER_OF_DUPLICATION:
                return limitNumberOfDuplication != LIMIT_NUMBER_OF_DUPLICATION_EDEFAULT;
            case FormPackage.GROUP__MAX_NUMBER_OF_DUPLICATION:
                return MAX_NUMBER_OF_DUPLICATION_EDEFAULT == null ? maxNumberOfDuplication != null : !MAX_NUMBER_OF_DUPLICATION_EDEFAULT.equals(maxNumberOfDuplication);
            case FormPackage.GROUP__LIMIT_MIN_NUMBER_OF_DUPLICATION:
                return limitMinNumberOfDuplication != LIMIT_MIN_NUMBER_OF_DUPLICATION_EDEFAULT;
            case FormPackage.GROUP__MIN_NUMBER_OF_DUPLICATION:
                return MIN_NUMBER_OF_DUPLICATION_EDEFAULT == null ? minNumberOfDuplication != null : !MIN_NUMBER_OF_DUPLICATION_EDEFAULT.equals(minNumberOfDuplication);
            case FormPackage.GROUP__DISPLAY_LABEL_FOR_ADD:
                return DISPLAY_LABEL_FOR_ADD_EDEFAULT == null ? displayLabelForAdd != null : !DISPLAY_LABEL_FOR_ADD_EDEFAULT.equals(displayLabelForAdd);
            case FormPackage.GROUP__TOOLTIP_FOR_ADD:
                return TOOLTIP_FOR_ADD_EDEFAULT == null ? tooltipForAdd != null : !TOOLTIP_FOR_ADD_EDEFAULT.equals(tooltipForAdd);
            case FormPackage.GROUP__DISPLAY_LABEL_FOR_REMOVE:
                return DISPLAY_LABEL_FOR_REMOVE_EDEFAULT == null ? displayLabelForRemove != null : !DISPLAY_LABEL_FOR_REMOVE_EDEFAULT.equals(displayLabelForRemove);
            case FormPackage.GROUP__TOOLTIP_FOR_REMOVE:
                return TOOLTIP_FOR_REMOVE_EDEFAULT == null ? tooltipForRemove != null : !TOOLTIP_FOR_REMOVE_EDEFAULT.equals(tooltipForRemove);
            case FormPackage.GROUP__WIDGETS:
                return widgets != null && !widgets.isEmpty();
            case FormPackage.GROUP__SHOW_BORDER:
                return showBorder != SHOW_BORDER_EDEFAULT;
            case FormPackage.GROUP__COLUMNS:
                return columns != null && !columns.isEmpty();
            case FormPackage.GROUP__LINES:
                return lines != null && !lines.isEmpty();
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
        if (baseClass == Duplicable.class) {
            switch (derivedFeatureID) {
                case FormPackage.GROUP__DUPLICATE: return FormPackage.DUPLICABLE__DUPLICATE;
                case FormPackage.GROUP__LIMIT_NUMBER_OF_DUPLICATION: return FormPackage.DUPLICABLE__LIMIT_NUMBER_OF_DUPLICATION;
                case FormPackage.GROUP__MAX_NUMBER_OF_DUPLICATION: return FormPackage.DUPLICABLE__MAX_NUMBER_OF_DUPLICATION;
                case FormPackage.GROUP__LIMIT_MIN_NUMBER_OF_DUPLICATION: return FormPackage.DUPLICABLE__LIMIT_MIN_NUMBER_OF_DUPLICATION;
                case FormPackage.GROUP__MIN_NUMBER_OF_DUPLICATION: return FormPackage.DUPLICABLE__MIN_NUMBER_OF_DUPLICATION;
                case FormPackage.GROUP__DISPLAY_LABEL_FOR_ADD: return FormPackage.DUPLICABLE__DISPLAY_LABEL_FOR_ADD;
                case FormPackage.GROUP__TOOLTIP_FOR_ADD: return FormPackage.DUPLICABLE__TOOLTIP_FOR_ADD;
                case FormPackage.GROUP__DISPLAY_LABEL_FOR_REMOVE: return FormPackage.DUPLICABLE__DISPLAY_LABEL_FOR_REMOVE;
                case FormPackage.GROUP__TOOLTIP_FOR_REMOVE: return FormPackage.DUPLICABLE__TOOLTIP_FOR_REMOVE;
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
        if (baseClass == Duplicable.class) {
            switch (baseFeatureID) {
                case FormPackage.DUPLICABLE__DUPLICATE: return FormPackage.GROUP__DUPLICATE;
                case FormPackage.DUPLICABLE__LIMIT_NUMBER_OF_DUPLICATION: return FormPackage.GROUP__LIMIT_NUMBER_OF_DUPLICATION;
                case FormPackage.DUPLICABLE__MAX_NUMBER_OF_DUPLICATION: return FormPackage.GROUP__MAX_NUMBER_OF_DUPLICATION;
                case FormPackage.DUPLICABLE__LIMIT_MIN_NUMBER_OF_DUPLICATION: return FormPackage.GROUP__LIMIT_MIN_NUMBER_OF_DUPLICATION;
                case FormPackage.DUPLICABLE__MIN_NUMBER_OF_DUPLICATION: return FormPackage.GROUP__MIN_NUMBER_OF_DUPLICATION;
                case FormPackage.DUPLICABLE__DISPLAY_LABEL_FOR_ADD: return FormPackage.GROUP__DISPLAY_LABEL_FOR_ADD;
                case FormPackage.DUPLICABLE__TOOLTIP_FOR_ADD: return FormPackage.GROUP__TOOLTIP_FOR_ADD;
                case FormPackage.DUPLICABLE__DISPLAY_LABEL_FOR_REMOVE: return FormPackage.GROUP__DISPLAY_LABEL_FOR_REMOVE;
                case FormPackage.DUPLICABLE__TOOLTIP_FOR_REMOVE: return FormPackage.GROUP__TOOLTIP_FOR_REMOVE;
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
        result.append(", duplicate: "); //$NON-NLS-1$
        result.append(duplicate);
        result.append(", limitNumberOfDuplication: "); //$NON-NLS-1$
        result.append(limitNumberOfDuplication);
        result.append(", maxNumberOfDuplication: "); //$NON-NLS-1$
        result.append(maxNumberOfDuplication);
        result.append(", limitMinNumberOfDuplication: "); //$NON-NLS-1$
        result.append(limitMinNumberOfDuplication);
        result.append(", minNumberOfDuplication: "); //$NON-NLS-1$
        result.append(minNumberOfDuplication);
        result.append(", displayLabelForAdd: "); //$NON-NLS-1$
        result.append(displayLabelForAdd);
        result.append(", tooltipForAdd: "); //$NON-NLS-1$
        result.append(tooltipForAdd);
        result.append(", displayLabelForRemove: "); //$NON-NLS-1$
        result.append(displayLabelForRemove);
        result.append(", tooltipForRemove: "); //$NON-NLS-1$
        result.append(tooltipForRemove);
        result.append(", showBorder: "); //$NON-NLS-1$
        result.append(showBorder);
        result.append(')');
        return result.toString();
    }

} //GroupImpl
