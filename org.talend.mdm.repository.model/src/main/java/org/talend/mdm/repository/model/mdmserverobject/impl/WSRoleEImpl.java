/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>WS Role E</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleEImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSRoleEImpl#getRecordssecurity <em>Recordssecurity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSRoleEImpl extends MDMServerObjectImpl implements WSRoleE {

    /**
     * The cached value of the '{@link #getSpecification() <em>Specification</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSpecification()
     * @generated
     * @ordered
     */
    protected EList<WSRoleSpecificationE> specification;

    /**
	 * The cached value of the '{@link #getRecordssecurity() <em>Recordssecurity</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordssecurity()
	 * @generated
	 * @ordered
	 */
	protected EList<String> recordssecurity;

				/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected WSRoleEImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return MdmserverobjectPackage.Literals.WS_ROLE_E;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EList<WSRoleSpecificationE> getSpecification() {
		if (specification == null) {
			specification = new EObjectContainmentEList<WSRoleSpecificationE>(WSRoleSpecificationE.class, this, MdmserverobjectPackage.WS_ROLE_E__SPECIFICATION);
		}
		return specification;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRecordssecurity() {
		if (recordssecurity == null) {
			recordssecurity = new EDataTypeUniqueEList<String>(String.class, this, MdmserverobjectPackage.WS_ROLE_E__RECORDSSECURITY);
		}
		return recordssecurity;
	}

				/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MdmserverobjectPackage.WS_ROLE_E__SPECIFICATION:
				return ((InternalEList<?>)getSpecification()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MdmserverobjectPackage.WS_ROLE_E__SPECIFICATION:
				return getSpecification();
			case MdmserverobjectPackage.WS_ROLE_E__RECORDSSECURITY:
				return getRecordssecurity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MdmserverobjectPackage.WS_ROLE_E__SPECIFICATION:
				getSpecification().clear();
				getSpecification().addAll((Collection<? extends WSRoleSpecificationE>)newValue);
				return;
			case MdmserverobjectPackage.WS_ROLE_E__RECORDSSECURITY:
				getRecordssecurity().clear();
				getRecordssecurity().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case MdmserverobjectPackage.WS_ROLE_E__SPECIFICATION:
				getSpecification().clear();
				return;
			case MdmserverobjectPackage.WS_ROLE_E__RECORDSSECURITY:
				getRecordssecurity().clear();
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MdmserverobjectPackage.WS_ROLE_E__SPECIFICATION:
				return specification != null && !specification.isEmpty();
			case MdmserverobjectPackage.WS_ROLE_E__RECORDSSECURITY:
				return recordssecurity != null && !recordssecurity.isEmpty();
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (recordssecurity: ");
		result.append(recordssecurity);
		result.append(')');
		return result.toString();
	}

				@Override
    public int getType() {
        return 13;
    }

} // WSRoleEImpl
