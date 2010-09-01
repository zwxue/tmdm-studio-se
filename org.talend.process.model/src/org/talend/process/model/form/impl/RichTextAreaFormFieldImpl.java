/**
 * Copyright (C) 2009 BonitaSoft S.A.
 * BonitaSoft, 31 rue Gustave Eiffel - 38000 Grenoble
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * $Id$
 */
package org.talend.process.model.form.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.talend.process.model.form.Duplicable;
import org.talend.process.model.form.FormPackage;
import org.talend.process.model.form.RichTextAreaFormField;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rich Text Area Form Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.form.impl.RichTextAreaFormFieldImpl#isDuplicate <em>Duplicate</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.RichTextAreaFormFieldImpl#isLimitNumberOfDuplication <em>Limit Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.RichTextAreaFormFieldImpl#getMaxNumberOfDuplication <em>Max Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.RichTextAreaFormFieldImpl#isLimitMinNumberOfDuplication <em>Limit Min Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.RichTextAreaFormFieldImpl#getMinNumberOfDuplication <em>Min Number Of Duplication</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.RichTextAreaFormFieldImpl#getDisplayLabelForAdd <em>Display Label For Add</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.RichTextAreaFormFieldImpl#getTooltipForAdd <em>Tooltip For Add</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.RichTextAreaFormFieldImpl#getDisplayLabelForRemove <em>Display Label For Remove</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.RichTextAreaFormFieldImpl#getTooltipForRemove <em>Tooltip For Remove</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RichTextAreaFormFieldImpl extends SingleValuatedFormFieldImpl implements RichTextAreaFormField {
    /**
     * The default value of the '{@link #isDuplicate() <em>Duplicate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDuplicate()
     * @generated
     * @ordered
     */
    protected static final boolean DUPLICATE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDuplicate() <em>Duplicate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDuplicate()
     * @generated
     * @ordered
     */
    protected boolean duplicate = DUPLICATE_EDEFAULT;

    /**
     * The default value of the '{@link #isLimitNumberOfDuplication() <em>Limit Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLimitNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected static final boolean LIMIT_NUMBER_OF_DUPLICATION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isLimitNumberOfDuplication() <em>Limit Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLimitNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected boolean limitNumberOfDuplication = LIMIT_NUMBER_OF_DUPLICATION_EDEFAULT;

    /**
     * The default value of the '{@link #getMaxNumberOfDuplication() <em>Max Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected static final String MAX_NUMBER_OF_DUPLICATION_EDEFAULT = "10"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getMaxNumberOfDuplication() <em>Max Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected String maxNumberOfDuplication = MAX_NUMBER_OF_DUPLICATION_EDEFAULT;

    /**
     * The default value of the '{@link #isLimitMinNumberOfDuplication() <em>Limit Min Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLimitMinNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected static final boolean LIMIT_MIN_NUMBER_OF_DUPLICATION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isLimitMinNumberOfDuplication() <em>Limit Min Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLimitMinNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected boolean limitMinNumberOfDuplication = LIMIT_MIN_NUMBER_OF_DUPLICATION_EDEFAULT;

    /**
     * The default value of the '{@link #getMinNumberOfDuplication() <em>Min Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMinNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected static final String MIN_NUMBER_OF_DUPLICATION_EDEFAULT = "2"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getMinNumberOfDuplication() <em>Min Number Of Duplication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMinNumberOfDuplication()
     * @generated
     * @ordered
     */
    protected String minNumberOfDuplication = MIN_NUMBER_OF_DUPLICATION_EDEFAULT;

    /**
     * The default value of the '{@link #getDisplayLabelForAdd() <em>Display Label For Add</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayLabelForAdd()
     * @generated
     * @ordered
     */
    protected static final String DISPLAY_LABEL_FOR_ADD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDisplayLabelForAdd() <em>Display Label For Add</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayLabelForAdd()
     * @generated
     * @ordered
     */
    protected String displayLabelForAdd = DISPLAY_LABEL_FOR_ADD_EDEFAULT;

    /**
     * The default value of the '{@link #getTooltipForAdd() <em>Tooltip For Add</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTooltipForAdd()
     * @generated
     * @ordered
     */
    protected static final String TOOLTIP_FOR_ADD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTooltipForAdd() <em>Tooltip For Add</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTooltipForAdd()
     * @generated
     * @ordered
     */
    protected String tooltipForAdd = TOOLTIP_FOR_ADD_EDEFAULT;

    /**
     * The default value of the '{@link #getDisplayLabelForRemove() <em>Display Label For Remove</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayLabelForRemove()
     * @generated
     * @ordered
     */
    protected static final String DISPLAY_LABEL_FOR_REMOVE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDisplayLabelForRemove() <em>Display Label For Remove</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayLabelForRemove()
     * @generated
     * @ordered
     */
    protected String displayLabelForRemove = DISPLAY_LABEL_FOR_REMOVE_EDEFAULT;

    /**
     * The default value of the '{@link #getTooltipForRemove() <em>Tooltip For Remove</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTooltipForRemove()
     * @generated
     * @ordered
     */
    protected static final String TOOLTIP_FOR_REMOVE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTooltipForRemove() <em>Tooltip For Remove</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTooltipForRemove()
     * @generated
     * @ordered
     */
    protected String tooltipForRemove = TOOLTIP_FOR_REMOVE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RichTextAreaFormFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FormPackage.Literals.RICH_TEXT_AREA_FORM_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDuplicate() {
        return duplicate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDuplicate(boolean newDuplicate) {
        boolean oldDuplicate = duplicate;
        duplicate = newDuplicate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.RICH_TEXT_AREA_FORM_FIELD__DUPLICATE, oldDuplicate, duplicate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isLimitNumberOfDuplication() {
        return limitNumberOfDuplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLimitNumberOfDuplication(boolean newLimitNumberOfDuplication) {
        boolean oldLimitNumberOfDuplication = limitNumberOfDuplication;
        limitNumberOfDuplication = newLimitNumberOfDuplication;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION, oldLimitNumberOfDuplication, limitNumberOfDuplication));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMaxNumberOfDuplication() {
        return maxNumberOfDuplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMaxNumberOfDuplication(String newMaxNumberOfDuplication) {
        String oldMaxNumberOfDuplication = maxNumberOfDuplication;
        maxNumberOfDuplication = newMaxNumberOfDuplication;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.RICH_TEXT_AREA_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION, oldMaxNumberOfDuplication, maxNumberOfDuplication));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isLimitMinNumberOfDuplication() {
        return limitMinNumberOfDuplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLimitMinNumberOfDuplication(boolean newLimitMinNumberOfDuplication) {
        boolean oldLimitMinNumberOfDuplication = limitMinNumberOfDuplication;
        limitMinNumberOfDuplication = newLimitMinNumberOfDuplication;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION, oldLimitMinNumberOfDuplication, limitMinNumberOfDuplication));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMinNumberOfDuplication() {
        return minNumberOfDuplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMinNumberOfDuplication(String newMinNumberOfDuplication) {
        String oldMinNumberOfDuplication = minNumberOfDuplication;
        minNumberOfDuplication = newMinNumberOfDuplication;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.RICH_TEXT_AREA_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION, oldMinNumberOfDuplication, minNumberOfDuplication));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDisplayLabelForAdd() {
        return displayLabelForAdd;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDisplayLabelForAdd(String newDisplayLabelForAdd) {
        String oldDisplayLabelForAdd = displayLabelForAdd;
        displayLabelForAdd = newDisplayLabelForAdd;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_ADD, oldDisplayLabelForAdd, displayLabelForAdd));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTooltipForAdd() {
        return tooltipForAdd;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTooltipForAdd(String newTooltipForAdd) {
        String oldTooltipForAdd = tooltipForAdd;
        tooltipForAdd = newTooltipForAdd;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_ADD, oldTooltipForAdd, tooltipForAdd));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDisplayLabelForRemove() {
        return displayLabelForRemove;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDisplayLabelForRemove(String newDisplayLabelForRemove) {
        String oldDisplayLabelForRemove = displayLabelForRemove;
        displayLabelForRemove = newDisplayLabelForRemove;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE, oldDisplayLabelForRemove, displayLabelForRemove));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTooltipForRemove() {
        return tooltipForRemove;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTooltipForRemove(String newTooltipForRemove) {
        String oldTooltipForRemove = tooltipForRemove;
        tooltipForRemove = newTooltipForRemove;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_REMOVE, oldTooltipForRemove, tooltipForRemove));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DUPLICATE:
                return isDuplicate();
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION:
                return isLimitNumberOfDuplication();
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION:
                return getMaxNumberOfDuplication();
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION:
                return isLimitMinNumberOfDuplication();
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION:
                return getMinNumberOfDuplication();
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_ADD:
                return getDisplayLabelForAdd();
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_ADD:
                return getTooltipForAdd();
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE:
                return getDisplayLabelForRemove();
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_REMOVE:
                return getTooltipForRemove();
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
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DUPLICATE:
                setDuplicate((Boolean)newValue);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION:
                setLimitNumberOfDuplication((Boolean)newValue);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION:
                setMaxNumberOfDuplication((String)newValue);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION:
                setLimitMinNumberOfDuplication((Boolean)newValue);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION:
                setMinNumberOfDuplication((String)newValue);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_ADD:
                setDisplayLabelForAdd((String)newValue);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_ADD:
                setTooltipForAdd((String)newValue);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE:
                setDisplayLabelForRemove((String)newValue);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_REMOVE:
                setTooltipForRemove((String)newValue);
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
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DUPLICATE:
                setDuplicate(DUPLICATE_EDEFAULT);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION:
                setLimitNumberOfDuplication(LIMIT_NUMBER_OF_DUPLICATION_EDEFAULT);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION:
                setMaxNumberOfDuplication(MAX_NUMBER_OF_DUPLICATION_EDEFAULT);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION:
                setLimitMinNumberOfDuplication(LIMIT_MIN_NUMBER_OF_DUPLICATION_EDEFAULT);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION:
                setMinNumberOfDuplication(MIN_NUMBER_OF_DUPLICATION_EDEFAULT);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_ADD:
                setDisplayLabelForAdd(DISPLAY_LABEL_FOR_ADD_EDEFAULT);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_ADD:
                setTooltipForAdd(TOOLTIP_FOR_ADD_EDEFAULT);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE:
                setDisplayLabelForRemove(DISPLAY_LABEL_FOR_REMOVE_EDEFAULT);
                return;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_REMOVE:
                setTooltipForRemove(TOOLTIP_FOR_REMOVE_EDEFAULT);
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
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DUPLICATE:
                return duplicate != DUPLICATE_EDEFAULT;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION:
                return limitNumberOfDuplication != LIMIT_NUMBER_OF_DUPLICATION_EDEFAULT;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION:
                return MAX_NUMBER_OF_DUPLICATION_EDEFAULT == null ? maxNumberOfDuplication != null : !MAX_NUMBER_OF_DUPLICATION_EDEFAULT.equals(maxNumberOfDuplication);
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION:
                return limitMinNumberOfDuplication != LIMIT_MIN_NUMBER_OF_DUPLICATION_EDEFAULT;
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION:
                return MIN_NUMBER_OF_DUPLICATION_EDEFAULT == null ? minNumberOfDuplication != null : !MIN_NUMBER_OF_DUPLICATION_EDEFAULT.equals(minNumberOfDuplication);
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_ADD:
                return DISPLAY_LABEL_FOR_ADD_EDEFAULT == null ? displayLabelForAdd != null : !DISPLAY_LABEL_FOR_ADD_EDEFAULT.equals(displayLabelForAdd);
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_ADD:
                return TOOLTIP_FOR_ADD_EDEFAULT == null ? tooltipForAdd != null : !TOOLTIP_FOR_ADD_EDEFAULT.equals(tooltipForAdd);
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE:
                return DISPLAY_LABEL_FOR_REMOVE_EDEFAULT == null ? displayLabelForRemove != null : !DISPLAY_LABEL_FOR_REMOVE_EDEFAULT.equals(displayLabelForRemove);
            case FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_REMOVE:
                return TOOLTIP_FOR_REMOVE_EDEFAULT == null ? tooltipForRemove != null : !TOOLTIP_FOR_REMOVE_EDEFAULT.equals(tooltipForRemove);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == Duplicable.class) {
            switch (derivedFeatureID) {
                case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DUPLICATE: return FormPackage.DUPLICABLE__DUPLICATE;
                case FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION: return FormPackage.DUPLICABLE__LIMIT_NUMBER_OF_DUPLICATION;
                case FormPackage.RICH_TEXT_AREA_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION: return FormPackage.DUPLICABLE__MAX_NUMBER_OF_DUPLICATION;
                case FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION: return FormPackage.DUPLICABLE__LIMIT_MIN_NUMBER_OF_DUPLICATION;
                case FormPackage.RICH_TEXT_AREA_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION: return FormPackage.DUPLICABLE__MIN_NUMBER_OF_DUPLICATION;
                case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_ADD: return FormPackage.DUPLICABLE__DISPLAY_LABEL_FOR_ADD;
                case FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_ADD: return FormPackage.DUPLICABLE__TOOLTIP_FOR_ADD;
                case FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE: return FormPackage.DUPLICABLE__DISPLAY_LABEL_FOR_REMOVE;
                case FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_REMOVE: return FormPackage.DUPLICABLE__TOOLTIP_FOR_REMOVE;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == Duplicable.class) {
            switch (baseFeatureID) {
                case FormPackage.DUPLICABLE__DUPLICATE: return FormPackage.RICH_TEXT_AREA_FORM_FIELD__DUPLICATE;
                case FormPackage.DUPLICABLE__LIMIT_NUMBER_OF_DUPLICATION: return FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_NUMBER_OF_DUPLICATION;
                case FormPackage.DUPLICABLE__MAX_NUMBER_OF_DUPLICATION: return FormPackage.RICH_TEXT_AREA_FORM_FIELD__MAX_NUMBER_OF_DUPLICATION;
                case FormPackage.DUPLICABLE__LIMIT_MIN_NUMBER_OF_DUPLICATION: return FormPackage.RICH_TEXT_AREA_FORM_FIELD__LIMIT_MIN_NUMBER_OF_DUPLICATION;
                case FormPackage.DUPLICABLE__MIN_NUMBER_OF_DUPLICATION: return FormPackage.RICH_TEXT_AREA_FORM_FIELD__MIN_NUMBER_OF_DUPLICATION;
                case FormPackage.DUPLICABLE__DISPLAY_LABEL_FOR_ADD: return FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_ADD;
                case FormPackage.DUPLICABLE__TOOLTIP_FOR_ADD: return FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_ADD;
                case FormPackage.DUPLICABLE__DISPLAY_LABEL_FOR_REMOVE: return FormPackage.RICH_TEXT_AREA_FORM_FIELD__DISPLAY_LABEL_FOR_REMOVE;
                case FormPackage.DUPLICABLE__TOOLTIP_FOR_REMOVE: return FormPackage.RICH_TEXT_AREA_FORM_FIELD__TOOLTIP_FOR_REMOVE;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (duplicate: "); //$NON-NLS-1$
        result.append(duplicate);
        result.append(", limitNumberOfDuplication: "); //$NON-NLS-1$
        result.append(limitNumberOfDuplication);
        result.append(", maxNumberOfDuplication: "); //$NON-NLS-1$
        result.append(maxNumberOfDuplication);
        result.append(", limitMinNumberOfDuplication: "); //$NON-NLS-1$
        result.append(limitMinNumberOfDuplication);
        result.append(", minNumberOfDuplication: "); //$NON-NLS-1$
        result.append(minNumberOfDuplication);
        result.append(", displayLabelForAdd: "); //$NON-NLS-1$
        result.append(displayLabelForAdd);
        result.append(", tooltipForAdd: "); //$NON-NLS-1$
        result.append(tooltipForAdd);
        result.append(", displayLabelForRemove: "); //$NON-NLS-1$
        result.append(displayLabelForRemove);
        result.append(", tooltipForRemove: "); //$NON-NLS-1$
        result.append(tooltipForRemove);
        result.append(')');
        return result.toString();
    }

} //RichTextAreaFormFieldImpl
