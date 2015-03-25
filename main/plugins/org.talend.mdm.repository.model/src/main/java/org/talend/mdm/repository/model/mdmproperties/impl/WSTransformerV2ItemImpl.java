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
import org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerV2E;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Transformer V2 Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSTransformerV2ItemImpl#getWsTransformerV2 <em>Ws Transformer V2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSTransformerV2ItemImpl extends MDMServerObjectItemImpl implements WSTransformerV2Item {
    /**
     * The cached value of the '{@link #getWsTransformerV2() <em>Ws Transformer V2</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWsTransformerV2()
     * @generated
     * @ordered
     */
    protected WSTransformerV2E wsTransformerV2;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSTransformerV2ItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_TRANSFORMER_V2_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public WSTransformerV2E getWsTransformerV2() {
        if (wsTransformerV2 != null && wsTransformerV2.eIsProxy()) {
            InternalEObject oldWsTransformerV2 = (InternalEObject)wsTransformerV2;
            wsTransformerV2 = (WSTransformerV2E)eResolveProxy(oldWsTransformerV2);
            if (wsTransformerV2.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsTransformerV2);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WSTransformerV2E) {
                        wsTransformerV2 = (WSTransformerV2E) object;
                        break;
                    }
                }
            }
            if (wsTransformerV2 != oldWsTransformerV2) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_TRANSFORMER_V2_ITEM__WS_TRANSFORMER_V2, oldWsTransformerV2, wsTransformerV2));
                }
            }
        }
        return wsTransformerV2;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSTransformerV2E basicGetWsTransformerV2() {
        return wsTransformerV2;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setWsTransformerV2(WSTransformerV2E newWsTransformerV2) {
        WSTransformerV2E oldWsTransformerV2 = wsTransformerV2;
        wsTransformerV2 = newWsTransformerV2;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_TRANSFORMER_V2_ITEM__WS_TRANSFORMER_V2, oldWsTransformerV2, wsTransformerV2));
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
            case MdmpropertiesPackage.WS_TRANSFORMER_V2_ITEM__WS_TRANSFORMER_V2:
                if (resolve) {
                    return getWsTransformerV2();
                }
                return basicGetWsTransformerV2();
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
            case MdmpropertiesPackage.WS_TRANSFORMER_V2_ITEM__WS_TRANSFORMER_V2:
                setWsTransformerV2((WSTransformerV2E)newValue);
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
            case MdmpropertiesPackage.WS_TRANSFORMER_V2_ITEM__WS_TRANSFORMER_V2:
                setWsTransformerV2((WSTransformerV2E)null);
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
            case MdmpropertiesPackage.WS_TRANSFORMER_V2_ITEM__WS_TRANSFORMER_V2:
                return wsTransformerV2 != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsTransformerV2();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsTransformerV2((WSTransformerV2E) serverObj);
    }
} // WsTransformerV2ItemImpl
