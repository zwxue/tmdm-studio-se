
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSPutMatchRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSPutMatchRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rule" type="{urn-com-amalto-xtentis-webservice}WSMatchRule"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSPutMatchRule", propOrder = {
    "rule"
})
public class WSPutMatchRule {

    @XmlElement(required = true)
    protected WSMatchRule rule;

    /**
     * Default no-arg constructor
     * 
     */
    public WSPutMatchRule() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSPutMatchRule(final WSMatchRule rule) {
        this.rule = rule;
    }

    /**
     * Gets the value of the rule property.
     * 
     * @return
     *     possible object is
     *     {@link WSMatchRule }
     *     
     */
    public WSMatchRule getRule() {
        return rule;
    }

    /**
     * Sets the value of the rule property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSMatchRule }
     *     
     */
    public void setRule(WSMatchRule value) {
        this.rule = value;
    }

}
