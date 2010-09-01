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
package org.talend.process.model.kpi;

import org.eclipse.emf.common.util.EList;

import org.talend.process.model.process.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract KPI Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.kpi.AbstractKPIDefinition#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.kpi.KpiPackage#getAbstractKPIDefinition()
 * @model abstract="true"
 * @generated
 */
public interface AbstractKPIDefinition extends Element {
    /**
     * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.kpi.KPIField}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fields</em>' containment reference list.
     * @see org.talend.process.model.kpi.KpiPackage#getAbstractKPIDefinition_Fields()
     * @model containment="true"
     * @generated
     */
    EList<KPIField> getFields();

} // AbstractKPIDefinition
