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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.process.model.process.Data;
import org.talend.process.model.process.InputMapping;
import org.talend.process.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.process.impl.InputMappingImpl#getProcessSource <em>Process Source</em>}</li>
 *   <li>{@link org.talend.process.model.process.impl.InputMappingImpl#getSubprocessTarget <em>Subprocess Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputMappingImpl extends EObjectImpl implements InputMapping {
    /**
     * The cached value of the '{@link #getProcessSource() <em>Process Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProcessSource()
     * @generated
     * @ordered
     */
    protected Data processSource;

    /**
     * The default value of the '{@link #getSubprocessTarget() <em>Subprocess Target</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubprocessTarget()
     * @generated
     * @ordered
     */
    protected static final String SUBPROCESS_TARGET_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSubprocessTarget() <em>Subprocess Target</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubprocessTarget()
     * @generated
     * @ordered
     */
    protected String subprocessTarget = SUBPROCESS_TARGET_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InputMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProcessPackage.Literals.INPUT_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data getProcessSource() {
        if (processSource != null && processSource.eIsProxy()) {
            InternalEObject oldProcessSource = (InternalEObject)processSource;
            processSource = (Data)eResolveProxy(oldProcessSource);
            if (processSource != oldProcessSource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.INPUT_MAPPING__PROCESS_SOURCE, oldProcessSource, processSource));
            }
        }
        return processSource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data basicGetProcessSource() {
        return processSource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProcessSource(Data newProcessSource) {
        Data oldProcessSource = processSource;
        processSource = newProcessSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.INPUT_MAPPING__PROCESS_SOURCE, oldProcessSource, processSource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSubprocessTarget() {
        return subprocessTarget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSubprocessTarget(String newSubprocessTarget) {
        String oldSubprocessTarget = subprocessTarget;
        subprocessTarget = newSubprocessTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.INPUT_MAPPING__SUBPROCESS_TARGET, oldSubprocessTarget, subprocessTarget));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ProcessPackage.INPUT_MAPPING__PROCESS_SOURCE:
                if (resolve) return getProcessSource();
                return basicGetProcessSource();
            case ProcessPackage.INPUT_MAPPING__SUBPROCESS_TARGET:
                return getSubprocessTarget();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ProcessPackage.INPUT_MAPPING__PROCESS_SOURCE:
                setProcessSource((Data)newValue);
                return;
            case ProcessPackage.INPUT_MAPPING__SUBPROCESS_TARGET:
                setSubprocessTarget((String)newValue);
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
            case ProcessPackage.INPUT_MAPPING__PROCESS_SOURCE:
                setProcessSource((Data)null);
                return;
            case ProcessPackage.INPUT_MAPPING__SUBPROCESS_TARGET:
                setSubprocessTarget(SUBPROCESS_TARGET_EDEFAULT);
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
            case ProcessPackage.INPUT_MAPPING__PROCESS_SOURCE:
                return processSource != null;
            case ProcessPackage.INPUT_MAPPING__SUBPROCESS_TARGET:
                return SUBPROCESS_TARGET_EDEFAULT == null ? subprocessTarget != null : !SUBPROCESS_TARGET_EDEFAULT.equals(subprocessTarget);
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
        result.append(" (subprocessTarget: "); //$NON-NLS-1$
        result.append(subprocessTarget);
        result.append(')');
        return result.toString();
    }

} //InputMappingImpl
