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

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.talend.process.model.simulation.SimulationAbstractProcess;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getVersion <em>Version</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getModificationDate <em>Modification Date</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getDatatypes <em>Datatypes</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getMandatorySymbol <em>Mandatory Symbol</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getMandatoryClasses <em>Mandatory Classes</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getMandatoryLabel <em>Mandatory Label</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getErrorTemplate <em>Error Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getProcessTemplate <em>Process Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getPageTemplate <em>Page Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getConsultationTemplate <em>Consultation Template</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getLogInPage <em>Log In Page</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getWelcomePage <em>Welcome Page</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getWelcomePageInternal <em>Welcome Page Internal</em>}</li>
 *   <li>{@link org.talend.process.model.process.AbstractProcess#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess()
 * @model abstract="true"
 * @generated
 */
public interface AbstractProcess extends Container, ResourceContainer, PageFlow, SimulationAbstractProcess, RecapFlow {
    /**
     * Returns the value of the '<em><b>Version</b></em>' attribute.
     * The default value is <code>"1.0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' attribute.
     * @see #setVersion(String)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_Version()
     * @model default="1.0"
     * @generated
     */
    String getVersion();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getVersion <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion(String value);

    /**
     * Returns the value of the '<em><b>Author</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Author</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Author</em>' attribute.
     * @see #setAuthor(String)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_Author()
     * @model
     * @generated
     */
    String getAuthor();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getAuthor <em>Author</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Author</em>' attribute.
     * @see #getAuthor()
     * @generated
     */
    void setAuthor(String value);

    /**
     * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Creation Date</em>' attribute.
     * @see #setCreationDate(Date)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_CreationDate()
     * @model
     * @generated
     */
    Date getCreationDate();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getCreationDate <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Creation Date</em>' attribute.
     * @see #getCreationDate()
     * @generated
     */
    void setCreationDate(Date value);

    /**
     * Returns the value of the '<em><b>Modification Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Modification Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Modification Date</em>' attribute.
     * @see #setModificationDate(Date)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_ModificationDate()
     * @model
     * @generated
     */
    Date getModificationDate();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getModificationDate <em>Modification Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Modification Date</em>' attribute.
     * @see #getModificationDate()
     * @generated
     */
    void setModificationDate(Date value);

    /**
     * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Group}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Groups</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_Groups()
     * @model containment="true"
     * @generated
     */
    EList<Group> getGroups();

    /**
     * Returns the value of the '<em><b>Datatypes</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.DataType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Datatypes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Datatypes</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_Datatypes()
     * @model containment="true"
     * @generated
     */
    EList<DataType> getDatatypes();

    /**
     * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Connection}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connections</em>' containment reference list.
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_Connections()
     * @model containment="true"
     * @generated
     */
    EList<Connection> getConnections();

    /**
     * Returns the value of the '<em><b>Mandatory Symbol</b></em>' attribute.
     * The default value is <code>"*"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mandatory Symbol</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mandatory Symbol</em>' attribute.
     * @see #setMandatorySymbol(String)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_MandatorySymbol()
     * @model default="*"
     * @generated
     */
    String getMandatorySymbol();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getMandatorySymbol <em>Mandatory Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mandatory Symbol</em>' attribute.
     * @see #getMandatorySymbol()
     * @generated
     */
    void setMandatorySymbol(String value);

    /**
     * Returns the value of the '<em><b>Mandatory Classes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mandatory Classes</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mandatory Classes</em>' attribute.
     * @see #setMandatoryClasses(String)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_MandatoryClasses()
     * @model
     * @generated
     */
    String getMandatoryClasses();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getMandatoryClasses <em>Mandatory Classes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mandatory Classes</em>' attribute.
     * @see #getMandatoryClasses()
     * @generated
     */
    void setMandatoryClasses(String value);

    /**
     * Returns the value of the '<em><b>Mandatory Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mandatory Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mandatory Label</em>' attribute.
     * @see #setMandatoryLabel(String)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_MandatoryLabel()
     * @model
     * @generated
     */
    String getMandatoryLabel();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getMandatoryLabel <em>Mandatory Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mandatory Label</em>' attribute.
     * @see #getMandatoryLabel()
     * @generated
     */
    void setMandatoryLabel(String value);

    /**
     * Returns the value of the '<em><b>Error Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Error Template</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Error Template</em>' containment reference.
     * @see #setErrorTemplate(AssociatedFile)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_ErrorTemplate()
     * @model containment="true"
     * @generated
     */
    AssociatedFile getErrorTemplate();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getErrorTemplate <em>Error Template</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Error Template</em>' containment reference.
     * @see #getErrorTemplate()
     * @generated
     */
    void setErrorTemplate(AssociatedFile value);

    /**
     * Returns the value of the '<em><b>Process Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Process Template</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Process Template</em>' containment reference.
     * @see #setProcessTemplate(AssociatedFile)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_ProcessTemplate()
     * @model containment="true"
     * @generated
     */
    AssociatedFile getProcessTemplate();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getProcessTemplate <em>Process Template</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Process Template</em>' containment reference.
     * @see #getProcessTemplate()
     * @generated
     */
    void setProcessTemplate(AssociatedFile value);

    /**
     * Returns the value of the '<em><b>Page Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Page Template</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Page Template</em>' containment reference.
     * @see #setPageTemplate(AssociatedFile)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_PageTemplate()
     * @model containment="true"
     * @generated
     */
    AssociatedFile getPageTemplate();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getPageTemplate <em>Page Template</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Page Template</em>' containment reference.
     * @see #getPageTemplate()
     * @generated
     */
    void setPageTemplate(AssociatedFile value);

    /**
     * Returns the value of the '<em><b>Consultation Template</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Consultation Template</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Consultation Template</em>' containment reference.
     * @see #setConsultationTemplate(AssociatedFile)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_ConsultationTemplate()
     * @model containment="true"
     * @generated
     */
    AssociatedFile getConsultationTemplate();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getConsultationTemplate <em>Consultation Template</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Consultation Template</em>' containment reference.
     * @see #getConsultationTemplate()
     * @generated
     */
    void setConsultationTemplate(AssociatedFile value);

    /**
     * Returns the value of the '<em><b>Log In Page</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Log In Page</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Log In Page</em>' containment reference.
     * @see #setLogInPage(AssociatedFile)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_LogInPage()
     * @model containment="true"
     * @generated
     */
    AssociatedFile getLogInPage();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getLogInPage <em>Log In Page</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Log In Page</em>' containment reference.
     * @see #getLogInPage()
     * @generated
     */
    void setLogInPage(AssociatedFile value);

    /**
     * Returns the value of the '<em><b>Welcome Page</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Welcome Page</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Welcome Page</em>' containment reference.
     * @see #setWelcomePage(AssociatedFile)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_WelcomePage()
     * @model containment="true"
     * @generated
     */
    AssociatedFile getWelcomePage();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getWelcomePage <em>Welcome Page</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Welcome Page</em>' containment reference.
     * @see #getWelcomePage()
     * @generated
     */
    void setWelcomePage(AssociatedFile value);

    /**
     * Returns the value of the '<em><b>Welcome Page Internal</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Welcome Page Internal</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Welcome Page Internal</em>' attribute.
     * @see #setWelcomePageInternal(Boolean)
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_WelcomePageInternal()
     * @model default="true"
     * @generated
     */
    Boolean getWelcomePageInternal();

    /**
     * Sets the value of the '{@link org.talend.process.model.process.AbstractProcess#getWelcomePageInternal <em>Welcome Page Internal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Welcome Page Internal</em>' attribute.
     * @see #getWelcomePageInternal()
     * @generated
     */
    void setWelcomePageInternal(Boolean value);

    /**
     * Returns the value of the '<em><b>Categories</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Categories</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Categories</em>' attribute list.
     * @see org.talend.process.model.process.ProcessPackage#getAbstractProcess_Categories()
     * @model
     * @generated
     */
    EList<String> getCategories();

} // AbstractProcess
