
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsBusinessConcept complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsBusinessConcept">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="businessTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsDescription" type="{http://www.talend.com/mdm}wsi18NString" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wsLabel" type="{http://www.talend.com/mdm}wsi18NString" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wsUniqueKey" type="{http://www.talend.com/mdm}wsKey" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsBusinessConcept", propOrder = {
    "businessTemplate",
    "name",
    "wsDescription",
    "wsLabel",
    "wsUniqueKey"
})
public class WsBusinessConcept {

    protected String businessTemplate;
    protected String name;
    @XmlElement(nillable = true)
    protected List<Wsi18NString> wsDescription;
    @XmlElement(nillable = true)
    protected List<Wsi18NString> wsLabel;
    protected WsKey wsUniqueKey;

    /**
     * Default no-arg constructor
     * 
     */
    public WsBusinessConcept() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsBusinessConcept(final String businessTemplate, final String name, final List<Wsi18NString> wsDescription, final List<Wsi18NString> wsLabel, final WsKey wsUniqueKey) {
        this.businessTemplate = businessTemplate;
        this.name = name;
        this.wsDescription = wsDescription;
        this.wsLabel = wsLabel;
        this.wsUniqueKey = wsUniqueKey;
    }

    /**
     * Gets the value of the businessTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessTemplate() {
        return businessTemplate;
    }

    /**
     * Sets the value of the businessTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessTemplate(String value) {
        this.businessTemplate = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the wsDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Wsi18NString }
     * 
     * 
     */
    public List<Wsi18NString> getWsDescription() {
        if (wsDescription == null) {
            wsDescription = new ArrayList<Wsi18NString>();
        }
        return this.wsDescription;
    }

    /**
     * Gets the value of the wsLabel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsLabel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsLabel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Wsi18NString }
     * 
     * 
     */
    public List<Wsi18NString> getWsLabel() {
        if (wsLabel == null) {
            wsLabel = new ArrayList<Wsi18NString>();
        }
        return this.wsLabel;
    }

    /**
     * Gets the value of the wsUniqueKey property.
     * 
     * @return
     *     possible object is
     *     {@link WsKey }
     *     
     */
    public WsKey getWsUniqueKey() {
        return wsUniqueKey;
    }

    /**
     * Sets the value of the wsUniqueKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsKey }
     *     
     */
    public void setWsUniqueKey(WsKey value) {
        this.wsUniqueKey = value;
    }

}
