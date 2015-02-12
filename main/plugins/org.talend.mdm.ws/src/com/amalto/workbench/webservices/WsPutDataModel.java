
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutDataModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutDataModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsDataModel" type="{http://www.talend.com/mdm}wsDataModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutDataModel", propOrder = {
    "wsDataModel"
})
public class WsPutDataModel {

    protected WsDataModel wsDataModel;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutDataModel() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutDataModel(final WsDataModel wsDataModel) {
        this.wsDataModel = wsDataModel;
    }

    /**
     * Gets the value of the wsDataModel property.
     * 
     * @return
     *     possible object is
     *     {@link WsDataModel }
     *     
     */
    public WsDataModel getWsDataModel() {
        return wsDataModel;
    }

    /**
     * Sets the value of the wsDataModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsDataModel }
     *     
     */
    public void setWsDataModel(WsDataModel value) {
        this.wsDataModel = value;
    }

}
