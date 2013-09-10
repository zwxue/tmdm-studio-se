/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSMatchRuleE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Match Rule E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMatchRuleEImpl#getConfigurationXmlContent <em>Configuration Xml Content</em>}</li>
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
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_MATCH_RULE_E__CONFIGURATION_XML_CONTENT:
                return getConfigurationXmlContent();
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
