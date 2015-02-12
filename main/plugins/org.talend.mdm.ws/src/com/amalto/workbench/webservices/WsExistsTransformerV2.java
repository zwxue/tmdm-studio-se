
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsExistsTransformerV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsExistsTransformerV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsTransformerV2PK" type="{http://www.talend.com/mdm}wsTransformerV2PK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsExistsTransformerV2", propOrder = {
    "wsTransformerV2PK"
})
public class WsExistsTransformerV2 {

    protected WsTransformerV2PK wsTransformerV2PK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsExistsTransformerV2() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsExistsTransformerV2(final WsTransformerV2PK wsTransformerV2PK) {
        this.wsTransformerV2PK = wsTransformerV2PK;
    }

    /**
     * Gets the value of the wsTransformerV2PK property.
     * 
     * @return
     *     possible object is
     *     {@link WsTransformerV2PK }
     *     
     */
    public WsTransformerV2PK getWsTransformerV2PK() {
        return wsTransformerV2PK;
    }

    /**
     * Sets the value of the wsTransformerV2PK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTransformerV2PK }
     *     
     */
    public void setWsTransformerV2PK(WsTransformerV2PK value) {
        this.wsTransformerV2PK = value;
    }

}
