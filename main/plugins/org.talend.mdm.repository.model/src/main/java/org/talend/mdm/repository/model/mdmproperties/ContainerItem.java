/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.core.model.properties.FolderItem;
import org.talend.core.model.repository.ERepositoryObjectType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getRepObjType <em>Rep Obj Type</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getContainerItem()
 * @model
 * @generated
 */
public interface ContainerItem extends MDMItem, FolderItem {
    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getContainerItem_Label()
     * @model
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel(String value);

    /**
     * Returns the value of the '<em><b>Rep Obj Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rep Obj Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rep Obj Type</em>' attribute.
     * @see #setRepObjType(ERepositoryObjectType)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getContainerItem_RepObjType()
     * @model dataType="org.talend.mdm.repository.model.mdmproperties.ERepositoryObjectType"
     * @generated
     */
    ERepositoryObjectType getRepObjType();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getRepObjType <em>Rep Obj Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rep Obj Type</em>' attribute.
     * @see #getRepObjType()
     * @generated
     */
    void setRepObjType(ERepositoryObjectType value);

    /**
     * Returns the value of the '<em><b>Data</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data</em>' attribute.
     * @see #setData(Object)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getContainerItem_Data()
     * @model transient="true"
     * @generated
     */
    Object getData();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getData <em>Data</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data</em>' attribute.
     * @see #getData()
     * @generated
     */
    void setData(Object value);

} // ContainerItem
