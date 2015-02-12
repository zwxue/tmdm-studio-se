
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsProcessBytesUsingTransformerWsOutputDecisionTableDecisions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsProcessBytesUsingTransformerWsOutputDecisionTableDecisions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="decision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outputVariableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsProcessBytesUsingTransformerWsOutputDecisionTableDecisions", propOrder = {
    "decision",
    "outputVariableName"
})
public class WsProcessBytesUsingTransformerWsOutputDecisionTableDecisions {

    protected String decision;
    protected String outputVariableName;

    /**
     * Default no-arg constructor
     * 
     */
    public WsProcessBytesUsingTransformerWsOutputDecisionTableDecisions() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsProcessBytesUsingTransformerWsOutputDecisionTableDecisions(final String decision, final String outputVariableName) {
        this.decision = decision;
        this.outputVariableName = outputVariableName;
    }

    /**
     * Gets the value of the decision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecision() {
        return decision;
    }

    /**
     * Sets the value of the decision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecision(String value) {
        this.decision = value;
    }

    /**
     * Gets the value of the outputVariableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputVariableName() {
        return outputVariableName;
    }

    /**
     * Sets the value of the outputVariableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputVariableName(String value) {
        this.outputVariableName = value;
    }

}
