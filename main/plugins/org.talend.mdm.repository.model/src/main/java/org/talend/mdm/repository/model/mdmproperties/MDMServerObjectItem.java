/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MDM Server Object Item</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getMDMServerObjectItem()
 * @model
 * @generated
 */
public interface MDMServerObjectItem extends MDMItem {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    MDMServerObject getMDMServerObject();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void setMDMServerObject(MDMServerObject serverObj);

} // MDMServerObjectItem
