/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Transformer Process Step E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTransformerProcessStepEImpl#getPluginJNDI <em>Plugin JNDI</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTransformerProcessStepEImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTransformerProcessStepEImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTransformerProcessStepEImpl#isDisabled <em>Disabled</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTransformerProcessStepEImpl#getInputMappings <em>Input Mappings</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTransformerProcessStepEImpl#getOutputMappings <em>Output Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSTransformerProcessStepEImpl extends EObjectImpl implements WSTransformerProcessStepE {
    /**
     * The default value of the '{@link #getPluginJNDI() <em>Plugin JNDI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPluginJNDI()
     * @generated
     * @ordered
     */
    protected static final String PLUGIN_JNDI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPluginJNDI() <em>Plugin JNDI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPluginJNDI()
     * @generated
     * @ordered
     */
    protected String pluginJNDI = PLUGIN_JNDI_EDEFAULT;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getParameters() <em>Parameters</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected static final String PARAMETERS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected String parameters = PARAMETERS_EDEFAULT;

    /**
     * The default value of the '{@link #isDisabled() <em>Disabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDisabled()
     * @generated
     * @ordered
     */
    protected static final boolean DISABLED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDisabled() <em>Disabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDisabled()
     * @generated
     * @ordered
     */
    protected boolean disabled = DISABLED_EDEFAULT;

    /**
     * The cached value of the '{@link #getInputMappings() <em>Input Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputMappings()
     * @generated
     * @ordered
     */
    protected EList<WSTransformerVariablesMappingE> inputMappings;

    /**
     * The cached value of the '{@link #getOutputMappings() <em>Output Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputMappings()
     * @generated
     * @ordered
     */
    protected EList<WSTransformerVariablesMappingE> outputMappings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSTransformerProcessStepEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_TRANSFORMER_PROCESS_STEP_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPluginJNDI() {
        return pluginJNDI;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPluginJNDI(String newPluginJNDI) {
        String oldPluginJNDI = pluginJNDI;
        pluginJNDI = newPluginJNDI;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__PLUGIN_JNDI, oldPluginJNDI, pluginJNDI));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getParameters() {
        return parameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameters(String newParameters) {
        String oldParameters = parameters;
        parameters = newParameters;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__PARAMETERS, oldParameters, parameters));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDisabled(boolean newDisabled) {
        boolean oldDisabled = disabled;
        disabled = newDisabled;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__DISABLED, oldDisabled, disabled));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WSTransformerVariablesMappingE> getInputMappings() {
        if (inputMappings == null) {
            inputMappings = new EObjectContainmentEList<WSTransformerVariablesMappingE>(WSTransformerVariablesMappingE.class, this, MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__INPUT_MAPPINGS);
        }
        return inputMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WSTransformerVariablesMappingE> getOutputMappings() {
        if (outputMappings == null) {
            outputMappings = new EObjectContainmentEList<WSTransformerVariablesMappingE>(WSTransformerVariablesMappingE.class, this, MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__OUTPUT_MAPPINGS);
        }
        return outputMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__INPUT_MAPPINGS:
                return ((InternalEList<?>)getInputMappings()).basicRemove(otherEnd, msgs);
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__OUTPUT_MAPPINGS:
                return ((InternalEList<?>)getOutputMappings()).basicRemove(otherEnd, msgs);
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
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__PLUGIN_JNDI:
                return getPluginJNDI();
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__DESCRIPTION:
                return getDescription();
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__PARAMETERS:
                return getParameters();
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__DISABLED:
                return isDisabled();
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__INPUT_MAPPINGS:
                return getInputMappings();
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__OUTPUT_MAPPINGS:
                return getOutputMappings();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__PLUGIN_JNDI:
                setPluginJNDI((String)newValue);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__PARAMETERS:
                setParameters((String)newValue);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__DISABLED:
                setDisabled((Boolean)newValue);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__INPUT_MAPPINGS:
                getInputMappings().clear();
                getInputMappings().addAll((Collection<? extends WSTransformerVariablesMappingE>)newValue);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__OUTPUT_MAPPINGS:
                getOutputMappings().clear();
                getOutputMappings().addAll((Collection<? extends WSTransformerVariablesMappingE>)newValue);
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
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__PLUGIN_JNDI:
                setPluginJNDI(PLUGIN_JNDI_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__PARAMETERS:
                setParameters(PARAMETERS_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__DISABLED:
                setDisabled(DISABLED_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__INPUT_MAPPINGS:
                getInputMappings().clear();
                return;
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__OUTPUT_MAPPINGS:
                getOutputMappings().clear();
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
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__PLUGIN_JNDI:
                return PLUGIN_JNDI_EDEFAULT == null ? pluginJNDI != null : !PLUGIN_JNDI_EDEFAULT.equals(pluginJNDI);
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__PARAMETERS:
                return PARAMETERS_EDEFAULT == null ? parameters != null : !PARAMETERS_EDEFAULT.equals(parameters);
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__DISABLED:
                return disabled != DISABLED_EDEFAULT;
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__INPUT_MAPPINGS:
                return inputMappings != null && !inputMappings.isEmpty();
            case MdmserverobjectPackage.WS_TRANSFORMER_PROCESS_STEP_E__OUTPUT_MAPPINGS:
                return outputMappings != null && !outputMappings.isEmpty();
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
        result.append(" (pluginJNDI: ");
        result.append(pluginJNDI);
        result.append(", description: ");
        result.append(description);
        result.append(", parameters: ");
        result.append(parameters);
        result.append(", disabled: ");
        result.append(disabled);
        result.append(')');
        return result.toString();
    }

} //WSTransformerProcessStepEImpl
