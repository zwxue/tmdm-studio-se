
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsGetItemsSort complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsGetItemsSort">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="conceptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxItems" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="skip" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spellTreshold" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalCountOnFirstResult" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="whereItem" type="{http://www.talend.com/mdm}wsWhereItem" minOccurs="0"/>
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
@XmlType(name = "wsGetItemsSort", propOrder = {
    "conceptName",
    "dir",
    "maxItems",
    "skip",
    "sort",
    "spellTreshold",
    "totalCountOnFirstResult",
    "whereItem",
    "wsDataClusterPK"
})
public class WsGetItemsSort {

    protected String conceptName;
    protected String dir;
    protected int maxItems;
    protected int skip;
    protected String sort;
    protected int spellTreshold;
    protected Boolean totalCountOnFirstResult;
    protected WsWhereItem whereItem;
    protected WsDataClusterPK wsDataClusterPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsGetItemsSort() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsGetItemsSort(final String conceptName, final String dir, final int maxItems, final int skip, final String sort, final int spellTreshold, final Boolean totalCountOnFirstResult, final WsWhereItem whereItem, final WsDataClusterPK wsDataClusterPK) {
        this.conceptName = conceptName;
        this.dir = dir;
        this.maxItems = maxItems;
        this.skip = skip;
        this.sort = sort;
        this.spellTreshold = spellTreshold;
        this.totalCountOnFirstResult = totalCountOnFirstResult;
        this.whereItem = whereItem;
        this.wsDataClusterPK = wsDataClusterPK;
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
     * Gets the value of the dir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDir() {
        return dir;
    }

    /**
     * Sets the value of the dir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDir(String value) {
        this.dir = value;
    }

    /**
     * Gets the value of the maxItems property.
     * 
     */
    public int getMaxItems() {
        return maxItems;
    }

    /**
     * Sets the value of the maxItems property.
     * 
     */
    public void setMaxItems(int value) {
        this.maxItems = value;
    }

    /**
     * Gets the value of the skip property.
     * 
     */
    public int getSkip() {
        return skip;
    }

    /**
     * Sets the value of the skip property.
     * 
     */
    public void setSkip(int value) {
        this.skip = value;
    }

    /**
     * Gets the value of the sort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSort() {
        return sort;
    }

    /**
     * Sets the value of the sort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSort(String value) {
        this.sort = value;
    }

    /**
     * Gets the value of the spellTreshold property.
     * 
     */
    public int getSpellTreshold() {
        return spellTreshold;
    }

    /**
     * Sets the value of the spellTreshold property.
     * 
     */
    public void setSpellTreshold(int value) {
        this.spellTreshold = value;
    }

    /**
     * Gets the value of the totalCountOnFirstResult property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTotalCountOnFirstResult() {
        return totalCountOnFirstResult;
    }

    /**
     * Sets the value of the totalCountOnFirstResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTotalCountOnFirstResult(Boolean value) {
        this.totalCountOnFirstResult = value;
    }

    /**
     * Gets the value of the whereItem property.
     * 
     * @return
     *     possible object is
     *     {@link WsWhereItem }
     *     
     */
    public WsWhereItem getWhereItem() {
        return whereItem;
    }

    /**
     * Sets the value of the whereItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsWhereItem }
     *     
     */
    public void setWhereItem(WsWhereItem value) {
        this.whereItem = value;
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
