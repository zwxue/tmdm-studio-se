
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSGetDataModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSGetDataModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsDataModelPK" type="{http://www.talend.com/mdm}WSDataModelPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSGetDataModel", propOrder = {
    "wsDataModelPK"
})
public class WSGetDataModel {

    protected WSDataModelPK wsDataModelPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WSGetDataModel() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSGetDataModel(final WSDataModelPK wsDataModelPK) {
        this.wsDataModelPK = wsDataModelPK;
    }

    /**
     * Gets the value of the wsDataModelPK property.
     * 
     * @return
     *     possible object is
     *     {@link WSDataModelPK }
     *     
     */
    public WSDataModelPK getWsDataModelPK() {
        return wsDataModelPK;
    }

    /**
     * Sets the value of the wsDataModelPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSDataModelPK }
     *     
     */
    public void setWsDataModelPK(WSDataModelPK value) {
        this.wsDataModelPK = value;
    }

}
