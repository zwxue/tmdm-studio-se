
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSCustomFormPKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSCustomFormPKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCustomFormPK" type="{urn-com-amalto-xtentis-webservice}WSCustomFormPK" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSCustomFormPKArray", propOrder = {
    "wsCustomFormPK"
})
public class WSCustomFormPKArray {

    @XmlElement(required = true)
    protected List<WSCustomFormPK> wsCustomFormPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WSCustomFormPKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSCustomFormPKArray(final List<WSCustomFormPK> wsCustomFormPK) {
        this.wsCustomFormPK = wsCustomFormPK;
    }

    /**
     * Gets the value of the wsCustomFormPK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsCustomFormPK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsCustomFormPK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSCustomFormPK }
     * 
     * 
     */
    public List<WSCustomFormPK> getWsCustomFormPK() {
        if (wsCustomFormPK == null) {
            wsCustomFormPK = new ArrayList<WSCustomFormPK>();
        }
        return this.wsCustomFormPK;
    }

}
