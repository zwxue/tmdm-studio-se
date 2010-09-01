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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.process.model.form.Form;
import org.talend.process.model.form.ViewForm;

import org.talend.process.model.process.ActorType;
import org.talend.process.model.process.Assignable;
import org.talend.process.model.process.AssociatedFile;
import org.talend.process.model.process.Connector;
import org.talend.process.model.process.Group;
import org.talend.process.model.process.PageFlow;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.ResourceContainer;
import org.talend.process.model.process.ResourceFile;
import org.talend.process.model.process.ResourceFolder;
import org.talend.process.model.process.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getForm <em>Form</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getByPassFormsGeneration <em>By Pass Forms Generation</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getConfirmationTemplate <em>Confirmation Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getConfirmationMessage <em>Confirmation Message</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getRegExpToHideDefaultField <em>Reg Exp To Hide Default Field</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#isUseRegExpToHideDefaultField <em>Use Reg Exp To Hide Default Field</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getViewForm <em>View Form</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#isUseViewForm <em>Use View Form</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getResourceFolders <em>Resource Folders</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getHtmlTemplate <em>Html Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getResourceFiles <em>Resource Files</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getResourceJars <em>Resource Jars</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getResourceValidators <em>Resource Validators</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getFilters <em>Filters</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getActorType <em>Actor Type</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#isOverrideGroupsOfTheLane <em>Override Groups Of The Lane</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.TaskImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends ActivityImpl implements Task {
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
     * The default value of the '{@link #getUser() <em>User</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUser()
     * @generated
     * @ordered
     */
    protected static final String USER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUser() <em>User</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUser()
     * @generated
     * @ordered
     */
    protected String user = USER_EDEFAULT;

    /**
     * The cached value of the '{@link #getFilters() <em>Filters</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilters()
     * @generated
     * @ordered
     */
    protected EList<Connector> filters;

    /**
     * The cached value of the '{@link #getGroups() <em>Groups</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGroups()
     * @generated
     * @ordered
     */
    protected EList<Group> groups;

    /**
     * The default value of the '{@link #getActorType() <em>Actor Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getActorType()
     * @generated
     * @ordered
     */
    protected static final ActorType ACTOR_TYPE_EDEFAULT = ActorType.GROUP;

    /**
     * The cached value of the '{@link #getActorType() <em>Actor Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getActorType()
     * @generated
     * @ordered
     */
    protected ActorType actorType = ACTOR_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #isOverrideGroupsOfTheLane() <em>Override Groups Of The Lane</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isOverrideGroupsOfTheLane()
     * @generated
     * @ordered
     */
    protected static final boolean OVERRIDE_GROUPS_OF_THE_LANE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isOverrideGroupsOfTheLane() <em>Override Groups Of The Lane</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isOverrideGroupsOfTheLane()
     * @generated
     * @ordered
     */
    protected boolean overrideGroupsOfTheLane = OVERRIDE_GROUPS_OF_THE_LANE_EDEFAULT;

    /**
     * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPriority()
     * @generated
     * @ordered
     */
    protected static final int PRIORITY_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPriority()
     * @generated
     * @ordered
     */
    protected int priority = PRIORITY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TaskImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.TASK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Form> getForm() {
        if (form == null) {
            form = new EObjectContainmentEList<Form>(Form.class, this, ProcessPackage.TASK__FORM);
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__BY_PASS_FORMS_GENERATION, oldByPassFormsGeneration, byPassFormsGeneration));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__CONFIRMATION_TEMPLATE, oldConfirmationTemplate, newConfirmationTemplate);
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
                msgs = ((InternalEObject)confirmationTemplate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TASK__CONFIRMATION_TEMPLATE, null, msgs);
            if (newConfirmationTemplate != null)
                msgs = ((InternalEObject)newConfirmationTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TASK__CONFIRMATION_TEMPLATE, null, msgs);
            msgs = basicSetConfirmationTemplate(newConfirmationTemplate, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__CONFIRMATION_TEMPLATE, newConfirmationTemplate, newConfirmationTemplate));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__CONFIRMATION_MESSAGE, oldConfirmationMessage, confirmationMessage));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__REG_EXP_TO_HIDE_DEFAULT_FIELD, oldRegExpToHideDefaultField, regExpToHideDefaultField));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD, oldUseRegExpToHideDefaultField, useRegExpToHideDefaultField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ViewForm> getViewForm() {
        if (viewForm == null) {
            viewForm = new EObjectContainmentEList<ViewForm>(ViewForm.class, this, ProcessPackage.TASK__VIEW_FORM);
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__USE_VIEW_FORM, oldUseViewForm, useViewForm));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ResourceFolder> getResourceFolders() {
        if (resourceFolders == null) {
            resourceFolders = new EObjectContainmentEList<ResourceFolder>(ResourceFolder.class, this, ProcessPackage.TASK__RESOURCE_FOLDERS);
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__HTML_TEMPLATE, oldHtmlTemplate, newHtmlTemplate);
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
                msgs = ((InternalEObject)htmlTemplate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TASK__HTML_TEMPLATE, null, msgs);
            if (newHtmlTemplate != null)
                msgs = ((InternalEObject)newHtmlTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TASK__HTML_TEMPLATE, null, msgs);
            msgs = basicSetHtmlTemplate(newHtmlTemplate, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__HTML_TEMPLATE, newHtmlTemplate, newHtmlTemplate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ResourceFile> getResourceFiles() {
        if (resourceFiles == null) {
            resourceFiles = new EObjectContainmentEList<ResourceFile>(ResourceFile.class, this, ProcessPackage.TASK__RESOURCE_FILES);
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
            resourceJars = new EDataTypeUniqueEList<String>(String.class, this, ProcessPackage.TASK__RESOURCE_JARS);
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
            resourceValidators = new EDataTypeUniqueEList<String>(String.class, this, ProcessPackage.TASK__RESOURCE_VALIDATORS);
        }
        return resourceValidators;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUser() {
        return user;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUser(String newUser) {
        String oldUser = user;
        user = newUser;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__USER, oldUser, user));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getFilters() {
        if (filters == null) {
            filters = new EObjectContainmentEList<Connector>(Connector.class, this, ProcessPackage.TASK__FILTERS);
        }
        return filters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Group> getGroups() {
        if (groups == null) {
            groups = new EObjectResolvingEList<Group>(Group.class, this, ProcessPackage.TASK__GROUPS);
        }
        return groups;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ActorType getActorType() {
        return actorType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setActorType(ActorType newActorType) {
        ActorType oldActorType = actorType;
        actorType = newActorType == null ? ACTOR_TYPE_EDEFAULT : newActorType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__ACTOR_TYPE, oldActorType, actorType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isOverrideGroupsOfTheLane() {
        return overrideGroupsOfTheLane;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOverrideGroupsOfTheLane(boolean newOverrideGroupsOfTheLane) {
        boolean oldOverrideGroupsOfTheLane = overrideGroupsOfTheLane;
        overrideGroupsOfTheLane = newOverrideGroupsOfTheLane;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__OVERRIDE_GROUPS_OF_THE_LANE, oldOverrideGroupsOfTheLane, overrideGroupsOfTheLane));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPriority() {
        return priority;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPriority(int newPriority) {
        int oldPriority = priority;
        priority = newPriority;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK__PRIORITY, oldPriority, priority));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.TASK__FORM:
                return ((InternalEList<?>)getForm()).basicRemove(otherEnd, msgs);
            case ProcessPackage.TASK__CONFIRMATION_TEMPLATE:
                return basicSetConfirmationTemplate(null, msgs);
            case ProcessPackage.TASK__VIEW_FORM:
                return ((InternalEList<?>)getViewForm()).basicRemove(otherEnd, msgs);
            case ProcessPackage.TASK__RESOURCE_FOLDERS:
                return ((InternalEList<?>)getResourceFolders()).basicRemove(otherEnd, msgs);
            case ProcessPackage.TASK__HTML_TEMPLATE:
                return basicSetHtmlTemplate(null, msgs);
            case ProcessPackage.TASK__RESOURCE_FILES:
                return ((InternalEList<?>)getResourceFiles()).basicRemove(otherEnd, msgs);
            case ProcessPackage.TASK__FILTERS:
                return ((InternalEList<?>)getFilters()).basicRemove(otherEnd, msgs);
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
            case ProcessPackage.TASK__FORM:
                return getForm();
            case ProcessPackage.TASK__BY_PASS_FORMS_GENERATION:
                return getByPassFormsGeneration();
            case ProcessPackage.TASK__CONFIRMATION_TEMPLATE:
                return getConfirmationTemplate();
            case ProcessPackage.TASK__CONFIRMATION_MESSAGE:
                return getConfirmationMessage();
            case ProcessPackage.TASK__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return getRegExpToHideDefaultField();
            case ProcessPackage.TASK__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return isUseRegExpToHideDefaultField();
            case ProcessPackage.TASK__VIEW_FORM:
                return getViewForm();
            case ProcessPackage.TASK__USE_VIEW_FORM:
                return isUseViewForm();
            case ProcessPackage.TASK__RESOURCE_FOLDERS:
                return getResourceFolders();
            case ProcessPackage.TASK__HTML_TEMPLATE:
                return getHtmlTemplate();
            case ProcessPackage.TASK__RESOURCE_FILES:
                return getResourceFiles();
            case ProcessPackage.TASK__RESOURCE_JARS:
                return getResourceJars();
            case ProcessPackage.TASK__RESOURCE_VALIDATORS:
                return getResourceValidators();
            case ProcessPackage.TASK__USER:
                return getUser();
            case ProcessPackage.TASK__FILTERS:
                return getFilters();
            case ProcessPackage.TASK__GROUPS:
                return getGroups();
            case ProcessPackage.TASK__ACTOR_TYPE:
                return getActorType();
            case ProcessPackage.TASK__OVERRIDE_GROUPS_OF_THE_LANE:
                return isOverrideGroupsOfTheLane();
            case ProcessPackage.TASK__PRIORITY:
                return getPriority();
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
            case ProcessPackage.TASK__FORM:
                getForm().clear();
                getForm().addAll((Collection<? extends Form>)newValue);
                return;
            case ProcessPackage.TASK__BY_PASS_FORMS_GENERATION:
                setByPassFormsGeneration((Boolean)newValue);
                return;
            case ProcessPackage.TASK__CONFIRMATION_TEMPLATE:
                setConfirmationTemplate((AssociatedFile)newValue);
                return;
            case ProcessPackage.TASK__CONFIRMATION_MESSAGE:
                setConfirmationMessage((String)newValue);
                return;
            case ProcessPackage.TASK__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setRegExpToHideDefaultField((String)newValue);
                return;
            case ProcessPackage.TASK__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setUseRegExpToHideDefaultField((Boolean)newValue);
                return;
            case ProcessPackage.TASK__VIEW_FORM:
                getViewForm().clear();
                getViewForm().addAll((Collection<? extends ViewForm>)newValue);
                return;
            case ProcessPackage.TASK__USE_VIEW_FORM:
                setUseViewForm((Boolean)newValue);
                return;
            case ProcessPackage.TASK__RESOURCE_FOLDERS:
                getResourceFolders().clear();
                getResourceFolders().addAll((Collection<? extends ResourceFolder>)newValue);
                return;
            case ProcessPackage.TASK__HTML_TEMPLATE:
                setHtmlTemplate((AssociatedFile)newValue);
                return;
            case ProcessPackage.TASK__RESOURCE_FILES:
                getResourceFiles().clear();
                getResourceFiles().addAll((Collection<? extends ResourceFile>)newValue);
                return;
            case ProcessPackage.TASK__RESOURCE_JARS:
                getResourceJars().clear();
                getResourceJars().addAll((Collection<? extends String>)newValue);
                return;
            case ProcessPackage.TASK__RESOURCE_VALIDATORS:
                getResourceValidators().clear();
                getResourceValidators().addAll((Collection<? extends String>)newValue);
                return;
            case ProcessPackage.TASK__USER:
                setUser((String)newValue);
                return;
            case ProcessPackage.TASK__FILTERS:
                getFilters().clear();
                getFilters().addAll((Collection<? extends Connector>)newValue);
                return;
            case ProcessPackage.TASK__GROUPS:
                getGroups().clear();
                getGroups().addAll((Collection<? extends Group>)newValue);
                return;
            case ProcessPackage.TASK__ACTOR_TYPE:
                setActorType((ActorType)newValue);
                return;
            case ProcessPackage.TASK__OVERRIDE_GROUPS_OF_THE_LANE:
                setOverrideGroupsOfTheLane((Boolean)newValue);
                return;
            case ProcessPackage.TASK__PRIORITY:
                setPriority((Integer)newValue);
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
            case ProcessPackage.TASK__FORM:
                getForm().clear();
                return;
            case ProcessPackage.TASK__BY_PASS_FORMS_GENERATION:
                setByPassFormsGeneration(BY_PASS_FORMS_GENERATION_EDEFAULT);
                return;
            case ProcessPackage.TASK__CONFIRMATION_TEMPLATE:
                setConfirmationTemplate((AssociatedFile)null);
                return;
            case ProcessPackage.TASK__CONFIRMATION_MESSAGE:
                setConfirmationMessage(CONFIRMATION_MESSAGE_EDEFAULT);
                return;
            case ProcessPackage.TASK__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setRegExpToHideDefaultField(REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT);
                return;
            case ProcessPackage.TASK__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                setUseRegExpToHideDefaultField(USE_REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT);
                return;
            case ProcessPackage.TASK__VIEW_FORM:
                getViewForm().clear();
                return;
            case ProcessPackage.TASK__USE_VIEW_FORM:
                setUseViewForm(USE_VIEW_FORM_EDEFAULT);
                return;
            case ProcessPackage.TASK__RESOURCE_FOLDERS:
                getResourceFolders().clear();
                return;
            case ProcessPackage.TASK__HTML_TEMPLATE:
                setHtmlTemplate((AssociatedFile)null);
                return;
            case ProcessPackage.TASK__RESOURCE_FILES:
                getResourceFiles().clear();
                return;
            case ProcessPackage.TASK__RESOURCE_JARS:
                getResourceJars().clear();
                return;
            case ProcessPackage.TASK__RESOURCE_VALIDATORS:
                getResourceValidators().clear();
                return;
            case ProcessPackage.TASK__USER:
                setUser(USER_EDEFAULT);
                return;
            case ProcessPackage.TASK__FILTERS:
                getFilters().clear();
                return;
            case ProcessPackage.TASK__GROUPS:
                getGroups().clear();
                return;
            case ProcessPackage.TASK__ACTOR_TYPE:
                setActorType(ACTOR_TYPE_EDEFAULT);
                return;
            case ProcessPackage.TASK__OVERRIDE_GROUPS_OF_THE_LANE:
                setOverrideGroupsOfTheLane(OVERRIDE_GROUPS_OF_THE_LANE_EDEFAULT);
                return;
            case ProcessPackage.TASK__PRIORITY:
                setPriority(PRIORITY_EDEFAULT);
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
            case ProcessPackage.TASK__FORM:
                return form != null && !form.isEmpty();
            case ProcessPackage.TASK__BY_PASS_FORMS_GENERATION:
                return BY_PASS_FORMS_GENERATION_EDEFAULT == null ? byPassFormsGeneration != null : !BY_PASS_FORMS_GENERATION_EDEFAULT.equals(byPassFormsGeneration);
            case ProcessPackage.TASK__CONFIRMATION_TEMPLATE:
                return confirmationTemplate != null;
            case ProcessPackage.TASK__CONFIRMATION_MESSAGE:
                return CONFIRMATION_MESSAGE_EDEFAULT == null ? confirmationMessage != null : !CONFIRMATION_MESSAGE_EDEFAULT.equals(confirmationMessage);
            case ProcessPackage.TASK__REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT == null ? regExpToHideDefaultField != null : !REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT.equals(regExpToHideDefaultField);
            case ProcessPackage.TASK__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
                return useRegExpToHideDefaultField != USE_REG_EXP_TO_HIDE_DEFAULT_FIELD_EDEFAULT;
            case ProcessPackage.TASK__VIEW_FORM:
                return viewForm != null && !viewForm.isEmpty();
            case ProcessPackage.TASK__USE_VIEW_FORM:
                return useViewForm != USE_VIEW_FORM_EDEFAULT;
            case ProcessPackage.TASK__RESOURCE_FOLDERS:
                return resourceFolders != null && !resourceFolders.isEmpty();
            case ProcessPackage.TASK__HTML_TEMPLATE:
                return htmlTemplate != null;
            case ProcessPackage.TASK__RESOURCE_FILES:
                return resourceFiles != null && !resourceFiles.isEmpty();
            case ProcessPackage.TASK__RESOURCE_JARS:
                return resourceJars != null && !resourceJars.isEmpty();
            case ProcessPackage.TASK__RESOURCE_VALIDATORS:
                return resourceValidators != null && !resourceValidators.isEmpty();
            case ProcessPackage.TASK__USER:
                return USER_EDEFAULT == null ? user != null : !USER_EDEFAULT.equals(user);
            case ProcessPackage.TASK__FILTERS:
                return filters != null && !filters.isEmpty();
            case ProcessPackage.TASK__GROUPS:
                return groups != null && !groups.isEmpty();
            case ProcessPackage.TASK__ACTOR_TYPE:
                return actorType != ACTOR_TYPE_EDEFAULT;
            case ProcessPackage.TASK__OVERRIDE_GROUPS_OF_THE_LANE:
                return overrideGroupsOfTheLane != OVERRIDE_GROUPS_OF_THE_LANE_EDEFAULT;
            case ProcessPackage.TASK__PRIORITY:
                return priority != PRIORITY_EDEFAULT;
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
        if (baseClass == PageFlow.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.TASK__FORM: return ProcessPackage.PAGE_FLOW__FORM;
                case ProcessPackage.TASK__BY_PASS_FORMS_GENERATION: return ProcessPackage.PAGE_FLOW__BY_PASS_FORMS_GENERATION;
                case ProcessPackage.TASK__CONFIRMATION_TEMPLATE: return ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE;
                case ProcessPackage.TASK__CONFIRMATION_MESSAGE: return ProcessPackage.PAGE_FLOW__CONFIRMATION_MESSAGE;
                case ProcessPackage.TASK__REG_EXP_TO_HIDE_DEFAULT_FIELD: return ProcessPackage.PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD;
                case ProcessPackage.TASK__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD: return ProcessPackage.PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD;
                case ProcessPackage.TASK__VIEW_FORM: return ProcessPackage.PAGE_FLOW__VIEW_FORM;
                case ProcessPackage.TASK__USE_VIEW_FORM: return ProcessPackage.PAGE_FLOW__USE_VIEW_FORM;
                default: return -1;
            }
        }
        if (baseClass == ResourceContainer.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.TASK__RESOURCE_FOLDERS: return ProcessPackage.RESOURCE_CONTAINER__RESOURCE_FOLDERS;
                case ProcessPackage.TASK__HTML_TEMPLATE: return ProcessPackage.RESOURCE_CONTAINER__HTML_TEMPLATE;
                case ProcessPackage.TASK__RESOURCE_FILES: return ProcessPackage.RESOURCE_CONTAINER__RESOURCE_FILES;
                case ProcessPackage.TASK__RESOURCE_JARS: return ProcessPackage.RESOURCE_CONTAINER__RESOURCE_JARS;
                case ProcessPackage.TASK__RESOURCE_VALIDATORS: return ProcessPackage.RESOURCE_CONTAINER__RESOURCE_VALIDATORS;
                default: return -1;
            }
        }
        if (baseClass == Assignable.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.TASK__USER: return ProcessPackage.ASSIGNABLE__USER;
                case ProcessPackage.TASK__FILTERS: return ProcessPackage.ASSIGNABLE__FILTERS;
                case ProcessPackage.TASK__GROUPS: return ProcessPackage.ASSIGNABLE__GROUPS;
                case ProcessPackage.TASK__ACTOR_TYPE: return ProcessPackage.ASSIGNABLE__ACTOR_TYPE;
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
        if (baseClass == PageFlow.class) {
            switch (baseFeatureID) {
                case ProcessPackage.PAGE_FLOW__FORM: return ProcessPackage.TASK__FORM;
                case ProcessPackage.PAGE_FLOW__BY_PASS_FORMS_GENERATION: return ProcessPackage.TASK__BY_PASS_FORMS_GENERATION;
                case ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE: return ProcessPackage.TASK__CONFIRMATION_TEMPLATE;
                case ProcessPackage.PAGE_FLOW__CONFIRMATION_MESSAGE: return ProcessPackage.TASK__CONFIRMATION_MESSAGE;
                case ProcessPackage.PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD: return ProcessPackage.TASK__REG_EXP_TO_HIDE_DEFAULT_FIELD;
                case ProcessPackage.PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD: return ProcessPackage.TASK__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD;
                case ProcessPackage.PAGE_FLOW__VIEW_FORM: return ProcessPackage.TASK__VIEW_FORM;
                case ProcessPackage.PAGE_FLOW__USE_VIEW_FORM: return ProcessPackage.TASK__USE_VIEW_FORM;
                default: return -1;
            }
        }
        if (baseClass == ResourceContainer.class) {
            switch (baseFeatureID) {
                case ProcessPackage.RESOURCE_CONTAINER__RESOURCE_FOLDERS: return ProcessPackage.TASK__RESOURCE_FOLDERS;
                case ProcessPackage.RESOURCE_CONTAINER__HTML_TEMPLATE: return ProcessPackage.TASK__HTML_TEMPLATE;
                case ProcessPackage.RESOURCE_CONTAINER__RESOURCE_FILES: return ProcessPackage.TASK__RESOURCE_FILES;
                case ProcessPackage.RESOURCE_CONTAINER__RESOURCE_JARS: return ProcessPackage.TASK__RESOURCE_JARS;
                case ProcessPackage.RESOURCE_CONTAINER__RESOURCE_VALIDATORS: return ProcessPackage.TASK__RESOURCE_VALIDATORS;
                default: return -1;
            }
        }
        if (baseClass == Assignable.class) {
            switch (baseFeatureID) {
                case ProcessPackage.ASSIGNABLE__USER: return ProcessPackage.TASK__USER;
                case ProcessPackage.ASSIGNABLE__FILTERS: return ProcessPackage.TASK__FILTERS;
                case ProcessPackage.ASSIGNABLE__GROUPS: return ProcessPackage.TASK__GROUPS;
                case ProcessPackage.ASSIGNABLE__ACTOR_TYPE: return ProcessPackage.TASK__ACTOR_TYPE;
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
        result.append(", resourceJars: "); //$NON-NLS-1$
        result.append(resourceJars);
        result.append(", resourceValidators: "); //$NON-NLS-1$
        result.append(resourceValidators);
        result.append(", user: "); //$NON-NLS-1$
        result.append(user);
        result.append(", actorType: "); //$NON-NLS-1$
        result.append(actorType);
        result.append(", overrideGroupsOfTheLane: "); //$NON-NLS-1$
        result.append(overrideGroupsOfTheLane);
        result.append(", priority: "); //$NON-NLS-1$
        result.append(priority);
        result.append(')');
        return result.toString();
    }

} //TaskImpl
