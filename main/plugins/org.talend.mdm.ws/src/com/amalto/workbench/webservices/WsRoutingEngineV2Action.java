
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsRoutingEngineV2Action complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsRoutingEngineV2Action">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsAction" type="{http://www.talend.com/mdm}wsRoutingEngineV2ActionCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsRoutingEngineV2Action", propOrder = {
    "wsAction"
})
public class WsRoutingEngineV2Action {

    protected WsRoutingEngineV2ActionCode wsAction;

    /**
     * Default no-arg constructor
     * 
     */
    public WsRoutingEngineV2Action() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsRoutingEngineV2Action(final WsRoutingEngineV2ActionCode wsAction) {
        this.wsAction = wsAction;
    }

    /**
     * Gets the value of the wsAction property.
     * 
     * @return
     *     possible object is
     *     {@link WsRoutingEngineV2ActionCode }
     *     
     */
    public WsRoutingEngineV2ActionCode getWsAction() {
        return wsAction;
    }

    /**
     * Sets the value of the wsAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsRoutingEngineV2ActionCode }
     *     
     */
    public void setWsAction(WsRoutingEngineV2ActionCode value) {
        this.wsAction = value;
    }

}
