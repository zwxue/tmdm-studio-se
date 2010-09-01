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
 * A representation of the model object '<em><b>Message Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.MessageFlow#getSource <em>Source</em>}</li>
 *   <li>{@link org.talend.process.model.process.MessageFlow#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getMessageFlow()
 * @model
 * @generated
 */
public interface MessageFlow extends Element {
    /**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.talend.process.model.process.ThrowMessageEvent#getOutgoingMessages <em>Outgoing Messages</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(ThrowMessageEvent)
     * @see org.talend.process.model.process.ProcessPackage#getMessageFlow_Source()
     * @see org.talend.process.model.process.ThrowMessageEvent#getOutgoingMessages
     * @model opposite="outgoingMessages" required="true"
     * @generated
     */
    ThrowMessageEvent getSource();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.MessageFlow#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
    void setSource(ThrowMessageEvent value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.talend.process.model.process.CatchMessageEvent#getIncomingMessag <em>Incoming Messag</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(CatchMessageEvent)
     * @see org.talend.process.model.process.ProcessPackage#getMessageFlow_Target()
     * @see org.talend.process.model.process.CatchMessageEvent#getIncomingMessag
     * @model opposite="incomingMessag" required="true"
     * @generated
     */
    CatchMessageEvent getTarget();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.MessageFlow#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(CatchMessageEvent value);

} // MessageFlow
