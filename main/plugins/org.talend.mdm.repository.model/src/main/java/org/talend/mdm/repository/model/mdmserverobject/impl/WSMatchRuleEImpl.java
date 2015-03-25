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

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSMatchRuleE;
import org.talend.mdm.repository.model.mdmserverobject.WSMatchRulePKE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Match Rule E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMatchRuleEImpl#getConfigurationXmlContent <em>Configuration Xml Content</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMatchRuleEImpl#getPK <em>PK</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSMatchRuleEImpl extends MDMServerObjectImpl implements WSMatchRuleE {
    /**
     * The default value of the '{@link #getConfigurationXmlContent() <em>Configuration Xml Content</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfigurationXmlContent()
     * @generated
     * @ordered
     */
    protected static final String CONFIGURATION_XML_CONTENT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConfigurationXmlContent() <em>Configuration Xml Content</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfigurationXmlContent()
     * @generated
     * @ordered
     */
    protected String configurationXmlContent = CONFIGURATION_XML_CONTENT_EDEFAULT;

    /**
     * The cached value of the '{@link #getPK() <em>PK</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPK()
     * @generated
     * @ordered
     */
    protected WSMatchRulePKE pk;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSMatchRuleEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_MATCH_RULE_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getConfigurationXmlContent() {
        return configurationXmlContent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConfigurationXmlContent(String newConfigurationXmlContent) {
        String oldConfigurationXmlContent = configurationXmlContent;
        configurationXmlContent = newConfigurationXmlContent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_MATCH_RULE_E__CONFIGURATION_XML_CONTENT, oldConfigurationXmlContent, configurationXmlContent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSMatchRulePKE getPK() {
        return pk;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPK(WSMatchRulePKE newPK, NotificationChain msgs) {
        WSMatchRulePKE oldPK = pk;
        pk = newPK;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_MATCH_RULE_E__PK, oldPK, newPK);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPK(WSMatchRulePKE newPK) {
        if (newPK != pk) {
            NotificationChain msgs = null;
            if (pk != null)
                msgs = ((InternalEObject)pk).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_MATCH_RULE_E__PK, null, msgs);
            if (newPK != null)
                msgs = ((InternalEObject)newPK).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_MATCH_RULE_E__PK, null, msgs);
            msgs = basicSetPK(newPK, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_MATCH_RULE_E__PK, newPK, newPK));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_MATCH_RULE_E__PK:
                return basicSetPK(null, msgs);
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
            case MdmserverobjectPackage.WS_MATCH_RULE_E__CONFIGURATION_XML_CONTENT:
                return getConfigurationXmlContent();
            case MdmserverobjectPackage.WS_MATCH_RULE_E__PK:
                return getPK();
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
            case MdmserverobjectPackage.WS_MATCH_RULE_E__CONFIGURATION_XML_CONTENT:
                setConfigurationXmlContent((String)newValue);
                return;
            case MdmserverobjectPackage.WS_MATCH_RULE_E__PK:
                setPK((WSMatchRulePKE)newValue);
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
            case MdmserverobjectPackage.WS_MATCH_RULE_E__CONFIGURATION_XML_CONTENT:
                setConfigurationXmlContent(CONFIGURATION_XML_CONTENT_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_MATCH_RULE_E__PK:
                setPK((WSMatchRulePKE)null);
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
            case MdmserverobjectPackage.WS_MATCH_RULE_E__CONFIGURATION_XML_CONTENT:
                return CONFIGURATION_XML_CONTENT_EDEFAULT == null ? configurationXmlContent != null : !CONFIGURATION_XML_CONTENT_EDEFAULT.equals(configurationXmlContent);
            case MdmserverobjectPackage.WS_MATCH_RULE_E__PK:
                return pk != null;
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
        result.append(" (configurationXmlContent: ");
        result.append(configurationXmlContent);
        result.append(')');
        return result.toString();
    }

} //WSMatchRuleEImpl
