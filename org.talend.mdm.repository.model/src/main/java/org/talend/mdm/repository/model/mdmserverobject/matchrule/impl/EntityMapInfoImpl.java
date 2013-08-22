/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKeyDefinition;
import org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo;
import org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfo;
import org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Map Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.EntityMapInfoImpl#getEntityName <em>Entity Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.EntityMapInfoImpl#getMatchKeyMap <em>Match Key Map</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.EntityMapInfoImpl#getBlockingKeyDefinition <em>Blocking Key Definition</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.EntityMapInfoImpl#getMatchRuleName <em>Match Rule Name</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.EntityMapInfoImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityMapInfoImpl extends EObjectImpl implements EntityMapInfo {
    /**
     * The default value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntityName()
     * @generated
     * @ordered
     */
    protected static final String ENTITY_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntityName()
     * @generated
     * @ordered
     */
    protected String entityName = ENTITY_NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getMatchKeyMap() <em>Match Key Map</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMatchKeyMap()
     * @generated
     * @ordered
     */
    protected EMap<String, String> matchKeyMap;

    /**
     * The cached value of the '{@link #getBlockingKeyDefinition() <em>Blocking Key Definition</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlockingKeyDefinition()
     * @generated
     * @ordered
     */
    protected BlockingKeyDefinition blockingKeyDefinition;

    /**
     * The default value of the '{@link #getMatchRuleName() <em>Match Rule Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMatchRuleName()
     * @generated
     * @ordered
     */
    protected static final String MATCH_RULE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMatchRuleName() <em>Match Rule Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMatchRuleName()
     * @generated
     * @ordered
     */
    protected String matchRuleName = MATCH_RULE_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EntityMapInfoImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MatchRulePackage.Literals.ENTITY_MAP_INFO;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEntityName(String newEntityName) {
        String oldEntityName = entityName;
        entityName = newEntityName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MatchRulePackage.ENTITY_MAP_INFO__ENTITY_NAME, oldEntityName, entityName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getMatchKeyMap() {
        if (matchKeyMap == null) {
            matchKeyMap = new EcoreEMap<String,String>(MatchRulePackage.Literals.MATCH_KEY_XPATH_MAP, MatchKeyXPathMapImpl.class, this, MatchRulePackage.ENTITY_MAP_INFO__MATCH_KEY_MAP);
        }
        return matchKeyMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BlockingKeyDefinition getBlockingKeyDefinition() {
        return blockingKeyDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetBlockingKeyDefinition(BlockingKeyDefinition newBlockingKeyDefinition, NotificationChain msgs) {
        BlockingKeyDefinition oldBlockingKeyDefinition = blockingKeyDefinition;
        blockingKeyDefinition = newBlockingKeyDefinition;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MatchRulePackage.ENTITY_MAP_INFO__BLOCKING_KEY_DEFINITION, oldBlockingKeyDefinition, newBlockingKeyDefinition);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBlockingKeyDefinition(BlockingKeyDefinition newBlockingKeyDefinition) {
        if (newBlockingKeyDefinition != blockingKeyDefinition) {
            NotificationChain msgs = null;
            if (blockingKeyDefinition != null)
                msgs = ((InternalEObject)blockingKeyDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MatchRulePackage.ENTITY_MAP_INFO__BLOCKING_KEY_DEFINITION, null, msgs);
            if (newBlockingKeyDefinition != null)
                msgs = ((InternalEObject)newBlockingKeyDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MatchRulePackage.ENTITY_MAP_INFO__BLOCKING_KEY_DEFINITION, null, msgs);
            msgs = basicSetBlockingKeyDefinition(newBlockingKeyDefinition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MatchRulePackage.ENTITY_MAP_INFO__BLOCKING_KEY_DEFINITION, newBlockingKeyDefinition, newBlockingKeyDefinition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMatchRuleName() {
        return matchRuleName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMatchRuleName(String newMatchRuleName) {
        String oldMatchRuleName = matchRuleName;
        matchRuleName = newMatchRuleName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MatchRulePackage.ENTITY_MAP_INFO__MATCH_RULE_NAME, oldMatchRuleName, matchRuleName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MatchRuleMapInfo getParent() {
        if (eContainerFeatureID() != MatchRulePackage.ENTITY_MAP_INFO__PARENT) return null;
        return (MatchRuleMapInfo)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParent(MatchRuleMapInfo newParent, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParent, MatchRulePackage.ENTITY_MAP_INFO__PARENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParent(MatchRuleMapInfo newParent) {
        if (newParent != eInternalContainer() || (eContainerFeatureID() != MatchRulePackage.ENTITY_MAP_INFO__PARENT && newParent != null)) {
            if (EcoreUtil.isAncestor(this, newParent))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParent != null)
                msgs = ((InternalEObject)newParent).eInverseAdd(this, MatchRulePackage.MATCH_RULE_MAP_INFO__ENTITY_MAP_INFOS, MatchRuleMapInfo.class, msgs);
            msgs = basicSetParent(newParent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MatchRulePackage.ENTITY_MAP_INFO__PARENT, newParent, newParent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MatchRulePackage.ENTITY_MAP_INFO__PARENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParent((MatchRuleMapInfo)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MatchRulePackage.ENTITY_MAP_INFO__MATCH_KEY_MAP:
                return ((InternalEList<?>)getMatchKeyMap()).basicRemove(otherEnd, msgs);
            case MatchRulePackage.ENTITY_MAP_INFO__BLOCKING_KEY_DEFINITION:
                return basicSetBlockingKeyDefinition(null, msgs);
            case MatchRulePackage.ENTITY_MAP_INFO__PARENT:
                return basicSetParent(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case MatchRulePackage.ENTITY_MAP_INFO__PARENT:
                return eInternalContainer().eInverseRemove(this, MatchRulePackage.MATCH_RULE_MAP_INFO__ENTITY_MAP_INFOS, MatchRuleMapInfo.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MatchRulePackage.ENTITY_MAP_INFO__ENTITY_NAME:
                return getEntityName();
            case MatchRulePackage.ENTITY_MAP_INFO__MATCH_KEY_MAP:
                if (coreType) return getMatchKeyMap();
                else return getMatchKeyMap().map();
            case MatchRulePackage.ENTITY_MAP_INFO__BLOCKING_KEY_DEFINITION:
                return getBlockingKeyDefinition();
            case MatchRulePackage.ENTITY_MAP_INFO__MATCH_RULE_NAME:
                return getMatchRuleName();
            case MatchRulePackage.ENTITY_MAP_INFO__PARENT:
                return getParent();
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
            case MatchRulePackage.ENTITY_MAP_INFO__ENTITY_NAME:
                setEntityName((String)newValue);
                return;
            case MatchRulePackage.ENTITY_MAP_INFO__MATCH_KEY_MAP:
                ((EStructuralFeature.Setting)getMatchKeyMap()).set(newValue);
                return;
            case MatchRulePackage.ENTITY_MAP_INFO__BLOCKING_KEY_DEFINITION:
                setBlockingKeyDefinition((BlockingKeyDefinition)newValue);
                return;
            case MatchRulePackage.ENTITY_MAP_INFO__MATCH_RULE_NAME:
                setMatchRuleName((String)newValue);
                return;
            case MatchRulePackage.ENTITY_MAP_INFO__PARENT:
                setParent((MatchRuleMapInfo)newValue);
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
            case MatchRulePackage.ENTITY_MAP_INFO__ENTITY_NAME:
                setEntityName(ENTITY_NAME_EDEFAULT);
                return;
            case MatchRulePackage.ENTITY_MAP_INFO__MATCH_KEY_MAP:
                getMatchKeyMap().clear();
                return;
            case MatchRulePackage.ENTITY_MAP_INFO__BLOCKING_KEY_DEFINITION:
                setBlockingKeyDefinition((BlockingKeyDefinition)null);
                return;
            case MatchRulePackage.ENTITY_MAP_INFO__MATCH_RULE_NAME:
                setMatchRuleName(MATCH_RULE_NAME_EDEFAULT);
                return;
            case MatchRulePackage.ENTITY_MAP_INFO__PARENT:
                setParent((MatchRuleMapInfo)null);
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
            case MatchRulePackage.ENTITY_MAP_INFO__ENTITY_NAME:
                return ENTITY_NAME_EDEFAULT == null ? entityName != null : !ENTITY_NAME_EDEFAULT.equals(entityName);
            case MatchRulePackage.ENTITY_MAP_INFO__MATCH_KEY_MAP:
                return matchKeyMap != null && !matchKeyMap.isEmpty();
            case MatchRulePackage.ENTITY_MAP_INFO__BLOCKING_KEY_DEFINITION:
                return blockingKeyDefinition != null;
            case MatchRulePackage.ENTITY_MAP_INFO__MATCH_RULE_NAME:
                return MATCH_RULE_NAME_EDEFAULT == null ? matchRuleName != null : !MATCH_RULE_NAME_EDEFAULT.equals(matchRuleName);
            case MatchRulePackage.ENTITY_MAP_INFO__PARENT:
                return getParent() != null;
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
        result.append(" (entityName: ");
        result.append(entityName);
        result.append(", matchRuleName: ");
        result.append(matchRuleName);
        result.append(')');
        return result.toString();
    }

} //EntityMapInfoImpl
