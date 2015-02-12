
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsExecuteStoredProcedure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsExecuteStoredProcedure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parameters" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wsDataClusterPK" type="{http://www.talend.com/mdm}wsDataClusterPK" minOccurs="0"/>
 *         &lt;element name="wsStoredProcedurePK" type="{http://www.talend.com/mdm}wsStoredProcedurePK" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsExecuteStoredProcedure", propOrder = {
    "parameters",
    "wsDataClusterPK",
    "wsStoredProcedurePK"
})
public class WsExecuteStoredProcedure {

    @XmlElement(nillable = true)
    protected List<String> parameters;
    protected WsDataClusterPK wsDataClusterPK;
    protected WsStoredProcedurePK wsStoredProcedurePK;

    /**
     * Default no-arg constructor
     * 
     */
    public WsExecuteStoredProcedure() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsExecuteStoredProcedure(final List<String> parameters, final WsDataClusterPK wsDataClusterPK, final WsStoredProcedurePK wsStoredProcedurePK) {
        this.parameters = parameters;
        this.wsDataClusterPK = wsDataClusterPK;
        this.wsStoredProcedurePK = wsStoredProcedurePK;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<String>();
        }
        return this.parameters;
    }

    /**
     * Gets the value of the wsDataClusterPK property.
     * 
     * @return
     *     possible object is
     *     {@link WsDataClusterPK }
     *     
     */
    public WsDataClusterPK getWsDataClusterPK() {
        return wsDataClusterPK;
    }

    /**
     * Sets the value of the wsDataClusterPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsDataClusterPK }
     *     
     */
    public void setWsDataClusterPK(WsDataClusterPK value) {
        this.wsDataClusterPK = value;
    }

    /**
     * Gets the value of the wsStoredProcedurePK property.
     * 
     * @return
     *     possible object is
     *     {@link WsStoredProcedurePK }
     *     
     */
    public WsStoredProcedurePK getWsStoredProcedurePK() {
        return wsStoredProcedurePK;
    }

    /**
     * Sets the value of the wsStoredProcedurePK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsStoredProcedurePK }
     *     
     */
    public void setWsStoredProcedurePK(WsStoredProcedurePK value) {
        this.wsStoredProcedurePK = value;
    }

}
