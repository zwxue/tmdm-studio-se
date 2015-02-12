
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsExecuteTransformerV2AsJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsExecuteTransformerV2AsJob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsTransformerContext" type="{http://www.talend.com/mdm}wsTransformerContext" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsExecuteTransformerV2AsJob", propOrder = {
    "wsTransformerContext"
})
public class WsExecuteTransformerV2AsJob {

    protected WsTransformerContext wsTransformerContext;

    /**
     * Default no-arg constructor
     * 
     */
    public WsExecuteTransformerV2AsJob() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsExecuteTransformerV2AsJob(final WsTransformerContext wsTransformerContext) {
        this.wsTransformerContext = wsTransformerContext;
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

}
