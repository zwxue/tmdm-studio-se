
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsRolePKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsRolePKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsRolePK" type="{http://www.talend.com/mdm}wsRolePK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsRolePKArray", propOrder = {
    "wsRolePK"
})
public class WsRolePKArray {

    @XmlElement(nillable = true)
    protected List<WsRolePK> wsRolePK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsRolePKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsRolePKArray(final List<WsRolePK> wsRolePK) {
        this.wsRolePK = wsRolePK;
    }

    /**
     * Gets the value of the wsRolePK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsRolePK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsRolePK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsRolePK }
     * 
     * 
     */
    public List<WsRolePK> getWsRolePK() {
        if (wsRolePK == null) {
            wsRolePK = new ArrayList<WsRolePK>();
        }
        return this.wsRolePK;
    }

}
