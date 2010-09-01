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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throw Signal Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.ThrowSignalEvent#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getThrowSignalEvent()
 * @model
 * @generated
 */
public interface ThrowSignalEvent extends SignalEvent {
    /**
     * Returns the value of the '<em><b>Events</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.EventObject}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Events</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getThrowSignalEvent_Events()
     * @model containment="true"
     * @generated
     */
    EList<EventObject> getEvents();

} // ThrowSignalEvent
