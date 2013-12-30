
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSSetTaskPriority complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSSetTaskPriority">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="taskUUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSSetTaskPriority", propOrder = {

})
public class WSSetTaskPriority {

    @XmlElement(required = true)
    protected String taskUUID;
    @XmlElement(required = true)
    protected String priority;

    /**
     * Default no-arg constructor
     * 
     */
    public WSSetTaskPriority() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSSetTaskPriority(final String taskUUID, final String priority) {
        this.taskUUID = taskUUID;
        this.priority = priority;
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
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(String value) {
        this.priority = value;
    }

}
