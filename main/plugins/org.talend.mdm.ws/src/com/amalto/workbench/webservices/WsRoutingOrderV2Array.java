
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsRoutingOrderV2Array complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsRoutingOrderV2Array">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsRoutingOrder" type="{http://www.talend.com/mdm}wsRoutingOrderV2" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsRoutingOrderV2Array", propOrder = {
    "wsRoutingOrder"
})
public class WsRoutingOrderV2Array {

    @XmlElement(nillable = true)
    protected List<WsRoutingOrderV2> wsRoutingOrder;

    /**
     * Default no-arg constructor
     * 
     */
    public WsRoutingOrderV2Array() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsRoutingOrderV2Array(final List<WsRoutingOrderV2> wsRoutingOrder) {
        this.wsRoutingOrder = wsRoutingOrder;
    }

    /**
     * Gets the value of the wsRoutingOrder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsRoutingOrder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsRoutingOrder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsRoutingOrderV2 }
     * 
     * 
     */
    public List<WsRoutingOrderV2> getWsRoutingOrder() {
        if (wsRoutingOrder == null) {
            wsRoutingOrder = new ArrayList<WsRoutingOrderV2>();
        }
        return this.wsRoutingOrder;
    }

}
