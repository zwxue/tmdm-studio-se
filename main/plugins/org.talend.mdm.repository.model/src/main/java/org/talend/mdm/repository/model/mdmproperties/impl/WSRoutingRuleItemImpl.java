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
import org.talend.mdm.repository.model.mdmproperties.WSRoutingRuleItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Routing Rule Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSRoutingRuleItemImpl#getWsRoutingRule <em>Ws Routing Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSRoutingRuleItemImpl extends MDMServerObjectItemImpl implements WSRoutingRuleItem {
    /**
     * The cached value of the '{@link #getWsRoutingRule() <em>Ws Routing Rule</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWsRoutingRule()
     * @generated
     * @ordered
     */
    protected WSRoutingRuleE wsRoutingRule;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSRoutingRuleItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_ROUTING_RULE_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public WSRoutingRuleE getWsRoutingRule() {
        if (wsRoutingRule != null && wsRoutingRule.eIsProxy()) {
            InternalEObject oldWsRoutingRule = (InternalEObject)wsRoutingRule;
            wsRoutingRule = (WSRoutingRuleE)eResolveProxy(oldWsRoutingRule);
            if (wsRoutingRule.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(wsRoutingRule);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WSRoutingRuleE) {
                        wsRoutingRule = (WSRoutingRuleE) object;
                        break;
                    }
                }
            }
            if (wsRoutingRule != oldWsRoutingRule) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_ROUTING_RULE_ITEM__WS_ROUTING_RULE, oldWsRoutingRule, wsRoutingRule));
                }
            }
        }
        return wsRoutingRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoutingRuleE basicGetWsRoutingRule() {
        return wsRoutingRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setWsRoutingRule(WSRoutingRuleE newWsRoutingRule) {
        WSRoutingRuleE oldWsRoutingRule = wsRoutingRule;
        wsRoutingRule = newWsRoutingRule;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_ROUTING_RULE_ITEM__WS_ROUTING_RULE, oldWsRoutingRule, wsRoutingRule));
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
            case MdmpropertiesPackage.WS_ROUTING_RULE_ITEM__WS_ROUTING_RULE:
                if (resolve) {
                    return getWsRoutingRule();
                }
                return basicGetWsRoutingRule();
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
            case MdmpropertiesPackage.WS_ROUTING_RULE_ITEM__WS_ROUTING_RULE:
                setWsRoutingRule((WSRoutingRuleE)newValue);
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
            case MdmpropertiesPackage.WS_ROUTING_RULE_ITEM__WS_ROUTING_RULE:
                setWsRoutingRule((WSRoutingRuleE)null);
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
            case MdmpropertiesPackage.WS_ROUTING_RULE_ITEM__WS_ROUTING_RULE:
                return wsRoutingRule != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getWsRoutingRule();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setWsRoutingRule((WSRoutingRuleE) serverObj);
    }
} // WsRoutingRuleItemImpl
