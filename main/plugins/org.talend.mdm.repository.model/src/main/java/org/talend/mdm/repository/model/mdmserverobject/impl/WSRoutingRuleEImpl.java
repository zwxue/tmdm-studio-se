/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleExpressionE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoutingRuleExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Routing Rule E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleEImpl#isSynchronous <em>Synchronous</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleEImpl#getConcept <em>Concept</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleEImpl#getServiceJNDI <em>Service JNDI</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleEImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleEImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleEImpl#isDeactive <em>Deactive</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleEImpl#getExecuteOrder <em>Execute Order</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoutingRuleEImpl#getWsRoutingRuleExpressions <em>Ws Routing Rule Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSRoutingRuleEImpl extends MDMServerObjectImpl implements WSRoutingRuleE {
    /**
     * The default value of the '{@link #isSynchronous() <em>Synchronous</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSynchronous()
     * @generated
     * @ordered
     */
    protected static final boolean SYNCHRONOUS_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isSynchronous() <em>Synchronous</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSynchronous()
     * @generated
     * @ordered
     */
    protected boolean synchronous = SYNCHRONOUS_EDEFAULT;

    /**
     * The default value of the '{@link #getConcept() <em>Concept</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConcept()
     * @generated
     * @ordered
     */
    protected static final String CONCEPT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConcept() <em>Concept</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConcept()
     * @generated
     * @ordered
     */
    protected String concept = CONCEPT_EDEFAULT;

    /**
     * The default value of the '{@link #getServiceJNDI() <em>Service JNDI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceJNDI()
     * @generated
     * @ordered
     */
    protected static final String SERVICE_JNDI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getServiceJNDI() <em>Service JNDI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceJNDI()
     * @generated
     * @ordered
     */
    protected String serviceJNDI = SERVICE_JNDI_EDEFAULT;

    /**
     * The default value of the '{@link #getParameters() <em>Parameters</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected static final String PARAMETERS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected String parameters = PARAMETERS_EDEFAULT;

    /**
     * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected static final String CONDITION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected String condition = CONDITION_EDEFAULT;

    /**
     * The default value of the '{@link #isDeactive() <em>Deactive</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeactive()
     * @generated
     * @ordered
     */
    protected static final boolean DEACTIVE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDeactive() <em>Deactive</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeactive()
     * @generated
     * @ordered
     */
    protected boolean deactive = DEACTIVE_EDEFAULT;

    /**
     * The default value of the '{@link #getExecuteOrder() <em>Execute Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExecuteOrder()
     * @generated
     * @ordered
     */
    protected static final int EXECUTE_ORDER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getExecuteOrder() <em>Execute Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExecuteOrder()
     * @generated
     * @ordered
     */
    protected int executeOrder = EXECUTE_ORDER_EDEFAULT;

    /**
     * The cached value of the '{@link #getWsRoutingRuleExpressions() <em>Ws Routing Rule Expressions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWsRoutingRuleExpressions()
     * @generated
     * @ordered
     */
    protected EList<WSRoutingRuleExpressionE> wsRoutingRuleExpressions;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSRoutingRuleEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_ROUTING_RULE_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSynchronous() {
        return synchronous;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSynchronous(boolean newSynchronous) {
        boolean oldSynchronous = synchronous;
        synchronous = newSynchronous;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_E__SYNCHRONOUS, oldSynchronous, synchronous));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getConcept() {
        return concept;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConcept(String newConcept) {
        String oldConcept = concept;
        concept = newConcept;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_E__CONCEPT, oldConcept, concept));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getServiceJNDI() {
        return serviceJNDI;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setServiceJNDI(String newServiceJNDI) {
        String oldServiceJNDI = serviceJNDI;
        serviceJNDI = newServiceJNDI;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_E__SERVICE_JNDI, oldServiceJNDI, serviceJNDI));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getParameters() {
        return parameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameters(String newParameters) {
        String oldParameters = parameters;
        parameters = newParameters;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_E__PARAMETERS, oldParameters, parameters));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCondition() {
        return condition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCondition(String newCondition) {
        String oldCondition = condition;
        condition = newCondition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_E__CONDITION, oldCondition, condition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDeactive() {
        return deactive;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeactive(boolean newDeactive) {
        boolean oldDeactive = deactive;
        deactive = newDeactive;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_E__DEACTIVE, oldDeactive, deactive));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getExecuteOrder() {
        return executeOrder;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExecuteOrder(int newExecuteOrder) {
        int oldExecuteOrder = executeOrder;
        executeOrder = newExecuteOrder;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROUTING_RULE_E__EXECUTE_ORDER, oldExecuteOrder, executeOrder));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WSRoutingRuleExpressionE> getWsRoutingRuleExpressions() {
        if (wsRoutingRuleExpressions == null) {
            wsRoutingRuleExpressions = new EObjectContainmentEList<WSRoutingRuleExpressionE>(WSRoutingRuleExpressionE.class, this, MdmserverobjectPackage.WS_ROUTING_RULE_E__WS_ROUTING_RULE_EXPRESSIONS);
        }
        return wsRoutingRuleExpressions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__WS_ROUTING_RULE_EXPRESSIONS:
                return ((InternalEList<?>)getWsRoutingRuleExpressions()).basicRemove(otherEnd, msgs);
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
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__SYNCHRONOUS:
                return isSynchronous();
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__CONCEPT:
                return getConcept();
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__SERVICE_JNDI:
                return getServiceJNDI();
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__PARAMETERS:
                return getParameters();
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__CONDITION:
                return getCondition();
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__DEACTIVE:
                return isDeactive();
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__EXECUTE_ORDER:
                return getExecuteOrder();
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__WS_ROUTING_RULE_EXPRESSIONS:
                return getWsRoutingRuleExpressions();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__SYNCHRONOUS:
                setSynchronous((Boolean)newValue);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__CONCEPT:
                setConcept((String)newValue);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__SERVICE_JNDI:
                setServiceJNDI((String)newValue);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__PARAMETERS:
                setParameters((String)newValue);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__CONDITION:
                setCondition((String)newValue);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__DEACTIVE:
                setDeactive((Boolean)newValue);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__EXECUTE_ORDER:
                setExecuteOrder((Integer)newValue);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__WS_ROUTING_RULE_EXPRESSIONS:
                getWsRoutingRuleExpressions().clear();
                getWsRoutingRuleExpressions().addAll((Collection<? extends WSRoutingRuleExpressionE>)newValue);
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
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__SYNCHRONOUS:
                setSynchronous(SYNCHRONOUS_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__CONCEPT:
                setConcept(CONCEPT_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__SERVICE_JNDI:
                setServiceJNDI(SERVICE_JNDI_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__PARAMETERS:
                setParameters(PARAMETERS_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__CONDITION:
                setCondition(CONDITION_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__DEACTIVE:
                setDeactive(DEACTIVE_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__EXECUTE_ORDER:
                setExecuteOrder(EXECUTE_ORDER_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__WS_ROUTING_RULE_EXPRESSIONS:
                getWsRoutingRuleExpressions().clear();
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
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__SYNCHRONOUS:
                return synchronous != SYNCHRONOUS_EDEFAULT;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__CONCEPT:
                return CONCEPT_EDEFAULT == null ? concept != null : !CONCEPT_EDEFAULT.equals(concept);
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__SERVICE_JNDI:
                return SERVICE_JNDI_EDEFAULT == null ? serviceJNDI != null : !SERVICE_JNDI_EDEFAULT.equals(serviceJNDI);
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__PARAMETERS:
                return PARAMETERS_EDEFAULT == null ? parameters != null : !PARAMETERS_EDEFAULT.equals(parameters);
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__CONDITION:
                return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__DEACTIVE:
                return deactive != DEACTIVE_EDEFAULT;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__EXECUTE_ORDER:
                return executeOrder != EXECUTE_ORDER_EDEFAULT;
            case MdmserverobjectPackage.WS_ROUTING_RULE_E__WS_ROUTING_RULE_EXPRESSIONS:
                return wsRoutingRuleExpressions != null && !wsRoutingRuleExpressions.isEmpty();
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
        result.append(" (synchronous: ");
        result.append(synchronous);
        result.append(", concept: ");
        result.append(concept);
        result.append(", serviceJNDI: ");
        result.append(serviceJNDI);
        result.append(", parameters: ");
        result.append(parameters);
        result.append(", condition: ");
        result.append(condition);
        result.append(", deactive: ");
        result.append(deactive);
        result.append(", executeOrder: ");
        result.append(executeOrder);
        result.append(')');
        return result.toString();
    }

    @Override
    public int getType() {
        return 14;
    }

} //WSRoutingRuleEImpl
