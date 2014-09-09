
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Deletes an item based on its cluster pk and its key(s)
 * 			
 * 
 * <p>Java class for WSDeleteItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSDeleteItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsItemPK" type="{urn-com-amalto-xtentis-webservice}WSItemPK"/>
 *         &lt;element name="override" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="withReport" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invokeBeforeDeleting" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSDeleteItem", propOrder = {
    "wsItemPK",
    "override",
    "withReport",
    "source",
    "invokeBeforeDeleting"
})
public class WSDeleteItem {

    @XmlElement(required = true)
    protected WSItemPK wsItemPK;
    @XmlElement(nillable = true)
    protected Boolean override;
    @XmlElement(nillable = true)
    protected Boolean withReport;
    @XmlElement(nillable = true)
    protected String source;
    @XmlElement(nillable = true)
    protected Boolean invokeBeforeDeleting;

    /**
     * Default no-arg constructor
     * 
     */
    public WSDeleteItem() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSDeleteItem(final WSItemPK wsItemPK, final Boolean override, final Boolean withReport, final String source, final Boolean invokeBeforeDeleting) {
        this.wsItemPK = wsItemPK;
        this.override = override;
        this.withReport = withReport;
        this.source = source;
        this.invokeBeforeDeleting = invokeBeforeDeleting;
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

    /**
     * Gets the value of the withReport property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWithReport() {
        return withReport;
    }

    /**
     * Sets the value of the withReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWithReport(Boolean value) {
        this.withReport = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the invokeBeforeDeleting property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInvokeBeforeDeleting() {
        return invokeBeforeDeleting;
    }

    /**
     * Sets the value of the invokeBeforeDeleting property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInvokeBeforeDeleting(Boolean value) {
        this.invokeBeforeDeleting = value;
    }

}
