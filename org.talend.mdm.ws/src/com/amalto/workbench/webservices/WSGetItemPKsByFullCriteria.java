
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Returns items based on criteria
 *             
 * 
 * <p>Java class for WSGetItemPKsByFullCriteria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSGetItemPKsByFullCriteria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsGetItemPKsByCriteria" type="{urn-com-amalto-xtentis-webservice}WSGetItemPKsByCriteria"/>
 *         &lt;element name="useFTSearch" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSGetItemPKsByFullCriteria", propOrder = {
    "wsGetItemPKsByCriteria",
    "useFTSearch"
})
public class WSGetItemPKsByFullCriteria {

    @XmlElement(required = true)
    protected WSGetItemPKsByCriteria wsGetItemPKsByCriteria;
    protected boolean useFTSearch;

    /**
     * Default no-arg constructor
     * 
     */
    public WSGetItemPKsByFullCriteria() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSGetItemPKsByFullCriteria(final WSGetItemPKsByCriteria wsGetItemPKsByCriteria, final boolean useFTSearch) {
        this.wsGetItemPKsByCriteria = wsGetItemPKsByCriteria;
        this.useFTSearch = useFTSearch;
    }

    /**
     * Gets the value of the wsGetItemPKsByCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link WSGetItemPKsByCriteria }
     *     
     */
    public WSGetItemPKsByCriteria getWsGetItemPKsByCriteria() {
        return wsGetItemPKsByCriteria;
    }

    /**
     * Sets the value of the wsGetItemPKsByCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSGetItemPKsByCriteria }
     *     
     */
    public void setWsGetItemPKsByCriteria(WSGetItemPKsByCriteria value) {
        this.wsGetItemPKsByCriteria = value;
    }

    /**
     * Gets the value of the useFTSearch property.
     * 
     */
    public boolean isUseFTSearch() {
        return useFTSearch;
    }

    /**
     * Sets the value of the useFTSearch property.
     * 
     */
    public void setUseFTSearch(boolean value) {
        this.useFTSearch = value;
    }

}
