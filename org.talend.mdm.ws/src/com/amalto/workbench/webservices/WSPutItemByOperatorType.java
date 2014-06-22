
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Puts an item in the xml storage.
 *             
 * 
 * <p>Java class for WSPutItemByOperatorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSPutItemByOperatorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsDataClusterPK" type="{urn-com-amalto-xtentis-webservice}WSDataClusterPK"/>
 *         &lt;element name="xmlString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wsDataModelPK" type="{urn-com-amalto-xtentis-webservice}WSDataModelPK"/>
 *         &lt;element name="operatortype" type="{urn-com-amalto-xtentis-webservice}WSOperatorType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSPutItemByOperatorType", propOrder = {
    "wsDataClusterPK",
    "xmlString",
    "wsDataModelPK",
    "operatortype"
})
public class WSPutItemByOperatorType {

    @XmlElement(required = true)
    protected WSDataClusterPK wsDataClusterPK;
    @XmlElement(required = true)
    protected String xmlString;
    @XmlElement(required = true)
    protected WSDataModelPK wsDataModelPK;
    @XmlElement(required = true)
    protected WSOperatorType operatortype;

    /**
     * Default no-arg constructor
     * 
     */
    public WSPutItemByOperatorType() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSPutItemByOperatorType(final WSDataClusterPK wsDataClusterPK, final String xmlString, final WSDataModelPK wsDataModelPK, final WSOperatorType operatortype) {
        this.wsDataClusterPK = wsDataClusterPK;
        this.xmlString = xmlString;
        this.wsDataModelPK = wsDataModelPK;
        this.operatortype = operatortype;
    }

    /**
     * Gets the value of the wsDataClusterPK property.
     * 
     * @return
     *     possible object is
     *     {@link WSDataClusterPK }
     *     
     */
    public WSDataClusterPK getWsDataClusterPK() {
        return wsDataClusterPK;
    }

    /**
     * Sets the value of the wsDataClusterPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSDataClusterPK }
     *     
     */
    public void setWsDataClusterPK(WSDataClusterPK value) {
        this.wsDataClusterPK = value;
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

    /**
     * Gets the value of the operatortype property.
     * 
     * @return
     *     possible object is
     *     {@link WSOperatorType }
     *     
     */
    public WSOperatorType getOperatortype() {
        return operatortype;
    }

    /**
     * Sets the value of the operatortype property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSOperatorType }
     *     
     */
    public void setOperatortype(WSOperatorType value) {
        this.operatortype = value;
    }

}
