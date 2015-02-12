
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsWhereAnd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsWhereAnd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="whereItems" type="{http://www.talend.com/mdm}wsWhereItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsWhereAnd", propOrder = {
    "whereItems"
})
public class WsWhereAnd {

    @XmlElement(nillable = true)
    protected List<WsWhereItem> whereItems;

    /**
     * Default no-arg constructor
     * 
     */
    public WsWhereAnd() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsWhereAnd(final List<WsWhereItem> whereItems) {
        this.whereItems = whereItems;
    }

    /**
     * Gets the value of the whereItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the whereItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWhereItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsWhereItem }
     * 
     * 
     */
    public List<WsWhereItem> getWhereItems() {
        if (whereItems == null) {
            whereItems = new ArrayList<WsWhereItem>();
        }
        return this.whereItems;
    }

}
