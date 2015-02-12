
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spellTreshold" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "wsCount", propOrder = {
    "countPath",
    "spellTreshold",
    "whereItem",
    "wsDataClusterPK"
})
public class WsCount {

    protected String countPath;
    protected int spellTreshold;
    protected WsWhereItem whereItem;
    protected WsDataClusterPK wsDataClusterPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsCount() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsCount(final String countPath, final int spellTreshold, final WsWhereItem whereItem, final WsDataClusterPK wsDataClusterPK) {
        this.countPath = countPath;
        this.spellTreshold = spellTreshold;
        this.whereItem = whereItem;
        this.wsDataClusterPK = wsDataClusterPK;
    }

    /**
     * Gets the value of the countPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountPath() {
        return countPath;
    }

    /**
     * Sets the value of the countPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountPath(String value) {
        this.countPath = value;
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
