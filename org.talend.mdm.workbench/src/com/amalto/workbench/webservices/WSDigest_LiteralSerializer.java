// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.webservices;

import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.ui.internal.handlers.WizardHandler.New;

import com.sun.org.apache.bcel.internal.generic.NEW;
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
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;


/**
 * created by yjli on 2013-8-22
 * Detailled comment
 *
 */
public class WSDigest_LiteralSerializer extends LiteralObjectSerializerBase implements Initializable {
    private static final QName ns1_wsDigestKey_QNAME  = new QName("","wsDigestKey");
    private static final QName ns1_WSDigestKey_TYPE_QNAME = new QName("urn-com-amalto-xtentis-webservice", "WSDigestKey");
    private CombinedSerializer ns1_myWSDigestKey_LiteralSerializer;
    private static final QName ns1_digestValue_QNAME = new QName("", "digestValue");
    private static final QName ns1_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
    private CombinedSerializer ns1_myns1_string__java_lang_String_String_Serializer;
    private static final QName ns1_timeStamp_QNAME = new QName("", "timeStamp");    
    private static final QName ns1_long_TYPE_QNAME = SchemaConstants.QNAME_TYPE_LONG;
    private CombinedSerializer ns1_myns1__long__long_Long_Serializer;
    
    
    public WSDigest_LiteralSerializer(QName type, String encodingStyle) {
        this(type, encodingStyle, false);
    }
    
    public WSDigest_LiteralSerializer(QName type, String encodingStyle, boolean encodeType) {
        super(type, true, encodingStyle, encodeType);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws Exception {
        ns1_myWSDigestKey_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", com.amalto.workbench.webservices.WSDigestKey.class, ns1_WSDigestKey_TYPE_QNAME);
        ns1_myns1_string__java_lang_String_String_Serializer = (CombinedSerializer)registry.getSerializer("", java.lang.String.class, ns1_string_TYPE_QNAME);
        ns1_myns1__long__long_Long_Serializer = (CombinedSerializer)registry.getSerializer("", java.lang.Long.class, ns1_long_TYPE_QNAME);
    }
    
    public Object doDeserialize(XMLReader reader,
        SOAPDeserializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSDigest instance = new com.amalto.workbench.webservices.WSDigest();
        Object member=null;
        QName elementName;
        
        reader.nextElementContent();
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_wsDigestKey_QNAME)) {
                member = ns1_myWSDigestKey_LiteralSerializer.deserialize(ns1_wsDigestKey_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setWsDigestKey((com.amalto.workbench.webservices.WSDigestKey)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_wsDigestKey_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        reader.nextElementContent();
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_digestValue_QNAME)) {
                member = ns1_myns1_string__java_lang_String_String_Serializer.deserialize(ns1_digestValue_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setDigestValue((java.lang.String)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_digestValue_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        reader.nextElementContent();
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_timeStamp_QNAME)) {
                member = ns1_myns1__long__long_Long_Serializer.deserialize(ns1_timeStamp_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setTimeStamp(((java.lang.Long)member).longValue());
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_timeStamp_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (Object)instance;
    }
    
    public void doSerializeAttributes(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSDigest instance = (com.amalto.workbench.webservices.WSDigest)obj;
        
    }
    public void doSerialize(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSDigest instance = (com.amalto.workbench.webservices.WSDigest)obj;
        
        if (instance.getWsDigestKey() == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns1_myWSDigestKey_LiteralSerializer.serialize(instance.wsDigestKey, ns1_wsDigestKey_QNAME, null, writer, context);
        
        if (instance.getDigestValue() == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns1_myns1_string__java_lang_String_String_Serializer.serialize(instance.digestValue, ns1_digestValue_QNAME, null, writer, context);

        ns1_myns1__long__long_Long_Serializer.serialize(instance.timeStamp, ns1_timeStamp_QNAME, null, writer, context);
    }
}
