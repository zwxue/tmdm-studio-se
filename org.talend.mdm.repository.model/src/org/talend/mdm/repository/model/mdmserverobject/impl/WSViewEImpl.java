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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSBooleanE;
import org.talend.mdm.repository.model.mdmserverobject.WSViewE;
import org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS View E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSViewEImpl#getSearchableBusinessElements <em>Searchable Business Elements</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSViewEImpl#getViewableBusinessElements <em>Viewable Business Elements</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSViewEImpl#isTransformerActive <em>Transformer Active</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSViewEImpl#getWhereConditions <em>Where Conditions</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSViewEImpl#getIsTransformerActive <em>Is Transformer Active</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSViewEImpl extends MDMServerObjectImpl implements WSViewE {
    /**
     * The default value of the '{@link #getSearchableBusinessElements() <em>Searchable Business Elements</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSearchableBusinessElements()
     * @generated
     * @ordered
     */
    protected static final String[] SEARCHABLE_BUSINESS_ELEMENTS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSearchableBusinessElements() <em>Searchable Business Elements</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSearchableBusinessElements()
     * @generated
     * @ordered
     */
    protected String[] searchableBusinessElements = SEARCHABLE_BUSINESS_ELEMENTS_EDEFAULT;

    /**
     * The default value of the '{@link #getViewableBusinessElements() <em>Viewable Business Elements</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getViewableBusinessElements()
     * @generated
     * @ordered
     */
    protected static final String[] VIEWABLE_BUSINESS_ELEMENTS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getViewableBusinessElements() <em>Viewable Business Elements</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getViewableBusinessElements()
     * @generated
     * @ordered
     */
    protected String[] viewableBusinessElements = VIEWABLE_BUSINESS_ELEMENTS_EDEFAULT;

    /**
     * The default value of the '{@link #isTransformerActive() <em>Transformer Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTransformerActive()
     * @generated
     * @ordered
     */
    protected static final boolean TRANSFORMER_ACTIVE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isTransformerActive() <em>Transformer Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTransformerActive()
     * @generated
     * @ordered
     */
    protected boolean transformerActive = TRANSFORMER_ACTIVE_EDEFAULT;

    /**
     * The cached value of the '{@link #getWhereConditions() <em>Where Conditions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWhereConditions()
     * @generated
     * @ordered
     */
    protected EList<WSWhereConditionE> whereConditions;

    /**
     * The cached value of the '{@link #getIsTransformerActive() <em>Is Transformer Active</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIsTransformerActive()
     * @generated
     * @ordered
     */
    protected WSBooleanE isTransformerActive;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSViewEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_VIEW_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String[] getSearchableBusinessElements() {
        return searchableBusinessElements;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSearchableBusinessElements(String[] newSearchableBusinessElements) {
        String[] oldSearchableBusinessElements = searchableBusinessElements;
        searchableBusinessElements = newSearchableBusinessElements;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_VIEW_E__SEARCHABLE_BUSINESS_ELEMENTS, oldSearchableBusinessElements, searchableBusinessElements));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String[] getViewableBusinessElements() {
        return viewableBusinessElements;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setViewableBusinessElements(String[] newViewableBusinessElements) {
        String[] oldViewableBusinessElements = viewableBusinessElements;
        viewableBusinessElements = newViewableBusinessElements;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_VIEW_E__VIEWABLE_BUSINESS_ELEMENTS, oldViewableBusinessElements, viewableBusinessElements));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isTransformerActive() {
        return transformerActive;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTransformerActive(boolean newTransformerActive) {
        boolean oldTransformerActive = transformerActive;
        transformerActive = newTransformerActive;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_VIEW_E__TRANSFORMER_ACTIVE, oldTransformerActive, transformerActive));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<WSWhereConditionE> getWhereConditions() {
        if (whereConditions == null) {
            whereConditions = new EObjectContainmentEList<WSWhereConditionE>(WSWhereConditionE.class, this, MdmserverobjectPackage.WS_VIEW_E__WHERE_CONDITIONS);
        }
        return whereConditions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSBooleanE getIsTransformerActive() {
        return isTransformerActive;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetIsTransformerActive(WSBooleanE newIsTransformerActive, NotificationChain msgs) {
        WSBooleanE oldIsTransformerActive = isTransformerActive;
        isTransformerActive = newIsTransformerActive;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_VIEW_E__IS_TRANSFORMER_ACTIVE, oldIsTransformerActive, newIsTransformerActive);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsTransformerActive(WSBooleanE newIsTransformerActive) {
        if (newIsTransformerActive != isTransformerActive) {
            NotificationChain msgs = null;
            if (isTransformerActive != null)
                msgs = ((InternalEObject)isTransformerActive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_VIEW_E__IS_TRANSFORMER_ACTIVE, null, msgs);
            if (newIsTransformerActive != null)
                msgs = ((InternalEObject)newIsTransformerActive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_VIEW_E__IS_TRANSFORMER_ACTIVE, null, msgs);
            msgs = basicSetIsTransformerActive(newIsTransformerActive, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_VIEW_E__IS_TRANSFORMER_ACTIVE, newIsTransformerActive, newIsTransformerActive));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_VIEW_E__WHERE_CONDITIONS:
                return ((InternalEList<?>)getWhereConditions()).basicRemove(otherEnd, msgs);
            case MdmserverobjectPackage.WS_VIEW_E__IS_TRANSFORMER_ACTIVE:
                return basicSetIsTransformerActive(null, msgs);
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
            case MdmserverobjectPackage.WS_VIEW_E__SEARCHABLE_BUSINESS_ELEMENTS:
                return getSearchableBusinessElements();
            case MdmserverobjectPackage.WS_VIEW_E__VIEWABLE_BUSINESS_ELEMENTS:
                return getViewableBusinessElements();
            case MdmserverobjectPackage.WS_VIEW_E__TRANSFORMER_ACTIVE:
                return isTransformerActive();
            case MdmserverobjectPackage.WS_VIEW_E__WHERE_CONDITIONS:
                return getWhereConditions();
            case MdmserverobjectPackage.WS_VIEW_E__IS_TRANSFORMER_ACTIVE:
                return getIsTransformerActive();
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
            case MdmserverobjectPackage.WS_VIEW_E__SEARCHABLE_BUSINESS_ELEMENTS:
                setSearchableBusinessElements((String[])newValue);
                return;
            case MdmserverobjectPackage.WS_VIEW_E__VIEWABLE_BUSINESS_ELEMENTS:
                setViewableBusinessElements((String[])newValue);
                return;
            case MdmserverobjectPackage.WS_VIEW_E__TRANSFORMER_ACTIVE:
                setTransformerActive((Boolean)newValue);
                return;
            case MdmserverobjectPackage.WS_VIEW_E__WHERE_CONDITIONS:
                getWhereConditions().clear();
                getWhereConditions().addAll((Collection<? extends WSWhereConditionE>)newValue);
                return;
            case MdmserverobjectPackage.WS_VIEW_E__IS_TRANSFORMER_ACTIVE:
                setIsTransformerActive((WSBooleanE)newValue);
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
            case MdmserverobjectPackage.WS_VIEW_E__SEARCHABLE_BUSINESS_ELEMENTS:
                setSearchableBusinessElements(SEARCHABLE_BUSINESS_ELEMENTS_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_VIEW_E__VIEWABLE_BUSINESS_ELEMENTS:
                setViewableBusinessElements(VIEWABLE_BUSINESS_ELEMENTS_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_VIEW_E__TRANSFORMER_ACTIVE:
                setTransformerActive(TRANSFORMER_ACTIVE_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_VIEW_E__WHERE_CONDITIONS:
                getWhereConditions().clear();
                return;
            case MdmserverobjectPackage.WS_VIEW_E__IS_TRANSFORMER_ACTIVE:
                setIsTransformerActive((WSBooleanE)null);
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
            case MdmserverobjectPackage.WS_VIEW_E__SEARCHABLE_BUSINESS_ELEMENTS:
                return SEARCHABLE_BUSINESS_ELEMENTS_EDEFAULT == null ? searchableBusinessElements != null : !SEARCHABLE_BUSINESS_ELEMENTS_EDEFAULT.equals(searchableBusinessElements);
            case MdmserverobjectPackage.WS_VIEW_E__VIEWABLE_BUSINESS_ELEMENTS:
                return VIEWABLE_BUSINESS_ELEMENTS_EDEFAULT == null ? viewableBusinessElements != null : !VIEWABLE_BUSINESS_ELEMENTS_EDEFAULT.equals(viewableBusinessElements);
            case MdmserverobjectPackage.WS_VIEW_E__TRANSFORMER_ACTIVE:
                return transformerActive != TRANSFORMER_ACTIVE_EDEFAULT;
            case MdmserverobjectPackage.WS_VIEW_E__WHERE_CONDITIONS:
                return whereConditions != null && !whereConditions.isEmpty();
            case MdmserverobjectPackage.WS_VIEW_E__IS_TRANSFORMER_ACTIVE:
                return isTransformerActive != null;
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
        result.append(" (searchableBusinessElements: ");
        result.append(searchableBusinessElements);
        result.append(", viewableBusinessElements: ");
        result.append(viewableBusinessElements);
        result.append(", transformerActive: ");
        result.append(transformerActive);
        result.append(')');
        return result.toString();
    }

    @Override
    public int getType() {
        return 8;
    }

} //WSViewEImpl
