
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteTransformerV2Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteTransformerV2Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.talend.com/mdm}wsTransformerV2PK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteTransformerV2Response", propOrder = {
    "_return"
})
public class DeleteTransformerV2Response {

    @XmlElement(name = "return")
    protected WsTransformerV2PK _return;

    /**
     * Default no-arg constructor
     * 
     */
    public DeleteTransformerV2Response() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public DeleteTransformerV2Response(final WsTransformerV2PK _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WsTransformerV2PK }
     *     
     */
    public WsTransformerV2PK getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTransformerV2PK }
     *     
     */
    public void setReturn(WsTransformerV2PK value) {
        this._return = value;
    }

}
