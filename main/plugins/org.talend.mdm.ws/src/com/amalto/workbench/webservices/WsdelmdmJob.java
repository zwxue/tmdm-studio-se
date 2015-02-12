
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsdelmdmJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsdelmdmJob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jobName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsdelmdmJob", propOrder = {
    "jobName",
    "jobVersion"
})
public class WsdelmdmJob {

    protected String jobName;
    protected String jobVersion;

    /**
     * Default no-arg constructor
     * 
     */
    public WsdelmdmJob() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsdelmdmJob(final String jobName, final String jobVersion) {
        this.jobName = jobName;
        this.jobVersion = jobVersion;
    }

    /**
     * Gets the value of the jobName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * Sets the value of the jobName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobName(String value) {
        this.jobName = value;
    }

    /**
     * Gets the value of the jobVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobVersion() {
        return jobVersion;
    }

    /**
     * Sets the value of the jobVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobVersion(String value) {
        this.jobVersion = value;
    }

}
