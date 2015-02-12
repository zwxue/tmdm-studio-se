/**
 * <copyright> </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WsDataClusterE;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ws Data Cluster E</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WsDataClusterEImpl#getVocabulary <em>Vocabulary</em>}
 * </li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsDataClusterEImpl extends MDMServerObjectImpl implements WsDataClusterE {

    /**
     * The default value of the '{@link #getVocabulary() <em>Vocabulary</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getVocabulary()
     * @generated
     * @ordered
     */
    protected static final String VOCABULARY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVocabulary() <em>Vocabulary</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getVocabulary()
     * @generated
     * @ordered
     */
    protected String vocabulary = VOCABULARY_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WsDataClusterEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_DATA_CLUSTER_E;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getVocabulary() {
        return vocabulary;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setVocabulary(String newVocabulary) {
        String oldVocabulary = vocabulary;
        vocabulary = newVocabulary;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_DATA_CLUSTER_E__VOCABULARY,
                    oldVocabulary, vocabulary));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case MdmserverobjectPackage.WS_DATA_CLUSTER_E__VOCABULARY:
            return getVocabulary();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case MdmserverobjectPackage.WS_DATA_CLUSTER_E__VOCABULARY:
            setVocabulary((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case MdmserverobjectPackage.WS_DATA_CLUSTER_E__VOCABULARY:
            setVocabulary(VOCABULARY_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case MdmserverobjectPackage.WS_DATA_CLUSTER_E__VOCABULARY:
            return VOCABULARY_EDEFAULT == null ? vocabulary != null : !VOCABULARY_EDEFAULT.equals(vocabulary);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (vocabulary: ");
        result.append(vocabulary);
        result.append(')');
        return result.toString();
    }

    @Override
    public int getType() {
        return 11;
    }
} // WsDataClusterEImpl
