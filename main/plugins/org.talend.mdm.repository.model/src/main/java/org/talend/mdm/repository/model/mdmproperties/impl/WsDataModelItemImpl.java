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
import org.talend.mdm.repository.model.mdmproperties.WsDataModelItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsDataModelE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Data Model Item</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsDataModelItemImpl#getWsDataModel <em>Ws Data Model
 * </em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsDataModelItemImpl extends MDMServerObjectItemImpl implements WsDataModelItem {

    /**
     * The cached value of the '{@link #getWsDataModel() <em>Ws Data Model</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getWsDataModel()
     * @generated
     * @ordered
     */
    protected WsDataModelE wsDataModel;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsDataModelItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_DATA_MODEL_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public WsDataModelE getWsDataModel() {
        if (wsDataModel != null && wsDataModel.eIsProxy()) {
            InternalEObject oldWsDataModel = (InternalEObject) wsDataModel;
            wsDataModel = (WsDataModelE) eResolveProxy(oldWsDataModel);
            if (wsDataModel.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsDataModel);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WsDataModelE) {
                        wsDataModel = (WsDataModelE) object;
                        break;
                    }
                }
            }
            if (wsDataModel != oldWsDataModel) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            MdmpropertiesPackage.WS_DATA_MODEL_ITEM__WS_DATA_MODEL, oldWsDataModel, wsDataModel));
                }
            }
        }
        return wsDataModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsDataModelE basicGetWsDataModel() {
        return wsDataModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWsDataModel(WsDataModelE newWsDataModel) {
        WsDataModelE oldWsDataModel = wsDataModel;
        wsDataModel = newWsDataModel;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_DATA_MODEL_ITEM__WS_DATA_MODEL,
                    oldWsDataModel, wsDataModel));
        }
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsDataModel((WsDataModelE) serverObj);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case MdmpropertiesPackage.WS_DATA_MODEL_ITEM__WS_DATA_MODEL:
            if (resolve) {
                return getWsDataModel();
            }
            return basicGetWsDataModel();
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
        case MdmpropertiesPackage.WS_DATA_MODEL_ITEM__WS_DATA_MODEL:
            setWsDataModel((WsDataModelE) newValue);
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
        case MdmpropertiesPackage.WS_DATA_MODEL_ITEM__WS_DATA_MODEL:
            setWsDataModel((WsDataModelE) null);
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
        case MdmpropertiesPackage.WS_DATA_MODEL_ITEM__WS_DATA_MODEL:
            return wsDataModel != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsDataModel();
    }

} // WsDataModelItemImpl
