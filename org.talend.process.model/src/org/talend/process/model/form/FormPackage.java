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
package org.talend.process.model.form;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.talend.process.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.talend.process.model.form.FormFactory
 * @model kind="package"
 * @generated
 */
public interface FormPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "form"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.bonitasoft.org/ns/studio/form"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "form"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    FormPackage eINSTANCE = org.talend.process.model.form.impl.FormPackageImpl.init();

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.FormImpl <em>Form</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.FormImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getForm()
     * @generated
     */
    int FORM = 0;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__DOCUMENTATION = ProcessPackage.CONNECTABLE_ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__NAME = ProcessPackage.CONNECTABLE_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__LABEL = ProcessPackage.CONNECTABLE_ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__TEXT_ANNOTATION_ATTACHMENT = ProcessPackage.CONNECTABLE_ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__CONNECTORS = ProcessPackage.CONNECTABLE_ELEMENT__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__DATA = ProcessPackage.CONNECTABLE_ELEMENT__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__KPIS = ProcessPackage.CONNECTABLE_ELEMENT__KPIS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__VALIDATORS = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__USE_DEFAULT_VALIDATOR = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__BELOW = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Resource Folders</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__RESOURCE_FOLDERS = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Html Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__HTML_TEMPLATE = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Resource Files</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__RESOURCE_FILES = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Resource Jars</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__RESOURCE_JARS = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Resource Validators</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__RESOURCE_VALIDATORS = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Widgets</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__WIDGETS = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Scripts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__SCRIPTS = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>NColumn</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__NCOLUMN = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>String Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__STRING_ATTRIBUTES = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>NLine</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__NLINE = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 12;

    /**
     * The feature id for the '<em><b>Columns</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__COLUMNS = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 13;

    /**
     * The feature id for the '<em><b>Lines</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__LINES = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 14;

    /**
     * The feature id for the '<em><b>Page Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__PAGE_LABEL = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 15;

    /**
     * The feature id for the '<em><b>Show Page Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__SHOW_PAGE_LABEL = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 16;

    /**
     * The feature id for the '<em><b>Allow HTML In Page Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM__ALLOW_HTML_IN_PAGE_LABEL = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 17;

    /**
     * The number of structural features of the '<em>Form</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FEATURE_COUNT = ProcessPackage.CONNECTABLE_ELEMENT_FEATURE_COUNT + 18;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.Widget <em>Widget</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.Widget
     * @see org.talend.process.model.form.impl.FormPackageImpl#getWidget()
     * @generated
     */
    int WIDGET = 1;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__DOCUMENTATION = ProcessPackage.ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__NAME = ProcessPackage.ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__LABEL = ProcessPackage.ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__TEXT_ANNOTATION_ATTACHMENT = ProcessPackage.ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__SCRIPT = ProcessPackage.ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__TOOLTIP = ProcessPackage.ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__WIDGET_LAYOUT_INFO = ProcessPackage.ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__DISPLAY_LABEL = ProcessPackage.ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__SHOW_DISPLAY_LABEL = ProcessPackage.ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL = ProcessPackage.ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__HTML_ATTRIBUTES = ProcessPackage.ELEMENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__REAL_HTML_ATTRIBUTES = ProcessPackage.ELEMENT_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__DEPEND_ON = ProcessPackage.ELEMENT_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = ProcessPackage.ELEMENT_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__SCRIPT_AFTER_EVENT = ProcessPackage.ELEMENT_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__PARENT_OF = ProcessPackage.ELEMENT_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__MANDATORY = ProcessPackage.ELEMENT_FEATURE_COUNT + 12;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__READ_ONLY = ProcessPackage.ELEMENT_FEATURE_COUNT + 13;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__LABEL_POSITION = ProcessPackage.ELEMENT_FEATURE_COUNT + 14;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__INPUT_CONNECTORS = ProcessPackage.ELEMENT_FEATURE_COUNT + 15;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__OUTPUT_CONNECTORS = ProcessPackage.ELEMENT_FEATURE_COUNT + 16;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET__AFTER_EVENT_CONNECTORS = ProcessPackage.ELEMENT_FEATURE_COUNT + 17;

    /**
     * The number of structural features of the '<em>Widget</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET_FEATURE_COUNT = ProcessPackage.ELEMENT_FEATURE_COUNT + 18;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.WidgetDependencyImpl <em>Widget Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.WidgetDependencyImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getWidgetDependency()
     * @generated
     */
    int WIDGET_DEPENDENCY = 2;

    /**
     * The feature id for the '<em><b>Widget</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET_DEPENDENCY__WIDGET = 0;

    /**
     * The feature id for the '<em><b>Event Types</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET_DEPENDENCY__EVENT_TYPES = 1;

    /**
     * The number of structural features of the '<em>Widget Dependency</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET_DEPENDENCY_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.GroupImpl <em>Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.GroupImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getGroup()
     * @generated
     */
    int GROUP = 3;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__DOCUMENTATION = WIDGET__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__NAME = WIDGET__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__LABEL = WIDGET__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__TEXT_ANNOTATION_ATTACHMENT = WIDGET__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__SCRIPT = WIDGET__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__TOOLTIP = WIDGET__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__WIDGET_LAYOUT_INFO = WIDGET__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__DISPLAY_LABEL = WIDGET__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__SHOW_DISPLAY_LABEL = WIDGET__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__ALLOW_HTML_FOR_DISPLAY_LABEL = WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__HTML_ATTRIBUTES = WIDGET__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__REAL_HTML_ATTRIBUTES = WIDGET__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__DEPEND_ON = WIDGET__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__SCRIPT_AFTER_EVENT = WIDGET__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__PARENT_OF = WIDGET__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__MANDATORY = WIDGET__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__READ_ONLY = WIDGET__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__LABEL_POSITION = WIDGET__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__INPUT_CONNECTORS = WIDGET__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__OUTPUT_CONNECTORS = WIDGET__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__AFTER_EVENT_CONNECTORS = WIDGET__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Duplicate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__DUPLICATE = WIDGET_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Limit Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__LIMIT_NUMBER_OF_DUPLICATION = WIDGET_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Max Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__MAX_NUMBER_OF_DUPLICATION = WIDGET_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Limit Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__LIMIT_MIN_NUMBER_OF_DUPLICATION = WIDGET_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__MIN_NUMBER_OF_DUPLICATION = WIDGET_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Display Label For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__DISPLAY_LABEL_FOR_ADD = WIDGET_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Tooltip For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__TOOLTIP_FOR_ADD = WIDGET_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Display Label For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__DISPLAY_LABEL_FOR_REMOVE = WIDGET_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Tooltip For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__TOOLTIP_FOR_REMOVE = WIDGET_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Widgets</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__WIDGETS = WIDGET_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Show Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__SHOW_BORDER = WIDGET_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Columns</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__COLUMNS = WIDGET_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>Lines</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__LINES = WIDGET_FEATURE_COUNT + 12;

    /**
     * The number of structural features of the '<em>Group</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 13;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.FormFieldImpl <em>Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.FormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getFormField()
     * @generated
     */
    int FORM_FIELD = 4;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__DOCUMENTATION = WIDGET__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__NAME = WIDGET__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__LABEL = WIDGET__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = WIDGET__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__SCRIPT = WIDGET__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__TOOLTIP = WIDGET__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__WIDGET_LAYOUT_INFO = WIDGET__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__DISPLAY_LABEL = WIDGET__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__SHOW_DISPLAY_LABEL = WIDGET__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__HTML_ATTRIBUTES = WIDGET__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__REAL_HTML_ATTRIBUTES = WIDGET__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__DEPEND_ON = WIDGET__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__SCRIPT_AFTER_EVENT = WIDGET__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__PARENT_OF = WIDGET__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__MANDATORY = WIDGET__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__READ_ONLY = WIDGET__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__LABEL_POSITION = WIDGET__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__INPUT_CONNECTORS = WIDGET__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__OUTPUT_CONNECTORS = WIDGET__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__AFTER_EVENT_CONNECTORS = WIDGET__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__VALIDATORS = WIDGET_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__USE_DEFAULT_VALIDATOR = WIDGET_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__BELOW = WIDGET_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD__DESCRIPTION = WIDGET_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_FIELD_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl <em>Multiple Valuated Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getMultipleValuatedFormField()
     * @generated
     */
    int MULTIPLE_VALUATED_FORM_FIELD = 5;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__DOCUMENTATION = FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__NAME = FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__LABEL = FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__SCRIPT = FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__TOOLTIP = FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO = FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_LABEL = FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL = FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES = FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES = FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__DEPEND_ON = FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT = FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__PARENT_OF = FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__MANDATORY = FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__READ_ONLY = FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__LABEL_POSITION = FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS = FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS = FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS = FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__VALIDATORS = FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR = FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__BELOW = FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__DESCRIPTION = FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE = FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Default Value After Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT = FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Enum</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__ENUM = FORM_FIELD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Enum After Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT = FORM_FIELD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Literals</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__LITERALS = FORM_FIELD_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Literals After Event</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT = FORM_FIELD_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Default Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS = FORM_FIELD_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Default After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS = FORM_FIELD_FEATURE_COUNT + 7;

    /**
     * The number of structural features of the '<em>Multiple Valuated Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT = FORM_FIELD_FEATURE_COUNT + 8;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.SingleValuatedFormFieldImpl <em>Single Valuated Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.SingleValuatedFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getSingleValuatedFormField()
     * @generated
     */
    int SINGLE_VALUATED_FORM_FIELD = 6;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__DOCUMENTATION = FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__NAME = FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__LABEL = FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__SCRIPT = FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__TOOLTIP = FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO = FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__DISPLAY_LABEL = FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL = FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES = FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES = FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__DEPEND_ON = FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT = FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__PARENT_OF = FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__MANDATORY = FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__READ_ONLY = FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__LABEL_POSITION = FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS = FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS = FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS = FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__VALIDATORS = FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR = FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__BELOW = FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD__DESCRIPTION = FORM_FIELD__DESCRIPTION;

    /**
     * The number of structural features of the '<em>Single Valuated Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT = FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.CheckBoxMultipleFormFieldImpl <em>Check Box Multiple Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.CheckBoxMultipleFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getCheckBoxMultipleFormField()
     * @generated
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD = 7;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__DOCUMENTATION = MULTIPLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__NAME = MULTIPLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__LABEL = MULTIPLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = MULTIPLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__SCRIPT = MULTIPLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__TOOLTIP = MULTIPLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__WIDGET_LAYOUT_INFO = MULTIPLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__SHOW_DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__HTML_ATTRIBUTES = MULTIPLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__REAL_HTML_ATTRIBUTES = MULTIPLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__DEPEND_ON = MULTIPLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__SCRIPT_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__PARENT_OF = MULTIPLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__MANDATORY = MULTIPLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__READ_ONLY = MULTIPLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__LABEL_POSITION = MULTIPLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__INPUT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__OUTPUT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__AFTER_EVENT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__VALIDATORS = MULTIPLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__USE_DEFAULT_VALIDATOR = MULTIPLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__BELOW = MULTIPLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__DESCRIPTION = MULTIPLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__DEFAULT_VALUE = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Default Value After Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Enum</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__ENUM = MULTIPLE_VALUATED_FORM_FIELD__ENUM;

    /**
     * The feature id for the '<em><b>Enum After Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__ENUM_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Literals</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__LITERALS = MULTIPLE_VALUATED_FORM_FIELD__LITERALS;

    /**
     * The feature id for the '<em><b>Literals After Event</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__LITERALS_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Default Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__DEFAULT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Default After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Item Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD__ITEM_CLASS = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Check Box Multiple Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_MULTIPLE_FORM_FIELD_FEATURE_COUNT = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.ComboFormFieldImpl <em>Combo Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.ComboFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getComboFormField()
     * @generated
     */
    int COMBO_FORM_FIELD = 8;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__DOCUMENTATION = MULTIPLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__NAME = MULTIPLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__LABEL = MULTIPLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = MULTIPLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__SCRIPT = MULTIPLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__TOOLTIP = MULTIPLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__WIDGET_LAYOUT_INFO = MULTIPLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__SHOW_DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__HTML_ATTRIBUTES = MULTIPLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__REAL_HTML_ATTRIBUTES = MULTIPLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__DEPEND_ON = MULTIPLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__SCRIPT_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__PARENT_OF = MULTIPLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__MANDATORY = MULTIPLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__READ_ONLY = MULTIPLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__LABEL_POSITION = MULTIPLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__INPUT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__OUTPUT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__AFTER_EVENT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__VALIDATORS = MULTIPLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__USE_DEFAULT_VALIDATOR = MULTIPLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__BELOW = MULTIPLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__DESCRIPTION = MULTIPLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__DEFAULT_VALUE = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Default Value After Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Enum</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__ENUM = MULTIPLE_VALUATED_FORM_FIELD__ENUM;

    /**
     * The feature id for the '<em><b>Enum After Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__ENUM_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Literals</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__LITERALS = MULTIPLE_VALUATED_FORM_FIELD__LITERALS;

    /**
     * The feature id for the '<em><b>Literals After Event</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__LITERALS_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Default Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__DEFAULT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Default After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS;

    /**
     * The number of structural features of the '<em>Combo Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMBO_FORM_FIELD_FEATURE_COUNT = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.DateFormFieldImpl <em>Date Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.DateFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getDateFormField()
     * @generated
     */
    int DATE_FORM_FIELD = 9;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__DOCUMENTATION = SINGLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__NAME = SINGLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__LABEL = SINGLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = SINGLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__SCRIPT = SINGLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__TOOLTIP = SINGLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__WIDGET_LAYOUT_INFO = SINGLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__SHOW_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__REAL_HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__DEPEND_ON = SINGLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = SINGLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__SCRIPT_AFTER_EVENT = SINGLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__PARENT_OF = SINGLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__MANDATORY = SINGLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__READ_ONLY = SINGLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__LABEL_POSITION = SINGLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__INPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__OUTPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__AFTER_EVENT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__VALIDATORS = SINGLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__USE_DEFAULT_VALIDATOR = SINGLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__BELOW = SINGLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__DESCRIPTION = SINGLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Duplicate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__DUPLICATE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Limit Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Max Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Limit Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Display Label For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__DISPLAY_LABEL_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Tooltip For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__TOOLTIP_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Display Label For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Tooltip For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__TOOLTIP_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Initial Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__INITIAL_FORMAT = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Display Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD__DISPLAY_FORMAT = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 10;

    /**
     * The number of structural features of the '<em>Date Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_FORM_FIELD_FEATURE_COUNT = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 11;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.ListFormFieldImpl <em>List Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.ListFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getListFormField()
     * @generated
     */
    int LIST_FORM_FIELD = 10;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__DOCUMENTATION = MULTIPLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__NAME = MULTIPLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__LABEL = MULTIPLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = MULTIPLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__SCRIPT = MULTIPLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__TOOLTIP = MULTIPLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__WIDGET_LAYOUT_INFO = MULTIPLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__SHOW_DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__HTML_ATTRIBUTES = MULTIPLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__REAL_HTML_ATTRIBUTES = MULTIPLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__DEPEND_ON = MULTIPLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__SCRIPT_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__PARENT_OF = MULTIPLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__MANDATORY = MULTIPLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__READ_ONLY = MULTIPLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__LABEL_POSITION = MULTIPLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__INPUT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__OUTPUT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__AFTER_EVENT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__VALIDATORS = MULTIPLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__USE_DEFAULT_VALIDATOR = MULTIPLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__BELOW = MULTIPLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__DESCRIPTION = MULTIPLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__DEFAULT_VALUE = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Default Value After Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Enum</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__ENUM = MULTIPLE_VALUATED_FORM_FIELD__ENUM;

    /**
     * The feature id for the '<em><b>Enum After Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__ENUM_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Literals</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__LITERALS = MULTIPLE_VALUATED_FORM_FIELD__LITERALS;

    /**
     * The feature id for the '<em><b>Literals After Event</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__LITERALS_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Default Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__DEFAULT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Default After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Max Heigth</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD__MAX_HEIGTH = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>List Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_FORM_FIELD_FEATURE_COUNT = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.PasswordFormFieldImpl <em>Password Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.PasswordFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getPasswordFormField()
     * @generated
     */
    int PASSWORD_FORM_FIELD = 11;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__DOCUMENTATION = SINGLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__NAME = SINGLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__LABEL = SINGLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = SINGLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__SCRIPT = SINGLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__TOOLTIP = SINGLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__WIDGET_LAYOUT_INFO = SINGLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__SHOW_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__REAL_HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__DEPEND_ON = SINGLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = SINGLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__SCRIPT_AFTER_EVENT = SINGLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__PARENT_OF = SINGLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__MANDATORY = SINGLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__READ_ONLY = SINGLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__LABEL_POSITION = SINGLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__INPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__OUTPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__AFTER_EVENT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__VALIDATORS = SINGLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__USE_DEFAULT_VALIDATOR = SINGLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__BELOW = SINGLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__DESCRIPTION = SINGLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Duplicate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__DUPLICATE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Limit Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Max Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Limit Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Display Label For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__DISPLAY_LABEL_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Tooltip For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__TOOLTIP_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Display Label For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Tooltip For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__TOOLTIP_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Max Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD__MAX_LENGTH = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 9;

    /**
     * The number of structural features of the '<em>Password Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_FORM_FIELD_FEATURE_COUNT = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 10;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.RadioFormFieldImpl <em>Radio Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.RadioFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getRadioFormField()
     * @generated
     */
    int RADIO_FORM_FIELD = 12;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__DOCUMENTATION = MULTIPLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__NAME = MULTIPLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__LABEL = MULTIPLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = MULTIPLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__SCRIPT = MULTIPLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__TOOLTIP = MULTIPLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__WIDGET_LAYOUT_INFO = MULTIPLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__SHOW_DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__HTML_ATTRIBUTES = MULTIPLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__REAL_HTML_ATTRIBUTES = MULTIPLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__DEPEND_ON = MULTIPLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__SCRIPT_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__PARENT_OF = MULTIPLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__MANDATORY = MULTIPLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__READ_ONLY = MULTIPLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__LABEL_POSITION = MULTIPLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__INPUT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__OUTPUT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__AFTER_EVENT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__VALIDATORS = MULTIPLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__USE_DEFAULT_VALIDATOR = MULTIPLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__BELOW = MULTIPLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__DESCRIPTION = MULTIPLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__DEFAULT_VALUE = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Default Value After Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Enum</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__ENUM = MULTIPLE_VALUATED_FORM_FIELD__ENUM;

    /**
     * The feature id for the '<em><b>Enum After Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__ENUM_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Literals</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__LITERALS = MULTIPLE_VALUATED_FORM_FIELD__LITERALS;

    /**
     * The feature id for the '<em><b>Literals After Event</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__LITERALS_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Default Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__DEFAULT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Default After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Item Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD__ITEM_CLASS = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Radio Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RADIO_FORM_FIELD_FEATURE_COUNT = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.SelectFormFieldImpl <em>Select Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.SelectFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getSelectFormField()
     * @generated
     */
    int SELECT_FORM_FIELD = 13;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DOCUMENTATION = MULTIPLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__NAME = MULTIPLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__LABEL = MULTIPLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = MULTIPLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__SCRIPT = MULTIPLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__TOOLTIP = MULTIPLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__WIDGET_LAYOUT_INFO = MULTIPLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__SHOW_DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = MULTIPLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__HTML_ATTRIBUTES = MULTIPLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__REAL_HTML_ATTRIBUTES = MULTIPLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DEPEND_ON = MULTIPLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = MULTIPLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__SCRIPT_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__PARENT_OF = MULTIPLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__MANDATORY = MULTIPLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__READ_ONLY = MULTIPLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__LABEL_POSITION = MULTIPLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__INPUT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__OUTPUT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__AFTER_EVENT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__VALIDATORS = MULTIPLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__USE_DEFAULT_VALIDATOR = MULTIPLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__BELOW = MULTIPLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DESCRIPTION = MULTIPLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DEFAULT_VALUE = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Default Value After Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Enum</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__ENUM = MULTIPLE_VALUATED_FORM_FIELD__ENUM;

    /**
     * The feature id for the '<em><b>Enum After Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__ENUM_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Literals</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__LITERALS = MULTIPLE_VALUATED_FORM_FIELD__LITERALS;

    /**
     * The feature id for the '<em><b>Literals After Event</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__LITERALS_AFTER_EVENT = MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Default Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DEFAULT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Default After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS = MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Duplicate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DUPLICATE = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Limit Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Max Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Limit Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Display Label For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DISPLAY_LABEL_FOR_ADD = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Tooltip For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__TOOLTIP_FOR_ADD = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Display Label For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Tooltip For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD__TOOLTIP_FOR_REMOVE = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 8;

    /**
     * The number of structural features of the '<em>Select Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECT_FORM_FIELD_FEATURE_COUNT = MULTIPLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 9;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.TextFormFieldImpl <em>Text Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.TextFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getTextFormField()
     * @generated
     */
    int TEXT_FORM_FIELD = 14;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__DOCUMENTATION = SINGLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__NAME = SINGLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__LABEL = SINGLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = SINGLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__SCRIPT = SINGLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__TOOLTIP = SINGLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__WIDGET_LAYOUT_INFO = SINGLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__SHOW_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__REAL_HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__DEPEND_ON = SINGLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = SINGLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__SCRIPT_AFTER_EVENT = SINGLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__PARENT_OF = SINGLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__MANDATORY = SINGLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__READ_ONLY = SINGLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__LABEL_POSITION = SINGLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__INPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__OUTPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__AFTER_EVENT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__VALIDATORS = SINGLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__USE_DEFAULT_VALIDATOR = SINGLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__BELOW = SINGLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__DESCRIPTION = SINGLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Duplicate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__DUPLICATE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Limit Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Max Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Limit Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Display Label For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__DISPLAY_LABEL_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Tooltip For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__TOOLTIP_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Display Label For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Tooltip For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__TOOLTIP_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Max Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD__MAX_LENGTH = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 9;

    /**
     * The number of structural features of the '<em>Text Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORM_FIELD_FEATURE_COUNT = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 10;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.TextAreaFormFieldImpl <em>Text Area Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.TextAreaFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getTextAreaFormField()
     * @generated
     */
    int TEXT_AREA_FORM_FIELD = 15;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__DOCUMENTATION = SINGLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__NAME = SINGLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__LABEL = SINGLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = SINGLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__SCRIPT = SINGLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__TOOLTIP = SINGLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__WIDGET_LAYOUT_INFO = SINGLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__SHOW_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__REAL_HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__DEPEND_ON = SINGLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = SINGLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__SCRIPT_AFTER_EVENT = SINGLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__PARENT_OF = SINGLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__MANDATORY = SINGLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__READ_ONLY = SINGLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__LABEL_POSITION = SINGLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__INPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__OUTPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__AFTER_EVENT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__VALIDATORS = SINGLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__USE_DEFAULT_VALIDATOR = SINGLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__BELOW = SINGLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__DESCRIPTION = SINGLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Duplicate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__DUPLICATE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Limit Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Max Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Limit Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Display Label For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Tooltip For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Display Label For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Tooltip For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Max Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__MAX_LENGTH = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Max Heigth</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD__MAX_HEIGTH = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 10;

    /**
     * The number of structural features of the '<em>Text Area Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_AREA_FORM_FIELD_FEATURE_COUNT = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 11;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.RichTextAreaFormFieldImpl <em>Rich Text Area Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.RichTextAreaFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getRichTextAreaFormField()
     * @generated
     */
    int RICH_TEXT_AREA_FORM_FIELD = 16;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__DOCUMENTATION = SINGLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__NAME = SINGLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__LABEL = SINGLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = SINGLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__SCRIPT = SINGLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__TOOLTIP = SINGLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__WIDGET_LAYOUT_INFO = SINGLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__SHOW_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__REAL_HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__DEPEND_ON = SINGLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = SINGLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__SCRIPT_AFTER_EVENT = SINGLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__PARENT_OF = SINGLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__MANDATORY = SINGLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__READ_ONLY = SINGLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__LABEL_POSITION = SINGLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__INPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__OUTPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__AFTER_EVENT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__VALIDATORS = SINGLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__USE_DEFAULT_VALIDATOR = SINGLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__BELOW = SINGLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__DESCRIPTION = SINGLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Duplicate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__DUPLICATE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Limit Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Max Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Limit Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Display Label For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Tooltip For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Display Label For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Tooltip For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 8;

    /**
     * The number of structural features of the '<em>Rich Text Area Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RICH_TEXT_AREA_FORM_FIELD_FEATURE_COUNT = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 9;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.FormButtonImpl <em>Button</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.FormButtonImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getFormButton()
     * @generated
     */
    int FORM_BUTTON = 17;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__DOCUMENTATION = WIDGET__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__NAME = WIDGET__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__LABEL = WIDGET__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__TEXT_ANNOTATION_ATTACHMENT = WIDGET__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__SCRIPT = WIDGET__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__TOOLTIP = WIDGET__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__WIDGET_LAYOUT_INFO = WIDGET__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__DISPLAY_LABEL = WIDGET__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__SHOW_DISPLAY_LABEL = WIDGET__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__ALLOW_HTML_FOR_DISPLAY_LABEL = WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__HTML_ATTRIBUTES = WIDGET__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__REAL_HTML_ATTRIBUTES = WIDGET__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__DEPEND_ON = WIDGET__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__SCRIPT_AFTER_EVENT = WIDGET__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__PARENT_OF = WIDGET__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__MANDATORY = WIDGET__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__READ_ONLY = WIDGET__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__LABEL_POSITION = WIDGET__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__INPUT_CONNECTORS = WIDGET__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__OUTPUT_CONNECTORS = WIDGET__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__AFTER_EVENT_CONNECTORS = WIDGET__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Label Behavior</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON__LABEL_BEHAVIOR = WIDGET_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Button</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORM_BUTTON_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.SubmitFormButtonImpl <em>Submit Form Button</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.SubmitFormButtonImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getSubmitFormButton()
     * @generated
     */
    int SUBMIT_FORM_BUTTON = 18;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__DOCUMENTATION = FORM_BUTTON__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__NAME = FORM_BUTTON__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__LABEL = FORM_BUTTON__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__TEXT_ANNOTATION_ATTACHMENT = FORM_BUTTON__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__SCRIPT = FORM_BUTTON__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__TOOLTIP = FORM_BUTTON__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__WIDGET_LAYOUT_INFO = FORM_BUTTON__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__DISPLAY_LABEL = FORM_BUTTON__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__SHOW_DISPLAY_LABEL = FORM_BUTTON__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__ALLOW_HTML_FOR_DISPLAY_LABEL = FORM_BUTTON__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__HTML_ATTRIBUTES = FORM_BUTTON__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__REAL_HTML_ATTRIBUTES = FORM_BUTTON__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__DEPEND_ON = FORM_BUTTON__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = FORM_BUTTON__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__SCRIPT_AFTER_EVENT = FORM_BUTTON__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__PARENT_OF = FORM_BUTTON__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__MANDATORY = FORM_BUTTON__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__READ_ONLY = FORM_BUTTON__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__LABEL_POSITION = FORM_BUTTON__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__INPUT_CONNECTORS = FORM_BUTTON__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__OUTPUT_CONNECTORS = FORM_BUTTON__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__AFTER_EVENT_CONNECTORS = FORM_BUTTON__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Label Behavior</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__LABEL_BEHAVIOR = FORM_BUTTON__LABEL_BEHAVIOR;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__CONNECTORS = FORM_BUTTON_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__DATA = FORM_BUTTON_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__KPIS = FORM_BUTTON_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Scripts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON__SCRIPTS = FORM_BUTTON_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Submit Form Button</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBMIT_FORM_BUTTON_FEATURE_COUNT = FORM_BUTTON_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.PreviousFormButtonImpl <em>Previous Form Button</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.PreviousFormButtonImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getPreviousFormButton()
     * @generated
     */
    int PREVIOUS_FORM_BUTTON = 19;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__DOCUMENTATION = FORM_BUTTON__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__NAME = FORM_BUTTON__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__LABEL = FORM_BUTTON__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__TEXT_ANNOTATION_ATTACHMENT = FORM_BUTTON__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__SCRIPT = FORM_BUTTON__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__TOOLTIP = FORM_BUTTON__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__WIDGET_LAYOUT_INFO = FORM_BUTTON__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__DISPLAY_LABEL = FORM_BUTTON__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__SHOW_DISPLAY_LABEL = FORM_BUTTON__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__ALLOW_HTML_FOR_DISPLAY_LABEL = FORM_BUTTON__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__HTML_ATTRIBUTES = FORM_BUTTON__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__REAL_HTML_ATTRIBUTES = FORM_BUTTON__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__DEPEND_ON = FORM_BUTTON__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = FORM_BUTTON__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__SCRIPT_AFTER_EVENT = FORM_BUTTON__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__PARENT_OF = FORM_BUTTON__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__MANDATORY = FORM_BUTTON__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__READ_ONLY = FORM_BUTTON__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__LABEL_POSITION = FORM_BUTTON__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__INPUT_CONNECTORS = FORM_BUTTON__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__OUTPUT_CONNECTORS = FORM_BUTTON__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__AFTER_EVENT_CONNECTORS = FORM_BUTTON__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Label Behavior</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON__LABEL_BEHAVIOR = FORM_BUTTON__LABEL_BEHAVIOR;

    /**
     * The number of structural features of the '<em>Previous Form Button</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREVIOUS_FORM_BUTTON_FEATURE_COUNT = FORM_BUTTON_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.NextFormButtonImpl <em>Next Form Button</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.NextFormButtonImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getNextFormButton()
     * @generated
     */
    int NEXT_FORM_BUTTON = 20;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__DOCUMENTATION = FORM_BUTTON__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__NAME = FORM_BUTTON__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__LABEL = FORM_BUTTON__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__TEXT_ANNOTATION_ATTACHMENT = FORM_BUTTON__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__SCRIPT = FORM_BUTTON__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__TOOLTIP = FORM_BUTTON__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__WIDGET_LAYOUT_INFO = FORM_BUTTON__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__DISPLAY_LABEL = FORM_BUTTON__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__SHOW_DISPLAY_LABEL = FORM_BUTTON__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__ALLOW_HTML_FOR_DISPLAY_LABEL = FORM_BUTTON__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__HTML_ATTRIBUTES = FORM_BUTTON__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__REAL_HTML_ATTRIBUTES = FORM_BUTTON__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__DEPEND_ON = FORM_BUTTON__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = FORM_BUTTON__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__SCRIPT_AFTER_EVENT = FORM_BUTTON__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__PARENT_OF = FORM_BUTTON__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__MANDATORY = FORM_BUTTON__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__READ_ONLY = FORM_BUTTON__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__LABEL_POSITION = FORM_BUTTON__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__INPUT_CONNECTORS = FORM_BUTTON__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__OUTPUT_CONNECTORS = FORM_BUTTON__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__AFTER_EVENT_CONNECTORS = FORM_BUTTON__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Label Behavior</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON__LABEL_BEHAVIOR = FORM_BUTTON__LABEL_BEHAVIOR;

    /**
     * The number of structural features of the '<em>Next Form Button</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEXT_FORM_BUTTON_FEATURE_COUNT = FORM_BUTTON_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.GroovyScriptImpl <em>Groovy Script</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.GroovyScriptImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getGroovyScript()
     * @generated
     */
    int GROOVY_SCRIPT = 21;

    /**
     * The feature id for the '<em><b>Expr Script</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROOVY_SCRIPT__EXPR_SCRIPT = 0;

    /**
     * The feature id for the '<em><b>Input Script</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROOVY_SCRIPT__INPUT_SCRIPT = 1;

    /**
     * The feature id for the '<em><b>Set Var</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROOVY_SCRIPT__SET_VAR = 2;

    /**
     * The feature id for the '<em><b>Allow HTML In Values</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROOVY_SCRIPT__ALLOW_HTML_IN_VALUES = 3;

    /**
     * The feature id for the '<em><b>Set Var Script</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROOVY_SCRIPT__SET_VAR_SCRIPT = 4;

    /**
     * The number of structural features of the '<em>Groovy Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROOVY_SCRIPT_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.InfoImpl <em>Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.InfoImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getInfo()
     * @generated
     */
    int INFO = 22;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__DOCUMENTATION = WIDGET__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__NAME = WIDGET__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__LABEL = WIDGET__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__TEXT_ANNOTATION_ATTACHMENT = WIDGET__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__SCRIPT = WIDGET__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__TOOLTIP = WIDGET__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__WIDGET_LAYOUT_INFO = WIDGET__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__DISPLAY_LABEL = WIDGET__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__SHOW_DISPLAY_LABEL = WIDGET__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__ALLOW_HTML_FOR_DISPLAY_LABEL = WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__HTML_ATTRIBUTES = WIDGET__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__REAL_HTML_ATTRIBUTES = WIDGET__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__DEPEND_ON = WIDGET__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__SCRIPT_AFTER_EVENT = WIDGET__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__PARENT_OF = WIDGET__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__MANDATORY = WIDGET__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__READ_ONLY = WIDGET__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__LABEL_POSITION = WIDGET__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__INPUT_CONNECTORS = WIDGET__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__OUTPUT_CONNECTORS = WIDGET__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO__AFTER_EVENT_CONNECTORS = WIDGET__AFTER_EVENT_CONNECTORS;

    /**
     * The number of structural features of the '<em>Info</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INFO_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.TextInfoImpl <em>Text Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.TextInfoImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getTextInfo()
     * @generated
     */
    int TEXT_INFO = 23;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__DOCUMENTATION = INFO__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__NAME = INFO__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__LABEL = INFO__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__TEXT_ANNOTATION_ATTACHMENT = INFO__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__SCRIPT = INFO__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__TOOLTIP = INFO__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__WIDGET_LAYOUT_INFO = INFO__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__DISPLAY_LABEL = INFO__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__SHOW_DISPLAY_LABEL = INFO__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__ALLOW_HTML_FOR_DISPLAY_LABEL = INFO__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__HTML_ATTRIBUTES = INFO__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__REAL_HTML_ATTRIBUTES = INFO__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__DEPEND_ON = INFO__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = INFO__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__SCRIPT_AFTER_EVENT = INFO__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__PARENT_OF = INFO__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__MANDATORY = INFO__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__READ_ONLY = INFO__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__LABEL_POSITION = INFO__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__INPUT_CONNECTORS = INFO__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__OUTPUT_CONNECTORS = INFO__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO__AFTER_EVENT_CONNECTORS = INFO__AFTER_EVENT_CONNECTORS;

    /**
     * The number of structural features of the '<em>Text Info</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INFO_FEATURE_COUNT = INFO_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.MessageInfoImpl <em>Message Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.MessageInfoImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getMessageInfo()
     * @generated
     */
    int MESSAGE_INFO = 24;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__DOCUMENTATION = INFO__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__NAME = INFO__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__LABEL = INFO__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__TEXT_ANNOTATION_ATTACHMENT = INFO__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__SCRIPT = INFO__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__TOOLTIP = INFO__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__WIDGET_LAYOUT_INFO = INFO__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__DISPLAY_LABEL = INFO__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__SHOW_DISPLAY_LABEL = INFO__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__ALLOW_HTML_FOR_DISPLAY_LABEL = INFO__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__HTML_ATTRIBUTES = INFO__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__REAL_HTML_ATTRIBUTES = INFO__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__DEPEND_ON = INFO__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = INFO__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__SCRIPT_AFTER_EVENT = INFO__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__PARENT_OF = INFO__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__MANDATORY = INFO__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__READ_ONLY = INFO__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__LABEL_POSITION = INFO__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__INPUT_CONNECTORS = INFO__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__OUTPUT_CONNECTORS = INFO__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO__AFTER_EVENT_CONNECTORS = INFO__AFTER_EVENT_CONNECTORS;

    /**
     * The number of structural features of the '<em>Message Info</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_INFO_FEATURE_COUNT = INFO_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.CheckBoxSingleFormFieldImpl <em>Check Box Single Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.CheckBoxSingleFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getCheckBoxSingleFormField()
     * @generated
     */
    int CHECK_BOX_SINGLE_FORM_FIELD = 25;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__DOCUMENTATION = SINGLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__NAME = SINGLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__LABEL = SINGLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = SINGLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__SCRIPT = SINGLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__TOOLTIP = SINGLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__WIDGET_LAYOUT_INFO = SINGLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__SHOW_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__REAL_HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__DEPEND_ON = SINGLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = SINGLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__SCRIPT_AFTER_EVENT = SINGLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__PARENT_OF = SINGLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__MANDATORY = SINGLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__READ_ONLY = SINGLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__LABEL_POSITION = SINGLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__INPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__OUTPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__AFTER_EVENT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__VALIDATORS = SINGLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__USE_DEFAULT_VALIDATOR = SINGLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__BELOW = SINGLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD__DESCRIPTION = SINGLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The number of structural features of the '<em>Check Box Single Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_BOX_SINGLE_FORM_FIELD_FEATURE_COUNT = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.ValidatorImpl <em>Validator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.ValidatorImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getValidator()
     * @generated
     */
    int VALIDATOR = 26;

    /**
     * The feature id for the '<em><b>Validator Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATOR__VALIDATOR_CLASS = 0;

    /**
     * The feature id for the '<em><b>Html Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATOR__HTML_CLASS = 1;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATOR__LABEL = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATOR__NAME = 3;

    /**
     * The feature id for the '<em><b>Parameter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATOR__PARAMETER = 4;

    /**
     * The feature id for the '<em><b>Below Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATOR__BELOW_FIELD = 5;

    /**
     * The number of structural features of the '<em>Validator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATOR_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.ValidableImpl <em>Validable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.ValidableImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getValidable()
     * @generated
     */
    int VALIDABLE = 27;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDABLE__VALIDATORS = 0;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDABLE__USE_DEFAULT_VALIDATOR = 1;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDABLE__BELOW = 2;

    /**
     * The number of structural features of the '<em>Validable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDABLE_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.WidgetLayoutInfoImpl <em>Widget Layout Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.WidgetLayoutInfoImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getWidgetLayoutInfo()
     * @generated
     */
    int WIDGET_LAYOUT_INFO = 28;

    /**
     * The feature id for the '<em><b>Line</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET_LAYOUT_INFO__LINE = 0;

    /**
     * The feature id for the '<em><b>Column</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET_LAYOUT_INFO__COLUMN = 1;

    /**
     * The feature id for the '<em><b>Vertical Span</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET_LAYOUT_INFO__VERTICAL_SPAN = 2;

    /**
     * The feature id for the '<em><b>Horizontal Span</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET_LAYOUT_INFO__HORIZONTAL_SPAN = 3;

    /**
     * The number of structural features of the '<em>Widget Layout Info</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WIDGET_LAYOUT_INFO_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.FileWidgetImpl <em>File Widget</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.FileWidgetImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getFileWidget()
     * @generated
     */
    int FILE_WIDGET = 29;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__DOCUMENTATION = SINGLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__NAME = SINGLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__LABEL = SINGLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__TEXT_ANNOTATION_ATTACHMENT = SINGLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__SCRIPT = SINGLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__TOOLTIP = SINGLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__WIDGET_LAYOUT_INFO = SINGLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__SHOW_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__REAL_HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__DEPEND_ON = SINGLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = SINGLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__SCRIPT_AFTER_EVENT = SINGLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__PARENT_OF = SINGLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__MANDATORY = SINGLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__READ_ONLY = SINGLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__LABEL_POSITION = SINGLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__INPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__OUTPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__AFTER_EVENT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__VALIDATORS = SINGLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__USE_DEFAULT_VALIDATOR = SINGLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__BELOW = SINGLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__DESCRIPTION = SINGLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Duplicate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__DUPLICATE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Limit Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__LIMIT_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Max Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__MAX_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Limit Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__LIMIT_MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__MIN_NUMBER_OF_DUPLICATION = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Display Label For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__DISPLAY_LABEL_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Tooltip For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__TOOLTIP_FOR_ADD = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Display Label For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__DISPLAY_LABEL_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Tooltip For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__TOOLTIP_FOR_REMOVE = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>File Data</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__FILE_DATA = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Download Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__DOWNLOAD_ONLY = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Use Preview</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET__USE_PREVIEW = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 11;

    /**
     * The number of structural features of the '<em>File Widget</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_WIDGET_FEATURE_COUNT = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 12;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.ColumnImpl <em>Column</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.ColumnImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getColumn()
     * @generated
     */
    int COLUMN = 30;

    /**
     * The feature id for the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN__WIDTH = 0;

    /**
     * The feature id for the '<em><b>Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN__NUMBER = 1;

    /**
     * The number of structural features of the '<em>Column</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.LineImpl <em>Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.LineImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getLine()
     * @generated
     */
    int LINE = 31;

    /**
     * The feature id for the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__HEIGHT = 0;

    /**
     * The feature id for the '<em><b>Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__NUMBER = 1;

    /**
     * The number of structural features of the '<em>Line</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.ImageWidgetImpl <em>Image Widget</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.ImageWidgetImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getImageWidget()
     * @generated
     */
    int IMAGE_WIDGET = 32;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__DOCUMENTATION = WIDGET__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__NAME = WIDGET__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__LABEL = WIDGET__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__TEXT_ANNOTATION_ATTACHMENT = WIDGET__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__SCRIPT = WIDGET__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__TOOLTIP = WIDGET__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__WIDGET_LAYOUT_INFO = WIDGET__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__DISPLAY_LABEL = WIDGET__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__SHOW_DISPLAY_LABEL = WIDGET__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL = WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__HTML_ATTRIBUTES = WIDGET__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__REAL_HTML_ATTRIBUTES = WIDGET__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__DEPEND_ON = WIDGET__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__SCRIPT_AFTER_EVENT = WIDGET__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__PARENT_OF = WIDGET__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__MANDATORY = WIDGET__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__READ_ONLY = WIDGET__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__LABEL_POSITION = WIDGET__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__INPUT_CONNECTORS = WIDGET__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__OUTPUT_CONNECTORS = WIDGET__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__AFTER_EVENT_CONNECTORS = WIDGET__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Img Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__IMG_PATH = WIDGET_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Is An Attachment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET__IS_AN_ATTACHMENT = WIDGET_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Image Widget</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_WIDGET_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.HiddenWidgetImpl <em>Hidden Widget</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.HiddenWidgetImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getHiddenWidget()
     * @generated
     */
    int HIDDEN_WIDGET = 33;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__DOCUMENTATION = SINGLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__NAME = SINGLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__LABEL = SINGLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__TEXT_ANNOTATION_ATTACHMENT = SINGLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__SCRIPT = SINGLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__TOOLTIP = SINGLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__WIDGET_LAYOUT_INFO = SINGLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__SHOW_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__REAL_HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__DEPEND_ON = SINGLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = SINGLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__SCRIPT_AFTER_EVENT = SINGLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__PARENT_OF = SINGLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__MANDATORY = SINGLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__READ_ONLY = SINGLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__LABEL_POSITION = SINGLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__INPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__OUTPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__AFTER_EVENT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__VALIDATORS = SINGLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__USE_DEFAULT_VALIDATOR = SINGLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__BELOW = SINGLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET__DESCRIPTION = SINGLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The number of structural features of the '<em>Hidden Widget</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_WIDGET_FEATURE_COUNT = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.DurationFormFieldImpl <em>Duration Form Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.DurationFormFieldImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getDurationFormField()
     * @generated
     */
    int DURATION_FORM_FIELD = 34;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__DOCUMENTATION = SINGLE_VALUATED_FORM_FIELD__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__NAME = SINGLE_VALUATED_FORM_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__LABEL = SINGLE_VALUATED_FORM_FIELD__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT = SINGLE_VALUATED_FORM_FIELD__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__SCRIPT = SINGLE_VALUATED_FORM_FIELD__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__TOOLTIP = SINGLE_VALUATED_FORM_FIELD__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__WIDGET_LAYOUT_INFO = SINGLE_VALUATED_FORM_FIELD__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__SHOW_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL = SINGLE_VALUATED_FORM_FIELD__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__REAL_HTML_ATTRIBUTES = SINGLE_VALUATED_FORM_FIELD__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__DEPEND_ON = SINGLE_VALUATED_FORM_FIELD__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = SINGLE_VALUATED_FORM_FIELD__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__SCRIPT_AFTER_EVENT = SINGLE_VALUATED_FORM_FIELD__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__PARENT_OF = SINGLE_VALUATED_FORM_FIELD__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__MANDATORY = SINGLE_VALUATED_FORM_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__READ_ONLY = SINGLE_VALUATED_FORM_FIELD__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__LABEL_POSITION = SINGLE_VALUATED_FORM_FIELD__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__INPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__OUTPUT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__AFTER_EVENT_CONNECTORS = SINGLE_VALUATED_FORM_FIELD__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__VALIDATORS = SINGLE_VALUATED_FORM_FIELD__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__USE_DEFAULT_VALIDATOR = SINGLE_VALUATED_FORM_FIELD__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__BELOW = SINGLE_VALUATED_FORM_FIELD__BELOW;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__DESCRIPTION = SINGLE_VALUATED_FORM_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Item Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__ITEM_CLASS = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Day</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__DAY = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Hour</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__HOUR = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Min</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__MIN = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Sec</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD__SEC = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Duration Form Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DURATION_FORM_FIELD_FEATURE_COUNT = SINGLE_VALUATED_FORM_FIELD_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.ItemContainer <em>Item Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.ItemContainer
     * @see org.talend.process.model.form.impl.FormPackageImpl#getItemContainer()
     * @generated
     */
    int ITEM_CONTAINER = 35;

    /**
     * The feature id for the '<em><b>Item Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_CONTAINER__ITEM_CLASS = 0;

    /**
     * The number of structural features of the '<em>Item Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_CONTAINER_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.Duplicable <em>Duplicable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.Duplicable
     * @see org.talend.process.model.form.impl.FormPackageImpl#getDuplicable()
     * @generated
     */
    int DUPLICABLE = 36;

    /**
     * The feature id for the '<em><b>Duplicate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DUPLICABLE__DUPLICATE = 0;

    /**
     * The feature id for the '<em><b>Limit Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DUPLICABLE__LIMIT_NUMBER_OF_DUPLICATION = 1;

    /**
     * The feature id for the '<em><b>Max Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DUPLICABLE__MAX_NUMBER_OF_DUPLICATION = 2;

    /**
     * The feature id for the '<em><b>Limit Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DUPLICABLE__LIMIT_MIN_NUMBER_OF_DUPLICATION = 3;

    /**
     * The feature id for the '<em><b>Min Number Of Duplication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DUPLICABLE__MIN_NUMBER_OF_DUPLICATION = 4;

    /**
     * The feature id for the '<em><b>Display Label For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DUPLICABLE__DISPLAY_LABEL_FOR_ADD = 5;

    /**
     * The feature id for the '<em><b>Tooltip For Add</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DUPLICABLE__TOOLTIP_FOR_ADD = 6;

    /**
     * The feature id for the '<em><b>Display Label For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DUPLICABLE__DISPLAY_LABEL_FOR_REMOVE = 7;

    /**
     * The feature id for the '<em><b>Tooltip For Remove</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DUPLICABLE__TOOLTIP_FOR_REMOVE = 8;

    /**
     * The number of structural features of the '<em>Duplicable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DUPLICABLE_FEATURE_COUNT = 9;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.TableImpl <em>Table</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.TableImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getTable()
     * @generated
     */
    int TABLE = 37;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__DOCUMENTATION = WIDGET__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__NAME = WIDGET__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__LABEL = WIDGET__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__TEXT_ANNOTATION_ATTACHMENT = WIDGET__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__SCRIPT = WIDGET__SCRIPT;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__TOOLTIP = WIDGET__TOOLTIP;

    /**
     * The feature id for the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__WIDGET_LAYOUT_INFO = WIDGET__WIDGET_LAYOUT_INFO;

    /**
     * The feature id for the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__DISPLAY_LABEL = WIDGET__DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Show Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__SHOW_DISPLAY_LABEL = WIDGET__SHOW_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__ALLOW_HTML_FOR_DISPLAY_LABEL = WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL;

    /**
     * The feature id for the '<em><b>Html Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__HTML_ATTRIBUTES = WIDGET__HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__REAL_HTML_ATTRIBUTES = WIDGET__REAL_HTML_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Depend On</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__DEPEND_ON = WIDGET__DEPEND_ON;

    /**
     * The feature id for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED;

    /**
     * The feature id for the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__SCRIPT_AFTER_EVENT = WIDGET__SCRIPT_AFTER_EVENT;

    /**
     * The feature id for the '<em><b>Parent Of</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__PARENT_OF = WIDGET__PARENT_OF;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__MANDATORY = WIDGET__MANDATORY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__READ_ONLY = WIDGET__READ_ONLY;

    /**
     * The feature id for the '<em><b>Label Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__LABEL_POSITION = WIDGET__LABEL_POSITION;

    /**
     * The feature id for the '<em><b>Input Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__INPUT_CONNECTORS = WIDGET__INPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Output Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__OUTPUT_CONNECTORS = WIDGET__OUTPUT_CONNECTORS;

    /**
     * The feature id for the '<em><b>After Event Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__AFTER_EVENT_CONNECTORS = WIDGET__AFTER_EVENT_CONNECTORS;

    /**
     * The feature id for the '<em><b>Left Column Is Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__LEFT_COLUMN_IS_HEADER = WIDGET_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Right Column Is Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__RIGHT_COLUMN_IS_HEADER = WIDGET_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>First Row Is Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__FIRST_ROW_IS_HEADER = WIDGET_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Last Row Is Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__LAST_ROW_IS_HEADER = WIDGET_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Initialized Using Cells</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__INITIALIZED_USING_CELLS = WIDGET_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Cells</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE__CELLS = WIDGET_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Table</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABLE_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.impl.ViewFormImpl <em>View Form</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.impl.ViewFormImpl
     * @see org.talend.process.model.form.impl.FormPackageImpl#getViewForm()
     * @generated
     */
    int VIEW_FORM = 38;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__DOCUMENTATION = FORM__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__NAME = FORM__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__LABEL = FORM__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__TEXT_ANNOTATION_ATTACHMENT = FORM__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__CONNECTORS = FORM__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__DATA = FORM__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__KPIS = FORM__KPIS;

    /**
     * The feature id for the '<em><b>Validators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__VALIDATORS = FORM__VALIDATORS;

    /**
     * The feature id for the '<em><b>Use Default Validator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__USE_DEFAULT_VALIDATOR = FORM__USE_DEFAULT_VALIDATOR;

    /**
     * The feature id for the '<em><b>Below</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__BELOW = FORM__BELOW;

    /**
     * The feature id for the '<em><b>Resource Folders</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__RESOURCE_FOLDERS = FORM__RESOURCE_FOLDERS;

    /**
     * The feature id for the '<em><b>Html Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__HTML_TEMPLATE = FORM__HTML_TEMPLATE;

    /**
     * The feature id for the '<em><b>Resource Files</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__RESOURCE_FILES = FORM__RESOURCE_FILES;

    /**
     * The feature id for the '<em><b>Resource Jars</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__RESOURCE_JARS = FORM__RESOURCE_JARS;

    /**
     * The feature id for the '<em><b>Resource Validators</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__RESOURCE_VALIDATORS = FORM__RESOURCE_VALIDATORS;

    /**
     * The feature id for the '<em><b>Widgets</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__WIDGETS = FORM__WIDGETS;

    /**
     * The feature id for the '<em><b>Scripts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__SCRIPTS = FORM__SCRIPTS;

    /**
     * The feature id for the '<em><b>NColumn</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__NCOLUMN = FORM__NCOLUMN;

    /**
     * The feature id for the '<em><b>String Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__STRING_ATTRIBUTES = FORM__STRING_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>NLine</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__NLINE = FORM__NLINE;

    /**
     * The feature id for the '<em><b>Columns</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__COLUMNS = FORM__COLUMNS;

    /**
     * The feature id for the '<em><b>Lines</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__LINES = FORM__LINES;

    /**
     * The feature id for the '<em><b>Page Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__PAGE_LABEL = FORM__PAGE_LABEL;

    /**
     * The feature id for the '<em><b>Show Page Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__SHOW_PAGE_LABEL = FORM__SHOW_PAGE_LABEL;

    /**
     * The feature id for the '<em><b>Allow HTML In Page Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM__ALLOW_HTML_IN_PAGE_LABEL = FORM__ALLOW_HTML_IN_PAGE_LABEL;

    /**
     * The number of structural features of the '<em>View Form</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FORM_FEATURE_COUNT = FORM_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.EventDependencyType <em>Event Dependency Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.EventDependencyType
     * @see org.talend.process.model.form.impl.FormPackageImpl#getEventDependencyType()
     * @generated
     */
    int EVENT_DEPENDENCY_TYPE = 39;

    /**
     * The meta object id for the '{@link org.talend.process.model.form.LabelPosition <em>Label Position</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.form.LabelPosition
     * @see org.talend.process.model.form.impl.FormPackageImpl#getLabelPosition()
     * @generated
     */
    int LABEL_POSITION = 40;


    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.Form <em>Form</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Form</em>'.
     * @see org.talend.process.model.form.Form
     * @generated
     */
    EClass getForm();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Form#getWidgets <em>Widgets</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Widgets</em>'.
     * @see org.talend.process.model.form.Form#getWidgets()
     * @see #getForm()
     * @generated
     */
    EReference getForm_Widgets();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Form#getScripts <em>Scripts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Scripts</em>'.
     * @see org.talend.process.model.form.Form#getScripts()
     * @see #getForm()
     * @generated
     */
    EReference getForm_Scripts();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Form#getNColumn <em>NColumn</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>NColumn</em>'.
     * @see org.talend.process.model.form.Form#getNColumn()
     * @see #getForm()
     * @generated
     */
    EAttribute getForm_NColumn();

    /**
     * Returns the meta object for the map '{@link org.talend.process.model.form.Form#getStringAttributes <em>String Attributes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>String Attributes</em>'.
     * @see org.talend.process.model.form.Form#getStringAttributes()
     * @see #getForm()
     * @generated
     */
    EReference getForm_StringAttributes();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Form#getNLine <em>NLine</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>NLine</em>'.
     * @see org.talend.process.model.form.Form#getNLine()
     * @see #getForm()
     * @generated
     */
    EAttribute getForm_NLine();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Form#getColumns <em>Columns</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Columns</em>'.
     * @see org.talend.process.model.form.Form#getColumns()
     * @see #getForm()
     * @generated
     */
    EReference getForm_Columns();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Form#getLines <em>Lines</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Lines</em>'.
     * @see org.talend.process.model.form.Form#getLines()
     * @see #getForm()
     * @generated
     */
    EReference getForm_Lines();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Form#getPageLabel <em>Page Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Page Label</em>'.
     * @see org.talend.process.model.form.Form#getPageLabel()
     * @see #getForm()
     * @generated
     */
    EAttribute getForm_PageLabel();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Form#getShowPageLabel <em>Show Page Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Show Page Label</em>'.
     * @see org.talend.process.model.form.Form#getShowPageLabel()
     * @see #getForm()
     * @generated
     */
    EAttribute getForm_ShowPageLabel();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Form#isAllowHTMLInPageLabel <em>Allow HTML In Page Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Allow HTML In Page Label</em>'.
     * @see org.talend.process.model.form.Form#isAllowHTMLInPageLabel()
     * @see #getForm()
     * @generated
     */
    EAttribute getForm_AllowHTMLInPageLabel();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.Widget <em>Widget</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Widget</em>'.
     * @see org.talend.process.model.form.Widget
     * @generated
     */
    EClass getWidget();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.form.Widget#getScript <em>Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Script</em>'.
     * @see org.talend.process.model.form.Widget#getScript()
     * @see #getWidget()
     * @generated
     */
    EReference getWidget_Script();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Widget#getTooltip <em>Tooltip</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tooltip</em>'.
     * @see org.talend.process.model.form.Widget#getTooltip()
     * @see #getWidget()
     * @generated
     */
    EAttribute getWidget_Tooltip();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.form.Widget#getWidgetLayoutInfo <em>Widget Layout Info</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Widget Layout Info</em>'.
     * @see org.talend.process.model.form.Widget#getWidgetLayoutInfo()
     * @see #getWidget()
     * @generated
     */
    EReference getWidget_WidgetLayoutInfo();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Widget#getDisplayLabel <em>Display Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Display Label</em>'.
     * @see org.talend.process.model.form.Widget#getDisplayLabel()
     * @see #getWidget()
     * @generated
     */
    EAttribute getWidget_DisplayLabel();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Widget#getShowDisplayLabel <em>Show Display Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Show Display Label</em>'.
     * @see org.talend.process.model.form.Widget#getShowDisplayLabel()
     * @see #getWidget()
     * @generated
     */
    EAttribute getWidget_ShowDisplayLabel();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Widget#isAllowHTMLForDisplayLabel <em>Allow HTML For Display Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Allow HTML For Display Label</em>'.
     * @see org.talend.process.model.form.Widget#isAllowHTMLForDisplayLabel()
     * @see #getWidget()
     * @generated
     */
    EAttribute getWidget_AllowHTMLForDisplayLabel();

    /**
     * Returns the meta object for the map '{@link org.talend.process.model.form.Widget#getHtmlAttributes <em>Html Attributes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Html Attributes</em>'.
     * @see org.talend.process.model.form.Widget#getHtmlAttributes()
     * @see #getWidget()
     * @generated
     */
    EReference getWidget_HtmlAttributes();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Widget#getRealHtmlAttributes <em>Real Html Attributes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Real Html Attributes</em>'.
     * @see org.talend.process.model.form.Widget#getRealHtmlAttributes()
     * @see #getWidget()
     * @generated
     */
    EAttribute getWidget_RealHtmlAttributes();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Widget#getDependOn <em>Depend On</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Depend On</em>'.
     * @see org.talend.process.model.form.Widget#getDependOn()
     * @see #getWidget()
     * @generated
     */
    EReference getWidget_DependOn();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Widget#isDisplayDependentWidgetOnlyOnEventTriggered <em>Display Dependent Widget Only On Event Triggered</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Display Dependent Widget Only On Event Triggered</em>'.
     * @see org.talend.process.model.form.Widget#isDisplayDependentWidgetOnlyOnEventTriggered()
     * @see #getWidget()
     * @generated
     */
    EAttribute getWidget_DisplayDependentWidgetOnlyOnEventTriggered();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.form.Widget#getScriptAfterEvent <em>Script After Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Script After Event</em>'.
     * @see org.talend.process.model.form.Widget#getScriptAfterEvent()
     * @see #getWidget()
     * @generated
     */
    EReference getWidget_ScriptAfterEvent();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Widget#getParentOf <em>Parent Of</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parent Of</em>'.
     * @see org.talend.process.model.form.Widget#getParentOf()
     * @see #getWidget()
     * @generated
     */
    EReference getWidget_ParentOf();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Widget#isMandatory <em>Mandatory</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mandatory</em>'.
     * @see org.talend.process.model.form.Widget#isMandatory()
     * @see #getWidget()
     * @generated
     */
    EAttribute getWidget_Mandatory();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Widget#isReadOnly <em>Read Only</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Read Only</em>'.
     * @see org.talend.process.model.form.Widget#isReadOnly()
     * @see #getWidget()
     * @generated
     */
    EAttribute getWidget_ReadOnly();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Widget#getLabelPosition <em>Label Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label Position</em>'.
     * @see org.talend.process.model.form.Widget#getLabelPosition()
     * @see #getWidget()
     * @generated
     */
    EAttribute getWidget_LabelPosition();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Widget#getInputConnectors <em>Input Connectors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Input Connectors</em>'.
     * @see org.talend.process.model.form.Widget#getInputConnectors()
     * @see #getWidget()
     * @generated
     */
    EReference getWidget_InputConnectors();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Widget#getOutputConnectors <em>Output Connectors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Output Connectors</em>'.
     * @see org.talend.process.model.form.Widget#getOutputConnectors()
     * @see #getWidget()
     * @generated
     */
    EReference getWidget_OutputConnectors();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Widget#getAfterEventConnectors <em>After Event Connectors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>After Event Connectors</em>'.
     * @see org.talend.process.model.form.Widget#getAfterEventConnectors()
     * @see #getWidget()
     * @generated
     */
    EReference getWidget_AfterEventConnectors();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.WidgetDependency <em>Widget Dependency</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Widget Dependency</em>'.
     * @see org.talend.process.model.form.WidgetDependency
     * @generated
     */
    EClass getWidgetDependency();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.form.WidgetDependency#getWidget <em>Widget</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Widget</em>'.
     * @see org.talend.process.model.form.WidgetDependency#getWidget()
     * @see #getWidgetDependency()
     * @generated
     */
    EReference getWidgetDependency_Widget();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.process.model.form.WidgetDependency#getEventTypes <em>Event Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Event Types</em>'.
     * @see org.talend.process.model.form.WidgetDependency#getEventTypes()
     * @see #getWidgetDependency()
     * @generated
     */
    EAttribute getWidgetDependency_EventTypes();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.Group <em>Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Group</em>'.
     * @see org.talend.process.model.form.Group
     * @generated
     */
    EClass getGroup();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Group#getWidgets <em>Widgets</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Widgets</em>'.
     * @see org.talend.process.model.form.Group#getWidgets()
     * @see #getGroup()
     * @generated
     */
    EReference getGroup_Widgets();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Group#isShowBorder <em>Show Border</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Show Border</em>'.
     * @see org.talend.process.model.form.Group#isShowBorder()
     * @see #getGroup()
     * @generated
     */
    EAttribute getGroup_ShowBorder();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Group#getColumns <em>Columns</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Columns</em>'.
     * @see org.talend.process.model.form.Group#getColumns()
     * @see #getGroup()
     * @generated
     */
    EReference getGroup_Columns();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Group#getLines <em>Lines</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Lines</em>'.
     * @see org.talend.process.model.form.Group#getLines()
     * @see #getGroup()
     * @generated
     */
    EReference getGroup_Lines();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.FormField <em>Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Field</em>'.
     * @see org.talend.process.model.form.FormField
     * @generated
     */
    EClass getFormField();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.FormField#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.process.model.form.FormField#getDescription()
     * @see #getFormField()
     * @generated
     */
    EAttribute getFormField_Description();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.MultipleValuatedFormField <em>Multiple Valuated Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Multiple Valuated Form Field</em>'.
     * @see org.talend.process.model.form.MultipleValuatedFormField
     * @generated
     */
    EClass getMultipleValuatedFormField();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.MultipleValuatedFormField#getDefaultValue <em>Default Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Value</em>'.
     * @see org.talend.process.model.form.MultipleValuatedFormField#getDefaultValue()
     * @see #getMultipleValuatedFormField()
     * @generated
     */
    EAttribute getMultipleValuatedFormField_DefaultValue();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.MultipleValuatedFormField#getDefaultValueAfterEvent <em>Default Value After Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Value After Event</em>'.
     * @see org.talend.process.model.form.MultipleValuatedFormField#getDefaultValueAfterEvent()
     * @see #getMultipleValuatedFormField()
     * @generated
     */
    EAttribute getMultipleValuatedFormField_DefaultValueAfterEvent();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.form.MultipleValuatedFormField#getEnum <em>Enum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Enum</em>'.
     * @see org.talend.process.model.form.MultipleValuatedFormField#getEnum()
     * @see #getMultipleValuatedFormField()
     * @generated
     */
    EReference getMultipleValuatedFormField_Enum();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.form.MultipleValuatedFormField#getEnumAfterEvent <em>Enum After Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Enum After Event</em>'.
     * @see org.talend.process.model.form.MultipleValuatedFormField#getEnumAfterEvent()
     * @see #getMultipleValuatedFormField()
     * @generated
     */
    EReference getMultipleValuatedFormField_EnumAfterEvent();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.process.model.form.MultipleValuatedFormField#getLiterals <em>Literals</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Literals</em>'.
     * @see org.talend.process.model.form.MultipleValuatedFormField#getLiterals()
     * @see #getMultipleValuatedFormField()
     * @generated
     */
    EAttribute getMultipleValuatedFormField_Literals();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.process.model.form.MultipleValuatedFormField#getLiteralsAfterEvent <em>Literals After Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Literals After Event</em>'.
     * @see org.talend.process.model.form.MultipleValuatedFormField#getLiteralsAfterEvent()
     * @see #getMultipleValuatedFormField()
     * @generated
     */
    EAttribute getMultipleValuatedFormField_LiteralsAfterEvent();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.MultipleValuatedFormField#getDefaultConnectors <em>Default Connectors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Default Connectors</em>'.
     * @see org.talend.process.model.form.MultipleValuatedFormField#getDefaultConnectors()
     * @see #getMultipleValuatedFormField()
     * @generated
     */
    EReference getMultipleValuatedFormField_DefaultConnectors();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.MultipleValuatedFormField#getDefaultAfterEventConnectors <em>Default After Event Connectors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Default After Event Connectors</em>'.
     * @see org.talend.process.model.form.MultipleValuatedFormField#getDefaultAfterEventConnectors()
     * @see #getMultipleValuatedFormField()
     * @generated
     */
    EReference getMultipleValuatedFormField_DefaultAfterEventConnectors();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.SingleValuatedFormField <em>Single Valuated Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Single Valuated Form Field</em>'.
     * @see org.talend.process.model.form.SingleValuatedFormField
     * @generated
     */
    EClass getSingleValuatedFormField();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.CheckBoxMultipleFormField <em>Check Box Multiple Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Check Box Multiple Form Field</em>'.
     * @see org.talend.process.model.form.CheckBoxMultipleFormField
     * @generated
     */
    EClass getCheckBoxMultipleFormField();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.ComboFormField <em>Combo Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Combo Form Field</em>'.
     * @see org.talend.process.model.form.ComboFormField
     * @generated
     */
    EClass getComboFormField();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.DateFormField <em>Date Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Date Form Field</em>'.
     * @see org.talend.process.model.form.DateFormField
     * @generated
     */
    EClass getDateFormField();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.DateFormField#getInitialFormat <em>Initial Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Initial Format</em>'.
     * @see org.talend.process.model.form.DateFormField#getInitialFormat()
     * @see #getDateFormField()
     * @generated
     */
    EAttribute getDateFormField_InitialFormat();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.DateFormField#getDisplayFormat <em>Display Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Display Format</em>'.
     * @see org.talend.process.model.form.DateFormField#getDisplayFormat()
     * @see #getDateFormField()
     * @generated
     */
    EAttribute getDateFormField_DisplayFormat();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.ListFormField <em>List Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>List Form Field</em>'.
     * @see org.talend.process.model.form.ListFormField
     * @generated
     */
    EClass getListFormField();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.ListFormField#getMaxHeigth <em>Max Heigth</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Heigth</em>'.
     * @see org.talend.process.model.form.ListFormField#getMaxHeigth()
     * @see #getListFormField()
     * @generated
     */
    EAttribute getListFormField_MaxHeigth();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.PasswordFormField <em>Password Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Password Form Field</em>'.
     * @see org.talend.process.model.form.PasswordFormField
     * @generated
     */
    EClass getPasswordFormField();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.PasswordFormField#getMaxLength <em>Max Length</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Length</em>'.
     * @see org.talend.process.model.form.PasswordFormField#getMaxLength()
     * @see #getPasswordFormField()
     * @generated
     */
    EAttribute getPasswordFormField_MaxLength();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.RadioFormField <em>Radio Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Radio Form Field</em>'.
     * @see org.talend.process.model.form.RadioFormField
     * @generated
     */
    EClass getRadioFormField();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.SelectFormField <em>Select Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Select Form Field</em>'.
     * @see org.talend.process.model.form.SelectFormField
     * @generated
     */
    EClass getSelectFormField();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.TextFormField <em>Text Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text Form Field</em>'.
     * @see org.talend.process.model.form.TextFormField
     * @generated
     */
    EClass getTextFormField();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.TextFormField#getMaxLength <em>Max Length</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Length</em>'.
     * @see org.talend.process.model.form.TextFormField#getMaxLength()
     * @see #getTextFormField()
     * @generated
     */
    EAttribute getTextFormField_MaxLength();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.TextAreaFormField <em>Text Area Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text Area Form Field</em>'.
     * @see org.talend.process.model.form.TextAreaFormField
     * @generated
     */
    EClass getTextAreaFormField();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.TextAreaFormField#getMaxLength <em>Max Length</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Length</em>'.
     * @see org.talend.process.model.form.TextAreaFormField#getMaxLength()
     * @see #getTextAreaFormField()
     * @generated
     */
    EAttribute getTextAreaFormField_MaxLength();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.TextAreaFormField#getMaxHeigth <em>Max Heigth</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Heigth</em>'.
     * @see org.talend.process.model.form.TextAreaFormField#getMaxHeigth()
     * @see #getTextAreaFormField()
     * @generated
     */
    EAttribute getTextAreaFormField_MaxHeigth();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.RichTextAreaFormField <em>Rich Text Area Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rich Text Area Form Field</em>'.
     * @see org.talend.process.model.form.RichTextAreaFormField
     * @generated
     */
    EClass getRichTextAreaFormField();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.FormButton <em>Button</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Button</em>'.
     * @see org.talend.process.model.form.FormButton
     * @generated
     */
    EClass getFormButton();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.FormButton#getLabelBehavior <em>Label Behavior</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label Behavior</em>'.
     * @see org.talend.process.model.form.FormButton#getLabelBehavior()
     * @see #getFormButton()
     * @generated
     */
    EAttribute getFormButton_LabelBehavior();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.SubmitFormButton <em>Submit Form Button</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Submit Form Button</em>'.
     * @see org.talend.process.model.form.SubmitFormButton
     * @generated
     */
    EClass getSubmitFormButton();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.SubmitFormButton#getScripts <em>Scripts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Scripts</em>'.
     * @see org.talend.process.model.form.SubmitFormButton#getScripts()
     * @see #getSubmitFormButton()
     * @generated
     */
    EReference getSubmitFormButton_Scripts();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.PreviousFormButton <em>Previous Form Button</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Previous Form Button</em>'.
     * @see org.talend.process.model.form.PreviousFormButton
     * @generated
     */
    EClass getPreviousFormButton();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.NextFormButton <em>Next Form Button</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Next Form Button</em>'.
     * @see org.talend.process.model.form.NextFormButton
     * @generated
     */
    EClass getNextFormButton();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.GroovyScript <em>Groovy Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Groovy Script</em>'.
     * @see org.talend.process.model.form.GroovyScript
     * @generated
     */
    EClass getGroovyScript();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.GroovyScript#getExprScript <em>Expr Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Expr Script</em>'.
     * @see org.talend.process.model.form.GroovyScript#getExprScript()
     * @see #getGroovyScript()
     * @generated
     */
    EAttribute getGroovyScript_ExprScript();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.GroovyScript#getInputScript <em>Input Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Input Script</em>'.
     * @see org.talend.process.model.form.GroovyScript#getInputScript()
     * @see #getGroovyScript()
     * @generated
     */
    EAttribute getGroovyScript_InputScript();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.form.GroovyScript#getSetVar <em>Set Var</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Set Var</em>'.
     * @see org.talend.process.model.form.GroovyScript#getSetVar()
     * @see #getGroovyScript()
     * @generated
     */
    EReference getGroovyScript_SetVar();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.GroovyScript#isAllowHTMLInValues <em>Allow HTML In Values</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Allow HTML In Values</em>'.
     * @see org.talend.process.model.form.GroovyScript#isAllowHTMLInValues()
     * @see #getGroovyScript()
     * @generated
     */
    EAttribute getGroovyScript_AllowHTMLInValues();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.GroovyScript#getSetVarScript <em>Set Var Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Set Var Script</em>'.
     * @see org.talend.process.model.form.GroovyScript#getSetVarScript()
     * @see #getGroovyScript()
     * @generated
     */
    EAttribute getGroovyScript_SetVarScript();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.Info <em>Info</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Info</em>'.
     * @see org.talend.process.model.form.Info
     * @generated
     */
    EClass getInfo();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.TextInfo <em>Text Info</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text Info</em>'.
     * @see org.talend.process.model.form.TextInfo
     * @generated
     */
    EClass getTextInfo();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.MessageInfo <em>Message Info</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Message Info</em>'.
     * @see org.talend.process.model.form.MessageInfo
     * @generated
     */
    EClass getMessageInfo();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.CheckBoxSingleFormField <em>Check Box Single Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Check Box Single Form Field</em>'.
     * @see org.talend.process.model.form.CheckBoxSingleFormField
     * @generated
     */
    EClass getCheckBoxSingleFormField();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.Validator <em>Validator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Validator</em>'.
     * @see org.talend.process.model.form.Validator
     * @generated
     */
    EClass getValidator();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Validator#getValidatorClass <em>Validator Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Validator Class</em>'.
     * @see org.talend.process.model.form.Validator#getValidatorClass()
     * @see #getValidator()
     * @generated
     */
    EAttribute getValidator_ValidatorClass();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Validator#getHtmlClass <em>Html Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Html Class</em>'.
     * @see org.talend.process.model.form.Validator#getHtmlClass()
     * @see #getValidator()
     * @generated
     */
    EAttribute getValidator_HtmlClass();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Validator#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.process.model.form.Validator#getLabel()
     * @see #getValidator()
     * @generated
     */
    EAttribute getValidator_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Validator#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.talend.process.model.form.Validator#getName()
     * @see #getValidator()
     * @generated
     */
    EAttribute getValidator_Name();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Validator#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Parameter</em>'.
     * @see org.talend.process.model.form.Validator#getParameter()
     * @see #getValidator()
     * @generated
     */
    EAttribute getValidator_Parameter();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Validator#isBelowField <em>Below Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Below Field</em>'.
     * @see org.talend.process.model.form.Validator#isBelowField()
     * @see #getValidator()
     * @generated
     */
    EAttribute getValidator_BelowField();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.Validable <em>Validable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Validable</em>'.
     * @see org.talend.process.model.form.Validable
     * @generated
     */
    EClass getValidable();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.form.Validable#getValidators <em>Validators</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Validators</em>'.
     * @see org.talend.process.model.form.Validable#getValidators()
     * @see #getValidable()
     * @generated
     */
    EReference getValidable_Validators();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Validable#getUseDefaultValidator <em>Use Default Validator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Use Default Validator</em>'.
     * @see org.talend.process.model.form.Validable#getUseDefaultValidator()
     * @see #getValidable()
     * @generated
     */
    EAttribute getValidable_UseDefaultValidator();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Validable#isBelow <em>Below</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Below</em>'.
     * @see org.talend.process.model.form.Validable#isBelow()
     * @see #getValidable()
     * @generated
     */
    EAttribute getValidable_Below();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.WidgetLayoutInfo <em>Widget Layout Info</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Widget Layout Info</em>'.
     * @see org.talend.process.model.form.WidgetLayoutInfo
     * @generated
     */
    EClass getWidgetLayoutInfo();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.WidgetLayoutInfo#getLine <em>Line</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Line</em>'.
     * @see org.talend.process.model.form.WidgetLayoutInfo#getLine()
     * @see #getWidgetLayoutInfo()
     * @generated
     */
    EAttribute getWidgetLayoutInfo_Line();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.WidgetLayoutInfo#getColumn <em>Column</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Column</em>'.
     * @see org.talend.process.model.form.WidgetLayoutInfo#getColumn()
     * @see #getWidgetLayoutInfo()
     * @generated
     */
    EAttribute getWidgetLayoutInfo_Column();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.WidgetLayoutInfo#getVerticalSpan <em>Vertical Span</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Vertical Span</em>'.
     * @see org.talend.process.model.form.WidgetLayoutInfo#getVerticalSpan()
     * @see #getWidgetLayoutInfo()
     * @generated
     */
    EAttribute getWidgetLayoutInfo_VerticalSpan();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.WidgetLayoutInfo#getHorizontalSpan <em>Horizontal Span</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Horizontal Span</em>'.
     * @see org.talend.process.model.form.WidgetLayoutInfo#getHorizontalSpan()
     * @see #getWidgetLayoutInfo()
     * @generated
     */
    EAttribute getWidgetLayoutInfo_HorizontalSpan();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.FileWidget <em>File Widget</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>File Widget</em>'.
     * @see org.talend.process.model.form.FileWidget
     * @generated
     */
    EClass getFileWidget();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.form.FileWidget#getFileData <em>File Data</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>File Data</em>'.
     * @see org.talend.process.model.form.FileWidget#getFileData()
     * @see #getFileWidget()
     * @generated
     */
    EReference getFileWidget_FileData();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.FileWidget#isDownloadOnly <em>Download Only</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Download Only</em>'.
     * @see org.talend.process.model.form.FileWidget#isDownloadOnly()
     * @see #getFileWidget()
     * @generated
     */
    EAttribute getFileWidget_DownloadOnly();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.FileWidget#isUsePreview <em>Use Preview</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Use Preview</em>'.
     * @see org.talend.process.model.form.FileWidget#isUsePreview()
     * @see #getFileWidget()
     * @generated
     */
    EAttribute getFileWidget_UsePreview();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.Column <em>Column</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Column</em>'.
     * @see org.talend.process.model.form.Column
     * @generated
     */
    EClass getColumn();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Column#getWidth <em>Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Width</em>'.
     * @see org.talend.process.model.form.Column#getWidth()
     * @see #getColumn()
     * @generated
     */
    EAttribute getColumn_Width();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Column#getNumber <em>Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Number</em>'.
     * @see org.talend.process.model.form.Column#getNumber()
     * @see #getColumn()
     * @generated
     */
    EAttribute getColumn_Number();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.Line <em>Line</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Line</em>'.
     * @see org.talend.process.model.form.Line
     * @generated
     */
    EClass getLine();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Line#getHeight <em>Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Height</em>'.
     * @see org.talend.process.model.form.Line#getHeight()
     * @see #getLine()
     * @generated
     */
    EAttribute getLine_Height();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Line#getNumber <em>Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Number</em>'.
     * @see org.talend.process.model.form.Line#getNumber()
     * @see #getLine()
     * @generated
     */
    EAttribute getLine_Number();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.ImageWidget <em>Image Widget</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Image Widget</em>'.
     * @see org.talend.process.model.form.ImageWidget
     * @generated
     */
    EClass getImageWidget();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.ImageWidget#getImgPath <em>Img Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Img Path</em>'.
     * @see org.talend.process.model.form.ImageWidget#getImgPath()
     * @see #getImageWidget()
     * @generated
     */
    EAttribute getImageWidget_ImgPath();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.ImageWidget#isIsAnAttachment <em>Is An Attachment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is An Attachment</em>'.
     * @see org.talend.process.model.form.ImageWidget#isIsAnAttachment()
     * @see #getImageWidget()
     * @generated
     */
    EAttribute getImageWidget_IsAnAttachment();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.HiddenWidget <em>Hidden Widget</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Hidden Widget</em>'.
     * @see org.talend.process.model.form.HiddenWidget
     * @generated
     */
    EClass getHiddenWidget();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.DurationFormField <em>Duration Form Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Duration Form Field</em>'.
     * @see org.talend.process.model.form.DurationFormField
     * @generated
     */
    EClass getDurationFormField();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.DurationFormField#getDay <em>Day</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Day</em>'.
     * @see org.talend.process.model.form.DurationFormField#getDay()
     * @see #getDurationFormField()
     * @generated
     */
    EAttribute getDurationFormField_Day();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.DurationFormField#getHour <em>Hour</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Hour</em>'.
     * @see org.talend.process.model.form.DurationFormField#getHour()
     * @see #getDurationFormField()
     * @generated
     */
    EAttribute getDurationFormField_Hour();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.DurationFormField#getMin <em>Min</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Min</em>'.
     * @see org.talend.process.model.form.DurationFormField#getMin()
     * @see #getDurationFormField()
     * @generated
     */
    EAttribute getDurationFormField_Min();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.DurationFormField#getSec <em>Sec</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sec</em>'.
     * @see org.talend.process.model.form.DurationFormField#getSec()
     * @see #getDurationFormField()
     * @generated
     */
    EAttribute getDurationFormField_Sec();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.ItemContainer <em>Item Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Container</em>'.
     * @see org.talend.process.model.form.ItemContainer
     * @generated
     */
    EClass getItemContainer();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.ItemContainer#getItemClass <em>Item Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Item Class</em>'.
     * @see org.talend.process.model.form.ItemContainer#getItemClass()
     * @see #getItemContainer()
     * @generated
     */
    EAttribute getItemContainer_ItemClass();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.Duplicable <em>Duplicable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Duplicable</em>'.
     * @see org.talend.process.model.form.Duplicable
     * @generated
     */
    EClass getDuplicable();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Duplicable#isDuplicate <em>Duplicate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Duplicate</em>'.
     * @see org.talend.process.model.form.Duplicable#isDuplicate()
     * @see #getDuplicable()
     * @generated
     */
    EAttribute getDuplicable_Duplicate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Duplicable#isLimitNumberOfDuplication <em>Limit Number Of Duplication</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Limit Number Of Duplication</em>'.
     * @see org.talend.process.model.form.Duplicable#isLimitNumberOfDuplication()
     * @see #getDuplicable()
     * @generated
     */
    EAttribute getDuplicable_LimitNumberOfDuplication();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Duplicable#getMaxNumberOfDuplication <em>Max Number Of Duplication</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Number Of Duplication</em>'.
     * @see org.talend.process.model.form.Duplicable#getMaxNumberOfDuplication()
     * @see #getDuplicable()
     * @generated
     */
    EAttribute getDuplicable_MaxNumberOfDuplication();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Duplicable#isLimitMinNumberOfDuplication <em>Limit Min Number Of Duplication</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Limit Min Number Of Duplication</em>'.
     * @see org.talend.process.model.form.Duplicable#isLimitMinNumberOfDuplication()
     * @see #getDuplicable()
     * @generated
     */
    EAttribute getDuplicable_LimitMinNumberOfDuplication();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Duplicable#getMinNumberOfDuplication <em>Min Number Of Duplication</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Min Number Of Duplication</em>'.
     * @see org.talend.process.model.form.Duplicable#getMinNumberOfDuplication()
     * @see #getDuplicable()
     * @generated
     */
    EAttribute getDuplicable_MinNumberOfDuplication();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Duplicable#getDisplayLabelForAdd <em>Display Label For Add</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Display Label For Add</em>'.
     * @see org.talend.process.model.form.Duplicable#getDisplayLabelForAdd()
     * @see #getDuplicable()
     * @generated
     */
    EAttribute getDuplicable_DisplayLabelForAdd();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Duplicable#getTooltipForAdd <em>Tooltip For Add</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tooltip For Add</em>'.
     * @see org.talend.process.model.form.Duplicable#getTooltipForAdd()
     * @see #getDuplicable()
     * @generated
     */
    EAttribute getDuplicable_TooltipForAdd();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Duplicable#getDisplayLabelForRemove <em>Display Label For Remove</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Display Label For Remove</em>'.
     * @see org.talend.process.model.form.Duplicable#getDisplayLabelForRemove()
     * @see #getDuplicable()
     * @generated
     */
    EAttribute getDuplicable_DisplayLabelForRemove();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Duplicable#getTooltipForRemove <em>Tooltip For Remove</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tooltip For Remove</em>'.
     * @see org.talend.process.model.form.Duplicable#getTooltipForRemove()
     * @see #getDuplicable()
     * @generated
     */
    EAttribute getDuplicable_TooltipForRemove();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.Table <em>Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Table</em>'.
     * @see org.talend.process.model.form.Table
     * @generated
     */
    EClass getTable();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Table#isLeftColumnIsHeader <em>Left Column Is Header</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Left Column Is Header</em>'.
     * @see org.talend.process.model.form.Table#isLeftColumnIsHeader()
     * @see #getTable()
     * @generated
     */
    EAttribute getTable_LeftColumnIsHeader();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Table#isRightColumnIsHeader <em>Right Column Is Header</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Right Column Is Header</em>'.
     * @see org.talend.process.model.form.Table#isRightColumnIsHeader()
     * @see #getTable()
     * @generated
     */
    EAttribute getTable_RightColumnIsHeader();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Table#isFirstRowIsHeader <em>First Row Is Header</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>First Row Is Header</em>'.
     * @see org.talend.process.model.form.Table#isFirstRowIsHeader()
     * @see #getTable()
     * @generated
     */
    EAttribute getTable_FirstRowIsHeader();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Table#isLastRowIsHeader <em>Last Row Is Header</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Row Is Header</em>'.
     * @see org.talend.process.model.form.Table#isLastRowIsHeader()
     * @see #getTable()
     * @generated
     */
    EAttribute getTable_LastRowIsHeader();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Table#isInitializedUsingCells <em>Initialized Using Cells</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Initialized Using Cells</em>'.
     * @see org.talend.process.model.form.Table#isInitializedUsingCells()
     * @see #getTable()
     * @generated
     */
    EAttribute getTable_InitializedUsingCells();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.form.Table#getCells <em>Cells</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Cells</em>'.
     * @see org.talend.process.model.form.Table#getCells()
     * @see #getTable()
     * @generated
     */
    EAttribute getTable_Cells();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.form.ViewForm <em>View Form</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Form</em>'.
     * @see org.talend.process.model.form.ViewForm
     * @generated
     */
    EClass getViewForm();

    /**
     * Returns the meta object for enum '{@link org.talend.process.model.form.EventDependencyType <em>Event Dependency Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Event Dependency Type</em>'.
     * @see org.talend.process.model.form.EventDependencyType
     * @generated
     */
    EEnum getEventDependencyType();

    /**
     * Returns the meta object for enum '{@link org.talend.process.model.form.LabelPosition <em>Label Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Label Position</em>'.
     * @see org.talend.process.model.form.LabelPosition
     * @generated
     */
    EEnum getLabelPosition();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    FormFactory getFormFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.FormImpl <em>Form</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.FormImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getForm()
         * @generated
         */
        EClass FORM = eINSTANCE.getForm();

        /**
         * The meta object literal for the '<em><b>Widgets</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORM__WIDGETS = eINSTANCE.getForm_Widgets();

        /**
         * The meta object literal for the '<em><b>Scripts</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORM__SCRIPTS = eINSTANCE.getForm_Scripts();

        /**
         * The meta object literal for the '<em><b>NColumn</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORM__NCOLUMN = eINSTANCE.getForm_NColumn();

        /**
         * The meta object literal for the '<em><b>String Attributes</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORM__STRING_ATTRIBUTES = eINSTANCE.getForm_StringAttributes();

        /**
         * The meta object literal for the '<em><b>NLine</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORM__NLINE = eINSTANCE.getForm_NLine();

        /**
         * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORM__COLUMNS = eINSTANCE.getForm_Columns();

        /**
         * The meta object literal for the '<em><b>Lines</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORM__LINES = eINSTANCE.getForm_Lines();

        /**
         * The meta object literal for the '<em><b>Page Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORM__PAGE_LABEL = eINSTANCE.getForm_PageLabel();

        /**
         * The meta object literal for the '<em><b>Show Page Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORM__SHOW_PAGE_LABEL = eINSTANCE.getForm_ShowPageLabel();

        /**
         * The meta object literal for the '<em><b>Allow HTML In Page Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORM__ALLOW_HTML_IN_PAGE_LABEL = eINSTANCE.getForm_AllowHTMLInPageLabel();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.Widget <em>Widget</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.Widget
         * @see org.talend.process.model.form.impl.FormPackageImpl#getWidget()
         * @generated
         */
        EClass WIDGET = eINSTANCE.getWidget();

        /**
         * The meta object literal for the '<em><b>Script</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WIDGET__SCRIPT = eINSTANCE.getWidget_Script();

        /**
         * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET__TOOLTIP = eINSTANCE.getWidget_Tooltip();

        /**
         * The meta object literal for the '<em><b>Widget Layout Info</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WIDGET__WIDGET_LAYOUT_INFO = eINSTANCE.getWidget_WidgetLayoutInfo();

        /**
         * The meta object literal for the '<em><b>Display Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET__DISPLAY_LABEL = eINSTANCE.getWidget_DisplayLabel();

        /**
         * The meta object literal for the '<em><b>Show Display Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET__SHOW_DISPLAY_LABEL = eINSTANCE.getWidget_ShowDisplayLabel();

        /**
         * The meta object literal for the '<em><b>Allow HTML For Display Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET__ALLOW_HTML_FOR_DISPLAY_LABEL = eINSTANCE.getWidget_AllowHTMLForDisplayLabel();

        /**
         * The meta object literal for the '<em><b>Html Attributes</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WIDGET__HTML_ATTRIBUTES = eINSTANCE.getWidget_HtmlAttributes();

        /**
         * The meta object literal for the '<em><b>Real Html Attributes</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET__REAL_HTML_ATTRIBUTES = eINSTANCE.getWidget_RealHtmlAttributes();

        /**
         * The meta object literal for the '<em><b>Depend On</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WIDGET__DEPEND_ON = eINSTANCE.getWidget_DependOn();

        /**
         * The meta object literal for the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET__DISPLAY_DEPENDENT_WIDGET_ONLY_ON_EVENT_TRIGGERED = eINSTANCE.getWidget_DisplayDependentWidgetOnlyOnEventTriggered();

        /**
         * The meta object literal for the '<em><b>Script After Event</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WIDGET__SCRIPT_AFTER_EVENT = eINSTANCE.getWidget_ScriptAfterEvent();

        /**
         * The meta object literal for the '<em><b>Parent Of</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WIDGET__PARENT_OF = eINSTANCE.getWidget_ParentOf();

        /**
         * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET__MANDATORY = eINSTANCE.getWidget_Mandatory();

        /**
         * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET__READ_ONLY = eINSTANCE.getWidget_ReadOnly();

        /**
         * The meta object literal for the '<em><b>Label Position</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET__LABEL_POSITION = eINSTANCE.getWidget_LabelPosition();

        /**
         * The meta object literal for the '<em><b>Input Connectors</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WIDGET__INPUT_CONNECTORS = eINSTANCE.getWidget_InputConnectors();

        /**
         * The meta object literal for the '<em><b>Output Connectors</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WIDGET__OUTPUT_CONNECTORS = eINSTANCE.getWidget_OutputConnectors();

        /**
         * The meta object literal for the '<em><b>After Event Connectors</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WIDGET__AFTER_EVENT_CONNECTORS = eINSTANCE.getWidget_AfterEventConnectors();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.WidgetDependencyImpl <em>Widget Dependency</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.WidgetDependencyImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getWidgetDependency()
         * @generated
         */
        EClass WIDGET_DEPENDENCY = eINSTANCE.getWidgetDependency();

        /**
         * The meta object literal for the '<em><b>Widget</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WIDGET_DEPENDENCY__WIDGET = eINSTANCE.getWidgetDependency_Widget();

        /**
         * The meta object literal for the '<em><b>Event Types</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET_DEPENDENCY__EVENT_TYPES = eINSTANCE.getWidgetDependency_EventTypes();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.GroupImpl <em>Group</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.GroupImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getGroup()
         * @generated
         */
        EClass GROUP = eINSTANCE.getGroup();

        /**
         * The meta object literal for the '<em><b>Widgets</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GROUP__WIDGETS = eINSTANCE.getGroup_Widgets();

        /**
         * The meta object literal for the '<em><b>Show Border</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP__SHOW_BORDER = eINSTANCE.getGroup_ShowBorder();

        /**
         * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GROUP__COLUMNS = eINSTANCE.getGroup_Columns();

        /**
         * The meta object literal for the '<em><b>Lines</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GROUP__LINES = eINSTANCE.getGroup_Lines();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.FormFieldImpl <em>Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.FormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getFormField()
         * @generated
         */
        EClass FORM_FIELD = eINSTANCE.getFormField();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORM_FIELD__DESCRIPTION = eINSTANCE.getFormField_Description();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl <em>Multiple Valuated Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.MultipleValuatedFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getMultipleValuatedFormField()
         * @generated
         */
        EClass MULTIPLE_VALUATED_FORM_FIELD = eINSTANCE.getMultipleValuatedFormField();

        /**
         * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE = eINSTANCE.getMultipleValuatedFormField_DefaultValue();

        /**
         * The meta object literal for the '<em><b>Default Value After Event</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_VALUE_AFTER_EVENT = eINSTANCE.getMultipleValuatedFormField_DefaultValueAfterEvent();

        /**
         * The meta object literal for the '<em><b>Enum</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MULTIPLE_VALUATED_FORM_FIELD__ENUM = eINSTANCE.getMultipleValuatedFormField_Enum();

        /**
         * The meta object literal for the '<em><b>Enum After Event</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MULTIPLE_VALUATED_FORM_FIELD__ENUM_AFTER_EVENT = eINSTANCE.getMultipleValuatedFormField_EnumAfterEvent();

        /**
         * The meta object literal for the '<em><b>Literals</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MULTIPLE_VALUATED_FORM_FIELD__LITERALS = eINSTANCE.getMultipleValuatedFormField_Literals();

        /**
         * The meta object literal for the '<em><b>Literals After Event</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MULTIPLE_VALUATED_FORM_FIELD__LITERALS_AFTER_EVENT = eINSTANCE.getMultipleValuatedFormField_LiteralsAfterEvent();

        /**
         * The meta object literal for the '<em><b>Default Connectors</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_CONNECTORS = eINSTANCE.getMultipleValuatedFormField_DefaultConnectors();

        /**
         * The meta object literal for the '<em><b>Default After Event Connectors</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MULTIPLE_VALUATED_FORM_FIELD__DEFAULT_AFTER_EVENT_CONNECTORS = eINSTANCE.getMultipleValuatedFormField_DefaultAfterEventConnectors();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.SingleValuatedFormFieldImpl <em>Single Valuated Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.SingleValuatedFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getSingleValuatedFormField()
         * @generated
         */
        EClass SINGLE_VALUATED_FORM_FIELD = eINSTANCE.getSingleValuatedFormField();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.CheckBoxMultipleFormFieldImpl <em>Check Box Multiple Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.CheckBoxMultipleFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getCheckBoxMultipleFormField()
         * @generated
         */
        EClass CHECK_BOX_MULTIPLE_FORM_FIELD = eINSTANCE.getCheckBoxMultipleFormField();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.ComboFormFieldImpl <em>Combo Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.ComboFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getComboFormField()
         * @generated
         */
        EClass COMBO_FORM_FIELD = eINSTANCE.getComboFormField();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.DateFormFieldImpl <em>Date Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.DateFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getDateFormField()
         * @generated
         */
        EClass DATE_FORM_FIELD = eINSTANCE.getDateFormField();

        /**
         * The meta object literal for the '<em><b>Initial Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATE_FORM_FIELD__INITIAL_FORMAT = eINSTANCE.getDateFormField_InitialFormat();

        /**
         * The meta object literal for the '<em><b>Display Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATE_FORM_FIELD__DISPLAY_FORMAT = eINSTANCE.getDateFormField_DisplayFormat();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.ListFormFieldImpl <em>List Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.ListFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getListFormField()
         * @generated
         */
        EClass LIST_FORM_FIELD = eINSTANCE.getListFormField();

        /**
         * The meta object literal for the '<em><b>Max Heigth</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LIST_FORM_FIELD__MAX_HEIGTH = eINSTANCE.getListFormField_MaxHeigth();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.PasswordFormFieldImpl <em>Password Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.PasswordFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getPasswordFormField()
         * @generated
         */
        EClass PASSWORD_FORM_FIELD = eINSTANCE.getPasswordFormField();

        /**
         * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PASSWORD_FORM_FIELD__MAX_LENGTH = eINSTANCE.getPasswordFormField_MaxLength();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.RadioFormFieldImpl <em>Radio Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.RadioFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getRadioFormField()
         * @generated
         */
        EClass RADIO_FORM_FIELD = eINSTANCE.getRadioFormField();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.SelectFormFieldImpl <em>Select Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.SelectFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getSelectFormField()
         * @generated
         */
        EClass SELECT_FORM_FIELD = eINSTANCE.getSelectFormField();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.TextFormFieldImpl <em>Text Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.TextFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getTextFormField()
         * @generated
         */
        EClass TEXT_FORM_FIELD = eINSTANCE.getTextFormField();

        /**
         * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_FORM_FIELD__MAX_LENGTH = eINSTANCE.getTextFormField_MaxLength();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.TextAreaFormFieldImpl <em>Text Area Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.TextAreaFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getTextAreaFormField()
         * @generated
         */
        EClass TEXT_AREA_FORM_FIELD = eINSTANCE.getTextAreaFormField();

        /**
         * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_AREA_FORM_FIELD__MAX_LENGTH = eINSTANCE.getTextAreaFormField_MaxLength();

        /**
         * The meta object literal for the '<em><b>Max Heigth</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_AREA_FORM_FIELD__MAX_HEIGTH = eINSTANCE.getTextAreaFormField_MaxHeigth();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.RichTextAreaFormFieldImpl <em>Rich Text Area Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.RichTextAreaFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getRichTextAreaFormField()
         * @generated
         */
        EClass RICH_TEXT_AREA_FORM_FIELD = eINSTANCE.getRichTextAreaFormField();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.FormButtonImpl <em>Button</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.FormButtonImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getFormButton()
         * @generated
         */
        EClass FORM_BUTTON = eINSTANCE.getFormButton();

        /**
         * The meta object literal for the '<em><b>Label Behavior</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORM_BUTTON__LABEL_BEHAVIOR = eINSTANCE.getFormButton_LabelBehavior();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.SubmitFormButtonImpl <em>Submit Form Button</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.SubmitFormButtonImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getSubmitFormButton()
         * @generated
         */
        EClass SUBMIT_FORM_BUTTON = eINSTANCE.getSubmitFormButton();

        /**
         * The meta object literal for the '<em><b>Scripts</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SUBMIT_FORM_BUTTON__SCRIPTS = eINSTANCE.getSubmitFormButton_Scripts();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.PreviousFormButtonImpl <em>Previous Form Button</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.PreviousFormButtonImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getPreviousFormButton()
         * @generated
         */
        EClass PREVIOUS_FORM_BUTTON = eINSTANCE.getPreviousFormButton();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.NextFormButtonImpl <em>Next Form Button</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.NextFormButtonImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getNextFormButton()
         * @generated
         */
        EClass NEXT_FORM_BUTTON = eINSTANCE.getNextFormButton();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.GroovyScriptImpl <em>Groovy Script</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.GroovyScriptImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getGroovyScript()
         * @generated
         */
        EClass GROOVY_SCRIPT = eINSTANCE.getGroovyScript();

        /**
         * The meta object literal for the '<em><b>Expr Script</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROOVY_SCRIPT__EXPR_SCRIPT = eINSTANCE.getGroovyScript_ExprScript();

        /**
         * The meta object literal for the '<em><b>Input Script</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROOVY_SCRIPT__INPUT_SCRIPT = eINSTANCE.getGroovyScript_InputScript();

        /**
         * The meta object literal for the '<em><b>Set Var</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GROOVY_SCRIPT__SET_VAR = eINSTANCE.getGroovyScript_SetVar();

        /**
         * The meta object literal for the '<em><b>Allow HTML In Values</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROOVY_SCRIPT__ALLOW_HTML_IN_VALUES = eINSTANCE.getGroovyScript_AllowHTMLInValues();

        /**
         * The meta object literal for the '<em><b>Set Var Script</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROOVY_SCRIPT__SET_VAR_SCRIPT = eINSTANCE.getGroovyScript_SetVarScript();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.InfoImpl <em>Info</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.InfoImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getInfo()
         * @generated
         */
        EClass INFO = eINSTANCE.getInfo();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.TextInfoImpl <em>Text Info</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.TextInfoImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getTextInfo()
         * @generated
         */
        EClass TEXT_INFO = eINSTANCE.getTextInfo();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.MessageInfoImpl <em>Message Info</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.MessageInfoImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getMessageInfo()
         * @generated
         */
        EClass MESSAGE_INFO = eINSTANCE.getMessageInfo();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.CheckBoxSingleFormFieldImpl <em>Check Box Single Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.CheckBoxSingleFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getCheckBoxSingleFormField()
         * @generated
         */
        EClass CHECK_BOX_SINGLE_FORM_FIELD = eINSTANCE.getCheckBoxSingleFormField();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.ValidatorImpl <em>Validator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.ValidatorImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getValidator()
         * @generated
         */
        EClass VALIDATOR = eINSTANCE.getValidator();

        /**
         * The meta object literal for the '<em><b>Validator Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALIDATOR__VALIDATOR_CLASS = eINSTANCE.getValidator_ValidatorClass();

        /**
         * The meta object literal for the '<em><b>Html Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALIDATOR__HTML_CLASS = eINSTANCE.getValidator_HtmlClass();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALIDATOR__LABEL = eINSTANCE.getValidator_Label();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALIDATOR__NAME = eINSTANCE.getValidator_Name();

        /**
         * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALIDATOR__PARAMETER = eINSTANCE.getValidator_Parameter();

        /**
         * The meta object literal for the '<em><b>Below Field</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALIDATOR__BELOW_FIELD = eINSTANCE.getValidator_BelowField();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.ValidableImpl <em>Validable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.ValidableImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getValidable()
         * @generated
         */
        EClass VALIDABLE = eINSTANCE.getValidable();

        /**
         * The meta object literal for the '<em><b>Validators</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VALIDABLE__VALIDATORS = eINSTANCE.getValidable_Validators();

        /**
         * The meta object literal for the '<em><b>Use Default Validator</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALIDABLE__USE_DEFAULT_VALIDATOR = eINSTANCE.getValidable_UseDefaultValidator();

        /**
         * The meta object literal for the '<em><b>Below</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALIDABLE__BELOW = eINSTANCE.getValidable_Below();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.WidgetLayoutInfoImpl <em>Widget Layout Info</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.WidgetLayoutInfoImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getWidgetLayoutInfo()
         * @generated
         */
        EClass WIDGET_LAYOUT_INFO = eINSTANCE.getWidgetLayoutInfo();

        /**
         * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET_LAYOUT_INFO__LINE = eINSTANCE.getWidgetLayoutInfo_Line();

        /**
         * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET_LAYOUT_INFO__COLUMN = eINSTANCE.getWidgetLayoutInfo_Column();

        /**
         * The meta object literal for the '<em><b>Vertical Span</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET_LAYOUT_INFO__VERTICAL_SPAN = eINSTANCE.getWidgetLayoutInfo_VerticalSpan();

        /**
         * The meta object literal for the '<em><b>Horizontal Span</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WIDGET_LAYOUT_INFO__HORIZONTAL_SPAN = eINSTANCE.getWidgetLayoutInfo_HorizontalSpan();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.FileWidgetImpl <em>File Widget</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.FileWidgetImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getFileWidget()
         * @generated
         */
        EClass FILE_WIDGET = eINSTANCE.getFileWidget();

        /**
         * The meta object literal for the '<em><b>File Data</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FILE_WIDGET__FILE_DATA = eINSTANCE.getFileWidget_FileData();

        /**
         * The meta object literal for the '<em><b>Download Only</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_WIDGET__DOWNLOAD_ONLY = eINSTANCE.getFileWidget_DownloadOnly();

        /**
         * The meta object literal for the '<em><b>Use Preview</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_WIDGET__USE_PREVIEW = eINSTANCE.getFileWidget_UsePreview();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.ColumnImpl <em>Column</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.ColumnImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getColumn()
         * @generated
         */
        EClass COLUMN = eINSTANCE.getColumn();

        /**
         * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN__WIDTH = eINSTANCE.getColumn_Width();

        /**
         * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN__NUMBER = eINSTANCE.getColumn_Number();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.LineImpl <em>Line</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.LineImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getLine()
         * @generated
         */
        EClass LINE = eINSTANCE.getLine();

        /**
         * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINE__HEIGHT = eINSTANCE.getLine_Height();

        /**
         * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINE__NUMBER = eINSTANCE.getLine_Number();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.ImageWidgetImpl <em>Image Widget</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.ImageWidgetImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getImageWidget()
         * @generated
         */
        EClass IMAGE_WIDGET = eINSTANCE.getImageWidget();

        /**
         * The meta object literal for the '<em><b>Img Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IMAGE_WIDGET__IMG_PATH = eINSTANCE.getImageWidget_ImgPath();

        /**
         * The meta object literal for the '<em><b>Is An Attachment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IMAGE_WIDGET__IS_AN_ATTACHMENT = eINSTANCE.getImageWidget_IsAnAttachment();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.HiddenWidgetImpl <em>Hidden Widget</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.HiddenWidgetImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getHiddenWidget()
         * @generated
         */
        EClass HIDDEN_WIDGET = eINSTANCE.getHiddenWidget();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.DurationFormFieldImpl <em>Duration Form Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.DurationFormFieldImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getDurationFormField()
         * @generated
         */
        EClass DURATION_FORM_FIELD = eINSTANCE.getDurationFormField();

        /**
         * The meta object literal for the '<em><b>Day</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DURATION_FORM_FIELD__DAY = eINSTANCE.getDurationFormField_Day();

        /**
         * The meta object literal for the '<em><b>Hour</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DURATION_FORM_FIELD__HOUR = eINSTANCE.getDurationFormField_Hour();

        /**
         * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DURATION_FORM_FIELD__MIN = eINSTANCE.getDurationFormField_Min();

        /**
         * The meta object literal for the '<em><b>Sec</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DURATION_FORM_FIELD__SEC = eINSTANCE.getDurationFormField_Sec();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.ItemContainer <em>Item Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.ItemContainer
         * @see org.talend.process.model.form.impl.FormPackageImpl#getItemContainer()
         * @generated
         */
        EClass ITEM_CONTAINER = eINSTANCE.getItemContainer();

        /**
         * The meta object literal for the '<em><b>Item Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_CONTAINER__ITEM_CLASS = eINSTANCE.getItemContainer_ItemClass();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.Duplicable <em>Duplicable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.Duplicable
         * @see org.talend.process.model.form.impl.FormPackageImpl#getDuplicable()
         * @generated
         */
        EClass DUPLICABLE = eINSTANCE.getDuplicable();

        /**
         * The meta object literal for the '<em><b>Duplicate</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DUPLICABLE__DUPLICATE = eINSTANCE.getDuplicable_Duplicate();

        /**
         * The meta object literal for the '<em><b>Limit Number Of Duplication</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DUPLICABLE__LIMIT_NUMBER_OF_DUPLICATION = eINSTANCE.getDuplicable_LimitNumberOfDuplication();

        /**
         * The meta object literal for the '<em><b>Max Number Of Duplication</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DUPLICABLE__MAX_NUMBER_OF_DUPLICATION = eINSTANCE.getDuplicable_MaxNumberOfDuplication();

        /**
         * The meta object literal for the '<em><b>Limit Min Number Of Duplication</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DUPLICABLE__LIMIT_MIN_NUMBER_OF_DUPLICATION = eINSTANCE.getDuplicable_LimitMinNumberOfDuplication();

        /**
         * The meta object literal for the '<em><b>Min Number Of Duplication</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DUPLICABLE__MIN_NUMBER_OF_DUPLICATION = eINSTANCE.getDuplicable_MinNumberOfDuplication();

        /**
         * The meta object literal for the '<em><b>Display Label For Add</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DUPLICABLE__DISPLAY_LABEL_FOR_ADD = eINSTANCE.getDuplicable_DisplayLabelForAdd();

        /**
         * The meta object literal for the '<em><b>Tooltip For Add</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DUPLICABLE__TOOLTIP_FOR_ADD = eINSTANCE.getDuplicable_TooltipForAdd();

        /**
         * The meta object literal for the '<em><b>Display Label For Remove</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DUPLICABLE__DISPLAY_LABEL_FOR_REMOVE = eINSTANCE.getDuplicable_DisplayLabelForRemove();

        /**
         * The meta object literal for the '<em><b>Tooltip For Remove</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DUPLICABLE__TOOLTIP_FOR_REMOVE = eINSTANCE.getDuplicable_TooltipForRemove();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.TableImpl <em>Table</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.TableImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getTable()
         * @generated
         */
        EClass TABLE = eINSTANCE.getTable();

        /**
         * The meta object literal for the '<em><b>Left Column Is Header</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TABLE__LEFT_COLUMN_IS_HEADER = eINSTANCE.getTable_LeftColumnIsHeader();

        /**
         * The meta object literal for the '<em><b>Right Column Is Header</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TABLE__RIGHT_COLUMN_IS_HEADER = eINSTANCE.getTable_RightColumnIsHeader();

        /**
         * The meta object literal for the '<em><b>First Row Is Header</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TABLE__FIRST_ROW_IS_HEADER = eINSTANCE.getTable_FirstRowIsHeader();

        /**
         * The meta object literal for the '<em><b>Last Row Is Header</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TABLE__LAST_ROW_IS_HEADER = eINSTANCE.getTable_LastRowIsHeader();

        /**
         * The meta object literal for the '<em><b>Initialized Using Cells</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TABLE__INITIALIZED_USING_CELLS = eINSTANCE.getTable_InitializedUsingCells();

        /**
         * The meta object literal for the '<em><b>Cells</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TABLE__CELLS = eINSTANCE.getTable_Cells();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.impl.ViewFormImpl <em>View Form</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.impl.ViewFormImpl
         * @see org.talend.process.model.form.impl.FormPackageImpl#getViewForm()
         * @generated
         */
        EClass VIEW_FORM = eINSTANCE.getViewForm();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.EventDependencyType <em>Event Dependency Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.EventDependencyType
         * @see org.talend.process.model.form.impl.FormPackageImpl#getEventDependencyType()
         * @generated
         */
        EEnum EVENT_DEPENDENCY_TYPE = eINSTANCE.getEventDependencyType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.form.LabelPosition <em>Label Position</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.form.LabelPosition
         * @see org.talend.process.model.form.impl.FormPackageImpl#getLabelPosition()
         * @generated
         */
        EEnum LABEL_POSITION = eINSTANCE.getLabelPosition();

    }

} //FormPackage
