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
import org.talend.mdm.repository.model.mdmproperties.WsSynchronizationPlanItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsSynchronizationPlanE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Synchronization Plan Item</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsSynchronizationPlanItemImpl#getWsSynchronizationPlan
 * <em>Ws Synchronization Plan</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsSynchronizationPlanItemImpl extends MDMServerObjectItemImpl implements WsSynchronizationPlanItem {

    /**
     * The cached value of the '{@link #getWsSynchronizationPlan() <em>Ws Synchronization Plan</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getWsSynchronizationPlan()
     * @generated
     * @ordered
     */
    protected WsSynchronizationPlanE wsSynchronizationPlan;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsSynchronizationPlanItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_SYNCHRONIZATION_PLAN_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public WsSynchronizationPlanE getWsSynchronizationPlan() {
        if (wsSynchronizationPlan != null && wsSynchronizationPlan.eIsProxy()) {
            InternalEObject oldWsSynchronizationPlan = (InternalEObject) wsSynchronizationPlan;
            wsSynchronizationPlan = (WsSynchronizationPlanE) eResolveProxy(oldWsSynchronizationPlan);
            if (wsSynchronizationPlan.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsSynchronizationPlan);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WsSynchronizationPlanE) {
                        wsSynchronizationPlan = (WsSynchronizationPlanE) object;
                        break;
                    }
                }
            }
            if (wsSynchronizationPlan != oldWsSynchronizationPlan) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            MdmpropertiesPackage.WS_SYNCHRONIZATION_PLAN_ITEM__WS_SYNCHRONIZATION_PLAN, oldWsSynchronizationPlan,
                            wsSynchronizationPlan));
                }
            }
        }
        return wsSynchronizationPlan;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsSynchronizationPlanE basicGetWsSynchronizationPlan() {
        return wsSynchronizationPlan;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWsSynchronizationPlan(WsSynchronizationPlanE newWsSynchronizationPlan) {
        WsSynchronizationPlanE oldWsSynchronizationPlan = wsSynchronizationPlan;
        wsSynchronizationPlan = newWsSynchronizationPlan;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    MdmpropertiesPackage.WS_SYNCHRONIZATION_PLAN_ITEM__WS_SYNCHRONIZATION_PLAN, oldWsSynchronizationPlan,
                    wsSynchronizationPlan));
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
        case MdmpropertiesPackage.WS_SYNCHRONIZATION_PLAN_ITEM__WS_SYNCHRONIZATION_PLAN:
            if (resolve) {
                return getWsSynchronizationPlan();
            }
            return basicGetWsSynchronizationPlan();
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
        case MdmpropertiesPackage.WS_SYNCHRONIZATION_PLAN_ITEM__WS_SYNCHRONIZATION_PLAN:
            setWsSynchronizationPlan((WsSynchronizationPlanE) newValue);
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
        case MdmpropertiesPackage.WS_SYNCHRONIZATION_PLAN_ITEM__WS_SYNCHRONIZATION_PLAN:
            setWsSynchronizationPlan((WsSynchronizationPlanE) null);
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
        case MdmpropertiesPackage.WS_SYNCHRONIZATION_PLAN_ITEM__WS_SYNCHRONIZATION_PLAN:
            return wsSynchronizationPlan != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsSynchronizationPlan();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsSynchronizationPlan((WsSynchronizationPlanE) serverObj);
    }
} // WsSynchronizationPlanItemImpl
