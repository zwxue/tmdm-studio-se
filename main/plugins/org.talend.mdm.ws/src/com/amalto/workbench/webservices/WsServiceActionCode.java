
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsServiceActionCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wsServiceActionCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="START"/>
 *     &lt;enumeration value="STOP"/>
 *     &lt;enumeration value="STATUS"/>
 *     &lt;enumeration value="EXECUTE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wsServiceActionCode")
@XmlEnum
public enum WsServiceActionCode {

    START,
    STOP,
    STATUS,
    EXECUTE;

    public String value() {
        return name();
    }

    public static WsServiceActionCode fromValue(String v) {
        return valueOf(v);
    }

}
