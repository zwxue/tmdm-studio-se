/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.talend.dataquality.rules.MatchRuleDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Info Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfoContainer#getMapInfos <em>Map Infos</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfoContainer#getMatchRuleDefinitions <em>Match Rule Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getMatchRuleMapInfoContainer()
 * @model
 * @generated
 */
public interface MatchRuleMapInfoContainer extends EObject {
    /**
     * Returns the value of the '<em><b>Map Infos</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Map Infos</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Map Infos</em>' containment reference.
     * @see #setMapInfos(MatchRuleMapInfo)
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getMatchRuleMapInfoContainer_MapInfos()
     * @model containment="true"
     * @generated
     */
    MatchRuleMapInfo getMapInfos();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfoContainer#getMapInfos <em>Map Infos</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Map Infos</em>' containment reference.
     * @see #getMapInfos()
     * @generated
     */
    void setMapInfos(MatchRuleMapInfo value);

    /**
     * Returns the value of the '<em><b>Match Rule Definitions</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.dataquality.rules.MatchRuleDefinition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Match Rule Definitions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Match Rule Definitions</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage#getMatchRuleMapInfoContainer_MatchRuleDefinitions()
     * @model containment="true"
     * @generated
     */
    EList<MatchRuleDefinition> getMatchRuleDefinitions();

} // MatchRuleMapInfoContainer
