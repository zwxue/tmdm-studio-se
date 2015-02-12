
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsServiceGetConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsServiceGetConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jndiName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="optionalParameter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsServiceGetConfiguration", propOrder = {
    "jndiName",
    "optionalParameter"
})
public class WsServiceGetConfiguration {

    protected String jndiName;
    protected String optionalParameter;

    /**
     * Default no-arg constructor
     * 
     */
    public WsServiceGetConfiguration() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsServiceGetConfiguration(final String jndiName, final String optionalParameter) {
        this.jndiName = jndiName;
        this.optionalParameter = optionalParameter;
    }

    /**
     * Gets the value of the jndiName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJndiName() {
        return jndiName;
    }

    /**
     * Sets the value of the jndiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJndiName(String value) {
        this.jndiName = value;
    }

    /**
     * Gets the value of the optionalParameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionalParameter() {
        return optionalParameter;
    }

    /**
     * Sets the value of the optionalParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionalParameter(String value) {
        this.optionalParameter = value;
    }

}
