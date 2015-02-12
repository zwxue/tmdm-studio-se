
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsDataClusterPKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsDataClusterPKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsDataClusterPKs" type="{http://www.talend.com/mdm}wsDataClusterPK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsDataClusterPKArray", propOrder = {
    "wsDataClusterPKs"
})
public class WsDataClusterPKArray {

    @XmlElement(nillable = true)
    protected List<WsDataClusterPK> wsDataClusterPKs;

    /**
     * Default no-arg constructor
     * 
     */
    public WsDataClusterPKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsDataClusterPKArray(final List<WsDataClusterPK> wsDataClusterPKs) {
        this.wsDataClusterPKs = wsDataClusterPKs;
    }

    /**
     * Gets the value of the wsDataClusterPKs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsDataClusterPKs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsDataClusterPKs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsDataClusterPK }
     * 
     * 
     */
    public List<WsDataClusterPK> getWsDataClusterPKs() {
        if (wsDataClusterPKs == null) {
            wsDataClusterPKs = new ArrayList<WsDataClusterPK>();
        }
        return this.wsDataClusterPKs;
    }

}
