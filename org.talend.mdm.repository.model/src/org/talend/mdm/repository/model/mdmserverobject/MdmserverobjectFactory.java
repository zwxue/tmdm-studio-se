/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage
 * @generated
 */
public interface MdmserverobjectFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MdmserverobjectFactory eINSTANCE = org.talend.mdm.repository.model.mdmserverobject.impl.MdmserverobjectFactoryImpl.init();

    /**
     * Returns a new object of class '<em>MDM Server Object</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>MDM Server Object</em>'.
     * @generated
     */
    MDMServerObject createMDMServerObject();

    /**
     * Returns a new object of class '<em>EWS Menu</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>EWS Menu</em>'.
     * @generated
     */
    EWSMenu createEWSMenu();

    /**
     * Returns a new object of class '<em>EWS Menu Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>EWS Menu Entry</em>'.
     * @generated
     */
    EWSMenuEntry createEWSMenuEntry();

    /**
     * Returns a new object of class '<em>WS Menu Menu Entries Descriptions E</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>WS Menu Menu Entries Descriptions E</em>'.
     * @generated
     */
    WSMenuMenuEntriesDescriptionsE createWSMenuMenuEntriesDescriptionsE();

    /**
     * Returns a new object of class '<em>WS Role E</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>WS Role E</em>'.
     * @generated
     */
    WSRoleE createWSRoleE();

    /**
     * Returns a new object of class '<em>WS Role Specification E</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>WS Role Specification E</em>'.
     * @generated
     */
    WSRoleSpecificationE createWSRoleSpecificationE();

    /**
     * Returns a new object of class '<em>WS Role Specification Instance E</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>WS Role Specification Instance E</em>'.
     * @generated
     */
    WSRoleSpecificationInstanceE createWSRoleSpecificationInstanceE();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    MdmserverobjectPackage getMdmserverobjectPackage();

} //MdmserverobjectFactory
