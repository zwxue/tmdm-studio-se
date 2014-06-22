/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSDataModelE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Data Model E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSDataModelEImpl#getXsdSchema <em>Xsd Schema</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSDataModelEImpl extends MDMServerObjectImpl implements WSDataModelE {
    /**
     * The default value of the '{@link #getXsdSchema() <em>Xsd Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXsdSchema()
     * @generated
     * @ordered
     */
    protected static final String XSD_SCHEMA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getXsdSchema() <em>Xsd Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXsdSchema()
     * @generated
     * @ordered
     */
    protected String xsdSchema = XSD_SCHEMA_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSDataModelEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_DATA_MODEL_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getXsdSchema() {
        return xsdSchema;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setXsdSchema(String newXsdSchema) {
        String oldXsdSchema = xsdSchema;
        xsdSchema = newXsdSchema;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_DATA_MODEL_E__XSD_SCHEMA, oldXsdSchema, xsdSchema));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_DATA_MODEL_E__XSD_SCHEMA:
                return getXsdSchema();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_DATA_MODEL_E__XSD_SCHEMA:
                setXsdSchema((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_DATA_MODEL_E__XSD_SCHEMA:
                setXsdSchema(XSD_SCHEMA_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_DATA_MODEL_E__XSD_SCHEMA:
                return XSD_SCHEMA_EDEFAULT == null ? xsdSchema != null : !XSD_SCHEMA_EDEFAULT.equals(xsdSchema);
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
        result.append(" (xsdSchema: ");
        result.append(xsdSchema);
        result.append(')');
        return result.toString();
    }

    @Override
    public int getType() {
        return 9;
    }

} //WSDataModelEImpl
