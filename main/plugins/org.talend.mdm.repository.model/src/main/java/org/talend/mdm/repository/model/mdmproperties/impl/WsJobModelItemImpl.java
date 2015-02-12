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
import org.talend.mdm.repository.model.mdmproperties.WsJobModelItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsJobModelE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Job Model Item</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsJobModelItemImpl#getWsJobModelItem <em>Ws Job Model
 * Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsJobModelItemImpl extends MDMServerObjectItemImpl implements WsJobModelItem {

    /**
     * The cached value of the '{@link #getWsJobModelItem() <em>Ws Job Model Item</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getWsJobModelItem()
     * @generated
     * @ordered
     */
    protected WsJobModelE wsJobModelItem;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsJobModelItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_JOB_MODEL_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public WsJobModelE getWsJobModelItem() {
        if (wsJobModelItem != null && wsJobModelItem.eIsProxy()) {
            InternalEObject oldWsJobModelItem = (InternalEObject) wsJobModelItem;
            wsJobModelItem = (WsJobModelE) eResolveProxy(oldWsJobModelItem);
            if (wsJobModelItem.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsJobModelItem);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WsJobModelE) {
                        wsJobModelItem = (WsJobModelE) object;
                        break;
                    }
                }
            }
            if (wsJobModelItem != oldWsJobModelItem) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM, oldWsJobModelItem, wsJobModelItem));
                }
            }
        }
        return wsJobModelItem;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsJobModelE basicGetWsJobModelItem() {
        return wsJobModelItem;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWsJobModelItem(WsJobModelE newWsJobModelItem) {
        WsJobModelE oldWsJobModelItem = wsJobModelItem;
        wsJobModelItem = newWsJobModelItem;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM,
                    oldWsJobModelItem, wsJobModelItem));
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
        case MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM:
            if (resolve) {
                return getWsJobModelItem();
            }
            return basicGetWsJobModelItem();
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
        case MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM:
            setWsJobModelItem((WsJobModelE) newValue);
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
        case MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM:
            setWsJobModelItem((WsJobModelE) null);
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
        case MdmpropertiesPackage.WS_JOB_MODEL_ITEM__WS_JOB_MODEL_ITEM:
            return wsJobModelItem != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsJobModelItem();
    }
} // WsJobModelItemImpl
