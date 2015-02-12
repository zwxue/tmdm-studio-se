
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsTransformerPKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsTransformerPKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsTransformerPK" type="{http://www.talend.com/mdm}wsTransformerPK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsTransformerPKArray", propOrder = {
    "wsTransformerPK"
})
public class WsTransformerPKArray {

    @XmlElement(nillable = true)
    protected List<WsTransformerPK> wsTransformerPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsTransformerPKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsTransformerPKArray(final List<WsTransformerPK> wsTransformerPK) {
        this.wsTransformerPK = wsTransformerPK;
    }

    /**
     * Gets the value of the wsTransformerPK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsTransformerPK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsTransformerPK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsTransformerPK }
     * 
     * 
     */
    public List<WsTransformerPK> getWsTransformerPK() {
        if (wsTransformerPK == null) {
            wsTransformerPK = new ArrayList<WsTransformerPK>();
        }
        return this.wsTransformerPK;
    }

}
