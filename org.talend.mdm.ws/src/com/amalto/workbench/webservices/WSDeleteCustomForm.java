
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSDeleteCustomForm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSDeleteCustomForm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCustomFormPK" type="{urn-com-amalto-xtentis-webservice}WSCustomFormPK"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSDeleteCustomForm", propOrder = {
    "wsCustomFormPK"
})
public class WSDeleteCustomForm {

    @XmlElement(required = true)
    protected WSCustomFormPK wsCustomFormPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WSDeleteCustomForm() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSDeleteCustomForm(final WSCustomFormPK wsCustomFormPK) {
        this.wsCustomFormPK = wsCustomFormPK;
    }

    /**
     * Gets the value of the wsCustomFormPK property.
     * 
     * @return
     *     possible object is
     *     {@link WSCustomFormPK }
     *     
     */
    public WSCustomFormPK getWsCustomFormPK() {
        return wsCustomFormPK;
    }

    /**
     * Sets the value of the wsCustomFormPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSCustomFormPK }
     *     
     */
    public void setWsCustomFormPK(WSCustomFormPK value) {
        this.wsCustomFormPK = value;
    }

}
