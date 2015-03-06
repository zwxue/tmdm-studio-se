
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsComponent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wsComponent">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DataManager"/>
 *     &lt;enumeration value="Service"/>
 *     &lt;enumeration value="Connector"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wsComponent")
@XmlEnum
public enum WsComponent {

    @XmlEnumValue("DataManager")
    DATA_MANAGER("DataManager"),
    @XmlEnumValue("Service")
    SERVICE("Service"),
    @XmlEnumValue("Connector")
    CONNECTOR("Connector");
    private final String value;

    WsComponent(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WsComponent fromValue(String v) {
        for (WsComponent c: WsComponent.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
