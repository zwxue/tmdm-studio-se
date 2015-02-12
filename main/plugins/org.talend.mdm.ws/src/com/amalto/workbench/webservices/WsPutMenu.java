
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutMenu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutMenu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsMenu" type="{http://www.talend.com/mdm}wsMenu" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutMenu", propOrder = {
    "wsMenu"
})
public class WsPutMenu {

    protected WsMenu wsMenu;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutMenu() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutMenu(final WsMenu wsMenu) {
        this.wsMenu = wsMenu;
    }

    /**
     * Gets the value of the wsMenu property.
     * 
     * @return
     *     possible object is
     *     {@link WsMenu }
     *     
     */
    public WsMenu getWsMenu() {
        return wsMenu;
    }

    /**
     * Sets the value of the wsMenu property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsMenu }
     *     
     */
    public void setWsMenu(WsMenu value) {
        this.wsMenu = value;
    }

}
