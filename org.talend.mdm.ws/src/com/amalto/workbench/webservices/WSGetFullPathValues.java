
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Return all the possible values for a full path starting with the concept name
 * 				optionally filtered with a condition
 * 			
 * 
 * <p>Java class for WSGetFullPathValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSGetFullPathValues">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsDataClusterPK" type="{urn-com-amalto-xtentis-webservice}WSDataClusterPK"/>
 *         &lt;element name="fullPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="whereItem" type="{urn-com-amalto-xtentis-webservice}WSWhereItem"/>
 *         &lt;element name="spellThreshold" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orderBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSGetFullPathValues", propOrder = {
    "wsDataClusterPK",
    "fullPath",
    "whereItem",
    "spellThreshold",
    "orderBy",
    "direction"
})
public class WSGetFullPathValues {

    @XmlElement(required = true)
    protected WSDataClusterPK wsDataClusterPK;
    @XmlElement(required = true)
    protected String fullPath;
    @XmlElement(required = true, nillable = true)
    protected WSWhereItem whereItem;
    protected int spellThreshold;
    @XmlElement(nillable = true)
    protected String orderBy;
    @XmlElement(nillable = true)
    protected String direction;

    /**
     * Default no-arg constructor
     * 
     */
    public WSGetFullPathValues() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSGetFullPathValues(final WSDataClusterPK wsDataClusterPK, final String fullPath, final WSWhereItem whereItem, final int spellThreshold, final String orderBy, final String direction) {
        this.wsDataClusterPK = wsDataClusterPK;
        this.fullPath = fullPath;
        this.whereItem = whereItem;
        this.spellThreshold = spellThreshold;
        this.orderBy = orderBy;
        this.direction = direction;
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
     * Gets the value of the fullPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullPath() {
        return fullPath;
    }

    /**
     * Sets the value of the fullPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullPath(String value) {
        this.fullPath = value;
    }

    /**
     * Gets the value of the whereItem property.
     * 
     * @return
     *     possible object is
     *     {@link WSWhereItem }
     *     
     */
    public WSWhereItem getWhereItem() {
        return whereItem;
    }

    /**
     * Sets the value of the whereItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSWhereItem }
     *     
     */
    public void setWhereItem(WSWhereItem value) {
        this.whereItem = value;
    }

    /**
     * Gets the value of the spellThreshold property.
     * 
     */
    public int getSpellThreshold() {
        return spellThreshold;
    }

    /**
     * Sets the value of the spellThreshold property.
     * 
     */
    public void setSpellThreshold(int value) {
        this.spellThreshold = value;
    }

    /**
     * Gets the value of the orderBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * Sets the value of the orderBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderBy(String value) {
        this.orderBy = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

}
