
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutStoredProcedure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutStoredProcedure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsStoredProcedure" type="{http://www.talend.com/mdm}wsStoredProcedure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutStoredProcedure", propOrder = {
    "wsStoredProcedure"
})
public class WsPutStoredProcedure {

    protected WsStoredProcedure wsStoredProcedure;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutStoredProcedure() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutStoredProcedure(final WsStoredProcedure wsStoredProcedure) {
        this.wsStoredProcedure = wsStoredProcedure;
    }

    /**
     * Gets the value of the wsStoredProcedure property.
     * 
     * @return
     *     possible object is
     *     {@link WsStoredProcedure }
     *     
     */
    public WsStoredProcedure getWsStoredProcedure() {
        return wsStoredProcedure;
    }

    /**
     * Sets the value of the wsStoredProcedure property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsStoredProcedure }
     *     
     */
    public void setWsStoredProcedure(WsStoredProcedure value) {
        this.wsStoredProcedure = value;
    }

}
