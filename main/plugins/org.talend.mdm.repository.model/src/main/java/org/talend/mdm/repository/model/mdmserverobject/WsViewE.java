/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ws View E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getSearchableBusinessElements <em>Searchable Business Elements</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getViewableBusinessElements <em>Viewable Business Elements</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#isTransformerActive <em>Transformer Active</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getWhereConditions <em>Where Conditions</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getIsTransformerActive <em>Is Transformer Active</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getTransformerPK <em>Transformer PK</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsViewE()
 * @model
 * @generated
 */
public interface WsViewE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Searchable Business Elements</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Searchable Business Elements</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Searchable Business Elements</em>' attribute list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsViewE_SearchableBusinessElements()
     * @model
     * @generated
     */
    EList<String> getSearchableBusinessElements();

    /**
     * Returns the value of the '<em><b>Viewable Business Elements</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Viewable Business Elements</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Viewable Business Elements</em>' attribute list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsViewE_ViewableBusinessElements()
     * @model
     * @generated
     */
    EList<String> getViewableBusinessElements();

    /**
     * Returns the value of the '<em><b>Transformer Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transformer Active</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transformer Active</em>' attribute.
     * @see #setTransformerActive(boolean)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsViewE_TransformerActive()
     * @model
     * @generated
     */
    boolean isTransformerActive();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#isTransformerActive <em>Transformer Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transformer Active</em>' attribute.
     * @see #isTransformerActive()
     * @generated
     */
    void setTransformerActive(boolean value);

    /**
     * Returns the value of the '<em><b>Where Conditions</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WsWhereConditionE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Where Conditions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Where Conditions</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsViewE_WhereConditions()
     * @model containment="true"
     * @generated
     */
    EList<WsWhereConditionE> getWhereConditions();

    /**
     * Returns the value of the '<em><b>Is Transformer Active</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Transformer Active</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Transformer Active</em>' containment reference.
     * @see #setIsTransformerActive(WsBooleanE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsViewE_IsTransformerActive()
     * @model containment="true"
     * @generated
     */
    WsBooleanE getIsTransformerActive();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getIsTransformerActive <em>Is Transformer Active</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Transformer Active</em>' containment reference.
     * @see #getIsTransformerActive()
     * @generated
     */
    void setIsTransformerActive(WsBooleanE value);

    /**
     * Returns the value of the '<em><b>Transformer PK</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transformer PK</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transformer PK</em>' attribute.
     * @see #setTransformerPK(String)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWsViewE_TransformerPK()
     * @model
     * @generated
     */
    String getTransformerPK();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WsViewE#getTransformerPK <em>Transformer PK</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transformer PK</em>' attribute.
     * @see #getTransformerPK()
     * @generated
     */
    void setTransformerPK(String value);

} // WsViewE
