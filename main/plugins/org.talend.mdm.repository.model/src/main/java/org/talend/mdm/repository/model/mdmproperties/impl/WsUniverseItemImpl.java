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
import org.talend.mdm.repository.model.mdmproperties.WsUniverseItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsUniverseE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Universe Item</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsUniverseItemImpl#getWsUniverse <em>Ws Universe</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsUniverseItemImpl extends MDMServerObjectItemImpl implements WsUniverseItem {

    /**
     * The cached value of the '{@link #getWsUniverse() <em>Ws Universe</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getWsUniverse()
     * @generated
     * @ordered
     */
    protected WsUniverseE wsUniverse;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsUniverseItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_UNIVERSE_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public WsUniverseE getWsUniverse() {
        if (wsUniverse != null && wsUniverse.eIsProxy()) {
            InternalEObject oldWsUniverse = (InternalEObject) wsUniverse;
            wsUniverse = (WsUniverseE) eResolveProxy(oldWsUniverse);
            if (wsUniverse.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsUniverse);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WsUniverseE) {
                        wsUniverse = (WsUniverseE) object;
                        break;
                    }
                }
            }
            if (wsUniverse != oldWsUniverse) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_UNIVERSE_ITEM__WS_UNIVERSE,
                            oldWsUniverse, wsUniverse));
                }
            }
        }
        return wsUniverse;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsUniverseE basicGetWsUniverse() {
        return wsUniverse;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWsUniverse(WsUniverseE newWsUniverse) {
        WsUniverseE oldWsUniverse = wsUniverse;
        wsUniverse = newWsUniverse;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_UNIVERSE_ITEM__WS_UNIVERSE,
                    oldWsUniverse, wsUniverse));
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
        case MdmpropertiesPackage.WS_UNIVERSE_ITEM__WS_UNIVERSE:
            if (resolve) {
                return getWsUniverse();
            }
            return basicGetWsUniverse();
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
        case MdmpropertiesPackage.WS_UNIVERSE_ITEM__WS_UNIVERSE:
            setWsUniverse((WsUniverseE) newValue);
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
        case MdmpropertiesPackage.WS_UNIVERSE_ITEM__WS_UNIVERSE:
            setWsUniverse((WsUniverseE) null);
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
        case MdmpropertiesPackage.WS_UNIVERSE_ITEM__WS_UNIVERSE:
            return wsUniverse != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsUniverse();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsUniverse((WsUniverseE) serverObj);
    }
} // WsUniverseItemImpl
