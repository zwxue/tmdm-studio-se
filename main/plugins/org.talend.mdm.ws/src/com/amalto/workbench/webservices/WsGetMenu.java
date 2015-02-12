
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsGetMenu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsGetMenu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsMenuPK" type="{http://www.talend.com/mdm}wsMenuPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsGetMenu", propOrder = {
    "wsMenuPK"
})
public class WsGetMenu {

    protected WsMenuPK wsMenuPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsGetMenu() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsGetMenu(final WsMenuPK wsMenuPK) {
        this.wsMenuPK = wsMenuPK;
    }

    /**
     * Gets the value of the wsMenuPK property.
     * 
     * @return
     *     possible object is
     *     {@link WsMenuPK }
     *     
     */
    public WsMenuPK getWsMenuPK() {
        return wsMenuPK;
    }

    /**
     * Sets the value of the wsMenuPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsMenuPK }
     *     
     */
    public void setWsMenuPK(WsMenuPK value) {
        this.wsMenuPK = value;
    }

}
