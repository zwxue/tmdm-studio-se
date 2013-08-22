/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage
 * @generated
 */
public interface MatchRuleFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MatchRuleFactory eINSTANCE = org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.MatchRuleFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Map Info</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Map Info</em>'.
     * @generated
     */
    MatchRuleMapInfo createMatchRuleMapInfo();

    /**
     * Returns a new object of class '<em>Entity Map Info</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Entity Map Info</em>'.
     * @generated
     */
    EntityMapInfo createEntityMapInfo();

    /**
     * Returns a new object of class '<em>Blocking Key Definition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Blocking Key Definition</em>'.
     * @generated
     */
    BlockingKeyDefinition createBlockingKeyDefinition();

    /**
     * Returns a new object of class '<em>Blocking Key</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Blocking Key</em>'.
     * @generated
     */
    BlockingKey createBlockingKey();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    MatchRulePackage getMatchRulePackage();

} //MatchRuleFactory
