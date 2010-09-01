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
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.Task#isOverrideGroupsOfTheLane <em>Override Groups Of The Lane</em>}</li>
 *   <li>{@link org.talend.process.model.process.Task#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends Activity, PageFlow, ResourceContainer, Assignable {
    /**
     * Returns the value of the '<em><b>Override Groups Of The Lane</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Override Groups Of The Lane</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Override Groups Of The Lane</em>' attribute.
     * @see #setOverrideGroupsOfTheLane(boolean)
     * @see org.talend.process.model.process.ProcessPackage#getTask_OverrideGroupsOfTheLane()
     * @model
     * @generated
     */
    boolean isOverrideGroupsOfTheLane();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Task#isOverrideGroupsOfTheLane <em>Override Groups Of The Lane</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Override Groups Of The Lane</em>' attribute.
     * @see #isOverrideGroupsOfTheLane()
     * @generated
     */
    void setOverrideGroupsOfTheLane(boolean value);

    /**
     * Returns the value of the '<em><b>Priority</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Priority</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Priority</em>' attribute.
     * @see #setPriority(int)
     * @see org.talend.process.model.process.ProcessPackage#getTask_Priority()
     * @model default="0"
     * @generated
     */
    int getPriority();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.Task#getPriority <em>Priority</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Priority</em>' attribute.
     * @see #getPriority()
     * @generated
     */
    void setPriority(int value);

} // Task
