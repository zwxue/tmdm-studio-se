
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsExtractedContent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsExtractedContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsByteArray" type="{http://www.talend.com/mdm}wsByteArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsExtractedContent", propOrder = {
    "contentType",
    "wsByteArray"
})
public class WsExtractedContent {

    protected String contentType;
    protected WsByteArray wsByteArray;

    /**
     * Default no-arg constructor
     * 
     */
    public WsExtractedContent() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsExtractedContent(final String contentType, final WsByteArray wsByteArray) {
        this.contentType = contentType;
        this.wsByteArray = wsByteArray;
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
     * Gets the value of the wsByteArray property.
     * 
     * @return
     *     possible object is
     *     {@link WsByteArray }
     *     
     */
    public WsByteArray getWsByteArray() {
        return wsByteArray;
    }

    /**
     * Sets the value of the wsByteArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsByteArray }
     *     
     */
    public void setWsByteArray(WsByteArray value) {
        this.wsByteArray = value;
    }

}
