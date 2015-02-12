
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsGetItemPKsByFullCriteria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsGetItemPKsByFullCriteria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="useFTSearch" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="wsGetItemPKsByCriteria" type="{http://www.talend.com/mdm}wsGetItemPKsByCriteria" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsGetItemPKsByFullCriteria", propOrder = {
    "useFTSearch",
    "wsGetItemPKsByCriteria"
})
public class WsGetItemPKsByFullCriteria {

    protected boolean useFTSearch;
    protected WsGetItemPKsByCriteria wsGetItemPKsByCriteria;

    /**
     * Default no-arg constructor
     * 
     */
    public WsGetItemPKsByFullCriteria() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsGetItemPKsByFullCriteria(final boolean useFTSearch, final WsGetItemPKsByCriteria wsGetItemPKsByCriteria) {
        this.useFTSearch = useFTSearch;
        this.wsGetItemPKsByCriteria = wsGetItemPKsByCriteria;
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

    /**
     * Gets the value of the wsGetItemPKsByCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link WsGetItemPKsByCriteria }
     *     
     */
    public WsGetItemPKsByCriteria getWsGetItemPKsByCriteria() {
        return wsGetItemPKsByCriteria;
    }

    /**
     * Sets the value of the wsGetItemPKsByCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsGetItemPKsByCriteria }
     *     
     */
    public void setWsGetItemPKsByCriteria(WsGetItemPKsByCriteria value) {
        this.wsGetItemPKsByCriteria = value;
    }

}
