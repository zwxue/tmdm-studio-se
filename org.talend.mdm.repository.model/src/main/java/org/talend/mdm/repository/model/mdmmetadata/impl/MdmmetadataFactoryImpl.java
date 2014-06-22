/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmmetadata.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.talend.mdm.repository.model.mdmmetadata.*;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataFactory;
import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MdmmetadataFactoryImpl extends EFactoryImpl implements MdmmetadataFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static MdmmetadataFactory init() {
        try {
            MdmmetadataFactory theMdmmetadataFactory = (MdmmetadataFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.talend.org/metadata/mdmserverdef"); 
            if (theMdmmetadataFactory != null) {
                return theMdmmetadataFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new MdmmetadataFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MdmmetadataFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case MdmmetadataPackage.MDM_SERVER_DEF: return createMDMServerDef();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MDMServerDef createMDMServerDef() {
        MDMServerDefImpl mdmServerDef = new MDMServerDefImpl();
        return mdmServerDef;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MdmmetadataPackage getMdmmetadataPackage() {
        return (MdmmetadataPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static MdmmetadataPackage getPackage() {
        return MdmmetadataPackage.eINSTANCE;
    }

} //MdmmetadataFactoryImpl
