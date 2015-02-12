
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsTransformerContextPipelinePipelineItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsTransformerContextPipelinePipelineItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="variable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsTypedContent" type="{http://www.talend.com/mdm}wsTypedContent" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsTransformerContextPipelinePipelineItem", propOrder = {
    "variable",
    "wsTypedContent"
})
public class WsTransformerContextPipelinePipelineItem {

    protected String variable;
    protected WsTypedContent wsTypedContent;

    /**
     * Default no-arg constructor
     * 
     */
    public WsTransformerContextPipelinePipelineItem() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsTransformerContextPipelinePipelineItem(final String variable, final WsTypedContent wsTypedContent) {
        this.variable = variable;
        this.wsTypedContent = wsTypedContent;
    }

    /**
     * Gets the value of the variable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVariable() {
        return variable;
    }

    /**
     * Sets the value of the variable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVariable(String value) {
        this.variable = value;
    }

    /**
     * Gets the value of the wsTypedContent property.
     * 
     * @return
     *     possible object is
     *     {@link WsTypedContent }
     *     
     */
    public WsTypedContent getWsTypedContent() {
        return wsTypedContent;
    }

    /**
     * Sets the value of the wsTypedContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTypedContent }
     *     
     */
    public void setWsTypedContent(WsTypedContent value) {
        this.wsTypedContent = value;
    }

}
