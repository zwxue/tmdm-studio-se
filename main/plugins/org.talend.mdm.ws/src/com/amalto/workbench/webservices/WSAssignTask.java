
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSAssignTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSAssignTask">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="taskUUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="candicates" type="{urn-com-amalto-xtentis-webservice}WSStringArray"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSAssignTask", propOrder = {

})
public class WSAssignTask {

    @XmlElement(required = true)
    protected String taskUUID;
    @XmlElement(required = true)
    protected WSStringArray candicates;

    /**
     * Default no-arg constructor
     * 
     */
    public WSAssignTask() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSAssignTask(final String taskUUID, final WSStringArray candicates) {
        this.taskUUID = taskUUID;
        this.candicates = candicates;
    }

    /**
     * Gets the value of the taskUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskUUID() {
        return taskUUID;
    }

    /**
     * Sets the value of the taskUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskUUID(String value) {
        this.taskUUID = value;
    }

    /**
     * Gets the value of the candicates property.
     * 
     * @return
     *     possible object is
     *     {@link WSStringArray }
     *     
     */
    public WSStringArray getCandicates() {
        return candicates;
    }

    /**
     * Sets the value of the candicates property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSStringArray }
     *     
     */
    public void setCandicates(WSStringArray value) {
        this.candicates = value;
    }

}
