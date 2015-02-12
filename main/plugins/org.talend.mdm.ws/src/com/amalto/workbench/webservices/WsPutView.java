
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsView" type="{http://www.talend.com/mdm}wsView" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutView", propOrder = {
    "wsView"
})
public class WsPutView {

    protected WsView wsView;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutView() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutView(final WsView wsView) {
        this.wsView = wsView;
    }

    /**
     * Gets the value of the wsView property.
     * 
     * @return
     *     possible object is
     *     {@link WsView }
     *     
     */
    public WsView getWsView() {
        return wsView;
    }

    /**
     * Sets the value of the wsView property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsView }
     *     
     */
    public void setWsView(WsView value) {
        this.wsView = value;
    }

}
