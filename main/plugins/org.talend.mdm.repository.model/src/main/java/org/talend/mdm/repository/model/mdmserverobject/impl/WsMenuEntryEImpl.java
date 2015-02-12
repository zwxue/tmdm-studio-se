/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE;
import org.talend.mdm.repository.model.mdmserverobject.WsMenuMenuEntriesDescriptionsE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ws Menu Entry E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEntryEImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEntryEImpl#getApplication <em>Application</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEntryEImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEntryEImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEntryEImpl#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsMenuEntryEImpl#getSubMenus <em>Sub Menus</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsMenuEntryEImpl extends EObjectImpl implements WsMenuEntryE {
    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getApplication() <em>Application</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getApplication()
     * @generated
     * @ordered
     */
    protected static final String APPLICATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getApplication() <em>Application</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getApplication()
     * @generated
     * @ordered
     */
    protected String application = APPLICATION_EDEFAULT;

    /**
     * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContext()
     * @generated
     * @ordered
     */
    protected static final String CONTEXT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContext() <em>Context</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContext()
     * @generated
     * @ordered
     */
    protected String context = CONTEXT_EDEFAULT;

    /**
     * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIcon()
     * @generated
     * @ordered
     */
    protected static final String ICON_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIcon()
     * @generated
     * @ordered
     */
    protected String icon = ICON_EDEFAULT;

    /**
     * The cached value of the '{@link #getDescriptions() <em>Descriptions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescriptions()
     * @generated
     * @ordered
     */
    protected EList<WsMenuMenuEntriesDescriptionsE> descriptions;

    /**
     * The cached value of the '{@link #getSubMenus() <em>Sub Menus</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubMenus()
     * @generated
     * @ordered
     */
    protected EList<WsMenuEntryE> subMenus;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WsMenuEntryEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_MENU_ENTRY_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(String newId) {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_MENU_ENTRY_E__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getApplication() {
        return application;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setApplication(String newApplication) {
        String oldApplication = application;
        application = newApplication;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_MENU_ENTRY_E__APPLICATION, oldApplication, application));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getContext() {
        return context;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContext(String newContext) {
        String oldContext = context;
        context = newContext;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_MENU_ENTRY_E__CONTEXT, oldContext, context));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getIcon() {
        return icon;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIcon(String newIcon) {
        String oldIcon = icon;
        icon = newIcon;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_MENU_ENTRY_E__ICON, oldIcon, icon));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WsMenuMenuEntriesDescriptionsE> getDescriptions() {
        if (descriptions == null) {
            descriptions = new EObjectContainmentEList<WsMenuMenuEntriesDescriptionsE>(WsMenuMenuEntriesDescriptionsE.class, this, MdmserverobjectPackage.WS_MENU_ENTRY_E__DESCRIPTIONS);
        }
        return descriptions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WsMenuEntryE> getSubMenus() {
        if (subMenus == null) {
            subMenus = new EObjectContainmentEList<WsMenuEntryE>(WsMenuEntryE.class, this, MdmserverobjectPackage.WS_MENU_ENTRY_E__SUB_MENUS);
        }
        return subMenus;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__DESCRIPTIONS:
                return ((InternalEList<?>)getDescriptions()).basicRemove(otherEnd, msgs);
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__SUB_MENUS:
                return ((InternalEList<?>)getSubMenus()).basicRemove(otherEnd, msgs);
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
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__ID:
                return getId();
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__APPLICATION:
                return getApplication();
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__CONTEXT:
                return getContext();
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__ICON:
                return getIcon();
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__DESCRIPTIONS:
                return getDescriptions();
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__SUB_MENUS:
                return getSubMenus();
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
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__ID:
                setId((String)newValue);
                return;
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__APPLICATION:
                setApplication((String)newValue);
                return;
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__CONTEXT:
                setContext((String)newValue);
                return;
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__ICON:
                setIcon((String)newValue);
                return;
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__DESCRIPTIONS:
                getDescriptions().clear();
                getDescriptions().addAll((Collection<? extends WsMenuMenuEntriesDescriptionsE>)newValue);
                return;
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__SUB_MENUS:
                getSubMenus().clear();
                getSubMenus().addAll((Collection<? extends WsMenuEntryE>)newValue);
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
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__ID:
                setId(ID_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__APPLICATION:
                setApplication(APPLICATION_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__CONTEXT:
                setContext(CONTEXT_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__ICON:
                setIcon(ICON_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__DESCRIPTIONS:
                getDescriptions().clear();
                return;
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__SUB_MENUS:
                getSubMenus().clear();
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
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__APPLICATION:
                return APPLICATION_EDEFAULT == null ? application != null : !APPLICATION_EDEFAULT.equals(application);
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__CONTEXT:
                return CONTEXT_EDEFAULT == null ? context != null : !CONTEXT_EDEFAULT.equals(context);
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__ICON:
                return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__DESCRIPTIONS:
                return descriptions != null && !descriptions.isEmpty();
            case MdmserverobjectPackage.WS_MENU_ENTRY_E__SUB_MENUS:
                return subMenus != null && !subMenus.isEmpty();
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
        result.append(" (id: ");
        result.append(id);
        result.append(", application: ");
        result.append(application);
        result.append(", context: ");
        result.append(context);
        result.append(", icon: ");
        result.append(icon);
        result.append(')');
        return result.toString();
    }

} //WsMenuEntryEImpl
