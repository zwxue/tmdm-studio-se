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
import org.talend.mdm.repository.model.mdmproperties.WSCustomFormItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSCustomFormE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>WS Custom Form Item</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WSCustomFormItemImpl#getCustomForm <em>Custom Form</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSCustomFormItemImpl extends MDMServerObjectItemImpl implements WSCustomFormItem {

    /**
     * The cached value of the '{@link #getCustomForm() <em>Custom Form</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getCustomForm()
     * @generated
     * @ordered
     */
    protected WSCustomFormE customForm;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected WSCustomFormItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WS_CUSTOM_FORM_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public WSCustomFormE getCustomForm() {
        if (customForm != null && customForm.eIsProxy()) {
            InternalEObject oldCustomForm = (InternalEObject) customForm;
            customForm = (WSCustomFormE) eResolveProxy(oldCustomForm);

            if (customForm != oldCustomForm) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM, oldCustomForm, customForm));
            }
        }
        if (customForm.eResource() == null && eResource() != null) {
            URI uri = EcoreUtil.getURI(customForm);
            if (uri.hasFragment()) {
                uri = uri.trimFragment();
            }
            Resource resource = eResource().getResourceSet().getResource(uri, true);
            for (EObject object : resource.getContents()) {
                if (object instanceof WSCustomFormE) {
                    customForm = (WSCustomFormE) object;
                    break;
                }
            }
        }
        return customForm;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public WSCustomFormE basicGetCustomForm() {
        return customForm;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setCustomForm(WSCustomFormE newCustomForm) {
        WSCustomFormE oldCustomForm = customForm;
        customForm = newCustomForm;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM, oldCustomForm, customForm));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM:
                if (resolve) return getCustomForm();
                return basicGetCustomForm();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM:
                setCustomForm((WSCustomFormE)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM:
                setCustomForm((WSCustomFormE)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM:
                return customForm != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject getMDMServerObject() {
        return getCustomForm();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setCustomForm((WSCustomFormE) serverObj);
    }

} // WSCustomFormItemImpl
