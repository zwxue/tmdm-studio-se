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
import org.talend.process.model.kpi.DatabaseKPIBinding;
import org.talend.process.model.kpi.KpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Database KPI Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.kpi.impl.DatabaseKPIBindingImpl#getDatabaseConfiguration <em>Database Configuration</em>}</li>
 *   <li>{@link org.talend.process.model.kpi.impl.DatabaseKPIBindingImpl#getTableName <em>Table Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DatabaseKPIBindingImpl extends AbstractKPIBindingImpl implements DatabaseKPIBinding {
    /**
     * The cached value of the '{@link #getDatabaseConfiguration() <em>Database Configuration</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatabaseConfiguration()
     * @generated
     * @ordered
     */
    protected DatabaseConfiguration databaseConfiguration;

    /**
     * The default value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTableName()
     * @generated
     * @ordered
     */
    protected static final String TABLE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTableName()
     * @generated
     * @ordered
     */
    protected String tableName = TABLE_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DatabaseKPIBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return KpiPackage.Literals.DATABASE_KPI_BINDING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDatabaseConfiguration(DatabaseConfiguration newDatabaseConfiguration, NotificationChain msgs) {
        DatabaseConfiguration oldDatabaseConfiguration = databaseConfiguration;
        databaseConfiguration = newDatabaseConfiguration;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KpiPackage.DATABASE_KPI_BINDING__DATABASE_CONFIGURATION, oldDatabaseConfiguration, newDatabaseConfiguration);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDatabaseConfiguration(DatabaseConfiguration newDatabaseConfiguration) {
        if (newDatabaseConfiguration != databaseConfiguration) {
            NotificationChain msgs = null;
            if (databaseConfiguration != null)
                msgs = ((InternalEObject)databaseConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KpiPackage.DATABASE_KPI_BINDING__DATABASE_CONFIGURATION, null, msgs);
            if (newDatabaseConfiguration != null)
                msgs = ((InternalEObject)newDatabaseConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KpiPackage.DATABASE_KPI_BINDING__DATABASE_CONFIGURATION, null, msgs);
            msgs = basicSetDatabaseConfiguration(newDatabaseConfiguration, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.DATABASE_KPI_BINDING__DATABASE_CONFIGURATION, newDatabaseConfiguration, newDatabaseConfiguration));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTableName(String newTableName) {
        String oldTableName = tableName;
        tableName = newTableName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KpiPackage.DATABASE_KPI_BINDING__TABLE_NAME, oldTableName, tableName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case KpiPackage.DATABASE_KPI_BINDING__DATABASE_CONFIGURATION:
                return basicSetDatabaseConfiguration(null, msgs);
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
            case KpiPackage.DATABASE_KPI_BINDING__DATABASE_CONFIGURATION:
                return getDatabaseConfiguration();
            case KpiPackage.DATABASE_KPI_BINDING__TABLE_NAME:
                return getTableName();
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
            case KpiPackage.DATABASE_KPI_BINDING__DATABASE_CONFIGURATION:
                setDatabaseConfiguration((DatabaseConfiguration)newValue);
                return;
            case KpiPackage.DATABASE_KPI_BINDING__TABLE_NAME:
                setTableName((String)newValue);
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
            case KpiPackage.DATABASE_KPI_BINDING__DATABASE_CONFIGURATION:
                setDatabaseConfiguration((DatabaseConfiguration)null);
                return;
            case KpiPackage.DATABASE_KPI_BINDING__TABLE_NAME:
                setTableName(TABLE_NAME_EDEFAULT);
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
            case KpiPackage.DATABASE_KPI_BINDING__DATABASE_CONFIGURATION:
                return databaseConfiguration != null;
            case KpiPackage.DATABASE_KPI_BINDING__TABLE_NAME:
                return TABLE_NAME_EDEFAULT == null ? tableName != null : !TABLE_NAME_EDEFAULT.equals(tableName);
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
        result.append(" (tableName: "); //$NON-NLS-1$
        result.append(tableName);
        result.append(')');
        return result.toString();
    }

} //DatabaseKPIBindingImpl
