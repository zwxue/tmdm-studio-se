/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Transformer Process Step E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE#getPluginJNDI <em>Plugin JNDI</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE#getDescription <em>Description</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE#isDisabled <em>Disabled</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE#getInputMappings <em>Input Mappings</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE#getOutputMappings <em>Output Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerProcessStepE()
 * @model
 * @generated
 */
public interface WSTransformerProcessStepE extends EObject {
    /**
     * Returns the value of the '<em><b>Plugin JNDI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plugin JNDI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plugin JNDI</em>' attribute.
     * @see #setPluginJNDI(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerProcessStepE_PluginJNDI()
     * @model
     * @generated
     */
    String getPluginJNDI();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE#getPluginJNDI <em>Plugin JNDI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plugin JNDI</em>' attribute.
     * @see #getPluginJNDI()
     * @generated
     */
    void setPluginJNDI(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerProcessStepE_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Parameters</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameters</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameters</em>' attribute.
     * @see #setParameters(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerProcessStepE_Parameters()
     * @model
     * @generated
     */
    String getParameters();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE#getParameters <em>Parameters</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameters</em>' attribute.
     * @see #getParameters()
     * @generated
     */
    void setParameters(String value);

    /**
     * Returns the value of the '<em><b>Disabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Disabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Disabled</em>' attribute.
     * @see #setDisabled(boolean)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerProcessStepE_Disabled()
     * @model
     * @generated
     */
    boolean isDisabled();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE#isDisabled <em>Disabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Disabled</em>' attribute.
     * @see #isDisabled()
     * @generated
     */
    void setDisabled(boolean value);

    /**
     * Returns the value of the '<em><b>Input Mappings</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Mappings</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerProcessStepE_InputMappings()
     * @model containment="true"
     * @generated
     */
    EList<WSTransformerVariablesMappingE> getInputMappings();

    /**
     * Returns the value of the '<em><b>Output Mappings</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Mappings</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerProcessStepE_OutputMappings()
     * @model containment="true"
     * @generated
     */
    EList<WSTransformerVariablesMappingE> getOutputMappings();

} // WSTransformerProcessStepE
