
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getBackgroundJobResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getBackgroundJobResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.talend.com/mdm}wsBackgroundJob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBackgroundJobResponse", propOrder = {
    "_return"
})
public class GetBackgroundJobResponse {

    @XmlElement(name = "return")
    protected WsBackgroundJob _return;

    /**
     * Default no-arg constructor
     * 
     */
    public GetBackgroundJobResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetBackgroundJobResponse(final WsBackgroundJob _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WsBackgroundJob }
     *     
     */
    public WsBackgroundJob getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsBackgroundJob }
     *     
     */
    public void setReturn(WsBackgroundJob value) {
        this._return = value;
    }

}
