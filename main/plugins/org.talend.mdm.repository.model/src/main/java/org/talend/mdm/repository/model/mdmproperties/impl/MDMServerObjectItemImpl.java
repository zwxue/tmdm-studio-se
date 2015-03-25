/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import org.eclipse.emf.ecore.EClass;

import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;

import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MDM Server Object Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MDMServerObjectItemImpl extends MDMItemImpl implements MDMServerObjectItem {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MDMServerObjectItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.MDM_SERVER_OBJECT_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MDMServerObject getMDMServerObject() {
        synchronized (MDMServerObjectItem.class) {
            return doGetMDMServerObject();
        }
    }

    public MDMServerObject doGetMDMServerObject() {
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMDMServerObject(MDMServerObject serverObj) {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

} //MDMServerObjectItemImpl
