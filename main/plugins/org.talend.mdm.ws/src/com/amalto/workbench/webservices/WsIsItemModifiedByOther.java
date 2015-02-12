
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsIsItemModifiedByOther complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsIsItemModifiedByOther">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsItem" type="{http://www.talend.com/mdm}wsItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsIsItemModifiedByOther", propOrder = {
    "wsItem"
})
public class WsIsItemModifiedByOther {

    protected WsItem wsItem;

    /**
     * Default no-arg constructor
     * 
     */
    public WsIsItemModifiedByOther() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsIsItemModifiedByOther(final WsItem wsItem) {
        this.wsItem = wsItem;
    }

    /**
     * Gets the value of the wsItem property.
     * 
     * @return
     *     possible object is
     *     {@link WsItem }
     *     
     */
    public WsItem getWsItem() {
        return wsItem;
    }

    /**
     * Sets the value of the wsItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsItem }
     *     
     */
    public void setWsItem(WsItem value) {
        this.wsItem = value;
    }

}
