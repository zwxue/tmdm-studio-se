
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutDataCluster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutDataCluster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsDataCluster" type="{http://www.talend.com/mdm}wsDataCluster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutDataCluster", propOrder = {
    "wsDataCluster"
})
public class WsPutDataCluster {

    protected WsDataCluster wsDataCluster;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutDataCluster() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutDataCluster(final WsDataCluster wsDataCluster) {
        this.wsDataCluster = wsDataCluster;
    }

    /**
     * Gets the value of the wsDataCluster property.
     * 
     * @return
     *     possible object is
     *     {@link WsDataCluster }
     *     
     */
    public WsDataCluster getWsDataCluster() {
        return wsDataCluster;
    }

    /**
     * Sets the value of the wsDataCluster property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsDataCluster }
     *     
     */
    public void setWsDataCluster(WsDataCluster value) {
        this.wsDataCluster = value;
    }

}
