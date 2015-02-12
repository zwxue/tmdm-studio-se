
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsRoleSpecification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsRoleSpecification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="admin" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="instance" type="{http://www.talend.com/mdm}wsRoleSpecificationInstance" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsRoleSpecification", propOrder = {
    "admin",
    "instance",
    "objectType"
})
public class WsRoleSpecification {

    protected boolean admin;
    @XmlElement(nillable = true)
    protected List<WsRoleSpecificationInstance> instance;
    protected String objectType;

    /**
     * Default no-arg constructor
     * 
     */
    public WsRoleSpecification() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WsRoleSpecification(final boolean admin, final List<WsRoleSpecificationInstance> instance, final String objectType) {
        this.admin = admin;
        this.instance = instance;
        this.objectType = objectType;
    }

    /**
     * Gets the value of the admin property.
     * 
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Sets the value of the admin property.
     * 
     */
    public void setAdmin(boolean value) {
        this.admin = value;
    }

    /**
     * Gets the value of the instance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsRoleSpecificationInstance }
     * 
     * 
     */
    public List<WsRoleSpecificationInstance> getInstance() {
        if (instance == null) {
            instance = new ArrayList<WsRoleSpecificationInstance>();
        }
        return this.instance;
    }

    /**
     * Gets the value of the objectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * Sets the value of the objectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectType(String value) {
        this.objectType = value;
    }

}
