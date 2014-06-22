
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSUniversePKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSUniversePKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsUniversePK" type="{urn-com-amalto-xtentis-webservice}WSUniversePK" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSUniversePKArray", propOrder = {
    "wsUniversePK"
})
public class WSUniversePKArray {

    @XmlElement(required = true)
    protected List<WSUniversePK> wsUniversePK;

    /**
     * Default no-arg constructor
     * 
     */
    public WSUniversePKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSUniversePKArray(final List<WSUniversePK> wsUniversePK) {
        this.wsUniversePK = wsUniversePK;
    }

    /**
     * Gets the value of the wsUniversePK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsUniversePK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsUniversePK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSUniversePK }
     * 
     * 
     */
    public List<WSUniversePK> getWsUniversePK() {
        if (wsUniversePK == null) {
            wsUniversePK = new ArrayList<WSUniversePK>();
        }
        return this.wsUniversePK;
    }

}
