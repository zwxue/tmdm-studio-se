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
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;

public class WSExtractUsingTransformerThruView_LiteralSerializer extends LiteralObjectSerializerBase implements Initializable  {
    private static final QName ns1_wsDataClusterPK_QNAME = new QName("", "wsDataClusterPK");
    private static final QName ns2_WSDataClusterPK_TYPE_QNAME = new QName("urn-com-amalto-xtentis-webservice", "WSDataClusterPK");
    private CombinedSerializer ns2_myWSDataClusterPK_LiteralSerializer;
    private static final QName ns1_wsTransformerPK_QNAME = new QName("", "wsTransformerPK");
    private static final QName ns2_WSTransformerPK_TYPE_QNAME = new QName("urn-com-amalto-xtentis-webservice", "WSTransformerPK");
    private CombinedSerializer ns2_myWSTransformerPK_LiteralSerializer;
    private static final QName ns1_wsViewPK_QNAME = new QName("", "wsViewPK");
    private static final QName ns2_WSViewPK_TYPE_QNAME = new QName("urn-com-amalto-xtentis-webservice", "WSViewPK");
    private CombinedSerializer ns2_myWSViewPK_LiteralSerializer;
    private static final QName ns1_whereItem_QNAME = new QName("", "whereItem");
    private static final QName ns2_WSWhereItem_TYPE_QNAME = new QName("urn-com-amalto-xtentis-webservice", "WSWhereItem");
    private CombinedSerializer ns2_myWSWhereItem_LiteralSerializer;
    private static final QName ns1_spellTreshold_QNAME = new QName("", "spellTreshold");
    private static final QName ns3_int_TYPE_QNAME = SchemaConstants.QNAME_TYPE_INT;
    private CombinedSerializer ns3_myns3__int__int_Int_Serializer;
    private static final QName ns1_skip_QNAME = new QName("", "skip");
    private static final QName ns1_maxItems_QNAME = new QName("", "maxItems");
    private static final QName ns1_orderBy_QNAME = new QName("", "orderBy");
    private static final QName ns3_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
    private CombinedSerializer ns3_myns3_string__java_lang_String_String_Serializer;
    private static final QName ns1_direction_QNAME = new QName("", "direction");
    
    public WSExtractUsingTransformerThruView_LiteralSerializer(QName type, String encodingStyle) {
        this(type, encodingStyle, false);
    }
    
