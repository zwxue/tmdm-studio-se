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
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.process.model.form.Form;
import org.talend.process.model.form.ViewForm;

import org.talend.process.model.kpi.AbstractKPIBinding;

import org.talend.process.model.process.AbstractProcess;
import org.talend.process.model.process.AssociatedFile;
import org.talend.process.model.process.ConnectableElement;
import org.talend.process.model.process.Connection;
import org.talend.process.model.process.Connector;
import org.talend.process.model.process.Data;
import org.talend.process.model.process.DataType;
import org.talend.process.model.process.Group;
import org.talend.process.model.process.PageFlow;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.RecapFlow;
import org.talend.process.model.process.ResourceContainer;
import org.talend.process.model.process.ResourceFile;
import org.talend.process.model.process.ResourceFolder;

import org.talend.process.model.simulation.SimulationAbstractProcess;
import org.talend.process.model.simulation.SimulationData;
import org.talend.process.model.simulation.SimulationDataContainer;
import org.talend.process.model.simulation.SimulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getResourceFolders <em>Resource Folders</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getHtmlTemplate <em>Html Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getResourceFiles <em>Resource Files</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getResourceJars <em>Resource Jars</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getResourceValidators <em>Resource Validators</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getKpis <em>Kpis</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getForm <em>Form</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getByPassFormsGeneration <em>By Pass Forms Generation</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getConfirmationTemplate <em>Confirmation Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getConfirmationMessage <em>Confirmation Message</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getRegExpToHideDefaultField <em>Reg Exp To Hide Default Field</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#isUseRegExpToHideDefaultField <em>Use Reg Exp To Hide Default Field</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getViewForm <em>View Form</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#isUseViewForm <em>Use View Form</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getSimulationData <em>Simulation Data</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getLoadProfileID <em>Load Profile ID</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getRecapForms <em>Recap Forms</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getModificationDate <em>Modification Date</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getDatatypes <em>Datatypes</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getMandatorySymbol <em>Mandatory Symbol</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getMandatoryClasses <em>Mandatory Classes</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getMandatoryLabel <em>Mandatory Label</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getErrorTemplate <em>Error Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getProcessTemplate <em>Process Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getPageTemplate <em>Page Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getConsultationTemplate <em>Consultation Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getLogInPage <em>Log In Page</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getWelcomePage <em>Welcome Page</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getWelcomePageInternal <em>Welcome Page Internal</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.AbstractProcessImpl#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractProcessImpl extends ContainerImpl implements AbstractProcess {
    /**
     * The cached value of the '{@link #getResourceFolders() <em>Resource Folders</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResourceFolders()
     * @generated
     * @ordered
     */
    protected EList<ResourceFolder> resourceFolders;

    /**
     * The cached value of the '{@link #getHtmlTemplate() <em>Html Template</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHtmlTemplate()
     * @generated
     * @ordered
     */
    protected AssociatedFile htmlTemplate;

    /**
     * The cached value of the '{@link #getResourceFiles() <em>Resource Files</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResourceFiles()
     * @generated
     * @ordered
     */
    protected EList<ResourceFile> resourceFiles;

    /**
     * The cached value of the '{@link #getResourceJars() <em>Resource Jars</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResourceJars()
     * @generated
     * @ordered
     */
    protected EList<String> resourceJars;

    /**
     * The cached value of the '{@link #getResourceValidators() <em>Resource Validators</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResourceValidators()
     * @generated
     * @ordered
     */
    protected EList<String> resourceValidators;

    /**
     * The cached value of the '{@link #getConnectors() <em>Connectors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnectors()
     * @generated
     * @ordered
     */
    protected EList<Connector> connectors;

    /**
     * The cached value of the '{@link #getData() <em>Data</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getData()
     * @generated
     * @ordered
     */
    protected EList<Data> data;

    /**
     * The cached value of the '{@link #getKpis() <em>Kpis</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKpis()
     * @generated
     * @ordered
     */
    protected EList<AbstractKPIBinding> kpis;

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
     * The cached value of the '{@link #getSimulationData() <em>Simulation Data</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSimulationData()
     * @generated
     * @ordered
     */
    protected EList<SimulationData> simulationData;

    /**
     * The default value of the '{@link #getLoadProfileID() <em>Load Profile ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLoadProfileID()
     * @generated
     * @ordered
     */
    protected static final String LOAD_PROFILE_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLoadProfileID() <em>Load Profile ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLoadProfileID()
     * @generated
     * @ordered
     */
    protected String loadProfileID = LOAD_PROFILE_ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getRecapForms() <em>Recap Forms</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRecapForms()
     * @generated
     * @ordered
     */
    protected EList<ViewForm> recapForms;

    /**
     * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected static final String VERSION_EDEFAULT = "1.0"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected String version = VERSION_EDEFAULT;

    /**
     * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthor()
     * @generated
     * @ordered
     */
    protected static final String AUTHOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthor()
     * @generated
     * @ordered
     */
    protected String author = AUTHOR_EDEFAULT;

    /**
     * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected static final Date CREATION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected Date creationDate = CREATION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getModificationDate() <em>Modification Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModificationDate()
     * @generated
     * @ordered
     */
    protected static final Date MODIFICATION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getModificationDate() <em>Modification Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModificationDate()
     * @generated
     * @ordered
     */
    protected Date modificationDate = MODIFICATION_DATE_EDEFAULT;

    /**
     * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGroups()
     * @generated
     * @ordered
     */
    protected EList<Group> groups;

    /**
     * The cached value of the '{@link #getDatatypes() <em>Datatypes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatatypes()
     * @generated
     * @ordered
     */
    protected EList<DataType> datatypes;

    /**
     * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnections()
     * @generated
     * @ordered
     */
    protected EList<Connection> connections;

    /**
     * The default value of the '{@link #getMandatorySymbol() <em>Mandatory Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMandatorySymbol()
     * @generated
     * @ordered
     */
    protected static final String MANDATORY_SYMBOL_EDEFAULT = "*"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getMandatorySymbol() <em>Mandatory Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMandatorySymbol()
     * @generated
     * @ordered
     */
    protected String mandatorySymbol = MANDATORY_SYMBOL_EDEFAULT;

    /**
     * The default value of the '{@link #getMandatoryClasses() <em>Mandatory Classes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMandatoryClasses()
     * @generated
     * @ordered
     */
    protected static final String MANDATORY_CLASSES_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMandatoryClasses() <em>Mandatory Classes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMandatoryClasses()
     * @generated
     * @ordered
     */
    protected String mandatoryClasses = MANDATORY_CLASSES_EDEFAULT;

    /**
     * The default value of the '{@link #getMandatoryLabel() <em>Mandatory Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMandatoryLabel()
     * @generated
     * @ordered
     */
    protected static final String MANDATORY_LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMandatoryLabel() <em>Mandatory Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMandatoryLabel()
     * @generated
     * @ordered
     */
    protected String mandatoryLabel = MANDATORY_LABEL_EDEFAULT;

    /**
     * The cached value of the '{@link #getErrorTemplate() <em>Error Template</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getErrorTemplate()
     * @generated
     * @ordered
     */
    protected AssociatedFile errorTemplate;

    /**
     * The cached value of the '{@link #getProcessTemplate() <em>Process Template</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProcessTemplate()
     * @generated
     * @ordered
     */
    protected AssociatedFile processTemplate;

    /**
     * The cached value of the '{@link #getPageTemplate() <em>Page Template</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPageTemplate()
     * @generated
     * @ordered
     */
    protected AssociatedFile pageTemplate;

    /**
     * The cached value of the '{@link #getConsultationTemplate() <em>Consultation Template</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConsultationTemplate()
     * @generated
     * @ordered
     */
    protected AssociatedFile consultationTemplate;

    /**
     * The cached value of the '{@link #getLogInPage() <em>Log In Page</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLogInPage()
     * @generated
     * @ordered
     */
    protected AssociatedFile logInPage;

    /**
     * The cached value of the '{@link #getWelcomePage() <em>Welcome Page</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWelcomePage()
     * @generated
     * @ordered
     */
    protected AssociatedFile welcomePage;

    /**
     * The default value of the '{@link #getWelcomePageInternal() <em>Welcome Page Internal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWelcomePageInternal()
     * @generated
     * @ordered
     */
    protected static final Boolean WELCOME_PAGE_INTERNAL_EDEFAULT = Boolean.TRUE;

    /**
     * The cached value of the '{@link #getWelcomePageInternal() <em>Welcome Page Internal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWelcomePageInternal()
     * @generated
     * @ordered
     */
    protected Boolean welcomePageInternal = WELCOME_PAGE_INTERNAL_EDEFAULT;

    /**
     * The cached value of the '{@link #getCategories() <em>Categories</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCategories()
     * @generated
     * @ordered
     */
    protected EList<String> categories;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractProcessImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.ABSTRACT_PROCESS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ResourceFolder> getResourceFolders() {
        if (resourceFolders == null) {
            resourceFolders = new EObjectContainmentEList<ResourceFolder>(ResourceFolder.class, this, ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FOLDERS);
        }
        return resourceFolders;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssociatedFile getHtmlTemplate() {
        return htmlTemplate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetHtmlTemplate(AssociatedFile newHtmlTemplate, NotificationChain msgs) {
        AssociatedFile oldHtmlTemplate = htmlTemplate;
        htmlTemplate = newHtmlTemplate;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__HTML_TEMPLATE, oldHtmlTemplate, newHtmlTemplate);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHtmlTemplate(AssociatedFile newHtmlTemplate) {
        if (newHtmlTemplate != htmlTemplate) {
            NotificationChain msgs = null;
            if (htmlTemplate != null)
                msgs = ((InternalEObject)htmlTemplate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__HTML_TEMPLATE, null, msgs);
            if (newHtmlTemplate != null)
                msgs = ((InternalEObject)newHtmlTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__HTML_TEMPLATE, null, msgs);
            msgs = basicSetHtmlTemplate(newHtmlTemplate, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__HTML_TEMPLATE, newHtmlTemplate, newHtmlTemplate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ResourceFile> getResourceFiles() {
        if (resourceFiles == null) {
            resourceFiles = new EObjectContainmentEList<ResourceFile>(ResourceFile.class, this, ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FILES);
        }
        return resourceFiles;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getResourceJars() {
        if (resourceJars == null) {
            resourceJars = new EDataTypeUniqueEList<String>(String.class, this, ProcessPackage.ABSTRACT_PROCESS__RESOURCE_JARS);
        }
        return resourceJars;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getResourceValidators() {
        if (resourceValidators == null) {
            resourceValidators = new EDataTypeUniqueEList<String>(String.class, this, ProcessPackage.ABSTRACT_PROCESS__RESOURCE_VALIDATORS);
        }
        return resourceValidators;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getConnectors() {
        if (connectors == null) {
            connectors = new EObjectContainmentEList<Connector>(Connector.class, this, ProcessPackage.ABSTRACT_PROCESS__CONNECTORS);
        }
        return connectors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Data> getData() {
        if (data == null) {
            data = new EObjectContainmentEList<Data>(Data.class, this, ProcessPackage.ABSTRACT_PROCESS__DATA);
        }
        return data;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<AbstractKPIBinding> getKpis() {
        if (kpis == null) {
            kpis = new EObjectContainmentEList<AbstractKPIBinding>(AbstractKPIBinding.class, this, ProcessPackage.ABSTRACT_PROCESS__KPIS);
        }
        return kpis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Form> getForm() {
        if (form == null) {
            form = new EObjectContainmentEList<Form>(Form.class, this, ProcessPackage.ABSTRACT_PROCESS__FORM);
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__BY_PASS_FORMS_GENERATION, oldByPassFormsGeneration, byPassFormsGeneration));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE, oldConfirmationTemplate, newConfirmationTemplate);
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
                msgs = ((InternalEObject)confirmationTemplate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE, null, msgs);
            if (newConfirmationTemplate != null)
                msgs = ((InternalEObject)newConfirmationTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE, null, msgs);
            msgs = basicSetConfirmationTemplate(newConfirmationTemplate, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE, newConfirmationTemplate, newConfirmationTemplate));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_MESSAGE, oldConfirmationMessage, confirmationMessage));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__REG_EXP_TO_HIDE_DEFAULT_FIELD, oldRegExpToHideDefaultField, regExpToHideDefaultField));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD, oldUseRegExpToHideDefaultField, useRegExpToHideDefaultField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ViewForm> getViewForm() {
        if (viewForm == null) {
            viewForm = new EObjectContainmentEList<ViewForm>(ViewForm.class, this, ProcessPackage.ABSTRACT_PROCESS__VIEW_FORM);
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__USE_VIEW_FORM, oldUseViewForm, useViewForm));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<SimulationData> getSimulationData() {
        if (simulationData == null) {
            simulationData = new EObjectContainmentEList<SimulationData>(SimulationData.class, this, ProcessPackage.ABSTRACT_PROCESS__SIMULATION_DATA);
        }
        return simulationData;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLoadProfileID() {
        return loadProfileID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLoadProfileID(String newLoadProfileID) {
        String oldLoadProfileID = loadProfileID;
        loadProfileID = newLoadProfileID;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__LOAD_PROFILE_ID, oldLoadProfileID, loadProfileID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ViewForm> getRecapForms() {
        if (recapForms == null) {
            recapForms = new EObjectContainmentEList<ViewForm>(ViewForm.class, this, ProcessPackage.ABSTRACT_PROCESS__RECAP_FORMS);
        }
        return recapForms;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getVersion() {
        return version;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVersion(String newVersion) {
        String oldVersion = version;
        version = newVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__VERSION, oldVersion, version));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAuthor(String newAuthor) {
        String oldAuthor = author;
        author = newAuthor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__AUTHOR, oldAuthor, author));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCreationDate(Date newCreationDate) {
        Date oldCreationDate = creationDate;
        creationDate = newCreationDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__CREATION_DATE, oldCreationDate, creationDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setModificationDate(Date newModificationDate) {
        Date oldModificationDate = modificationDate;
        modificationDate = newModificationDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__MODIFICATION_DATE, oldModificationDate, modificationDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Group> getGroups() {
        if (groups == null) {
            groups = new EObjectContainmentEList<Group>(Group.class, this, ProcessPackage.ABSTRACT_PROCESS__GROUPS);
        }
        return groups;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DataType> getDatatypes() {
        if (datatypes == null) {
            datatypes = new EObjectContainmentEList<DataType>(DataType.class, this, ProcessPackage.ABSTRACT_PROCESS__DATATYPES);
        }
        return datatypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connection> getConnections() {
        if (connections == null) {
            connections = new EObjectContainmentEList<Connection>(Connection.class, this, ProcessPackage.ABSTRACT_PROCESS__CONNECTIONS);
        }
        return connections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMandatorySymbol() {
        return mandatorySymbol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMandatorySymbol(String newMandatorySymbol) {
        String oldMandatorySymbol = mandatorySymbol;
        mandatorySymbol = newMandatorySymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__MANDATORY_SYMBOL, oldMandatorySymbol, mandatorySymbol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMandatoryClasses() {
        return mandatoryClasses;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMandatoryClasses(String newMandatoryClasses) {
        String oldMandatoryClasses = mandatoryClasses;
        mandatoryClasses = newMandatoryClasses;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__MANDATORY_CLASSES, oldMandatoryClasses, mandatoryClasses));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMandatoryLabel() {
        return mandatoryLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMandatoryLabel(String newMandatoryLabel) {
        String oldMandatoryLabel = mandatoryLabel;
        mandatoryLabel = newMandatoryLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__MANDATORY_LABEL, oldMandatoryLabel, mandatoryLabel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssociatedFile getErrorTemplate() {
        return errorTemplate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetErrorTemplate(AssociatedFile newErrorTemplate, NotificationChain msgs) {
        AssociatedFile oldErrorTemplate = errorTemplate;
        errorTemplate = newErrorTemplate;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__ERROR_TEMPLATE, oldErrorTemplate, newErrorTemplate);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setErrorTemplate(AssociatedFile newErrorTemplate) {
        if (newErrorTemplate != errorTemplate) {
            NotificationChain msgs = null;
            if (errorTemplate != null)
                msgs = ((InternalEObject)errorTemplate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__ERROR_TEMPLATE, null, msgs);
            if (newErrorTemplate != null)
                msgs = ((InternalEObject)newErrorTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__ERROR_TEMPLATE, null, msgs);
            msgs = basicSetErrorTemplate(newErrorTemplate, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__ERROR_TEMPLATE, newErrorTemplate, newErrorTemplate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssociatedFile getProcessTemplate() {
        return processTemplate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProcessTemplate(AssociatedFile newProcessTemplate, NotificationChain msgs) {
        AssociatedFile oldProcessTemplate = processTemplate;
        processTemplate = newProcessTemplate;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__PROCESS_TEMPLATE, oldProcessTemplate, newProcessTemplate);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProcessTemplate(AssociatedFile newProcessTemplate) {
        if (newProcessTemplate != processTemplate) {
            NotificationChain msgs = null;
            if (processTemplate != null)
                msgs = ((InternalEObject)processTemplate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__PROCESS_TEMPLATE, null, msgs);
            if (newProcessTemplate != null)
                msgs = ((InternalEObject)newProcessTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__PROCESS_TEMPLATE, null, msgs);
            msgs = basicSetProcessTemplate(newProcessTemplate, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__PROCESS_TEMPLATE, newProcessTemplate, newProcessTemplate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssociatedFile getPageTemplate() {
        return pageTemplate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPageTemplate(AssociatedFile newPageTemplate, NotificationChain msgs) {
        AssociatedFile oldPageTemplate = pageTemplate;
        pageTemplate = newPageTemplate;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__PAGE_TEMPLATE, oldPageTemplate, newPageTemplate);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPageTemplate(AssociatedFile newPageTemplate) {
        if (newPageTemplate != pageTemplate) {
            NotificationChain msgs = null;
            if (pageTemplate != null)
                msgs = ((InternalEObject)pageTemplate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__PAGE_TEMPLATE, null, msgs);
            if (newPageTemplate != null)
                msgs = ((InternalEObject)newPageTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__PAGE_TEMPLATE, null, msgs);
            msgs = basicSetPageTemplate(newPageTemplate, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__PAGE_TEMPLATE, newPageTemplate, newPageTemplate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssociatedFile getConsultationTemplate() {
        return consultationTemplate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetConsultationTemplate(AssociatedFile newConsultationTemplate, NotificationChain msgs) {
        AssociatedFile oldConsultationTemplate = consultationTemplate;
        consultationTemplate = newConsultationTemplate;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__CONSULTATION_TEMPLATE, oldConsultationTemplate, newConsultationTemplate);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConsultationTemplate(AssociatedFile newConsultationTemplate) {
        if (newConsultationTemplate != consultationTemplate) {
            NotificationChain msgs = null;
            if (consultationTemplate != null)
                msgs = ((InternalEObject)consultationTemplate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__CONSULTATION_TEMPLATE, null, msgs);
            if (newConsultationTemplate != null)
                msgs = ((InternalEObject)newConsultationTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__CONSULTATION_TEMPLATE, null, msgs);
            msgs = basicSetConsultationTemplate(newConsultationTemplate, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__CONSULTATION_TEMPLATE, newConsultationTemplate, newConsultationTemplate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssociatedFile getLogInPage() {
        return logInPage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLogInPage(AssociatedFile newLogInPage, NotificationChain msgs) {
        AssociatedFile oldLogInPage = logInPage;
        logInPage = newLogInPage;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__LOG_IN_PAGE, oldLogInPage, newLogInPage);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLogInPage(AssociatedFile newLogInPage) {
        if (newLogInPage != logInPage) {
            NotificationChain msgs = null;
            if (logInPage != null)
                msgs = ((InternalEObject)logInPage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__LOG_IN_PAGE, null, msgs);
            if (newLogInPage != null)
                msgs = ((InternalEObject)newLogInPage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__LOG_IN_PAGE, null, msgs);
            msgs = basicSetLogInPage(newLogInPage, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__LOG_IN_PAGE, newLogInPage, newLogInPage));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssociatedFile getWelcomePage() {
        return welcomePage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetWelcomePage(AssociatedFile newWelcomePage, NotificationChain msgs) {
        AssociatedFile oldWelcomePage = welcomePage;
        welcomePage = newWelcomePage;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE, oldWelcomePage, newWelcomePage);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWelcomePage(AssociatedFile newWelcomePage) {
        if (newWelcomePage != welcomePage) {
            NotificationChain msgs = null;
            if (welcomePage != null)
                msgs = ((InternalEObject)welcomePage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE, null, msgs);
            if (newWelcomePage != null)
                msgs = ((InternalEObject)newWelcomePage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE, null, msgs);
            msgs = basicSetWelcomePage(newWelcomePage, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE, newWelcomePage, newWelcomePage));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getWelcomePageInternal() {
        return welcomePageInternal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWelcomePageInternal(Boolean newWelcomePageInternal) {
        Boolean oldWelcomePageInternal = welcomePageInternal;
        welcomePageInternal = newWelcomePageInternal;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE_INTERNAL, oldWelcomePageInternal, welcomePageInternal));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getCategories() {
        if (categories == null) {
            categories = new EDataTypeUniqueEList<String>(String.class, this, ProcessPackage.ABSTRACT_PROCESS__CATEGORIES);
        }
        return categories;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FOLDERS:
                return ((InternalEList<?>)getResourceFolders()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__HTML_TEMPLATE:
                return basicSetHtmlTemplate(null, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FILES:
                return ((InternalEList<?>)getResourceFiles()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__CONNECTORS:
                return ((InternalEList<?>)getConnectors()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__DATA:
                return ((InternalEList<?>)getData()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__KPIS:
                return ((InternalEList<?>)getKpis()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__FORM:
                return ((InternalEList<?>)getForm()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE:
                return basicSetConfirmationTemplate(null, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__VIEW_FORM:
                return ((InternalEList<?>)getViewForm()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__SIMULATION_DATA:
                return ((InternalEList<?>)getSimulationData()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__RECAP_FORMS:
                return ((InternalEList<?>)getRecapForms()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__GROUPS:
                return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__DATATYPES:
                return ((InternalEList<?>)getDatatypes()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__CONNECTIONS:
                return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__ERROR_TEMPLATE:
                return basicSetErrorTemplate(null, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__PROCESS_TEMPLATE:
                return basicSetProcessTemplate(null, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__PAGE_TEMPLATE:
                return basicSetPageTemplate(null, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__CONSULTATION_TEMPLATE:
                return basicSetConsultationTemplate(null, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__LOG_IN_PAGE:
                return basicSetLogInPage(null, msgs);
            case ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE:
                return basicSetWelcomePage(null, msgs);
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
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FOLDERS:
                return getResourceFolders();
            case ProcessPackage.ABSTRACT_PROCESS__HTML_TEMPLATE:
                return getHtmlTemplate();
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FILES:
                return getResourceFiles();
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_JARS:
                return getResourceJars();
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_VALIDATORS:
                return getResourceValidators();
            case ProcessPackage.ABSTRACT_PROCESS__CONNECTORS:
                return getConnectors();
            case ProcessPackage.ABSTRACT_PROCESS__DATA:
                return getData();
            case ProcessPackage.ABSTRACT_PROCESS__KPIS:
                return getKpis();
            case ProcessPackage.ABSTRACT_PROCESS__FORM:
                return getForm();
            case ProcessPackage.ABSTRACT_PROCESS__BY_PASS_FORMS_GENERATION:
                return getByPassFormsGeneration();
            case ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE:
                return getConfirmationTemplate();
            case ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_MESSAGE:
                return getConfirmationMessage();
            case ProcessPackage.ABSTRACT_PROCESS__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return getRegExpToHideDefaultField();
            case ProcessPackage.ABSTRACT_PROCESS__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return isUseRegExpToHideDefaultField();
            case ProcessPackage.ABSTRACT_PROCESS__VIEW_FORM:
                return getViewForm();
            case ProcessPackage.ABSTRACT_PROCESS__USE_VIEW_FORM:
                return isUseViewForm();
            case ProcessPackage.ABSTRACT_PROCESS__SIMULATION_DATA:
                return getSimulationData();
            case ProcessPackage.ABSTRACT_PROCESS__LOAD_PROFILE_ID:
                return getLoadProfileID();
            case ProcessPackage.ABSTRACT_PROCESS__RECAP_FORMS:
                return getRecapForms();
            case ProcessPackage.ABSTRACT_PROCESS__VERSION:
                return getVersion();
            case ProcessPackage.ABSTRACT_PROCESS__AUTHOR:
                return getAuthor();
            case ProcessPackage.ABSTRACT_PROCESS__CREATION_DATE:
                return getCreationDate();
            case ProcessPackage.ABSTRACT_PROCESS__MODIFICATION_DATE:
                return getModificationDate();
            case ProcessPackage.ABSTRACT_PROCESS__GROUPS:
                return getGroups();
            case ProcessPackage.ABSTRACT_PROCESS__DATATYPES:
                return getDatatypes();
            case ProcessPackage.ABSTRACT_PROCESS__CONNECTIONS:
                return getConnections();
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_SYMBOL:
                return getMandatorySymbol();
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_CLASSES:
                return getMandatoryClasses();
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_LABEL:
                return getMandatoryLabel();
            case ProcessPackage.ABSTRACT_PROCESS__ERROR_TEMPLATE:
                return getErrorTemplate();
            case ProcessPackage.ABSTRACT_PROCESS__PROCESS_TEMPLATE:
                return getProcessTemplate();
            case ProcessPackage.ABSTRACT_PROCESS__PAGE_TEMPLATE:
                return getPageTemplate();
            case ProcessPackage.ABSTRACT_PROCESS__CONSULTATION_TEMPLATE:
                return getConsultationTemplate();
            case ProcessPackage.ABSTRACT_PROCESS__LOG_IN_PAGE:
                return getLogInPage();
            case ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE:
                return getWelcomePage();
            case ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE_INTERNAL:
                return getWelcomePageInternal();
            case ProcessPackage.ABSTRACT_PROCESS__CATEGORIES:
                return getCategories();
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
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FOLDERS:
                getResourceFolders().clear();
                getResourceFolders().addAll((Collection<? extends ResourceFolder>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__HTML_TEMPLATE:
                setHtmlTemplate((AssociatedFile)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FILES:
                getResourceFiles().clear();
                getResourceFiles().addAll((Collection<? extends ResourceFile>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_JARS:
                getResourceJars().clear();
                getResourceJars().addAll((Collection<? extends String>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_VALIDATORS:
                getResourceValidators().clear();
                getResourceValidators().addAll((Collection<? extends String>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CONNECTORS:
                getConnectors().clear();
                getConnectors().addAll((Collection<? extends Connector>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__DATA:
                getData().clear();
                getData().addAll((Collection<? extends Data>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__KPIS:
                getKpis().clear();
                getKpis().addAll((Collection<? extends AbstractKPIBinding>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__FORM:
                getForm().clear();
                getForm().addAll((Collection<? extends Form>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__BY_PASS_FORMS_GENERATION:
                setByPassFormsGeneration((Boolean)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE:
                setConfirmationTemplate((AssociatedFile)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_MESSAGE:
                setConfirmationMessage((String)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setRegExpToHideDefaultField((String)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setUseRegExpToHideDefaultField((Boolean)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__VIEW_FORM:
                getViewForm().clear();
                getViewForm().addAll((Collection<? extends ViewForm>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__USE_VIEW_FORM:
                setUseViewForm((Boolean)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__SIMULATION_DATA:
                getSimulationData().clear();
                getSimulationData().addAll((Collection<? extends SimulationData>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__LOAD_PROFILE_ID:
                setLoadProfileID((String)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__RECAP_FORMS:
                getRecapForms().clear();
                getRecapForms().addAll((Collection<? extends ViewForm>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__VERSION:
                setVersion((String)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__AUTHOR:
                setAuthor((String)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CREATION_DATE:
                setCreationDate((Date)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__MODIFICATION_DATE:
                setModificationDate((Date)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__GROUPS:
                getGroups().clear();
                getGroups().addAll((Collection<? extends Group>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__DATATYPES:
                getDatatypes().clear();
                getDatatypes().addAll((Collection<? extends DataType>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CONNECTIONS:
                getConnections().clear();
                getConnections().addAll((Collection<? extends Connection>)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_SYMBOL:
                setMandatorySymbol((String)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_CLASSES:
                setMandatoryClasses((String)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_LABEL:
                setMandatoryLabel((String)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__ERROR_TEMPLATE:
                setErrorTemplate((AssociatedFile)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__PROCESS_TEMPLATE:
                setProcessTemplate((AssociatedFile)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__PAGE_TEMPLATE:
                setPageTemplate((AssociatedFile)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CONSULTATION_TEMPLATE:
                setConsultationTemplate((AssociatedFile)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__LOG_IN_PAGE:
                setLogInPage((AssociatedFile)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE:
                setWelcomePage((AssociatedFile)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE_INTERNAL:
                setWelcomePageInternal((Boolean)newValue);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CATEGORIES:
                getCategories().clear();
                getCategories().addAll((Collection<? extends String>)newValue);
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
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FOLDERS:
                getResourceFolders().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__HTML_TEMPLATE:
                setHtmlTemplate((AssociatedFile)null);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FILES:
                getResourceFiles().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_JARS:
                getResourceJars().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_VALIDATORS:
                getResourceValidators().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CONNECTORS:
                getConnectors().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__DATA:
                getData().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__KPIS:
                getKpis().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__FORM:
                getForm().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__BY_PASS_FORMS_GENERATION:
                setByPassFormsGeneration(BY_PASS_FORMS_GENERATION_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE:
                setConfirmationTemplate((AssociatedFile)null);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_MESSAGE:
                setConfirmationMessage(CONFIRMATION_MESSAGE_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setRegExpToHideDefaultField(REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setUseRegExpToHideDefaultField(USE_REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__VIEW_FORM:
                getViewForm().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__USE_VIEW_FORM:
                setUseViewForm(USE_VIEW_FORM_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__SIMULATION_DATA:
                getSimulationData().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__LOAD_PROFILE_ID:
                setLoadProfileID(LOAD_PROFILE_ID_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__RECAP_FORMS:
                getRecapForms().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__VERSION:
                setVersion(VERSION_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__AUTHOR:
                setAuthor(AUTHOR_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CREATION_DATE:
                setCreationDate(CREATION_DATE_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__MODIFICATION_DATE:
                setModificationDate(MODIFICATION_DATE_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__GROUPS:
                getGroups().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__DATATYPES:
                getDatatypes().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CONNECTIONS:
                getConnections().clear();
                return;
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_SYMBOL:
                setMandatorySymbol(MANDATORY_SYMBOL_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_CLASSES:
                setMandatoryClasses(MANDATORY_CLASSES_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_LABEL:
                setMandatoryLabel(MANDATORY_LABEL_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__ERROR_TEMPLATE:
                setErrorTemplate((AssociatedFile)null);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__PROCESS_TEMPLATE:
                setProcessTemplate((AssociatedFile)null);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__PAGE_TEMPLATE:
                setPageTemplate((AssociatedFile)null);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CONSULTATION_TEMPLATE:
                setConsultationTemplate((AssociatedFile)null);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__LOG_IN_PAGE:
                setLogInPage((AssociatedFile)null);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE:
                setWelcomePage((AssociatedFile)null);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE_INTERNAL:
                setWelcomePageInternal(WELCOME_PAGE_INTERNAL_EDEFAULT);
                return;
            case ProcessPackage.ABSTRACT_PROCESS__CATEGORIES:
                getCategories().clear();
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
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FOLDERS:
                return resourceFolders != null && !resourceFolders.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__HTML_TEMPLATE:
                return htmlTemplate != null;
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FILES:
                return resourceFiles != null && !resourceFiles.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_JARS:
                return resourceJars != null && !resourceJars.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_VALIDATORS:
                return resourceValidators != null && !resourceValidators.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__CONNECTORS:
                return connectors != null && !connectors.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__DATA:
                return data != null && !data.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__KPIS:
                return kpis != null && !kpis.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__FORM:
                return form != null && !form.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__BY_PASS_FORMS_GENERATION:
                return BY_PASS_FORMS_GENERATION_EDEFAULT == null ? byPassFormsGeneration != null : !BY_PASS_FORMS_GENERATION_EDEFAULT.equals(byPassFormsGeneration);
            case ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE:
                return confirmationTemplate != null;
            case ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_MESSAGE:
                return CONFIRMATION_MESSAGE_EDEFAULT == null ? confirmationMessage != null : !CONFIRMATION_MESSAGE_EDEFAULT.equals(confirmationMessage);
            case ProcessPackage.ABSTRACT_PROCESS__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT == null ? regExpToHideDefaultField != null : !REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT.equals(regExpToHideDefaultField);
            case ProcessPackage.ABSTRACT_PROCESS__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return useRegExpToHideDefaultField != USE_REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT;
            case ProcessPackage.ABSTRACT_PROCESS__VIEW_FORM:
                return viewForm != null && !viewForm.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__USE_VIEW_FORM:
                return useViewForm != USE_VIEW_FORM_EDEFAULT;
            case ProcessPackage.ABSTRACT_PROCESS__SIMULATION_DATA:
                return simulationData != null && !simulationData.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__LOAD_PROFILE_ID:
                return LOAD_PROFILE_ID_EDEFAULT == null ? loadProfileID != null : !LOAD_PROFILE_ID_EDEFAULT.equals(loadProfileID);
            case ProcessPackage.ABSTRACT_PROCESS__RECAP_FORMS:
                return recapForms != null && !recapForms.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__VERSION:
                return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
            case ProcessPackage.ABSTRACT_PROCESS__AUTHOR:
                return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
            case ProcessPackage.ABSTRACT_PROCESS__CREATION_DATE:
                return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
            case ProcessPackage.ABSTRACT_PROCESS__MODIFICATION_DATE:
                return MODIFICATION_DATE_EDEFAULT == null ? modificationDate != null : !MODIFICATION_DATE_EDEFAULT.equals(modificationDate);
            case ProcessPackage.ABSTRACT_PROCESS__GROUPS:
                return groups != null && !groups.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__DATATYPES:
                return datatypes != null && !datatypes.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__CONNECTIONS:
                return connections != null && !connections.isEmpty();
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_SYMBOL:
                return MANDATORY_SYMBOL_EDEFAULT == null ? mandatorySymbol != null : !MANDATORY_SYMBOL_EDEFAULT.equals(mandatorySymbol);
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_CLASSES:
                return MANDATORY_CLASSES_EDEFAULT == null ? mandatoryClasses != null : !MANDATORY_CLASSES_EDEFAULT.equals(mandatoryClasses);
            case ProcessPackage.ABSTRACT_PROCESS__MANDATORY_LABEL:
                return MANDATORY_LABEL_EDEFAULT == null ? mandatoryLabel != null : !MANDATORY_LABEL_EDEFAULT.equals(mandatoryLabel);
            case ProcessPackage.ABSTRACT_PROCESS__ERROR_TEMPLATE:
                return errorTemplate != null;
            case ProcessPackage.ABSTRACT_PROCESS__PROCESS_TEMPLATE:
                return processTemplate != null;
            case ProcessPackage.ABSTRACT_PROCESS__PAGE_TEMPLATE:
                return pageTemplate != null;
            case ProcessPackage.ABSTRACT_PROCESS__CONSULTATION_TEMPLATE:
                return consultationTemplate != null;
            case ProcessPackage.ABSTRACT_PROCESS__LOG_IN_PAGE:
                return logInPage != null;
            case ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE:
                return welcomePage != null;
            case ProcessPackage.ABSTRACT_PROCESS__WELCOME_PAGE_INTERNAL:
                return WELCOME_PAGE_INTERNAL_EDEFAULT == null ? welcomePageInternal != null : !WELCOME_PAGE_INTERNAL_EDEFAULT.equals(welcomePageInternal);
            case ProcessPackage.ABSTRACT_PROCESS__CATEGORIES:
                return categories != null && !categories.isEmpty();
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
        if (baseClass == ResourceContainer.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FOLDERS: return ProcessPackage.RESOURCE_CONTAINER__RESOURCE_FOLDERS;
                case ProcessPackage.ABSTRACT_PROCESS__HTML_TEMPLATE: return ProcessPackage.RESOURCE_CONTAINER__HTML_TEMPLATE;
                case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FILES: return ProcessPackage.RESOURCE_CONTAINER__RESOURCE_FILES;
                case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_JARS: return ProcessPackage.RESOURCE_CONTAINER__RESOURCE_JARS;
                case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_VALIDATORS: return ProcessPackage.RESOURCE_CONTAINER__RESOURCE_VALIDATORS;
                default: return -1;
            }
        }
        if (baseClass == ConnectableElement.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.ABSTRACT_PROCESS__CONNECTORS: return ProcessPackage.CONNECTABLE_ELEMENT__CONNECTORS;
                case ProcessPackage.ABSTRACT_PROCESS__DATA: return ProcessPackage.CONNECTABLE_ELEMENT__DATA;
                case ProcessPackage.ABSTRACT_PROCESS__KPIS: return ProcessPackage.CONNECTABLE_ELEMENT__KPIS;
                default: return -1;
            }
        }
        if (baseClass == PageFlow.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.ABSTRACT_PROCESS__FORM: return ProcessPackage.PAGE_FLOW__FORM;
                case ProcessPackage.ABSTRACT_PROCESS__BY_PASS_FORMS_GENERATION: return ProcessPackage.PAGE_FLOW__BY_PASS_FORMS_GENERATION;
                case ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE: return ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE;
                case ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_MESSAGE: return ProcessPackage.PAGE_FLOW__CONFIRMATION_MESSAGE;
                case ProcessPackage.ABSTRACT_PROCESS__REG_EXP_TO_HIDE_DEFAULT_FIELD: return ProcessPackage.PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD;
                case ProcessPackage.ABSTRACT_PROCESS__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD: return ProcessPackage.PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD;
                case ProcessPackage.ABSTRACT_PROCESS__VIEW_FORM: return ProcessPackage.PAGE_FLOW__VIEW_FORM;
                case ProcessPackage.ABSTRACT_PROCESS__USE_VIEW_FORM: return ProcessPackage.PAGE_FLOW__USE_VIEW_FORM;
                default: return -1;
            }
        }
        if (baseClass == SimulationDataContainer.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.ABSTRACT_PROCESS__SIMULATION_DATA: return SimulationPackage.SIMULATION_DATA_CONTAINER__SIMULATION_DATA;
                default: return -1;
            }
        }
        if (baseClass == SimulationAbstractProcess.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.ABSTRACT_PROCESS__LOAD_PROFILE_ID: return SimulationPackage.SIMULATION_ABSTRACT_PROCESS__LOAD_PROFILE_ID;
                default: return -1;
            }
        }
        if (baseClass == RecapFlow.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.ABSTRACT_PROCESS__RECAP_FORMS: return ProcessPackage.RECAP_FLOW__RECAP_FORMS;
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
        if (baseClass == ResourceContainer.class) {
            switch (baseFeatureID) {
                case ProcessPackage.RESOURCE_CONTAINER__RESOURCE_FOLDERS: return ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FOLDERS;
                case ProcessPackage.RESOURCE_CONTAINER__HTML_TEMPLATE: return ProcessPackage.ABSTRACT_PROCESS__HTML_TEMPLATE;
                case ProcessPackage.RESOURCE_CONTAINER__RESOURCE_FILES: return ProcessPackage.ABSTRACT_PROCESS__RESOURCE_FILES;
                case ProcessPackage.RESOURCE_CONTAINER__RESOURCE_JARS: return ProcessPackage.ABSTRACT_PROCESS__RESOURCE_JARS;
                case ProcessPackage.RESOURCE_CONTAINER__RESOURCE_VALIDATORS: return ProcessPackage.ABSTRACT_PROCESS__RESOURCE_VALIDATORS;
                default: return -1;
            }
        }
        if (baseClass == ConnectableElement.class) {
            switch (baseFeatureID) {
                case ProcessPackage.CONNECTABLE_ELEMENT__CONNECTORS: return ProcessPackage.ABSTRACT_PROCESS__CONNECTORS;
                case ProcessPackage.CONNECTABLE_ELEMENT__DATA: return ProcessPackage.ABSTRACT_PROCESS__DATA;
                case ProcessPackage.CONNECTABLE_ELEMENT__KPIS: return ProcessPackage.ABSTRACT_PROCESS__KPIS;
                default: return -1;
            }
        }
        if (baseClass == PageFlow.class) {
            switch (baseFeatureID) {
                case ProcessPackage.PAGE_FLOW__FORM: return ProcessPackage.ABSTRACT_PROCESS__FORM;
                case ProcessPackage.PAGE_FLOW__BY_PASS_FORMS_GENERATION: return ProcessPackage.ABSTRACT_PROCESS__BY_PASS_FORMS_GENERATION;
                case ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE: return ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_TEMPLATE;
                case ProcessPackage.PAGE_FLOW__CONFIRMATION_MESSAGE: return ProcessPackage.ABSTRACT_PROCESS__CONFIRMATION_MESSAGE;
                case ProcessPackage.PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD: return ProcessPackage.ABSTRACT_PROCESS__REG_EXP_TO_HIDE_DEFAULT_FIELD;
                case ProcessPackage.PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD: return ProcessPackage.ABSTRACT_PROCESS__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD;
                case ProcessPackage.PAGE_FLOW__VIEW_FORM: return ProcessPackage.ABSTRACT_PROCESS__VIEW_FORM;
                case ProcessPackage.PAGE_FLOW__USE_VIEW_FORM: return ProcessPackage.ABSTRACT_PROCESS__USE_VIEW_FORM;
                default: return -1;
            }
        }
        if (baseClass == SimulationDataContainer.class) {
            switch (baseFeatureID) {
                case SimulationPackage.SIMULATION_DATA_CONTAINER__SIMULATION_DATA: return ProcessPackage.ABSTRACT_PROCESS__SIMULATION_DATA;
                default: return -1;
            }
        }
        if (baseClass == SimulationAbstractProcess.class) {
            switch (baseFeatureID) {
                case SimulationPackage.SIMULATION_ABSTRACT_PROCESS__LOAD_PROFILE_ID: return ProcessPackage.ABSTRACT_PROCESS__LOAD_PROFILE_ID;
                default: return -1;
            }
        }
        if (baseClass == RecapFlow.class) {
            switch (baseFeatureID) {
                case ProcessPackage.RECAP_FLOW__RECAP_FORMS: return ProcessPackage.ABSTRACT_PROCESS__RECAP_FORMS;
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
        result.append(" (resourceJars: "); //$NON-NLS-1$
        result.append(resourceJars);
        result.append(", resourceValidators: "); //$NON-NLS-1$
        result.append(resourceValidators);
        result.append(", byPassFormsGeneration: "); //$NON-NLS-1$
        result.append(byPassFormsGeneration);
        result.append(", confirmationMessage: "); //$NON-NLS-1$
        result.append(confirmationMessage);
        result.append(", regExpToHideDefaultField: "); //$NON-NLS-1$
        result.append(regExpToHideDefaultField);
        result.append(", useRegExpToHideDefaultField: "); //$NON-NLS-1$
        result.append(useRegExpToHideDefaultField);
        result.append(", useViewForm: "); //$NON-NLS-1$
        result.append(useViewForm);
        result.append(", loadProfileID: "); //$NON-NLS-1$
        result.append(loadProfileID);
        result.append(", version: "); //$NON-NLS-1$
        result.append(version);
        result.append(", author: "); //$NON-NLS-1$
        result.append(author);
        result.append(", creationDate: "); //$NON-NLS-1$
        result.append(creationDate);
        result.append(", modificationDate: "); //$NON-NLS-1$
        result.append(modificationDate);
        result.append(", mandatorySymbol: "); //$NON-NLS-1$
        result.append(mandatorySymbol);
        result.append(", mandatoryClasses: "); //$NON-NLS-1$
        result.append(mandatoryClasses);
        result.append(", mandatoryLabel: "); //$NON-NLS-1$
        result.append(mandatoryLabel);
        result.append(", welcomePageInternal: "); //$NON-NLS-1$
        result.append(welcomePageInternal);
        result.append(", categories: "); //$NON-NLS-1$
        result.append(categories);
        result.append(')');
        return result.toString();
    }

} //AbstractProcessImpl
