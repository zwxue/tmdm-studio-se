/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.talend.mdm.repository.model.mdmproperties.*;
import org.talend.mdm.repository.model.mdmproperties.MDMItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MdmpropertiesFactoryImpl extends EFactoryImpl implements MdmpropertiesFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static MdmpropertiesFactory init() {
        try {
            MdmpropertiesFactory theMdmpropertiesFactory = (MdmpropertiesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.talend.org/mdmproperties"); 
            if (theMdmpropertiesFactory != null) {
                return theMdmpropertiesFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new MdmpropertiesFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MdmpropertiesFactoryImpl() {
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
            case MdmpropertiesPackage.MDM_ITEM: return createMDMItem();
            case MdmpropertiesPackage.MDM_SERVER_DEF_ITEM: return createMDMServerDefItem();
            case MdmpropertiesPackage.MDM_SERVER_OBJECT_ITEM: return createMDMServerObjectItem();
            case MdmpropertiesPackage.WS_MENU_ITEM: return createWSMenuItem();
            case MdmpropertiesPackage.WS_ROLE_ITEM: return createWSRoleItem();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MDMItem createMDMItem() {
        MDMItemImpl mdmItem = new MDMItemImpl();
        return mdmItem;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MDMServerDefItem createMDMServerDefItem() {
        MDMServerDefItemImpl mdmServerDefItem = new MDMServerDefItemImpl();
        return mdmServerDefItem;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MDMServerObjectItem createMDMServerObjectItem() {
        MDMServerObjectItemImpl mdmServerObjectItem = new MDMServerObjectItemImpl();
        return mdmServerObjectItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSMenuItem createWSMenuItem() {
        WSMenuItemImpl wsMenuItem = new WSMenuItemImpl();
        return wsMenuItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSRoleItem createWSRoleItem() {
        WSRoleItemImpl wsRoleItem = new WSRoleItemImpl();
        return wsRoleItem;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MdmpropertiesPackage getMdmpropertiesPackage() {
        return (MdmpropertiesPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static MdmpropertiesPackage getPackage() {
        return MdmpropertiesPackage.eINSTANCE;
    }

} //MdmpropertiesFactoryImpl
