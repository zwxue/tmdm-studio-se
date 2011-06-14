/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage
 * @generated
 */
public interface MdmpropertiesFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	MdmpropertiesFactory eINSTANCE = org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesFactoryImpl.init();

	/**
     * Returns a new object of class '<em>MDM Item</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>MDM Item</em>'.
     * @generated
     */
	MDMItem createMDMItem();

	/**
     * Returns a new object of class '<em>MDM Server Def Item</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>MDM Server Def Item</em>'.
     * @generated
     */
	MDMServerDefItem createMDMServerDefItem();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	MdmpropertiesPackage getMdmpropertiesPackage();

} //MdmpropertiesFactory
