/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule.impl;

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

import org.talend.dataquality.rules.MatchRuleDefinition;

import org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfo;
import org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfoContainer;
import org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Info Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.MatchRuleMapInfoContainerImpl#getMapInfos <em>Map Infos</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.MatchRuleMapInfoContainerImpl#getMatchRuleDefinitions <em>Match Rule Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatchRuleMapInfoContainerImpl extends EObjectImpl implements MatchRuleMapInfoContainer {
    /**
     * The cached value of the '{@link #getMapInfos() <em>Map Infos</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMapInfos()
     * @generated
     * @ordered
     */
    protected MatchRuleMapInfo mapInfos;

    /**
     * The cached value of the '{@link #getMatchRuleDefinitions() <em>Match Rule Definitions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMatchRuleDefinitions()
     * @generated
     * @ordered
     */
    protected EList<MatchRuleDefinition> matchRuleDefinitions;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MatchRuleMapInfoContainerImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MatchRulePackage.Literals.MATCH_RULE_MAP_INFO_CONTAINER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MatchRuleMapInfo getMapInfos() {
        return mapInfos;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMapInfos(MatchRuleMapInfo newMapInfos, NotificationChain msgs) {
        MatchRuleMapInfo oldMapInfos = mapInfos;
        mapInfos = newMapInfos;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MAP_INFOS, oldMapInfos, newMapInfos);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMapInfos(MatchRuleMapInfo newMapInfos) {
        if (newMapInfos != mapInfos) {
            NotificationChain msgs = null;
            if (mapInfos != null)
                msgs = ((InternalEObject)mapInfos).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MAP_INFOS, null, msgs);
            if (newMapInfos != null)
                msgs = ((InternalEObject)newMapInfos).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MAP_INFOS, null, msgs);
            msgs = basicSetMapInfos(newMapInfos, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MAP_INFOS, newMapInfos, newMapInfos));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MatchRuleDefinition> getMatchRuleDefinitions() {
        if (matchRuleDefinitions == null) {
            matchRuleDefinitions = new EObjectContainmentEList<MatchRuleDefinition>(MatchRuleDefinition.class, this, MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MATCH_RULE_DEFINITIONS);
        }
        return matchRuleDefinitions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MAP_INFOS:
                return basicSetMapInfos(null, msgs);
            case MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MATCH_RULE_DEFINITIONS:
                return ((InternalEList<?>)getMatchRuleDefinitions()).basicRemove(otherEnd, msgs);
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
            case MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MAP_INFOS:
                return getMapInfos();
            case MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MATCH_RULE_DEFINITIONS:
                return getMatchRuleDefinitions();
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
            case MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MAP_INFOS:
                setMapInfos((MatchRuleMapInfo)newValue);
                return;
            case MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MATCH_RULE_DEFINITIONS:
                getMatchRuleDefinitions().clear();
                getMatchRuleDefinitions().addAll((Collection<? extends MatchRuleDefinition>)newValue);
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
            case MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MAP_INFOS:
                setMapInfos((MatchRuleMapInfo)null);
                return;
            case MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MATCH_RULE_DEFINITIONS:
                getMatchRuleDefinitions().clear();
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
            case MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MAP_INFOS:
                return mapInfos != null;
            case MatchRulePackage.MATCH_RULE_MAP_INFO_CONTAINER__MATCH_RULE_DEFINITIONS:
                return matchRuleDefinitions != null && !matchRuleDefinitions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //MatchRuleMapInfoContainerImpl
