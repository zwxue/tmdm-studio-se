
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSRoutingRuleExpression complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSRoutingRuleExpression">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xpath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsOperator" type="{urn-com-amalto-xtentis-webservice}WSRoutingRuleOperator" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSRoutingRuleExpression", propOrder = {
    "name",
    "xpath",
    "wsOperator",
    "value"
})
public class WSRoutingRuleExpression {

    @XmlElement(nillable = true)
    protected String name;
    @XmlElement(nillable = true)
    protected String xpath;
    @XmlElement(nillable = true)
    protected WSRoutingRuleOperator wsOperator;
    @XmlElement(nillable = true)
    protected String value;

    /**
     * Default no-arg constructor
     * 
     */
    public WSRoutingRuleExpression() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSRoutingRuleExpression(final String name, final String xpath, final WSRoutingRuleOperator wsOperator, final String value) {
        this.name = name;
        this.xpath = xpath;
        this.wsOperator = wsOperator;
        this.value = value;
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

    /**
     * Gets the value of the xpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * Sets the value of the xpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXpath(String value) {
        this.xpath = value;
    }

    /**
     * Gets the value of the wsOperator property.
     * 
     * @return
     *     possible object is
     *     {@link WSRoutingRuleOperator }
     *     
     */
    public WSRoutingRuleOperator getWsOperator() {
        return wsOperator;
    }

    /**
     * Sets the value of the wsOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSRoutingRuleOperator }
     *     
     */
    public void setWsOperator(WSRoutingRuleOperator value) {
        this.wsOperator = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
