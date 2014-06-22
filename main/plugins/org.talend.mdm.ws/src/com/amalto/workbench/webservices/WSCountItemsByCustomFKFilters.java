
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Count items based on customized FK filters
 *             
 * 
 * <p>Java class for WSCountItemsByCustomFKFilters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSCountItemsByCustomFKFilters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsDataClusterPK" type="{urn-com-amalto-xtentis-webservice}WSDataClusterPK"/>
 *         &lt;element name="conceptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="injectedXpath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSCountItemsByCustomFKFilters", propOrder = {
    "wsDataClusterPK",
    "conceptName",
    "injectedXpath"
})
public class WSCountItemsByCustomFKFilters {

    @XmlElement(required = true)
    protected WSDataClusterPK wsDataClusterPK;
    @XmlElement(required = true)
    protected String conceptName;
    @XmlElement(required = true)
    protected String injectedXpath;

    /**
     * Default no-arg constructor
     * 
     */
    public WSCountItemsByCustomFKFilters() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSCountItemsByCustomFKFilters(final WSDataClusterPK wsDataClusterPK, final String conceptName, final String injectedXpath) {
        this.wsDataClusterPK = wsDataClusterPK;
        this.conceptName = conceptName;
        this.injectedXpath = injectedXpath;
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
     * Gets the value of the injectedXpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInjectedXpath() {
        return injectedXpath;
    }

    /**
     * Sets the value of the injectedXpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInjectedXpath(String value) {
        this.injectedXpath = value;
    }

}
