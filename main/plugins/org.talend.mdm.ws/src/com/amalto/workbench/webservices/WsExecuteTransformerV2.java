
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsExecuteTransformerV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsExecuteTransformerV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsTransformerContext" type="{http://www.talend.com/mdm}wsTransformerContext" minOccurs="0"/>
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
@XmlType(name = "wsExecuteTransformerV2", propOrder = {
    "wsTransformerContext",
    "wsTypedContent"
})
public class WsExecuteTransformerV2 {

    protected WsTransformerContext wsTransformerContext;
    protected WsTypedContent wsTypedContent;

    /**
     * Default no-arg constructor
     * 
     */
    public WsExecuteTransformerV2() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsExecuteTransformerV2(final WsTransformerContext wsTransformerContext, final WsTypedContent wsTypedContent) {
        this.wsTransformerContext = wsTransformerContext;
        this.wsTypedContent = wsTypedContent;
    }

    /**
     * Gets the value of the wsTransformerContext property.
     * 
     * @return
     *     possible object is
     *     {@link WsTransformerContext }
     *     
     */
    public WsTransformerContext getWsTransformerContext() {
        return wsTransformerContext;
    }

    /**
     * Sets the value of the wsTransformerContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsTransformerContext }
     *     
     */
    public void setWsTransformerContext(WsTransformerContext value) {
        this.wsTransformerContext = value;
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
