/**
 * WSPutLicense.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package urn_com_amalto_xtentis_webservice;


/**
 * Creates - updates a data model
 */
public class WSPutLicense  implements java.io.Serializable {
    private urn_com_amalto_xtentis_webservice.WSLicense wsLicense;

    public WSPutLicense() {
    }

    public WSPutLicense(
           urn_com_amalto_xtentis_webservice.WSLicense wsLicense) {
           this.wsLicense = wsLicense;
    }


    /**
     * Gets the wsLicense value for this WSPutLicense.
     * 
     * @return wsLicense
     */
    public urn_com_amalto_xtentis_webservice.WSLicense getWsLicense() {
        return wsLicense;
    }


    /**
     * Sets the wsLicense value for this WSPutLicense.
     * 
     * @param wsLicense
     */
    public void setWsLicense(urn_com_amalto_xtentis_webservice.WSLicense wsLicense) {
        this.wsLicense = wsLicense;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSPutLicense)) return false;
        WSPutLicense other = (WSPutLicense) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.wsLicense==null && other.getWsLicense()==null) || 
             (this.wsLicense!=null &&
              this.wsLicense.equals(other.getWsLicense())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getWsLicense() != null) {
            _hashCode += getWsLicense().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSPutLicense.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSPutLicense"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wsLicense");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wsLicense"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSLicense"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
