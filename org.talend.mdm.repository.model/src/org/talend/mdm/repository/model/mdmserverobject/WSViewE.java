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
 * A representation of the model object '<em><b>WS View E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#getSearchableBusinessElements <em>Searchable Business Elements</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#getViewableBusinessElements <em>Viewable Business Elements</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#isTransformerActive <em>Transformer Active</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#getWhereConditions <em>Where Conditions</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#getIsTransformerActive <em>Is Transformer Active</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSViewE()
 * @model
 * @generated
 */
public interface WSViewE extends MDMServerObject {
    /**
     * Returns the value of the '<em><b>Searchable Business Elements</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Searchable Business Elements</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Searchable Business Elements</em>' attribute.
     * @see #setSearchableBusinessElements(String[])
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSViewE_SearchableBusinessElements()
     * @model dataType="org.talend.mdm.repository.model.mdmserverobject.StringArray"
     * @generated
     */
    String[] getSearchableBusinessElements();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#getSearchableBusinessElements <em>Searchable Business Elements</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Searchable Business Elements</em>' attribute.
     * @see #getSearchableBusinessElements()
     * @generated
     */
    void setSearchableBusinessElements(String[] value);

    /**
     * Returns the value of the '<em><b>Viewable Business Elements</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Viewable Business Elements</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Viewable Business Elements</em>' attribute.
     * @see #setViewableBusinessElements(String[])
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSViewE_ViewableBusinessElements()
     * @model dataType="org.talend.mdm.repository.model.mdmserverobject.StringArray"
     * @generated
     */
    String[] getViewableBusinessElements();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#getViewableBusinessElements <em>Viewable Business Elements</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Viewable Business Elements</em>' attribute.
     * @see #getViewableBusinessElements()
     * @generated
     */
    void setViewableBusinessElements(String[] value);

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
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSViewE_TransformerActive()
     * @model
     * @generated
     */
    boolean isTransformerActive();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#isTransformerActive <em>Transformer Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transformer Active</em>' attribute.
     * @see #isTransformerActive()
     * @generated
     */
    void setTransformerActive(boolean value);

    /**
     * Returns the value of the '<em><b>Where Conditions</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Where Conditions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Where Conditions</em>' containment reference list.
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSViewE_WhereConditions()
     * @model containment="true"
     * @generated
     */
    EList<WSWhereConditionE> getWhereConditions();

    /**
     * Returns the value of the '<em><b>Is Transformer Active</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Transformer Active</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Transformer Active</em>' containment reference.
     * @see #setIsTransformerActive(WSBooleanE)
     * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage#getWSViewE_IsTransformerActive()
     * @model containment="true"
     * @generated
     */
    WSBooleanE getIsTransformerActive();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmserverobject.WSViewE#getIsTransformerActive <em>Is Transformer Active</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Transformer Active</em>' containment reference.
     * @see #getIsTransformerActive()
     * @generated
     */
    void setIsTransformerActive(WSBooleanE value);

} // WSViewE
