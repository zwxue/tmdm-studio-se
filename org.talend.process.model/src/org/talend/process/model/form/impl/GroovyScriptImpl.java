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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.process.model.form.FormPackage;
import org.talend.process.model.form.GroovyScript;

import org.talend.process.model.process.Data;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Groovy Script</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.form.impl.GroovyScriptImpl#getExprScript <em>Expr Script</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroovyScriptImpl#getInputScript <em>Input Script</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroovyScriptImpl#getSetVar <em>Set Var</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroovyScriptImpl#isAllowHTMLInValues <em>Allow HTML In Values</em>}</li>
 *   <li>{@link org.talend.process.model.form.impl.GroovyScriptImpl#getSetVarScript <em>Set Var Script</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroovyScriptImpl extends EObjectImpl implements GroovyScript {
    /**
     * The default value of the '{@link #getExprScript() <em>Expr Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExprScript()
     * @generated
     * @ordered
     */
    protected static final String EXPR_SCRIPT_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getExprScript() <em>Expr Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExprScript()
     * @generated
     * @ordered
     */
    protected String exprScript = EXPR_SCRIPT_EDEFAULT;

    /**
     * The default value of the '{@link #getInputScript() <em>Input Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputScript()
     * @generated
     * @ordered
     */
    protected static final String INPUT_SCRIPT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInputScript() <em>Input Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputScript()
     * @generated
     * @ordered
     */
    protected String inputScript = INPUT_SCRIPT_EDEFAULT;

    /**
     * The cached value of the '{@link #getSetVar() <em>Set Var</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSetVar()
     * @generated
     * @ordered
     */
    protected Data setVar;

    /**
     * The default value of the '{@link #isAllowHTMLInValues() <em>Allow HTML In Values</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAllowHTMLInValues()
     * @generated
     * @ordered
     */
    protected static final boolean ALLOW_HTML_IN_VALUES_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAllowHTMLInValues() <em>Allow HTML In Values</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAllowHTMLInValues()
     * @generated
     * @ordered
     */
    protected boolean allowHTMLInValues = ALLOW_HTML_IN_VALUES_EDEFAULT;

    /**
     * The default value of the '{@link #getSetVarScript() <em>Set Var Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSetVarScript()
     * @generated
     * @ordered
     */
    protected static final String SET_VAR_SCRIPT_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getSetVarScript() <em>Set Var Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSetVarScript()
     * @generated
     * @ordered
     */
    protected String setVarScript = SET_VAR_SCRIPT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GroovyScriptImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FormPackage.Literals.GROOVY_SCRIPT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExprScript() {
        return exprScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExprScript(String newExprScript) {
        String oldExprScript = exprScript;
        exprScript = newExprScript;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROOVY_SCRIPT__EXPR_SCRIPT, oldExprScript, exprScript));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInputScript() {
        return inputScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInputScript(String newInputScript) {
        String oldInputScript = inputScript;
        inputScript = newInputScript;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROOVY_SCRIPT__INPUT_SCRIPT, oldInputScript, inputScript));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data getSetVar() {
        if (setVar != null && setVar.eIsProxy()) {
            InternalEObject oldSetVar = (InternalEObject)setVar;
            setVar = (Data)eResolveProxy(oldSetVar);
            if (setVar != oldSetVar) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormPackage.GROOVY_SCRIPT__SET_VAR, oldSetVar, setVar));
            }
        }
        return setVar;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Data basicGetSetVar() {
        return setVar;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSetVar(Data newSetVar) {
        Data oldSetVar = setVar;
        setVar = newSetVar;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROOVY_SCRIPT__SET_VAR, oldSetVar, setVar));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAllowHTMLInValues() {
        return allowHTMLInValues;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAllowHTMLInValues(boolean newAllowHTMLInValues) {
        boolean oldAllowHTMLInValues = allowHTMLInValues;
        allowHTMLInValues = newAllowHTMLInValues;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROOVY_SCRIPT__ALLOW_HTML_IN_VALUES, oldAllowHTMLInValues, allowHTMLInValues));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSetVarScript() {
        return setVarScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSetVarScript(String newSetVarScript) {
        String oldSetVarScript = setVarScript;
        setVarScript = newSetVarScript;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.GROOVY_SCRIPT__SET_VAR_SCRIPT, oldSetVarScript, setVarScript));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FormPackage.GROOVY_SCRIPT__EXPR_SCRIPT:
                return getExprScript();
            case FormPackage.GROOVY_SCRIPT__INPUT_SCRIPT:
                return getInputScript();
            case FormPackage.GROOVY_SCRIPT__SET_VAR:
                if (resolve) return getSetVar();
                return basicGetSetVar();
            case FormPackage.GROOVY_SCRIPT__ALLOW_HTML_IN_VALUES:
                return isAllowHTMLInValues();
            case FormPackage.GROOVY_SCRIPT__SET_VAR_SCRIPT:
                return getSetVarScript();
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
            case FormPackage.GROOVY_SCRIPT__EXPR_SCRIPT:
                setExprScript((String)newValue);
                return;
            case FormPackage.GROOVY_SCRIPT__INPUT_SCRIPT:
                setInputScript((String)newValue);
                return;
            case FormPackage.GROOVY_SCRIPT__SET_VAR:
                setSetVar((Data)newValue);
                return;
            case FormPackage.GROOVY_SCRIPT__ALLOW_HTML_IN_VALUES:
                setAllowHTMLInValues((Boolean)newValue);
                return;
            case FormPackage.GROOVY_SCRIPT__SET_VAR_SCRIPT:
                setSetVarScript((String)newValue);
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
            case FormPackage.GROOVY_SCRIPT__EXPR_SCRIPT:
                setExprScript(EXPR_SCRIPT_EDEFAULT);
                return;
            case FormPackage.GROOVY_SCRIPT__INPUT_SCRIPT:
                setInputScript(INPUT_SCRIPT_EDEFAULT);
                return;
            case FormPackage.GROOVY_SCRIPT__SET_VAR:
                setSetVar((Data)null);
                return;
            case FormPackage.GROOVY_SCRIPT__ALLOW_HTML_IN_VALUES:
                setAllowHTMLInValues(ALLOW_HTML_IN_VALUES_EDEFAULT);
                return;
            case FormPackage.GROOVY_SCRIPT__SET_VAR_SCRIPT:
                setSetVarScript(SET_VAR_SCRIPT_EDEFAULT);
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
            case FormPackage.GROOVY_SCRIPT__EXPR_SCRIPT:
                return EXPR_SCRIPT_EDEFAULT == null ? exprScript != null : !EXPR_SCRIPT_EDEFAULT.equals(exprScript);
            case FormPackage.GROOVY_SCRIPT__INPUT_SCRIPT:
                return INPUT_SCRIPT_EDEFAULT == null ? inputScript != null : !INPUT_SCRIPT_EDEFAULT.equals(inputScript);
            case FormPackage.GROOVY_SCRIPT__SET_VAR:
                return setVar != null;
            case FormPackage.GROOVY_SCRIPT__ALLOW_HTML_IN_VALUES:
                return allowHTMLInValues != ALLOW_HTML_IN_VALUES_EDEFAULT;
            case FormPackage.GROOVY_SCRIPT__SET_VAR_SCRIPT:
                return SET_VAR_SCRIPT_EDEFAULT == null ? setVarScript != null : !SET_VAR_SCRIPT_EDEFAULT.equals(setVarScript);
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
        result.append(" (exprScript: "); //$NON-NLS-1$
        result.append(exprScript);
        result.append(", inputScript: "); //$NON-NLS-1$
        result.append(inputScript);
        result.append(", allowHTMLInValues: "); //$NON-NLS-1$
        result.append(allowHTMLInValues);
        result.append(", setVarScript: "); //$NON-NLS-1$
        result.append(setVarScript);
        result.append(')');
        return result.toString();
    }

} //GroovyScriptImpl
