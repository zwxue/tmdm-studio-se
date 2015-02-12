
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsWhereCondition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsWhereCondition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="leftPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://www.talend.com/mdm}wsWhereOperator" minOccurs="0"/>
 *         &lt;element name="rightValueOrPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spellCheck" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="stringPredicate" type="{http://www.talend.com/mdm}wsStringPredicate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsWhereCondition", propOrder = {
    "leftPath",
    "operator",
    "rightValueOrPath",
    "spellCheck",
    "stringPredicate"
})
public class WsWhereCondition {

    protected String leftPath;
    protected WsWhereOperator operator;
    protected String rightValueOrPath;
    protected boolean spellCheck;
    protected WsStringPredicate stringPredicate;

    /**
     * Default no-arg constructor
     * 
     */
    public WsWhereCondition() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsWhereCondition(final String leftPath, final WsWhereOperator operator, final String rightValueOrPath, final boolean spellCheck, final WsStringPredicate stringPredicate) {
        this.leftPath = leftPath;
        this.operator = operator;
        this.rightValueOrPath = rightValueOrPath;
        this.spellCheck = spellCheck;
        this.stringPredicate = stringPredicate;
    }

    /**
     * Gets the value of the leftPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeftPath() {
        return leftPath;
    }

    /**
     * Sets the value of the leftPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeftPath(String value) {
        this.leftPath = value;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link WsWhereOperator }
     *     
     */
    public WsWhereOperator getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsWhereOperator }
     *     
     */
    public void setOperator(WsWhereOperator value) {
        this.operator = value;
    }

    /**
     * Gets the value of the rightValueOrPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRightValueOrPath() {
        return rightValueOrPath;
    }

    /**
     * Sets the value of the rightValueOrPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRightValueOrPath(String value) {
        this.rightValueOrPath = value;
    }

    /**
     * Gets the value of the spellCheck property.
     * 
     */
    public boolean isSpellCheck() {
        return spellCheck;
    }

    /**
     * Sets the value of the spellCheck property.
     * 
     */
    public void setSpellCheck(boolean value) {
        this.spellCheck = value;
    }

    /**
     * Gets the value of the stringPredicate property.
     * 
     * @return
     *     possible object is
     *     {@link WsStringPredicate }
     *     
     */
    public WsStringPredicate getStringPredicate() {
        return stringPredicate;
    }

    /**
     * Sets the value of the stringPredicate property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsStringPredicate }
     *     
     */
    public void setStringPredicate(WsStringPredicate value) {
        this.stringPredicate = value;
    }

}
