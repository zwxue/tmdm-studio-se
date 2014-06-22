
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSProcessTaskInstance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSProcessTaskInstance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="candidates" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="readyDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processInstanceNb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processInstanceUUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processDefineUUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "WSProcessTaskInstance", propOrder = {

})
public class WSProcessTaskInstance {

    @XmlElement(required = true)
    protected String uuid;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true, nillable = true)
    protected String candidates;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String readyDate;
    @XmlElement(required = true)
    protected String processName;
    @XmlElement(required = true)
    protected String processVersion;
    @XmlElement(required = true)
    protected String processInstanceNb;
    @XmlElement(required = true)
    protected String processInstanceUUID;
    @XmlElement(required = true)
    protected String processDefineUUID;
    @XmlElement(required = true)
    protected String priority;

    /**
     * Default no-arg constructor
     * 
     */
    public WSProcessTaskInstance() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSProcessTaskInstance(final String uuid, final String status, final String candidates, final String name, final String readyDate, final String processName, final String processVersion, final String processInstanceNb, final String processInstanceUUID, final String processDefineUUID, final String priority) {
        this.uuid = uuid;
        this.status = status;
        this.candidates = candidates;
        this.name = name;
        this.readyDate = readyDate;
        this.processName = processName;
        this.processVersion = processVersion;
        this.processInstanceNb = processInstanceNb;
        this.processInstanceUUID = processInstanceUUID;
        this.processDefineUUID = processDefineUUID;
        this.priority = priority;
    }

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the candidates property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCandidates() {
        return candidates;
    }

    /**
     * Sets the value of the candidates property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCandidates(String value) {
        this.candidates = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the readyDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadyDate() {
        return readyDate;
    }

    /**
     * Sets the value of the readyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadyDate(String value) {
        this.readyDate = value;
    }

    /**
     * Gets the value of the processName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * Sets the value of the processName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessName(String value) {
        this.processName = value;
    }

    /**
     * Gets the value of the processVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessVersion() {
        return processVersion;
    }

    /**
     * Sets the value of the processVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessVersion(String value) {
        this.processVersion = value;
    }

    /**
     * Gets the value of the processInstanceNb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessInstanceNb() {
        return processInstanceNb;
    }

    /**
     * Sets the value of the processInstanceNb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessInstanceNb(String value) {
        this.processInstanceNb = value;
    }

    /**
     * Gets the value of the processInstanceUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessInstanceUUID() {
        return processInstanceUUID;
    }

    /**
     * Sets the value of the processInstanceUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessInstanceUUID(String value) {
        this.processInstanceUUID = value;
    }

    /**
     * Gets the value of the processDefineUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessDefineUUID() {
        return processDefineUUID;
    }

    /**
     * Sets the value of the processDefineUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessDefineUUID(String value) {
        this.processDefineUUID = value;
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
