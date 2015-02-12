
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutBusinessConceptSchema complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutBusinessConceptSchema">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="businessConceptSchema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsDataModelPK" type="{http://www.talend.com/mdm}wsDataModelPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutBusinessConceptSchema", propOrder = {
    "businessConceptSchema",
    "wsDataModelPK"
})
public class WsPutBusinessConceptSchema {

    protected String businessConceptSchema;
    protected WsDataModelPK wsDataModelPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutBusinessConceptSchema() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutBusinessConceptSchema(final String businessConceptSchema, final WsDataModelPK wsDataModelPK) {
        this.businessConceptSchema = businessConceptSchema;
        this.wsDataModelPK = wsDataModelPK;
    }

    /**
     * Gets the value of the businessConceptSchema property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessConceptSchema() {
        return businessConceptSchema;
    }

    /**
     * Sets the value of the businessConceptSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessConceptSchema(String value) {
        this.businessConceptSchema = value;
    }

    /**
     * Gets the value of the wsDataModelPK property.
     * 
     * @return
     *     possible object is
     *     {@link WsDataModelPK }
     *     
     */
    public WsDataModelPK getWsDataModelPK() {
        return wsDataModelPK;
    }

    /**
     * Sets the value of the wsDataModelPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsDataModelPK }
     *     
     */
    public void setWsDataModelPK(WsDataModelPK value) {
        this.wsDataModelPK = value;
    }

}
