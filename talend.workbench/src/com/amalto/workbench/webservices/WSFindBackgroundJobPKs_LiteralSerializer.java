// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation ��1.1.2_01������� R40��
// Generated source version: 1.1.2

package com.amalto.workbench.webservices;

import java.util.List;

import javax.xml.namespace.QName;

import com.sun.xml.rpc.encoding.CombinedSerializer;
import com.sun.xml.rpc.encoding.DeserializationException;
import com.sun.xml.rpc.encoding.Initializable;
import com.sun.xml.rpc.encoding.InternalTypeMappingRegistry;
import com.sun.xml.rpc.encoding.SOAPDeserializationContext;
import com.sun.xml.rpc.encoding.SOAPSerializationContext;
import com.sun.xml.rpc.encoding.SerializationException;
import com.sun.xml.rpc.encoding.literal.LiteralObjectSerializerBase;
import com.sun.xml.rpc.streaming.XMLReader;
import com.sun.xml.rpc.streaming.XMLReaderUtil;
import com.sun.xml.rpc.streaming.XMLWriter;

public class WSFindBackgroundJobPKs_LiteralSerializer extends LiteralObjectSerializerBase implements Initializable  {
    private static final QName ns1_status_QNAME = new QName("", "status");
    private static final QName ns2_BackgroundJobStatusType_TYPE_QNAME = new QName("urn-com-amalto-xtentis-webservice", "BackgroundJobStatusType");
    private CombinedSerializer ns2myns2_BackgroundJobStatusType__BackgroundJobStatusType_LiteralSerializer;
    
    public WSFindBackgroundJobPKs_LiteralSerializer(QName type, String encodingStyle) {
        this(type, encodingStyle, false);
    }
    
    public WSFindBackgroundJobPKs_LiteralSerializer(QName type, String encodingStyle, boolean encodeType) {
        super(type, true, encodingStyle, encodeType);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws Exception {
        ns2myns2_BackgroundJobStatusType__BackgroundJobStatusType_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", com.amalto.workbench.webservices.BackgroundJobStatusType.class, ns2_BackgroundJobStatusType_TYPE_QNAME);
    }
    
    public Object doDeserialize(XMLReader reader,
        SOAPDeserializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSFindBackgroundJobPKs instance = new com.amalto.workbench.webservices.WSFindBackgroundJobPKs();
        Object member=null;
        QName elementName;
        List values;
        Object value;
        
        reader.nextElementContent();
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_status_QNAME)) {
                member = ns2myns2_BackgroundJobStatusType__BackgroundJobStatusType_LiteralSerializer.deserialize(ns1_status_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setStatus((com.amalto.workbench.webservices.BackgroundJobStatusType)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_status_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (Object)instance;
    }
    
    public void doSerializeAttributes(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSFindBackgroundJobPKs instance = (com.amalto.workbench.webservices.WSFindBackgroundJobPKs)obj;
        
    }
    public void doSerialize(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSFindBackgroundJobPKs instance = (com.amalto.workbench.webservices.WSFindBackgroundJobPKs)obj;
        
        if (instance.getStatus() == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns2myns2_BackgroundJobStatusType__BackgroundJobStatusType_LiteralSerializer.serialize(instance.getStatus(), ns1_status_QNAME, null, writer, context);
    }
}
