
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsGetRoutingRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsGetRoutingRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsRoutingRulePK" type="{http://www.talend.com/mdm}wsRoutingRulePK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsGetRoutingRule", propOrder = {
    "wsRoutingRulePK"
})
public class WsGetRoutingRule {

    protected WsRoutingRulePK wsRoutingRulePK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsGetRoutingRule() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsGetRoutingRule(final WsRoutingRulePK wsRoutingRulePK) {
        this.wsRoutingRulePK = wsRoutingRulePK;
    }

    /**
     * Gets the value of the wsRoutingRulePK property.
     * 
     * @return
     *     possible object is
     *     {@link WsRoutingRulePK }
     *     
     */
    public WsRoutingRulePK getWsRoutingRulePK() {
        return wsRoutingRulePK;
    }

    /**
     * Sets the value of the wsRoutingRulePK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsRoutingRulePK }
     *     
     */
    public void setWsRoutingRulePK(WsRoutingRulePK value) {
        this.wsRoutingRulePK = value;
    }

}
