
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutRole complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutRole">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsRole" type="{http://www.talend.com/mdm}wsRole" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutRole", propOrder = {
    "wsRole"
})
public class WsPutRole {

    protected WsRole wsRole;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutRole() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutRole(final WsRole wsRole) {
        this.wsRole = wsRole;
    }

    /**
     * Gets the value of the wsRole property.
     * 
     * @return
     *     possible object is
     *     {@link WsRole }
     *     
     */
    public WsRole getWsRole() {
        return wsRole;
    }

    /**
     * Sets the value of the wsRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsRole }
     *     
     */
    public void setWsRole(WsRole value) {
        this.wsRole = value;
    }

}
