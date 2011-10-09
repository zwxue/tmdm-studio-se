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
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MDM Server Def Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.MDMServerDefItemImpl#getServerDef <em>Server Def</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MDMServerDefItemImpl extends MDMItemImpl implements MDMServerDefItem {
	/**
     * The cached value of the '{@link #getServerDef() <em>Server Def</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getServerDef()
     * @generated
     * @ordered
     */
	protected MDMServerDef serverDef;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected MDMServerDefItemImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.MDM_SERVER_DEF_ITEM;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MDMServerDef getServerDef() {
        if (serverDef != null && serverDef.eIsProxy()) {
            InternalEObject oldServerDef = (InternalEObject)serverDef;
            serverDef = (MDMServerDef)eResolveProxy(oldServerDef);
            if (serverDef != oldServerDef) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.MDM_SERVER_DEF_ITEM__SERVER_DEF, oldServerDef, serverDef));
            }
        }
        return serverDef;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MDMServerDef basicGetServerDef() {
        return serverDef;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setServerDef(MDMServerDef newServerDef) {
        MDMServerDef oldServerDef = serverDef;
        serverDef = newServerDef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.MDM_SERVER_DEF_ITEM__SERVER_DEF, oldServerDef, serverDef));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.MDM_SERVER_DEF_ITEM__SERVER_DEF:
                if (resolve) return getServerDef();
                return basicGetServerDef();
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
            case MdmpropertiesPackage.MDM_SERVER_DEF_ITEM__SERVER_DEF:
                setServerDef((MDMServerDef)newValue);
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
            case MdmpropertiesPackage.MDM_SERVER_DEF_ITEM__SERVER_DEF:
                setServerDef((MDMServerDef)null);
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
            case MdmpropertiesPackage.MDM_SERVER_DEF_ITEM__SERVER_DEF:
                return serverDef != null;
        }
        return super.eIsSet(featureID);
    }

} //MDMServerDefItemImpl
