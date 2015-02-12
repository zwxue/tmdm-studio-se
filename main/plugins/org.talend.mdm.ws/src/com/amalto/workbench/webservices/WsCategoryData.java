
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsCategoryData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsCategoryData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categorySchema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCategoryData", propOrder = {
    "categorySchema"
})
public class WsCategoryData {

    protected String categorySchema;

    /**
     * Default no-arg constructor
     * 
     */
    public WsCategoryData() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsCategoryData(final String categorySchema) {
        this.categorySchema = categorySchema;
    }

    /**
     * Gets the value of the categorySchema property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategorySchema() {
        return categorySchema;
    }

    /**
     * Sets the value of the categorySchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategorySchema(String value) {
        this.categorySchema = value;
    }

}
