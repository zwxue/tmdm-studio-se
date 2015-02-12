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
import org.talend.mdm.repository.model.mdmproperties.WsWorkflowItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsWorkflowE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Workflow Item</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsWorkflowItemImpl#getWsWorkflow <em>Ws Workflow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsWorkflowItemImpl extends MDMServerObjectItemImpl implements WsWorkflowItem {

    /**
     * The cached value of the '{@link #getWsWorkflow() <em>Ws Workflow</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getWsWorkflow()
     * @generated
     * @ordered
     */
    protected WsWorkflowE wsWorkflow;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsWorkflowItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_WORKFLOW_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public WsWorkflowE getWsWorkflow() {
        if (wsWorkflow != null && wsWorkflow.eIsProxy()) {
            InternalEObject oldWsWorkflow = (InternalEObject) wsWorkflow;
            wsWorkflow = (WsWorkflowE) eResolveProxy(oldWsWorkflow);
            if (wsWorkflow.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsWorkflow);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WsWorkflowE) {
                        wsWorkflow = (WsWorkflowE) object;
                        break;
                    }
                }
            }
            if (wsWorkflow != oldWsWorkflow) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_WORKFLOW_ITEM__WS_WORKFLOW,
                            oldWsWorkflow, wsWorkflow));
                }
            }
        }
        return wsWorkflow;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsWorkflowE basicGetWsWorkflow() {
        return wsWorkflow;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWsWorkflow(WsWorkflowE newWsWorkflow) {
        WsWorkflowE oldWsWorkflow = wsWorkflow;
        wsWorkflow = newWsWorkflow;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_WORKFLOW_ITEM__WS_WORKFLOW,
                    oldWsWorkflow, wsWorkflow));
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
        case MdmpropertiesPackage.WS_WORKFLOW_ITEM__WS_WORKFLOW:
            if (resolve) {
                return getWsWorkflow();
            }
            return basicGetWsWorkflow();
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
        case MdmpropertiesPackage.WS_WORKFLOW_ITEM__WS_WORKFLOW:
            setWsWorkflow((WsWorkflowE) newValue);
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
        case MdmpropertiesPackage.WS_WORKFLOW_ITEM__WS_WORKFLOW:
            setWsWorkflow((WsWorkflowE) null);
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
        case MdmpropertiesPackage.WS_WORKFLOW_ITEM__WS_WORKFLOW:
            return wsWorkflow != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsWorkflow();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsWorkflow((WsWorkflowE) serverObj);
    }
} // WsWorkflowItemImpl
