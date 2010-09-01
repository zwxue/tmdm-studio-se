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
package org.talend.process.model.simulation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.process.model.simulation.SimulationPackage;
import org.talend.process.model.simulation.SimulationTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.process.model.simulation.impl.SimulationTransitionImpl#getProbability <em>Probability</em>}</li>
 *   <li>{@link org.talend.process.model.simulation.impl.SimulationTransitionImpl#isDataBased <em>Data Based</em>}</li>
 *   <li>{@link org.talend.process.model.simulation.impl.SimulationTransitionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.talend.process.model.simulation.impl.SimulationTransitionImpl#isUseExpression <em>Use Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulationTransitionImpl extends EObjectImpl implements SimulationTransition {
    /**
     * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProbability()
     * @generated
     * @ordered
     */
    protected static final double PROBABILITY_EDEFAULT = 1.0;

    /**
     * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProbability()
     * @generated
     * @ordered
     */
    protected double probability = PROBABILITY_EDEFAULT;

    /**
     * The default value of the '{@link #isDataBased() <em>Data Based</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDataBased()
     * @generated
     * @ordered
     */
    protected static final boolean DATA_BASED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDataBased() <em>Data Based</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDataBased()
     * @generated
     * @ordered
     */
    protected boolean dataBased = DATA_BASED_EDEFAULT;

    /**
     * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExpression()
     * @generated
     * @ordered
     */
    protected static final String EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExpression()
     * @generated
     * @ordered
     */
    protected String expression = EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #isUseExpression() <em>Use Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUseExpression()
     * @generated
     * @ordered
     */
    protected static final boolean USE_EXPRESSION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isUseExpression() <em>Use Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUseExpression()
     * @generated
     * @ordered
     */
    protected boolean useExpression = USE_EXPRESSION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SimulationTransitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimulationPackage.Literals.SIMULATION_TRANSITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getProbability() {
        return probability;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProbability(double newProbability) {
        double oldProbability = probability;
        probability = newProbability;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.SIMULATION_TRANSITION__PROBABILITY, oldProbability, probability));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDataBased() {
        return dataBased;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataBased(boolean newDataBased) {
        boolean oldDataBased = dataBased;
        dataBased = newDataBased;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.SIMULATION_TRANSITION__DATA_BASED, oldDataBased, dataBased));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExpression() {
        return expression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExpression(String newExpression) {
        String oldExpression = expression;
        expression = newExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.SIMULATION_TRANSITION__EXPRESSION, oldExpression, expression));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isUseExpression() {
        return useExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUseExpression(boolean newUseExpression) {
        boolean oldUseExpression = useExpression;
        useExpression = newUseExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimulationPackage.SIMULATION_TRANSITION__USE_EXPRESSION, oldUseExpression, useExpression));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SimulationPackage.SIMULATION_TRANSITION__PROBABILITY:
                return getProbability();
            case SimulationPackage.SIMULATION_TRANSITION__DATA_BASED:
                return isDataBased();
            case SimulationPackage.SIMULATION_TRANSITION__EXPRESSION:
                return getExpression();
            case SimulationPackage.SIMULATION_TRANSITION__USE_EXPRESSION:
                return isUseExpression();
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
            case SimulationPackage.SIMULATION_TRANSITION__PROBABILITY:
                setProbability((Double)newValue);
                return;
            case SimulationPackage.SIMULATION_TRANSITION__DATA_BASED:
                setDataBased((Boolean)newValue);
                return;
            case SimulationPackage.SIMULATION_TRANSITION__EXPRESSION:
                setExpression((String)newValue);
                return;
            case SimulationPackage.SIMULATION_TRANSITION__USE_EXPRESSION:
                setUseExpression((Boolean)newValue);
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
            case SimulationPackage.SIMULATION_TRANSITION__PROBABILITY:
                setProbability(PROBABILITY_EDEFAULT);
                return;
            case SimulationPackage.SIMULATION_TRANSITION__DATA_BASED:
                setDataBased(DATA_BASED_EDEFAULT);
                return;
            case SimulationPackage.SIMULATION_TRANSITION__EXPRESSION:
                setExpression(EXPRESSION_EDEFAULT);
                return;
            case SimulationPackage.SIMULATION_TRANSITION__USE_EXPRESSION:
                setUseExpression(USE_EXPRESSION_EDEFAULT);
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
            case SimulationPackage.SIMULATION_TRANSITION__PROBABILITY:
                return probability != PROBABILITY_EDEFAULT;
            case SimulationPackage.SIMULATION_TRANSITION__DATA_BASED:
                return dataBased != DATA_BASED_EDEFAULT;
            case SimulationPackage.SIMULATION_TRANSITION__EXPRESSION:
                return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
            case SimulationPackage.SIMULATION_TRANSITION__USE_EXPRESSION:
                return useExpression != USE_EXPRESSION_EDEFAULT;
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
        result.append(" (probability: "); //$NON-NLS-1$
        result.append(probability);
        result.append(", dataBased: "); //$NON-NLS-1$
        result.append(dataBased);
        result.append(", expression: "); //$NON-NLS-1$
        result.append(expression);
        result.append(", useExpression: "); //$NON-NLS-1$
        result.append(useExpression);
        result.append(')');
        return result.toString();
    }

} //SimulationTransitionImpl
