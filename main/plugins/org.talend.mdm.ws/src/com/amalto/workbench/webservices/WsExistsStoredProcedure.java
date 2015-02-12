
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsExistsStoredProcedure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsExistsStoredProcedure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsStoredProcedurePK" type="{http://www.talend.com/mdm}wsStoredProcedurePK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsExistsStoredProcedure", propOrder = {
    "wsStoredProcedurePK"
})
public class WsExistsStoredProcedure {

    protected WsStoredProcedurePK wsStoredProcedurePK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsExistsStoredProcedure() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsExistsStoredProcedure(final WsStoredProcedurePK wsStoredProcedurePK) {
        this.wsStoredProcedurePK = wsStoredProcedurePK;
    }

    /**
     * Gets the value of the wsStoredProcedurePK property.
     * 
     * @return
     *     possible object is
     *     {@link WsStoredProcedurePK }
     *     
     */
    public WsStoredProcedurePK getWsStoredProcedurePK() {
        return wsStoredProcedurePK;
    }

    /**
     * Sets the value of the wsStoredProcedurePK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsStoredProcedurePK }
     *     
     */
    public void setWsStoredProcedurePK(WsStoredProcedurePK value) {
        this.wsStoredProcedurePK = value;
    }

}
