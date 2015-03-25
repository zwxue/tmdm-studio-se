/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE;
import org.talend.mdm.repository.model.mdmserverobject.WSTypedContentE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Transformer Variables Mapping E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTransformerVariablesMappingEImpl#getPipelineVariable <em>Pipeline Variable</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTransformerVariablesMappingEImpl#getPluginVariable <em>Plugin Variable</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTransformerVariablesMappingEImpl#getHardCoding <em>Hard Coding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSTransformerVariablesMappingEImpl extends EObjectImpl implements WSTransformerVariablesMappingE {
    /**
     * The default value of the '{@link #getPipelineVariable() <em>Pipeline Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPipelineVariable()
     * @generated
     * @ordered
     */
    protected static final String PIPELINE_VARIABLE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPipelineVariable() <em>Pipeline Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPipelineVariable()
     * @generated
     * @ordered
     */
    protected String pipelineVariable = PIPELINE_VARIABLE_EDEFAULT;

    /**
     * The default value of the '{@link #getPluginVariable() <em>Plugin Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPluginVariable()
     * @generated
     * @ordered
     */
    protected static final String PLUGIN_VARIABLE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPluginVariable() <em>Plugin Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPluginVariable()
     * @generated
     * @ordered
     */
    protected String pluginVariable = PLUGIN_VARIABLE_EDEFAULT;

    /**
     * The cached value of the '{@link #getHardCoding() <em>Hard Coding</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHardCoding()
     * @generated
     * @ordered
     */
    protected WSTypedContentE hardCoding;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSTransformerVariablesMappingEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_TRANSFORMER_VARIABLES_MAPPING_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPipelineVariable() {
        return pipelineVariable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPipelineVariable(String newPipelineVariable) {
        String oldPipelineVariable = pipelineVariable;
        pipelineVariable = newPipelineVariable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__PIPELINE_VARIABLE, oldPipelineVariable, pipelineVariable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPluginVariable() {
        return pluginVariable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPluginVariable(String newPluginVariable) {
        String oldPluginVariable = pluginVariable;
        pluginVariable = newPluginVariable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__PLUGIN_VARIABLE, oldPluginVariable, pluginVariable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSTypedContentE getHardCoding() {
        return hardCoding;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetHardCoding(WSTypedContentE newHardCoding, NotificationChain msgs) {
        WSTypedContentE oldHardCoding = hardCoding;
        hardCoding = newHardCoding;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING, oldHardCoding, newHardCoding);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHardCoding(WSTypedContentE newHardCoding) {
        if (newHardCoding != hardCoding) {
            NotificationChain msgs = null;
            if (hardCoding != null)
                msgs = ((InternalEObject)hardCoding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING, null, msgs);
            if (newHardCoding != null)
                msgs = ((InternalEObject)newHardCoding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING, null, msgs);
            msgs = basicSetHardCoding(newHardCoding, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING, newHardCoding, newHardCoding));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING:
                return basicSetHardCoding(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__PIPELINE_VARIABLE:
                return getPipelineVariable();
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__PLUGIN_VARIABLE:
                return getPluginVariable();
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING:
                return getHardCoding();
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
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__PIPELINE_VARIABLE:
                setPipelineVariable((String)newValue);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__PLUGIN_VARIABLE:
                setPluginVariable((String)newValue);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING:
                setHardCoding((WSTypedContentE)newValue);
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
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__PIPELINE_VARIABLE:
                setPipelineVariable(PIPELINE_VARIABLE_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__PLUGIN_VARIABLE:
                setPluginVariable(PLUGIN_VARIABLE_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING:
                setHardCoding((WSTypedContentE)null);
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
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__PIPELINE_VARIABLE:
                return PIPELINE_VARIABLE_EDEFAULT == null ? pipelineVariable != null : !PIPELINE_VARIABLE_EDEFAULT.equals(pipelineVariable);
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__PLUGIN_VARIABLE:
                return PLUGIN_VARIABLE_EDEFAULT == null ? pluginVariable != null : !PLUGIN_VARIABLE_EDEFAULT.equals(pluginVariable);
            case MdmserverobjectPackage.WS_TRANSFORMER_VARIABLES_MAPPING_E__HARD_CODING:
                return hardCoding != null;
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
        result.append(" (pipelineVariable: ");
        result.append(pipelineVariable);
        result.append(", pluginVariable: ");
        result.append(pluginVariable);
        result.append(')');
        return result.toString();
    }

} //WSTransformerVariablesMappingEImpl
