
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsRoutingRuleExpression complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsRoutingRuleExpression">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsOperator" type="{http://www.talend.com/mdm}wsRoutingRuleOperator" minOccurs="0"/>
 *         &lt;element name="xpath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsRoutingRuleExpression", propOrder = {
    "name",
    "value",
    "wsOperator",
    "xpath"
})
public class WsRoutingRuleExpression {

    protected String name;
    protected String value;
    protected WsRoutingRuleOperator wsOperator;
    protected String xpath;

    /**
     * Default no-arg constructor
     * 
     */
    public WsRoutingRuleExpression() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsRoutingRuleExpression(final String name, final String value, final WsRoutingRuleOperator wsOperator, final String xpath) {
        this.name = name;
        this.value = value;
        this.wsOperator = wsOperator;
        this.xpath = xpath;
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

    /**
     * Gets the value of the wsOperator property.
     * 
     * @return
     *     possible object is
     *     {@link WsRoutingRuleOperator }
     *     
     */
    public WsRoutingRuleOperator getWsOperator() {
        return wsOperator;
    }

    /**
     * Sets the value of the wsOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsRoutingRuleOperator }
     *     
     */
    public void setWsOperator(WsRoutingRuleOperator value) {
        this.wsOperator = value;
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

}
