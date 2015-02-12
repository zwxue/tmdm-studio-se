
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPipelineTypedContentEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPipelineTypedContentEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="output" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsExtractedContent" type="{http://www.talend.com/mdm}wsExtractedContent" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPipelineTypedContentEntry", propOrder = {
    "output",
    "wsExtractedContent"
})
public class WsPipelineTypedContentEntry {

    protected String output;
    protected WsExtractedContent wsExtractedContent;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPipelineTypedContentEntry() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPipelineTypedContentEntry(final String output, final WsExtractedContent wsExtractedContent) {
        this.output = output;
        this.wsExtractedContent = wsExtractedContent;
    }

    /**
     * Gets the value of the output property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutput(String value) {
        this.output = value;
    }

    /**
     * Gets the value of the wsExtractedContent property.
     * 
     * @return
     *     possible object is
     *     {@link WsExtractedContent }
     *     
     */
    public WsExtractedContent getWsExtractedContent() {
        return wsExtractedContent;
    }

    /**
     * Sets the value of the wsExtractedContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsExtractedContent }
     *     
     */
    public void setWsExtractedContent(WsExtractedContent value) {
        this.wsExtractedContent = value;
    }

}
