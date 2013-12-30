
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSMatchRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSMatchRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PK" type="{urn-com-amalto-xtentis-webservice}WSMatchRulePK"/>
 *         &lt;element name="configurationXmlContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSMatchRule", propOrder = {
    "pk",
    "configurationXmlContent"
})
public class WSMatchRule {

    @XmlElement(name = "PK", required = true)
    protected WSMatchRulePK pk;
    @XmlElement(required = true, nillable = true)
    protected String configurationXmlContent;

    /**
     * Default no-arg constructor
     * 
     */
    public WSMatchRule() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSMatchRule(final WSMatchRulePK pk, final String configurationXmlContent) {
        this.pk = pk;
        this.configurationXmlContent = configurationXmlContent;
    }

    /**
     * Gets the value of the pk property.
     * 
     * @return
     *     possible object is
     *     {@link WSMatchRulePK }
     *     
     */
    public WSMatchRulePK getPK() {
        return pk;
    }

    /**
     * Sets the value of the pk property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSMatchRulePK }
     *     
     */
    public void setPK(WSMatchRulePK value) {
        this.pk = value;
    }

    /**
     * Gets the value of the configurationXmlContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigurationXmlContent() {
        return configurationXmlContent;
    }

    /**
     * Sets the value of the configurationXmlContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigurationXmlContent(String value) {
        this.configurationXmlContent = value;
    }

}
