
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStoredProcedurePKsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStoredProcedurePKsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.talend.com/mdm}wsStoredProcedurePKArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStoredProcedurePKsResponse", propOrder = {
    "_return"
})
public class GetStoredProcedurePKsResponse {

    @XmlElement(name = "return")
    protected WsStoredProcedurePKArray _return;

    /**
     * Default no-arg constructor
     * 
     */
    public GetStoredProcedurePKsResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetStoredProcedurePKsResponse(final WsStoredProcedurePKArray _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WsStoredProcedurePKArray }
     *     
     */
    public WsStoredProcedurePKArray getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsStoredProcedurePKArray }
     *     
     */
    public void setReturn(WsStoredProcedurePKArray value) {
        this._return = value;
    }

}
