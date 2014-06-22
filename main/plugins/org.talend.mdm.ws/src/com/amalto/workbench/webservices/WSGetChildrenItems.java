
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Get children items
 *             
 * 
 * <p>Java class for WSGetChildrenItems complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSGetChildrenItems">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clusterName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="conceptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PKXpaths" type="{urn-com-amalto-xtentis-webservice}WSStringArray"/>
 *         &lt;element name="FKXpath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="labelXpath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fatherPK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="whereItem" type="{urn-com-amalto-xtentis-webservice}WSWhereItem" minOccurs="0"/>
 *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="limit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSGetChildrenItems", propOrder = {
    "clusterName",
    "conceptName",
    "pkXpaths",
    "fkXpath",
    "labelXpath",
    "fatherPK",
    "whereItem",
    "start",
    "limit"
})
public class WSGetChildrenItems {

    @XmlElement(required = true)
    protected String clusterName;
    @XmlElement(required = true)
    protected String conceptName;
    @XmlElement(name = "PKXpaths", required = true)
    protected WSStringArray pkXpaths;
    @XmlElement(name = "FKXpath", nillable = true)
    protected String fkXpath;
    @XmlElement(required = true)
    protected String labelXpath;
    @XmlElement(nillable = true)
    protected String fatherPK;
    @XmlElement(nillable = true)
    protected WSWhereItem whereItem;
    protected int start;
    protected int limit;

    /**
     * Default no-arg constructor
     * 
     */
    public WSGetChildrenItems() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSGetChildrenItems(final String clusterName, final String conceptName, final WSStringArray pkXpaths, final String fkXpath, final String labelXpath, final String fatherPK, final WSWhereItem whereItem, final int start, final int limit) {
        this.clusterName = clusterName;
        this.conceptName = conceptName;
        this.pkXpaths = pkXpaths;
        this.fkXpath = fkXpath;
        this.labelXpath = labelXpath;
        this.fatherPK = fatherPK;
        this.whereItem = whereItem;
        this.start = start;
        this.limit = limit;
    }

    /**
     * Gets the value of the clusterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClusterName() {
        return clusterName;
    }

    /**
     * Sets the value of the clusterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClusterName(String value) {
        this.clusterName = value;
    }

    /**
     * Gets the value of the conceptName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConceptName() {
        return conceptName;
    }

    /**
     * Sets the value of the conceptName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConceptName(String value) {
        this.conceptName = value;
    }

    /**
     * Gets the value of the pkXpaths property.
     * 
     * @return
     *     possible object is
     *     {@link WSStringArray }
     *     
     */
    public WSStringArray getPKXpaths() {
        return pkXpaths;
    }

    /**
     * Sets the value of the pkXpaths property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSStringArray }
     *     
     */
    public void setPKXpaths(WSStringArray value) {
        this.pkXpaths = value;
    }

    /**
     * Gets the value of the fkXpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFKXpath() {
        return fkXpath;
    }

    /**
     * Sets the value of the fkXpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFKXpath(String value) {
        this.fkXpath = value;
    }

    /**
     * Gets the value of the labelXpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelXpath() {
        return labelXpath;
    }

    /**
     * Sets the value of the labelXpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelXpath(String value) {
        this.labelXpath = value;
    }

    /**
     * Gets the value of the fatherPK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatherPK() {
        return fatherPK;
    }

    /**
     * Sets the value of the fatherPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatherPK(String value) {
        this.fatherPK = value;
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
     * Gets the value of the start property.
     * 
     */
    public int getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     */
    public void setStart(int value) {
        this.start = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     */
    public void setLimit(int value) {
        this.limit = value;
    }

}
