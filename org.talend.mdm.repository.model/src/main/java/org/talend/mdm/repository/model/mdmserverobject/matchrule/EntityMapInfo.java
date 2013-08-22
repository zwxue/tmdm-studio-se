/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Map Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo#getEntityName <em>Entity Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo#getMatchKeyMap <em>Match Key Map</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo#getBlockingKeyDefinition <em>Blocking Key Definition</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo#getMatchRuleName <em>Match Rule Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getEntityMapInfo()
 * @model
 * @generated
 */
public interface EntityMapInfo extends EObject {
    /**
     * Returns the value of the '<em><b>Entity Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entity Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entity Name</em>' attribute.
     * @see #setEntityName(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getEntityMapInfo_EntityName()
     * @model
     * @generated
     */
    String getEntityName();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo#getEntityName <em>Entity Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Entity Name</em>' attribute.
     * @see #getEntityName()
     * @generated
     */
    void setEntityName(String value);

    /**
     * Returns the value of the '<em><b>Match Key Map</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Match Key Map</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Match Key Map</em>' map.
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getEntityMapInfo_MatchKeyMap()
     * @model mapType="org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchKeyXPathMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
     * @generated
     */
    EMap<String, String> getMatchKeyMap();

    /**
     * Returns the value of the '<em><b>Blocking Key Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Blocking Key Definition</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Blocking Key Definition</em>' containment reference.
     * @see #setBlockingKeyDefinition(BlockingKeyDefinition)
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getEntityMapInfo_BlockingKeyDefinition()
     * @model containment="true"
     * @generated
     */
    BlockingKeyDefinition getBlockingKeyDefinition();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo#getBlockingKeyDefinition <em>Blocking Key Definition</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Blocking Key Definition</em>' containment reference.
     * @see #getBlockingKeyDefinition()
     * @generated
     */
    void setBlockingKeyDefinition(BlockingKeyDefinition value);

    /**
     * Returns the value of the '<em><b>Match Rule Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Match Rule Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Match Rule Name</em>' attribute.
     * @see #setMatchRuleName(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getEntityMapInfo_MatchRuleName()
     * @model
     * @generated
     */
    String getMatchRuleName();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo#getMatchRuleName <em>Match Rule Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Match Rule Name</em>' attribute.
     * @see #getMatchRuleName()
     * @generated
     */
    void setMatchRuleName(String value);

    /**
     * Returns the value of the '<em><b>Parent</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfo#getEntityMapInfos <em>Entity Map Infos</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(MatchRuleMapInfo)
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getEntityMapInfo_Parent()
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfo#getEntityMapInfos
     * @model opposite="entityMapInfos" transient="false"
     * @generated
     */
    MatchRuleMapInfo getParent();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo#getParent <em>Parent</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
    void setParent(MatchRuleMapInfo value);

} // EntityMapInfo
