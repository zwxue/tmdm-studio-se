
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsExistsView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsExistsView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsViewPK" type="{http://www.talend.com/mdm}wsViewPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsExistsView", propOrder = {
    "wsViewPK"
})
public class WsExistsView {

    protected WsViewPK wsViewPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsExistsView() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsExistsView(final WsViewPK wsViewPK) {
        this.wsViewPK = wsViewPK;
    }

    /**
     * Gets the value of the wsViewPK property.
     * 
     * @return
     *     possible object is
     *     {@link WsViewPK }
     *     
     */
    public WsViewPK getWsViewPK() {
        return wsViewPK;
    }

    /**
     * Sets the value of the wsViewPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsViewPK }
     *     
     */
    public void setWsViewPK(WsViewPK value) {
        this.wsViewPK = value;
    }

}
