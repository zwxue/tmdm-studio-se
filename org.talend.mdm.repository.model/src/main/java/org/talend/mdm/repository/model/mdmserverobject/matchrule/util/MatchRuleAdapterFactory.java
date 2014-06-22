/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.talend.mdm.repository.model.mdmserverobject.matchrule.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage
 * @generated
 */
public class MatchRuleAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static MatchRulePackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MatchRuleAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = MatchRulePackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MatchRuleSwitch<Adapter> modelSwitch =
        new MatchRuleSwitch<Adapter>() {
            @Override
            public Adapter caseMatchRuleMapInfo(MatchRuleMapInfo object) {
                return createMatchRuleMapInfoAdapter();
            }
            @Override
            public Adapter caseEntityMapInfo(EntityMapInfo object) {
                return createEntityMapInfoAdapter();
            }
            @Override
            public Adapter caseMatchRuleMapInfoPage(MatchRuleMapInfoPage object) {
                return createMatchRuleMapInfoPageAdapter();
            }
            @Override
            public Adapter caseKeyXPathMap(Map.Entry<String, String> object) {
                return createKeyXPathMapAdapter();
            }
            @Override
            public Adapter caseBlockingKeyDefinition(BlockingKeyDefinition object) {
                return createBlockingKeyDefinitionAdapter();
            }
            @Override
            public Adapter caseBlockingKey(BlockingKey object) {
                return createBlockingKeyAdapter();
            }
            @Override
            public Adapter caseMatchRuleMapInfoContainer(MatchRuleMapInfoContainer object) {
                return createMatchRuleMapInfoContainerAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfo <em>Map Info</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfo
     * @generated
     */
    public Adapter createMatchRuleMapInfoAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo <em>Entity Map Info</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo
     * @generated
     */
    public Adapter createEntityMapInfoAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfoPage <em>Map Info Page</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfoPage
     * @generated
     */
    public Adapter createMatchRuleMapInfoPageAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Key XPath Map</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
    public Adapter createKeyXPathMapAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKeyDefinition <em>Blocking Key Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKeyDefinition
     * @generated
     */
    public Adapter createBlockingKeyDefinitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKey <em>Blocking Key</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.BlockingKey
     * @generated
     */
    public Adapter createBlockingKeyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfoContainer <em>Map Info Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfoContainer
     * @generated
     */
    public Adapter createMatchRuleMapInfoContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //MatchRuleAdapterFactory
