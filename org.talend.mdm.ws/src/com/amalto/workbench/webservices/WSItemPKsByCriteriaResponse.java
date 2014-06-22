
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				items returned based on criteria
 * 			
 * 
 * <p>Java class for WSItemPKsByCriteriaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSItemPKsByCriteriaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="results" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="wsItemPK" type="{urn-com-amalto-xtentis-webservice}WSItemPK"/>
 *                   &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSItemPKsByCriteriaResponse", propOrder = {
    "results"
})
public class WSItemPKsByCriteriaResponse {

    @XmlElement(required = true)
    protected List<WSItemPKsByCriteriaResponse.Results> results;

    /**
     * Default no-arg constructor
     * 
     */
    public WSItemPKsByCriteriaResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSItemPKsByCriteriaResponse(final List<WSItemPKsByCriteriaResponse.Results> results) {
        this.results = results;
    }

    /**
     * Gets the value of the results property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the results property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSItemPKsByCriteriaResponse.Results }
     * 
     * 
     */
    public List<WSItemPKsByCriteriaResponse.Results> getResults() {
        if (results == null) {
            results = new ArrayList<WSItemPKsByCriteriaResponse.Results>();
        }
        return this.results;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="wsItemPK" type="{urn-com-amalto-xtentis-webservice}WSItemPK"/>
     *         &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "date",
        "wsItemPK",
        "taskId"
    })
    public static class Results {

        protected long date;
        @XmlElement(required = true)
        protected WSItemPK wsItemPK;
        @XmlElement(nillable = true)
        protected String taskId;

        /**
         * Default no-arg constructor
         * 
         */
        public Results() {
            super();
        }

        /**
         * Fully-initialising value constructor
         * 
         */
        public Results(final long date, final WSItemPK wsItemPK, final String taskId) {
            this.date = date;
            this.wsItemPK = wsItemPK;
            this.taskId = taskId;
        }

        /**
         * Gets the value of the date property.
         * 
         */
        public long getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         * 
         */
        public void setDate(long value) {
            this.date = value;
        }

        /**
         * Gets the value of the wsItemPK property.
         * 
         * @return
         *     possible object is
         *     {@link WSItemPK }
         *     
         */
        public WSItemPK getWsItemPK() {
            return wsItemPK;
        }

        /**
         * Sets the value of the wsItemPK property.
         * 
         * @param value
         *     allowed object is
         *     {@link WSItemPK }
         *     
         */
        public void setWsItemPK(WSItemPK value) {
            this.wsItemPK = value;
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

    }

}
