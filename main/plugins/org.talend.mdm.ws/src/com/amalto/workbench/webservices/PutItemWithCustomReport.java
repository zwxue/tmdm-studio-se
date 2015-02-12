
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for putItemWithCustomReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="putItemWithCustomReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.talend.com/mdm}wsPutItemWithCustomReport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putItemWithCustomReport", propOrder = {
    "arg0"
})
public class PutItemWithCustomReport {

    protected WsPutItemWithCustomReport arg0;

    /**
     * Default no-arg constructor
     * 
     */
    public PutItemWithCustomReport() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public PutItemWithCustomReport(final WsPutItemWithCustomReport arg0) {
        this.arg0 = arg0;
    }

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link WsPutItemWithCustomReport }
     *     
     */
    public WsPutItemWithCustomReport getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsPutItemWithCustomReport }
     *     
     */
    public void setArg0(WsPutItemWithCustomReport value) {
        this.arg0 = value;
    }

}
