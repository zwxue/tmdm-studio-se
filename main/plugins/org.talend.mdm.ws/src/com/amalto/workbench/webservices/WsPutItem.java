
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isUpdate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="wsDataClusterPK" type="{http://www.talend.com/mdm}wsDataClusterPK" minOccurs="0"/>
 *         &lt;element name="wsDataModelPK" type="{http://www.talend.com/mdm}wsDataModelPK" minOccurs="0"/>
 *         &lt;element name="xmlString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutItem", propOrder = {
    "isUpdate",
    "wsDataClusterPK",
    "wsDataModelPK",
    "xmlString"
})
public class WsPutItem {

    protected Boolean isUpdate;
    protected WsDataClusterPK wsDataClusterPK;
    protected WsDataModelPK wsDataModelPK;
    protected String xmlString;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutItem() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutItem(final Boolean isUpdate, final WsDataClusterPK wsDataClusterPK, final WsDataModelPK wsDataModelPK, final String xmlString) {
        this.isUpdate = isUpdate;
        this.wsDataClusterPK = wsDataClusterPK;
        this.wsDataModelPK = wsDataModelPK;
        this.xmlString = xmlString;
    }

    /**
     * Gets the value of the isUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsUpdate() {
        return isUpdate;
    }

    /**
     * Sets the value of the isUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsUpdate(Boolean value) {
        this.isUpdate = value;
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

    /**
     * Gets the value of the xmlString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlString() {
        return xmlString;
    }

    /**
     * Sets the value of the xmlString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlString(String value) {
        this.xmlString = value;
    }

}
