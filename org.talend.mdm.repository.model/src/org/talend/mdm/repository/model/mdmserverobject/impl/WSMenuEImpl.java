/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuE;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Menu E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSMenuEImpl#getMenuEntries <em>Menu Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSMenuEImpl extends MDMServerObjectImpl implements WSMenuE {
    /**
     * The cached value of the '{@link #getMenuEntries() <em>Menu Entries</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMenuEntries()
     * @generated
     * @ordered
     */
    protected EList<WSMenuEntryE> menuEntries;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSMenuEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_MENU_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WSMenuEntryE> getMenuEntries() {
        if (menuEntries == null) {
            menuEntries = new EObjectContainmentEList<WSMenuEntryE>(WSMenuEntryE.class, this, MdmserverobjectPackage.WS_MENU_E__MENU_ENTRIES);
        }
        return menuEntries;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_MENU_E__MENU_ENTRIES:
                return ((InternalEList<?>)getMenuEntries()).basicRemove(otherEnd, msgs);
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
            case MdmserverobjectPackage.WS_MENU_E__MENU_ENTRIES:
                return getMenuEntries();
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
            case MdmserverobjectPackage.WS_MENU_E__MENU_ENTRIES:
                getMenuEntries().clear();
                getMenuEntries().addAll((Collection<? extends WSMenuEntryE>)newValue);
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
            case MdmserverobjectPackage.WS_MENU_E__MENU_ENTRIES:
                getMenuEntries().clear();
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
            case MdmserverobjectPackage.WS_MENU_E__MENU_ENTRIES:
                return menuEntries != null && !menuEntries.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //WSMenuEImpl
