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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.Assignable#getUser <em>User</em>}</li>
 *   <li>{@link org.talend.process.model.process.Assignable#getFilters <em>Filters</em>}</li>
 *   <li>{@link org.talend.process.model.process.Assignable#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.talend.process.model.process.Assignable#getActorType <em>Actor Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getAssignable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Assignable extends EObject {
    /**
     * Returns the value of the '<em><b>User</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>User</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>User</em>' attribute.
     * @see #setUser(String)
     * @see org.talend.process.model.process.ProcessPackage#getAssignable_User()
     * @model
     * @generated
     */
    String getUser();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Assignable#getUser <em>User</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>User</em>' attribute.
     * @see #getUser()
     * @generated
     */
    void setUser(String value);

    /**
     * Returns the value of the '<em><b>Filters</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Connector}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Filters</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Filters</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getAssignable_Filters()
     * @model containment="true"
     * @generated
     */
    EList<Connector> getFilters();

    /**
     * Returns the value of the '<em><b>Groups</b></em>' reference list.
     * The list contents are of type {@link org.talend.process.model.process.Group}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Groups</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Groups</em>' reference list.
     * @see org.talend.process.model.process.ProcessPackage#getAssignable_Groups()
     * @model
     * @generated
     */
    EList<Group> getGroups();

    /**
     * Returns the value of the '<em><b>Actor Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.talend.process.model.process.ActorType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Actor Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Actor Type</em>' attribute.
     * @see org.talend.process.model.process.ActorType
     * @see #setActorType(ActorType)
     * @see org.talend.process.model.process.ProcessPackage#getAssignable_ActorType()
     * @model
     * @generated
     */
    ActorType getActorType();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Assignable#getActorType <em>Actor Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Actor Type</em>' attribute.
     * @see org.talend.process.model.process.ActorType
     * @see #getActorType()
     * @generated
     */
    void setActorType(ActorType value);

} // Assignable
