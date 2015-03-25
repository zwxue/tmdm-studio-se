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
import org.talend.mdm.repository.model.mdmproperties.WSMatchRuleItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSMatchRuleE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Match Rule Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSMatchRuleItemImpl#getMdmMatchRule <em>Mdm Match Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSMatchRuleItemImpl extends MDMServerObjectItemImpl implements WSMatchRuleItem {
    /**
     * The cached value of the '{@link #getMdmMatchRule() <em>Mdm Match Rule</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMdmMatchRule()
     * @generated
     * @ordered
     */
    protected WSMatchRuleE mdmMatchRule;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSMatchRuleItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_MATCH_RULE_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public WSMatchRuleE getMdmMatchRule() {
        if (mdmMatchRule != null && mdmMatchRule.eIsProxy()) {
            InternalEObject oldMdmMatchRule = (InternalEObject)mdmMatchRule;
            mdmMatchRule = (WSMatchRuleE)eResolveProxy(oldMdmMatchRule);
            if (mdmMatchRule != oldMdmMatchRule) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.WS_MATCH_RULE_ITEM__MDM_MATCH_RULE, oldMdmMatchRule, mdmMatchRule));
                }
            }
        }
        return mdmMatchRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSMatchRuleE basicGetMdmMatchRule() {
        return mdmMatchRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMdmMatchRule(WSMatchRuleE newMdmMatchRule) {
        WSMatchRuleE oldMdmMatchRule = mdmMatchRule;
        mdmMatchRule = newMdmMatchRule;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_MATCH_RULE_ITEM__MDM_MATCH_RULE, oldMdmMatchRule, mdmMatchRule));
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
            case MdmpropertiesPackage.WS_MATCH_RULE_ITEM__MDM_MATCH_RULE:
                if (resolve) {
                    return getMdmMatchRule();
                }
                return basicGetMdmMatchRule();
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
            case MdmpropertiesPackage.WS_MATCH_RULE_ITEM__MDM_MATCH_RULE:
                setMdmMatchRule((WSMatchRuleE)newValue);
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
            case MdmpropertiesPackage.WS_MATCH_RULE_ITEM__MDM_MATCH_RULE:
                setMdmMatchRule((WSMatchRuleE)null);
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
            case MdmpropertiesPackage.WS_MATCH_RULE_ITEM__MDM_MATCH_RULE:
                return mdmMatchRule != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getMdmMatchRule();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setMdmMatchRule((WSMatchRuleE) serverObj);
    }

} // WsMatchRuleItemImpl
