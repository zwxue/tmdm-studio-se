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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Menu Menu Entries Descriptions E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuMenuEntriesDescriptionsEImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuMenuEntriesDescriptionsEImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSMenuMenuEntriesDescriptionsEImpl extends EObjectImpl implements WSMenuMenuEntriesDescriptionsE {
    /**
     * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLanguage()
     * @generated
     * @ordered
     */
    protected static final String LANGUAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLanguage()
     * @generated
     * @ordered
     */
    protected String language = LANGUAGE_EDEFAULT;

    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSMenuMenuEntriesDescriptionsEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLanguage() {
        return language;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLanguage(String newLanguage) {
        String oldLanguage = language;
        language = newLanguage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LANGUAGE, oldLanguage, language));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLabel() {
        return label;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabel(String newLabel) {
        String oldLabel = label;
        label = newLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LANGUAGE:
                return getLanguage();
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LABEL:
                return getLabel();
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
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LANGUAGE:
                setLanguage((String)newValue);
                return;
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LABEL:
                setLabel((String)newValue);
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
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LANGUAGE:
                setLanguage(LANGUAGE_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LABEL:
                setLabel(LABEL_EDEFAULT);
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
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LANGUAGE:
                return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
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
        result.append(" (language: ");
        result.append(language);
        result.append(", label: ");
        result.append(label);
        result.append(')');
        return result.toString();
    }

} //WSMenuMenuEntriesDescriptionsEImpl
