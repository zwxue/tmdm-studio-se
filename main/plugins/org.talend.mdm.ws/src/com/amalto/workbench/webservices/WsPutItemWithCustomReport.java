
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutItemWithCustomReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutItemWithCustomReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsPutItemWithReport" type="{http://www.talend.com/mdm}wsPutItemWithReport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutItemWithCustomReport", propOrder = {
    "user",
    "wsPutItemWithReport"
})
public class WsPutItemWithCustomReport {

    protected String user;
    protected WsPutItemWithReport wsPutItemWithReport;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutItemWithCustomReport() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutItemWithCustomReport(final String user, final WsPutItemWithReport wsPutItemWithReport) {
        this.user = user;
        this.wsPutItemWithReport = wsPutItemWithReport;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Gets the value of the wsPutItemWithReport property.
     * 
     * @return
     *     possible object is
     *     {@link WsPutItemWithReport }
     *     
     */
    public WsPutItemWithReport getWsPutItemWithReport() {
        return wsPutItemWithReport;
    }

    /**
     * Sets the value of the wsPutItemWithReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsPutItemWithReport }
     *     
     */
    public void setWsPutItemWithReport(WsPutItemWithReport value) {
        this.wsPutItemWithReport = value;
    }

}
