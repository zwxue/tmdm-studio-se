
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsProcessBytesUsingTransformer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsProcessBytesUsingTransformer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsBytes" type="{http://www.talend.com/mdm}wsByteArray" minOccurs="0"/>
 *         &lt;element name="wsOutputDecisionTable" type="{http://www.talend.com/mdm}wsOutputDecisionTable" minOccurs="0"/>
 *         &lt;element name="wsTransformerPK" type="{http://www.talend.com/mdm}wsTransformerPK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsProcessBytesUsingTransformer", propOrder = {
    "contentType",
    "wsBytes",
    "wsOutputDecisionTable",
    "wsTransformerPK"
})
public class WsProcessBytesUsingTransformer {

    protected String contentType;
    protected WsByteArray wsBytes;
    protected WsOutputDecisionTable wsOutputDecisionTable;
    protected WsTransformerPK wsTransformerPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsProcessBytesUsingTransformer() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsProcessBytesUsingTransformer(final String contentType, final WsByteArray wsBytes, final WsOutputDecisionTable wsOutputDecisionTable, final WsTransformerPK wsTransformerPK) {
        this.contentType = contentType;
        this.wsBytes = wsBytes;
        this.wsOutputDecisionTable = wsOutputDecisionTable;
        this.wsTransformerPK = wsTransformerPK;
    }

    /**
     * Gets the value of the contentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

    /**
     * Gets the value of the wsBytes property.
     * 
     * @return
     *     possible object is
     *     {@link WsByteArray }
     *     
     */
    public WsByteArray getWsBytes() {
        return wsBytes;
    }

    /**
     * Sets the value of the wsBytes property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsByteArray }
     *     
     */
    public void setWsBytes(WsByteArray value) {
        this.wsBytes = value;
    }

    /**
     * Gets the value of the wsOutputDecisionTable property.
     * 
     * @return
     *     possible object is
     *     {@link WsOutputDecisionTable }
     *     
     */
    public WsOutputDecisionTable getWsOutputDecisionTable() {
        return wsOutputDecisionTable;
    }

    /**
     * Sets the value of the wsOutputDecisionTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsOutputDecisionTable }
     *     
     */
    public void setWsOutputDecisionTable(WsOutputDecisionTable value) {
        this.wsOutputDecisionTable = value;
    }

    /**
     * Gets the value of the wsTransformerPK property.
     * 
     * @return
     *     possible object is
     *     {@link WsTransformerPK }
     *     
     */
    public WsTransformerPK getWsTransformerPK() {
        return wsTransformerPK;
    }

    /**
     * Sets the value of the wsTransformerPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTransformerPK }
     *     
     */
    public void setWsTransformerPK(WsTransformerPK value) {
        this.wsTransformerPK = value;
    }

}
