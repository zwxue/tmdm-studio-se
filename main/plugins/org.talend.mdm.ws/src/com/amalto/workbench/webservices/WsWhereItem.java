
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsWhereItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsWhereItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="whereAnd" type="{http://www.talend.com/mdm}wsWhereAnd" minOccurs="0"/>
 *         &lt;element name="whereCondition" type="{http://www.talend.com/mdm}wsWhereCondition" minOccurs="0"/>
 *         &lt;element name="whereOr" type="{http://www.talend.com/mdm}wsWhereOr" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsWhereItem", propOrder = {
    "whereAnd",
    "whereCondition",
    "whereOr"
})
public class WsWhereItem {

    protected WsWhereAnd whereAnd;
    protected WsWhereCondition whereCondition;
    protected WsWhereOr whereOr;

    /**
     * Default no-arg constructor
     * 
     */
    public WsWhereItem() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsWhereItem(final WsWhereAnd whereAnd, final WsWhereCondition whereCondition, final WsWhereOr whereOr) {
        this.whereAnd = whereAnd;
        this.whereCondition = whereCondition;
        this.whereOr = whereOr;
    }

    /**
     * Gets the value of the whereAnd property.
     * 
     * @return
     *     possible object is
     *     {@link WsWhereAnd }
     *     
     */
    public WsWhereAnd getWhereAnd() {
        return whereAnd;
    }

    /**
     * Sets the value of the whereAnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsWhereAnd }
     *     
     */
    public void setWhereAnd(WsWhereAnd value) {
        this.whereAnd = value;
    }

    /**
     * Gets the value of the whereCondition property.
     * 
     * @return
     *     possible object is
     *     {@link WsWhereCondition }
     *     
     */
    public WsWhereCondition getWhereCondition() {
        return whereCondition;
    }

    /**
     * Sets the value of the whereCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsWhereCondition }
     *     
     */
    public void setWhereCondition(WsWhereCondition value) {
        this.whereCondition = value;
    }

    /**
     * Gets the value of the whereOr property.
     * 
     * @return
     *     possible object is
     *     {@link WsWhereOr }
     *     
     */
    public WsWhereOr getWhereOr() {
        return whereOr;
    }

    /**
     * Sets the value of the whereOr property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsWhereOr }
     *     
     */
    public void setWhereOr(WsWhereOr value) {
        this.whereOr = value;
    }

}
