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
import org.talend.mdm.repository.model.mdmproperties.WsEventManagerItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsEventManagerE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Event Manager Item</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsEventManagerItemImpl#getWsEventManager <em>Ws Event
 * Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsEventManagerItemImpl extends MDMServerObjectItemImpl implements WsEventManagerItem {

    /**
     * The cached value of the '{@link #getWsEventManager() <em>Ws Event Manager</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getWsEventManager()
     * @generated
     * @ordered
     */
    protected WsEventManagerE wsEventManager;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsEventManagerItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_EVENT_MANAGER_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public WsEventManagerE getWsEventManager() {
        if (wsEventManager != null && wsEventManager.eIsProxy()) {
            InternalEObject oldWsEventManager = (InternalEObject) wsEventManager;
            wsEventManager = (WsEventManagerE) eResolveProxy(oldWsEventManager);
            if (wsEventManager.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsEventManager);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WsEventManagerE) {
                        wsEventManager = (WsEventManagerE) object;
                        break;
                    }
                }
            }
            if (wsEventManager != oldWsEventManager) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER, oldWsEventManager, wsEventManager));
                }
            }
        }
        return wsEventManager;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsEventManagerE basicGetWsEventManager() {
        return wsEventManager;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWsEventManager(WsEventManagerE newWsEventManager) {
        WsEventManagerE oldWsEventManager = wsEventManager;
        wsEventManager = newWsEventManager;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER,
                    oldWsEventManager, wsEventManager));
        }
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsEventManager((WsEventManagerE) serverObj);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER:
            if (resolve) {
                return getWsEventManager();
            }
            return basicGetWsEventManager();
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
        case MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER:
            setWsEventManager((WsEventManagerE) newValue);
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
        case MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER:
            setWsEventManager((WsEventManagerE) null);
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
        case MdmpropertiesPackage.WS_EVENT_MANAGER_ITEM__WS_EVENT_MANAGER:
            return wsEventManager != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsEventManager();
    }

} // WsEventManagerItemImpl
