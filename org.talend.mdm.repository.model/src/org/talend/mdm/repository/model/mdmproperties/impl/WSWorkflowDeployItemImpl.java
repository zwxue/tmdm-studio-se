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
import org.talend.mdm.repository.model.mdmproperties.WSWorkflowDeployItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSWorkflowDeployE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>WS Workflow Deploy Item</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSWorkflowDeployItemImpl#getWsWorkflowDeploy <em>Ws
 * Workflow Deploy</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class WSWorkflowDeployItemImpl extends MDMServerObjectItemImpl implements WSWorkflowDeployItem {

    /**
     * The cached value of the '{@link #getWsWorkflowDeploy() <em>Ws Workflow Deploy</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getWsWorkflowDeploy()
     * @generated
     * @ordered
     */
    protected WSWorkflowDeployE wsWorkflowDeploy;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WSWorkflowDeployItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_WORKFLOW_DEPLOY_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WSWorkflowDeployE getWsWorkflowDeploy() {
        if (wsWorkflowDeploy != null && wsWorkflowDeploy.eIsProxy()) {
            InternalEObject oldWsWorkflowDeploy = (InternalEObject) wsWorkflowDeploy;
            wsWorkflowDeploy = (WSWorkflowDeployE) eResolveProxy(oldWsWorkflowDeploy);
            if (wsWorkflowDeploy != oldWsWorkflowDeploy) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            MdmpropertiesPackage.WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY, oldWsWorkflowDeploy,
                            wsWorkflowDeploy));
            }
        }
        return wsWorkflowDeploy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WSWorkflowDeployE basicGetWsWorkflowDeploy() {
        return wsWorkflowDeploy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setWsWorkflowDeploy(WSWorkflowDeployE newWsWorkflowDeploy) {
        WSWorkflowDeployE oldWsWorkflowDeploy = wsWorkflowDeploy;
        wsWorkflowDeploy = newWsWorkflowDeploy;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    MdmpropertiesPackage.WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY, oldWsWorkflowDeploy, wsWorkflowDeploy));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case MdmpropertiesPackage.WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY:
            if (resolve)
                return getWsWorkflowDeploy();
            return basicGetWsWorkflowDeploy();
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
        case MdmpropertiesPackage.WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY:
            setWsWorkflowDeploy((WSWorkflowDeployE) newValue);
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
        case MdmpropertiesPackage.WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY:
            setWsWorkflowDeploy((WSWorkflowDeployE) null);
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
        case MdmpropertiesPackage.WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY:
            return wsWorkflowDeploy != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject getMDMServerObject() {
        return getWsWorkflowDeploy();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsWorkflowDeploy((WSWorkflowDeployE) serverObj);
    }
} // WSWorkflowDeployItemImpl
