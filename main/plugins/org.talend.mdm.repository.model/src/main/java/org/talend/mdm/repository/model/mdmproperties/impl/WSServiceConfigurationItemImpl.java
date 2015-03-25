/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;
import org.talend.mdm.repository.model.mdmproperties.WSServiceConfigurationItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSServiceConfigurationE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Service Configuration Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSServiceConfigurationItemImpl#getWsServiceConfiguration <em>Ws Service Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSServiceConfigurationItemImpl extends MDMServerObjectItemImpl implements WSServiceConfigurationItem {
    /**
     * The cached value of the '{@link #getWsServiceConfiguration() <em>Ws Service Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWsServiceConfiguration()
     * @generated
     * @ordered
     */
    protected WSServiceConfigurationE wsServiceConfiguration;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSServiceConfigurationItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_SERVICE_CONFIGURATION_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public WSServiceConfigurationE getWsServiceConfiguration() {
        if (wsServiceConfiguration != null && wsServiceConfiguration.eIsProxy()) {
            InternalEObject oldWsServiceConfiguration = (InternalEObject)wsServiceConfiguration;
            wsServiceConfiguration = (WSServiceConfigurationE)eResolveProxy(oldWsServiceConfiguration);
            if (wsServiceConfiguration.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsServiceConfiguration);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WSServiceConfigurationE) {
                        wsServiceConfiguration = (WSServiceConfigurationE) object;
                        break;
                    }
                }
            }
            if (wsServiceConfiguration != oldWsServiceConfiguration) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_SERVICE_CONFIGURATION_ITEM__WS_SERVICE_CONFIGURATION, oldWsServiceConfiguration, wsServiceConfiguration));
                }
            }
        }
        return wsServiceConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSServiceConfigurationE basicGetWsServiceConfiguration() {
        return wsServiceConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setWsServiceConfiguration(WSServiceConfigurationE newWsServiceConfiguration) {
        WSServiceConfigurationE oldWsServiceConfiguration = wsServiceConfiguration;
        wsServiceConfiguration = newWsServiceConfiguration;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_SERVICE_CONFIGURATION_ITEM__WS_SERVICE_CONFIGURATION, oldWsServiceConfiguration, wsServiceConfiguration));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_SERVICE_CONFIGURATION_ITEM__WS_SERVICE_CONFIGURATION:
                if (resolve) {
                    return getWsServiceConfiguration();
                }
                return basicGetWsServiceConfiguration();
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
            case MdmpropertiesPackage.WS_SERVICE_CONFIGURATION_ITEM__WS_SERVICE_CONFIGURATION:
                setWsServiceConfiguration((WSServiceConfigurationE)newValue);
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
            case MdmpropertiesPackage.WS_SERVICE_CONFIGURATION_ITEM__WS_SERVICE_CONFIGURATION:
                setWsServiceConfiguration((WSServiceConfigurationE)null);
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
            case MdmpropertiesPackage.WS_SERVICE_CONFIGURATION_ITEM__WS_SERVICE_CONFIGURATION:
                return wsServiceConfiguration != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsServiceConfiguration();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsServiceConfiguration((WSServiceConfigurationE) serverObj);
    }
} // WsServiceConfigurationItemImpl
