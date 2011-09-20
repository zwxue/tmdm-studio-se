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

import org.talend.mdm.repository.model.mdmserverobject.CustomForm;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Form</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.CustomFormImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.CustomFormImpl#getDataModelName <em>Data Model Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.CustomFormImpl#getEntityName <em>Entity Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomFormImpl extends MDMServerObjectImpl implements CustomForm {
    /**
     * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilename()
     * @generated
     * @ordered
     */
    protected static final String FILENAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilename()
     * @generated
     * @ordered
     */
    protected String filename = FILENAME_EDEFAULT;

    /**
     * The default value of the '{@link #getDataModelName() <em>Data Model Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataModelName()
     * @generated
     * @ordered
     */
    protected static final String DATA_MODEL_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDataModelName() <em>Data Model Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataModelName()
     * @generated
     * @ordered
     */
    protected String dataModelName = DATA_MODEL_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntityName()
     * @generated
     * @ordered
     */
    protected static final String ENTITY_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntityName()
     * @generated
     * @ordered
     */
    protected String entityName = ENTITY_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CustomFormImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.CUSTOM_FORM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFilename() {
        return filename;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFilename(String newFilename) {
        String oldFilename = filename;
        filename = newFilename;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.CUSTOM_FORM__FILENAME, oldFilename, filename));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDataModelName() {
        return dataModelName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataModelName(String newDataModelName) {
        String oldDataModelName = dataModelName;
        dataModelName = newDataModelName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.CUSTOM_FORM__DATA_MODEL_NAME, oldDataModelName, dataModelName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEntityName(String newEntityName) {
        String oldEntityName = entityName;
        entityName = newEntityName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.CUSTOM_FORM__ENTITY_NAME, oldEntityName, entityName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.CUSTOM_FORM__FILENAME:
                return getFilename();
            case MdmserverobjectPackage.CUSTOM_FORM__DATA_MODEL_NAME:
                return getDataModelName();
            case MdmserverobjectPackage.CUSTOM_FORM__ENTITY_NAME:
                return getEntityName();
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
            case MdmserverobjectPackage.CUSTOM_FORM__FILENAME:
                setFilename((String)newValue);
                return;
            case MdmserverobjectPackage.CUSTOM_FORM__DATA_MODEL_NAME:
                setDataModelName((String)newValue);
                return;
            case MdmserverobjectPackage.CUSTOM_FORM__ENTITY_NAME:
                setEntityName((String)newValue);
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
            case MdmserverobjectPackage.CUSTOM_FORM__FILENAME:
                setFilename(FILENAME_EDEFAULT);
                return;
            case MdmserverobjectPackage.CUSTOM_FORM__DATA_MODEL_NAME:
                setDataModelName(DATA_MODEL_NAME_EDEFAULT);
                return;
            case MdmserverobjectPackage.CUSTOM_FORM__ENTITY_NAME:
                setEntityName(ENTITY_NAME_EDEFAULT);
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
            case MdmserverobjectPackage.CUSTOM_FORM__FILENAME:
                return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
            case MdmserverobjectPackage.CUSTOM_FORM__DATA_MODEL_NAME:
                return DATA_MODEL_NAME_EDEFAULT == null ? dataModelName != null : !DATA_MODEL_NAME_EDEFAULT.equals(dataModelName);
            case MdmserverobjectPackage.CUSTOM_FORM__ENTITY_NAME:
                return ENTITY_NAME_EDEFAULT == null ? entityName != null : !ENTITY_NAME_EDEFAULT.equals(entityName);
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
        result.append(" (filename: ");
        result.append(filename);
        result.append(", dataModelName: ");
        result.append(dataModelName);
        result.append(", entityName: ");
        result.append(entityName);
        result.append(')');
        return result.toString();
    }

} //CustomFormImpl
