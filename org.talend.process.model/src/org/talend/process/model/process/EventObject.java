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
 * A representation of the model object '<em><b>Event Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.EventObject#getThrowEvent <em>Throw Event</em>}</li>
 *   <li>{@link org.talend.process.model.process.EventObject#getSource <em>Source</em>}</li>
 *   <li>{@link org.talend.process.model.process.EventObject#getTtl <em>Ttl</em>}</li>
 *   <li>{@link org.talend.process.model.process.EventObject#getTargetProcessName <em>Target Process Name</em>}</li>
 *   <li>{@link org.talend.process.model.process.EventObject#getTargetElementName <em>Target Element Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getEventObject()
 * @model
 * @generated
 */
public interface EventObject extends ConnectableElement {
    /**
     * Returns the value of the '<em><b>Throw Event</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Throw Event</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Throw Event</em>' attribute.
     * @see #setThrowEvent(String)
     * @see org.talend.process.model.process.ProcessPackage#getEventObject_ThrowEvent()
     * @model default="" required="true"
     * @generated
     */
    String getThrowEvent();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.EventObject#getThrowEvent <em>Throw Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Throw Event</em>' attribute.
     * @see #getThrowEvent()
     * @generated
     */
    void setThrowEvent(String value);

    /**
     * Returns the value of the '<em><b>Source</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.talend.process.model.process.ThrowMessageEvent#getEvents <em>Events</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' container reference.
     * @see #setSource(ThrowMessageEvent)
     * @see org.talend.process.model.process.ProcessPackage#getEventObject_Source()
     * @see org.talend.process.model.process.ThrowMessageEvent#getEvents
     * @model opposite="events" transient="false"
     * @generated
     */
    ThrowMessageEvent getSource();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.EventObject#getSource <em>Source</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' container reference.
     * @see #getSource()
     * @generated
     */
    void setSource(ThrowMessageEvent value);

    /**
     * Returns the value of the '<em><b>Ttl</b></em>' attribute.
     * The default value is <code>"31104000000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ttl</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ttl</em>' attribute.
     * @see #setTtl(String)
     * @see org.talend.process.model.process.ProcessPackage#getEventObject_Ttl()
     * @model default="31104000000"
     * @generated
     */
    String getTtl();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.EventObject#getTtl <em>Ttl</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ttl</em>' attribute.
     * @see #getTtl()
     * @generated
     */
    void setTtl(String value);

    /**
     * Returns the value of the '<em><b>Target Process Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Process Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Process Name</em>' attribute.
     * @see #setTargetProcessName(String)
     * @see org.talend.process.model.process.ProcessPackage#getEventObject_TargetProcessName()
     * @model
     * @generated
     */
    String getTargetProcessName();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.EventObject#getTargetProcessName <em>Target Process Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Process Name</em>' attribute.
     * @see #getTargetProcessName()
     * @generated
     */
    void setTargetProcessName(String value);

    /**
     * Returns the value of the '<em><b>Target Element Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Element Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Element Name</em>' attribute.
     * @see #setTargetElementName(String)
     * @see org.talend.process.model.process.ProcessPackage#getEventObject_TargetElementName()
     * @model
     * @generated
     */
    String getTargetElementName();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.EventObject#getTargetElementName <em>Target Element Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Element Name</em>' attribute.
     * @see #getTargetElementName()
     * @generated
     */
    void setTargetElementName(String value);

} // EventObject
