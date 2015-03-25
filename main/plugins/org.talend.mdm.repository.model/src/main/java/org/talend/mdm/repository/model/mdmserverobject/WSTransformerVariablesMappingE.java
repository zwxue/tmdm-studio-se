/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Transformer Variables Mapping E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE#getPipelineVariable <em>Pipeline Variable</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE#getPluginVariable <em>Plugin Variable</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE#getHardCoding <em>Hard Coding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerVariablesMappingE()
 * @model
 * @generated
 */
public interface WSTransformerVariablesMappingE extends EObject {
    /**
     * Returns the value of the '<em><b>Pipeline Variable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pipeline Variable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pipeline Variable</em>' attribute.
     * @see #setPipelineVariable(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerVariablesMappingE_PipelineVariable()
     * @model
     * @generated
     */
    String getPipelineVariable();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE#getPipelineVariable <em>Pipeline Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pipeline Variable</em>' attribute.
     * @see #getPipelineVariable()
     * @generated
     */
    void setPipelineVariable(String value);

    /**
     * Returns the value of the '<em><b>Plugin Variable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plugin Variable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plugin Variable</em>' attribute.
     * @see #setPluginVariable(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerVariablesMappingE_PluginVariable()
     * @model
     * @generated
     */
    String getPluginVariable();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE#getPluginVariable <em>Plugin Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plugin Variable</em>' attribute.
     * @see #getPluginVariable()
     * @generated
     */
    void setPluginVariable(String value);

    /**
     * Returns the value of the '<em><b>Hard Coding</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hard Coding</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hard Coding</em>' containment reference.
     * @see #setHardCoding(WSTypedContentE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSTransformerVariablesMappingE_HardCoding()
     * @model containment="true"
     * @generated
     */
    WSTypedContentE getHardCoding();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE#getHardCoding <em>Hard Coding</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hard Coding</em>' containment reference.
     * @see #getHardCoding()
     * @generated
     */
    void setHardCoding(WSTypedContentE value);

} // WSTransformerVariablesMappingE
