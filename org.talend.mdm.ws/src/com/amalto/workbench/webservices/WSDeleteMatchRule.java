
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSDeleteMatchRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSDeleteMatchRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PK" type="{urn-com-amalto-xtentis-webservice}WSMatchRulePK"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSDeleteMatchRule", propOrder = {
    "pk"
})
public class WSDeleteMatchRule {

    @XmlElement(name = "PK", required = true)
    protected WSMatchRulePK pk;

    /**
     * Default no-arg constructor
     * 
     */
    public WSDeleteMatchRule() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSDeleteMatchRule(final WSMatchRulePK pk) {
        this.pk = pk;
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

}
