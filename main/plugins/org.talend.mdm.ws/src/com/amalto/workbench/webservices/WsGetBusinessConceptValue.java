
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsGetBusinessConceptValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsGetBusinessConceptValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsBusinessConceptPK" type="{http://www.talend.com/mdm}wsBusinessConceptPK" minOccurs="0"/>
 *         &lt;element name="wsDataClusterPK" type="{http://www.talend.com/mdm}wsDataClusterPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsGetBusinessConceptValue", propOrder = {
    "wsBusinessConceptPK",
    "wsDataClusterPK"
})
public class WsGetBusinessConceptValue {

    protected WsBusinessConceptPK wsBusinessConceptPK;
    protected WsDataClusterPK wsDataClusterPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsGetBusinessConceptValue() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsGetBusinessConceptValue(final WsBusinessConceptPK wsBusinessConceptPK, final WsDataClusterPK wsDataClusterPK) {
        this.wsBusinessConceptPK = wsBusinessConceptPK;
        this.wsDataClusterPK = wsDataClusterPK;
    }

    /**
     * Gets the value of the wsBusinessConceptPK property.
     * 
     * @return
     *     possible object is
     *     {@link WsBusinessConceptPK }
     *     
     */
    public WsBusinessConceptPK getWsBusinessConceptPK() {
        return wsBusinessConceptPK;
    }

    /**
     * Sets the value of the wsBusinessConceptPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsBusinessConceptPK }
     *     
     */
    public void setWsBusinessConceptPK(WsBusinessConceptPK value) {
        this.wsBusinessConceptPK = value;
    }

    /**
     * Gets the value of the wsDataClusterPK property.
     * 
     * @return
     *     possible object is
     *     {@link WsDataClusterPK }
     *     
     */
    public WsDataClusterPK getWsDataClusterPK() {
        return wsDataClusterPK;
    }

    /**
     * Sets the value of the wsDataClusterPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsDataClusterPK }
     *     
     */
    public void setWsDataClusterPK(WsDataClusterPK value) {
        this.wsDataClusterPK = value;
    }

}
