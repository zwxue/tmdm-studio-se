
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsDeleteBusinessConcept complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsDeleteBusinessConcept">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="businessConceptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "wsDeleteBusinessConcept", propOrder = {
    "businessConceptName",
    "wsDataModelPK"
})
public class WsDeleteBusinessConcept {

    protected String businessConceptName;
    protected WsDataModelPK wsDataModelPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsDeleteBusinessConcept() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsDeleteBusinessConcept(final String businessConceptName, final WsDataModelPK wsDataModelPK) {
        this.businessConceptName = businessConceptName;
        this.wsDataModelPK = wsDataModelPK;
    }

    /**
     * Gets the value of the businessConceptName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessConceptName() {
        return businessConceptName;
    }

    /**
     * Sets the value of the businessConceptName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessConceptName(String value) {
        this.businessConceptName = value;
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
