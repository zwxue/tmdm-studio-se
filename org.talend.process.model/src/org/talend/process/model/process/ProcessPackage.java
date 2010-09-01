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
package org.talend.process.model.process;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.talend.process.model.process.ProcessFactory
 * @model kind="package"
 * @generated
 */
public interface ProcessPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "process"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.bonitasoft.org/ns/studio/process"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "process"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ProcessPackage eINSTANCE = org.talend.process.model.process.impl.ProcessPackageImpl.init();

    /**
     * The meta object id for the '{@link org.talend.process.model.process.Element <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.Element
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getElement()
     * @generated
     */
    int ELEMENT = 0;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT__DOCUMENTATION = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT__NAME = 1;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT__LABEL = 2;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT__TEXT_ANNOTATION_ATTACHMENT = 3;

    /**
     * The number of structural features of the '<em>Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ContainerImpl <em>Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ContainerImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getContainer()
     * @generated
     */
    int CONTAINER = 20;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER__ELEMENTS = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.AbstractProcessImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAbstractProcess()
     * @generated
     */
    int ABSTRACT_PROCESS = 1;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__DOCUMENTATION = CONTAINER__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__NAME = CONTAINER__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__LABEL = CONTAINER__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__TEXT_ANNOTATION_ATTACHMENT = CONTAINER__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__ELEMENTS = CONTAINER__ELEMENTS;

    /**
     * The feature id for the '<em><b>Resource Folders</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__RESOURCE_FOLDERS = CONTAINER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Html Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__HTML_TEMPLATE = CONTAINER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Resource Files</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__RESOURCE_FILES = CONTAINER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Resource Jars</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__RESOURCE_JARS = CONTAINER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Resource Validators</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__RESOURCE_VALIDATORS = CONTAINER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__CONNECTORS = CONTAINER_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__DATA = CONTAINER_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__KPIS = CONTAINER_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Form</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__FORM = CONTAINER_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>By Pass Forms Generation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__BY_PASS_FORMS_GENERATION = CONTAINER_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Confirmation Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE = CONTAINER_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Confirmation Message</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__CONFIRMATION_MESSAGE = CONTAINER_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>Reg Exp To Hide Default Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__REG_EXP_TO_HIDE_DEFAULT_FIELD = CONTAINER_FEATURE_COUNT + 12;

    /**
     * The feature id for the '<em><b>Use Reg Exp To Hide Default Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD = CONTAINER_FEATURE_COUNT + 13;

    /**
     * The feature id for the '<em><b>View Form</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__VIEW_FORM = CONTAINER_FEATURE_COUNT + 14;

    /**
     * The feature id for the '<em><b>Use View Form</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__USE_VIEW_FORM = CONTAINER_FEATURE_COUNT + 15;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__SIMULATION_DATA = CONTAINER_FEATURE_COUNT + 16;

    /**
     * The feature id for the '<em><b>Load Profile ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__LOAD_PROFILE_ID = CONTAINER_FEATURE_COUNT + 17;

    /**
     * The feature id for the '<em><b>Recap Forms</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__RECAP_FORMS = CONTAINER_FEATURE_COUNT + 18;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__VERSION = CONTAINER_FEATURE_COUNT + 19;

    /**
     * The feature id for the '<em><b>Author</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__AUTHOR = CONTAINER_FEATURE_COUNT + 20;

    /**
     * The feature id for the '<em><b>Creation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__CREATION_DATE = CONTAINER_FEATURE_COUNT + 21;

    /**
     * The feature id for the '<em><b>Modification Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__MODIFICATION_DATE = CONTAINER_FEATURE_COUNT + 22;

    /**
     * The feature id for the '<em><b>Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__GROUPS = CONTAINER_FEATURE_COUNT + 23;

    /**
     * The feature id for the '<em><b>Datatypes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__DATATYPES = CONTAINER_FEATURE_COUNT + 24;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__CONNECTIONS = CONTAINER_FEATURE_COUNT + 25;

    /**
     * The feature id for the '<em><b>Mandatory Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__MANDATORY_SYMBOL = CONTAINER_FEATURE_COUNT + 26;

    /**
     * The feature id for the '<em><b>Mandatory Classes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__MANDATORY_CLASSES = CONTAINER_FEATURE_COUNT + 27;

    /**
     * The feature id for the '<em><b>Mandatory Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__MANDATORY_LABEL = CONTAINER_FEATURE_COUNT + 28;

    /**
     * The feature id for the '<em><b>Error Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__ERROR_TEMPLATE = CONTAINER_FEATURE_COUNT + 29;

    /**
     * The feature id for the '<em><b>Process Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__PROCESS_TEMPLATE = CONTAINER_FEATURE_COUNT + 30;

    /**
     * The feature id for the '<em><b>Page Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__PAGE_TEMPLATE = CONTAINER_FEATURE_COUNT + 31;

    /**
     * The feature id for the '<em><b>Consultation Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__CONSULTATION_TEMPLATE = CONTAINER_FEATURE_COUNT + 32;

    /**
     * The feature id for the '<em><b>Log In Page</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__LOG_IN_PAGE = CONTAINER_FEATURE_COUNT + 33;

    /**
     * The feature id for the '<em><b>Welcome Page</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__WELCOME_PAGE = CONTAINER_FEATURE_COUNT + 34;

    /**
     * The feature id for the '<em><b>Welcome Page Internal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__WELCOME_PAGE_INTERNAL = CONTAINER_FEATURE_COUNT + 35;

    /**
     * The feature id for the '<em><b>Categories</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS__CATEGORIES = CONTAINER_FEATURE_COUNT + 36;

    /**
     * The number of structural features of the '<em>Abstract Process</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PROCESS_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 37;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.MainProcessImpl <em>Main Process</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.MainProcessImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getMainProcess()
     * @generated
     */
    int MAIN_PROCESS = 2;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__DOCUMENTATION = ABSTRACT_PROCESS__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__NAME = ABSTRACT_PROCESS__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__LABEL = ABSTRACT_PROCESS__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__TEXT_ANNOTATION_ATTACHMENT = ABSTRACT_PROCESS__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__ELEMENTS = ABSTRACT_PROCESS__ELEMENTS;

    /**
     * The feature id for the '<em><b>Resource Folders</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__RESOURCE_FOLDERS = ABSTRACT_PROCESS__RESOURCE_FOLDERS;

    /**
     * The feature id for the '<em><b>Html Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__HTML_TEMPLATE = ABSTRACT_PROCESS__HTML_TEMPLATE;

    /**
     * The feature id for the '<em><b>Resource Files</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__RESOURCE_FILES = ABSTRACT_PROCESS__RESOURCE_FILES;

    /**
     * The feature id for the '<em><b>Resource Jars</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__RESOURCE_JARS = ABSTRACT_PROCESS__RESOURCE_JARS;

    /**
     * The feature id for the '<em><b>Resource Validators</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__RESOURCE_VALIDATORS = ABSTRACT_PROCESS__RESOURCE_VALIDATORS;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__CONNECTORS = ABSTRACT_PROCESS__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__DATA = ABSTRACT_PROCESS__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__KPIS = ABSTRACT_PROCESS__KPIS;

    /**
     * The feature id for the '<em><b>Form</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__FORM = ABSTRACT_PROCESS__FORM;

    /**
     * The feature id for the '<em><b>By Pass Forms Generation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__BY_PASS_FORMS_GENERATION = ABSTRACT_PROCESS__BY_PASS_FORMS_GENERATION;

    /**
     * The feature id for the '<em><b>Confirmation Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__CONFIRMATION_TEMPLATE = ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE;

    /**
     * The feature id for the '<em><b>Confirmation Message</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__CONFIRMATION_MESSAGE = ABSTRACT_PROCESS__CONFIRMATION_MESSAGE;

    /**
     * The feature id for the '<em><b>Reg Exp To Hide Default Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__REG_EXP_TO_HIDE_DEFAULT_FIELD = ABSTRACT_PROCESS__REG_EXP_TO_HIDE_DEFAULT_FIELD;

    /**
     * The feature id for the '<em><b>Use Reg Exp To Hide Default Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD = ABSTRACT_PROCESS__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD;

    /**
     * The feature id for the '<em><b>View Form</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__VIEW_FORM = ABSTRACT_PROCESS__VIEW_FORM;

    /**
     * The feature id for the '<em><b>Use View Form</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__USE_VIEW_FORM = ABSTRACT_PROCESS__USE_VIEW_FORM;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__SIMULATION_DATA = ABSTRACT_PROCESS__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Load Profile ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__LOAD_PROFILE_ID = ABSTRACT_PROCESS__LOAD_PROFILE_ID;

    /**
     * The feature id for the '<em><b>Recap Forms</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__RECAP_FORMS = ABSTRACT_PROCESS__RECAP_FORMS;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__VERSION = ABSTRACT_PROCESS__VERSION;

    /**
     * The feature id for the '<em><b>Author</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__AUTHOR = ABSTRACT_PROCESS__AUTHOR;

    /**
     * The feature id for the '<em><b>Creation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__CREATION_DATE = ABSTRACT_PROCESS__CREATION_DATE;

    /**
     * The feature id for the '<em><b>Modification Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__MODIFICATION_DATE = ABSTRACT_PROCESS__MODIFICATION_DATE;

    /**
     * The feature id for the '<em><b>Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__GROUPS = ABSTRACT_PROCESS__GROUPS;

    /**
     * The feature id for the '<em><b>Datatypes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__DATATYPES = ABSTRACT_PROCESS__DATATYPES;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__CONNECTIONS = ABSTRACT_PROCESS__CONNECTIONS;

    /**
     * The feature id for the '<em><b>Mandatory Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__MANDATORY_SYMBOL = ABSTRACT_PROCESS__MANDATORY_SYMBOL;

    /**
     * The feature id for the '<em><b>Mandatory Classes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__MANDATORY_CLASSES = ABSTRACT_PROCESS__MANDATORY_CLASSES;

    /**
     * The feature id for the '<em><b>Mandatory Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__MANDATORY_LABEL = ABSTRACT_PROCESS__MANDATORY_LABEL;

    /**
     * The feature id for the '<em><b>Error Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__ERROR_TEMPLATE = ABSTRACT_PROCESS__ERROR_TEMPLATE;

    /**
     * The feature id for the '<em><b>Process Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__PROCESS_TEMPLATE = ABSTRACT_PROCESS__PROCESS_TEMPLATE;

    /**
     * The feature id for the '<em><b>Page Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__PAGE_TEMPLATE = ABSTRACT_PROCESS__PAGE_TEMPLATE;

    /**
     * The feature id for the '<em><b>Consultation Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__CONSULTATION_TEMPLATE = ABSTRACT_PROCESS__CONSULTATION_TEMPLATE;

    /**
     * The feature id for the '<em><b>Log In Page</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__LOG_IN_PAGE = ABSTRACT_PROCESS__LOG_IN_PAGE;

    /**
     * The feature id for the '<em><b>Welcome Page</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__WELCOME_PAGE = ABSTRACT_PROCESS__WELCOME_PAGE;

    /**
     * The feature id for the '<em><b>Welcome Page Internal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__WELCOME_PAGE_INTERNAL = ABSTRACT_PROCESS__WELCOME_PAGE_INTERNAL;

    /**
     * The feature id for the '<em><b>Categories</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__CATEGORIES = ABSTRACT_PROCESS__CATEGORIES;

    /**
     * The feature id for the '<em><b>Bonita Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__BONITA_VERSION = ABSTRACT_PROCESS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Bonita Model Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__BONITA_MODEL_VERSION = ABSTRACT_PROCESS_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Included Entries</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__INCLUDED_ENTRIES = ABSTRACT_PROCESS_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Message Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS__MESSAGE_CONNECTIONS = ABSTRACT_PROCESS_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Main Process</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAIN_PROCESS_FEATURE_COUNT = ABSTRACT_PROCESS_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.FlowElementImpl <em>Flow Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.FlowElementImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getFlowElement()
     * @generated
     */
    int FLOW_ELEMENT = 19;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__SIMULATION_DATA = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__RESOURCES_USAGES = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__EXECUTION_TIME = ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__ESTIMATED_TIME = ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__MAXIMUM_TIME = ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__CONTIGOUS = ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__EXCLUSIVE_OUTGOING_TRANSITION = ELEMENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__DATA_CHANGE = ELEMENT_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__LOOP_TRANSITION = ELEMENT_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__OUTGOING = ELEMENT_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__INCOMING = ELEMENT_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__SYNCHRONOUS = ELEMENT_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__DYNAMIC_LABEL = ELEMENT_FEATURE_COUNT + 12;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__DYNAMIC_DESCRIPTION = ELEMENT_FEATURE_COUNT + 13;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT__STEP_SUMMARY = ELEMENT_FEATURE_COUNT + 14;

    /**
     * The number of structural features of the '<em>Flow Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 15;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ActivityImpl <em>Activity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ActivityImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getActivity()
     * @generated
     */
    int ACTIVITY = 13;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__DOCUMENTATION = FLOW_ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__NAME = FLOW_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__LABEL = FLOW_ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__TEXT_ANNOTATION_ATTACHMENT = FLOW_ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__SIMULATION_DATA = FLOW_ELEMENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__RESOURCES_USAGES = FLOW_ELEMENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__EXECUTION_TIME = FLOW_ELEMENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__ESTIMATED_TIME = FLOW_ELEMENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__MAXIMUM_TIME = FLOW_ELEMENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__CONTIGOUS = FLOW_ELEMENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__EXCLUSIVE_OUTGOING_TRANSITION = FLOW_ELEMENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__DATA_CHANGE = FLOW_ELEMENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__LOOP_TRANSITION = FLOW_ELEMENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__OUTGOING = FLOW_ELEMENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__INCOMING = FLOW_ELEMENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__SYNCHRONOUS = FLOW_ELEMENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__DYNAMIC_LABEL = FLOW_ELEMENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__DYNAMIC_DESCRIPTION = FLOW_ELEMENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__STEP_SUMMARY = FLOW_ELEMENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__CONNECTORS = FLOW_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__DATA = FLOW_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__KPIS = FLOW_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Duration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__DURATION = FLOW_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Deadlines</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__DEADLINES = FLOW_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Multi Instantiation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__MULTI_INSTANTIATION = FLOW_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Is Loop</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__IS_LOOP = FLOW_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Test Before</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__TEST_BEFORE = FLOW_ELEMENT_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Loop Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__LOOP_CONDITION = FLOW_ELEMENT_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Loop Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__LOOP_MAXIMUM = FLOW_ELEMENT_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Boundary Intermediate Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS = FLOW_ELEMENT_FEATURE_COUNT + 10;

    /**
     * The number of structural features of the '<em>Activity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTIVITY_FEATURE_COUNT = FLOW_ELEMENT_FEATURE_COUNT + 11;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.TaskImpl <em>Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.TaskImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getTask()
     * @generated
     */
    int TASK = 3;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__DOCUMENTATION = ACTIVITY__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__NAME = ACTIVITY__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__LABEL = ACTIVITY__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__TEXT_ANNOTATION_ATTACHMENT = ACTIVITY__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__SIMULATION_DATA = ACTIVITY__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__RESOURCES_USAGES = ACTIVITY__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__EXECUTION_TIME = ACTIVITY__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__ESTIMATED_TIME = ACTIVITY__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__MAXIMUM_TIME = ACTIVITY__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__CONTIGOUS = ACTIVITY__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__EXCLUSIVE_OUTGOING_TRANSITION = ACTIVITY__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__DATA_CHANGE = ACTIVITY__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__LOOP_TRANSITION = ACTIVITY__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__OUTGOING = ACTIVITY__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__INCOMING = ACTIVITY__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__SYNCHRONOUS = ACTIVITY__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__DYNAMIC_LABEL = ACTIVITY__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__DYNAMIC_DESCRIPTION = ACTIVITY__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__STEP_SUMMARY = ACTIVITY__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__CONNECTORS = ACTIVITY__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__DATA = ACTIVITY__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__KPIS = ACTIVITY__KPIS;

    /**
     * The feature id for the '<em><b>Duration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__DURATION = ACTIVITY__DURATION;

    /**
     * The feature id for the '<em><b>Deadlines</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__DEADLINES = ACTIVITY__DEADLINES;

    /**
     * The feature id for the '<em><b>Multi Instantiation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__MULTI_INSTANTIATION = ACTIVITY__MULTI_INSTANTIATION;

    /**
     * The feature id for the '<em><b>Is Loop</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__IS_LOOP = ACTIVITY__IS_LOOP;

    /**
     * The feature id for the '<em><b>Test Before</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__TEST_BEFORE = ACTIVITY__TEST_BEFORE;

    /**
     * The feature id for the '<em><b>Loop Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__LOOP_CONDITION = ACTIVITY__LOOP_CONDITION;

    /**
     * The feature id for the '<em><b>Loop Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__LOOP_MAXIMUM = ACTIVITY__LOOP_MAXIMUM;

    /**
     * The feature id for the '<em><b>Boundary Intermediate Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__BOUNDARY_INTERMEDIATE_EVENTS = ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS;

    /**
     * The feature id for the '<em><b>Form</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__FORM = ACTIVITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>By Pass Forms Generation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__BY_PASS_FORMS_GENERATION = ACTIVITY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Confirmation Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__CONFIRMATION_TEMPLATE = ACTIVITY_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Confirmation Message</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__CONFIRMATION_MESSAGE = ACTIVITY_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Reg Exp To Hide Default Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__REG_EXP_TO_HIDE_DEFAULT_FIELD = ACTIVITY_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Use Reg Exp To Hide Default Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD = ACTIVITY_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>View Form</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__VIEW_FORM = ACTIVITY_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Use View Form</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__USE_VIEW_FORM = ACTIVITY_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Resource Folders</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__RESOURCE_FOLDERS = ACTIVITY_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Html Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__HTML_TEMPLATE = ACTIVITY_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Resource Files</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__RESOURCE_FILES = ACTIVITY_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Resource Jars</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__RESOURCE_JARS = ACTIVITY_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>Resource Validators</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__RESOURCE_VALIDATORS = ACTIVITY_FEATURE_COUNT + 12;

    /**
     * The feature id for the '<em><b>User</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__USER = ACTIVITY_FEATURE_COUNT + 13;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__FILTERS = ACTIVITY_FEATURE_COUNT + 14;

    /**
     * The feature id for the '<em><b>Groups</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__GROUPS = ACTIVITY_FEATURE_COUNT + 15;

    /**
     * The feature id for the '<em><b>Actor Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__ACTOR_TYPE = ACTIVITY_FEATURE_COUNT + 16;

    /**
     * The feature id for the '<em><b>Override Groups Of The Lane</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__OVERRIDE_GROUPS_OF_THE_LANE = ACTIVITY_FEATURE_COUNT + 17;

    /**
     * The feature id for the '<em><b>Priority</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__PRIORITY = ACTIVITY_FEATURE_COUNT + 18;

    /**
     * The number of structural features of the '<em>Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_FEATURE_COUNT = ACTIVITY_FEATURE_COUNT + 19;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.GatewayImpl <em>Gateway</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.GatewayImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getGateway()
     * @generated
     */
    int GATEWAY = 4;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__DOCUMENTATION = FLOW_ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__NAME = FLOW_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__LABEL = FLOW_ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__TEXT_ANNOTATION_ATTACHMENT = FLOW_ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__SIMULATION_DATA = FLOW_ELEMENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__RESOURCES_USAGES = FLOW_ELEMENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__EXECUTION_TIME = FLOW_ELEMENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__ESTIMATED_TIME = FLOW_ELEMENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__MAXIMUM_TIME = FLOW_ELEMENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__CONTIGOUS = FLOW_ELEMENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__EXCLUSIVE_OUTGOING_TRANSITION = FLOW_ELEMENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__DATA_CHANGE = FLOW_ELEMENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__LOOP_TRANSITION = FLOW_ELEMENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__OUTGOING = FLOW_ELEMENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__INCOMING = FLOW_ELEMENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__SYNCHRONOUS = FLOW_ELEMENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__DYNAMIC_LABEL = FLOW_ELEMENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__DYNAMIC_DESCRIPTION = FLOW_ELEMENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__STEP_SUMMARY = FLOW_ELEMENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Gateway Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__GATEWAY_TYPE = FLOW_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Gateway</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY_FEATURE_COUNT = FLOW_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.XORGatewayImpl <em>XOR Gateway</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.XORGatewayImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getXORGateway()
     * @generated
     */
    int XOR_GATEWAY = 5;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__DOCUMENTATION = GATEWAY__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__NAME = GATEWAY__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__LABEL = GATEWAY__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__TEXT_ANNOTATION_ATTACHMENT = GATEWAY__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__SIMULATION_DATA = GATEWAY__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__RESOURCES_USAGES = GATEWAY__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__EXECUTION_TIME = GATEWAY__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__ESTIMATED_TIME = GATEWAY__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__MAXIMUM_TIME = GATEWAY__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__CONTIGOUS = GATEWAY__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__EXCLUSIVE_OUTGOING_TRANSITION = GATEWAY__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__DATA_CHANGE = GATEWAY__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__LOOP_TRANSITION = GATEWAY__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__OUTGOING = GATEWAY__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__INCOMING = GATEWAY__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__SYNCHRONOUS = GATEWAY__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__DYNAMIC_LABEL = GATEWAY__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__DYNAMIC_DESCRIPTION = GATEWAY__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__STEP_SUMMARY = GATEWAY__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Gateway Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY__GATEWAY_TYPE = GATEWAY__GATEWAY_TYPE;

    /**
     * The number of structural features of the '<em>XOR Gateway</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XOR_GATEWAY_FEATURE_COUNT = GATEWAY_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ANDGatewayImpl <em>AND Gateway</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ANDGatewayImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getANDGateway()
     * @generated
     */
    int AND_GATEWAY = 6;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__DOCUMENTATION = GATEWAY__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__NAME = GATEWAY__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__LABEL = GATEWAY__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__TEXT_ANNOTATION_ATTACHMENT = GATEWAY__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__SIMULATION_DATA = GATEWAY__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__RESOURCES_USAGES = GATEWAY__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__EXECUTION_TIME = GATEWAY__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__ESTIMATED_TIME = GATEWAY__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__MAXIMUM_TIME = GATEWAY__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__CONTIGOUS = GATEWAY__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__EXCLUSIVE_OUTGOING_TRANSITION = GATEWAY__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__DATA_CHANGE = GATEWAY__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__LOOP_TRANSITION = GATEWAY__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__OUTGOING = GATEWAY__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__INCOMING = GATEWAY__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__SYNCHRONOUS = GATEWAY__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__DYNAMIC_LABEL = GATEWAY__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__DYNAMIC_DESCRIPTION = GATEWAY__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__STEP_SUMMARY = GATEWAY__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Gateway Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY__GATEWAY_TYPE = GATEWAY__GATEWAY_TYPE;

    /**
     * The number of structural features of the '<em>AND Gateway</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_GATEWAY_FEATURE_COUNT = GATEWAY_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ConnectionImpl <em>Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ConnectionImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getConnection()
     * @generated
     */
    int CONNECTION = 7;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Probability</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__PROBABILITY = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Data Based</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__DATA_BASED = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__EXPRESSION = ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Use Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__USE_EXPRESSION = ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__SOURCE = ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__TARGET = ELEMENT_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.MessageFlowImpl <em>Message Flow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.MessageFlowImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getMessageFlow()
     * @generated
     */
    int MESSAGE_FLOW = 8;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_FLOW__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_FLOW__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_FLOW__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_FLOW__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_FLOW__SOURCE = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_FLOW__TARGET = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Message Flow</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_FLOW_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.AssociationImpl <em>Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.AssociationImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAssociation()
     * @generated
     */
    int ASSOCIATION = 9;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION__DOCUMENTATION = CONNECTION__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION__NAME = CONNECTION__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION__LABEL = CONNECTION__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION__TEXT_ANNOTATION_ATTACHMENT = CONNECTION__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Probability</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION__PROBABILITY = CONNECTION__PROBABILITY;

    /**
     * The feature id for the '<em><b>Data Based</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION__DATA_BASED = CONNECTION__DATA_BASED;

    /**
     * The feature id for the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION__EXPRESSION = CONNECTION__EXPRESSION;

    /**
     * The feature id for the '<em><b>Use Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION__USE_EXPRESSION = CONNECTION__USE_EXPRESSION;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION__SOURCE = CONNECTION__SOURCE;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION__TARGET = CONNECTION__TARGET;

    /**
     * The feature id for the '<em><b>Is Directed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION__IS_DIRECTED = CONNECTION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Association</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.SequenceFlowImpl <em>Sequence Flow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.SequenceFlowImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getSequenceFlow()
     * @generated
     */
    int SEQUENCE_FLOW = 10;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__DOCUMENTATION = CONNECTION__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__NAME = CONNECTION__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__LABEL = CONNECTION__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__TEXT_ANNOTATION_ATTACHMENT = CONNECTION__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Probability</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__PROBABILITY = CONNECTION__PROBABILITY;

    /**
     * The feature id for the '<em><b>Data Based</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__DATA_BASED = CONNECTION__DATA_BASED;

    /**
     * The feature id for the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__EXPRESSION = CONNECTION__EXPRESSION;

    /**
     * The feature id for the '<em><b>Use Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__USE_EXPRESSION = CONNECTION__USE_EXPRESSION;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__SOURCE = CONNECTION__SOURCE;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__TARGET = CONNECTION__TARGET;

    /**
     * The feature id for the '<em><b>Quantity</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__QUANTITY = CONNECTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Is Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__IS_DEFAULT = CONNECTION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__CONDITION = CONNECTION_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Sequence Flow</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.LaneImpl <em>Lane</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.LaneImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getLane()
     * @generated
     */
    int LANE = 11;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANE__DOCUMENTATION = CONTAINER__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANE__NAME = CONTAINER__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANE__LABEL = CONTAINER__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANE__TEXT_ANNOTATION_ATTACHMENT = CONTAINER__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANE__ELEMENTS = CONTAINER__ELEMENTS;

    /**
     * The feature id for the '<em><b>User</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANE__USER = CONTAINER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANE__FILTERS = CONTAINER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Groups</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANE__GROUPS = CONTAINER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Actor Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANE__ACTOR_TYPE = CONTAINER_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Lane</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANE_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.PoolImpl <em>Pool</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.PoolImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getPool()
     * @generated
     */
    int POOL = 12;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__DOCUMENTATION = ABSTRACT_PROCESS__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__NAME = ABSTRACT_PROCESS__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__LABEL = ABSTRACT_PROCESS__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__TEXT_ANNOTATION_ATTACHMENT = ABSTRACT_PROCESS__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__ELEMENTS = ABSTRACT_PROCESS__ELEMENTS;

    /**
     * The feature id for the '<em><b>Resource Folders</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__RESOURCE_FOLDERS = ABSTRACT_PROCESS__RESOURCE_FOLDERS;

    /**
     * The feature id for the '<em><b>Html Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__HTML_TEMPLATE = ABSTRACT_PROCESS__HTML_TEMPLATE;

    /**
     * The feature id for the '<em><b>Resource Files</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__RESOURCE_FILES = ABSTRACT_PROCESS__RESOURCE_FILES;

    /**
     * The feature id for the '<em><b>Resource Jars</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__RESOURCE_JARS = ABSTRACT_PROCESS__RESOURCE_JARS;

    /**
     * The feature id for the '<em><b>Resource Validators</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__RESOURCE_VALIDATORS = ABSTRACT_PROCESS__RESOURCE_VALIDATORS;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__CONNECTORS = ABSTRACT_PROCESS__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__DATA = ABSTRACT_PROCESS__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__KPIS = ABSTRACT_PROCESS__KPIS;

    /**
     * The feature id for the '<em><b>Form</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__FORM = ABSTRACT_PROCESS__FORM;

    /**
     * The feature id for the '<em><b>By Pass Forms Generation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__BY_PASS_FORMS_GENERATION = ABSTRACT_PROCESS__BY_PASS_FORMS_GENERATION;

    /**
     * The feature id for the '<em><b>Confirmation Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__CONFIRMATION_TEMPLATE = ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE;

    /**
     * The feature id for the '<em><b>Confirmation Message</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__CONFIRMATION_MESSAGE = ABSTRACT_PROCESS__CONFIRMATION_MESSAGE;

    /**
     * The feature id for the '<em><b>Reg Exp To Hide Default Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__REG_EXP_TO_HIDE_DEFAULT_FIELD = ABSTRACT_PROCESS__REG_EXP_TO_HIDE_DEFAULT_FIELD;

    /**
     * The feature id for the '<em><b>Use Reg Exp To Hide Default Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD = ABSTRACT_PROCESS__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD;

    /**
     * The feature id for the '<em><b>View Form</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__VIEW_FORM = ABSTRACT_PROCESS__VIEW_FORM;

    /**
     * The feature id for the '<em><b>Use View Form</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__USE_VIEW_FORM = ABSTRACT_PROCESS__USE_VIEW_FORM;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__SIMULATION_DATA = ABSTRACT_PROCESS__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Load Profile ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__LOAD_PROFILE_ID = ABSTRACT_PROCESS__LOAD_PROFILE_ID;

    /**
     * The feature id for the '<em><b>Recap Forms</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__RECAP_FORMS = ABSTRACT_PROCESS__RECAP_FORMS;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__VERSION = ABSTRACT_PROCESS__VERSION;

    /**
     * The feature id for the '<em><b>Author</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__AUTHOR = ABSTRACT_PROCESS__AUTHOR;

    /**
     * The feature id for the '<em><b>Creation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__CREATION_DATE = ABSTRACT_PROCESS__CREATION_DATE;

    /**
     * The feature id for the '<em><b>Modification Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__MODIFICATION_DATE = ABSTRACT_PROCESS__MODIFICATION_DATE;

    /**
     * The feature id for the '<em><b>Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__GROUPS = ABSTRACT_PROCESS__GROUPS;

    /**
     * The feature id for the '<em><b>Datatypes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__DATATYPES = ABSTRACT_PROCESS__DATATYPES;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__CONNECTIONS = ABSTRACT_PROCESS__CONNECTIONS;

    /**
     * The feature id for the '<em><b>Mandatory Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__MANDATORY_SYMBOL = ABSTRACT_PROCESS__MANDATORY_SYMBOL;

    /**
     * The feature id for the '<em><b>Mandatory Classes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__MANDATORY_CLASSES = ABSTRACT_PROCESS__MANDATORY_CLASSES;

    /**
     * The feature id for the '<em><b>Mandatory Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__MANDATORY_LABEL = ABSTRACT_PROCESS__MANDATORY_LABEL;

    /**
     * The feature id for the '<em><b>Error Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__ERROR_TEMPLATE = ABSTRACT_PROCESS__ERROR_TEMPLATE;

    /**
     * The feature id for the '<em><b>Process Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__PROCESS_TEMPLATE = ABSTRACT_PROCESS__PROCESS_TEMPLATE;

    /**
     * The feature id for the '<em><b>Page Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__PAGE_TEMPLATE = ABSTRACT_PROCESS__PAGE_TEMPLATE;

    /**
     * The feature id for the '<em><b>Consultation Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__CONSULTATION_TEMPLATE = ABSTRACT_PROCESS__CONSULTATION_TEMPLATE;

    /**
     * The feature id for the '<em><b>Log In Page</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__LOG_IN_PAGE = ABSTRACT_PROCESS__LOG_IN_PAGE;

    /**
     * The feature id for the '<em><b>Welcome Page</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__WELCOME_PAGE = ABSTRACT_PROCESS__WELCOME_PAGE;

    /**
     * The feature id for the '<em><b>Welcome Page Internal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__WELCOME_PAGE_INTERNAL = ABSTRACT_PROCESS__WELCOME_PAGE_INTERNAL;

    /**
     * The feature id for the '<em><b>Categories</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL__CATEGORIES = ABSTRACT_PROCESS__CATEGORIES;

    /**
     * The number of structural features of the '<em>Pool</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POOL_FEATURE_COUNT = ABSTRACT_PROCESS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.SendTaskImpl <em>Send Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.SendTaskImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getSendTask()
     * @generated
     */
    int SEND_TASK = 14;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__DOCUMENTATION = ACTIVITY__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__NAME = ACTIVITY__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__LABEL = ACTIVITY__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__TEXT_ANNOTATION_ATTACHMENT = ACTIVITY__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__SIMULATION_DATA = ACTIVITY__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__RESOURCES_USAGES = ACTIVITY__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__EXECUTION_TIME = ACTIVITY__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__ESTIMATED_TIME = ACTIVITY__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__MAXIMUM_TIME = ACTIVITY__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__CONTIGOUS = ACTIVITY__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__EXCLUSIVE_OUTGOING_TRANSITION = ACTIVITY__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__DATA_CHANGE = ACTIVITY__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__LOOP_TRANSITION = ACTIVITY__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__OUTGOING = ACTIVITY__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__INCOMING = ACTIVITY__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__SYNCHRONOUS = ACTIVITY__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__DYNAMIC_LABEL = ACTIVITY__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__DYNAMIC_DESCRIPTION = ACTIVITY__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__STEP_SUMMARY = ACTIVITY__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__CONNECTORS = ACTIVITY__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__DATA = ACTIVITY__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__KPIS = ACTIVITY__KPIS;

    /**
     * The feature id for the '<em><b>Duration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__DURATION = ACTIVITY__DURATION;

    /**
     * The feature id for the '<em><b>Deadlines</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__DEADLINES = ACTIVITY__DEADLINES;

    /**
     * The feature id for the '<em><b>Multi Instantiation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__MULTI_INSTANTIATION = ACTIVITY__MULTI_INSTANTIATION;

    /**
     * The feature id for the '<em><b>Is Loop</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__IS_LOOP = ACTIVITY__IS_LOOP;

    /**
     * The feature id for the '<em><b>Test Before</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__TEST_BEFORE = ACTIVITY__TEST_BEFORE;

    /**
     * The feature id for the '<em><b>Loop Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__LOOP_CONDITION = ACTIVITY__LOOP_CONDITION;

    /**
     * The feature id for the '<em><b>Loop Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__LOOP_MAXIMUM = ACTIVITY__LOOP_MAXIMUM;

    /**
     * The feature id for the '<em><b>Boundary Intermediate Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__BOUNDARY_INTERMEDIATE_EVENTS = ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS;

    /**
     * The feature id for the '<em><b>Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__EVENTS = ACTIVITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Outgoing Messages</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK__OUTGOING_MESSAGES = ACTIVITY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Send Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEND_TASK_FEATURE_COUNT = ACTIVITY_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ReceiveTaskImpl <em>Receive Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ReceiveTaskImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getReceiveTask()
     * @generated
     */
    int RECEIVE_TASK = 15;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__DOCUMENTATION = ACTIVITY__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__NAME = ACTIVITY__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__LABEL = ACTIVITY__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__TEXT_ANNOTATION_ATTACHMENT = ACTIVITY__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__SIMULATION_DATA = ACTIVITY__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__RESOURCES_USAGES = ACTIVITY__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__EXECUTION_TIME = ACTIVITY__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__ESTIMATED_TIME = ACTIVITY__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__MAXIMUM_TIME = ACTIVITY__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__CONTIGOUS = ACTIVITY__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__EXCLUSIVE_OUTGOING_TRANSITION = ACTIVITY__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__DATA_CHANGE = ACTIVITY__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__LOOP_TRANSITION = ACTIVITY__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__OUTGOING = ACTIVITY__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__INCOMING = ACTIVITY__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__SYNCHRONOUS = ACTIVITY__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__DYNAMIC_LABEL = ACTIVITY__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__DYNAMIC_DESCRIPTION = ACTIVITY__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__STEP_SUMMARY = ACTIVITY__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__CONNECTORS = ACTIVITY__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__DATA = ACTIVITY__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__KPIS = ACTIVITY__KPIS;

    /**
     * The feature id for the '<em><b>Duration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__DURATION = ACTIVITY__DURATION;

    /**
     * The feature id for the '<em><b>Deadlines</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__DEADLINES = ACTIVITY__DEADLINES;

    /**
     * The feature id for the '<em><b>Multi Instantiation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__MULTI_INSTANTIATION = ACTIVITY__MULTI_INSTANTIATION;

    /**
     * The feature id for the '<em><b>Is Loop</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__IS_LOOP = ACTIVITY__IS_LOOP;

    /**
     * The feature id for the '<em><b>Test Before</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__TEST_BEFORE = ACTIVITY__TEST_BEFORE;

    /**
     * The feature id for the '<em><b>Loop Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__LOOP_CONDITION = ACTIVITY__LOOP_CONDITION;

    /**
     * The feature id for the '<em><b>Loop Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__LOOP_MAXIMUM = ACTIVITY__LOOP_MAXIMUM;

    /**
     * The feature id for the '<em><b>Boundary Intermediate Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__BOUNDARY_INTERMEDIATE_EVENTS = ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS;

    /**
     * The feature id for the '<em><b>Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__EVENT = ACTIVITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Incoming Messag</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__INCOMING_MESSAG = ACTIVITY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Matcher</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK__MATCHER = ACTIVITY_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Receive Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECEIVE_TASK_FEATURE_COUNT = ACTIVITY_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ScriptTaskImpl <em>Script Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ScriptTaskImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getScriptTask()
     * @generated
     */
    int SCRIPT_TASK = 16;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__DOCUMENTATION = ACTIVITY__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__NAME = ACTIVITY__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__LABEL = ACTIVITY__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__TEXT_ANNOTATION_ATTACHMENT = ACTIVITY__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__SIMULATION_DATA = ACTIVITY__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__RESOURCES_USAGES = ACTIVITY__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__EXECUTION_TIME = ACTIVITY__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__ESTIMATED_TIME = ACTIVITY__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__MAXIMUM_TIME = ACTIVITY__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__CONTIGOUS = ACTIVITY__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__EXCLUSIVE_OUTGOING_TRANSITION = ACTIVITY__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__DATA_CHANGE = ACTIVITY__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__LOOP_TRANSITION = ACTIVITY__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__OUTGOING = ACTIVITY__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__INCOMING = ACTIVITY__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__SYNCHRONOUS = ACTIVITY__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__DYNAMIC_LABEL = ACTIVITY__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__DYNAMIC_DESCRIPTION = ACTIVITY__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__STEP_SUMMARY = ACTIVITY__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__CONNECTORS = ACTIVITY__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__DATA = ACTIVITY__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__KPIS = ACTIVITY__KPIS;

    /**
     * The feature id for the '<em><b>Duration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__DURATION = ACTIVITY__DURATION;

    /**
     * The feature id for the '<em><b>Deadlines</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__DEADLINES = ACTIVITY__DEADLINES;

    /**
     * The feature id for the '<em><b>Multi Instantiation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__MULTI_INSTANTIATION = ACTIVITY__MULTI_INSTANTIATION;

    /**
     * The feature id for the '<em><b>Is Loop</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__IS_LOOP = ACTIVITY__IS_LOOP;

    /**
     * The feature id for the '<em><b>Test Before</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__TEST_BEFORE = ACTIVITY__TEST_BEFORE;

    /**
     * The feature id for the '<em><b>Loop Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__LOOP_CONDITION = ACTIVITY__LOOP_CONDITION;

    /**
     * The feature id for the '<em><b>Loop Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__LOOP_MAXIMUM = ACTIVITY__LOOP_MAXIMUM;

    /**
     * The feature id for the '<em><b>Boundary Intermediate Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK__BOUNDARY_INTERMEDIATE_EVENTS = ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS;

    /**
     * The number of structural features of the '<em>Script Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TASK_FEATURE_COUNT = ACTIVITY_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ServiceTaskImpl <em>Service Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ServiceTaskImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getServiceTask()
     * @generated
     */
    int SERVICE_TASK = 17;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__DOCUMENTATION = ACTIVITY__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__NAME = ACTIVITY__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__LABEL = ACTIVITY__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__TEXT_ANNOTATION_ATTACHMENT = ACTIVITY__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__SIMULATION_DATA = ACTIVITY__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__RESOURCES_USAGES = ACTIVITY__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__EXECUTION_TIME = ACTIVITY__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__ESTIMATED_TIME = ACTIVITY__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__MAXIMUM_TIME = ACTIVITY__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__CONTIGOUS = ACTIVITY__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__EXCLUSIVE_OUTGOING_TRANSITION = ACTIVITY__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__DATA_CHANGE = ACTIVITY__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__LOOP_TRANSITION = ACTIVITY__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__OUTGOING = ACTIVITY__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__INCOMING = ACTIVITY__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__SYNCHRONOUS = ACTIVITY__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__DYNAMIC_LABEL = ACTIVITY__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__DYNAMIC_DESCRIPTION = ACTIVITY__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__STEP_SUMMARY = ACTIVITY__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__CONNECTORS = ACTIVITY__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__DATA = ACTIVITY__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__KPIS = ACTIVITY__KPIS;

    /**
     * The feature id for the '<em><b>Duration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__DURATION = ACTIVITY__DURATION;

    /**
     * The feature id for the '<em><b>Deadlines</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__DEADLINES = ACTIVITY__DEADLINES;

    /**
     * The feature id for the '<em><b>Multi Instantiation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__MULTI_INSTANTIATION = ACTIVITY__MULTI_INSTANTIATION;

    /**
     * The feature id for the '<em><b>Is Loop</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__IS_LOOP = ACTIVITY__IS_LOOP;

    /**
     * The feature id for the '<em><b>Test Before</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__TEST_BEFORE = ACTIVITY__TEST_BEFORE;

    /**
     * The feature id for the '<em><b>Loop Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__LOOP_CONDITION = ACTIVITY__LOOP_CONDITION;

    /**
     * The feature id for the '<em><b>Loop Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__LOOP_MAXIMUM = ACTIVITY__LOOP_MAXIMUM;

    /**
     * The feature id for the '<em><b>Boundary Intermediate Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK__BOUNDARY_INTERMEDIATE_EVENTS = ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS;

    /**
     * The number of structural features of the '<em>Service Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_TASK_FEATURE_COUNT = ACTIVITY_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.SubProcessImpl <em>Sub Process</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.SubProcessImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getSubProcess()
     * @generated
     */
    int SUB_PROCESS = 18;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__DOCUMENTATION = ACTIVITY__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__NAME = ACTIVITY__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__LABEL = ACTIVITY__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__TEXT_ANNOTATION_ATTACHMENT = ACTIVITY__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__SIMULATION_DATA = ACTIVITY__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__RESOURCES_USAGES = ACTIVITY__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__EXECUTION_TIME = ACTIVITY__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__ESTIMATED_TIME = ACTIVITY__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__MAXIMUM_TIME = ACTIVITY__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__CONTIGOUS = ACTIVITY__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__EXCLUSIVE_OUTGOING_TRANSITION = ACTIVITY__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__DATA_CHANGE = ACTIVITY__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__LOOP_TRANSITION = ACTIVITY__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__OUTGOING = ACTIVITY__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__INCOMING = ACTIVITY__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__SYNCHRONOUS = ACTIVITY__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__DYNAMIC_LABEL = ACTIVITY__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__DYNAMIC_DESCRIPTION = ACTIVITY__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__STEP_SUMMARY = ACTIVITY__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__CONNECTORS = ACTIVITY__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__DATA = ACTIVITY__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__KPIS = ACTIVITY__KPIS;

    /**
     * The feature id for the '<em><b>Duration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__DURATION = ACTIVITY__DURATION;

    /**
     * The feature id for the '<em><b>Deadlines</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__DEADLINES = ACTIVITY__DEADLINES;

    /**
     * The feature id for the '<em><b>Multi Instantiation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__MULTI_INSTANTIATION = ACTIVITY__MULTI_INSTANTIATION;

    /**
     * The feature id for the '<em><b>Is Loop</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__IS_LOOP = ACTIVITY__IS_LOOP;

    /**
     * The feature id for the '<em><b>Test Before</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__TEST_BEFORE = ACTIVITY__TEST_BEFORE;

    /**
     * The feature id for the '<em><b>Loop Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__LOOP_CONDITION = ACTIVITY__LOOP_CONDITION;

    /**
     * The feature id for the '<em><b>Loop Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__LOOP_MAXIMUM = ACTIVITY__LOOP_MAXIMUM;

    /**
     * The feature id for the '<em><b>Boundary Intermediate Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__BOUNDARY_INTERMEDIATE_EVENTS = ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS;

    /**
     * The feature id for the '<em><b>Subprocess Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__SUBPROCESS_NAME = ACTIVITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Subprocess Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__SUBPROCESS_VERSION = ACTIVITY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Input Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__INPUT_MAPPINGS = ACTIVITY_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Output Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS__OUTPUT_MAPPINGS = ACTIVITY_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Sub Process</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROCESS_FEATURE_COUNT = ACTIVITY_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ConnectableElementImpl <em>Connectable Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ConnectableElementImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getConnectableElement()
     * @generated
     */
    int CONNECTABLE_ELEMENT = 21;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTABLE_ELEMENT__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTABLE_ELEMENT__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTABLE_ELEMENT__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTABLE_ELEMENT__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTABLE_ELEMENT__CONNECTORS = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTABLE_ELEMENT__DATA = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTABLE_ELEMENT__KPIS = ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Connectable Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTABLE_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ConnectorImpl <em>Connector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ConnectorImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getConnector()
     * @generated
     */
    int CONNECTOR = 22;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTOR__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTOR__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTOR__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTOR__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Connector Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTOR__CONNECTOR_ID = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Configuration Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTOR__CONFIGURATION_ID = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTOR__PARAMETERS = ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTOR__EVENT = ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Ignore Errors</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTOR__IGNORE_ERRORS = ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTOR__OUTPUTS = ELEMENT_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Connector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTOR_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ParameterImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getParameter()
     * @generated
     */
    int PARAMETER = 23;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETER__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETER__VALUE = 1;

    /**
     * The number of structural features of the '<em>Parameter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETER_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.OutputParameterMappingImpl <em>Output Parameter Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.OutputParameterMappingImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getOutputParameterMapping()
     * @generated
     */
    int OUTPUT_PARAMETER_MAPPING = 24;

    /**
     * The feature id for the '<em><b>Value Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_PARAMETER_MAPPING__VALUE_EXPRESSION = 0;

    /**
     * The feature id for the '<em><b>Target Data</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_PARAMETER_MAPPING__TARGET_DATA = 1;

    /**
     * The feature id for the '<em><b>Additional Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_PARAMETER_MAPPING__ADDITIONAL_PATH = 2;

    /**
     * The feature id for the '<em><b>Target Widget</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_PARAMETER_MAPPING__TARGET_WIDGET = 3;

    /**
     * The number of structural features of the '<em>Output Parameter Mapping</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_PARAMETER_MAPPING_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.GroupImpl <em>Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.GroupImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getGroup()
     * @generated
     */
    int GROUP = 25;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__DOCUMENTATION = CONNECTOR__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__NAME = CONNECTOR__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__LABEL = CONNECTOR__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__TEXT_ANNOTATION_ATTACHMENT = CONNECTOR__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Connector Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__CONNECTOR_ID = CONNECTOR__CONNECTOR_ID;

    /**
     * The feature id for the '<em><b>Configuration Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__CONFIGURATION_ID = CONNECTOR__CONFIGURATION_ID;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__PARAMETERS = CONNECTOR__PARAMETERS;

    /**
     * The feature id for the '<em><b>Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__EVENT = CONNECTOR__EVENT;

    /**
     * The feature id for the '<em><b>Ignore Errors</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__IGNORE_ERRORS = CONNECTOR__IGNORE_ERRORS;

    /**
     * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__OUTPUTS = CONNECTOR__OUTPUTS;

    /**
     * The number of structural features of the '<em>Group</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_FEATURE_COUNT = CONNECTOR_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.DataImpl <em>Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.DataImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getData()
     * @generated
     */
    int DATA = 26;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA__DATA_TYPE = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA__DEFAULT_VALUE = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Generated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA__GENERATED = ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Data</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.AttachmentDataImpl <em>Attachment Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.AttachmentDataImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAttachmentData()
     * @generated
     */
    int ATTACHMENT_DATA = 27;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_DATA__DOCUMENTATION = DATA__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_DATA__NAME = DATA__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_DATA__LABEL = DATA__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_DATA__TEXT_ANNOTATION_ATTACHMENT = DATA__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_DATA__DATA_TYPE = DATA__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_DATA__DEFAULT_VALUE = DATA__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Generated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_DATA__GENERATED = DATA__GENERATED;

    /**
     * The feature id for the '<em><b>Bar Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_DATA__BAR_PATH = DATA_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Attachment Data</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_DATA_FEATURE_COUNT = DATA_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.JavaObjectDataImpl <em>Java Object Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.JavaObjectDataImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getJavaObjectData()
     * @generated
     */
    int JAVA_OBJECT_DATA = 28;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_OBJECT_DATA__DOCUMENTATION = DATA__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_OBJECT_DATA__NAME = DATA__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_OBJECT_DATA__LABEL = DATA__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_OBJECT_DATA__TEXT_ANNOTATION_ATTACHMENT = DATA__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_OBJECT_DATA__DATA_TYPE = DATA__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_OBJECT_DATA__DEFAULT_VALUE = DATA__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Generated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_OBJECT_DATA__GENERATED = DATA__GENERATED;

    /**
     * The feature id for the '<em><b>Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_OBJECT_DATA__CLASS_NAME = DATA_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Java Object Data</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_OBJECT_DATA_FEATURE_COUNT = DATA_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.XMLDataImpl <em>XML Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.XMLDataImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getXMLData()
     * @generated
     */
    int XML_DATA = 29;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_DATA__DOCUMENTATION = DATA__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_DATA__NAME = DATA__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_DATA__LABEL = DATA__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_DATA__TEXT_ANNOTATION_ATTACHMENT = DATA__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_DATA__DATA_TYPE = DATA__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_DATA__DEFAULT_VALUE = DATA__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Generated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_DATA__GENERATED = DATA__GENERATED;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_DATA__NAMESPACE = DATA_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_DATA__TYPE = DATA_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>XML Data</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_DATA_FEATURE_COUNT = DATA_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.DataTypeImpl <em>Data Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.DataTypeImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getDataType()
     * @generated
     */
    int DATA_TYPE = 30;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_TYPE__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_TYPE__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_TYPE__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_TYPE__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The number of structural features of the '<em>Data Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_TYPE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.IntegerTypeImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntegerType()
     * @generated
     */
    int INTEGER_TYPE = 31;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTEGER_TYPE__DOCUMENTATION = DATA_TYPE__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTEGER_TYPE__NAME = DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTEGER_TYPE__LABEL = DATA_TYPE__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTEGER_TYPE__TEXT_ANNOTATION_ATTACHMENT = DATA_TYPE__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The number of structural features of the '<em>Integer Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTEGER_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.StringTypeImpl <em>String Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.StringTypeImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getStringType()
     * @generated
     */
    int STRING_TYPE = 32;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_TYPE__DOCUMENTATION = DATA_TYPE__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_TYPE__NAME = DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_TYPE__LABEL = DATA_TYPE__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_TYPE__TEXT_ANNOTATION_ATTACHMENT = DATA_TYPE__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The number of structural features of the '<em>String Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.DateTypeImpl <em>Date Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.DateTypeImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getDateType()
     * @generated
     */
    int DATE_TYPE = 33;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_TYPE__DOCUMENTATION = STRING_TYPE__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_TYPE__NAME = STRING_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_TYPE__LABEL = STRING_TYPE__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_TYPE__TEXT_ANNOTATION_ATTACHMENT = STRING_TYPE__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The number of structural features of the '<em>Date Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATE_TYPE_FEATURE_COUNT = STRING_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.FloatTypeImpl <em>Float Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.FloatTypeImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getFloatType()
     * @generated
     */
    int FLOAT_TYPE = 34;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOAT_TYPE__DOCUMENTATION = DATA_TYPE__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOAT_TYPE__NAME = DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOAT_TYPE__LABEL = DATA_TYPE__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOAT_TYPE__TEXT_ANNOTATION_ATTACHMENT = DATA_TYPE__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The number of structural features of the '<em>Float Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOAT_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.BooleanTypeImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getBooleanType()
     * @generated
     */
    int BOOLEAN_TYPE = 35;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_TYPE__DOCUMENTATION = DATA_TYPE__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_TYPE__NAME = DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_TYPE__LABEL = DATA_TYPE__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_TYPE__TEXT_ANNOTATION_ATTACHMENT = DATA_TYPE__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The number of structural features of the '<em>Boolean Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.EnumTypeImpl <em>Enum Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.EnumTypeImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEnumType()
     * @generated
     */
    int ENUM_TYPE = 36;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_TYPE__DOCUMENTATION = DATA_TYPE__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_TYPE__NAME = DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_TYPE__LABEL = DATA_TYPE__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_TYPE__TEXT_ANNOTATION_ATTACHMENT = DATA_TYPE__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Literals</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_TYPE__LITERALS = DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Enum Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.JavaTypeImpl <em>Java Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.JavaTypeImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getJavaType()
     * @generated
     */
    int JAVA_TYPE = 37;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_TYPE__DOCUMENTATION = DATA_TYPE__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_TYPE__NAME = DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_TYPE__LABEL = DATA_TYPE__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_TYPE__TEXT_ANNOTATION_ATTACHMENT = DATA_TYPE__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The number of structural features of the '<em>Java Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.XMLTypeImpl <em>XML Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.XMLTypeImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getXMLType()
     * @generated
     */
    int XML_TYPE = 38;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_TYPE__DOCUMENTATION = DATA_TYPE__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_TYPE__NAME = DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_TYPE__LABEL = DATA_TYPE__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_TYPE__TEXT_ANNOTATION_ATTACHMENT = DATA_TYPE__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The number of structural features of the '<em>XML Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XML_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.OutputMappingImpl <em>Output Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.OutputMappingImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getOutputMapping()
     * @generated
     */
    int OUTPUT_MAPPING = 39;

    /**
     * The feature id for the '<em><b>Subprocess Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_MAPPING__SUBPROCESS_SOURCE = 0;

    /**
     * The feature id for the '<em><b>Process Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_MAPPING__PROCESS_TARGET = 1;

    /**
     * The number of structural features of the '<em>Output Mapping</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_MAPPING_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.AttachmentTypeImpl <em>Attachment Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.AttachmentTypeImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAttachmentType()
     * @generated
     */
    int ATTACHMENT_TYPE = 40;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_TYPE__DOCUMENTATION = DATA_TYPE__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_TYPE__NAME = DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_TYPE__LABEL = DATA_TYPE__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_TYPE__TEXT_ANNOTATION_ATTACHMENT = DATA_TYPE__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The number of structural features of the '<em>Attachment Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTACHMENT_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.EventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEvent()
     * @generated
     */
    int EVENT = 43;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__DOCUMENTATION = FLOW_ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__NAME = FLOW_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__LABEL = FLOW_ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__TEXT_ANNOTATION_ATTACHMENT = FLOW_ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__SIMULATION_DATA = FLOW_ELEMENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__RESOURCES_USAGES = FLOW_ELEMENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__EXECUTION_TIME = FLOW_ELEMENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__ESTIMATED_TIME = FLOW_ELEMENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__MAXIMUM_TIME = FLOW_ELEMENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__CONTIGOUS = FLOW_ELEMENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__EXCLUSIVE_OUTGOING_TRANSITION = FLOW_ELEMENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__DATA_CHANGE = FLOW_ELEMENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__LOOP_TRANSITION = FLOW_ELEMENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__OUTGOING = FLOW_ELEMENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__INCOMING = FLOW_ELEMENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__SYNCHRONOUS = FLOW_ELEMENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__DYNAMIC_LABEL = FLOW_ELEMENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__DYNAMIC_DESCRIPTION = FLOW_ELEMENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__STEP_SUMMARY = FLOW_ELEMENT__STEP_SUMMARY;

    /**
     * The number of structural features of the '<em>Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_FEATURE_COUNT = FLOW_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.StartEventImpl <em>Start Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.StartEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getStartEvent()
     * @generated
     */
    int START_EVENT = 41;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__DOCUMENTATION = EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__NAME = EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__LABEL = EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__TEXT_ANNOTATION_ATTACHMENT = EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__SIMULATION_DATA = EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__RESOURCES_USAGES = EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__EXECUTION_TIME = EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__ESTIMATED_TIME = EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__MAXIMUM_TIME = EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__CONTIGOUS = EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__DATA_CHANGE = EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__LOOP_TRANSITION = EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__OUTGOING = EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__INCOMING = EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__SYNCHRONOUS = EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__DYNAMIC_LABEL = EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__DYNAMIC_DESCRIPTION = EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__STEP_SUMMARY = EVENT__STEP_SUMMARY;

    /**
     * The number of structural features of the '<em>Start Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.EndEventImpl <em>End Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.EndEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEndEvent()
     * @generated
     */
    int END_EVENT = 42;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__DOCUMENTATION = EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__NAME = EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__LABEL = EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__TEXT_ANNOTATION_ATTACHMENT = EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__SIMULATION_DATA = EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__RESOURCES_USAGES = EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__EXECUTION_TIME = EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__ESTIMATED_TIME = EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__MAXIMUM_TIME = EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__CONTIGOUS = EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__DATA_CHANGE = EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__LOOP_TRANSITION = EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__OUTGOING = EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__INCOMING = EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__SYNCHRONOUS = EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__DYNAMIC_LABEL = EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__DYNAMIC_DESCRIPTION = EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__STEP_SUMMARY = EVENT__STEP_SUMMARY;

    /**
     * The number of structural features of the '<em>End Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.PageFlowImpl <em>Page Flow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.PageFlowImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getPageFlow()
     * @generated
     */
    int PAGE_FLOW = 44;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__DOCUMENTATION = CONNECTABLE_ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__NAME = CONNECTABLE_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__LABEL = CONNECTABLE_ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__TEXT_ANNOTATION_ATTACHMENT = CONNECTABLE_ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__CONNECTORS = CONNECTABLE_ELEMENT__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__DATA = CONNECTABLE_ELEMENT__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__KPIS = CONNECTABLE_ELEMENT__KPIS;

    /**
     * The feature id for the '<em><b>Form</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__FORM = CONNECTABLE_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>By Pass Forms Generation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__BY_PASS_FORMS_GENERATION = CONNECTABLE_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Confirmation Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__CONFIRMATION_TEMPLATE = CONNECTABLE_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Confirmation Message</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__CONFIRMATION_MESSAGE = CONNECTABLE_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Reg Exp To Hide Default Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD = CONNECTABLE_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Use Reg Exp To Hide Default Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD = CONNECTABLE_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>View Form</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__VIEW_FORM = CONNECTABLE_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Use View Form</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW__USE_VIEW_FORM = CONNECTABLE_ELEMENT_FEATURE_COUNT + 7;

    /**
     * The number of structural features of the '<em>Page Flow</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PAGE_FLOW_FEATURE_COUNT = CONNECTABLE_ELEMENT_FEATURE_COUNT + 8;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ResourceContainerImpl <em>Resource Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ResourceContainerImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getResourceContainer()
     * @generated
     */
    int RESOURCE_CONTAINER = 45;

    /**
     * The feature id for the '<em><b>Resource Folders</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER__RESOURCE_FOLDERS = 0;

    /**
     * The feature id for the '<em><b>Html Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER__HTML_TEMPLATE = 1;

    /**
     * The feature id for the '<em><b>Resource Files</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER__RESOURCE_FILES = 2;

    /**
     * The feature id for the '<em><b>Resource Jars</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER__RESOURCE_JARS = 3;

    /**
     * The feature id for the '<em><b>Resource Validators</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER__RESOURCE_VALIDATORS = 4;

    /**
     * The number of structural features of the '<em>Resource Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.AssociatedFileImpl <em>Associated File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.AssociatedFileImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAssociatedFile()
     * @generated
     */
    int ASSOCIATED_FILE = 46;

    /**
     * The feature id for the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATED_FILE__PATH = 0;

    /**
     * The feature id for the '<em><b>War Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATED_FILE__WAR_PATH = 1;

    /**
     * The number of structural features of the '<em>Associated File</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSOCIATED_FILE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ResourceFileImpl <em>Resource File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ResourceFileImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getResourceFile()
     * @generated
     */
    int RESOURCE_FILE = 47;

    /**
     * The feature id for the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_FILE__PATH = ASSOCIATED_FILE__PATH;

    /**
     * The feature id for the '<em><b>War Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_FILE__WAR_PATH = ASSOCIATED_FILE__WAR_PATH;

    /**
     * The number of structural features of the '<em>Resource File</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_FILE_FEATURE_COUNT = ASSOCIATED_FILE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ResourceFolderImpl <em>Resource Folder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ResourceFolderImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getResourceFolder()
     * @generated
     */
    int RESOURCE_FOLDER = 48;

    /**
     * The feature id for the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_FOLDER__PATH = ASSOCIATED_FILE__PATH;

    /**
     * The feature id for the '<em><b>War Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_FOLDER__WAR_PATH = ASSOCIATED_FILE__WAR_PATH;

    /**
     * The feature id for the '<em><b>Resource Files</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_FOLDER__RESOURCE_FILES = ASSOCIATED_FILE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Resource Folder</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_FOLDER_FEATURE_COUNT = ASSOCIATED_FILE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.DeadlineImpl <em>Deadline</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.DeadlineImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getDeadline()
     * @generated
     */
    int DEADLINE = 49;

    /**
     * The feature id for the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEADLINE__CONDITION = 0;

    /**
     * The feature id for the '<em><b>Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEADLINE__CONNECTOR = 1;

    /**
     * The number of structural features of the '<em>Deadline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEADLINE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.MultiInstantiationImpl <em>Multi Instantiation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.MultiInstantiationImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getMultiInstantiation()
     * @generated
     */
    int MULTI_INSTANTIATION = 50;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__DOCUMENTATION = CONNECTOR__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__NAME = CONNECTOR__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__LABEL = CONNECTOR__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__TEXT_ANNOTATION_ATTACHMENT = CONNECTOR__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Connector Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__CONNECTOR_ID = CONNECTOR__CONNECTOR_ID;

    /**
     * The feature id for the '<em><b>Configuration Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__CONFIGURATION_ID = CONNECTOR__CONFIGURATION_ID;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__PARAMETERS = CONNECTOR__PARAMETERS;

    /**
     * The feature id for the '<em><b>Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__EVENT = CONNECTOR__EVENT;

    /**
     * The feature id for the '<em><b>Ignore Errors</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__IGNORE_ERRORS = CONNECTOR__IGNORE_ERRORS;

    /**
     * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__OUTPUTS = CONNECTOR__OUTPUTS;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__ENABLED = CONNECTOR_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Activity Data</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__ACTIVITY_DATA = CONNECTOR_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Instantiator</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__INSTANTIATOR = CONNECTOR_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Join Checker</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION__JOIN_CHECKER = CONNECTOR_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Multi Instantiation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MULTI_INSTANTIATION_FEATURE_COUNT = CONNECTOR_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.InputMappingImpl <em>Input Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.InputMappingImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getInputMapping()
     * @generated
     */
    int INPUT_MAPPING = 51;

    /**
     * The feature id for the '<em><b>Process Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_MAPPING__PROCESS_SOURCE = 0;

    /**
     * The feature id for the '<em><b>Subprocess Target</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_MAPPING__SUBPROCESS_TARGET = 1;

    /**
     * The number of structural features of the '<em>Input Mapping</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_MAPPING_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.MessageEventImpl <em>Message Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.MessageEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getMessageEvent()
     * @generated
     */
    int MESSAGE_EVENT = 52;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__DOCUMENTATION = EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__NAME = EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__LABEL = EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT = EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__SIMULATION_DATA = EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__RESOURCES_USAGES = EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__EXECUTION_TIME = EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__ESTIMATED_TIME = EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__MAXIMUM_TIME = EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__CONTIGOUS = EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__DATA_CHANGE = EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__LOOP_TRANSITION = EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__OUTGOING = EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__INCOMING = EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__SYNCHRONOUS = EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__DYNAMIC_LABEL = EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__DYNAMIC_DESCRIPTION = EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT__STEP_SUMMARY = EVENT__STEP_SUMMARY;

    /**
     * The number of structural features of the '<em>Message Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.CatchMessageEventImpl <em>Catch Message Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.CatchMessageEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getCatchMessageEvent()
     * @generated
     */
    int CATCH_MESSAGE_EVENT = 55;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__DOCUMENTATION = MESSAGE_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__NAME = MESSAGE_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__LABEL = MESSAGE_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT = MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__SIMULATION_DATA = MESSAGE_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__RESOURCES_USAGES = MESSAGE_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__EXECUTION_TIME = MESSAGE_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__ESTIMATED_TIME = MESSAGE_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__MAXIMUM_TIME = MESSAGE_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__CONTIGOUS = MESSAGE_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__DATA_CHANGE = MESSAGE_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__LOOP_TRANSITION = MESSAGE_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__OUTGOING = MESSAGE_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__INCOMING = MESSAGE_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__SYNCHRONOUS = MESSAGE_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__DYNAMIC_LABEL = MESSAGE_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__DYNAMIC_DESCRIPTION = MESSAGE_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__STEP_SUMMARY = MESSAGE_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__CONNECTORS = MESSAGE_EVENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__DATA = MESSAGE_EVENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__KPIS = MESSAGE_EVENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__EVENT = MESSAGE_EVENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Incoming Messag</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__INCOMING_MESSAG = MESSAGE_EVENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Matcher</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT__MATCHER = MESSAGE_EVENT_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Catch Message Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_MESSAGE_EVENT_FEATURE_COUNT = MESSAGE_EVENT_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.StartMessageEventImpl <em>Start Message Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.StartMessageEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getStartMessageEvent()
     * @generated
     */
    int START_MESSAGE_EVENT = 53;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__DOCUMENTATION = CATCH_MESSAGE_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__NAME = CATCH_MESSAGE_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__LABEL = CATCH_MESSAGE_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT = CATCH_MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__SIMULATION_DATA = CATCH_MESSAGE_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__RESOURCES_USAGES = CATCH_MESSAGE_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__EXECUTION_TIME = CATCH_MESSAGE_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__ESTIMATED_TIME = CATCH_MESSAGE_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__MAXIMUM_TIME = CATCH_MESSAGE_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__CONTIGOUS = CATCH_MESSAGE_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = CATCH_MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__DATA_CHANGE = CATCH_MESSAGE_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__LOOP_TRANSITION = CATCH_MESSAGE_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__OUTGOING = CATCH_MESSAGE_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__INCOMING = CATCH_MESSAGE_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__SYNCHRONOUS = CATCH_MESSAGE_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__DYNAMIC_LABEL = CATCH_MESSAGE_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__DYNAMIC_DESCRIPTION = CATCH_MESSAGE_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__STEP_SUMMARY = CATCH_MESSAGE_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__CONNECTORS = CATCH_MESSAGE_EVENT__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__DATA = CATCH_MESSAGE_EVENT__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__KPIS = CATCH_MESSAGE_EVENT__KPIS;

    /**
     * The feature id for the '<em><b>Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__EVENT = CATCH_MESSAGE_EVENT__EVENT;

    /**
     * The feature id for the '<em><b>Incoming Messag</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__INCOMING_MESSAG = CATCH_MESSAGE_EVENT__INCOMING_MESSAG;

    /**
     * The feature id for the '<em><b>Matcher</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT__MATCHER = CATCH_MESSAGE_EVENT__MATCHER;

    /**
     * The number of structural features of the '<em>Start Message Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_MESSAGE_EVENT_FEATURE_COUNT = CATCH_MESSAGE_EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ThrowMessageEventImpl <em>Throw Message Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ThrowMessageEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getThrowMessageEvent()
     * @generated
     */
    int THROW_MESSAGE_EVENT = 56;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__DOCUMENTATION = MESSAGE_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__NAME = MESSAGE_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__LABEL = MESSAGE_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT = MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__SIMULATION_DATA = MESSAGE_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__RESOURCES_USAGES = MESSAGE_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__EXECUTION_TIME = MESSAGE_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__ESTIMATED_TIME = MESSAGE_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__MAXIMUM_TIME = MESSAGE_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__CONTIGOUS = MESSAGE_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__DATA_CHANGE = MESSAGE_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__LOOP_TRANSITION = MESSAGE_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__OUTGOING = MESSAGE_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__INCOMING = MESSAGE_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__SYNCHRONOUS = MESSAGE_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__DYNAMIC_LABEL = MESSAGE_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__DYNAMIC_DESCRIPTION = MESSAGE_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__STEP_SUMMARY = MESSAGE_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__EVENTS = MESSAGE_EVENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Outgoing Messages</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT__OUTGOING_MESSAGES = MESSAGE_EVENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Throw Message Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_MESSAGE_EVENT_FEATURE_COUNT = MESSAGE_EVENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.EndMessageEventImpl <em>End Message Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.EndMessageEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEndMessageEvent()
     * @generated
     */
    int END_MESSAGE_EVENT = 54;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__DOCUMENTATION = THROW_MESSAGE_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__NAME = THROW_MESSAGE_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__LABEL = THROW_MESSAGE_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT = THROW_MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__SIMULATION_DATA = THROW_MESSAGE_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__RESOURCES_USAGES = THROW_MESSAGE_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__EXECUTION_TIME = THROW_MESSAGE_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__ESTIMATED_TIME = THROW_MESSAGE_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__MAXIMUM_TIME = THROW_MESSAGE_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__CONTIGOUS = THROW_MESSAGE_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = THROW_MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__DATA_CHANGE = THROW_MESSAGE_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__LOOP_TRANSITION = THROW_MESSAGE_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__OUTGOING = THROW_MESSAGE_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__INCOMING = THROW_MESSAGE_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__SYNCHRONOUS = THROW_MESSAGE_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__DYNAMIC_LABEL = THROW_MESSAGE_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__DYNAMIC_DESCRIPTION = THROW_MESSAGE_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__STEP_SUMMARY = THROW_MESSAGE_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__EVENTS = THROW_MESSAGE_EVENT__EVENTS;

    /**
     * The feature id for the '<em><b>Outgoing Messages</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT__OUTGOING_MESSAGES = THROW_MESSAGE_EVENT__OUTGOING_MESSAGES;

    /**
     * The number of structural features of the '<em>End Message Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_MESSAGE_EVENT_FEATURE_COUNT = THROW_MESSAGE_EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.IntermediateCatchMessageEventImpl <em>Intermediate Catch Message Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.IntermediateCatchMessageEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateCatchMessageEvent()
     * @generated
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT = 57;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__DOCUMENTATION = CATCH_MESSAGE_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__NAME = CATCH_MESSAGE_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__LABEL = CATCH_MESSAGE_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT = CATCH_MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__SIMULATION_DATA = CATCH_MESSAGE_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__RESOURCES_USAGES = CATCH_MESSAGE_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__EXECUTION_TIME = CATCH_MESSAGE_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__ESTIMATED_TIME = CATCH_MESSAGE_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__MAXIMUM_TIME = CATCH_MESSAGE_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__CONTIGOUS = CATCH_MESSAGE_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = CATCH_MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__DATA_CHANGE = CATCH_MESSAGE_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__LOOP_TRANSITION = CATCH_MESSAGE_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__OUTGOING = CATCH_MESSAGE_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__INCOMING = CATCH_MESSAGE_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__SYNCHRONOUS = CATCH_MESSAGE_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__DYNAMIC_LABEL = CATCH_MESSAGE_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__DYNAMIC_DESCRIPTION = CATCH_MESSAGE_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__STEP_SUMMARY = CATCH_MESSAGE_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__CONNECTORS = CATCH_MESSAGE_EVENT__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__DATA = CATCH_MESSAGE_EVENT__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__KPIS = CATCH_MESSAGE_EVENT__KPIS;

    /**
     * The feature id for the '<em><b>Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__EVENT = CATCH_MESSAGE_EVENT__EVENT;

    /**
     * The feature id for the '<em><b>Incoming Messag</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__INCOMING_MESSAG = CATCH_MESSAGE_EVENT__INCOMING_MESSAG;

    /**
     * The feature id for the '<em><b>Matcher</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT__MATCHER = CATCH_MESSAGE_EVENT__MATCHER;

    /**
     * The number of structural features of the '<em>Intermediate Catch Message Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_MESSAGE_EVENT_FEATURE_COUNT = CATCH_MESSAGE_EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.IntermediateThrowMessageEventImpl <em>Intermediate Throw Message Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.IntermediateThrowMessageEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateThrowMessageEvent()
     * @generated
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT = 58;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__DOCUMENTATION = THROW_MESSAGE_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__NAME = THROW_MESSAGE_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__LABEL = THROW_MESSAGE_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT = THROW_MESSAGE_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__SIMULATION_DATA = THROW_MESSAGE_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__RESOURCES_USAGES = THROW_MESSAGE_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__EXECUTION_TIME = THROW_MESSAGE_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__ESTIMATED_TIME = THROW_MESSAGE_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__MAXIMUM_TIME = THROW_MESSAGE_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__CONTIGOUS = THROW_MESSAGE_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = THROW_MESSAGE_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__DATA_CHANGE = THROW_MESSAGE_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__LOOP_TRANSITION = THROW_MESSAGE_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__OUTGOING = THROW_MESSAGE_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__INCOMING = THROW_MESSAGE_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__SYNCHRONOUS = THROW_MESSAGE_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__DYNAMIC_LABEL = THROW_MESSAGE_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__DYNAMIC_DESCRIPTION = THROW_MESSAGE_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__STEP_SUMMARY = THROW_MESSAGE_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__EVENTS = THROW_MESSAGE_EVENT__EVENTS;

    /**
     * The feature id for the '<em><b>Outgoing Messages</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT__OUTGOING_MESSAGES = THROW_MESSAGE_EVENT__OUTGOING_MESSAGES;

    /**
     * The number of structural features of the '<em>Intermediate Throw Message Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_MESSAGE_EVENT_FEATURE_COUNT = THROW_MESSAGE_EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.TextAnnotationImpl <em>Text Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.TextAnnotationImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getTextAnnotation()
     * @generated
     */
    int TEXT_ANNOTATION = 59;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ANNOTATION__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ANNOTATION__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ANNOTATION__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ANNOTATION__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ANNOTATION__TEXT = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Text Annotation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ANNOTATION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.TextAnnotationAttachmentImpl <em>Text Annotation Attachment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.TextAnnotationAttachmentImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getTextAnnotationAttachment()
     * @generated
     */
    int TEXT_ANNOTATION_ATTACHMENT = 60;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ANNOTATION_ATTACHMENT__SOURCE = 0;

    /**
     * The feature id for the '<em><b>Target</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ANNOTATION_ATTACHMENT__TARGET = 1;

    /**
     * The number of structural features of the '<em>Text Annotation Attachment</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ANNOTATION_ATTACHMENT_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.EventObjectImpl <em>Event Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.EventObjectImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEventObject()
     * @generated
     */
    int EVENT_OBJECT = 61;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__DOCUMENTATION = CONNECTABLE_ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__NAME = CONNECTABLE_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__LABEL = CONNECTABLE_ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__TEXT_ANNOTATION_ATTACHMENT = CONNECTABLE_ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__CONNECTORS = CONNECTABLE_ELEMENT__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__DATA = CONNECTABLE_ELEMENT__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__KPIS = CONNECTABLE_ELEMENT__KPIS;

    /**
     * The feature id for the '<em><b>Throw Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__THROW_EVENT = CONNECTABLE_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Source</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__SOURCE = CONNECTABLE_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Ttl</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__TTL = CONNECTABLE_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Target Process Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__TARGET_PROCESS_NAME = CONNECTABLE_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Target Element Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT__TARGET_ELEMENT_NAME = CONNECTABLE_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Event Object</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OBJECT_FEATURE_COUNT = CONNECTABLE_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.TimerEventImpl <em>Timer Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.TimerEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getTimerEvent()
     * @generated
     */
    int TIMER_EVENT = 62;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__DOCUMENTATION = EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__NAME = EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__LABEL = EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__TEXT_ANNOTATION_ATTACHMENT = EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__SIMULATION_DATA = EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__RESOURCES_USAGES = EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__EXECUTION_TIME = EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__ESTIMATED_TIME = EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__MAXIMUM_TIME = EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__CONTIGOUS = EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__DATA_CHANGE = EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__LOOP_TRANSITION = EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__OUTGOING = EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__INCOMING = EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__SYNCHRONOUS = EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__DYNAMIC_LABEL = EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__DYNAMIC_DESCRIPTION = EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__STEP_SUMMARY = EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__CONNECTORS = EVENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__DATA = EVENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__KPIS = EVENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT__CONDITION = EVENT_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Timer Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.StartTimerEventImpl <em>Start Timer Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.StartTimerEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getStartTimerEvent()
     * @generated
     */
    int START_TIMER_EVENT = 63;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__DOCUMENTATION = TIMER_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__NAME = TIMER_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__LABEL = TIMER_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__TEXT_ANNOTATION_ATTACHMENT = TIMER_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__SIMULATION_DATA = TIMER_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__RESOURCES_USAGES = TIMER_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__EXECUTION_TIME = TIMER_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__ESTIMATED_TIME = TIMER_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__MAXIMUM_TIME = TIMER_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__CONTIGOUS = TIMER_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = TIMER_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__DATA_CHANGE = TIMER_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__LOOP_TRANSITION = TIMER_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__OUTGOING = TIMER_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__INCOMING = TIMER_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__SYNCHRONOUS = TIMER_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__DYNAMIC_LABEL = TIMER_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__DYNAMIC_DESCRIPTION = TIMER_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__STEP_SUMMARY = TIMER_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__CONNECTORS = TIMER_EVENT__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__DATA = TIMER_EVENT__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__KPIS = TIMER_EVENT__KPIS;

    /**
     * The feature id for the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT__CONDITION = TIMER_EVENT__CONDITION;

    /**
     * The number of structural features of the '<em>Start Timer Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_TIMER_EVENT_FEATURE_COUNT = TIMER_EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.IntermediateCatchTimerEventImpl <em>Intermediate Catch Timer Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.IntermediateCatchTimerEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateCatchTimerEvent()
     * @generated
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT = 64;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__DOCUMENTATION = TIMER_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__NAME = TIMER_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__LABEL = TIMER_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__TEXT_ANNOTATION_ATTACHMENT = TIMER_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__SIMULATION_DATA = TIMER_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__RESOURCES_USAGES = TIMER_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__EXECUTION_TIME = TIMER_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__ESTIMATED_TIME = TIMER_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__MAXIMUM_TIME = TIMER_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__CONTIGOUS = TIMER_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = TIMER_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__DATA_CHANGE = TIMER_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__LOOP_TRANSITION = TIMER_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__OUTGOING = TIMER_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__INCOMING = TIMER_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__SYNCHRONOUS = TIMER_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__DYNAMIC_LABEL = TIMER_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__DYNAMIC_DESCRIPTION = TIMER_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__STEP_SUMMARY = TIMER_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__CONNECTORS = TIMER_EVENT__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__DATA = TIMER_EVENT__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__KPIS = TIMER_EVENT__KPIS;

    /**
     * The feature id for the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT__CONDITION = TIMER_EVENT__CONDITION;

    /**
     * The number of structural features of the '<em>Intermediate Catch Timer Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_TIMER_EVENT_FEATURE_COUNT = TIMER_EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.LinkEventImpl <em>Link Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.LinkEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getLinkEvent()
     * @generated
     */
    int LINK_EVENT = 67;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__DOCUMENTATION = EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__NAME = EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__LABEL = EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__TEXT_ANNOTATION_ATTACHMENT = EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__SIMULATION_DATA = EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__RESOURCES_USAGES = EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__EXECUTION_TIME = EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__ESTIMATED_TIME = EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__MAXIMUM_TIME = EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__CONTIGOUS = EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__DATA_CHANGE = EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__LOOP_TRANSITION = EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__OUTGOING = EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__INCOMING = EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__SYNCHRONOUS = EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__DYNAMIC_LABEL = EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__DYNAMIC_DESCRIPTION = EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT__STEP_SUMMARY = EVENT__STEP_SUMMARY;

    /**
     * The number of structural features of the '<em>Link Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.CatchLinkEventImpl <em>Catch Link Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.CatchLinkEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getCatchLinkEvent()
     * @generated
     */
    int CATCH_LINK_EVENT = 65;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__DOCUMENTATION = LINK_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__NAME = LINK_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__LABEL = LINK_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__TEXT_ANNOTATION_ATTACHMENT = LINK_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__SIMULATION_DATA = LINK_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__RESOURCES_USAGES = LINK_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__EXECUTION_TIME = LINK_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__ESTIMATED_TIME = LINK_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__MAXIMUM_TIME = LINK_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__CONTIGOUS = LINK_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = LINK_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__DATA_CHANGE = LINK_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__LOOP_TRANSITION = LINK_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__OUTGOING = LINK_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__INCOMING = LINK_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__SYNCHRONOUS = LINK_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__DYNAMIC_LABEL = LINK_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__DYNAMIC_DESCRIPTION = LINK_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__STEP_SUMMARY = LINK_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>From</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT__FROM = LINK_EVENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Catch Link Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_LINK_EVENT_FEATURE_COUNT = LINK_EVENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ThrowLinkEventImpl <em>Throw Link Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ThrowLinkEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getThrowLinkEvent()
     * @generated
     */
    int THROW_LINK_EVENT = 66;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__DOCUMENTATION = LINK_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__NAME = LINK_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__LABEL = LINK_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__TEXT_ANNOTATION_ATTACHMENT = LINK_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__SIMULATION_DATA = LINK_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__RESOURCES_USAGES = LINK_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__EXECUTION_TIME = LINK_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__ESTIMATED_TIME = LINK_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__MAXIMUM_TIME = LINK_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__CONTIGOUS = LINK_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = LINK_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__DATA_CHANGE = LINK_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__LOOP_TRANSITION = LINK_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__OUTGOING = LINK_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__INCOMING = LINK_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__SYNCHRONOUS = LINK_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__DYNAMIC_LABEL = LINK_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__DYNAMIC_DESCRIPTION = LINK_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__STEP_SUMMARY = LINK_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>To</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT__TO = LINK_EVENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Throw Link Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_LINK_EVENT_FEATURE_COUNT = LINK_EVENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.SignalEventImpl <em>Signal Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.SignalEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getSignalEvent()
     * @generated
     */
    int SIGNAL_EVENT = 68;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__DOCUMENTATION = EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__NAME = EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__LABEL = EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT = EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__SIMULATION_DATA = EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__RESOURCES_USAGES = EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__EXECUTION_TIME = EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__ESTIMATED_TIME = EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__MAXIMUM_TIME = EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__CONTIGOUS = EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__DATA_CHANGE = EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__LOOP_TRANSITION = EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__OUTGOING = EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__INCOMING = EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__SYNCHRONOUS = EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__DYNAMIC_LABEL = EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__DYNAMIC_DESCRIPTION = EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT__STEP_SUMMARY = EVENT__STEP_SUMMARY;

    /**
     * The number of structural features of the '<em>Signal Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.ThrowSignalEventImpl <em>Throw Signal Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.ThrowSignalEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getThrowSignalEvent()
     * @generated
     */
    int THROW_SIGNAL_EVENT = 69;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__DOCUMENTATION = SIGNAL_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__NAME = SIGNAL_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__LABEL = SIGNAL_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT = SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__SIMULATION_DATA = SIGNAL_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__RESOURCES_USAGES = SIGNAL_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__EXECUTION_TIME = SIGNAL_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__ESTIMATED_TIME = SIGNAL_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__MAXIMUM_TIME = SIGNAL_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__CONTIGOUS = SIGNAL_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__DATA_CHANGE = SIGNAL_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__LOOP_TRANSITION = SIGNAL_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__OUTGOING = SIGNAL_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__INCOMING = SIGNAL_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__SYNCHRONOUS = SIGNAL_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__DYNAMIC_LABEL = SIGNAL_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__DYNAMIC_DESCRIPTION = SIGNAL_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__STEP_SUMMARY = SIGNAL_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT__EVENTS = SIGNAL_EVENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Throw Signal Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int THROW_SIGNAL_EVENT_FEATURE_COUNT = SIGNAL_EVENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.CatchSignalEventImpl <em>Catch Signal Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.CatchSignalEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getCatchSignalEvent()
     * @generated
     */
    int CATCH_SIGNAL_EVENT = 70;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__DOCUMENTATION = SIGNAL_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__NAME = SIGNAL_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__LABEL = SIGNAL_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT = SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__SIMULATION_DATA = SIGNAL_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__RESOURCES_USAGES = SIGNAL_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__EXECUTION_TIME = SIGNAL_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__ESTIMATED_TIME = SIGNAL_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__MAXIMUM_TIME = SIGNAL_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__CONTIGOUS = SIGNAL_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__DATA_CHANGE = SIGNAL_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__LOOP_TRANSITION = SIGNAL_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__OUTGOING = SIGNAL_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__INCOMING = SIGNAL_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__SYNCHRONOUS = SIGNAL_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__DYNAMIC_LABEL = SIGNAL_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__DYNAMIC_DESCRIPTION = SIGNAL_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__STEP_SUMMARY = SIGNAL_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__CONNECTORS = SIGNAL_EVENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__DATA = SIGNAL_EVENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__KPIS = SIGNAL_EVENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Signal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__SIGNAL = SIGNAL_EVENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Matcher</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT__MATCHER = SIGNAL_EVENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Catch Signal Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATCH_SIGNAL_EVENT_FEATURE_COUNT = SIGNAL_EVENT_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.EndSignalEventImpl <em>End Signal Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.EndSignalEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEndSignalEvent()
     * @generated
     */
    int END_SIGNAL_EVENT = 71;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__DOCUMENTATION = THROW_SIGNAL_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__NAME = THROW_SIGNAL_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__LABEL = THROW_SIGNAL_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT = THROW_SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__SIMULATION_DATA = THROW_SIGNAL_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__RESOURCES_USAGES = THROW_SIGNAL_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__EXECUTION_TIME = THROW_SIGNAL_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__ESTIMATED_TIME = THROW_SIGNAL_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__MAXIMUM_TIME = THROW_SIGNAL_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__CONTIGOUS = THROW_SIGNAL_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = THROW_SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__DATA_CHANGE = THROW_SIGNAL_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__LOOP_TRANSITION = THROW_SIGNAL_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__OUTGOING = THROW_SIGNAL_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__INCOMING = THROW_SIGNAL_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__SYNCHRONOUS = THROW_SIGNAL_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__DYNAMIC_LABEL = THROW_SIGNAL_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__DYNAMIC_DESCRIPTION = THROW_SIGNAL_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__STEP_SUMMARY = THROW_SIGNAL_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT__EVENTS = THROW_SIGNAL_EVENT__EVENTS;

    /**
     * The number of structural features of the '<em>End Signal Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_SIGNAL_EVENT_FEATURE_COUNT = THROW_SIGNAL_EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.IntermediateThrowSignalEventImpl <em>Intermediate Throw Signal Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.IntermediateThrowSignalEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateThrowSignalEvent()
     * @generated
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT = 72;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__DOCUMENTATION = THROW_SIGNAL_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__NAME = THROW_SIGNAL_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__LABEL = THROW_SIGNAL_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT = THROW_SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__SIMULATION_DATA = THROW_SIGNAL_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__RESOURCES_USAGES = THROW_SIGNAL_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__EXECUTION_TIME = THROW_SIGNAL_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__ESTIMATED_TIME = THROW_SIGNAL_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__MAXIMUM_TIME = THROW_SIGNAL_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__CONTIGOUS = THROW_SIGNAL_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = THROW_SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__DATA_CHANGE = THROW_SIGNAL_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__LOOP_TRANSITION = THROW_SIGNAL_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__OUTGOING = THROW_SIGNAL_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__INCOMING = THROW_SIGNAL_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__SYNCHRONOUS = THROW_SIGNAL_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__DYNAMIC_LABEL = THROW_SIGNAL_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__DYNAMIC_DESCRIPTION = THROW_SIGNAL_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__STEP_SUMMARY = THROW_SIGNAL_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT__EVENTS = THROW_SIGNAL_EVENT__EVENTS;

    /**
     * The number of structural features of the '<em>Intermediate Throw Signal Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_THROW_SIGNAL_EVENT_FEATURE_COUNT = THROW_SIGNAL_EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.IntermediateCatchSignalEventImpl <em>Intermediate Catch Signal Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.IntermediateCatchSignalEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateCatchSignalEvent()
     * @generated
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT = 73;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__DOCUMENTATION = CATCH_SIGNAL_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__NAME = CATCH_SIGNAL_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__LABEL = CATCH_SIGNAL_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT = CATCH_SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__SIMULATION_DATA = CATCH_SIGNAL_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__RESOURCES_USAGES = CATCH_SIGNAL_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__EXECUTION_TIME = CATCH_SIGNAL_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__ESTIMATED_TIME = CATCH_SIGNAL_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__MAXIMUM_TIME = CATCH_SIGNAL_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__CONTIGOUS = CATCH_SIGNAL_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = CATCH_SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__DATA_CHANGE = CATCH_SIGNAL_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__LOOP_TRANSITION = CATCH_SIGNAL_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__OUTGOING = CATCH_SIGNAL_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__INCOMING = CATCH_SIGNAL_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__SYNCHRONOUS = CATCH_SIGNAL_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__DYNAMIC_LABEL = CATCH_SIGNAL_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__DYNAMIC_DESCRIPTION = CATCH_SIGNAL_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__STEP_SUMMARY = CATCH_SIGNAL_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__CONNECTORS = CATCH_SIGNAL_EVENT__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__DATA = CATCH_SIGNAL_EVENT__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__KPIS = CATCH_SIGNAL_EVENT__KPIS;

    /**
     * The feature id for the '<em><b>Signal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__SIGNAL = CATCH_SIGNAL_EVENT__SIGNAL;

    /**
     * The feature id for the '<em><b>Matcher</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT__MATCHER = CATCH_SIGNAL_EVENT__MATCHER;

    /**
     * The number of structural features of the '<em>Intermediate Catch Signal Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_CATCH_SIGNAL_EVENT_FEATURE_COUNT = CATCH_SIGNAL_EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.StartSignalEventImpl <em>Start Signal Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.StartSignalEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getStartSignalEvent()
     * @generated
     */
    int START_SIGNAL_EVENT = 74;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__DOCUMENTATION = CATCH_SIGNAL_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__NAME = CATCH_SIGNAL_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__LABEL = CATCH_SIGNAL_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT = CATCH_SIGNAL_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Simulation Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__SIMULATION_DATA = CATCH_SIGNAL_EVENT__SIMULATION_DATA;

    /**
     * The feature id for the '<em><b>Resources Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__RESOURCES_USAGES = CATCH_SIGNAL_EVENT__RESOURCES_USAGES;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__EXECUTION_TIME = CATCH_SIGNAL_EVENT__EXECUTION_TIME;

    /**
     * The feature id for the '<em><b>Estimated Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__ESTIMATED_TIME = CATCH_SIGNAL_EVENT__ESTIMATED_TIME;

    /**
     * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__MAXIMUM_TIME = CATCH_SIGNAL_EVENT__MAXIMUM_TIME;

    /**
     * The feature id for the '<em><b>Contigous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__CONTIGOUS = CATCH_SIGNAL_EVENT__CONTIGOUS;

    /**
     * The feature id for the '<em><b>Exclusive Outgoing Transition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION = CATCH_SIGNAL_EVENT__EXCLUSIVE_OUTGOING_TRANSITION;

    /**
     * The feature id for the '<em><b>Data Change</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__DATA_CHANGE = CATCH_SIGNAL_EVENT__DATA_CHANGE;

    /**
     * The feature id for the '<em><b>Loop Transition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__LOOP_TRANSITION = CATCH_SIGNAL_EVENT__LOOP_TRANSITION;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__OUTGOING = CATCH_SIGNAL_EVENT__OUTGOING;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__INCOMING = CATCH_SIGNAL_EVENT__INCOMING;

    /**
     * The feature id for the '<em><b>Synchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__SYNCHRONOUS = CATCH_SIGNAL_EVENT__SYNCHRONOUS;

    /**
     * The feature id for the '<em><b>Dynamic Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__DYNAMIC_LABEL = CATCH_SIGNAL_EVENT__DYNAMIC_LABEL;

    /**
     * The feature id for the '<em><b>Dynamic Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__DYNAMIC_DESCRIPTION = CATCH_SIGNAL_EVENT__DYNAMIC_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Step Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__STEP_SUMMARY = CATCH_SIGNAL_EVENT__STEP_SUMMARY;

    /**
     * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__CONNECTORS = CATCH_SIGNAL_EVENT__CONNECTORS;

    /**
     * The feature id for the '<em><b>Data</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__DATA = CATCH_SIGNAL_EVENT__DATA;

    /**
     * The feature id for the '<em><b>Kpis</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__KPIS = CATCH_SIGNAL_EVENT__KPIS;

    /**
     * The feature id for the '<em><b>Signal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__SIGNAL = CATCH_SIGNAL_EVENT__SIGNAL;

    /**
     * The feature id for the '<em><b>Matcher</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT__MATCHER = CATCH_SIGNAL_EVENT__MATCHER;

    /**
     * The number of structural features of the '<em>Start Signal Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_SIGNAL_EVENT_FEATURE_COUNT = CATCH_SIGNAL_EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.Assignable <em>Assignable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.Assignable
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAssignable()
     * @generated
     */
    int ASSIGNABLE = 75;

    /**
     * The feature id for the '<em><b>User</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSIGNABLE__USER = 0;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSIGNABLE__FILTERS = 1;

    /**
     * The feature id for the '<em><b>Groups</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSIGNABLE__GROUPS = 2;

    /**
     * The feature id for the '<em><b>Actor Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSIGNABLE__ACTOR_TYPE = 3;

    /**
     * The number of structural features of the '<em>Assignable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSIGNABLE_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.RecapFlow <em>Recap Flow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.RecapFlow
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getRecapFlow()
     * @generated
     */
    int RECAP_FLOW = 76;

    /**
     * The feature id for the '<em><b>Recap Forms</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECAP_FLOW__RECAP_FORMS = 0;

    /**
     * The number of structural features of the '<em>Recap Flow</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECAP_FLOW_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.BoundaryEventImpl <em>Boundary Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.BoundaryEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getBoundaryEvent()
     * @generated
     */
    int BOUNDARY_EVENT = 77;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOUNDARY_EVENT__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOUNDARY_EVENT__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOUNDARY_EVENT__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOUNDARY_EVENT__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOUNDARY_EVENT__OUTGOING = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Boundary Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOUNDARY_EVENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.impl.IntermediateErrorCatchEventImpl <em>Intermediate Error Catch Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.impl.IntermediateErrorCatchEventImpl
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateErrorCatchEvent()
     * @generated
     */
    int INTERMEDIATE_ERROR_CATCH_EVENT = 78;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ERROR_CATCH_EVENT__DOCUMENTATION = BOUNDARY_EVENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ERROR_CATCH_EVENT__NAME = BOUNDARY_EVENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ERROR_CATCH_EVENT__LABEL = BOUNDARY_EVENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ERROR_CATCH_EVENT__TEXT_ANNOTATION_ATTACHMENT = BOUNDARY_EVENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ERROR_CATCH_EVENT__OUTGOING = BOUNDARY_EVENT__OUTGOING;

    /**
     * The number of structural features of the '<em>Intermediate Error Catch Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ERROR_CATCH_EVENT_FEATURE_COUNT = BOUNDARY_EVENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.SourceElement <em>Source Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.SourceElement
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getSourceElement()
     * @generated
     */
    int SOURCE_ELEMENT = 79;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ELEMENT__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ELEMENT__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ELEMENT__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ELEMENT__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Outgoing</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ELEMENT__OUTGOING = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Source Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.TargetElement <em>Target Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.TargetElement
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getTargetElement()
     * @generated
     */
    int TARGET_ELEMENT = 80;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TARGET_ELEMENT__DOCUMENTATION = ELEMENT__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TARGET_ELEMENT__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TARGET_ELEMENT__LABEL = ELEMENT__LABEL;

    /**
     * The feature id for the '<em><b>Text Annotation Attachment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TARGET_ELEMENT__TEXT_ANNOTATION_ATTACHMENT = ELEMENT__TEXT_ANNOTATION_ATTACHMENT;

    /**
     * The feature id for the '<em><b>Incoming</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TARGET_ELEMENT__INCOMING = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Target Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TARGET_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.GatewayType <em>Gateway Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.GatewayType
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getGatewayType()
     * @generated
     */
    int GATEWAY_TYPE = 81;

    /**
     * The meta object id for the '{@link org.talend.process.model.process.ActorType <em>Actor Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.process.model.process.ActorType
     * @see org.talend.process.model.process.impl.ProcessPackageImpl#getActorType()
     * @generated
     */
    int ACTOR_TYPE = 82;


    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Element <em>Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element</em>'.
     * @see org.talend.process.model.process.Element
     * @generated
     */
    EClass getElement();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Element#getDocumentation <em>Documentation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Documentation</em>'.
     * @see org.talend.process.model.process.Element#getDocumentation()
     * @see #getElement()
     * @generated
     */
    EAttribute getElement_Documentation();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Element#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.talend.process.model.process.Element#getName()
     * @see #getElement()
     * @generated
     */
    EAttribute getElement_Name();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Element#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.process.model.process.Element#getLabel()
     * @see #getElement()
     * @generated
     */
    EAttribute getElement_Label();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.Element#getTextAnnotationAttachment <em>Text Annotation Attachment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Text Annotation Attachment</em>'.
     * @see org.talend.process.model.process.Element#getTextAnnotationAttachment()
     * @see #getElement()
     * @generated
     */
    EReference getElement_TextAnnotationAttachment();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.AbstractProcess <em>Abstract Process</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Process</em>'.
     * @see org.talend.process.model.process.AbstractProcess
     * @generated
     */
    EClass getAbstractProcess();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.AbstractProcess#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getVersion()
     * @see #getAbstractProcess()
     * @generated
     */
    EAttribute getAbstractProcess_Version();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.AbstractProcess#getAuthor <em>Author</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Author</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getAuthor()
     * @see #getAbstractProcess()
     * @generated
     */
    EAttribute getAbstractProcess_Author();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.AbstractProcess#getCreationDate <em>Creation Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Creation Date</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getCreationDate()
     * @see #getAbstractProcess()
     * @generated
     */
    EAttribute getAbstractProcess_CreationDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.AbstractProcess#getModificationDate <em>Modification Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Modification Date</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getModificationDate()
     * @see #getAbstractProcess()
     * @generated
     */
    EAttribute getAbstractProcess_ModificationDate();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.AbstractProcess#getGroups <em>Groups</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Groups</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getGroups()
     * @see #getAbstractProcess()
     * @generated
     */
    EReference getAbstractProcess_Groups();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.AbstractProcess#getDatatypes <em>Datatypes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Datatypes</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getDatatypes()
     * @see #getAbstractProcess()
     * @generated
     */
    EReference getAbstractProcess_Datatypes();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.AbstractProcess#getConnections <em>Connections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Connections</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getConnections()
     * @see #getAbstractProcess()
     * @generated
     */
    EReference getAbstractProcess_Connections();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.AbstractProcess#getMandatorySymbol <em>Mandatory Symbol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mandatory Symbol</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getMandatorySymbol()
     * @see #getAbstractProcess()
     * @generated
     */
    EAttribute getAbstractProcess_MandatorySymbol();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.AbstractProcess#getMandatoryClasses <em>Mandatory Classes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mandatory Classes</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getMandatoryClasses()
     * @see #getAbstractProcess()
     * @generated
     */
    EAttribute getAbstractProcess_MandatoryClasses();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.AbstractProcess#getMandatoryLabel <em>Mandatory Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mandatory Label</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getMandatoryLabel()
     * @see #getAbstractProcess()
     * @generated
     */
    EAttribute getAbstractProcess_MandatoryLabel();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.AbstractProcess#getErrorTemplate <em>Error Template</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Error Template</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getErrorTemplate()
     * @see #getAbstractProcess()
     * @generated
     */
    EReference getAbstractProcess_ErrorTemplate();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.AbstractProcess#getProcessTemplate <em>Process Template</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Process Template</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getProcessTemplate()
     * @see #getAbstractProcess()
     * @generated
     */
    EReference getAbstractProcess_ProcessTemplate();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.AbstractProcess#getPageTemplate <em>Page Template</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Page Template</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getPageTemplate()
     * @see #getAbstractProcess()
     * @generated
     */
    EReference getAbstractProcess_PageTemplate();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.AbstractProcess#getConsultationTemplate <em>Consultation Template</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Consultation Template</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getConsultationTemplate()
     * @see #getAbstractProcess()
     * @generated
     */
    EReference getAbstractProcess_ConsultationTemplate();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.AbstractProcess#getLogInPage <em>Log In Page</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Log In Page</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getLogInPage()
     * @see #getAbstractProcess()
     * @generated
     */
    EReference getAbstractProcess_LogInPage();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.AbstractProcess#getWelcomePage <em>Welcome Page</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Welcome Page</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getWelcomePage()
     * @see #getAbstractProcess()
     * @generated
     */
    EReference getAbstractProcess_WelcomePage();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.AbstractProcess#getWelcomePageInternal <em>Welcome Page Internal</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Welcome Page Internal</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getWelcomePageInternal()
     * @see #getAbstractProcess()
     * @generated
     */
    EAttribute getAbstractProcess_WelcomePageInternal();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.process.model.process.AbstractProcess#getCategories <em>Categories</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Categories</em>'.
     * @see org.talend.process.model.process.AbstractProcess#getCategories()
     * @see #getAbstractProcess()
     * @generated
     */
    EAttribute getAbstractProcess_Categories();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.MainProcess <em>Main Process</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Main Process</em>'.
     * @see org.talend.process.model.process.MainProcess
     * @generated
     */
    EClass getMainProcess();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.MainProcess#getBonitaVersion <em>Bonita Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Bonita Version</em>'.
     * @see org.talend.process.model.process.MainProcess#getBonitaVersion()
     * @see #getMainProcess()
     * @generated
     */
    EAttribute getMainProcess_BonitaVersion();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.MainProcess#getBonitaModelVersion <em>Bonita Model Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Bonita Model Version</em>'.
     * @see org.talend.process.model.process.MainProcess#getBonitaModelVersion()
     * @see #getMainProcess()
     * @generated
     */
    EAttribute getMainProcess_BonitaModelVersion();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.process.model.process.MainProcess#getIncludedEntries <em>Included Entries</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Included Entries</em>'.
     * @see org.talend.process.model.process.MainProcess#getIncludedEntries()
     * @see #getMainProcess()
     * @generated
     */
    EAttribute getMainProcess_IncludedEntries();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.MainProcess#getMessageConnections <em>Message Connections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Message Connections</em>'.
     * @see org.talend.process.model.process.MainProcess#getMessageConnections()
     * @see #getMainProcess()
     * @generated
     */
    EReference getMainProcess_MessageConnections();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Task <em>Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Task</em>'.
     * @see org.talend.process.model.process.Task
     * @generated
     */
    EClass getTask();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Task#isOverrideGroupsOfTheLane <em>Override Groups Of The Lane</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Override Groups Of The Lane</em>'.
     * @see org.talend.process.model.process.Task#isOverrideGroupsOfTheLane()
     * @see #getTask()
     * @generated
     */
    EAttribute getTask_OverrideGroupsOfTheLane();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Task#getPriority <em>Priority</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Priority</em>'.
     * @see org.talend.process.model.process.Task#getPriority()
     * @see #getTask()
     * @generated
     */
    EAttribute getTask_Priority();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Gateway <em>Gateway</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Gateway</em>'.
     * @see org.talend.process.model.process.Gateway
     * @generated
     */
    EClass getGateway();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Gateway#getGatewayType <em>Gateway Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Gateway Type</em>'.
     * @see org.talend.process.model.process.Gateway#getGatewayType()
     * @see #getGateway()
     * @generated
     */
    EAttribute getGateway_GatewayType();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.XORGateway <em>XOR Gateway</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>XOR Gateway</em>'.
     * @see org.talend.process.model.process.XORGateway
     * @generated
     */
    EClass getXORGateway();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.ANDGateway <em>AND Gateway</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>AND Gateway</em>'.
     * @see org.talend.process.model.process.ANDGateway
     * @generated
     */
    EClass getANDGateway();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Connection</em>'.
     * @see org.talend.process.model.process.Connection
     * @generated
     */
    EClass getConnection();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.Connection#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see org.talend.process.model.process.Connection#getSource()
     * @see #getConnection()
     * @generated
     */
    EReference getConnection_Source();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.Connection#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see org.talend.process.model.process.Connection#getTarget()
     * @see #getConnection()
     * @generated
     */
    EReference getConnection_Target();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.MessageFlow <em>Message Flow</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Message Flow</em>'.
     * @see org.talend.process.model.process.MessageFlow
     * @generated
     */
    EClass getMessageFlow();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.MessageFlow#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see org.talend.process.model.process.MessageFlow#getSource()
     * @see #getMessageFlow()
     * @generated
     */
    EReference getMessageFlow_Source();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.MessageFlow#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see org.talend.process.model.process.MessageFlow#getTarget()
     * @see #getMessageFlow()
     * @generated
     */
    EReference getMessageFlow_Target();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Association <em>Association</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Association</em>'.
     * @see org.talend.process.model.process.Association
     * @generated
     */
    EClass getAssociation();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Association#isIsDirected <em>Is Directed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Directed</em>'.
     * @see org.talend.process.model.process.Association#isIsDirected()
     * @see #getAssociation()
     * @generated
     */
    EAttribute getAssociation_IsDirected();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.SequenceFlow <em>Sequence Flow</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sequence Flow</em>'.
     * @see org.talend.process.model.process.SequenceFlow
     * @generated
     */
    EClass getSequenceFlow();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.SequenceFlow#getQuantity <em>Quantity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Quantity</em>'.
     * @see org.talend.process.model.process.SequenceFlow#getQuantity()
     * @see #getSequenceFlow()
     * @generated
     */
    EAttribute getSequenceFlow_Quantity();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.SequenceFlow#isIsDefault <em>Is Default</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Default</em>'.
     * @see org.talend.process.model.process.SequenceFlow#isIsDefault()
     * @see #getSequenceFlow()
     * @generated
     */
    EAttribute getSequenceFlow_IsDefault();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.SequenceFlow#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Condition</em>'.
     * @see org.talend.process.model.process.SequenceFlow#getCondition()
     * @see #getSequenceFlow()
     * @generated
     */
    EAttribute getSequenceFlow_Condition();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Lane <em>Lane</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Lane</em>'.
     * @see org.talend.process.model.process.Lane
     * @generated
     */
    EClass getLane();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Pool <em>Pool</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Pool</em>'.
     * @see org.talend.process.model.process.Pool
     * @generated
     */
    EClass getPool();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Activity <em>Activity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Activity</em>'.
     * @see org.talend.process.model.process.Activity
     * @generated
     */
    EClass getActivity();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Activity#getDuration <em>Duration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Duration</em>'.
     * @see org.talend.process.model.process.Activity#getDuration()
     * @see #getActivity()
     * @generated
     */
    EAttribute getActivity_Duration();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.Activity#getDeadlines <em>Deadlines</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Deadlines</em>'.
     * @see org.talend.process.model.process.Activity#getDeadlines()
     * @see #getActivity()
     * @generated
     */
    EReference getActivity_Deadlines();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.Activity#getMultiInstantiation <em>Multi Instantiation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Multi Instantiation</em>'.
     * @see org.talend.process.model.process.Activity#getMultiInstantiation()
     * @see #getActivity()
     * @generated
     */
    EReference getActivity_MultiInstantiation();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Activity#getIsLoop <em>Is Loop</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Loop</em>'.
     * @see org.talend.process.model.process.Activity#getIsLoop()
     * @see #getActivity()
     * @generated
     */
    EAttribute getActivity_IsLoop();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Activity#getTestBefore <em>Test Before</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Test Before</em>'.
     * @see org.talend.process.model.process.Activity#getTestBefore()
     * @see #getActivity()
     * @generated
     */
    EAttribute getActivity_TestBefore();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Activity#getLoopCondition <em>Loop Condition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Loop Condition</em>'.
     * @see org.talend.process.model.process.Activity#getLoopCondition()
     * @see #getActivity()
     * @generated
     */
    EAttribute getActivity_LoopCondition();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Activity#getLoopMaximum <em>Loop Maximum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Loop Maximum</em>'.
     * @see org.talend.process.model.process.Activity#getLoopMaximum()
     * @see #getActivity()
     * @generated
     */
    EAttribute getActivity_LoopMaximum();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.Activity#getBoundaryIntermediateEvents <em>Boundary Intermediate Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Boundary Intermediate Events</em>'.
     * @see org.talend.process.model.process.Activity#getBoundaryIntermediateEvents()
     * @see #getActivity()
     * @generated
     */
    EReference getActivity_BoundaryIntermediateEvents();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.SendTask <em>Send Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Send Task</em>'.
     * @see org.talend.process.model.process.SendTask
     * @generated
     */
    EClass getSendTask();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.ReceiveTask <em>Receive Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Receive Task</em>'.
     * @see org.talend.process.model.process.ReceiveTask
     * @generated
     */
    EClass getReceiveTask();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.ScriptTask <em>Script Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Script Task</em>'.
     * @see org.talend.process.model.process.ScriptTask
     * @generated
     */
    EClass getScriptTask();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.ServiceTask <em>Service Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Service Task</em>'.
     * @see org.talend.process.model.process.ServiceTask
     * @generated
     */
    EClass getServiceTask();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.SubProcess <em>Sub Process</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sub Process</em>'.
     * @see org.talend.process.model.process.SubProcess
     * @generated
     */
    EClass getSubProcess();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.SubProcess#getSubprocessName <em>Subprocess Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Subprocess Name</em>'.
     * @see org.talend.process.model.process.SubProcess#getSubprocessName()
     * @see #getSubProcess()
     * @generated
     */
    EAttribute getSubProcess_SubprocessName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.SubProcess#getSubprocessVersion <em>Subprocess Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Subprocess Version</em>'.
     * @see org.talend.process.model.process.SubProcess#getSubprocessVersion()
     * @see #getSubProcess()
     * @generated
     */
    EAttribute getSubProcess_SubprocessVersion();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.SubProcess#getInputMappings <em>Input Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Input Mappings</em>'.
     * @see org.talend.process.model.process.SubProcess#getInputMappings()
     * @see #getSubProcess()
     * @generated
     */
    EReference getSubProcess_InputMappings();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.SubProcess#getOutputMappings <em>Output Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Output Mappings</em>'.
     * @see org.talend.process.model.process.SubProcess#getOutputMappings()
     * @see #getSubProcess()
     * @generated
     */
    EReference getSubProcess_OutputMappings();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.FlowElement <em>Flow Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Flow Element</em>'.
     * @see org.talend.process.model.process.FlowElement
     * @generated
     */
    EClass getFlowElement();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.FlowElement#getSynchronous <em>Synchronous</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Synchronous</em>'.
     * @see org.talend.process.model.process.FlowElement#getSynchronous()
     * @see #getFlowElement()
     * @generated
     */
    EAttribute getFlowElement_Synchronous();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.FlowElement#getDynamicLabel <em>Dynamic Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dynamic Label</em>'.
     * @see org.talend.process.model.process.FlowElement#getDynamicLabel()
     * @see #getFlowElement()
     * @generated
     */
    EAttribute getFlowElement_DynamicLabel();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.FlowElement#getDynamicDescription <em>Dynamic Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dynamic Description</em>'.
     * @see org.talend.process.model.process.FlowElement#getDynamicDescription()
     * @see #getFlowElement()
     * @generated
     */
    EAttribute getFlowElement_DynamicDescription();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.FlowElement#getStepSummary <em>Step Summary</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Step Summary</em>'.
     * @see org.talend.process.model.process.FlowElement#getStepSummary()
     * @see #getFlowElement()
     * @generated
     */
    EAttribute getFlowElement_StepSummary();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Container <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Container</em>'.
     * @see org.talend.process.model.process.Container
     * @generated
     */
    EClass getContainer();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.Container#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Elements</em>'.
     * @see org.talend.process.model.process.Container#getElements()
     * @see #getContainer()
     * @generated
     */
    EReference getContainer_Elements();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.ConnectableElement <em>Connectable Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Connectable Element</em>'.
     * @see org.talend.process.model.process.ConnectableElement
     * @generated
     */
    EClass getConnectableElement();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.ConnectableElement#getConnectors <em>Connectors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Connectors</em>'.
     * @see org.talend.process.model.process.ConnectableElement#getConnectors()
     * @see #getConnectableElement()
     * @generated
     */
    EReference getConnectableElement_Connectors();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.ConnectableElement#getData <em>Data</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Data</em>'.
     * @see org.talend.process.model.process.ConnectableElement#getData()
     * @see #getConnectableElement()
     * @generated
     */
    EReference getConnectableElement_Data();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.ConnectableElement#getKpis <em>Kpis</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Kpis</em>'.
     * @see org.talend.process.model.process.ConnectableElement#getKpis()
     * @see #getConnectableElement()
     * @generated
     */
    EReference getConnectableElement_Kpis();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Connector <em>Connector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Connector</em>'.
     * @see org.talend.process.model.process.Connector
     * @generated
     */
    EClass getConnector();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Connector#getConnectorId <em>Connector Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Connector Id</em>'.
     * @see org.talend.process.model.process.Connector#getConnectorId()
     * @see #getConnector()
     * @generated
     */
    EAttribute getConnector_ConnectorId();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Connector#getConfigurationId <em>Configuration Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Configuration Id</em>'.
     * @see org.talend.process.model.process.Connector#getConfigurationId()
     * @see #getConnector()
     * @generated
     */
    EAttribute getConnector_ConfigurationId();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.Connector#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameters</em>'.
     * @see org.talend.process.model.process.Connector#getParameters()
     * @see #getConnector()
     * @generated
     */
    EReference getConnector_Parameters();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Connector#getEvent <em>Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Event</em>'.
     * @see org.talend.process.model.process.Connector#getEvent()
     * @see #getConnector()
     * @generated
     */
    EAttribute getConnector_Event();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Connector#isIgnoreErrors <em>Ignore Errors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ignore Errors</em>'.
     * @see org.talend.process.model.process.Connector#isIgnoreErrors()
     * @see #getConnector()
     * @generated
     */
    EAttribute getConnector_IgnoreErrors();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.Connector#getOutputs <em>Outputs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Outputs</em>'.
     * @see org.talend.process.model.process.Connector#getOutputs()
     * @see #getConnector()
     * @generated
     */
    EReference getConnector_Outputs();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Parameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Parameter</em>'.
     * @see org.talend.process.model.process.Parameter
     * @generated
     */
    EClass getParameter();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Parameter#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.talend.process.model.process.Parameter#getKey()
     * @see #getParameter()
     * @generated
     */
    EAttribute getParameter_Key();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Parameter#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.talend.process.model.process.Parameter#getValue()
     * @see #getParameter()
     * @generated
     */
    EAttribute getParameter_Value();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.OutputParameterMapping <em>Output Parameter Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Output Parameter Mapping</em>'.
     * @see org.talend.process.model.process.OutputParameterMapping
     * @generated
     */
    EClass getOutputParameterMapping();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.OutputParameterMapping#getValueExpression <em>Value Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value Expression</em>'.
     * @see org.talend.process.model.process.OutputParameterMapping#getValueExpression()
     * @see #getOutputParameterMapping()
     * @generated
     */
    EAttribute getOutputParameterMapping_ValueExpression();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.OutputParameterMapping#getTargetData <em>Target Data</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target Data</em>'.
     * @see org.talend.process.model.process.OutputParameterMapping#getTargetData()
     * @see #getOutputParameterMapping()
     * @generated
     */
    EReference getOutputParameterMapping_TargetData();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.OutputParameterMapping#getAdditionalPath <em>Additional Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Additional Path</em>'.
     * @see org.talend.process.model.process.OutputParameterMapping#getAdditionalPath()
     * @see #getOutputParameterMapping()
     * @generated
     */
    EAttribute getOutputParameterMapping_AdditionalPath();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.OutputParameterMapping#getTargetWidget <em>Target Widget</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target Widget</em>'.
     * @see org.talend.process.model.process.OutputParameterMapping#getTargetWidget()
     * @see #getOutputParameterMapping()
     * @generated
     */
    EReference getOutputParameterMapping_TargetWidget();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Group <em>Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Group</em>'.
     * @see org.talend.process.model.process.Group
     * @generated
     */
    EClass getGroup();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Data <em>Data</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data</em>'.
     * @see org.talend.process.model.process.Data
     * @generated
     */
    EClass getData();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.Data#getDataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Data Type</em>'.
     * @see org.talend.process.model.process.Data#getDataType()
     * @see #getData()
     * @generated
     */
    EReference getData_DataType();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Data#getDefaultValue <em>Default Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Value</em>'.
     * @see org.talend.process.model.process.Data#getDefaultValue()
     * @see #getData()
     * @generated
     */
    EAttribute getData_DefaultValue();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Data#isGenerated <em>Generated</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generated</em>'.
     * @see org.talend.process.model.process.Data#isGenerated()
     * @see #getData()
     * @generated
     */
    EAttribute getData_Generated();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.AttachmentData <em>Attachment Data</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attachment Data</em>'.
     * @see org.talend.process.model.process.AttachmentData
     * @generated
     */
    EClass getAttachmentData();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.AttachmentData#getBarPath <em>Bar Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Bar Path</em>'.
     * @see org.talend.process.model.process.AttachmentData#getBarPath()
     * @see #getAttachmentData()
     * @generated
     */
    EAttribute getAttachmentData_BarPath();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.JavaObjectData <em>Java Object Data</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Java Object Data</em>'.
     * @see org.talend.process.model.process.JavaObjectData
     * @generated
     */
    EClass getJavaObjectData();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.JavaObjectData#getClassName <em>Class Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Class Name</em>'.
     * @see org.talend.process.model.process.JavaObjectData#getClassName()
     * @see #getJavaObjectData()
     * @generated
     */
    EAttribute getJavaObjectData_ClassName();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.XMLData <em>XML Data</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>XML Data</em>'.
     * @see org.talend.process.model.process.XMLData
     * @generated
     */
    EClass getXMLData();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.XMLData#getNamespace <em>Namespace</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Namespace</em>'.
     * @see org.talend.process.model.process.XMLData#getNamespace()
     * @see #getXMLData()
     * @generated
     */
    EAttribute getXMLData_Namespace();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.XMLData#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.talend.process.model.process.XMLData#getType()
     * @see #getXMLData()
     * @generated
     */
    EAttribute getXMLData_Type();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.DataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Type</em>'.
     * @see org.talend.process.model.process.DataType
     * @generated
     */
    EClass getDataType();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.IntegerType <em>Integer Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Integer Type</em>'.
     * @see org.talend.process.model.process.IntegerType
     * @generated
     */
    EClass getIntegerType();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.StringType <em>String Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Type</em>'.
     * @see org.talend.process.model.process.StringType
     * @generated
     */
    EClass getStringType();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.DateType <em>Date Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Date Type</em>'.
     * @see org.talend.process.model.process.DateType
     * @generated
     */
    EClass getDateType();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.FloatType <em>Float Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Float Type</em>'.
     * @see org.talend.process.model.process.FloatType
     * @generated
     */
    EClass getFloatType();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.BooleanType <em>Boolean Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Boolean Type</em>'.
     * @see org.talend.process.model.process.BooleanType
     * @generated
     */
    EClass getBooleanType();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.EnumType <em>Enum Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Enum Type</em>'.
     * @see org.talend.process.model.process.EnumType
     * @generated
     */
    EClass getEnumType();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.process.model.process.EnumType#getLiterals <em>Literals</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Literals</em>'.
     * @see org.talend.process.model.process.EnumType#getLiterals()
     * @see #getEnumType()
     * @generated
     */
    EAttribute getEnumType_Literals();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.JavaType <em>Java Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Java Type</em>'.
     * @see org.talend.process.model.process.JavaType
     * @generated
     */
    EClass getJavaType();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.XMLType <em>XML Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>XML Type</em>'.
     * @see org.talend.process.model.process.XMLType
     * @generated
     */
    EClass getXMLType();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.OutputMapping <em>Output Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Output Mapping</em>'.
     * @see org.talend.process.model.process.OutputMapping
     * @generated
     */
    EClass getOutputMapping();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.OutputMapping#getSubprocessSource <em>Subprocess Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Subprocess Source</em>'.
     * @see org.talend.process.model.process.OutputMapping#getSubprocessSource()
     * @see #getOutputMapping()
     * @generated
     */
    EAttribute getOutputMapping_SubprocessSource();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.OutputMapping#getProcessTarget <em>Process Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Process Target</em>'.
     * @see org.talend.process.model.process.OutputMapping#getProcessTarget()
     * @see #getOutputMapping()
     * @generated
     */
    EReference getOutputMapping_ProcessTarget();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.AttachmentType <em>Attachment Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attachment Type</em>'.
     * @see org.talend.process.model.process.AttachmentType
     * @generated
     */
    EClass getAttachmentType();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.StartEvent <em>Start Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Start Event</em>'.
     * @see org.talend.process.model.process.StartEvent
     * @generated
     */
    EClass getStartEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.EndEvent <em>End Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>End Event</em>'.
     * @see org.talend.process.model.process.EndEvent
     * @generated
     */
    EClass getEndEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Event <em>Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event</em>'.
     * @see org.talend.process.model.process.Event
     * @generated
     */
    EClass getEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.PageFlow <em>Page Flow</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Page Flow</em>'.
     * @see org.talend.process.model.process.PageFlow
     * @generated
     */
    EClass getPageFlow();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.PageFlow#getForm <em>Form</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Form</em>'.
     * @see org.talend.process.model.process.PageFlow#getForm()
     * @see #getPageFlow()
     * @generated
     */
    EReference getPageFlow_Form();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.PageFlow#getByPassFormsGeneration <em>By Pass Forms Generation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>By Pass Forms Generation</em>'.
     * @see org.talend.process.model.process.PageFlow#getByPassFormsGeneration()
     * @see #getPageFlow()
     * @generated
     */
    EAttribute getPageFlow_ByPassFormsGeneration();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.PageFlow#getConfirmationTemplate <em>Confirmation Template</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Confirmation Template</em>'.
     * @see org.talend.process.model.process.PageFlow#getConfirmationTemplate()
     * @see #getPageFlow()
     * @generated
     */
    EReference getPageFlow_ConfirmationTemplate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.PageFlow#getConfirmationMessage <em>Confirmation Message</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Confirmation Message</em>'.
     * @see org.talend.process.model.process.PageFlow#getConfirmationMessage()
     * @see #getPageFlow()
     * @generated
     */
    EAttribute getPageFlow_ConfirmationMessage();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.PageFlow#getRegExpToHideDefaultField <em>Reg Exp To Hide Default Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Reg Exp To Hide Default Field</em>'.
     * @see org.talend.process.model.process.PageFlow#getRegExpToHideDefaultField()
     * @see #getPageFlow()
     * @generated
     */
    EAttribute getPageFlow_RegExpToHideDefaultField();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.PageFlow#isUseRegExpToHideDefaultField <em>Use Reg Exp To Hide Default Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Use Reg Exp To Hide Default Field</em>'.
     * @see org.talend.process.model.process.PageFlow#isUseRegExpToHideDefaultField()
     * @see #getPageFlow()
     * @generated
     */
    EAttribute getPageFlow_UseRegExpToHideDefaultField();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.PageFlow#getViewForm <em>View Form</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>View Form</em>'.
     * @see org.talend.process.model.process.PageFlow#getViewForm()
     * @see #getPageFlow()
     * @generated
     */
    EReference getPageFlow_ViewForm();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.PageFlow#isUseViewForm <em>Use View Form</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Use View Form</em>'.
     * @see org.talend.process.model.process.PageFlow#isUseViewForm()
     * @see #getPageFlow()
     * @generated
     */
    EAttribute getPageFlow_UseViewForm();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.ResourceContainer <em>Resource Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Resource Container</em>'.
     * @see org.talend.process.model.process.ResourceContainer
     * @generated
     */
    EClass getResourceContainer();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.ResourceContainer#getResourceFolders <em>Resource Folders</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Resource Folders</em>'.
     * @see org.talend.process.model.process.ResourceContainer#getResourceFolders()
     * @see #getResourceContainer()
     * @generated
     */
    EReference getResourceContainer_ResourceFolders();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.ResourceContainer#getHtmlTemplate <em>Html Template</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Html Template</em>'.
     * @see org.talend.process.model.process.ResourceContainer#getHtmlTemplate()
     * @see #getResourceContainer()
     * @generated
     */
    EReference getResourceContainer_HtmlTemplate();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.ResourceContainer#getResourceFiles <em>Resource Files</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Resource Files</em>'.
     * @see org.talend.process.model.process.ResourceContainer#getResourceFiles()
     * @see #getResourceContainer()
     * @generated
     */
    EReference getResourceContainer_ResourceFiles();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.process.model.process.ResourceContainer#getResourceJars <em>Resource Jars</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Resource Jars</em>'.
     * @see org.talend.process.model.process.ResourceContainer#getResourceJars()
     * @see #getResourceContainer()
     * @generated
     */
    EAttribute getResourceContainer_ResourceJars();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.process.model.process.ResourceContainer#getResourceValidators <em>Resource Validators</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Resource Validators</em>'.
     * @see org.talend.process.model.process.ResourceContainer#getResourceValidators()
     * @see #getResourceContainer()
     * @generated
     */
    EAttribute getResourceContainer_ResourceValidators();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.AssociatedFile <em>Associated File</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Associated File</em>'.
     * @see org.talend.process.model.process.AssociatedFile
     * @generated
     */
    EClass getAssociatedFile();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.AssociatedFile#getPath <em>Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Path</em>'.
     * @see org.talend.process.model.process.AssociatedFile#getPath()
     * @see #getAssociatedFile()
     * @generated
     */
    EAttribute getAssociatedFile_Path();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.AssociatedFile#getWarPath <em>War Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>War Path</em>'.
     * @see org.talend.process.model.process.AssociatedFile#getWarPath()
     * @see #getAssociatedFile()
     * @generated
     */
    EAttribute getAssociatedFile_WarPath();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.ResourceFile <em>Resource File</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Resource File</em>'.
     * @see org.talend.process.model.process.ResourceFile
     * @generated
     */
    EClass getResourceFile();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.ResourceFolder <em>Resource Folder</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Resource Folder</em>'.
     * @see org.talend.process.model.process.ResourceFolder
     * @generated
     */
    EClass getResourceFolder();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.ResourceFolder#getResourceFiles <em>Resource Files</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Resource Files</em>'.
     * @see org.talend.process.model.process.ResourceFolder#getResourceFiles()
     * @see #getResourceFolder()
     * @generated
     */
    EReference getResourceFolder_ResourceFiles();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Deadline <em>Deadline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Deadline</em>'.
     * @see org.talend.process.model.process.Deadline
     * @generated
     */
    EClass getDeadline();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Deadline#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Condition</em>'.
     * @see org.talend.process.model.process.Deadline#getCondition()
     * @see #getDeadline()
     * @generated
     */
    EAttribute getDeadline_Condition();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.Deadline#getConnector <em>Connector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Connector</em>'.
     * @see org.talend.process.model.process.Deadline#getConnector()
     * @see #getDeadline()
     * @generated
     */
    EReference getDeadline_Connector();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.MultiInstantiation <em>Multi Instantiation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Multi Instantiation</em>'.
     * @see org.talend.process.model.process.MultiInstantiation
     * @generated
     */
    EClass getMultiInstantiation();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.MultiInstantiation#isEnabled <em>Enabled</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enabled</em>'.
     * @see org.talend.process.model.process.MultiInstantiation#isEnabled()
     * @see #getMultiInstantiation()
     * @generated
     */
    EAttribute getMultiInstantiation_Enabled();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.MultiInstantiation#getActivityData <em>Activity Data</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Activity Data</em>'.
     * @see org.talend.process.model.process.MultiInstantiation#getActivityData()
     * @see #getMultiInstantiation()
     * @generated
     */
    EReference getMultiInstantiation_ActivityData();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.MultiInstantiation#getInstantiator <em>Instantiator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Instantiator</em>'.
     * @see org.talend.process.model.process.MultiInstantiation#getInstantiator()
     * @see #getMultiInstantiation()
     * @generated
     */
    EReference getMultiInstantiation_Instantiator();

    /**
     * Returns the meta object for the containment reference '{@link org.talend.process.model.process.MultiInstantiation#getJoinChecker <em>Join Checker</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Join Checker</em>'.
     * @see org.talend.process.model.process.MultiInstantiation#getJoinChecker()
     * @see #getMultiInstantiation()
     * @generated
     */
    EReference getMultiInstantiation_JoinChecker();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.InputMapping <em>Input Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Input Mapping</em>'.
     * @see org.talend.process.model.process.InputMapping
     * @generated
     */
    EClass getInputMapping();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.InputMapping#getProcessSource <em>Process Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Process Source</em>'.
     * @see org.talend.process.model.process.InputMapping#getProcessSource()
     * @see #getInputMapping()
     * @generated
     */
    EReference getInputMapping_ProcessSource();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.InputMapping#getSubprocessTarget <em>Subprocess Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Subprocess Target</em>'.
     * @see org.talend.process.model.process.InputMapping#getSubprocessTarget()
     * @see #getInputMapping()
     * @generated
     */
    EAttribute getInputMapping_SubprocessTarget();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.MessageEvent <em>Message Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Message Event</em>'.
     * @see org.talend.process.model.process.MessageEvent
     * @generated
     */
    EClass getMessageEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.StartMessageEvent <em>Start Message Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Start Message Event</em>'.
     * @see org.talend.process.model.process.StartMessageEvent
     * @generated
     */
    EClass getStartMessageEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.EndMessageEvent <em>End Message Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>End Message Event</em>'.
     * @see org.talend.process.model.process.EndMessageEvent
     * @generated
     */
    EClass getEndMessageEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.CatchMessageEvent <em>Catch Message Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Catch Message Event</em>'.
     * @see org.talend.process.model.process.CatchMessageEvent
     * @generated
     */
    EClass getCatchMessageEvent();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.CatchMessageEvent#getEvent <em>Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Event</em>'.
     * @see org.talend.process.model.process.CatchMessageEvent#getEvent()
     * @see #getCatchMessageEvent()
     * @generated
     */
    EAttribute getCatchMessageEvent_Event();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.CatchMessageEvent#getIncomingMessag <em>Incoming Messag</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Incoming Messag</em>'.
     * @see org.talend.process.model.process.CatchMessageEvent#getIncomingMessag()
     * @see #getCatchMessageEvent()
     * @generated
     */
    EReference getCatchMessageEvent_IncomingMessag();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.CatchMessageEvent#getMatcher <em>Matcher</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Matcher</em>'.
     * @see org.talend.process.model.process.CatchMessageEvent#getMatcher()
     * @see #getCatchMessageEvent()
     * @generated
     */
    EAttribute getCatchMessageEvent_Matcher();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.ThrowMessageEvent <em>Throw Message Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Throw Message Event</em>'.
     * @see org.talend.process.model.process.ThrowMessageEvent
     * @generated
     */
    EClass getThrowMessageEvent();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.ThrowMessageEvent#getEvents <em>Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Events</em>'.
     * @see org.talend.process.model.process.ThrowMessageEvent#getEvents()
     * @see #getThrowMessageEvent()
     * @generated
     */
    EReference getThrowMessageEvent_Events();

    /**
     * Returns the meta object for the reference list '{@link org.talend.process.model.process.ThrowMessageEvent#getOutgoingMessages <em>Outgoing Messages</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Outgoing Messages</em>'.
     * @see org.talend.process.model.process.ThrowMessageEvent#getOutgoingMessages()
     * @see #getThrowMessageEvent()
     * @generated
     */
    EReference getThrowMessageEvent_OutgoingMessages();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.IntermediateCatchMessageEvent <em>Intermediate Catch Message Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Intermediate Catch Message Event</em>'.
     * @see org.talend.process.model.process.IntermediateCatchMessageEvent
     * @generated
     */
    EClass getIntermediateCatchMessageEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.IntermediateThrowMessageEvent <em>Intermediate Throw Message Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Intermediate Throw Message Event</em>'.
     * @see org.talend.process.model.process.IntermediateThrowMessageEvent
     * @generated
     */
    EClass getIntermediateThrowMessageEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.TextAnnotation <em>Text Annotation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text Annotation</em>'.
     * @see org.talend.process.model.process.TextAnnotation
     * @generated
     */
    EClass getTextAnnotation();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.TextAnnotation#getText <em>Text</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text</em>'.
     * @see org.talend.process.model.process.TextAnnotation#getText()
     * @see #getTextAnnotation()
     * @generated
     */
    EAttribute getTextAnnotation_Text();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.TextAnnotationAttachment <em>Text Annotation Attachment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text Annotation Attachment</em>'.
     * @see org.talend.process.model.process.TextAnnotationAttachment
     * @generated
     */
    EClass getTextAnnotationAttachment();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.TextAnnotationAttachment#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see org.talend.process.model.process.TextAnnotationAttachment#getSource()
     * @see #getTextAnnotationAttachment()
     * @generated
     */
    EReference getTextAnnotationAttachment_Source();

    /**
     * Returns the meta object for the container reference '{@link org.talend.process.model.process.TextAnnotationAttachment#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Target</em>'.
     * @see org.talend.process.model.process.TextAnnotationAttachment#getTarget()
     * @see #getTextAnnotationAttachment()
     * @generated
     */
    EReference getTextAnnotationAttachment_Target();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.EventObject <em>Event Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Object</em>'.
     * @see org.talend.process.model.process.EventObject
     * @generated
     */
    EClass getEventObject();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.EventObject#getThrowEvent <em>Throw Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Throw Event</em>'.
     * @see org.talend.process.model.process.EventObject#getThrowEvent()
     * @see #getEventObject()
     * @generated
     */
    EAttribute getEventObject_ThrowEvent();

    /**
     * Returns the meta object for the container reference '{@link org.talend.process.model.process.EventObject#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Source</em>'.
     * @see org.talend.process.model.process.EventObject#getSource()
     * @see #getEventObject()
     * @generated
     */
    EReference getEventObject_Source();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.EventObject#getTtl <em>Ttl</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ttl</em>'.
     * @see org.talend.process.model.process.EventObject#getTtl()
     * @see #getEventObject()
     * @generated
     */
    EAttribute getEventObject_Ttl();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.EventObject#getTargetProcessName <em>Target Process Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Target Process Name</em>'.
     * @see org.talend.process.model.process.EventObject#getTargetProcessName()
     * @see #getEventObject()
     * @generated
     */
    EAttribute getEventObject_TargetProcessName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.EventObject#getTargetElementName <em>Target Element Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Target Element Name</em>'.
     * @see org.talend.process.model.process.EventObject#getTargetElementName()
     * @see #getEventObject()
     * @generated
     */
    EAttribute getEventObject_TargetElementName();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.TimerEvent <em>Timer Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Timer Event</em>'.
     * @see org.talend.process.model.process.TimerEvent
     * @generated
     */
    EClass getTimerEvent();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.TimerEvent#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Condition</em>'.
     * @see org.talend.process.model.process.TimerEvent#getCondition()
     * @see #getTimerEvent()
     * @generated
     */
    EAttribute getTimerEvent_Condition();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.StartTimerEvent <em>Start Timer Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Start Timer Event</em>'.
     * @see org.talend.process.model.process.StartTimerEvent
     * @generated
     */
    EClass getStartTimerEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.IntermediateCatchTimerEvent <em>Intermediate Catch Timer Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Intermediate Catch Timer Event</em>'.
     * @see org.talend.process.model.process.IntermediateCatchTimerEvent
     * @generated
     */
    EClass getIntermediateCatchTimerEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.CatchLinkEvent <em>Catch Link Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Catch Link Event</em>'.
     * @see org.talend.process.model.process.CatchLinkEvent
     * @generated
     */
    EClass getCatchLinkEvent();

    /**
     * Returns the meta object for the reference list '{@link org.talend.process.model.process.CatchLinkEvent#getFrom <em>From</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>From</em>'.
     * @see org.talend.process.model.process.CatchLinkEvent#getFrom()
     * @see #getCatchLinkEvent()
     * @generated
     */
    EReference getCatchLinkEvent_From();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.ThrowLinkEvent <em>Throw Link Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Throw Link Event</em>'.
     * @see org.talend.process.model.process.ThrowLinkEvent
     * @generated
     */
    EClass getThrowLinkEvent();

    /**
     * Returns the meta object for the reference '{@link org.talend.process.model.process.ThrowLinkEvent#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>To</em>'.
     * @see org.talend.process.model.process.ThrowLinkEvent#getTo()
     * @see #getThrowLinkEvent()
     * @generated
     */
    EReference getThrowLinkEvent_To();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.LinkEvent <em>Link Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Link Event</em>'.
     * @see org.talend.process.model.process.LinkEvent
     * @generated
     */
    EClass getLinkEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.SignalEvent <em>Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Signal Event</em>'.
     * @see org.talend.process.model.process.SignalEvent
     * @generated
     */
    EClass getSignalEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.ThrowSignalEvent <em>Throw Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Throw Signal Event</em>'.
     * @see org.talend.process.model.process.ThrowSignalEvent
     * @generated
     */
    EClass getThrowSignalEvent();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.ThrowSignalEvent#getEvents <em>Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Events</em>'.
     * @see org.talend.process.model.process.ThrowSignalEvent#getEvents()
     * @see #getThrowSignalEvent()
     * @generated
     */
    EReference getThrowSignalEvent_Events();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.CatchSignalEvent <em>Catch Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Catch Signal Event</em>'.
     * @see org.talend.process.model.process.CatchSignalEvent
     * @generated
     */
    EClass getCatchSignalEvent();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.CatchSignalEvent#getSignal <em>Signal</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Signal</em>'.
     * @see org.talend.process.model.process.CatchSignalEvent#getSignal()
     * @see #getCatchSignalEvent()
     * @generated
     */
    EAttribute getCatchSignalEvent_Signal();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.CatchSignalEvent#getMatcher <em>Matcher</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Matcher</em>'.
     * @see org.talend.process.model.process.CatchSignalEvent#getMatcher()
     * @see #getCatchSignalEvent()
     * @generated
     */
    EAttribute getCatchSignalEvent_Matcher();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.EndSignalEvent <em>End Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>End Signal Event</em>'.
     * @see org.talend.process.model.process.EndSignalEvent
     * @generated
     */
    EClass getEndSignalEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.IntermediateThrowSignalEvent <em>Intermediate Throw Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Intermediate Throw Signal Event</em>'.
     * @see org.talend.process.model.process.IntermediateThrowSignalEvent
     * @generated
     */
    EClass getIntermediateThrowSignalEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.IntermediateCatchSignalEvent <em>Intermediate Catch Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Intermediate Catch Signal Event</em>'.
     * @see org.talend.process.model.process.IntermediateCatchSignalEvent
     * @generated
     */
    EClass getIntermediateCatchSignalEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.StartSignalEvent <em>Start Signal Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Start Signal Event</em>'.
     * @see org.talend.process.model.process.StartSignalEvent
     * @generated
     */
    EClass getStartSignalEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.Assignable <em>Assignable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Assignable</em>'.
     * @see org.talend.process.model.process.Assignable
     * @generated
     */
    EClass getAssignable();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Assignable#getUser <em>User</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>User</em>'.
     * @see org.talend.process.model.process.Assignable#getUser()
     * @see #getAssignable()
     * @generated
     */
    EAttribute getAssignable_User();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.Assignable#getFilters <em>Filters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Filters</em>'.
     * @see org.talend.process.model.process.Assignable#getFilters()
     * @see #getAssignable()
     * @generated
     */
    EReference getAssignable_Filters();

    /**
     * Returns the meta object for the reference list '{@link org.talend.process.model.process.Assignable#getGroups <em>Groups</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Groups</em>'.
     * @see org.talend.process.model.process.Assignable#getGroups()
     * @see #getAssignable()
     * @generated
     */
    EReference getAssignable_Groups();

    /**
     * Returns the meta object for the attribute '{@link org.talend.process.model.process.Assignable#getActorType <em>Actor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Actor Type</em>'.
     * @see org.talend.process.model.process.Assignable#getActorType()
     * @see #getAssignable()
     * @generated
     */
    EAttribute getAssignable_ActorType();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.RecapFlow <em>Recap Flow</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Recap Flow</em>'.
     * @see org.talend.process.model.process.RecapFlow
     * @generated
     */
    EClass getRecapFlow();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.process.model.process.RecapFlow#getRecapForms <em>Recap Forms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Recap Forms</em>'.
     * @see org.talend.process.model.process.RecapFlow#getRecapForms()
     * @see #getRecapFlow()
     * @generated
     */
    EReference getRecapFlow_RecapForms();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.BoundaryEvent <em>Boundary Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Boundary Event</em>'.
     * @see org.talend.process.model.process.BoundaryEvent
     * @generated
     */
    EClass getBoundaryEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.IntermediateErrorCatchEvent <em>Intermediate Error Catch Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Intermediate Error Catch Event</em>'.
     * @see org.talend.process.model.process.IntermediateErrorCatchEvent
     * @generated
     */
    EClass getIntermediateErrorCatchEvent();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.SourceElement <em>Source Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Source Element</em>'.
     * @see org.talend.process.model.process.SourceElement
     * @generated
     */
    EClass getSourceElement();

    /**
     * Returns the meta object for the reference list '{@link org.talend.process.model.process.SourceElement#getOutgoing <em>Outgoing</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Outgoing</em>'.
     * @see org.talend.process.model.process.SourceElement#getOutgoing()
     * @see #getSourceElement()
     * @generated
     */
    EReference getSourceElement_Outgoing();

    /**
     * Returns the meta object for class '{@link org.talend.process.model.process.TargetElement <em>Target Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Target Element</em>'.
     * @see org.talend.process.model.process.TargetElement
     * @generated
     */
    EClass getTargetElement();

    /**
     * Returns the meta object for the reference list '{@link org.talend.process.model.process.TargetElement#getIncoming <em>Incoming</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Incoming</em>'.
     * @see org.talend.process.model.process.TargetElement#getIncoming()
     * @see #getTargetElement()
     * @generated
     */
    EReference getTargetElement_Incoming();

    /**
     * Returns the meta object for enum '{@link org.talend.process.model.process.GatewayType <em>Gateway Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Gateway Type</em>'.
     * @see org.talend.process.model.process.GatewayType
     * @generated
     */
    EEnum getGatewayType();

    /**
     * Returns the meta object for enum '{@link org.talend.process.model.process.ActorType <em>Actor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Actor Type</em>'.
     * @see org.talend.process.model.process.ActorType
     * @generated
     */
    EEnum getActorType();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ProcessFactory getProcessFactory();

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
         * The meta object literal for the '{@link org.talend.process.model.process.Element <em>Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.Element
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getElement()
         * @generated
         */
        EClass ELEMENT = eINSTANCE.getElement();

        /**
         * The meta object literal for the '<em><b>Documentation</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ELEMENT__DOCUMENTATION = eINSTANCE.getElement_Documentation();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ELEMENT__LABEL = eINSTANCE.getElement_Label();

        /**
         * The meta object literal for the '<em><b>Text Annotation Attachment</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ELEMENT__TEXT_ANNOTATION_ATTACHMENT = eINSTANCE.getElement_TextAnnotationAttachment();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.AbstractProcessImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAbstractProcess()
         * @generated
         */
        EClass ABSTRACT_PROCESS = eINSTANCE.getAbstractProcess();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_PROCESS__VERSION = eINSTANCE.getAbstractProcess_Version();

        /**
         * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_PROCESS__AUTHOR = eINSTANCE.getAbstractProcess_Author();

        /**
         * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_PROCESS__CREATION_DATE = eINSTANCE.getAbstractProcess_CreationDate();

        /**
         * The meta object literal for the '<em><b>Modification Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_PROCESS__MODIFICATION_DATE = eINSTANCE.getAbstractProcess_ModificationDate();

        /**
         * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_PROCESS__GROUPS = eINSTANCE.getAbstractProcess_Groups();

        /**
         * The meta object literal for the '<em><b>Datatypes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_PROCESS__DATATYPES = eINSTANCE.getAbstractProcess_Datatypes();

        /**
         * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_PROCESS__CONNECTIONS = eINSTANCE.getAbstractProcess_Connections();

        /**
         * The meta object literal for the '<em><b>Mandatory Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_PROCESS__MANDATORY_SYMBOL = eINSTANCE.getAbstractProcess_MandatorySymbol();

        /**
         * The meta object literal for the '<em><b>Mandatory Classes</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_PROCESS__MANDATORY_CLASSES = eINSTANCE.getAbstractProcess_MandatoryClasses();

        /**
         * The meta object literal for the '<em><b>Mandatory Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_PROCESS__MANDATORY_LABEL = eINSTANCE.getAbstractProcess_MandatoryLabel();

        /**
         * The meta object literal for the '<em><b>Error Template</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_PROCESS__ERROR_TEMPLATE = eINSTANCE.getAbstractProcess_ErrorTemplate();

        /**
         * The meta object literal for the '<em><b>Process Template</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_PROCESS__PROCESS_TEMPLATE = eINSTANCE.getAbstractProcess_ProcessTemplate();

        /**
         * The meta object literal for the '<em><b>Page Template</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_PROCESS__PAGE_TEMPLATE = eINSTANCE.getAbstractProcess_PageTemplate();

        /**
         * The meta object literal for the '<em><b>Consultation Template</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_PROCESS__CONSULTATION_TEMPLATE = eINSTANCE.getAbstractProcess_ConsultationTemplate();

        /**
         * The meta object literal for the '<em><b>Log In Page</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_PROCESS__LOG_IN_PAGE = eINSTANCE.getAbstractProcess_LogInPage();

        /**
         * The meta object literal for the '<em><b>Welcome Page</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_PROCESS__WELCOME_PAGE = eINSTANCE.getAbstractProcess_WelcomePage();

        /**
         * The meta object literal for the '<em><b>Welcome Page Internal</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_PROCESS__WELCOME_PAGE_INTERNAL = eINSTANCE.getAbstractProcess_WelcomePageInternal();

        /**
         * The meta object literal for the '<em><b>Categories</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_PROCESS__CATEGORIES = eINSTANCE.getAbstractProcess_Categories();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.MainProcessImpl <em>Main Process</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.MainProcessImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getMainProcess()
         * @generated
         */
        EClass MAIN_PROCESS = eINSTANCE.getMainProcess();

        /**
         * The meta object literal for the '<em><b>Bonita Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MAIN_PROCESS__BONITA_VERSION = eINSTANCE.getMainProcess_BonitaVersion();

        /**
         * The meta object literal for the '<em><b>Bonita Model Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MAIN_PROCESS__BONITA_MODEL_VERSION = eINSTANCE.getMainProcess_BonitaModelVersion();

        /**
         * The meta object literal for the '<em><b>Included Entries</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MAIN_PROCESS__INCLUDED_ENTRIES = eINSTANCE.getMainProcess_IncludedEntries();

        /**
         * The meta object literal for the '<em><b>Message Connections</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAIN_PROCESS__MESSAGE_CONNECTIONS = eINSTANCE.getMainProcess_MessageConnections();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.TaskImpl <em>Task</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.TaskImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getTask()
         * @generated
         */
        EClass TASK = eINSTANCE.getTask();

        /**
         * The meta object literal for the '<em><b>Override Groups Of The Lane</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK__OVERRIDE_GROUPS_OF_THE_LANE = eINSTANCE.getTask_OverrideGroupsOfTheLane();

        /**
         * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK__PRIORITY = eINSTANCE.getTask_Priority();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.GatewayImpl <em>Gateway</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.GatewayImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getGateway()
         * @generated
         */
        EClass GATEWAY = eINSTANCE.getGateway();

        /**
         * The meta object literal for the '<em><b>Gateway Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GATEWAY__GATEWAY_TYPE = eINSTANCE.getGateway_GatewayType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.XORGatewayImpl <em>XOR Gateway</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.XORGatewayImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getXORGateway()
         * @generated
         */
        EClass XOR_GATEWAY = eINSTANCE.getXORGateway();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ANDGatewayImpl <em>AND Gateway</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ANDGatewayImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getANDGateway()
         * @generated
         */
        EClass AND_GATEWAY = eINSTANCE.getANDGateway();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ConnectionImpl <em>Connection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ConnectionImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getConnection()
         * @generated
         */
        EClass CONNECTION = eINSTANCE.getConnection();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION__SOURCE = eINSTANCE.getConnection_Source();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION__TARGET = eINSTANCE.getConnection_Target();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.MessageFlowImpl <em>Message Flow</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.MessageFlowImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getMessageFlow()
         * @generated
         */
        EClass MESSAGE_FLOW = eINSTANCE.getMessageFlow();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MESSAGE_FLOW__SOURCE = eINSTANCE.getMessageFlow_Source();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MESSAGE_FLOW__TARGET = eINSTANCE.getMessageFlow_Target();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.AssociationImpl <em>Association</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.AssociationImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAssociation()
         * @generated
         */
        EClass ASSOCIATION = eINSTANCE.getAssociation();

        /**
         * The meta object literal for the '<em><b>Is Directed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ASSOCIATION__IS_DIRECTED = eINSTANCE.getAssociation_IsDirected();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.SequenceFlowImpl <em>Sequence Flow</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.SequenceFlowImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getSequenceFlow()
         * @generated
         */
        EClass SEQUENCE_FLOW = eINSTANCE.getSequenceFlow();

        /**
         * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SEQUENCE_FLOW__QUANTITY = eINSTANCE.getSequenceFlow_Quantity();

        /**
         * The meta object literal for the '<em><b>Is Default</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SEQUENCE_FLOW__IS_DEFAULT = eINSTANCE.getSequenceFlow_IsDefault();

        /**
         * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SEQUENCE_FLOW__CONDITION = eINSTANCE.getSequenceFlow_Condition();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.LaneImpl <em>Lane</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.LaneImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getLane()
         * @generated
         */
        EClass LANE = eINSTANCE.getLane();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.PoolImpl <em>Pool</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.PoolImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getPool()
         * @generated
         */
        EClass POOL = eINSTANCE.getPool();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ActivityImpl <em>Activity</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ActivityImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getActivity()
         * @generated
         */
        EClass ACTIVITY = eINSTANCE.getActivity();

        /**
         * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ACTIVITY__DURATION = eINSTANCE.getActivity_Duration();

        /**
         * The meta object literal for the '<em><b>Deadlines</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ACTIVITY__DEADLINES = eINSTANCE.getActivity_Deadlines();

        /**
         * The meta object literal for the '<em><b>Multi Instantiation</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ACTIVITY__MULTI_INSTANTIATION = eINSTANCE.getActivity_MultiInstantiation();

        /**
         * The meta object literal for the '<em><b>Is Loop</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ACTIVITY__IS_LOOP = eINSTANCE.getActivity_IsLoop();

        /**
         * The meta object literal for the '<em><b>Test Before</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ACTIVITY__TEST_BEFORE = eINSTANCE.getActivity_TestBefore();

        /**
         * The meta object literal for the '<em><b>Loop Condition</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ACTIVITY__LOOP_CONDITION = eINSTANCE.getActivity_LoopCondition();

        /**
         * The meta object literal for the '<em><b>Loop Maximum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ACTIVITY__LOOP_MAXIMUM = eINSTANCE.getActivity_LoopMaximum();

        /**
         * The meta object literal for the '<em><b>Boundary Intermediate Events</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ACTIVITY__BOUNDARY_INTERMEDIATE_EVENTS = eINSTANCE.getActivity_BoundaryIntermediateEvents();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.SendTaskImpl <em>Send Task</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.SendTaskImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getSendTask()
         * @generated
         */
        EClass SEND_TASK = eINSTANCE.getSendTask();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ReceiveTaskImpl <em>Receive Task</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ReceiveTaskImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getReceiveTask()
         * @generated
         */
        EClass RECEIVE_TASK = eINSTANCE.getReceiveTask();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ScriptTaskImpl <em>Script Task</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ScriptTaskImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getScriptTask()
         * @generated
         */
        EClass SCRIPT_TASK = eINSTANCE.getScriptTask();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ServiceTaskImpl <em>Service Task</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ServiceTaskImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getServiceTask()
         * @generated
         */
        EClass SERVICE_TASK = eINSTANCE.getServiceTask();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.SubProcessImpl <em>Sub Process</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.SubProcessImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getSubProcess()
         * @generated
         */
        EClass SUB_PROCESS = eINSTANCE.getSubProcess();

        /**
         * The meta object literal for the '<em><b>Subprocess Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SUB_PROCESS__SUBPROCESS_NAME = eINSTANCE.getSubProcess_SubprocessName();

        /**
         * The meta object literal for the '<em><b>Subprocess Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SUB_PROCESS__SUBPROCESS_VERSION = eINSTANCE.getSubProcess_SubprocessVersion();

        /**
         * The meta object literal for the '<em><b>Input Mappings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SUB_PROCESS__INPUT_MAPPINGS = eINSTANCE.getSubProcess_InputMappings();

        /**
         * The meta object literal for the '<em><b>Output Mappings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SUB_PROCESS__OUTPUT_MAPPINGS = eINSTANCE.getSubProcess_OutputMappings();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.FlowElementImpl <em>Flow Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.FlowElementImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getFlowElement()
         * @generated
         */
        EClass FLOW_ELEMENT = eINSTANCE.getFlowElement();

        /**
         * The meta object literal for the '<em><b>Synchronous</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FLOW_ELEMENT__SYNCHRONOUS = eINSTANCE.getFlowElement_Synchronous();

        /**
         * The meta object literal for the '<em><b>Dynamic Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FLOW_ELEMENT__DYNAMIC_LABEL = eINSTANCE.getFlowElement_DynamicLabel();

        /**
         * The meta object literal for the '<em><b>Dynamic Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FLOW_ELEMENT__DYNAMIC_DESCRIPTION = eINSTANCE.getFlowElement_DynamicDescription();

        /**
         * The meta object literal for the '<em><b>Step Summary</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FLOW_ELEMENT__STEP_SUMMARY = eINSTANCE.getFlowElement_StepSummary();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ContainerImpl <em>Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ContainerImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getContainer()
         * @generated
         */
        EClass CONTAINER = eINSTANCE.getContainer();

        /**
         * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTAINER__ELEMENTS = eINSTANCE.getContainer_Elements();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ConnectableElementImpl <em>Connectable Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ConnectableElementImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getConnectableElement()
         * @generated
         */
        EClass CONNECTABLE_ELEMENT = eINSTANCE.getConnectableElement();

        /**
         * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTABLE_ELEMENT__CONNECTORS = eINSTANCE.getConnectableElement_Connectors();

        /**
         * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTABLE_ELEMENT__DATA = eINSTANCE.getConnectableElement_Data();

        /**
         * The meta object literal for the '<em><b>Kpis</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTABLE_ELEMENT__KPIS = eINSTANCE.getConnectableElement_Kpis();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ConnectorImpl <em>Connector</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ConnectorImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getConnector()
         * @generated
         */
        EClass CONNECTOR = eINSTANCE.getConnector();

        /**
         * The meta object literal for the '<em><b>Connector Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTOR__CONNECTOR_ID = eINSTANCE.getConnector_ConnectorId();

        /**
         * The meta object literal for the '<em><b>Configuration Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTOR__CONFIGURATION_ID = eINSTANCE.getConnector_ConfigurationId();

        /**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTOR__PARAMETERS = eINSTANCE.getConnector_Parameters();

        /**
         * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTOR__EVENT = eINSTANCE.getConnector_Event();

        /**
         * The meta object literal for the '<em><b>Ignore Errors</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTOR__IGNORE_ERRORS = eINSTANCE.getConnector_IgnoreErrors();

        /**
         * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTOR__OUTPUTS = eINSTANCE.getConnector_Outputs();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ParameterImpl <em>Parameter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ParameterImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getParameter()
         * @generated
         */
        EClass PARAMETER = eINSTANCE.getParameter();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMETER__KEY = eINSTANCE.getParameter_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMETER__VALUE = eINSTANCE.getParameter_Value();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.OutputParameterMappingImpl <em>Output Parameter Mapping</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.OutputParameterMappingImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getOutputParameterMapping()
         * @generated
         */
        EClass OUTPUT_PARAMETER_MAPPING = eINSTANCE.getOutputParameterMapping();

        /**
         * The meta object literal for the '<em><b>Value Expression</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OUTPUT_PARAMETER_MAPPING__VALUE_EXPRESSION = eINSTANCE.getOutputParameterMapping_ValueExpression();

        /**
         * The meta object literal for the '<em><b>Target Data</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OUTPUT_PARAMETER_MAPPING__TARGET_DATA = eINSTANCE.getOutputParameterMapping_TargetData();

        /**
         * The meta object literal for the '<em><b>Additional Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OUTPUT_PARAMETER_MAPPING__ADDITIONAL_PATH = eINSTANCE.getOutputParameterMapping_AdditionalPath();

        /**
         * The meta object literal for the '<em><b>Target Widget</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OUTPUT_PARAMETER_MAPPING__TARGET_WIDGET = eINSTANCE.getOutputParameterMapping_TargetWidget();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.GroupImpl <em>Group</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.GroupImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getGroup()
         * @generated
         */
        EClass GROUP = eINSTANCE.getGroup();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.DataImpl <em>Data</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.DataImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getData()
         * @generated
         */
        EClass DATA = eINSTANCE.getData();

        /**
         * The meta object literal for the '<em><b>Data Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA__DATA_TYPE = eINSTANCE.getData_DataType();

        /**
         * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA__DEFAULT_VALUE = eINSTANCE.getData_DefaultValue();

        /**
         * The meta object literal for the '<em><b>Generated</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA__GENERATED = eINSTANCE.getData_Generated();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.AttachmentDataImpl <em>Attachment Data</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.AttachmentDataImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAttachmentData()
         * @generated
         */
        EClass ATTACHMENT_DATA = eINSTANCE.getAttachmentData();

        /**
         * The meta object literal for the '<em><b>Bar Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTACHMENT_DATA__BAR_PATH = eINSTANCE.getAttachmentData_BarPath();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.JavaObjectDataImpl <em>Java Object Data</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.JavaObjectDataImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getJavaObjectData()
         * @generated
         */
        EClass JAVA_OBJECT_DATA = eINSTANCE.getJavaObjectData();

        /**
         * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JAVA_OBJECT_DATA__CLASS_NAME = eINSTANCE.getJavaObjectData_ClassName();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.XMLDataImpl <em>XML Data</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.XMLDataImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getXMLData()
         * @generated
         */
        EClass XML_DATA = eINSTANCE.getXMLData();

        /**
         * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute XML_DATA__NAMESPACE = eINSTANCE.getXMLData_Namespace();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute XML_DATA__TYPE = eINSTANCE.getXMLData_Type();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.DataTypeImpl <em>Data Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.DataTypeImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getDataType()
         * @generated
         */
        EClass DATA_TYPE = eINSTANCE.getDataType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.IntegerTypeImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntegerType()
         * @generated
         */
        EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.StringTypeImpl <em>String Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.StringTypeImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getStringType()
         * @generated
         */
        EClass STRING_TYPE = eINSTANCE.getStringType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.DateTypeImpl <em>Date Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.DateTypeImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getDateType()
         * @generated
         */
        EClass DATE_TYPE = eINSTANCE.getDateType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.FloatTypeImpl <em>Float Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.FloatTypeImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getFloatType()
         * @generated
         */
        EClass FLOAT_TYPE = eINSTANCE.getFloatType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.BooleanTypeImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getBooleanType()
         * @generated
         */
        EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.EnumTypeImpl <em>Enum Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.EnumTypeImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEnumType()
         * @generated
         */
        EClass ENUM_TYPE = eINSTANCE.getEnumType();

        /**
         * The meta object literal for the '<em><b>Literals</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ENUM_TYPE__LITERALS = eINSTANCE.getEnumType_Literals();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.JavaTypeImpl <em>Java Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.JavaTypeImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getJavaType()
         * @generated
         */
        EClass JAVA_TYPE = eINSTANCE.getJavaType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.XMLTypeImpl <em>XML Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.XMLTypeImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getXMLType()
         * @generated
         */
        EClass XML_TYPE = eINSTANCE.getXMLType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.OutputMappingImpl <em>Output Mapping</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.OutputMappingImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getOutputMapping()
         * @generated
         */
        EClass OUTPUT_MAPPING = eINSTANCE.getOutputMapping();

        /**
         * The meta object literal for the '<em><b>Subprocess Source</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OUTPUT_MAPPING__SUBPROCESS_SOURCE = eINSTANCE.getOutputMapping_SubprocessSource();

        /**
         * The meta object literal for the '<em><b>Process Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OUTPUT_MAPPING__PROCESS_TARGET = eINSTANCE.getOutputMapping_ProcessTarget();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.AttachmentTypeImpl <em>Attachment Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.AttachmentTypeImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAttachmentType()
         * @generated
         */
        EClass ATTACHMENT_TYPE = eINSTANCE.getAttachmentType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.StartEventImpl <em>Start Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.StartEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getStartEvent()
         * @generated
         */
        EClass START_EVENT = eINSTANCE.getStartEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.EndEventImpl <em>End Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.EndEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEndEvent()
         * @generated
         */
        EClass END_EVENT = eINSTANCE.getEndEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.EventImpl <em>Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.EventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEvent()
         * @generated
         */
        EClass EVENT = eINSTANCE.getEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.PageFlowImpl <em>Page Flow</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.PageFlowImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getPageFlow()
         * @generated
         */
        EClass PAGE_FLOW = eINSTANCE.getPageFlow();

        /**
         * The meta object literal for the '<em><b>Form</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PAGE_FLOW__FORM = eINSTANCE.getPageFlow_Form();

        /**
         * The meta object literal for the '<em><b>By Pass Forms Generation</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PAGE_FLOW__BY_PASS_FORMS_GENERATION = eINSTANCE.getPageFlow_ByPassFormsGeneration();

        /**
         * The meta object literal for the '<em><b>Confirmation Template</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PAGE_FLOW__CONFIRMATION_TEMPLATE = eINSTANCE.getPageFlow_ConfirmationTemplate();

        /**
         * The meta object literal for the '<em><b>Confirmation Message</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PAGE_FLOW__CONFIRMATION_MESSAGE = eINSTANCE.getPageFlow_ConfirmationMessage();

        /**
         * The meta object literal for the '<em><b>Reg Exp To Hide Default Field</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD = eINSTANCE.getPageFlow_RegExpToHideDefaultField();

        /**
         * The meta object literal for the '<em><b>Use Reg Exp To Hide Default Field</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD = eINSTANCE.getPageFlow_UseRegExpToHideDefaultField();

        /**
         * The meta object literal for the '<em><b>View Form</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PAGE_FLOW__VIEW_FORM = eINSTANCE.getPageFlow_ViewForm();

        /**
         * The meta object literal for the '<em><b>Use View Form</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PAGE_FLOW__USE_VIEW_FORM = eINSTANCE.getPageFlow_UseViewForm();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ResourceContainerImpl <em>Resource Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ResourceContainerImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getResourceContainer()
         * @generated
         */
        EClass RESOURCE_CONTAINER = eINSTANCE.getResourceContainer();

        /**
         * The meta object literal for the '<em><b>Resource Folders</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOURCE_CONTAINER__RESOURCE_FOLDERS = eINSTANCE.getResourceContainer_ResourceFolders();

        /**
         * The meta object literal for the '<em><b>Html Template</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOURCE_CONTAINER__HTML_TEMPLATE = eINSTANCE.getResourceContainer_HtmlTemplate();

        /**
         * The meta object literal for the '<em><b>Resource Files</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOURCE_CONTAINER__RESOURCE_FILES = eINSTANCE.getResourceContainer_ResourceFiles();

        /**
         * The meta object literal for the '<em><b>Resource Jars</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RESOURCE_CONTAINER__RESOURCE_JARS = eINSTANCE.getResourceContainer_ResourceJars();

        /**
         * The meta object literal for the '<em><b>Resource Validators</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RESOURCE_CONTAINER__RESOURCE_VALIDATORS = eINSTANCE.getResourceContainer_ResourceValidators();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.AssociatedFileImpl <em>Associated File</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.AssociatedFileImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAssociatedFile()
         * @generated
         */
        EClass ASSOCIATED_FILE = eINSTANCE.getAssociatedFile();

        /**
         * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ASSOCIATED_FILE__PATH = eINSTANCE.getAssociatedFile_Path();

        /**
         * The meta object literal for the '<em><b>War Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ASSOCIATED_FILE__WAR_PATH = eINSTANCE.getAssociatedFile_WarPath();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ResourceFileImpl <em>Resource File</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ResourceFileImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getResourceFile()
         * @generated
         */
        EClass RESOURCE_FILE = eINSTANCE.getResourceFile();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ResourceFolderImpl <em>Resource Folder</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ResourceFolderImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getResourceFolder()
         * @generated
         */
        EClass RESOURCE_FOLDER = eINSTANCE.getResourceFolder();

        /**
         * The meta object literal for the '<em><b>Resource Files</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOURCE_FOLDER__RESOURCE_FILES = eINSTANCE.getResourceFolder_ResourceFiles();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.DeadlineImpl <em>Deadline</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.DeadlineImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getDeadline()
         * @generated
         */
        EClass DEADLINE = eINSTANCE.getDeadline();

        /**
         * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEADLINE__CONDITION = eINSTANCE.getDeadline_Condition();

        /**
         * The meta object literal for the '<em><b>Connector</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEADLINE__CONNECTOR = eINSTANCE.getDeadline_Connector();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.MultiInstantiationImpl <em>Multi Instantiation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.MultiInstantiationImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getMultiInstantiation()
         * @generated
         */
        EClass MULTI_INSTANTIATION = eINSTANCE.getMultiInstantiation();

        /**
         * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MULTI_INSTANTIATION__ENABLED = eINSTANCE.getMultiInstantiation_Enabled();

        /**
         * The meta object literal for the '<em><b>Activity Data</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MULTI_INSTANTIATION__ACTIVITY_DATA = eINSTANCE.getMultiInstantiation_ActivityData();

        /**
         * The meta object literal for the '<em><b>Instantiator</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MULTI_INSTANTIATION__INSTANTIATOR = eINSTANCE.getMultiInstantiation_Instantiator();

        /**
         * The meta object literal for the '<em><b>Join Checker</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MULTI_INSTANTIATION__JOIN_CHECKER = eINSTANCE.getMultiInstantiation_JoinChecker();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.InputMappingImpl <em>Input Mapping</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.InputMappingImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getInputMapping()
         * @generated
         */
        EClass INPUT_MAPPING = eINSTANCE.getInputMapping();

        /**
         * The meta object literal for the '<em><b>Process Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INPUT_MAPPING__PROCESS_SOURCE = eINSTANCE.getInputMapping_ProcessSource();

        /**
         * The meta object literal for the '<em><b>Subprocess Target</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INPUT_MAPPING__SUBPROCESS_TARGET = eINSTANCE.getInputMapping_SubprocessTarget();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.MessageEventImpl <em>Message Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.MessageEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getMessageEvent()
         * @generated
         */
        EClass MESSAGE_EVENT = eINSTANCE.getMessageEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.StartMessageEventImpl <em>Start Message Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.StartMessageEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getStartMessageEvent()
         * @generated
         */
        EClass START_MESSAGE_EVENT = eINSTANCE.getStartMessageEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.EndMessageEventImpl <em>End Message Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.EndMessageEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEndMessageEvent()
         * @generated
         */
        EClass END_MESSAGE_EVENT = eINSTANCE.getEndMessageEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.CatchMessageEventImpl <em>Catch Message Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.CatchMessageEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getCatchMessageEvent()
         * @generated
         */
        EClass CATCH_MESSAGE_EVENT = eINSTANCE.getCatchMessageEvent();

        /**
         * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CATCH_MESSAGE_EVENT__EVENT = eINSTANCE.getCatchMessageEvent_Event();

        /**
         * The meta object literal for the '<em><b>Incoming Messag</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CATCH_MESSAGE_EVENT__INCOMING_MESSAG = eINSTANCE.getCatchMessageEvent_IncomingMessag();

        /**
         * The meta object literal for the '<em><b>Matcher</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CATCH_MESSAGE_EVENT__MATCHER = eINSTANCE.getCatchMessageEvent_Matcher();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ThrowMessageEventImpl <em>Throw Message Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ThrowMessageEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getThrowMessageEvent()
         * @generated
         */
        EClass THROW_MESSAGE_EVENT = eINSTANCE.getThrowMessageEvent();

        /**
         * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference THROW_MESSAGE_EVENT__EVENTS = eINSTANCE.getThrowMessageEvent_Events();

        /**
         * The meta object literal for the '<em><b>Outgoing Messages</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference THROW_MESSAGE_EVENT__OUTGOING_MESSAGES = eINSTANCE.getThrowMessageEvent_OutgoingMessages();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.IntermediateCatchMessageEventImpl <em>Intermediate Catch Message Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.IntermediateCatchMessageEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateCatchMessageEvent()
         * @generated
         */
        EClass INTERMEDIATE_CATCH_MESSAGE_EVENT = eINSTANCE.getIntermediateCatchMessageEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.IntermediateThrowMessageEventImpl <em>Intermediate Throw Message Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.IntermediateThrowMessageEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateThrowMessageEvent()
         * @generated
         */
        EClass INTERMEDIATE_THROW_MESSAGE_EVENT = eINSTANCE.getIntermediateThrowMessageEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.TextAnnotationImpl <em>Text Annotation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.TextAnnotationImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getTextAnnotation()
         * @generated
         */
        EClass TEXT_ANNOTATION = eINSTANCE.getTextAnnotation();

        /**
         * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_ANNOTATION__TEXT = eINSTANCE.getTextAnnotation_Text();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.TextAnnotationAttachmentImpl <em>Text Annotation Attachment</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.TextAnnotationAttachmentImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getTextAnnotationAttachment()
         * @generated
         */
        EClass TEXT_ANNOTATION_ATTACHMENT = eINSTANCE.getTextAnnotationAttachment();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TEXT_ANNOTATION_ATTACHMENT__SOURCE = eINSTANCE.getTextAnnotationAttachment_Source();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TEXT_ANNOTATION_ATTACHMENT__TARGET = eINSTANCE.getTextAnnotationAttachment_Target();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.EventObjectImpl <em>Event Object</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.EventObjectImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEventObject()
         * @generated
         */
        EClass EVENT_OBJECT = eINSTANCE.getEventObject();

        /**
         * The meta object literal for the '<em><b>Throw Event</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_OBJECT__THROW_EVENT = eINSTANCE.getEventObject_ThrowEvent();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EVENT_OBJECT__SOURCE = eINSTANCE.getEventObject_Source();

        /**
         * The meta object literal for the '<em><b>Ttl</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_OBJECT__TTL = eINSTANCE.getEventObject_Ttl();

        /**
         * The meta object literal for the '<em><b>Target Process Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_OBJECT__TARGET_PROCESS_NAME = eINSTANCE.getEventObject_TargetProcessName();

        /**
         * The meta object literal for the '<em><b>Target Element Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_OBJECT__TARGET_ELEMENT_NAME = eINSTANCE.getEventObject_TargetElementName();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.TimerEventImpl <em>Timer Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.TimerEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getTimerEvent()
         * @generated
         */
        EClass TIMER_EVENT = eINSTANCE.getTimerEvent();

        /**
         * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TIMER_EVENT__CONDITION = eINSTANCE.getTimerEvent_Condition();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.StartTimerEventImpl <em>Start Timer Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.StartTimerEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getStartTimerEvent()
         * @generated
         */
        EClass START_TIMER_EVENT = eINSTANCE.getStartTimerEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.IntermediateCatchTimerEventImpl <em>Intermediate Catch Timer Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.IntermediateCatchTimerEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateCatchTimerEvent()
         * @generated
         */
        EClass INTERMEDIATE_CATCH_TIMER_EVENT = eINSTANCE.getIntermediateCatchTimerEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.CatchLinkEventImpl <em>Catch Link Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.CatchLinkEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getCatchLinkEvent()
         * @generated
         */
        EClass CATCH_LINK_EVENT = eINSTANCE.getCatchLinkEvent();

        /**
         * The meta object literal for the '<em><b>From</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CATCH_LINK_EVENT__FROM = eINSTANCE.getCatchLinkEvent_From();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ThrowLinkEventImpl <em>Throw Link Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ThrowLinkEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getThrowLinkEvent()
         * @generated
         */
        EClass THROW_LINK_EVENT = eINSTANCE.getThrowLinkEvent();

        /**
         * The meta object literal for the '<em><b>To</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference THROW_LINK_EVENT__TO = eINSTANCE.getThrowLinkEvent_To();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.LinkEventImpl <em>Link Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.LinkEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getLinkEvent()
         * @generated
         */
        EClass LINK_EVENT = eINSTANCE.getLinkEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.SignalEventImpl <em>Signal Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.SignalEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getSignalEvent()
         * @generated
         */
        EClass SIGNAL_EVENT = eINSTANCE.getSignalEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.ThrowSignalEventImpl <em>Throw Signal Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.ThrowSignalEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getThrowSignalEvent()
         * @generated
         */
        EClass THROW_SIGNAL_EVENT = eINSTANCE.getThrowSignalEvent();

        /**
         * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference THROW_SIGNAL_EVENT__EVENTS = eINSTANCE.getThrowSignalEvent_Events();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.CatchSignalEventImpl <em>Catch Signal Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.CatchSignalEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getCatchSignalEvent()
         * @generated
         */
        EClass CATCH_SIGNAL_EVENT = eINSTANCE.getCatchSignalEvent();

        /**
         * The meta object literal for the '<em><b>Signal</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CATCH_SIGNAL_EVENT__SIGNAL = eINSTANCE.getCatchSignalEvent_Signal();

        /**
         * The meta object literal for the '<em><b>Matcher</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CATCH_SIGNAL_EVENT__MATCHER = eINSTANCE.getCatchSignalEvent_Matcher();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.EndSignalEventImpl <em>End Signal Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.EndSignalEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getEndSignalEvent()
         * @generated
         */
        EClass END_SIGNAL_EVENT = eINSTANCE.getEndSignalEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.IntermediateThrowSignalEventImpl <em>Intermediate Throw Signal Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.IntermediateThrowSignalEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateThrowSignalEvent()
         * @generated
         */
        EClass INTERMEDIATE_THROW_SIGNAL_EVENT = eINSTANCE.getIntermediateThrowSignalEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.IntermediateCatchSignalEventImpl <em>Intermediate Catch Signal Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.IntermediateCatchSignalEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateCatchSignalEvent()
         * @generated
         */
        EClass INTERMEDIATE_CATCH_SIGNAL_EVENT = eINSTANCE.getIntermediateCatchSignalEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.StartSignalEventImpl <em>Start Signal Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.StartSignalEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getStartSignalEvent()
         * @generated
         */
        EClass START_SIGNAL_EVENT = eINSTANCE.getStartSignalEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.Assignable <em>Assignable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.Assignable
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getAssignable()
         * @generated
         */
        EClass ASSIGNABLE = eINSTANCE.getAssignable();

        /**
         * The meta object literal for the '<em><b>User</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ASSIGNABLE__USER = eINSTANCE.getAssignable_User();

        /**
         * The meta object literal for the '<em><b>Filters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ASSIGNABLE__FILTERS = eINSTANCE.getAssignable_Filters();

        /**
         * The meta object literal for the '<em><b>Groups</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ASSIGNABLE__GROUPS = eINSTANCE.getAssignable_Groups();

        /**
         * The meta object literal for the '<em><b>Actor Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ASSIGNABLE__ACTOR_TYPE = eINSTANCE.getAssignable_ActorType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.RecapFlow <em>Recap Flow</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.RecapFlow
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getRecapFlow()
         * @generated
         */
        EClass RECAP_FLOW = eINSTANCE.getRecapFlow();

        /**
         * The meta object literal for the '<em><b>Recap Forms</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RECAP_FLOW__RECAP_FORMS = eINSTANCE.getRecapFlow_RecapForms();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.BoundaryEventImpl <em>Boundary Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.BoundaryEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getBoundaryEvent()
         * @generated
         */
        EClass BOUNDARY_EVENT = eINSTANCE.getBoundaryEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.impl.IntermediateErrorCatchEventImpl <em>Intermediate Error Catch Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.impl.IntermediateErrorCatchEventImpl
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getIntermediateErrorCatchEvent()
         * @generated
         */
        EClass INTERMEDIATE_ERROR_CATCH_EVENT = eINSTANCE.getIntermediateErrorCatchEvent();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.SourceElement <em>Source Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.SourceElement
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getSourceElement()
         * @generated
         */
        EClass SOURCE_ELEMENT = eINSTANCE.getSourceElement();

        /**
         * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SOURCE_ELEMENT__OUTGOING = eINSTANCE.getSourceElement_Outgoing();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.TargetElement <em>Target Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.TargetElement
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getTargetElement()
         * @generated
         */
        EClass TARGET_ELEMENT = eINSTANCE.getTargetElement();

        /**
         * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TARGET_ELEMENT__INCOMING = eINSTANCE.getTargetElement_Incoming();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.GatewayType <em>Gateway Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.GatewayType
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getGatewayType()
         * @generated
         */
        EEnum GATEWAY_TYPE = eINSTANCE.getGatewayType();

        /**
         * The meta object literal for the '{@link org.talend.process.model.process.ActorType <em>Actor Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.process.model.process.ActorType
         * @see org.talend.process.model.process.impl.ProcessPackageImpl#getActorType()
         * @generated
         */
        EEnum ACTOR_TYPE = eINSTANCE.getActorType();

    }

} //ProcessPackage
