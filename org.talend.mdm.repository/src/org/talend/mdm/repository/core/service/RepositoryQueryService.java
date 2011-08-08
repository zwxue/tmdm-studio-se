// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSDataModelE;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.webservices.WSTransformerPluginV2SList;
import com.amalto.workbench.webservices.WSTransformerPluginV2SListItem;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryQueryService {

    private static Logger log = Logger.getLogger(RepositoryQueryService.class);

    public static List<String> findAllDataModelNames() {
        return findAllServerObjectNames(IServerObjectRepositoryType.TYPE_DATAMODEL);
    }

    public static WSDataModelE findDataModelByName(String name) {
        return (WSDataModelE) findServerObjectByName(IServerObjectRepositoryType.TYPE_DATAMODEL, name);
    }

    /**
     * this method is compatible with Util.getDataModel, but for Repository view
     * 
     * @param obj
     * @param datamodel
     * @param conceptName
     * @return
     */
    public static List<String> getDataModel(String datamodel, String conceptName) {
        List<String> systemDataModelValues = findAllDataModelNames();

        // filter the datamodel according to conceptName
        List<String> avaiList = new LinkedList<String>();
        avaiList.addAll(systemDataModelValues);
        if (datamodel != null) {
            avaiList.clear();
            avaiList.add(datamodel);
        } else if (conceptName != null && !conceptName.contains("*")) {//$NON-NLS-1$
            for (String data : systemDataModelValues) {
                try {
                    WSDataModelE dm = findDataModelByName(data);
                    if (dm != null) {
                        String schema = dm.getXsdSchema();
                        Pattern p = Pattern.compile("<xsd:element(.*?)name=\"" + conceptName + "\"");//$NON-NLS-1$//$NON-NLS-2$
                        if (!p.matcher(schema).find()) {
                            avaiList.remove(data);
                        }
                    }
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        if (avaiList.size() == 0)
            avaiList.addAll(systemDataModelValues);
        return avaiList;
    }

    private static List<String> findAllServerObjectNames(ERepositoryObjectType type) {
        List<IRepositoryViewObject> viewObjects = RepositoryResourceUtil.findAllViewObjects(type);
        List<String> names = new LinkedList<String>();
        if (viewObjects != null) {
            for (IRepositoryViewObject viewObj : viewObjects) {
                Item item = viewObj.getProperty().getItem();
                if (item instanceof MDMServerObjectItem) {
                    names.add(((MDMServerObjectItem) item).getMDMServerObject().getName());
                }
                // names[i]=viewObj.getLabel();
            }
        }
        return names;
    }

    private static MDMServerObject findServerObjectByName(ERepositoryObjectType type, String name) {
        List<IRepositoryViewObject> viewObjects = RepositoryResourceUtil.findAllViewObjects(type);
        if (viewObjects != null) {
            for (IRepositoryViewObject viewObj : viewObjects) {
                Item item = viewObj.getProperty().getItem();
                if (item instanceof MDMServerObjectItem) {
                    MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
                    if (serverObject.getName().equals(name)) {
                        return serverObject;
                    }
                }
            }
        }
        return null;
    }

    public static WSTransformerPluginV2SList getTransformerPluginV2SList(String language) {

        WSTransformerPluginV2SListItem[] items = new WSTransformerPluginV2SListItem[18];
        if (language.equalsIgnoreCase("en")) {
            items[0] = new WSTransformerPluginV2SListItem(
                    "csvparser", "Parses a text line with fields separated with a separator"); //$NON-NLS-1$//$NON-NLS-2$
            items[1] = new WSTransformerPluginV2SListItem("linereader", "Reads a text, line by line");//$NON-NLS-1$//$NON-NLS-2$
            items[2] = new WSTransformerPluginV2SListItem("project", "Projects and item to the Data Manager");//$NON-NLS-1$//$NON-NLS-2$
            items[3] = new WSTransformerPluginV2SListItem("codec", "This is a plugin used for encode or decode text");//$NON-NLS-1$//$NON-NLS-2$
            items[4] = new WSTransformerPluginV2SListItem("batchproject", "Batch projecting items to the Data Manager");//$NON-NLS-1$//$NON-NLS-2$
            items[5] = new WSTransformerPluginV2SListItem("callJob", "Executes a TIS Job on a text and returns the result");//$NON-NLS-1$//$NON-NLS-2$
            items[6] = new WSTransformerPluginV2SListItem("fixedlengthparser", "Parses a text line with fixed length fields");//$NON-NLS-1$//$NON-NLS-2$
            items[7] = new WSTransformerPluginV2SListItem("groovy", "This is a plugin which you can call the groovy script.");//$NON-NLS-1$//$NON-NLS-2$
            items[8] = new WSTransformerPluginV2SListItem("workflowtrigger", "Pass an item to a workflow engine");//$NON-NLS-1$//$NON-NLS-2$
            items[9] = new WSTransformerPluginV2SListItem("groupedlinesreader", "Reads a text, grouping several lines");//$NON-NLS-1$//$NON-NLS-2$
            items[10] = new WSTransformerPluginV2SListItem("xpath", "Executes an XPath on an XML document and returns the result");//$NON-NLS-1$//$NON-NLS-2$
            items[11] = new WSTransformerPluginV2SListItem("partialupdate", "Partial update of an existing item");//$NON-NLS-1$//$NON-NLS-2$
            items[12] = new WSTransformerPluginV2SListItem("xslt", "Transform an XML using an XSLT");//$NON-NLS-1$//$NON-NLS-2$
            items[13] = new WSTransformerPluginV2SListItem("crossreferencing", "Transform an XML using crossreferencing rules");//$NON-NLS-1$//$NON-NLS-2$
            items[14] = new WSTransformerPluginV2SListItem(
                    "replace", "Executes a regexp on a text, replaces with parameter value and returns the result");//$NON-NLS-1$//$NON-NLS-2$
            items[15] = new WSTransformerPluginV2SListItem("route", "Submits an item to the subscription engine");//$NON-NLS-1$//$NON-NLS-2$
            items[16] = new WSTransformerPluginV2SListItem("dumpandgo", "This is a plugin used for dump text and pass it. ");//$NON-NLS-1$//$NON-NLS-2$
            items[17] = new WSTransformerPluginV2SListItem("regexp", "Executes a regexp on a text and returns the result");//$NON-NLS-1$//$NON-NLS-2$
        }
        return new WSTransformerPluginV2SList(items);
    }

    public static java.util.List<String> getInputVariables(String jndiName) {
        List<String> variables = new ArrayList<String>();
        if (jndiName.equals("batchproject")) {
            variables.add("xml_instance");
            variables.add("file_path");
        }
        if (jndiName.equals("callJob")) {
            variables.add("text");
        }
        if (jndiName.equals("codec")) {
            variables.add("law_text");
        }
        if (jndiName.equals("crossreferencing")) {
            variables.add("xml");
        }
        if (jndiName.equals("csvparser")) {
            variables.add("csv_line");
        }
        if (jndiName.equals("dumpandgo")) {
            variables.add("in_text");
        }
        if (jndiName.equals("fixedlengthparser")) {
            variables.add("line");
        }
        if (jndiName.equals("groovy")) {
            variables.add("variable_input");
        }
        if (jndiName.equals("groupedlinesreader")) {
            variables.add("text_content");
        }
        if (jndiName.equals("linereader")) {
            variables.add("text_content");
        }
        if (jndiName.equals("partialupdate")) {
            variables.add("xml_instance");
            variables.add("item_primary_key");
            variables.add("data_model");
            variables.add("clear_cache");
        }
        if (jndiName.equals("project")) {
            variables.add("xml_instance");
            variables.add("item_primary_key");
            variables.add("data_model");
            variables.add("clear_cache");
        }
        if (jndiName.equals("regexp")) {
            variables.add("text");
        }
        if (jndiName.equals("replace")) {
            variables.add("text");
        }
        if (jndiName.equals("route")) {
            variables.add("item_primary_key");
        }
        if (jndiName.equals("workflowtrigger")) {
            variables.add("item_primary_key");
            variables.add("update_report");
            variables.add("data_model");
        }
        if (jndiName.equals("xpath")) {
            variables.add("xml");
        }
        if (jndiName.equals("xslt")) {
            variables.add("xml");
            variables.add("parameters");
        }
        return variables;
    }

    public static java.util.List<String> getOutputVariables(String jndiName) {
        List<String> variables = new ArrayList<String>();
        if (jndiName.equals("batchproject")) {
            variables.add("unavailable_content");
        }
        if (jndiName.equals("callJob")) {
            variables.add("result");
        }
        if (jndiName.equals("codec")) {
            variables.add("codec_text");
        }
        if (jndiName.equals("crossreferencing")) {
            variables.add("text");
        }
        if (jndiName.equals("csvparser")) {
            variables.add("xml");
        }
        if (jndiName.equals("dumpandgo")) {
            variables.add("out_text");
        }
        if (jndiName.equals("fixedlengthparser")) {
            variables.add("xml");
        }
        if (jndiName.equals("groovy")) {
            variables.add("script_output");
        }
        if (jndiName.equals("groupedlinesreader")) {
            variables.add("line");
        }
        if (jndiName.equals("linereader")) {
            variables.add("line");
        }
        if (jndiName.equals("partialupdate")) {
            variables.add("item_primary_key");
        }
        if (jndiName.equals("project")) {
            variables.add("item_primary_key");
        }
        if (jndiName.equals("regexp")) {
            variables.add("group");
        }
        if (jndiName.equals("replace")) {
            variables.add("replaced");
        }
        if (jndiName.equals("route")) {
            variables.add("item_primary_key");
        }
        if (jndiName.equals("workflowtrigger")) {
            variables.add("execution_result");
        }
        if (jndiName.equals("xpath")) {
            variables.add("text");
        }
        if (jndiName.equals("xslt")) {
            variables.add("text");
        }
        return variables;
    }
}
