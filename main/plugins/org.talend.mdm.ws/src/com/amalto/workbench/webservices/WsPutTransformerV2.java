
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutTransformerV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutTransformerV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsTransformerV2" type="{http://www.talend.com/mdm}wsTransformerV2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutTransformerV2", propOrder = {
    "wsTransformerV2"
})
public class WsPutTransformerV2 {

    protected WsTransformerV2 wsTransformerV2;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutTransformerV2() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutTransformerV2(final WsTransformerV2 wsTransformerV2) {
        this.wsTransformerV2 = wsTransformerV2;
    }

    /**
     * Gets the value of the wsTransformerV2 property.
     * 
     * @return
     *     possible object is
     *     {@link WsTransformerV2 }
     *     
     */
    public WsTransformerV2 getWsTransformerV2() {
        return wsTransformerV2;
    }

    /**
     * Sets the value of the wsTransformerV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTransformerV2 }
     *     
     */
    public void setWsTransformerV2(WsTransformerV2 value) {
        this.wsTransformerV2 = value;
    }

}
