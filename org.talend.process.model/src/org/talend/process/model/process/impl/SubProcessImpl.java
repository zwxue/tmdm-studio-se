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
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.process.model.process.InputMapping;
import org.talend.process.model.process.OutputMapping;
import org.talend.process.model.process.ProcessPackage;
import org.talend.process.model.process.SubProcess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.SubProcessImpl#getSubprocessName <em>Subprocess Name</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.SubProcessImpl#getSubprocessVersion <em>Subprocess Version</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.SubProcessImpl#getInputMappings <em>Input Mappings</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.SubProcessImpl#getOutputMappings <em>Output Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubProcessImpl extends ActivityImpl implements SubProcess {
    /**
     * The default value of the '{@link #getSubprocessName() <em>Subprocess Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubprocessName()
     * @generated
     * @ordered
     */
    protected static final String SUBPROCESS_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSubprocessName() <em>Subprocess Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubprocessName()
     * @generated
     * @ordered
     */
    protected String subprocessName = SUBPROCESS_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getSubprocessVersion() <em>Subprocess Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubprocessVersion()
     * @generated
     * @ordered
     */
    protected static final String SUBPROCESS_VERSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSubprocessVersion() <em>Subprocess Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubprocessVersion()
     * @generated
     * @ordered
     */
    protected String subprocessVersion = SUBPROCESS_VERSION_EDEFAULT;

    /**
     * The cached value of the '{@link #getInputMappings() <em>Input Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputMappings()
     * @generated
     * @ordered
     */
    protected EList<InputMapping> inputMappings;

    /**
     * The cached value of the '{@link #getOutputMappings() <em>Output Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputMappings()
     * @generated
     * @ordered
     */
    protected EList<OutputMapping> outputMappings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SubProcessImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.SUB_PROCESS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSubprocessName() {
        return subprocessName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSubprocessName(String newSubprocessName) {
        String oldSubprocessName = subprocessName;
        subprocessName = newSubprocessName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.SUB_PROCESS__SUBPROCESS_NAME, oldSubprocessName, subprocessName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSubprocessVersion() {
        return subprocessVersion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSubprocessVersion(String newSubprocessVersion) {
        String oldSubprocessVersion = subprocessVersion;
        subprocessVersion = newSubprocessVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.SUB_PROCESS__SUBPROCESS_VERSION, oldSubprocessVersion, subprocessVersion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InputMapping> getInputMappings() {
        if (inputMappings == null) {
            inputMappings = new EObjectContainmentEList<InputMapping>(InputMapping.class, this, ProcessPackage.SUB_PROCESS__INPUT_MAPPINGS);
        }
        return inputMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<OutputMapping> getOutputMappings() {
        if (outputMappings == null) {
            outputMappings = new EObjectContainmentEList<OutputMapping>(OutputMapping.class, this, ProcessPackage.SUB_PROCESS__OUTPUT_MAPPINGS);
        }
        return outputMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProcessPackage.SUB_PROCESS__INPUT_MAPPINGS:
                return ((InternalEList<?>)getInputMappings()).basicRemove(otherEnd, msgs);
            case ProcessPackage.SUB_PROCESS__OUTPUT_MAPPINGS:
                return ((InternalEList<?>)getOutputMappings()).basicRemove(otherEnd, msgs);
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
            case ProcessPackage.SUB_PROCESS__SUBPROCESS_NAME:
                return getSubprocessName();
            case ProcessPackage.SUB_PROCESS__SUBPROCESS_VERSION:
                return getSubprocessVersion();
            case ProcessPackage.SUB_PROCESS__INPUT_MAPPINGS:
                return getInputMappings();
            case ProcessPackage.SUB_PROCESS__OUTPUT_MAPPINGS:
                return getOutputMappings();
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
            case ProcessPackage.SUB_PROCESS__SUBPROCESS_NAME:
                setSubprocessName((String)newValue);
                return;
            case ProcessPackage.SUB_PROCESS__SUBPROCESS_VERSION:
                setSubprocessVersion((String)newValue);
                return;
            case ProcessPackage.SUB_PROCESS__INPUT_MAPPINGS:
                getInputMappings().clear();
                getInputMappings().addAll((Collection<? extends InputMapping>)newValue);
                return;
            case ProcessPackage.SUB_PROCESS__OUTPUT_MAPPINGS:
                getOutputMappings().clear();
                getOutputMappings().addAll((Collection<? extends OutputMapping>)newValue);
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
            case ProcessPackage.SUB_PROCESS__SUBPROCESS_NAME:
                setSubprocessName(SUBPROCESS_NAME_EDEFAULT);
                return;
            case ProcessPackage.SUB_PROCESS__SUBPROCESS_VERSION:
                setSubprocessVersion(SUBPROCESS_VERSION_EDEFAULT);
                return;
            case ProcessPackage.SUB_PROCESS__INPUT_MAPPINGS:
                getInputMappings().clear();
                return;
            case ProcessPackage.SUB_PROCESS__OUTPUT_MAPPINGS:
                getOutputMappings().clear();
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
            case ProcessPackage.SUB_PROCESS__SUBPROCESS_NAME:
                return SUBPROCESS_NAME_EDEFAULT == null ? subprocessName != null : !SUBPROCESS_NAME_EDEFAULT.equals(subprocessName);
            case ProcessPackage.SUB_PROCESS__SUBPROCESS_VERSION:
                return SUBPROCESS_VERSION_EDEFAULT == null ? subprocessVersion != null : !SUBPROCESS_VERSION_EDEFAULT.equals(subprocessVersion);
            case ProcessPackage.SUB_PROCESS__INPUT_MAPPINGS:
                return inputMappings != null && !inputMappings.isEmpty();
            case ProcessPackage.SUB_PROCESS__OUTPUT_MAPPINGS:
                return outputMappings != null && !outputMappings.isEmpty();
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
        result.append(" (subprocessName: "); //$NON-NLS-1$
        result.append(subprocessName);
        result.append(", subprocessVersion: "); //$NON-NLS-1$
        result.append(subprocessVersion);
        result.append(')');
        return result.toString();
    }

} //SubProcessImpl
