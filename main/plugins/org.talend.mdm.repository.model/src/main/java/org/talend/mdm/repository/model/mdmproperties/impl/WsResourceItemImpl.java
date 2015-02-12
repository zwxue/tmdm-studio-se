/**
 * <copyright> </copyright>
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
import org.talend.mdm.repository.model.mdmproperties.WsResourceItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsResourceE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Resource Item</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsResourceItemImpl#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsResourceItemImpl extends MDMServerObjectItemImpl implements WsResourceItem {

    /**
     * The cached value of the '{@link #getResource() <em>Resource</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getResource()
     * @generated
     * @ordered
     */
    protected WsResourceE resource;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsResourceItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_RESOURCE_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public WsResourceE getResource() {
        if (resource != null && resource.eIsProxy()) {
            InternalEObject oldResource = (InternalEObject) resource;
            resource = (WsResourceE) eResolveProxy(oldResource);
            if (resource.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(resource);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource res = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : res.getContents()) {
                    if (object instanceof WsResourceE) {
                        resource = (WsResourceE) object;
                        break;
                    }
                }
            }
            if (resource != oldResource) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_RESOURCE_ITEM__RESOURCE,
                            oldResource, resource));
                }
            }
        }
        return resource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsResourceE basicGetResource() {
        return resource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResource(WsResourceE newResource) {
        WsResourceE oldResource = resource;
        resource = newResource;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_RESOURCE_ITEM__RESOURCE, oldResource,
                    resource));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case MdmpropertiesPackage.WS_RESOURCE_ITEM__RESOURCE:
            if (resolve) {
                return getResource();
            }
            return basicGetResource();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case MdmpropertiesPackage.WS_RESOURCE_ITEM__RESOURCE:
            setResource((WsResourceE) newValue);
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
        case MdmpropertiesPackage.WS_RESOURCE_ITEM__RESOURCE:
            setResource((WsResourceE) null);
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
        case MdmpropertiesPackage.WS_RESOURCE_ITEM__RESOURCE:
            return resource != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getResource();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setResource((WsResourceE) serverObj);
    }
} // WsResourceItemImpl
