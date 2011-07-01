/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;
import org.talend.mdm.repository.model.mdmproperties.WSMenuItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Menu Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSMenuItemImpl#getWsMenu <em>Ws Menu</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSMenuItemImpl extends MDMServerObjectItemImpl implements WSMenuItem {
    /**
     * The cached value of the '{@link #getWsMenu() <em>Ws Menu</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWsMenu()
     * @generated
     * @ordered
     */
    protected WSMenuE wsMenu;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSMenuItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_MENU_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSMenuE getWsMenu() {
        if (wsMenu != null && wsMenu.eIsProxy()) {
            InternalEObject oldWsMenu = (InternalEObject)wsMenu;
            wsMenu = (WSMenuE)eResolveProxy(oldWsMenu);
            if (wsMenu != oldWsMenu) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU, oldWsMenu, wsMenu));
            }
        }
        return wsMenu;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSMenuE basicGetWsMenu() {
        return wsMenu;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWsMenu(WSMenuE newWsMenu) {
        WSMenuE oldWsMenu = wsMenu;
        wsMenu = newWsMenu;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU, oldWsMenu, wsMenu));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU:
                if (resolve) return getWsMenu();
                return basicGetWsMenu();
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
            case MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU:
                setWsMenu((WSMenuE)newValue);
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
            case MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU:
                setWsMenu((WSMenuE)null);
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
            case MdmpropertiesPackage.WS_MENU_ITEM__WS_MENU:
                return wsMenu != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject getMDMServerObject() {
        return getWsMenu();
    }

} //WSMenuItemImpl
