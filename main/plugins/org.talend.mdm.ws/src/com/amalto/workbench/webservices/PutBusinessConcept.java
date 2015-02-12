
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for putBusinessConcept complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="putBusinessConcept">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.talend.com/mdm}wsPutBusinessConcept" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putBusinessConcept", propOrder = {
    "arg0"
})
public class PutBusinessConcept {

    protected WsPutBusinessConcept arg0;

    /**
     * Default no-arg constructor
     * 
     */
    public PutBusinessConcept() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public PutBusinessConcept(final WsPutBusinessConcept arg0) {
        this.arg0 = arg0;
    }

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link WsPutBusinessConcept }
     *     
     */
    public WsPutBusinessConcept getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsPutBusinessConcept }
     *     
     */
    public void setArg0(WsPutBusinessConcept value) {
        this.arg0 = value;
    }

}
