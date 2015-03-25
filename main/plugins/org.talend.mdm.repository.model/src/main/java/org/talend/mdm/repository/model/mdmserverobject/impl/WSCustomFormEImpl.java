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
import org.talend.mdm.repository.model.mdmserverobject.WSCustomFormE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Custom Form E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSCustomFormEImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSCustomFormEImpl#getDatamodel <em>Datamodel</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSCustomFormEImpl#getEntity <em>Entity</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSCustomFormEImpl#getXml <em>Xml</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSCustomFormEImpl#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSCustomFormEImpl extends MDMServerObjectImpl implements WSCustomFormE {
    /**
     * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilename()
     * @generated
     * @ordered
     */
    protected static final String FILENAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilename()
     * @generated
     * @ordered
     */
    protected String filename = FILENAME_EDEFAULT;

    /**
     * The default value of the '{@link #getDatamodel() <em>Datamodel</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatamodel()
     * @generated
     * @ordered
     */
    protected static final String DATAMODEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDatamodel() <em>Datamodel</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatamodel()
     * @generated
     * @ordered
     */
    protected String datamodel = DATAMODEL_EDEFAULT;

    /**
     * The default value of the '{@link #getEntity() <em>Entity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntity()
     * @generated
     * @ordered
     */
    protected static final String ENTITY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEntity() <em>Entity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntity()
     * @generated
     * @ordered
     */
    protected String entity = ENTITY_EDEFAULT;

    /**
     * The default value of the '{@link #getXml() <em>Xml</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXml()
     * @generated
     * @ordered
     */
    protected static final String XML_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getXml() <em>Xml</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXml()
     * @generated
     * @ordered
     */
    protected String xml = XML_EDEFAULT;

    /**
     * The default value of the '{@link #getRole() <em>Role</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRole()
     * @generated
     * @ordered
     */
    protected static final String ROLE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRole() <em>Role</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRole()
     * @generated
     * @ordered
     */
    protected String role = ROLE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSCustomFormEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_CUSTOM_FORM_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFilename() {
        return filename;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFilename(String newFilename) {
        String oldFilename = filename;
        filename = newFilename;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_CUSTOM_FORM_E__FILENAME, oldFilename, filename));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDatamodel() {
        return datamodel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDatamodel(String newDatamodel) {
        String oldDatamodel = datamodel;
        datamodel = newDatamodel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_CUSTOM_FORM_E__DATAMODEL, oldDatamodel, datamodel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEntity() {
        return entity;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEntity(String newEntity) {
        String oldEntity = entity;
        entity = newEntity;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_CUSTOM_FORM_E__ENTITY, oldEntity, entity));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getXml() {
        return xml;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setXml(String newXml) {
        String oldXml = xml;
        xml = newXml;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_CUSTOM_FORM_E__XML, oldXml, xml));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRole() {
        return role;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRole(String newRole) {
        String oldRole = role;
        role = newRole;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_CUSTOM_FORM_E__ROLE, oldRole, role));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__FILENAME:
                return getFilename();
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__DATAMODEL:
                return getDatamodel();
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__ENTITY:
                return getEntity();
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__XML:
                return getXml();
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__ROLE:
                return getRole();
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
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__FILENAME:
                setFilename((String)newValue);
                return;
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__DATAMODEL:
                setDatamodel((String)newValue);
                return;
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__ENTITY:
                setEntity((String)newValue);
                return;
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__XML:
                setXml((String)newValue);
                return;
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__ROLE:
                setRole((String)newValue);
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
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__FILENAME:
                setFilename(FILENAME_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__DATAMODEL:
                setDatamodel(DATAMODEL_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__ENTITY:
                setEntity(ENTITY_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__XML:
                setXml(XML_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__ROLE:
                setRole(ROLE_EDEFAULT);
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
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__FILENAME:
                return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__DATAMODEL:
                return DATAMODEL_EDEFAULT == null ? datamodel != null : !DATAMODEL_EDEFAULT.equals(datamodel);
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__ENTITY:
                return ENTITY_EDEFAULT == null ? entity != null : !ENTITY_EDEFAULT.equals(entity);
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__XML:
                return XML_EDEFAULT == null ? xml != null : !XML_EDEFAULT.equals(xml);
            case MdmserverobjectPackage.WS_CUSTOM_FORM_E__ROLE:
                return ROLE_EDEFAULT == null ? role != null : !ROLE_EDEFAULT.equals(role);
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
        result.append(" (filename: ");
        result.append(filename);
        result.append(", datamodel: ");
        result.append(datamodel);
        result.append(", entity: ");
        result.append(entity);
        result.append(", xml: ");
        result.append(xml);
        result.append(", role: ");
        result.append(role);
        result.append(')');
        return result.toString();
    }

    @Override
    public int getType() {
        return 36;
    }
} // WsCustomFormEImpl
