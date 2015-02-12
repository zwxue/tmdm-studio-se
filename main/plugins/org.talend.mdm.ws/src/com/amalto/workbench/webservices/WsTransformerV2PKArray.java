
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsTransformerV2PKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsTransformerV2PKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsTransformerV2PK" type="{http://www.talend.com/mdm}wsTransformerV2PK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsTransformerV2PKArray", propOrder = {
    "wsTransformerV2PK"
})
public class WsTransformerV2PKArray {

    @XmlElement(nillable = true)
    protected List<WsTransformerV2PK> wsTransformerV2PK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsTransformerV2PKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsTransformerV2PKArray(final List<WsTransformerV2PK> wsTransformerV2PK) {
        this.wsTransformerV2PK = wsTransformerV2PK;
    }

    /**
     * Gets the value of the wsTransformerV2PK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsTransformerV2PK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsTransformerV2PK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsTransformerV2PK }
     * 
     * 
     */
    public List<WsTransformerV2PK> getWsTransformerV2PK() {
        if (wsTransformerV2PK == null) {
            wsTransformerV2PK = new ArrayList<WsTransformerV2PK>();
        }
        return this.wsTransformerV2PK;
    }

}
