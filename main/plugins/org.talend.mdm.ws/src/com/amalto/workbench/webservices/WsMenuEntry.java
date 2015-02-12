
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsMenuEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsMenuEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="context" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptions" type="{http://www.talend.com/mdm}wsMenuMenuEntriesDescriptions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="icon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subMenus" type="{http://www.talend.com/mdm}wsMenuEntry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsMenuEntry", propOrder = {
    "application",
    "context",
    "descriptions",
    "icon",
    "id",
    "subMenus"
})
public class WsMenuEntry {

    protected String application;
    protected String context;
    @XmlElement(nillable = true)
    protected List<WsMenuMenuEntriesDescriptions> descriptions;
    protected String icon;
    protected String id;
    @XmlElement(nillable = true)
    protected List<WsMenuEntry> subMenus;

    /**
     * Default no-arg constructor
     * 
     */
    public WsMenuEntry() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsMenuEntry(final String application, final String context, final List<WsMenuMenuEntriesDescriptions> descriptions, final String icon, final String id, final List<WsMenuEntry> subMenus) {
        this.application = application;
        this.context = context;
        this.descriptions = descriptions;
        this.icon = icon;
        this.id = id;
        this.subMenus = subMenus;
    }

    /**
     * Gets the value of the application property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplication() {
        return application;
    }

    /**
     * Sets the value of the application property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplication(String value) {
        this.application = value;
    }

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContext(String value) {
        this.context = value;
    }

    /**
     * Gets the value of the descriptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the descriptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescriptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsMenuMenuEntriesDescriptions }
     * 
     * 
     */
    public List<WsMenuMenuEntriesDescriptions> getDescriptions() {
        if (descriptions == null) {
            descriptions = new ArrayList<WsMenuMenuEntriesDescriptions>();
        }
        return this.descriptions;
    }

    /**
     * Gets the value of the icon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcon(String value) {
        this.icon = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the subMenus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subMenus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubMenus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsMenuEntry }
     * 
     * 
     */
    public List<WsMenuEntry> getSubMenus() {
        if (subMenus == null) {
            subMenus = new ArrayList<WsMenuEntry>();
        }
        return this.subMenus;
    }

}
