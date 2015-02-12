
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteDataCluster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteDataCluster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.talend.com/mdm}wsDeleteDataCluster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteDataCluster", propOrder = {
    "arg0"
})
public class DeleteDataCluster {

    protected WsDeleteDataCluster arg0;

    /**
     * Default no-arg constructor
     * 
     */
    public DeleteDataCluster() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public DeleteDataCluster(final WsDeleteDataCluster arg0) {
        this.arg0 = arg0;
    }

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link WsDeleteDataCluster }
     *     
     */
    public WsDeleteDataCluster getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsDeleteDataCluster }
     *     
     */
    public void setArg0(WsDeleteDataCluster value) {
        this.arg0 = value;
    }

}
