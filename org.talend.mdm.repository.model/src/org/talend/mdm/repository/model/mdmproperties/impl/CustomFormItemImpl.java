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

import org.talend.mdm.repository.model.mdmproperties.CustomFormItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;

import org.talend.mdm.repository.model.mdmserverobject.CustomForm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Form Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.CustomFormItemImpl#getCustomForm <em>Custom Form</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomFormItemImpl extends MDMServerObjectItemImpl implements CustomFormItem {
    /**
     * The cached value of the '{@link #getCustomForm() <em>Custom Form</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomForm()
     * @generated
     * @ordered
     */
    protected CustomForm customForm;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CustomFormItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.CUSTOM_FORM_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomForm getCustomForm() {
        if (customForm != null && customForm.eIsProxy()) {
            InternalEObject oldCustomForm = (InternalEObject)customForm;
            customForm = (CustomForm)eResolveProxy(oldCustomForm);
            if (customForm != oldCustomForm) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdmpropertiesPackage.CUSTOM_FORM_ITEM__CUSTOM_FORM, oldCustomForm, customForm));
            }
        }
        return customForm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomForm basicGetCustomForm() {
        return customForm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCustomForm(CustomForm newCustomForm) {
        CustomForm oldCustomForm = customForm;
        customForm = newCustomForm;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.CUSTOM_FORM_ITEM__CUSTOM_FORM, oldCustomForm, customForm));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.CUSTOM_FORM_ITEM__CUSTOM_FORM:
                if (resolve) return getCustomForm();
                return basicGetCustomForm();
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
            case MdmpropertiesPackage.CUSTOM_FORM_ITEM__CUSTOM_FORM:
                setCustomForm((CustomForm)newValue);
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
            case MdmpropertiesPackage.CUSTOM_FORM_ITEM__CUSTOM_FORM:
                setCustomForm((CustomForm)null);
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
            case MdmpropertiesPackage.CUSTOM_FORM_ITEM__CUSTOM_FORM:
                return customForm != null;
        }
        return super.eIsSet(featureID);
    }

} //CustomFormItemImpl
