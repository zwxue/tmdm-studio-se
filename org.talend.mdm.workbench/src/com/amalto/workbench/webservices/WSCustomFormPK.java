
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSCustomFormPK complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSCustomFormPK">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datamodel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="entity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSCustomFormPK", propOrder = {
    "datamodel",
    "entity",
    "name"
})
public class WSCustomFormPK {

    @XmlElement(required = true)
    protected String datamodel;
    @XmlElement(required = true)
    protected String entity;
    @XmlElement(nillable = true)
    protected String name;

    /**
     * Default no-arg constructor
     * 
     */
    public WSCustomFormPK() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSCustomFormPK(final String datamodel, final String entity, final String name) {
        this.datamodel = datamodel;
        this.entity = entity;
        this.name = name;
    }

    /**
     * Gets the value of the datamodel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatamodel() {
        return datamodel;
    }

    /**
     * Sets the value of the datamodel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatamodel(String value) {
        this.datamodel = value;
    }

    /**
     * Gets the value of the entity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntity() {
        return entity;
    }

    /**
     * Sets the value of the entity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntity(String value) {
        this.entity = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
