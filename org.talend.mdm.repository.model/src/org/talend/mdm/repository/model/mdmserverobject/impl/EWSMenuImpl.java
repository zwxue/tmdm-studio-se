/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.talend.mdm.repository.model.mdmserverobject.EWSMenu;
import org.talend.mdm.repository.model.mdmserverobject.EWSMenuEntry;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EWS Menu</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.EWSMenuImpl#getMenuEntries <em>Menu Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EWSMenuImpl extends MDMServerObjectImpl implements EWSMenu {
    /**
     * The cached value of the '{@link #getMenuEntries() <em>Menu Entries</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMenuEntries()
     * @generated
     * @ordered
     */
    protected EList<EWSMenuEntry> menuEntries;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EWSMenuImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.EWS_MENU;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EWSMenuEntry> getMenuEntries() {
        if (menuEntries == null) {
            menuEntries = new EObjectResolvingEList<EWSMenuEntry>(EWSMenuEntry.class, this, MdmserverobjectPackage.EWS_MENU__MENU_ENTRIES);
        }
        return menuEntries;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.EWS_MENU__MENU_ENTRIES:
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
            case MdmserverobjectPackage.EWS_MENU__MENU_ENTRIES:
                getMenuEntries().clear();
                getMenuEntries().addAll((Collection<? extends EWSMenuEntry>)newValue);
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
            case MdmserverobjectPackage.EWS_MENU__MENU_ENTRIES:
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
            case MdmserverobjectPackage.EWS_MENU__MENU_ENTRIES:
                return menuEntries != null && !menuEntries.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //EWSMenuImpl
