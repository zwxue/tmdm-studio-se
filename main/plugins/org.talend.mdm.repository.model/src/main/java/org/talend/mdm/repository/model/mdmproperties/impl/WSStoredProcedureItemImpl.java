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
import org.talend.mdm.repository.model.mdmproperties.WSStoredProcedureItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSStoredProcedureE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Stored Procedure Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSStoredProcedureItemImpl#getWsStoredProcedure <em>Ws Stored Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSStoredProcedureItemImpl extends MDMServerObjectItemImpl implements WSStoredProcedureItem {
    /**
     * The cached value of the '{@link #getWsStoredProcedure() <em>Ws Stored Procedure</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWsStoredProcedure()
     * @generated
     * @ordered
     */
    protected WSStoredProcedureE wsStoredProcedure;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSStoredProcedureItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_STORED_PROCEDURE_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public WSStoredProcedureE getWsStoredProcedure() {
        if (wsStoredProcedure != null && wsStoredProcedure.eIsProxy()) {
            InternalEObject oldWsStoredProcedure = (InternalEObject)wsStoredProcedure;
            wsStoredProcedure = (WSStoredProcedureE)eResolveProxy(oldWsStoredProcedure);
            if (wsStoredProcedure.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsStoredProcedure);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WSStoredProcedureE) {
                        wsStoredProcedure = (WSStoredProcedureE) object;
                        break;
                    }
                }
            }
            if (wsStoredProcedure != oldWsStoredProcedure) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_STORED_PROCEDURE_ITEM__WS_STORED_PROCEDURE, oldWsStoredProcedure, wsStoredProcedure));
                }
            }
        }
        return wsStoredProcedure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSStoredProcedureE basicGetWsStoredProcedure() {
        return wsStoredProcedure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setWsStoredProcedure(WSStoredProcedureE newWsStoredProcedure) {
        WSStoredProcedureE oldWsStoredProcedure = wsStoredProcedure;
        wsStoredProcedure = newWsStoredProcedure;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_STORED_PROCEDURE_ITEM__WS_STORED_PROCEDURE, oldWsStoredProcedure, wsStoredProcedure));
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
            case MdmpropertiesPackage.WS_STORED_PROCEDURE_ITEM__WS_STORED_PROCEDURE:
                if (resolve) {
                    return getWsStoredProcedure();
                }
                return basicGetWsStoredProcedure();
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
            case MdmpropertiesPackage.WS_STORED_PROCEDURE_ITEM__WS_STORED_PROCEDURE:
                setWsStoredProcedure((WSStoredProcedureE)newValue);
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
            case MdmpropertiesPackage.WS_STORED_PROCEDURE_ITEM__WS_STORED_PROCEDURE:
                setWsStoredProcedure((WSStoredProcedureE)null);
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
            case MdmpropertiesPackage.WS_STORED_PROCEDURE_ITEM__WS_STORED_PROCEDURE:
                return wsStoredProcedure != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsStoredProcedure();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsStoredProcedure((WSStoredProcedureE) serverObj);
    }
} // WsStoredProcedureItemImpl
