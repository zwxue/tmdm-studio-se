/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.talend.mdm.repository.model.mdmserverobject.matchrule.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage
 * @generated
 */
public class MatchRuleSwitch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static MatchRulePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MatchRuleSwitch() {
        if (modelPackage == null) {
            modelPackage = MatchRulePackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case MatchRulePackage.MATCH_RULE_MAP_INFO: {
                MatchRuleMapInfo matchRuleMapInfo = (MatchRuleMapInfo)theEObject;
                T result = caseMatchRuleMapInfo(matchRuleMapInfo);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MatchRulePackage.ENTITY_MAP_INFO: {
                EntityMapInfo entityMapInfo = (EntityMapInfo)theEObject;
                T result = caseEntityMapInfo(entityMapInfo);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MatchRulePackage.KEY_XPATH_MAP: {
                @SuppressWarnings("unchecked") Map.Entry<String, String> keyXPathMap = (Map.Entry<String, String>)theEObject;
                T result = caseKeyXPathMap(keyXPathMap);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MatchRulePackage.BLOCKING_KEY_DEFINITION: {
                BlockingKeyDefinition blockingKeyDefinition = (BlockingKeyDefinition)theEObject;
                T result = caseBlockingKeyDefinition(blockingKeyDefinition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MatchRulePackage.BLOCKING_KEY: {
                BlockingKey blockingKey = (BlockingKey)theEObject;
                T result = caseBlockingKey(blockingKey);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Map Info</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Map Info</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMatchRuleMapInfo(MatchRuleMapInfo object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Entity Map Info</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity Map Info</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntityMapInfo(EntityMapInfo object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Key XPath Map</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Key XPath Map</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKeyXPathMap(Map.Entry<String, String> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Blocking Key Definition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Blocking Key Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBlockingKeyDefinition(BlockingKeyDefinition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Blocking Key</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Blocking Key</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBlockingKey(BlockingKey object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
        return null;
    }

} //MatchRuleSwitch
