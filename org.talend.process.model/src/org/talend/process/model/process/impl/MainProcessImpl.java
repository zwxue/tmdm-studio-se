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
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.process.model.process.MainProcess;
import org.talend.process.model.process.MessageFlow;
import org.talend.process.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Main Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.MainProcessImpl#getBonitaVersion <em>Bonita Version</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.MainProcessImpl#getBonitaModelVersion <em>Bonita Model Version</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.MainProcessImpl#getIncludedEntries <em>Included Entries</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.MainProcessImpl#getMessageConnections <em>Message Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MainProcessImpl extends AbstractProcessImpl implements MainProcess {
    /**
     * The default value of the '{@link #getBonitaVersion() <em>Bonita Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBonitaVersion()
     * @generated
     * @ordered
     */
    protected static final String BONITA_VERSION_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getBonitaVersion() <em>Bonita Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBonitaVersion()
     * @generated
     * @ordered
     */
    protected String bonitaVersion = BONITA_VERSION_EDEFAULT;

    /**
     * The default value of the '{@link #getBonitaModelVersion() <em>Bonita Model Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBonitaModelVersion()
     * @generated
     * @ordered
     */
    protected static final String BONITA_MODEL_VERSION_EDEFAULT = "5.0"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getBonitaModelVersion() <em>Bonita Model Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBonitaModelVersion()
     * @generated
     * @ordered
     */
    protected String bonitaModelVersion = BONITA_MODEL_VERSION_EDEFAULT;

    /**
     * The cached value of the '{@link #getIncludedEntries() <em>Included Entries</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIncludedEntries()
     * @generated
     * @ordered
     */
    protected EList<String> includedEntries;

    /**
     * The cached value of the '{@link #getMessageConnections() <em>Message Connections</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessageConnections()
     * @generated
     * @ordered
     */
    protected EList<MessageFlow> messageConnections;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MainProcessImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.MAIN_PROCESS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBonitaVersion() {
        return bonitaVersion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBonitaVersion(String newBonitaVersion) {
        String oldBonitaVersion = bonitaVersion;
        bonitaVersion = newBonitaVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.MAIN_PROCESS__BONITA_VERSION, oldBonitaVersion, bonitaVersion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBonitaModelVersion() {
        return bonitaModelVersion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBonitaModelVersion(String newBonitaModelVersion) {
        String oldBonitaModelVersion = bonitaModelVersion;
        bonitaModelVersion = newBonitaModelVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.MAIN_PROCESS__BONITA_MODEL_VERSION, oldBonitaModelVersion, bonitaModelVersion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getIncludedEntries() {
        if (includedEntries == null) {
            includedEntries = new EDataTypeUniqueEList<String>(String.class, this, ProcessPackage.MAIN_PROCESS__INCLUDED_ENTRIES);
        }
        return includedEntries;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MessageFlow> getMessageConnections() {
        if (messageConnections == null) {
            messageConnections = new EObjectContainmentEList<MessageFlow>(MessageFlow.class, this, ProcessPackage.MAIN_PROCESS__MESSAGE_CONNECTIONS);
        }
        return messageConnections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.MAIN_PROCESS__MESSAGE_CONNECTIONS:
                return ((InternalEList<?>)getMessageConnections()).basicRemove(otherEnd, msgs);
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
            case ProcessPackage.MAIN_PROCESS__BONITA_VERSION:
                return getBonitaVersion();
            case ProcessPackage.MAIN_PROCESS__BONITA_MODEL_VERSION:
                return getBonitaModelVersion();
            case ProcessPackage.MAIN_PROCESS__INCLUDED_ENTRIES:
                return getIncludedEntries();
            case ProcessPackage.MAIN_PROCESS__MESSAGE_CONNECTIONS:
                return getMessageConnections();
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
            case ProcessPackage.MAIN_PROCESS__BONITA_VERSION:
                setBonitaVersion((String)newValue);
                return;
            case ProcessPackage.MAIN_PROCESS__BONITA_MODEL_VERSION:
                setBonitaModelVersion((String)newValue);
                return;
            case ProcessPackage.MAIN_PROCESS__INCLUDED_ENTRIES:
                getIncludedEntries().clear();
                getIncludedEntries().addAll((Collection<? extends String>)newValue);
                return;
            case ProcessPackage.MAIN_PROCESS__MESSAGE_CONNECTIONS:
                getMessageConnections().clear();
                getMessageConnections().addAll((Collection<? extends MessageFlow>)newValue);
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
            case ProcessPackage.MAIN_PROCESS__BONITA_VERSION:
                setBonitaVersion(BONITA_VERSION_EDEFAULT);
                return;
            case ProcessPackage.MAIN_PROCESS__BONITA_MODEL_VERSION:
                setBonitaModelVersion(BONITA_MODEL_VERSION_EDEFAULT);
                return;
            case ProcessPackage.MAIN_PROCESS__INCLUDED_ENTRIES:
                getIncludedEntries().clear();
                return;
            case ProcessPackage.MAIN_PROCESS__MESSAGE_CONNECTIONS:
                getMessageConnections().clear();
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
            case ProcessPackage.MAIN_PROCESS__BONITA_VERSION:
                return BONITA_VERSION_EDEFAULT == null ? bonitaVersion != null : !BONITA_VERSION_EDEFAULT.equals(bonitaVersion);
            case ProcessPackage.MAIN_PROCESS__BONITA_MODEL_VERSION:
                return BONITA_MODEL_VERSION_EDEFAULT == null ? bonitaModelVersion != null : !BONITA_MODEL_VERSION_EDEFAULT.equals(bonitaModelVersion);
            case ProcessPackage.MAIN_PROCESS__INCLUDED_ENTRIES:
                return includedEntries != null && !includedEntries.isEmpty();
            case ProcessPackage.MAIN_PROCESS__MESSAGE_CONNECTIONS:
                return messageConnections != null && !messageConnections.isEmpty();
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
        result.append(" (bonitaVersion: "); //$NON-NLS-1$
        result.append(bonitaVersion);
        result.append(", bonitaModelVersion: "); //$NON-NLS-1$
        result.append(bonitaModelVersion);
        result.append(", includedEntries: "); //$NON-NLS-1$
        result.append(includedEntries);
        result.append(')');
        return result.toString();
    }

} //MainProcessImpl
