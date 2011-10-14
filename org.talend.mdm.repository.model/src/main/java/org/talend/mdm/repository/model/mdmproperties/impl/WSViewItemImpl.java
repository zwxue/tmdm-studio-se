/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;
import org.talend.mdm.repository.model.mdmproperties.WSViewItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSViewE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>WS View Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSViewItemImpl#getWsView <em>Ws View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSViewItemImpl extends MDMServerObjectItemImpl implements WSViewItem {

    /**
     * The cached value of the '{@link #getWsView() <em>Ws View</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getWsView()
     * @generated
     * @ordered
     */
    protected WSViewE wsView;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected WSViewItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_VIEW_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public WSViewE getWsView() {
        if (wsView != null && wsView.eIsProxy()) {
            InternalEObject oldWsView = (InternalEObject)wsView;
            wsView = (WSViewE)eResolveProxy(oldWsView);
            if (wsView != oldWsView) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_VIEW_ITEM__WS_VIEW, oldWsView, wsView));
            }
        }
        return wsView;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public WSViewE basicGetWsView() {
        return wsView;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setWsView(WSViewE newWsView) {
        WSViewE oldWsView = wsView;
        wsView = newWsView;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_VIEW_ITEM__WS_VIEW, oldWsView, wsView));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_VIEW_ITEM__WS_VIEW:
                if (resolve) return getWsView();
                return basicGetWsView();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_VIEW_ITEM__WS_VIEW:
                setWsView((WSViewE)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_VIEW_ITEM__WS_VIEW:
                setWsView((WSViewE)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_VIEW_ITEM__WS_VIEW:
                return wsView != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject getMDMServerObject() {
        return getWsView();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsView((WSViewE) serverObj);
    }
} // WSViewItemImpl
