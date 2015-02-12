
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsTransformerContextPipeline complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsTransformerContextPipeline">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pipelineItem" type="{http://www.talend.com/mdm}wsTransformerContextPipelinePipelineItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsTransformerContextPipeline", propOrder = {
    "pipelineItem"
})
public class WsTransformerContextPipeline {

    @XmlElement(nillable = true)
    protected List<WsTransformerContextPipelinePipelineItem> pipelineItem;

    /**
     * Default no-arg constructor
     * 
     */
    public WsTransformerContextPipeline() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsTransformerContextPipeline(final List<WsTransformerContextPipelinePipelineItem> pipelineItem) {
        this.pipelineItem = pipelineItem;
    }

    /**
     * Gets the value of the pipelineItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pipelineItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPipelineItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsTransformerContextPipelinePipelineItem }
     * 
     * 
     */
    public List<WsTransformerContextPipelinePipelineItem> getPipelineItem() {
        if (pipelineItem == null) {
            pipelineItem = new ArrayList<WsTransformerContextPipelinePipelineItem>();
        }
        return this.pipelineItem;
    }

}
