
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStoredProcedureResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStoredProcedureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.talend.com/mdm}wsStoredProcedure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStoredProcedureResponse", propOrder = {
    "_return"
})
public class GetStoredProcedureResponse {

    @XmlElement(name = "return")
    protected WsStoredProcedure _return;

    /**
     * Default no-arg constructor
     * 
     */
    public GetStoredProcedureResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetStoredProcedureResponse(final WsStoredProcedure _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WsStoredProcedure }
     *     
     */
    public WsStoredProcedure getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsStoredProcedure }
     *     
     */
    public void setReturn(WsStoredProcedure value) {
        this._return = value;
    }

}
