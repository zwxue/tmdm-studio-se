
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPutBackgroundJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPutBackgroundJob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsBackgroundJob" type="{http://www.talend.com/mdm}wsBackgroundJob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPutBackgroundJob", propOrder = {
    "wsBackgroundJob"
})
public class WsPutBackgroundJob {

    protected WsBackgroundJob wsBackgroundJob;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPutBackgroundJob() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPutBackgroundJob(final WsBackgroundJob wsBackgroundJob) {
        this.wsBackgroundJob = wsBackgroundJob;
    }

    /**
     * Gets the value of the wsBackgroundJob property.
     * 
     * @return
     *     possible object is
     *     {@link WsBackgroundJob }
     *     
     */
    public WsBackgroundJob getWsBackgroundJob() {
        return wsBackgroundJob;
    }

    /**
     * Sets the value of the wsBackgroundJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsBackgroundJob }
     *     
     */
    public void setWsBackgroundJob(WsBackgroundJob value) {
        this.wsBackgroundJob = value;
    }

}
