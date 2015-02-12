
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsPipeline complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsPipeline">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="typedContentEntry" type="{http://www.talend.com/mdm}wsPipelineTypedContentEntry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsPipeline", propOrder = {
    "typedContentEntry"
})
public class WsPipeline {

    @XmlElement(nillable = true)
    protected List<WsPipelineTypedContentEntry> typedContentEntry;

    /**
     * Default no-arg constructor
     * 
     */
    public WsPipeline() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsPipeline(final List<WsPipelineTypedContentEntry> typedContentEntry) {
        this.typedContentEntry = typedContentEntry;
    }

    /**
     * Gets the value of the typedContentEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typedContentEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypedContentEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsPipelineTypedContentEntry }
     * 
     * 
     */
    public List<WsPipelineTypedContentEntry> getTypedContentEntry() {
        if (typedContentEntry == null) {
            typedContentEntry = new ArrayList<WsPipelineTypedContentEntry>();
        }
        return this.typedContentEntry;
    }

}
