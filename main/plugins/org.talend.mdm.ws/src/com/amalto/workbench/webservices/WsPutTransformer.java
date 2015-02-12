
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutTransformer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutTransformer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsTransformer" type="{http://www.talend.com/mdm}wsTransformer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutTransformer", propOrder = {
    "wsTransformer"
})
public class WsPutTransformer {

    protected WsTransformer wsTransformer;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutTransformer() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutTransformer(final WsTransformer wsTransformer) {
        this.wsTransformer = wsTransformer;
    }

    /**
     * Gets the value of the wsTransformer property.
     * 
     * @return
     *     possible object is
     *     {@link WsTransformer }
     *     
     */
    public WsTransformer getWsTransformer() {
        return wsTransformer;
    }

    /**
     * Sets the value of the wsTransformer property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTransformer }
     *     
     */
    public void setWsTransformer(WsTransformer value) {
        this.wsTransformer = value;
    }

}
