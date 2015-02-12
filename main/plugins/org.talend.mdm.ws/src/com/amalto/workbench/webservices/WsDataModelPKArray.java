
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsDataModelPKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsDataModelPKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsDataModelPKs" type="{http://www.talend.com/mdm}wsDataModelPK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsDataModelPKArray", propOrder = {
    "wsDataModelPKs"
})
public class WsDataModelPKArray {

    @XmlElement(nillable = true)
    protected List<WsDataModelPK> wsDataModelPKs;

    /**
     * Default no-arg constructor
     * 
     */
    public WsDataModelPKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsDataModelPKArray(final List<WsDataModelPK> wsDataModelPKs) {
        this.wsDataModelPKs = wsDataModelPKs;
    }

    /**
     * Gets the value of the wsDataModelPKs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsDataModelPKs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsDataModelPKs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsDataModelPK }
     * 
     * 
     */
    public List<WsDataModelPK> getWsDataModelPKs() {
        if (wsDataModelPKs == null) {
            wsDataModelPKs = new ArrayList<WsDataModelPK>();
        }
        return this.wsDataModelPKs;
    }

}
