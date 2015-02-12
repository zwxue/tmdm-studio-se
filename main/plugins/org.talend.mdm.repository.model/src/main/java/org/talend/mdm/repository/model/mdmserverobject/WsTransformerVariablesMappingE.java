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
 * A representation of the model object '<em><b>Ws Transformer Variables Mapping E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getPipelineVariable <em>Pipeline Variable</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getPluginVariable <em>Plugin Variable</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getHardCoding <em>Hard Coding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsTransformerVariablesMappingE()
 * @model
 * @generated
 */
public interface WsTransformerVariablesMappingE extends EObject {
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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsTransformerVariablesMappingE_PipelineVariable()
     * @model
     * @generated
     */
    String getPipelineVariable();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getPipelineVariable <em>Pipeline Variable</em>}' attribute.
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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsTransformerVariablesMappingE_PluginVariable()
     * @model
     * @generated
     */
    String getPluginVariable();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getPluginVariable <em>Plugin Variable</em>}' attribute.
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
     * @see #setHardCoding(WsTypedContentE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsTransformerVariablesMappingE_HardCoding()
     * @model containment="true"
     * @generated
     */
    WsTypedContentE getHardCoding();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsTransformerVariablesMappingE#getHardCoding <em>Hard Coding</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hard Coding</em>' containment reference.
     * @see #getHardCoding()
     * @generated
     */
    void setHardCoding(WsTypedContentE value);

} // WsTransformerVariablesMappingE
