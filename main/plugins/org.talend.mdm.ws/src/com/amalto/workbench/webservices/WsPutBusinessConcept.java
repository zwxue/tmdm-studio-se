
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutBusinessConcept complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutBusinessConcept">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="businessConcept" type="{http://www.talend.com/mdm}wsBusinessConcept" minOccurs="0"/>
 *         &lt;element name="wsDataModelPK" type="{http://www.talend.com/mdm}wsDataModelPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutBusinessConcept", propOrder = {
    "businessConcept",
    "wsDataModelPK"
})
public class WsPutBusinessConcept {

    protected WsBusinessConcept businessConcept;
    protected WsDataModelPK wsDataModelPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutBusinessConcept() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutBusinessConcept(final WsBusinessConcept businessConcept, final WsDataModelPK wsDataModelPK) {
        this.businessConcept = businessConcept;
        this.wsDataModelPK = wsDataModelPK;
    }

    /**
     * Gets the value of the businessConcept property.
     * 
     * @return
     *     possible object is
     *     {@link WsBusinessConcept }
     *     
     */
    public WsBusinessConcept getBusinessConcept() {
        return businessConcept;
    }

    /**
     * Sets the value of the businessConcept property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsBusinessConcept }
     *     
     */
    public void setBusinessConcept(WsBusinessConcept value) {
        this.businessConcept = value;
    }

    /**
     * Gets the value of the wsDataModelPK property.
     * 
     * @return
     *     possible object is
     *     {@link WsDataModelPK }
     *     
     */
    public WsDataModelPK getWsDataModelPK() {
        return wsDataModelPK;
    }

    /**
     * Sets the value of the wsDataModelPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsDataModelPK }
     *     
     */
    public void setWsDataModelPK(WsDataModelPK value) {
        this.wsDataModelPK = value;
    }

}
