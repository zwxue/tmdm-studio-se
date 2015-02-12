
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsViewPKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsViewPKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsViewPK" type="{http://www.talend.com/mdm}wsViewPK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsViewPKArray", propOrder = {
    "wsViewPK"
})
public class WsViewPKArray {

    @XmlElement(nillable = true)
    protected List<WsViewPK> wsViewPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsViewPKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsViewPKArray(final List<WsViewPK> wsViewPK) {
        this.wsViewPK = wsViewPK;
    }

    /**
     * Gets the value of the wsViewPK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsViewPK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsViewPK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsViewPK }
     * 
     * 
     */
    public List<WsViewPK> getWsViewPK() {
        if (wsViewPK == null) {
            wsViewPK = new ArrayList<WsViewPK>();
        }
        return this.wsViewPK;
    }

}
