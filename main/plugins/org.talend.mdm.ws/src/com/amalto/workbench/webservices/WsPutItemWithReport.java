
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutItemWithReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutItemWithReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="invokeBeforeSaving" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsPutItem" type="{http://www.talend.com/mdm}wsPutItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutItemWithReport", propOrder = {
    "invokeBeforeSaving",
    "source",
    "wsPutItem"
})
public class WsPutItemWithReport {

    protected Boolean invokeBeforeSaving;
    protected String source;
    protected WsPutItem wsPutItem;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutItemWithReport() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutItemWithReport(final Boolean invokeBeforeSaving, final String source, final WsPutItem wsPutItem) {
        this.invokeBeforeSaving = invokeBeforeSaving;
        this.source = source;
        this.wsPutItem = wsPutItem;
    }

    /**
     * Gets the value of the invokeBeforeSaving property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInvokeBeforeSaving() {
        return invokeBeforeSaving;
    }

    /**
     * Sets the value of the invokeBeforeSaving property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInvokeBeforeSaving(Boolean value) {
        this.invokeBeforeSaving = value;
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
     * Gets the value of the wsPutItem property.
     * 
     * @return
     *     possible object is
     *     {@link WsPutItem }
     *     
     */
    public WsPutItem getWsPutItem() {
        return wsPutItem;
    }

    /**
     * Sets the value of the wsPutItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsPutItem }
     *     
     */
    public void setWsPutItem(WsPutItem value) {
        this.wsPutItem = value;
    }

}
