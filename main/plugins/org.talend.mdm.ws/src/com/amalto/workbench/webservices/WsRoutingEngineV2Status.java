
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsRoutingEngineV2Status.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wsRoutingEngineV2Status">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DEAD"/>
 *     &lt;enumeration value="STOPPED"/>
 *     &lt;enumeration value="SUSPENDED"/>
 *     &lt;enumeration value="RUNNING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wsRoutingEngineV2Status")
@XmlEnum
public enum WsRoutingEngineV2Status {

    DEAD,
    STOPPED,
    SUSPENDED,
    RUNNING;

    public String value() {
        return name();
    }

    public static WsRoutingEngineV2Status fromValue(String v) {
        return valueOf(v);
    }

}
