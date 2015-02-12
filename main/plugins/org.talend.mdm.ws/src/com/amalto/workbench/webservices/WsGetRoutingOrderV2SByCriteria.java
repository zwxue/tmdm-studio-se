
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsGetRoutingOrderV2SByCriteria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsGetRoutingOrderV2SByCriteria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsSearchCriteria" type="{http://www.talend.com/mdm}wsRoutingOrderV2SearchCriteria" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsGetRoutingOrderV2SByCriteria", propOrder = {
    "wsSearchCriteria"
})
public class WsGetRoutingOrderV2SByCriteria {

    protected WsRoutingOrderV2SearchCriteria wsSearchCriteria;

    /**
     * Default no-arg constructor
     * 
     */
    public WsGetRoutingOrderV2SByCriteria() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsGetRoutingOrderV2SByCriteria(final WsRoutingOrderV2SearchCriteria wsSearchCriteria) {
        this.wsSearchCriteria = wsSearchCriteria;
    }

    /**
     * Gets the value of the wsSearchCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link WsRoutingOrderV2SearchCriteria }
     *     
     */
    public WsRoutingOrderV2SearchCriteria getWsSearchCriteria() {
        return wsSearchCriteria;
    }

    /**
     * Sets the value of the wsSearchCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsRoutingOrderV2SearchCriteria }
     *     
     */
    public void setWsSearchCriteria(WsRoutingOrderV2SearchCriteria value) {
        this.wsSearchCriteria = value;
    }

}
