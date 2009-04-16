// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.2_01, construire R40)
// Generated source version: 1.1.2

package talend.core.transformer.plugin.v2.tiscall.webservices;

import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.encoding.xsd.XSDConstants;
import com.sun.xml.rpc.encoding.literal.*;
import com.sun.xml.rpc.encoding.literal.DetailFragmentDeserializer;
import com.sun.xml.rpc.encoding.simpletype.*;
import com.sun.xml.rpc.encoding.soap.SOAPConstants;
import com.sun.xml.rpc.encoding.soap.SOAP12Constants;
import com.sun.xml.rpc.streaming.*;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.ArrayList;

public class RunJobReturn_LiteralSerializer extends LiteralObjectSerializerBase implements Initializable  {
    private static final QName ns1_item_QNAME = new QName("http://talend.org", "item");
    private static final QName ns1_ArrayOf_xsd_string_TYPE_QNAME = new QName("http://talend.org", "ArrayOf_xsd_string");
    private CombinedSerializer ns1_myArrayOf_xsd_string_LiteralSerializer;
    
    public RunJobReturn_LiteralSerializer(QName type, String encodingStyle) {
        this(type, encodingStyle, false);
    }
    
    public RunJobReturn_LiteralSerializer(QName type, String encodingStyle, boolean encodeType) {
        super(type, true, encodingStyle, encodeType);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws Exception {
        ns1_myArrayOf_xsd_string_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", talend.core.transformer.plugin.v2.tiscall.webservices.ArrayOf_xsd_string.class, ns1_ArrayOf_xsd_string_TYPE_QNAME);
    }
    
    public Object doDeserialize(XMLReader reader,
        SOAPDeserializationContext context) throws Exception {
        talend.core.transformer.plugin.v2.tiscall.webservices.RunJobReturn instance = new talend.core.transformer.plugin.v2.tiscall.webservices.RunJobReturn();
        Object member=null;
        QName elementName;
        List values;
        Object value;
        
        reader.nextElementContent();
        elementName = reader.getName();
        if ((reader.getState() == XMLReader.START) && (elementName.equals(ns1_item_QNAME))) {
            values = new ArrayList();
            for(;;) {
                elementName = reader.getName();
                if ((reader.getState() == XMLReader.START) && (elementName.equals(ns1_item_QNAME))) {
                    value = ns1_myArrayOf_xsd_string_LiteralSerializer.deserialize(ns1_item_QNAME, reader, context);
                    if (value == null) {
                        throw new DeserializationException("literal.unexpectedNull");
                    }
                    values.add(value);
                    reader.nextElementContent();
                } else {
                    break;
                }
            }
            member = new talend.core.transformer.plugin.v2.tiscall.webservices.ArrayOf_xsd_string[values.size()];
            member = values.toArray((Object[]) member);
            instance.setItem((talend.core.transformer.plugin.v2.tiscall.webservices.ArrayOf_xsd_string[])member);
        }
        else {
            instance.setItem(new talend.core.transformer.plugin.v2.tiscall.webservices.ArrayOf_xsd_string[0]);
        }
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (Object)instance;
    }
    
    public void doSerializeAttributes(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        talend.core.transformer.plugin.v2.tiscall.webservices.RunJobReturn instance = (talend.core.transformer.plugin.v2.tiscall.webservices.RunJobReturn)obj;
        
    }
    public void doSerialize(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        talend.core.transformer.plugin.v2.tiscall.webservices.RunJobReturn instance = (talend.core.transformer.plugin.v2.tiscall.webservices.RunJobReturn)obj;
        
        if (instance.getItem() != null) {
            for (int i = 0; i < instance.getItem().length; ++i) {
                ns1_myArrayOf_xsd_string_LiteralSerializer.serialize(instance.getItem()[i], ns1_item_QNAME, null, writer, context);
            }
        }
    }
}
