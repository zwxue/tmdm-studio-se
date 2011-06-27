/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.talend.core.model.repository.ERepositoryObjectType;

import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.ContainerType;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.ContainerItemImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.ContainerItemImpl#getRepObjType <em>Rep Obj Type</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.ContainerItemImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainerItemImpl extends MDMItemImpl implements ContainerItem {
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
     * The default value of the '{@link #getRepObjType() <em>Rep Obj Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRepObjType()
     * @generated
     * @ordered
     */
    protected static final ERepositoryObjectType REP_OBJ_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRepObjType() <em>Rep Obj Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRepObjType()
     * @generated
     * @ordered
     */
    protected ERepositoryObjectType repObjType = REP_OBJ_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final ContainerType TYPE_EDEFAULT = ContainerType.CATEGORY;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected ContainerType type = TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ContainerItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.CONTAINER_ITEM;
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
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.CONTAINER_ITEM__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ERepositoryObjectType getRepObjType() {
        return repObjType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRepObjType(ERepositoryObjectType newRepObjType) {
        ERepositoryObjectType oldRepObjType = repObjType;
        repObjType = newRepObjType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.CONTAINER_ITEM__REP_OBJ_TYPE, oldRepObjType, repObjType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContainerType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(ContainerType newType) {
        ContainerType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.CONTAINER_ITEM__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.CONTAINER_ITEM__LABEL:
                return getLabel();
            case MdmpropertiesPackage.CONTAINER_ITEM__REP_OBJ_TYPE:
                return getRepObjType();
            case MdmpropertiesPackage.CONTAINER_ITEM__TYPE:
                return getType();
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
            case MdmpropertiesPackage.CONTAINER_ITEM__LABEL:
                setLabel((String)newValue);
                return;
            case MdmpropertiesPackage.CONTAINER_ITEM__REP_OBJ_TYPE:
                setRepObjType((ERepositoryObjectType)newValue);
                return;
            case MdmpropertiesPackage.CONTAINER_ITEM__TYPE:
                setType((ContainerType)newValue);
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
            case MdmpropertiesPackage.CONTAINER_ITEM__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case MdmpropertiesPackage.CONTAINER_ITEM__REP_OBJ_TYPE:
                setRepObjType(REP_OBJ_TYPE_EDEFAULT);
                return;
            case MdmpropertiesPackage.CONTAINER_ITEM__TYPE:
                setType(TYPE_EDEFAULT);
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
            case MdmpropertiesPackage.CONTAINER_ITEM__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case MdmpropertiesPackage.CONTAINER_ITEM__REP_OBJ_TYPE:
                return REP_OBJ_TYPE_EDEFAULT == null ? repObjType != null : !REP_OBJ_TYPE_EDEFAULT.equals(repObjType);
            case MdmpropertiesPackage.CONTAINER_ITEM__TYPE:
                return type != TYPE_EDEFAULT;
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
        result.append(" (label: ");
        result.append(label);
        result.append(", repObjType: ");
        result.append(repObjType);
        result.append(", type: ");
        result.append(type);
        result.append(')');
        return result.toString();
    }

} //ContainerItemImpl
