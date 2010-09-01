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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.process.model.process.ActorType;
import org.talend.process.model.process.Assignable;
import org.talend.process.model.process.Connector;
import org.talend.process.model.process.Group;
import org.talend.process.model.process.Lane;
import org.talend.process.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lane</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.LaneImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.LaneImpl#getFilters <em>Filters</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.LaneImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.LaneImpl#getActorType <em>Actor Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LaneImpl extends ContainerImpl implements Lane {
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LaneImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.LANE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.LANE__USER, oldUser, user));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connector> getFilters() {
        if (filters == null) {
            filters = new EObjectContainmentEList<Connector>(Connector.class, this, ProcessPackage.LANE__FILTERS);
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
            groups = new EObjectResolvingEList<Group>(Group.class, this, ProcessPackage.LANE__GROUPS);
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
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.LANE__ACTOR_TYPE, oldActorType, actorType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.LANE__FILTERS:
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
            case ProcessPackage.LANE__USER:
                return getUser();
            case ProcessPackage.LANE__FILTERS:
                return getFilters();
            case ProcessPackage.LANE__GROUPS:
                return getGroups();
            case ProcessPackage.LANE__ACTOR_TYPE:
                return getActorType();
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
            case ProcessPackage.LANE__USER:
                setUser((String)newValue);
                return;
            case ProcessPackage.LANE__FILTERS:
                getFilters().clear();
                getFilters().addAll((Collection<? extends Connector>)newValue);
                return;
            case ProcessPackage.LANE__GROUPS:
                getGroups().clear();
                getGroups().addAll((Collection<? extends Group>)newValue);
                return;
            case ProcessPackage.LANE__ACTOR_TYPE:
                setActorType((ActorType)newValue);
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
            case ProcessPackage.LANE__USER:
                setUser(USER_EDEFAULT);
                return;
            case ProcessPackage.LANE__FILTERS:
                getFilters().clear();
                return;
            case ProcessPackage.LANE__GROUPS:
                getGroups().clear();
                return;
            case ProcessPackage.LANE__ACTOR_TYPE:
                setActorType(ACTOR_TYPE_EDEFAULT);
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
            case ProcessPackage.LANE__USER:
                return USER_EDEFAULT == null ? user != null : !USER_EDEFAULT.equals(user);
            case ProcessPackage.LANE__FILTERS:
                return filters != null && !filters.isEmpty();
            case ProcessPackage.LANE__GROUPS:
                return groups != null && !groups.isEmpty();
            case ProcessPackage.LANE__ACTOR_TYPE:
                return actorType != ACTOR_TYPE_EDEFAULT;
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
        if (baseClass == Assignable.class) {
            switch (derivedFeatureID) {
                case ProcessPackage.LANE__USER: return ProcessPackage.ASSIGNABLE__USER;
                case ProcessPackage.LANE__FILTERS: return ProcessPackage.ASSIGNABLE__FILTERS;
                case ProcessPackage.LANE__GROUPS: return ProcessPackage.ASSIGNABLE__GROUPS;
                case ProcessPackage.LANE__ACTOR_TYPE: return ProcessPackage.ASSIGNABLE__ACTOR_TYPE;
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
        if (baseClass == Assignable.class) {
            switch (baseFeatureID) {
                case ProcessPackage.ASSIGNABLE__USER: return ProcessPackage.LANE__USER;
                case ProcessPackage.ASSIGNABLE__FILTERS: return ProcessPackage.LANE__FILTERS;
                case ProcessPackage.ASSIGNABLE__GROUPS: return ProcessPackage.LANE__GROUPS;
                case ProcessPackage.ASSIGNABLE__ACTOR_TYPE: return ProcessPackage.LANE__ACTOR_TYPE;
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
        result.append(" (user: "); //$NON-NLS-1$
        result.append(user);
        result.append(", actorType: "); //$NON-NLS-1$
        result.append(actorType);
        result.append(')');
        return result.toString();
    }

} //LaneImpl
