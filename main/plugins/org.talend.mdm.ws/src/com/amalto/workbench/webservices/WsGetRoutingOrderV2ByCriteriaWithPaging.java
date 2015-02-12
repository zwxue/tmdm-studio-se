
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsGetRoutingOrderV2ByCriteriaWithPaging complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsGetRoutingOrderV2ByCriteriaWithPaging">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsSearchCriteriaWithPaging" type="{http://www.talend.com/mdm}wsRoutingOrderV2SearchCriteriaWithPaging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsGetRoutingOrderV2ByCriteriaWithPaging", propOrder = {
    "wsSearchCriteriaWithPaging"
})
public class WsGetRoutingOrderV2ByCriteriaWithPaging {

    protected WsRoutingOrderV2SearchCriteriaWithPaging wsSearchCriteriaWithPaging;

    /**
     * Default no-arg constructor
     * 
     */
    public WsGetRoutingOrderV2ByCriteriaWithPaging() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsGetRoutingOrderV2ByCriteriaWithPaging(final WsRoutingOrderV2SearchCriteriaWithPaging wsSearchCriteriaWithPaging) {
        this.wsSearchCriteriaWithPaging = wsSearchCriteriaWithPaging;
    }

    /**
     * Gets the value of the wsSearchCriteriaWithPaging property.
     * 
     * @return
     *     possible object is
     *     {@link WsRoutingOrderV2SearchCriteriaWithPaging }
     *     
     */
    public WsRoutingOrderV2SearchCriteriaWithPaging getWsSearchCriteriaWithPaging() {
        return wsSearchCriteriaWithPaging;
    }

    /**
     * Sets the value of the wsSearchCriteriaWithPaging property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsRoutingOrderV2SearchCriteriaWithPaging }
     *     
     */
    public void setWsSearchCriteriaWithPaging(WsRoutingOrderV2SearchCriteriaWithPaging value) {
        this.wsSearchCriteriaWithPaging = value;
    }

}
