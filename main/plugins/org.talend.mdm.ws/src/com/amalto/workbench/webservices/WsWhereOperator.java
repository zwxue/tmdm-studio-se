
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsWhereOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wsWhereOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="JOIN"/>
 *     &lt;enumeration value="CONTAINS_TEXT_OF"/>
 *     &lt;enumeration value="CONTAINS"/>
 *     &lt;enumeration value="STARTSWITH"/>
 *     &lt;enumeration value="STRICTCONTAINS"/>
 *     &lt;enumeration value="EQUALS"/>
 *     &lt;enumeration value="NOT_EQUALS"/>
 *     &lt;enumeration value="GREATER_THAN"/>
 *     &lt;enumeration value="GREATER_THAN_OR_EQUAL"/>
 *     &lt;enumeration value="LOWER_THAN"/>
 *     &lt;enumeration value="LOWER_THAN_OR_EQUAL"/>
 *     &lt;enumeration value="NO_OPERATOR"/>
 *     &lt;enumeration value="FULLTEXTSEARCH"/>
 *     &lt;enumeration value="EMPTY_NULL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wsWhereOperator")
@XmlEnum
public enum WsWhereOperator {

    JOIN,
    CONTAINS_TEXT_OF,
    CONTAINS,
    STARTSWITH,
    STRICTCONTAINS,
    EQUALS,
    NOT_EQUALS,
    GREATER_THAN,
    GREATER_THAN_OR_EQUAL,
    LOWER_THAN,
    LOWER_THAN_OR_EQUAL,
    NO_OPERATOR,
    FULLTEXTSEARCH,
    EMPTY_NULL;

    public String value() {
        return name();
    }

    public static WsWhereOperator fromValue(String v) {
        return valueOf(v);
    }

}
