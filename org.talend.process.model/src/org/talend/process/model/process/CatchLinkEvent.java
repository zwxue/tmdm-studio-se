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
 * A representation of the model object '<em><b>Catch Link Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.CatchLinkEvent#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getCatchLinkEvent()
 * @model
 * @generated
 */
public interface CatchLinkEvent extends LinkEvent {
    /**
     * Returns the value of the '<em><b>From</b></em>' reference list.
     * The list contents are of type {@link org.talend.process.model.process.ThrowLinkEvent}.
     * It is bidirectional and its opposite is '{@link org.talend.process.model.process.ThrowLinkEvent#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>From</em>' reference list.
     * @see org.talend.process.model.process.ProcessPackage#getCatchLinkEvent_From()
     * @see org.talend.process.model.process.ThrowLinkEvent#getTo
     * @model opposite="to"
     * @generated
     */
    EList<ThrowLinkEvent> getFrom();

} // CatchLinkEvent
