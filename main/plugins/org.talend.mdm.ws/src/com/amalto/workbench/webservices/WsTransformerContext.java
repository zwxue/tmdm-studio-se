
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsTransformerContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsTransformerContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pipeline" type="{http://www.talend.com/mdm}wsTransformerContextPipeline" minOccurs="0"/>
 *         &lt;element name="projectedItemPKs" type="{http://www.talend.com/mdm}wsTransformerContextProjectedItemPKs" minOccurs="0"/>
 *         &lt;element name="wsTransformerPK" type="{http://www.talend.com/mdm}wsTransformerV2PK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsTransformerContext", propOrder = {
    "pipeline",
    "projectedItemPKs",
    "wsTransformerPK"
})
public class WsTransformerContext {

    protected WsTransformerContextPipeline pipeline;
    protected WsTransformerContextProjectedItemPKs projectedItemPKs;
    protected WsTransformerV2PK wsTransformerPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsTransformerContext() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsTransformerContext(final WsTransformerContextPipeline pipeline, final WsTransformerContextProjectedItemPKs projectedItemPKs, final WsTransformerV2PK wsTransformerPK) {
        this.pipeline = pipeline;
        this.projectedItemPKs = projectedItemPKs;
        this.wsTransformerPK = wsTransformerPK;
    }

    /**
     * Gets the value of the pipeline property.
     * 
     * @return
     *     possible object is
     *     {@link WsTransformerContextPipeline }
     *     
     */
    public WsTransformerContextPipeline getPipeline() {
        return pipeline;
    }

    /**
     * Sets the value of the pipeline property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTransformerContextPipeline }
     *     
     */
    public void setPipeline(WsTransformerContextPipeline value) {
        this.pipeline = value;
    }

    /**
     * Gets the value of the projectedItemPKs property.
     * 
     * @return
     *     possible object is
     *     {@link WsTransformerContextProjectedItemPKs }
     *     
     */
    public WsTransformerContextProjectedItemPKs getProjectedItemPKs() {
        return projectedItemPKs;
    }

    /**
     * Sets the value of the projectedItemPKs property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTransformerContextProjectedItemPKs }
     *     
     */
    public void setProjectedItemPKs(WsTransformerContextProjectedItemPKs value) {
        this.projectedItemPKs = value;
    }

    /**
     * Gets the value of the wsTransformerPK property.
     * 
     * @return
     *     possible object is
     *     {@link WsTransformerV2PK }
     *     
     */
    public WsTransformerV2PK getWsTransformerPK() {
        return wsTransformerPK;
    }

    /**
     * Sets the value of the wsTransformerPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTransformerV2PK }
     *     
     */
    public void setWsTransformerPK(WsTransformerV2PK value) {
        this.wsTransformerPK = value;
    }

}
