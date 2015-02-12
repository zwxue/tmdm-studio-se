
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRoutingRulePKsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRoutingRulePKsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.talend.com/mdm}wsRoutingRulePKArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRoutingRulePKsResponse", propOrder = {
    "_return"
})
public class GetRoutingRulePKsResponse {

    @XmlElement(name = "return")
    protected WsRoutingRulePKArray _return;

    /**
     * Default no-arg constructor
     * 
     */
    public GetRoutingRulePKsResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetRoutingRulePKsResponse(final WsRoutingRulePKArray _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WsRoutingRulePKArray }
     *     
     */
    public WsRoutingRulePKArray getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsRoutingRulePKArray }
     *     
     */
    public void setReturn(WsRoutingRulePKArray value) {
        this._return = value;
    }

}
