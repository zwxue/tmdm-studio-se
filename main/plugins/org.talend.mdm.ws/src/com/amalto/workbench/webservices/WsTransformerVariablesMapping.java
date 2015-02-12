
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsTransformerVariablesMapping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsTransformerVariablesMapping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hardCoding" type="{http://www.talend.com/mdm}wsTypedContent" minOccurs="0"/>
 *         &lt;element name="pipelineVariable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pluginVariable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsTransformerVariablesMapping", propOrder = {
    "hardCoding",
    "pipelineVariable",
    "pluginVariable"
})
public class WsTransformerVariablesMapping {

    protected WsTypedContent hardCoding;
    protected String pipelineVariable;
    protected String pluginVariable;

    /**
     * Default no-arg constructor
     * 
     */
    public WsTransformerVariablesMapping() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsTransformerVariablesMapping(final WsTypedContent hardCoding, final String pipelineVariable, final String pluginVariable) {
        this.hardCoding = hardCoding;
        this.pipelineVariable = pipelineVariable;
        this.pluginVariable = pluginVariable;
    }

    /**
     * Gets the value of the hardCoding property.
     * 
     * @return
     *     possible object is
     *     {@link WsTypedContent }
     *     
     */
    public WsTypedContent getHardCoding() {
        return hardCoding;
    }

    /**
     * Sets the value of the hardCoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTypedContent }
     *     
     */
    public void setHardCoding(WsTypedContent value) {
        this.hardCoding = value;
    }

    /**
     * Gets the value of the pipelineVariable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPipelineVariable() {
        return pipelineVariable;
    }

    /**
     * Sets the value of the pipelineVariable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPipelineVariable(String value) {
        this.pipelineVariable = value;
    }

    /**
     * Gets the value of the pluginVariable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPluginVariable() {
        return pluginVariable;
    }

    /**
     * Sets the value of the pluginVariable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPluginVariable(String value) {
        this.pluginVariable = value;
    }

}
