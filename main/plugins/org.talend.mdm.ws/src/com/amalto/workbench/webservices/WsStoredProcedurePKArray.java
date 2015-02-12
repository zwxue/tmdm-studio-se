
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsStoredProcedurePKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsStoredProcedurePKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsStoredProcedurePK" type="{http://www.talend.com/mdm}wsStoredProcedurePK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsStoredProcedurePKArray", propOrder = {
    "wsStoredProcedurePK"
})
public class WsStoredProcedurePKArray {

    @XmlElement(nillable = true)
    protected List<WsStoredProcedurePK> wsStoredProcedurePK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsStoredProcedurePKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsStoredProcedurePKArray(final List<WsStoredProcedurePK> wsStoredProcedurePK) {
        this.wsStoredProcedurePK = wsStoredProcedurePK;
    }

    /**
     * Gets the value of the wsStoredProcedurePK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsStoredProcedurePK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsStoredProcedurePK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsStoredProcedurePK }
     * 
     * 
     */
    public List<WsStoredProcedurePK> getWsStoredProcedurePK() {
        if (wsStoredProcedurePK == null) {
            wsStoredProcedurePK = new ArrayList<WsStoredProcedurePK>();
        }
        return this.wsStoredProcedurePK;
    }

}
