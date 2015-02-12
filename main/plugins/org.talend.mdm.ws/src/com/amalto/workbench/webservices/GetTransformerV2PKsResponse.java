
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTransformerV2PKsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTransformerV2PKsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.talend.com/mdm}wsTransformerV2PKArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTransformerV2PKsResponse", propOrder = {
    "_return"
})
public class GetTransformerV2PKsResponse {

    @XmlElement(name = "return")
    protected WsTransformerV2PKArray _return;

    /**
     * Default no-arg constructor
     * 
     */
    public GetTransformerV2PKsResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetTransformerV2PKsResponse(final WsTransformerV2PKArray _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WsTransformerV2PKArray }
     *     
     */
    public WsTransformerV2PKArray getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTransformerV2PKArray }
     *     
     */
    public void setReturn(WsTransformerV2PKArray value) {
        this._return = value;
    }

}
