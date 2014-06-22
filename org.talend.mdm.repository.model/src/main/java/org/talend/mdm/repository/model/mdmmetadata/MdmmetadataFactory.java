/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmmetadata;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage
 * @generated
 */
public interface MdmmetadataFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	MdmmetadataFactory eINSTANCE = org.talend.mdm.repository.model.mdmmetadata.impl.MdmmetadataFactoryImpl.init();

	/**
     * Returns a new object of class '<em>MDM Server Def</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>MDM Server Def</em>'.
     * @generated
     */
	MDMServerDef createMDMServerDef();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	MdmmetadataPackage getMdmmetadataPackage();

} //MdmmetadataFactory
