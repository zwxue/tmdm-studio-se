
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsDataClusterPK" type="{urn-com-amalto-xtentis-webservice}WSDataClusterPK"/>
 *         &lt;element name="dataModelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataModelRevision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="conceptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ids" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="insertionTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSItem", propOrder = {
    "wsDataClusterPK",
    "dataModelName",
    "dataModelRevision",
    "conceptName",
    "ids",
    "insertionTime",
    "taskId",
    "content"
})
public class WSItem {

    @XmlElement(required = true)
    protected WSDataClusterPK wsDataClusterPK;
    @XmlElement(required = true, nillable = true)
    protected String dataModelName;
    @XmlElement(required = true, nillable = true)
    protected String dataModelRevision;
    @XmlElement(required = true)
    protected String conceptName;
    @XmlElement(required = true)
    protected List<String> ids;
    protected long insertionTime;
    @XmlElement(nillable = true)
    protected String taskId;
    @XmlElement(required = true)
    protected String content;

    /**
     * Default no-arg constructor
     * 
     */
    public WSItem() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSItem(final WSDataClusterPK wsDataClusterPK, final String dataModelName, final String dataModelRevision, final String conceptName, final List<String> ids, final long insertionTime, final String taskId, final String content) {
        this.wsDataClusterPK = wsDataClusterPK;
        this.dataModelName = dataModelName;
        this.dataModelRevision = dataModelRevision;
        this.conceptName = conceptName;
        this.ids = ids;
        this.insertionTime = insertionTime;
        this.taskId = taskId;
        this.content = content;
    }

    /**
     * Gets the value of the wsDataClusterPK property.
     * 
     * @return
     *     possible object is
     *     {@link WSDataClusterPK }
     *     
     */
    public WSDataClusterPK getWsDataClusterPK() {
        return wsDataClusterPK;
    }

    /**
     * Sets the value of the wsDataClusterPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSDataClusterPK }
     *     
     */
    public void setWsDataClusterPK(WSDataClusterPK value) {
        this.wsDataClusterPK = value;
    }

    /**
     * Gets the value of the dataModelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataModelName() {
        return dataModelName;
    }

    /**
     * Sets the value of the dataModelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataModelName(String value) {
        this.dataModelName = value;
    }

    /**
     * Gets the value of the dataModelRevision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataModelRevision() {
        return dataModelRevision;
    }

    /**
     * Sets the value of the dataModelRevision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataModelRevision(String value) {
        this.dataModelRevision = value;
    }

    /**
     * Gets the value of the conceptName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConceptName() {
        return conceptName;
    }

    /**
     * Sets the value of the conceptName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConceptName(String value) {
        this.conceptName = value;
    }

    /**
     * Gets the value of the ids property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ids property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIds() {
        if (ids == null) {
            ids = new ArrayList<String>();
        }
        return this.ids;
    }

    /**
     * Gets the value of the insertionTime property.
     * 
     */
    public long getInsertionTime() {
        return insertionTime;
    }

    /**
     * Sets the value of the insertionTime property.
     * 
     */
    public void setInsertionTime(long value) {
        this.insertionTime = value;
    }

    /**
     * Gets the value of the taskId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Sets the value of the taskId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskId(String value) {
        this.taskId = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

}
