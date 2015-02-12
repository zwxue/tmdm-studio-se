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
import org.talend.mdm.repository.model.mdmproperties.WsMenuItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsMenuE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Menu Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsMenuItemImpl#getWsMenu <em>Ws Menu</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsMenuItemImpl extends MDMServerObjectItemImpl implements WsMenuItem {

    /**
     * The cached value of the '{@link #getWsMenu() <em>Ws Menu</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getWsMenu()
     * @generated
     * @ordered
     */
    protected WsMenuE wsMenu;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsMenuItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_MENU_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public WsMenuE getWsMenu() {
        if (wsMenu != null && wsMenu.eIsProxy()) {
            InternalEObject oldWsMenu = (InternalEObject) wsMenu;
            wsMenu = (WsMenuE) eResolveProxy(oldWsMenu);
            if (wsMenu.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsMenu);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WsMenuE) {
                        wsMenu = (WsMenuE) object;
                        break;
                    }
                }
            }
            if (wsMenu != oldWsMenu) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU,
                            oldWsMenu, wsMenu));
                }
            }
        }
        return wsMenu;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsMenuE basicGetWsMenu() {
        return wsMenu;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWsMenu(WsMenuE newWsMenu) {
        WsMenuE oldWsMenu = wsMenu;
        wsMenu = newWsMenu;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU, oldWsMenu, wsMenu));
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
        case MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU:
            if (resolve) {
                return getWsMenu();
            }
            return basicGetWsMenu();
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
        case MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU:
            setWsMenu((WsMenuE) newValue);
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
        case MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU:
            setWsMenu((WsMenuE) null);
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
        case MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU:
            return wsMenu != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsMenu();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsMenu((WsMenuE) serverObj);
    }

} // WsMenuItemImpl
