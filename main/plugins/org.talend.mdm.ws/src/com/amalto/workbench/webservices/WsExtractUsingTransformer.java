
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsExtractUsingTransformer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsExtractUsingTransformer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsItemPK" type="{http://www.talend.com/mdm}wsItemPK" minOccurs="0"/>
 *         &lt;element name="wsTransformerPK" type="{http://www.talend.com/mdm}wsTransformerPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsExtractUsingTransformer", propOrder = {
    "wsItemPK",
    "wsTransformerPK"
})
public class WsExtractUsingTransformer {

    protected WsItemPK wsItemPK;
    protected WsTransformerPK wsTransformerPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsExtractUsingTransformer() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsExtractUsingTransformer(final WsItemPK wsItemPK, final WsTransformerPK wsTransformerPK) {
        this.wsItemPK = wsItemPK;
        this.wsTransformerPK = wsTransformerPK;
    }

    /**
     * Gets the value of the wsItemPK property.
     * 
     * @return
     *     possible object is
     *     {@link WsItemPK }
     *     
     */
    public WsItemPK getWsItemPK() {
        return wsItemPK;
    }

    /**
     * Sets the value of the wsItemPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsItemPK }
     *     
     */
    public void setWsItemPK(WsItemPK value) {
        this.wsItemPK = value;
    }

    /**
     * Gets the value of the wsTransformerPK property.
     * 
     * @return
     *     possible object is
     *     {@link WsTransformerPK }
     *     
     */
    public WsTransformerPK getWsTransformerPK() {
        return wsTransformerPK;
    }

    /**
     * Sets the value of the wsTransformerPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTransformerPK }
     *     
     */
    public void setWsTransformerPK(WsTransformerPK value) {
        this.wsTransformerPK = value;
    }

}
