
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSUnassignTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSUnassignTask">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="taskUUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSUnassignTask", propOrder = {

})
public class WSUnassignTask {

    @XmlElement(required = true)
    protected String taskUUID;

    /**
     * Default no-arg constructor
     * 
     */
    public WSUnassignTask() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSUnassignTask(final String taskUUID) {
        this.taskUUID = taskUUID;
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

}
