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
import org.talend.mdm.repository.model.mdmproperties.WsCustomFormItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WsCustomFormE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Custom Form Item</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WsCustomFormItemImpl#getCustomForm <em>Custom Form
 * </em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsCustomFormItemImpl extends MDMServerObjectItemImpl implements WsCustomFormItem {

    /**
     * The cached value of the '{@link #getCustomForm() <em>Custom Form</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getCustomForm()
     * @generated
     * @ordered
     */
    protected WsCustomFormE customForm;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsCustomFormItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
    @Override
    public WsCustomFormE getCustomForm() {
        if (customForm != null && customForm.eIsProxy()) {
            InternalEObject oldCustomForm = (InternalEObject) customForm;
            customForm = (WsCustomFormE) eResolveProxy(oldCustomForm);

            if (customForm.eResource() == null && eResource() != null) {
                URI uri = EcoreUtil.getURI(customForm);
                if (uri.hasFragment()) {
                    uri = uri.trimFragment();
                }
                Resource resource = eResource().getResourceSet().getResource(uri, true);
                for (EObject object : resource.getContents()) {
                    if (object instanceof WsCustomFormE) {
                        customForm = (WsCustomFormE) object;
                        break;
                    }
                }
            }
            if (customForm != oldCustomForm) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM, oldCustomForm, customForm));
                }
            }
        }
        return customForm;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WsCustomFormE basicGetCustomForm() {
        return customForm;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCustomForm(WsCustomFormE newCustomForm) {
        WsCustomFormE oldCustomForm = customForm;
        customForm = newCustomForm;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM,
                    oldCustomForm, customForm));
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
        case MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM:
            if (resolve) {
                return getCustomForm();
            }
            return basicGetCustomForm();
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
        case MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM:
            setCustomForm((WsCustomFormE) newValue);
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
        case MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM:
            setCustomForm((WsCustomFormE) null);
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
        case MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM__CUSTOM_FORM:
            return customForm != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public MDMServerObject doGetMDMServerObject() {
        return getCustomForm();
    }

    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        setCustomForm((WsCustomFormE) serverObj);
    }

} // WsCustomFormItemImpl
