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

import org.talend.process.model.kpi.AbstractKPIBinding;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connectable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.ConnectableElement#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.process.ConnectableElement#getData <em>Data</em>}</li>
 *   <li>{@link org.talend.process.model.process.ConnectableElement#getKpis <em>Kpis</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getConnectableElement()
 * @model
 * @generated
 */
public interface ConnectableElement extends Element {
    /**
     * Returns the value of the '<em><b>Connectors</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Connector}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connectors</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connectors</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getConnectableElement_Connectors()
     * @model containment="true"
     * @generated
     */
    EList<Connector> getConnectors();

    /**
     * Returns the value of the '<em><b>Data</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Data}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getConnectableElement_Data()
     * @model containment="true"
     * @generated
     */
    EList<Data> getData();

    /**
     * Returns the value of the '<em><b>Kpis</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.kpi.AbstractKPIBinding}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Kpis</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Kpis</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getConnectableElement_Kpis()
     * @model containment="true"
     * @generated
     */
    EList<AbstractKPIBinding> getKpis();

} // ConnectableElement
