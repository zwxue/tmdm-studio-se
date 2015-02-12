
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for putItemArrayResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="putItemArrayResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.talend.com/mdm}wsItemPKArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putItemArrayResponse", propOrder = {
    "_return"
})
public class PutItemArrayResponse {

    @XmlElement(name = "return")
    protected WsItemPKArray _return;

    /**
     * Default no-arg constructor
     * 
     */
    public PutItemArrayResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public PutItemArrayResponse(final WsItemPKArray _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WsItemPKArray }
     *     
     */
    public WsItemPKArray getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsItemPKArray }
     *     
     */
    public void setReturn(WsItemPKArray value) {
        this._return = value;
    }

}
