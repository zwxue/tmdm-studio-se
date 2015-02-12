
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsMenuPKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsMenuPKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsMenuPK" type="{http://www.talend.com/mdm}wsMenuPK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsMenuPKArray", propOrder = {
    "wsMenuPK"
})
public class WsMenuPKArray {

    @XmlElement(nillable = true)
    protected List<WsMenuPK> wsMenuPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsMenuPKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsMenuPKArray(final List<WsMenuPK> wsMenuPK) {
        this.wsMenuPK = wsMenuPK;
    }

    /**
     * Gets the value of the wsMenuPK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsMenuPK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsMenuPK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsMenuPK }
     * 
     * 
     */
    public List<WsMenuPK> getWsMenuPK() {
        if (wsMenuPK == null) {
            wsMenuPK = new ArrayList<WsMenuPK>();
        }
        return this.wsMenuPK;
    }

}
