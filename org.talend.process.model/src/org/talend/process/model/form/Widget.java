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
package org.talend.process.model.form;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.talend.process.model.process.Connector;
import org.talend.process.model.process.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.process.model.form.Widget#getScript <em>Script</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getTooltip <em>Tooltip</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getWidgetLayoutInfo <em>Widget Layout Info</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getDisplayLabel <em>Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getShowDisplayLabel <em>Show Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#isAllowHTMLForDisplayLabel <em>Allow HTML For Display Label</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getHtmlAttributes <em>Html Attributes</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getRealHtmlAttributes <em>Real Html Attributes</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getDependOn <em>Depend On</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#isDisplayDependentWidgetOnlyOnEventTriggered <em>Display Dependent Widget Only On Event Triggered</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getScriptAfterEvent <em>Script After Event</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getParentOf <em>Parent Of</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getLabelPosition <em>Label Position</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getInputConnectors <em>Input Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getOutputConnectors <em>Output Connectors</em>}</li>
 *   <li>{@link org.talend.process.model.form.Widget#getAfterEventConnectors <em>After Event Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.process.model.form.FormPackage#getWidget()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Widget extends Element {
    /**
     * Returns the value of the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script</em>' containment reference.
     * @see #setScript(GroovyScript)
     * @see org.talend.process.model.form.FormPackage#getWidget_Script()
     * @model containment="true"
     * @generated
     */
    GroovyScript getScript();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#getScript <em>Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script</em>' containment reference.
     * @see #getScript()
     * @generated
     */
    void setScript(GroovyScript value);

    /**
     * Returns the value of the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The tooltip is mapped with title in forms.xml (and so in GWT)
     * <!-- end-model-doc -->
     * @return the value of the '<em>Tooltip</em>' attribute.
     * @see #setTooltip(String)
     * @see org.talend.process.model.form.FormPackage#getWidget_Tooltip()
     * @model
     * @generated
     */
    String getTooltip();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#getTooltip <em>Tooltip</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tooltip</em>' attribute.
     * @see #getTooltip()
     * @generated
     */
    void setTooltip(String value);

    /**
     * Returns the value of the '<em><b>Widget Layout Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Widget Layout Info</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Widget Layout Info</em>' containment reference.
     * @see #setWidgetLayoutInfo(WidgetLayoutInfo)
     * @see org.talend.process.model.form.FormPackage#getWidget_WidgetLayoutInfo()
     * @model containment="true"
     * @generated
     */
    WidgetLayoutInfo getWidgetLayoutInfo();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#getWidgetLayoutInfo <em>Widget Layout Info</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Widget Layout Info</em>' containment reference.
     * @see #getWidgetLayoutInfo()
     * @generated
     */
    void setWidgetLayoutInfo(WidgetLayoutInfo value);

    /**
     * Returns the value of the '<em><b>Display Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Display Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Display Label</em>' attribute.
     * @see #setDisplayLabel(String)
     * @see org.talend.process.model.form.FormPackage#getWidget_DisplayLabel()
     * @model
     * @generated
     */
    String getDisplayLabel();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#getDisplayLabel <em>Display Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Display Label</em>' attribute.
     * @see #getDisplayLabel()
     * @generated
     */
    void setDisplayLabel(String value);

    /**
     * Returns the value of the '<em><b>Show Display Label</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Show Display Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Show Display Label</em>' attribute.
     * @see #setShowDisplayLabel(Boolean)
     * @see org.talend.process.model.form.FormPackage#getWidget_ShowDisplayLabel()
     * @model default="true"
     * @generated
     */
    Boolean getShowDisplayLabel();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#getShowDisplayLabel <em>Show Display Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Show Display Label</em>' attribute.
     * @see #getShowDisplayLabel()
     * @generated
     */
    void setShowDisplayLabel(Boolean value);

    /**
     * Returns the value of the '<em><b>Allow HTML For Display Label</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Allow HTML For Display Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Allow HTML For Display Label</em>' attribute.
     * @see #setAllowHTMLForDisplayLabel(boolean)
     * @see org.talend.process.model.form.FormPackage#getWidget_AllowHTMLForDisplayLabel()
     * @model default="false"
     * @generated
     */
    boolean isAllowHTMLForDisplayLabel();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#isAllowHTMLForDisplayLabel <em>Allow HTML For Display Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Allow HTML For Display Label</em>' attribute.
     * @see #isAllowHTMLForDisplayLabel()
     * @generated
     */
    void setAllowHTMLForDisplayLabel(boolean value);

    /**
     * Returns the value of the '<em><b>Html Attributes</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * historic name, but in fact it is style attribute.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Html Attributes</em>' map.
     * @see org.talend.process.model.form.FormPackage#getWidget_HtmlAttributes()
     * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
     * @generated
     */
    EMap<String, String> getHtmlAttributes();

    /**
     * Returns the value of the '<em><b>Real Html Attributes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * the name have "real" prefix because, for historic reason, htmlAttributes is used for style attribute
     * <!-- end-model-doc -->
     * @return the value of the '<em>Real Html Attributes</em>' attribute.
     * @see #setRealHtmlAttributes(String)
     * @see org.talend.process.model.form.FormPackage#getWidget_RealHtmlAttributes()
     * @model
     * @generated
     */
    String getRealHtmlAttributes();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#getRealHtmlAttributes <em>Real Html Attributes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Real Html Attributes</em>' attribute.
     * @see #getRealHtmlAttributes()
     * @generated
     */
    void setRealHtmlAttributes(String value);

    /**
     * Returns the value of the '<em><b>Depend On</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.form.WidgetDependency}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The list of widgets in depend on is the list of widgets that need to be filled before the widget appeared and the initial value of widget is filled
     * <!-- end-model-doc -->
     * @return the value of the '<em>Depend On</em>' containment reference list.
     * @see org.talend.process.model.form.FormPackage#getWidget_DependOn()
     * @model containment="true"
     * @generated
     */
    EList<WidgetDependency> getDependOn();

    /**
     * Returns the value of the '<em><b>Display Dependent Widget Only On Event Triggered</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Display Dependent Widget Only On Event Triggered</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Display Dependent Widget Only On Event Triggered</em>' attribute.
     * @see #setDisplayDependentWidgetOnlyOnEventTriggered(boolean)
     * @see org.talend.process.model.form.FormPackage#getWidget_DisplayDependentWidgetOnlyOnEventTriggered()
     * @model default="false"
     * @generated
     */
    boolean isDisplayDependentWidgetOnlyOnEventTriggered();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#isDisplayDependentWidgetOnlyOnEventTriggered <em>Display Dependent Widget Only On Event Triggered</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Display Dependent Widget Only On Event Triggered</em>' attribute.
     * @see #isDisplayDependentWidgetOnlyOnEventTriggered()
     * @generated
     */
    void setDisplayDependentWidgetOnlyOnEventTriggered(boolean value);

    /**
     * Returns the value of the '<em><b>Script After Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script After Event</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script After Event</em>' containment reference.
     * @see #setScriptAfterEvent(GroovyScript)
     * @see org.talend.process.model.form.FormPackage#getWidget_ScriptAfterEvent()
     * @model containment="true"
     * @generated
     */
    GroovyScript getScriptAfterEvent();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#getScriptAfterEvent <em>Script After Event</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script After Event</em>' containment reference.
     * @see #getScriptAfterEvent()
     * @generated
     */
    void setScriptAfterEvent(GroovyScript value);

    /**
     * Returns the value of the '<em><b>Parent Of</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.form.WidgetDependency}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent Of</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent Of</em>' containment reference list.
     * @see org.talend.process.model.form.FormPackage#getWidget_ParentOf()
     * @model containment="true"
     * @generated
     */
    EList<WidgetDependency> getParentOf();

    /**
     * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mandatory</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mandatory</em>' attribute.
     * @see #setMandatory(boolean)
     * @see org.talend.process.model.form.FormPackage#getWidget_Mandatory()
     * @model default="false"
     * @generated
     */
    boolean isMandatory();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#isMandatory <em>Mandatory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mandatory</em>' attribute.
     * @see #isMandatory()
     * @generated
     */
    void setMandatory(boolean value);

    /**
     * Returns the value of the '<em><b>Read Only</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Read Only</em>' attribute.
     * @see #setReadOnly(boolean)
     * @see org.talend.process.model.form.FormPackage#getWidget_ReadOnly()
     * @model default="false"
     * @generated
     */
    boolean isReadOnly();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#isReadOnly <em>Read Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Read Only</em>' attribute.
     * @see #isReadOnly()
     * @generated
     */
    void setReadOnly(boolean value);

    /**
     * Returns the value of the '<em><b>Label Position</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * The literals are from the enumeration {@link org.talend.process.model.form.LabelPosition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label Position</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label Position</em>' attribute.
     * @see org.talend.process.model.form.LabelPosition
     * @see #setLabelPosition(LabelPosition)
     * @see org.talend.process.model.form.FormPackage#getWidget_LabelPosition()
     * @model default="0"
     * @generated
     */
    LabelPosition getLabelPosition();

    /**
     * Sets the value of the '{@link org.talend.process.model.form.Widget#getLabelPosition <em>Label Position</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label Position</em>' attribute.
     * @see org.talend.process.model.form.LabelPosition
     * @see #getLabelPosition()
     * @generated
     */
    void setLabelPosition(LabelPosition value);

    /**
     * Returns the value of the '<em><b>Input Connectors</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Connector}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Connectors</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Connectors</em>' containment reference list.
     * @see org.talend.process.model.form.FormPackage#getWidget_InputConnectors()
     * @model containment="true"
     * @generated
     */
    EList<Connector> getInputConnectors();

    /**
     * Returns the value of the '<em><b>Output Connectors</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Connector}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Connectors</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Connectors</em>' containment reference list.
     * @see org.talend.process.model.form.FormPackage#getWidget_OutputConnectors()
     * @model containment="true"
     * @generated
     */
    EList<Connector> getOutputConnectors();

    /**
     * Returns the value of the '<em><b>After Event Connectors</b></em>' containment reference list.
     * The list contents are of type {@link org.talend.process.model.process.Connector}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>After Event Connectors</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>After Event Connectors</em>' containment reference list.
     * @see org.talend.process.model.form.FormPackage#getWidget_AfterEventConnectors()
     * @model containment="true"
     * @generated
     */
    EList<Connector> getAfterEventConnectors();

} // Widget
