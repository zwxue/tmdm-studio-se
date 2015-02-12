
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsItemPKsByCriteriaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsItemPKsByCriteriaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="results" type="{http://www.talend.com/mdm}wsItemPKsByCriteriaResponseResults" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsItemPKsByCriteriaResponse", propOrder = {
    "results"
})
public class WsItemPKsByCriteriaResponse {

    @XmlElement(nillable = true)
    protected List<WsItemPKsByCriteriaResponseResults> results;

    /**
     * Default no-arg constructor
     * 
     */
    public WsItemPKsByCriteriaResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsItemPKsByCriteriaResponse(final List<WsItemPKsByCriteriaResponseResults> results) {
        this.results = results;
    }

    /**
     * Gets the value of the results property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the results property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsItemPKsByCriteriaResponseResults }
     * 
     * 
     */
    public List<WsItemPKsByCriteriaResponseResults> getResults() {
        if (results == null) {
            results = new ArrayList<WsItemPKsByCriteriaResponseResults>();
        }
        return this.results;
    }

}
