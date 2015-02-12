
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsItemPKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsItemPKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsItemPK" type="{http://www.talend.com/mdm}wsItemPK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsItemPKArray", propOrder = {
    "wsItemPK"
})
public class WsItemPKArray {

    @XmlElement(nillable = true)
    protected List<WsItemPK> wsItemPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsItemPKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsItemPKArray(final List<WsItemPK> wsItemPK) {
        this.wsItemPK = wsItemPK;
    }

    /**
     * Gets the value of the wsItemPK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsItemPK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsItemPK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsItemPK }
     * 
     * 
     */
    public List<WsItemPK> getWsItemPK() {
        if (wsItemPK == null) {
            wsItemPK = new ArrayList<WsItemPK>();
        }
        return this.wsItemPK;
    }

}
