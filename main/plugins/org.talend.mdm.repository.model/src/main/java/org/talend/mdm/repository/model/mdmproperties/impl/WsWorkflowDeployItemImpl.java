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
import org.talend.mdm.repository.model.mdmproperties.WsWorkflowDeployItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsWorkflowDeployE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Workflow Deploy Item</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsWorkflowDeployItemImpl#getWsWorkflowDeploy <em>Ws
 * Workflow Deploy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsWorkflowDeployItemImpl extends MDMServerObjectItemImpl implements WsWorkflowDeployItem {

    /**
     * The cached value of the '{@link #getWsWorkflowDeploy() <em>Ws Workflow Deploy</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getWsWorkflowDeploy()
     * @generated
     * @ordered
     */
    protected WsWorkflowDeployE wsWorkflowDeploy;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsWorkflowDeployItemImpl() {
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
     * @generated not
     */
    @Override
    public WsWorkflowDeployE getWsWorkflowDeploy() {
        if (wsWorkflowDeploy != null && wsWorkflowDeploy.eIsProxy()) {
            InternalEObject oldWsWorkflowDeploy = (InternalEObject) wsWorkflowDeploy;
            wsWorkflowDeploy = (WsWorkflowDeployE) eResolveProxy(oldWsWorkflowDeploy);
            if (wsWorkflowDeploy.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsWorkflowDeploy);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WsWorkflowDeployE) {
                        wsWorkflowDeploy = (WsWorkflowDeployE) object;
                        break;
                    }
                }
            }
            if (wsWorkflowDeploy != oldWsWorkflowDeploy) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            MdmpropertiesPackage.WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY, oldWsWorkflowDeploy,
                            wsWorkflowDeploy));
                }
            }
        }
        return wsWorkflowDeploy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsWorkflowDeployE basicGetWsWorkflowDeploy() {
        return wsWorkflowDeploy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWsWorkflowDeploy(WsWorkflowDeployE newWsWorkflowDeploy) {
        WsWorkflowDeployE oldWsWorkflowDeploy = wsWorkflowDeploy;
        wsWorkflowDeploy = newWsWorkflowDeploy;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    MdmpropertiesPackage.WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY, oldWsWorkflowDeploy, wsWorkflowDeploy));
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
        case MdmpropertiesPackage.WS_WORKFLOW_DEPLOY_ITEM__WS_WORKFLOW_DEPLOY:
            if (resolve) {
                return getWsWorkflowDeploy();
            }
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
            setWsWorkflowDeploy((WsWorkflowDeployE) newValue);
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
            setWsWorkflowDeploy((WsWorkflowDeployE) null);
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
    public MDMServerObject doGetMDMServerObject() {
        return getWsWorkflowDeploy();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsWorkflowDeploy((WsWorkflowDeployE) serverObj);
    }
} // WsWorkflowDeployItemImpl
