/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Role Specification Instance E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationInstanceEImpl#getInstanceName <em>Instance Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationInstanceEImpl#isWritable <em>Writable</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleSpecificationInstanceEImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSRoleSpecificationInstanceEImpl extends EObjectImpl implements WSRoleSpecificationInstanceE {
    /**
     * The default value of the '{@link #getInstanceName() <em>Instance Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceName()
     * @generated
     * @ordered
     */
    protected static final String INSTANCE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInstanceName() <em>Instance Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceName()
     * @generated
     * @ordered
     */
    protected String instanceName = INSTANCE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #isWritable() <em>Writable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isWritable()
     * @generated
     * @ordered
     */
    protected static final boolean WRITABLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isWritable() <em>Writable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isWritable()
     * @generated
     * @ordered
     */
    protected boolean writable = WRITABLE_EDEFAULT;

    /**
     * The cached value of the '{@link #getParameter() <em>Parameter</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameter()
     * @generated
     * @ordered
     */
    protected EList<String> parameter;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSRoleSpecificationInstanceEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_ROLE_SPECIFICATION_INSTANCE_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInstanceName() {
        return instanceName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInstanceName(String newInstanceName) {
        String oldInstanceName = instanceName;
        instanceName = newInstanceName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__INSTANCE_NAME, oldInstanceName, instanceName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isWritable() {
        return writable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWritable(boolean newWritable) {
        boolean oldWritable = writable;
        writable = newWritable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__WRITABLE, oldWritable, writable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getParameter() {
        if (parameter == null) {
            parameter = new EDataTypeUniqueEList<String>(String.class, this, MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__PARAMETER);
        }
        return parameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__INSTANCE_NAME:
                return getInstanceName();
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__WRITABLE:
                return isWritable();
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__PARAMETER:
                return getParameter();
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
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__INSTANCE_NAME:
                setInstanceName((String)newValue);
                return;
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__WRITABLE:
                setWritable((Boolean)newValue);
                return;
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__PARAMETER:
                getParameter().clear();
                getParameter().addAll((Collection<? extends String>)newValue);
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
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__INSTANCE_NAME:
                setInstanceName(INSTANCE_NAME_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__WRITABLE:
                setWritable(WRITABLE_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__PARAMETER:
                getParameter().clear();
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
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__INSTANCE_NAME:
                return INSTANCE_NAME_EDEFAULT == null ? instanceName != null : !INSTANCE_NAME_EDEFAULT.equals(instanceName);
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__WRITABLE:
                return writable != WRITABLE_EDEFAULT;
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E__PARAMETER:
                return parameter != null && !parameter.isEmpty();
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
        result.append(" (instanceName: ");
        result.append(instanceName);
        result.append(", writable: ");
        result.append(writable);
        result.append(", parameter: ");
        result.append(parameter);
        result.append(')');
        return result.toString();
    }

} //WSRoleSpecificationInstanceEImpl
