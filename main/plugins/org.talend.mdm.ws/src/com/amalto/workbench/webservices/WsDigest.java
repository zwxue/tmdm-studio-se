
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsDigest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsDigest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="digestValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="wsDigestKey" type="{http://www.talend.com/mdm}wsDigestKey" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsDigest", propOrder = {
    "digestValue",
    "timeStamp",
    "wsDigestKey"
})
public class WsDigest {

    protected String digestValue;
    protected long timeStamp;
    protected WsDigestKey wsDigestKey;

    /**
     * Default no-arg constructor
     * 
     */
    public WsDigest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsDigest(final String digestValue, final long timeStamp, final WsDigestKey wsDigestKey) {
        this.digestValue = digestValue;
        this.timeStamp = timeStamp;
        this.wsDigestKey = wsDigestKey;
    }

    /**
     * Gets the value of the digestValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDigestValue() {
        return digestValue;
    }

    /**
     * Sets the value of the digestValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDigestValue(String value) {
        this.digestValue = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     */
    public void setTimeStamp(long value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the wsDigestKey property.
     * 
     * @return
     *     possible object is
     *     {@link WsDigestKey }
     *     
     */
    public WsDigestKey getWsDigestKey() {
        return wsDigestKey;
    }

    /**
     * Sets the value of the wsDigestKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsDigestKey }
     *     
     */
    public void setWsDigestKey(WsDigestKey value) {
        this.wsDigestKey = value;
    }

}
