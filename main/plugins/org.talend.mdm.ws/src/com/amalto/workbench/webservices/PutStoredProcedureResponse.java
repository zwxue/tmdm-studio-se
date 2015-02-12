
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for putStoredProcedureResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="putStoredProcedureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.talend.com/mdm}wsStoredProcedurePK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putStoredProcedureResponse", propOrder = {
    "_return"
})
public class PutStoredProcedureResponse {

    @XmlElement(name = "return")
    protected WsStoredProcedurePK _return;

    /**
     * Default no-arg constructor
     * 
     */
    public PutStoredProcedureResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public PutStoredProcedureResponse(final WsStoredProcedurePK _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WsStoredProcedurePK }
     *     
     */
    public WsStoredProcedurePK getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsStoredProcedurePK }
     *     
     */
    public void setReturn(WsStoredProcedurePK value) {
        this._return = value;
    }

}
