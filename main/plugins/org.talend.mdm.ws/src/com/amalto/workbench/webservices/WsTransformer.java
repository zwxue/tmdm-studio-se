
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsTransformer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsTransformer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pluginSpecs" type="{http://www.talend.com/mdm}wsTransformerPluginSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsTransformer", propOrder = {
    "description",
    "name",
    "pluginSpecs"
})
public class WsTransformer {

    protected String description;
    protected String name;
    @XmlElement(nillable = true)
    protected List<WsTransformerPluginSpec> pluginSpecs;

    /**
     * Default no-arg constructor
     * 
     */
    public WsTransformer() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsTransformer(final String description, final String name, final List<WsTransformerPluginSpec> pluginSpecs) {
        this.description = description;
        this.name = name;
        this.pluginSpecs = pluginSpecs;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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
     * Gets the value of the pluginSpecs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pluginSpecs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPluginSpecs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsTransformerPluginSpec }
     * 
     * 
     */
    public List<WsTransformerPluginSpec> getPluginSpecs() {
        if (pluginSpecs == null) {
            pluginSpecs = new ArrayList<WsTransformerPluginSpec>();
        }
        return this.pluginSpecs;
    }

}
