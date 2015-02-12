
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAutoIncrementResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAutoIncrementResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.talend.com/mdm}wsAutoIncrement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAutoIncrementResponse", propOrder = {
    "_return"
})
public class GetAutoIncrementResponse {

    @XmlElement(name = "return")
    protected WsAutoIncrement _return;

    /**
     * Default no-arg constructor
     * 
     */
    public GetAutoIncrementResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetAutoIncrementResponse(final WsAutoIncrement _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WsAutoIncrement }
     *     
     */
    public WsAutoIncrement getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsAutoIncrement }
     *     
     */
    public void setReturn(WsAutoIncrement value) {
        this._return = value;
    }

}