    public WSExtractUsingTransformerThruView_LiteralSerializer(QName type, String encodingStyle, boolean encodeType) {
        super(type, true, encodingStyle, encodeType);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws Exception {
        ns2_myWSDataClusterPK_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", com.amalto.workbench.webservices.WSDataClusterPK.class, ns2_WSDataClusterPK_TYPE_QNAME);
        ns2_myWSTransformerPK_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", com.amalto.workbench.webservices.WSTransformerPK.class, ns2_WSTransformerPK_TYPE_QNAME);
        ns2_myWSViewPK_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", com.amalto.workbench.webservices.WSViewPK.class, ns2_WSViewPK_TYPE_QNAME);
        ns2_myWSWhereItem_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", com.amalto.workbench.webservices.WSWhereItem.class, ns2_WSWhereItem_TYPE_QNAME);
        ns3_myns3__int__int_Int_Serializer = (CombinedSerializer)registry.getSerializer("", int.class, ns3_int_TYPE_QNAME);
        ns3_myns3_string__java_lang_String_String_Serializer = (CombinedSerializer)registry.getSerializer("", java.lang.String.class, ns3_string_TYPE_QNAME);
    }
    
    public Object doDeserialize(XMLReader reader,
        SOAPDeserializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSExtractUsingTransformerThruView instance = new com.amalto.workbench.webservices.WSExtractUsingTransformerThruView();
        Object member=null;
        QName elementName;
        List values;
        Object value;
        
        reader.nextElementContent();
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_wsDataClusterPK_QNAME)) {
                member = ns2_myWSDataClusterPK_LiteralSerializer.deserialize(ns1_wsDataClusterPK_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setWsDataClusterPK((com.amalto.workbench.webservices.WSDataClusterPK)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_wsDataClusterPK_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_wsTransformerPK_QNAME)) {
                member = ns2_myWSTransformerPK_LiteralSerializer.deserialize(ns1_wsTransformerPK_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setWsTransformerPK((com.amalto.workbench.webservices.WSTransformerPK)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_wsTransformerPK_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_wsViewPK_QNAME)) {
                member = ns2_myWSViewPK_LiteralSerializer.deserialize(ns1_wsViewPK_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setWsViewPK((com.amalto.workbench.webservices.WSViewPK)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_wsViewPK_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_whereItem_QNAME)) {
                member = ns2_myWSWhereItem_LiteralSerializer.deserialize(ns1_whereItem_QNAME, reader, context);
                instance.setWhereItem((com.amalto.workbench.webservices.WSWhereItem)member);
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_whereItem_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_spellTreshold_QNAME)) {
                member = ns3_myns3__int__int_Int_Serializer.deserialize(ns1_spellTreshold_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setSpellTreshold(((Integer)member).intValue());
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_spellTreshold_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_skip_QNAME)) {
                member = ns3_myns3__int__int_Int_Serializer.deserialize(ns1_skip_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setSkip(((Integer)member).intValue());
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_skip_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_maxItems_QNAME)) {
                member = ns3_myns3__int__int_Int_Serializer.deserialize(ns1_maxItems_QNAME, reader, context);
                if (member == null) {
                    throw new DeserializationException("literal.unexpectedNull");
                }
                instance.setMaxItems(((Integer)member).intValue());
                reader.nextElementContent();
            } else {
                throw new DeserializationException("literal.unexpectedElementName", new Object[] { ns1_maxItems_QNAME, reader.getName() });
            }
        }
        else {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_orderBy_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_orderBy_QNAME, reader, context);
                instance.setOrderBy((java.lang.String)member);
                reader.nextElementContent();
            }
        }
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_direction_QNAME)) {
                member = ns3_myns3_string__java_lang_String_String_Serializer.deserialize(ns1_direction_QNAME, reader, context);
                instance.setDirection((java.lang.String)member);
                reader.nextElementContent();
            }
        }
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (Object)instance;
    }
    
    public void doSerializeAttributes(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSExtractUsingTransformerThruView instance = (com.amalto.workbench.webservices.WSExtractUsingTransformerThruView)obj;
        
    }
    public void doSerialize(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSExtractUsingTransformerThruView instance = (com.amalto.workbench.webservices.WSExtractUsingTransformerThruView)obj;
        
        if (instance.getWsDataClusterPK() == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns2_myWSDataClusterPK_LiteralSerializer.serialize(instance.getWsDataClusterPK(), ns1_wsDataClusterPK_QNAME, null, writer, context);
        if (instance.getWsTransformerPK() == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns2_myWSTransformerPK_LiteralSerializer.serialize(instance.getWsTransformerPK(), ns1_wsTransformerPK_QNAME, null, writer, context);
        if (instance.getWsViewPK() == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns2_myWSViewPK_LiteralSerializer.serialize(instance.getWsViewPK(), ns1_wsViewPK_QNAME, null, writer, context);
        ns2_myWSWhereItem_LiteralSerializer.serialize(instance.getWhereItem(), ns1_whereItem_QNAME, null, writer, context);
        if (new Integer(instance.getSpellTreshold()) == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns3_myns3__int__int_Int_Serializer.serialize(new Integer(instance.getSpellTreshold()), ns1_spellTreshold_QNAME, null, writer, context);
        if (new Integer(instance.getSkip()) == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns3_myns3__int__int_Int_Serializer.serialize(new Integer(instance.getSkip()), ns1_skip_QNAME, null, writer, context);
        if (new Integer(instance.getMaxItems()) == null) {
            throw new SerializationException("literal.unexpectedNull");
        }
        ns3_myns3__int__int_Int_Serializer.serialize(new Integer(instance.getMaxItems()), ns1_maxItems_QNAME, null, writer, context);
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getOrderBy(), ns1_orderBy_QNAME, null, writer, context);
        ns3_myns3_string__java_lang_String_String_Serializer.serialize(instance.getDirection(), ns1_direction_QNAME, null, writer, context);
    }
}