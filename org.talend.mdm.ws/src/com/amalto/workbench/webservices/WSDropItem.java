
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Drop an item to items trash
 * 			
 * 
 * <p>Java class for WSDropItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSDropItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsItemPK" type="{urn-com-amalto-xtentis-webservice}WSItemPK"/>
 *         &lt;element name="partPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="override" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSDropItem", propOrder = {
    "wsItemPK",
    "partPath",
    "override"
})
public class WSDropItem {

    @XmlElement(required = true)
    protected WSItemPK wsItemPK;
    @XmlElement(required = true, nillable = true)
    protected String partPath;
    @XmlElement(nillable = true)
    protected Boolean override;

    /**
     * Default no-arg constructor
     * 
     */
    public WSDropItem() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSDropItem(final WSItemPK wsItemPK, final String partPath, final Boolean override) {
        this.wsItemPK = wsItemPK;
        this.partPath = partPath;
        this.override = override;
    }

    /**
     * Gets the value of the wsItemPK property.
     * 
     * @return
     *     possible object is
     *     {@link WSItemPK }
     *     
     */
    public WSItemPK getWsItemPK() {
        return wsItemPK;
    }

    /**
     * Sets the value of the wsItemPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSItemPK }
     *     
     */
    public void setWsItemPK(WSItemPK value) {
        this.wsItemPK = value;
    }

    /**
     * Gets the value of the partPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartPath() {
        return partPath;
    }

    /**
     * Sets the value of the partPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartPath(String value) {
        this.partPath = value;
    }

    /**
     * Gets the value of the override property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOverride() {
        return override;
    }

    /**
     * Sets the value of the override property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOverride(Boolean value) {
        this.override = value;
    }

}
