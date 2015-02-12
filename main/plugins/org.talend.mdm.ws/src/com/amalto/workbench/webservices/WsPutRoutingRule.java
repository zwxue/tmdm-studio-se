
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutRoutingRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutRoutingRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsRoutingRule" type="{http://www.talend.com/mdm}wsRoutingRule" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutRoutingRule", propOrder = {
    "wsRoutingRule"
})
public class WsPutRoutingRule {

    protected WsRoutingRule wsRoutingRule;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutRoutingRule() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutRoutingRule(final WsRoutingRule wsRoutingRule) {
        this.wsRoutingRule = wsRoutingRule;
    }

    /**
     * Gets the value of the wsRoutingRule property.
     * 
     * @return
     *     possible object is
     *     {@link WsRoutingRule }
     *     
     */
    public WsRoutingRule getWsRoutingRule() {
        return wsRoutingRule;
    }

    /**
     * Sets the value of the wsRoutingRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsRoutingRule }
     *     
     */
    public void setWsRoutingRule(WsRoutingRule value) {
        this.wsRoutingRule = value;
    }

}
