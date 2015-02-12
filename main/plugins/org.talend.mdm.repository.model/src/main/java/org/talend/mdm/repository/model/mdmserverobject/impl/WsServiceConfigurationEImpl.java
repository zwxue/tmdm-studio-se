/**
 * <copyright> </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WsServiceConfigurationE;
import org.talend.mdm.repository.model.mdmserverobject.WsServicePutConfigurationE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Service Configuration E</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.talend.mdm.repository.model.mdmserverobject.impl.WsServiceConfigurationEImpl#getServicePutConfigurations
 * <em>Service Put Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsServiceConfigurationEImpl extends MDMServerObjectImpl implements WsServiceConfigurationE {

    /**
     * The cached value of the '{@link #getServicePutConfigurations() <em>Service Put Configurations</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getServicePutConfigurations()
     * @generated
     * @ordered
     */
    protected EList<WsServicePutConfigurationE> servicePutConfigurations;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsServiceConfigurationEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_SERVICE_CONFIGURATION_E;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<WsServicePutConfigurationE> getServicePutConfigurations() {
        if (servicePutConfigurations == null) {
            servicePutConfigurations = new EObjectContainmentEList<WsServicePutConfigurationE>(WsServicePutConfigurationE.class,
                    this, MdmserverobjectPackage.WS_SERVICE_CONFIGURATION_E__SERVICE_PUT_CONFIGURATIONS);
        }
        return servicePutConfigurations;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case MdmserverobjectPackage.WS_SERVICE_CONFIGURATION_E__SERVICE_PUT_CONFIGURATIONS:
            return ((InternalEList<?>) getServicePutConfigurations()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case MdmserverobjectPackage.WS_SERVICE_CONFIGURATION_E__SERVICE_PUT_CONFIGURATIONS:
            return getServicePutConfigurations();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case MdmserverobjectPackage.WS_SERVICE_CONFIGURATION_E__SERVICE_PUT_CONFIGURATIONS:
            getServicePutConfigurations().clear();
            getServicePutConfigurations().addAll((Collection<? extends WsServicePutConfigurationE>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case MdmserverobjectPackage.WS_SERVICE_CONFIGURATION_E__SERVICE_PUT_CONFIGURATIONS:
            getServicePutConfigurations().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case MdmserverobjectPackage.WS_SERVICE_CONFIGURATION_E__SERVICE_PUT_CONFIGURATIONS:
            return servicePutConfigurations != null && !servicePutConfigurations.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    @Override
    public int getType() {
        return 22;
    }
} // WsServiceConfigurationEImpl
