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
package org.talend.process.model.process;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catch Signal Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.CatchSignalEvent#getSignal <em>Signal</em>}</li>
 *   <li>{@link org.talend.process.model.process.CatchSignalEvent#getMatcher <em>Matcher</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getCatchSignalEvent()
 * @model
 * @generated
 */
public interface CatchSignalEvent extends SignalEvent, ConnectableElement {
    /**
     * Returns the value of the '<em><b>Signal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signal</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Signal</em>' attribute.
     * @see #setSignal(String)
     * @see org.talend.process.model.process.ProcessPackage#getCatchSignalEvent_Signal()
     * @model
     * @generated
     */
    String getSignal();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.CatchSignalEvent#getSignal <em>Signal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Signal</em>' attribute.
     * @see #getSignal()
     * @generated
     */
    void setSignal(String value);

    /**
     * Returns the value of the '<em><b>Matcher</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Matcher</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Matcher</em>' attribute.
     * @see #setMatcher(String)
     * @see org.talend.process.model.process.ProcessPackage#getCatchSignalEvent_Matcher()
     * @model
     * @generated
     */
    String getMatcher();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.CatchSignalEvent#getMatcher <em>Matcher</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Matcher</em>' attribute.
     * @see #getMatcher()
     * @generated
     */
    void setMatcher(String value);

} // CatchSignalEvent
