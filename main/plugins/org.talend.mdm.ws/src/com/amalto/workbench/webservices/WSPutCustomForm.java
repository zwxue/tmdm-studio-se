
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSPutCustomForm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSPutCustomForm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCustomForm" type="{urn-com-amalto-xtentis-webservice}WSCustomForm"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSPutCustomForm", propOrder = {
    "wsCustomForm"
})
public class WSPutCustomForm {

    @XmlElement(required = true)
    protected WSCustomForm wsCustomForm;

    /**
     * Default no-arg constructor
     * 
     */
    public WSPutCustomForm() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSPutCustomForm(final WSCustomForm wsCustomForm) {
        this.wsCustomForm = wsCustomForm;
    }

    /**
     * Gets the value of the wsCustomForm property.
     * 
     * @return
     *     possible object is
     *     {@link WSCustomForm }
     *     
     */
    public WSCustomForm getWsCustomForm() {
        return wsCustomForm;
    }

    /**
     * Sets the value of the wsCustomForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSCustomForm }
     *     
     */
    public void setWsCustomForm(WSCustomForm value) {
        this.wsCustomForm = value;
    }

}
