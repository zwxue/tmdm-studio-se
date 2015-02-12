
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsDeleteRole complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsDeleteRole">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsRolePK" type="{http://www.talend.com/mdm}wsRolePK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsDeleteRole", propOrder = {
    "wsRolePK"
})
public class WsDeleteRole {

    protected WsRolePK wsRolePK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsDeleteRole() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsDeleteRole(final WsRolePK wsRolePK) {
        this.wsRolePK = wsRolePK;
    }

    /**
     * Gets the value of the wsRolePK property.
     * 
     * @return
     *     possible object is
     *     {@link WsRolePK }
     *     
     */
    public WsRolePK getWsRolePK() {
        return wsRolePK;
    }

    /**
     * Sets the value of the wsRolePK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsRolePK }
     *     
     */
    public void setWsRolePK(WsRolePK value) {
        this.wsRolePK = value;
    }

}
