
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSDigest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSDigest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsDigestKey" type="{urn-com-amalto-xtentis-webservice}WSDigestKey"/>
 *         &lt;element name="digestValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSDigest", propOrder = {
    "wsDigestKey",
    "digestValue",
    "timeStamp"
})
public class WSDigest {

    @XmlElement(required = true)
    protected WSDigestKey wsDigestKey;
    @XmlElement(required = true, nillable = true)
    protected String digestValue;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long timeStamp;

    /**
     * Default no-arg constructor
     * 
     */
    public WSDigest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSDigest(final WSDigestKey wsDigestKey, final String digestValue, final Long timeStamp) {
        this.wsDigestKey = wsDigestKey;
        this.digestValue = digestValue;
        this.timeStamp = timeStamp;
    }

    /**
     * Gets the value of the wsDigestKey property.
     * 
     * @return
     *     possible object is
     *     {@link WSDigestKey }
     *     
     */
    public WSDigestKey getWsDigestKey() {
        return wsDigestKey;
    }

    /**
     * Sets the value of the wsDigestKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSDigestKey }
     *     
     */
    public void setWsDigestKey(WSDigestKey value) {
        this.wsDigestKey = value;
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
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimeStamp(Long value) {
        this.timeStamp = value;
    }

}
