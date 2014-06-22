/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleExpressionE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleOperatorE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Routing Rule Expression E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleExpressionEImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleExpressionEImpl#getXpath <em>Xpath</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleExpressionEImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleExpressionEImpl#getWsOperator <em>Ws Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSRoutingRuleExpressionEImpl extends EObjectImpl implements WSRoutingRuleExpressionE {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getXpath() <em>Xpath</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXpath()
     * @generated
     * @ordered
     */
    protected static final String XPATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getXpath() <em>Xpath</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXpath()
     * @generated
     * @ordered
     */
    protected String xpath = XPATH_EDEFAULT;

    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * The cached value of the '{@link #getWsOperator() <em>Ws Operator</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWsOperator()
     * @generated
     * @ordered
     */
    protected WSRoutingRuleOperatorE wsOperator;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSRoutingRuleExpressionEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_ROUTING_RULE_EXPRESSION_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setXpath(String newXpath) {
        String oldXpath = xpath;
        xpath = newXpath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__XPATH, oldXpath, xpath));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__VALUE, oldValue, value));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoutingRuleOperatorE getWsOperator() {
        return wsOperator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetWsOperator(WSRoutingRuleOperatorE newWsOperator, NotificationChain msgs) {
        WSRoutingRuleOperatorE oldWsOperator = wsOperator;
        wsOperator = newWsOperator;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR, oldWsOperator, newWsOperator);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWsOperator(WSRoutingRuleOperatorE newWsOperator) {
        if (newWsOperator != wsOperator) {
            NotificationChain msgs = null;
            if (wsOperator != null)
                msgs = ((InternalEObject)wsOperator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR, null, msgs);
            if (newWsOperator != null)
                msgs = ((InternalEObject)newWsOperator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR, null, msgs);
            msgs = basicSetWsOperator(newWsOperator, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR, newWsOperator, newWsOperator));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR:
                return basicSetWsOperator(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__NAME:
                return getName();
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__XPATH:
                return getXpath();
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__VALUE:
                return getValue();
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR:
                return getWsOperator();
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
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__NAME:
                setName((String)newValue);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__XPATH:
                setXpath((String)newValue);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__VALUE:
                setValue((String)newValue);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR:
                setWsOperator((WSRoutingRuleOperatorE)newValue);
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
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__NAME:
                setName(NAME_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__XPATH:
                setXpath(XPATH_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__VALUE:
                setValue(VALUE_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR:
                setWsOperator((WSRoutingRuleOperatorE)null);
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
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__XPATH:
                return XPATH_EDEFAULT == null ? xpath != null : !XPATH_EDEFAULT.equals(xpath);
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
            case MdmserverobjectPackage.WS_ROUTING_RULE_EXPRESSION_E__WS_OPERATOR:
                return wsOperator != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", xpath: ");
        result.append(xpath);
        result.append(", value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} //WSRoutingRuleExpressionEImpl
