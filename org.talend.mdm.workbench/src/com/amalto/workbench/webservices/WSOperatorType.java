
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSOperatorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WSOperatorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="UPDATE"/>
 *     &lt;enumeration value="INSERT"/>
 *     &lt;enumeration value="DELETE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WSOperatorType")
@XmlEnum
public enum WSOperatorType {

    UPDATE,
    INSERT,
    DELETE;

    public String value() {
        return name();
    }

    public static WSOperatorType fromValue(String v) {
        return valueOf(v);
    }

}
