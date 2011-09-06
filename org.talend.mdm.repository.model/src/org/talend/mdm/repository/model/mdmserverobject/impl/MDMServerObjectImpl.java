/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>MDM Server Object</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.MDMServerObjectImpl#getName <em>Name</em>}</li>
 * <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.MDMServerObjectImpl#getDescription <em>Description
 * </em>}</li>
 * <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.MDMServerObjectImpl#isSystem <em>System</em>}</li>
 * <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.MDMServerObjectImpl#getLastServerDef <em>Last Server
 * Def</em>}</li>
 * <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.MDMServerObjectImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MDMServerObjectImpl extends EObjectImpl implements MDMServerObject {

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #isSystem() <em>System</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #isSystem()
     * @generated
     * @ordered
     */
    protected static final boolean SYSTEM_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isSystem() <em>System</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #isSystem()
     * @generated
     * @ordered
     */
    protected boolean system = SYSTEM_EDEFAULT;

    /**
     * The cached value of the '{@link #getLastServerDef() <em>Last Server Def</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLastServerDef()
     * @generated
     * @ordered
     */
    protected MDMServerDef lastServerDef;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final int TYPE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected int type = TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #isChanged() <em>Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isChanged()
     * @generated
     * @ordered
     */
    protected static final boolean CHANGED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isChanged() <em>Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isChanged()
     * @generated
     * @ordered
     */
    protected boolean changed = CHANGED_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected MDMServerObjectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.MDM_SERVER_OBJECT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.MDM_SERVER_OBJECT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.MDM_SERVER_OBJECT__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean isSystem() {
        return system;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setSystem(boolean newSystem) {
        boolean oldSystem = system;
        system = newSystem;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.MDM_SERVER_OBJECT__SYSTEM, oldSystem, system));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public MDMServerDef getLastServerDef() {
        return lastServerDef;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLastServerDef(MDMServerDef newLastServerDef, NotificationChain msgs) {
        MDMServerDef oldLastServerDef = lastServerDef;
        lastServerDef = newLastServerDef;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.MDM_SERVER_OBJECT__LAST_SERVER_DEF, oldLastServerDef, newLastServerDef);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void setLastServerDef(MDMServerDef newLastServerDef) {

        if (newLastServerDef != lastServerDef) {
            if (newLastServerDef != null) {
                newLastServerDef = EcoreUtil.copy(newLastServerDef);
            }
            NotificationChain msgs = null;
            if (lastServerDef != null)
                msgs = ((InternalEObject) lastServerDef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - MdmserverobjectPackage.MDM_SERVER_OBJECT__LAST_SERVER_DEF, null, msgs);
            if (newLastServerDef != null)
                msgs = ((InternalEObject) newLastServerDef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - MdmserverobjectPackage.MDM_SERVER_OBJECT__LAST_SERVER_DEF, null, msgs);
            msgs = basicSetLastServerDef(newLastServerDef, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.MDM_SERVER_OBJECT__LAST_SERVER_DEF,
                    newLastServerDef, newLastServerDef));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public int getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setType(int newType) {
        int oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.MDM_SERVER_OBJECT__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isChanged() {
        return changed;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setChanged(boolean newChanged) {
        boolean oldChanged = changed;
        changed = newChanged;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.MDM_SERVER_OBJECT__CHANGED, oldChanged, changed));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getUniqueName() {
        return getName();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__LAST_SERVER_DEF:
                return basicSetLastServerDef(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__NAME:
                return getName();
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__DESCRIPTION:
                return getDescription();
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__SYSTEM:
                return isSystem();
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__LAST_SERVER_DEF:
                return getLastServerDef();
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__TYPE:
                return getType();
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__CHANGED:
                return isChanged();
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
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__NAME:
                setName((String)newValue);
                return;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__SYSTEM:
                setSystem((Boolean)newValue);
                return;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__LAST_SERVER_DEF:
                setLastServerDef((MDMServerDef)newValue);
                return;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__TYPE:
                setType((Integer)newValue);
                return;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__CHANGED:
                setChanged((Boolean)newValue);
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
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__SYSTEM:
                setSystem(SYSTEM_EDEFAULT);
                return;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__LAST_SERVER_DEF:
                setLastServerDef((MDMServerDef)null);
                return;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__CHANGED:
                setChanged(CHANGED_EDEFAULT);
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
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__SYSTEM:
                return system != SYSTEM_EDEFAULT;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__LAST_SERVER_DEF:
                return lastServerDef != null;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__TYPE:
                return type != TYPE_EDEFAULT;
            case MdmserverobjectPackage.MDM_SERVER_OBJECT__CHANGED:
                return changed != CHANGED_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", description: ");
        result.append(description);
        result.append(", system: ");
        result.append(system);
        result.append(", type: ");
        result.append(type);
        result.append(", changed: ");
        result.append(changed);
        result.append(')');
        return result.toString();
    }

} // MDMServerObjectImpl
