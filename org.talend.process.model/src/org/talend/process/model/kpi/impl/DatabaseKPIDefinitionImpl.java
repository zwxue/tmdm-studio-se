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
package org.talend.process.model.kpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.talend.process.model.kpi.DatabaseConfiguration;
import org.talend.process.model.kpi.DatabaseKPIDefinition;
import org.talend.process.model.kpi.KpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Database KPI Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.kpi.impl.DatabaseKPIDefinitionImpl#getDefaultConfiguration <em>Default Configuration</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.DatabaseKPIDefinitionImpl#getDefaultTableName <em>Default Table Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DatabaseKPIDefinitionImpl extends AbstractKPIDefinitionImpl implements DatabaseKPIDefinition {
    /**
     * The cached value of the '{@link #getDefaultConfiguration() <em>Default Configuration</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultConfiguration()
     * @generated
     * @ordered
     */
    protected DatabaseConfiguration defaultConfiguration;

    /**
     * The default value of the '{@link #getDefaultTableName() <em>Default Table Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultTableName()
     * @generated
     * @ordered
     */
    protected static final String DEFAULT_TABLE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefaultTableName() <em>Default Table Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultTableName()
     * @generated
     * @ordered
     */
    protected String defaultTableName = DEFAULT_TABLE_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DatabaseKPIDefinitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return KpiPackage.Literals.DATABASE_KPI_DEFINITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatabaseConfiguration getDefaultConfiguration() {
        return defaultConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDefaultConfiguration(DatabaseConfiguration newDefaultConfiguration, NotificationChain msgs) {
        DatabaseConfiguration oldDefaultConfiguration = defaultConfiguration;
        defaultConfiguration = newDefaultConfiguration;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_CONFIGURATION, oldDefaultConfiguration, newDefaultConfiguration);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultConfiguration(DatabaseConfiguration newDefaultConfiguration) {
        if (newDefaultConfiguration != defaultConfiguration) {
            NotificationChain msgs = null;
            if (defaultConfiguration != null)
                msgs = ((InternalEObject)defaultConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_CONFIGURATION, null, msgs);
            if (newDefaultConfiguration != null)
                msgs = ((InternalEObject)newDefaultConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_CONFIGURATION, null, msgs);
            msgs = basicSetDefaultConfiguration(newDefaultConfiguration, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_CONFIGURATION, newDefaultConfiguration, newDefaultConfiguration));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDefaultTableName() {
        return defaultTableName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultTableName(String newDefaultTableName) {
        String oldDefaultTableName = defaultTableName;
        defaultTableName = newDefaultTableName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_TABLE_NAME, oldDefaultTableName, defaultTableName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_CONFIGURATION:
                return basicSetDefaultConfiguration(null, msgs);
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
            case KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_CONFIGURATION:
                return getDefaultConfiguration();
            case KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_TABLE_NAME:
                return getDefaultTableName();
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
            case KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_CONFIGURATION:
                setDefaultConfiguration((DatabaseConfiguration)newValue);
                return;
            case KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_TABLE_NAME:
                setDefaultTableName((String)newValue);
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
            case KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_CONFIGURATION:
                setDefaultConfiguration((DatabaseConfiguration)null);
                return;
            case KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_TABLE_NAME:
                setDefaultTableName(DEFAULT_TABLE_NAME_EDEFAULT);
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
            case KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_CONFIGURATION:
                return defaultConfiguration != null;
            case KpiPackage.DATABASE_KPI_DEFINITION__DEFAULT_TABLE_NAME:
                return DEFAULT_TABLE_NAME_EDEFAULT == null ? defaultTableName != null : !DEFAULT_TABLE_NAME_EDEFAULT.equals(defaultTableName);
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
        result.append(" (defaultTableName: "); //$NON-NLS-1$
        result.append(defaultTableName);
        result.append(')');
        return result.toString();
    }

} //DatabaseKPIDefinitionImpl
