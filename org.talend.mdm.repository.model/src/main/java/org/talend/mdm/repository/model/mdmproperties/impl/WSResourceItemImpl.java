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
import org.talend.mdm.repository.model.mdmproperties.WSResourceItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSResourceE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Resource Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSResourceItemImpl#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSResourceItemImpl extends MDMServerObjectItemImpl implements WSResourceItem {
    /**
     * The cached value of the '{@link #getResource() <em>Resource</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResource()
     * @generated
     * @ordered
     */
    protected WSResourceE resource;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSResourceItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
    public WSResourceE getResource() {
        if (resource != null && resource.eIsProxy()) {
            InternalEObject oldResource = (InternalEObject)resource;
            resource = (WSResourceE)eResolveProxy(oldResource);
            if (resource.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(resource);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource res = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : res.getContents()) {
                    if (object instanceof WSResourceE) {
                        resource = (WSResourceE) object;
                        break;
                    }
                }
            }
            if (resource != oldResource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_RESOURCE_ITEM__RESOURCE, oldResource, resource));
            }
        }
        return resource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSResourceE basicGetResource() {
        return resource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResource(WSResourceE newResource) {
        WSResourceE oldResource = resource;
        resource = newResource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_RESOURCE_ITEM__RESOURCE, oldResource, resource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_RESOURCE_ITEM__RESOURCE:
                if (resolve) return getResource();
                return basicGetResource();
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
            case MdmpropertiesPackage.WS_RESOURCE_ITEM__RESOURCE:
                setResource((WSResourceE)newValue);
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
            case MdmpropertiesPackage.WS_RESOURCE_ITEM__RESOURCE:
                setResource((WSResourceE)null);
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
        setResource((WSResourceE) serverObj);
    }

} //WSResourceItemImpl
