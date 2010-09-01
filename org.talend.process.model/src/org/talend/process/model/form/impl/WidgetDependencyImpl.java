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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.talend.process.model.form.EventDependencyType;
import org.talend.process.model.form.FormPackage;
import org.talend.process.model.form.Widget;
import org.talend.process.model.form.WidgetDependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Widget Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.form.impl.WidgetDependencyImpl#getWidget <em>Widget</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.WidgetDependencyImpl#getEventTypes <em>Event Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WidgetDependencyImpl extends EObjectImpl implements WidgetDependency {
    /**
     * The cached value of the '{@link #getWidget() <em>Widget</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidget()
     * @generated
     * @ordered
     */
    protected Widget widget;

    /**
     * The cached value of the '{@link #getEventTypes() <em>Event Types</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEventTypes()
     * @generated
     * @ordered
     */
    protected EList<EventDependencyType> eventTypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WidgetDependencyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FormPackage.Literals.WIDGET_DEPENDENCY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Widget getWidget() {
        if (widget != null && widget.eIsProxy()) {
            InternalEObject oldWidget = (InternalEObject)widget;
            widget = (Widget)eResolveProxy(oldWidget);
            if (widget != oldWidget) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormPackage.WIDGET_DEPENDENCY__WIDGET, oldWidget, widget));
            }
        }
        return widget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Widget basicGetWidget() {
        return widget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWidget(Widget newWidget) {
        Widget oldWidget = widget;
        widget = newWidget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.WIDGET_DEPENDENCY__WIDGET, oldWidget, widget));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EventDependencyType> getEventTypes() {
        if (eventTypes == null) {
            eventTypes = new EDataTypeUniqueEList<EventDependencyType>(EventDependencyType.class, this, FormPackage.WIDGET_DEPENDENCY__EVENT_TYPES);
        }
        return eventTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FormPackage.WIDGET_DEPENDENCY__WIDGET:
                if (resolve) return getWidget();
                return basicGetWidget();
            case FormPackage.WIDGET_DEPENDENCY__EVENT_TYPES:
                return getEventTypes();
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
            case FormPackage.WIDGET_DEPENDENCY__WIDGET:
                setWidget((Widget)newValue);
                return;
            case FormPackage.WIDGET_DEPENDENCY__EVENT_TYPES:
                getEventTypes().clear();
                getEventTypes().addAll((Collection<? extends EventDependencyType>)newValue);
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
            case FormPackage.WIDGET_DEPENDENCY__WIDGET:
                setWidget((Widget)null);
                return;
            case FormPackage.WIDGET_DEPENDENCY__EVENT_TYPES:
                getEventTypes().clear();
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
            case FormPackage.WIDGET_DEPENDENCY__WIDGET:
                return widget != null;
            case FormPackage.WIDGET_DEPENDENCY__EVENT_TYPES:
                return eventTypes != null && !eventTypes.isEmpty();
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
        result.append(" (eventTypes: "); //$NON-NLS-1$
        result.append(eventTypes);
        result.append(')');
        return result.toString();
    }

} //WidgetDependencyImpl
