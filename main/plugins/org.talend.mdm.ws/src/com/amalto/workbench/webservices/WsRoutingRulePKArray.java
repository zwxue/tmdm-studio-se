
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsRoutingRulePKArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsRoutingRulePKArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsRoutingRulePKs" type="{http://www.talend.com/mdm}wsRoutingRulePK" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsRoutingRulePKArray", propOrder = {
    "wsRoutingRulePKs"
})
public class WsRoutingRulePKArray {

    @XmlElement(nillable = true)
    protected List<WsRoutingRulePK> wsRoutingRulePKs;

    /**
     * Default no-arg constructor
     * 
     */
    public WsRoutingRulePKArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsRoutingRulePKArray(final List<WsRoutingRulePK> wsRoutingRulePKs) {
        this.wsRoutingRulePKs = wsRoutingRulePKs;
    }

    /**
     * Gets the value of the wsRoutingRulePKs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsRoutingRulePKs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsRoutingRulePKs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsRoutingRulePK }
     * 
     * 
     */
    public List<WsRoutingRulePK> getWsRoutingRulePKs() {
        if (wsRoutingRulePKs == null) {
            wsRoutingRulePKs = new ArrayList<WsRoutingRulePK>();
        }
        return this.wsRoutingRulePKs;
    }

}
