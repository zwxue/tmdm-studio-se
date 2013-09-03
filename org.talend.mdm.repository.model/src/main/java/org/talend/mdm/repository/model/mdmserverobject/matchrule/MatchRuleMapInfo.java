/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfo#getEntityMapInfos <em>Entity Map Infos</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfo#getModelName <em>Model Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getMatchRuleMapInfo()
 * @model
 * @generated
 */
public interface MatchRuleMapInfo extends EObject {
    /**
     * Returns the value of the '<em><b>Entity Map Infos</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo}.
     * It is bidirectional and its opposite is '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entity Map Infos</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entity Map Infos</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getMatchRuleMapInfo_EntityMapInfos()
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo#getParent
     * @model opposite="parent" containment="true"
     * @generated
     */
    EList<EntityMapInfo> getEntityMapInfos();

    /**
     * Returns the value of the '<em><b>Model Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Model Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Model Name</em>' attribute.
     * @see #setModelName(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getMatchRuleMapInfo_ModelName()
     * @model
     * @generated
     */
    String getModelName();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfo#getModelName <em>Model Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Model Name</em>' attribute.
     * @see #getModelName()
     * @generated
     */
    void setModelName(String value);

} // MatchRuleMapInfo
