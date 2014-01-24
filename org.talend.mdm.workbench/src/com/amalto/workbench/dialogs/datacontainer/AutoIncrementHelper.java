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
package com.amalto.workbench.dialogs.datacontainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.workbench.utils.Util;

public class AutoIncrementHelper {

    private static final String TAG_KEY = "key"; //$NON-NLS-1$

    private static final String TAG_VALUE = "value"; //$NON-NLS-1$

    private static final String TAG_ENTRY = "entry"; //$NON-NLS-1$

    private static final String DEFAULT_VALUE = "0"; //$NON-NLS-1$

    public static Map<String, String> getCurrentValue(String autoIncrementRecordContent, Map<String, String> entityToKeys) throws Exception {
        if (autoIncrementRecordContent == null || autoIncrementRecordContent.trim().isEmpty() || entityToKeys == null || entityToKeys.isEmpty()) {
            return null;
        }

        Map<String, String> keyToEntities = new HashMap<String, String>();
        Iterator<String> iterator = entityToKeys.keySet().iterator();
        while (iterator.hasNext()) {
            String entity = iterator.next();
            keyToEntities.put(entityToKeys.get(entity), entity);
        }

        Map<String, String> entityValues = new HashMap<String, String>();
        Document doc = Util.parse(autoIncrementRecordContent);

        NodeList nodeLists = doc.getElementsByTagName(TAG_KEY);
        for (int i = 0; i < nodeLists.getLength(); i++) {
            Node item = nodeLists.item(i);
            String keyContent = item.getTextContent();

            if (keyToEntities.keySet().contains(keyContent)) {
                NodeList nodeList = item.getParentNode().getChildNodes();
                for (int j = 0; j < nodeList.getLength(); j++) {
                    Node item2 = nodeList.item(j);
                    if (item2.getNodeName().equals(TAG_VALUE)) {
                        String valueContent = item2.getTextContent();
                        entityValues.put(keyToEntities.get(keyContent), valueContent);
                        break;
                    }
                }
            }
        }

        iterator = entityToKeys.keySet().iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            if(!entityValues.containsKey(next)) {
                entityValues.put(next, DEFAULT_VALUE);
            }
        }


        return entityValues;
    }

    public static String updateValue(String xml, Map<String, String> keyvalues) throws Exception {
        Document doc = Util.parse(xml);

        List<String> allKeys = new LinkedList<String>();
        NodeList nodeLists = doc.getElementsByTagName(TAG_KEY);
        for (int i = 0; i < nodeLists.getLength(); i++) {
            Node item = nodeLists.item(i);
            String keyContent = item.getTextContent();
            allKeys.add(keyContent);
        }

        List<String> removeKeys = new LinkedList<String>();// need remove
        Iterator<String> iterator = keyvalues.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (keyvalues.get(key).equals(DEFAULT_VALUE)) {
                removeKeys.add(key);
                iterator.remove();
            }
        }

        List<String> addKeys = new ArrayList<String>(keyvalues.keySet());// need add
        addKeys.removeAll(allKeys);

        List<String> updateKeys = new ArrayList<String>(keyvalues.keySet());
        updateKeys.retainAll(allKeys);

        for (int i = 0; i < nodeLists.getLength(); i++) {
            Node item = nodeLists.item(i);
            String keyContent = item.getTextContent();

            if (removeKeys.contains(keyContent)) {
                Node parentNode = item.getParentNode();
                parentNode.getParentNode().removeChild(parentNode);
            } else if (updateKeys.contains(keyContent)) {
                NodeList nodeList = item.getParentNode().getChildNodes();
                for (int j = 0; j < nodeList.getLength(); j++) {
                    Node item2 = nodeList.item(j);
                    if (item2.getNodeName().equals(TAG_VALUE)) {
                        item2.setTextContent(keyvalues.get(keyContent));
                    }
                }
            }
        }

        if (!addKeys.isEmpty()) {
            for (String key : addKeys) {
                addNode(doc, key, keyvalues.get(key));
            }
        }

        return Util.nodeToString(doc);
    }

    private static void addNode(Document doc, String key, String value) {
        Element parentNode = doc.getDocumentElement();

        Element entryElement = doc.createElement(TAG_ENTRY);

        Element keyElement = doc.createElement(TAG_KEY);
        keyElement.appendChild(doc.createTextNode(key));

        Element valueElement = doc.createElement(TAG_VALUE);
        valueElement.appendChild(doc.createTextNode(value));

        entryElement.appendChild(keyElement);
        entryElement.appendChild(valueElement);

        parentNode.appendChild(entryElement);
    }
}
