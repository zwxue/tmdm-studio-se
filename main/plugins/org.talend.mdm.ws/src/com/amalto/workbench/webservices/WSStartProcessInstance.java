
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSStartProcessInstance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSStartProcessInstance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="processUUID" type="{urn-com-amalto-xtentis-webservice}WSWorkflowProcessDefinitionUUID"/>
 *         &lt;element name="variable" type="{urn-com-amalto-xtentis-webservice}WSHashMap"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSStartProcessInstance", propOrder = {

})
public class WSStartProcessInstance {

    @XmlElement(required = true)
    protected WSWorkflowProcessDefinitionUUID processUUID;
    @XmlElement(required = true)
    protected WSHashMap variable;

    /**
     * Default no-arg constructor
     * 
     */
    public WSStartProcessInstance() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSStartProcessInstance(final WSWorkflowProcessDefinitionUUID processUUID, final WSHashMap variable) {
        this.processUUID = processUUID;
        this.variable = variable;
    }

    /**
     * Gets the value of the processUUID property.
     * 
     * @return
     *     possible object is
     *     {@link WSWorkflowProcessDefinitionUUID }
     *     
     */
    public WSWorkflowProcessDefinitionUUID getProcessUUID() {
        return processUUID;
    }

    /**
     * Sets the value of the processUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSWorkflowProcessDefinitionUUID }
     *     
     */
    public void setProcessUUID(WSWorkflowProcessDefinitionUUID value) {
        this.processUUID = value;
    }

    /**
     * Gets the value of the variable property.
     * 
     * @return
     *     possible object is
     *     {@link WSHashMap }
     *     
     */
    public WSHashMap getVariable() {
        return variable;
    }

    /**
     * Sets the value of the variable property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSHashMap }
     *     
     */
    public void setVariable(WSHashMap value) {
        this.variable = value;
    }

}
