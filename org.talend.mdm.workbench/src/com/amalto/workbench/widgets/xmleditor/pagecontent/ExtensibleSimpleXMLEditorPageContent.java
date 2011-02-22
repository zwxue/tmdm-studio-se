package com.amalto.workbench.widgets.xmleditor.pagecontent;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

public abstract class ExtensibleSimpleXMLEditorPageContent extends ExtensibleXMLEditorPageContent {

    private static Log log = LogFactory.getLog(ExtensibleSimpleXMLEditorPageContent.class);

    protected List<String> singleValuePropNames = new ArrayList<String>();

    protected List<String> multiValuesPropNames = new ArrayList<String>();

    protected List<String> allOrderedValuePropNames = new ArrayList<String>();

    protected Map<String, String> valuePropName2GetMethod = new HashMap<String, String>();

    protected Map<String, String> multiValuesPropName2Delimiter = new HashMap<String, String>();

    protected Map<String, Object> valuePropName2DefaultValue = new HashMap<String, Object>();

    public ExtensibleSimpleXMLEditorPageContent() {
        super();

        initSingleValuePropNames();
        initMultiValuePropNames();
        initAllOrderedValuePropNames();
        initValuePropName2GetMethod();
        initMultiValuesPropName2Delimiter();
        initValuePropName2DefaultValue();
    }

    @Override
    protected void fillXMLDoc(Node parent) {

        if (!(parent instanceof Document))
            return;

        Element rootElement = ((Document) parent).addElement(getRootElementName());

        for (String eachProp : allOrderedValuePropNames) {

            if (multiValuesPropNames.contains(eachProp))
                doAddMultiValuesElement(rootElement, eachProp);
            else
                doAddSingleValueElement(rootElement, eachProp);
        }

    }

    @Override
    protected void initByXMLExpression(Node parent) {

        if (!(parent instanceof Document))
            return;

        Map<String, Object> singleValuePropName2Value = new HashMap<String, Object>();
        Map<String, List<Object>> multiValuesPropName2Value = new HashMap<String, List<Object>>();

        for (String eachSingleValueProp : singleValuePropNames) {
            singleValuePropName2Value.put(
                    eachSingleValueProp,
                    getSingleValueFromXMLDoc((Document) parent, eachSingleValueProp, valuePropName2DefaultValue
                            .containsKey(eachSingleValueProp) ? valuePropName2DefaultValue.get(eachSingleValueProp) : "?"));
        }

        for (String eachMultiValuesProp : multiValuesPropNames) {
            multiValuesPropName2Value.put(
                    eachMultiValuesProp,
                    getValuesFromXMLDoc((Document) parent, eachMultiValuesProp, multiValuesPropName2Delimiter
                            .containsKey(eachMultiValuesProp) ? multiValuesPropName2Delimiter.get(eachMultiValuesProp) : ","));
        }

        initSingleValueFields(singleValuePropName2Value);

        initMultiValueFields(multiValuesPropName2Value);
    }

    protected String getDefaultValue() {
        return "?";
    }

    protected void doAddSingleValueElement(Element rootElement, String prop) {

        if (!valuePropName2GetMethod.containsKey(prop))
            return;

        String propValue = "";
        try {
            Method method = getClass().getMethod(valuePropName2GetMethod.get(prop));
            propValue = method.invoke(this).toString();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            rootElement.addElement(prop).setText("");
            return;
        }

        rootElement.addElement(prop).setText(propValue);
    }

    @SuppressWarnings("unchecked")
    protected void doAddMultiValuesElement(Element rootElement, String prop) {

        if (!valuePropName2GetMethod.containsKey(prop))
            return;

        List<String> propValues = new ArrayList<String>();

        try {
            Method method = getClass().getMethod(valuePropName2GetMethod.get(prop));
            propValues = (List<String>) method.invoke(this);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            rootElement.addElement(prop).setText("");
            return;
        }

        rootElement.addElement(prop).setText(
                getListContentExpression(propValues,
                        (multiValuesPropName2Delimiter.containsKey(prop)) ? multiValuesPropName2Delimiter.get(prop) : ","));

    }

    protected String getListContentExpression(List<String> values, String delimiter) {

        String result = "";

        for (String eachValue : values)
            result += (eachValue + delimiter);

        if (result.length() >= delimiter.length())
            result = result.substring(0, result.length() - delimiter.length());

        return result;
    }

    protected Object getSingleValueFromXMLDoc(Document xmlDoc, String valueName, Object valueForNull) {

        List<Object> results = getValuesFromXMLDoc(xmlDoc, valueName, null);

        if (results.isEmpty())
            return valueForNull;

        return results.get(0);

    }

    protected List<Object> getValuesFromXMLDoc(Document xmlDoc, String valueName, String delimiter) {

        List<Object> results = new ArrayList<Object>();

        List<?> nodes = xmlDoc.selectNodes("/" + getRootElementName() + "/" + valueName);

        if (nodes == null || nodes.isEmpty())
            return results;

        for (Object eachNode : nodes) {

            if (!(eachNode instanceof Node))
                continue;

            String nodeValue = ((Node) eachNode).getText();
            if (nodeValue == null || "".equals(nodeValue.trim()))
                continue;

            if (delimiter == null) {
                results.add(nodeValue);
                continue;
            }

            results.addAll(Arrays.asList(nodeValue.split(delimiter)));
        }

        return results;
    }

    protected void addSingleValueName(String name) {

        if (name == null || "".equals(name.trim()) || singleValuePropNames.contains(name))
            return;

        singleValuePropNames.add(name);
    }

    protected void addMultiValuesName(String name) {

        if (name == null || "".equals(name.trim()) || multiValuesPropNames.contains(name))
            return;

        multiValuesPropNames.add(name);
    }

    protected void addAllOrderedPropNames(String name) {

        if (name == null || "".equals(name.trim()) || allOrderedValuePropNames.contains(name))
            return;

        allOrderedValuePropNames.add(name);

    }

    protected void addValuePropName2GetMethod(String prop, String getMethod) {

        if (prop == null || "".equals(prop.trim()) || getMethod == null || "".equals(getMethod.trim()))
            return;

        valuePropName2GetMethod.put(prop, getMethod);
    }

    protected void addMultiValuesProp2Delimiter(String prop, String delimiter) {

        if (prop == null || "".equals(prop.trim()))
            return;

        multiValuesPropName2Delimiter.put(prop, delimiter == null ? "" : delimiter);
    }

    protected void addPropName2DefaultValue(String prop, Object defaultValue) {

        if (prop == null || "".equals(prop.trim()))
            return;

        valuePropName2DefaultValue.put(prop, defaultValue);
    }

    protected List<String> translateToStringList(List<Object> values) {

        List<String> results = new ArrayList<String>();

        for (Object eachObj : values) {

            if (!(eachObj instanceof String))
                continue;

            results.add((String) eachObj);
        }

        return results;
    }

    protected abstract void initSingleValuePropNames();

    protected abstract void initMultiValuePropNames();

    protected abstract void initAllOrderedValuePropNames();

    protected abstract void initValuePropName2GetMethod();

    protected abstract void initMultiValuesPropName2Delimiter();

    protected abstract void initValuePropName2DefaultValue();

    protected abstract void initSingleValueFields(Map<String, Object> singleValuePropName2Value);

    protected abstract void initMultiValueFields(Map<String, List<Object>> multiValuesPropName2Value);
}
