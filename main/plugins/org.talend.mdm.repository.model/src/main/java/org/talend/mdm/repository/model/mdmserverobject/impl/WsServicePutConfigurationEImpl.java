/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ws Service Put Configuration E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsServicePutConfigurationEImpl#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsServicePutConfigurationEImpl#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsServicePutConfigurationEImpl extends EObjectImpl implements WsServicePutConfigurationE {
    /**
     * The default value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJndiName()
     * @generated
     * @ordered
     */
    protected static final String JNDI_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJndiName()
     * @generated
     * @ordered
     */
    protected String jndiName = JNDI_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getConfiguration() <em>Configuration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfiguration()
     * @generated
     * @ordered
     */
    protected static final String CONFIGURATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfiguration()
     * @generated
     * @ordered
     */
    protected String configuration = CONFIGURATION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WsServicePutConfigurationEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_SERVICE_PUT_CONFIGURATION_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getJndiName() {
        return jndiName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setJndiName(String newJndiName) {
        String oldJndiName = jndiName;
        jndiName = newJndiName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E__JNDI_NAME, oldJndiName, jndiName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getConfiguration() {
        return configuration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConfiguration(String newConfiguration) {
        String oldConfiguration = configuration;
        configuration = newConfiguration;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E__CONFIGURATION, oldConfiguration, configuration));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E__JNDI_NAME:
                return getJndiName();
            case MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E__CONFIGURATION:
                return getConfiguration();
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
            case MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E__JNDI_NAME:
                setJndiName((String)newValue);
                return;
            case MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E__CONFIGURATION:
                setConfiguration((String)newValue);
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
            case MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E__JNDI_NAME:
                setJndiName(JNDI_NAME_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E__CONFIGURATION:
                setConfiguration(CONFIGURATION_EDEFAULT);
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
            case MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E__JNDI_NAME:
                return JNDI_NAME_EDEFAULT == null ? jndiName != null : !JNDI_NAME_EDEFAULT.equals(jndiName);
            case MdmserverobjectPackage.WS_SERVICE_PUT_CONFIGURATION_E__CONFIGURATION:
                return CONFIGURATION_EDEFAULT == null ? configuration != null : !CONFIGURATION_EDEFAULT.equals(configuration);
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
        result.append(" (jndiName: ");
        result.append(jndiName);
        result.append(", configuration: ");
        result.append(configuration);
        result.append(')');
        return result.toString();
    }

} //WsServicePutConfigurationEImpl
