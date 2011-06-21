/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.talend.mdm.repository.model.mdmserverobject.*;

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
 * @see org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage
 * @generated
 */
public class MdmserverobjectSwitch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static MdmserverobjectPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MdmserverobjectSwitch() {
        if (modelPackage == null) {
            modelPackage = MdmserverobjectPackage.eINSTANCE;
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
            case MdmserverobjectPackage.MDM_SERVER_OBJECT: {
                MDMServerObject mdmServerObject = (MDMServerObject)theEObject;
                T result = caseMDMServerObject(mdmServerObject);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.EWS_MENU: {
                EWSMenu ewsMenu = (EWSMenu)theEObject;
                T result = caseEWSMenu(ewsMenu);
                if (result == null) result = caseMDMServerObject(ewsMenu);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.EWS_MENU_ENTRY: {
                EWSMenuEntry ewsMenuEntry = (EWSMenuEntry)theEObject;
                T result = caseEWSMenuEntry(ewsMenuEntry);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_MENU_MENU_ENTRIES_DESCRIPTIONS_E: {
                WSMenuMenuEntriesDescriptionsE wsMenuMenuEntriesDescriptionsE = (WSMenuMenuEntriesDescriptionsE)theEObject;
                T result = caseWSMenuMenuEntriesDescriptionsE(wsMenuMenuEntriesDescriptionsE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROLE_E: {
                WSRoleE wsRoleE = (WSRoleE)theEObject;
                T result = caseWSRoleE(wsRoleE);
                if (result == null) result = caseMDMServerObject(wsRoleE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_E: {
                WSRoleSpecificationE wsRoleSpecificationE = (WSRoleSpecificationE)theEObject;
                T result = caseWSRoleSpecificationE(wsRoleSpecificationE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MdmserverobjectPackage.WS_ROLE_SPECIFICATION_INSTANCE_E: {
                WSRoleSpecificationInstanceE wsRoleSpecificationInstanceE = (WSRoleSpecificationInstanceE)theEObject;
                T result = caseWSRoleSpecificationInstanceE(wsRoleSpecificationInstanceE);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>MDM Server Object</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MDM Server Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMDMServerObject(MDMServerObject object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EWS Menu</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EWS Menu</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEWSMenu(EWSMenu object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EWS Menu Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EWS Menu Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEWSMenuEntry(EWSMenuEntry object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Menu Menu Entries Descriptions E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Menu Menu Entries Descriptions E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSMenuMenuEntriesDescriptionsE(WSMenuMenuEntriesDescriptionsE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Role E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Role E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSRoleE(WSRoleE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Role Specification E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Role Specification E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSRoleSpecificationE(WSRoleSpecificationE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>WS Role Specification Instance E</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>WS Role Specification Instance E</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWSRoleSpecificationInstanceE(WSRoleSpecificationInstanceE object) {
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

} //MdmserverobjectSwitch
