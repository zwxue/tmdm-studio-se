
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSSuspendTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSSuspendTask">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="taskUUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="assignTask" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSSuspendTask", propOrder = {

})
public class WSSuspendTask {

    @XmlElement(required = true)
    protected String taskUUID;
    protected boolean assignTask;

    /**
     * Default no-arg constructor
     * 
     */
    public WSSuspendTask() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSSuspendTask(final String taskUUID, final boolean assignTask) {
        this.taskUUID = taskUUID;
        this.assignTask = assignTask;
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
     * Gets the value of the assignTask property.
     * 
     */
    public boolean isAssignTask() {
        return assignTask;
    }

    /**
     * Sets the value of the assignTask property.
     * 
     */
    public void setAssignTask(boolean value) {
        this.assignTask = value;
    }

}
